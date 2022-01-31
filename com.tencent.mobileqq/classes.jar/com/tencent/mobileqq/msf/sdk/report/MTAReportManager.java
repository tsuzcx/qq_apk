package com.tencent.mobileqq.msf.sdk.report;

public class MTAReportManager
{
  public static final String TAG = "MTAReport";
  private static IMTAReporter sMtaReporter;
  
  public static IMTAReporter getMtaReporter()
  {
    return sMtaReporter;
  }
  
  public static void setMTAReporter(IMTAReporter paramIMTAReporter)
  {
    if ((paramIMTAReporter != null) && (paramIMTAReporter.isMtaSupported())) {
      sMtaReporter = paramIMTAReporter;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.MTAReportManager
 * JD-Core Version:    0.7.0.1
 */