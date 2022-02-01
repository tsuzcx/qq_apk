package com.tencent.mobileqq.search.ftsmsg;

import java.util.Comparator;

class FTSMessageSearchEngine$4
  implements Comparator<FTSMessageSearchEngine.FTSSearchResultItem>
{
  FTSMessageSearchEngine$4(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramFTSSearchResultItem1.a + paramFTSSearchResultItem2.a);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */