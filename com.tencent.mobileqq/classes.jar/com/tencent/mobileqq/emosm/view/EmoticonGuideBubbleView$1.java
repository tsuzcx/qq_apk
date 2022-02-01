package com.tencent.mobileqq.emosm.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class EmoticonGuideBubbleView$1
  implements Animation.AnimationListener
{
  EmoticonGuideBubbleView$1(EmoticonGuideBubbleView paramEmoticonGuideBubbleView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, "removeFastImage fadeoutanimation ended");
    }
    this.a.removeAllViews();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.EmoticonGuideBubbleView.1
 * JD-Core Version:    0.7.0.1
 */