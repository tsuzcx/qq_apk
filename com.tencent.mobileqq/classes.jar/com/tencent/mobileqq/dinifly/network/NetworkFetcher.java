package com.tencent.mobileqq.dinifly.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.LottieCompositionFactory;
import com.tencent.mobileqq.dinifly.LottieResult;
import com.tencent.mobileqq.dinifly.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

public class NetworkFetcher
{
  @NonNull
  private final LottieNetworkFetcher fetcher;
  @NonNull
  private final NetworkCache networkCache;
  
  public NetworkFetcher(@NonNull NetworkCache paramNetworkCache, @NonNull LottieNetworkFetcher paramLottieNetworkFetcher)
  {
    this.networkCache = paramNetworkCache;
    this.fetcher = paramLottieNetworkFetcher;
  }
  
  @Nullable
  @WorkerThread
  private LottieComposition fetchFromCache(@NonNull String paramString1, @Nullable String paramString2)
  {
    if (paramString2 == null) {
      return null;
    }
    Object localObject = this.networkCache.fetch(paramString1);
    if (localObject == null) {
      return null;
    }
    paramString2 = (FileExtension)((Pair)localObject).first;
    localObject = (InputStream)((Pair)localObject).second;
    if (paramString2 == FileExtension.ZIP) {
      paramString1 = LottieCompositionFactory.fromZipStreamSync(new ZipInputStream((InputStream)localObject), paramString1);
    } else {
      paramString1 = LottieCompositionFactory.fromJsonInputStreamSync((InputStream)localObject, paramString1);
    }
    if (paramString1.getValue() != null) {
      return (LottieComposition)paramString1.getValue();
    }
    return null;
  }
  
  /* Error */
  @NonNull
  @WorkerThread
  private LottieResult<LottieComposition> fetchFromNetwork(@NonNull String paramString1, @Nullable String paramString2)
  {
    // Byte code:
    //   0: new 79	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc 82
    //   13: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 4
    //   19: aload_1
    //   20: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: invokestatic 96	com/tencent/mobileqq/dinifly/utils/Logger:debug	(Ljava/lang/String;)V
    //   32: aconst_null
    //   33: astore 5
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 18	com/tencent/mobileqq/dinifly/network/NetworkFetcher:fetcher	Lcom/tencent/mobileqq/dinifly/network/LottieNetworkFetcher;
    //   42: aload_1
    //   43: invokeinterface 102 2 0
    //   48: astore 6
    //   50: aload 6
    //   52: astore 4
    //   54: aload 6
    //   56: astore 5
    //   58: aload 6
    //   60: invokeinterface 108 1 0
    //   65: ifeq +135 -> 200
    //   68: aload 6
    //   70: astore 4
    //   72: aload 6
    //   74: astore 5
    //   76: aload_0
    //   77: aload_1
    //   78: aload 6
    //   80: invokeinterface 112 1 0
    //   85: aload 6
    //   87: invokeinterface 115 1 0
    //   92: aload_2
    //   93: invokespecial 119	com/tencent/mobileqq/dinifly/network/NetworkFetcher:fromInputStream	(Ljava/lang/String;Ljava/io/InputStream;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/dinifly/LottieResult;
    //   96: astore_1
    //   97: aload 6
    //   99: astore 4
    //   101: aload 6
    //   103: astore 5
    //   105: new 79	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   112: astore_2
    //   113: aload 6
    //   115: astore 4
    //   117: aload 6
    //   119: astore 5
    //   121: aload_2
    //   122: ldc 121
    //   124: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 6
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: aload_1
    //   137: invokevirtual 68	com/tencent/mobileqq/dinifly/LottieResult:getValue	()Ljava/lang/Object;
    //   140: ifnull +178 -> 318
    //   143: iconst_1
    //   144: istore_3
    //   145: goto +3 -> 148
    //   148: aload 6
    //   150: astore 4
    //   152: aload 6
    //   154: astore 5
    //   156: aload_2
    //   157: iload_3
    //   158: invokevirtual 124	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: astore 4
    //   166: aload 6
    //   168: astore 5
    //   170: aload_2
    //   171: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 96	com/tencent/mobileqq/dinifly/utils/Logger:debug	(Ljava/lang/String;)V
    //   177: aload 6
    //   179: ifnull +19 -> 198
    //   182: aload 6
    //   184: invokeinterface 127 1 0
    //   189: aload_1
    //   190: areturn
    //   191: astore_2
    //   192: ldc 129
    //   194: aload_2
    //   195: invokestatic 133	com/tencent/mobileqq/dinifly/utils/Logger:warning	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   198: aload_1
    //   199: areturn
    //   200: aload 6
    //   202: astore 4
    //   204: aload 6
    //   206: astore 5
    //   208: new 64	com/tencent/mobileqq/dinifly/LottieResult
    //   211: dup
    //   212: new 135	java/lang/IllegalArgumentException
    //   215: dup
    //   216: aload 6
    //   218: invokeinterface 138 1 0
    //   223: invokespecial 140	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   226: invokespecial 143	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Throwable;)V
    //   229: astore_1
    //   230: aload 6
    //   232: ifnull +19 -> 251
    //   235: aload 6
    //   237: invokeinterface 127 1 0
    //   242: aload_1
    //   243: areturn
    //   244: astore_2
    //   245: ldc 129
    //   247: aload_2
    //   248: invokestatic 133	com/tencent/mobileqq/dinifly/utils/Logger:warning	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_1
    //   252: areturn
    //   253: astore_1
    //   254: goto +40 -> 294
    //   257: astore_1
    //   258: aload 5
    //   260: astore 4
    //   262: new 64	com/tencent/mobileqq/dinifly/LottieResult
    //   265: dup
    //   266: aload_1
    //   267: invokespecial 143	com/tencent/mobileqq/dinifly/LottieResult:<init>	(Ljava/lang/Throwable;)V
    //   270: astore_1
    //   271: aload 5
    //   273: ifnull +19 -> 292
    //   276: aload 5
    //   278: invokeinterface 127 1 0
    //   283: aload_1
    //   284: areturn
    //   285: astore_2
    //   286: ldc 129
    //   288: aload_2
    //   289: invokestatic 133	com/tencent/mobileqq/dinifly/utils/Logger:warning	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   292: aload_1
    //   293: areturn
    //   294: aload 4
    //   296: ifnull +20 -> 316
    //   299: aload 4
    //   301: invokeinterface 127 1 0
    //   306: goto +10 -> 316
    //   309: astore_2
    //   310: ldc 129
    //   312: aload_2
    //   313: invokestatic 133	com/tencent/mobileqq/dinifly/utils/Logger:warning	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload_1
    //   317: athrow
    //   318: iconst_0
    //   319: istore_3
    //   320: goto -172 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	NetworkFetcher
    //   0	323	1	paramString1	String
    //   0	323	2	paramString2	String
    //   144	176	3	bool	boolean
    //   7	293	4	localObject1	Object
    //   33	244	5	localObject2	Object
    //   48	188	6	localLottieFetchResult	LottieFetchResult
    // Exception table:
    //   from	to	target	type
    //   182	189	191	java/io/IOException
    //   235	242	244	java/io/IOException
    //   38	50	253	finally
    //   58	68	253	finally
    //   76	97	253	finally
    //   105	113	253	finally
    //   121	128	253	finally
    //   136	143	253	finally
    //   156	162	253	finally
    //   170	177	253	finally
    //   208	230	253	finally
    //   262	271	253	finally
    //   38	50	257	java/lang/Exception
    //   58	68	257	java/lang/Exception
    //   76	97	257	java/lang/Exception
    //   105	113	257	java/lang/Exception
    //   121	128	257	java/lang/Exception
    //   136	143	257	java/lang/Exception
    //   156	162	257	java/lang/Exception
    //   170	177	257	java/lang/Exception
    //   208	230	257	java/lang/Exception
    //   276	283	285	java/io/IOException
    //   299	306	309	java/io/IOException
  }
  
  @NonNull
  private LottieResult<LottieComposition> fromInputStream(@NonNull String paramString1, @NonNull InputStream paramInputStream, @Nullable String paramString2, @Nullable String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "application/json";
    }
    if ((!str.contains("application/zip")) && (!paramString1.split("\\?")[0].endsWith(".lottie")))
    {
      Logger.debug("Received json response.");
      paramString2 = FileExtension.JSON;
      paramInputStream = fromJsonStream(paramString1, paramInputStream, paramString3);
    }
    else
    {
      Logger.debug("Handling zip response.");
      paramString2 = FileExtension.ZIP;
      paramInputStream = fromZipStream(paramString1, paramInputStream, paramString3);
    }
    if ((paramString3 != null) && (paramInputStream.getValue() != null)) {
      this.networkCache.renameTempFile(paramString1, paramString2);
    }
    return paramInputStream;
  }
  
  @NonNull
  private LottieResult<LottieComposition> fromJsonStream(@NonNull String paramString1, @NonNull InputStream paramInputStream, @Nullable String paramString2)
  {
    if (paramString2 == null) {
      return LottieCompositionFactory.fromJsonInputStreamSync(paramInputStream, null);
    }
    return LottieCompositionFactory.fromJsonInputStreamSync(new FileInputStream(new File(this.networkCache.writeTempCacheFile(paramString1, paramInputStream, FileExtension.JSON).getAbsolutePath())), paramString1);
  }
  
  @NonNull
  private LottieResult<LottieComposition> fromZipStream(@NonNull String paramString1, @NonNull InputStream paramInputStream, @Nullable String paramString2)
  {
    if (paramString2 == null) {
      return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(paramInputStream), null);
    }
    return LottieCompositionFactory.fromZipStreamSync(new ZipInputStream(new FileInputStream(this.networkCache.writeTempCacheFile(paramString1, paramInputStream, FileExtension.ZIP))), paramString1);
  }
  
  @NonNull
  @WorkerThread
  public LottieResult<LottieComposition> fetchSync(@NonNull String paramString1, @Nullable String paramString2)
  {
    Object localObject = fetchFromCache(paramString1, paramString2);
    if (localObject != null) {
      return new LottieResult(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Animation for ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" not found in cache. Fetching from network.");
    Logger.debug(((StringBuilder)localObject).toString());
    return fetchFromNetwork(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkFetcher
 * JD-Core Version:    0.7.0.1
 */