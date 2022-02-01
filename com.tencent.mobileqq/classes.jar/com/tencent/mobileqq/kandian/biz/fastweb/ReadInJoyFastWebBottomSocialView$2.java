package com.tencent.mobileqq.kandian.biz.fastweb;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.widget.ImageView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;

class ReadInJoyFastWebBottomSocialView$2
  implements Animation.AnimationListener
{
  ReadInJoyFastWebBottomSocialView$2(ReadInJoyFastWebBottomSocialView paramReadInJoyFastWebBottomSocialView) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    ImageView localImageView = ReadInJoyFastWebBottomSocialView.a(this.a);
    int i;
    if (ReadInJoyFastWebBottomSocialView.a(this.a).a) {
      i = 2130842975;
    } else {
      i = 2130842977;
    }
    localImageView.setImageResource(i);
    paramAnimation.setInterpolator(new AnticipateInterpolator());
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.ReadInJoyFastWebBottomSocialView.2
 * JD-Core Version:    0.7.0.1
 */