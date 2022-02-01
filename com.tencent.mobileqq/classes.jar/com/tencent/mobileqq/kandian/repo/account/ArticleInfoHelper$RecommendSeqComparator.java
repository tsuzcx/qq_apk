package com.tencent.mobileqq.kandian.repo.account;

import java.util.Comparator;

public class ArticleInfoHelper$RecommendSeqComparator
  implements Comparator<Long>
{
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.longValue() > paramLong2.longValue()) {
      return -1;
    }
    if (paramLong1.longValue() < paramLong2.longValue()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.ArticleInfoHelper.RecommendSeqComparator
 * JD-Core Version:    0.7.0.1
 */