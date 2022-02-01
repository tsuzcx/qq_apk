package com.tencent.timi.game.component.chat.input;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;

final class KeyboardUtils$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  KeyboardUtils$3(Window paramWindow, int[] paramArrayOfInt, KeyboardUtils.OnSoftInputChangedListener paramOnSoftInputChangedListener) {}
  
  public void onGlobalLayout()
  {
    int i = KeyboardUtils.b(this.a);
    if (this.b[0] != i)
    {
      this.c.a(i);
      this.b[0] = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.KeyboardUtils.3
 * JD-Core Version:    0.7.0.1
 */