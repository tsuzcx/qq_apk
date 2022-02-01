package dov.com.qq.im.aeeditor.module.clip.image;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class AEImageCropperMask$2
  implements Animator.AnimatorListener
{
  AEImageCropperMask$2(AEImageCropperMask paramAEImageCropperMask) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, false);
    AEImageCropperMask.b(this.a, AEImageCropperMask.a(this.a));
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, false);
    AEImageCropperMask.b(this.a, AEImageCropperMask.a(this.a));
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEImageCropperMask.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.image.AEImageCropperMask.2
 * JD-Core Version:    0.7.0.1
 */