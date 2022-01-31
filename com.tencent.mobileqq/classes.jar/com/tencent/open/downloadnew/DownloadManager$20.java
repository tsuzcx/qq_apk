package com.tencent.open.downloadnew;

import bdht;
import bdkp;
import bdkx;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bdkp parambdkp, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bdht.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bdkp.a(this.this$0).a(this.a.e, this.a.b, bdkp.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bdht.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */