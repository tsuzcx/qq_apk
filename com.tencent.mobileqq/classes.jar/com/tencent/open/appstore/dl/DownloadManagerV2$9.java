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
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        LogUtility.b("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo=" + localTMAssistantDownloadTaskInfo + ",writeCodeState=" + this.a.j);
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        this.a.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.this$0.c(this.a);
        if ((this.a.j != 0) && (!TextUtils.isEmpty(this.a.e))) {
          break label182;
        }
        this.this$0.a(4, this.a);
        if (!"1101070898".equals(this.a.jdField_c_of_type_JavaLangString))
        {
          long l = localTMAssistantDownloadTaskInfo.mTotalDataLen;
          this.this$0.a(this.a, l);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label182:
        LogUtility.c("DownloadManagerV2", "[doGeneraWriteCodeTask]>>>", localException);
      }
    }
    if (this.a.a) {
      this.this$0.a(this.a, false);
    }
    return;
    LogUtility.b("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo == null");
    DownloadManagerV2.b(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.9
 * JD-Core Version:    0.7.0.1
 */