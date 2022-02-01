package com.tencent.mobileqq.richmedia.dc;

import bard;
import barg;
import barh;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(bard parambard, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new barh();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (barg)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((barh)localObject).f + ",uinType = " + ((barh)localObject).b + ",groupMemCount = " + ((barh)localObject).c + ",age = " + ((barh)localObject).d + ",gender = " + ((barh)localObject).e + ",reprotHour = " + ((barh)localObject).g + ",netType = " + ((barh)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((barh)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */