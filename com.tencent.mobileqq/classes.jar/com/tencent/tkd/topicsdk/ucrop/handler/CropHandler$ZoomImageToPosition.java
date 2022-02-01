package com.tencent.tkd.topicsdk.ucrop.handler;

import android.view.View;
import com.tencent.tkd.topicsdk.ucrop.util.CubicEasing;
import com.tencent.tkd.topicsdk.ucrop.view.IGestureCropView;
import java.lang.ref.WeakReference;

class CropHandler$ZoomImageToPosition
  implements Runnable
{
  private final WeakReference<CropHandler> a;
  private final long b;
  private final long c;
  private final float d;
  private final float e;
  private final float f;
  private final float g;
  
  public CropHandler$ZoomImageToPosition(CropHandler paramCropHandler, long paramLong, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = new WeakReference(paramCropHandler);
    this.c = System.currentTimeMillis();
    this.b = paramLong;
    this.d = paramFloat1;
    this.e = paramFloat2;
    this.f = paramFloat3;
    this.g = paramFloat4;
  }
  
  public void run()
  {
    CropHandler localCropHandler = (CropHandler)this.a.get();
    if (localCropHandler == null) {
      return;
    }
    long l = System.currentTimeMillis();
    float f1 = (float)Math.min(this.b, l - this.c);
    float f2 = CubicEasing.b(f1, 0.0F, this.e, (float)this.b);
    if (f1 < (float)this.b)
    {
      localCropHandler.a(this.d + f2, this.f, this.g);
      localCropHandler.k().getView().post(this);
      return;
    }
    localCropHandler.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.ucrop.handler.CropHandler.ZoomImageToPosition
 * JD-Core Version:    0.7.0.1
 */