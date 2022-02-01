package com.tencent.mobileqq.richmedia.dc;

import bbjw;
import bbjy;
import bbjz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(bbjw parambbjw, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new bbjy();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (bbjz)localObject);
    ((bbjy)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((bbjy)localObject).f + ",uinType = " + ((bbjy)localObject).b + ",groupMemCount = " + ((bbjy)localObject).c + ",age = " + ((bbjy)localObject).d + ",gender = " + ((bbjy)localObject).e + ",reprotHour = " + ((bbjy)localObject).g + ",netType = " + ((bbjy)localObject).h + ",playAction = " + ((bbjy)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((bbjy)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */