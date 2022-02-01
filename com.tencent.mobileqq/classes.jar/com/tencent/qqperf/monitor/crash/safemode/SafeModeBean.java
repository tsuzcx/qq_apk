package com.tencent.qqperf.monitor.crash.safemode;

import org.json.JSONObject;

public class SafeModeBean
{
  public boolean a;
  
  public static SafeModeBean a(String paramString)
  {
    SafeModeBean localSafeModeBean = new SafeModeBean();
    try
    {
      localSafeModeBean.a = new JSONObject(paramString).optBoolean("test_crash_enabled", false);
      return localSafeModeBean;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.safemode.SafeModeBean
 * JD-Core Version:    0.7.0.1
 */