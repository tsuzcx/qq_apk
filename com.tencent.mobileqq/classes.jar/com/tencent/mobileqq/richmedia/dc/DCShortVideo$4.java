package com.tencent.mobileqq.richmedia.dc;

import axtc;
import axtf;
import axtg;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(axtc paramaxtc, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new axtg();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (axtf)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((axtg)localObject).f + ",uinType = " + ((axtg)localObject).b + ",groupMemCount = " + ((axtg)localObject).c + ",age = " + ((axtg)localObject).d + ",gender = " + ((axtg)localObject).e + ",reprotHour = " + ((axtg)localObject).g + ",netType = " + ((axtg)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((axtg)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */