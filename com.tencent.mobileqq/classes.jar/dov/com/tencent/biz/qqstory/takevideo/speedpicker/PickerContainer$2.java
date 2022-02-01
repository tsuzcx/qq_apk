package dov.com.tencent.biz.qqstory.takevideo.speedpicker;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class PickerContainer$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PickerContainer$2(PickerContainer paramPickerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setAlpha(PickerContainer.b(this.a).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.speedpicker.PickerContainer.2
 * JD-Core Version:    0.7.0.1
 */