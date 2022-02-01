package com.tencent.qzonehub.api.report.wmd;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IWMDReport
  extends QRouteApi
{
  public abstract int getReportCount();
  
  public abstract String getReportId();
  
  public abstract int getReportTime();
  
  public abstract void loadConfig();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.wmd.IWMDReport
 * JD-Core Version:    0.7.0.1
 */