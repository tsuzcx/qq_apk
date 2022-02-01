package com.tencent.mobileqq.extendfriend.wiget;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MatchingView$2$1
  implements OnCompositionLoadedListener
{
  MatchingView$2$1(MatchingView.2 param2) {}
  
  public void onCompositionLoaded(LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition == null)
    {
      QLog.e("MatchingView", 1, "onCompositionLoaded lottieComposition is null");
      return;
    }
    LottieDrawable localLottieDrawable = new LottieDrawable();
    localLottieDrawable.setComposition(paramLottieComposition);
    localLottieDrawable.loop(true);
    MatchingView.a(this.a.this$0, localLottieDrawable);
    ThreadManager.getUIHandler().post(new MatchingView.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.MatchingView.2.1
 * JD-Core Version:    0.7.0.1
 */