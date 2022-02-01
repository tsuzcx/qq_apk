package com.tencent.timi.game.teamlist.util;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamListUtil
{
  public static void a()
  {
    Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null)
    {
      ((IExpandHall)localObject).g();
      return;
    }
    localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(5);
    ITeamService localITeamService = (ITeamService)ServiceCenter.a(ITeamService.class);
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    long l;
    if (localObject != null) {
      l = ((YoloRoomOuterClass.YoloRoomInfo)localObject).room_id.get();
    } else {
      l = 0L;
    }
    localITeamService.a(localQBaseActivity, 1, 1, l, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.util.TeamListUtil
 * JD-Core Version:    0.7.0.1
 */