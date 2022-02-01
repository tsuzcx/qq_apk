package com.tencent.timi.game.component.chat.message;

import android.view.View;
import com.tencent.timi.game.tim.api.message.IMsg;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/component/chat/message/MessageLayout$IView;", "", "contentView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "getLongOperOptions", "", "Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "()[Lcom/tencent/timi/game/component/chat/message/LongClickOperOption;", "isCenter", "", "refresh", "", "view", "msg", "Lcom/tencent/timi/game/tim/api/message/IMsg;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public abstract interface MessageLayout$IView
{
  public abstract void a(@NotNull View paramView, @NotNull IMsg paramIMsg);
  
  @Nullable
  public abstract LongClickOperOption[] a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.message.MessageLayout.IView
 * JD-Core Version:    0.7.0.1
 */