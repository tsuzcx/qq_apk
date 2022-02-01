package com.tencent.qcircle.shadow.core.runtime;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ProviderInfo;

public abstract interface PluginPackageManager
{
  public abstract ActivityInfo getActivityInfo(ComponentName paramComponentName, int paramInt);
  
  public abstract ApplicationInfo getApplicationInfo(String paramString, int paramInt);
  
  public abstract PackageInfo getPackageInfo(String paramString, int paramInt);
  
  public abstract ProviderInfo resolveContentProvider(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.PluginPackageManager
 * JD-Core Version:    0.7.0.1
 */