package com.tencent.mobileqq.dinifly;

import android.content.Context;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$2
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$2(Context paramContext, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromAssetSync(this.val$appContext, this.val$fileName);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.2
 * JD-Core Version:    0.7.0.1
 */