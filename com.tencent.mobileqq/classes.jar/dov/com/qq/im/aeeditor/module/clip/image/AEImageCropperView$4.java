package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEImageCropperView$4
  implements Animator.AnimatorListener
{
  AEImageCropperView$4(AEImageCropperView paramAEImageCropperView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, false);
    if (this.a.a != null) {
      this.a.a.onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEImageCropperView.a(this.a, true);
    if (this.a.a != null) {
      this.a.a.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperView.4
 * JD-Core Version:    0.7.0.1
 */