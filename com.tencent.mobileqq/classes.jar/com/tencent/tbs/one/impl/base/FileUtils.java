package com.tencent.tbs.one.impl.base;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class FileUtils
{
  public static final String ANDROID_ASSET_PATH = "/android_asset/";
  public static final int EOF = -1;
  public static final String FILE_ANDROID_ASSET_PREFIX = "file:///android_asset/";
  public static final String UTF8_ENCODING = "utf-8";
  
  public static void batchDeleteFiles(File paramFile, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      File localFile = new File(paramFile, paramArrayOfString[i]);
      if (localFile.exists()) {
        recursivelyDeleteFile(localFile);
      }
      i += 1;
    }
  }
  
  public static void close(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException localIOException)
    {
      Logging.e("Failed to close %s", new Object[] { paramCloseable, localIOException });
    }
  }
  
  /* Error */
  public static boolean contentEquals(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_1
    //   4: istore 4
    //   6: aload_0
    //   7: invokevirtual 33	java/io/File:exists	()Z
    //   10: istore 5
    //   12: iload 5
    //   14: aload_1
    //   15: invokevirtual 33	java/io/File:exists	()Z
    //   18: if_icmpeq +5 -> 23
    //   21: iconst_0
    //   22: ireturn
    //   23: iload 5
    //   25: ifne +5 -> 30
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_0
    //   31: invokevirtual 58	java/io/File:isDirectory	()Z
    //   34: ifne +10 -> 44
    //   37: aload_1
    //   38: invokevirtual 58	java/io/File:isDirectory	()Z
    //   41: ifeq +13 -> 54
    //   44: new 41	java/io/IOException
    //   47: dup
    //   48: ldc 60
    //   50: invokespecial 63	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: aload_0
    //   55: invokevirtual 67	java/io/File:length	()J
    //   58: aload_1
    //   59: invokevirtual 67	java/io/File:length	()J
    //   62: lcmp
    //   63: ifne -42 -> 21
    //   66: aload_0
    //   67: invokevirtual 71	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   70: aload_1
    //   71: invokevirtual 71	java/io/File:getCanonicalFile	()Ljava/io/File;
    //   74: invokevirtual 75	java/io/File:equals	(Ljava/lang/Object;)Z
    //   77: ifeq +5 -> 82
    //   80: iconst_1
    //   81: ireturn
    //   82: new 77	java/io/BufferedInputStream
    //   85: dup
    //   86: new 79	java/io/FileInputStream
    //   89: dup
    //   90: aload_0
    //   91: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   94: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: astore_0
    //   98: new 77	java/io/BufferedInputStream
    //   101: dup
    //   102: new 79	java/io/FileInputStream
    //   105: dup
    //   106: aload_1
    //   107: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: invokespecial 85	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_1
    //   114: aload_0
    //   115: invokevirtual 91	java/io/InputStream:read	()I
    //   118: istore_2
    //   119: iconst_m1
    //   120: iload_2
    //   121: if_icmpeq +31 -> 152
    //   124: aload_1
    //   125: invokevirtual 91	java/io/InputStream:read	()I
    //   128: istore_3
    //   129: iload_2
    //   130: iload_3
    //   131: if_icmpeq +13 -> 144
    //   134: aload_0
    //   135: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   138: aload_1
    //   139: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   142: iconst_0
    //   143: ireturn
    //   144: aload_0
    //   145: invokevirtual 91	java/io/InputStream:read	()I
    //   148: istore_2
    //   149: goto -30 -> 119
    //   152: aload_1
    //   153: invokevirtual 91	java/io/InputStream:read	()I
    //   156: istore_2
    //   157: iload_2
    //   158: iconst_m1
    //   159: if_icmpne +14 -> 173
    //   162: aload_0
    //   163: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   166: aload_1
    //   167: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   170: iload 4
    //   172: ireturn
    //   173: iconst_0
    //   174: istore 4
    //   176: goto -14 -> 162
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_1
    //   182: aload 6
    //   184: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   187: aload_1
    //   188: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   191: aload_0
    //   192: athrow
    //   193: astore 7
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_0
    //   198: astore 6
    //   200: aload 7
    //   202: astore_0
    //   203: goto -21 -> 182
    //   206: astore 7
    //   208: aload_0
    //   209: astore 6
    //   211: aload 7
    //   213: astore_0
    //   214: goto -32 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	paramFile1	File
    //   0	217	1	paramFile2	File
    //   118	42	2	i	int
    //   128	4	3	j	int
    //   4	171	4	bool1	boolean
    //   10	14	5	bool2	boolean
    //   1	209	6	localObject1	Object
    //   193	8	7	localObject2	Object
    //   206	6	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   82	98	179	finally
    //   98	114	193	finally
    //   114	119	206	finally
    //   124	129	206	finally
    //   144	149	206	finally
    //   152	157	206	finally
  }
  
  /* Error */
  public static void copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 79	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 99	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_2
    //   14: new 101	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 102	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 103	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: lconst_0
    //   29: aload_2
    //   30: invokevirtual 108	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 112	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_2
    //   38: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   41: aload_1
    //   42: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   55: aload_1
    //   56: invokestatic 93	com/tencent/tbs/one/impl/base/FileUtils:close	(Ljava/io/Closeable;)V
    //   59: aload_0
    //   60: athrow
    //   61: astore_0
    //   62: aconst_null
    //   63: astore_1
    //   64: goto -13 -> 51
    //   67: astore_0
    //   68: goto -17 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   13	39	2	localObject1	Object
    //   1	49	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	46	finally
    //   14	26	61	finally
    //   26	37	67	finally
  }
  
  public static void copyFile(String paramString1, String paramString2)
  {
    copyFile(new File(paramString1), new File(paramString2));
  }
  
  public static void copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[8192];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static void copyStreamToFile(InputStream paramInputStream, File paramFile)
  {
    File localFile = new File(paramFile.getPath() + ".tmp");
    try
    {
      localFileOutputStream = new FileOutputStream(localFile);
      close(paramFile);
    }
    finally
    {
      paramInputStream = finally;
    }
    throw paramInputStream;
  }
  
  public static void createFileWithWarning(File paramFile)
  {
    try
    {
      if (!paramFile.createNewFile()) {
        Logging.e("Failed to create file %s, file already exists", new Object[] { paramFile.getAbsolutePath() });
      }
      return;
    }
    catch (IOException localIOException)
    {
      Logging.e("Failed to create file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
    }
  }
  
  public static void deleteFileWithWarning(File paramFile)
  {
    if (!recursivelyDeleteFile(paramFile)) {
      Logging.e("Failed to delete file %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  public static String getExtension(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(".");
    } while (i <= 0);
    return paramString.substring(i + 1);
  }
  
  public static String[] getNameAndExtension(File paramFile)
  {
    paramFile = paramFile.getName();
    if (!TextUtils.isEmpty(paramFile))
    {
      int i = paramFile.lastIndexOf('.');
      if (i > 0) {
        return new String[] { paramFile.substring(0, i), paramFile.substring(i + 1) };
      }
    }
    return new String[] { paramFile, null };
  }
  
  public static String[] getNameAndExtension(String paramString)
  {
    return getNameAndExtension(new File(paramString));
  }
  
  public static String getPathInAndroidAsset(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("/android_asset/")) {
        return paramString.substring("/android_asset/".length());
      }
    } while (!paramString.startsWith("file:///android_asset/"));
    return paramString.substring("file:///android_asset/".length());
  }
  
  public static boolean isAndroidAssetPath(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/android_asset/")) || (paramString.startsWith("file:///android_asset/")));
  }
  
  public static void mkdirsAnywayWithWarning(File paramFile)
  {
    if (!paramFile.exists()) {
      if (!paramFile.mkdirs()) {
        Logging.e("Failed to create non-exist directory %s", new Object[] { paramFile.getAbsolutePath() });
      }
    }
    while ((paramFile.isDirectory()) || ((paramFile.delete()) && (paramFile.mkdirs()))) {
      return;
    }
    Logging.e("Failed to create namesake directory %s", new Object[] { paramFile.getAbsolutePath() });
  }
  
  public static void mkdirsWithWarning(File paramFile)
  {
    if (!paramFile.mkdirs()) {
      Logging.e("Failed to create directory %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  public static InputStream openFile(Context paramContext, String paramString1, String paramString2)
  {
    if (isAndroidAssetPath(paramString2))
    {
      paramString1 = getPathInAndroidAsset(paramString2);
      return paramContext.getResources().getAssets().open(paramString1);
    }
    if (new File(paramString2).isAbsolute()) {
      return new FileInputStream(paramString2);
    }
    paramString1 = new File(paramString1, paramString2).getAbsolutePath();
    if (isAndroidAssetPath(paramString1))
    {
      paramString1 = getPathInAndroidAsset(paramString1);
      return paramContext.getResources().getAssets().open(paramString1);
    }
    return new FileInputStream(paramString1);
  }
  
  public static String readAndCopyStream(InputStream paramInputStream, String paramString, File paramFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    File localFile = new File(paramFile.getPath() + ".tmp");
    try
    {
      localMultiOutputStream = new MultiOutputStream(new OutputStream[] { localByteArrayOutputStream, new FileOutputStream(localFile) });
      close(paramString);
    }
    finally
    {
      paramInputStream = finally;
    }
    throw paramInputStream;
    return new String(localByteArrayOutputStream.toByteArray(), paramString);
  }
  
  @NonNull
  public static byte[] readStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copyStream(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  @NonNull
  public static String readStreamToString(InputStream paramInputStream, String paramString)
  {
    return new String(readStream(paramInputStream), paramString);
  }
  
  public static void recursivelyCopyFile(File paramFile1, File paramFile2)
  {
    if (paramFile1.isDirectory())
    {
      if ((!paramFile2.exists()) && (!paramFile2.mkdirs())) {
        throw new IOException("Failed to create directory " + paramFile2.getAbsolutePath());
      }
      paramFile1 = paramFile1.listFiles();
      if (paramFile1 != null)
      {
        int j = paramFile1.length;
        int i = 0;
        while (i < j)
        {
          File localFile = paramFile1[i];
          recursivelyCopyFile(localFile, new File(paramFile2, localFile.getName()));
          i += 1;
        }
      }
    }
    else if (paramFile1.canRead())
    {
      copyFile(paramFile1, paramFile2);
    }
  }
  
  public static boolean recursivelyDeleteFile(File paramFile)
  {
    try
    {
      if (!paramFile.exists()) {
        return true;
      }
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            recursivelyDeleteFile(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      boolean bool = paramFile.delete();
      return bool;
    }
    catch (Exception localException)
    {
      Logging.e("recursivelyDeleteFile failed,current file is %s,exception is %s", new Object[] { paramFile.getAbsolutePath(), Log.getStackTraceString(localException) });
    }
    return false;
  }
  
  public static void renameOrCopyFile(File paramFile1, File paramFile2)
  {
    if (!paramFile1.renameTo(paramFile2))
    {
      recursivelyCopyFile(paramFile1, paramFile2);
      recursivelyDeleteFile(paramFile1);
    }
  }
  
  public static void touchWithWarning(File paramFile, long paramLong)
  {
    try
    {
      if ((paramFile.exists()) || (paramFile.createNewFile()))
      {
        if (!paramFile.setLastModified(paramLong)) {
          Logging.e("Failed to touch file %s, cannot set last modified with %d", new Object[] { paramFile.getAbsolutePath(), Long.valueOf(paramLong) });
        }
      }
      else
      {
        Logging.e("Failed to touch file %s, cannot create new file", new Object[] { paramFile.getAbsolutePath() });
        return;
      }
    }
    catch (IOException localIOException)
    {
      Logging.e("Failed to touch file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
    }
  }
  
  public static void unzipFile(File paramFile1, File paramFile2)
  {
    try
    {
      localFileInputStream = new FileInputStream(paramFile1);
      close(paramFile2);
    }
    finally
    {
      try
      {
        unzipStream(localFileInputStream, paramFile2, null);
        close(localFileInputStream);
        return;
      }
      finally
      {
        FileInputStream localFileInputStream;
        paramFile2 = localFileInputStream;
      }
      paramFile1 = finally;
      paramFile2 = null;
    }
    throw paramFile1;
  }
  
  public static void unzipStream(InputStream paramInputStream, File paramFile1, File paramFile2)
  {
    ZipEntry localZipEntry = null;
    Object localObject1 = null;
    ZipOutputStream localZipOutputStream = null;
    try
    {
      localZipInputStream = new ZipInputStream(new BufferedInputStream(paramInputStream));
      if (paramFile2 != null) {
        localObject1 = localZipEntry;
      }
      try
      {
        localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramFile2));
        localObject1 = localZipOutputStream;
        localZipEntry = localZipInputStream.getNextEntry();
        if (localZipEntry == null) {
          break label371;
        }
        localObject1 = localZipOutputStream;
        paramFile2 = new File(paramFile1, localZipEntry.getName());
        localObject1 = localZipOutputStream;
        if (!localZipEntry.isDirectory()) {
          break label169;
        }
        localObject1 = localZipOutputStream;
        if (paramFile2.exists()) {
          break label335;
        }
        localObject1 = localZipOutputStream;
        if (paramFile2.mkdirs()) {
          break label335;
        }
        throw new IOException("Failed to create directory " + paramFile2.getAbsolutePath());
      }
      finally
      {
        paramFile1 = localZipInputStream;
      }
    }
    finally
    {
      for (;;)
      {
        ZipInputStream localZipInputStream;
        Object localObject2;
        int i;
        paramFile1 = null;
      }
    }
    close(paramFile1);
    close((Closeable)localObject1);
    throw paramInputStream;
    label169:
    localObject1 = localZipOutputStream;
    localObject2 = paramFile2.getParentFile();
    localObject1 = localZipOutputStream;
    if (!((File)localObject2).exists())
    {
      localObject1 = localZipOutputStream;
      if (!((File)localObject2).mkdirs())
      {
        localObject1 = localZipOutputStream;
        throw new IOException("Failed to create directory " + ((File)localObject2).getAbsolutePath());
      }
    }
    localObject1 = localZipOutputStream;
    localObject2 = new BufferedOutputStream(new FileOutputStream(paramFile2));
    if (localZipOutputStream != null)
    {
      localObject1 = localZipOutputStream;
      paramFile2 = new MultiOutputStream(new OutputStream[] { localObject2, localZipOutputStream });
      localObject1 = localZipOutputStream;
      localZipOutputStream.putNextEntry(localZipEntry);
    }
    for (;;)
    {
      localObject1 = localZipOutputStream;
      copyStream(localZipInputStream, paramFile2);
      localObject1 = localZipOutputStream;
      ((OutputStream)localObject2).close();
      if (localZipOutputStream != null)
      {
        localObject1 = localZipOutputStream;
        localZipOutputStream.closeEntry();
      }
      label335:
      localObject1 = localZipOutputStream;
      localZipInputStream.closeEntry();
      break;
      localObject1 = localZipOutputStream;
      paramFile2 = new MultiOutputStream(new OutputStream[] { localObject2 });
    }
    label371:
    localObject1 = localZipOutputStream;
    paramFile1 = new byte[8192];
    do
    {
      localObject1 = localZipOutputStream;
      i = paramInputStream.read(paramFile1);
    } while (i != -1);
    close(localZipInputStream);
    close(localZipOutputStream);
  }
  
  public static void writeFile(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      close(paramString2);
    }
    finally
    {
      try
      {
        paramFile.write(paramString1.getBytes(paramString2));
        close(paramFile);
        return;
      }
      finally
      {
        paramString2 = paramFile;
      }
      paramString1 = finally;
      paramString2 = null;
    }
    throw paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.FileUtils
 * JD-Core Version:    0.7.0.1
 */