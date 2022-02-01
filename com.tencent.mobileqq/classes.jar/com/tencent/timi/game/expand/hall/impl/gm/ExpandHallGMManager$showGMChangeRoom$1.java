package com.tencent.timi.game.expand.hall.impl.gm;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallGMManager$showGMChangeRoom$1
  implements View.OnClickListener
{
  ExpandHallGMManager$showGMChangeRoom$1(ExpandHallGMManager paramExpandHallGMManager) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      ExpandHallGMManager localExpandHallGMManager = this.a;
      Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
      ExpandHallGMManager.a(localExpandHallGMManager, paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.ExpandHallGMManager.showGMChangeRoom.1
 * JD-Core Version:    0.7.0.1
 */