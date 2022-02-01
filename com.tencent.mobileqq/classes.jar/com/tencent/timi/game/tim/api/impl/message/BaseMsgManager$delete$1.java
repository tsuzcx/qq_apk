package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.utils.Logger;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$delete$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "code", "", "desc", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$delete$1
  implements V2TIMCallback
{
  BaseMsgManager$delete$1(IMsg paramIMsg) {}
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    String str = BaseMsgManager.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete error: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    Logger.a(str, localStringBuilder.toString());
  }
  
  public void onSuccess()
  {
    this.b.a(MsgStatus.DELETE);
    Iterator localIterator = ((Iterable)this.a.a()).iterator();
    while (localIterator.hasNext()) {
      ((IMsgListener)localIterator.next()).d(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.delete.1
 * JD-Core Version:    0.7.0.1
 */