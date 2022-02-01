package com.tencent.timi.game.team.impl.team;

import com.tencent.timi.game.mic.api.CheckMicPermissionCallback;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;

class TeamContainerView$5
  implements CheckMicPermissionCallback
{
  TeamContainerView$5(TeamContainerView paramTeamContainerView) {}
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkMicPermission onChecked - ");
    localStringBuilder.append(paramBoolean);
    Logger.a("TeamContainerView", localStringBuilder.toString());
    if (!paramBoolean) {
      ((IRoomService)ServiceCenter.a(IRoomService.class)).b(TeamContainerView.f(this.a)).a(0L, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.5
 * JD-Core Version:    0.7.0.1
 */