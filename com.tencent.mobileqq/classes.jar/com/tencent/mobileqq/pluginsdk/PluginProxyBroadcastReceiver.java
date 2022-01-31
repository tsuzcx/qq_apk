package com.tencent.mobileqq.pluginsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class PluginProxyBroadcastReceiver
  extends BroadcastReceiver
{
  private int a;
  
  private IPluginBroadcastReceiver a(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!PluginStatic.a(paramIntent.getExtras()))) {}
    for (;;)
    {
      return null;
      String str1 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      String str2 = paramIntent.getStringExtra("pluginsdk_launchReceiver");
      this.a = paramIntent.getIntExtra("userQqResources", 0);
      Object localObject2 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      Object localObject1 = paramIntent.getStringExtra("pluginsdk_selfuin");
      String str3 = paramIntent.getStringExtra("pluginsdk_pluginName");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        IPluginAdapterProxy.getProxy().currentUin = ((String)localObject1);
      }
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {}
      try
      {
        localObject1 = PluginUtils.getInstalledPluginPath(paramContext, str1).getCanonicalPath();
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.startPluginIfNeccessary Params:" + str1 + ", " + str2);
        }
        if ((str1 != null) && (str1.length() > 0))
        {
          PluginRecoverReceiver.a(str1);
          paramIntent = new File((String)localObject1);
          if ((paramIntent.exists()) && (paramIntent.isFile()))
          {
            paramIntent = (PackageInfo)PluginStatic.d.get(localObject1);
            if (paramIntent == null)
            {
              try
              {
                localObject2 = ApkFileParser.getPackageInfoWithException(paramContext, (String)localObject1, 129);
                paramIntent = (Intent)localObject2;
              }
              catch (Throwable localThrowable2)
              {
                for (;;)
                {
                  try
                  {
                    localObject2 = PluginStatic.a(paramContext, str1, (String)localObject1);
                    paramContext = (IPluginBroadcastReceiver)((ClassLoader)localObject2).loadClass(str2).newInstance();
                  }
                  catch (Exception localException1)
                  {
                    paramContext = null;
                    paramIntent = paramContext;
                    if (!DebugHelper.sDebug) {
                      continue;
                    }
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver initPlugin", localException1);
                    paramIntent = paramContext;
                    continue;
                  }
                  try
                  {
                    paramContext.IInit(str3, str1, (String)localObject1, this, (ClassLoader)localObject2, paramIntent, this.a);
                    paramIntent = paramContext;
                    return paramIntent;
                  }
                  catch (Exception localException2)
                  {
                    continue;
                  }
                  localThrowable2 = localThrowable2;
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver failed", localThrowable2);
                  }
                }
              }
              if (paramIntent == null) {
                continue;
              }
              PluginStatic.d.put(localObject1, paramIntent);
            }
          }
        }
      }
      catch (IOException paramIntent)
      {
        for (;;)
        {
          Throwable localThrowable1 = localThrowable2;
          continue;
          continue;
          paramIntent = null;
        }
      }
    }
  }
  
  public static void sendBroadcastReceiver(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchReceiver", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.sendBroadcast(paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("plugin_tag", 1, "", paramContext);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.onReceive: " + paramIntent);
    }
    a.a();
    IPluginBroadcastReceiver localIPluginBroadcastReceiver = a(paramContext, paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.startPluginIfNeccessary: " + localIPluginBroadcastReceiver);
    }
    if (localIPluginBroadcastReceiver != null) {
      localIPluginBroadcastReceiver.IOnReceive(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */