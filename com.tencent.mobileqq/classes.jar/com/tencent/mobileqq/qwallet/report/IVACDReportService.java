package com.tencent.mobileqq.qwallet.report;

import VACDReport.ReportHeader;
import VACDReport.ReportItem;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface IVACDReportService
  extends IRuntimeService
{
  public static final String TAG = "VACDReport";
  
  public abstract void addReportItem(long paramLong, String paramString, ReportItem paramReportItem);
  
  public abstract void endReport(long paramLong, ReportItem paramReportItem);
  
  public abstract void singleReport(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem);
  
  public abstract void startReport(String paramString, ReportHeader paramReportHeader, ReportItem paramReportItem);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.IVACDReportService
 * JD-Core Version:    0.7.0.1
 */