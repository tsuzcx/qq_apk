package com.tencent.mobileqq.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OverScrollRecyclerView$OverScrollStateManager
  implements View.OnTouchListener
{
  protected final RecyclerView a;
  protected OverScrollRecyclerView.IOverScrollDecor b = new OverScrollRecyclerView.LinearScrollViewOverScrollDecor();
  protected final OverScrollRecyclerView.OverScrollStartAttributes c = new OverScrollRecyclerView.OverScrollStartAttributes();
  protected float d;
  protected OverScrollRecyclerView.IdleState e;
  protected OverScrollRecyclerView.OverScrollingState f;
  protected OverScrollRecyclerView.BounceBackState g;
  protected OverScrollRecyclerView.IDecoratorState h;
  
  public OverScrollRecyclerView$OverScrollStateManager(RecyclerView paramRecyclerView)
  {
    this.a = paramRecyclerView;
  }
  
  public void a()
  {
    this.g = new OverScrollRecyclerView.BounceBackState(this, -2.0F);
    this.f = new OverScrollRecyclerView.OverScrollingState(this, 3.0F, 1.0F);
    this.e = new OverScrollRecyclerView.IdleState(this);
    this.h = this.e;
    c();
  }
  
  public void a(RecyclerView.LayoutManager paramLayoutManager)
  {
    if ((paramLayoutManager instanceof LinearLayoutManager))
    {
      paramLayoutManager = (LinearLayoutManager)paramLayoutManager;
      this.b.a(paramLayoutManager.getOrientation());
      return;
    }
    this.b.a(1);
  }
  
  protected void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState)
  {
    OverScrollRecyclerView.IDecoratorState localIDecoratorState = this.h;
    this.h = paramIDecoratorState;
    this.h.a(localIDecoratorState);
  }
  
  public View b()
  {
    return this.a;
  }
  
  public void c()
  {
    this.a.setOnTouchListener(this);
    this.a.setOverScrollMode(2);
  }
  
  public void d()
  {
    this.a.setOnTouchListener(null);
    this.a.setOverScrollMode(0);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return false;
        }
      }
      else {
        return this.h.a(paramMotionEvent);
      }
    }
    return this.h.b(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.OverScrollStateManager
 * JD-Core Version:    0.7.0.1
 */