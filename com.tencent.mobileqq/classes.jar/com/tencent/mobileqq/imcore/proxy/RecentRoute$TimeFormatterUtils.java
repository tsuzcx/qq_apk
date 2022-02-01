package com.tencent.mobileqq.imcore.proxy;

public class RecentRoute$TimeFormatterUtils
{
  private static RecentRoute.TimeFormatterUtils.Proxy proxy;
  
  public static String getRecentMessageDateTime(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    if (proxy != null) {
      return proxy.getRecentMessageDateTime(paramStringBuffer, paramLong, paramBoolean, paramString);
    }
    return null;
  }
  
  public static void registerProxy(RecentRoute.TimeFormatterUtils.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.TimeFormatterUtils
 * JD-Core Version:    0.7.0.1
 */