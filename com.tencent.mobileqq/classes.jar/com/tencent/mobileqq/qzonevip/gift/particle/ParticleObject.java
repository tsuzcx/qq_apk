package com.tencent.mobileqq.qzonevip.gift.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class ParticleObject
{
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public float c;
  public float d = 1.0F;
  
  public ParticleObject()
  {
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, Matrix paramMatrix)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject == null) {
      return;
    }
    int i = (int)(((Bitmap)localObject).getWidth() * this.d);
    int j = (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.d);
    localObject = paramMatrix;
    if (paramMatrix == null) {
      localObject = new Matrix();
    }
    paramPaint.setAlpha(this.jdField_a_of_type_Int);
    ((Matrix)localObject).reset();
    float f = this.d;
    ((Matrix)localObject).setScale(f, f);
    ((Matrix)localObject).postRotate(this.c, i / 2, j / 2);
    ((Matrix)localObject).postTranslate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, (Matrix)localObject, paramPaint);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mDx = ");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(" mDy = ");
    localStringBuilder.append(this.jdField_b_of_type_Float);
    localStringBuilder.append(" mScale = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mRotation = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mDuration = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" mAlpha = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleObject
 * JD-Core Version:    0.7.0.1
 */