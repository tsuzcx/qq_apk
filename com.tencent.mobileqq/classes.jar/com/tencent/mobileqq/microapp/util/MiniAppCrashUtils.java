package com.tencent.mobileqq.microapp.util;

import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Method;

public class MiniAppCrashUtils
{
  public static void reportCrash(String paramString)
  {
    try
    {
      ClassLoader localClassLoader = BaseApplicationImpl.sApplication.getClassLoader();
      if (localClassLoader == null) {
        return;
      }
      localClassLoader.loadClass("com.tencent.mobileqq.microapp.sdk.MiniAppController").getMethod("handleNoCatchCrash", new Class[] { String.class }).invoke(null, new Object[] { paramString });
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.util.MiniAppCrashUtils
 * JD-Core Version:    0.7.0.1
 */