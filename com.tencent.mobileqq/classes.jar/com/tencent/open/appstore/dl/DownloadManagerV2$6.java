package com.tencent.open.appstore.dl;

import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManagerV2$6
  implements Runnable
{
  DownloadManagerV2$6(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        this.this$0.c(this.a);
        this.this$0.a(4, this.a);
      }
      LogUtility.b("AppCenterReporter", "from:[onDownloadComplete]");
      AppCenterReporter.b(this.a);
      this.this$0.a(this.a, false);
      return;
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.6
 * JD-Core Version:    0.7.0.1
 */