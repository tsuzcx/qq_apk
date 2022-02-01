package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$showCollapseHint$5$1
  implements Runnable
{
  AnchorTopAreaView$showCollapseHint$5$1(AnchorTopAreaView.showCollapseHint.5 param5) {}
  
  public final void run()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.this$0.a.findViewById(2131431338);
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "hintView.contentView");
    localRelativeLayout.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.showCollapseHint.5.1
 * JD-Core Version:    0.7.0.1
 */