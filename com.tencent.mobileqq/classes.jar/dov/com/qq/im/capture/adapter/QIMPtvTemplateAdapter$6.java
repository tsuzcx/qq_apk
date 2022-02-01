package dov.com.qq.im.capture.adapter;

import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

class QIMPtvTemplateAdapter$6
  implements Runnable
{
  QIMPtvTemplateAdapter$6(QIMPtvTemplateAdapter paramQIMPtvTemplateAdapter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.a(this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoQIMPtvTemplateManager.getApp(), this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, QIMPtvTemplateAdapter.a(this.this$0));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */