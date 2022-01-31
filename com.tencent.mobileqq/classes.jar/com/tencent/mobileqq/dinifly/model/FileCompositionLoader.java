package com.tencent.mobileqq.dinifly.model;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.model.layer.Layer.Factory;
import java.io.InputStream;

public final class FileCompositionLoader
  extends CompositionLoader<InputStream>
{
  private final OnCompositionLoadedListener loadedListener;
  private LottieDrawable lottieDrawable;
  private final Resources res;
  private Bundle userData;
  
  public FileCompositionLoader(Resources paramResources, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, LottieDrawable paramLottieDrawable)
  {
    this.res = paramResources;
    this.loadedListener = paramOnCompositionLoadedListener;
    this.userData = paramBundle;
    this.lottieDrawable = paramLottieDrawable;
  }
  
  protected LottieComposition doInBackground(InputStream... paramVarArgs)
  {
    paramVarArgs = LottieComposition.Factory.fromInputStream(this.res, paramVarArgs[0], this.userData);
    if ((this.lottieDrawable != null) && (paramVarArgs != null)) {
      paramVarArgs.compositionLayer = new CompositionLayer(this.lottieDrawable, Layer.Factory.newInstance(paramVarArgs), paramVarArgs.getLayers(), paramVarArgs);
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(LottieComposition paramLottieComposition)
  {
    this.loadedListener.onCompositionLoaded(paramLottieComposition);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.FileCompositionLoader
 * JD-Core Version:    0.7.0.1
 */