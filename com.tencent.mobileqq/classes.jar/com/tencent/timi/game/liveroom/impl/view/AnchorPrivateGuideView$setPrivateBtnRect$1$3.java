package com.tencent.timi.game.liveroom.impl.view;

import android.animation.Animator.AnimatorListener;
import android.view.ViewPropertyAnimator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorPrivateGuideView$setPrivateBtnRect$1$3
  implements Runnable
{
  AnchorPrivateGuideView$setPrivateBtnRect$1$3(AnchorPrivateGuideView.setPrivateBtnRect.1 param1) {}
  
  public final void run()
  {
    ViewPropertyAnimator localViewPropertyAnimator = this.this$0.this$0.animate().alpha(1.0F);
    Intrinsics.checkExpressionValueIsNotNull(localViewPropertyAnimator, "ani");
    localViewPropertyAnimator.setDuration(200L);
    localViewPropertyAnimator.setListener((Animator.AnimatorListener)new AnchorPrivateGuideView.setPrivateBtnRect.1.3.1(this));
    localViewPropertyAnimator.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorPrivateGuideView.setPrivateBtnRect.1.3
 * JD-Core Version:    0.7.0.1
 */