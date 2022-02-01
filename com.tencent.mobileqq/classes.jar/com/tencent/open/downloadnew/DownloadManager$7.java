package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

class DownloadManager$7
  implements Runnable
{
  DownloadManager$7(DownloadManager paramDownloadManager, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        LogUtility.c("DownloadManager_", "onDownloadError taskInfo != null！info.writeCodeState = " + this.a.j);
        this.a.l = localTMAssistantDownloadTaskInfo.mSavePath;
        this.a.jdField_c_of_type_Long = localTMAssistantDownloadTaskInfo.mTotalDataLen;
        this.this$0.e(this.a);
        if (this.a.j != 0) {
          break label184;
        }
        this.this$0.a(4, this.a);
        if (!this.a.jdField_c_of_type_JavaLangString.equals("1101070898"))
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
        label184:
        LogUtility.c("DownloadManager_", "downloadSDKClient>>>", localException);
      }
    }
    StaticAnalyz.a("300", this.a.h, this.a.jdField_c_of_type_JavaLangString, this.a.o);
    if (this.a.a) {
      this.this$0.c(this.a);
    }
    return;
    LogUtility.c("DownloadManager_", "onDownloadError taskInfo == null");
    DownloadManager.a(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.7
 * JD-Core Version:    0.7.0.1
 */