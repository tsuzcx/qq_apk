package com.tencent.open.downloadnew;

import amtj;
import bhzm;
import biby;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$6
  implements Runnable
{
  public DownloadManager$6(biby parambiby, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = this.this$0.a(this.a);
    if (this.a.j != 0)
    {
      bhzm.a("DownloadManager_", amtj.a(2131702619));
      this.a.e = -2;
      this.a.f = 100;
      this.this$0.a(this.a, this.a.j, null);
      return;
    }
    bhzm.a("DownloadManager_", amtj.a(2131702644));
    this.a.e = 4;
    this.a.f = 100;
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */