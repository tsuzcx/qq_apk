package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManagerV2$8
  implements Runnable
{
  DownloadManagerV2$8(DownloadManagerV2 paramDownloadManagerV2, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      DownloadManagerV2.e(this.this$0).cancelDownloadTask(this.a);
      DownloadManagerV2.a(this.this$0, this.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.8
 * JD-Core Version:    0.7.0.1
 */