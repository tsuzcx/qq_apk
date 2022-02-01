package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.support.annotation.WorkerThread;
import android.util.JsonReader;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
import com.tencent.mobileqq.dinifly.parser.LottieCompositionParser;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.json.JSONObject;

public class LottieCompositionFactory
{
  private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
  
  private static LottieTask<LottieComposition> cache(@Nullable String paramString, Callable<LottieResult<LottieComposition>> paramCallable)
  {
    if (paramString == null) {}
    for (LottieComposition localLottieComposition = null; localLottieComposition != null; localLottieComposition = LottieCompositionCache.getInstance().get(paramString)) {
      return new LottieTask(new LottieCompositionFactory.9(localLottieComposition));
    }
    if ((paramString != null) && (taskCache.containsKey(paramString))) {
      return (LottieTask)taskCache.get(paramString);
    }
    paramCallable = new LottieTask(paramCallable);
    paramCallable.addListener(new LottieCompositionFactory.10(paramString));
    paramCallable.addFailureListener(new LottieCompositionFactory.11(paramString));
    taskCache.put(paramString, paramCallable);
    return paramCallable;
  }
  
  @Nullable
  private static LottieImageAsset findImageAssetForFileName(LottieComposition paramLottieComposition, String paramString)
  {
    paramLottieComposition = paramLottieComposition.getImages().values().iterator();
    while (paramLottieComposition.hasNext())
    {
      LottieImageAsset localLottieImageAsset = (LottieImageAsset)paramLottieComposition.next();
      if (localLottieImageAsset.getFileName().equals(paramString)) {
        return localLottieImageAsset;
      }
    }
    return null;
  }
  
  public static LottieTask<LottieComposition> fromAsset(Context paramContext, String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.2(paramContext.getApplicationContext(), paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromAssetSync(Context paramContext, String paramString)
  {
    try
    {
      String str = "asset_" + paramString;
      if (paramString.endsWith(".zip")) {
        return fromZipStreamSync(new ZipInputStream(paramContext.getAssets().open(paramString)), str);
      }
      paramContext = fromJsonInputStreamSync(paramContext.getAssets().open(paramString), str);
      return paramContext;
    }
    catch (IOException paramContext) {}
    return new LottieResult(paramContext);
  }
  
  @Deprecated
  public static LottieTask<LottieComposition> fromJson(JSONObject paramJSONObject, @Nullable String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.5(paramJSONObject, paramString));
  }
  
  public static LottieTask<LottieComposition> fromJsonInputStream(InputStream paramInputStream, @Nullable String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.4(paramInputStream, paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream paramInputStream, @Nullable String paramString)
  {
    return fromJsonInputStreamSync(paramInputStream, paramString, true);
  }
  
  @WorkerThread
  private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream paramInputStream, @Nullable String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = fromJsonReaderSync(new JsonReader(new InputStreamReader(paramInputStream)), paramString);
      return paramString;
    }
    finally
    {
      if (paramBoolean) {
        Utils.closeQuietly(paramInputStream);
      }
    }
  }
  
  public static LottieTask<LottieComposition> fromJsonReader(JsonReader paramJsonReader, @Nullable String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.7(paramJsonReader, paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader paramJsonReader, @Nullable String paramString)
  {
    return fromJsonReaderSyncInternal(paramJsonReader, paramString, true);
  }
  
  private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader paramJsonReader, @Nullable String paramString, boolean paramBoolean)
  {
    label67:
    try
    {
      localObject = LottieCompositionParser.parse(paramJsonReader);
      LottieCompositionCache.getInstance().put(paramString, (LottieComposition)localObject);
      localObject = new LottieResult(localObject);
      paramString = (String)localObject;
      if (paramBoolean)
      {
        Utils.closeQuietly(paramJsonReader);
        paramString = (String)localObject;
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new LottieResult(paramString);
      paramString = (String)localObject;
      return localObject;
    }
    finally
    {
      if (!paramBoolean) {
        break label67;
      }
      Utils.closeQuietly(paramJsonReader);
    }
    return paramString;
  }
  
  public static LottieTask<LottieComposition> fromJsonString(String paramString1, @Nullable String paramString2)
  {
    return cache(paramString2, new LottieCompositionFactory.6(paramString1, paramString2));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonStringSync(String paramString1, @Nullable String paramString2)
  {
    return fromJsonReaderSync(new JsonReader(new StringReader(paramString1)), paramString2);
  }
  
  @Deprecated
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonSync(JSONObject paramJSONObject, @Nullable String paramString)
  {
    return fromJsonStringSync(paramJSONObject.toString(), paramString);
  }
  
  public static LottieTask<LottieComposition> fromRawRes(Context paramContext, @RawRes int paramInt)
  {
    paramContext = paramContext.getApplicationContext();
    return cache(rawResCacheKey(paramInt), new LottieCompositionFactory.3(paramContext, paramInt));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromRawResSync(Context paramContext, @RawRes int paramInt)
  {
    try
    {
      paramContext = fromJsonInputStreamSync(paramContext.getResources().openRawResource(paramInt), rawResCacheKey(paramInt));
      return paramContext;
    }
    catch (Resources.NotFoundException paramContext) {}
    return new LottieResult(paramContext);
  }
  
  public static LottieTask<LottieComposition> fromUrl(Context paramContext, String paramString)
  {
    return cache("url_" + paramString, new LottieCompositionFactory.1(paramContext, paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromUrlSync(Context paramContext, String paramString)
  {
    return NetworkFetcher.fetchSync(paramContext, paramString);
  }
  
  public static LottieTask<LottieComposition> fromZipStream(ZipInputStream paramZipInputStream, @Nullable String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.8(paramZipInputStream, paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream paramZipInputStream, @Nullable String paramString)
  {
    try
    {
      paramString = fromZipStreamSyncInternal(paramZipInputStream, paramString);
      return paramString;
    }
    finally
    {
      Utils.closeQuietly(paramZipInputStream);
    }
  }
  
  @WorkerThread
  private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream paramZipInputStream, @Nullable String paramString)
  {
    Object localObject2 = new HashMap();
    Object localObject1;
    LottieComposition localLottieComposition;
    try
    {
      localObject1 = paramZipInputStream.getNextEntry();
      localLottieComposition = null;
      while (localObject1 != null) {
        if ((((ZipEntry)localObject1).getName() != null) && (!((ZipEntry)localObject1).getName().contains("../")))
        {
          if (((ZipEntry)localObject1).getName().contains("__MACOSX")) {
            paramZipInputStream.closeEntry();
          }
          for (;;)
          {
            localObject1 = paramZipInputStream.getNextEntry();
            break;
            if (((ZipEntry)localObject1).getName().contains(".json"))
            {
              localLottieComposition = (LottieComposition)fromJsonReaderSyncInternal(new JsonReader(new InputStreamReader(paramZipInputStream)), null, false).getValue();
            }
            else if (((ZipEntry)localObject1).getName().contains(".png"))
            {
              localObject1 = ((ZipEntry)localObject1).getName().split("/");
              ((Map)localObject2).put(localObject1[(localObject1.length - 1)], BitmapFactory.decodeStream(paramZipInputStream));
            }
            else
            {
              paramZipInputStream.closeEntry();
            }
          }
        }
      }
      if (localLottieComposition != null) {
        break label192;
      }
    }
    catch (IOException paramZipInputStream)
    {
      return new LottieResult(paramZipInputStream);
    }
    return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
    label192:
    paramZipInputStream = ((Map)localObject2).entrySet().iterator();
    while (paramZipInputStream.hasNext())
    {
      localObject1 = (Map.Entry)paramZipInputStream.next();
      localObject2 = findImageAssetForFileName(localLottieComposition, (String)((Map.Entry)localObject1).getKey());
      if (localObject2 != null) {
        ((LottieImageAsset)localObject2).setBitmap((Bitmap)((Map.Entry)localObject1).getValue());
      }
    }
    paramZipInputStream = localLottieComposition.getImages().entrySet().iterator();
    while (paramZipInputStream.hasNext())
    {
      localObject1 = (Map.Entry)paramZipInputStream.next();
      if (((LottieImageAsset)((Map.Entry)localObject1).getValue()).getBitmap() == null) {
        return new LottieResult(new IllegalStateException("There is no image for " + ((LottieImageAsset)((Map.Entry)localObject1).getValue()).getFileName()));
      }
    }
    LottieCompositionCache.getInstance().put(paramString, localLottieComposition);
    return new LottieResult(localLottieComposition);
  }
  
  private static String rawResCacheKey(@RawRes int paramInt)
  {
    return "rawRes_" + paramInt;
  }
  
  public static void removeCacheByKey(String paramString)
  {
    if (paramString != null) {
      taskCache.remove(paramString);
    }
  }
  
  public static void setMaxCacheSize(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      LottieCompositionCache.getInstance().resize(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory
 * JD-Core Version:    0.7.0.1
 */