package com.tencent.mtt.hippy.views.viewpager;

import android.view.View.MeasureSpec;

class HippyViewPager$1
  implements Runnable
{
  HippyViewPager$1(HippyViewPager paramHippyViewPager) {}
  
  public void run()
  {
    this.this$0.measure(View.MeasureSpec.makeMeasureSpec(this.this$0.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.this$0.getHeight(), 1073741824));
    this.this$0.layout(this.this$0.getLeft(), this.this$0.getTop(), this.this$0.getRight(), this.this$0.getBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPager.1
 * JD-Core Version:    0.7.0.1
 */