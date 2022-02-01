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
    View localView;
    if (BubblePopupWindow.access$000(this.this$0) != null) {
      localView = (View)BubblePopupWindow.access$000(this.this$0).get();
    } else {
      localView = null;
    }
    if ((localView != null) && (BubblePopupWindow.access$100(this.this$0) != null))
    {
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)BubblePopupWindow.access$100(this.this$0).getLayoutParams();
      if (localLayoutParams == null) {
        return;
      }
      BubblePopupWindow localBubblePopupWindow = this.this$0;
      BubblePopupWindow.access$400(localBubblePopupWindow, localView, localLayoutParams, BubblePopupWindow.access$200(localBubblePopupWindow), BubblePopupWindow.access$300(this.this$0));
      this.this$0.update(localLayoutParams.x, localLayoutParams.y, -1, -1, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow.1
 * JD-Core Version:    0.7.0.1
 */