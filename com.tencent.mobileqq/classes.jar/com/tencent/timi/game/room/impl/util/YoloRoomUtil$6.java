package com.tencent.timi.game.room.impl.util;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.TimiGameBaseActivity;
import com.tencent.timi.game.expand.hall.api.ExpandRoomListener;
import com.tencent.timi.game.expand.hall.api.data.GMChangeRoomInfo;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.room.impl.YoloRoomList;
import com.tencent.timi.game.room.impl.YoloRoomManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import com.yolo.esports.room.api.IRoomOperationService;
import trpc.yes.common.RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomCommonConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomConf;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomEnterRsp;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

final class YoloRoomUtil$6
  implements RequestListener<RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp>
{
  YoloRoomUtil$6(IResultListener paramIResultListener, Activity paramActivity) {}
  
  public void a(RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp paramGetHallDiversionRecommendRoomRsp, FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("YoloRoomUtil", "getAndEnterExpandHallRoom SUCCESS ");
    if ((paramGetHallDiversionRecommendRoomRsp != null) && (paramGetHallDiversionRecommendRoomRsp.enter_room_rsp.has()))
    {
      paramFromServiceMsg = paramGetHallDiversionRecommendRoomRsp.enter_room_rsp;
      ((IRoomOperationService)ServiceCenter.a(IRoomOperationService.class)).a(paramFromServiceMsg.room_info.room_id.get(), paramFromServiceMsg.rotate_messsage_list.get());
      YoloRoomList.a().a(1, paramFromServiceMsg.room_info, paramFromServiceMsg.room_speaking_pos_list.get(), paramFromServiceMsg.speaking_pos_list_version.get(), paramFromServiceMsg.cur_action_id.get(), paramFromServiceMsg.room_conf, paramFromServiceMsg.room_user_data);
      if ((paramFromServiceMsg.room_conf.has()) && (paramFromServiceMsg.room_conf.yolo_room_common_conf.has()))
      {
        YoloRoomManager localYoloRoomManager = YoloRoomList.a().b(paramFromServiceMsg.room_info.room_id.get());
        if (localYoloRoomManager != null) {
          localYoloRoomManager.a(paramFromServiceMsg.room_info.room_id.get(), paramFromServiceMsg.room_conf.yolo_room_common_conf.forbidden_speech_conf_list.get());
        }
      }
      paramFromServiceMsg = this.a;
      if ((paramFromServiceMsg instanceof ExpandRoomListener)) {
        ((ExpandRoomListener)paramFromServiceMsg).a(new GMChangeRoomInfo(paramGetHallDiversionRecommendRoomRsp.white_flag.get(), paramGetHallDiversionRecommendRoomRsp.room_list.get()));
      }
    }
    paramFromServiceMsg = this.b;
    if ((paramFromServiceMsg != null) && ((paramFromServiceMsg instanceof TimiGameBaseActivity)) && (!paramFromServiceMsg.isFinishing())) {
      ((TimiGameBaseActivity)this.b).b();
    }
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null)
    {
      if (paramGetHallDiversionRecommendRoomRsp != null) {
        paramGetHallDiversionRecommendRoomRsp = paramGetHallDiversionRecommendRoomRsp.enter_room_rsp.room_info;
      } else {
        paramGetHallDiversionRecommendRoomRsp = null;
      }
      paramFromServiceMsg.a(paramGetHallDiversionRecommendRoomRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable RecommendProxyOuterClass.GetHallDiversionRecommendRoomRsp paramGetHallDiversionRecommendRoomRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramString1 = new StringBuilder();
    paramString1.append("getAndEnterExpandHallRoom ERROR , errorCode=");
    paramString1.append(paramInt2);
    paramString1.append(", errorMessage=");
    paramString1.append(paramString2);
    Logger.c("YoloRoomUtil", paramString1.toString());
    paramString1 = this.b;
    if ((paramString1 != null) && ((paramString1 instanceof TimiGameBaseActivity)) && (!paramString1.isFinishing())) {
      ((TimiGameBaseActivity)this.b).b();
    }
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.a(paramInt2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.util.YoloRoomUtil.6
 * JD-Core Version:    0.7.0.1
 */