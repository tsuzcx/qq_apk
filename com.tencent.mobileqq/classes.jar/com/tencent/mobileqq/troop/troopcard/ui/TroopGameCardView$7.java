package com.tencent.mobileqq.troop.troopcard.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class TroopGameCardView$7
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$7(TroopGameCardView paramTroopGameCardView, ValueAnimator paramValueAnimator, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)this.a.getAnimatedValue("height")).intValue();
    paramValueAnimator = this.b.getLayoutParams();
    paramValueAnimator.height = i;
    this.b.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.7
 * JD-Core Version:    0.7.0.1
 */