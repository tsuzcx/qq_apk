package com.tencent.timi.game.team.impl.team;

import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.utils.Logger;

class TeamContainerView$8
  implements YoloRoomInterface.YoloRoomLifecycleListener
{
  TeamContainerView$8(TeamContainerView paramTeamContainerView) {}
  
  public void a(long paramLong, int paramInt) {}
  
  public void b(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("YoloRoomLifecycleListener - onExitRoom: ");
    localStringBuilder.append(paramLong);
    Logger.a("TeamContainerView", localStringBuilder.toString());
    if (paramLong != 0L) {
      ((ITeamService)ServiceCenter.a(ITeamService.class)).b(this.a.getContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.8
 * JD-Core Version:    0.7.0.1
 */