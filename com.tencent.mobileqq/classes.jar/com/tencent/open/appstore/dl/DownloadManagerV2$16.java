package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.UpdateManager;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManagerV2$16
  implements Runnable
{
  DownloadManagerV2$16(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.g(this.a.k);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.q = localTMAssistantDownloadTaskInfo.mSavePath;
        UpdateManager.b().a(this.a);
        return;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.16
 * JD-Core Version:    0.7.0.1
 */