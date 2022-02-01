package com.tencent.open.appstore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class InstallStateReceiver
  extends BroadcastReceiver
{
  protected final String a = "InstallStateReceiver";
  
  private void a(String paramString, int paramInt)
  {
    Object localObject2 = DownloadManagerV2.a().b(paramString, 4);
    Object localObject1 = localObject2;
    if (((List)localObject2).size() == 0) {
      localObject1 = DownloadManagerV2.a().a(paramString, 4);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(">notifyInstalled ");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(", info:");
    ((StringBuilder)localObject2).append(localObject1);
    LogUtility.c("InstallStateReceiver", ((StringBuilder)localObject2).toString());
    paramString = ((List)localObject1).iterator();
    while (paramString.hasNext())
    {
      localObject1 = (DownloadInfo)paramString.next();
      if ((localObject1 != null) && (((DownloadInfo)localObject1).a() == 4))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(">notifyInstalled ");
        ((StringBuilder)localObject2).append(localObject1);
        LogUtility.c("InstallStateReceiver", ((StringBuilder)localObject2).toString());
        if (1 == paramInt)
        {
          DownloadManagerV2.a().f((DownloadInfo)localObject1);
        }
        else if (2 == paramInt)
        {
          DownloadManagerV2.a().e((DownloadInfo)localObject1);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(">notifyInstalled bad notifyType:");
          ((StringBuilder)localObject1).append(paramInt);
          LogUtility.e("InstallStateReceiver", ((StringBuilder)localObject1).toString());
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("[onReceive] action=");
    paramContext.append(paramIntent.getAction());
    LogUtility.c("InstallStateReceiver", paramContext.toString());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext))
    {
      LogUtility.e("InstallStateReceiver", "[onReceive] intentPkgNameString == null ");
      return;
    }
    Object localObject = paramContext.split(":");
    if (localObject.length == 2)
    {
      localObject = localObject[1];
      String str = paramIntent.getAction();
      if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED"))
      {
        ThreadManager.excute(new InstallStateReceiver.1(this, paramContext, (String)localObject), 16, null, true);
        return;
      }
      if (TextUtils.equals(str, "android.intent.action.PACKAGE_REPLACED"))
      {
        AppCenterReporter.a((String)localObject, true);
        ThreadManager.excute(new InstallStateReceiver.2(this, paramContext, (String)localObject), 16, null, true);
        return;
      }
      if (TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED")) {
        ThreadManager.excute(new InstallStateReceiver.3(this, paramIntent, paramContext, (String)localObject), 16, null, true);
      }
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("[onReceive] packageName == null ");
    paramContext.append(paramIntent.getDataString());
    LogUtility.e("InstallStateReceiver", paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver
 * JD-Core Version:    0.7.0.1
 */