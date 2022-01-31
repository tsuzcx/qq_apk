package dov.com.qq.im;

import bbmy;
import bhdi;
import com.tencent.common.app.BaseApplicationImpl;
import dov.com.tencent.mobileqq.richmedia.capture.view.QIMCameraCaptureButtonLayout;

public class QIMCameraCaptureUnit$5
  implements Runnable
{
  public QIMCameraCaptureUnit$5(bhdi parambhdi) {}
  
  public void run()
  {
    bbmy.a(BaseApplicationImpl.getContext(), this.this$0.jdField_a_of_type_JavaLangString, 0).a();
    if (this.this$0.h) {
      this.this$0.L();
    }
    if (this.this$0.b == 5) {
      this.this$0.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewQIMCameraCaptureButtonLayout.setVisibility(0);
    }
    for (;;)
    {
      this.this$0.N();
      return;
      this.this$0.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMCameraCaptureUnit.5
 * JD-Core Version:    0.7.0.1
 */