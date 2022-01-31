package com.tencent.viola.ui.view.list;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.tencent.viola.utils.ViolaLogUtils;

class PagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements RecyclerViewCompat.OnCompatFlingListener
{
  private int currentScrollState = 0;
  private int lastCenterPosition = -1;
  private boolean reset = false;
  
  private PagerSnapHelper$TouchEventProcessor(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onDragging(int paramInt)
  {
    int i = -1;
    View localView;
    if ((paramInt == 0) || (paramInt == 2))
    {
      localView = this.this$0.findCenterView(PagerSnapHelper.access$200(this.this$0));
      if (localView == null) {
        break label150;
      }
      this.lastCenterPosition = PagerSnapHelper.access$200(this.this$0).getPosition(localView);
    }
    label150:
    for (this.lastCenterPosition = PagerSnapHelper.access$800(this.this$0, this.lastCenterPosition);; this.lastCenterPosition = -1)
    {
      if ((PagerSnapHelper.access$900(this.this$0) != -1) && (PagerSnapHelper.access$200(this.this$0).findViewByPosition(PagerSnapHelper.access$900(this.this$0)) == null))
      {
        ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: centerPosition has been recycler");
        this.reset = true;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("onScrollStateChanged: lastCenterView=");
      paramInt = i;
      if (localView != null) {
        paramInt = PagerSnapHelper.access$200(this.this$0).getPosition(localView);
      }
      ViolaLogUtils.d("PagerSnapHelper", paramInt);
      return;
    }
  }
  
  private void onIdle()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i;
    if (PagerSnapHelper.access$000(this.this$0))
    {
      if (!this.this$0.snapToCenterPosition()) {
        bool1 = bool2;
      }
    }
    else
    {
      ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: isRealIdle=" + bool1);
      if (bool1) {
        PagerSnapHelper.access$102(this.this$0, false);
      }
      View localView = this.this$0.findCenterView(PagerSnapHelper.access$200(this.this$0));
      if (localView == null) {
        break label139;
      }
      i = PagerSnapHelper.access$200(this.this$0).getPosition(localView);
      label97:
      if (PagerSnapHelper.access$300(this.this$0, i, PagerSnapHelper.access$200(this.this$0))) {
        break label144;
      }
      PagerSnapHelper.access$400(this.this$0, localView, this.reset);
    }
    for (;;)
    {
      this.reset = false;
      return;
      bool1 = false;
      break;
      label139:
      i = -1;
      break label97;
      label144:
      if ((!PagerSnapHelper.access$500(this.this$0)) && (!PagerSnapHelper.access$000(this.this$0)) && (i > PagerSnapHelper.access$600(this.this$0, PagerSnapHelper.access$200(this.this$0)))) {
        PagerSnapHelper.access$700(this.this$0);
      }
    }
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.access$200(this.this$0) == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return false;
      } while ((PagerSnapHelper.access$1000(this.this$0).getAdapter() == null) || (!PagerSnapHelper.access$500(this.this$0)));
      i = PagerSnapHelper.access$1000(this.this$0).getMinFlingVelocity();
      j = this.lastCenterPosition;
    } while ((Math.abs(paramFloat2) <= i) && (Math.abs(paramFloat1) <= i));
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = PagerSnapHelper.access$1100(this.this$0, PagerSnapHelper.access$200(this.this$0), paramFloat1, paramFloat2, j);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: state=" + paramInt);
    int i = this.currentScrollState;
    this.currentScrollState = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      onIdle();
      TraceCompat.endSection();
    }
    while (paramInt != 1) {
      return;
    }
    TraceCompat.beginSection("snap onDragging");
    onDragging(i);
    TraceCompat.endSection();
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */