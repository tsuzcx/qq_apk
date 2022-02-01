package com.tencent.tbs.one.impl.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
  
  /* Error */
  public static String a(InputStream paramInputStream, String paramString, File paramFile)
  {
    // Byte code:
    //   0: new 56	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 59	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: new 75	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 76	java/lang/StringBuilder:<init>	()V
    //   16: astore_3
    //   17: aload_3
    //   18: aload_2
    //   19: invokevirtual 79	java/io/File:getPath	()Ljava/lang/String;
    //   22: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: ldc 85
    //   29: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: new 33	java/io/File
    //   36: dup
    //   37: aload_3
    //   38: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: aconst_null
    //   47: astore_3
    //   48: new 90	com/tencent/tbs/one/impl/a/h
    //   51: dup
    //   52: iconst_2
    //   53: anewarray 92	java/io/OutputStream
    //   56: dup
    //   57: iconst_0
    //   58: aload 5
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: new 94	java/io/FileOutputStream
    //   66: dup
    //   67: aload 6
    //   69: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   72: aastore
    //   73: invokespecial 100	com/tencent/tbs/one/impl/a/h:<init>	([Ljava/io/OutputStream;)V
    //   76: astore 4
    //   78: aload_0
    //   79: aload 4
    //   81: invokestatic 62	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   84: aload 4
    //   86: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   89: aload 6
    //   91: aload_2
    //   92: invokevirtual 107	java/io/File:renameTo	(Ljava/io/File;)Z
    //   95: ifeq +17 -> 112
    //   98: new 64	java/lang/String
    //   101: dup
    //   102: aload 5
    //   104: invokevirtual 68	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   107: aload_1
    //   108: invokespecial 71	java/lang/String:<init>	([BLjava/lang/String;)V
    //   111: areturn
    //   112: new 109	java/io/IOException
    //   115: dup
    //   116: invokespecial 110	java/io/IOException:<init>	()V
    //   119: athrow
    //   120: astore_1
    //   121: aload 4
    //   123: astore_0
    //   124: goto +6 -> 130
    //   127: astore_1
    //   128: aload_3
    //   129: astore_0
    //   130: aload_0
    //   131: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramInputStream	InputStream
    //   0	136	1	paramString	String
    //   0	136	2	paramFile	File
    //   16	113	3	localStringBuilder	StringBuilder
    //   76	46	4	localh	h
    //   7	96	5	localByteArrayOutputStream	ByteArrayOutputStream
    //   44	46	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   78	84	120	finally
    //   48	78	127	finally
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
    //   13: astore_0
    //   14: new 94	java/io/FileOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   22: invokevirtual 130	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   25: astore_2
    //   26: aload_2
    //   27: aload_0
    //   28: lconst_0
    //   29: aload_0
    //   30: invokevirtual 136	java/nio/channels/FileChannel:size	()J
    //   33: invokevirtual 140	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   36: pop2
    //   37: aload_0
    //   38: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   41: aload_2
    //   42: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   45: return
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_1
    //   51: aconst_null
    //   52: astore_2
    //   53: goto +8 -> 61
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_2
    //   59: aload_3
    //   60: astore_0
    //   61: aload_0
    //   62: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   65: aload_2
    //   66: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramFile1	File
    //   0	71	1	paramFile2	File
    //   25	41	2	localFileChannel	java.nio.channels.FileChannel
    //   1	59	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   26	37	46	finally
    //   14	26	50	finally
    //   2	14	56	finally
  }
  
  /* Error */
  public static void a(InputStream paramInputStream, File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: new 143	java/util/zip/ZipInputStream
    //   12: dup
    //   13: new 145	java/io/BufferedInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 148	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: invokespecial 149	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 7
    //   26: aload_2
    //   27: ifnull +24 -> 51
    //   30: aload 8
    //   32: astore 5
    //   34: new 151	java/util/zip/ZipOutputStream
    //   37: dup
    //   38: new 94	java/io/FileOutputStream
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: invokespecial 154	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   49: astore 6
    //   51: aload 6
    //   53: astore 5
    //   55: aload 7
    //   57: invokevirtual 158	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   60: astore 8
    //   62: aload 8
    //   64: ifnull +236 -> 300
    //   67: aload 6
    //   69: astore 5
    //   71: new 33	java/io/File
    //   74: dup
    //   75: aload_1
    //   76: aload 8
    //   78: invokevirtual 163	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   81: invokespecial 166	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   84: astore_2
    //   85: aload 6
    //   87: astore 5
    //   89: aload 8
    //   91: invokevirtual 169	java/util/zip/ZipEntry:isDirectory	()Z
    //   94: istore 4
    //   96: iload 4
    //   98: ifeq +71 -> 169
    //   101: aload 6
    //   103: astore 5
    //   105: aload_2
    //   106: invokevirtual 172	java/io/File:exists	()Z
    //   109: ifne +179 -> 288
    //   112: aload 6
    //   114: astore 5
    //   116: aload_2
    //   117: invokevirtual 175	java/io/File:mkdirs	()Z
    //   120: ifeq +6 -> 126
    //   123: goto +165 -> 288
    //   126: aload 6
    //   128: astore 5
    //   130: new 75	java/lang/StringBuilder
    //   133: dup
    //   134: ldc 177
    //   136: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   139: astore_0
    //   140: aload 6
    //   142: astore 5
    //   144: aload_0
    //   145: aload_2
    //   146: invokevirtual 51	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   149: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload 6
    //   155: astore 5
    //   157: new 109	java/io/IOException
    //   160: dup
    //   161: aload_0
    //   162: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 179	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: aload 6
    //   171: astore 5
    //   173: aload_2
    //   174: invokevirtual 183	java/io/File:getParentFile	()Ljava/io/File;
    //   177: astore 8
    //   179: aload 6
    //   181: astore 5
    //   183: aload 8
    //   185: invokevirtual 172	java/io/File:exists	()Z
    //   188: ifne +62 -> 250
    //   191: aload 6
    //   193: astore 5
    //   195: aload 8
    //   197: invokevirtual 175	java/io/File:mkdirs	()Z
    //   200: ifeq +6 -> 206
    //   203: goto +47 -> 250
    //   206: aload 6
    //   208: astore 5
    //   210: new 75	java/lang/StringBuilder
    //   213: dup
    //   214: ldc 177
    //   216: invokespecial 178	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   219: astore_0
    //   220: aload 6
    //   222: astore 5
    //   224: aload_0
    //   225: aload 8
    //   227: invokevirtual 51	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   230: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 6
    //   236: astore 5
    //   238: new 109	java/io/IOException
    //   241: dup
    //   242: aload_0
    //   243: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   246: invokespecial 179	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   249: athrow
    //   250: aload 6
    //   252: astore 5
    //   254: new 185	java/io/BufferedOutputStream
    //   257: dup
    //   258: new 94	java/io/FileOutputStream
    //   261: dup
    //   262: aload_2
    //   263: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   266: invokespecial 186	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   269: astore_2
    //   270: aload 6
    //   272: astore 5
    //   274: aload 7
    //   276: aload_2
    //   277: invokestatic 62	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   280: aload 6
    //   282: astore 5
    //   284: aload_2
    //   285: invokevirtual 187	java/io/OutputStream:close	()V
    //   288: aload 6
    //   290: astore 5
    //   292: aload 7
    //   294: invokevirtual 190	java/util/zip/ZipInputStream:closeEntry	()V
    //   297: goto -246 -> 51
    //   300: aload 6
    //   302: astore 5
    //   304: sipush 8192
    //   307: newarray byte
    //   309: astore_1
    //   310: aload 6
    //   312: astore 5
    //   314: aload_0
    //   315: aload_1
    //   316: invokevirtual 196	java/io/InputStream:read	([B)I
    //   319: istore_3
    //   320: iload_3
    //   321: iconst_m1
    //   322: if_icmpne -12 -> 310
    //   325: aload 7
    //   327: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   330: aload 6
    //   332: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   335: return
    //   336: astore_1
    //   337: aload 7
    //   339: astore_0
    //   340: goto +6 -> 346
    //   343: astore_1
    //   344: aconst_null
    //   345: astore_0
    //   346: aload_0
    //   347: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   350: aload 5
    //   352: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   355: goto +5 -> 360
    //   358: aload_1
    //   359: athrow
    //   360: goto -2 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramInputStream	InputStream
    //   0	363	1	paramFile1	File
    //   0	363	2	paramFile2	File
    //   319	4	3	i	int
    //   94	3	4	bool	boolean
    //   4	347	5	localObject1	Object
    //   7	324	6	localZipOutputStream	java.util.zip.ZipOutputStream
    //   24	314	7	localZipInputStream	java.util.zip.ZipInputStream
    //   1	225	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	51	336	finally
    //   55	62	336	finally
    //   71	85	336	finally
    //   89	96	336	finally
    //   105	112	336	finally
    //   116	123	336	finally
    //   130	140	336	finally
    //   144	153	336	finally
    //   157	169	336	finally
    //   173	179	336	finally
    //   183	191	336	finally
    //   195	203	336	finally
    //   210	220	336	finally
    //   224	234	336	finally
    //   238	250	336	finally
    //   254	270	336	finally
    //   274	280	336	finally
    //   284	288	336	finally
    //   292	297	336	finally
    //   304	310	336	finally
    //   314	320	336	finally
    //   9	26	343	finally
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
  
  /* Error */
  public static void a(String paramString1, String paramString2, File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 94	java/io/FileOutputStream
    //   5: dup
    //   6: aload_2
    //   7: invokespecial 97	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_2
    //   11: aload_2
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 205	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   17: invokevirtual 208	java/io/FileOutputStream:write	([B)V
    //   20: aload_2
    //   21: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   24: return
    //   25: astore_1
    //   26: aload_2
    //   27: astore_0
    //   28: goto +6 -> 34
    //   31: astore_1
    //   32: aload_3
    //   33: astore_0
    //   34: aload_0
    //   35: invokestatic 103	com/tencent/tbs/one/impl/a/c:a	(Ljava/io/Closeable;)V
    //   38: aload_1
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	paramString1	String
    //   0	40	1	paramString2	String
    //   0	40	2	paramFile	File
    //   1	32	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	25	finally
    //   2	11	31	finally
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.startsWith("/android_asset/")) {
      return paramString.substring(15);
    }
    if (paramString.startsWith("file:///android_asset/")) {
      return paramString.substring(22);
    }
    return null;
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
      if ((!paramFile2.exists()) && (!paramFile2.mkdirs()))
      {
        paramFile1 = new StringBuilder("Failed to create directory ");
        paramFile1.append(paramFile2.getAbsolutePath());
        throw new IOException(paramFile1.toString());
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
      return;
    }
    if (paramFile1.canRead()) {
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
    if (!paramFile.exists())
    {
      if (!paramFile.mkdirs()) {
        f.c("Failed to create non-exist directory %s", new Object[] { paramFile.getAbsolutePath() });
      }
    }
    else if ((!paramFile.isDirectory()) && ((!paramFile.delete()) || (!paramFile.mkdirs()))) {
      f.c("Failed to create namesake directory %s", new Object[] { paramFile.getAbsolutePath() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.c
 * JD-Core Version:    0.7.0.1
 */