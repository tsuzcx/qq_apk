package com.tencent.timi.game.expand.hall.impl.gm.net;

import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.GetTopKuolieRoomListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/gm/net/GetTopKuolieRoomListRequest$requestRoomList$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetTopKuolieRoomListRequest$requestRoomList$1
  implements RequestListener<RecommendProxyOuterClass.GetTopKuolieRoomListRsp>
{
  GetTopKuolieRoomListRequest$requestRoomList$1(IResultListener paramIResultListener) {}
  
  public void a(@Nullable RecommendProxyOuterClass.GetTopKuolieRoomListRsp paramGetTopKuolieRoomListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    Logger.a(GetTopKuolieRoomListRequest.a(GetTopKuolieRoomListRequest.a), "requestRoomList - success ");
    paramFromServiceMsg = this.a;
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(paramGetTopKuolieRoomListRsp);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable RecommendProxyOuterClass.GetTopKuolieRoomListRsp paramGetTopKuolieRoomListRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramGetTopKuolieRoomListRsp = GetTopKuolieRoomListRequest.a(GetTopKuolieRoomListRequest.a);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("requestRoomList - onError ");
    paramFromServiceMsg.append(paramBoolean);
    paramFromServiceMsg.append("-");
    paramFromServiceMsg.append(paramInt1);
    paramFromServiceMsg.append(" -- ");
    paramFromServiceMsg.append(paramInt2);
    paramFromServiceMsg.append("-");
    paramFromServiceMsg.append(paramString1);
    paramFromServiceMsg.append("-");
    paramFromServiceMsg.append(paramString2);
    Logger.c(paramGetTopKuolieRoomListRsp, paramFromServiceMsg.toString());
    paramString2 = this.a;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.net.GetTopKuolieRoomListRequest.requestRoomList.1
 * JD-Core Version:    0.7.0.1
 */