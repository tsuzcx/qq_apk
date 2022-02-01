package com.tencent.widget.pull2refresh;

import android.support.v4.os.TraceCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qphone.base.util.QLog;

class PagerSnapHelper$TouchEventProcessor
  extends RecyclerView.OnScrollListener
  implements View.OnTouchListener, RecyclerViewCompat.OnFlingListener
{
  private boolean b = false;
  private int c = 0;
  private int d = -1;
  private boolean e = false;
  private boolean f = false;
  private float g;
  private float h;
  private float i;
  private float j;
  
  private PagerSnapHelper$TouchEventProcessor(PagerSnapHelper paramPagerSnapHelper) {}
  
  private void a()
  {
    PagerSnapHelper.a(this.a, true);
    if (PagerSnapHelper.e(this.a))
    {
      boolean bool = this.a.f();
      PagerSnapHelper.a(this.a, bool ^ true);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScrollStateChanged: isRealIdle=");
      ((StringBuilder)localObject).append(PagerSnapHelper.f(this.a));
      QLog.d("PagerSnapHelper", 2, ((StringBuilder)localObject).toString());
    }
    if (PagerSnapHelper.f(this.a)) {
      PagerSnapHelper.b(this.a, false);
    }
    Object localObject = this.a;
    localObject = ((PagerSnapHelper)localObject).a(PagerSnapHelper.a((PagerSnapHelper)localObject));
    int k;
    if (localObject != null) {
      k = PagerSnapHelper.a(this.a).getPosition((View)localObject);
    } else {
      k = -1;
    }
    PagerSnapHelper localPagerSnapHelper = this.a;
    if (!PagerSnapHelper.a(localPagerSnapHelper, k, PagerSnapHelper.a(localPagerSnapHelper)))
    {
      PagerSnapHelper.a(this.a, (View)localObject, this.e);
    }
    else if ((!PagerSnapHelper.c(this.a)) && (!PagerSnapHelper.e(this.a)))
    {
      localObject = this.a;
      if (k > PagerSnapHelper.a((PagerSnapHelper)localObject, PagerSnapHelper.a((PagerSnapHelper)localObject))) {
        PagerSnapHelper.g(this.a);
      } else if (k < PagerSnapHelper.h(this.a)) {
        PagerSnapHelper.i(this.a);
      }
    }
    this.e = false;
  }
  
  private void a(int paramInt)
  {
    PagerSnapHelper.a(this.a, false);
    if ((paramInt == 0) || (paramInt == 2))
    {
      Object localObject = this.a;
      localObject = ((PagerSnapHelper)localObject).a(PagerSnapHelper.a((PagerSnapHelper)localObject));
      paramInt = -1;
      if (localObject != null)
      {
        this.d = PagerSnapHelper.a(this.a).getPosition((View)localObject);
        this.d = PagerSnapHelper.b(this.a, this.d);
      }
      else
      {
        this.d = -1;
      }
      if ((PagerSnapHelper.j(this.a) != -1) && (PagerSnapHelper.a(this.a).findViewByPosition(PagerSnapHelper.j(this.a)) == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PagerSnapHelper", 2, "onScrollStateChanged: centerPosition has been recycler");
        }
        this.e = true;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onScrollStateChanged: lastCenterView=");
        if (localObject != null) {
          paramInt = PagerSnapHelper.a(this.a).getPosition((View)localObject);
        }
        localStringBuilder.append(paramInt);
        QLog.d("PagerSnapHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    if (PagerSnapHelper.a(this.a) == null) {
      return false;
    }
    if (PagerSnapHelper.b(this.a).getAdapter() == null) {
      return false;
    }
    if (!PagerSnapHelper.c(this.a)) {
      return false;
    }
    if (PagerSnapHelper.d(this.a) <= 0)
    {
      PagerSnapHelper localPagerSnapHelper = this.a;
      PagerSnapHelper.a(localPagerSnapHelper, PagerSnapHelper.b(localPagerSnapHelper).getMinFlingVelocity());
    }
    int k = this.d;
    if ((Math.abs(paramFloat2) <= PagerSnapHelper.d(this.a)) && (Math.abs(paramFloat1) <= PagerSnapHelper.d(this.a))) {
      return false;
    }
    try
    {
      TraceCompat.beginSection("snapFromFling");
      boolean bool = PagerSnapHelper.a(this.a, PagerSnapHelper.a(this.a), this.i, this.j, paramFloat1, paramFloat2, k);
      return bool;
    }
    finally
    {
      TraceCompat.endSection();
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramRecyclerView = new StringBuilder();
      paramRecyclerView.append("onScrollStateChanged: state=");
      paramRecyclerView.append(paramInt);
      QLog.d("PagerSnapHelper", 2, paramRecyclerView.toString());
    }
    int k = this.c;
    this.c = paramInt;
    if (paramInt == 0)
    {
      TraceCompat.beginSection("snap onIdle");
      a();
      TraceCompat.endSection();
      return;
    }
    if (paramInt == 1)
    {
      TraceCompat.beginSection("snap onDragging");
      a(k);
      TraceCompat.endSection();
    }
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.b = true;
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (k != 1)
    {
      if (k != 2) {
        return false;
      }
      this.f = true;
      if (this.g <= 0.0F) {
        this.g = paramMotionEvent.getX();
      }
      if (this.h <= 0.0F)
      {
        this.h = paramMotionEvent.getY();
        return false;
      }
    }
    else
    {
      if (this.f)
      {
        this.i = (this.g - paramMotionEvent.getX());
        this.j = (this.h - paramMotionEvent.getY());
      }
      else
      {
        this.i = 0.0F;
        this.j = 0.0F;
      }
      this.g = 0.0F;
      this.h = 0.0F;
      this.f = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.PagerSnapHelper.TouchEventProcessor
 * JD-Core Version:    0.7.0.1
 */