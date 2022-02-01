package com.tencent.viola.ui.view;

import android.view.MotionEvent;
import com.tencent.viola.ui.view.refresh.VRefreshViewGroup.TouchLifeCycle;

class VScrollView$2
  implements VRefreshViewGroup.TouchLifeCycle
{
  VScrollView$2(VScrollView paramVScrollView) {}
  
  public void onTouch(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i == 3) {}
        }
        else
        {
          VScrollView.access$102(this.this$0, true);
          return;
        }
      }
      VScrollView.access$102(this.this$0, false);
      VScrollView localVScrollView = this.this$0;
      VScrollView.access$002(localVScrollView, localVScrollView.getScrollY());
      float f = paramMotionEvent.getRawY();
      if (VScrollView.access$600(this.this$0) - f >= VScrollView.access$700(this.this$0))
      {
        paramMotionEvent = this.this$0;
        paramMotionEvent.removeCallbacks(VScrollView.access$800(paramMotionEvent));
        paramMotionEvent = this.this$0;
        paramMotionEvent.postDelayed(VScrollView.access$800(paramMotionEvent), 20L);
      }
    }
    else
    {
      VScrollView.access$602(this.this$0, paramMotionEvent.getRawY());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VScrollView.2
 * JD-Core Version:    0.7.0.1
 */