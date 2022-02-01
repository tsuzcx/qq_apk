package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;

public class OverScrollRecyclerView$IdleState
  implements OverScrollRecyclerView.IDecoratorState
{
  protected final OverScrollRecyclerView.OverScrollStateManager a;
  protected final OverScrollRecyclerView.MotionAttributes b = new OverScrollRecyclerView.MotionAttributes();
  
  public OverScrollRecyclerView$IdleState(OverScrollRecyclerView.OverScrollStateManager paramOverScrollStateManager)
  {
    this.a = paramOverScrollStateManager;
  }
  
  public void a(OverScrollRecyclerView.IDecoratorState paramIDecoratorState) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    Object localObject = this.a.b();
    OverScrollRecyclerView.IOverScrollDecor localIOverScrollDecor = this.a.b;
    if (!localIOverScrollDecor.a((View)localObject, this.b, paramMotionEvent)) {
      return false;
    }
    OverScrollRecyclerView.OverScrollStartAttributes localOverScrollStartAttributes = this.a.c;
    if (((localIOverScrollDecor.a((View)localObject)) && (this.b.c)) || ((localIOverScrollDecor.b((View)localObject)) && (!this.b.c)))
    {
      localOverScrollStartAttributes.a = paramMotionEvent.getPointerId(0);
      localOverScrollStartAttributes.b = this.b.a;
      localOverScrollStartAttributes.c = this.b.c;
      localObject = this.a;
      ((OverScrollRecyclerView.OverScrollStateManager)localObject).a(((OverScrollRecyclerView.OverScrollStateManager)localObject).f);
      return this.a.f.a(paramMotionEvent);
    }
    return false;
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.OverScrollRecyclerView.IdleState
 * JD-Core Version:    0.7.0.1
 */