package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManager$14
  implements Runnable
{
  DownloadManager$14(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.c(this.a);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.q = localTMAssistantDownloadTaskInfo.mSavePath;
        this.this$0.f(this.a);
        this.this$0.a(4, this.a);
      }
      StaticAnalyz.a("300", this.a.h, this.a.c, this.a.F);
      this.this$0.d(this.a);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.14
 * JD-Core Version:    0.7.0.1
 */