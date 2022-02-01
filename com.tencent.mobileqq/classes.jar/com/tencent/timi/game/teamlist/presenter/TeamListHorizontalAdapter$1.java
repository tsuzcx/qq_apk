package com.tencent.timi.game.teamlist.presenter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.teamlist.util.TeamListUtil;

class TeamListHorizontalAdapter$1
  implements View.OnClickListener
{
  TeamListHorizontalAdapter$1(TeamListHorizontalAdapter paramTeamListHorizontalAdapter) {}
  
  public void onClick(View paramView)
  {
    TeamListUtil.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.presenter.TeamListHorizontalAdapter.1
 * JD-Core Version:    0.7.0.1
 */