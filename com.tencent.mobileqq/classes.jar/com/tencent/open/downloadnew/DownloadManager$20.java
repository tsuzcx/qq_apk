package com.tencent.open.downloadnew;

import bisy;
import bivr;
import bivz;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bivr parambivr, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bisy.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bivr.a(this.this$0).a(this.a.e, this.a.b, bivr.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bisy.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */