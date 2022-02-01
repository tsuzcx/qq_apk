package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.team.impl.TeamActivity;
import com.tencent.timi.game.utils.FloatingPermission;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mRoomLifecycleListener$1", "Lcom/tencent/timi/game/room/api/YoloRoomInterface$YoloRoomLifecycleListener;", "onEnterRoom", "", "roomId", "", "roomType", "", "onExitRoom", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$mRoomLifecycleListener$1
  implements YoloRoomInterface.YoloRoomLifecycleListener
{
  public void a(long paramLong, int paramInt) {}
  
  public void b(long paramLong, int paramInt)
  {
    if ((paramLong == ExpandHallFragment.g(this.a)) && (paramInt == 5))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("finish when exit!! ");
      ((StringBuilder)localObject).append(paramLong);
      Logger.c("ExpandHallFragment_", ((StringBuilder)localObject).toString());
      localObject = TimiGameActivityManager.a();
      if ((localObject != null) && ((localObject instanceof TeamActivity)) && (FloatingPermission.a(this.a.getContext())))
      {
        if (((IRoomService)ServiceCenter.a(IRoomService.class)).a(1) != null)
        {
          ((ITeamService)ServiceCenter.a(ITeamService.class)).b(this.a.getContext());
          this.a.a(3);
        }
        Logger.a("ExpandHallFragment_", "finish with team Activity exit");
        return;
      }
      this.a.a(3);
      Logger.c("ExpandHallFragment_", "just hall Activity exit");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.mRoomLifecycleListener.1
 * JD-Core Version:    0.7.0.1
 */