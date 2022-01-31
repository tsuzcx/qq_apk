package com.tencent.mobileqq.richmedia.dc;

import auxb;
import auxe;
import auxf;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(auxb paramauxb, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new auxf();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (auxe)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((auxf)localObject).f + ",uinType = " + ((auxf)localObject).b + ",groupMemCount = " + ((auxf)localObject).c + ",age = " + ((auxf)localObject).d + ",gender = " + ((auxf)localObject).e + ",reprotHour = " + ((auxf)localObject).g + ",netType = " + ((auxf)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((auxf)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */