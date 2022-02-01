package com.tencent.tav.coremedia;

import android.graphics.Matrix;

public class Transform
{
  public float degrees = 0.0F;
  public final float scaleX;
  public final float scaleY;
  public final float translateX;
  public final float translateY;
  
  public Transform(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    this.scaleX = paramFloat1;
    this.scaleY = paramFloat2;
    this.translateX = paramFloat3;
    this.translateY = paramFloat4;
    this.degrees = paramFloat5;
  }
  
  public static Transform instanceFromScale(float paramFloat1, float paramFloat2)
  {
    return new Transform(paramFloat1, paramFloat2, 0.0F, 0.0F, 0.0F);
  }
  
  public static Transform instanceFromTranslate(float paramFloat1, float paramFloat2)
  {
    return new Transform(1.0F, 1.0F, paramFloat1, paramFloat2, 0.0F);
  }
  
  public Matrix toMatrix()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postRotate(this.degrees);
    localMatrix.postScale(this.scaleX, this.scaleY);
    localMatrix.postTranslate(this.translateX, this.translateY);
    return localMatrix;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tav.coremedia.Transform
 * JD-Core Version:    0.7.0.1
 */