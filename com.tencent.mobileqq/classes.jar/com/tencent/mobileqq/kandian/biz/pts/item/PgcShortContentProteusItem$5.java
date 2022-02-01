package com.tencent.mobileqq.kandian.biz.pts.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.biz.pts.util.PGCShortContentUtils;
import com.tencent.mobileqq.kandian.biz.pts.view.PgcSmallView;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleBasicInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.video.entity.PGCVideoInfo;
import com.tencent.qphone.base.util.QLog;

class PgcShortContentProteusItem$5
  implements View.OnClickListener
{
  PgcShortContentProteusItem$5(PgcShortContentProteusItem paramPgcShortContentProteusItem, IReadInJoyModel paramIReadInJoyModel, PgcSmallView paramPgcSmallView, Container paramContainer) {}
  
  public void onClick(View paramView)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a();
    paramView.clickArea = 11;
    QLog.d("PgcShortContentProteusItem", 1, "click short content small image");
    if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_Int == 3)
    {
      paramView.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo.h, "-1");
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPgcSmallView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityPGCVideoInfo.h, null);
    }
    else
    {
      paramView.clickJumpTarget = PGCShortContentUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityArticleBasicInfo.c, "-1");
      RIJJumpUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsViewPgcSmallView.getContext(), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a().mSocialFeedInfo.a.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityArticleBasicInfo.c, null);
    }
    RIJFrameworkReportManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewContainerContainer.getContext(), paramView, (int)paramView.mChannelID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.PgcShortContentProteusItem.5
 * JD-Core Version:    0.7.0.1
 */