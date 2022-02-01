package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.Comparator;

class RIJArticleInfoRepo$13
  implements Comparator<AbsBaseArticleInfo>
{
  RIJArticleInfoRepo$13(RIJArticleInfoRepo paramRIJArticleInfoRepo) {}
  
  public int a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2)
  {
    if (paramAbsBaseArticleInfo1.mRecommendSeq == paramAbsBaseArticleInfo2.mRecommendSeq) {
      return 0;
    }
    if (paramAbsBaseArticleInfo1.mRecommendSeq > paramAbsBaseArticleInfo2.mRecommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo.13
 * JD-Core Version:    0.7.0.1
 */