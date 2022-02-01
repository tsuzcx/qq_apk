package com.tencent.mobileqq.dinifly;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$3
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$3(WeakReference paramWeakReference, Context paramContext, int paramInt, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    Context localContext = (Context)this.val$contextRef.get();
    if (localContext == null) {
      localContext = this.val$appContext;
    }
    return LottieCompositionFactory.fromRawResSync(localContext, this.val$rawRes, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.3
 * JD-Core Version:    0.7.0.1
 */