package com.tencent.mobileqq.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;

public class MonitorSizeChangeHSV
  extends HorizontalScrollView
{
  private MonitorSizeChangeHSV.IOnSizeChangeCallback a;
  
  public MonitorSizeChangeHSV(Context paramContext)
  {
    super(paramContext);
  }
  
  public MonitorSizeChangeHSV(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    View localView = getChildAt(0);
    boolean bool1 = bool2;
    if (localView != null)
    {
      int i = localView.getWidth();
      bool1 = bool2;
      if (getWidth() < i + getPaddingLeft() + getPaddingLeft()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (a())
    {
      ViewGroup localViewGroup;
      if (paramMotionEvent.getAction() == 0)
      {
        localViewGroup = (ViewGroup)getParent();
        if (localViewGroup != null) {
          localViewGroup.requestDisallowInterceptTouchEvent(true);
        }
      }
      else if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1))
      {
        localViewGroup = (ViewGroup)getParent();
        if (localViewGroup != null) {
          localViewGroup.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    MonitorSizeChangeHSV.IOnSizeChangeCallback localIOnSizeChangeCallback = this.a;
    if (localIOnSizeChangeCallback != null) {
      localIOnSizeChangeCallback.a(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void setOnSizeChangeCallback(MonitorSizeChangeHSV.IOnSizeChangeCallback paramIOnSizeChangeCallback)
  {
    this.a = paramIOnSizeChangeCallback;
  }
  
  public void setOverScrollMode(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 9) {
      super.setOverScrollMode(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.MonitorSizeChangeHSV
 * JD-Core Version:    0.7.0.1
 */