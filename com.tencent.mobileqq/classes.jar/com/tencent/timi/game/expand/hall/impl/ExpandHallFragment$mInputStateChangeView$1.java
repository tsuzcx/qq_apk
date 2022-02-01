package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.component.chat.input.TimiBaseInputView;
import com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener;
import com.tencent.timi.game.teamlist.view.TeamListView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mInputStateChangeView$1", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$mInputStateChangeView$1
  implements TimiBaseInputView.StateChangedListener
{
  public void a(int paramInt)
  {
    ExpandHallFragment localExpandHallFragment = this.a;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    ExpandHallFragment.b(localExpandHallFragment, bool);
    if (ExpandHallFragment.m(this.a))
    {
      ((TeamListView)this.a.c(2131446859)).b();
      return;
    }
    ((TeamListView)this.a.c(2131446859)).c();
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
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.mInputStateChangeView.1
 * JD-Core Version:    0.7.0.1
 */