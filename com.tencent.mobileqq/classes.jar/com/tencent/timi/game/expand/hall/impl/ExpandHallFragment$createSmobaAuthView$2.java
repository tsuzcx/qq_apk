package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView;
import com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallFragment$createSmobaAuthView$2
  implements View.OnClickListener
{
  ExpandHallFragment$createSmobaAuthView$2(ExpandHallFragment paramExpandHallFragment) {}
  
  public final void onClick(View paramView)
  {
    Object localObject = ExpandHallFragment.j(this.a);
    if (localObject != null) {
      ((ExpandHallSmobaAuthView)localObject).b();
    }
    localObject = ExpandHallFragment.k(this.a);
    if (localObject != null) {
      ((ExpandHallInfoView)localObject).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.createSmobaAuthView.2
 * JD-Core Version:    0.7.0.1
 */