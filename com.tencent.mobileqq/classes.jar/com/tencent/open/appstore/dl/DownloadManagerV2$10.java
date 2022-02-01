package com.tencent.open.appstore.dl;

import anvx;
import bjjq;
import bjko;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$10
  implements Runnable
{
  public DownloadManagerV2$10(bjjq parambjjq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = bjjq.a(this.this$0, this.a);
    if (this.a.j != 0)
    {
      bjko.b("DownloadManagerV2", anvx.a(2131702973));
      this.a.a(-2);
      this.a.f = 100;
      bjjq.a(this.this$0, this.a, this.a.j, null);
      return;
    }
    bjko.a("DownloadManagerV2", anvx.a(2131702992));
    this.a.a(4);
    this.a.f = 100;
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */