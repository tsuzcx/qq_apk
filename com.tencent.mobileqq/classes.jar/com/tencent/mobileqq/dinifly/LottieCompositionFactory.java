package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.dinifly.model.LottieCompositionCache;
import com.tencent.mobileqq.dinifly.network.NetworkCache;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
import com.tencent.mobileqq.dinifly.parser.moshi.JsonReader;
import com.tencent.mobileqq.dinifly.utils.Logger;
import com.tencent.mobileqq.dinifly.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

public class LottieCompositionFactory
{
  private static final byte[] MAGIC = { 80, 75, 3, 4 };
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
    if (paramString != null)
    {
      paramCallable.addListener(new LottieCompositionFactory.10(paramString));
      paramCallable.addFailureListener(new LottieCompositionFactory.11(paramString));
      taskCache.put(paramString, paramCallable);
    }
    return paramCallable;
  }
  
  public static void clearCache(Context paramContext)
  {
    taskCache.clear();
    LottieCompositionCache.getInstance().clear();
    L.networkCache(paramContext).clear();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asset_");
    localStringBuilder.append(paramString);
    return fromAsset(paramContext, paramString, localStringBuilder.toString());
  }
  
  public static LottieTask<LottieComposition> fromAsset(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    return cache(paramString2, new LottieCompositionFactory.2(paramContext.getApplicationContext(), paramString1, paramString2));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromAssetSync(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("asset_");
    localStringBuilder.append(paramString);
    return fromAssetSync(paramContext, paramString, localStringBuilder.toString());
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromAssetSync(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    try
    {
      if ((!paramString1.endsWith(".zip")) && (!paramString1.endsWith(".lottie"))) {
        return fromJsonInputStreamSync(paramContext.getAssets().open(paramString1), paramString2);
      }
      paramContext = fromZipStreamSync(new ZipInputStream(paramContext.getAssets().open(paramString1)), paramString2);
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
      paramString = fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(paramInputStream))), paramString);
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
    //   1: invokestatic 284	com/tencent/mobileqq/dinifly/parser/LottieCompositionMoshiParser:parse	(Lcom/tencent/mobileqq/dinifly/parser/moshi/JsonReader;)Lcom/tencent/mobileqq/dinifly/LottieComposition;
    //   4: astore_3
    //   5: aload_1
    //   6: ifnull +11 -> 17
    //   9: invokestatic 37	com/tencent/mobileqq/dinifly/model/LottieCompositionCache:getInstance	()Lcom/tencent/mobileqq/dinifly/model/LottieCompositionCache;
    //   12: aload_1
    //   13: aload_3
    //   14: invokevirtual 287	com/tencent/mobileqq/dinifly/model/LottieCompositionCache:put	(Ljava/lang/String;Lcom/tencent/mobileqq/dinifly/LottieComposition;)V
    //   17: new 210	com/tencent/mobileqq/dinifly/LottieResult
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 290	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Object;)V
    //   25: astore_1
    //   26: iload_2
    //   27: ifeq +7 -> 34
    //   30: aload_0
    //   31: invokestatic 262	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   34: aload_1
    //   35: areturn
    //   36: astore_1
    //   37: goto +23 -> 60
    //   40: astore_1
    //   41: new 210	com/tencent/mobileqq/dinifly/LottieResult
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 213	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Throwable;)V
    //   49: astore_1
    //   50: iload_2
    //   51: ifeq +7 -> 58
    //   54: aload_0
    //   55: invokestatic 262	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   58: aload_1
    //   59: areturn
    //   60: iload_2
    //   61: ifeq +7 -> 68
    //   64: aload_0
    //   65: invokestatic 262	com/tencent/mobileqq/dinifly/utils/Utils:closeQuietly	(Ljava/io/Closeable;)V
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramJsonReader	JsonReader
    //   0	70	1	paramString	String
    //   0	70	2	paramBoolean	boolean
    //   4	18	3	localLottieComposition	LottieComposition
    // Exception table:
    //   from	to	target	type
    //   0	5	36	finally
    //   9	17	36	finally
    //   17	26	36	finally
    //   41	50	36	finally
    //   0	5	40	java/lang/Exception
    //   9	17	40	java/lang/Exception
    //   17	26	40	java/lang/Exception
  }
  
  public static LottieTask<LottieComposition> fromJsonString(String paramString1, @Nullable String paramString2)
  {
    return cache(paramString2, new LottieCompositionFactory.6(paramString1, paramString2));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonStringSync(String paramString1, @Nullable String paramString2)
  {
    return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(paramString1.getBytes())))), paramString2);
  }
  
  @Deprecated
  @WorkerThread
  public static LottieResult<LottieComposition> fromJsonSync(JSONObject paramJSONObject, @Nullable String paramString)
  {
    return fromJsonStringSync(paramJSONObject.toString(), paramString);
  }
  
  public static LottieTask<LottieComposition> fromRawRes(Context paramContext, @RawRes int paramInt)
  {
    return fromRawRes(paramContext, paramInt, rawResCacheKey(paramContext, paramInt));
  }
  
  public static LottieTask<LottieComposition> fromRawRes(Context paramContext, @RawRes int paramInt, @Nullable String paramString)
  {
    return cache(paramString, new LottieCompositionFactory.3(new WeakReference(paramContext), paramContext.getApplicationContext(), paramInt, paramString));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromRawResSync(Context paramContext, @RawRes int paramInt)
  {
    return fromRawResSync(paramContext, paramInt, rawResCacheKey(paramContext, paramInt));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromRawResSync(Context paramContext, @RawRes int paramInt, @Nullable String paramString)
  {
    try
    {
      paramContext = Okio.buffer(Okio.source(paramContext.getResources().openRawResource(paramInt)));
      if (isZipCompressed(paramContext).booleanValue()) {
        return fromZipStreamSync(new ZipInputStream(paramContext.inputStream()), paramString);
      }
      paramContext = fromJsonInputStreamSync(paramContext.inputStream(), paramString);
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
    return fromUrl(paramContext, paramString, localStringBuilder.toString());
  }
  
  public static LottieTask<LottieComposition> fromUrl(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    return cache(paramString2, new LottieCompositionFactory.1(paramContext, paramString1, paramString2));
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromUrlSync(Context paramContext, String paramString)
  {
    return fromUrlSync(paramContext, paramString, paramString);
  }
  
  @WorkerThread
  public static LottieResult<LottieComposition> fromUrlSync(Context paramContext, String paramString1, @Nullable String paramString2)
  {
    paramContext = L.networkFetcher(paramContext).fetchSync(paramString1, paramString2);
    if ((paramString2 != null) && (paramContext.getValue() != null)) {
      LottieCompositionCache.getInstance().put(paramString2, (LottieComposition)paramContext.getValue());
    }
    return paramContext;
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
          String str = ((ZipEntry)localObject1).getName();
          if (str.contains("__MACOSX"))
          {
            paramZipInputStream.closeEntry();
          }
          else if (((ZipEntry)localObject1).getName().equalsIgnoreCase("manifest.json"))
          {
            paramZipInputStream.closeEntry();
          }
          else if (((ZipEntry)localObject1).getName().contains(".json"))
          {
            localLottieComposition = (LottieComposition)fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(paramZipInputStream))), null, false).getValue();
          }
          else if ((!str.contains(".png")) && (!str.contains(".webp")) && (!str.contains(".jpg")) && (!str.contains(".jpeg")))
          {
            paramZipInputStream.closeEntry();
          }
          else
          {
            localObject1 = str.split("/");
            ((Map)localObject2).put(localObject1[(localObject1.length - 1)], BitmapFactory.decodeStream(paramZipInputStream));
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
          ((LottieImageAsset)localObject2).setBitmap(Utils.resizeBitmapIfNeeded((Bitmap)((Map.Entry)localObject1).getValue(), ((LottieImageAsset)localObject2).getWidth(), ((LottieImageAsset)localObject2).getHeight()));
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
      if (paramString != null) {
        LottieCompositionCache.getInstance().put(paramString, localLottieComposition);
      }
      return new LottieResult(localLottieComposition);
    }
    catch (IOException paramZipInputStream) {}
    return new LottieResult(paramZipInputStream);
  }
  
  private static boolean isNightMode(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().uiMode & 0x30) == 32;
  }
  
  private static Boolean isZipCompressed(BufferedSource paramBufferedSource)
  {
    for (;;)
    {
      int i;
      try
      {
        paramBufferedSource = paramBufferedSource.peek();
        byte[] arrayOfByte = MAGIC;
        int j = arrayOfByte.length;
        i = 0;
        if (i < j)
        {
          int k = arrayOfByte[i];
          if (paramBufferedSource.readByte() != k) {
            return Boolean.valueOf(false);
          }
        }
        else
        {
          paramBufferedSource.close();
          return Boolean.valueOf(true);
        }
      }
      catch (Exception paramBufferedSource)
      {
        Logger.error("Failed to check zip file header", paramBufferedSource);
        return Boolean.valueOf(false);
      }
      i += 1;
    }
  }
  
  private static String rawResCacheKey(Context paramContext, @RawRes int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rawRes");
    if (isNightMode(paramContext)) {
      paramContext = "_night_";
    } else {
      paramContext = "_day_";
    }
    localStringBuilder.append(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.LottieCompositionFactory
 * JD-Core Version:    0.7.0.1
 */