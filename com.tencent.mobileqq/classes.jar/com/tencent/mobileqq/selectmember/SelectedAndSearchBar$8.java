package com.tencent.mobileqq.selectmember;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class SelectedAndSearchBar$8
  implements ValueAnimator.AnimatorUpdateListener
{
  SelectedAndSearchBar$8(SelectedAndSearchBar paramSelectedAndSearchBar, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.topMargin = i;
    SelectedAndSearchBar.f(this.b).setLayoutParams(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.SelectedAndSearchBar.8
 * JD-Core Version:    0.7.0.1
 */