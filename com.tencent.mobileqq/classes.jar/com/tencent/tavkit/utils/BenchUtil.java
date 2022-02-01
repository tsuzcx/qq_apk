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
    boolean bool = ENABLE_DEBUG;
    long l2 = 0L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject = startTimeMap;
        l1 = l2;
        if (localObject != null)
        {
          localObject = (Long)((Map)localObject).get(paramString);
          if (localObject == null) {
            return 0L;
          }
          l1 = System.currentTimeMillis() - ((Long)localObject).longValue();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append(", cost time: ");
          ((StringBuilder)localObject).append(l1);
          Log.d("BenchUtil", ((StringBuilder)localObject).toString());
        }
      }
    }
    return l1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavkit.utils.BenchUtil
 * JD-Core Version:    0.7.0.1
 */