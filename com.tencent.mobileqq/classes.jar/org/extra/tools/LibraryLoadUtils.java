package org.extra.tools;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import org.extra.relinker.ReLinker;

public class LibraryLoadUtils
{
  public static final String TAG = LibraryLoadUtils.class.getSimpleName();
  private static Context appContext;
  
  public static Context getAppContext()
  {
    return appContext;
  }
  
  private static boolean load(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      paramContext = paramContext.getApplicationInfo().dataDir + "/lib";
      System.load(paramContext + File.separator + "lib" + paramString + ".so");
      return true;
    }
    catch (Throwable paramContext)
    {
      Log.i(TAG, "load  fail! Error: " + paramContext.getMessage());
    }
    return false;
  }
  
  private static boolean load(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    boolean bool = true;
    try
    {
      System.loadLibrary(paramString);
      return bool;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.i(TAG, "loadLibrary " + paramString + " fail! Error: " + localThrowable.getMessage());
        bool = false;
      }
    }
  }
  
  private static void loadLibrary(Context paramContext, String paramString)
  {
    if (load(paramString)) {}
    while (load(paramContext, paramString)) {
      return;
    }
    relinker(paramContext, paramString);
  }
  
  public static void loadLibrary(String paramString)
  {
    try
    {
      appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
      label31:
      loadLibrary(appContext, paramString);
      return;
    }
    catch (Exception localException)
    {
      break label31;
    }
  }
  
  private static boolean relinker(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      ReLinker.loadLibrary(paramContext, paramString);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.extra.tools.LibraryLoadUtils
 * JD-Core Version:    0.7.0.1
 */