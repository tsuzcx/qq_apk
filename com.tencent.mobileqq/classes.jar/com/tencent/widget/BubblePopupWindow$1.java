package com.tencent.widget;

import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager.LayoutParams;
import java.lang.ref.WeakReference;

class BubblePopupWindow$1
  implements ViewTreeObserver.OnScrollChangedListener
{
  BubblePopupWindow$1(BubblePopupWindow paramBubblePopupWindow) {}
  
  public void onScrollChanged()
  {
    if (BubblePopupWindow.a(this.a) != null) {}
    WindowManager.LayoutParams localLayoutParams;
    for (View localView = (View)BubblePopupWindow.a(this.a).get();; localView = null)
    {
      if ((localView != null) && (BubblePopupWindow.a(this.a) != null))
      {
        localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.a(this.a).getLayoutParams();
        if (localLayoutParams != null) {
          break;
        }
      }
      return;
    }
    BubblePopupWindow.a(this.a, localView, localLayoutParams, BubblePopupWindow.a(this.a), BubblePopupWindow.b(this.a));
    this.a.a(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */