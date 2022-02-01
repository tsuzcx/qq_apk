package com.tencent.timi.game.liveroom.impl.inscription.net;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorGameRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorGameRoleListRequest$requestAnchorGameRoleList$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorGameRoleListRequest$requestAnchorGameRoleList$1
  implements RequestListener<GameDataServerOuterClass.GetAnchorGameRoleListRsp>
{
  GetAnchorGameRoleListRequest$requestAnchorGameRoleList$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.GetAnchorGameRoleListRsp paramGetAnchorGameRoleListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramGetAnchorGameRoleListRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.GetAnchorGameRoleListRsp paramGetAnchorGameRoleListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramGetAnchorGameRoleListRsp = new StringBuilder();
    paramGetAnchorGameRoleListRsp.append("requestAnchorGameRoleList - onError ");
    paramGetAnchorGameRoleListRsp.append(paramBoolean);
    paramGetAnchorGameRoleListRsp.append("-");
    paramGetAnchorGameRoleListRsp.append(paramInt1);
    paramGetAnchorGameRoleListRsp.append(" -- ");
    paramGetAnchorGameRoleListRsp.append(paramInt2);
    paramGetAnchorGameRoleListRsp.append("-");
    paramGetAnchorGameRoleListRsp.append(paramString1);
    paramGetAnchorGameRoleListRsp.append("-");
    paramGetAnchorGameRoleListRsp.append(paramString2);
    Logger.c("GetAnchorRoomInfoRequest", paramGetAnchorGameRoleListRsp.toString());
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorGameRoleListRequest.requestAnchorGameRoleList.1
 * JD-Core Version:    0.7.0.1
 */