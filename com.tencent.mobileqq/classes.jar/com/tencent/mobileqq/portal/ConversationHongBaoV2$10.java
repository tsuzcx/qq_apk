package com.tencent.mobileqq.portal;

import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

class ConversationHongBaoV2$10
  implements ValueAnimator.AnimatorUpdateListener
{
  ConversationHongBaoV2$10(ConversationHongBaoV2 paramConversationHongBaoV2, RelativeLayout.LayoutParams paramLayoutParams, View paramView1, View paramView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (paramValueAnimator.getAnimatedValue() == null) {
      return;
    }
    float f = ((Integer)paramValueAnimator.getAnimatedValue()).intValue() * 1.0F / 1000.0F;
    int i = (int)(-ConversationHongBaoV2.p(this.d) * (1.0F - f));
    paramValueAnimator = this.a;
    paramValueAnimator.topMargin = i;
    this.b.setLayoutParams(paramValueAnimator);
    if (this.d.n) {
      this.c.setAlpha(f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.10
 * JD-Core Version:    0.7.0.1
 */