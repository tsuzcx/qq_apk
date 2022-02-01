package com.tencent.mobileqq.kandian.biz.pts.view;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ReadInJoySocializeRecommendFollowView$8
  extends D8SafeAnimatorListener
{
  ReadInJoySocializeRecommendFollowView$8(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!this.a)
    {
      ReadInJoySocializeRecommendFollowView.g(this.b).isShowRecommendList = false;
      ReadInJoySocializeRecommendFollowView.a(this.b);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.view.ReadInJoySocializeRecommendFollowView.8
 * JD-Core Version:    0.7.0.1
 */