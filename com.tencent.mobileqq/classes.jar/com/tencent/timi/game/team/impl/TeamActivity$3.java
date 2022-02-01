package com.tencent.timi.game.team.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamActivity$3
  implements View.OnClickListener
{
  TeamActivity$3(TeamActivity paramTeamActivity) {}
  
  public void onClick(View paramView)
  {
    TeamActivity.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.3
 * JD-Core Version:    0.7.0.1
 */