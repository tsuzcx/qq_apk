package com.tencent.open.downloadnew;

import bcds;
import bcgo;
import bcgw;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bcgo parambcgo, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bcds.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bcgo.a(this.this$0).a(this.a.e, this.a.b, bcgo.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bcds.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */