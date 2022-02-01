package com.tencent.timi.game.component.chat.input;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class KeyboardUtils$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
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
 * Qualified Name:     com.tencent.timi.game.component.chat.input.KeyboardUtils.2
 * JD-Core Version:    0.7.0.1
 */