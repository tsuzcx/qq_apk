package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Canvas;
import java.util.Random;

class VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion
{
  public float a;
  public int a;
  public float b;
  public int b;
  public float c;
  public float d;
  public float e;
  public float f;
  public float g = 0.8F;
  public float h = 0.4F;
  
  public VideoFeedsLikeAnimate$LikeExplosionView$LikeExplosion(VideoFeedsLikeAnimate.LikeExplosionView paramLikeExplosionView)
  {
    this.jdField_a_of_type_Int = 360;
    this.jdField_b_of_type_Int = 0;
    b();
  }
  
  private void b()
  {
    c();
    a();
  }
  
  private void c()
  {
    int i = this.jdField_b_of_type_Int;
    if (i != this.jdField_a_of_type_Int)
    {
      i = VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView).nextInt();
      int j = this.jdField_a_of_type_Int;
      int k = this.jdField_b_of_type_Int;
      i = i * (j - k) + k;
    }
    double d2 = Math.toRadians(i);
    double d1 = 0.9F;
    double d3 = Math.cos(d2);
    Double.isNaN(d1);
    this.e = ((float)(d3 * d1));
    d2 = Math.sin(d2);
    Double.isNaN(d1);
    this.f = ((float)(d1 * d2));
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Float = (VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.a) - VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.a).getWidth() / 2);
    this.jdField_b_of_type_Float = (VideoFeedsLikeAnimate.b(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.a) - VideoFeedsLikeAnimate.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.a).getHeight() / 2);
    this.c = this.jdField_a_of_type_Float;
    this.d = this.jdField_b_of_type_Float;
  }
  
  public void a(float paramFloat)
  {
    this.c = (this.jdField_a_of_type_Float + this.e * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView) * paramFloat);
    this.d = (this.jdField_b_of_type_Float + this.f * (float)VideoFeedsLikeAnimate.LikeExplosionView.a(this.jdField_b_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView) * paramFloat);
  }
  
  public void a(Canvas paramCanvas) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate.LikeExplosionView.LikeExplosion
 * JD-Core Version:    0.7.0.1
 */