package com.tencent.shadow.proguard;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.LoaderFactory;
import com.tencent.shadow.dynamic.host.PluginLoaderImpl;

public final class j
  extends i
{
  private static final String[] a = { "com.tencent.shadow.core.runtime.container", "com.tencent.shadow.dynamic.host", "com.tencent.shadow.core.common" };
  
  public final PluginLoaderImpl a(InstalledApk paramInstalledApk, String paramString, Context paramContext)
  {
    return ((LoaderFactory)new b(paramInstalledApk, j.class.getClassLoader(), a(paramInstalledApk)).a(LoaderFactory.class, "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl")).buildLoader(paramString, paramContext);
  }
  
  final String[] a()
  {
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.proguard.j
 * JD-Core Version:    0.7.0.1
 */