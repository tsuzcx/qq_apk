package com.tencent.mobileqq.perf.report;

import java.util.Map;

public class FeatureFlag
{
  public static boolean a;
  
  public static void a(Map<String, String> paramMap)
  {
    if (a) {
      paramMap.put("rNatMem", String.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.perf.report.FeatureFlag
 * JD-Core Version:    0.7.0.1
 */