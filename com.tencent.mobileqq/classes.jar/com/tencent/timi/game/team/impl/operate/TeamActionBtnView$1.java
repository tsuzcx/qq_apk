package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.NoDoubleClickUtils;

class TeamActionBtnView$1
  implements View.OnClickListener
{
  TeamActionBtnView$1(TeamActionBtnView paramTeamActionBtnView) {}
  
  public void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      TeamActionBtnView localTeamActionBtnView = this.a;
      if (TeamActionBtnView.a(localTeamActionBtnView, localTeamActionBtnView.getContext())) {
        ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamActionBtnView.b(this.a)).c(new TeamActionBtnView.1.1(this));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamActionBtnView.1
 * JD-Core Version:    0.7.0.1
 */