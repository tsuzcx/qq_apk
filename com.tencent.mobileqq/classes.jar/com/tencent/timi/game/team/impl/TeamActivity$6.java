package com.tencent.timi.game.team.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.RelativeLayout;
import com.tencent.timi.game.team.impl.team.TeamContainerView;

class TeamActivity$6
  extends AnimatorListenerAdapter
{
  TeamActivity$6(TeamActivity paramTeamActivity) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    TeamActivity.d(this.a);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    TeamActivity.d(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    float f = TeamActivity.e(this.a).getHeight();
    TeamActivity.e(this.a).setTranslationY(f);
    if (TeamActivity.f(this.a) != null)
    {
      TeamActivity.a(TeamActivity.f(this.a), 0.0F);
      TeamActivity.f(this.a).setVisibility(0);
    }
    TeamActivity.e(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.6
 * JD-Core Version:    0.7.0.1
 */