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
      PagerSnapHelper localPagerSnapHelper = this.this$0;
      PagerSnapHelper.access$202(localPagerSnapHelper, localPagerSnapHelper.findCenterView(PagerSnapHelper.access$000(localPagerSnapHelper)));
      if ((PagerSnapHelper.access$700(this.this$0) != -1) && (PagerSnapHelper.access$000(this.this$0).findViewByPosition(PagerSnapHelper.access$700(this.this$0)) == null)) {
        this.reset = true;
      }
    }
  }
  
  private void onIdle()
  {
    boolean bool2 = this.scrolled;
    int j = 1;
    boolean bool1;
    if (bool2)
    {
      this.scrolled = false;
      bool1 = this.this$0.snapToCenterPosition() ^ true;
    }
    else
    {
      bool1 = true;
    }
    if (bool1) {
      PagerSnapHelper.access$402(this.this$0, false);
    }
    int m = PagerSnapHelper.access$500(this.this$0);
    Object localObject = this.this$0;
    int n = PagerSnapHelper.access$600((PagerSnapHelper)localObject, PagerSnapHelper.access$000((PagerSnapHelper)localObject));
    int i;
    if ((PagerSnapHelper.access$700(this.this$0) == n) && (!this.reset)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((PagerSnapHelper.access$700(this.this$0) != m) || (this.reset)) {
      j = 0;
    }
    localObject = this.this$0;
    localObject = ((PagerSnapHelper)localObject).findCenterView(PagerSnapHelper.access$000((PagerSnapHelper)localObject));
    int k;
    if (localObject != null) {
      k = PagerSnapHelper.access$000(this.this$0).getPosition((View)localObject);
    } else {
      k = -1;
    }
    if ((k >= n) && (i != 0))
    {
      if ((bool1) && (PagerSnapHelper.access$800(this.this$0) != null)) {
        PagerSnapHelper.access$800(this.this$0).onFooterRebound();
      }
    }
    else if ((k > m) || (j == 0)) {
      PagerSnapHelper.access$900(this.this$0, (View)localObject, this.reset);
    }
    this.reset = false;
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
    int i;
    if (PagerSnapHelper.access$200(this.this$0) != null) {
      i = PagerSnapHelper.access$000(this.this$0).getPosition(PagerSnapHelper.access$200(this.this$0));
    } else {
      i = -1;
    }
    float f1 = Math.abs(paramFloat2);
    float f2 = j;
    if ((f1 <= f2) && (Math.abs(paramFloat1) <= f2)) {
      return false;
    }
    PagerSnapHelper localPagerSnapHelper = this.this$0;
    return PagerSnapHelper.access$300(localPagerSnapHelper, PagerSnapHelper.access$000(localPagerSnapHelper), paramFloat1, paramFloat2, i);
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    int i = this.currentScrollState;
    this.currentScrollState = paramInt;
    if (paramInt == 0)
    {
      onIdle();
      return;
    }
    if (paramInt == 1) {
      onDragging(i);
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.scrolled = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.support.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */