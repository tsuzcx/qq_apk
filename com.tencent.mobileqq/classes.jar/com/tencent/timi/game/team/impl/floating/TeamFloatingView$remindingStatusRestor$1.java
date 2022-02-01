package com.tencent.timi.game.team.impl.floating;

import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/floating/TeamFloatingView$remindingStatusRestor$1", "Ljava/lang/Runnable;", "run", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamFloatingView$remindingStatusRestor$1
  implements Runnable
{
  public void run()
  {
    if (TeamFloatingView.a.b())
    {
      IRoomGetDataService localIRoomGetDataService = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.this$0.getRoomId());
      Intrinsics.checkExpressionValueIsNotNull(localIRoomGetDataService, "ServiceCenter.getService…         .getData(roomId)");
      if (3 == localIRoomGetDataService.i()) {
        TeamFloatingView.a(this.this$0, "游戏中", false);
      } else {
        TeamFloatingView.a(this.this$0, "组队中", false);
      }
    }
    this.this$0.removeCallbacks((Runnable)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.floating.TeamFloatingView.remindingStatusRestor.1
 * JD-Core Version:    0.7.0.1
 */