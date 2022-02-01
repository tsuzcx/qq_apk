package com.tencent.mobileqq.richmedia.dc;

import bbjw;
import bbjz;
import bbka;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(bbjw parambbjw, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new bbka();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (bbjz)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((bbka)localObject).f + ",uinType = " + ((bbka)localObject).b + ",groupMemCount = " + ((bbka)localObject).c + ",age = " + ((bbka)localObject).d + ",gender = " + ((bbka)localObject).e + ",reprotHour = " + ((bbka)localObject).g + ",netType = " + ((bbka)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((bbka)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */