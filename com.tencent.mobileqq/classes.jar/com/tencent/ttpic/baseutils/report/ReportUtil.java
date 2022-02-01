package com.tencent.ttpic.baseutils.report;

public class ReportUtil
{
  private static ReportUtil.ReportListener listener;
  
  public static void report(String paramString)
  {
    ReportUtil.ReportListener localReportListener = listener;
    if (localReportListener != null) {
      localReportListener.report(paramString);
    }
  }
  
  public static void setListener(ReportUtil.ReportListener paramReportListener)
  {
    listener = paramReportListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.report.ReportUtil
 * JD-Core Version:    0.7.0.1
 */