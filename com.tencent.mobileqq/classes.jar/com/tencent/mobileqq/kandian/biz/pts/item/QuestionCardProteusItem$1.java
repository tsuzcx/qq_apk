package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.pts.listeners.OnSuperTopicClickListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;

class QuestionCardProteusItem$1
  implements View.OnClickListener
{
  QuestionCardProteusItem$1(QuestionCardProteusItem paramQuestionCardProteusItem, IReadInJoyModel paramIReadInJoyModel, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    OnSuperTopicClickListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), this.jdField_a_of_type_AndroidContentContext);
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    String str1 = String.valueOf(RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), this.jdField_a_of_type_Int));
    String str2 = RIJTransMergeKanDianReport.a(paramView.mAlgorithmID, RIJFeedsType.a(paramView), 70, 0, 0, NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext), str1, null, paramView.innerUniqueID, null, paramView);
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramView.mFeedId);
    localStringBuilder.append("");
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str1, "0X8009355", "0X8009355", 0, 0, localStringBuilder.toString(), String.valueOf(paramView.businessId), String.valueOf(paramView.mAlgorithmID), str2, false);
    ReadinjoyReportUtils.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.QuestionCardProteusItem.1
 * JD-Core Version:    0.7.0.1
 */