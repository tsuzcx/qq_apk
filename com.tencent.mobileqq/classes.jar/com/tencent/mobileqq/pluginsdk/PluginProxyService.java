package com.tencent.mobileqq.pluginsdk;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class PluginProxyService
  extends Service
{
  private String mApkFilePath;
  private String mLaunchService;
  private String mPluginID;
  private String mPluginName;
  private int mPluginResoucesType;
  private IPluginService mPluginService;
  
  public static void bindService(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, ServiceConnection paramServiceConnection)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchService", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.bindService(paramIntent, paramServiceConnection, 1);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("plugin_tag", 1, "", paramContext);
    }
  }
  
  private String initPlugin()
  {
    PluginRecoverReceiver.addCarePluginId(this.mPluginID);
    Object localObject2 = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mApkFilePath);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      try
      {
        localObject1 = ApkFileParser.getPackageInfoWithException(this, this.mApkFilePath, 129);
        if (localObject1 == null) {
          return "Get Package Info Failed!";
        }
        PluginStatic.sPackageInfoMap.put(this.mApkFilePath, localObject1);
      }
      catch (Throwable localThrowable1)
      {
        throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", localThrowable1);
      }
    }
    localObject2 = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mApkFilePath, true);
    Class localClass = ((ClassLoader)localObject2).loadClass(this.mLaunchService);
    try
    {
      this.mPluginService = ((IPluginService)localClass.newInstance());
      this.mPluginService.IInit(this.mPluginName, this.mPluginID, this.mApkFilePath, this, (ClassLoader)localObject2, localThrowable1, this.mPluginResoucesType);
      return null;
    }
    catch (Throwable localThrowable2)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "PluginProxyService initPlugin ", localThrowable2);
      }
    }
    return "new PluginService failed!";
  }
  
  public static void openService(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchService", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramContext.startService(paramIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.d("plugin_tag", 1, "", paramContext);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyService.onBind PluginService:");
      ((StringBuilder)localObject).append(this.mPluginService);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    if (this.mPluginService == null) {
      startPluginIfNeccessary(paramIntent);
    }
    Object localObject = this.mPluginService;
    if (localObject != null) {
      paramIntent = ((IPluginService)localObject).IOnBind(paramIntent);
    } else {
      paramIntent = null;
    }
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyService.onBind IBinder:");
      ((StringBuilder)localObject).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    return paramIntent;
  }
  
  public void onCreate()
  {
    super.onCreate();
    IPluginProxyComponent.registerAccountReceiverIfNeccessary();
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onCreate");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onDestroy");
    }
    IPluginService localIPluginService = this.mPluginService;
    if (localIPluginService != null)
    {
      localIPluginService.IOnDestroy();
      this.mPluginService = null;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    Object localObject;
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyService.onStart Intent:");
      ((StringBuilder)localObject).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    if (startPluginIfNeccessary(paramIntent))
    {
      localObject = this.mPluginService;
      if (localObject != null) {
        ((IPluginService)localObject).IOnStart(paramIntent, paramInt);
      }
    }
  }
  
  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int j = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    Object localObject;
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyService.onStartCommand Intent:");
      ((StringBuilder)localObject).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    int i = j;
    if (startPluginIfNeccessary(paramIntent))
    {
      localObject = this.mPluginService;
      i = j;
      if (localObject != null) {
        i = ((IPluginService)localObject).IOnStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
    return i;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    boolean bool = super.onUnbind(paramIntent);
    if (DebugHelper.sDebug)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PluginProxyService.onUnbind Intent:");
      ((StringBuilder)localObject).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mPluginService;
    if (localObject != null) {
      bool = ((IPluginService)localObject).IOnUnbind(paramIntent);
    }
    return bool;
  }
  
  protected boolean startPluginIfNeccessary(Intent paramIntent)
  {
    Object localObject1;
    if (DebugHelper.sDebug)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("PluginProxyService.startPluginIfNeccessary Intent:");
      ((StringBuilder)localObject1).append(paramIntent);
      DebugHelper.log("plugin_tag", ((StringBuilder)localObject1).toString());
    }
    String str1;
    String str2;
    String str3;
    Object localObject3;
    if (paramIntent != null)
    {
      if (!PluginStatic.isValidPluginIntent(paramIntent.getExtras())) {
        return false;
      }
      str1 = paramIntent.getStringExtra("pluginsdk_pluginName");
      str2 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
      str3 = paramIntent.getStringExtra("pluginsdk_launchService");
      this.mPluginResoucesType = paramIntent.getIntExtra("userQqResources", 0);
      localObject3 = paramIntent.getStringExtra("pluginsdk_pluginpath");
      localObject1 = paramIntent.getStringExtra("pluginsdk_selfuin");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        IPluginAdapterProxy.getProxy().currentUin = ((String)localObject1);
      }
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = PluginUtils.getInstalledPluginPath(this, str2);
      }
    }
    try
    {
      localObject1 = ((File)localObject1).getCanonicalPath();
      if (DebugHelper.sDebug)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("PluginProxyService.startPluginIfNeccessary Params:");
        ((StringBuilder)localObject3).append(str2);
        ((StringBuilder)localObject3).append(", ");
        ((StringBuilder)localObject3).append(str3);
        DebugHelper.log("plugin_tag", ((StringBuilder)localObject3).toString());
      }
      if (this.mPluginService != null)
      {
        if ((this.mPluginID.equals(str2)) && (this.mPluginName.equals(str1)) && (this.mLaunchService.equals(str3)))
        {
          if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: already init the same service");
          }
          return true;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary: error arguments");
        }
        return false;
      }
      this.mPluginID = str2;
      this.mApkFilePath = ((String)localObject1);
      this.mPluginName = str1;
      this.mLaunchService = str3;
      localObject1 = PluginStatic.getClassLoader(this.mPluginID);
      if (localObject1 != null) {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject1);
      }
      localObject1 = this.mPluginID;
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject1 = new File(this.mApkFilePath);
        if ((!((File)localObject1).exists()) && (!((File)localObject1).isFile())) {
          paramIntent = "Plugin File Not Found!";
        } else {
          try
          {
            localObject1 = initPlugin();
            if (localObject1 == null)
            {
              PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(this.mLaunchService, paramIntent);
              this.mPluginService.IOnCreate();
            }
            paramIntent = (Intent)localObject1;
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramIntent = PluginUtils.getExceptionInfo(paramIntent);
            stopSelf();
          }
        }
      }
      else
      {
        paramIntent = "Param mPluingLocation missing!";
      }
      if (DebugHelper.sDebug)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("PluginProxyService.startPluginIfNeccessary ErrorInfo: ");
        ((StringBuilder)localObject1).append(paramIntent);
        DebugHelper.log("plugin_tag", ((StringBuilder)localObject1).toString());
      }
      return true;
      return false;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyService
 * JD-Core Version:    0.7.0.1
 */