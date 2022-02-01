package com.tencent.timi.game.team.impl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.timi.game.team.impl.team.TeamContainerView;

class TeamActivity$9
  extends AnimatorListenerAdapter
{
  TeamActivity$9(TeamActivity paramTeamActivity, float paramFloat) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    TeamActivity.e(this.b).setTranslationY(this.a);
    TeamActivity.a(TeamActivity.f(this.b), 0.0F);
    TeamActivity.c(this.b);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    TeamActivity.e(this.b).setTranslationY(this.a);
    TeamActivity.a(TeamActivity.f(this.b), 0.0F);
    TeamActivity.c(this.b);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    TeamActivity.e(this.b).setTranslationY(0.0F);
    TeamActivity.a(TeamActivity.f(this.b), 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.9
 * JD-Core Version:    0.7.0.1
 */