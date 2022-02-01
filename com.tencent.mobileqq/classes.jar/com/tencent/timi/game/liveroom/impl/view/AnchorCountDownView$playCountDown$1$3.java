package com.tencent.timi.game.liveroom.impl.view;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorCountDownView$playCountDown$1$3", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorCountDownView$playCountDown$1$3
  implements PAGView.PAGViewListener
{
  public void onAnimationCancel(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    paramPAGView = this.a.this$0.getCountDownTimerListener();
    if (paramPAGView != null) {
      paramPAGView.b();
    }
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationStart(@Nullable PAGView paramPAGView)
  {
    paramPAGView = this.a.this$0.getCountDownTimerListener();
    if (paramPAGView != null) {
      paramPAGView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView.playCountDown.1.3
 * JD-Core Version:    0.7.0.1
 */