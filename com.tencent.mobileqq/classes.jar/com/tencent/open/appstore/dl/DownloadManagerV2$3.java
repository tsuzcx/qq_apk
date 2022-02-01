package com.tencent.open.appstore.dl;

import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appstore.db.DownloadInfoDB;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class DownloadManagerV2$3
  implements Runnable
{
  DownloadManagerV2$3(DownloadManagerV2 paramDownloadManagerV2) {}
  
  public void run()
  {
    DownloadManagerV2.a(this.this$0, DownloadInfoDB.a().a());
    Object localObject1;
    Object localObject2;
    if (DownloadManagerV2.a(this.this$0) != null)
    {
      localObject1 = DownloadManagerV2.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        if (((DownloadInfo)localObject2).a() == 2) {
          ((DownloadInfo)localObject2).a(3);
        }
      }
    }
    try
    {
      DownloadInfo localDownloadInfo = this.this$0.c("com.tencent.mobileqq");
      if (localDownloadInfo != null)
      {
        if (localDownloadInfo.c != 0) {
          return;
        }
        localObject1 = "";
        if (localDownloadInfo.a == 0)
        {
          TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = this.this$0.a(localDownloadInfo.d);
          localObject2 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            localObject1 = localTMAssistantDownloadTaskInfo.mSavePath;
            localObject2 = localTMAssistantDownloadTaskInfo;
          }
        }
        else
        {
          localObject2 = this.this$0.a(localDownloadInfo.i);
          localObject1 = localDownloadInfo.l;
        }
        if (localObject2 == null)
        {
          DownloadManagerV2.a(this.this$0, localDownloadInfo);
          return;
        }
        if ((((TMAssistantDownloadTaskInfo)localObject2).mState == 4) && (AppUtil.c((String)localObject1) <= CommonDataAdapter.a().a())) {
          DownloadManagerV2.a(this.this$0, localDownloadInfo);
        }
      }
      else {}
    }
    catch (Exception localException)
    {
      LogUtility.c("DownloadManagerV2", "speical clear>>>", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.3
 * JD-Core Version:    0.7.0.1
 */