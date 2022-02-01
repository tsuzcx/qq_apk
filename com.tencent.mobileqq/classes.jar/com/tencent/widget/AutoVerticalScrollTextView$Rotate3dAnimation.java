package com.tencent.widget;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class AutoVerticalScrollTextView$Rotate3dAnimation
  extends Animation
{
  private float b;
  private float c;
  private final boolean d;
  private final boolean e;
  private Camera f;
  
  public AutoVerticalScrollTextView$Rotate3dAnimation(AutoVerticalScrollTextView paramAutoVerticalScrollTextView, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.b;
    float f2 = this.c;
    Camera localCamera = this.f;
    int i;
    if (this.e) {
      i = 1;
    } else {
      i = -1;
    }
    paramTransformation = paramTransformation.getMatrix();
    localCamera.save();
    if (this.d) {
      localCamera.translate(0.0F, i * this.c * (paramFloat - 1.0F), 0.0F);
    } else {
      localCamera.translate(0.0F, i * this.c * paramFloat, 0.0F);
    }
    localCamera.getMatrix(paramTransformation);
    localCamera.restore();
    paramTransformation.preTranslate(-f1, -f2);
    paramTransformation.postTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = new Camera();
    this.c = this.a.getHeight();
    this.b = this.a.getWidth();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.AutoVerticalScrollTextView.Rotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */