package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

class PickerContainer$3
  implements Animator.AnimatorListener
{
  PickerContainer$3(PickerContainer paramPickerContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PickerContainer.a(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PickerContainer.a(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer.3
 * JD-Core Version:    0.7.0.1
 */