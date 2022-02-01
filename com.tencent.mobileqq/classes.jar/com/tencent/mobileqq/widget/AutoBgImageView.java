package com.tencent.mobileqq.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AutoBgImageView
  extends ImageView
{
  private float a = 0.5F;
  
  public AutoBgImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoBgImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoBgImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public AutoBgImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
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
  
  public void setPressedAlpha(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AutoBgImageView
 * JD-Core Version:    0.7.0.1
 */