package com.tencent.mobileqq.together.clockin;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation
  extends Animation
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  private boolean f;
  private Camera g;
  private float h = 0.0F;
  
  public Rotate3dAnimation()
  {
    this.a = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.h = 0.0F;
    this.f = false;
  }
  
  public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = paramFloat2;
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.f = paramBoolean;
    this.h = paramFloat1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = paramFloat2;
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.f = paramBoolean;
    this.h = paramFloat1;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f3 = this.a;
    float f4 = this.b;
    float f1 = this.c;
    float f2 = this.d;
    Object localObject = this.g;
    paramTransformation = paramTransformation.getMatrix();
    ((Camera)localObject).save();
    if (this.f) {
      ((Camera)localObject).translate(0.0F, 0.0F, this.e * paramFloat);
    } else {
      ((Camera)localObject).translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
    }
    ((Camera)localObject).rotateY(f3 + (f4 - f3) * paramFloat);
    ((Camera)localObject).getMatrix(paramTransformation);
    ((Camera)localObject).restore();
    localObject = new float[9];
    paramTransformation.getValues((float[])localObject);
    paramFloat = localObject[6];
    f3 = this.h;
    localObject[6] = (paramFloat / f3);
    localObject[7] /= f3;
    paramTransformation.setValues((float[])localObject);
    paramTransformation.preTranslate(-f1, -f2);
    paramTransformation.postTranslate(f1, f2);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.Rotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */