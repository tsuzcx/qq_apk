package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import com.tencent.timi.game.ui.ViewStateChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$createExpandHallRightDrawerView$1", "Lcom/tencent/timi/game/ui/ViewStateChangeListener;", "onHide", "", "view", "Landroid/view/View;", "onShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$createExpandHallRightDrawerView$1
  implements ViewStateChangeListener
{
  public void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ExpandHallFragment.a(this.a, false);
  }
  
  public void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    ExpandHallFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.createExpandHallRightDrawerView.1
 * JD-Core Version:    0.7.0.1
 */