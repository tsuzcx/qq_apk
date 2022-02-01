package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/C2CMsgManager$markMsgAsRead$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "p0", "", "p1", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class C2CMsgManager$markMsgAsRead$1
  implements V2TIMCallback
{
  public void onError(int paramInt, @Nullable String paramString)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void onSuccess()
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(Boolean.valueOf(true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.C2CMsgManager.markMsgAsRead.1
 * JD-Core Version:    0.7.0.1
 */