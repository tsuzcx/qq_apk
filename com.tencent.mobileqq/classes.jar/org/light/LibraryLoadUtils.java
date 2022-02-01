package org.light;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import org.light.relinker.ReLinker;

public class LibraryLoadUtils
{
  public static final String TAG = "LibraryLoadUtils";
  private static Context appContext;
  
  public static Context getAppContext()
  {
    return appContext;
  }
  
  private static boolean load(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getApplicationInfo().dataDir);
        localStringBuilder.append("/lib");
        paramContext = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("lib");
        localStringBuilder.append(paramString);
        localStringBuilder.append(".so");
        System.load(localStringBuilder.toString());
        return true;
      }
      catch (Throwable paramContext)
      {
        paramString = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load  fail! Error: ");
        localStringBuilder.append(paramContext.getMessage());
        Log.i(paramString, localStringBuilder.toString());
      }
    }
    return false;
  }
  
  private static boolean load(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (Throwable localThrowable)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadLibrary ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" fail! Error: ");
      localStringBuilder.append(localThrowable.getMessage());
      Log.i(str, localStringBuilder.toString());
    }
    return false;
  }
  
  private static void loadLibrary(Context paramContext, String paramString)
  {
    if (load(paramString)) {
      return;
    }
    if (load(paramContext, paramString)) {
      return;
    }
    relinker(paramContext, paramString);
  }
  
  public static void loadLibrary(String paramString)
  {
    try
    {
      appContext = ((Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null)).getApplicationContext();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    loadLibrary(appContext, paramString);
  }
  
  private static boolean relinker(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      try
      {
        ReLinker.loadLibrary(paramContext, paramString);
        return true;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.light.LibraryLoadUtils
 * JD-Core Version:    0.7.0.1
 */