package com.tencent.timi.game.room.impl.network;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.YoloRoomOuterClass.DoYoloRoomCmdReq;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCmdReq;

public class DoYoloRoomCmdServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(long paramLong1, int paramInt, long paramLong2, YoloRoomOuterClass.YoloRoomCmdReq paramYoloRoomCmdReq)
  {
    YoloRoomOuterClass.DoYoloRoomCmdReq localDoYoloRoomCmdReq = new YoloRoomOuterClass.DoYoloRoomCmdReq();
    localDoYoloRoomCmdReq.room_id.set(paramLong1);
    localDoYoloRoomCmdReq.cmd_type.set(paramInt);
    localDoYoloRoomCmdReq.client_seq_id.set(paramLong2);
    if (paramYoloRoomCmdReq != null) {
      localDoYoloRoomCmdReq.yolo_room_cmd_req.set(paramYoloRoomCmdReq);
    }
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localDoYoloRoomCmdReq, DoYoloRoomCmdServlet.class);
  }
  
  protected int a()
  {
    return 924;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.DoYoloRoomCmdServlet
 * JD-Core Version:    0.7.0.1
 */