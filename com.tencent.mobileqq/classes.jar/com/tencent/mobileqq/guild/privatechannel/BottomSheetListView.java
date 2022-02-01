package com.tencent.mobileqq.guild.privatechannel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.tencent.widget.SwipListView;

public class BottomSheetListView
  extends SwipListView
{
  public BottomSheetListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a(BottomSheetListView paramBottomSheetListView)
  {
    boolean bool = true;
    if ((paramBottomSheetListView != null) && (paramBottomSheetListView.getChildCount() > 0))
    {
      int i;
      if ((paramBottomSheetListView.getFirstVisiblePosition() == 0) && (paramBottomSheetListView.getChildAt(0).getTop() == 0)) {
        i = 0;
      } else {
        i = 1;
      }
      int j;
      if ((i != 0) && (paramBottomSheetListView.getLastVisiblePosition() == paramBottomSheetListView.getChildCount())) {
        j = 1;
      } else {
        j = 0;
      }
      if (i != 0) {
        break label77;
      }
      if (j != 0) {
        return true;
      }
    }
    bool = false;
    label77:
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a(this)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.privatechannel.BottomSheetListView
 * JD-Core Version:    0.7.0.1
 */