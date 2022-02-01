package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$receiveGiftMessageListener$1", "Lcom/tencent/mobileqq/qqlive/callback/gift/ReceiveGiftMessageListener;", "onError", "", "code", "", "msg", "", "onGiftMessageReceive", "giftMessage", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$receiveGiftMessageListener$1
  implements ReceiveGiftMessageListener
{
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNewGiftError:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(',');
    localStringBuilder.append(paramString);
    Logger.c("AnchorMessageLayout", localStringBuilder.toString());
  }
  
  public void a(@NotNull GiftMessage paramGiftMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramGiftMessage, "giftMessage");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onNewGift:");
    localStringBuilder.append(paramGiftMessage);
    Logger.c("AnchorMessageLayout", localStringBuilder.toString());
    if ((paramGiftMessage.comboOver) || (paramGiftMessage.allComboCnt == 0)) {
      this.a.a(paramGiftMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.receiveGiftMessageListener.1
 * JD-Core Version:    0.7.0.1
 */