package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import bctl;
import com.tencent.image.URLImageView;

public class PressEffectURLImageView
  extends URLImageView
{
  public PressEffectURLImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isClickable()) || (!isEnabled())) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      bctl.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      bctl.b(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectURLImageView
 * JD-Core Version:    0.7.0.1
 */