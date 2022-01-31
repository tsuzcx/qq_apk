package com.tencent.pts.utils;

import java.util.HashMap;

public class PTSTimeCostUtil
{
  private static final String TAG = "PTSTimeCostUtil";
  private static HashMap<String, Long> sTimeCostMap = new HashMap();
  
  public static void end(String paramString)
  {
    Long localLong = (Long)sTimeCostMap.get(paramString);
    if (localLong != null) {}
    for (long l = System.currentTimeMillis() - localLong.longValue();; l = 0L)
    {
      PTSLog.d("PTSTimeCostUtil", "tag: " + paramString + ", end! timeCost = " + l);
      return;
    }
  }
  
  public static void start(String paramString)
  {
    PTSLog.d("PTSTimeCostUtil", "tag: " + paramString + ", begin!");
    sTimeCostMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSTimeCostUtil
 * JD-Core Version:    0.7.0.1
 */