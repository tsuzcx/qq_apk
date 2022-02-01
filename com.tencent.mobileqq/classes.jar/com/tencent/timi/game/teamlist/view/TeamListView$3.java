package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamListView$3
  implements View.OnClickListener
{
  TeamListView$3(TeamListView paramTeamListView) {}
  
  public void onClick(View paramView)
  {
    TeamListView.a(this.a).performClick();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView.3
 * JD-Core Version:    0.7.0.1
 */