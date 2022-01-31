package com.tencent.mobileqq.mini.report;

import android.os.Handler;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

public class MiniProgramLpReportDC04266
{
  private static final String TAG = "MiniProgramLpReportDC04266";
  private static final boolean VERBOSE = false;
  
  public static void report(MiniAppConfig paramMiniAppConfig, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong1, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04266.1(paramInt1, paramMiniAppConfig, paramInt2, paramString2, paramLong2, paramLong1, paramString1, paramString3, paramString4, paramString5, paramString6, paramString7, paramString8, paramString9));
  }
  
  public static void reportCostTimeEvent(MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04266.2(paramMiniAppConfig, paramString1, paramString2, paramInt, paramLong1, paramLong2, paramString3, paramString4, paramString5, paramString6));
  }
  
  private static boolean shouldFlushReportData(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 22) || (paramInt == 605) || (paramInt == 1011) || (paramInt == 1024) || (paramInt == 1028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266
 * JD-Core Version:    0.7.0.1
 */