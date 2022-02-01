package com.tencent.mobileqq.widget;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

class PopupWindowWithMask$1
  implements View.OnKeyListener
{
  PopupWindowWithMask$1(PopupWindowWithMask paramPopupWindowWithMask) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      PopupWindowWithMask.a(this.a);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PopupWindowWithMask.1
 * JD-Core Version:    0.7.0.1
 */