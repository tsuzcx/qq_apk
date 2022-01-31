package com.tencent.shadow.proguard;

import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;

abstract class i
{
  abstract String[] a();
  
  final String[] a(InstalledApk paramInstalledApk)
  {
    String[] arrayOfString1 = null;
    paramInstalledApk = new DexClassLoader(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, getClass().getClassLoader());
    try
    {
      paramInstalledApk = (String[])paramInstalledApk.loadClass("com.tencent.shadow.dynamic.impl.WhiteList").getDeclaredField("sWhiteList").get(null);
      if (paramInstalledApk != null)
      {
        arrayOfString1 = a();
        int i = arrayOfString1.length;
        int j = paramInstalledApk.length;
        String[] arrayOfString2 = new String[i + j];
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
        System.arraycopy(paramInstalledApk, 0, arrayOfString2, i, j);
        return arrayOfString2;
      }
    }
    catch (NoSuchFieldException paramInstalledApk)
    {
      throw new RuntimeException(paramInstalledApk);
    }
    catch (IllegalAccessException paramInstalledApk)
    {
      throw new RuntimeException(paramInstalledApk);
      return a();
    }
    catch (ClassNotFoundException paramInstalledApk)
    {
      for (;;)
      {
        paramInstalledApk = arrayOfString1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.proguard.i
 * JD-Core Version:    0.7.0.1
 */