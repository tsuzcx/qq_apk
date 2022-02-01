package cooperation.qqcircle.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class QCircleFileUtils
{
  private static final int DEFAULT_BUFFER_SIZE = 3072;
  private static final String TAG = "QCircleFileUtils";
  
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    return copyFile(paramFile1, paramFile2, false);
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_1
    //   10: invokevirtual 31	java/io/File:getParentFile	()Ljava/io/File;
    //   13: ifnull +21 -> 34
    //   16: aload_1
    //   17: invokevirtual 31	java/io/File:getParentFile	()Ljava/io/File;
    //   20: invokevirtual 35	java/io/File:exists	()Z
    //   23: ifne +11 -> 34
    //   26: aload_1
    //   27: invokevirtual 31	java/io/File:getParentFile	()Ljava/io/File;
    //   30: invokevirtual 38	java/io/File:mkdirs	()Z
    //   33: pop
    //   34: new 40	java/io/FileOutputStream
    //   37: dup
    //   38: aload_1
    //   39: invokespecial 43	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: astore_1
    //   43: new 45	java/io/BufferedInputStream
    //   46: dup
    //   47: new 47	java/io/FileInputStream
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: invokespecial 51	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   58: astore_0
    //   59: invokestatic 57	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   62: sipush 4096
    //   65: invokevirtual 61	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   68: astore 4
    //   70: aload_0
    //   71: aload 4
    //   73: invokevirtual 65	java/io/BufferedInputStream:read	([B)I
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_m1
    //   79: if_icmpeq +18 -> 97
    //   82: aload_1
    //   83: aload 4
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 69	java/io/FileOutputStream:write	([BII)V
    //   90: aload_1
    //   91: invokevirtual 72	java/io/FileOutputStream:flush	()V
    //   94: goto -24 -> 70
    //   97: invokestatic 57	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   100: aload 4
    //   102: invokevirtual 76	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   105: aload_1
    //   106: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   109: goto +17 -> 126
    //   112: astore_1
    //   113: iload_2
    //   114: ifeq +12 -> 126
    //   117: ldc 11
    //   119: iconst_1
    //   120: ldc 81
    //   122: aload_1
    //   123: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   126: aload_0
    //   127: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   130: goto +17 -> 147
    //   133: astore_0
    //   134: iload_2
    //   135: ifeq +12 -> 147
    //   138: ldc 11
    //   140: iconst_1
    //   141: ldc 81
    //   143: aload_0
    //   144: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   147: iconst_1
    //   148: ireturn
    //   149: astore 4
    //   151: goto +171 -> 322
    //   154: astore 4
    //   156: goto +16 -> 172
    //   159: astore 4
    //   161: goto +28 -> 189
    //   164: astore_0
    //   165: goto +167 -> 332
    //   168: astore 4
    //   170: aconst_null
    //   171: astore_0
    //   172: aload_1
    //   173: astore 5
    //   175: aload 4
    //   177: astore 6
    //   179: aload_0
    //   180: astore 4
    //   182: goto +31 -> 213
    //   185: astore 4
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_1
    //   190: astore 5
    //   192: aload 4
    //   194: astore 6
    //   196: aload_0
    //   197: astore 4
    //   199: goto +98 -> 297
    //   202: astore_0
    //   203: aconst_null
    //   204: astore_1
    //   205: goto +127 -> 332
    //   208: astore 6
    //   210: aconst_null
    //   211: astore 4
    //   213: iload_2
    //   214: ifeq +19 -> 233
    //   217: aload 5
    //   219: astore_1
    //   220: aload 4
    //   222: astore_0
    //   223: ldc 11
    //   225: iconst_1
    //   226: ldc 81
    //   228: aload 6
    //   230: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: aload 5
    //   235: ifnull +25 -> 260
    //   238: aload 5
    //   240: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   243: goto +17 -> 260
    //   246: astore_0
    //   247: iload_2
    //   248: ifeq +12 -> 260
    //   251: ldc 11
    //   253: iconst_1
    //   254: ldc 81
    //   256: aload_0
    //   257: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   260: aload 4
    //   262: ifnull +171 -> 433
    //   265: aload 4
    //   267: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   270: iconst_0
    //   271: ireturn
    //   272: astore_0
    //   273: iload_2
    //   274: ifeq +159 -> 433
    //   277: ldc 11
    //   279: iconst_1
    //   280: ldc 81
    //   282: aload_0
    //   283: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore 6
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 7
    //   295: astore 5
    //   297: iload_2
    //   298: ifeq +88 -> 386
    //   301: aload 5
    //   303: astore_1
    //   304: aload 4
    //   306: astore_0
    //   307: ldc 11
    //   309: iconst_1
    //   310: ldc 81
    //   312: aload 6
    //   314: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: goto +69 -> 386
    //   320: astore 4
    //   322: aload_0
    //   323: astore 5
    //   325: aload 4
    //   327: astore_0
    //   328: aload 5
    //   330: astore 4
    //   332: aload_1
    //   333: ifnull +24 -> 357
    //   336: aload_1
    //   337: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   340: goto +17 -> 357
    //   343: astore_1
    //   344: iload_2
    //   345: ifeq +12 -> 357
    //   348: ldc 11
    //   350: iconst_1
    //   351: ldc 81
    //   353: aload_1
    //   354: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   357: aload 4
    //   359: ifnull +25 -> 384
    //   362: aload 4
    //   364: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   367: goto +17 -> 384
    //   370: astore_1
    //   371: iload_2
    //   372: ifeq +12 -> 384
    //   375: ldc 11
    //   377: iconst_1
    //   378: ldc 81
    //   380: aload_1
    //   381: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   384: aload_0
    //   385: athrow
    //   386: aload 5
    //   388: ifnull +25 -> 413
    //   391: aload 5
    //   393: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   396: goto +17 -> 413
    //   399: astore_0
    //   400: iload_2
    //   401: ifeq +12 -> 413
    //   404: ldc 11
    //   406: iconst_1
    //   407: ldc 81
    //   409: aload_0
    //   410: invokestatic 87	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: aload 4
    //   415: ifnull +18 -> 433
    //   418: aload 4
    //   420: invokevirtual 88	java/io/BufferedInputStream:close	()V
    //   423: iconst_0
    //   424: ireturn
    //   425: astore_0
    //   426: iload_2
    //   427: ifeq +6 -> 433
    //   430: goto -153 -> 277
    //   433: iconst_0
    //   434: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	paramFile1	File
    //   0	435	1	paramFile2	File
    //   0	435	2	paramBoolean	boolean
    //   76	11	3	i	int
    //   4	97	4	arrayOfByte	byte[]
    //   149	1	4	localObject1	Object
    //   154	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   159	1	4	localIOException1	IOException
    //   168	8	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   180	1	4	localFile1	File
    //   185	8	4	localIOException2	IOException
    //   197	108	4	localFile2	File
    //   320	6	4	localObject2	Object
    //   330	89	4	localObject3	Object
    //   7	385	5	localObject4	Object
    //   177	18	6	localObject5	Object
    //   208	21	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   288	25	6	localIOException3	IOException
    //   1	293	7	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   105	109	112	java/io/IOException
    //   126	130	133	java/io/IOException
    //   59	70	149	finally
    //   70	77	149	finally
    //   82	94	149	finally
    //   97	105	149	finally
    //   59	70	154	java/lang/OutOfMemoryError
    //   70	77	154	java/lang/OutOfMemoryError
    //   82	94	154	java/lang/OutOfMemoryError
    //   97	105	154	java/lang/OutOfMemoryError
    //   59	70	159	java/io/IOException
    //   70	77	159	java/io/IOException
    //   82	94	159	java/io/IOException
    //   97	105	159	java/io/IOException
    //   43	59	164	finally
    //   43	59	168	java/lang/OutOfMemoryError
    //   43	59	185	java/io/IOException
    //   9	34	202	finally
    //   34	43	202	finally
    //   9	34	208	java/lang/OutOfMemoryError
    //   34	43	208	java/lang/OutOfMemoryError
    //   238	243	246	java/io/IOException
    //   265	270	272	java/io/IOException
    //   9	34	288	java/io/IOException
    //   34	43	288	java/io/IOException
    //   223	233	320	finally
    //   307	317	320	finally
    //   336	340	343	java/io/IOException
    //   362	367	370	java/io/IOException
    //   391	396	399	java/io/IOException
    //   418	423	425	java/io/IOException
  }
  
  public static long copyStream(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null)
    {
      if (paramOutputStream == null) {
        return 0L;
      }
      try
      {
        byte[] arrayOfByte = new byte[3072];
        int i;
        for (long l = 0L;; l += i)
        {
          i = paramInputStream.read(arrayOfByte);
          if (i <= 0) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        paramOutputStream.flush();
        return l;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    return 0L;
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (!paramString1.exists()) {}
    }
    try
    {
      copyFile(paramString1, createFile(paramString2));
      paramString1.delete();
      bool1 = true;
      return bool1;
    }
    catch (IOException paramString1) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.utils.QCircleFileUtils
 * JD-Core Version:    0.7.0.1
 */