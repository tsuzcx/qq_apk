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
    Object localObject = this.this$0.h(this.a.d);
    if (localObject != null) {
      this.a.q = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
    }
    localObject = this.a;
    ((DownloadInfo)localObject).D = this.this$0.h((DownloadInfo)localObject);
    if (this.a.D != 0)
    {
      LogUtility.a("DownloadManager_", HardCodeUtil.a(2131901598));
      localObject = this.a;
      ((DownloadInfo)localObject).s = -2;
      ((DownloadInfo)localObject).t = 100;
      this.this$0.a((DownloadInfo)localObject, ((DownloadInfo)localObject).D, null);
      return;
    }
    LogUtility.a("DownloadManager_", HardCodeUtil.a(2131901623));
    localObject = this.a;
    ((DownloadInfo)localObject).s = 4;
    ((DownloadInfo)localObject).t = 100;
    this.this$0.b((DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.6
 * JD-Core Version:    0.7.0.1
 */