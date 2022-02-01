package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TeamLaneSelectView$1
  implements View.OnClickListener
{
  TeamLaneSelectView$1(TeamLaneSelectView paramTeamLaneSelectView, TextView paramTextView) {}
  
  public void onClick(View paramView)
  {
    TeamLaneSelectView.a(this.b);
    paramView.setSelected(true);
    if (TeamLaneSelectView.b(this.b) != null) {
      TeamLaneSelectView.b(this.b).a(this.a, ((Integer)paramView.getTag()).intValue());
    }
    TeamLaneSelectView.c(this.b).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneSelectView.1
 * JD-Core Version:    0.7.0.1
 */