package com.tencent.mobileqq.dinifly;

import java.io.InputStream;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$4
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$4(InputStream paramInputStream, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromJsonInputStreamSync(this.val$stream, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.4
 * JD-Core Version:    0.7.0.1
 */