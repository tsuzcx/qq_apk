package com.tencent.timi.game.team.impl.team;

import android.view.View;
import android.widget.TextView;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;

class TeamLaneStateView$2
  implements TeamLaneSelectView.OnLaneSelectedListener
{
  TeamLaneStateView$2(TeamLaneStateView paramTeamLaneStateView) {}
  
  public void a(View paramView, int paramInt)
  {
    TeamLaneStateView.a(this.a, paramInt);
    TeamLaneStateView.b(this.a).setText(TeamLaneHelper.a(paramInt, true));
    TeamLaneHelper.a(TeamLaneStateView.c(this.a), TeamLaneStateView.d(this.a));
    TeamLaneStateView localTeamLaneStateView = this.a;
    TeamLaneStateView.a(localTeamLaneStateView, paramView, TeamLaneStateView.c(localTeamLaneStateView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneStateView.2
 * JD-Core Version:    0.7.0.1
 */