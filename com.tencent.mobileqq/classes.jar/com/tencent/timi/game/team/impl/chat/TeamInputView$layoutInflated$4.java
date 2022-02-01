package com.tencent.timi.game.team.impl.chat;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.ex.LayoutExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamInputView$layoutInflated$4", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamInputView$layoutInflated$4
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      localObject = TeamInputView.e(this.a);
      if (localObject != null) {
        ((FrameLayout)localObject).removeAllViews();
      }
      localObject = TeamInputView.f(this.a);
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(16));
      }
    }
    else
    {
      localObject = TeamInputView.f(this.a);
      if (localObject != null) {
        TeamInputViewKt.a((View)localObject, LayoutExKt.b(12));
      }
    }
    Object localObject = TeamInputView.f(this.a);
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
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamInputView.layoutInflated.4
 * JD-Core Version:    0.7.0.1
 */