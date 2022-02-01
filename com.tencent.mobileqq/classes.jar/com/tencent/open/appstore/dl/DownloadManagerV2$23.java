package com.tencent.open.appstore.dl;

import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmdownloader.TMAssistantDownloadClient;

class DownloadManagerV2$23
  implements Runnable
{
  DownloadManagerV2$23(DownloadManagerV2 paramDownloadManagerV2, TMAssistantDownloadClient paramTMAssistantDownloadClient, int paramInt1, String paramString1, int paramInt2, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnDownloadStateChanged,clientKey:");
    ((StringBuilder)localObject1).append(this.a);
    ((StringBuilder)localObject1).append(",state:");
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(",url:");
    ((StringBuilder)localObject1).append(this.c);
    LogUtility.b("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    int i = DownloadManagerV2.b(this.b);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onStateChanged url: +++++loacalState=");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" +++++downloadInfo=");
    ((StringBuilder)localObject1).append(this.this$0.b(this.c));
    LogUtility.a("DownloadManagerV2", ((StringBuilder)localObject1).toString());
    DownloadInfo localDownloadInfo = DownloadManagerV2.a(this.this$0, this.c, i);
    if (localDownloadInfo == null)
    {
      LogUtility.d("DownloadManagerV2", "OnDownloadSDKTaskStateChanged info == null");
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
        LogUtility.c("DownloadManagerV2", "getDownloadTaskState>>>", localException);
      }
      if (localObject1 != null)
      {
        long l1 = ((TMAssistantDownloadTaskInfo)localObject1).mReceiveDataLen;
        long l2 = ((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen;
        int j = (int)((float)l1 * 100.0F / (float)l2);
        localDownloadInfo.t = j;
        localDownloadInfo.q = ((TMAssistantDownloadTaskInfo)localObject1).mSavePath;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OnDownloadSDKTaskStateChanged info progress = ");
        localStringBuilder.append(j);
        localStringBuilder.append(", ");
        localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject1).mReceiveDataLen);
        localStringBuilder.append("|");
        localStringBuilder.append(((TMAssistantDownloadTaskInfo)localObject1).mTotalDataLen);
        LogUtility.a("DownloadManagerV2", localStringBuilder.toString());
      }
    }
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
              this.this$0.a(localDownloadInfo);
              return;
            }
            this.this$0.a(3, localDownloadInfo);
            return;
          }
          this.this$0.a(2, localDownloadInfo);
          return;
        }
        this.this$0.a(20, localDownloadInfo);
        return;
      }
      this.this$0.a(10, localDownloadInfo);
      return;
    }
    DownloadManagerV2.a(this.this$0, -2, localDownloadInfo, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.dl.DownloadManagerV2.23
 * JD-Core Version:    0.7.0.1
 */