package com.tencent.mobileqq.richmedia.dc;

import bbkg;
import bbki;
import bbkj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(bbkg parambbkg, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new bbki();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (bbkj)localObject);
    ((bbki)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((bbki)localObject).f + ",uinType = " + ((bbki)localObject).b + ",groupMemCount = " + ((bbki)localObject).c + ",age = " + ((bbki)localObject).d + ",gender = " + ((bbki)localObject).e + ",reprotHour = " + ((bbki)localObject).g + ",netType = " + ((bbki)localObject).h + ",playAction = " + ((bbki)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((bbki)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */