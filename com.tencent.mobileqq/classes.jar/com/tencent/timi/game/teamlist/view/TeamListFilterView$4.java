package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamListFilterView$4
  implements View.OnClickListener
{
  TeamListFilterView$4(TeamListFilterView paramTeamListFilterView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a) {
      this.a.c();
    } else {
      this.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListFilterView.4
 * JD-Core Version:    0.7.0.1
 */