package com.tencent.qzonehub.api.report;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQzoneExceptionReport
  extends QRouteApi
{
  public abstract void doReport(Throwable paramThrowable, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.IQzoneExceptionReport
 * JD-Core Version:    0.7.0.1
 */