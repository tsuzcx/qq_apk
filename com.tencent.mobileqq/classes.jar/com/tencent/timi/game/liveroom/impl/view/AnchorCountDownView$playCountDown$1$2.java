package com.tencent.timi.game.liveroom.impl.view;

import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorCountDownView$playCountDown$1$2
  implements Runnable
{
  AnchorCountDownView$playCountDown$1$2(AnchorCountDownView.playCountDown.1 param1) {}
  
  public final void run()
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = this.this$0.this$0.animate().alpha(1.0F);
    ViewPropertyAnimator localViewPropertyAnimator = (ViewPropertyAnimator)localObjectRef.element;
    Intrinsics.checkExpressionValueIsNotNull(localViewPropertyAnimator, "animator");
    localViewPropertyAnimator.setDuration(200L);
    ((ViewPropertyAnimator)localObjectRef.element).setListener((Animator.AnimatorListener)new AnchorCountDownView.playCountDown.1.2.1(this, localObjectRef));
    ((ViewPropertyAnimator)localObjectRef.element).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView.playCountDown.1.2
 * JD-Core Version:    0.7.0.1
 */