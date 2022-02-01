package com.tencent.timi.game.team.impl.setting;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

final class TeamLaneHelper$1
  implements IResultListener<YoloRoomOuterClass.YoloRoomCmdRsp>
{
  TeamLaneHelper$1(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, CommonOuterClass.QQUserId paramQQUserId, int paramInt, IResultListener paramIResultListener) {}
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("chooseHeroLane failed, errorCode == ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(",errorMessage == ");
    ((StringBuilder)localObject).append(paramString);
    Logger.c("TeamLaneHelper", ((StringBuilder)localObject).toString());
    localObject = this.d;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(YoloRoomOuterClass.YoloRoomCmdRsp paramYoloRoomCmdRsp)
  {
    Logger.a("TeamLaneHelper", "chooseHeroLane success ");
    if (!NoDoubleClickUtils.b("tag_choose_lane_interval", TeamLaneHelper.b())) {
      ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).b(this.a.tim_group_id.get()).a(this.b, TeamLaneHelper.b(this.c));
    } else {
      Logger.c("TeamLaneHelper", "chooseHeroLane error : choose hero lane too fast");
    }
    IResultListener localIResultListener = this.d;
    if (localIResultListener != null) {
      localIResultListener.a(paramYoloRoomCmdRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.setting.TeamLaneHelper.1
 * JD-Core Version:    0.7.0.1
 */