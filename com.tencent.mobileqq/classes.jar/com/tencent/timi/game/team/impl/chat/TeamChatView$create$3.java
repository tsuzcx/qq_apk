package com.tencent.timi.game.team.impl.chat;

import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.component.chat.message.MessageLayoutImpl;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$create$3", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$create$3
  implements TimiBaseInputView.StateChangedListener
{
  TeamChatView$create$3(CommonOuterClass.QQUserId paramQQUserId) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1) {
      TeamChatView.d(this.a).setVisibility(8);
    } else if (paramInt == 2) {
      TeamChatView.d(this.a).setVisibility(0);
    }
    Object localObject = TeamChatView.a(this.a).getLayoutParams();
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)localObject;
      if (paramInt == 1) {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131446906);
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131435812);
      }
      TeamChatView.a(this.a).setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramInt != 1) {
        TeamChatView.a(this.a).a();
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    if (NoDoubleClickUtils.b("tag_suspend_send_msg", TeamChatView.c(this.a)))
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
      paramTimiBaseInputView = this.a.getIMsgManager();
      if (paramTimiBaseInputView != null) {
        paramString = paramTimiBaseInputView.a(this.b, paramString);
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = TeamChatView.d(this.a).getInputEditText();
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
    if (NoDoubleClickUtils.b("tag_suspend_send_msg", TeamChatView.c(this.a)))
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
      paramTimiBaseInputView = this.a.getIMsgManager();
      if (paramTimiBaseInputView != null) {
        paramString = paramTimiBaseInputView.a(this.b, paramString, paramMsgContent);
      } else {
        paramString = null;
      }
      if (paramString != null)
      {
        paramString = TeamChatView.d(this.a).getInputEditText();
        if (paramString != null) {
          paramString.setText((CharSequence)"");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.create.3
 * JD-Core Version:    0.7.0.1
 */