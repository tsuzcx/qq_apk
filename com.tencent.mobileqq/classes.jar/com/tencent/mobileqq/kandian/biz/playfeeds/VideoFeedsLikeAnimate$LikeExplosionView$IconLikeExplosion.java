package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;

class VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion
  extends VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
{
  private Drawable m;
  private int n;
  private int o;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    super(paramLikeExplosionView);
    this.m = paramDrawable;
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public VideoFeedsLikeAnimate$LikeExplosionView$IconLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramLikeExplosionView);
    double d = Math.toRadians(paramInt3);
    this.f = ((float)Math.cos(d));
    this.g = ((float)Math.sin(d));
    a();
    this.m = paramDrawable;
    this.n = paramInt1;
    this.o = paramInt2;
  }
  
  public void a(Canvas paramCanvas)
  {
    int i = (int)(this.d - this.n / 2);
    float f = this.e;
    int j = this.n;
    int k = (int)(f - j / 2);
    this.m.setBounds(i, k, i + j, j + k);
    VideoFeedsLikeAnimate.LikeExplosionView.d(this.a).reset();
    VideoFeedsLikeAnimate.LikeExplosionView.d(this.a).setRotate(this.o, VideoFeedsLikeAnimate.b(this.a.a), VideoFeedsLikeAnimate.c(this.a.a));
    paramCanvas.setMatrix(VideoFeedsLikeAnimate.LikeExplosionView.d(this.a));
    this.m.draw(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionView.IconLikeExplosion
 * JD-Core Version:    0.7.0.1
 */