package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.PointF;
import android.view.View;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout.LayoutParams;

class VasProfileTagView$11
  extends AnimatorListenerAdapter
{
  VasProfileTagView$11(VasProfileTagView paramVasProfileTagView, View paramView, PointF paramPointF) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    VasProfileTagView.access$1706(this.this$0);
    paramAnimator = (RatioLayout.LayoutParams)this.val$child.getLayoutParams();
    if (paramAnimator == null) {
      return;
    }
    if (this.val$child.getAnimation() != null) {
      this.val$child.clearAnimation();
    }
    if ((paramAnimator.a != this.val$pos.x) || (paramAnimator.b != this.val$pos.y))
    {
      paramAnimator.a = this.val$pos.x;
      paramAnimator.b = this.val$pos.y;
      this.val$child.setLayoutParams(paramAnimator);
      this.val$child.setTranslationX(0.0F);
      this.val$child.setTranslationY(0.0F);
      paramAnimator = this.val$child;
      if ((paramAnimator instanceof VipTagView)) {
        ((VipTagView)paramAnimator).setShakingState(true);
      }
    }
    VasProfileTagView.access$202(this.this$0, false);
    if (VasProfileTagView.access$1700(this.this$0) == 0) {
      VasProfileTagView.access$1800(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.11
 * JD-Core Version:    0.7.0.1
 */