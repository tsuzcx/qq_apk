package com.tencent.mobileqq.winkpublish.uploader.report;

import java.util.ArrayList;
import java.util.Random;

final class AUploadBusinessReport$1
  extends ArrayList<ReportObj>
{
  private final boolean a(ReportObj paramReportObj)
  {
    return (paramReportObj.m != 0) && (paramReportObj.m != -2);
  }
  
  public boolean add(ReportObj paramReportObj)
  {
    if (a(paramReportObj)) {
      return super.add(paramReportObj);
    }
    if ((AUploadBusinessReport.b().nextInt(Math.round(20.0F)) != 0) && (!AUploadBusinessReport.c())) {
      return false;
    }
    return super.add(paramReportObj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.uploader.report.AUploadBusinessReport.1
 * JD-Core Version:    0.7.0.1
 */