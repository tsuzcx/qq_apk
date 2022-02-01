package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.widget.FrameLayout;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGRightDrawerView$hideAnim$1$1
  implements Runnable
{
  TGRightDrawerView$hideAnim$1$1(TGRightDrawerView.hideAnim.1 param1, int paramInt) {}
  
  public final void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat((FrameLayout)this.this$0.this$0.a(2131431334), "translationX", new float[] { 0.0F, this.a });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator1, "transAnim");
    localObjectAnimator1.setInterpolator((TimeInterpolator)CommonAnimationUtil.SlideUpAnimation.b);
    localObjectAnimator1.setDuration(500L);
    localObjectAnimator1.addListener((Animator.AnimatorListener)new TGRightDrawerView.hideAnim.1.1.1(this));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.this$0.this$0.a(2131445743), "alpha", new float[] { 1.0F, 0.0F });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator2, "alphaAnim");
    localObjectAnimator2.setInterpolator((TimeInterpolator)CommonAnimationUtil.SlideUpAnimation.b);
    localObjectAnimator2.setDuration(500L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator1);
    localAnimatorSet.play((Animator)localObjectAnimator2);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TGRightDrawerView.hideAnim.1.1
 * JD-Core Version:    0.7.0.1
 */