package com.tencent.mobileqq.kandian.repo.feeds.pts;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.util.Pair;
import java.util.Comparator;

class ReadInJoyProteusFamilyUtil$1
  implements Comparator<Pair<Long, Pair<View, AbsBaseArticleInfo>>>
{
  ReadInJoyProteusFamilyUtil$1(ReadInJoyProteusFamilyUtil paramReadInJoyProteusFamilyUtil) {}
  
  public int a(Pair<Long, Pair<View, AbsBaseArticleInfo>> paramPair1, Pair<Long, Pair<View, AbsBaseArticleInfo>> paramPair2)
  {
    return ((Long)paramPair2.first).compareTo((Long)paramPair1.first);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.pts.ReadInJoyProteusFamilyUtil.1
 * JD-Core Version:    0.7.0.1
 */