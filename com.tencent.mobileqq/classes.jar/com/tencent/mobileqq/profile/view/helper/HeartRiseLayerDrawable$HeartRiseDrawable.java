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
  private static int d;
  private static int e;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private AccelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator(1.5F);
  private float jdField_b_of_type_Float = 0.5F;
  private int jdField_b_of_type_Int = 50;
  private int c = 0;
  
  public HeartRiseLayerDrawable$HeartRiseDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
  }
  
  public static HeartRiseDrawable[] a(int paramInt, Resources paramResources, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramResources != null))
    {
      HeartRiseDrawable[] arrayOfHeartRiseDrawable = new HeartRiseDrawable[paramInt];
      e = paramBitmap.getWidth() / 2;
      d = paramBitmap.getHeight() / 2;
      int i = 0;
      while (i < paramInt)
      {
        arrayOfHeartRiseDrawable[i] = new HeartRiseDrawable(paramResources, paramBitmap);
        i += 1;
      }
      return arrayOfHeartRiseDrawable;
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Float = ((float)paramLong);
    this.jdField_a_of_type_Int = paramInt;
    this.c = 1;
    invalidateSelf();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = this.c;
    int j = 1;
    int i = j;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 2)
        {
          i = j;
          break label199;
        }
        float f2 = (float)(SystemClock.uptimeMillis() - this.jdField_a_of_type_Long) / this.jdField_a_of_type_Float;
        if (f2 > 1.0F)
        {
          this.c = 3;
          i = j;
          break label199;
        }
        paramCanvas.save();
        float f3 = this.jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation(f2);
        if (f3 > 0.5F) {
          f1 = -f3;
        } else {
          f1 = -(1.0F - f3);
        }
        float f4 = this.jdField_b_of_type_Int;
        i = this.jdField_a_of_type_Int;
        paramCanvas.translate(f1 * f4, i - f3 * i);
        float f1 = this.jdField_b_of_type_Float;
        paramCanvas.scale(f2 * f1, f1 * f2, e, d);
        setAlpha((int)(255.0F - f2 * 255.0F));
        super.draw(paramCanvas);
        paramCanvas.restore();
      }
      else
      {
        this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
        this.c = 2;
      }
      i = 0;
    }
    label199:
    if (i == 0) {
      invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable.HeartRiseDrawable
 * JD-Core Version:    0.7.0.1
 */