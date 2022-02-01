package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.timi.game.tim.api.message.IMsgListener;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$checkLoginGetHistoryMsgList$1$onSuccess$callback$1", "Lcom/tencent/imsdk/v2/V2TIMValueCallback;", "", "Lcom/tencent/imsdk/v2/V2TIMMessage;", "onError", "", "p0", "", "p1", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$checkLoginGetHistoryMsgList$1$onSuccess$callback$1
  implements V2TIMValueCallback<List<V2TIMMessage>>
{
  public void a(@Nullable List<V2TIMMessage> paramList)
  {
    Logger.b(BaseMsgManager.a(this.a.a), "checkLoginGetHistoryMsgList onSuccess");
    this.a.a.a(false);
    if (paramList != null)
    {
      Iterator localIterator = ((Iterable)this.a.a.a()).iterator();
      while (localIterator.hasNext())
      {
        IMsgListener localIMsgListener = (IMsgListener)localIterator.next();
        Object localObject = (Iterable)CollectionsKt.reversed((Iterable)paramList);
        Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
        localObject = ((Iterable)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localCollection.add(new MsgInfo((V2TIMMessage)((Iterator)localObject).next()));
        }
        localIMsgListener.a((List)localCollection);
      }
    }
  }
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    Logger.b(BaseMsgManager.a(this.a.a), "checkLoginGetHistoryMsgList onError");
    this.a.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.checkLoginGetHistoryMsgList.1.onSuccess.callback.1
 * JD-Core Version:    0.7.0.1
 */