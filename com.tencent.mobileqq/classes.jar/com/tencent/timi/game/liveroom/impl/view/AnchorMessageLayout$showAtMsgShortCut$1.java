package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$showAtMsgShortCut$1
  implements View.OnClickListener
{
  AnchorMessageLayout$showAtMsgShortCut$1(AnchorMessageLayout paramAnchorMessageLayout, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AnchorMessageLayout localAnchorMessageLayout = this.a;
    AnchorMessageLayout.a(localAnchorMessageLayout, AnchorMessageLayout.d(localAnchorMessageLayout), Math.max(0, AnchorMessageLayout.c(this.a).size() - this.b), true);
    AnchorMessageLayout.j(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.showAtMsgShortCut.1
 * JD-Core Version:    0.7.0.1
 */