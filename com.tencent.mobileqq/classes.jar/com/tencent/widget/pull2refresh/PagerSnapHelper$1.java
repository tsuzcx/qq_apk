package com.tencent.widget.pull2refresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$1
  extends RecyclerView.AdapterDataObserver
{
  PagerSnapHelper$1(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    View localView = this.a.a(PagerSnapHelper.a(this.a));
    if (localView != null) {}
    for (int i = PagerSnapHelper.a(this.a).getPosition(localView);; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PagerSnapHelper", 2, "onPagerDataChanged: positionStart=" + paramInt1 + ", itemCount=" + paramInt2 + ", centerPosition=" + PagerSnapHelper.c(this.a) + ", currentPosition=" + i);
      }
      if ((paramInt1 <= i) && (paramInt1 + paramInt2 - 1 >= i))
      {
        PagerSnapHelper.OnLayoutChangedListenerImpl.a(PagerSnapHelper.a(this.a), true);
        PagerSnapHelper.a(this.a).addOnLayoutChangeListener(PagerSnapHelper.a(this.a));
        PagerSnapHelper.a(this.a).requestLayout();
      }
      return;
    }
  }
  
  public void onChanged()
  {
    a(0, PagerSnapHelper.a(this.a).getItemCount());
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramObject == null) {
      onItemRangeChanged(paramInt1, paramInt2);
    }
  }
  
  public void onItemRangeInserted(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.c(this.a)) {
      PagerSnapHelper.c(this.a, PagerSnapHelper.c(this.a) + paramInt2);
    }
    a(paramInt1, paramInt2);
  }
  
  public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == PagerSnapHelper.c(this.a)) {
      PagerSnapHelper.c(this.a, paramInt2);
    }
    a(paramInt1, paramInt3);
  }
  
  public void onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= PagerSnapHelper.c(this.a)) {
      PagerSnapHelper.c(this.a, PagerSnapHelper.c(this.a) - paramInt2);
    }
    a(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.1
 * JD-Core Version:    0.7.0.1
 */