package com.tencent.mobileqq.dinifly.model;

import android.content.res.Resources;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import org.json.JSONObject;

public final class JsonCompositionLoader
  extends CompositionLoader<JSONObject>
{
  private final OnCompositionLoadedListener loadedListener;
  private final Resources res;
  
  public JsonCompositionLoader(Resources paramResources, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    this.res = paramResources;
    this.loadedListener = paramOnCompositionLoadedListener;
  }
  
  protected LottieComposition doInBackground(JSONObject... paramVarArgs)
  {
    return LottieComposition.Factory.fromJsonSync(this.res, paramVarArgs[0]);
  }
  
  protected void onPostExecute(LottieComposition paramLottieComposition)
  {
    this.loadedListener.onCompositionLoaded(paramLottieComposition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.JsonCompositionLoader
 * JD-Core Version:    0.7.0.1
 */