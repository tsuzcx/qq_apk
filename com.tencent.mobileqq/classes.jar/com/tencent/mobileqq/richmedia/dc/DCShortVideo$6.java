package com.tencent.mobileqq.richmedia.dc;

import bard;
import barj;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(bard parambard, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    barj localbarj = new barj();
    localbarj.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbarj.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbarj.b = this.b;
    localbarj.c = this.c;
    localbarj.d = this.d;
    localbarj.e = this.e;
    localbarj.f = this.f;
    localbarj.g = this.g;
    localbarj.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localbarj.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localbarj.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */