package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleTopicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

final class FastWebProteusReportUtils$1
  implements Runnable
{
  FastWebProteusReportUtils$1(FastWebArticleInfo paramFastWebArticleInfo) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((FastWebArticleInfo)localObject1).b != null) && (this.a.b.size() > 0))
    {
      localObject1 = this.a.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ArticleTopicInfo)((Iterator)localObject1).next();
        RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.a.e);
        localReportR5Builder.addStringNotThrow("puin", localStringBuilder.toString());
        localReportR5Builder.addStringNotThrow("rowkey", this.a.j);
        localReportR5Builder.addStringNotThrow("article_id", this.a.o);
        localReportR5Builder.addStringNotThrow("tag_from_page", "3");
        localReportR5Builder.addStringNotThrow("tag_rk", ((ArticleTopicInfo)localObject2).c);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B9BB", "0X800B9BB", 0, 0, "", "", "", localReportR5Builder.build(), false);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[topicTagReport] 0X800B9BB, r5 = ");
        ((StringBuilder)localObject2).append(localReportR5Builder.build());
        QLog.i("FastWebProteusReportUtils", 1, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    QLog.i("FastWebProteusReportUtils", 1, "[topicTagReport] topic list is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebProteusReportUtils.1
 * JD-Core Version:    0.7.0.1
 */