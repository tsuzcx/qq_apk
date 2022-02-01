package com.tencent.open.downloadnew;

import bjtx;
import bjwq;
import bjxw;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$15
  implements Runnable
{
  public DownloadManager$15(bjwq parambjwq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.i);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        bjxw.a().a(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      bjtx.c("DownloadManager_", "downloadSDKClient>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.15
 * JD-Core Version:    0.7.0.1
 */