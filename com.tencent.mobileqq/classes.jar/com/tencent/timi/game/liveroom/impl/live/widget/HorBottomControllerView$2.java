package com.tencent.timi.game.liveroom.impl.live.widget;

import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/live/widget/HorBottomControllerView$2", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class HorBottomControllerView$2
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    HorInputBoxView localHorInputBoxView = (HorInputBoxView)this.a.a(2131435126);
    Intrinsics.checkExpressionValueIsNotNull(localHorInputBoxView, "horInputBoxView");
    int i;
    if (paramInt == 1) {
      i = 8;
    } else {
      i = 0;
    }
    localHorInputBoxView.setVisibility(i);
    if (HorBottomControllerView.c(this.a) == paramInt) {
      return;
    }
    HorBottomControllerView.a(this.a, paramInt);
    if (this.a.getForbidExpose()) {
      return;
    }
    if ((((HorInputBoxView)this.a.a(2131435126)).getPreState() != 1) && (paramInt == 1))
    {
      ((HorInputBoxView)this.a.a(2131435126)).a(true);
      return;
    }
    if ((((HorInputBoxView)this.a.a(2131435126)).getPreState() == 1) && (paramInt != 1)) {
      ((HorInputBoxView)this.a.a(2131435126)).a(false);
    }
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
    paramString = StringsKt.trim((CharSequence)paramString).toString();
    int i;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    ILiveMsgEven localILiveMsgEven = this.a.getLiveMsgEven();
    if (localILiveMsgEven != null) {
      localILiveMsgEven.a(paramString);
    }
    paramTimiBaseInputView.e();
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.live.widget.HorBottomControllerView.2
 * JD-Core Version:    0.7.0.1
 */