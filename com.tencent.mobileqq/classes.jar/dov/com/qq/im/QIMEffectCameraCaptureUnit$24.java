package dov.com.qq.im;

import android.widget.RelativeLayout;
import bjao;
import bjav;
import bjbe;
import bkzp;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

class QIMEffectCameraCaptureUnit$24
  implements Runnable
{
  QIMEffectCameraCaptureUnit$24(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.a) && (QIMEffectCameraCaptureUnit.e(this.this$0)))
    {
      this.this$0.l = true;
      QIMEffectCameraCaptureUnit.c(this.this$0);
    }
    if (this.this$0.d) {
      this.this$0.b.setVisibility(0);
    }
    ((bkzp)bjav.a(3)).a("0", bjbe.b, "");
    bjbe.c = 0;
    this.this$0.jdField_a_of_type_Bjao.x();
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.24
 * JD-Core Version:    0.7.0.1
 */