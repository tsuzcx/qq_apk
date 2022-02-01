package com.tencent.mobileqq.search;

import java.util.Comparator;

final class SearchTask$3
  implements Comparator<ISearchable>
{
  public int a(ISearchable paramISearchable1, ISearchable paramISearchable2)
  {
    long l1 = paramISearchable1.c();
    long l2 = paramISearchable2.c();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask.3
 * JD-Core Version:    0.7.0.1
 */