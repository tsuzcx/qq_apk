package com.tencent.mobileqq.data;

import java.util.Comparator;

public class CardProfile$CardProfileComparator
  implements Comparator<CardProfile>
{
  public int compare(CardProfile paramCardProfile1, CardProfile paramCardProfile2)
  {
    return paramCardProfile2.lTime - paramCardProfile1.lTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.CardProfile.CardProfileComparator
 * JD-Core Version:    0.7.0.1
 */