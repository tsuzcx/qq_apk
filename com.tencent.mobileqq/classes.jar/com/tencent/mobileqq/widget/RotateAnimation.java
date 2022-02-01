package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAnimation
  extends Animation
{
  public float a = 800.0F;
  private final boolean b;
  private final float c;
  private final float d;
  private Camera e;
  private RotateAnimation.InterpolatedTimeListener f;
  
  public RotateAnimation(float paramFloat1, float paramFloat2, boolean paramBoolean, int paramInt)
  {
    this.c = paramFloat1;
    this.d = paramFloat2;
    this.b = paramBoolean;
    this.a = paramInt;
    setDuration(800L);
  }
  
  public void a(RotateAnimation.InterpolatedTimeListener paramInterpolatedTimeListener)
  {
    this.f = paramInterpolatedTimeListener;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    RotateAnimation.InterpolatedTimeListener localInterpolatedTimeListener = this.f;
    if (localInterpolatedTimeListener != null) {
      localInterpolatedTimeListener.a(paramFloat);
    }
    boolean bool = this.b;
    int i = 1;
    if (bool == true) {}
    for (float f1 = 0.0F;; f1 = 360.0F)
    {
      f2 = 180.0F;
      break label59;
      if (bool) {
        break;
      }
    }
    f1 = 0.0F;
    float f2 = 0.0F;
    label59:
    f2 = f1 + (f2 - f1) * paramFloat;
    if (paramFloat <= 0.5F) {
      i = 0;
    }
    f1 = f2;
    if (i != 0) {
      f1 = f2 - 180.0F;
    }
    paramFloat = Math.abs(paramFloat - 0.5F);
    f2 = this.a;
    paramTransformation = paramTransformation.getMatrix();
    this.e.save();
    this.e.translate(0.0F, 0.0F, (0.5F - paramFloat) * f2);
    this.e.rotateY(f1);
    this.e.getMatrix(paramTransformation);
    this.e.restore();
    paramTransformation.preTranslate(-this.c, -this.d);
    paramTransformation.postTranslate(this.c, this.d);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateAnimation
 * JD-Core Version:    0.7.0.1
 */