package com.tencent.mobileqq.qwallet.hb.send.view.impl;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class BirthdayHbRecyclerView
  extends RecyclerView
{
  private Scroller a;
  private int b;
  
  public BirthdayHbRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BirthdayHbRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BirthdayHbRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOnFlingListener(new BirthdayHbRecyclerView.MyOnFlingListener(this));
    this.a = new Scroller(paramContext);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.a.computeScrollOffset())
    {
      int i = this.a.getCurrY();
      scrollBy(0, i - this.b);
      this.b = i;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      this.b = ((int)paramMotionEvent.getY());
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.view.impl.BirthdayHbRecyclerView
 * JD-Core Version:    0.7.0.1
 */