package com.tencent.timi.game.liveroom.impl.view.operation;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/operation/AnchorOperationView$ViewPagerScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "mDuration", "", "getMDuration", "()I", "setMDuration", "(I)V", "setDuration", "", "duration", "startScroll", "startX", "startY", "dx", "dy", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
final class AnchorOperationView$ViewPagerScroller
  extends Scroller
{
  private int a = 400;
  
  public AnchorOperationView$ViewPagerScroller(@NotNull Context paramContext, @NotNull Interpolator paramInterpolator)
  {
    super(paramContext, paramInterpolator);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
  
  public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.operation.AnchorOperationView.ViewPagerScroller
 * JD-Core Version:    0.7.0.1
 */