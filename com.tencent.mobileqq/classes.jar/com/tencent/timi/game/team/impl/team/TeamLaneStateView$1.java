package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamLaneStateView$1
  implements View.OnClickListener
{
  TeamLaneStateView$1(TeamLaneStateView paramTeamLaneStateView) {}
  
  public void onClick(View paramView)
  {
    TeamLaneStateView.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneStateView.1
 * JD-Core Version:    0.7.0.1
 */