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
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

class ComponentTopicItemSingle$1
  implements View.OnClickListener
{
  ComponentTopicItemSingle$1(ComponentTopicItemSingle paramComponentTopicItemSingle, TopicRecommendFeedsInfo.TopicRecommendInfo paramTopicRecommendInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle.a.a.a();
    com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils.a = paramView;
    ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.b);
    String str1 = RIJTransMergeKanDianReport.a(paramView.mAlgorithmID, RIJFeedsType.a(paramView), this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle.a.a.c(), 0, 0, NetworkUtil.isWifiConnected(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle.getContext()), paramView.mSubscribeID, null, paramView.innerUniqueID, null, paramView);
    String str2 = ReadinjoyReportUtils.b(paramView.mChannelID);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str3 = paramView.mSubscribeID;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.mFeedId);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str3, str2, str2, 0, 0, localStringBuilder.toString(), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTopicRecommendFeedsInfo$TopicRecommendInfo.a), String.valueOf(paramView.mAlgorithmID), str1, false);
    RIJFrameworkReportManager.c(paramView, this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentTopicItemSingle.a.a.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentTopicItemSingle.1
 * JD-Core Version:    0.7.0.1
 */