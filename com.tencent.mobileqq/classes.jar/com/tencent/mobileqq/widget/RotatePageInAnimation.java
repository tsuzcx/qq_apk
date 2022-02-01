package com.tencent.mobileqq.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class RotatePageInAnimation
  extends Animation
{
  private Camera a;
  private Matrix b;
  private int c;
  private int d;
  private View e;
  
  public RotatePageInAnimation(View paramView)
  {
    this.e = paramView;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    this.a.save();
    this.a.rotateX(90.0F - paramFloat * 90.0F);
    this.a.getMatrix(this.b);
    this.a.restore();
    this.b.preTranslate(-this.c / 2, -this.d / 2);
    this.b.postTranslate(this.c / 2, this.d / 2);
    paramTransformation.getMatrix().postConcat(this.b);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.a = new Camera();
    this.b = new Matrix();
    this.c = paramInt1;
    this.d = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotatePageInAnimation
 * JD-Core Version:    0.7.0.1
 */