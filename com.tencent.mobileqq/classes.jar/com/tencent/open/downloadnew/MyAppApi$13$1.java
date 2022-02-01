package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

class MyAppApi$13$1
  implements Runnable
{
  MyAppApi$13$1(MyAppApi.13 param13, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.c.a.a();
    for (;;)
    {
      try
      {
        Object localObject = this.c.h.a(this.c.b, this.c.c);
        DownloadManager.b().f((DownloadInfo)localObject);
        if ((this.a != null) && (this.a.length != 0))
        {
          localObject = new StringBuilder();
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = this.c.b;
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append("&identity=");
          ((StringBuilder)localObject).append(util.buf_to_string(this.a));
          localTMAssistantCallYYBParamStruct.uin = ((StringBuilder)localObject).toString();
          this.c.h.m = this.c.d;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OpenSDK startToAppDetail param SNGAppId=");
        ((StringBuilder)localObject).append(this.c.b.SNGAppId);
        ((StringBuilder)localObject).append(" apkId=");
        ((StringBuilder)localObject).append(this.c.b.taskApkId);
        ((StringBuilder)localObject).append(" taskAppId=");
        ((StringBuilder)localObject).append(this.c.b.taskAppId);
        ((StringBuilder)localObject).append(" packageName=");
        ((StringBuilder)localObject).append(this.c.b.taskPackageName);
        ((StringBuilder)localObject).append(" version=");
        ((StringBuilder)localObject).append(this.c.b.taskVersion);
        ((StringBuilder)localObject).append(" uin=");
        ((StringBuilder)localObject).append(this.c.b.uin);
        ((StringBuilder)localObject).append(" via=");
        ((StringBuilder)localObject).append(this.c.b.via);
        LogUtility.a("State_Log", ((StringBuilder)localObject).toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (this.c.h.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.c.h.d()).startToDownloadTaskList(this.c.e, this.c.b, this.c.f, this.c.g);
          return;
        }
        int i = this.c.c.getInt(DownloadConstants.k);
        int j = this.c.h.e(this.c.c);
        boolean bool1 = this.c.f;
        boolean bool2 = this.c.g;
        if (i == 3)
        {
          bool1 = false;
          bool2 = false;
          ((TMAssistantCallYYB_V2)this.c.h.d()).startToDownloadTaskList(this.c.e, this.c.b, bool1, bool2, j);
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
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.13.1
 * JD-Core Version:    0.7.0.1
 */