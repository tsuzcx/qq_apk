package com.tencent.pts.support;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;

class PagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements RecyclerViewCompat.OnFlingListener
{
  private int currentScrollState = 0;
  private boolean reset = false;
  private boolean scrolled = false;
  
  private PagerSnapHelper$TouchEventProcessor(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onDragging(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      PagerSnapHelper.access$202(this.this$0, this.this$0.findCenterView(PagerSnapHelper.access$000(this.this$0)));
      if ((PagerSnapHelper.access$700(this.this$0) != -1) && (PagerSnapHelper.access$000(this.this$0).findViewByPosition(PagerSnapHelper.access$700(this.this$0)) == null)) {
        this.reset = true;
      }
    }
  }
  
  private void onIdle()
  {
    int k = 1;
    int i;
    if (this.scrolled)
    {
      this.scrolled = false;
      if (!this.this$0.snapToCenterPosition()) {
        i = 1;
      }
    }
    for (;;)
    {
      if (i != 0) {
        PagerSnapHelper.access$402(this.this$0, false);
      }
      int n = PagerSnapHelper.access$500(this.this$0);
      int i1 = PagerSnapHelper.access$600(this.this$0, PagerSnapHelper.access$000(this.this$0));
      int j;
      label85:
      label104:
      View localView;
      int m;
      if ((PagerSnapHelper.access$700(this.this$0) == i1) && (!this.reset))
      {
        j = 1;
        if ((PagerSnapHelper.access$700(this.this$0) != n) || (this.reset)) {
          break label192;
        }
        localView = this.this$0.findCenterView(PagerSnapHelper.access$000(this.this$0));
        if (localView == null) {
          break label197;
        }
        m = PagerSnapHelper.access$000(this.this$0).getPosition(localView);
        label139:
        if ((m < i1) || (j == 0)) {
          break label203;
        }
        if ((i != 0) && (PagerSnapHelper.access$800(this.this$0) != null)) {
          PagerSnapHelper.access$800(this.this$0).onFooterRebound();
        }
      }
      for (;;)
      {
        this.reset = false;
        return;
        i = 0;
        break;
        j = 0;
        break label85;
        label192:
        k = 0;
        break label104;
        label197:
        m = -1;
        break label139;
        label203:
        if ((m > n) || (k == 0)) {
          PagerSnapHelper.access$900(this.this$0, localView, this.reset);
        }
      }
      i = 1;
    }
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.access$000(this.this$0) == null) {
      return false;
    }
    if (PagerSnapHelper.access$100(this.this$0).getAdapter() == null) {
      return false;
    }
    int j = PagerSnapHelper.access$100(this.this$0).getMinFlingVelocity();
    if (PagerSnapHelper.access$200(this.this$0) != null) {}
    for (int i = PagerSnapHelper.access$000(this.this$0).getPosition(PagerSnapHelper.access$200(this.this$0)); (Math.abs(paramFloat2) > j) || (Math.abs(paramFloat1) > j); i = -1) {
      return PagerSnapHelper.access$300(this.this$0, PagerSnapHelper.access$000(this.this$0), paramFloat1, paramFloat2, i);
    }
    return false;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.currentScrollState;
    this.currentScrollState = paramInt;
    if (paramInt == 0) {
      onIdle();
    }
    while (paramInt != 1) {
      return;
    }
    onDragging(i);
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.scrolled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */