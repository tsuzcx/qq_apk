package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  protected final String a = PackageInstallReceiver.class.getName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive >> ");
    ((StringBuilder)localObject).append(paramIntent.getAction());
    LogUtility.c(paramContext, ((StringBuilder)localObject).toString());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext))
    {
      LogUtility.e(this.a, "onReceive intentPkgNameString == null ");
      return;
    }
    localObject = paramContext.split(":");
    if (localObject.length == 2)
    {
      localObject = localObject[1];
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
      {
        ThreadManager.post(new PackageInstallReceiver.1(this, paramContext, (String)localObject), 5, null, true);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        ThreadManager.post(new PackageInstallReceiver.2(this, paramContext, (String)localObject), 5, null, true);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
        ThreadManager.post(new PackageInstallReceiver.3(this, paramContext, (String)localObject), 5, null, true);
      }
      return;
    }
    paramContext = this.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive packageName == null ");
    ((StringBuilder)localObject).append(paramIntent.getDataString());
    LogUtility.e(paramContext, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */