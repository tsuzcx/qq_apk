package com.tencent.timi.game.team.impl.main;

import android.view.View;
import android.widget.LinearLayout;
import androidx.customview.widget.ViewDragHelper.Callback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/main/LevelSegmentSelectView$1", "Landroidx/customview/widget/ViewDragHelper$Callback;", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "onViewReleased", "", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LevelSegmentSelectView$1
  extends ViewDragHelper.Callback
{
  public int clampViewPositionHorizontal(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "child");
    this.a.invalidate();
    int j;
    int i;
    if (LevelSegmentSelectView.b(this.a) == 0)
    {
      j = this.a.getPaddingLeft();
      paramInt2 = this.a.getWidth() - paramView.getWidth();
      i = this.a.getPaddingRight();
    }
    else
    {
      LevelSegmentSelectView localLevelSegmentSelectView = this.a;
      i = LevelSegmentSelectView.a(localLevelSegmentSelectView, LevelSegmentSelectView.c(localLevelSegmentSelectView) - 1);
      localLevelSegmentSelectView = this.a;
      paramInt2 = LevelSegmentSelectView.a(localLevelSegmentSelectView, LevelSegmentSelectView.c(localLevelSegmentSelectView) + 1);
      localLevelSegmentSelectView = this.a;
      View localView = LevelSegmentSelectView.d(localLevelSegmentSelectView).getChildAt(i);
      Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(releaseLowPos)");
      j = LevelSegmentSelectView.a(localLevelSegmentSelectView, localView) - paramView.getWidth() / 2;
      localLevelSegmentSelectView = this.a;
      localView = LevelSegmentSelectView.d(localLevelSegmentSelectView).getChildAt(paramInt2);
      Intrinsics.checkExpressionValueIsNotNull(localView, "textItemLinear.getChildAt(releaseHighPos)");
      paramInt2 = LevelSegmentSelectView.a(localLevelSegmentSelectView, localView);
      i = paramView.getWidth() / 2;
    }
    paramInt1 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(paramInt1, j), paramInt2 - i);
    LevelSegmentSelectView.a(this.a);
    return paramInt1;
  }
  
  public void onViewReleased(@NotNull View paramView, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "releasedChild");
    super.onViewReleased(paramView, paramFloat1, paramFloat2);
    LevelSegmentSelectView.b(this.a, paramView);
    LevelSegmentSelectView.c(this.a, paramView);
  }
  
  public boolean tryCaptureView(@NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "child");
    return (paramView.getId() == 2131439560) || (paramView.getId() == 2131439706);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.LevelSegmentSelectView.1
 * JD-Core Version:    0.7.0.1
 */