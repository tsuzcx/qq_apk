package com.tencent.timi.game.team.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.float_window.BusFloatManager;
import com.tencent.timi.game.float_window.BusFloatManager.Companion;
import com.tencent.timi.game.float_window.FloatingAnimateInfo;
import com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout;
import com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout.WorldScaleListener;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TeamActivity$2
  implements WorldScaleLayout.WorldScaleListener
{
  TeamActivity$2(TeamActivity paramTeamActivity) {}
  
  public void a()
  {
    Object localObject = BusFloatManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TeamActivity.b(this.a).room_id.get());
    localStringBuilder.append("");
    localObject = ((BusFloatManager)localObject).c(localStringBuilder.toString());
    TeamActivity.a(this.a).a(((FloatingAnimateInfo)localObject).a(), ((FloatingAnimateInfo)localObject).b(), ((FloatingAnimateInfo)localObject).c(), ((FloatingAnimateInfo)localObject).d());
  }
  
  public void b()
  {
    this.a.overridePendingTransition(0, 0);
    TeamActivity.c(this.a);
    this.a.overridePendingTransition(0, 0);
    TeamActivity.a(this.a).post(new TeamActivity.2.1(this));
  }
  
  public void c()
  {
    Object localObject = BusFloatManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(TeamActivity.b(this.a).room_id.get());
    localStringBuilder.append("");
    localObject = ((BusFloatManager)localObject).c(localStringBuilder.toString());
    TeamActivity.a(this.a).a(((FloatingAnimateInfo)localObject).a(), ((FloatingAnimateInfo)localObject).b(), ((FloatingAnimateInfo)localObject).c(), ((FloatingAnimateInfo)localObject).d());
    TeamActivity.d(this.a);
    TeamActivity.a(this.a).post(new TeamActivity.2.2(this));
  }
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.2
 * JD-Core Version:    0.7.0.1
 */