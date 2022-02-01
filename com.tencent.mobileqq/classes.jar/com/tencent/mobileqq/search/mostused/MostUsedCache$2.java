package com.tencent.mobileqq.search.mostused;

import java.util.Comparator;

final class MostUsedCache$2
  implements Comparator<MostUsedSearch>
{
  public int a(MostUsedSearch paramMostUsedSearch1, MostUsedSearch paramMostUsedSearch2)
  {
    return Long.signum(paramMostUsedSearch2.latestUsedTime - paramMostUsedSearch1.latestUsedTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.mostused.MostUsedCache.2
 * JD-Core Version:    0.7.0.1
 */