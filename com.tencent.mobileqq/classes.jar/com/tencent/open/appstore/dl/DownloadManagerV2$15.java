package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManagerV2$15
  implements Runnable
{
  DownloadManagerV2$15(DownloadManagerV2 paramDownloadManagerV2, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.a)
      {
        DownloadManagerV2.e(this.this$0).deleteDownloadTask(this.b);
        return;
      }
      DownloadManagerV2.e(this.this$0).cancelDownloadTask(this.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.15
 * JD-Core Version:    0.7.0.1
 */