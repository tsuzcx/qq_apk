package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMMessage;
import com.tencent.imsdk.v2.V2TIMMessageManager;
import com.tencent.imsdk.v2.V2TIMValueCallback;
import com.tencent.timi.game.tim.api.ILoginCallback;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/BaseMsgManager$checkLoginGetHistoryMsgList$1", "Lcom/tencent/timi/game/tim/api/ILoginCallback;", "onError", "", "errorCode", "", "errorMsg", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMsgManager$checkLoginGetHistoryMsgList$1
  implements ILoginCallback
{
  BaseMsgManager$checkLoginGetHistoryMsgList$1(int paramInt, IMsg paramIMsg) {}
  
  public void a()
  {
    Logger.b(BaseMsgManager.a(this.a), "checkLoginGetHistoryMsgList begin getHistory");
    BaseMsgManager.checkLoginGetHistoryMsgList.1.onSuccess.callback.1 local1 = new BaseMsgManager.checkLoginGetHistoryMsgList.1.onSuccess.callback.1(this);
    boolean bool = this.a.b();
    V2TIMMessageManager localV2TIMMessageManager = null;
    Object localObject1 = null;
    if (bool)
    {
      localV2TIMMessageManager = V2TIMManager.getMessageManager();
      localObject2 = this.a.c();
      i = this.b;
      localObject3 = this.c;
      if ((localObject3 instanceof MsgInfo)) {
        localObject1 = ((MsgInfo)localObject3).o();
      }
      localV2TIMMessageManager.getGroupHistoryMessageList((String)localObject2, i, (V2TIMMessage)localObject1, (V2TIMValueCallback)local1);
      return;
    }
    Object localObject2 = V2TIMManager.getMessageManager();
    Object localObject3 = this.a.c();
    int i = this.b;
    IMsg localIMsg = this.c;
    localObject1 = localV2TIMMessageManager;
    if ((localIMsg instanceof MsgInfo)) {
      localObject1 = ((MsgInfo)localIMsg).o();
    }
    ((V2TIMMessageManager)localObject2).getC2CHistoryMessageList((String)localObject3, i, (V2TIMMessage)localObject1, (V2TIMValueCallback)local1);
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    Logger.b(BaseMsgManager.a(this.a), "checkLoginGetHistoryMsgList login onError");
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.BaseMsgManager.checkLoginGetHistoryMsgList.1
 * JD-Core Version:    0.7.0.1
 */