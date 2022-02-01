package com.tencent.timi.game.component.chat.message;

import android.widget.TextView;
import com.tencent.timi.game.tim.api.message.IMsg;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/message/BaseMessageView$refresh$2", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BaseMessageView$refresh$2
  implements IResultListener<IUserInfo>
{
  BaseMessageView$refresh$2(IMsg paramIMsg) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    paramString = (TextView)this.a.a(2131444750);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "revokeView");
    paramString.setText((CharSequence)"\"--\" 撤回了一条消息");
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    TextView localTextView = (TextView)this.a.a(2131444750);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "revokeView");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('"');
    if (paramIUserInfo != null) {
      paramIUserInfo = paramIUserInfo.c(this.b.d());
    } else {
      paramIUserInfo = null;
    }
    localStringBuilder.append(paramIUserInfo);
    localStringBuilder.append("\" 撤回了一条消息");
    localTextView.setText((CharSequence)localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.BaseMessageView.refresh.2
 * JD-Core Version:    0.7.0.1
 */