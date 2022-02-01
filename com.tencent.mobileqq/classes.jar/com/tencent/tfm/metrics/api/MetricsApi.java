package com.tencent.tfm.metrics.api;

import java.lang.reflect.Constructor;

public class MetricsApi
{
  private static Metrics instance;
  
  static
  {
    try
    {
      instance = (Metrics)Class.forName("com.tencent.tfm.metrics.MetricsSDK").getConstructor(new Class[0]).newInstance(new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Metrics getDefault()
  {
    return instance;
  }
  
  public static void registerImpl(Metrics paramMetrics)
  {
    instance = paramMetrics;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tfm.metrics.api.MetricsApi
 * JD-Core Version:    0.7.0.1
 */