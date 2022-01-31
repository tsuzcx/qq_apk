package com.tencent.mobileqq.pluginsdk;

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
  private IPluginService a;
  private int b;
  private String c;
  private String d;
  private String e;
  private String f;
  
  private String a()
    throws Exception
  {
    PluginRecoverReceiver.a(this.d);
    PackageInfo localPackageInfo = (PackageInfo)PluginStatic.d.get(this.e);
    if (localPackageInfo == null)
    {
      try
      {
        localPackageInfo = ApkFileParser.getPackageInfoWithException(this, this.e, 129);
        if (localPackageInfo == null) {
          return "Get Package Info Failed!";
        }
      }
      catch (Throwable localThrowable1)
      {
        throw new PluginUtils.a("getPackageInfoWithException", localThrowable1);
      }
      PluginStatic.d.put(this.e, localThrowable1);
    }
    for (;;)
    {
      ClassLoader localClassLoader = PluginStatic.a(this, this.d, this.e);
      Class localClass = localClassLoader.loadClass(this.f);
      try
      {
        this.a = ((IPluginService)localClass.newInstance());
        this.a.IInit(this.c, this.d, this.e, this, localClassLoader, localThrowable1, this.b);
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
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind PluginService:" + this.a);
    }
    if (this.a == null) {
      startPluginIfNeccessary(paramIntent);
    }
    if (this.a != null) {
      localIBinder = this.a.IOnBind(paramIntent);
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onBind IBinder:" + localIBinder);
    }
    return localIBinder;
  }
  
  public void onCreate()
  {
    super.onCreate();
    a.a();
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
    if (this.a != null)
    {
      this.a.IOnDestroy();
      this.a = null;
    }
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    super.onStart(paramIntent, paramInt);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.onStart Intent:" + paramIntent);
    }
    if ((startPluginIfNeccessary(paramIntent)) && (this.a != null)) {
      this.a.IOnStart(paramIntent, paramInt);
    }
  }
  
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
      if (this.a != null) {
        i = this.a.IOnStartCommand(paramIntent, paramInt1, paramInt2);
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
    if (this.a != null) {
      bool = this.a.IOnUnbind(paramIntent);
    }
    return bool;
  }
  
  protected boolean startPluginIfNeccessary(Intent paramIntent)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary Intent:" + paramIntent);
    }
    if ((paramIntent == null) || (!PluginStatic.a(paramIntent.getExtras()))) {
      return false;
    }
    String str3 = paramIntent.getStringExtra("pluginsdk_pluginName");
    String str4 = paramIntent.getStringExtra("pluginsdk_pluginLocation");
    String str5 = paramIntent.getStringExtra("pluginsdk_launchService");
    this.b = paramIntent.getIntExtra("userQqResources", 0);
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
      if (this.a != null)
      {
        if ((this.d.equals(str4)) && (this.c.equals(str3)) && (this.f.equals(str5)))
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
      this.d = str4;
      this.e = ((String)localObject);
      this.c = str3;
      this.f = str5;
      localObject = PluginStatic.getClassLoader(this.d);
      if (localObject != null) {
        paramIntent.setExtrasClassLoader((ClassLoader)localObject);
      }
      if ((this.d == null) || (this.d.length() == 0)) {
        paramIntent = "Param mPluingLocation missing!";
      }
      for (;;)
      {
        if (DebugHelper.sDebug) {
          DebugHelper.log("plugin_tag", "PluginProxyService.startPluginIfNeccessary ErrorInfo: " + paramIntent);
        }
        return true;
        paramIntent = new File(this.e);
        if ((!paramIntent.exists()) && (!paramIntent.isFile())) {
          paramIntent = "Plugin File Not Found!";
        } else {
          try
          {
            localObject = a();
            paramIntent = (Intent)localObject;
            if (localObject == null)
            {
              this.a.IOnCreate();
              paramIntent = (Intent)localObject;
            }
          }
          catch (Exception paramIntent)
          {
            paramIntent.printStackTrace();
            paramIntent = PluginUtils.getExceptionInfo(paramIntent);
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