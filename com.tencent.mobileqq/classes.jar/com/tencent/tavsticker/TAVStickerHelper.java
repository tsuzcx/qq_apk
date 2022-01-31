package com.tencent.tavsticker;

import android.app.Application;
import android.content.Context;
import com.tencent.tavsticker.log.TLog;
import java.lang.reflect.Method;

public class TAVStickerHelper
{
  private static final String TAG = TAVStickerHelper.class.getSimpleName();
  private static boolean isDebug = false;
  private static Context sContext = null;
  
  private static Application getApplication()
  {
    try
    {
      Application localApplication = (Application)Class.forName("android.app.AppGlobals").getMethod("getInitialApplication", new Class[0]).invoke(null, (Object[])null);
      return localApplication;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return null;
  }
  
  public static Context getContext()
  {
    if (sContext == null) {
      sContext = getApplication();
    }
    return sContext;
  }
  
  public static String getVersion()
  {
    return "1.2.70";
  }
  
  public static void init(Context paramContext)
  {
    sContext = paramContext;
  }
  
  public static boolean isDebug()
  {
    return isDebug;
  }
  
  public static void setDebugMode(boolean paramBoolean)
  {
    TLog.d(TAG, "setDebugMode -> isDebug : " + paramBoolean);
    isDebug = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.TAVStickerHelper
 * JD-Core Version:    0.7.0.1
 */