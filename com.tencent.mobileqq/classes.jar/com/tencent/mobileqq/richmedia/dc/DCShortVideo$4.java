package com.tencent.mobileqq.richmedia.dc;

import avws;
import avwv;
import avww;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(avws paramavws, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new avww();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (avwv)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((avww)localObject).f + ",uinType = " + ((avww)localObject).b + ",groupMemCount = " + ((avww)localObject).c + ",age = " + ((avww)localObject).d + ",gender = " + ((avww)localObject).e + ",reprotHour = " + ((avww)localObject).g + ",netType = " + ((avww)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((avww)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */