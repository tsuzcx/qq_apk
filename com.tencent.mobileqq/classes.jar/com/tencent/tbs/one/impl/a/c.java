package com.tencent.tbs.one.impl.a;

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

public final class c
{
  public static InputStream a(Context paramContext, String paramString1, String paramString2)
  {
    if (a(paramString2))
    {
      paramString1 = b(paramString2);
      return paramContext.getResources().getAssets().open(paramString1);
    }
    if (new File(paramString2).isAbsolute()) {
      return new FileInputStream(paramString2);
    }
    paramString1 = new File(paramString1, paramString2).getAbsolutePath();
    if (a(paramString1))
    {
      paramString1 = b(paramString1);
      return paramContext.getResources().getAssets().open(paramString1);
    }
    return new FileInputStream(paramString1);
  }
  
  @NonNull
  public static String a(InputStream paramInputStream, String paramString)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramInputStream, localByteArrayOutputStream);
    return new String(localByteArrayOutputStream.toByteArray(), paramString);
  }
  
  public static String a(InputStream paramInputStream, String paramString, File paramFile)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    File localFile = new File(paramFile.getPath() + ".tmp");
    try
    {
      localh = new h(new OutputStream[] { localByteArrayOutputStream, new FileOutputStream(localFile) });
      a(paramString);
    }
    finally
    {
      paramInputStream = finally;
    }
    throw paramInputStream;
    return new String(localByteArrayOutputStream.toByteArray(), paramString);
  }
  
  public static void a(Closeable paramCloseable)
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
      f.c("Failed to close %s", new Object[] { paramCloseable, localIOException });
    }
  }
  
  /* Error */
  public static void a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 43	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 125	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: invokevirtual 129	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   13: astore_2
    //   14: new 94	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 130	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_1
    //   26: aload_1
    //   27: aload_2
    //   28: lconst_0
    //   29: aload_2
    //   30: invokevirtual 136	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 140	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_2
    //   38: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   41: aload_1
    //   42: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   45: return
    //   46: astore_0
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_3
    //   50: astore_2
    //   51: aload_2
    //   52: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   55: aload_1
    //   56: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
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
  
  public static void a(InputStream paramInputStream, File paramFile1, File paramFile2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    ZipOutputStream localZipOutputStream = null;
    for (;;)
    {
      try
      {
        localZipInputStream = new ZipInputStream(new BufferedInputStream(paramInputStream));
        if (paramFile2 != null) {
          localObject1 = localObject2;
        }
        try
        {
          localZipOutputStream = new ZipOutputStream(new FileOutputStream(paramFile2));
          localObject1 = localZipOutputStream;
          localObject2 = localZipInputStream.getNextEntry();
          if (localObject2 == null) {
            continue;
          }
          localObject1 = localZipOutputStream;
          paramFile2 = new File(paramFile1, ((ZipEntry)localObject2).getName());
          localObject1 = localZipOutputStream;
          if (!((ZipEntry)localObject2).isDirectory()) {
            continue;
          }
          localObject1 = localZipOutputStream;
          if (paramFile2.exists()) {
            continue;
          }
          localObject1 = localZipOutputStream;
          if (paramFile2.mkdirs()) {
            continue;
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
        ZipInputStream localZipInputStream;
        int i;
        paramFile1 = null;
        continue;
      }
      a(paramFile1);
      a(localObject1);
      throw paramInputStream;
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
      paramFile2 = new BufferedOutputStream(new FileOutputStream(paramFile2));
      localObject1 = localZipOutputStream;
      a(localZipInputStream, paramFile2);
      localObject1 = localZipOutputStream;
      paramFile2.close();
      localObject1 = localZipOutputStream;
      localZipInputStream.closeEntry();
    }
    localObject1 = localZipOutputStream;
    paramFile1 = new byte[8192];
    do
    {
      localObject1 = localZipOutputStream;
      i = paramInputStream.read(paramFile1);
    } while (i != -1);
    a(localZipInputStream);
    a(localZipOutputStream);
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
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
  
  public static void a(String paramString1, String paramString2, File paramFile)
  {
    try
    {
      paramFile = new FileOutputStream(paramFile);
      a(paramString2);
    }
    finally
    {
      try
      {
        paramFile.write(paramString1.getBytes(paramString2));
        a(paramFile);
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
  
  public static boolean a(File paramFile)
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
            a(arrayOfFile[i]);
            i += 1;
          }
        }
      }
      boolean bool = paramFile.delete();
      return bool;
    }
    catch (Exception localException)
    {
      f.c("recursivelyDeleteFile failed,current file is %s,exception is %s", new Object[] { paramFile.getAbsolutePath(), Log.getStackTraceString(localException) });
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("/android_asset/")) || (paramString.startsWith("file:///android_asset/")));
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (paramString.startsWith("/android_asset/")) {
        return paramString.substring(15);
      }
    } while (!paramString.startsWith("file:///android_asset/"));
    return paramString.substring(22);
  }
  
  public static void b(File paramFile)
  {
    try
    {
      if (!paramFile.createNewFile()) {
        f.c("Failed to create file %s, file already exists", new Object[] { paramFile.getAbsolutePath() });
      }
      return;
    }
    catch (IOException localIOException)
    {
      f.c("Failed to create file %s", new Object[] { paramFile.getAbsolutePath(), localIOException });
    }
  }
  
  public static void b(File paramFile1, File paramFile2)
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
          b(localFile, new File(paramFile2, localFile.getName()));
          i += 1;
        }
      }
    }
    else if (paramFile1.canRead())
    {
      a(paramFile1, paramFile2);
    }
  }
  
  public static void c(File paramFile)
  {
    if (!a(paramFile)) {
      f.c("Failed to delete file %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
  
  public static void c(File paramFile1, File paramFile2)
  {
    if (!paramFile1.renameTo(paramFile2))
    {
      b(paramFile1, paramFile2);
      a(paramFile1);
    }
  }
  
  public static void d(File paramFile)
  {
    if (!paramFile.exists()) {
      if (!paramFile.mkdirs()) {
        f.c("Failed to create non-exist directory %s", new Object[] { paramFile.getAbsolutePath() });
      }
    }
    while ((paramFile.isDirectory()) || ((paramFile.delete()) && (paramFile.mkdirs()))) {
      return;
    }
    f.c("Failed to create namesake directory %s", new Object[] { paramFile.getAbsolutePath() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.c
 * JD-Core Version:    0.7.0.1
 */