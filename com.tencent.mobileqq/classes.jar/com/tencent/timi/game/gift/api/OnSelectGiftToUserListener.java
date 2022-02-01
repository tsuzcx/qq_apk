package com.tencent.timi.game.gift.api;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/api/OnSelectGiftToUserListener;", "", "onSelect", "", "chosenUidList", "", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "giftUrl", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface OnSelectGiftToUserListener
{
  public abstract void a(@NotNull List<CommonOuterClass.QQUserId> paramList, @Nullable String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.api.OnSelectGiftToUserListener
 * JD-Core Version:    0.7.0.1
 */