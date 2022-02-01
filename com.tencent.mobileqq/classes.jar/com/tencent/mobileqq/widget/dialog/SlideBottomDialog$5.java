package com.tencent.mobileqq.widget.dialog;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class SlideBottomDialog$5
  implements Animation.AnimationListener
{
  SlideBottomDialog$5(SlideBottomDialog paramSlideBottomDialog) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.dismiss();
    SlideBottomDialog.a(this.a, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.dialog.SlideBottomDialog.5
 * JD-Core Version:    0.7.0.1
 */