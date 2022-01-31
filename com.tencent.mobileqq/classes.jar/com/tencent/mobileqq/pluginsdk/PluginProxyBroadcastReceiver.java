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
  private int mPluginResoucesType;
  
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
  
  private IPluginBroadcastReceiver startPluginIfNeccessary(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!PluginStatic.isValidPluginIntent(paramIntent.getExtras()))) {}
    for (;;)
    {
      return null;
      String str1 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      String str2 = paramIntent.getStringExtra("pluginsdk_launchReceiver");
      this.mPluginResoucesType = paramIntent.getIntExtra("userQqResources", 0);
      Object localObject1 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      Object localObject2 = paramIntent.getStringExtra("pluginsdk_selfuin");
      String str3 = paramIntent.getStringExtra("pluginsdk_pluginName");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        IPluginAdapterProxy.getProxy().currentUin = ((String)localObject2);
      }
      localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
      try
      {
        localObject2 = PluginUtils.getInstalledPluginPath(paramContext, str1).getCanonicalPath();
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.startPluginIfNeccessary Params:" + str1 + ", " + str2);
        }
        if ((str1 != null) && (str1.length() > 0))
        {
          PluginRecoverReceiver.addCarePluginId(str1);
          localObject1 = new File((String)localObject2);
          if ((((File)localObject1).exists()) && (((File)localObject1).isFile()))
          {
            localObject1 = (PackageInfo)PluginStatic.sPackageInfoMap.get(localObject2);
            if (localObject1 == null)
            {
              try
              {
                localObject3 = ApkFileParser.getPackageInfoWithException(paramContext, (String)localObject2, 129);
                localObject1 = localObject3;
              }
              catch (Throwable localThrowable)
              {
                for (;;)
                {
                  try
                  {
                    localObject3 = PluginStatic.getOrCreateClassLoaderByPath(paramContext, str1, (String)localObject2);
                    paramContext = (IPluginBroadcastReceiver)((ClassLoader)localObject3).loadClass(str2).newInstance();
                  }
                  catch (Exception localException1)
                  {
                    Object localObject3;
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
                    paramContext.IInit(str3, str1, (String)localObject2, this, (ClassLoader)localObject3, (PackageInfo)localObject1, this.mPluginResoucesType);
                    PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(str2, paramIntent);
                    paramIntent = paramContext;
                    return paramIntent;
                  }
                  catch (Exception localException2)
                  {
                    continue;
                  }
                  localThrowable = localThrowable;
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver failed", localThrowable);
                  }
                }
              }
              if (localObject1 == null) {
                continue;
              }
              PluginStatic.sPackageInfoMap.put(localObject2, localObject1);
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Exception localException3 = localException2;
          continue;
          continue;
          paramIntent = null;
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver.onReceive: " + paramIntent);
    }
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    IPluginBroadcastReceiver localIPluginBroadcastReceiver = startPluginIfNeccessary(paramContext, paramIntent);
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