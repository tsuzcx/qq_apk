package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQBroadcastReceiver;

public class EarlyDownloadReceiver
  extends QQBroadcastReceiver
{
  public void onReceive(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    if (MobileQQ.sProcessId == 1)
    {
      if (paramAppRuntime.isLogin())
      {
        ((IEarlyDownloadService)paramAppRuntime.getRuntimeService(IEarlyDownloadService.class, "")).handleBroadcastReq(paramIntent);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDownloadReceiver
 * JD-Core Version:    0.7.0.1
 */