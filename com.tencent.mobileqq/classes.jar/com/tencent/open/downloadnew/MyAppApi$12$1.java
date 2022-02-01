package com.tencent.open.downloadnew;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import oicq.wlogin_sdk.tools.util;

class MyAppApi$12$1
  implements Runnable
{
  MyAppApi$12$1(MyAppApi.12 param12, byte[] paramArrayOfByte, String paramString) {}
  
  public void run()
  {
    this.c.a.a();
    for (;;)
    {
      try
      {
        ThreadManager.excute(new MyAppApi.12.1.1(this, this.c.h.a(this.c.b, this.c.c)), 32, null, true);
        if ((this.a != null) && (this.a.length != 0))
        {
          localStringBuilder = new StringBuilder();
          TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = this.c.b;
          localStringBuilder.append(this.b);
          localStringBuilder.append("&identity=");
          localStringBuilder.append(util.buf_to_string(this.a));
          localTMAssistantCallYYBParamStruct.uin = localStringBuilder.toString();
          this.c.h.m = this.c.d;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("OpenSDK startToAppDetail param SNGAppId=");
        localStringBuilder.append(this.c.b.SNGAppId);
        localStringBuilder.append(" apkId=");
        localStringBuilder.append(this.c.b.taskApkId);
        localStringBuilder.append(" taskAppId=");
        localStringBuilder.append(this.c.b.taskAppId);
        localStringBuilder.append(" packageName=");
        localStringBuilder.append(this.c.b.taskPackageName);
        localStringBuilder.append(" version=");
        localStringBuilder.append(this.c.b.taskVersion);
        localStringBuilder.append(" uin=");
        localStringBuilder.append(this.c.b.uin);
        localStringBuilder.append(" via=");
        localStringBuilder.append(this.c.b.via);
        LogUtility.a("MyAppApi", localStringBuilder.toString());
        LogUtility.c("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
        if (this.c.h.a() <= 2)
        {
          ((TMAssistantCallYYB_V1)this.c.h.d()).startToAppDetail(this.c.e, this.c.b, this.c.f, this.c.g);
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
          ((TMAssistantCallYYB_V2)this.c.h.d()).startToAppDetail(this.c.e, this.c.b, bool1, bool2, j);
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
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.12.1
 * JD-Core Version:    0.7.0.1
 */