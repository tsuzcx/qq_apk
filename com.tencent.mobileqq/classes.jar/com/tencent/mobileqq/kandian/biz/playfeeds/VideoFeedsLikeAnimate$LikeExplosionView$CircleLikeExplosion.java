package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.Random;

class VideoFeedsLikeAnimate$LikeExplosionView$CircleLikeExplosion
  extends VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
{
  private float m;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$CircleLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    super(paramLikeExplosionView);
    b();
  }
  
  public VideoFeedsLikeAnimate$LikeExplosionView$CircleLikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView, int paramInt)
  {
    super(paramLikeExplosionView);
    double d = Math.toRadians(paramInt);
    this.f = ((float)Math.cos(d));
    this.g = ((float)Math.sin(d));
    a();
    b();
  }
  
  private void b()
  {
    VideoFeedsLikeAnimate.LikeExplosionView.b(this.a).setColor(Color.parseColor("#E6FF4222"));
    VideoFeedsLikeAnimate.LikeExplosionView.b(this.a).setStyle(Paint.Style.FILL);
    this.m = (VideoFeedsLikeAnimate.LikeExplosionView.c(this.a).nextFloat() * AIOUtils.b(10.0F, this.a.getResources()) + AIOUtils.b(4.5F, this.a.getResources()));
  }
  
  public void a(Canvas paramCanvas)
  {
    paramCanvas.drawCircle(this.d, this.e, this.m, VideoFeedsLikeAnimate.LikeExplosionView.b(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionView.CircleLikeExplosion
 * JD-Core Version:    0.7.0.1
 */