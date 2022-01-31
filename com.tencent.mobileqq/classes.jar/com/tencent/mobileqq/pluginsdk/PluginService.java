package com.tencent.mobileqq.pluginsdk;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import mqq.app.AppService;
import mqq.app.MobileQQ;

public abstract class PluginService
  extends AppService
  implements IPluginService
{
  private int a;
  private Context b;
  protected String mApkFilePath;
  protected ClassLoader mDexClassLoader;
  protected boolean mIsRunInPlugin;
  protected Service mOutService;
  protected PackageInfo mPackageInfo;
  protected String mPluginID;
  protected String mPluginName;
  
  public void IInit(String paramString1, String paramString2, String paramString3, Service paramService, ClassLoader paramClassLoader, PackageInfo paramPackageInfo, int paramInt)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginService.IInit: " + paramString2 + ", " + this.a);
    }
    this.mIsRunInPlugin = true;
    this.mPluginName = paramString1;
    this.mPluginID = paramString2;
    this.mApkFilePath = paramString3;
    this.mOutService = paramService;
    this.mDexClassLoader = paramClassLoader;
    this.mPackageInfo = paramPackageInfo;
    this.a = paramInt;
    if (this.b == null) {}
    try
    {
      this.b = new c(paramService, 0, this.mApkFilePath, this.mDexClassLoader, paramService.getResources(), this.a);
      label124:
      attachBaseContext(this.b);
      return;
    }
    catch (Error paramString1)
    {
      break label124;
    }
  }
  
  public IBinder IOnBind(Intent paramIntent)
  {
    IBinder localIBinder = onBind(paramIntent);
    if (DebugHelper.sDebug) {
      DebugHelper.log("plugin_tag", "PluginService.IOnBind: " + localIBinder + ", " + paramIntent);
    }
    return localIBinder;
  }
  
  public void IOnCreate()
  {
    onCreate();
  }
  
  public void IOnDestroy()
  {
    onDestroy();
  }
  
  public void IOnStart(Intent paramIntent, int paramInt)
  {
    onStart(paramIntent, paramInt);
  }
  
  public int IOnStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean IOnUnbind(Intent paramIntent)
  {
    return onUnbind(paramIntent);
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.applicationInfo;
    }
    return super.getApplicationInfo();
  }
  
  public String getModuleId()
  {
    return this.mPluginID;
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo.packageName;
    }
    return super.getPackageName();
  }
  
  public Object getSystemService(String paramString)
  {
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin) {
        return this.mOutService.getSystemService(paramString);
      }
      return super.getSystemService(paramString);
    }
    if (this.b != null) {
      return this.b.getSystemService(paramString);
    }
    return super.getSystemService(paramString);
  }
  
  public void openActivity(Intent paramIntent, String paramString1, String paramString2, boolean paramBoolean)
  {
    paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
    PluginProxyActivity.StartActivityParams localStartActivityParams = new PluginProxyActivity.StartActivityParams();
    localStartActivityParams.mPluginName = this.mPluginName;
    localStartActivityParams.mPluginID = this.mPluginID;
    localStartActivityParams.mPluginApkFilePath = this.mApkFilePath;
    localStartActivityParams.proxyActivity = paramString1;
    localStartActivityParams.mPluginResoucesType = this.a;
    localStartActivityParams.mUseSkinEngine = paramBoolean;
    localStartActivityParams.loader = this.mDexClassLoader;
    localStartActivityParams.launchActivity = paramString2;
    PluginProxyActivity.openActivity(MobileQQ.sMobileQQ, paramIntent, localStartActivityParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginService
 * JD-Core Version:    0.7.0.1
 */