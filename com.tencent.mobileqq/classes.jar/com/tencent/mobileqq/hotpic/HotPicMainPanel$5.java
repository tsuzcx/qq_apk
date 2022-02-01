package com.tencent.mobileqq.hotpic;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.image.AbstractGifImage;
import com.tencent.widget.XPanelContainer;

class HotPicMainPanel$5
  implements ValueAnimator.AnimatorUpdateListener
{
  HotPicMainPanel$5(HotPicMainPanel paramHotPicMainPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i == this.a) {
      AbstractGifImage.resumeAll();
    }
    XPanelContainer.a = i;
    if (this.b.m != null) {
      this.b.m.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicMainPanel.5
 * JD-Core Version:    0.7.0.1
 */