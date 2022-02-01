package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo;
import com.tencent.mobileqq.kandian.biz.ugc.video.VideoMetaInfo.Builder;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class NormalVideoDeliverController$2
  implements FileUploadController.FileUploadListener
{
  NormalVideoDeliverController$2(NormalVideoDeliverController paramNormalVideoDeliverController) {}
  
  public void a()
  {
    NormalVideoDeliverController.a(this.a, NetConnInfoCenter.getServerTimeMillis());
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt != 0)
    {
      switch (paramInt)
      {
      default: 
        return;
      case 1005: 
        NormalVideoDeliverController.b(this.a, 12);
        return;
      case 1004: 
        NormalVideoDeliverController.b(this.a, 7);
        NormalVideoDeliverController.c(this.a, 1004);
        PublicAccountReportUtils.a(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 1, String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a)), String.valueOf(NormalVideoDeliverController.d(this.a) - NormalVideoDeliverController.e(this.a)), String.valueOf(NormalVideoDeliverController.f(this.a) - NormalVideoDeliverController.g(this.a)));
        return;
      case 1003: 
        NormalVideoDeliverController.b(this.a, 7);
        return;
      case 1002: 
        NormalVideoDeliverController.b(this.a, 5);
        return;
      }
      NormalVideoDeliverController.b(this.a, 6);
      return;
    }
    NormalVideoDeliverController.a(this.a, 4);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mVideoTransProcessorHandler mVideoMd5=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", mVideoUuid=");
      ((StringBuilder)localObject).append(paramString3);
      ((StringBuilder)localObject).append(", mVideoUrl=");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("VideoDeliverController", 2, ((StringBuilder)localObject).toString());
    }
    NormalVideoDeliverController.b(this.a, NetConnInfoCenter.getServerTimeMillis());
    PublicAccountReportUtils.a(NormalVideoDeliverController.a(this.a), "", "0X8008181", "0X8008181", 0, 0, String.valueOf(NormalVideoDeliverController.b(this.a)), String.valueOf(NormalVideoDeliverController.c(this.a)), String.valueOf(NormalVideoDeliverController.d(this.a) - NormalVideoDeliverController.e(this.a)), String.valueOf(NormalVideoDeliverController.f(this.a) - NormalVideoDeliverController.g(this.a)));
    Object localObject = this.a;
    NormalVideoDeliverController.a((NormalVideoDeliverController)localObject, 0, NormalVideoDeliverController.h((NormalVideoDeliverController)localObject), NormalVideoDeliverController.i(this.a), paramString1, paramString2, paramString3);
    paramString1 = VideoMetaInfo.a().a(NormalVideoDeliverController.h(this.a)).b(NormalVideoDeliverController.i(this.a)).d(paramString2).c(paramString1).e(paramString3).a(NormalVideoDeliverController.c(this.a)).b(NormalVideoDeliverController.j(this.a)).a();
    NormalVideoDeliverController.a(this.a, paramString1);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    NormalVideoDeliverController.a(this.a, (float)paramLong1 * 100.0F / (float)paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.NormalVideoDeliverController.2
 * JD-Core Version:    0.7.0.1
 */