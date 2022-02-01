package com.tencent.open.downloadnew;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManager$2
  implements Runnable
{
  DownloadManager$2(DownloadManager paramDownloadManager) {}
  
  public void run()
  {
    this.this$0.a = ((ConcurrentHashMap)DownloadDBHelper.a().a());
    try
    {
      DownloadInfo localDownloadInfo = this.this$0.b("com.tencent.mobileqq");
      if ((localDownloadInfo != null) && (localDownloadInfo.jdField_c_of_type_Int == 0))
      {
        String str = "";
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1;
        if (localDownloadInfo.a == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = this.this$0.a(localDownloadInfo.d);
          localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            str = localTMAssistantDownloadTaskInfo2.mSavePath;
            localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          }
        }
        else
        {
          localTMAssistantDownloadTaskInfo1 = this.this$0.a(localDownloadInfo.i);
          str = localDownloadInfo.l;
        }
        if (localTMAssistantDownloadTaskInfo1 == null)
        {
          this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
          DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          return;
        }
        if ((localTMAssistantDownloadTaskInfo1.mState == 4) && (AppUtil.c(str) <= CommonDataAdapter.a().a()))
        {
          this.this$0.a.remove(localDownloadInfo.jdField_c_of_type_JavaLangString);
          DownloadDBHelper.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManager_", "speical clear>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.2
 * JD-Core Version:    0.7.0.1
 */