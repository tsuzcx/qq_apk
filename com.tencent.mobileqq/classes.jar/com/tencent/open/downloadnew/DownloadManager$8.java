package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManager$8
  implements Runnable
{
  DownloadManager$8(DownloadManager paramDownloadManager, String paramString, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      this.this$0.f().cancelDownloadTask(this.a);
      this.this$0.g.remove(this.b.c);
      DownloadDBHelper.a().b(this.b.c);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.8
 * JD-Core Version:    0.7.0.1
 */