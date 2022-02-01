package com.tencent.timi.game.component.chat.input;

import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/ExpandHallInputBoxView$layoutInflated$4", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallInputBoxView$layoutInflated$4
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      localObject = ExpandHallInputBoxView.h(this.a);
      if (localObject != null) {
        ((ConstraintLayout)localObject).setPadding(0, LayoutExKt.b(12), 0, LayoutExKt.b(18));
      }
    }
    else
    {
      localObject = ExpandHallInputBoxView.h(this.a);
      if (localObject != null) {
        ((ConstraintLayout)localObject).setPadding(0, LayoutExKt.b(12), 0, LayoutExKt.b(12));
      }
    }
    Object localObject = ExpandHallInputBoxView.i(this.a);
    if (localObject != null)
    {
      if (paramInt == 3) {
        paramInt = 2130852982;
      } else {
        paramInt = 2130852981;
      }
      ((ImageView)localObject).setBackgroundResource(paramInt);
    }
  }
  
  public void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
  }
  
  public void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    Intrinsics.checkParameterIsNotNull(paramMsgContent, "content");
    Intrinsics.checkParameterIsNotNull(paramTimiBaseInputView, "timiBaseInputView");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.ExpandHallInputBoxView.layoutInflated.4
 * JD-Core Version:    0.7.0.1
 */