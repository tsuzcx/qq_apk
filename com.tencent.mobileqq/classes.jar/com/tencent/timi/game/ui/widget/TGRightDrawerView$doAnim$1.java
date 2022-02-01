package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/ui/widget/TGRightDrawerView$doAnim$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TGRightDrawerView$doAnim$1
  extends AnimatorListenerAdapter
{
  TGRightDrawerView$doAnim$1(int paramInt) {}
  
  public void onAnimationEnd(@Nullable Animator paramAnimator)
  {
    Logger.a("TGRightDrawerView", "doAnim onAnimationEnd");
    if (this.b == 2) {
      TGRightDrawerView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.ui.widget.TGRightDrawerView.doAnim.1
 * JD-Core Version:    0.7.0.1
 */