package com.tencent.timi.game.gift.impl.timi;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "onGlobalLayout"}, k=3, mv={1, 1, 16})
final class TimiGiftLayerView$setGiftBannerViewHolder$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TimiGiftLayerView$setGiftBannerViewHolder$1(TimiGiftLayerView paramTimiGiftLayerView, View paramView) {}
  
  public final void onGlobalLayout()
  {
    TimiGiftLayerView localTimiGiftLayerView = this.a;
    TimiGiftLayerView.a(localTimiGiftLayerView, localTimiGiftLayerView.getHeight(), this.b.getHeight(), TimiGiftLayerView.a(this.a), TimiGiftLayerView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftLayerView.setGiftBannerViewHolder.1
 * JD-Core Version:    0.7.0.1
 */