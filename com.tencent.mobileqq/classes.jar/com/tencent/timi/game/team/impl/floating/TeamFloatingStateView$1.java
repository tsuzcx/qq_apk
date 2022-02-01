package com.tencent.timi.game.team.impl.floating;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.timi.game.widget.MediumBoldTextView;

class TeamFloatingStateView$1
  implements Animation.AnimationListener
{
  TeamFloatingStateView$1(TeamFloatingStateView paramTeamFloatingStateView, String paramString) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TeamFloatingStateView.a(this.b).setVisibility(8);
    TeamFloatingStateView.a(this.b, this.a);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    TeamFloatingStateView.a(this.b).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingStateView.1
 * JD-Core Version:    0.7.0.1
 */