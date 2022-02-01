package com.tencent.timi.game.expand.hall.impl.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallSmobaAuthView$hideAnim$1$1
  implements Runnable
{
  ExpandHallSmobaAuthView$hideAnim$1$1(ExpandHallSmobaAuthView.hideAnim.1 param1, int paramInt) {}
  
  public final void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat((LinearLayout)this.this$0.this$0.a(2131431333), "translationY", new float[] { 0.0F, this.a });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator1, "transAnim");
    localObjectAnimator1.setDuration(200L);
    localObjectAnimator1.addListener((Animator.AnimatorListener)new ExpandHallSmobaAuthView.hideAnim.1.1.1(this));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.this$0.this$0.a(2131445743), "alpha", new float[] { 1.0F, 0.0F });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator2, "alphaAnim");
    localObjectAnimator2.setDuration(200L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator1);
    localAnimatorSet.play((Animator)localObjectAnimator2);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.hideAnim.1.1
 * JD-Core Version:    0.7.0.1
 */