package com.tencent.open.appstore.dl;

import amtj;
import bhyo;
import bhzm;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$10
  implements Runnable
{
  public DownloadManagerV2$10(bhyo parambhyo, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = bhyo.a(this.this$0, this.a);
    if (this.a.j != 0)
    {
      bhzm.b("DownloadManagerV2", amtj.a(2131702622));
      this.a.a(-2);
      this.a.f = 100;
      bhyo.a(this.this$0, this.a, this.a.j, null);
      return;
    }
    bhzm.a("DownloadManagerV2", amtj.a(2131702641));
    this.a.a(4);
    this.a.f = 100;
    this.this$0.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */