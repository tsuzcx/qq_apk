package com.tencent.mobileqq.dinifly;

import android.content.Context;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$1
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$1(Context paramContext, String paramString1, String paramString2) {}
  
  public LottieResult<LottieComposition> call()
  {
    LottieResult localLottieResult = L.networkFetcher(this.val$context).fetchSync(this.val$url, this.val$cacheKey);
    if ((this.val$cacheKey != null) && (localLottieResult.getValue() != null)) {
      LottieCompositionCache.getInstance().put(this.val$cacheKey, (LottieComposition)localLottieResult.getValue());
    }
    return localLottieResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.1
 * JD-Core Version:    0.7.0.1
 */