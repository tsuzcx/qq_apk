package com.tencent.mobileqq.onlinestatus;

import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.LottieDrawableLoadedListener;

class OnlineStatusItemView$1
  implements LottieHelper.LottieDrawableLoadedListener
{
  OnlineStatusItemView$1(OnlineStatusItemView paramOnlineStatusItemView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable == null) {
      return;
    }
    OnlineStatusItemView.a(this.a, paramLottieDrawable);
    OnlineStatusItemView.a(this.a).addAnimatorListener(this.a);
    OnlineStatusItemView.a(this.a).setImageDrawable(OnlineStatusItemView.a(this.a));
    OnlineStatusItemView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView.1
 * JD-Core Version:    0.7.0.1
 */