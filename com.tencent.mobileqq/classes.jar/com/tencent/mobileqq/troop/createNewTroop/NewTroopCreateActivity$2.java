package com.tencent.mobileqq.troop.createNewTroop;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.widget.TabBarView2;

class NewTroopCreateActivity$2
  implements ValueAnimator.AnimatorUpdateListener
{
  NewTroopCreateActivity$2(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (RelativeLayout.LayoutParams)this.a.a.getLayoutParams();
    paramValueAnimator.topMargin = i;
    this.a.a.setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity.2
 * JD-Core Version:    0.7.0.1
 */