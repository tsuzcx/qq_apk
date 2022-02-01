package com.tencent.mobileqq.kandian.base.view.widget.pullrefresh;

import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;

class RefreshAnimView$3$3
  implements OnCompositionLoadedListener
{
  RefreshAnimView$3$3(RefreshAnimView.3 param3, Runnable paramRunnable) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    RefreshAnimView.a(this.b.c, paramLottieComposition);
    if (paramLottieComposition != null) {
      this.a.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView.3.3
 * JD-Core Version:    0.7.0.1
 */