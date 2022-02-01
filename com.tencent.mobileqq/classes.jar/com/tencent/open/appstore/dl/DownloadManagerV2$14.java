package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManagerV2$14
  implements Runnable
{
  DownloadManagerV2$14(DownloadManagerV2 paramDownloadManagerV2, String paramString) {}
  
  public void run()
  {
    try
    {
      DownloadManagerV2.a(this.this$0).pauseDownloadTask(this.a);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.14
 * JD-Core Version:    0.7.0.1
 */