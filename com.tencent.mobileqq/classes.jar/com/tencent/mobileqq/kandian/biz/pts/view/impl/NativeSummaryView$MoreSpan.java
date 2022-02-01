package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class NativeSummaryView$MoreSpan
  extends PressedSpan
{
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public NativeSummaryView$MoreSpan(NativeSummaryView paramNativeSummaryView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super(-15504151, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if ((RIJItemViewTypeUtils.h(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeSummaryView.getContext() instanceof Activity)))
    {
      RIJJumpUtils.b((Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    int i;
    if (RIJItemViewTypeUtils.l(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      i = 2;
    } else {
      i = 3;
    }
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeSummaryView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeSummaryView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */