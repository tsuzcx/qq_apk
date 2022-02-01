package com.tencent.timi.game.liveroom.impl.inscription.net;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.liveroom.impl.AnchorLiveSysMsgEvent;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AnchorGameInfo;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorRoomInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest$requestAnchorRoomInfo$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorRoomInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorRoomInfoRequest$requestAnchorRoomInfo$1
  implements RequestListener<GameDataServerOuterClass.GetAnchorRoomInfoRsp>
{
  GetAnchorRoomInfoRequest$requestAnchorRoomInfo$1(long paramLong, IResultListener paramIResultListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.GetAnchorRoomInfoRsp paramGetAnchorRoomInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a("GetAnchorRoomInfoRequest", "requestAnchorRoomInfo success");
    GetAnchorRoomInfoRequest.Result localResult = new GetAnchorRoomInfoRequest.Result();
    localResult.a(this.a);
    if (paramGetAnchorRoomInfoRsp != null)
    {
      paramFromServiceMsg = paramGetAnchorRoomInfoRsp.game_info;
      if (paramFromServiceMsg != null)
      {
        paramFromServiceMsg = (GameDataServerOuterClass.AnchorGameInfo)paramFromServiceMsg.get();
        break label51;
      }
    }
    paramFromServiceMsg = null;
    label51:
    localResult.a(paramFromServiceMsg);
    boolean bool = false;
    if (paramGetAnchorRoomInfoRsp != null)
    {
      paramFromServiceMsg = paramGetAnchorRoomInfoRsp.refresh_interval;
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.get();
        break label83;
      }
    }
    int i = 0;
    label83:
    localResult.a(i * 1000);
    if (paramGetAnchorRoomInfoRsp != null)
    {
      paramFromServiceMsg = paramGetAnchorRoomInfoRsp.equip_setting_status;
      if (paramFromServiceMsg != null)
      {
        i = paramFromServiceMsg.get();
        break label116;
      }
    }
    i = 0;
    label116:
    if (i == 1) {
      bool = true;
    }
    localResult.a(bool);
    paramFromServiceMsg = this.b;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(localResult);
    }
    if (paramGetAnchorRoomInfoRsp != null)
    {
      paramGetAnchorRoomInfoRsp = paramGetAnchorRoomInfoRsp.tips;
      if (paramGetAnchorRoomInfoRsp != null)
      {
        paramGetAnchorRoomInfoRsp = paramGetAnchorRoomInfoRsp.get();
        if (paramGetAnchorRoomInfoRsp != null) {
          SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new AnchorLiveSysMsgEvent(this.a, paramGetAnchorRoomInfoRsp));
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.GetAnchorRoomInfoRsp paramGetAnchorRoomInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramGetAnchorRoomInfoRsp = new StringBuilder();
    paramGetAnchorRoomInfoRsp.append("requestAnchorRoomInfo - onError ");
    paramGetAnchorRoomInfoRsp.append(paramBoolean);
    paramGetAnchorRoomInfoRsp.append("-");
    paramGetAnchorRoomInfoRsp.append(paramInt1);
    paramGetAnchorRoomInfoRsp.append(" -- ");
    paramGetAnchorRoomInfoRsp.append(paramInt2);
    paramGetAnchorRoomInfoRsp.append("-");
    paramGetAnchorRoomInfoRsp.append(paramString1);
    paramGetAnchorRoomInfoRsp.append("-");
    paramGetAnchorRoomInfoRsp.append(paramString2);
    Logger.c("GetAnchorRoomInfoRequest", paramGetAnchorRoomInfoRsp.toString());
    paramString2 = this.b;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest.requestAnchorRoomInfo.1
 * JD-Core Version:    0.7.0.1
 */