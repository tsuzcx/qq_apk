package com.tencent.viola.ui.view.list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.viola.utils.ViolaLogUtils;

class PagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onPagerDataChanged(int paramInt1, int paramInt2)
  {
    View localView = this.this$0.findCenterView(PagerSnapHelper.access$200(this.this$0));
    if (localView != null) {}
    for (int i = PagerSnapHelper.access$200(this.this$0).getPosition(localView);; i = -1)
    {
      ViolaLogUtils.d("PagerSnapHelper", "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + PagerSnapHelper.access$900(this.this$0) + ", currentPosition=" + i);
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        PagerSnapHelper.OnLayoutChangedListenerImpl.access$1602(PagerSnapHelper.access$1500(this.this$0), true);
        PagerSnapHelper.access$1000(this.this$0).addOnLayoutChangeListener(PagerSnapHelper.access$1500(this.this$0));
        PagerSnapHelper.access$1000(this.this$0).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    onPagerDataChanged(0, PagerSnapHelper.access$200(this.this$0).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$900(this.this$0)) {
      PagerSnapHelper.access$902(this.this$0, PagerSnapHelper.access$900(this.this$0) + paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == PagerSnapHelper.access$900(this.this$0)) {
      PagerSnapHelper.access$902(this.this$0, paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.access$900(this.this$0)) {
      PagerSnapHelper.access$902(this.this$0, PagerSnapHelper.access$900(this.this$0) - paramInt2);
    }
    onPagerDataChanged(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */