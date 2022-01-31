package com.tencent.mobileqq.richmedia.dc;

import avwu;
import avwx;
import avwy;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class DCShortVideo$4
  implements Runnable
{
  public DCShortVideo$4(avwu paramavwu, AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    Object localObject = new avwy();
    this.this$0.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangString, (avwx)localObject);
    if (QLog.isDevelopLevel()) {
      QLog.d("DCShortVideo", 4, "[reportSave]shortVideoType=" + ((avwy)localObject).f + ",uinType = " + ((avwy)localObject).b + ",groupMemCount = " + ((avwy)localObject).c + ",age = " + ((avwy)localObject).d + ",gender = " + ((avwy)localObject).e + ",reprotHour = " + ((avwy)localObject).g + ",netType = " + ((avwy)localObject).h);
    }
    localObject = new DataReport.ReportTask("ShortVideo.Save", ((avwy)localObject).a("ShortVideo.Save"));
    DataReport.a().a((DataReport.ReportTask)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCShortVideo.4
 * JD-Core Version:    0.7.0.1
 */