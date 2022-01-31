package com.tencent.tmassistant.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistant.st.b;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import java.util.ArrayList;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  private static PackageInstallReceiver d = null;
  protected final String a = "DLSDK_PackageInstallReceiver";
  protected boolean b = false;
  ArrayList<PackageInstallReceiver.IPackageInstallObserver> c = new ArrayList();
  
  public static PackageInstallReceiver a()
  {
    try
    {
      if (d == null) {
        d = new PackageInstallReceiver();
      }
      PackageInstallReceiver localPackageInstallReceiver = d;
      return localPackageInstallReceiver;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (paramContext != null)
    {
      paramContext = new IntentFilter();
      paramContext.addDataScheme("package");
      paramContext.addAction("android.intent.action.PACKAGE_ADDED");
      paramContext.addAction("android.intent.action.PACKAGE_REMOVED");
      paramContext.addAction("android.intent.action.PACKAGE_REPLACED");
      localContext.registerReceiver(this, paramContext);
      this.b = true;
    }
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis() / 1000L;
    String str = l + "|" + "" + "|" + paramString + "|" + Build.MANUFACTURER + "|" + Build.MODEL;
    ab.c("DLSDK_PackageInstallReceiver", "<installReport>reportLog installTest type=" + 9 + ",postReport.data: " + str);
    SDKReportManager2.getInstance().postReport(9, str);
    b.a().a(paramString);
  }
  
  public void b(Context paramContext)
  {
    if (paramContext == null) {}
    while (!this.b) {
      return;
    }
    paramContext.unregisterReceiver(this);
    this.b = false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    ab.b("DLSDK_PackageInstallReceiver", "halleytest intent Action" + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      ab.e("DLSDK_PackageInstallReceiver", "intentPkgNameString == null ");
    }
    Object localObject;
    Message localMessage;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        localMessage = Message.obtain();
        localMessage.obj = localObject;
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
        {
          ab.b("DLSDK_PackageInstallReceiver", "ACTION_PACKAGE_REMOVED >> " + paramContext);
          localMessage.what = 2;
        }
      }
      else
      {
        ab.e("DLSDK_PackageInstallReceiver", "packageName == null " + paramIntent.getDataString());
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        ab.b("DLSDK_PackageInstallReceiver", "ACTION_PACKAGE_REPLACED >> " + paramContext);
        localMessage.what = 3;
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
    ab.b("DLSDK_PackageInstallReceiver", "ACTION_PACKAGE_ADDED >> " + paramContext);
    localMessage.what = 1;
    k.a().post(new a(this, (String)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmassistant.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */