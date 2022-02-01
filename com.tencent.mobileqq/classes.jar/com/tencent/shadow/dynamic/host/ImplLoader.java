package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.InstalledApk;
import dalvik.system.DexClassLoader;
import java.lang.reflect.Field;

abstract class ImplLoader
{
  private static final String WHITE_LIST_CLASS_NAME = "com.tencent.shadow.dynamic.impl.WhiteList";
  private static final String WHITE_LIST_FIELD_NAME = "sWhiteList";
  
  private static String[] concatenate(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    int i = paramArrayOfString1.length;
    int j = paramArrayOfString2.length;
    String[] arrayOfString = new String[i + j];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, i);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, i, j);
    return arrayOfString;
  }
  
  abstract String[] getCustomWhiteList();
  
  String[] loadWhiteList(InstalledApk paramInstalledApk)
  {
    paramInstalledApk = new DexClassLoader(paramInstalledApk.apkFilePath, paramInstalledApk.oDexPath, paramInstalledApk.libraryPath, getClass().getClassLoader());
    try
    {
      paramInstalledApk = (String[])paramInstalledApk.loadClass("com.tencent.shadow.dynamic.impl.WhiteList").getDeclaredField("sWhiteList").get(null);
      if (paramInstalledApk != null) {
        return concatenate(getCustomWhiteList(), paramInstalledApk);
      }
    }
    catch (ClassNotFoundException paramInstalledApk)
    {
      for (;;)
      {
        paramInstalledApk = null;
      }
    }
    catch (NoSuchFieldException paramInstalledApk)
    {
      throw new RuntimeException(paramInstalledApk);
    }
    catch (IllegalAccessException paramInstalledApk)
    {
      throw new RuntimeException(paramInstalledApk);
    }
    return getCustomWhiteList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.ImplLoader
 * JD-Core Version:    0.7.0.1
 */