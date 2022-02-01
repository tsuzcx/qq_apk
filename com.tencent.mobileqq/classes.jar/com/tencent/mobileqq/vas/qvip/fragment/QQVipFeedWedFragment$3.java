package com.tencent.mobileqq.vas.qvip.fragment;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.gamecenter.view.QQGamePubViewpager;

class QQVipFeedWedFragment$3
  implements ValueAnimator.AnimatorUpdateListener
{
  QQVipFeedWedFragment$3(QQVipFeedWedFragment paramQQVipFeedWedFragment) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QQVipFeedWedFragment.a(this.a).scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment.3
 * JD-Core Version:    0.7.0.1
 */