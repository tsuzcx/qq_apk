package com.tencent.timi.game.component.chat.input;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/component/chat/input/TimiBaseInputView$showKeyBoard$1$1", "Landroid/os/ResultReceiver;", "onReceiveResult", "", "resultCode", "", "resultData", "Landroid/os/Bundle;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiBaseInputView$showKeyBoard$1$1
  extends ResultReceiver
{
  TimiBaseInputView$showKeyBoard$1$1(InputMethodManager paramInputMethodManager, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, @Nullable Bundle paramBundle)
  {
    if ((paramInt == 1) || (paramInt == 3)) {
      this.a.toggleSoftInput(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.TimiBaseInputView.showKeyBoard.1.1
 * JD-Core Version:    0.7.0.1
 */