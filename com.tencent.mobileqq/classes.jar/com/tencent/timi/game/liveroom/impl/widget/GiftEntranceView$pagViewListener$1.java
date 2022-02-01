package com.tencent.timi.game.liveroom.impl.widget;

import android.widget.ImageView;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/GiftEntranceView$pagViewListener$1", "Lorg/libpag/PAGView$PAGViewListener;", "onAnimationCancel", "", "p0", "Lorg/libpag/PAGView;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GiftEntranceView$pagViewListener$1
  implements PAGView.PAGViewListener
{
  public void onAnimationCancel(@Nullable PAGView paramPAGView)
  {
    GiftEntranceView.d(this.a).setVisibility(0);
    paramPAGView = GiftEntranceView.e(this.a);
    if (paramPAGView != null) {
      paramPAGView.setVisibility(4);
    }
  }
  
  public void onAnimationEnd(@Nullable PAGView paramPAGView)
  {
    GiftEntranceView.d(this.a).setVisibility(0);
    paramPAGView = GiftEntranceView.e(this.a);
    if (paramPAGView != null) {
      paramPAGView.setVisibility(4);
    }
  }
  
  public void onAnimationRepeat(@Nullable PAGView paramPAGView) {}
  
  public void onAnimationStart(@Nullable PAGView paramPAGView)
  {
    GiftEntranceView.d(this.a).setVisibility(4);
    paramPAGView = GiftEntranceView.e(this.a);
    if (paramPAGView != null) {
      paramPAGView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.GiftEntranceView.pagViewListener.1
 * JD-Core Version:    0.7.0.1
 */