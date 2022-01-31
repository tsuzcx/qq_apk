package com.tencent.mobileqq.richmedia.dc;

import avwu;
import avww;
import avwx;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$2
  implements Runnable
{
  public DCShortVideo$2(avwu paramavwu, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, String paramString, int paramInt3) {}
  
  public void run()
  {
    Object localObject = new avww();
    this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (avwx)localObject);
    ((avww)localObject).jdField_a_of_type_Int = this.c;
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportPreview]shortVideoType=" + ((avww)localObject).f + ",uinType = " + ((avww)localObject).b + ",groupMemCount = " + ((avww)localObject).c + ",age = " + ((avww)localObject).d + ",gender = " + ((avww)localObject).e + ",reprotHour = " + ((avww)localObject).g + ",netType = " + ((avww)localObject).h + ",playAction = " + ((avww)localObject).jdField_a_of_type_Int);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Preview", ((avww)localObject).a("ShortVideo.Preview"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.2
 * JD-Core Version:    0.7.0.1
 */