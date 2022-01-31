package dov.com.qq.im;

import android.os.Handler;

class QIMEffectCameraCaptureUnit$ReplayTips
  implements Runnable
{
  private QIMEffectCameraCaptureUnit$ReplayTips(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.b(this.this$0);
    if (QIMEffectCameraCaptureUnit.a(this.this$0) >= 3) {
      QIMEffectCameraCaptureUnit.a(this.this$0, 0);
    }
    QIMEffectCameraCaptureUnit.a(this.this$0, QIMEffectCameraCaptureUnit.a(this.this$0));
    this.this$0.a.postDelayed(QIMEffectCameraCaptureUnit.a(this.this$0), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.ReplayTips
 * JD-Core Version:    0.7.0.1
 */