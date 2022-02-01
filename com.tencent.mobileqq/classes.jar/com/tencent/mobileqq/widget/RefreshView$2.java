package com.tencent.mobileqq.widget;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import mqq.os.MqqHandler;

class RefreshView$2
  implements OnCompositionLoadedListener
{
  RefreshView$2(RefreshView paramRefreshView) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null) {
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    RefreshView.a(this.a, localLottieDrawable);
    ThreadManager.getUIHandler().post(new RefreshView.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RefreshView.2
 * JD-Core Version:    0.7.0.1
 */