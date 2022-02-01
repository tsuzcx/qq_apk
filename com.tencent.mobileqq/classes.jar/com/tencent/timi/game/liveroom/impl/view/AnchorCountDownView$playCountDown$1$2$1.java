package com.tencent.timi.game.liveroom.impl.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorCountDownView$playCountDown$1$2$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorCountDownView$playCountDown$1$2$1
  extends AnimatorListenerAdapter
{
  AnchorCountDownView$playCountDown$1$2$1(Ref.ObjectRef paramObjectRef) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    ((ViewPropertyAnimator)this.b.element).setListener(null);
    ((TimiGamePAGView)this.a.this$0.this$0.a(2131431438)).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView.playCountDown.1.2.1
 * JD-Core Version:    0.7.0.1
 */