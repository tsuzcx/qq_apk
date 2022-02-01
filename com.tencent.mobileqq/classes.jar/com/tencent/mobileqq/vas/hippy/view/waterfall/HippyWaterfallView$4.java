package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class HippyWaterfallView$4
  implements ViewTreeObserver.OnPreDrawListener
{
  HippyWaterfallView$4(HippyWaterfallView paramHippyWaterfallView) {}
  
  public boolean onPreDraw()
  {
    if ((this.a.a.getItemCount() > 0) && (this.a.getChildCount() > 0))
    {
      HippyWaterfallView.d(this.a).removeOnPreDrawListener(this);
      HippyWaterfallView.a(this.a, true);
      this.a.post(new HippyWaterfallView.4.1(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallView.4
 * JD-Core Version:    0.7.0.1
 */