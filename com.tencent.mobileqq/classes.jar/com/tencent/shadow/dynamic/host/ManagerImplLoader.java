package com.tencent.shadow.dynamic.host;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;
import java.io.File;

final class ManagerImplLoader
  extends ImplLoader
{
  private static final String MANAGER_FACTORY_CLASS_NAME = "com.tencent.shadow.dynamic.impl.ManagerFactoryImpl";
  private static final String[] REMOTE_PLUGIN_MANAGER_INTERFACES = { "com.tencent.shadow.core.common", "com.tencent.shadow.dynamic.host" };
  private final Context applicationContext;
  private final InstalledApk installedApk;
  
  ManagerImplLoader(Context paramContext, File paramFile)
  {
    this.applicationContext = paramContext.getApplicationContext();
    paramContext = new File(new File(this.applicationContext.getFilesDir(), "ManagerImplLoader"), Long.toString(paramFile.lastModified(), 36));
    paramContext.mkdirs();
    this.installedApk = new InstalledApk(paramFile.getAbsolutePath(), paramContext.getAbsolutePath(), null);
  }
  
  String[] getCustomWhiteList()
  {
    return REMOTE_PLUGIN_MANAGER_INTERFACES;
  }
  
  PluginManagerImpl load()
  {
    Object localObject = new ApkClassLoader(this.installedApk, getClass().getClassLoader(), loadWhiteList(this.installedApk), 1);
    ChangeApkContextWrapper localChangeApkContextWrapper = new ChangeApkContextWrapper(this.applicationContext, this.installedApk.apkFilePath, (ClassLoader)localObject);
    try
    {
      localObject = ((ManagerFactory)((ApkClassLoader)localObject).getInterface(ManagerFactory.class, "com.tencent.shadow.dynamic.impl.ManagerFactoryImpl")).buildManager(localChangeApkContextWrapper);
      return localObject;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.ManagerImplLoader
 * JD-Core Version:    0.7.0.1
 */