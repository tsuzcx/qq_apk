package com.tencent.mobileqq.richmedia.dc;

import auxb;
import auxh;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(auxb paramauxb, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    auxh localauxh = new auxh();
    localauxh.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localauxh.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localauxh.b = this.b;
    localauxh.c = this.c;
    localauxh.d = this.d;
    localauxh.e = this.e;
    localauxh.f = this.f;
    localauxh.g = this.g;
    localauxh.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localauxh.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localauxh.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */