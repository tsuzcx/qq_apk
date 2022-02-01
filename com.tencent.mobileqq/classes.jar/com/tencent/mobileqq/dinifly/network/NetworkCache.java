package com.tencent.mobileqq.dinifly.network;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.tencent.mobileqq.dinifly.L;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lottie_cache_");
    localStringBuilder.append(paramString.replaceAll("\\W+", ""));
    if (paramBoolean) {
      paramString = paramFileExtension.tempExtension();
    } else {
      paramString = paramFileExtension.extension;
    }
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @Nullable
  private File getCachedFile(String paramString)
  {
    File localFile = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.JSON, false));
    if (localFile.exists()) {
      return localFile;
    }
    paramString = new File(this.appContext.getCacheDir(), filenameForUrl(paramString, FileExtension.ZIP, false));
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  @Nullable
  @WorkerThread
  Pair<FileExtension, InputStream> fetch()
  {
    try
    {
      File localFile = getCachedFile(this.url);
      if (localFile == null) {
        return null;
      }
      FileInputStream localFileInputStream = new FileInputStream(localFile);
      FileExtension localFileExtension;
      if (localFile.getAbsolutePath().endsWith(".zip")) {
        localFileExtension = FileExtension.ZIP;
      } else {
        localFileExtension = FileExtension.JSON;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cache hit for ");
      localStringBuilder.append(this.url);
      localStringBuilder.append(" at ");
      localStringBuilder.append(localFile.getAbsolutePath());
      L.debug(localStringBuilder.toString());
      return new Pair(localFileExtension, localFileInputStream);
    }
    catch (FileNotFoundException localFileNotFoundException) {}
    return null;
  }
  
  void renameTempFile(FileExtension paramFileExtension)
  {
    paramFileExtension = filenameForUrl(this.url, paramFileExtension, true);
    paramFileExtension = new File(this.appContext.getCacheDir(), paramFileExtension);
    File localFile = new File(paramFileExtension.getAbsolutePath().replace(".temp", ""));
    boolean bool = paramFileExtension.renameTo(localFile);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Copying temp file to real file (");
    localStringBuilder.append(localFile);
    localStringBuilder.append(")");
    L.debug(localStringBuilder.toString());
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to rename cache file ");
      localStringBuilder.append(paramFileExtension.getAbsolutePath());
      localStringBuilder.append(" to ");
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(".");
      L.warn(localStringBuilder.toString());
    }
  }
  
  /* Error */
  File writeTempCacheFile(InputStream paramInputStream, FileExtension paramFileExtension)
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
    //   53: if_icmpeq +14 -> 67
    //   56: aload_2
    //   57: aload 5
    //   59: iconst_0
    //   60: iload_3
    //   61: invokevirtual 170	java/io/OutputStream:write	([BII)V
    //   64: goto -20 -> 44
    //   67: aload_2
    //   68: invokevirtual 173	java/io/OutputStream:flush	()V
    //   71: aload_2
    //   72: invokevirtual 176	java/io/OutputStream:close	()V
    //   75: goto +49 -> 124
    //   78: astore 4
    //   80: goto +51 -> 131
    //   83: astore 5
    //   85: new 28	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   92: astore 6
    //   94: aload 6
    //   96: ldc 178
    //   98: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload 6
    //   104: aload 5
    //   106: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   109: invokevirtual 35	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload 6
    //   115: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 151	com/tencent/mobileqq/dinifly/L:warn	(Ljava/lang/String;)V
    //   121: goto -50 -> 71
    //   124: aload_1
    //   125: invokevirtual 182	java/io/InputStream:close	()V
    //   128: aload 4
    //   130: areturn
    //   131: aload_2
    //   132: invokevirtual 176	java/io/OutputStream:close	()V
    //   135: aload 4
    //   137: athrow
    //   138: astore_2
    //   139: aload_1
    //   140: invokevirtual 182	java/io/InputStream:close	()V
    //   143: goto +5 -> 148
    //   146: aload_2
    //   147: athrow
    //   148: goto -2 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	NetworkCache
    //   0	151	1	paramInputStream	InputStream
    //   0	151	2	paramFileExtension	FileExtension
    //   50	11	3	i	int
    //   25	7	4	localFile1	File
    //   78	58	4	localFile2	File
    //   42	16	5	arrayOfByte	byte[]
    //   83	22	5	localException	java.lang.Exception
    //   92	22	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   37	44	78	finally
    //   44	51	78	finally
    //   56	64	78	finally
    //   67	71	78	finally
    //   85	121	78	finally
    //   37	44	83	java/lang/Exception
    //   44	51	83	java/lang/Exception
    //   56	64	83	java/lang/Exception
    //   67	71	83	java/lang/Exception
    //   27	37	138	finally
    //   71	75	138	finally
    //   131	138	138	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkCache
 * JD-Core Version:    0.7.0.1
 */