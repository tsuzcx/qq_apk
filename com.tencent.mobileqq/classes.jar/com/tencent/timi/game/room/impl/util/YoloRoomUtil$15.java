package com.tencent.timi.game.room.impl.util;

import androidx.lifecycle.LiveData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomAudioService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.SimpleTaskListener;
import java.util.concurrent.ConcurrentHashMap;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid;
import trpc.yes.common.YoloBattleOuterClass.YoloBattleBaseInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloGameRouteInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaGameRouteInfo;

final class YoloRoomUtil$15
  implements SimpleTaskListener<IUserInfo>
{
  YoloRoomUtil$15(YoloRoomOuterClass.YoloRoomInfo paramYoloRoomInfo, long paramLong) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    ConcurrentHashMap localConcurrentHashMap = YoloRoomUtil.c(this.a);
    long l;
    if ((this.a.game_route_info.has()) && (this.a.game_route_info.smoba_game_route_info.has()) && (this.a.game_route_info.smoba_game_route_info.base_info.has())) {
      l = this.a.game_route_info.smoba_game_route_info.base_info.yolo_battle_id.get();
    } else {
      l = 0L;
    }
    localConcurrentHashMap.put("yes_launch_id", String.valueOf(l));
    boolean bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).d(this.b).b();
    String str2 = "0";
    if (bool) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    localConcurrentHashMap.put("yes_voice_status", str1);
    String str1 = str2;
    if (((IRoomService)ServiceCenter.a(IRoomService.class)).d(this.b).a()) {
      str1 = "1";
    }
    localConcurrentHashMap.put("yes_mic_status", str1);
    localConcurrentHashMap.put("yes_game_platid", "1");
    if ((paramIUserInfo != null) && (paramIUserInfo.b() != null) && (paramIUserInfo.b().smoba_openid != null)) {
      localConcurrentHashMap.put("yes_game_openid", paramIUserInfo.b().smoba_openid.get());
    }
    paramIUserInfo = ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a();
    if ((paramIUserInfo != null) && (paramIUserInfo.getValue() != null))
    {
      localConcurrentHashMap.put("yes_game_areaid", String.valueOf(((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)paramIUserInfo.getValue()).role_info.area.get()));
      localConcurrentHashMap.put("yes_game_worldid", String.valueOf(((GameDataServerOuterClass.GetSmobaDefaultRoleRsp)paramIUserInfo.getValue()).role_info.partition.get()));
    }
    ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_game_launch_success", localConcurrentHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.15
 * JD-Core Version:    0.7.0.1
 */