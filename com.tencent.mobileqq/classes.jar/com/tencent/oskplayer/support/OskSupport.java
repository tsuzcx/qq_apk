package com.tencent.oskplayer.support;

import android.content.Context;
import com.tencent.oskplayer.support.loader.DefaultNativeLibLoader;
import com.tencent.oskplayer.support.loader.NativeLibLoader;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;

public class OskSupport
{
  public static final String LOG_TAG = "OskSupport";
  private static boolean isInit = false;
  private static Context sContext = null;
  private static NativeLibLoader sLibLoader = null;
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static NativeLibLoader getLibLoader()
  {
    return sLibLoader;
  }
  
  public static ILogger getLogger()
  {
    return Logger.g();
  }
  
  public static void init(Context paramContext, ILogger paramILogger, NativeLibLoader paramNativeLibLoader)
  {
    if (paramContext == null) {
      throw new RuntimeException("need a valid applicationContext");
    }
    if (paramILogger == null) {
      throw new RuntimeException("need a valid logger implementation");
    }
    if (paramNativeLibLoader == null) {
      paramILogger.i("OskSupport", "libLoader is not set, use DefaultNativeLibLoader");
    }
    try
    {
      if (!isInit)
      {
        sContext = paramContext.getApplicationContext();
        Logger.setLogger(paramILogger);
        paramContext = paramNativeLibLoader;
        if (paramNativeLibLoader == null) {
          paramContext = new DefaultNativeLibLoader();
        }
        sLibLoader = paramContext;
        isInit = true;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.oskplayer.support.OskSupport
 * JD-Core Version:    0.7.0.1
 */