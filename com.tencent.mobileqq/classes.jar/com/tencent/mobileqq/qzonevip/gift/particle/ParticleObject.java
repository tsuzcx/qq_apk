package com.tencent.mobileqq.qzonevip.gift.particle;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class ParticleObject
{
  public float a;
  public float b;
  public float c;
  public float d = 1.0F;
  public int e = 255;
  public Bitmap f;
  public long g = System.currentTimeMillis();
  public boolean h = false;
  public int i = 0;
  public long j;
  
  public void a(Canvas paramCanvas, Paint paramPaint, Matrix paramMatrix)
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    int k = (int)(((Bitmap)localObject).getWidth() * this.d);
    int m = (int)(this.f.getHeight() * this.d);
    localObject = paramMatrix;
    if (paramMatrix == null) {
      localObject = new Matrix();
    }
    paramPaint.setAlpha(this.e);
    ((Matrix)localObject).reset();
    float f1 = this.d;
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postRotate(this.c, k / 2, m / 2);
    ((Matrix)localObject).postTranslate(this.a, this.b);
    paramCanvas.drawBitmap(this.f, (Matrix)localObject, paramPaint);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mDx = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mDy = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mScale = ");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mRotation = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mDuration = ");
    localStringBuilder.append(this.j);
    localStringBuilder.append(" mAlpha = ");
    localStringBuilder.append(this.e);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.particle.ParticleObject
 * JD-Core Version:    0.7.0.1
 */