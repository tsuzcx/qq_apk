package com.tencent.mobileqq.emoticonview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class FastImagePreviewLayout$1
  implements Animation.AnimationListener
{
  FastImagePreviewLayout$1(FastImagePreviewLayout paramFastImagePreviewLayout) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(FastImagePreviewLayout.TAG, 2, "removeFastImage fadeoutanimation ended");
    }
    this.this$0.removeAllViews();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FastImagePreviewLayout.1
 * JD-Core Version:    0.7.0.1
 */