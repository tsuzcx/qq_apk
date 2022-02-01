package com.tencent.timi.game.room.impl.network;

import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import mqq.app.NewIntent;
import trpc.yes.common.YoloRoomOuterClass.YoloCommunityRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloLiveRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCreateReq;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public class CreateYoloRoomServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(YoloRoomOuterClass.YoloRoomParams paramYoloRoomParams, YoloRoomOuterClass.YoloSmobaRoomParams paramYoloSmobaRoomParams, YoloRoomOuterClass.YoloCommunityRoomParams paramYoloCommunityRoomParams, YoloRoomOuterClass.YoloLiveRoomParams paramYoloLiveRoomParams)
  {
    YoloRoomOuterClass.YoloRoomCreateReq localYoloRoomCreateReq = new YoloRoomOuterClass.YoloRoomCreateReq();
    if (paramYoloRoomParams != null) {
      localYoloRoomCreateReq.room_params.set(paramYoloRoomParams);
    }
    if (paramYoloSmobaRoomParams != null) {
      localYoloRoomCreateReq.smoba_room_params.set(paramYoloSmobaRoomParams);
    }
    if (paramYoloCommunityRoomParams != null) {
      localYoloRoomCreateReq.comm_room_params.set(paramYoloCommunityRoomParams);
    }
    if (paramYoloLiveRoomParams != null) {
      localYoloRoomCreateReq.live_room_params.set(paramYoloLiveRoomParams);
    }
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localYoloRoomCreateReq, CreateYoloRoomServlet.class);
  }
  
  protected int a()
  {
    return 920;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.network.CreateYoloRoomServlet
 * JD-Core Version:    0.7.0.1
 */