package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class PressEffectLinearLayout
  extends LinearLayout
{
  public PressEffectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      PressEffectHelper.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      PressEffectHelper.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout
 * JD-Core Version:    0.7.0.1
 */