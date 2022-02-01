package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.teamlist.presenter.TeamListSlidePresenter;

class TeamListSlideView$3
  implements View.OnClickListener
{
  TeamListSlideView$3(TeamListSlideView paramTeamListSlideView) {}
  
  public void onClick(View paramView)
  {
    TeamListSlideView.a(this.a).c();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListSlideView.3
 * JD-Core Version:    0.7.0.1
 */