package com.tencent.mobileqq.mini.report;

import android.os.Handler;

public class MiniProgramLpReportDC04884
{
  private static final String TAG = "MiniProgramLpReportDC04";
  
  public static void reportApiReport(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    MiniProgramReporter.getInstance().getReportHandler().post(new MiniProgramLpReportDC04884.1(paramString1, paramString3, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04884
 * JD-Core Version:    0.7.0.1
 */