package com.tencent.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class AutoBgTextView
  extends TextView
{
  private float pressedAlpha = 0.5F;
  
  public AutoBgTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoBgTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoBgTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    float f;
    if (isPressed()) {
      f = this.pressedAlpha;
    } else {
      f = 1.0F;
    }
    setAlpha(f);
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.AutoBgTextView
 * JD-Core Version:    0.7.0.1
 */