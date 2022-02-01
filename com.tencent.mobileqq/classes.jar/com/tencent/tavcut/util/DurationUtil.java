package com.tencent.tavcut.util;

import java.util.HashMap;
import java.util.Map;

public class DurationUtil
{
  private static final String TAG = "DurationUtil";
  public static boolean enableLog = false;
  private static Map<String, Long> timeMap = new HashMap();
  
  public static void end(String paramString)
  {
    if ((enableLog) && (timeMap.containsKey(paramString))) {
      Logger.i(TAG, String.format("** %s end ** duration = %d", new Object[] { paramString, Long.valueOf(System.currentTimeMillis() - ((Long)timeMap.get(paramString)).longValue()) }));
    }
  }
  
  public static void start(String paramString)
  {
    if (enableLog)
    {
      timeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      Logger.i(TAG, String.format("** %s start **", new Object[] { paramString }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.util.DurationUtil
 * JD-Core Version:    0.7.0.1
 */