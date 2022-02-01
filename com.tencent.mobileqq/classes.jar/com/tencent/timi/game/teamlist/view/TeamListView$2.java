package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.teamlist.presenter.TeamListPresenter;

class TeamListView$2
  implements View.OnClickListener
{
  TeamListView$2(TeamListView paramTeamListView) {}
  
  public void onClick(View paramView)
  {
    this.a.a.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView.2
 * JD-Core Version:    0.7.0.1
 */