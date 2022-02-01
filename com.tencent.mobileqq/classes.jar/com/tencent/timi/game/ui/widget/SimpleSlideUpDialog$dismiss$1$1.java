package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SimpleSlideUpDialog$dismiss$1$1
  implements Runnable
{
  SimpleSlideUpDialog$dismiss$1$1(SimpleSlideUpDialog.dismiss.1 param1, int paramInt) {}
  
  public final void run()
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.this$0.a, "translationY", new float[] { 0.0F, this.a });
    localObjectAnimator1.addListener((Animator.AnimatorListener)new SimpleSlideUpDialog.dismiss.1.1.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator1, "transAnim");
    localObjectAnimator1.setDuration(this.this$0.this$0.d());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.this$0.b, "alpha", new float[] { 1.0F, 0.0F });
    Intrinsics.checkExpressionValueIsNotNull(localObjectAnimator2, "alphaAnim");
    localObjectAnimator2.setDuration(this.this$0.this$0.d());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObjectAnimator1);
    localAnimatorSet.play((Animator)localObjectAnimator2);
    localAnimatorSet.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.SimpleSlideUpDialog.dismiss.1.1
 * JD-Core Version:    0.7.0.1
 */