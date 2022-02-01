package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.JsonReader;
import androidx.annotation.RawRes;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
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
    LottieComposition localLottieComposition;
    if (paramString == null) {
      localLottieComposition = null;
    } else {
      localLottieComposition = LottieCompositionCache.getInstance().get(paramString);
    }
    if (localLottieComposition != null) {
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("asset_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      if (paramString.endsWith(".zip")) {
        return fromZipStreamSync(new ZipInputStream(paramContext.getAssets().open(paramString)), (String)localObject);
      }
      paramContext = fromJsonInputStreamSync(paramContext.getAssets().open(paramString), (String)localObject);
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
  
  /* Error */
  private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader paramJsonReader, @Nullable String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 243	com/tencent/mobileqq/dinifly/parser/LottieCompositionParser:parse	(Landroid/util/JsonReader;)Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   4: astore_3
    //   5: invokestatic 29	com/tencent/mobileqq/dinifly/model/LottieCompositionCache:getInstance	()Lcom/tencent/mobileqq/dinifly/model/LottieCompositionCache;
    //   8: aload_1
    //   9: aload_3
    //   10: invokevirtual 246	com/tencent/mobileqq/dinifly/model/LottieCompositionCache:put	(Ljava/lang/String;Lcom/tencent/mobileqq/dinifly/LottieComposition;)V
    //   13: new 177	com/tencent/mobileqq/dinifly/LottieResult
    //   16: dup
    //   17: aload_3
    //   18: invokespecial 249	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Object;)V
    //   21: astore_1
    //   22: iload_2
    //   23: ifeq +7 -> 30
    //   26: aload_0
    //   27: invokestatic 221	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   30: aload_1
    //   31: areturn
    //   32: astore_1
    //   33: goto +23 -> 56
    //   36: astore_1
    //   37: new 177	com/tencent/mobileqq/dinifly/LottieResult
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 180	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Throwable;)V
    //   45: astore_1
    //   46: iload_2
    //   47: ifeq +7 -> 54
    //   50: aload_0
    //   51: invokestatic 221	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   54: aload_1
    //   55: areturn
    //   56: iload_2
    //   57: ifeq +7 -> 64
    //   60: aload_0
    //   61: invokestatic 221	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	paramJsonReader	JsonReader
    //   0	66	1	paramString	String
    //   0	66	2	paramBoolean	boolean
    //   4	14	3	localLottieComposition	LottieComposition
    // Exception table:
    //   from	to	target	type
    //   0	22	32	finally
    //   37	46	32	finally
    //   0	22	36	java/lang/Exception
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url_");
    localStringBuilder.append(paramString);
    return cache(localStringBuilder.toString(), new LottieCompositionFactory.1(paramContext, paramString));
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
    try
    {
      Object localObject1 = paramZipInputStream.getNextEntry();
      LottieComposition localLottieComposition = null;
      while (localObject1 != null) {
        if ((((ZipEntry)localObject1).getName() != null) && (!((ZipEntry)localObject1).getName().contains("../")))
        {
          if (((ZipEntry)localObject1).getName().contains("__MACOSX"))
          {
            paramZipInputStream.closeEntry();
          }
          else if (((ZipEntry)localObject1).getName().contains(".json"))
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
          localObject1 = paramZipInputStream.getNextEntry();
        }
      }
      if (localLottieComposition == null) {
        return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
      }
      paramZipInputStream = ((Map)localObject2).entrySet().iterator();
      while (paramZipInputStream.hasNext())
      {
        localObject1 = (Map.Entry)paramZipInputStream.next();
        localObject2 = findImageAssetForFileName(localLottieComposition, (String)((Map.Entry)localObject1).getKey());
        if (localObject2 != null) {
          ((LottieImageAsset)localObject2).setBitmap((Bitmap)((Map.Entry)localObject1).getValue());
        }
      }
      localObject1 = localLottieComposition.getImages().entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        paramZipInputStream = (Map.Entry)((Iterator)localObject1).next();
        if (((LottieImageAsset)paramZipInputStream.getValue()).getBitmap() == null)
        {
          paramString = new StringBuilder();
          paramString.append("There is no image for ");
          paramString.append(((LottieImageAsset)paramZipInputStream.getValue()).getFileName());
          return new LottieResult(new IllegalStateException(paramString.toString()));
        }
      }
      LottieCompositionCache.getInstance().put(paramString, localLottieComposition);
      return new LottieResult(localLottieComposition);
    }
    catch (IOException paramZipInputStream) {}
    return new LottieResult(paramZipInputStream);
  }
  
  private static String rawResCacheKey(@RawRes int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rawRes_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory
 * JD-Core Version:    0.7.0.1
 */