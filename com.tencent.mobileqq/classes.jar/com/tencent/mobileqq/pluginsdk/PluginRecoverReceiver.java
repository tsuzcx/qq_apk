package com.tencent.mobileqq.pluginsdk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

public class PluginRecoverReceiver
  extends BroadcastReceiver
{
  private static final String c = "PluginRecoverReceiver";
  private static final String d = "com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED";
  private static final String e = "pluginId";
  private static final int f = 50;
  private static final int g = 100;
  private static final Set h = new HashSet();
  boolean a;
  String b;
  
  static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED");
    localIntent.putExtra("pluginId", paramString);
    localIntent.setPackage(paramContext.getPackageName());
    paramContext.sendOrderedBroadcast(localIntent, null);
  }
  
  static void a(String paramString)
  {
    if (!h.contains(paramString)) {
      h.add(paramString);
    }
  }
  
  public static PluginRecoverReceiver register(Application paramApplication, PluginRecoverReceiver paramPluginRecoverReceiver)
  {
    String str = MobileQQ.processName;
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED");
    boolean bool = TextUtils.equals(paramApplication.getPackageName(), str);
    if (bool) {
      localIntentFilter.setPriority(50);
    }
    for (;;)
    {
      paramPluginRecoverReceiver.a = bool;
      paramPluginRecoverReceiver.b = str;
      try
      {
        paramApplication.registerReceiver(paramPluginRecoverReceiver, localIntentFilter);
        return paramPluginRecoverReceiver;
      }
      catch (Exception paramApplication) {}
      localIntentFilter.setPriority(100);
    }
    return null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (("com.tencent.mobileqq.ACTION_PLUGIN_STARUP_FAILED".equals(paramIntent.getAction())) && (TextUtils.equals(paramContext.getPackageName(), paramIntent.getPackage())))
    {
      paramContext = paramIntent.getStringExtra("pluginId");
      QLog.d("PluginRecoverReceiver", 1, "onReceive =  pluginID = " + paramContext + ", isQQMobileProcess = " + this.a + ", processName = " + this.b);
      if (!this.a) {
        break label107;
      }
      if (!h.contains(paramContext)) {
        onRecver(paramContext);
      }
    }
    label107:
    while (!h.contains(paramContext)) {
      return;
    }
    paramIntent = PluginRuntime.getRuntime();
    if ((paramIntent != null) && (paramIntent.getRunningModuleSize() > 1))
    {
      onRecver(paramContext);
      return;
    }
    QLog.d("PluginRecoverReceiver", 1, "kill Process =  pluginID = " + paramContext + ", ");
    Process.killProcess(Process.myPid());
  }
  
  protected void onRecver(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginRecoverReceiver
 * JD-Core Version:    0.7.0.1
 */