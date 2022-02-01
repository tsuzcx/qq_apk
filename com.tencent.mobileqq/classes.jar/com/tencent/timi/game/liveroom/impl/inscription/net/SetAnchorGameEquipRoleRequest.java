package com.tencent.timi.game.liveroom.impl.inscription.net;

import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.SetAnchorGameEquipRoleServlet;
import com.tencent.timi.game.liveroom.impl.inscription.net.servlet.SetAnchorGameEquipRoleServlet.Companion;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetAnchorGameEquipRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/SetAnchorGameEquipRoleRequest;", "", "()V", "TAG", "", "setAnchorGameEquipRole", "", "anchorId", "area", "", "partition", "equipStatus", "uId", "", "roomId", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/GameDataServerOuterClass$SetAnchorGameEquipRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SetAnchorGameEquipRoleRequest
{
  public static final SetAnchorGameEquipRoleRequest a = new SetAnchorGameEquipRoleRequest();
  
  public final void a(@NotNull String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, @Nullable IResultListener<GameDataServerOuterClass.SetAnchorGameEquipRoleRsp> paramIResultListener)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "anchorId");
    Logger.a("SetAnchorGameEquipRoleRequest", "SetAnchorGameEquipRoleRequest ");
    ((NetApi)ServiceCenter.a(NetApi.class)).a(SetAnchorGameEquipRoleServlet.a.a(paramString, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2), GameDataServerOuterClass.SetAnchorGameEquipRoleRsp.class, (RequestListener)new SetAnchorGameEquipRoleRequest.setAnchorGameEquipRole.1(paramIResultListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.SetAnchorGameEquipRoleRequest
 * JD-Core Version:    0.7.0.1
 */