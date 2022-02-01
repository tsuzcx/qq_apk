package com.tencent.mobileqq.dinifly.model;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.util.Log;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.mobileqq.dinifly.LottieResult;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.mobileqq.dinifly.model.layer.CompositionLayer;
import com.tencent.mobileqq.dinifly.parser.LayerParser;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class FileCompositionLoader
  extends CompositionLoader<InputStream>
{
  private MQLruCache<String, Object> imageCache;
  private final OnCompositionLoadedListener loadedListener;
  private LottieDrawable lottieDrawable;
  private Bundle userData;
  
  public FileCompositionLoader(Resources paramResources, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, LottieDrawable paramLottieDrawable, MQLruCache<String, Object> paramMQLruCache)
  {
    this.loadedListener = paramOnCompositionLoadedListener;
    this.userData = paramBundle;
    this.lottieDrawable = paramLottieDrawable;
    this.imageCache = paramMQLruCache;
  }
  
  protected LottieComposition doInBackground(InputStream... paramVarArgs)
  {
    Object localObject1;
    try
    {
      paramVarArgs = (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramVarArgs[0], null).getValue();
    }
    catch (AssertionError paramVarArgs)
    {
      localObject1 = this.userData;
      if (localObject1 != null) {
        Log.w("FileCompositionLoader", ((Bundle)localObject1).getString("path"));
      }
      paramVarArgs.printStackTrace();
      paramVarArgs = null;
    }
    if ((this.userData != null) && (paramVarArgs != null) && (paramVarArgs.images != null))
    {
      localObject1 = this.userData.getString("key");
      String str = this.userData.getString("path");
      Iterator localIterator = paramVarArgs.images.entrySet().iterator();
      Log.v("DiniFlyAnimationView", str);
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getKey());
        localObject3 = ((StringBuilder)localObject3).toString();
        ((LottieImageAsset)((Map.Entry)localObject2).getValue()).setKey((String)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(((LottieImageAsset)((Map.Entry)localObject2).getValue()).getFileName());
        localObject2 = localStringBuilder.toString();
        LottieImageAsset.decodeBitmapIntoCache(this.imageCache, (String)localObject3, (String)localObject2);
      }
      paramVarArgs.compositionLayer = new CompositionLayer(this.lottieDrawable, LayerParser.parse(paramVarArgs), paramVarArgs.getLayers(), paramVarArgs);
    }
    return paramVarArgs;
  }
  
  protected void onPostExecute(LottieComposition paramLottieComposition)
  {
    OnCompositionLoadedListener localOnCompositionLoadedListener = this.loadedListener;
    if ((localOnCompositionLoadedListener != null) && (paramLottieComposition != null)) {
      localOnCompositionLoadedListener.onCompositionLoaded(paramLottieComposition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.model.FileCompositionLoader
 * JD-Core Version:    0.7.0.1
 */