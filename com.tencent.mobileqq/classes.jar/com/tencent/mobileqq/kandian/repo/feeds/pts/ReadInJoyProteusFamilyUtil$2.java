package com.tencent.mobileqq.kandian.repo.feeds.pts;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

final class ReadInJoyProteusFamilyUtil$2
  implements Comparator<Pair<Long, AbsBaseArticleInfo>>
{
  public int a(Pair<Long, AbsBaseArticleInfo> paramPair1, Pair<Long, AbsBaseArticleInfo> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.2
 * JD-Core Version:    0.7.0.1
 */