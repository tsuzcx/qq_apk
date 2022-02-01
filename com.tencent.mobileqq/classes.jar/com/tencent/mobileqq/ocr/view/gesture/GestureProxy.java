package com.tencent.mobileqq.ocr.view.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.ocr.view.gesture.control.GestureController;
import com.tencent.mobileqq.ocr.view.gesture.control.OnGestureListener;
import com.tencent.mobileqq.ocr.view.gesture.state.State;
import com.tencent.mobileqq.ocr.view.gesture.state.StateController;
import java.util.List;

public class GestureProxy
  extends GestureController
{
  public GestureProxy(View paramView)
  {
    super(paramView);
  }
  
  public OnGestureListener a()
  {
    return this.a;
  }
  
  public void a(GestureProxy.OnStateChangeListener paramOnStateChangeListener)
  {
    this.c.add(paramOnStateChangeListener);
  }
  
  public void a(OnGestureListener paramOnGestureListener)
  {
    this.a = paramOnGestureListener;
  }
  
  public boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    return super.a(paramView, paramMotionEvent);
  }
  
  public Settings b()
  {
    return this.i;
  }
  
  public boolean b(View paramView, MotionEvent paramMotionEvent)
  {
    return super.b(paramView, paramMotionEvent);
  }
  
  public State c()
  {
    return this.j;
  }
  
  public void d()
  {
    this.l.c(this.j);
    this.l.c(this.k);
    this.l.c(this.f);
    this.l.c(this.g);
    if (this.l.b(this.j))
    {
      n();
      return;
    }
    m();
  }
  
  public void e()
  {
    l();
    if (this.l.a(this.j))
    {
      n();
      return;
    }
    m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.gesture.GestureProxy
 * JD-Core Version:    0.7.0.1
 */