package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class ScrollDisableListView
  extends ListView
{
  private int a;
  
  public ScrollDisableListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScrollDisableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScrollDisableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int i = paramMotionEvent.getActionMasked() & 0xFF;
    if (i == 0)
    {
      this.a = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    while (i == 2) {
      return bool;
    }
    if ((i == 1) || (i == 3))
    {
      if (pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) == this.a) {
        super.dispatchTouchEvent(paramMotionEvent);
      }
    }
    else {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    setPressed(false);
    invalidate();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.ScrollDisableListView
 * JD-Core Version:    0.7.0.1
 */