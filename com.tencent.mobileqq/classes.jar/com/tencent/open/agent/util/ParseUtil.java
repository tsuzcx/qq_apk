package com.tencent.open.agent.util;

import android.text.TextUtils;

public class ParseUtil
{
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SSOLog.b("ParseUtil", new Object[] { "parseLong text = ", paramString });
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      label34:
      break label34;
    }
    SSOLog.b("ParseUtil", new Object[] { "parseLong text = ", paramString });
    return 0L;
  }
  
  public static int b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SSOLog.b("ParseUtil", new Object[] { "parseInt text isEmpty" });
      return 0;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      SSOLog.c("ParseUtil", "Exception", paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.util.ParseUtil
 * JD-Core Version:    0.7.0.1
 */