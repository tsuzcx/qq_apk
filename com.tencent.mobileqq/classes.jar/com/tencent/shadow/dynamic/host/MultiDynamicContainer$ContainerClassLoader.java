package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.BaseDexClassLoader;
import java.io.File;

class MultiDynamicContainer$ContainerClassLoader
  extends BaseDexClassLoader
{
  private String apkFilePath;
  private String containerKey;
  
  public MultiDynamicContainer$ContainerClassLoader(String paramString, InstalledApk paramInstalledApk, ClassLoader paramClassLoader)
  {
    super(str, localFile, paramInstalledApk.libraryPath, paramClassLoader);
    this.containerKey = paramString;
    this.apkFilePath = paramInstalledApk.apkFilePath;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiDynamicContainer.ContainerClassLoader
 * JD-Core Version:    0.7.0.1
 */