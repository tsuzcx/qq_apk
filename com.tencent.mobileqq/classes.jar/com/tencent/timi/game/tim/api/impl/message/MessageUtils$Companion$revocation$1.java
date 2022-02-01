package com.tencent.timi.game.tim.api.impl.message;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.tim.api.message.MsgStatus;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/tim/api/impl/message/MessageUtils$Companion$revocation$1", "Lcom/tencent/imsdk/v2/V2TIMCallback;", "onError", "", "code", "", "desc", "", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class MessageUtils$Companion$revocation$1
  implements V2TIMCallback
{
  MessageUtils$Companion$revocation$1(IMsg paramIMsg) {}
  
  public void onError(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("revocation error: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    Logger.c("MessageUtils", localStringBuilder.toString());
    if ((paramInt == 20016) || (paramInt == 10031)) {
      MessageUtils.a.a();
    }
    if (!NetworkUtil.isNetworkAvailable()) {
      CustomToastView.a("操作失败，请检查网络连接");
    }
  }
  
  public void onSuccess()
  {
    this.a.a(MsgStatus.REVOKE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.impl.message.MessageUtils.Companion.revocation.1
 * JD-Core Version:    0.7.0.1
 */