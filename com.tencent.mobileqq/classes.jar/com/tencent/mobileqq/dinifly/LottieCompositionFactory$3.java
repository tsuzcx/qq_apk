package com.tencent.mobileqq.dinifly;

import android.content.Context;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$3
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$3(Context paramContext, int paramInt) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromRawResSync(this.val$appContext, this.val$rawRes);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.3
 * JD-Core Version:    0.7.0.1
 */