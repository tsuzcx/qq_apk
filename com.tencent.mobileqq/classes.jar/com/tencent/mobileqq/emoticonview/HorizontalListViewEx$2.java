package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class HorizontalListViewEx$2
  implements ValueAnimator.AnimatorUpdateListener
{
  HorizontalListViewEx$2(HorizontalListViewEx paramHorizontalListViewEx, View paramView, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.this$0.mIndicatorStartX = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = this.this$0;
    paramValueAnimator.mIndicatorStartX += this.val$nextView.getLeft() - this.val$endX;
    if (this.this$0.mIndicatorStartX == this.val$nextView.getLeft()) {
      HorizontalListViewEx.access$002(this.this$0, false);
    }
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.HorizontalListViewEx.2
 * JD-Core Version:    0.7.0.1
 */