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
    this.this$0.g = ((ConcurrentHashMap)DownloadDBHelper.a().b());
    try
    {
      DownloadInfo localDownloadInfo = this.this$0.f("com.tencent.mobileqq");
      if ((localDownloadInfo != null) && (localDownloadInfo.o == 0))
      {
        String str = "";
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1;
        if (localDownloadInfo.j == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = this.this$0.h(localDownloadInfo.d);
          localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          if (localTMAssistantDownloadTaskInfo2 != null)
          {
            str = localTMAssistantDownloadTaskInfo2.mSavePath;
            localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
          }
        }
        else
        {
          localTMAssistantDownloadTaskInfo1 = this.this$0.h(localDownloadInfo.k);
          str = localDownloadInfo.q;
        }
        if (localTMAssistantDownloadTaskInfo1 == null)
        {
          this.this$0.g.remove(localDownloadInfo.c);
          DownloadDBHelper.a().b(localDownloadInfo.c);
          return;
        }
        if ((localTMAssistantDownloadTaskInfo1.mState == 4) && (AppUtil.f(str) <= CommonDataAdapter.a().h()))
        {
          this.this$0.g.remove(localDownloadInfo.c);
          DownloadDBHelper.a().b(localDownloadInfo.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.2
 * JD-Core Version:    0.7.0.1
 */