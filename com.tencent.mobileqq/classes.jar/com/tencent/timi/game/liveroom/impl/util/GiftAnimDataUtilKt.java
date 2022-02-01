package com.tencent.timi.game.liveroom.impl.util;

import com.tencent.mobileqq.qqgift.mvvm.business.anim.GiftAnimData;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getGiftAnimData", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/GiftAnimData;", "giftMessage", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class GiftAnimDataUtilKt
{
  @NotNull
  public static final GiftAnimData a(@NotNull GiftMessage paramGiftMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramGiftMessage, "giftMessage");
    GiftAnimData localGiftAnimData = new GiftAnimData();
    localGiftAnimData.a = paramGiftMessage.giftID;
    localGiftAnimData.b = paramGiftMessage.giftType;
    localGiftAnimData.c = paramGiftMessage.giftName;
    localGiftAnimData.d = paramGiftMessage.materialID;
    localGiftAnimData.e = paramGiftMessage.giftNum;
    localGiftAnimData.g = paramGiftMessage.sender;
    localGiftAnimData.h = paramGiftMessage.senderNick;
    localGiftAnimData.k = paramGiftMessage.senderHead;
    localGiftAnimData.j = paramGiftMessage.receiverNick;
    localGiftAnimData.l = paramGiftMessage.receiverHead;
    localGiftAnimData.m = paramGiftMessage.effectLevel;
    localGiftAnimData.n = paramGiftMessage.comboSeq;
    localGiftAnimData.o = paramGiftMessage.allComboCnt;
    return localGiftAnimData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.util.GiftAnimDataUtilKt
 * JD-Core Version:    0.7.0.1
 */