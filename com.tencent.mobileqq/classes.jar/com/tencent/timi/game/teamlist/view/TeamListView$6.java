package com.tencent.timi.game.teamlist.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

class TeamListView$6
  implements ValueAnimator.AnimatorUpdateListener
{
  TeamListView$6(TeamListView paramTeamListView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    TeamListView.b(this.b).setLayoutParams(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView.6
 * JD-Core Version:    0.7.0.1
 */