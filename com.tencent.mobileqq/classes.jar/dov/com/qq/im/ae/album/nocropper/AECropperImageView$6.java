package dov.com.qq.im.ae.album.nocropper;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AECropperImageView$6
  implements Animator.AnimatorListener
{
  AECropperImageView$6(AECropperImageView paramAECropperImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, false);
    AECropperImageView.c(this.a);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECropperImageView.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.nocropper.AECropperImageView.6
 * JD-Core Version:    0.7.0.1
 */