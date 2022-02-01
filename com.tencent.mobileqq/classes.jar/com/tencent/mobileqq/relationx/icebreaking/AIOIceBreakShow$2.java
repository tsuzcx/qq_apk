package com.tencent.mobileqq.relationx.icebreaking;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOFooterViewDetector;
import com.tencent.widget.AbsListView.LayoutParams;

class AIOIceBreakShow$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AIOIceBreakShow$2(AIOIceBreakShow paramAIOIceBreakShow) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (AIOIceBreakShow.b(this.a) == null) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue("alpha")).intValue();
    int j = ((Integer)paramValueAnimator.getAnimatedValue("height")).intValue();
    AIOIceBreakShow.b(this.a).setAlpha(i / 100.0F);
    paramValueAnimator = AIOIceBreakShow.c(this.a).a();
    ((AbsListView.LayoutParams)paramValueAnimator.getLayoutParams()).height = j;
    paramValueAnimator.requestLayout();
    AIOIceBreakShow.b(this.a).scrollTo(0, j - AIOIceBreakShow.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakShow.2
 * JD-Core Version:    0.7.0.1
 */