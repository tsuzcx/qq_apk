package com.tencent.timi.game.liveroom.impl.inscription.net;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetAnchorGameEquipRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/net/SetAnchorGameEquipRoleRequest$setAnchorGameEquipRole$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SetAnchorGameEquipRoleRequest$setAnchorGameEquipRole$1
  implements RequestListener<GameDataServerOuterClass.SetAnchorGameEquipRoleRsp>
{
  SetAnchorGameEquipRoleRequest$setAnchorGameEquipRole$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable GameDataServerOuterClass.SetAnchorGameEquipRoleRsp paramSetAnchorGameEquipRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramSetAnchorGameEquipRoleRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.SetAnchorGameEquipRoleRsp paramSetAnchorGameEquipRoleRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramSetAnchorGameEquipRoleRsp = new StringBuilder();
    paramSetAnchorGameEquipRoleRsp.append("setAnchorGameEquipRole - onError ");
    paramSetAnchorGameEquipRoleRsp.append(paramBoolean);
    paramSetAnchorGameEquipRoleRsp.append("-");
    paramSetAnchorGameEquipRoleRsp.append(paramInt1);
    paramSetAnchorGameEquipRoleRsp.append(" -- ");
    paramSetAnchorGameEquipRoleRsp.append(paramInt2);
    paramSetAnchorGameEquipRoleRsp.append("-");
    paramSetAnchorGameEquipRoleRsp.append(paramString1);
    paramSetAnchorGameEquipRoleRsp.append("-");
    paramSetAnchorGameEquipRoleRsp.append(paramString2);
    Logger.c("SetAnchorGameEquipRoleRequest", paramSetAnchorGameEquipRoleRsp.toString());
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.SetAnchorGameEquipRoleRequest.setAnchorGameEquipRole.1
 * JD-Core Version:    0.7.0.1
 */