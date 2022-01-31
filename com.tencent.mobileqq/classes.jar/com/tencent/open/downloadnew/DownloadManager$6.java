package com.tencent.open.downloadnew;

import alpo;
import bfhg;
import bfkb;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManager$6
  implements Runnable
{
  public DownloadManager$6(bfkb parambfkb, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
    if (localTMAssistantDownloadTaskInfo != null) {
      this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
    }
    this.a.j = this.this$0.a(this.a);
    if (this.a.j != 0)
    {
      bfhg.a("DownloadManager_", alpo.a(2131703868));
      this.a.e = -2;
      this.a.f = 100;
      this.this$0.a(this.a, this.a.j, null);
      return;
    }
    bfhg.a("DownloadManager_", alpo.a(2131703893));
    this.a.e = 4;
    this.a.f = 100;
    this.this$0.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */