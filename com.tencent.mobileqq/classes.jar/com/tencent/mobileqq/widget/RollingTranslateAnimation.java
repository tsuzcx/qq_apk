package com.tencent.mobileqq.widget;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RollingTranslateAnimation
  extends Animation
{
  private int a;
  private int b;
  private int c;
  private int d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private float n;
  private int o;
  private int p;
  private float q;
  private float r;
  private float s;
  private float t;
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.m;
    f1 += (this.n - f1) * paramFloat;
    if ((this.s == 0.0F) && (this.t == 0.0F)) {
      paramTransformation.getMatrix().setRotate(f1);
    } else {
      paramTransformation.getMatrix().setRotate(f1, this.s, this.t);
    }
    float f3 = this.i;
    float f2 = this.k;
    float f4 = this.j;
    f1 = f3;
    if (f3 != f4) {
      f1 = f3 + (f4 - f3) * paramFloat;
    }
    f3 = this.k;
    f4 = this.l;
    if (f3 != f4) {
      f2 = f3 + (f4 - f3) * paramFloat;
    }
    paramTransformation.getMatrix().postTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = resolveSize(this.a, this.e, paramInt1, paramInt3);
    this.j = resolveSize(this.b, this.f, paramInt1, paramInt3);
    this.k = resolveSize(this.c, this.g, paramInt2, paramInt4);
    this.l = resolveSize(this.d, this.h, paramInt2, paramInt4);
    this.s = resolveSize(this.o, this.q, paramInt1, paramInt3);
    this.t = resolveSize(this.p, this.r, paramInt2, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RollingTranslateAnimation
 * JD-Core Version:    0.7.0.1
 */