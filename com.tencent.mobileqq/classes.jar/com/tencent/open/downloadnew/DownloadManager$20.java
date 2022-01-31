package com.tencent.open.downloadnew;

import bflp;
import bfok;
import bfos;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bfok parambfok, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bflp.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bfok.a(this.this$0).a(this.a.e, this.a.b, bfok.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bflp.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */