package com.tencent.mobileqq.troop.troopcard.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class TroopGameCardView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  TroopGameCardView$8(TroopGameCardView paramTroopGameCardView, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue("startColor")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("endColor")).intValue();
    TroopGameCardView.a(this.b, this.a, i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopGameCardView.8
 * JD-Core Version:    0.7.0.1
 */