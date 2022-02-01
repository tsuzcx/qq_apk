package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploadListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class UploadVideoTaskStep$1
  implements IVideoUploadListener<String>
{
  UploadVideoTaskStep$1(UploadVideoTaskStep paramUploadVideoTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    RIJUgcUtils.a("fail", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    Object localObject = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo).addValueSafe("errMsg", paramString).build();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC66", (String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFailed, errCode=");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errMsg=");
    ((StringBuilder)localObject).append(paramString);
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status = UgcVideo.STATUS_FAILED;
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep.d();
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep, false);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 * 100.0F / (float)paramLong2;
    if ((f1 > this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.videoProgress) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status != UgcVideo.STATUS_PAUSE))
    {
      paramLong1 = System.currentTimeMillis();
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.lastUploadSizeUpdateTime != 0L) && (paramLong1 - this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.lastUploadSizeUpdateTime > 500L))
      {
        float f2 = f1 / 100.0F;
        paramLong2 = (((float)this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.fileSize * f2) - this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.lastUploadSize) * 1000L / (paramLong1 - this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.lastUploadSizeUpdateTime);
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJUgcUtils.a(paramLong2));
        localStringBuilder.append("/S");
        ((UgcVideo)localObject).uploadSpeed = localStringBuilder.toString();
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
        ((UgcVideo)localObject).lastUploadSizeUpdateTime = paramLong1;
        ((UgcVideo)localObject).lastUploadSize = ((f2 * (float)((UgcVideo)localObject).fileSize));
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
      ((UgcVideo)localObject).videoProgress = ((int)f1);
      ((UgcVideo)localObject).status = UgcVideo.STATUS_UPLOADING;
      UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep).a(2, true, false, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("videoProgress = ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.videoProgress);
        ((StringBuilder)localObject).append(", speed=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.uploadSpeed);
        QLog.i("RIJUGC.UploadVideoTaskStep", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(@NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.videoUploadKey = paramString;
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
  }
  
  public void b(String paramString)
  {
    RIJUgcUtils.a("success", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    Object localObject = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo).addValueSafe("from", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.fromForReport)).addValueSafe("compress_time", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.compressTime)).addValueSafe("upload_time", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.uploadTotalCostTime)).addValueSafe("wait_time", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.userWaitingTotalCostTime));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.kdCommunityId)) {
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addValueSafe("kdcommunity_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.kdCommunityId);
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC67", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build());
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
    ((UgcVideo)localObject).url = paramString;
    ((UgcVideo)localObject).compressProgress = 100;
    ((UgcVideo)localObject).videoProgress = 100;
    if (UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep) != null) {
      UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep).a(2, true, true, null);
    }
    UploadVideoTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadVideoTaskStep.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadVideoTaskStep.1
 * JD-Core Version:    0.7.0.1
 */