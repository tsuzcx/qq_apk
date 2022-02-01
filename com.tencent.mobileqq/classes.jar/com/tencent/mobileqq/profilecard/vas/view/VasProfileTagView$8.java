package com.tencent.mobileqq.profilecard.vas.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.PointF;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.widget.RatioLayout;

class VasProfileTagView$8
  implements ValueAnimator.AnimatorUpdateListener
{
  VasProfileTagView$8(VasProfileTagView paramVasProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (PointF)paramValueAnimator.getAnimatedValue();
    VasProfileTagView.access$500(this.this$0).a(this.val$tagView, paramValueAnimator.x, paramValueAnimator.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView.8
 * JD-Core Version:    0.7.0.1
 */