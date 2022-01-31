package com.tencent.mobileqq.richmedia.dc;

import auxb;
import auxd;
import auxe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(auxb paramauxb, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new auxd();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (auxe)localObject);
    ((auxd)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((auxd)localObject).f + ",uinType = " + ((auxd)localObject).b + ",groupMemCount = " + ((auxd)localObject).c + ",age = " + ((auxd)localObject).d + ",gender = " + ((auxd)localObject).e + ",reprotHour = " + ((auxd)localObject).g + ",netType = " + ((auxd)localObject).h + ",playAction = " + ((auxd)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((auxd)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */