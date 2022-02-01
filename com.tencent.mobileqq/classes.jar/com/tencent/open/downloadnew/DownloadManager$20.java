package com.tencent.open.downloadnew;

import bjko;
import bjna;
import bjni;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bjna parambjna, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bjko.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bjna.a(this.this$0).a(this.a.e, this.a.b, bjna.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bjko.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */