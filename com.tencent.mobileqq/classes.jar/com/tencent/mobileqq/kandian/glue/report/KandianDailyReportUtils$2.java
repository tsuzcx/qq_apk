package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.Comparator;

final class KandianDailyReportUtils$2
  implements Comparator<AbsBaseArticleInfo>
{
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils.2
 * JD-Core Version:    0.7.0.1
 */