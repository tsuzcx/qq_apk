package com.tencent.mobileqq.richmedia.dc;

import badr;
import badx;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$6
  implements Runnable
{
  public DCShortVideo$6(badr parambadr, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    badx localbadx = new badx();
    localbadx.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localbadx.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localbadx.b = this.b;
    localbadx.c = this.c;
    localbadx.d = this.d;
    localbadx.e = this.e;
    localbadx.f = this.f;
    localbadx.g = this.g;
    localbadx.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localbadx.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localbadx.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */