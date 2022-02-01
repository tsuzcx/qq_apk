package com.tencent.timi.game.team.impl.team;

import android.widget.TextView;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

class TeamLaneStateView$4
  implements PAGView.PAGViewListener
{
  TeamLaneStateView$4(TeamLaneStateView paramTeamLaneStateView, String paramString) {}
  
  public void onAnimationCancel(PAGView paramPAGView)
  {
    TeamLaneStateView.f(this.b).setVisibility(8);
  }
  
  public void onAnimationEnd(PAGView paramPAGView)
  {
    TeamLaneStateView.f(this.b).setVisibility(8);
  }
  
  public void onAnimationRepeat(PAGView paramPAGView) {}
  
  public void onAnimationStart(PAGView paramPAGView)
  {
    TeamLaneStateView.f(this.b).setVisibility(0);
    TeamLaneStateView.b(this.b).postDelayed(new TeamLaneStateView.4.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneStateView.4
 * JD-Core Version:    0.7.0.1
 */