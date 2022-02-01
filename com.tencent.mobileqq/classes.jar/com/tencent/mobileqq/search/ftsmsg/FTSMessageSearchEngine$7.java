package com.tencent.mobileqq.search.ftsmsg;

import java.util.Comparator;

class FTSMessageSearchEngine$7
  implements Comparator<FTSMessageSearchEngine.FTSSearchResultItem>
{
  FTSMessageSearchEngine$7(FTSMessageSearchEngine paramFTSMessageSearchEngine) {}
  
  public int a(FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem1, FTSMessageSearchEngine.FTSSearchResultItem paramFTSSearchResultItem2)
  {
    int j = Long.signum(paramFTSSearchResultItem1.jdField_a_of_type_Int - paramFTSSearchResultItem2.jdField_a_of_type_Int);
    int i = j;
    if (j == 0)
    {
      j = Long.signum(paramFTSSearchResultItem1.b - paramFTSSearchResultItem2.b);
      i = j;
      if (j == 0)
      {
        j = Long.signum(paramFTSSearchResultItem1.c - paramFTSSearchResultItem2.c);
        i = j;
        if (j == 0) {
          i = Long.signum(-paramFTSSearchResultItem1.jdField_a_of_type_Long + paramFTSSearchResultItem2.jdField_a_of_type_Long);
        }
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.7
 * JD-Core Version:    0.7.0.1
 */