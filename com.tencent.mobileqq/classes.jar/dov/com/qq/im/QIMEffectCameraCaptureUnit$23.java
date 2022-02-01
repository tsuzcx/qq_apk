package dov.com.qq.im;

import android.os.Handler;
import android.widget.TextView;

class QIMEffectCameraCaptureUnit$23
  implements Runnable
{
  QIMEffectCameraCaptureUnit$23(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.c(this.this$0);
    this.this$0.a.removeCallbacks(QIMEffectCameraCaptureUnit.a(this.this$0));
    QIMEffectCameraCaptureUnit.g(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.23
 * JD-Core Version:    0.7.0.1
 */