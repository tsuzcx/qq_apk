package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;

class DiniFlyAnimationView$5
  implements Callable<LottieResult<LottieComposition>>
{
  DiniFlyAnimationView$5(DiniFlyAnimationView paramDiniFlyAnimationView, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    if (DiniFlyAnimationView.access$300(this.this$0)) {
      return LottieCompositionFactory.fromAssetSync(this.this$0.getContext(), this.val$assetName);
    }
    return LottieCompositionFactory.fromAssetSync(this.this$0.getContext(), this.val$assetName, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.DiniFlyAnimationView.5
 * JD-Core Version:    0.7.0.1
 */