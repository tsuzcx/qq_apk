package com.tencent.mtt.hippy.views.list;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerViewBase.Adapter;

class HippyListView$1
  implements ViewTreeObserver.OnPreDrawListener
{
  HippyListView$1(HippyListView paramHippyListView) {}
  
  public boolean onPreDraw()
  {
    if ((this.this$0.mAdapter.getItemCount() > 0) && (this.this$0.getChildCount() > 0))
    {
      HippyListView.access$000(this.this$0).removeOnPreDrawListener(this);
      HippyListView.access$102(this.this$0, true);
      this.this$0.post(new HippyListView.1.1(this));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.list.HippyListView.1
 * JD-Core Version:    0.7.0.1
 */