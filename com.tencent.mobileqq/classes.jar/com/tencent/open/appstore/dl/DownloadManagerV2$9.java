package com.tencent.open.appstore.dl;

import android.text.TextUtils;
import bhyo;
import bhzm;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;

public class DownloadManagerV2$9
  implements Runnable
{
  public DownloadManagerV2$9(bhyo parambhyo, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    try
    {
      TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(this.a.d);
      if (localTMAssistantDownloadTaskInfo != null)
      {
        bhzm.b("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo=" + localTMAssistantDownloadTaskInfo + ",writeCodeState=" + this.a.j);
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
        bhzm.c("DownloadManagerV2", "[doGeneraWriteCodeTask]>>>", localException);
      }
    }
    if (this.a.a) {
      this.this$0.a(this.a, false);
    }
    return;
    bhzm.b("DownloadManagerV2", "[doGeneraWriteCodeTask] taskInfo == null");
    bhyo.b(this.this$0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.9
 * JD-Core Version:    0.7.0.1
 */