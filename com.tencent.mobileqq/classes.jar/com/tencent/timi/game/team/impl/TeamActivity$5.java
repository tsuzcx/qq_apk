package com.tencent.timi.game.team.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.timi.game.team.impl.team.TeamContainerView;

class TeamActivity$5
  implements ValueAnimator.AnimatorUpdateListener
{
  TeamActivity$5(TeamActivity paramTeamActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = TeamActivity.e(this.a).getHeight();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    TeamActivity.e(this.a).setTranslationY(f1 * f2);
    TeamActivity.a(TeamActivity.f(this.a), 1.0F - f2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.5
 * JD-Core Version:    0.7.0.1
 */