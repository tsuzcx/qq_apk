package com.tencent.mobileqq.search.ftsmsg;

import java.util.Comparator;

class FTSMessageSearchEngine$7
  implements Comparator<FTSMessageSearchEngine.FTSSearchResultItem>
{
  FTSMessageSearchEngine$7(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramFTSSearchResultItem1.d - paramFTSSearchResultItem2.d);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramFTSSearchResultItem1.e + paramFTSSearchResultItem2.e);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.7
 * JD-Core Version:    0.7.0.1
 */