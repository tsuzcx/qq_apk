package com.tencent.mobileqq.richmedia.dc;

import bbjw;
import bbkc;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(bbjw parambbjw, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    bbkc localbbkc = new bbkc();
    localbbkc.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbbkc.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbbkc.b = this.b;
    localbbkc.c = this.c;
    localbbkc.d = this.d;
    localbbkc.e = this.e;
    localbbkc.f = this.f;
    localbbkc.g = this.g;
    localbbkc.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localbbkc.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localbbkc.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */