package com.tencent.timi.game.team.impl;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

class TeamActivity$2$2
  implements Runnable
{
  TeamActivity$2$2(TeamActivity.2 param2) {}
  
  public void run()
  {
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(TeamActivity.b(this.a.a).room_id.get(), TeamActivity.e(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.TeamActivity.2.2
 * JD-Core Version:    0.7.0.1
 */