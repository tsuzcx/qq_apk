package com.tencent.mobileqq.kandian.base.imagecrop;

import com.tencent.mobileqq.kandian.base.imagecrop.util.CubicEasing;
import java.lang.ref.WeakReference;

class CropImageView$ZoomImageToPosition
  implements Runnable
{
  private final WeakReference<CropImageView> a;
  private final long b;
  private final long c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final boolean h;
  
  public CropImageView$ZoomImageToPosition(CropImageView paramCropImageView, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.a = new WeakReference(paramCropImageView);
    this.c = System.currentTimeMillis();
    this.b = paramLong;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
    this.h = paramBoolean;
  }
  
  public void run()
  {
    CropImageView localCropImageView = (CropImageView)this.a.get();
    if (localCropImageView == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f2 = (float)Math.min(this.b, l - this.c);
    float f1;
    if (this.h) {
      f1 = CubicEasing.a(f2, 0.0F, this.e, (float)this.b);
    } else {
      f1 = CubicEasing.b(f2, 0.0F, this.e, (float)this.b);
    }
    if (f2 < (float)this.b)
    {
      if (!this.h) {
        localCropImageView.b(this.d + f1, this.f, this.g);
      } else {
        localCropImageView.a(this.d + f1, this.f, this.g);
      }
      localCropImageView.post(this);
      return;
    }
    localCropImageView.setImageToWrapCropBounds();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.CropImageView.ZoomImageToPosition
 * JD-Core Version:    0.7.0.1
 */