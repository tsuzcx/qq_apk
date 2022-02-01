package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;

class DCShortVideo$6
  implements Runnable
{
  DCShortVideo$6(DCShortVideo paramDCShortVideo, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong) {}
  
  public void run()
  {
    DCShortVideo.ProgressivePlayData localProgressivePlayData = new DCShortVideo.ProgressivePlayData();
    localProgressivePlayData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localProgressivePlayData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localProgressivePlayData.b = this.b;
    localProgressivePlayData.c = this.c;
    localProgressivePlayData.d = this.d;
    localProgressivePlayData.e = this.e;
    localProgressivePlayData.f = this.f;
    localProgressivePlayData.g = this.g;
    localProgressivePlayData.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("actStreamingVideoPlay", localProgressivePlayData.a("actStreamingVideoPlay"));
    DataReport.a().a(localReportTask);
    if (QLog.isColorLevel()) {
      QLog.d("DCShortVideo", 2, "reportProgressivePlayData():" + localProgressivePlayData.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.6
 * JD-Core Version:    0.7.0.1
 */