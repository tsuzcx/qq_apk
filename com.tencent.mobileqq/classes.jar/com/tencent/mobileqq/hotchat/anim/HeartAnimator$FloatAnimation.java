package com.tencent.mobileqq.hotchat.anim;

import android.annotation.TargetApi;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;

class HeartAnimator$FloatAnimation
  extends Animation
{
  public PathMeasure a;
  public View b;
  public float c;
  public float d;
  public HeartAnimator.Config e;
  public int f = 0;
  public HeartAnimator.HeartAnimatorListener g;
  public Interpolator h;
  
  @TargetApi(11)
  public HeartAnimator$FloatAnimation(Path paramPath, float paramFloat, View paramView1, View paramView2, HeartAnimator.Config paramConfig)
  {
    this.a = new PathMeasure(paramPath, false);
    this.c = this.a.getLength();
    this.b = paramView2;
    this.d = paramFloat;
    this.e = paramConfig;
    paramView1.setLayerType(2, null);
  }
  
  private static float a(int paramInt, float paramFloat)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return (float)Math.pow(paramFloat, 2.0D);
      }
      return paramFloat * 0.5F + 0.5F;
    }
    if (paramFloat < 0.8D) {
      return 0.0F;
    }
    return paramFloat * 5.0F - 4.0F;
  }
  
  @TargetApi(11)
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    Object localObject = paramTransformation.getMatrix();
    this.a.getMatrix(this.c * paramFloat, (Matrix)localObject, 1);
    float f1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localObject = this.b;
      f1 = this.d;
      HeartAnimator.Config localConfig = this.e;
      ((View)localObject).setRotation(f1 * paramFloat * HeartAnimator.Config.l);
    }
    if (this.e.q)
    {
      f1 = this.h.getInterpolation(paramFloat);
      this.b.setScaleX(this.e.p * f1);
      this.b.setScaleY(f1 * this.e.p);
    }
    paramTransformation.setAlpha(1.0F - a(this.f, paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartAnimator.FloatAnimation
 * JD-Core Version:    0.7.0.1
 */