package com.tencent.qzonehub.api.report.impl;

import com.tencent.qzonehub.api.report.IQzoneExceptionReport;
import cooperation.qzone.util.QZoneExceptionReport;

public class QzoneExceptionReportImpl
  implements IQzoneExceptionReport
{
  public void doReport(Throwable paramThrowable, String paramString)
  {
    QZoneExceptionReport.doReport(paramThrowable, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.report.impl.QzoneExceptionReportImpl
 * JD-Core Version:    0.7.0.1
 */