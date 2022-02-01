package com.tencent.timi.game.teamlist.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

class TeamListFilterView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  TeamListFilterView$6(TeamListFilterView paramTeamListFilterView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    TeamListFilterView.a(this.a).height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    TeamListFilterView.b(this.a).setLayoutParams(TeamListFilterView.a(this.a));
    TeamListFilterView.d(this.a).setAlpha(TeamListFilterView.a(this.a).height / TeamListFilterView.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListFilterView.6
 * JD-Core Version:    0.7.0.1
 */