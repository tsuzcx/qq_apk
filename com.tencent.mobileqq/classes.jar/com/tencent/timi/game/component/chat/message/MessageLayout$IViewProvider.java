package com.tencent.timi.game.component.chat.message;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayout$IViewProvider;", "", "filterForwardOption", "", "()Ljava/lang/Boolean;", "imConfig", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IIMConfig;", "intercept", "type", "", "onCreateView", "Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;", "parent", "Landroid/view/ViewGroup;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface MessageLayout$IViewProvider
{
  @Nullable
  public abstract MessageLayout.IIMConfig a();
  
  @Nullable
  public abstract Boolean b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayout.IViewProvider
 * JD-Core Version:    0.7.0.1
 */