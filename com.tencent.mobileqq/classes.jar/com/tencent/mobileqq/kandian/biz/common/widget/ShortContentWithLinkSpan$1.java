package com.tencent.mobileqq.kandian.biz.common.widget;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.text.PressedSpan;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

final class ShortContentWithLinkSpan$1
  extends PressedSpan
{
  ShortContentWithLinkSpan$1(int paramInt1, int paramInt2, int paramInt3, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(@NonNull View paramView)
  {
    RIJJumpUtils.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, null);
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.isPGCShortContent()))
    {
      localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      localAbsBaseArticleInfo.clickArea = 11;
      localAbsBaseArticleInfo.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_JavaLangString, "-1");
      paramView = paramView.getContext();
      localAbsBaseArticleInfo = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
      RIJFrameworkReportManager.a(paramView, localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ShortContentWithLinkSpan.1
 * JD-Core Version:    0.7.0.1
 */