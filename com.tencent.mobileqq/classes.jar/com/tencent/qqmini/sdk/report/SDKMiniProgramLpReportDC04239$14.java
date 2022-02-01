package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.entry.MiniAppExposureManager.BaseExposureReport;
import java.util.Iterator;
import java.util.List;

final class SDKMiniProgramLpReportDC04239$14
  implements Runnable
{
  SDKMiniProgramLpReportDC04239$14(List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.val$appConfigList.iterator();
    while (localIterator.hasNext())
    {
      MiniAppExposureManager.BaseExposureReport localBaseExposureReport = (MiniAppExposureManager.BaseExposureReport)localIterator.next();
      if (localBaseExposureReport != null) {
        localBaseExposureReport.report();
      }
    }
    MiniProgramReporter.getInstance().flush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239.14
 * JD-Core Version:    0.7.0.1
 */