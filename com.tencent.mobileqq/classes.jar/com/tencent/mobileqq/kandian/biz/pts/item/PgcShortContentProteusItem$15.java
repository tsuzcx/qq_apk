package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$15
  implements ViewBase.OnClickListener
{
  PgcShortContentProteusItem$15(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityPGCFeedsInfo.a) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo != null))
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityLongContentInfo.a.h;
        paramViewBase = paramViewBase.getNativeView();
        PgcShortContentProteusItem.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsItemPgcShortContentProteusItem, paramViewBase, str);
        paramViewBase = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
        if ((paramViewBase != null) && (paramViewBase.isPGCShortContent()))
        {
          paramViewBase.clickArea = 11;
          paramViewBase.clickJumpTarget = PGCShortContentUtils.a(str, "-1");
          RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase.getNativeView().getContext(), paramViewBase, (int)paramViewBase.mChannelID);
          return;
        }
      }
    }
    catch (NullPointerException paramViewBase)
    {
      QLog.e("PgcShortContentProteusItem", 1, paramViewBase.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.15
 * JD-Core Version:    0.7.0.1
 */