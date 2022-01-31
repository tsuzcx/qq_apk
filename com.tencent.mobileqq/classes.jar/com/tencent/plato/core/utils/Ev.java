package com.tencent.plato.core.utils;

import android.content.Context;
import com.tencent.plato.jni.JniLog.JniLogPrinter;

public class Ev
{
  private static IApp app;
  private static Context appContext;
  private static JniLog.JniLogPrinter jniLogPrinter = null;
  private static boolean logEnable = false;
  private static ILogPrinter logPrinter = null;
  private static IReporter reporter = null;
  
  public static Context appContext()
  {
    return appContext;
  }
  
  public static JniLog.JniLogPrinter getJniLogPrinter()
  {
    return jniLogPrinter;
  }
  
  public static boolean getLogEnable()
  {
    return logEnable;
  }
  
  public static ILogPrinter getLogPrinter()
  {
    return logPrinter;
  }
  
  public static IReporter getReporter()
  {
    return reporter;
  }
  
  public static void init(Context paramContext, IApp paramIApp)
  {
    appContext = paramContext;
    app = paramIApp;
  }
  
  public static void setJniLogPrinter(JniLog.JniLogPrinter paramJniLogPrinter)
  {
    jniLogPrinter = paramJniLogPrinter;
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    logEnable = paramBoolean;
  }
  
  public static void setLogPrinter(ILogPrinter paramILogPrinter)
  {
    logPrinter = paramILogPrinter;
  }
  
  public static void setReporter(IReporter paramIReporter)
  {
    reporter = paramIReporter;
  }
  
  public static abstract interface IApp
  {
    public abstract String version();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.core.utils.Ev
 * JD-Core Version:    0.7.0.1
 */