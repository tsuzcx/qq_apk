package dov.com.qq.im;

import android.widget.RelativeLayout;
import bplj;
import bplq;
import bplz;
import brhn;
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
    ((brhn)bplq.a(3)).a("0", bplz.b, "");
    bplz.c = 0;
    this.this$0.jdField_a_of_type_Bplj.x();
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.24
 * JD-Core Version:    0.7.0.1
 */