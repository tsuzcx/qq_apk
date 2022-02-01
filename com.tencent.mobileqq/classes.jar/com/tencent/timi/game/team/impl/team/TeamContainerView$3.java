package com.tencent.timi.game.team.impl.team;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.component.chat.message.IMessageListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

class TeamContainerView$3
  implements IMessageListener
{
  TeamContainerView$3(TeamContainerView paramTeamContainerView) {}
  
  public void a(@NotNull CommonOuterClass.QQUserId paramQQUserId)
  {
    boolean bool = ((ITeamService)ServiceCenter.a(ITeamService.class)).b(TeamContainerView.f(this.a));
    TimiGameBaseActivity localTimiGameBaseActivity = TimiGameActivityManager.b();
    if (localTimiGameBaseActivity != null) {
      FleetProfileUtil.a.a(localTimiGameBaseActivity, paramQQUserId, bool, paramQQUserId.uid.get(), TeamContainerView.f(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamContainerView.3
 * JD-Core Version:    0.7.0.1
 */