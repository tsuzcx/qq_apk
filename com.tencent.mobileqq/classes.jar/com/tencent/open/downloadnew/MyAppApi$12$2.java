package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;

class MyAppApi$12$2
  implements Runnable
{
  MyAppApi$12$2(MyAppApi.12 param12) {}
  
  public void run()
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    Object localObject = this.a.h.a(this.a.b, this.a.c);
    DownloadManager.b().f((DownloadInfo)localObject);
    for (;;)
    {
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToAppDetail param SNGAppId=");
        ((StringBuilder)localObject).append(this.a.b.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(this.a.b.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(this.a.b.taskAppId);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(this.a.b.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(this.a.b.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(this.a.b.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(this.a.b.via);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.a.h.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.a.h.d()).startToAppDetail(this.a.e, this.a.b, this.a.f, this.a.g);
          return;
        }
        int i = this.a.c.getInt(DownloadConstants.k);
        int j = this.a.h.e(this.a.c);
        boolean bool1 = this.a.f;
        boolean bool2 = this.a.g;
        if (i == 3)
        {
          bool1 = false;
          bool2 = false;
          ((TMAssistantCallYYB_V2)this.a.h.d()).startToAppDetail(this.a.e, this.a.b, bool1, bool2, j);
          return;
        }
      }
      catch (Exception localException)
      {
        LogUtility.b("MyAppApi", "startToAppDetail err", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.12.2
 * JD-Core Version:    0.7.0.1
 */