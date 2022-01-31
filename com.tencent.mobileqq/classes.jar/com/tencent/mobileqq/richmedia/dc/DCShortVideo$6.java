package com.tencent.mobileqq.richmedia.dc;

import axot;
import axoz;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(axot paramaxot, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    axoz localaxoz = new axoz();
    localaxoz.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localaxoz.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaxoz.b = this.b;
    localaxoz.c = this.c;
    localaxoz.d = this.d;
    localaxoz.e = this.e;
    localaxoz.f = this.f;
    localaxoz.g = this.g;
    localaxoz.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localaxoz.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localaxoz.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */