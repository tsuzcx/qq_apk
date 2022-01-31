package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.widget.ListView;

public class SlideNotBackRecyclerView
  extends RecyclerView
{
  public SlideNotBackRecyclerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SlideNotBackRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return bool;
      for (paramMotionEvent = getParent(); !(paramMotionEvent instanceof ListView); paramMotionEvent = paramMotionEvent.getParent()) {}
      paramMotionEvent = paramMotionEvent.getParent();
    } while (paramMotionEvent == null);
    paramMotionEvent.requestDisallowInterceptTouchEvent(true);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlideNotBackRecyclerView
 * JD-Core Version:    0.7.0.1
 */