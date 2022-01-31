package com.tencent.txproxy;

import com.tencent.proxyinner.report.DataReport;

public class DataReportWrapper
{
  public static DataReport getDataReport(String paramString)
  {
    return DataReport.getInstance(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.txproxy.DataReportWrapper
 * JD-Core Version:    0.7.0.1
 */