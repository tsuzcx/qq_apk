package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.util.DisplayUtil;

public class TopEdgeGestureLayout
  extends TopGestureLayout
{
  private float a;
  private float b;
  private int c;
  private int d;
  
  public TopEdgeGestureLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TopEdgeGestureLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.c = DisplayUtil.a(getContext(), 25.0F);
    this.d = ViewConfiguration.getTouchSlop();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.a = paramMotionEvent.getY();
      this.b = paramMotionEvent.getX();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      int i = getWidth();
      float f = this.b;
      if (((f < this.c) || (Math.abs(i - f) < this.c)) && (Math.abs(this.b - paramMotionEvent.getX()) > this.d)) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.TopEdgeGestureLayout
 * JD-Core Version:    0.7.0.1
 */