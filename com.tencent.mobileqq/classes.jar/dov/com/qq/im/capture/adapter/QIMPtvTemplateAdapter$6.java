package dov.com.qq.im.capture.adapter;

import bjan;
import bkyy;
import com.tencent.qphone.base.util.QLog;

public class QIMPtvTemplateAdapter$6
  implements Runnable
{
  public QIMPtvTemplateAdapter$6(bjan parambjan) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.this$0.jdField_a_of_type_Bkyy.a(this.this$0.jdField_a_of_type_Bkyy.a(), this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, bjan.a(this.this$0));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */