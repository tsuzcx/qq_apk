package com.tencent.mobileqq.winkpublish.widget.multitouchimg;

import android.view.animation.Interpolator;
import com.tencent.qphone.base.util.QLog;

class PhotoViewAttacher$AnimatedZoomRunnable
  implements Runnable
{
  private final float a;
  private final float b;
  private final long c;
  private final float d;
  private final float e;
  
  public PhotoViewAttacher$AnimatedZoomRunnable(PhotoViewAttacher paramPhotoViewAttacher, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.a = paramFloat3;
    this.b = paramFloat4;
    this.c = System.currentTimeMillis();
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  private float a()
  {
    float f = Math.min(1.0F, (float)(System.currentTimeMillis() - this.c) * 1.0F / PhotoViewAttacher.q(this.this$0));
    return PhotoViewAttacher.r(this.this$0).getInterpolation(f);
  }
  
  public void run()
  {
    float f1 = a();
    float f2 = this.d;
    f2 = (f2 + (this.e - f2) * f1) / this.this$0.e();
    PhotoViewAttacher.l(this.this$0).a(f2, this.a, this.b);
    if (f1 < 1.0F)
    {
      Compat.a(PhotoViewAttacher.i(this.this$0), this);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("AnimatedZoomRunnable postOnAnimation t:");
      localStringBuilder.append(f1);
      localStringBuilder.append(" deltaScale:");
      localStringBuilder.append(f2);
      localStringBuilder.append(" mFocalX:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" mFocalY:");
      localStringBuilder.append(this.b);
      QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AnimatedZoomRunnable t:");
    localStringBuilder.append(f1);
    localStringBuilder.append(" deltaScale:");
    localStringBuilder.append(f2);
    localStringBuilder.append(" mFocalX:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mFocalY:");
    localStringBuilder.append(this.b);
    QLog.d("PhotoViewAttacher", 4, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.widget.multitouchimg.PhotoViewAttacher.AnimatedZoomRunnable
 * JD-Core Version:    0.7.0.1
 */