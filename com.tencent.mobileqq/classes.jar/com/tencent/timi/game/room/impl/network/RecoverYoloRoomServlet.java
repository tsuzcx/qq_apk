package com.tencent.timi.game.room.impl.network;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomRecoverReq;

public class RecoverYoloRoomServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(long paramLong)
  {
    YoloRoomOuterClass.YoloRoomRecoverReq localYoloRoomRecoverReq = new YoloRoomOuterClass.YoloRoomRecoverReq();
    localYoloRoomRecoverReq.room_id.set(paramLong);
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localYoloRoomRecoverReq, RecoverYoloRoomServlet.class);
  }
  
  protected int a()
  {
    return 923;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.RecoverYoloRoomServlet
 * JD-Core Version:    0.7.0.1
 */