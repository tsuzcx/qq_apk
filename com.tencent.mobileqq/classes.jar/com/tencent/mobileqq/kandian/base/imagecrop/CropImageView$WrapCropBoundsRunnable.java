package com.tencent.mobileqq.kandian.base.imagecrop;

import android.graphics.RectF;
import com.tencent.mobileqq.kandian.base.imagecrop.util.CubicEasing;
import java.lang.ref.WeakReference;

class CropImageView$WrapCropBoundsRunnable
  implements Runnable
{
  private final WeakReference<CropImageView> a;
  private final long b;
  private final long c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;
  private final boolean j;
  
  public CropImageView$WrapCropBoundsRunnable(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = new WeakReference(paramCropImageView);
    this.b = paramLong;
    this.c = System.currentTimeMillis();
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
    this.h = paramFloat5;
    this.i = paramFloat6;
    this.j = paramBoolean;
  }
  
  public void run()
  {
    CropImageView localCropImageView = (CropImageView)this.a.get();
    if (localCropImageView == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f1 = (float)Math.min(this.b, l - this.c);
    float f2 = CubicEasing.a(f1, 0.0F, this.f, (float)this.b);
    float f3 = CubicEasing.a(f1, 0.0F, this.g, (float)this.b);
    float f4 = CubicEasing.b(f1, 0.0F, this.i, (float)this.b);
    if (f1 < (float)this.b)
    {
      localCropImageView.a(f2 - (localCropImageView.b[0] - this.d), f3 - (localCropImageView.b[1] - this.e));
      if (!this.j) {
        localCropImageView.b(this.h + f4, CropImageView.a(localCropImageView).centerX(), CropImageView.a(localCropImageView).centerY());
      }
      if (!localCropImageView.c()) {
        localCropImageView.post(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.CropImageView.WrapCropBoundsRunnable
 * JD-Core Version:    0.7.0.1
 */