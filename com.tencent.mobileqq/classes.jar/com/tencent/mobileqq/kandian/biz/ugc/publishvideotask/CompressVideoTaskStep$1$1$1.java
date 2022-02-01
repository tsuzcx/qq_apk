package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.video.compress.VideoMediaInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;

class CompressVideoTaskStep$1$1$1
  implements Runnable
{
  CompressVideoTaskStep$1$1$1(CompressVideoTaskStep.1.1 param1, String paramString) {}
  
  public void run()
  {
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int != 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int != 1)) {
      bool = false;
    } else {
      bool = true;
    }
    Object localObject;
    if (bool)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressPath = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.fileMd5 = this.jdField_a_of_type_JavaLangString;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
      VideoMediaInfo localVideoMediaInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo;
      long l2 = 0L;
      if (localVideoMediaInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo.d;
      } else {
        l1 = 0L;
      }
      ((UgcVideo)localObject).fileSize = l1;
      if (!CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressProgress = 100;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressTime = 0L;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 0) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressTime = (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.startCompressTime);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
      long l1 = l2;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo != null) {
        l1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoMediaInfo.b;
      }
      ((UgcVideo)localObject).bitrate = l1;
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status = UgcVideo.STATUS_PAUSE;
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status = UgcVideo.STATUS_FAILED;
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
        ((UgcVideo)localObject).retryTime += 1;
      }
      CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressProgress = 0;
      localObject = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo).addValueSafe("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressTime)).addValueSafe("error_code", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_Int)).build();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC65", (String)localObject);
    }
    CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    if (CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep) != null) {
      CompressVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep).a(1, bool, true, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep$1.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskCompressVideoTaskStep.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep.1.1.1
 * JD-Core Version:    0.7.0.1
 */