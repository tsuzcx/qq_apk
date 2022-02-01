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
  private static PackageInstallReceiver d;
  protected final String a = "DLSDK_PackageInstallReceiver";
  protected boolean b = false;
  ArrayList<Object> c = new ArrayList();
  
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(Build.MANUFACTURER);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<installReport>reportLog installTest type=");
    localStringBuilder.append(9);
    localStringBuilder.append(",postReport.data: ");
    localStringBuilder.append((String)localObject);
    ab.c("DLSDK_PackageInstallReceiver", localStringBuilder.toString());
    SDKReportManager2.getInstance().postReport(9, (String)localObject);
    b.a().a(paramString);
  }
  
  public void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    if (this.b)
    {
      paramContext.unregisterReceiver(this);
      this.b = false;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("halleytest intent Action");
    paramContext.append(paramIntent.getAction());
    ab.b("DLSDK_PackageInstallReceiver", paramContext.toString());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext))
    {
      ab.e("DLSDK_PackageInstallReceiver", "intentPkgNameString == null ");
      return;
    }
    Object localObject = paramContext.split(":");
    if (localObject.length == 2)
    {
      String str = localObject[1];
      localObject = Message.obtain();
      ((Message)localObject).obj = str;
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("ACTION_PACKAGE_REMOVED >> ");
        paramIntent.append(paramContext);
        ab.b("DLSDK_PackageInstallReceiver", paramIntent.toString());
        ((Message)localObject).what = 2;
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("ACTION_PACKAGE_REPLACED >> ");
        paramIntent.append(paramContext);
        ab.b("DLSDK_PackageInstallReceiver", paramIntent.toString());
        ((Message)localObject).what = 3;
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"))
      {
        paramIntent = new StringBuilder();
        paramIntent.append("ACTION_PACKAGE_ADDED >> ");
        paramIntent.append(paramContext);
        ab.b("DLSDK_PackageInstallReceiver", paramIntent.toString());
        ((Message)localObject).what = 1;
        k.a().post(new a(this, str));
      }
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("packageName == null ");
    paramContext.append(paramIntent.getDataString());
    ab.e("DLSDK_PackageInstallReceiver", paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */