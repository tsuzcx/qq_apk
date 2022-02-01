package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class BaseMsgManager$sendMessage$1
  implements Runnable
{
  BaseMsgManager$sendMessage$1(BaseMsgManager paramBaseMsgManager, MsgInfo paramMsgInfo, boolean paramBoolean) {}
  
  public final void run()
  {
    this.a.a(MsgStatus.SENDING);
    Object localObject1 = ((Iterable)this.this$0.a()).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (IMsgListener)((Iterator)localObject1).next();
      if (this.b) {
        ((IMsgListener)localObject2).b((IMsg)this.a);
      } else {
        ((IMsgListener)localObject2).a((IMsg)this.a);
      }
    }
    localObject1 = BaseMsgManager.a(this.this$0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("sendMessage ");
    ((StringBuilder)localObject2).append(this.a.a());
    ((StringBuilder)localObject2).append(", resend=");
    ((StringBuilder)localObject2).append(this.b);
    Logger.a((String)localObject1, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.sendMessage.1
 * JD-Core Version:    0.7.0.1
 */