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
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = localObject4;
    String str1;
    String str2;
    Object localObject2;
    String str3;
    if (paramIntent != null)
    {
      if (!PluginStatic.isValidPluginIntent(paramIntent.getExtras())) {
        return null;
      }
      str1 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      str2 = paramIntent.getStringExtra("pluginsdk_launchReceiver");
      this.mPluginResoucesType = paramIntent.getIntExtra("userQqResources", 0);
      localObject1 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      localObject2 = paramIntent.getStringExtra("pluginsdk_selfuin");
      str3 = paramIntent.getStringExtra("pluginsdk_pluginName");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        IPluginAdapterProxy.getProxy().currentUin = ((String)localObject2);
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    try
    {
      localObject2 = PluginUtils.getInstalledPluginPath(paramContext, str1).getCanonicalPath();
      if (DebugHelper.sDebug)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PluginProxyBroadcastReceiver.startPluginIfNeccessary Params:");
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(str2);
        DebugHelper.log("plugin_tag", ((StringBuilder)localObject1).toString());
      }
      localObject1 = localObject4;
      if (str1 != null)
      {
        localObject1 = localObject4;
        if (str1.length() > 0)
        {
          PluginRecoverReceiver.addCarePluginId(str1);
          File localFile = new File((String)localObject2);
          localObject1 = localObject4;
          if (localFile.exists())
          {
            localObject1 = localObject4;
            if (localFile.isFile())
            {
              localObject4 = (PackageInfo)PluginStatic.sPackageInfoMap.get(localObject2);
              localObject1 = localObject4;
              if (localObject4 == null)
              {
                try
                {
                  localObject1 = ApkFileParser.getPackageInfoWithException(paramContext, (String)localObject2, 129);
                }
                catch (Throwable localThrowable)
                {
                  localObject1 = localObject4;
                  if (DebugHelper.sDebug)
                  {
                    DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver failed", localThrowable);
                    localObject1 = localObject4;
                  }
                }
                if (localObject1 == null) {
                  return null;
                }
                PluginStatic.sPackageInfoMap.put(localObject2, localObject1);
              }
              try
              {
                localObject4 = PluginStatic.getOrCreateClassLoaderByPath(paramContext, str1, (String)localObject2, true);
                paramContext = (IPluginBroadcastReceiver)((ClassLoader)localObject4).loadClass(str2).newInstance();
                try
                {
                  paramContext.IInit(str3, str1, (String)localObject2, this, (ClassLoader)localObject4, (PackageInfo)localObject1, this.mPluginResoucesType);
                  PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(str2, paramIntent);
                  return paramContext;
                }
                catch (Exception paramIntent) {}
                localObject1 = paramContext;
              }
              catch (Exception paramIntent)
              {
                paramContext = localObject5;
              }
              if (DebugHelper.sDebug)
              {
                DebugHelper.log("plugin_tag", "PluginProxyBroadcastReceiver initPlugin", paramIntent);
                localObject1 = paramContext;
              }
            }
          }
        }
      }
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject3 = localObject1;
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyBroadcastReceiver.onReceive: ");
      ((StringBuilder)localObject).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    Object localObject = startPluginIfNeccessary(paramContext, paramIntent);
    if (DebugHelper.sDebug)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PluginProxyBroadcastReceiver.startPluginIfNeccessary: ");
      localStringBuilder.append(localObject);
      DebugHelper.log("plugin_tag", localStringBuilder.toString());
    }
    if (localObject != null) {
      ((IPluginBroadcastReceiver)localObject).IOnReceive(paramContext, paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */