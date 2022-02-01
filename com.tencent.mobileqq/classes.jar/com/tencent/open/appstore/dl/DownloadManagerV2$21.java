package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloaderGetCodeClient;

class DownloadManagerV2$21
  implements Runnable
{
  DownloadManagerV2$21(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getApkCodeAsync]");
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(" begin getApkCode ......");
      LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
      DownloadManagerV2.g(this.this$0).a(this.a.b, this.a.e, this.a.n, DownloadManagerV2.f(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "[getApkCodeAsync] >>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.21
 * JD-Core Version:    0.7.0.1
 */