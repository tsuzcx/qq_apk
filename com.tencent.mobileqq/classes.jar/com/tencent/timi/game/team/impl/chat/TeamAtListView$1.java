package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamAtListView$1
  implements View.OnClickListener
{
  TeamAtListView$1(TeamAtListView paramTeamAtListView) {}
  
  public void onClick(View paramView)
  {
    TeamAtListView.a(this.a).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamAtListView.1
 * JD-Core Version:    0.7.0.1
 */