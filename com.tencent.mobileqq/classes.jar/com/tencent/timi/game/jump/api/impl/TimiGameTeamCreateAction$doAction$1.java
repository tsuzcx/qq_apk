package com.tencent.timi.game.jump.api.impl;

import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameTeamCreateAction$doAction$1
  implements InitCallback
{
  TimiGameTeamCreateAction$doAction$1(GuildShequnParams paramGuildShequnParams) {}
  
  public final void a(boolean paramBoolean)
  {
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d((IUserSmobaInfoService.Callback)new TimiGameTeamCreateAction.doAction.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.jump.api.impl.TimiGameTeamCreateAction.doAction.1
 * JD-Core Version:    0.7.0.1
 */