package com.tencent.timi.game.room.impl.network;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import com.tencent.timi.game.room.api.GuildShequnParams;
import mqq.app.NewIntent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterReq;

public class JoinYoloRoomServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(long paramLong1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, GuildShequnParams paramGuildShequnParams, long paramLong2)
  {
    YoloRoomOuterClass.YoloRoomEnterReq localYoloRoomEnterReq = new YoloRoomOuterClass.YoloRoomEnterReq();
    localYoloRoomEnterReq.room_id.set(paramLong1);
    localYoloRoomEnterReq.enter_from.set(paramInt1);
    localYoloRoomEnterReq.sub_enter_from.set(paramInt2);
    localYoloRoomEnterReq.voice_switch.set(paramInt3);
    localYoloRoomEnterReq.room_type.set(paramInt4);
    if (paramGuildShequnParams != null)
    {
      localYoloRoomEnterReq.guild_id.set(paramGuildShequnParams.a);
      localYoloRoomEnterReq.channel_id.set(paramGuildShequnParams.b);
      localYoloRoomEnterReq.channel_name.set(paramGuildShequnParams.c);
    }
    if (paramLong2 != 0L) {
      localYoloRoomEnterReq.from_room_id.set(paramLong2);
    }
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localYoloRoomEnterReq, JoinYoloRoomServlet.class);
  }
  
  protected int a()
  {
    return 921;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.JoinYoloRoomServlet
 * JD-Core Version:    0.7.0.1
 */