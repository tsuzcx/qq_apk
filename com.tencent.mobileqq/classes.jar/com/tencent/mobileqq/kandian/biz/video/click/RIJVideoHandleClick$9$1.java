package com.tencent.mobileqq.kandian.biz.video.click;

import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;

class RIJVideoHandleClick$9$1
  implements Runnable
{
  RIJVideoHandleClick$9$1(RIJVideoHandleClick.9 param9, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void run()
  {
    String str = new VideoR5.Builder(null, null, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mVideoVid, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.innerUniqueID).a((int)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mChannelID).N((int)RIJVideoHandleClick.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick$9.a).a().a()).R(0).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8008E28", "0X8008E28", 0, 0, "", "", "", str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick.9.1
 * JD-Core Version:    0.7.0.1
 */