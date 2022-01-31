package com.tencent.open.appstore.dl;

import bfgi;
import bfgx;
import bfhg;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$6
  implements Runnable
{
  public DownloadManagerV2$6(bfgi parambfgi, DownloadInfo paramDownloadInfo) {}
  
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
      bfhg.b("AppCenterReporter", "from:[onDownloadComplete]");
      bfgx.b(this.a);
      this.this$0.a(this.a, false);
      return;
    }
    catch (Exception localException)
    {
      bfhg.c("DownloadManagerV2", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.6
 * JD-Core Version:    0.7.0.1
 */