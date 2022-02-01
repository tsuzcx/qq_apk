package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AECropperImageView$2
  implements Animator.AnimatorListener
{
  AECropperImageView$2(AECropperImageView paramAECropperImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperImageView.2
 * JD-Core Version:    0.7.0.1
 */