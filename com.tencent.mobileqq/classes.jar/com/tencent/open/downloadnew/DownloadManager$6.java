package com.tencent.open.downloadnew;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManager$6
  implements Runnable
{
  DownloadManager$6(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = this.this$0.a(this.a);
    if (this.a.j != 0)
    {
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703518));
      this.a.e = -2;
      this.a.f = 100;
      this.this$0.a(this.a, this.a.j, null);
      return;
    }
    LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703543));
    this.a.e = 4;
    this.a.f = 100;
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */