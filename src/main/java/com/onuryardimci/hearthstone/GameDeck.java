package com.onuryardimci.hearthstone;

import java.util.*;

/**
 * Created by onury.
 */
public class GameDeck {

    public final static int REQUIRED_CARD_COUNT_TO_BE_INITIALIZED = 20;

    private final LinkedList<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public GameDeck(List<Card> cards) {
        if (cards == null) {
            throw new IllegalArgumentException("Cards should be given.");
        }
        if (cards.size() != REQUIRED_CARD_COUNT_TO_BE_INITIALIZED) {
            throw new IllegalArgumentException(String.format("%s of cards should be provided.", REQUIRED_CARD_COUNT_TO_BE_INITIALIZED));
        }
        this.cards = shuffle(cards);
    }

    private LinkedList<Card> shuffle(List<Card> cards) {
        LinkedList<Card> clonedList = new LinkedList<>(cards);
        Collections.shuffle(clonedList);
        return clonedList;
    }

    public List<Card> drawCards(int numberOfCards) {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < numberOfCards; i++) {
            Optional<Card> drawnCard = drawCard();
            if (drawnCard.isPresent()) {
                drawnCards.add(drawnCard.get());
            }
        }
        return drawnCards;
    }

    public Optional<Card> drawCard() {
        if (cards.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(cards.pop());
    }
}
