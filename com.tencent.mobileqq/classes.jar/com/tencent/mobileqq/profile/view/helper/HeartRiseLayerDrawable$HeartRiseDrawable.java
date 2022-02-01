package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.view.animation.AccelerateInterpolator;

class HeartRiseLayerDrawable$HeartRiseDrawable
  extends BitmapDrawable
{
  private static int h;
  private static int i;
  private float a;
  private int b;
  private float c = 0.5F;
  private int d = 50;
  private int e = 0;
  private long f = 0L;
  private AccelerateInterpolator g = new AccelerateInterpolator(1.5F);
  
  public HeartRiseLayerDrawable$HeartRiseDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static HeartRiseDrawable[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramResources != null))
    {
      HeartRiseDrawable[] arrayOfHeartRiseDrawable = new HeartRiseDrawable[paramInt];
      i = paramBitmap.getWidth() / 2;
      h = paramBitmap.getHeight() / 2;
      int j = 0;
      while (j < paramInt)
      {
        arrayOfHeartRiseDrawable[j] = new HeartRiseDrawable(paramResources, paramBitmap);
        j += 1;
      }
      return arrayOfHeartRiseDrawable;
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.a = ((float)paramLong);
    this.b = paramInt;
    this.e = 1;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int m = this.e;
    int k = 1;
    int j = k;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          j = k;
          break label199;
        }
        float f2 = (float)(SystemClock.uptimeMillis() - this.f) / this.a;
        if (f2 > 1.0F)
        {
          this.e = 3;
          j = k;
          break label199;
        }
        paramCanvas.save();
        float f3 = this.g.getInterpolation(f2);
        if (f3 > 0.5F) {
          f1 = -f3;
        } else {
          f1 = -(1.0F - f3);
        }
        float f4 = this.d;
        j = this.b;
        paramCanvas.translate(f1 * f4, j - f3 * j);
        float f1 = this.c;
        paramCanvas.scale(f2 * f1, f1 * f2, i, h);
        setAlpha((int)(255.0F - f2 * 255.0F));
        super.draw(paramCanvas);
        paramCanvas.restore();
      }
      else
      {
        this.f = SystemClock.uptimeMillis();
        this.e = 2;
      }
      j = 0;
    }
    label199:
    if (j == 0) {
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable.HeartRiseDrawable
 * JD-Core Version:    0.7.0.1
 */