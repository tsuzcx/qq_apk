package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class AutoBgTextView
  extends TextView
{
  private float a = 0.5F;
  
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
    if (isPressed()) {}
    for (float f = this.a;; f = 1.0F)
    {
      setAlpha(f);
      postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoBgTextView
 * JD-Core Version:    0.7.0.1
 */