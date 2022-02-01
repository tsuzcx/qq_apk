package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;

class DCShortVideo$5
  implements Runnable
{
  DCShortVideo$5(DCShortVideo paramDCShortVideo, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    DCShortVideo.RecordData localRecordData = new DCShortVideo.RecordData();
    localRecordData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localRecordData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    DataReport.ReportTask localReportTask = new DataReport.ReportTask("RealShortVideo.Record", localRecordData.a("RealShortVideo.Record"));
    DataReport.a().a(localReportTask);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "cameraID=" + localRecordData.jdField_a_of_type_Int + ",hasMultiSegments=" + localRecordData.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.5
 * JD-Core Version:    0.7.0.1
 */