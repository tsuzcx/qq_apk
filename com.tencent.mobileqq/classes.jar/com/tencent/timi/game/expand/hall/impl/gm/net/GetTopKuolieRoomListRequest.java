package com.tencent.timi.game.expand.hall.impl.gm.net;

import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.RecommendProxyOuterClass.GetTopKuolieRoomListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/expand/hall/impl/gm/net/GetTopKuolieRoomListRequest;", "", "()V", "TAG", "", "requestRoomList", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$GetTopKuolieRoomListRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetTopKuolieRoomListRequest
{
  public static final GetTopKuolieRoomListRequest a = new GetTopKuolieRoomListRequest();
  private static final String b = "GetTopKuolieRoomListRequest";
  
  public final void a(@Nullable IResultListener<RecommendProxyOuterClass.GetTopKuolieRoomListRsp> paramIResultListener)
  {
    Logger.a(b, "requestAnchorGameRoleList ");
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetTopKuolieRoomListServlet.a.a(), RecommendProxyOuterClass.GetTopKuolieRoomListRsp.class, (RequestListener)new GetTopKuolieRoomListRequest.requestRoomList.1(paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.net.GetTopKuolieRoomListRequest
 * JD-Core Version:    0.7.0.1
 */