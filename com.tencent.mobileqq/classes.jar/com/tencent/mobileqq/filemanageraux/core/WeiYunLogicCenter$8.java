package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IWeiyunSoListener;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;

class WeiYunLogicCenter$8
  implements IWeiyunSoListener
{
  WeiYunLogicCenter$8(WeiYunLogicCenter paramWeiYunLogicCenter) {}
  
  public void a(long paramLong, float paramFloat) {}
  
  public void a(String paramString)
  {
    WeiYunLogicCenter.b(this.a, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    WeiYunLogicCenter.a(this.a, true);
    WeiYunLogicCenter.b(this.a, false);
    ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).initTransmission(WeiYunLogicCenter.c(this.a).getApplication(), true);
    WeiyunTransmissionGlobal.getInstance().getUploadManager().loadLibFromPath(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.8
 * JD-Core Version:    0.7.0.1
 */