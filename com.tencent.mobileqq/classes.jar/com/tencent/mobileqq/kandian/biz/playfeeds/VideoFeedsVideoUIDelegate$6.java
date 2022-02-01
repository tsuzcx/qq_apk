package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class VideoFeedsVideoUIDelegate$6
  extends AnimateUtils.AnimationAdapter
{
  VideoFeedsVideoUIDelegate$6(VideoFeedsVideoUIDelegate paramVideoFeedsVideoUIDelegate, AlphaAnimation paramAlphaAnimation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsVideoUIDelegate.a.o.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsVideoUIDelegate.6
 * JD-Core Version:    0.7.0.1
 */