package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$checkLoginAndSendMessage$1", "Lcom/tencent/timi/game/tim/api/ILoginCallback;", "onError", "", "errorCode", "", "errorMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$checkLoginAndSendMessage$1
  implements ILoginCallback
{
  BaseMsgManager$checkLoginAndSendMessage$1(MsgInfo paramMsgInfo) {}
  
  public void a()
  {
    BaseMsgManager.a(this.a, this.b);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    this.b.a(MsgStatus.FAILED);
    Iterator localIterator = ((Iterable)this.a.a()).iterator();
    while (localIterator.hasNext()) {
      ((IMsgListener)localIterator.next()).a((IMsg)this.b, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.checkLoginAndSendMessage.1
 * JD-Core Version:    0.7.0.1
 */