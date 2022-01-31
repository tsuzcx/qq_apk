package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

public class SwipConflictHorizontailListView
  extends HorizontalListView
{
  public SwipConflictHorizontailListView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SwipConflictHorizontailListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getOverScrollMode()
  {
    return 2;
  }
  
  protected void initView()
  {
    setOverScrollMode(2);
    super.initView();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.SwipConflictHorizontailListView
 * JD-Core Version:    0.7.0.1
 */