package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.Intent;
import anox;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;
import mqq.app.QQBroadcastReceiver;

public class EarlyDownloadReceiver
  extends QQBroadcastReceiver
{
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramAppRuntime.isLogin()) {
        ((anox)paramAppRuntime.getManager(77)).a(paramIntent);
      }
    }
    else
    {
      return;
    }
    paramAppRuntime = new Intent(paramIntent.getAction().replace("req.", "resp."));
    paramAppRuntime.putExtra("strResName", paramIntent.getStringExtra("strResName"));
    paramAppRuntime.putExtra("strPkgName", paramIntent.getStringExtra("strPkgName"));
    paramAppRuntime.putExtra("reqResult", false);
    paramAppRuntime.putExtra("resultReason", "app is not login.");
    paramContext.sendBroadcast(paramAppRuntime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */