package com.tencent.open.appstore.dl;

import biip;
import biry;
import bisa;
import bisy;
import biub;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadManagerV2$3
  implements Runnable
{
  public DownloadManagerV2$3(bisa parambisa) {}
  
  public void run()
  {
    bisa.a(this.this$0, biry.a().a());
    Object localObject1;
    Object localObject2;
    if (bisa.a(this.this$0) != null)
    {
      localObject1 = bisa.a(this.this$0).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (DownloadInfo)((Iterator)localObject1).next();
        if (((DownloadInfo)localObject2).a() == 2) {
          ((DownloadInfo)localObject2).a(3);
        }
      }
    }
    DownloadInfo localDownloadInfo;
    String str;
    for (;;)
    {
      try
      {
        localDownloadInfo = this.this$0.c("com.tencent.mobileqq");
        if (localDownloadInfo == null) {
          return;
        }
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
          if (localObject2 != null) {
            break;
          }
          bisa.a(this.this$0, localDownloadInfo);
          return;
        }
      }
      catch (Exception localException)
      {
        bisy.c("DownloadManagerV2", "speical clear>>>", localException);
        return;
      }
      localObject2 = this.this$0.a(localDownloadInfo.i);
      str = localDownloadInfo.l;
    }
    if ((((TMAssistantDownloadTaskInfo)localObject2).mState == 4) && (biub.c(str) <= biip.a().a())) {
      bisa.a(this.this$0, localDownloadInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.3
 * JD-Core Version:    0.7.0.1
 */