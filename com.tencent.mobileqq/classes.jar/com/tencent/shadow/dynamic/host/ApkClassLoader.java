package com.tencent.shadow.dynamic.host;

import android.os.Build.VERSION;
import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;

class ApkClassLoader
  extends DexClassLoader
{
  private ClassLoader mGrandParent;
  private final String[] mInterfacePackageNames;
  
  ApkClassLoader(InstalledApk paramInstalledApk, ClassLoader paramClassLoader, String[] paramArrayOfString, int paramInt)
  {
    super(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, paramClassLoader);
    int i = 0;
    while (i < paramInt)
    {
      paramClassLoader = paramClassLoader.getParent();
      i += 1;
    }
    this.mGrandParent = paramClassLoader;
    this.mInterfacePackageNames = paramArrayOfString;
  }
  
  <T> T getInterface(Class<T> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.cast(loadClass(paramString).newInstance());
      return paramClass;
    }
    catch (IllegalAccessException paramClass) {}catch (ClassCastException paramClass) {}catch (InstantiationException paramClass) {}catch (ClassNotFoundException paramClass) {}
    throw new Exception(paramClass);
  }
  
  protected Class<?> loadClass(String paramString, boolean paramBoolean)
  {
    int i = paramString.lastIndexOf('.');
    int k = 0;
    if (i != -1) {
      localObject1 = paramString.substring(0, i);
    } else {
      localObject1 = "";
    }
    Object localObject2 = this.mInterfacePackageNames;
    int m = localObject2.length;
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= m) {
        break;
      }
      if (((String)localObject1).equals(localObject2[i]))
      {
        j = 1;
        break;
      }
      i += 1;
    }
    if (j != 0) {
      return super.loadClass(paramString, paramBoolean);
    }
    Object localObject1 = findLoadedClass(paramString);
    localObject2 = localObject1;
    if (localObject1 == null) {}
    try
    {
      localObject2 = findClass(paramString);
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label117:
      break label117;
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      try
      {
        paramString = this.mGrandParent.loadClass(paramString);
        return paramString;
      }
      catch (ClassNotFoundException paramString)
      {
        i = Build.VERSION.SDK_INT;
        throw paramString;
      }
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.ApkClassLoader
 * JD-Core Version:    0.7.0.1
 */