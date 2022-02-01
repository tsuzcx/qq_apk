package com.tencent.mobileqq.richmedia.dc;

import bbkg;
import bbkn;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$5
  implements Runnable
{
  public DCShortVideo$5(bbkg parambbkg, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    bbkn localbbkn = new bbkn();
    localbbkn.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbbkn.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("RealShortVideo.Record", localbbkn.a("RealShortVideo.Record"));
    DataReport.a().a(localReportTask);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localbbkn.jdField_a_of_type_Int + ",hasMultiSegments=" + localbbkn.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.5
 * JD-Core Version:    0.7.0.1
 */