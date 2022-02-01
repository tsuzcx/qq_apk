package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class SlipLimitedListView
  extends SlideDetectListView
{
  private Rect p = new Rect();
  
  public SlipLimitedListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView;
      int i = 0;
      while (i < paramView.getChildCount())
      {
        View localView = paramView.getChildAt(i);
        if ((localView instanceof WorkSpaceView))
        {
          paramView = (WorkSpaceView)localView;
          paramView.getGlobalVisibleRect(this.p);
          if (paramView.isShown()) {
            return this.p.contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY());
          }
          return false;
        }
        if (((localView instanceof ViewGroup)) && (a((ViewGroup)localView, paramMotionEvent))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) && (a(this, paramMotionEvent))) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SlipLimitedListView
 * JD-Core Version:    0.7.0.1
 */