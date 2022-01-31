package com.tencent.mobileqq.dinifly;

import android.util.JsonReader;
import java.util.concurrent.Callable;

final class LottieCompositionFactory$7
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$7(JsonReader paramJsonReader, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromJsonReaderSync(this.val$reader, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.7
 * JD-Core Version:    0.7.0.1
 */