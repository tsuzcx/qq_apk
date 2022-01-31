package com.tencent.weiyun.utils;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IOUtils
{
  private static final long MAX_MMAP_BUFFER = 536870912L;
  private static final int MAX_STREAM_BUFFER = 8192;
  private static final String TAG = "IOUtils";
  
  private static String calcCapUnit(int paramInt, float paramFloat)
  {
    if (paramFloat < 0.0F) {
      return "";
    }
    if (paramFloat < 1024.0F) {
      return String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }) + countToUnit(paramInt);
    }
    return calcCapUnit(paramInt + 1, paramFloat / 1024.0F);
  }
  
  public static String calcCapUnit(long paramLong)
  {
    return calcCapUnit(0, (float)paramLong);
  }
  
  public static void closeSilently(Cursor paramCursor)
  {
    if ((paramCursor != null) && (!paramCursor.isClosed())) {}
    try
    {
      paramCursor.close();
      return;
    }
    catch (Throwable paramCursor) {}
  }
  
  public static void closeSilently(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  public static boolean copyFileAndNotifyOS(Context paramContext, String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if (copyFiles(paramString1, paramString2))
    {
      scan2MediaStore(paramContext, paramString2);
      return true;
    }
    return false;
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
  {
    int i = 0;
    boolean bool2;
    if ((paramFile1 == null) || (paramFile2 == null))
    {
      bool2 = false;
      return bool2;
    }
    if (!paramFile1.exists()) {
      return false;
    }
    if (paramFile1.isFile()) {
      return performCopyFile(paramFile1, paramFile2);
    }
    paramFile1 = paramFile1.listFiles();
    if (paramFile1 == null) {
      return false;
    }
    boolean bool1 = true;
    int j = paramFile1.length;
    for (;;)
    {
      bool2 = bool1;
      if (i >= j) {
        break;
      }
      File localFile = paramFile1[i];
      if (!copyFiles(localFile, new File(paramFile2, localFile.getName()))) {
        bool1 = false;
      }
      i += 1;
    }
  }
  
  private static String countToUnit(int paramInt)
  {
    if (paramInt == 0) {
      return "byte";
    }
    if (paramInt == 1) {
      return "KB";
    }
    if (paramInt == 2) {
      return "MB";
    }
    if (paramInt == 3) {
      return "GB";
    }
    if (paramInt == 4) {
      return "TB";
    }
    if (paramInt == 5) {
      return "PB";
    }
    return "";
  }
  
  public static void deleteFile(File paramFile, boolean paramBoolean)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      do
      {
        return;
        if (!paramFile.isDirectory())
        {
          localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
          paramFile.renameTo((File)localObject);
          ((File)localObject).delete();
          return;
        }
        localObject = paramFile.listFiles();
      } while (localObject == null);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        deleteFile(localObject[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    Object localObject = new File(paramFile.getAbsolutePath() + System.currentTimeMillis());
    paramFile.renameTo((File)localObject);
    ((File)localObject).delete();
  }
  
  public static String ensureFilePath(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    String str = paramString1;
    if (!paramString1.endsWith(File.separator)) {
      str = paramString1 + File.separatorChar;
    }
    for (paramString1 = new File(str + paramString2);; paramString1 = new File(str + paramString2)) {
      if (paramString1.exists())
      {
        paramString2 = performRename(paramString1.getName());
        if (!TextUtils.isEmpty(paramString2)) {}
      }
      else
      {
        return paramString1.getAbsolutePath();
      }
    }
  }
  
  public static boolean ensureStorageSpace(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      for (Object localObject1 = new File(paramString); !((File)localObject1).exists(); localObject1 = ((File)localObject1).getParentFile()) {}
      Object localObject2 = localObject1;
      if (!((File)localObject1).isDirectory()) {
        localObject2 = ((File)localObject1).getParentFile();
      }
      long l1 = 0L;
      try
      {
        localObject1 = new StatFs(((File)localObject2).getAbsolutePath());
        long l2 = ((StatFs)localObject1).getAvailableBlocks();
        int i = ((StatFs)localObject1).getBlockSize();
        l1 = l2 * i;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Log.d("IOUtils", "ensure storage space error for path:" + paramString, localThrowable);
        }
      }
    } while (l1 <= paramLong);
    return true;
  }
  
  /* Error */
  public static boolean ensureWritable(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 7
    //   8: aload 7
    //   10: astore 5
    //   12: aload 6
    //   14: astore 4
    //   16: new 78	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 8
    //   26: aload 7
    //   28: astore 5
    //   30: aload 6
    //   32: astore 4
    //   34: aload 8
    //   36: invokevirtual 92	java/io/File:exists	()Z
    //   39: ifne +123 -> 162
    //   42: aload 7
    //   44: astore 5
    //   46: aload 6
    //   48: astore 4
    //   50: aload 8
    //   52: invokevirtual 200	java/io/File:mkdirs	()Z
    //   55: pop
    //   56: iconst_0
    //   57: istore_1
    //   58: aconst_null
    //   59: astore 4
    //   61: new 78	java/io/File
    //   64: dup
    //   65: aload 8
    //   67: new 27	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   74: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   77: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   80: ldc 202
    //   82: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 108	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   91: astore 6
    //   93: iload_1
    //   94: iconst_1
    //   95: iadd
    //   96: istore_1
    //   97: aload 6
    //   99: astore 5
    //   101: aload 6
    //   103: astore 4
    //   105: aload 6
    //   107: invokevirtual 92	java/io/File:exists	()Z
    //   110: ifeq +9 -> 119
    //   113: iload_1
    //   114: bipush 30
    //   116: if_icmplt +185 -> 301
    //   119: aload 6
    //   121: astore 5
    //   123: aload 6
    //   125: astore 4
    //   127: aload 6
    //   129: invokevirtual 205	java/io/File:createNewFile	()Z
    //   132: istore_2
    //   133: iload_2
    //   134: istore_3
    //   135: iload_3
    //   136: istore_2
    //   137: aload 6
    //   139: ifnull +21 -> 160
    //   142: iload_3
    //   143: istore_2
    //   144: aload 6
    //   146: invokevirtual 92	java/io/File:exists	()Z
    //   149: ifeq +11 -> 160
    //   152: aload 6
    //   154: invokevirtual 144	java/io/File:delete	()Z
    //   157: pop
    //   158: iload_3
    //   159: istore_2
    //   160: iload_2
    //   161: ireturn
    //   162: aload 7
    //   164: astore 5
    //   166: aload 6
    //   168: astore 4
    //   170: aload 8
    //   172: invokevirtual 125	java/io/File:isDirectory	()Z
    //   175: ifne -119 -> 56
    //   178: aload 7
    //   180: astore 5
    //   182: aload 6
    //   184: astore 4
    //   186: ldc 15
    //   188: ldc 207
    //   190: invokestatic 211	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   193: pop
    //   194: iload_3
    //   195: istore_2
    //   196: iconst_0
    //   197: ifeq -37 -> 160
    //   200: new 213	java/lang/NullPointerException
    //   203: dup
    //   204: invokespecial 214	java/lang/NullPointerException:<init>	()V
    //   207: athrow
    //   208: astore 6
    //   210: aload 5
    //   212: astore 4
    //   214: ldc 15
    //   216: new 27	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   223: ldc 216
    //   225: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_0
    //   229: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: aload 6
    //   237: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   240: pop
    //   241: iload_3
    //   242: istore_2
    //   243: aload 5
    //   245: ifnull -85 -> 160
    //   248: iload_3
    //   249: istore_2
    //   250: aload 5
    //   252: invokevirtual 92	java/io/File:exists	()Z
    //   255: ifeq -95 -> 160
    //   258: aload 5
    //   260: invokevirtual 144	java/io/File:delete	()Z
    //   263: pop
    //   264: iconst_0
    //   265: ireturn
    //   266: astore_0
    //   267: aload 4
    //   269: ifnull +17 -> 286
    //   272: aload 4
    //   274: invokevirtual 92	java/io/File:exists	()Z
    //   277: ifeq +9 -> 286
    //   280: aload 4
    //   282: invokevirtual 144	java/io/File:delete	()Z
    //   285: pop
    //   286: aload_0
    //   287: athrow
    //   288: astore_0
    //   289: goto -22 -> 267
    //   292: astore 6
    //   294: aload 4
    //   296: astore 5
    //   298: goto -88 -> 210
    //   301: aload 6
    //   303: astore 4
    //   305: goto -244 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString	String
    //   57	60	1	i	int
    //   132	118	2	bool1	boolean
    //   1	248	3	bool2	boolean
    //   14	290	4	localObject1	Object
    //   10	287	5	localObject2	Object
    //   3	180	6	localFile1	File
    //   208	28	6	localThrowable1	Throwable
    //   292	10	6	localThrowable2	Throwable
    //   6	173	7	localObject3	Object
    //   24	147	8	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   16	26	208	java/lang/Throwable
    //   34	42	208	java/lang/Throwable
    //   50	56	208	java/lang/Throwable
    //   105	113	208	java/lang/Throwable
    //   127	133	208	java/lang/Throwable
    //   170	178	208	java/lang/Throwable
    //   186	194	208	java/lang/Throwable
    //   16	26	266	finally
    //   34	42	266	finally
    //   50	56	266	finally
    //   105	113	266	finally
    //   127	133	266	finally
    //   170	178	266	finally
    //   186	194	266	finally
    //   214	241	266	finally
    //   61	93	288	finally
    //   61	93	292	java/lang/Throwable
  }
  
  public static String getDirPathNoSeparator(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      str = paramString;
      if (paramString.endsWith(File.separator)) {
        str = paramString.substring(0, paramString.lastIndexOf(File.separator));
      }
    }
    return str;
  }
  
  public static String getFileExt(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i >= 0) {
      return paramString.substring(i);
    }
    return "";
  }
  
  public static String getFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return new File(paramString).getName();
  }
  
  /* Error */
  public static String getFileSha1(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: new 235	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore_3
    //   21: ldc 238
    //   23: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore 5
    //   28: iconst_0
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +70 -> 102
    //   35: aload 4
    //   37: aload_3
    //   38: invokevirtual 250	java/io/InputStream:read	([B)I
    //   41: istore_2
    //   42: iload_2
    //   43: istore_1
    //   44: iload_2
    //   45: ifle -15 -> 30
    //   48: aload 5
    //   50: aload_3
    //   51: iconst_0
    //   52: iload_2
    //   53: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   56: iload_2
    //   57: istore_1
    //   58: goto -28 -> 30
    //   61: astore 5
    //   63: aload 4
    //   65: astore_3
    //   66: ldc 15
    //   68: new 27	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   75: ldc_w 256
    //   78: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aload 5
    //   90: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   93: pop
    //   94: aload 4
    //   96: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   99: ldc 24
    //   101: areturn
    //   102: aload 5
    //   104: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   107: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   110: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   113: astore_3
    //   114: aload 4
    //   116: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   119: aload_3
    //   120: areturn
    //   121: astore_0
    //   122: aload_3
    //   123: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   126: aload_0
    //   127: athrow
    //   128: astore_0
    //   129: aload 4
    //   131: astore_3
    //   132: goto -10 -> 122
    //   135: astore 5
    //   137: aload 6
    //   139: astore 4
    //   141: goto -78 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	paramString	String
    //   29	29	1	i	int
    //   41	16	2	j	int
    //   1	131	3	localObject1	Object
    //   13	127	4	localObject2	Object
    //   26	23	5	localMessageDigest	java.security.MessageDigest
    //   61	42	5	localThrowable1	Throwable
    //   135	1	5	localThrowable2	Throwable
    //   3	135	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	28	61	java/lang/Throwable
    //   35	42	61	java/lang/Throwable
    //   48	56	61	java/lang/Throwable
    //   102	114	61	java/lang/Throwable
    //   5	15	121	finally
    //   66	94	121	finally
    //   15	28	128	finally
    //   35	42	128	finally
    //   48	56	128	finally
    //   102	114	128	finally
    //   5	15	135	java/lang/Throwable
  }
  
  /* Error */
  public static String[] getFileSha1AndMd5(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 6
    //   5: new 235	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore 4
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore 5
    //   22: ldc 238
    //   24: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 6
    //   29: ldc_w 275
    //   32: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore_3
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +92 -> 132
    //   43: aload 4
    //   45: aload 5
    //   47: invokevirtual 250	java/io/InputStream:read	([B)I
    //   50: istore_2
    //   51: iload_2
    //   52: istore_1
    //   53: iload_2
    //   54: ifle -16 -> 38
    //   57: aload 6
    //   59: aload 5
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   66: aload_3
    //   67: aload 5
    //   69: iconst_0
    //   70: iload_2
    //   71: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   74: iload_2
    //   75: istore_1
    //   76: goto -38 -> 38
    //   79: astore 5
    //   81: aload 4
    //   83: astore_3
    //   84: ldc 15
    //   86: new 27	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 256
    //   96: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_0
    //   100: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: aload 5
    //   108: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   111: pop
    //   112: aload 4
    //   114: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   117: iconst_2
    //   118: anewarray 38	java/lang/String
    //   121: dup
    //   122: iconst_0
    //   123: ldc 24
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: ldc 24
    //   130: aastore
    //   131: areturn
    //   132: aload 6
    //   134: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   137: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   140: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   143: astore 5
    //   145: aload_3
    //   146: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   149: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   152: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   155: astore_3
    //   156: aload 4
    //   158: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   161: iconst_2
    //   162: anewarray 38	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: aload 5
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload_3
    //   173: aastore
    //   174: areturn
    //   175: astore_0
    //   176: aload_3
    //   177: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   180: aload_0
    //   181: athrow
    //   182: astore_0
    //   183: aload 4
    //   185: astore_3
    //   186: goto -10 -> 176
    //   189: astore 5
    //   191: aload 6
    //   193: astore 4
    //   195: goto -114 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramString	String
    //   37	39	1	i	int
    //   50	25	2	j	int
    //   1	185	3	localObject1	Object
    //   13	181	4	localObject2	Object
    //   20	48	5	arrayOfByte	byte[]
    //   79	28	5	localThrowable1	Throwable
    //   143	25	5	str	String
    //   189	1	5	localThrowable2	Throwable
    //   3	189	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   15	36	79	java/lang/Throwable
    //   43	51	79	java/lang/Throwable
    //   57	74	79	java/lang/Throwable
    //   132	156	79	java/lang/Throwable
    //   5	15	175	finally
    //   84	112	175	finally
    //   15	36	182	finally
    //   43	51	182	finally
    //   57	74	182	finally
    //   132	156	182	finally
    //   5	15	189	java/lang/Throwable
  }
  
  public static long getFileSize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null)
    {
      if (paramFile.exists()) {
        break label22;
      }
      l2 = l1;
    }
    label22:
    do
    {
      return l2;
      if (paramFile.isFile()) {
        return paramFile.length();
      }
      paramFile = paramFile.listFiles();
      l2 = l1;
    } while (paramFile == null);
    l1 = 0L;
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l1 += getFileSize(paramFile[i]);
      i += 1;
    }
  }
  
  public static long getFileSize(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    return getFileSize(new File(paramString));
  }
  
  public static int[] getImageWidthHeight(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    return new int[] { localOptions.outWidth, localOptions.outHeight };
  }
  
  public static String getParentDir(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return getDirPathNoSeparator(new File(paramString).getParent());
  }
  
  public static long getSdcardCapability()
  {
    if (!isSdcardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l;
  }
  
  public static String getSdcardCapabilityForDisplay()
  {
    long l = getSdcardCapability();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static long getSdcardRemain()
  {
    if (!isSdcardMounted()) {
      return -1L;
    }
    StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
    long l = localStatFs.getBlockSize();
    return localStatFs.getAvailableBlocks() * l;
  }
  
  public static String getSdcardRemainForDisplay()
  {
    long l = getSdcardRemain();
    if (l >= 0L) {
      return calcCapUnit(l);
    }
    return "无SD Card";
  }
  
  public static boolean isFileModified(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (new File(paramString).lastModified() == paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean isSdcardMounted()
  {
    return TextUtils.equals(Environment.getExternalStorageState(), "mounted");
  }
  
  /* Error */
  private static boolean performCopyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 16
    //   13: aconst_null
    //   14: astore 15
    //   16: aconst_null
    //   17: astore 14
    //   19: aconst_null
    //   20: astore 13
    //   22: aload 13
    //   24: astore 11
    //   26: aload 15
    //   28: astore 12
    //   30: aload 14
    //   32: astore 9
    //   34: aload 16
    //   36: astore 10
    //   38: aload_0
    //   39: invokevirtual 92	java/io/File:exists	()Z
    //   42: ifeq +28 -> 70
    //   45: aload 13
    //   47: astore 11
    //   49: aload 15
    //   51: astore 12
    //   53: aload 14
    //   55: astore 9
    //   57: aload 16
    //   59: astore 10
    //   61: aload_0
    //   62: invokevirtual 95	java/io/File:isFile	()Z
    //   65: istore_2
    //   66: iload_2
    //   67: ifne +13 -> 80
    //   70: aconst_null
    //   71: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   74: aconst_null
    //   75: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   78: iconst_0
    //   79: ireturn
    //   80: aload 13
    //   82: astore 11
    //   84: aload 15
    //   86: astore 12
    //   88: aload 14
    //   90: astore 9
    //   92: aload 16
    //   94: astore 10
    //   96: aload_1
    //   97: invokevirtual 92	java/io/File:exists	()Z
    //   100: ifeq +66 -> 166
    //   103: aload 13
    //   105: astore 11
    //   107: aload 15
    //   109: astore 12
    //   111: aload 14
    //   113: astore 9
    //   115: aload 16
    //   117: astore 10
    //   119: aload_0
    //   120: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   123: aload_1
    //   124: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   127: invokestatic 351	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +13 -> 145
    //   135: aconst_null
    //   136: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   139: aconst_null
    //   140: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   143: iconst_1
    //   144: ireturn
    //   145: aload 13
    //   147: astore 11
    //   149: aload 15
    //   151: astore 12
    //   153: aload 14
    //   155: astore 9
    //   157: aload 16
    //   159: astore 10
    //   161: aload_1
    //   162: iconst_0
    //   163: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   166: aload 13
    //   168: astore 11
    //   170: aload 15
    //   172: astore 12
    //   174: aload 14
    //   176: astore 9
    //   178: aload 16
    //   180: astore 10
    //   182: aload_1
    //   183: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   186: astore 17
    //   188: aload 13
    //   190: astore 11
    //   192: aload 15
    //   194: astore 12
    //   196: aload 14
    //   198: astore 9
    //   200: aload 16
    //   202: astore 10
    //   204: aload 17
    //   206: invokevirtual 95	java/io/File:isFile	()Z
    //   209: ifeq +25 -> 234
    //   212: aload 13
    //   214: astore 11
    //   216: aload 15
    //   218: astore 12
    //   220: aload 14
    //   222: astore 9
    //   224: aload 16
    //   226: astore 10
    //   228: aload 17
    //   230: iconst_0
    //   231: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   234: aload 13
    //   236: astore 11
    //   238: aload 15
    //   240: astore 12
    //   242: aload 14
    //   244: astore 9
    //   246: aload 16
    //   248: astore 10
    //   250: aload 17
    //   252: invokevirtual 92	java/io/File:exists	()Z
    //   255: ifne +39 -> 294
    //   258: aload 13
    //   260: astore 11
    //   262: aload 15
    //   264: astore 12
    //   266: aload 14
    //   268: astore 9
    //   270: aload 16
    //   272: astore 10
    //   274: aload 17
    //   276: invokevirtual 200	java/io/File:mkdirs	()Z
    //   279: istore_2
    //   280: iload_2
    //   281: ifne +13 -> 294
    //   284: aconst_null
    //   285: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   288: aconst_null
    //   289: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   292: iconst_0
    //   293: ireturn
    //   294: aload 13
    //   296: astore 11
    //   298: aload 15
    //   300: astore 12
    //   302: aload 14
    //   304: astore 9
    //   306: aload 16
    //   308: astore 10
    //   310: new 235	java/io/FileInputStream
    //   313: dup
    //   314: aload_0
    //   315: invokespecial 354	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   318: invokevirtual 358	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   321: astore_0
    //   322: aload 13
    //   324: astore 11
    //   326: aload_0
    //   327: astore 12
    //   329: aload 14
    //   331: astore 9
    //   333: aload_0
    //   334: astore 10
    //   336: new 360	java/io/FileOutputStream
    //   339: dup
    //   340: aload_1
    //   341: invokespecial 361	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   344: invokevirtual 362	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   347: astore 13
    //   349: aload 13
    //   351: astore 11
    //   353: aload_0
    //   354: astore 12
    //   356: aload 13
    //   358: astore 9
    //   360: aload_0
    //   361: astore 10
    //   363: aload_0
    //   364: invokevirtual 367	java/nio/channels/FileChannel:size	()J
    //   367: lstore_3
    //   368: lload_3
    //   369: ldc2_w 368
    //   372: lcmp
    //   373: ifgt +65 -> 438
    //   376: lconst_0
    //   377: lstore_3
    //   378: aload 13
    //   380: astore 9
    //   382: aload_0
    //   383: astore 10
    //   385: aload_0
    //   386: invokevirtual 367	java/nio/channels/FileChannel:size	()J
    //   389: lstore 5
    //   391: lload_3
    //   392: lload 5
    //   394: lcmp
    //   395: ifge +30 -> 425
    //   398: aload 13
    //   400: astore 9
    //   402: aload_0
    //   403: astore 10
    //   405: aload 13
    //   407: aload_0
    //   408: lload_3
    //   409: ldc2_w 7
    //   412: invokevirtual 373	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   415: lstore 7
    //   417: lload_3
    //   418: lload 7
    //   420: ladd
    //   421: lstore_3
    //   422: goto -31 -> 391
    //   425: aload_0
    //   426: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   429: aload 13
    //   431: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   434: iconst_1
    //   435: ireturn
    //   436: astore 9
    //   438: aload 13
    //   440: astore 11
    //   442: aload_0
    //   443: astore 12
    //   445: aload 13
    //   447: astore 9
    //   449: aload_0
    //   450: astore 10
    //   452: sipush 8192
    //   455: invokestatic 379	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   458: astore 14
    //   460: aload 13
    //   462: astore 11
    //   464: aload_0
    //   465: astore 12
    //   467: aload 13
    //   469: astore 9
    //   471: aload_0
    //   472: astore 10
    //   474: aload_0
    //   475: aload 14
    //   477: invokevirtual 382	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   480: ifle +112 -> 592
    //   483: aload 13
    //   485: astore 11
    //   487: aload_0
    //   488: astore 12
    //   490: aload 13
    //   492: astore 9
    //   494: aload_0
    //   495: astore 10
    //   497: aload 14
    //   499: invokevirtual 386	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   502: pop
    //   503: aload 13
    //   505: astore 11
    //   507: aload_0
    //   508: astore 12
    //   510: aload 13
    //   512: astore 9
    //   514: aload_0
    //   515: astore 10
    //   517: aload 13
    //   519: aload 14
    //   521: invokevirtual 389	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   524: pop
    //   525: aload 13
    //   527: astore 11
    //   529: aload_0
    //   530: astore 12
    //   532: aload 13
    //   534: astore 9
    //   536: aload_0
    //   537: astore 10
    //   539: aload 14
    //   541: invokevirtual 393	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   544: pop
    //   545: goto -85 -> 460
    //   548: astore_0
    //   549: aload 11
    //   551: astore 9
    //   553: aload 12
    //   555: astore 10
    //   557: ldc 15
    //   559: ldc_w 395
    //   562: aload_0
    //   563: invokestatic 398	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   566: pop
    //   567: aload 11
    //   569: astore 9
    //   571: aload 12
    //   573: astore 10
    //   575: aload_1
    //   576: iconst_0
    //   577: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   580: aload 12
    //   582: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   585: aload 11
    //   587: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   590: iconst_0
    //   591: ireturn
    //   592: aload_0
    //   593: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   596: aload 13
    //   598: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   601: iconst_1
    //   602: ireturn
    //   603: astore_0
    //   604: aload 10
    //   606: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   609: aload 9
    //   611: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   614: aload_0
    //   615: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	paramFile1	File
    //   0	616	1	paramFile2	File
    //   65	216	2	bool	boolean
    //   367	55	3	l1	long
    //   389	4	5	l2	long
    //   415	4	7	l3	long
    //   32	369	9	localObject1	Object
    //   436	1	9	localThrowable	Throwable
    //   447	163	9	localFileChannel1	java.nio.channels.FileChannel
    //   36	569	10	localObject2	Object
    //   24	562	11	localFileChannel2	java.nio.channels.FileChannel
    //   28	553	12	localObject3	Object
    //   20	577	13	localFileChannel3	java.nio.channels.FileChannel
    //   17	523	14	localByteBuffer	java.nio.ByteBuffer
    //   14	285	15	localObject4	Object
    //   11	296	16	localObject5	Object
    //   186	89	17	localFile	File
    // Exception table:
    //   from	to	target	type
    //   385	391	436	java/lang/Throwable
    //   405	417	436	java/lang/Throwable
    //   38	45	548	java/lang/Throwable
    //   61	66	548	java/lang/Throwable
    //   96	103	548	java/lang/Throwable
    //   119	131	548	java/lang/Throwable
    //   161	166	548	java/lang/Throwable
    //   182	188	548	java/lang/Throwable
    //   204	212	548	java/lang/Throwable
    //   228	234	548	java/lang/Throwable
    //   250	258	548	java/lang/Throwable
    //   274	280	548	java/lang/Throwable
    //   310	322	548	java/lang/Throwable
    //   336	349	548	java/lang/Throwable
    //   363	368	548	java/lang/Throwable
    //   452	460	548	java/lang/Throwable
    //   474	483	548	java/lang/Throwable
    //   497	503	548	java/lang/Throwable
    //   517	525	548	java/lang/Throwable
    //   539	545	548	java/lang/Throwable
    //   38	45	603	finally
    //   61	66	603	finally
    //   96	103	603	finally
    //   119	131	603	finally
    //   161	166	603	finally
    //   182	188	603	finally
    //   204	212	603	finally
    //   228	234	603	finally
    //   250	258	603	finally
    //   274	280	603	finally
    //   310	322	603	finally
    //   336	349	603	finally
    //   363	368	603	finally
    //   385	391	603	finally
    //   405	417	603	finally
    //   452	460	603	finally
    //   474	483	603	finally
    //   497	503	603	finally
    //   517	525	603	finally
    //   539	545	603	finally
    //   557	567	603	finally
    //   575	580	603	finally
  }
  
  private static String performRename(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    int i = str.lastIndexOf('.');
    label32:
    StringBuilder localStringBuilder;
    Object localObject;
    if (i == -1)
    {
      paramString = "";
      if (i != -1) {
        break label128;
      }
      str = "";
      localStringBuilder = new StringBuilder();
      localObject = Pattern.compile("(^.+)(\\((\\d+)\\)$)").matcher(str);
      if (!((Matcher)localObject).find()) {
        break label152;
      }
      str = ((Matcher)localObject).group(1);
      localObject = ((Matcher)localObject).group(3);
    }
    for (;;)
    {
      try
      {
        i = Integer.parseInt((String)localObject);
        if (2147483647 > i) {
          localStringBuilder.append(str).append('(').append(i + 1).append(')').append(paramString);
        }
      }
      catch (Throwable paramString)
      {
        label128:
        Log.e("IOUtils", "fail to rename", paramString);
        continue;
      }
      return localStringBuilder.toString();
      paramString = str.substring(i);
      break;
      str = str.substring(0, i);
      break label32;
      label152:
      localStringBuilder.append(str).append("(1)").append(paramString);
    }
  }
  
  public static void scan2MediaStore(Context paramContext, File paramFile)
  {
    paramFile = Uri.fromFile(paramFile);
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(paramFile);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static String spliceFilePath(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    String str = paramString1;
    if (!paramString1.endsWith(File.separator)) {
      str = paramString1 + File.separatorChar;
    }
    return str + paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */