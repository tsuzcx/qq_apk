package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManager$15
  implements Runnable
{
  DownloadManager$15(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.i);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        UpdateManager.a().a(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.15
 * JD-Core Version:    0.7.0.1
 */