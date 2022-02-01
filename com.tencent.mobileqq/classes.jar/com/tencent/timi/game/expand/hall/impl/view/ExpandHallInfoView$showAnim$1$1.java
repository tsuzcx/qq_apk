package com.tencent.timi.game.expand.hall.impl.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.RelativeLayout;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$showAnim$1$1
  implements Runnable
{
  ExpandHallInfoView$showAnim$1$1(ExpandHallInfoView.showAnim.1 param1, int paramInt) {}
  
  public final void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat((RelativeLayout)this.this$0.this$0.a(2131431332), "translationY", new float[] { this.a, 0.0F });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator1, "transAnim");
    localObjectAnimator1.setInterpolator((TimeInterpolator)CommonAnimationUtil.SlideUpAnimation.a);
    localObjectAnimator1.setDuration(500L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.this$0.this$0.a(2131445743), "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)ExpandHallInfoView.showAnim.1.1.1.a);
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator2, "alphaAnim");
    localObjectAnimator2.setInterpolator((TimeInterpolator)CommonAnimationUtil.SlideUpAnimation.a);
    localObjectAnimator2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator1);
    localAnimatorSet.play((Animator)localObjectAnimator2);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.showAnim.1.1
 * JD-Core Version:    0.7.0.1
 */