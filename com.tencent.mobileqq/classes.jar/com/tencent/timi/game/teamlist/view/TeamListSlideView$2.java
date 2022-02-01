package com.tencent.timi.game.teamlist.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamListSlideView$2
  implements View.OnClickListener
{
  TeamListSlideView$2(TeamListSlideView paramTeamListSlideView) {}
  
  public void onClick(View paramView)
  {
    if (TeamListSlideView.b(this.a).a) {
      TeamListSlideView.b(this.a).c();
    } else {
      this.a.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListSlideView.2
 * JD-Core Version:    0.7.0.1
 */