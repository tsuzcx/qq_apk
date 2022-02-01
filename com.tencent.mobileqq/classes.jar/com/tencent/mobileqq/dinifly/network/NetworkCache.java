package com.tencent.mobileqq.dinifly.network;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.tencent.mobileqq.dinifly.utils.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class NetworkCache
{
  @NonNull
  private final LottieNetworkCacheProvider cacheProvider;
  
  public NetworkCache(@NonNull LottieNetworkCacheProvider paramLottieNetworkCacheProvider)
  {
    this.cacheProvider = paramLottieNetworkCacheProvider;
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
    File localFile = new File(parentDir(), filenameForUrl(paramString, FileExtension.JSON, false));
    if (localFile.exists()) {
      return localFile;
    }
    paramString = new File(parentDir(), filenameForUrl(paramString, FileExtension.ZIP, false));
    if (paramString.exists()) {
      return paramString;
    }
    return null;
  }
  
  private File parentDir()
  {
    File localFile = this.cacheProvider.getCacheDir();
    if (localFile.isFile()) {
      localFile.delete();
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void clear()
  {
    File localFile = parentDir();
    if (localFile.exists())
    {
      File[] arrayOfFile = localFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        arrayOfFile = localFile.listFiles();
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
      localFile.delete();
    }
  }
  
  @Nullable
  @WorkerThread
  Pair<FileExtension, InputStream> fetch(String paramString)
  {
    try
    {
      File localFile = getCachedFile(paramString);
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
      localStringBuilder.append(paramString);
      localStringBuilder.append(" at ");
      localStringBuilder.append(localFile.getAbsolutePath());
      Logger.debug(localStringBuilder.toString());
      return new Pair(localFileExtension, localFileInputStream);
    }
    catch (FileNotFoundException paramString) {}
    return null;
  }
  
  void renameTempFile(String paramString, FileExtension paramFileExtension)
  {
    paramString = filenameForUrl(paramString, paramFileExtension, true);
    paramString = new File(parentDir(), paramString);
    paramFileExtension = new File(paramString.getAbsolutePath().replace(".temp", ""));
    boolean bool = paramString.renameTo(paramFileExtension);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Copying temp file to real file (");
    localStringBuilder.append(paramFileExtension);
    localStringBuilder.append(")");
    Logger.debug(localStringBuilder.toString());
    if (!bool)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to rename cache file ");
      localStringBuilder.append(paramString.getAbsolutePath());
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramFileExtension.getAbsolutePath());
      localStringBuilder.append(".");
      Logger.warning(localStringBuilder.toString());
    }
  }
  
  /* Error */
  File writeTempCacheFile(String paramString, InputStream paramInputStream, FileExtension paramFileExtension)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_3
    //   2: iconst_1
    //   3: invokestatic 65	com/tencent/mobileqq/dinifly/network/NetworkCache:filenameForUrl	(Ljava/lang/String;Lcom/tencent/mobileqq/dinifly/network/FileExtension;Z)Ljava/lang/String;
    //   6: astore_1
    //   7: new 55	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 59	com/tencent/mobileqq/dinifly/network/NetworkCache:parentDir	()Ljava/io/File;
    //   15: aload_1
    //   16: invokespecial 68	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore_3
    //   20: new 169	java/io/FileOutputStream
    //   23: dup
    //   24: aload_3
    //   25: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   28: astore_1
    //   29: sipush 1024
    //   32: newarray byte
    //   34: astore 5
    //   36: aload_2
    //   37: aload 5
    //   39: invokevirtual 176	java/io/InputStream:read	([B)I
    //   42: istore 4
    //   44: iload 4
    //   46: iconst_m1
    //   47: if_icmpeq +15 -> 62
    //   50: aload_1
    //   51: aload 5
    //   53: iconst_0
    //   54: iload 4
    //   56: invokevirtual 182	java/io/OutputStream:write	([BII)V
    //   59: goto -23 -> 36
    //   62: aload_1
    //   63: invokevirtual 185	java/io/OutputStream:flush	()V
    //   66: aload_1
    //   67: invokevirtual 188	java/io/OutputStream:close	()V
    //   70: goto +48 -> 118
    //   73: astore_3
    //   74: goto +50 -> 124
    //   77: astore 5
    //   79: new 20	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   86: astore 6
    //   88: aload 6
    //   90: ldc 190
    //   92: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload 6
    //   98: aload 5
    //   100: invokevirtual 193	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   103: invokevirtual 27	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 6
    //   109: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 198	com/tencent/mobileqq/dinifly/L:warn	(Ljava/lang/String;)V
    //   115: goto -49 -> 66
    //   118: aload_2
    //   119: invokevirtual 199	java/io/InputStream:close	()V
    //   122: aload_3
    //   123: areturn
    //   124: aload_1
    //   125: invokevirtual 188	java/io/OutputStream:close	()V
    //   128: aload_3
    //   129: athrow
    //   130: astore_1
    //   131: aload_2
    //   132: invokevirtual 199	java/io/InputStream:close	()V
    //   135: goto +5 -> 140
    //   138: aload_1
    //   139: athrow
    //   140: goto -2 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	NetworkCache
    //   0	143	1	paramString	String
    //   0	143	2	paramInputStream	InputStream
    //   0	143	3	paramFileExtension	FileExtension
    //   42	13	4	i	int
    //   34	18	5	arrayOfByte	byte[]
    //   77	22	5	localException	java.lang.Exception
    //   86	22	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   29	36	73	finally
    //   36	44	73	finally
    //   50	59	73	finally
    //   62	66	73	finally
    //   79	115	73	finally
    //   29	36	77	java/lang/Exception
    //   36	44	77	java/lang/Exception
    //   50	59	77	java/lang/Exception
    //   62	66	77	java/lang/Exception
    //   20	29	130	finally
    //   66	70	130	finally
    //   124	130	130	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.network.NetworkCache
 * JD-Core Version:    0.7.0.1
 */