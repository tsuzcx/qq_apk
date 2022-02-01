package com.tencent.timi.game.liveroom.impl.inscription.net.servlet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetAnchorGameEquipRoleReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/net/servlet/SetAnchorGameEquipRoleServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "anchorId", "", "area", "", "partition", "equipStatus", "uId", "", "roomId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SetAnchorGameEquipRoleServlet$Companion
{
  @Nullable
  public final NewIntent a(@NotNull String paramString, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "anchorId");
    GameDataServerOuterClass.SetAnchorGameEquipRoleReq localSetAnchorGameEquipRoleReq = new GameDataServerOuterClass.SetAnchorGameEquipRoleReq();
    localSetAnchorGameEquipRoleReq.anchor_id.set(paramString);
    localSetAnchorGameEquipRoleReq.area.set(paramInt1);
    localSetAnchorGameEquipRoleReq.partition.set(paramInt2);
    localSetAnchorGameEquipRoleReq.equip_status.set(paramInt3);
    localSetAnchorGameEquipRoleReq.uid.set(paramLong1);
    localSetAnchorGameEquipRoleReq.room_id.set(paramLong2);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localSetAnchorGameEquipRoleReq, SetAnchorGameEquipRoleServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.net.servlet.SetAnchorGameEquipRoleServlet.Companion
 * JD-Core Version:    0.7.0.1
 */