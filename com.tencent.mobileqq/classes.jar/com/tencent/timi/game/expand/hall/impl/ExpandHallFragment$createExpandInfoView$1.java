package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallFragment$createExpandInfoView$1
  implements View.OnClickListener
{
  ExpandHallFragment$createExpandInfoView$1(ExpandHallFragment paramExpandHallFragment) {}
  
  public final void onClick(View paramView)
  {
    ExpandHallFragment.i(this.a);
    ExpandHallSmobaAuthView localExpandHallSmobaAuthView = ExpandHallFragment.j(this.a);
    if (localExpandHallSmobaAuthView != null) {
      localExpandHallSmobaAuthView.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.createExpandInfoView.1
 * JD-Core Version:    0.7.0.1
 */