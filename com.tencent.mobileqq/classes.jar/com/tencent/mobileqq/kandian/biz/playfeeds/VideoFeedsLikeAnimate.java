package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import java.util.Random;

public class VideoFeedsLikeAnimate
{
  private float jdField_a_of_type_Float;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoFeedsLikeAnimate.LikeExplosionCenterView jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView;
  private VideoFeedsLikeAnimate.LikeExplosionView jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView;
  private float b;
  
  public VideoFeedsLikeAnimate(ViewGroup paramViewGroup, float paramFloat1, float paramFloat2, Random paramRandom)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView = new VideoFeedsLikeAnimate.LikeExplosionCenterView(this, this.jdField_a_of_type_AndroidViewViewGroup.getContext());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView.setPivotX(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView.setPivotY(this.b);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView.setDrawableId(2130843233);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView = new VideoFeedsLikeAnimate.LikeExplosionView(this, this.jdField_a_of_type_AndroidViewViewGroup.getContext(), paramRandom);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView);
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionCenterView.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.setExplosionEachDirection(paramInt);
  }
  
  public void a(Drawable[] paramArrayOfDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimate$LikeExplosionView.setIconExplosionEachDirection(paramArrayOfDrawable, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsLikeAnimate
 * JD-Core Version:    0.7.0.1
 */