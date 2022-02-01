package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManagerV2$9
  implements Runnable
{
  DownloadManagerV2$9(DownloadManagerV2 paramDownloadManagerV2, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.g(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[doGeneraWriteCodeTask] taskInfo=");
        localStringBuilder.append(localTMAssistantDownloadTaskInfo);
        localStringBuilder.append(",writeCodeState=");
        localStringBuilder.append(this.a.D);
        LogUtility.b("DownloadManagerV2", localStringBuilder.toString());
        this.a.q = localTMAssistantDownloadTaskInfo.mSavePath;
        this.a.E = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.this$0.e(this.a);
        if ((this.a.D != 0) && (!TextUtils.isEmpty(this.a.e)))
        {
          LogUtility.b("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo == null");
          DownloadManagerV2.c(this.this$0, this.a);
          return;
        }
        this.this$0.a(4, this.a);
        if (!"1101070898".equals(this.a.c))
        {
          long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
          this.this$0.a(this.a, l);
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "[doGeneraWriteCodeTask]>>>", localException);
    }
    if (this.a.w) {
      this.this$0.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.9
 * JD-Core Version:    0.7.0.1
 */