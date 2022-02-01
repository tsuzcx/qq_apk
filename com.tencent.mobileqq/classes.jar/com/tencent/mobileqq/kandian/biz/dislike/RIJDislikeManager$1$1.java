package com.tencent.mobileqq.kandian.biz.dislike;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.kandian.biz.video.viewholder.ViewHolder;
import java.util.ArrayList;

class RIJDislikeManager$1$1
  implements Animation.AnimationListener
{
  RIJDislikeManager$1$1(RIJDislikeManager.1 param1, ArrayList paramArrayList, Object paramObject) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager$1.a.g.post(new RIJDislikeManager.1.1.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager.1.1
 * JD-Core Version:    0.7.0.1
 */