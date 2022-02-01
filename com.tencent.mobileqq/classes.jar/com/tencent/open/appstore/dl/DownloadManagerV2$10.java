package com.tencent.open.appstore.dl;

import anzj;
import bjsz;
import bjtx;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$10
  implements Runnable
{
  public DownloadManagerV2$10(bjsz parambjsz, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = bjsz.a(this.this$0, this.a);
    if (this.a.j != 0)
    {
      bjtx.b("DownloadManagerV2", anzj.a(2131702387));
      this.a.a(-2);
      this.a.f = 100;
      bjsz.a(this.this$0, this.a, this.a.j, null);
      return;
    }
    bjtx.a("DownloadManagerV2", anzj.a(2131702406));
    this.a.a(4);
    this.a.f = 100;
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */