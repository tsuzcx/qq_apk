package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.tencent.mobileqq.popanim.PopOutAnimConfig;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;

public class EndAnimState
  extends BaseState
{
  protected EndAnimState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    super(paramViewGroup, paramStateContext);
  }
  
  public void a(BaseState paramBaseState)
  {
    this.c.a();
    this.c.c.stopShakeAnimation();
    PopOutAnimViewHolder.a().b();
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return super.a(paramMotionEvent);
  }
  
  public void b(BaseState paramBaseState)
  {
    super.b(paramBaseState);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.EndAnimState
 * JD-Core Version:    0.7.0.1
 */