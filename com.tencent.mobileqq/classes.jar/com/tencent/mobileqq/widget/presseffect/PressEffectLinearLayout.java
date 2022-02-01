package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import bivv;

public class PressEffectLinearLayout
  extends LinearLayout
{
  private boolean a;
  
  public PressEffectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled()) || (this.a)) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      bivv.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      bivv.b(this);
    }
  }
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout
 * JD-Core Version:    0.7.0.1
 */