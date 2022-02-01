package com.tencent.open.downloadnew;

import bjko;
import bjlu;
import bjna;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$14
  implements Runnable
{
  public DownloadManager$14(bjna parambjna, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        this.this$0.e(this.a);
        this.this$0.a(4, this.a);
      }
      bjlu.a("300", this.a.h, this.a.c, this.a.o);
      this.this$0.c(this.a);
      return;
    }
    catch (Exception localException)
    {
      bjko.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.14
 * JD-Core Version:    0.7.0.1
 */