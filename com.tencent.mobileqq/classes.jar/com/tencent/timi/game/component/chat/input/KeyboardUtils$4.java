package com.tencent.timi.game.component.chat.input;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

final class KeyboardUtils$4
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public void onGlobalLayout()
  {
    int i = KeyboardUtils.c(this.a);
    if (this.b[0] != i)
    {
      View localView = this.c;
      localView.setPadding(localView.getPaddingLeft(), this.c.getPaddingTop(), this.c.getPaddingRight(), this.d + KeyboardUtils.b(this.a));
      this.b[0] = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.chat.input.KeyboardUtils.4
 * JD-Core Version:    0.7.0.1
 */