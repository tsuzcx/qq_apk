package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class PackProteusItem$1
  implements View.OnClickListener
{
  PackProteusItem$1(PackProteusItem paramPackProteusItem, AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if ((paramView != null) && (paramView.mTopicRecommendFeedsInfo != null) && (this.a.mTopicRecommendFeedsInfo.g != null) && (!this.a.mTopicRecommendFeedsInfo.g.isEmpty()))
    {
      String str1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.mTopicRecommendFeedsInfo.g.get(0)).c;
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str2 = RIJTransMergeKanDianReport.a("1", this.a);
      if (ReadinjoyReportUtils.d(this.a.mChannelID)) {
        paramView = "0X800935C";
      } else {
        paramView = "0X8007BA3";
      }
      long l1 = this.a.mFeedId;
      long l2 = this.a.mArticleID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.mStrategyId);
      PublicAccountReportUtils.a(null, "", paramView, paramView, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str2, false);
      paramView = new ActivityURIRequest(this.b, "/pubaccount/browser");
      paramView.extra().putString("url", str1);
      QRoute.startUri(paramView, null);
      return;
    }
    QLog.d("PackProteusItem", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PackProteusItem.1
 * JD-Core Version:    0.7.0.1
 */