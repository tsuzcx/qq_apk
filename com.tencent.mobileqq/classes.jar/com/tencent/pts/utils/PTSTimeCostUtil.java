package com.tencent.pts.utils;

import java.util.HashMap;

public class PTSTimeCostUtil
{
  private static final String TAG = "PTSTimeCostUtil";
  private static HashMap<String, Long> sTimeCostMap = new HashMap();
  
  public static void end(String paramString)
  {
    Object localObject = (Long)sTimeCostMap.get(paramString);
    long l;
    if (localObject != null) {
      l = System.currentTimeMillis() - ((Long)localObject).longValue();
    } else {
      l = 0L;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("tag: ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", end! timeCost = ");
    ((StringBuilder)localObject).append(l);
    PTSLog.d("PTSTimeCostUtil", ((StringBuilder)localObject).toString());
  }
  
  public static void start(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tag: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", begin!");
    PTSLog.d("PTSTimeCostUtil", localStringBuilder.toString());
    sTimeCostMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.utils.PTSTimeCostUtil
 * JD-Core Version:    0.7.0.1
 */