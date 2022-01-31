package com.tencent.open.downloadnew.common;

import aktp;
import aktq;
import aktr;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  public final String a = PackageInstallReceiver.class.getName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c(this.a, "onReceive >> " + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      LogUtility.e(this.a, "onReceive intentPkgNameString == null ");
    }
    Object localObject;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
          ThreadManager.post(new aktp(this, paramContext, (String)localObject), 5, null, true);
        }
      }
      else
      {
        LogUtility.e(this.a, "onReceive packageName == null " + paramIntent.getDataString());
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        ThreadManager.post(new aktq(this, paramContext, (String)localObject), 5, null, true);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
    ThreadManager.post(new aktr(this, paramContext, (String)localObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */