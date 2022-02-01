package com.tencent.tkd.topicsdk.ucrop.handler;

import android.graphics.RectF;
import android.view.View;
import com.tencent.tkd.topicsdk.ucrop.util.CubicEasing;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import java.lang.ref.WeakReference;

class CropHandler$WrapCropBoundsRunnable
  implements Runnable
{
  private final WeakReference<CropHandler> a;
  private final long b;
  private final long c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  private final float h;
  private final float i;
  private final boolean j;
  
  public CropHandler$WrapCropBoundsRunnable(CropHandler paramCropHandler, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, boolean paramBoolean)
  {
    this.a = new WeakReference(paramCropHandler);
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
    CropHandler localCropHandler = (CropHandler)this.a.get();
    if (localCropHandler == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f1 = (float)Math.min(this.b, l - this.c);
    float f2 = CubicEasing.a(f1, 0.0F, this.f, (float)this.b);
    float f3 = CubicEasing.a(f1, 0.0F, this.g, (float)this.b);
    float f4 = CubicEasing.b(f1, 0.0F, this.i, (float)this.b);
    if (f1 < (float)this.b)
    {
      localCropHandler.a(f2 - (localCropHandler.b[0] - this.d), f3 - (localCropHandler.b[1] - this.e));
      if (!this.j) {
        localCropHandler.a(this.h + f4, CropHandler.a(localCropHandler).centerX(), CropHandler.a(localCropHandler).centerY());
      }
      if (!localCropHandler.f()) {
        localCropHandler.k().getView().post(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.CropHandler.WrapCropBoundsRunnable
 * JD-Core Version:    0.7.0.1
 */