package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class ScaleTxtAnimation
  extends Animation
{
  private float a;
  private float b;
  private float c;
  private Camera d;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1;
    if (paramFloat > 0.5F)
    {
      paramFloat = (paramFloat - 0.5F) / 0.5F;
      f1 = this.c;
      float f2 = this.b;
      paramFloat = paramFloat * (f1 - f2) + f2;
    }
    else
    {
      f1 = this.a;
      paramFloat = f1 - paramFloat / 0.5F * (f1 - this.b);
    }
    paramTransformation = paramTransformation.getMatrix();
    this.d.save();
    this.d.getMatrix(paramTransformation);
    paramTransformation.postScale(paramFloat, paramFloat);
    this.d.restore();
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.d = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ScaleTxtAnimation
 * JD-Core Version:    0.7.0.1
 */