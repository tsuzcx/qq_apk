package com.tencent.mobileqq.mini.api.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IMiniReport
  extends QRouteApi
{
  public abstract String getCrashReportAppInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.api.report.IMiniReport
 * JD-Core Version:    0.7.0.1
 */