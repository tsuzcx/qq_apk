package com.tencent.mobileqq.search;

import java.util.Comparator;

final class SearchTask$4
  implements Comparator<ISearchable>
{
  public int a(ISearchable paramISearchable1, ISearchable paramISearchable2)
  {
    long l1 = paramISearchable1.o();
    long l2 = paramISearchable2.o();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    l1 = paramISearchable1.n();
    l2 = paramISearchable2.n();
    if (l1 < l2) {
      return 1;
    }
    if (l1 > l2) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.SearchTask.4
 * JD-Core Version:    0.7.0.1
 */