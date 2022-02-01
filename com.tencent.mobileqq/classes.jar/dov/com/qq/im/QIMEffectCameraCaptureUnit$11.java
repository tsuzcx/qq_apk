package dov.com.qq.im;

import android.view.View;
import android.widget.TextView;

class QIMEffectCameraCaptureUnit$11
  implements Runnable
{
  QIMEffectCameraCaptureUnit$11(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      QIMEffectCameraCaptureUnit.a(this.this$0).setVisibility(8);
      QIMEffectCameraCaptureUnit.c(this.this$0).setVisibility(8);
      QIMEffectCameraCaptureUnit.d(this.this$0).setVisibility(8);
      QIMEffectCameraCaptureUnit.e(this.this$0, false);
      return;
    }
    QIMEffectCameraCaptureUnit.a(this.this$0, QIMEffectCameraCaptureUnit.a(this.this$0), QIMEffectCameraCaptureUnit.b(this.this$0), QIMEffectCameraCaptureUnit.c(this.this$0), QIMEffectCameraCaptureUnit.d(this.this$0));
    QIMEffectCameraCaptureUnit.e(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.11
 * JD-Core Version:    0.7.0.1
 */