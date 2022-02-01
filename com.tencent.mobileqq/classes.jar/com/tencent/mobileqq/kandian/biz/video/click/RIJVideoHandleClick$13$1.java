package com.tencent.mobileqq.kandian.biz.video.click;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.share.VideoShareListener;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

class RIJVideoHandleClick$13$1
  extends VideoShareListener
{
  RIJVideoHandleClick$13$1(RIJVideoHandleClick.13 param13, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    if (paramBoolean3)
    {
      if (paramBoolean4) {
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a().c();
      } else {
        RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a().a(2);
      }
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a().a(ReportConstants.VideoEndType.SLIDE_LEAVE);
    }
    if (!paramBoolean1)
    {
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().f(false);
    }
    else if (RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().b())
    {
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a().c();
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().f(false);
    }
    if ((paramBoolean2) && (RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a() != null)) {
      RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$13.a).a().a().a(2, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo, 0L, 0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.13.1
 * JD-Core Version:    0.7.0.1
 */