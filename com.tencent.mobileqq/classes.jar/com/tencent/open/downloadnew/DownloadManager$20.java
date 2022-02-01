package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;

class DownloadManager$20
  implements Runnable
{
  DownloadManager$20(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.e);
      localStringBuilder.append(" begin getApkCode ......");
      LogUtility.c("DownloadManager_", localStringBuilder.toString());
      DownloadManager.a(this.this$0).a(this.a.e, this.a.b, DownloadManager.a(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.20
 * JD-Core Version:    0.7.0.1
 */