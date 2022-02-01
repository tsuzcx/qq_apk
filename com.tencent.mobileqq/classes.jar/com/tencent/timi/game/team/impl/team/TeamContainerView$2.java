package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamContainerView$2
  implements View.OnClickListener
{
  TeamContainerView$2(TeamContainerView paramTeamContainerView) {}
  
  public void onClick(View paramView)
  {
    if (TeamContainerView.e(this.a) != null) {
      TeamContainerView.e(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.2
 * JD-Core Version:    0.7.0.1
 */