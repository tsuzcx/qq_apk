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
    int i = 0;
    if (HippyVerticalScrollView.access$000(this.this$0))
    {
      if ((!HippyVerticalScrollView.access$100(this.this$0)) || (this.mSnappingToPage)) {
        break label145;
      }
      this.mSnappingToPage = true;
      HippyVerticalScrollView.access$200(this.this$0, 0);
    }
    for (;;)
    {
      if (i != 0)
      {
        if (HippyVerticalScrollView.access$300(this.this$0)) {
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
      HippyVerticalScrollView.access$002(this.this$0, true);
      if (Build.VERSION.SDK_INT >= 16)
      {
        this.this$0.postOnAnimationDelayed(this, 20L);
        return;
      }
      this.this$0.getHandler().postDelayed(this, 20L);
      return;
      label145:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.scroll.HippyVerticalScrollView.2
 * JD-Core Version:    0.7.0.1
 */