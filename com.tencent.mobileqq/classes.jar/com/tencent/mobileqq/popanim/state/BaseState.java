package com.tencent.mobileqq.popanim.state;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewGroup;
import mqq.app.MobileQQ;

public class BaseState
{
  protected Context a = MobileQQ.getContext();
  protected ViewGroup b;
  protected StateContext c;
  
  protected BaseState(ViewGroup paramViewGroup, StateContext paramStateContext)
  {
    this.b = paramViewGroup;
    this.c = paramStateContext;
  }
  
  public void a(BaseState paramBaseState) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void b(BaseState paramBaseState) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.BaseState
 * JD-Core Version:    0.7.0.1
 */