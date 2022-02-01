package com.tencent.open.downloadnew;

import bjtx;
import bjwq;
import bjwy;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bjwq parambjwq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bjtx.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bjwq.a(this.this$0).a(this.a.e, this.a.b, bjwq.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bjtx.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */