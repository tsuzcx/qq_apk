package com.tencent.timi.game.component.chat;

import android.widget.EditText;
import com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/ChatView$createChat$3", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ChatView$createChat$3
  implements TimiBaseInputView.StateChangedListener
{
  ChatView$createChat$3(IMsgManager paramIMsgManager, CommonOuterClass.QQUserId paramQQUserId) {}
  
  public void a(int paramInt)
  {
    ((ExpandHallInputBoxView)this.a.a(2131435812)).b();
    if (paramInt != 1) {
      ((MessageLayoutImpl)this.a.a(2131438151)).post((Runnable)new ChatView.createChat.3.onStateChanged.1(this));
    }
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    if (NoDoubleClickUtils.b("tag_suspend_send_msg", ChatView.a(this.a)))
    {
      CustomToastView.a("说话太快了，休息一下吧");
      return;
    }
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramTimiBaseInputView = this.b;
      if (paramTimiBaseInputView != null) {
        paramString = paramTimiBaseInputView.a(this.c, paramString);
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = ((ExpandHallInputBoxView)this.a.a(2131435812)).getInputEditText();
        if (paramString != null) {
          paramString.setText((CharSequence)"");
        }
      }
    }
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    if (NoDoubleClickUtils.b("tag_suspend_send_msg", ChatView.a(this.a)))
    {
      CustomToastView.a("说话太快了，休息一下吧");
      return;
    }
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramTimiBaseInputView = this.b;
      if (paramTimiBaseInputView != null) {
        paramString = paramTimiBaseInputView.a(this.c, paramString, paramMsgContent);
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = ((ExpandHallInputBoxView)this.a.a(2131435812)).getInputEditText();
        if (paramString != null) {
          paramString.setText((CharSequence)"");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.ChatView.createChat.3
 * JD-Core Version:    0.7.0.1
 */