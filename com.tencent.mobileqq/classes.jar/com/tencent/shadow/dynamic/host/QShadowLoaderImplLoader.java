package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;

public class QShadowLoaderImplLoader
  extends ImplLoader
{
  private static final String TAG = "ShadowTag.QShadowLoader";
  private static final String[] sInterfaces = { "com.tencent.shadow.core.runtime.container", "com.tencent.shadow.dynamic.host", "com.tencent.shadow.core.common" };
  private static final String sLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl";
  private static final String sQShadowLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.QShadowCoreLoaderFactoryImpl";
  
  String[] getCustomWhiteList()
  {
    return sInterfaces;
  }
  
  PluginLoaderImpl load(InstalledApk paramInstalledApk, String paramString, Context paramContext)
  {
    Log.w("ShadowTag.QShadowLoader", "load uuid = " + paramString);
    ApkClassLoader localApkClassLoader = new ApkClassLoader(paramInstalledApk, LoaderImplLoader.class.getClassLoader(), loadWhiteList(paramInstalledApk), 1);
    Log.w("ShadowTag.QShadowLoader", "loadLoader loadNormalFactory");
    LoaderFactory localLoaderFactory = (LoaderFactory)localApkClassLoader.getInterface(LoaderFactory.class, "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl");
    Log.w("ShadowTag.QShadowLoader", "loadLoader loadTryQShadowFactory");
    try
    {
      localApkClassLoader.loadClass("com.tencent.shadow.dynamic.loader.impl.QShadowCoreLoaderFactoryImpl");
      Log.w("ShadowTag.QShadowLoader", "ChangeApkContextWrapper");
      paramInstalledApk = new ChangeApkContextWrapper(paramContext, paramInstalledApk.apkFilePath, localApkClassLoader);
      Log.w("ShadowTag.QShadowLoader", "loadLoader buildLoader");
      if (paramInstalledApk == null) {
        return localLoaderFactory.buildLoader(paramString, paramContext);
      }
    }
    catch (ClassNotFoundException paramInstalledApk)
    {
      for (;;)
      {
        Log.w("ShadowTag.QShadowLoader", "不存在QShadowCoreLoaderFactoryImpl，为shadow原生插件，buildLoader传入宿主Context");
        paramInstalledApk = null;
        continue;
        paramContext = paramInstalledApk;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.QShadowLoaderImplLoader
 * JD-Core Version:    0.7.0.1
 */