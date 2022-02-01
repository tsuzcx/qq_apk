package com.tencent.mobileqq.qqgift.utils;

import android.view.View;

public class LongClickHandler
{
  private boolean a = false;
  private final View b;
  private LongClickHandler.OnLongClickListener c;
  private int d = 0;
  private final Runnable e = new LongClickHandler.1(this);
  
  public LongClickHandler(View paramView)
  {
    this.b = paramView;
  }
  
  public void a()
  {
    this.a = false;
    ThreadManager.b(this.e);
  }
  
  public void a(LongClickHandler.OnLongClickListener paramOnLongClickListener, int paramInt)
  {
    this.c = paramOnLongClickListener;
    this.d = paramInt;
    this.b.setOnLongClickListener(new LongClickHandler.2(this, paramOnLongClickListener, paramInt));
    this.b.setOnTouchListener(new LongClickHandler.3(this, paramOnLongClickListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.utils.LongClickHandler
 * JD-Core Version:    0.7.0.1
 */