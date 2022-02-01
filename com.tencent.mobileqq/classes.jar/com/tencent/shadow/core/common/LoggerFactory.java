package com.tencent.shadow.core.common;

import android.util.Log;

public final class LoggerFactory
{
  private static final String TAG = "LoggerFactory";
  private static volatile ILoggerFactory sILoggerFactory;
  
  public static ILoggerFactory getILoggerFactory()
  {
    if (sILoggerFactory != null) {
      return sILoggerFactory;
    }
    throw new RuntimeException("没有找到 ILoggerFactory 实现，请先调用setILoggerFactory");
  }
  
  public static final Logger getLogger(Class<?> paramClass)
  {
    return getILoggerFactory().getLogger(paramClass.getName());
  }
  
  public static void setILoggerFactory(ILoggerFactory paramILoggerFactory)
  {
    if (sILoggerFactory != null)
    {
      Log.w("LoggerFactory", "setILoggerFactory: 不能重复初始化!");
      return;
    }
    sILoggerFactory = paramILoggerFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.core.common.LoggerFactory
 * JD-Core Version:    0.7.0.1
 */