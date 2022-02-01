package com.tencent.timi.game.team.impl.main;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/main/LevelSegmentSelectView$2", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LevelSegmentSelectView$2
  implements View.OnTouchListener
{
  public boolean onTouch(@NotNull View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (paramMotionEvent.getAction() == 0) {
      LevelSegmentSelectView.a(this.a, paramMotionEvent.getX());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.LevelSegmentSelectView.2
 * JD-Core Version:    0.7.0.1
 */