package com.tencent.shadow.dynamic.host;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;

final class LoaderImplLoader
  extends ImplLoader
{
  private static final String[] sInterfaces = { "com.tencent.shadow.core.runtime.container", "com.tencent.shadow.dynamic.host", "com.tencent.shadow.core.common" };
  private static final String sLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl";
  
  String[] getCustomWhiteList()
  {
    return sInterfaces;
  }
  
  PluginLoaderImpl load(InstalledApk paramInstalledApk, String paramString, Context paramContext)
  {
    return ((LoaderFactory)new ApkClassLoader(paramInstalledApk, LoaderImplLoader.class.getClassLoader(), loadWhiteList(paramInstalledApk), 1).getInterface(LoaderFactory.class, "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl")).buildLoader(paramString, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.LoaderImplLoader
 * JD-Core Version:    0.7.0.1
 */