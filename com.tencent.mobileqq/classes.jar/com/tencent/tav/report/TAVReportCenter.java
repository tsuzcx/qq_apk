package com.tencent.tav.report;

import android.content.Context;
import com.tencent.camerasdk.avreporter.AVReportCenter;

public class TAVReportCenter
{
  public static final String REPORT_VERSION = "2.2.2.5";
  
  public static void init(Context paramContext)
  {
    AVReportCenter.getInstance().init(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.report.TAVReportCenter
 * JD-Core Version:    0.7.0.1
 */