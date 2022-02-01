package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class PressAlphaTextView
  extends TextView
{
  public PressAlphaTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressAlphaTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PressAlphaTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isClickable()) && (isEnabled()))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1)
        {
          if (i != 2) {
            if (i != 3) {
              break label58;
            }
          }
        }
        else
        {
          setAlpha(1.0F);
          break label58;
        }
      }
      setAlpha(0.5F);
      label58:
      return super.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PressAlphaTextView
 * JD-Core Version:    0.7.0.1
 */