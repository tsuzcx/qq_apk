package com.tencent.timi.game.team.impl;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.timi.game.team.impl.team.TeamContainerView;

class TeamActivity$8
  implements ValueAnimator.AnimatorUpdateListener
{
  TeamActivity$8(TeamActivity paramTeamActivity, float paramFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    TeamActivity.e(this.b).setTranslationY(this.a * f);
    TeamActivity.a(TeamActivity.f(this.b), 1.0F - f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.8
 * JD-Core Version:    0.7.0.1
 */