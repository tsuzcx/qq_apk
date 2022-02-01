package com.tencent.mobileqq.richmedia.dc;

import com.tencent.qphone.base.util.QLog;

class DCShortVideo$5
  implements Runnable
{
  public void run()
  {
    DCShortVideo.RecordData localRecordData = new DCShortVideo.RecordData();
    localRecordData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localRecordData.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    Object localObject = new DataReport.ReportTask("RealShortVideo.Record", localRecordData.a("RealShortVideo.Record"));
    DataReport.a().a((DataReport.ReportTask)localObject);
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cameraID=");
      ((StringBuilder)localObject).append(localRecordData.jdField_a_of_type_Int);
      ((StringBuilder)localObject).append(",hasMultiSegments=");
      ((StringBuilder)localObject).append(localRecordData.jdField_a_of_type_Boolean);
      QLog.d("DCShortVideo", 4, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.5
 * JD-Core Version:    0.7.0.1
 */