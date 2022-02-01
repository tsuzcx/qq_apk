package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunUploadDownloadService;
import com.tencent.mobileqq.weiyun.api.download.IDownloadStatusListener;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.upload.UploadManager;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;

public class WeiyunTask
{
  private final String a;
  private final Object b;
  private final boolean c;
  private final IDownloadStatusListener d;
  private final UploadManager.IUploadStatusListener e;
  private String f;
  
  public WeiyunTask(String paramString, Object paramObject, boolean paramBoolean, UploadManager.IUploadStatusListener paramIUploadStatusListener, IDownloadStatusListener paramIDownloadStatusListener)
  {
    this.a = paramString;
    this.b = paramObject;
    this.c = paramBoolean;
    this.e = paramIUploadStatusListener;
    this.d = paramIDownloadStatusListener;
  }
  
  public void a()
  {
    if (this.c)
    {
      WeiyunTransmissionGlobal.getInstance().getUploadManager().removeJob(this.a);
      return;
    }
    ((IWeiyunUploadDownloadService)QRoute.api(IWeiyunUploadDownloadService.class)).removeJob(this.a);
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiyunTask
 * JD-Core Version:    0.7.0.1
 */