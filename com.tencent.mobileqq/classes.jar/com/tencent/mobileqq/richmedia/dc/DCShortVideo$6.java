package com.tencent.mobileqq.richmedia.dc;

import avwu;
import avxa;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(avwu paramavwu, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    avxa localavxa = new avxa();
    localavxa.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localavxa.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localavxa.b = this.b;
    localavxa.c = this.c;
    localavxa.d = this.d;
    localavxa.e = this.e;
    localavxa.f = this.f;
    localavxa.g = this.g;
    localavxa.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localavxa.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localavxa.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */