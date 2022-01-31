package com.tencent.tvkbeacon.core.protocol.a;

import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.c.i;

public final class a
{
  public static String a(String paramString)
  {
    return "http://" + paramString + "/analytics/upload";
  }
  
  public static String a(boolean paramBoolean, String paramString)
  {
    c.b("[event url] getStrategyUrl, isHttpMode: %s, httpUrl: %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (i.a(paramString))
    {
      if (paramBoolean) {
        return "http://oth.str.mdt.qq.com:8080/analytics/upload";
      }
      return "oth.str.mdt.qq.com";
    }
    if (paramBoolean) {}
    for (;;)
    {
      return paramString;
      paramString = b(paramString);
    }
  }
  
  public static String a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    c.b("[event url] getRequestUrl, isHttpMode: %s, isRealtimeTest: %s, httpUrl: %s", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), paramString });
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        return "http://183.36.108.226:8080/analytics/upload";
      }
      return "183.36.108.226";
    }
    if (i.a(paramString))
    {
      if (paramBoolean1) {
        return "http://oth.eve.mdt.qq.com:8080/analytics/upload";
      }
      return "oth.eve.mdt.qq.com";
    }
    if (paramBoolean1) {}
    for (;;)
    {
      return paramString;
      paramString = b(paramString);
    }
  }
  
  private static String b(String paramString)
  {
    String str;
    if ((paramString == null) || ("".equals(paramString))) {
      str = "";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("http://");
      str = paramString;
    } while (i == -1);
    int j = paramString.indexOf(":", "http://".length());
    return paramString.substring("http://".length() + i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.protocol.a.a
 * JD-Core Version:    0.7.0.1
 */