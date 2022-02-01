package com.tencent.mobileqq.richmedia.dc;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class DCShortVideo$2
  implements Runnable
{
  DCShortVideo$2(DCShortVideo paramDCShortVideo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new DCShortVideo.DCShortVideoPreviewData();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (DCShortVideo.DCShortVideoReportData)localObject);
    ((DCShortVideo.DCShortVideoPreviewData)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((DCShortVideo.DCShortVideoPreviewData)localObject).f + ",uinType = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).b + ",groupMemCount = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).c + ",age = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).d + ",gender = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).e + ",reprotHour = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).g + ",netType = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).h + ",playAction = " + ((DCShortVideo.DCShortVideoPreviewData)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((DCShortVideo.DCShortVideoPreviewData)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */