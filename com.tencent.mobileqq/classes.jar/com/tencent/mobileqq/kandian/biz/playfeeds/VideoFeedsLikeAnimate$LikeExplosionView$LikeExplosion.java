package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Canvas;
import java.util.Random;

class VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion
{
  public float b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h = 0.8F;
  public float i = 0.4F;
  public int j = 360;
  public int k = 0;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    b();
  }
  
  private void b()
  {
    c();
    a();
  }
  
  private void c()
  {
    int m = this.k;
    if (m != this.j)
    {
      m = VideoFeedsLikeAnimate.LikeExplosionView.c(this.l).nextInt();
      int n = this.j;
      int i1 = this.k;
      m = m * (n - i1) + i1;
    }
    double d2 = Math.toRadians(m);
    double d1 = 0.9F;
    double d3 = Math.cos(d2);
    Double.isNaN(d1);
    this.f = ((float)(d3 * d1));
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    this.g = ((float)(d1 * d2));
  }
  
  protected void a()
  {
    this.b = (VideoFeedsLikeAnimate.b(this.l.a) - VideoFeedsLikeAnimate.d(this.l.a).getWidth() / 2);
    this.c = (VideoFeedsLikeAnimate.c(this.l.a) - VideoFeedsLikeAnimate.d(this.l.a).getHeight() / 2);
    this.d = this.b;
    this.e = this.c;
  }
  
  public void a(float paramFloat)
  {
    this.d = (this.b + this.f * (float)VideoFeedsLikeAnimate.LikeExplosionView.e(this.l) * paramFloat);
    this.e = (this.c + this.g * (float)VideoFeedsLikeAnimate.LikeExplosionView.e(this.l) * paramFloat);
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
 * JD-Core Version:    0.7.0.1
 */