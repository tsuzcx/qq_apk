package com.tencent.open.appstore.dl;

import ajyc;
import bdgv;
import bdht;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$10
  implements Runnable
{
  public DownloadManagerV2$10(bdgv parambdgv, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = bdgv.a(this.this$0, this.a);
    if (this.a.j != 0)
    {
      bdht.b("DownloadManagerV2", ajyc.a(2131703488));
      this.a.a(-2);
      this.a.f = 100;
      bdgv.a(this.this$0, this.a, this.a.j, null);
      return;
    }
    bdht.a("DownloadManagerV2", ajyc.a(2131703507));
    this.a.a(4);
    this.a.f = 100;
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */