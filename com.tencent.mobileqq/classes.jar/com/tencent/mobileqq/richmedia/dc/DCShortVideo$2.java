package com.tencent.mobileqq.richmedia.dc;

import axot;
import axov;
import axow;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(axot paramaxot, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new axov();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (axow)localObject);
    ((axov)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((axov)localObject).f + ",uinType = " + ((axov)localObject).b + ",groupMemCount = " + ((axov)localObject).c + ",age = " + ((axov)localObject).d + ",gender = " + ((axov)localObject).e + ",reprotHour = " + ((axov)localObject).g + ",netType = " + ((axov)localObject).h + ",playAction = " + ((axov)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((axov)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */