package com.tencent.mobileqq.widget;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class InputMethodRelativeLayout$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  InputMethodRelativeLayout$1(InputMethodRelativeLayout paramInputMethodRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    if (this.a.a != null)
    {
      int i = InputMethodRelativeLayout.a(this.a);
      if (i != InputMethodRelativeLayout.b(this.a))
      {
        int j = this.a.getRootView().getHeight();
        if (j - i > j / 4) {
          InputMethodRelativeLayout.a(this.a, true);
        } else {
          InputMethodRelativeLayout.a(this.a, false);
        }
        this.a.a.a(InputMethodRelativeLayout.c(this.a), InputMethodRelativeLayout.b(this.a), i);
        this.a.requestLayout();
        InputMethodRelativeLayout.a(this.a, i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodRelativeLayout.1
 * JD-Core Version:    0.7.0.1
 */