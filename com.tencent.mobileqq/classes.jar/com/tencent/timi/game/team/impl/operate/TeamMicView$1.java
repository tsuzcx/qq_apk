package com.tencent.timi.game.team.impl.operate;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.mic.api.IMicService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;

class TeamMicView$1
  implements View.OnClickListener
{
  TeamMicView$1(TeamMicView paramTeamMicView, int paramInt, long paramLong) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.c;
    TeamMicView.a((TeamMicView)localObject, TeamMicView.a((TeamMicView)localObject));
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamMicView.a(this.c)).a("click mic btn");
    int i = this.a;
    if (i == 3)
    {
      CustomToastView.a("你已被房主禁麦，无法开启麦克风");
    }
    else
    {
      if (i == 1) {
        i = 2;
      } else {
        i = 1;
      }
      if (i == 1)
      {
        localObject = new TeamMicView.1.1(this, i);
        ((IMicService)ServiceCenter.a(IMicService.class)).a((CheckMicPermissionCallback)localObject);
      }
      else
      {
        TeamMicView.a(this.c, this.b, i);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.operate.TeamMicView.1
 * JD-Core Version:    0.7.0.1
 */