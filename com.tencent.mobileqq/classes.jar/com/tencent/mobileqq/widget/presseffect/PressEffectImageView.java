package com.tencent.mobileqq.widget.presseffect;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import bbpx;

public class PressEffectImageView
  extends ImageView
{
  private boolean a;
  
  public PressEffectImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PressEffectImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
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
      bbpx.a(this);
      super.onTouchEvent(paramMotionEvent);
      return true;
      bbpx.b(this);
    }
  }
  
  public void setDisableEffect(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.presseffect.PressEffectImageView
 * JD-Core Version:    0.7.0.1
 */