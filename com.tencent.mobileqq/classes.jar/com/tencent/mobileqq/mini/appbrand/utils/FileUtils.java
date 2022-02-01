package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils
{
  public static final String TAG = "MiniAppFileUtils";
  private static char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
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
    //   10: invokevirtual 49	java/io/File:exists	()Z
    //   13: ifeq +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 52	java/io/File:delete	()Z
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 56	java/io/File:getParentFile	()Ljava/io/File;
    //   25: ifnull +21 -> 46
    //   28: aload_1
    //   29: invokevirtual 56	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 49	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_1
    //   39: invokevirtual 56	java/io/File:getParentFile	()Ljava/io/File;
    //   42: invokevirtual 59	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: new 61	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 64	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
    //   55: new 66	java/io/BufferedInputStream
    //   58: dup
    //   59: new 68	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: invokestatic 78	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   74: sipush 4096
    //   77: invokevirtual 82	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   80: astore 4
    //   82: aload_0
    //   83: aload 4
    //   85: invokevirtual 86	java/io/BufferedInputStream:read	([B)I
    //   88: istore_3
    //   89: iload_3
    //   90: iconst_m1
    //   91: if_icmpeq +18 -> 109
    //   94: aload_1
    //   95: aload 4
    //   97: iconst_0
    //   98: iload_3
    //   99: invokevirtual 90	java/io/FileOutputStream:write	([BII)V
    //   102: aload_1
    //   103: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   106: goto -24 -> 82
    //   109: invokestatic 78	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   112: aload 4
    //   114: invokevirtual 97	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   117: aload_1
    //   118: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   121: goto +17 -> 138
    //   124: astore_1
    //   125: iload_2
    //   126: ifeq +12 -> 138
    //   129: ldc 8
    //   131: iconst_1
    //   132: ldc 102
    //   134: aload_1
    //   135: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   138: aload_0
    //   139: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   142: goto +17 -> 159
    //   145: astore_0
    //   146: iload_2
    //   147: ifeq +12 -> 159
    //   150: ldc 8
    //   152: iconst_1
    //   153: ldc 102
    //   155: aload_0
    //   156: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   159: iconst_1
    //   160: ireturn
    //   161: astore 5
    //   163: goto +17 -> 180
    //   166: astore 4
    //   168: goto +28 -> 196
    //   171: astore 4
    //   173: goto +40 -> 213
    //   176: astore 5
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_1
    //   181: astore 4
    //   183: aload 5
    //   185: astore_1
    //   186: aload_0
    //   187: astore 5
    //   189: goto +167 -> 356
    //   192: astore 4
    //   194: aconst_null
    //   195: astore_0
    //   196: aload_1
    //   197: astore 5
    //   199: aload 4
    //   201: astore 6
    //   203: aload_0
    //   204: astore 4
    //   206: goto +32 -> 238
    //   209: astore 4
    //   211: aconst_null
    //   212: astore_0
    //   213: aload_1
    //   214: astore 5
    //   216: aload 4
    //   218: astore 6
    //   220: aload_0
    //   221: astore 4
    //   223: goto +99 -> 322
    //   226: astore_1
    //   227: aconst_null
    //   228: astore 5
    //   230: goto +126 -> 356
    //   233: astore 6
    //   235: aconst_null
    //   236: astore 4
    //   238: iload_2
    //   239: ifeq +19 -> 258
    //   242: aload 5
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: ldc 8
    //   250: iconst_1
    //   251: ldc 102
    //   253: aload 6
    //   255: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload 5
    //   260: ifnull +25 -> 285
    //   263: aload 5
    //   265: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   268: goto +17 -> 285
    //   271: astore_0
    //   272: iload_2
    //   273: ifeq +12 -> 285
    //   276: ldc 8
    //   278: iconst_1
    //   279: ldc 102
    //   281: aload_0
    //   282: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   285: aload 4
    //   287: ifnull +172 -> 459
    //   290: aload 4
    //   292: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   295: iconst_0
    //   296: ireturn
    //   297: astore_0
    //   298: iload_2
    //   299: ifeq +160 -> 459
    //   302: ldc 8
    //   304: iconst_1
    //   305: ldc 102
    //   307: aload_0
    //   308: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   311: iconst_0
    //   312: ireturn
    //   313: astore 6
    //   315: aconst_null
    //   316: astore 4
    //   318: aload 7
    //   320: astore 5
    //   322: iload_2
    //   323: ifeq +89 -> 412
    //   326: aload 5
    //   328: astore_0
    //   329: aload 4
    //   331: astore_1
    //   332: ldc 8
    //   334: iconst_1
    //   335: ldc 102
    //   337: aload 6
    //   339: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: goto +70 -> 412
    //   345: astore 4
    //   347: aload_1
    //   348: astore 5
    //   350: aload 4
    //   352: astore_1
    //   353: aload_0
    //   354: astore 4
    //   356: aload 4
    //   358: ifnull +25 -> 383
    //   361: aload 4
    //   363: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   366: goto +17 -> 383
    //   369: astore_0
    //   370: iload_2
    //   371: ifeq +12 -> 383
    //   374: ldc 8
    //   376: iconst_1
    //   377: ldc 102
    //   379: aload_0
    //   380: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: aload 5
    //   385: ifnull +25 -> 410
    //   388: aload 5
    //   390: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   393: goto +17 -> 410
    //   396: astore_0
    //   397: iload_2
    //   398: ifeq +12 -> 410
    //   401: ldc 8
    //   403: iconst_1
    //   404: ldc 102
    //   406: aload_0
    //   407: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload_1
    //   411: athrow
    //   412: aload 5
    //   414: ifnull +25 -> 439
    //   417: aload 5
    //   419: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   422: goto +17 -> 439
    //   425: astore_0
    //   426: iload_2
    //   427: ifeq +12 -> 439
    //   430: ldc 8
    //   432: iconst_1
    //   433: ldc 102
    //   435: aload_0
    //   436: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: aload 4
    //   441: ifnull +18 -> 459
    //   444: aload 4
    //   446: invokevirtual 109	java/io/BufferedInputStream:close	()V
    //   449: iconst_0
    //   450: ireturn
    //   451: astore_0
    //   452: iload_2
    //   453: ifeq +6 -> 459
    //   456: goto -154 -> 302
    //   459: iconst_0
    //   460: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	461	0	paramFile1	File
    //   0	461	1	paramFile2	File
    //   0	461	2	paramBoolean	boolean
    //   88	11	3	i	int
    //   4	109	4	arrayOfByte	byte[]
    //   166	1	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   171	1	4	localIOException1	IOException
    //   181	1	4	localFile1	File
    //   192	8	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   204	1	4	localFile2	File
    //   209	8	4	localIOException2	IOException
    //   221	109	4	localFile3	File
    //   345	6	4	localObject1	Object
    //   354	91	4	localFile4	File
    //   7	1	5	localObject2	Object
    //   161	1	5	localObject3	Object
    //   176	8	5	localObject4	Object
    //   187	231	5	localObject5	Object
    //   201	18	6	localObject6	Object
    //   233	21	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   313	25	6	localIOException3	IOException
    //   1	318	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   117	121	124	java/io/IOException
    //   138	142	145	java/io/IOException
    //   71	82	161	finally
    //   82	89	161	finally
    //   94	106	161	finally
    //   109	117	161	finally
    //   71	82	166	java/lang/OutOfMemoryError
    //   82	89	166	java/lang/OutOfMemoryError
    //   94	106	166	java/lang/OutOfMemoryError
    //   109	117	166	java/lang/OutOfMemoryError
    //   71	82	171	java/io/IOException
    //   82	89	171	java/io/IOException
    //   94	106	171	java/io/IOException
    //   109	117	171	java/io/IOException
    //   55	71	176	finally
    //   55	71	192	java/lang/OutOfMemoryError
    //   55	71	209	java/io/IOException
    //   9	21	226	finally
    //   21	46	226	finally
    //   46	55	226	finally
    //   9	21	233	java/lang/OutOfMemoryError
    //   21	46	233	java/lang/OutOfMemoryError
    //   46	55	233	java/lang/OutOfMemoryError
    //   263	268	271	java/io/IOException
    //   290	295	297	java/io/IOException
    //   9	21	313	java/io/IOException
    //   21	46	313	java/io/IOException
    //   46	55	313	java/io/IOException
    //   248	258	345	finally
    //   332	342	345	finally
    //   361	366	369	java/io/IOException
    //   388	393	396	java/io/IOException
    //   417	422	425	java/io/IOException
    //   444	449	451	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      File localFile = new File(paramString1);
      if (localFile.exists()) {
        try
        {
          boolean bool = copyFile(localFile, createFile(paramString2));
          return bool;
        }
        catch (IOException localIOException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("copy fail from ");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(" to ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" ");
          localStringBuilder.append(localIOException.getMessage());
          QLog.d("MiniAppFileUtils", 2, localStringBuilder.toString());
        }
      }
    }
    return false;
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
  
  public static long delete(String paramString, boolean paramBoolean)
  {
    long l = 0L;
    if (paramString == null) {
      return 0L;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return 0L;
    }
    if (paramString.isFile())
    {
      l = paramString.length();
      paramString.delete();
      return l;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return 0L;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      l += delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
    return l;
  }
  
  public static long deleteDirectory(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return 0L;
      }
      paramString = new File(paramString);
      File[] arrayOfFile = paramString.listFiles();
      l2 = l1;
      if (arrayOfFile != null)
      {
        l2 = l1;
        if (arrayOfFile.length > 0)
        {
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= arrayOfFile.length) {
              break;
            }
            if (arrayOfFile[i].isDirectory())
            {
              l1 += deleteDirectory(arrayOfFile[i].getAbsolutePath());
            }
            else
            {
              l1 += arrayOfFile[i].length();
              arrayOfFile[i].delete();
            }
            i += 1;
          }
        }
      }
      paramString.delete();
    }
    return l2;
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  public static long deleteFilesInDirectory(String paramString)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramString != null)
    {
      if (paramString.trim().length() == 0) {
        return 0L;
      }
      paramString = new File(paramString).listFiles();
      l2 = l1;
      if (paramString != null)
      {
        l2 = l1;
        if (paramString.length > 0)
        {
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= paramString.length) {
              break;
            }
            if (paramString[i].isDirectory())
            {
              l1 += deleteDirectory(paramString[i].getAbsolutePath());
            }
            else
            {
              l1 += paramString[i].length();
              paramString[i].delete();
            }
            i += 1;
          }
        }
      }
    }
    return l2;
  }
  
  /* Error */
  public static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 189
    //   2: invokestatic 195	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_2
    //   6: new 68	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_0
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore_3
    //   21: aload_0
    //   22: aload_3
    //   23: invokevirtual 197	java/io/FileInputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +13 -> 42
    //   32: aload_2
    //   33: aload_3
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 200	java/security/MessageDigest:update	([BII)V
    //   39: goto -18 -> 21
    //   42: aload_2
    //   43: invokevirtual 204	java/security/MessageDigest:digest	()[B
    //   46: astore_2
    //   47: aload_0
    //   48: invokevirtual 205	java/io/FileInputStream:close	()V
    //   51: aload_2
    //   52: areturn
    //   53: astore_2
    //   54: aload_0
    //   55: invokevirtual 205	java/io/FileInputStream:close	()V
    //   58: aload_2
    //   59: athrow
    //   60: aload_0
    //   61: invokevirtual 205	java/io/FileInputStream:close	()V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_0
    //   67: aconst_null
    //   68: areturn
    //   69: astore_2
    //   70: goto -10 -> 60
    //   73: astore_0
    //   74: aload_2
    //   75: areturn
    //   76: astore_0
    //   77: goto -19 -> 58
    //   80: astore_0
    //   81: goto -17 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramString	String
    //   26	10	1	i	int
    //   5	47	2	localObject1	Object
    //   53	6	2	localObject2	Object
    //   69	6	2	localIOException	IOException
    //   20	14	3	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   21	27	53	finally
    //   32	39	53	finally
    //   42	47	53	finally
    //   0	21	66	java/io/FileNotFoundException
    //   0	21	66	java/security/NoSuchAlgorithmException
    //   47	51	66	java/io/FileNotFoundException
    //   47	51	66	java/security/NoSuchAlgorithmException
    //   54	58	66	java/io/FileNotFoundException
    //   54	58	66	java/security/NoSuchAlgorithmException
    //   58	60	66	java/io/FileNotFoundException
    //   58	60	66	java/security/NoSuchAlgorithmException
    //   60	64	66	java/io/FileNotFoundException
    //   60	64	66	java/security/NoSuchAlgorithmException
    //   21	27	69	java/io/IOException
    //   32	39	69	java/io/IOException
    //   42	47	69	java/io/IOException
    //   47	51	73	java/io/IOException
    //   54	58	76	java/io/IOException
    //   60	64	80	java/io/IOException
  }
  
  public static String encodeFile2HexStr(String paramString)
  {
    return HexUtil.bytes2HexStr(encodeFile(paramString));
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  /* Error */
  public static byte[] fileToBytes(File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 49	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 66	java/io/BufferedInputStream
    //   12: dup
    //   13: new 68	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 69	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 6
    //   26: aload 6
    //   28: astore 5
    //   30: aload_0
    //   31: invokevirtual 154	java/io/File:length	()J
    //   34: lstore_3
    //   35: lload_3
    //   36: ldc2_w 221
    //   39: lcmp
    //   40: ifgt +152 -> 192
    //   43: lload_3
    //   44: lconst_0
    //   45: lcmp
    //   46: ifgt +6 -> 52
    //   49: goto +143 -> 192
    //   52: aload 6
    //   54: astore 5
    //   56: lload_3
    //   57: l2i
    //   58: newarray byte
    //   60: astore 7
    //   62: iconst_0
    //   63: istore_1
    //   64: aload 6
    //   66: astore 5
    //   68: iload_1
    //   69: aload 7
    //   71: arraylength
    //   72: if_icmpge +32 -> 104
    //   75: aload 6
    //   77: astore 5
    //   79: aload 6
    //   81: aload 7
    //   83: iload_1
    //   84: aload 7
    //   86: arraylength
    //   87: iload_1
    //   88: isub
    //   89: invokevirtual 227	java/io/InputStream:read	([BII)I
    //   92: istore_2
    //   93: iload_2
    //   94: iflt +10 -> 104
    //   97: iload_1
    //   98: iload_2
    //   99: iadd
    //   100: istore_1
    //   101: goto -37 -> 64
    //   104: aload 6
    //   106: astore 5
    //   108: iload_1
    //   109: aload 7
    //   111: arraylength
    //   112: if_icmpge +64 -> 176
    //   115: aload 6
    //   117: astore 5
    //   119: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +54 -> 176
    //   125: aload 6
    //   127: astore 5
    //   129: new 121	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   136: astore 8
    //   138: aload 6
    //   140: astore 5
    //   142: aload 8
    //   144: ldc 232
    //   146: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 6
    //   152: astore 5
    //   154: aload 8
    //   156: aload_0
    //   157: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload 6
    //   163: astore 5
    //   165: ldc 237
    //   167: iconst_2
    //   168: aload 8
    //   170: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aload 6
    //   178: invokevirtual 238	java/io/InputStream:close	()V
    //   181: aload 7
    //   183: areturn
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   189: aload 7
    //   191: areturn
    //   192: aload 6
    //   194: astore 5
    //   196: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   199: ifeq +54 -> 253
    //   202: aload 6
    //   204: astore 5
    //   206: new 121	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   213: astore 7
    //   215: aload 6
    //   217: astore 5
    //   219: aload 7
    //   221: ldc 243
    //   223: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 6
    //   229: astore 5
    //   231: aload 7
    //   233: lload_3
    //   234: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 6
    //   240: astore 5
    //   242: ldc 237
    //   244: iconst_2
    //   245: aload 7
    //   247: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: aload 6
    //   255: invokevirtual 238	java/io/InputStream:close	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   265: aconst_null
    //   266: areturn
    //   267: astore_0
    //   268: aconst_null
    //   269: astore 5
    //   271: goto +87 -> 358
    //   274: aconst_null
    //   275: astore 6
    //   277: aload 6
    //   279: astore 5
    //   281: invokestatic 230	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   284: ifeq +54 -> 338
    //   287: aload 6
    //   289: astore 5
    //   291: new 121	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   298: astore 7
    //   300: aload 6
    //   302: astore 5
    //   304: aload 7
    //   306: ldc 248
    //   308: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 6
    //   314: astore 5
    //   316: aload 7
    //   318: aload_0
    //   319: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 6
    //   325: astore 5
    //   327: ldc 237
    //   329: iconst_2
    //   330: aload 7
    //   332: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   338: aload 6
    //   340: ifnull +15 -> 355
    //   343: aload 6
    //   345: invokevirtual 238	java/io/InputStream:close	()V
    //   348: aconst_null
    //   349: areturn
    //   350: astore_0
    //   351: aload_0
    //   352: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   355: aconst_null
    //   356: areturn
    //   357: astore_0
    //   358: aload 5
    //   360: ifnull +18 -> 378
    //   363: aload 5
    //   365: invokevirtual 238	java/io/InputStream:close	()V
    //   368: goto +10 -> 378
    //   371: astore 5
    //   373: aload 5
    //   375: invokevirtual 241	java/lang/Throwable:printStackTrace	()V
    //   378: goto +5 -> 383
    //   381: aload_0
    //   382: athrow
    //   383: goto -2 -> 381
    //   386: astore 5
    //   388: goto -114 -> 274
    //   391: astore 5
    //   393: goto -116 -> 277
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramFile	File
    //   63	50	1	i	int
    //   92	8	2	j	int
    //   34	200	3	l	long
    //   28	336	5	localBufferedInputStream1	java.io.BufferedInputStream
    //   371	3	5	localThrowable1	java.lang.Throwable
    //   386	1	5	localThrowable2	java.lang.Throwable
    //   391	1	5	localThrowable3	java.lang.Throwable
    //   24	320	6	localBufferedInputStream2	java.io.BufferedInputStream
    //   60	271	7	localObject	Object
    //   136	33	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   176	181	184	java/lang/Throwable
    //   253	258	260	java/lang/Throwable
    //   9	26	267	finally
    //   343	348	350	java/lang/Throwable
    //   30	35	357	finally
    //   56	62	357	finally
    //   68	75	357	finally
    //   79	93	357	finally
    //   108	115	357	finally
    //   119	125	357	finally
    //   129	138	357	finally
    //   142	150	357	finally
    //   154	161	357	finally
    //   165	176	357	finally
    //   196	202	357	finally
    //   206	215	357	finally
    //   219	227	357	finally
    //   231	238	357	finally
    //   242	253	357	finally
    //   281	287	357	finally
    //   291	300	357	finally
    //   304	312	357	finally
    //   316	323	357	finally
    //   327	338	357	finally
    //   363	368	371	java/lang/Throwable
    //   9	26	386	java/lang/Throwable
    //   30	35	391	java/lang/Throwable
    //   56	62	391	java/lang/Throwable
    //   68	75	391	java/lang/Throwable
    //   79	93	391	java/lang/Throwable
    //   108	115	391	java/lang/Throwable
    //   119	125	391	java/lang/Throwable
    //   129	138	391	java/lang/Throwable
    //   142	150	391	java/lang/Throwable
    //   154	161	391	java/lang/Throwable
    //   165	176	391	java/lang/Throwable
    //   196	202	391	java/lang/Throwable
    //   206	215	391	java/lang/Throwable
    //   219	227	391	java/lang/Throwable
    //   231	238	391	java/lang/Throwable
    //   242	253	391	java/lang/Throwable
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      if (paramString.isFile()) {
        return paramString.length();
      }
      l2 = l1;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        l2 = l1;
        if (paramString != null)
        {
          if (paramString.length <= 0) {
            return 0L;
          }
          int j = paramString.length;
          int i = 0;
          for (;;)
          {
            l2 = l1;
            if (i >= j) {
              break;
            }
            Object localObject = paramString[i];
            l2 = l1;
            if (localObject != null)
            {
              l2 = l1;
              if (localObject.exists())
              {
                if (localObject.isDirectory()) {}
                for (l2 = getFileOrFolderSize(localObject.getAbsolutePath());; l2 = localObject.length())
                {
                  l2 = l1 + l2;
                  break;
                  l2 = l1;
                  if (!localObject.isFile()) {
                    break;
                  }
                }
              }
            }
            i += 1;
            l1 = l2;
          }
        }
      }
    }
    return l2;
  }
  
  public static String getFileSHA1(String paramString)
  {
    try
    {
      paramString = getHash(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static long getFileSizes(String paramString)
  {
    try
    {
      long l = new File(paramString).length();
      return l;
    }
    catch (Exception paramString)
    {
      label14:
      break label14;
    }
    return 0L;
  }
  
  /* Error */
  private static String getHash(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 66	java/io/BufferedInputStream
    //   5: dup
    //   6: new 68	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 196	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: invokestatic 195	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore_1
    //   29: aload_0
    //   30: aload_3
    //   31: invokevirtual 265	java/io/InputStream:read	([B)I
    //   34: istore_2
    //   35: iload_2
    //   36: ifle +13 -> 49
    //   39: aload_1
    //   40: aload_3
    //   41: iconst_0
    //   42: iload_2
    //   43: invokevirtual 200	java/security/MessageDigest:update	([BII)V
    //   46: goto -17 -> 29
    //   49: aload_0
    //   50: invokevirtual 238	java/io/InputStream:close	()V
    //   53: aload_1
    //   54: invokevirtual 204	java/security/MessageDigest:digest	()[B
    //   57: invokestatic 268	com/tencent/mobileqq/mini/appbrand/utils/FileUtils:toHexString	([B)Ljava/lang/String;
    //   60: areturn
    //   61: astore_3
    //   62: aload_0
    //   63: astore_1
    //   64: aload_3
    //   65: astore_0
    //   66: goto +6 -> 72
    //   69: astore_0
    //   70: aload_3
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokevirtual 238	java/io/InputStream:close	()V
    //   80: goto +5 -> 85
    //   83: aload_0
    //   84: athrow
    //   85: goto -2 -> 83
    //   88: astore_0
    //   89: goto -36 -> 53
    //   92: astore_1
    //   93: goto -13 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramString1	String
    //   0	96	1	paramString2	String
    //   34	9	2	i	int
    //   1	40	3	arrayOfByte	byte[]
    //   61	10	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	29	61	finally
    //   29	35	61	finally
    //   39	46	61	finally
    //   2	18	69	finally
    //   49	53	88	java/io/IOException
    //   76	80	92	java/io/IOException
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
  
  public static boolean rename(String paramString1, String paramString2)
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
      if (paramString1.exists()) {
        bool1 = paramString1.renameTo(new File(paramString2));
      }
    }
    return bool1;
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(hexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    return writeFile(paramString1, paramString2, true);
  }
  
  public static boolean writeFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label42:
      boolean bool;
      break label42;
    }
    bool = false;
    break label49;
    bool = true;
    try
    {
      label49:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label62:
      Object localObject;
      break label62;
    }
    paramString1 = null;
    bool = false;
    localObject = paramString2;
    if (paramBoolean) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("\r\n");
      localObject = ((StringBuilder)localObject).toString();
      paramBoolean = bool;
      if (paramString1 == null) {
        break label127;
      }
      paramString1.write(((String)localObject).getBytes());
      paramBoolean = bool;
    }
    catch (IOException paramString2)
    {
      label125:
      break label125;
    }
    paramBoolean = false;
    label127:
    bool = paramBoolean;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool = paramBoolean;
    }
    catch (IOException paramString2)
    {
      label142:
      break label142;
    }
    bool = false;
    paramBoolean = bool;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool;
    }
    catch (IOException paramString1)
    {
      label156:
      break label156;
    }
    paramBoolean = false;
    return paramBoolean;
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 45	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 113	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_1
    //   16: invokevirtual 49	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 56	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 49	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 56	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 59	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 146	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 61	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 287	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 90	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 93	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: goto +10 -> 83
    //   76: goto +17 -> 93
    //   79: astore_0
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload 5
    //   106: astore_1
    //   107: goto -14 -> 93
    //   110: astore_0
    //   111: goto -35 -> 76
    //   114: astore_0
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto -27 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramArrayOfByte	byte[]
    //   0	121	1	paramString	String
    //   0	121	2	paramBoolean	boolean
    //   0	121	3	paramInt	int
    //   13	68	4	localObject1	Object
    //   10	95	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	79	finally
    //   40	45	79	finally
    //   45	55	79	finally
    //   15	40	103	java/io/IOException
    //   40	45	103	java/io/IOException
    //   45	55	103	java/io/IOException
    //   55	66	110	java/io/IOException
    //   66	70	114	java/io/IOException
    //   97	101	114	java/io/IOException
    //   87	91	117	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */