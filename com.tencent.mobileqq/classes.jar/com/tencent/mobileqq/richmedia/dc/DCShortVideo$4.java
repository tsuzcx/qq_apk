package com.tencent.mobileqq.richmedia.dc;

import axot;
import axow;
import axox;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(axot paramaxot, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new axox();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (axow)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((axox)localObject).f + ",uinType = " + ((axox)localObject).b + ",groupMemCount = " + ((axox)localObject).c + ",age = " + ((axox)localObject).d + ",gender = " + ((axox)localObject).e + ",reprotHour = " + ((axox)localObject).g + ",netType = " + ((axox)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((axox)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */