package com.tencent.mobileqq.richmedia.dc;

import bbjw;
import bbkd;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$5
  implements Runnable
{
  public DCShortVideo$5(bbjw parambbjw, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    bbkd localbbkd = new bbkd();
    localbbkd.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbbkd.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("RealShortVideo.Record", localbbkd.a("RealShortVideo.Record"));
    DataReport.a().a(localReportTask);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localbbkd.jdField_a_of_type_Int + ",hasMultiSegments=" + localbbkd.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.5
 * JD-Core Version:    0.7.0.1
 */