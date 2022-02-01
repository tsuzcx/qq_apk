package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
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
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((paramView != null) && (paramView.mTopicRecommendFeedsInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a != null) && (!this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.isEmpty()))
    {
      String str1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mTopicRecommendFeedsInfo.a.get(0)).b;
      if (TextUtils.isEmpty(str1)) {
        return;
      }
      String str2 = RIJTransMergeKanDianReport.a("1", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (ReadinjoyReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID)) {
        paramView = "0X800935C";
      } else {
        paramView = "0X8007BA3";
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      long l1 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId;
      long l2 = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mStrategyId);
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", paramView, paramView, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), str2, false);
      paramView = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/browser");
      paramView.extra().putString("url", str1);
      QRoute.startUri(paramView, null);
      return;
    }
    QLog.d("PackProteusItem", 1, "articleInfo is null or topicRecommendInfo is null or topicRecommendInfoList is empty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PackProteusItem.1
 * JD-Core Version:    0.7.0.1
 */