package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$insertGroupMsg$1", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "onError", "", "code", "", "desc", "", "onSuccess", "p0", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$insertGroupMsg$1
  implements V2TIMValueCallback<V2TIMMessage>
{
  BaseMsgManager$insertGroupMsg$1(MsgInfo paramMsgInfo) {}
  
  public void a(@Nullable V2TIMMessage paramV2TIMMessage)
  {
    paramV2TIMMessage = BaseMsgManager.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("insertGroupMsg onSuccess: ");
    localStringBuilder.append(this.b.a());
    Logger.c(paramV2TIMMessage, localStringBuilder.toString());
    this.b.a(MsgStatus.SUCCESS);
  }
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    String str = BaseMsgManager.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("insertGroupMsg error: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    Logger.a(str, localStringBuilder.toString());
    this.b.a(MsgStatus.FAILED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.insertGroupMsg.1
 * JD-Core Version:    0.7.0.1
 */