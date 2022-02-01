package com.tencent.mobileqq.search.mostused;

import java.util.Comparator;

final class MostUsedCache$1
  implements Comparator<MostUsedCache.MostUsedSearchItemModel>
{
  public int a(MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel1, MostUsedCache.MostUsedSearchItemModel paramMostUsedSearchItemModel2)
  {
    int j = Long.signum(paramMostUsedSearchItemModel2.c - paramMostUsedSearchItemModel1.c);
    int i = j;
    if (j == 0) {
      i = Long.signum(paramMostUsedSearchItemModel2.a.timeStamp - paramMostUsedSearchItemModel1.a.timeStamp);
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedCache.1
 * JD-Core Version:    0.7.0.1
 */