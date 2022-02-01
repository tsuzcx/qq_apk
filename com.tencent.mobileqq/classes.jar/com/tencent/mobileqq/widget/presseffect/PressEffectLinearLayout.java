package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class PressEffectLinearLayout
  extends LinearLayout
{
  private boolean a = false;
  
  public PressEffectLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((isClickable()) && (isEnabled()) && (!this.a))
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
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectLinearLayout
 * JD-Core Version:    0.7.0.1
 */