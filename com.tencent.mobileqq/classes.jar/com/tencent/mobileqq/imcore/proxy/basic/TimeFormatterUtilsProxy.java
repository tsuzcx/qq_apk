package com.tencent.mobileqq.imcore.proxy.basic;

public class TimeFormatterUtilsProxy
{
  private static TimeFormatterUtilsProxy.Proxy a;
  
  public static String a(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    TimeFormatterUtilsProxy.Proxy localProxy = a;
    if (localProxy != null) {
      return localProxy.a(paramStringBuffer, paramLong, paramBoolean, paramString);
    }
    return null;
  }
  
  public static void a(TimeFormatterUtilsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.basic.TimeFormatterUtilsProxy
 * JD-Core Version:    0.7.0.1
 */