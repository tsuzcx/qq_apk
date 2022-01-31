package dov.com.qq.im;

import android.widget.RelativeLayout;
import blqk;
import blqr;
import blra;
import bnpl;
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
    ((bnpl)blqr.a(3)).a("0", blra.b, "");
    blra.c = 0;
    this.this$0.jdField_a_of_type_Blqk.x();
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.24
 * JD-Core Version:    0.7.0.1
 */