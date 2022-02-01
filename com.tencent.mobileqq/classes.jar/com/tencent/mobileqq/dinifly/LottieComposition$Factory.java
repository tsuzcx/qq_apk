package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.v4.util.MQLruCache;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.RawRes;
import com.tencent.mobileqq.dinifly.model.FileCompositionLoader;
import com.tencent.mobileqq.dinifly.model.JsonCompositionLoader;
import java.io.InputStream;
import org.json.JSONObject;

@Deprecated
public class LottieComposition$Factory
{
  public static final String KEY_CACHE_PREFIX = "key";
  public static final String KEY_PATH_PREFIX = "path";
  
  @Deprecated
  public static Cancellable fromAssetFileName(Context paramContext, String paramString, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramOnCompositionLoadedListener = new LottieComposition.Factory.ListenerAdapter(paramOnCompositionLoadedListener);
    LottieCompositionFactory.fromAsset(paramContext, paramString).addListener(paramOnCompositionLoadedListener);
    return paramOnCompositionLoadedListener;
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromFileSync(Context paramContext, String paramString)
  {
    return (LottieComposition)LottieCompositionFactory.fromAssetSync(paramContext, paramString).getValue();
  }
  
  @Deprecated
  public static Cancellable fromInputStream(Context paramContext, InputStream paramInputStream, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramContext = new LottieComposition.Factory.ListenerAdapter(paramOnCompositionLoadedListener);
    LottieCompositionFactory.fromJsonInputStream(paramInputStream, null).addListener(paramContext);
    return paramContext;
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromInputStreamSync(InputStream paramInputStream)
  {
    return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramInputStream, null).getValue();
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromInputStreamSync(InputStream paramInputStream, boolean paramBoolean)
  {
    if (paramBoolean) {
      Log.w("LOTTIE", "Lottie now auto-closes input stream!");
    }
    return (LottieComposition)LottieCompositionFactory.fromJsonInputStreamSync(paramInputStream, null).getValue();
  }
  
  public static Cancellable fromInputStreamWithCacheBitmap(Context paramContext, InputStream paramInputStream, LottieDrawable paramLottieDrawable, OnCompositionLoadedListener paramOnCompositionLoadedListener, Bundle paramBundle, MQLruCache<String, Object> paramMQLruCache)
  {
    paramContext = new FileCompositionLoader(paramContext.getResources(), paramOnCompositionLoadedListener, paramBundle, paramLottieDrawable, paramMQLruCache);
    paramContext.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new InputStream[] { paramInputStream });
    return paramContext;
  }
  
  public static Cancellable fromJson(Resources paramResources, JSONObject paramJSONObject, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramResources = new JsonCompositionLoader(paramResources, paramOnCompositionLoadedListener);
    paramResources.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new JSONObject[] { paramJSONObject });
    return paramResources;
  }
  
  @Deprecated
  public static Cancellable fromJsonReader(JsonReader paramJsonReader, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramOnCompositionLoadedListener = new LottieComposition.Factory.ListenerAdapter(paramOnCompositionLoadedListener);
    LottieCompositionFactory.fromJsonReader(paramJsonReader, null).addListener(paramOnCompositionLoadedListener);
    return paramOnCompositionLoadedListener;
  }
  
  @Deprecated
  public static Cancellable fromJsonString(String paramString, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramOnCompositionLoadedListener = new LottieComposition.Factory.ListenerAdapter(paramOnCompositionLoadedListener);
    LottieCompositionFactory.fromJsonString(paramString, null).addListener(paramOnCompositionLoadedListener);
    return paramOnCompositionLoadedListener;
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromJsonSync(Resources paramResources, JSONObject paramJSONObject)
  {
    return (LottieComposition)LottieCompositionFactory.fromJsonSync(paramJSONObject, null).getValue();
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromJsonSync(JsonReader paramJsonReader)
  {
    return (LottieComposition)LottieCompositionFactory.fromJsonReaderSync(paramJsonReader, null).getValue();
  }
  
  @Deprecated
  @Nullable
  @WorkerThread
  public static LottieComposition fromJsonSync(String paramString)
  {
    return (LottieComposition)LottieCompositionFactory.fromJsonStringSync(paramString, null).getValue();
  }
  
  @Deprecated
  public static Cancellable fromRawFile(Context paramContext, @RawRes int paramInt, OnCompositionLoadedListener paramOnCompositionLoadedListener)
  {
    paramOnCompositionLoadedListener = new LottieComposition.Factory.ListenerAdapter(paramOnCompositionLoadedListener);
    LottieCompositionFactory.fromRawRes(paramContext, paramInt).addListener(paramOnCompositionLoadedListener);
    return paramOnCompositionLoadedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieComposition.Factory
 * JD-Core Version:    0.7.0.1
 */