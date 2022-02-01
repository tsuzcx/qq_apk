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
    PackageInfo localPackageInfo = (PackageInfo)PluginStatic.sPackageInfoMap.get(this.mApkFilePath);
    if (localPackageInfo == null)
    {
      try
      {
        localPackageInfo = ApkFileParser.getPackageInfoWithException(this, this.mApkFilePath, 129);
        if (localPackageInfo == null) {
          return "Get Package Info Failed!";
        }
      }
      catch (Throwable localThrowable1)
      {
        throw new PluginUtils.GetPackageInfoFailException("getPackageInfoWithException", localThrowable1);
      }
      PluginStatic.sPackageInfoMap.put(this.mApkFilePath, localThrowable1);
    }
    for (;;)
    {
      ClassLoader localClassLoader = PluginStatic.getOrCreateClassLoaderByPath(this, this.mPluginID, this.mApkFilePath, true);
      Class localClass = localClassLoader.loadClass(this.mLaunchService);
      try
      {
        this.mPluginService = ((IPluginService)localClass.newInstance());
        this.mPluginService.IInit(this.mPluginName, this.mPluginID, this.mApkFilePath, this, localClassLoader, localThrowable1, this.mPluginResoucesType);
        return null;
      }
      catch (Throwable localThrowable2)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService initPlugin ", localThrowable2);
        }
        return "new PluginService failed!";
      }
    }
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
    IBinder localIBinder = null;
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind PluginService:" + this.mPluginService);
    }
    if (this.mPluginService == null) {
      startPluginIfNeccessary(paramIntent);
    }
    if (this.mPluginService != null) {
      localIBinder = this.mPluginService.IOnBind(paramIntent);
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind IBinder:" + localIBinder);
    }
    return localIBinder;
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
    if (this.mPluginService != null)
    {
      this.mPluginService.IOnDestroy();
      this.mPluginService = null;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onStart Intent:" + paramIntent);
    }
    if ((startPluginIfNeccessary(paramIntent)) && (this.mPluginService != null)) {
      this.mPluginService.IOnStart(paramIntent, paramInt);
    }
  }
  
  @SuppressLint({"NewApi"})
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    int j = super.onStartCommand(paramIntent, paramInt1, paramInt2);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onStartCommand Intent:" + paramIntent);
    }
    int i = j;
    if (startPluginIfNeccessary(paramIntent))
    {
      i = j;
      if (this.mPluginService != null) {
        i = this.mPluginService.IOnStartCommand(paramIntent, paramInt1, paramInt2);
      }
    }
    return i;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    boolean bool = super.onUnbind(paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onUnbind Intent:" + paramIntent);
    }
    if (this.mPluginService != null) {
      bool = this.mPluginService.IOnUnbind(paramIntent);
    }
    return bool;
  }
  
  protected boolean startPluginIfNeccessary(Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Intent:" + paramIntent);
    }
    if ((paramIntent == null) || (!PluginStatic.isValidPluginIntent(paramIntent.getExtras()))) {
      return false;
    }
    String str3 = paramIntent.getStringExtra("pluginsdk_pluginName");
    String str4 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    String str5 = paramIntent.getStringExtra("pluginsdk_launchService");
    this.mPluginResoucesType = paramIntent.getIntExtra("userQqResources", 0);
    String str2 = paramIntent.getStringExtra("pluginsdk_pluginpath");
    Object localObject = paramIntent.getStringExtra("pluginsdk_selfuin");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      IPluginAdapterProxy.getProxy().currentUin = ((String)localObject);
    }
    localObject = str2;
    if (TextUtils.isEmpty(str2)) {
      localObject = PluginUtils.getInstalledPluginPath(this, str4);
    }
    try
    {
      localObject = ((File)localObject).getCanonicalPath();
      if (DebugHelper.sDebug) {
        DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Params:" + str4 + ", " + str5);
      }
      if (this.mPluginService != null)
      {
        if ((this.mPluginID.equals(str4)) && (this.mPluginName.equals(str3)) && (this.mLaunchService.equals(str5)))
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
      this.mPluginID = str4;
      this.mApkFilePath = ((String)localObject);
      this.mPluginName = str3;
      this.mLaunchService = str5;
      localObject = PluginStatic.getClassLoader(this.mPluginID);
      if (localObject != null) {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject);
      }
      if ((this.mPluginID == null) || (this.mPluginID.length() == 0)) {
        localObject = "Param mPluingLocation missing!";
      }
      for (;;)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary ErrorInfo: " + (String)localObject);
        }
        return true;
        localObject = new File(this.mApkFilePath);
        if ((!((File)localObject).exists()) && (!((File)localObject).isFile())) {
          localObject = "Plugin File Not Found!";
        } else {
          try
          {
            str2 = initPlugin();
            localObject = str2;
            if (str2 == null)
            {
              PluginProxyActivity.uploadLaunchInfoWhenCreateClassLoader(this.mLaunchService, paramIntent);
              this.mPluginService.IOnCreate();
              localObject = str2;
            }
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            localObject = PluginUtils.getExceptionInfo(paramIntent);
            stopSelf();
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        String str1 = str2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyService
 * JD-Core Version:    0.7.0.1
 */