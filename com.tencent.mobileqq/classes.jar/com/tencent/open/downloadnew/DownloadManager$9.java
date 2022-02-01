package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManager$9
  implements Runnable
{
  DownloadManager$9(DownloadManager paramDownloadManager, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    try
    {
      if (this.a)
      {
        this.this$0.f().deleteDownloadTask(this.b);
        return;
      }
      this.this$0.f().cancelDownloadTask(this.b);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.9
 * JD-Core Version:    0.7.0.1
 */