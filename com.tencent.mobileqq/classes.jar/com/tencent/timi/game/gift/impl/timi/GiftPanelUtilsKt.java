package com.tencent.timi.game.gift.impl.timi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.timi.game.gift.impl.event.GiftPanelControlEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dismissGiftPanel", "", "roomId", "", "certainUid", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "showGiftPanel", "subSceneId", "", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class GiftPanelUtilsKt
{
  public static final void a(long paramLong, @NotNull CommonOuterClass.QQUserId paramQQUserId, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserId, "certainUid");
    Intrinsics.checkParameterIsNotNull(paramString, "subSceneId");
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new GiftPanelControlEvent(true, 0, paramQQUserId, Long.valueOf(paramLong), paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.GiftPanelUtilsKt
 * JD-Core Version:    0.7.0.1
 */