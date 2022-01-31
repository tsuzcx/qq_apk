package com.tencent.open.wadl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.open.downloadnew.common.AppNotificationManager;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlProxyServiceCallBackInterface;
import cooperation.wadl.ipc.WadlProxyServiceUtil;
import cooperation.wadl.ipc.WadlProxyServiceWrap;
import cooperation.wadl.ipc.WadlResult;
import java.util.Iterator;
import java.util.List;

public class WadlJSBridgePackageInstallReceiver
  extends BroadcastReceiver
{
  protected final String a = "WadlJSBridgePackageInstallReceiver";
  private String b = "";
  
  public WadlJSBridgePackageInstallReceiver(String paramString)
  {
    WLog.b("WadlJSBridgePackageInstallReceiver", "create package install broadcast receiver processName=" + paramString);
    this.b = paramString;
  }
  
  private void a(WadlResult paramWadlResult)
  {
    Iterator localIterator = WadlProxyServiceUtil.a().iterator();
    while (localIterator.hasNext()) {
      ((WadlProxyServiceCallBackInterface)localIterator.next()).b(paramWadlResult);
    }
  }
  
  private boolean a(Context paramContext, String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(this.b)) {
        this.b = GameCenterUtils.a(paramContext);
      }
      return TextUtils.equals(this.b, paramString);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        WLog.a("WadlJSBridgePackageInstallReceiver", "getProcessName exception=" + paramContext);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getDataString();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).contains(":"))) {
      WLog.a("WadlJSBridgePackageInstallReceiver", "##@onReceive intentPkgNameString=" + (String)localObject);
    }
    do
    {
      String str;
      do
      {
        return;
        localObject = ((String)localObject).split(":");
        if (localObject.length < 2)
        {
          WLog.b("WadlJSBridgePackageInstallReceiver", "##@onReceive packageName == null " + paramIntent.getDataString());
          return;
        }
        localObject = localObject[1];
        str = WadlJsBridgeUtil.a((String)localObject);
        if (!a(paramContext, "com.tencent.mobileqq")) {
          break;
        }
      } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
      WLog.b("WadlJSBridgePackageInstallReceiver", "isQQProcess:YES");
      try
      {
        AppNotificationManager.a().b("wadl_" + str);
        return;
      }
      catch (Exception paramContext)
      {
        WLog.a("WadlJSBridgePackageInstallReceiver", "WadlJsBridgeUtil, QQ Process meet exception", paramContext);
        return;
      }
      try
      {
        WadlProxyServiceUtil.a(BaseApplicationImpl.getApplication().getRuntime());
        paramContext = paramIntent.getAction();
        try
        {
          WLog.b("WadlJSBridgePackageInstallReceiver", "receive package broadcast mProcessName=" + this.b + ",actionName=" + paramContext + ",appId=" + str + ",packageName=" + (String)localObject);
          paramIntent = new WadlResult(new WadlParams(str, (String)localObject));
          paramIntent.c = 0;
          if (TextUtils.equals(paramContext, "android.intent.action.PACKAGE_REMOVED"))
          {
            paramIntent.a = 3001;
            paramIntent.b = 11;
            a(paramIntent);
            WadlProxyServiceUtil.a().a("doUninstallAppCompleted", (String)localObject);
            return;
          }
        }
        catch (Exception paramContext)
        {
          WLog.a("WadlJSBridgePackageInstallReceiver", "receive package broadcast exception:" + paramContext.getMessage());
          return;
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          WLog.b("WadlJSBridgePackageInstallReceiver", "WadlProxyServiceUtil.launchService:failed", paramContext);
        }
        if (TextUtils.equals(paramContext, "android.intent.action.PACKAGE_REPLACED"))
        {
          paramIntent.a = 2002;
          paramIntent.b = 10;
          a(paramIntent);
          WadlProxyServiceUtil.a().a("doAppReplaced", (String)localObject);
          return;
        }
      }
    } while (!TextUtils.equals(paramContext, "android.intent.action.PACKAGE_ADDED"));
    paramIntent.a = 2002;
    paramIntent.b = 9;
    a(paramIntent);
    WadlProxyServiceUtil.a().a("doInstallAppCompleted", (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.wadl.WadlJSBridgePackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */