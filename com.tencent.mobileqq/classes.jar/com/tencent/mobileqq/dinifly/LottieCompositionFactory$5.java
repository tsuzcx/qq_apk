package com.tencent.mobileqq.dinifly;

import java.util.concurrent.Callable;
import org.json.JSONObject;

final class LottieCompositionFactory$5
  implements Callable<LottieResult<LottieComposition>>
{
  LottieCompositionFactory$5(JSONObject paramJSONObject, String paramString) {}
  
  public LottieResult<LottieComposition> call()
  {
    return LottieCompositionFactory.fromJsonSync(this.val$json, this.val$cacheKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory.5
 * JD-Core Version:    0.7.0.1
 */