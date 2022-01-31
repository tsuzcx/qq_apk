package com.tencent.open.downloadnew;

import bdii;
import bdle;
import bdlm;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bdle parambdle, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bdii.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bdle.a(this.this$0).a(this.a.e, this.a.b, bdle.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bdii.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */