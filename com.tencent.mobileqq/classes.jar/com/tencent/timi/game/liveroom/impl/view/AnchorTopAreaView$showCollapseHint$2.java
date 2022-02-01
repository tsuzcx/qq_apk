package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$showCollapseHint$2
  implements View.OnClickListener
{
  AnchorTopAreaView$showCollapseHint$2(ViewGroup paramViewGroup, View paramView) {}
  
  public final void onClick(View paramView)
  {
    this.a.removeView(this.b);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.b.findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "hintView.contentView");
    localRelativeLayout.setVisibility(4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.showCollapseHint.2
 * JD-Core Version:    0.7.0.1
 */