package com.tencent.timi.game.team.impl.team;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;
import org.jetbrains.annotations.NotNull;

class TeamContainerView$1
  extends ViewDragHelper.Callback
{
  TeamContainerView$1(TeamContainerView paramTeamContainerView) {}
  
  public int clampViewPositionVertical(@NonNull @NotNull View paramView, int paramInt1, int paramInt2)
  {
    return Math.max(paramInt1, 0);
  }
  
  public int getViewVerticalDragRange(@NonNull @NotNull View paramView)
  {
    return TeamContainerView.d(this.a);
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    super.onViewDragStateChanged(paramInt);
    if ((paramInt == 0) && (TeamContainerView.c(this.a).getCapturedView() != null) && (TeamContainerView.c(this.a).getCapturedView().getTop() > 0) && (TeamContainerView.a(this.a) != null)) {
      TeamContainerView.a(this.a).a();
    }
  }
  
  public void onViewPositionChanged(@NonNull @NotNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (TeamContainerView.a(this.a) != null)
    {
      float f = paramInt2 / TeamContainerView.d(this.a);
      TeamContainerView.a(this.a).a(f);
    }
  }
  
  public void onViewReleased(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    int i = paramView.getTop();
    boolean bool;
    if (TeamContainerView.a(this.a) != null) {
      bool = TeamContainerView.a(this.a).b();
    } else {
      bool = false;
    }
    if (!bool) {
      if (i <= TeamContainerView.b(this.a)) {
        TeamContainerView.c(this.a).settleCapturedViewAt(0, 0);
      } else {
        TeamContainerView.c(this.a).settleCapturedViewAt(0, TeamContainerView.d(this.a));
      }
    }
    this.a.invalidate();
  }
  
  public boolean tryCaptureView(@NonNull View paramView, int paramInt)
  {
    return paramView.getId() == 2131446863;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.1
 * JD-Core Version:    0.7.0.1
 */