package com.tencent.mtt.hippy.views.scroll;

import android.os.Build.VERSION;
import android.os.Handler;

class HippyVerticalScrollView$2
  implements Runnable
{
  private boolean mSnappingToPage = false;
  
  HippyVerticalScrollView$2(HippyVerticalScrollView paramHippyVerticalScrollView) {}
  
  public void run()
  {
    boolean bool = HippyVerticalScrollView.access$000(this.this$0);
    int j = 1;
    if (bool)
    {
      int i = j;
      if (HippyVerticalScrollView.access$100(this.this$0))
      {
        i = j;
        if (!this.mSnappingToPage)
        {
          this.mSnappingToPage = true;
          HippyVerticalScrollView.access$200(this.this$0, 0);
          i = 0;
        }
      }
      if (i != 0)
      {
        if (!HippyVerticalScrollView.access$300(this.this$0)) {
          return;
        }
        HippyScrollViewEventHelper.emitScrollMomentumEndEvent(this.this$0);
        return;
      }
      if (Build.VERSION.SDK_INT < 16) {
        this.this$0.getHandler().postDelayed(this, 36L);
      }
    }
    else
    {
      HippyVerticalScrollView.access$002(this.this$0, true);
      if (Build.VERSION.SDK_INT < 16) {
        break label128;
      }
    }
    this.this$0.postOnAnimationDelayed(this, 20L);
    return;
    label128:
    this.this$0.getHandler().postDelayed(this, 20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView.2
 * JD-Core Version:    0.7.0.1
 */