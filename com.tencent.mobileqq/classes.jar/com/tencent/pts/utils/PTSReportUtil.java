package com.tencent.pts.utils;

public class PTSReportUtil
{
  public static final int REPORT_TYPE_ERROR = 1;
  public static final int REPORT_TYPE_INFO = 0;
  private static final String TAG = "PTSReportUtil";
  private static PTSReportUtil.IPTSReport sPtsReport;
  
  public static void registerPtsReport(PTSReportUtil.IPTSReport paramIPTSReport)
  {
    if (paramIPTSReport != null) {
      sPtsReport = paramIPTSReport;
    }
  }
  
  public static void reportEvent(String paramString1, String paramString2, int paramInt)
  {
    if (sPtsReport != null) {
      sPtsReport.reportEvent(paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.utils.PTSReportUtil
 * JD-Core Version:    0.7.0.1
 */