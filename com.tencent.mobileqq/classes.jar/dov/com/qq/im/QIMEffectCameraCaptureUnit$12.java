package dov.com.qq.im;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;

class QIMEffectCameraCaptureUnit$12
  implements Runnable
{
  QIMEffectCameraCaptureUnit$12(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (!this.a)
    {
      this.this$0.a.setAnimationListener(null);
      this.this$0.b.setAnimationListener(null);
      this.this$0.b.cancel();
      this.this$0.a.cancel();
      QIMEffectCameraCaptureUnit.e(this.this$0).clearAnimation();
      QIMEffectCameraCaptureUnit.e(this.this$0).setVisibility(8);
      this.this$0.v = false;
      return;
    }
    this.this$0.b.reset();
    this.this$0.a.reset();
    this.this$0.v = true;
    QIMEffectCameraCaptureUnit.e(this.this$0).setVisibility(0);
    QIMEffectCameraCaptureUnit.e(this.this$0).setText(2131699480);
    AlphaAnimation localAlphaAnimation = this.this$0.a;
    Object localObject;
    if (this.b)
    {
      localObject = QIMEffectCameraCaptureUnit.a(this.this$0);
      localAlphaAnimation.setAnimationListener((Animation.AnimationListener)localObject);
      localObject = this.this$0.a;
      if (!this.b) {
        break label224;
      }
    }
    label224:
    for (long l = 2000L;; l = 3000L)
    {
      ((AlphaAnimation)localObject).setStartOffset(l);
      QIMEffectCameraCaptureUnit.e(this.this$0).setAnimation(this.this$0.a);
      this.this$0.a.startNow();
      return;
      localObject = QIMEffectCameraCaptureUnit.b(this.this$0);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.QIMEffectCameraCaptureUnit.12
 * JD-Core Version:    0.7.0.1
 */