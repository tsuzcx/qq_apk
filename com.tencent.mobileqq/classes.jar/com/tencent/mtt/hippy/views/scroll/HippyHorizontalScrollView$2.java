package com.tencent.mtt.hippy.views.scroll;

import android.os.Build.VERSION;
import android.os.Handler;

class HippyHorizontalScrollView$2
  implements Runnable
{
  private boolean mSnappingToPage = false;
  
  HippyHorizontalScrollView$2(HippyHorizontalScrollView paramHippyHorizontalScrollView) {}
  
  public void run()
  {
    boolean bool = HippyHorizontalScrollView.access$000(this.this$0);
    int j = 1;
    if (bool)
    {
      int i = j;
      if (HippyHorizontalScrollView.access$100(this.this$0))
      {
        i = j;
        if (!this.mSnappingToPage)
        {
          this.mSnappingToPage = true;
          HippyHorizontalScrollView.access$200(this.this$0, 0);
          i = 0;
        }
      }
      if (i != 0)
      {
        if (!HippyHorizontalScrollView.access$300(this.this$0)) {
          return;
        }
        HippyScrollViewEventHelper.emitScrollMomentumEndEvent(this.this$0);
        return;
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label112;
      }
    }
    else
    {
      HippyHorizontalScrollView.access$002(this.this$0, true);
      if (Build.VERSION.SDK_INT < 16) {
        break label112;
      }
    }
    this.this$0.postOnAnimationDelayed(this, 20L);
    return;
    label112:
    this.this$0.getHandler().postDelayed(this, 36L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.2
 * JD-Core Version:    0.7.0.1
 */