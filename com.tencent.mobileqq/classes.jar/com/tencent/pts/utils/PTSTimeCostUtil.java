package com.tencent.pts.utils;

import java.util.HashMap;

public class PTSTimeCostUtil
{
  private static final String TAG = "PTSTimeCostUtil";
  private static HashMap<String, Long> sTimeCostMap = new HashMap();
  
  public static void end(String paramString)
  {
    paramString = (Long)sTimeCostMap.get(paramString);
    if (paramString != null)
    {
      System.currentTimeMillis();
      paramString.longValue();
    }
  }
  
  public static void start(String paramString)
  {
    sTimeCostMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSTimeCostUtil
 * JD-Core Version:    0.7.0.1
 */