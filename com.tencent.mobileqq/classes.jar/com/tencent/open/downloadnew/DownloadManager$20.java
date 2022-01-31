package com.tencent.open.downloadnew;

import bfhg;
import bfkb;
import bfkj;

public class DownloadManager$20
  implements Runnable
{
  public DownloadManager$20(bfkb parambfkb, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      bfhg.c("DownloadManager_", this.a.e + " begin getApkCode ......");
      bfkb.a(this.this$0).a(this.a.e, this.a.b, bfkb.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      bfhg.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */