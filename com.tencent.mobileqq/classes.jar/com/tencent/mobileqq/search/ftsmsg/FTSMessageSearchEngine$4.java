package com.tencent.mobileqq.search.ftsmsg;

import java.util.Comparator;

class FTSMessageSearchEngine$4
  implements Comparator<FTSMessageSearchEngine.FTSSearchResultItem>
{
  FTSMessageSearchEngine$4(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.d - paramFTSSearchResultItem2.d);
      i = j;
      if (j == 0) {
        i = Long.signum(-paramFTSSearchResultItem1.e + paramFTSSearchResultItem2.e);
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.4
 * JD-Core Version:    0.7.0.1
 */