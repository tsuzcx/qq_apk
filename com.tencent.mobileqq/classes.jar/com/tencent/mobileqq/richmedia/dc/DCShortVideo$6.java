package com.tencent.mobileqq.richmedia.dc;

import avws;
import avwy;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(avws paramavws, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    avwy localavwy = new avwy();
    localavwy.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localavwy.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localavwy.b = this.b;
    localavwy.c = this.c;
    localavwy.d = this.d;
    localavwy.e = this.e;
    localavwy.f = this.f;
    localavwy.g = this.g;
    localavwy.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localavwy.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localavwy.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */