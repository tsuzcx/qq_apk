package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class OnTopicRecommendHeaderClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  
  public OnTopicRecommendHeaderClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("business url is ");
      ((StringBuilder)localObject1).append(this.a.businessUrl);
      QLog.d("OnTopicRecommendHeaderClickListener", 2, ((StringBuilder)localObject1).toString());
    }
    if ((this.a.mTopicRecommendFeedsInfo != null) && (this.a.mTopicRecommendFeedsInfo.g != null) && (this.a.mTopicRecommendFeedsInfo.g.size() > 0)) {
      localObject1 = (TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.mTopicRecommendFeedsInfo.g.get(0);
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.a;
    if ((localObject2 != null) && (localObject1 != null))
    {
      localObject2 = ((AbsBaseArticleInfo)localObject2).businessUrl;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return;
      }
      Object localObject3 = new ActivityURIRequest(this.b, "/pubaccount/browser");
      ((ActivityURIRequest)localObject3).extra().putString("url", (String)localObject2);
      QRoute.startUri((URIRequest)localObject3, null);
      localObject2 = RIJFeedsType.k(this.a);
      localObject3 = this.a.innerUniqueID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((TopicRecommendFeedsInfo.TopicRecommendInfo)localObject1).a);
      localStringBuilder.append("");
      localObject1 = RIJTransMergeKanDianReport.a((String)localObject3, localStringBuilder.toString(), this.a);
      PublicAccountReportUtils.a(null, (String)localObject2, "0X8008A63", "0X8008A63", 0, 0, Long.toString(this.a.mFeedId), Long.toString(this.a.mArticleID), Long.toString(this.a.mStrategyId), (String)localObject1, false);
      localObject1 = this.a;
      RIJFrameworkReportManager.b((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
      localObject1 = this.a;
      RIJFrameworkReportManager.c((AbsBaseArticleInfo)localObject1, (int)((AbsBaseArticleInfo)localObject1).mChannelID);
      return;
    }
    QLog.d("OnTopicRecommendHeaderClickListener", 1, new Object[] { "articleInfo is null or topicRecommendInfo is null, articleInfo: ", this.a, " topicRecommendInfo: ", localObject1 });
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    int i = RIJBaseItemViewType.c(this.a);
    if (((this.b instanceof Activity)) && (i != 79)) {
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnTopicRecommendHeaderClickListener
 * JD-Core Version:    0.7.0.1
 */