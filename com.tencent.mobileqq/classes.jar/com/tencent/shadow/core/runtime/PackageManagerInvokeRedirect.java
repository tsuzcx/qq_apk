package com.tencent.shadow.core.runtime;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.VersionedPackage;

public class PackageManagerInvokeRedirect
{
  public static ActivityInfo getActivityInfo(ClassLoader paramClassLoader, ComponentName paramComponentName, int paramInt)
  {
    return getPluginPackageManager(paramClassLoader).getActivityInfo(paramComponentName, paramInt);
  }
  
  public static ApplicationInfo getApplicationInfo(ClassLoader paramClassLoader, String paramString, int paramInt)
  {
    return getPluginPackageManager(paramClassLoader).getApplicationInfo(paramString, paramInt);
  }
  
  @TargetApi(26)
  public static PackageInfo getPackageInfo(ClassLoader paramClassLoader, VersionedPackage paramVersionedPackage, int paramInt)
  {
    return getPluginPackageManager(paramClassLoader).getPackageInfo(paramVersionedPackage.getPackageName(), paramInt);
  }
  
  public static PackageInfo getPackageInfo(ClassLoader paramClassLoader, String paramString, int paramInt)
  {
    return getPluginPackageManager(paramClassLoader).getPackageInfo(paramString, paramInt);
  }
  
  private static PluginPackageManager getPluginPackageManager(ClassLoader paramClassLoader)
  {
    return PluginPartInfoManager.getPluginInfo(paramClassLoader).packageManager;
  }
  
  public static ProviderInfo resolveContentProvider(ClassLoader paramClassLoader, String paramString, int paramInt)
  {
    return getPluginPackageManager(paramClassLoader).resolveContentProvider(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.PackageManagerInvokeRedirect
 * JD-Core Version:    0.7.0.1
 */