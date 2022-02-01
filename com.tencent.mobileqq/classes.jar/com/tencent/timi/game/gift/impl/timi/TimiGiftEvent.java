package com.tencent.timi.game.gift.impl.timi;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/gift/impl/timi/TimiGiftEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "giftMsg", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "roomId", "", "(Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;J)V", "getGiftMsg", "()Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "getRoomId", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGiftEvent
  extends SimpleBaseEvent
{
  @NotNull
  private final GiftMessage giftMsg;
  private final long roomId;
  
  public TimiGiftEvent(@NotNull GiftMessage paramGiftMessage, long paramLong)
  {
    this.giftMsg = paramGiftMessage;
    this.roomId = paramLong;
  }
  
  @NotNull
  public final GiftMessage component1()
  {
    return this.giftMsg;
  }
  
  public final long component2()
  {
    return this.roomId;
  }
  
  @NotNull
  public final TimiGiftEvent copy(@NotNull GiftMessage paramGiftMessage, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramGiftMessage, "giftMsg");
    return new TimiGiftEvent(paramGiftMessage, paramLong);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof TimiGiftEvent))
      {
        paramObject = (TimiGiftEvent)paramObject;
        if ((Intrinsics.areEqual(this.giftMsg, paramObject.giftMsg)) && (this.roomId == paramObject.roomId)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final GiftMessage getGiftMsg()
  {
    return this.giftMsg;
  }
  
  public final long getRoomId()
  {
    return this.roomId;
  }
  
  public int hashCode()
  {
    GiftMessage localGiftMessage = this.giftMsg;
    int i;
    if (localGiftMessage != null) {
      i = localGiftMessage.hashCode();
    } else {
      i = 0;
    }
    long l = this.roomId;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TimiGiftEvent(giftMsg=");
    localStringBuilder.append(this.giftMsg);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(this.roomId);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.gift.impl.timi.TimiGiftEvent
 * JD-Core Version:    0.7.0.1
 */