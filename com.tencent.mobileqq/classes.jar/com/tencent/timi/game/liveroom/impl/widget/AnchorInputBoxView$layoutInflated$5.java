package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;
import trpc.yes.common.MessageOuterClass.TextMsg;
import trpc.yes.common.MessageOuterClass.TimMsgBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/widget/AnchorInputBoxView$layoutInflated$5", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorInputBoxView$layoutInflated$5
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    if (AnchorInputBoxView.f(this.a)) {
      return;
    }
    Object localObject = this.a;
    int j = 8;
    int i;
    if (paramInt == 1)
    {
      FrameLayout localFrameLayout = AnchorInputBoxView.b((AnchorInputBoxView)localObject);
      if (localFrameLayout != null) {
        localFrameLayout.removeAllViews();
      }
      i = 8;
    }
    else
    {
      i = 0;
    }
    ((AnchorInputBoxView)localObject).setVisibility(i);
    localObject = AnchorInputBoxView.g(this.a);
    if (localObject != null)
    {
      if (paramInt == 3) {
        i = 2130852973;
      } else {
        i = 2130852972;
      }
      ((View)localObject).setBackgroundResource(i);
    }
    localObject = AnchorInputBoxView.h(this.a);
    if (localObject != null)
    {
      i = j;
      if (paramInt != 1) {
        if (AnchorInputBoxView.f(this.a)) {
          i = j;
        } else {
          i = 0;
        }
      }
      ((View)localObject).setVisibility(i);
    }
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    paramTimiBaseInputView = new MessageOuterClass.TimMsgBody();
    paramTimiBaseInputView.msg_type.set(1);
    MessageOuterClass.MsgContent localMsgContent1 = paramTimiBaseInputView.content;
    MessageOuterClass.MsgContent localMsgContent2 = new MessageOuterClass.MsgContent();
    MessageOuterClass.TextMsg localTextMsg1 = localMsgContent2.text_msg;
    MessageOuterClass.TextMsg localTextMsg2 = new MessageOuterClass.TextMsg();
    localTextMsg2.text.set(paramString);
    localTextMsg1.set((MessageMicro)localTextMsg2);
    localMsgContent1.set((MessageMicro)localMsgContent2);
    AnchorInputBoxView.a(this.a, paramTimiBaseInputView, paramString);
    paramString = AnchorInputBoxView.c(this.a);
    if (paramString != null) {
      paramString.setText((CharSequence)"");
    }
    this.a.setState(1);
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    paramTimiBaseInputView = new MessageOuterClass.TimMsgBody();
    paramTimiBaseInputView.msg_type.set(70);
    paramTimiBaseInputView.content.set((MessageMicro)paramMsgContent);
    AnchorInputBoxView.a(this.a, paramTimiBaseInputView, paramString);
    paramString = AnchorInputBoxView.c(this.a);
    if (paramString != null) {
      paramString.setText((CharSequence)"");
    }
    this.a.setState(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AnchorInputBoxView.layoutInflated.5
 * JD-Core Version:    0.7.0.1
 */