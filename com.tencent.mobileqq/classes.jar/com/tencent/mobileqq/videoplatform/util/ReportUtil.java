package com.tencent.mobileqq.videoplatform.util;

import com.tencent.mobileqq.videoplatform.api.IReport;
import com.tencent.mobileqq.videoplatform.imp.ReportImp;
import java.util.HashMap;

public class ReportUtil
{
  private static IReport sReportImp = new ReportImp();
  
  public static void report(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    sReportImp.report(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void setReportImp(IReport paramIReport)
  {
    sReportImp = paramIReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.util.ReportUtil
 * JD-Core Version:    0.7.0.1
 */