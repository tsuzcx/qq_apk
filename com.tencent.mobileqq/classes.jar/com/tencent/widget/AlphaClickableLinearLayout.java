package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class AlphaClickableLinearLayout
  extends LinearLayout
{
  private float a = 0.6F;
  
  public AlphaClickableLinearLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AlphaClickableLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AlphaClickableLinearLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (isEnabled()) {
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      setAlpha(this.a);
      continue;
      setAlpha(1.0F);
    }
  }
  
  public void setClickAlpha(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.AlphaClickableLinearLayout
 * JD-Core Version:    0.7.0.1
 */