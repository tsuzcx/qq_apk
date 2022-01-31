package com.tencent.tavkit.utils;

import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class BenchUtil
{
  public static boolean ENABLE_DEBUG = false;
  private static final String TAG = "BenchUtil";
  private static Map<String, Long> endTimeMap;
  private static Map<String, Long> startTimeMap = new HashMap();
  
  static
  {
    endTimeMap = new HashMap();
  }
  
  public static long benchEnd(String paramString)
  {
    if ((ENABLE_DEBUG) && (!TextUtils.isEmpty(paramString)) && (startTimeMap != null))
    {
      Long localLong = (Long)startTimeMap.get(paramString);
      if (localLong == null) {
        return 0L;
      }
      long l = System.currentTimeMillis() - localLong.longValue();
      Log.d("BenchUtil", paramString + ", cost time: " + l);
      return l;
    }
    return 0L;
  }
  
  public static void benchStart(String paramString)
  {
    if ((ENABLE_DEBUG) && (!TextUtils.isEmpty(paramString))) {
      startTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
  }
  
  public static void clear()
  {
    startTimeMap.clear();
    endTimeMap.clear();
  }
  
  public static void setEnableDebugLog(boolean paramBoolean)
  {
    ENABLE_DEBUG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavkit.utils.BenchUtil
 * JD-Core Version:    0.7.0.1
 */