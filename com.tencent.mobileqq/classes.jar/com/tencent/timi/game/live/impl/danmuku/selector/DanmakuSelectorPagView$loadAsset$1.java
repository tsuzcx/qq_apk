package com.tencent.timi.game.live.impl.danmuku.selector;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/danmuku/selector/DanmakuSelectorPagView$loadAsset$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuSelectorPagView$loadAsset$1
  implements PAGView.PAGViewListener
{
  DanmakuSelectorPagView$loadAsset$1(PAGView paramPAGView) {}
  
  public void onAnimationCancel(@Nullable PAGView paramPAGView)
  {
    this.b.post(DanmakuSelectorPagView.a(this.a));
  }
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    this.b.post(DanmakuSelectorPagView.a(this.a));
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationStart(@Nullable PAGView paramPAGView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.selector.DanmakuSelectorPagView.loadAsset.1
 * JD-Core Version:    0.7.0.1
 */