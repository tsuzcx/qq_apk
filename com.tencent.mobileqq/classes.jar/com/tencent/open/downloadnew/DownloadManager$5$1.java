package com.tencent.open.downloadnew;

import com.tencent.open.base.LogUtility;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManager$5$1
  implements Runnable
{
  DownloadManager$5$1(DownloadManager.5 param5, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnDownloadStateChanged,clientKey:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(",state:");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(",url:");
    ((StringBuilder)localObject1).append(this.c);
    LogUtility.b("DownloadManager_", ((StringBuilder)localObject1).toString());
    int i = DownloadManager.b(this.b);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onStateChanged url: +++++loacalState=");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" +++++downloadInfo=");
    ((StringBuilder)localObject1).append(this.f.a.i(this.c));
    LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
    DownloadInfo localDownloadInfo = this.f.a.a(this.c, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManager_", "OnDownloadSDKTaskStateChanged info == null");
      return;
    }
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      localObject1 = null;
      try
      {
        localObject2 = ((TMAssistantDownloadClient)localObject2).getDownloadTaskState(this.c);
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        LogUtility.c("DownloadManager_", "getDownloadTaskState>>>", localException);
      }
      if (localObject1 != null)
      {
        l2 = ((TMAssistantDownloadTaskInfo)localObject1).mReceiveDataLen;
        l1 = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        int j = (int)((float)l2 * 100.0F / (float)l1);
        localDownloadInfo.t = j;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("OnDownloadSDKTaskStateChanged info progress = ");
        ((StringBuilder)localObject1).append(j);
        LogUtility.a("DownloadManager_", ((StringBuilder)localObject1).toString());
        l3 = l1;
        break label299;
      }
    }
    long l1 = 0L;
    long l3 = l1;
    long l2 = l1;
    label299:
    if (i != -2)
    {
      if (i != 10)
      {
        if (i != 20)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4) {
                return;
              }
              this.f.a.a(localDownloadInfo, 0L, l3 - localDownloadInfo.y, "complete");
              this.f.a.b(localDownloadInfo);
              return;
            }
            this.f.a.a(localDownloadInfo, l2, l2 - localDownloadInfo.y, "pause");
            this.f.a.a(3, localDownloadInfo);
            return;
          }
          this.f.a.a(2, localDownloadInfo);
          return;
        }
        this.f.a.a(20, localDownloadInfo);
        return;
      }
      this.f.a.a(10, localDownloadInfo);
      return;
    }
    this.f.a.a(localDownloadInfo, l2, l3, this.d);
    this.f.a.a(-2, localDownloadInfo, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadManager.5.1
 * JD-Core Version:    0.7.0.1
 */