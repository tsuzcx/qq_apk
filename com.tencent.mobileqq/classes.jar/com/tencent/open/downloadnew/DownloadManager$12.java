package com.tencent.open.downloadnew;

import bjtx;
import bjwq;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

public class DownloadManager$12
  implements Runnable
{
  public DownloadManager$12(bjwq parambjwq, String paramString) {}
  
  public void run()
  {
    try
    {
      this.this$0.a().pauseDownloadTask(this.a);
      return;
    }
    catch (Exception localException)
    {
      bjtx.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.12
 * JD-Core Version:    0.7.0.1
 */