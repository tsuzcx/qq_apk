package com.tencent.viola.ui.view.list;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.viola.utils.ViolaLogUtils;

class PagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener, RecyclerViewCompat.OnCompatFlingListener
{
  private int currentScrollState = 0;
  private float firstMoveX;
  private float firstMoveY;
  private boolean hadMoveEvent = false;
  private int lastCenterPosition = -1;
  private float moveXDistance;
  private float moveYDistance;
  private boolean reset = false;
  
  private PagerSnapHelper$TouchEventProcessor(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void onDragging(int paramInt)
  {
    if ((paramInt == 0) || (paramInt == 2))
    {
      Object localObject = this.this$0;
      localObject = ((PagerSnapHelper)localObject).findCenterView(PagerSnapHelper.access$200((PagerSnapHelper)localObject));
      paramInt = -1;
      if (localObject != null)
      {
        this.lastCenterPosition = PagerSnapHelper.access$200(this.this$0).getPosition((View)localObject);
        this.lastCenterPosition = PagerSnapHelper.access$1100(this.this$0, this.lastCenterPosition);
      }
      else
      {
        this.lastCenterPosition = -1;
      }
      if ((PagerSnapHelper.access$1200(this.this$0) != -1) && (PagerSnapHelper.access$200(this.this$0).findViewByPosition(PagerSnapHelper.access$1200(this.this$0)) == null))
      {
        ViolaLogUtils.d("PagerSnapHelper", "onScrollStateChanged: centerPosition has been recycler");
        this.reset = true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged: lastCenterView=");
      if (localObject != null) {
        paramInt = PagerSnapHelper.access$200(this.this$0).getPosition((View)localObject);
      }
      localStringBuilder.append(paramInt);
      ViolaLogUtils.d("PagerSnapHelper", localStringBuilder.toString());
    }
  }
  
  private void onIdle()
  {
    boolean bool2 = PagerSnapHelper.access$000(this.this$0);
    boolean bool1 = true;
    if (bool2) {
      bool1 = true ^ this.this$0.snapToCenterPosition();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onScrollStateChanged: isRealIdle=");
    ((StringBuilder)localObject).append(bool1);
    ViolaLogUtils.d("PagerSnapHelper", ((StringBuilder)localObject).toString());
    if (bool1) {
      PagerSnapHelper.access$102(this.this$0, false);
    }
    localObject = this.this$0;
    localObject = ((PagerSnapHelper)localObject).findCenterView(PagerSnapHelper.access$200((PagerSnapHelper)localObject));
    int i;
    if (localObject != null) {
      i = PagerSnapHelper.access$200(this.this$0).getPosition((View)localObject);
    } else {
      i = -1;
    }
    PagerSnapHelper localPagerSnapHelper = this.this$0;
    if (!PagerSnapHelper.access$300(localPagerSnapHelper, i, PagerSnapHelper.access$200(localPagerSnapHelper)))
    {
      PagerSnapHelper.access$400(this.this$0, (View)localObject, this.reset);
    }
    else if ((!PagerSnapHelper.access$500(this.this$0)) && (!PagerSnapHelper.access$000(this.this$0)))
    {
      localObject = this.this$0;
      if ((i > PagerSnapHelper.access$600((PagerSnapHelper)localObject, PagerSnapHelper.access$200((PagerSnapHelper)localObject))) && (PagerSnapHelper.access$700(this.this$0))) {
        PagerSnapHelper.access$800(this.this$0);
      } else if (i < PagerSnapHelper.access$900(this.this$0)) {
        PagerSnapHelper.access$1000(this.this$0);
      }
    }
    this.reset = false;
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.access$200(this.this$0) == null) {
      return false;
    }
    if (PagerSnapHelper.access$1300(this.this$0).getAdapter() == null) {
      return false;
    }
    if (!PagerSnapHelper.access$500(this.this$0)) {
      return false;
    }
    if (PagerSnapHelper.access$1400(this.this$0) <= 0)
    {
      PagerSnapHelper localPagerSnapHelper = this.this$0;
      PagerSnapHelper.access$1402(localPagerSnapHelper, PagerSnapHelper.access$1300(localPagerSnapHelper).getMinFlingVelocity());
    }
    int i = this.lastCenterPosition;
    if ((Math.abs(paramFloat2) <= PagerSnapHelper.access$1400(this.this$0)) && (Math.abs(paramFloat1) <= PagerSnapHelper.access$1400(this.this$0))) {
      return false;
    }
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = PagerSnapHelper.access$1500(this.this$0, PagerSnapHelper.access$200(this.this$0), this.moveXDistance, this.moveYDistance, paramFloat1, paramFloat2, i);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    paramRecyclerView = new StringBuilder();
    paramRecyclerView.append("onScrollStateChanged: state=");
    paramRecyclerView.append(paramInt);
    ViolaLogUtils.d("PagerSnapHelper", paramRecyclerView.toString());
    int i = this.currentScrollState;
    this.currentScrollState = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      onIdle();
      TraceCompat.endSection();
      return;
    }
    if (paramInt == 1)
    {
      TraceCompat.beginSection("snap onDragging");
      onDragging(i);
      TraceCompat.endSection();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      this.hadMoveEvent = true;
      if (this.firstMoveX <= 0.0F) {
        this.firstMoveX = paramMotionEvent.getX();
      }
      if (this.firstMoveY <= 0.0F)
      {
        this.firstMoveY = paramMotionEvent.getY();
        return false;
      }
    }
    else
    {
      if (this.hadMoveEvent)
      {
        this.moveXDistance = (this.firstMoveX - paramMotionEvent.getX());
        this.moveYDistance = (this.firstMoveY - paramMotionEvent.getY());
      }
      else
      {
        this.moveXDistance = 0.0F;
        this.moveYDistance = 0.0F;
      }
      this.firstMoveX = 0.0F;
      this.firstMoveY = 0.0F;
      this.hadMoveEvent = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.view.list.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */