package com.tencent.open.downloadnew;

import bhzm;
import biby;
import bicg;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(biby parambiby, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bhzm.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      biby.a(this.this$0).a(this.a.e, this.a.b, biby.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bhzm.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */