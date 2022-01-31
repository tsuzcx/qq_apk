package com.tencent.open.downloadnew;

import bfhg;
import bfkb;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$12
  implements Runnable
{
  public DownloadManager$12(bfkb parambfkb, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a().pauseDownloadTask(this.a);
      return;
    }
    catch (Exception localException)
    {
      bfhg.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.12
 * JD-Core Version:    0.7.0.1
 */