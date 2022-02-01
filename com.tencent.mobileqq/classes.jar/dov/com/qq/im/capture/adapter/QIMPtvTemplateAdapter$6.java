package dov.com.qq.im.capture.adapter;

import bmqu;
import boba;
import com.tencent.qphone.base.util.QLog;

public class QIMPtvTemplateAdapter$6
  implements Runnable
{
  public QIMPtvTemplateAdapter$6(bmqu parambmqu) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.this$0.jdField_a_of_type_Boba.a(this.this$0.jdField_a_of_type_Boba.getApp(), this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, bmqu.a(this.this$0));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */