package com.tencent.weiyun.utils;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaScannerConnection;
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
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2);
      }
      paramFile1 = paramFile1.listFiles();
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      File localFile = paramFile1[i];
      if (!copyFiles(localFile, new File(paramFile2, localFile.getName()))) {
        bool = false;
      }
      i += 1;
    }
    return bool;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
      l1 = i * l2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.d("IOUtils", "ensure storage space error for path:" + paramString, localThrowable);
        continue;
        boolean bool = false;
      }
    }
    if (l1 > paramLong)
    {
      bool = true;
      return bool;
    }
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
    //   0: iconst_0
    //   1: istore_1
    //   2: new 235	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_3
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore 5
    //   22: aload 4
    //   24: astore_3
    //   25: ldc 238
    //   27: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore 6
    //   32: iload_1
    //   33: iconst_m1
    //   34: if_icmpeq +78 -> 112
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 250	java/io/InputStream:read	([B)I
    //   47: istore_2
    //   48: iload_2
    //   49: istore_1
    //   50: iload_2
    //   51: ifle -19 -> 32
    //   54: aload 4
    //   56: astore_3
    //   57: aload 6
    //   59: aload 5
    //   61: iconst_0
    //   62: iload_2
    //   63: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   66: iload_2
    //   67: istore_1
    //   68: goto -36 -> 32
    //   71: astore 5
    //   73: aload 4
    //   75: astore_3
    //   76: ldc 15
    //   78: new 27	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 256
    //   88: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_0
    //   92: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload 5
    //   100: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: aload 4
    //   106: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   109: ldc 24
    //   111: areturn
    //   112: aload 4
    //   114: astore_3
    //   115: aload 6
    //   117: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   120: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   123: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   126: astore 5
    //   128: aload 4
    //   130: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   133: aload 5
    //   135: areturn
    //   136: astore_0
    //   137: aconst_null
    //   138: astore_3
    //   139: aload_3
    //   140: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   143: aload_0
    //   144: athrow
    //   145: astore_0
    //   146: goto -7 -> 139
    //   149: astore 5
    //   151: aconst_null
    //   152: astore 4
    //   154: goto -81 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   1	67	1	i	int
    //   47	20	2	j	int
    //   14	126	3	localFileInputStream1	java.io.FileInputStream
    //   10	143	4	localFileInputStream2	java.io.FileInputStream
    //   20	40	5	arrayOfByte	byte[]
    //   71	28	5	localThrowable1	Throwable
    //   126	8	5	str	String
    //   149	1	5	localThrowable2	Throwable
    //   30	86	6	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   15	22	71	java/lang/Throwable
    //   25	32	71	java/lang/Throwable
    //   40	48	71	java/lang/Throwable
    //   57	66	71	java/lang/Throwable
    //   115	128	71	java/lang/Throwable
    //   2	12	136	finally
    //   15	22	145	finally
    //   25	32	145	finally
    //   40	48	145	finally
    //   57	66	145	finally
    //   76	104	145	finally
    //   115	128	145	finally
    //   2	12	149	java/lang/Throwable
  }
  
  /* Error */
  public static String[] getFileSha1AndMd5(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: new 235	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 236	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore 4
    //   12: aload 4
    //   14: astore_3
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore 6
    //   22: aload 4
    //   24: astore_3
    //   25: ldc 238
    //   27: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   30: astore 7
    //   32: aload 4
    //   34: astore_3
    //   35: ldc_w 275
    //   38: invokestatic 244	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   41: astore 5
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +102 -> 147
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: aload 6
    //   55: invokevirtual 250	java/io/InputStream:read	([B)I
    //   58: istore_2
    //   59: iload_2
    //   60: istore_1
    //   61: iload_2
    //   62: ifle -19 -> 43
    //   65: aload 4
    //   67: astore_3
    //   68: aload 7
    //   70: aload 6
    //   72: iconst_0
    //   73: iload_2
    //   74: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: aload 6
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 254	java/security/MessageDigest:update	([BII)V
    //   89: iload_2
    //   90: istore_1
    //   91: goto -48 -> 43
    //   94: astore 5
    //   96: aload 4
    //   98: astore_3
    //   99: ldc 15
    //   101: new 27	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   108: ldc_w 256
    //   111: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_0
    //   115: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: aload 5
    //   123: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   126: pop
    //   127: aload 4
    //   129: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   132: iconst_2
    //   133: anewarray 38	java/lang/String
    //   136: dup
    //   137: iconst_0
    //   138: ldc 24
    //   140: aastore
    //   141: dup
    //   142: iconst_1
    //   143: ldc 24
    //   145: aastore
    //   146: areturn
    //   147: aload 4
    //   149: astore_3
    //   150: aload 7
    //   152: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   155: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   158: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   161: astore 6
    //   163: aload 4
    //   165: astore_3
    //   166: aload 5
    //   168: invokevirtual 262	java/security/MessageDigest:digest	()[B
    //   171: invokestatic 268	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   174: invokevirtual 271	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   177: astore 5
    //   179: aload 4
    //   181: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   184: iconst_2
    //   185: anewarray 38	java/lang/String
    //   188: dup
    //   189: iconst_0
    //   190: aload 6
    //   192: aastore
    //   193: dup
    //   194: iconst_1
    //   195: aload 5
    //   197: aastore
    //   198: areturn
    //   199: astore_0
    //   200: aconst_null
    //   201: astore_3
    //   202: aload_3
    //   203: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   206: aload_0
    //   207: athrow
    //   208: astore_0
    //   209: goto -7 -> 202
    //   212: astore 5
    //   214: aconst_null
    //   215: astore 4
    //   217: goto -121 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString	String
    //   1	90	1	i	int
    //   58	32	2	j	int
    //   14	189	3	localFileInputStream1	java.io.FileInputStream
    //   10	206	4	localFileInputStream2	java.io.FileInputStream
    //   41	40	5	localMessageDigest1	java.security.MessageDigest
    //   94	73	5	localThrowable1	Throwable
    //   177	19	5	str	String
    //   212	1	5	localThrowable2	Throwable
    //   20	171	6	localObject	Object
    //   30	121	7	localMessageDigest2	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   15	22	94	java/lang/Throwable
    //   25	32	94	java/lang/Throwable
    //   35	43	94	java/lang/Throwable
    //   51	59	94	java/lang/Throwable
    //   68	77	94	java/lang/Throwable
    //   80	89	94	java/lang/Throwable
    //   150	163	94	java/lang/Throwable
    //   166	179	94	java/lang/Throwable
    //   2	12	199	finally
    //   15	22	208	finally
    //   25	32	208	finally
    //   35	43	208	finally
    //   51	59	208	finally
    //   68	77	208	finally
    //   80	89	208	finally
    //   99	127	208	finally
    //   150	163	208	finally
    //   166	179	208	finally
    //   2	12	212	java/lang/Throwable
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
    int j = paramFile.length;
    int i = 0;
    for (;;)
    {
      l2 = l1;
      if (i >= j) {
        break;
      }
      l2 = getFileSize(paramFile[i]);
      i += 1;
      l1 = l2 + l1;
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
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getBlockCount();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      Log.e("IOUtils", "getSdcardCapability error", localThrowable);
    }
    return -1L;
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
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      long l = localStatFs.getBlockSize();
      int i = localStatFs.getAvailableBlocks();
      return i * l;
    }
    catch (Throwable localThrowable)
    {
      Log.e("IOUtils", "getSdcardRemain error", localThrowable);
    }
    return -1L;
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
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_0
    //   7: ifnull +7 -> 14
    //   10: aload_1
    //   11: ifnonnull +5 -> 16
    //   14: iconst_0
    //   15: ireturn
    //   16: aload_0
    //   17: invokevirtual 92	java/io/File:exists	()Z
    //   20: ifeq +12 -> 32
    //   23: aload_0
    //   24: invokevirtual 95	java/io/File:isFile	()Z
    //   27: istore_2
    //   28: iload_2
    //   29: ifne +13 -> 42
    //   32: aconst_null
    //   33: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   36: aconst_null
    //   37: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_1
    //   43: invokevirtual 92	java/io/File:exists	()Z
    //   46: ifeq +34 -> 80
    //   49: aload_0
    //   50: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokestatic 358	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq +13 -> 75
    //   65: aconst_null
    //   66: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   69: aconst_null
    //   70: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   73: iconst_1
    //   74: ireturn
    //   75: aload_1
    //   76: iconst_0
    //   77: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   80: aload_1
    //   81: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   84: astore 11
    //   86: aload 11
    //   88: invokevirtual 95	java/io/File:isFile	()Z
    //   91: ifeq +9 -> 100
    //   94: aload 11
    //   96: iconst_0
    //   97: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   100: aload 11
    //   102: invokevirtual 92	java/io/File:exists	()Z
    //   105: ifne +23 -> 128
    //   108: aload 11
    //   110: invokevirtual 200	java/io/File:mkdirs	()Z
    //   113: istore_2
    //   114: iload_2
    //   115: ifne +13 -> 128
    //   118: aconst_null
    //   119: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   122: aconst_null
    //   123: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: new 235	java/io/FileInputStream
    //   131: dup
    //   132: aload_0
    //   133: invokespecial 361	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: invokevirtual 365	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   139: astore_0
    //   140: new 367	java/io/FileOutputStream
    //   143: dup
    //   144: aload_1
    //   145: invokespecial 368	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   148: invokevirtual 369	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   151: astore 9
    //   153: aload_0
    //   154: invokevirtual 374	java/nio/channels/FileChannel:size	()J
    //   157: lstore_3
    //   158: lload_3
    //   159: ldc2_w 375
    //   162: lcmp
    //   163: ifgt +51 -> 214
    //   166: lconst_0
    //   167: lstore_3
    //   168: aload_0
    //   169: invokevirtual 374	java/nio/channels/FileChannel:size	()J
    //   172: lstore 5
    //   174: lload_3
    //   175: lload 5
    //   177: lcmp
    //   178: ifge +23 -> 201
    //   181: aload 9
    //   183: aload_0
    //   184: lload_3
    //   185: ldc2_w 7
    //   188: invokevirtual 380	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   191: lstore 7
    //   193: lload_3
    //   194: lload 7
    //   196: ladd
    //   197: lstore_3
    //   198: goto -24 -> 174
    //   201: aload_0
    //   202: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   205: aload 9
    //   207: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   210: iconst_1
    //   211: ireturn
    //   212: astore 10
    //   214: sipush 8192
    //   217: invokestatic 386	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   220: astore 10
    //   222: aload_0
    //   223: aload 10
    //   225: invokevirtual 389	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   228: ifle +69 -> 297
    //   231: aload 10
    //   233: invokevirtual 393	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   236: pop
    //   237: aload 9
    //   239: aload 10
    //   241: invokevirtual 396	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   244: pop
    //   245: aload 10
    //   247: invokevirtual 400	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   250: pop
    //   251: goto -29 -> 222
    //   254: astore 11
    //   256: aload 9
    //   258: astore 10
    //   260: aload_0
    //   261: astore 9
    //   263: aload 10
    //   265: astore_0
    //   266: aload 11
    //   268: astore 10
    //   270: ldc 15
    //   272: ldc_w 402
    //   275: aload 10
    //   277: invokestatic 332	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   280: pop
    //   281: aload_1
    //   282: iconst_0
    //   283: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   286: aload 9
    //   288: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   291: aload_0
    //   292: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   295: iconst_0
    //   296: ireturn
    //   297: aload_0
    //   298: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   301: aload 9
    //   303: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   306: iconst_1
    //   307: ireturn
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_0
    //   311: aload 10
    //   313: astore 9
    //   315: aload_0
    //   316: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   319: aload 9
    //   321: invokestatic 258	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   324: aload_1
    //   325: athrow
    //   326: astore_1
    //   327: aload 10
    //   329: astore 9
    //   331: goto -16 -> 315
    //   334: astore_1
    //   335: goto -20 -> 315
    //   338: astore_1
    //   339: aload_0
    //   340: astore 10
    //   342: aload 9
    //   344: astore_0
    //   345: aload 10
    //   347: astore 9
    //   349: goto -34 -> 315
    //   352: astore 10
    //   354: aconst_null
    //   355: astore_0
    //   356: goto -86 -> 270
    //   359: astore 10
    //   361: aload_0
    //   362: astore 9
    //   364: aconst_null
    //   365: astore_0
    //   366: goto -96 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	paramFile1	File
    //   0	369	1	paramFile2	File
    //   27	88	2	bool	boolean
    //   157	41	3	l1	long
    //   172	4	5	l2	long
    //   191	4	7	l3	long
    //   4	359	9	localObject1	Object
    //   1	1	10	localObject2	Object
    //   212	1	10	localThrowable1	Throwable
    //   220	126	10	localObject3	Object
    //   352	1	10	localThrowable2	Throwable
    //   359	1	10	localThrowable3	Throwable
    //   84	25	11	localFile	File
    //   254	13	11	localThrowable4	Throwable
    // Exception table:
    //   from	to	target	type
    //   168	174	212	java/lang/Throwable
    //   181	193	212	java/lang/Throwable
    //   153	158	254	java/lang/Throwable
    //   214	222	254	java/lang/Throwable
    //   222	251	254	java/lang/Throwable
    //   16	28	308	finally
    //   42	61	308	finally
    //   75	80	308	finally
    //   80	100	308	finally
    //   100	114	308	finally
    //   128	140	308	finally
    //   140	153	326	finally
    //   153	158	334	finally
    //   168	174	334	finally
    //   181	193	334	finally
    //   214	222	334	finally
    //   222	251	334	finally
    //   270	286	338	finally
    //   16	28	352	java/lang/Throwable
    //   42	61	352	java/lang/Throwable
    //   75	80	352	java/lang/Throwable
    //   80	100	352	java/lang/Throwable
    //   100	114	352	java/lang/Throwable
    //   128	140	352	java/lang/Throwable
    //   140	153	359	java/lang/Throwable
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
    MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { paramFile.getAbsolutePath() }, null, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weiyun.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */