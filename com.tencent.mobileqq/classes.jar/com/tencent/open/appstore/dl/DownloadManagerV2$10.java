package com.tencent.open.appstore.dl;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManagerV2$10
  implements Runnable
{
  DownloadManagerV2$10(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = DownloadManagerV2.a(this.this$0, this.a);
    if (this.a.j != 0)
    {
      LogUtility.b("DownloadManagerV2", HardCodeUtil.a(2131703521));
      this.a.a(-2);
      this.a.f = 100;
      DownloadManagerV2.a(this.this$0, this.a, this.a.j, null);
      return;
    }
    LogUtility.a("DownloadManagerV2", HardCodeUtil.a(2131703540));
    this.a.a(4);
    this.a.f = 100;
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */