package com.tencent.timi.game.team.impl.team;

import com.tencent.timi.game.team.impl.event.ChooseLaneEvent;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;

class TeamContainerView$9
  implements Runnable
{
  TeamContainerView$9(TeamContainerView paramTeamContainerView, TeamLaneStateView paramTeamLaneStateView, ChooseLaneEvent paramChooseLaneEvent) {}
  
  public void run()
  {
    this.a.setStateWithAnim(TeamLaneHelper.a(this.b.getLaneId(), true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.9
 * JD-Core Version:    0.7.0.1
 */