package com.tencent.timi.game.room.impl.network;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.RecommendProxyOuterClass.GetHallDiversionRecommendRoomReq;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterReq;

public class GetHallDiversionRecommendRoomServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(int paramInt1, int paramInt2, int paramInt3)
  {
    YoloRoomOuterClass.YoloRoomEnterReq localYoloRoomEnterReq = new YoloRoomOuterClass.YoloRoomEnterReq();
    localYoloRoomEnterReq.enter_from.set(paramInt1);
    localYoloRoomEnterReq.voice_switch.set(paramInt2);
    localYoloRoomEnterReq.room_type.set(paramInt3);
    RecommendProxyOuterClass.GetHallDiversionRecommendRoomReq localGetHallDiversionRecommendRoomReq = new RecommendProxyOuterClass.GetHallDiversionRecommendRoomReq();
    localGetHallDiversionRecommendRoomReq.enter_room_req.set(localYoloRoomEnterReq);
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localGetHallDiversionRecommendRoomReq, GetHallDiversionRecommendRoomServlet.class);
  }
  
  protected int a()
  {
    return 1101;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.GetHallDiversionRecommendRoomServlet
 * JD-Core Version:    0.7.0.1
 */