package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class OnUserCommentClickListener
  implements ViewBase.OnClickListener
{
  Context jdField_a_of_type_AndroidContentContext;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  
  public OnUserCommentClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (RIJItemViewTypeUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 1, false, 0, 1);
    }
    else if (RIJFeedsType.T(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo))
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009A77", null);
    }
    else
    {
      RIJJumpUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0, false, 0, 1);
    }
    GalleryReportedUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    OnSocialOperationListener.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, "0X8009442", "0X8009445");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnUserCommentClickListener
 * JD-Core Version:    0.7.0.1
 */