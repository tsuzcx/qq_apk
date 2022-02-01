package com.tencent.mobileqq.vas.hippy.view.waterfall;

import android.util.Log;
import com.tencent.mtt.supportui.views.recyclerview.RecyclerView.OnListScrollListener;

class HippyWaterfallAdapter$1
  implements RecyclerView.OnListScrollListener
{
  HippyWaterfallAdapter$1(HippyWaterfallAdapter paramHippyWaterfallAdapter) {}
  
  public void onDragEnd()
  {
    Log.d("HippyWaterfallAdapter", "onDragEnd");
  }
  
  public void onScroll(int paramInt1, int paramInt2)
  {
    if (((this.a.mParentRecyclerView instanceof HippyWaterfallView)) && (((HippyWaterfallView)this.a.mParentRecyclerView).b())) {
      this.a.a();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onScroll position:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" scrollY:");
    localStringBuilder.append(paramInt2);
    Log.d("HippyWaterfallAdapter", localStringBuilder.toString());
  }
  
  public void onScrollEnd()
  {
    Log.d("HippyWaterfallAdapter", "onScrollEnd");
    this.a.a();
  }
  
  public void onStartDrag() {}
  
  public void onStartFling() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippy.view.waterfall.HippyWaterfallAdapter.1
 * JD-Core Version:    0.7.0.1
 */