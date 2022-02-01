package com.tencent.mobileqq.extendfriend.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class ClickableFrameLayout
  extends FrameLayout
{
  private ClickableFrameLayout.OnDispatchListener a;
  private boolean b = true;
  
  public ClickableFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ClickableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b)
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          this.a.b(paramMotionEvent);
        }
      }
      else
      {
        this.a.a(paramMotionEvent);
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setOnDispatchListener(ClickableFrameLayout.OnDispatchListener paramOnDispatchListener)
  {
    this.a = paramOnDispatchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ClickableFrameLayout
 * JD-Core Version:    0.7.0.1
 */