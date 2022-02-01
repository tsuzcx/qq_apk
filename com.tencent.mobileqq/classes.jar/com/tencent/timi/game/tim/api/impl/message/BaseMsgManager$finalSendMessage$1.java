package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMSendCallback;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.Logger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$finalSendMessage$1", "Lcom/tencent/imsdk/v2/V2TIMSendCallback;", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "onError", "", "code", "", "desc", "", "onProgress", "progress", "onSuccess", "p0", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$finalSendMessage$1
  implements V2TIMSendCallback<V2TIMMessage>
{
  BaseMsgManager$finalSendMessage$1(MsgInfo paramMsgInfo) {}
  
  public void a(@Nullable V2TIMMessage paramV2TIMMessage)
  {
    this.b.a(MsgStatus.SUCCESS);
    paramV2TIMMessage = ((Iterable)this.a.a()).iterator();
    while (paramV2TIMMessage.hasNext()) {
      ((IMsgListener)paramV2TIMMessage.next()).c((IMsg)this.b);
    }
    paramV2TIMMessage = BaseMsgManager.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendMessage onSuccess: ");
    localStringBuilder.append(this.b.a());
    Logger.a(paramV2TIMMessage, localStringBuilder.toString());
    BaseMsgManager.b(this.a).remove(this.b);
    if ((((Collection)BaseMsgManager.b(this.a)).isEmpty() ^ true))
    {
      paramV2TIMMessage = this.a;
      BaseMsgManager.a(paramV2TIMMessage, (MsgInfo)BaseMsgManager.b(paramV2TIMMessage).get(0));
      BaseMsgManager.b(this.a).remove(0);
    }
  }
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    this.b.a(MsgStatus.FAILED);
    Object localObject = ((Iterable)this.a.a()).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IMsgListener)((Iterator)localObject).next()).a((IMsg)this.b, paramInt, paramString);
    }
    localObject = BaseMsgManager.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sendMessage error: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    Logger.c((String)localObject, localStringBuilder.toString());
    BaseMsgManager.b(this.a).remove(this.b);
    if ((((Collection)BaseMsgManager.b(this.a)).isEmpty() ^ true))
    {
      paramString = this.a;
      BaseMsgManager.a(paramString, (MsgInfo)BaseMsgManager.b(paramString).get(0));
      BaseMsgManager.b(this.a).remove(0);
    }
  }
  
  public void onProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.finalSendMessage.1
 * JD-Core Version:    0.7.0.1
 */