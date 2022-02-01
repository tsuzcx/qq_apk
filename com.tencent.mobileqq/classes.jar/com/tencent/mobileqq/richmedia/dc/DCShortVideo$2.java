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
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[reportPreview]shortVideoType=");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).f);
      localStringBuilder.append(",uinType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).b);
      localStringBuilder.append(",groupMemCount = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).c);
      localStringBuilder.append(",age = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).d);
      localStringBuilder.append(",gender = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).e);
      localStringBuilder.append(",reprotHour = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).g);
      localStringBuilder.append(",netType = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).h);
      localStringBuilder.append(",playAction = ");
      localStringBuilder.append(((DCShortVideo.DCShortVideoPreviewData)localObject).jdField_a_of_type_Int);
      QLog.d("DCShortVideo", 4, localStringBuilder.toString());
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((DCShortVideo.DCShortVideoPreviewData)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */