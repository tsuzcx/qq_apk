package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;

final class LottieCompositionFactory$6
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$6(String paramString1, String paramString2) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromJsonStringSync(this.val$json, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.6
 * JD-Core Version:    0.7.0.1
 */