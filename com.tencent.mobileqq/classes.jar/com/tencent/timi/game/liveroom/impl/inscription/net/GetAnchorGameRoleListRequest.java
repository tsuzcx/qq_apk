package com.tencent.timi.game.liveroom.impl.inscription.net;

import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.GetAnchorGameRoleListServlet;
import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.GetAnchorGameRoleListServlet.Companion;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetAnchorGameRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorGameRoleListRequest;", "", "()V", "TAG", "", "requestAnchorGameRoleList", "", "anchorId", "gameId", "", "userId", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$GetAnchorGameRoleListRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetAnchorGameRoleListRequest
{
  public static final GetAnchorGameRoleListRequest a = new GetAnchorGameRoleListRequest();
  
  public final void a(@NotNull String paramString, int paramInt, long paramLong, @Nullable IResultListener<GameDataServerOuterClass.GetAnchorGameRoleListRsp> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "anchorId");
    Logger.a("GetAnchorRoomInfoRequest", "requestAnchorGameRoleList ");
    ((NetApi)ServiceCenter.a(NetApi.class)).a(GetAnchorGameRoleListServlet.a.a(paramString, paramInt, paramLong), GameDataServerOuterClass.GetAnchorGameRoleListRsp.class, (RequestListener)new GetAnchorGameRoleListRequest.requestAnchorGameRoleList.1(paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorGameRoleListRequest
 * JD-Core Version:    0.7.0.1
 */