package com.tencent.mobileqq.kandian.biz.pts.view.impl;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class NativeBiuCommentView$MoreSpan
  extends PressedSpan
{
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public NativeBiuCommentView$MoreSpan(NativeBiuCommentView paramNativeBiuCommentView, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    super(paramInt, 13421772, 860716207);
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void onClick(View paramView)
  {
    if (RIJItemViewTypeUtils.l(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0, false, 5, false);
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    if (RIJItemViewTypeUtils.h(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeBiuCommentView.getContext();
      if ((paramView instanceof Activity)) {
        RIJJumpUtils.b(paramView, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 6);
      }
      paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      RIJFrameworkReportManager.b(paramView, (int)paramView.mChannelID);
      return;
    }
    RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewImplNativeBiuCommentView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.impl.NativeBiuCommentView.MoreSpan
 * JD-Core Version:    0.7.0.1
 */