package com.tencent.widget.itemtouchhelper;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ItemTouchHelper$RecoverAnimation$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ItemTouchHelper$RecoverAnimation$1(ItemTouchHelper.RecoverAnimation paramRecoverAnimation, ItemTouchHelper paramItemTouchHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$1.setFraction(paramValueAnimator.getAnimatedFraction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.itemtouchhelper.ItemTouchHelper.RecoverAnimation.1
 * JD-Core Version:    0.7.0.1
 */