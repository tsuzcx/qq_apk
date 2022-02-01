package com.tencent.mobileqq.kandian.biz.share;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;

class VideoShareHelper$ReportDislikeAction$2$1
  implements Animation.AnimationListener
{
  VideoShareHelper$ReportDislikeAction$2$1(VideoShareHelper.ReportDislikeAction.2 param2, ArrayList paramArrayList) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VideoShareHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper$ReportDislikeAction$2.a.a).post(new VideoShareHelper.ReportDislikeAction.2.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportDislikeAction.2.1
 * JD-Core Version:    0.7.0.1
 */