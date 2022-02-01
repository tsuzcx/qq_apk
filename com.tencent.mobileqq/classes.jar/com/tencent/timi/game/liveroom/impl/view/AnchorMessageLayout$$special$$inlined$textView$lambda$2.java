package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$5$1"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$$special$$inlined$textView$lambda$2
  implements View.OnClickListener
{
  AnchorMessageLayout$$special$$inlined$textView$lambda$2(AnchorMessageLayout paramAnchorMessageLayout) {}
  
  public final void onClick(View paramView)
  {
    this.a.e();
    AnchorMessageLayout.a(this.a, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout..special..inlined.textView.lambda.2
 * JD-Core Version:    0.7.0.1
 */