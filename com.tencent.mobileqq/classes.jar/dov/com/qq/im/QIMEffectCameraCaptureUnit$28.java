package dov.com.qq.im;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;

class QIMEffectCameraCaptureUnit$28
  implements Runnable
{
  QIMEffectCameraCaptureUnit$28(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.h(this.this$0, false);
    if (QIMEffectCameraCaptureUnit.a(this.this$0) == null) {
      return;
    }
    ((ViewGroup)this.this$0.jdField_a_of_type_AndroidViewView).removeView(QIMEffectCameraCaptureUnit.a(this.this$0));
    QIMEffectCameraCaptureUnit.c(this.this$0).setVisibility(0);
    QIMEffectCameraCaptureUnit.c(this.this$0).setEnabled(true);
    this.this$0.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.28
 * JD-Core Version:    0.7.0.1
 */