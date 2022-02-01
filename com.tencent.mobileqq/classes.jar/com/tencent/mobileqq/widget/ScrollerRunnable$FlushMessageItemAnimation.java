package com.tencent.mobileqq.widget;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ScrollerRunnable$FlushMessageItemAnimation
  extends Animation
{
  private float a;
  private float b;
  private View c;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = this.c;
    if (paramTransformation == null) {
      return;
    }
    float f = this.a;
    paramTransformation.setBackgroundColor(Color.argb((int)((f + (this.b - f) * paramFloat) * 255.0F), 255, 255, 255));
  }
  
  public boolean willChangeBounds()
  {
    return false;
  }
  
  public boolean willChangeTransformationMatrix()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScrollerRunnable.FlushMessageItemAnimation
 * JD-Core Version:    0.7.0.1
 */