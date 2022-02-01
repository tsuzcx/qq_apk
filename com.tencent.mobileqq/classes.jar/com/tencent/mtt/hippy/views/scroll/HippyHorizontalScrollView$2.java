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
    int i = 0;
    if (HippyHorizontalScrollView.access$000(this.this$0))
    {
      if ((!HippyHorizontalScrollView.access$100(this.this$0)) || (this.mSnappingToPage)) {
        break label145;
      }
      this.mSnappingToPage = true;
      HippyHorizontalScrollView.access$200(this.this$0, 0);
    }
    for (;;)
    {
      if (i != 0)
      {
        if (HippyHorizontalScrollView.access$300(this.this$0)) {
          HippyScrollViewEventHelper.emitScrollMomentumEndEvent(this.this$0);
        }
        return;
      }
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimationDelayed(this, 20L);
        return;
      }
      this.this$0.getHandler().postDelayed(this, 36L);
      return;
      HippyHorizontalScrollView.access$002(this.this$0, true);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimationDelayed(this, 20L);
        return;
      }
      this.this$0.getHandler().postDelayed(this, 36L);
      return;
      label145:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyHorizontalScrollView.2
 * JD-Core Version:    0.7.0.1
 */