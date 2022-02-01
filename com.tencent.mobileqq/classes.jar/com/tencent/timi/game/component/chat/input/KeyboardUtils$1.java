package com.tencent.timi.game.component.chat.input;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

final class KeyboardUtils$1
  extends ResultReceiver
{
  KeyboardUtils$1(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 1) || (paramInt == 3)) {
      KeyboardUtils.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.KeyboardUtils.1
 * JD-Core Version:    0.7.0.1
 */