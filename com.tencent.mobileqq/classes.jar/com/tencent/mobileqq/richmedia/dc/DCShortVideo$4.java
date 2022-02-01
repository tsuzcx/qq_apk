package com.tencent.mobileqq.richmedia.dc;

import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

class DCShortVideo$4
  implements Runnable
{
  DCShortVideo$4(DCShortVideo paramDCShortVideo, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new DCShortVideo.DCShortVideoSaveData();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (DCShortVideo.DCShortVideoReportData)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((DCShortVideo.DCShortVideoSaveData)localObject).f + ",uinType = " + ((DCShortVideo.DCShortVideoSaveData)localObject).b + ",groupMemCount = " + ((DCShortVideo.DCShortVideoSaveData)localObject).c + ",age = " + ((DCShortVideo.DCShortVideoSaveData)localObject).d + ",gender = " + ((DCShortVideo.DCShortVideoSaveData)localObject).e + ",reprotHour = " + ((DCShortVideo.DCShortVideoSaveData)localObject).g + ",netType = " + ((DCShortVideo.DCShortVideoSaveData)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((DCShortVideo.DCShortVideoSaveData)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */