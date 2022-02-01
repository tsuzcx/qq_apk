package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class InputMethodRelativeLayout$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  InputMethodRelativeLayout$1(InputMethodRelativeLayout paramInputMethodRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    int i;
    if (this.a.a != null)
    {
      i = InputMethodRelativeLayout.a(this.a);
      if (i != InputMethodRelativeLayout.b(this.a))
      {
        int j = this.a.getRootView().getHeight();
        if (j - i <= j / 4) {
          break label102;
        }
        InputMethodRelativeLayout.a(this.a, true);
      }
    }
    for (;;)
    {
      this.a.a.a(InputMethodRelativeLayout.a(this.a), InputMethodRelativeLayout.b(this.a), i);
      this.a.requestLayout();
      InputMethodRelativeLayout.a(this.a, i);
      return;
      label102:
      InputMethodRelativeLayout.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */