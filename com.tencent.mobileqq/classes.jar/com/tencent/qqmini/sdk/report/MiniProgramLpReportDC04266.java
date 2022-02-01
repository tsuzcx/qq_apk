package com.tencent.qqmini.sdk.report;

import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;

public class MiniProgramLpReportDC04266
{
  private static final String TAG = "MiniProgramLpReportDC04266";
  
  private static int getDcId4266()
  {
    return 3;
  }
  
  private static int getDcId5332()
  {
    return 14;
  }
  
  private static int getDcId5374()
  {
    return 13;
  }
  
  private static int getQualityDcId()
  {
    if ((QUAUtil.isQQApp()) || (QUAUtil.isMicroApp())) {
      return getDcId4266();
    }
    return getDcId5374();
  }
  
  public static void report(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong1, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    report(paramMiniAppInfo, paramInt1, paramString1, paramString2, paramString3, paramInt2, paramString4, paramLong1, paramString5, paramLong2, paramString6, paramString7, paramString8, paramString9, "");
  }
  
  public static void report(MiniAppInfo paramMiniAppInfo, int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, long paramLong1, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04266.1(paramInt1, paramMiniAppInfo, paramInt2, paramString2, paramLong2, paramLong1, paramString6, paramString7, paramString1, paramString3, paramString4, paramString5, paramString8, paramString9, paramString10));
  }
  
  public static void reportCostTimeEvent(MiniAppInfo paramMiniAppInfo, String paramString1, String paramString2, int paramInt, long paramLong1, long paramLong2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04266.2(paramMiniAppInfo, paramString1, paramString2, paramInt, paramLong1, paramLong2, paramString3, paramString4, paramString5, paramString6, paramString7));
  }
  
  private static boolean shouldFlushReportData(int paramInt)
  {
    return (paramInt == 20) || (paramInt == 22) || (paramInt == 605) || (paramInt == 1011) || (paramInt == 1024) || (paramInt == 1028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266
 * JD-Core Version:    0.7.0.1
 */