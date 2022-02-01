package com.tencent.timi.game.room.impl.network;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.YoloRoomOuterClass.GetYoloRoomDataReq;

public class GetYoloRoomDataServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(long paramLong1, long paramLong2, int paramInt)
  {
    YoloRoomOuterClass.GetYoloRoomDataReq localGetYoloRoomDataReq = new YoloRoomOuterClass.GetYoloRoomDataReq();
    localGetYoloRoomDataReq.room_id.set(paramLong1);
    localGetYoloRoomDataReq.client_max_id.set(paramLong2);
    localGetYoloRoomDataReq.is_update_heartbeat.set(paramInt);
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localGetYoloRoomDataReq, GetYoloRoomDataServlet.class);
  }
  
  protected int a()
  {
    return 925;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.GetYoloRoomDataServlet
 * JD-Core Version:    0.7.0.1
 */