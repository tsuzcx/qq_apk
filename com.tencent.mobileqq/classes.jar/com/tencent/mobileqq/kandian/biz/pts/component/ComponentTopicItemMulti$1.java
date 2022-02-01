package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

class ComponentTopicItemMulti$1
  implements View.OnClickListener
{
  ComponentTopicItemMulti$1(ComponentTopicItemMulti paramComponentTopicItemMulti) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = ComponentTopicItemMulti.a(this.a);
    ReadInJoyUtils.a(this.a.getContext(), this.a.a.b);
    paramView = ReadinjoyReportUtils.b(ComponentTopicItemMulti.a(this.a));
    String str1 = RIJTransMergeKanDianReport.a(ComponentTopicItemMulti.a(this.a).mAlgorithmID, RIJFeedsType.a(ComponentTopicItemMulti.a(this.a)), ComponentTopicItemMulti.a(this.a), 0, 0, NetworkUtil.isWifiConnected(this.a.getContext()), ComponentTopicItemMulti.a(this.a).mSubscribeID, null, ComponentTopicItemMulti.a(this.a).innerUniqueID, null, ComponentTopicItemMulti.a(this.a));
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str2 = ComponentTopicItemMulti.a(this.a).mSubscribeID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ComponentTopicItemMulti.a(this.a).mFeedId);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, paramView, paramView, 0, 0, localStringBuilder.toString(), String.valueOf(this.a.a.a), String.valueOf(ComponentTopicItemMulti.a(this.a).mAlgorithmID), str1, false);
    RIJFrameworkReportManager.c(ComponentTopicItemMulti.a(this.a), ComponentTopicItemMulti.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTopicItemMulti.1
 * JD-Core Version:    0.7.0.1
 */