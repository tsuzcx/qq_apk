package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;

class DiniFlyAnimationView$4
  implements Callable<LottieResult<LottieComposition>>
{
  DiniFlyAnimationView$4(DiniFlyAnimationView paramDiniFlyAnimationView, int paramInt) {}
  
  public LottieResult<LottieComposition> call()
  {
    if (DiniFlyAnimationView.access$300(this.this$0)) {
      return LottieCompositionFactory.fromRawResSync(this.this$0.getContext(), this.val$rawRes);
    }
    return LottieCompositionFactory.fromRawResSync(this.this$0.getContext(), this.val$rawRes, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView.4
 * JD-Core Version:    0.7.0.1
 */