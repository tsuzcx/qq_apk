package com.tencent.qcircle.shadow.core.runtime;

import android.content.res.Resources;

public class PluginPartInfo
{
  public ShadowApplication application;
  public ClassLoader classLoader;
  PluginPackageManager packageManager;
  public Resources resources;
  
  public PluginPartInfo(ShadowApplication paramShadowApplication, Resources paramResources, ClassLoader paramClassLoader, PluginPackageManager paramPluginPackageManager)
  {
    this.application = paramShadowApplication;
    this.resources = paramResources;
    this.classLoader = paramClassLoader;
    this.packageManager = paramPluginPackageManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.PluginPartInfo
 * JD-Core Version:    0.7.0.1
 */