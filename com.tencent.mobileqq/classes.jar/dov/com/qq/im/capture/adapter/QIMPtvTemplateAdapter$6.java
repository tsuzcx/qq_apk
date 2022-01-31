package dov.com.qq.im.capture.adapter;

import blmo;
import bnkz;
import com.tencent.qphone.base.util.QLog;

public class QIMPtvTemplateAdapter$6
  implements Runnable
{
  public QIMPtvTemplateAdapter$6(blmo paramblmo) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMPtvTemplateManager", 2, "start download template runnable");
    }
    this.this$0.jdField_a_of_type_Bnkz.a(this.this$0.jdField_a_of_type_Bnkz.a(), this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo, blmo.a(this.this$0));
    this.this$0.jdField_a_of_type_DovComTencentMobileqqShortvideoPtvTemplateManager$PtvTemplateInfo.downloading = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter.6
 * JD-Core Version:    0.7.0.1
 */