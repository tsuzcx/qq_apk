package com.tencent.pts.support;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

class PagerSnapHelper$OnLayoutChangedListenerImpl
  implements View.OnLayoutChangeListener
{
  private boolean reset = false;
  
  private PagerSnapHelper$OnLayoutChangedListenerImpl(PagerSnapHelper paramPagerSnapHelper) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    PagerSnapHelper.access$100(this.this$0).removeOnLayoutChangeListener(this);
    if (PagerSnapHelper.access$000(this.this$0).getItemCount() > PagerSnapHelper.access$1700(this.this$0) + PagerSnapHelper.access$1800(this.this$0))
    {
      paramView = this.this$0;
      paramView = paramView.findCenterView(PagerSnapHelper.access$000(paramView));
      if ((!this.this$0.snapToTargetView(paramView)) || (this.reset)) {
        PagerSnapHelper.access$900(this.this$0, paramView, this.reset);
      }
      this.reset = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper.OnLayoutChangedListenerImpl
 * JD-Core Version:    0.7.0.1
 */