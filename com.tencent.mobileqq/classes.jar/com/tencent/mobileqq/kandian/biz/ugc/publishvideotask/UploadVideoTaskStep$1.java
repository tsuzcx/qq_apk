package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploadListener;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class UploadVideoTaskStep$1
  implements IVideoUploadListener<String>
{
  UploadVideoTaskStep$1(UploadVideoTaskStep paramUploadVideoTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    RIJUgcUtils.a("fail", this.a);
    PublicAccountReportUtils.a("0X800AC66", RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.a).addValueSafe("errMsg", paramString).build());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailed, errCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, localStringBuilder.toString());
    this.a.status = UgcVideo.STATUS_FAILED;
    UploadVideoTaskStep.a(this.b).d(this.a);
    this.b.g();
    UploadVideoTaskStep.a(this.b, false);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 * 100.0F / (float)paramLong2;
    if ((f1 > this.a.videoProgress) && (this.a.status != UgcVideo.STATUS_PAUSE))
    {
      paramLong1 = System.currentTimeMillis();
      if ((this.a.lastUploadSizeUpdateTime != 0L) && (paramLong1 - this.a.lastUploadSizeUpdateTime > 500L))
      {
        float f2 = f1 / 100.0F;
        paramLong2 = (((float)this.a.fileSize * f2) - this.a.lastUploadSize) * 1000L / (paramLong1 - this.a.lastUploadSizeUpdateTime);
        localObject = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(RIJUgcUtils.a(paramLong2));
        localStringBuilder.append("/S");
        ((UgcVideo)localObject).uploadSpeed = localStringBuilder.toString();
        localObject = this.a;
        ((UgcVideo)localObject).lastUploadSizeUpdateTime = paramLong1;
        ((UgcVideo)localObject).lastUploadSize = ((f2 * (float)((UgcVideo)localObject).fileSize));
      }
      Object localObject = this.a;
      ((UgcVideo)localObject).videoProgress = ((int)f1);
      ((UgcVideo)localObject).status = UgcVideo.STATUS_UPLOADING;
      UploadVideoTaskStep.b(this.b).a(2, true, false, null);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("videoProgress = ");
        ((StringBuilder)localObject).append(this.a.videoProgress);
        ((StringBuilder)localObject).append(", speed=");
        ((StringBuilder)localObject).append(this.a.uploadSpeed);
        QLog.i("RIJUGC.UploadVideoTaskStep", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(@NotNull String paramString)
  {
    this.a.videoUploadKey = paramString;
    UploadVideoTaskStep.a(this.b).d(this.a);
  }
  
  public void b(String paramString)
  {
    RIJUgcUtils.a("success", this.a);
    Object localObject = RIJUgcUtils.a(RIJQQAppInterfaceUtil.a(), this.a).addValueSafe("from", Integer.valueOf(this.a.fromForReport)).addValueSafe("compress_time", Long.valueOf(this.a.compressTime)).addValueSafe("upload_time", Long.valueOf(this.a.uploadTotalCostTime)).addValueSafe("wait_time", Long.valueOf(this.a.userWaitingTotalCostTime));
    if (!TextUtils.isEmpty(this.a.kdCommunityId)) {
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).addValueSafe("kdcommunity_id", this.a.kdCommunityId);
    }
    PublicAccountReportUtils.a("0X800AC67", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).build());
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.a;
    ((UgcVideo)localObject).url = paramString;
    ((UgcVideo)localObject).compressProgress = 100;
    ((UgcVideo)localObject).videoProgress = 100;
    if (UploadVideoTaskStep.b(this.b) != null) {
      UploadVideoTaskStep.b(this.b).a(2, true, true, null);
    }
    UploadVideoTaskStep.a(this.b).d(this.a);
    this.b.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadVideoTaskStep.1
 * JD-Core Version:    0.7.0.1
 */