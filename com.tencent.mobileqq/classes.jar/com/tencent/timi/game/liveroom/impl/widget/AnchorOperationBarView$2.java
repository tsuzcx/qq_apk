package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorOperationBarView$2
  implements View.OnClickListener
{
  AnchorOperationBarView$2(AnchorOperationBarView paramAnchorOperationBarView) {}
  
  public final void onClick(View paramView)
  {
    AnchorOperationBarView.IAnchorOperationBarViewListener localIAnchorOperationBarViewListener = AnchorOperationBarView.a(this.a);
    if (localIAnchorOperationBarViewListener != null) {
      localIAnchorOperationBarViewListener.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorOperationBarView.2
 * JD-Core Version:    0.7.0.1
 */