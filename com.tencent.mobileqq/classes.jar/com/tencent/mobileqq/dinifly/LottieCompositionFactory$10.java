package com.tencent.mobileqq.dinifly;

import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import java.util.Map;

final class LottieCompositionFactory$10
  implements LottieListener<LottieComposition>
{
  LottieCompositionFactory$10(String paramString) {}
  
  public void onResult(LottieComposition paramLottieComposition)
  {
    if (this.val$cacheKey != null) {
      LottieCompositionCache.getInstance().put(this.val$cacheKey, paramLottieComposition);
    }
    LottieCompositionFactory.access$000().remove(this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.10
 * JD-Core Version:    0.7.0.1
 */