package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.teamlist.util.TeamListUtil;
import com.tencent.timi.game.utils.Logger;

class TeamListSlideView$4
  implements View.OnClickListener
{
  TeamListSlideView$4(TeamListSlideView paramTeamListSlideView) {}
  
  public void onClick(View paramView)
  {
    Logger.b("TeamListSlideView", "openTeamCreatePage");
    this.a.a();
    TeamListUtil.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListSlideView.4
 * JD-Core Version:    0.7.0.1
 */