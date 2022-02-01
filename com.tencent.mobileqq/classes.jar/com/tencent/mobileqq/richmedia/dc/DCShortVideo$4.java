package com.tencent.mobileqq.richmedia.dc;

import badr;
import badu;
import badv;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(badr parambadr, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new badv();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (badu)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((badv)localObject).f + ",uinType = " + ((badv)localObject).b + ",groupMemCount = " + ((badv)localObject).c + ",age = " + ((badv)localObject).d + ",gender = " + ((badv)localObject).e + ",reprotHour = " + ((badv)localObject).g + ",netType = " + ((badv)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((badv)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */