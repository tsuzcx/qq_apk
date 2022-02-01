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
    Object localObject = this.this$0.a(this.a.d);
    if (localObject != null) {
      this.a.l = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
    }
    localObject = this.a;
    ((DownloadInfo)localObject).j = this.this$0.a((DownloadInfo)localObject);
    if (this.a.j != 0)
    {
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703649));
      localObject = this.a;
      ((DownloadInfo)localObject).e = -2;
      ((DownloadInfo)localObject).f = 100;
      this.this$0.a((DownloadInfo)localObject, ((DownloadInfo)localObject).j, null);
      return;
    }
    LogUtility.a("DownloadManager_", HardCodeUtil.a(2131703674));
    localObject = this.a;
    ((DownloadInfo)localObject).e = 4;
    ((DownloadInfo)localObject).f = 100;
    this.this$0.b((DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */