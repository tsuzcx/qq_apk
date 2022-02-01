package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/GiftResourceManager$IGiftResourceListener;", "", "onGiftResourceReady", "", "giftServiceData", "", "Lcom/tencent/mobileqq/qqgift/data/service/GiftServiceData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface GiftResourceManager$IGiftResourceListener
{
  public abstract void a(@NotNull List<? extends GiftServiceData> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.GiftResourceManager.IGiftResourceListener
 * JD-Core Version:    0.7.0.1
 */