package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;

public class ExtendInputMethodRelativeLayout
  extends InputMethodRelativeLayout
{
  private ExtendInputMethodRelativeLayout.OnDownListener a;
  
  public ExtendInputMethodRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if ((this.a == null) || (!this.a.a(paramMotionEvent))) {}
    }
    else {
      while ((this.a != null) && (this.a.b(paramMotionEvent))) {
        return true;
      }
    }
    try
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    return true;
  }
  
  public void setOnDownListener(ExtendInputMethodRelativeLayout.OnDownListener paramOnDownListener)
  {
    this.a = paramOnDownListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.ExtendInputMethodRelativeLayout
 * JD-Core Version:    0.7.0.1
 */