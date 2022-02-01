package com.tencent.mobileqq.richmedia.dc;

import bbkg;
import bbkm;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(bbkg parambbkg, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    bbkm localbbkm = new bbkm();
    localbbkm.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbbkm.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbbkm.b = this.b;
    localbbkm.c = this.c;
    localbbkm.d = this.d;
    localbbkm.e = this.e;
    localbbkm.f = this.f;
    localbbkm.g = this.g;
    localbbkm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localbbkm.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localbbkm.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */