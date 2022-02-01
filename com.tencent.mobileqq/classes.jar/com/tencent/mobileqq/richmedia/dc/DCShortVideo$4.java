package com.tencent.mobileqq.richmedia.dc;

import bbkg;
import bbkj;
import bbkk;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(bbkg parambbkg, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new bbkk();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (bbkj)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((bbkk)localObject).f + ",uinType = " + ((bbkk)localObject).b + ",groupMemCount = " + ((bbkk)localObject).c + ",age = " + ((bbkk)localObject).d + ",gender = " + ((bbkk)localObject).e + ",reprotHour = " + ((bbkk)localObject).g + ",netType = " + ((bbkk)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((bbkk)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */