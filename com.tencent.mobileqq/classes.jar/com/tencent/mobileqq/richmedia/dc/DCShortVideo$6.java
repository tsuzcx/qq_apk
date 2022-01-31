package com.tencent.mobileqq.richmedia.dc;

import axtc;
import axti;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(axtc paramaxtc, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    axti localaxti = new axti();
    localaxti.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localaxti.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localaxti.b = this.b;
    localaxti.c = this.c;
    localaxti.d = this.d;
    localaxti.e = this.e;
    localaxti.f = this.f;
    localaxti.g = this.g;
    localaxti.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localaxti.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localaxti.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */