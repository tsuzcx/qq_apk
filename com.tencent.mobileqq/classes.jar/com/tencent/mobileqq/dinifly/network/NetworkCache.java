package com.tencent.mobileqq.dinifly.network;

import android.content.Context;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.L;
import java.io.File;

class NetworkCache
{
  private final Context appContext;
  private final String url;
  
  NetworkCache(Context paramContext, String paramString)
  {
    this.appContext = paramContext.getApplicationContext();
    this.url = paramString;
  }
  
  private static String filenameForUrl(String paramString, FileExtension paramFileExtension, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("lottie_cache_").append(paramString.replaceAll("\\W+", ""));
    if (paramBoolean) {}
    for (paramString = paramFileExtension.tempExtension();; paramString = paramFileExtension.extension) {
      return paramString;
    }
  }
  
  @Nullable
  private File getCachedFile(String paramString)
  {
    File localFile = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.JSON, false));
    if (localFile.exists()) {
      paramString = localFile;
    }
    do
    {
      return paramString;
      localFile = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.ZIP, false));
      paramString = localFile;
    } while (localFile.exists());
    return null;
  }
  
  /* Error */
  @Nullable
  @android.support.annotation.WorkerThread
  android.util.Pair<FileExtension, java.io.InputStream> fetch()
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_0
    //   2: getfield 23	com/tencent/mobileqq/dinifly/network/NetworkCache:url	Ljava/lang/String;
    //   5: invokespecial 90	com/tencent/mobileqq/dinifly/network/NetworkCache:getCachedFile	(Ljava/lang/String;)Ljava/io/File;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnonnull +5 -> 15
    //   13: aconst_null
    //   14: areturn
    //   15: new 92	java/io/FileInputStream
    //   18: dup
    //   19: aload_2
    //   20: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_3
    //   24: aload_2
    //   25: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   28: ldc 100
    //   30: invokevirtual 104	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   33: ifeq +54 -> 87
    //   36: getstatic 82	com/tencent/mobileqq/dinifly/network/FileExtension:ZIP	Lcom/tencent/mobileqq/dinifly/network/FileExtension;
    //   39: astore_1
    //   40: new 28	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   47: ldc 106
    //   49: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 23	com/tencent/mobileqq/dinifly/network/NetworkCache:url	Ljava/lang/String;
    //   56: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 108
    //   61: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_2
    //   65: invokevirtual 98	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 114	com/tencent/mobileqq/dinifly/L:debug	(Ljava/lang/String;)V
    //   77: new 116	android/util/Pair
    //   80: dup
    //   81: aload_1
    //   82: aload_3
    //   83: invokespecial 119	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   86: areturn
    //   87: getstatic 70	com/tencent/mobileqq/dinifly/network/FileExtension:JSON	Lcom/tencent/mobileqq/dinifly/network/FileExtension;
    //   90: astore_1
    //   91: goto -51 -> 40
    //   94: astore_1
    //   95: aconst_null
    //   96: areturn
    //   97: astore_1
    //   98: aconst_null
    //   99: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	NetworkCache
    //   39	52	1	localFileExtension	FileExtension
    //   94	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   97	1	1	localFileNotFoundException2	java.io.FileNotFoundException
    //   8	57	2	localFile	File
    //   23	60	3	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   15	24	94	java/io/FileNotFoundException
    //   0	9	97	java/io/FileNotFoundException
  }
  
  void renameTempFile(FileExtension paramFileExtension)
  {
    paramFileExtension = filenameForUrl(this.url, paramFileExtension, true);
    paramFileExtension = new File(this.appContext.getCacheDir(), paramFileExtension);
    File localFile = new File(paramFileExtension.getAbsolutePath().replace(".temp", ""));
    boolean bool = paramFileExtension.renameTo(localFile);
    L.debug("Copying temp file to real file (" + localFile + ")");
    if (!bool) {
      L.warn("Unable to rename cache file " + paramFileExtension.getAbsolutePath() + " to " + localFile.getAbsolutePath() + ".");
    }
  }
  
  /* Error */
  File writeTempCacheFile(java.io.InputStream paramInputStream, FileExtension paramFileExtension)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 23	com/tencent/mobileqq/dinifly/network/NetworkCache:url	Ljava/lang/String;
    //   4: aload_2
    //   5: iconst_1
    //   6: invokestatic 72	com/tencent/mobileqq/dinifly/network/NetworkCache:filenameForUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/dinifly/network/FileExtension;Z)Ljava/lang/String;
    //   9: astore_2
    //   10: new 62	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: getfield 21	com/tencent/mobileqq/dinifly/network/NetworkCache:appContext	Landroid/content/Context;
    //   18: invokevirtual 66	android/content/Context:getCacheDir	()Ljava/io/File;
    //   21: aload_2
    //   22: invokespecial 75	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   25: astore 4
    //   27: new 157	java/io/FileOutputStream
    //   30: dup
    //   31: aload 4
    //   33: invokespecial 158	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   36: astore_2
    //   37: sipush 1024
    //   40: newarray byte
    //   42: astore 5
    //   44: aload_1
    //   45: aload 5
    //   47: invokevirtual 164	java/io/InputStream:read	([B)I
    //   50: istore_3
    //   51: iload_3
    //   52: iconst_m1
    //   53: if_icmpeq +53 -> 106
    //   56: aload_2
    //   57: aload 5
    //   59: iconst_0
    //   60: iload_3
    //   61: invokevirtual 170	java/io/OutputStream:write	([BII)V
    //   64: goto -20 -> 44
    //   67: astore 5
    //   69: new 28	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   76: ldc 172
    //   78: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload 5
    //   83: invokevirtual 175	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   86: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 151	com/tencent/mobileqq/dinifly/L:warn	(Ljava/lang/String;)V
    //   95: aload_2
    //   96: invokevirtual 178	java/io/OutputStream:close	()V
    //   99: aload_1
    //   100: invokevirtual 179	java/io/InputStream:close	()V
    //   103: aload 4
    //   105: areturn
    //   106: aload_2
    //   107: invokevirtual 182	java/io/OutputStream:flush	()V
    //   110: aload_2
    //   111: invokevirtual 178	java/io/OutputStream:close	()V
    //   114: goto -15 -> 99
    //   117: astore_2
    //   118: aload_1
    //   119: invokevirtual 179	java/io/InputStream:close	()V
    //   122: aload_2
    //   123: athrow
    //   124: astore 4
    //   126: aload_2
    //   127: invokevirtual 178	java/io/OutputStream:close	()V
    //   130: aload 4
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	NetworkCache
    //   0	133	1	paramInputStream	java.io.InputStream
    //   0	133	2	paramFileExtension	FileExtension
    //   50	11	3	i	int
    //   25	79	4	localFile	File
    //   124	7	4	localObject	Object
    //   42	16	5	arrayOfByte	byte[]
    //   67	15	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   37	44	67	java/lang/Exception
    //   44	51	67	java/lang/Exception
    //   56	64	67	java/lang/Exception
    //   106	110	67	java/lang/Exception
    //   27	37	117	finally
    //   95	99	117	finally
    //   110	114	117	finally
    //   126	133	117	finally
    //   37	44	124	finally
    //   44	51	124	finally
    //   56	64	124	finally
    //   69	95	124	finally
    //   106	110	124	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkCache
 * JD-Core Version:    0.7.0.1
 */