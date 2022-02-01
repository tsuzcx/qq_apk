package com.tencent.timi.game.component.chat.input;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass.MsgContent;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView$StateChangedListener;", "", "onAt", "", "text", "", "content", "Ltrpc/yes/common/MessageOuterClass$MsgContent;", "timiBaseInputView", "Lcom/tencent/timi/game/component/chat/input/TimiBaseInputView;", "onStateChanged", "state", "", "onText", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface TimiBaseInputView$StateChangedListener
{
  public abstract void a(int paramInt);
  
  public abstract void a(@NotNull String paramString, @NotNull TimiBaseInputView paramTimiBaseInputView);
  
  public abstract void a(@NotNull String paramString, @NotNull MessageOuterClass.MsgContent paramMsgContent, @NotNull TimiBaseInputView paramTimiBaseInputView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.StateChangedListener
 * JD-Core Version:    0.7.0.1
 */