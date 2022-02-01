package com.tencent.mobileqq.hotpic;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XPanelContainer;

class HotPicMainPanel$1
  implements ValueAnimator.AnimatorUpdateListener
{
  HotPicMainPanel$1(HotPicMainPanel paramHotPicMainPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.a.a != null) {
      this.a.a.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel.1
 * JD-Core Version:    0.7.0.1
 */