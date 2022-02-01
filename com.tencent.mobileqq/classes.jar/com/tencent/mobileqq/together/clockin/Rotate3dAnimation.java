package com.tencent.mobileqq.together.clockin;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation
  extends Animation
{
  private float jdField_a_of_type_Float;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private boolean jdField_a_of_type_Boolean;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f = 0.0F;
  
  public Rotate3dAnimation()
  {
    this.jdField_a_of_type_Float = 0.0F;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = 0.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public Rotate3dAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramFloat2;
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramFloat1;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.jdField_a_of_type_Float = paramFloat2;
    this.b = paramFloat3;
    this.c = paramFloat4;
    this.d = paramFloat5;
    this.e = paramFloat6;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.f = paramFloat1;
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.b;
    float f3 = this.c;
    float f4 = this.d;
    Object localObject = this.jdField_a_of_type_AndroidGraphicsCamera;
    paramTransformation = paramTransformation.getMatrix();
    ((Camera)localObject).save();
    if (this.jdField_a_of_type_Boolean) {
      ((Camera)localObject).translate(0.0F, 0.0F, this.e * paramFloat);
    }
    for (;;)
    {
      ((Camera)localObject).rotateY(f1 + (f2 - f1) * paramFloat);
      ((Camera)localObject).getMatrix(paramTransformation);
      ((Camera)localObject).restore();
      localObject = new float[9];
      paramTransformation.getValues((float[])localObject);
      localObject[6] /= this.f;
      localObject[7] /= this.f;
      paramTransformation.setValues((float[])localObject);
      paramTransformation.preTranslate(-f3, -f4);
      paramTransformation.postTranslate(f3, f4);
      return;
      ((Camera)localObject).translate(0.0F, 0.0F, this.e * (1.0F - paramFloat));
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.together.clockin.Rotate3dAnimation
 * JD-Core Version:    0.7.0.1
 */