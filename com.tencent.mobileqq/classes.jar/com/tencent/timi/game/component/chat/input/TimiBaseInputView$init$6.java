package com.tencent.timi.game.component.chat.input;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/TimiBaseInputView$init$6", "Landroid/view/View$OnKeyListener;", "onKey", "", "v", "Landroid/view/View;", "keyCode", "", "event", "Landroid/view/KeyEvent;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiBaseInputView$init$6
  implements View.OnKeyListener
{
  public boolean onKey(@Nullable View paramView, int paramInt, @NotNull KeyEvent paramKeyEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramKeyEvent, "event");
    if ((paramKeyEvent.getKeyCode() == 67) && (paramKeyEvent.getAction() == 0))
    {
      this.a.j();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.init.6
 * JD-Core Version:    0.7.0.1
 */