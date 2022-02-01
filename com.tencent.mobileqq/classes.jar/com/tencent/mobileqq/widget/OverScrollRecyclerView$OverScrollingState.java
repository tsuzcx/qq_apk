package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

public class OverScrollRecyclerView$OverScrollingState
  implements OverScrollRecyclerView.IDecoratorState
{
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected float b;
  protected float c;
  protected final OverScrollRecyclerView.MotionAttributes d;
  protected int e;
  
  public OverScrollRecyclerView$OverScrollingState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager, float paramFloat1, float paramFloat2)
  {
    this.a = paramOverScrollStateManager;
    this.d = new OverScrollRecyclerView.MotionAttributes();
    this.b = paramFloat1;
    this.c = paramFloat2;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    int i;
    if (this.a.c.c) {
      i = 1;
    } else {
      i = 2;
    }
    this.e = i;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.a.c;
    if (localOverScrollStartAttributes.a != paramMotionEvent.getPointerId(0))
    {
      paramMotionEvent = this.a;
      paramMotionEvent.a(paramMotionEvent.g);
      return true;
    }
    View localView = this.a.b();
    OverScrollRecyclerView.IOverScrollDecor localIOverScrollDecor = this.a.b;
    if (!localIOverScrollDecor.a(localView, this.d, paramMotionEvent)) {
      return true;
    }
    float f2 = this.d.b;
    if (this.d.c == localOverScrollStartAttributes.c) {
      f1 = this.b;
    } else {
      f1 = this.c;
    }
    float f1 = f2 / f1;
    f2 = this.d.a + f1;
    if (((localOverScrollStartAttributes.c) && (!this.d.c) && (f2 <= localOverScrollStartAttributes.b)) || ((!localOverScrollStartAttributes.c) && (this.d.c) && (f2 >= localOverScrollStartAttributes.b)))
    {
      localIOverScrollDecor.a(localView, localOverScrollStartAttributes.b, paramMotionEvent);
      paramMotionEvent = this.a;
      paramMotionEvent.a(paramMotionEvent.e);
      return true;
    }
    if (localView.getParent() != null) {
      localView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    long l = paramMotionEvent.getEventTime() - paramMotionEvent.getHistoricalEventTime(0);
    if (l > 0L) {
      this.a.d = (f1 / (float)l);
    }
    localIOverScrollDecor.a(localView, f2);
    return true;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    paramMotionEvent = this.a;
    paramMotionEvent.a(paramMotionEvent.g);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.OverScrollingState
 * JD-Core Version:    0.7.0.1
 */