package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class DispatchActionMoveScrollView
  extends ScrollView
{
  public boolean a = false;
  
  public DispatchActionMoveScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DispatchActionMoveScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DispatchActionMoveScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  @TargetApi(9)
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DispatchActionMoveScrollView
 * JD-Core Version:    0.7.0.1
 */