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
    Object localObject = this.this$0.g(this.a.d);
    if (localObject != null) {
      this.a.q = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
    }
    localObject = this.a;
    ((DownloadInfo)localObject).D = DownloadManagerV2.b(this.this$0, (DownloadInfo)localObject);
    if (this.a.D != 0)
    {
      LogUtility.b("DownloadManagerV2", HardCodeUtil.a(2131901601));
      this.a.a(-2);
      localObject = this.a;
      ((DownloadInfo)localObject).t = 100;
      DownloadManagerV2.a(this.this$0, (DownloadInfo)localObject, ((DownloadInfo)localObject).D, null);
      return;
    }
    LogUtility.a("DownloadManagerV2", HardCodeUtil.a(2131901620));
    this.a.a(4);
    localObject = this.a;
    ((DownloadInfo)localObject).t = 100;
    this.this$0.a((DownloadInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.10
 * JD-Core Version:    0.7.0.1
 */