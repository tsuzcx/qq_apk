package com.tencent.mobileqq.onlinestatus.manager;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.LottieDrawableLoadedListener;

class OnlineStatusOlympicManager$3
  implements LottieHelper.LottieDrawableLoadedListener
{
  OnlineStatusOlympicManager$3(OnlineStatusOlympicManager paramOnlineStatusOlympicManager, int paramInt, View paramView) {}
  
  public void a(LottieDrawable paramLottieDrawable)
  {
    if (paramLottieDrawable == null) {
      return;
    }
    if ((OnlineStatusOlympicManager.e(this.c) != null) && (OnlineStatusOlympicManager.e(this.c).isRunning()))
    {
      OnlineStatusOlympicManager.e(this.c).stop();
      OnlineStatusOlympicManager.e(this.c).removeAllAnimatorListeners();
    }
    OnlineStatusOlympicManager.a(this.c, paramLottieDrawable);
    OnlineStatusOlympicManager.a(this.c, this.a);
    OnlineStatusOlympicManager.e(this.c).addAnimatorListener(OnlineStatusOlympicManager.f(this.c));
    ((ImageView)this.b).setImageDrawable(OnlineStatusOlympicManager.e(this.c));
    OnlineStatusOlympicManager.e(this.c).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager.3
 * JD-Core Version:    0.7.0.1
 */