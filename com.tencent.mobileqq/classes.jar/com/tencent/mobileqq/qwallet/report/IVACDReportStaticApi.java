package com.tencent.mobileqq.qwallet.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IVACDReportStaticApi
  extends QRouteApi
{
  public abstract void addReportItem(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  
  public abstract void checkReportsTimeOut();
  
  public abstract void endReport(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void singleReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6);
  
  public abstract long startReport(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt, String paramString6, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.report.IVACDReportStaticApi
 * JD-Core Version:    0.7.0.1
 */