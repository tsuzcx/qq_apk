package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

public class PressEffectTextView
  extends TextView
{
  public PressEffectTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isClickable()) && (isEnabled()))
    {
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if ((i == 1) || (i == 3)) {
          PressEffectHelper.b(this);
        }
        return super.onTouchEvent(paramMotionEvent);
      }
      PressEffectHelper.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectTextView
 * JD-Core Version:    0.7.0.1
 */