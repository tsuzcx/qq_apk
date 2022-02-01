package dov.com.qq.im;

import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

class QIMEffectCameraCaptureUnit$21
  implements Runnable
{
  QIMEffectCameraCaptureUnit$21(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.c(this.this$0).setVisibility(8);
    QIMEffectCameraCaptureUnit.c(this.this$0).setEnabled(false);
    QIMEffectCameraCaptureUnit.a(this.this$0, 0);
    QIMEffectCameraCaptureUnit.a(this.this$0, QIMEffectCameraCaptureUnit.a(this.this$0));
    QIMEffectCameraCaptureUnit.g(this.this$0).setVisibility(0);
    this.this$0.a.postDelayed(QIMEffectCameraCaptureUnit.a(this.this$0), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.21
 * JD-Core Version:    0.7.0.1
 */