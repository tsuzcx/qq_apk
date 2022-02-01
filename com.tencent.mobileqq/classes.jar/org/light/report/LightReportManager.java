package org.light.report;

import java.util.HashMap;

public class LightReportManager
{
  private static LightReportInterface mLightReporter = null;
  
  public static native void LaunchFromApp(String paramString1, String paramString2);
  
  public static native void SetCommonParamsExternal(HashMap<String, String> paramHashMap);
  
  public static native String getShareKey();
  
  public static boolean lightReport(String paramString, HashMap<String, String> paramHashMap)
  {
    if (mLightReporter != null)
    {
      mLightReporter.report(paramString, paramHashMap);
      return true;
    }
    return false;
  }
  
  public static native void reportOutsideData(String paramString, HashMap<String, String> paramHashMap);
  
  public static void setReporter(LightReportInterface paramLightReportInterface)
  {
    mLightReporter = paramLightReportInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.report.LightReportManager
 * JD-Core Version:    0.7.0.1
 */