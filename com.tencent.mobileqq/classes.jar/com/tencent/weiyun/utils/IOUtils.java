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
    if (paramFloat < 1024.0F)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.format("%.2f", new Object[] { Float.valueOf(paramFloat) }));
      localStringBuilder.append(countToUnit(paramInt));
      return localStringBuilder.toString();
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
    if (paramFile1 != null)
    {
      if (paramFile2 == null) {
        return false;
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
      int j = paramFile1.length;
      int i = 0;
      boolean bool = true;
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
    return false;
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
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (!paramFile.isDirectory())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        localObject = new File(((StringBuilder)localObject).toString());
        paramFile.renameTo((File)localObject);
        ((File)localObject).delete();
        return;
      }
      Object localObject = paramFile.listFiles();
      if (localObject == null) {
        return;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        deleteFile(localObject[i], paramBoolean);
        i += 1;
      }
      if (!paramBoolean)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
        ((StringBuilder)localObject).append(System.currentTimeMillis());
        localObject = new File(((StringBuilder)localObject).toString());
        paramFile.renameTo((File)localObject);
        ((File)localObject).delete();
      }
    }
  }
  
  public static String ensureFilePath(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = paramString1;
      if (!paramString1.endsWith(File.separator))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(File.separatorChar);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append(paramString2);
      for (paramString1 = new File(paramString1.toString()); paramString1.exists(); paramString1 = new File(paramString1.toString()))
      {
        paramString2 = performRename(paramString1.getName());
        if (TextUtils.isEmpty(paramString2)) {
          break;
        }
        paramString1 = new StringBuilder();
        paramString1.append((String)localObject);
        paramString1.append(paramString2);
      }
      return paramString1.getAbsolutePath();
    }
    return "";
  }
  
  public static boolean ensureStorageSpace(String paramString, long paramLong)
  {
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
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
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ensure storage space error for path:");
      ((StringBuilder)localObject2).append(paramString);
      Log.d("IOUtils", ((StringBuilder)localObject2).toString(), localThrowable);
    }
    if (l1 > paramLong) {
      bool1 = true;
    }
    return bool1;
  }
  
  /* Error */
  public static boolean ensureWritable(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload 5
    //   7: astore 4
    //   9: new 78	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 81	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 6
    //   19: aload 5
    //   21: astore 4
    //   23: aload 6
    //   25: invokevirtual 92	java/io/File:exists	()Z
    //   28: ifne +16 -> 44
    //   31: aload 5
    //   33: astore 4
    //   35: aload 6
    //   37: invokevirtual 200	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: goto +29 -> 70
    //   44: aload 5
    //   46: astore 4
    //   48: aload 6
    //   50: invokevirtual 125	java/io/File:isDirectory	()Z
    //   53: ifne +17 -> 70
    //   56: aload 5
    //   58: astore 4
    //   60: ldc 15
    //   62: ldc 202
    //   64: invokestatic 206	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   67: pop
    //   68: iconst_0
    //   69: ireturn
    //   70: aconst_null
    //   71: astore_3
    //   72: iconst_0
    //   73: istore_1
    //   74: new 27	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   81: astore 4
    //   83: aload 4
    //   85: invokestatic 134	java/lang/System:currentTimeMillis	()J
    //   88: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 4
    //   94: ldc 208
    //   96: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: new 78	java/io/File
    //   103: dup
    //   104: aload 6
    //   106: aload 4
    //   108: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 108	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   114: astore 4
    //   116: iload_1
    //   117: iconst_1
    //   118: iadd
    //   119: istore_1
    //   120: aload 4
    //   122: invokevirtual 92	java/io/File:exists	()Z
    //   125: ifeq +12 -> 137
    //   128: iload_1
    //   129: bipush 30
    //   131: if_icmplt +152 -> 283
    //   134: goto +3 -> 137
    //   137: aload 4
    //   139: invokevirtual 211	java/io/File:createNewFile	()Z
    //   142: istore_2
    //   143: aload 4
    //   145: invokevirtual 92	java/io/File:exists	()Z
    //   148: ifeq +9 -> 157
    //   151: aload 4
    //   153: invokevirtual 144	java/io/File:delete	()Z
    //   156: pop
    //   157: iload_2
    //   158: ireturn
    //   159: astore_0
    //   160: goto +96 -> 256
    //   163: astore 5
    //   165: aload 4
    //   167: astore_3
    //   168: goto +21 -> 189
    //   171: astore_0
    //   172: aload_3
    //   173: astore 4
    //   175: goto +81 -> 256
    //   178: astore 5
    //   180: goto +9 -> 189
    //   183: astore_0
    //   184: goto +72 -> 256
    //   187: astore 5
    //   189: aload_3
    //   190: astore 4
    //   192: new 27	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   199: astore 6
    //   201: aload_3
    //   202: astore 4
    //   204: aload 6
    //   206: ldc 213
    //   208: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_3
    //   213: astore 4
    //   215: aload 6
    //   217: aload_0
    //   218: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload_3
    //   223: astore 4
    //   225: ldc 15
    //   227: aload 6
    //   229: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: aload 5
    //   234: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   237: pop
    //   238: aload_3
    //   239: ifnull +15 -> 254
    //   242: aload_3
    //   243: invokevirtual 92	java/io/File:exists	()Z
    //   246: ifeq +8 -> 254
    //   249: aload_3
    //   250: invokevirtual 144	java/io/File:delete	()Z
    //   253: pop
    //   254: iconst_0
    //   255: ireturn
    //   256: aload 4
    //   258: ifnull +17 -> 275
    //   261: aload 4
    //   263: invokevirtual 92	java/io/File:exists	()Z
    //   266: ifeq +9 -> 275
    //   269: aload 4
    //   271: invokevirtual 144	java/io/File:delete	()Z
    //   274: pop
    //   275: goto +5 -> 280
    //   278: aload_0
    //   279: athrow
    //   280: goto -2 -> 278
    //   283: aload 4
    //   285: astore_3
    //   286: goto -212 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramString	String
    //   73	59	1	i	int
    //   142	16	2	bool	boolean
    //   1	285	3	localObject1	Object
    //   7	277	4	localObject2	Object
    //   3	54	5	localObject3	Object
    //   163	1	5	localThrowable1	Throwable
    //   178	1	5	localThrowable2	Throwable
    //   187	46	5	localThrowable3	Throwable
    //   17	211	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   120	128	159	finally
    //   137	143	159	finally
    //   120	128	163	java/lang/Throwable
    //   137	143	163	java/lang/Throwable
    //   74	116	171	finally
    //   74	116	178	java/lang/Throwable
    //   9	19	183	finally
    //   23	31	183	finally
    //   35	41	183	finally
    //   48	56	183	finally
    //   60	68	183	finally
    //   192	201	183	finally
    //   204	212	183	finally
    //   215	222	183	finally
    //   225	238	183	finally
    //   9	19	187	java/lang/Throwable
    //   23	31	187	java/lang/Throwable
    //   35	41	187	java/lang/Throwable
    //   48	56	187	java/lang/Throwable
    //   60	68	187	java/lang/Throwable
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
    //   0: new 232	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_3
    //   13: sipush 16384
    //   16: newarray byte
    //   18: astore 5
    //   20: aload 4
    //   22: astore_3
    //   23: ldc 235
    //   25: invokestatic 241	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore 6
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_m1
    //   34: if_icmpeq +37 -> 71
    //   37: aload 4
    //   39: astore_3
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 247	java/io/InputStream:read	([B)I
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
    //   63: invokevirtual 251	java/security/MessageDigest:update	([BII)V
    //   66: iload_2
    //   67: istore_1
    //   68: goto -36 -> 32
    //   71: aload 4
    //   73: astore_3
    //   74: aload 6
    //   76: invokevirtual 255	java/security/MessageDigest:digest	()[B
    //   79: invokestatic 261	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   82: invokevirtual 264	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   85: astore 5
    //   87: aload 4
    //   89: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   92: aload 5
    //   94: areturn
    //   95: astore 5
    //   97: goto +14 -> 111
    //   100: astore_0
    //   101: aconst_null
    //   102: astore_3
    //   103: goto +67 -> 170
    //   106: astore 5
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: astore_3
    //   114: new 27	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   121: astore 6
    //   123: aload 4
    //   125: astore_3
    //   126: aload 6
    //   128: ldc_w 268
    //   131: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 4
    //   137: astore_3
    //   138: aload 6
    //   140: aload_0
    //   141: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 4
    //   147: astore_3
    //   148: ldc 15
    //   150: aload 6
    //   152: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: aload 5
    //   157: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   160: pop
    //   161: aload 4
    //   163: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   166: ldc 24
    //   168: areturn
    //   169: astore_0
    //   170: aload_3
    //   171: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   174: goto +5 -> 179
    //   177: aload_0
    //   178: athrow
    //   179: goto -2 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString	String
    //   31	37	1	i	int
    //   47	20	2	j	int
    //   12	159	3	localFileInputStream1	java.io.FileInputStream
    //   8	154	4	localFileInputStream2	java.io.FileInputStream
    //   18	75	5	localObject1	Object
    //   95	1	5	localThrowable1	Throwable
    //   106	50	5	localThrowable2	Throwable
    //   28	123	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	20	95	java/lang/Throwable
    //   23	30	95	java/lang/Throwable
    //   40	48	95	java/lang/Throwable
    //   57	66	95	java/lang/Throwable
    //   74	87	95	java/lang/Throwable
    //   0	10	100	finally
    //   0	10	106	java/lang/Throwable
    //   13	20	169	finally
    //   23	30	169	finally
    //   40	48	169	finally
    //   57	66	169	finally
    //   74	87	169	finally
    //   114	123	169	finally
    //   126	135	169	finally
    //   138	145	169	finally
    //   148	161	169	finally
  }
  
  /* Error */
  public static String[] getFileSha1AndMd5(String paramString)
  {
    // Byte code:
    //   0: new 232	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 233	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore 4
    //   10: aload 4
    //   12: astore_3
    //   13: sipush 16384
    //   16: newarray byte
    //   18: astore 6
    //   20: aload 4
    //   22: astore_3
    //   23: ldc 235
    //   25: invokestatic 241	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore 7
    //   30: aload 4
    //   32: astore_3
    //   33: ldc_w 272
    //   36: invokestatic 241	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   39: astore 5
    //   41: iconst_0
    //   42: istore_1
    //   43: iload_1
    //   44: iconst_m1
    //   45: if_icmpeq +49 -> 94
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: aload 6
    //   55: invokevirtual 247	java/io/InputStream:read	([B)I
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
    //   74: invokevirtual 251	java/security/MessageDigest:update	([BII)V
    //   77: aload 4
    //   79: astore_3
    //   80: aload 5
    //   82: aload 6
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 251	java/security/MessageDigest:update	([BII)V
    //   89: iload_2
    //   90: istore_1
    //   91: goto -48 -> 43
    //   94: aload 4
    //   96: astore_3
    //   97: aload 7
    //   99: invokevirtual 255	java/security/MessageDigest:digest	()[B
    //   102: invokestatic 261	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   105: invokevirtual 264	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   108: astore 6
    //   110: aload 4
    //   112: astore_3
    //   113: aload 5
    //   115: invokevirtual 255	java/security/MessageDigest:digest	()[B
    //   118: invokestatic 261	com/tencent/weiyun/utils/Utils:bytes2HexStr	([B)Ljava/lang/String;
    //   121: invokevirtual 264	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   124: astore 5
    //   126: aload 4
    //   128: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   131: iconst_2
    //   132: anewarray 38	java/lang/String
    //   135: dup
    //   136: iconst_0
    //   137: aload 6
    //   139: aastore
    //   140: dup
    //   141: iconst_1
    //   142: aload 5
    //   144: aastore
    //   145: areturn
    //   146: astore 5
    //   148: goto +14 -> 162
    //   151: astore_0
    //   152: aconst_null
    //   153: astore_3
    //   154: goto +79 -> 233
    //   157: astore 5
    //   159: aconst_null
    //   160: astore 4
    //   162: aload 4
    //   164: astore_3
    //   165: new 27	java/lang/StringBuilder
    //   168: dup
    //   169: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   172: astore 6
    //   174: aload 4
    //   176: astore_3
    //   177: aload 6
    //   179: ldc_w 268
    //   182: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: astore_3
    //   189: aload 6
    //   191: aload_0
    //   192: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: ldc 15
    //   201: aload 6
    //   203: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: aload 5
    //   208: invokestatic 196	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   211: pop
    //   212: aload 4
    //   214: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   217: iconst_2
    //   218: anewarray 38	java/lang/String
    //   221: dup
    //   222: iconst_0
    //   223: ldc 24
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: ldc 24
    //   230: aastore
    //   231: areturn
    //   232: astore_0
    //   233: aload_3
    //   234: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   237: goto +5 -> 242
    //   240: aload_0
    //   241: athrow
    //   242: goto -2 -> 240
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	paramString	String
    //   42	49	1	i	int
    //   58	32	2	j	int
    //   12	222	3	localFileInputStream1	java.io.FileInputStream
    //   8	205	4	localFileInputStream2	java.io.FileInputStream
    //   39	104	5	localObject1	Object
    //   146	1	5	localThrowable1	Throwable
    //   157	50	5	localThrowable2	Throwable
    //   18	184	6	localObject2	Object
    //   28	70	7	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   13	20	146	java/lang/Throwable
    //   23	30	146	java/lang/Throwable
    //   33	41	146	java/lang/Throwable
    //   51	59	146	java/lang/Throwable
    //   68	77	146	java/lang/Throwable
    //   80	89	146	java/lang/Throwable
    //   97	110	146	java/lang/Throwable
    //   113	126	146	java/lang/Throwable
    //   0	10	151	finally
    //   0	10	157	java/lang/Throwable
    //   13	20	232	finally
    //   23	30	232	finally
    //   33	41	232	finally
    //   51	59	232	finally
    //   68	77	232	finally
    //   80	89	232	finally
    //   97	110	232	finally
    //   113	126	232	finally
    //   165	174	232	finally
    //   177	186	232	finally
    //   189	196	232	finally
    //   199	212	232	finally
  }
  
  public static long getFileSize(File paramFile)
  {
    long l1 = 0L;
    long l2 = l1;
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return 0L;
      }
      if (paramFile.isFile()) {
        return paramFile.length();
      }
      paramFile = paramFile.listFiles();
      if (paramFile == null) {
        return 0L;
      }
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
    return l2;
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
    boolean bool2 = TextUtils.isEmpty(paramString);
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (new File(paramString).lastModified() != paramLong) {
      bool1 = true;
    }
    return bool1;
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
    //   1: ifnull +424 -> 425
    //   4: aload_1
    //   5: ifnonnull +5 -> 10
    //   8: iconst_0
    //   9: ireturn
    //   10: aconst_null
    //   11: astore 13
    //   13: aconst_null
    //   14: astore 12
    //   16: aconst_null
    //   17: astore 10
    //   19: aconst_null
    //   20: astore 9
    //   22: aconst_null
    //   23: astore 11
    //   25: aload_0
    //   26: invokevirtual 92	java/io/File:exists	()Z
    //   29: ifeq +315 -> 344
    //   32: aload_0
    //   33: invokevirtual 95	java/io/File:isFile	()Z
    //   36: ifne +6 -> 42
    //   39: goto +305 -> 344
    //   42: aload_1
    //   43: invokevirtual 92	java/io/File:exists	()Z
    //   46: ifeq +39 -> 85
    //   49: aload_0
    //   50: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 128	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokestatic 355	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   60: istore_2
    //   61: iload_2
    //   62: ifeq +18 -> 80
    //   65: aconst_null
    //   66: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   69: aload 11
    //   71: astore 9
    //   73: aload 9
    //   75: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   78: iconst_1
    //   79: ireturn
    //   80: aload_1
    //   81: iconst_0
    //   82: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   85: aload_1
    //   86: invokevirtual 178	java/io/File:getParentFile	()Ljava/io/File;
    //   89: astore 11
    //   91: aload 11
    //   93: invokevirtual 95	java/io/File:isFile	()Z
    //   96: ifeq +9 -> 105
    //   99: aload 11
    //   101: iconst_0
    //   102: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   105: aload 11
    //   107: invokevirtual 92	java/io/File:exists	()Z
    //   110: ifne +23 -> 133
    //   113: aload 11
    //   115: invokevirtual 200	java/io/File:mkdirs	()Z
    //   118: istore_2
    //   119: iload_2
    //   120: ifne +13 -> 133
    //   123: aconst_null
    //   124: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   127: aconst_null
    //   128: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   131: iconst_0
    //   132: ireturn
    //   133: new 232	java/io/FileInputStream
    //   136: dup
    //   137: aload_0
    //   138: invokespecial 358	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: invokevirtual 362	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   144: astore 11
    //   146: aload 13
    //   148: astore_0
    //   149: aload 12
    //   151: astore 10
    //   153: new 364	java/io/FileOutputStream
    //   156: dup
    //   157: aload_1
    //   158: invokespecial 365	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   161: invokevirtual 366	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   164: astore 9
    //   166: aload 9
    //   168: astore_0
    //   169: aload 9
    //   171: astore 10
    //   173: aload 11
    //   175: invokevirtual 371	java/nio/channels/FileChannel:size	()J
    //   178: lstore_3
    //   179: lload_3
    //   180: ldc2_w 372
    //   183: lcmp
    //   184: ifgt +54 -> 238
    //   187: aload 9
    //   189: astore_0
    //   190: aload 11
    //   192: invokevirtual 371	java/nio/channels/FileChannel:size	()J
    //   195: lstore 5
    //   197: lconst_0
    //   198: lstore_3
    //   199: lload_3
    //   200: lload 5
    //   202: lcmp
    //   203: ifge +27 -> 230
    //   206: aload 9
    //   208: astore_0
    //   209: aload 9
    //   211: aload 11
    //   213: lload_3
    //   214: ldc2_w 7
    //   217: invokevirtual 377	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   220: lstore 7
    //   222: lload_3
    //   223: lload 7
    //   225: ladd
    //   226: lstore_3
    //   227: goto -28 -> 199
    //   230: aload 11
    //   232: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   235: goto -162 -> 73
    //   238: aload 9
    //   240: astore_0
    //   241: aload 9
    //   243: astore 10
    //   245: sipush 8192
    //   248: invokestatic 383	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   251: astore 12
    //   253: aload 9
    //   255: astore_0
    //   256: aload 9
    //   258: astore 10
    //   260: aload 11
    //   262: aload 12
    //   264: invokevirtual 386	java/nio/channels/FileChannel:read	(Ljava/nio/ByteBuffer;)I
    //   267: ifle -37 -> 230
    //   270: aload 9
    //   272: astore_0
    //   273: aload 9
    //   275: astore 10
    //   277: aload 12
    //   279: invokevirtual 390	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   282: pop
    //   283: aload 9
    //   285: astore_0
    //   286: aload 9
    //   288: astore 10
    //   290: aload 9
    //   292: aload 12
    //   294: invokevirtual 393	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
    //   297: pop
    //   298: aload 9
    //   300: astore_0
    //   301: aload 9
    //   303: astore 10
    //   305: aload 12
    //   307: invokevirtual 397	java/nio/ByteBuffer:compact	()Ljava/nio/ByteBuffer;
    //   310: pop
    //   311: goto -58 -> 253
    //   314: astore 10
    //   316: aload_0
    //   317: astore 9
    //   319: aload 11
    //   321: astore_1
    //   322: aload 10
    //   324: astore_0
    //   325: goto +89 -> 414
    //   328: astore 12
    //   330: aload 10
    //   332: astore 9
    //   334: aload 11
    //   336: astore_0
    //   337: aload 12
    //   339: astore 10
    //   341: goto +39 -> 380
    //   344: aconst_null
    //   345: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   348: aconst_null
    //   349: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   352: iconst_0
    //   353: ireturn
    //   354: astore_0
    //   355: aconst_null
    //   356: astore 10
    //   358: aload 9
    //   360: astore_1
    //   361: aload 10
    //   363: astore 9
    //   365: goto +49 -> 414
    //   368: astore 11
    //   370: aconst_null
    //   371: astore 9
    //   373: aload 10
    //   375: astore_0
    //   376: aload 11
    //   378: astore 10
    //   380: ldc 15
    //   382: ldc_w 399
    //   385: aload 10
    //   387: invokestatic 329	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   390: pop
    //   391: aload_1
    //   392: iconst_0
    //   393: invokestatic 146	com/tencent/weiyun/utils/IOUtils:deleteFile	(Ljava/io/File;Z)V
    //   396: aload_0
    //   397: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   400: aload 9
    //   402: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   405: iconst_0
    //   406: ireturn
    //   407: astore 10
    //   409: aload_0
    //   410: astore_1
    //   411: aload 10
    //   413: astore_0
    //   414: aload_1
    //   415: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   418: aload 9
    //   420: invokestatic 266	com/tencent/weiyun/utils/IOUtils:closeSilently	(Ljava/io/Closeable;)V
    //   423: aload_0
    //   424: athrow
    //   425: iconst_0
    //   426: ireturn
    //   427: astore_0
    //   428: goto -190 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	paramFile1	File
    //   0	431	1	paramFile2	File
    //   60	60	2	bool	boolean
    //   178	49	3	l1	long
    //   195	6	5	l2	long
    //   220	4	7	l3	long
    //   20	399	9	localObject1	Object
    //   17	287	10	localObject2	Object
    //   314	17	10	localObject3	Object
    //   339	47	10	localObject4	Object
    //   407	5	10	localObject5	Object
    //   23	312	11	localObject6	Object
    //   368	9	11	localThrowable1	Throwable
    //   14	292	12	localByteBuffer	java.nio.ByteBuffer
    //   328	10	12	localThrowable2	Throwable
    //   11	136	13	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   153	166	314	finally
    //   173	179	314	finally
    //   190	197	314	finally
    //   209	222	314	finally
    //   245	253	314	finally
    //   260	270	314	finally
    //   277	283	314	finally
    //   290	298	314	finally
    //   305	311	314	finally
    //   153	166	328	java/lang/Throwable
    //   173	179	328	java/lang/Throwable
    //   245	253	328	java/lang/Throwable
    //   260	270	328	java/lang/Throwable
    //   277	283	328	java/lang/Throwable
    //   290	298	328	java/lang/Throwable
    //   305	311	328	java/lang/Throwable
    //   25	39	354	finally
    //   42	61	354	finally
    //   80	85	354	finally
    //   85	105	354	finally
    //   105	119	354	finally
    //   133	146	354	finally
    //   25	39	368	java/lang/Throwable
    //   42	61	368	java/lang/Throwable
    //   80	85	368	java/lang/Throwable
    //   85	105	368	java/lang/Throwable
    //   105	119	368	java/lang/Throwable
    //   133	146	368	java/lang/Throwable
    //   380	396	407	finally
    //   190	197	427	java/lang/Throwable
    //   209	222	427	java/lang/Throwable
  }
  
  private static String performRename(String paramString)
  {
    Object localObject2 = "";
    Object localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    int i = ((String)localObject1).lastIndexOf('.');
    if (i == -1) {
      paramString = "";
    } else {
      paramString = ((String)localObject1).substring(i);
    }
    if (i == -1) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((String)localObject1).substring(0, i);
    }
    localObject2 = new StringBuilder();
    Object localObject3 = Pattern.compile("(^.+)(\\((\\d+)\\)$)").matcher((CharSequence)localObject1);
    if (((Matcher)localObject3).find())
    {
      localObject1 = ((Matcher)localObject3).group(1);
      localObject3 = ((Matcher)localObject3).group(3);
      try
      {
        i = Integer.parseInt((String)localObject3);
        if (2147483647 <= i) {
          break label180;
        }
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append('(');
        ((StringBuilder)localObject2).append(i + 1);
        ((StringBuilder)localObject2).append(')');
        ((StringBuilder)localObject2).append(paramString);
      }
      catch (Throwable paramString)
      {
        Log.e("IOUtils", "fail to rename", paramString);
      }
    }
    else
    {
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(1)");
      ((StringBuilder)localObject2).append(paramString);
    }
    label180:
    return ((StringBuilder)localObject2).toString();
  }
  
  public static void scan2MediaStore(Context paramContext, File paramFile)
  {
    MediaScannerConnection.scanFile(paramContext.getApplicationContext(), new String[] { paramFile.getAbsolutePath() }, null, null);
  }
  
  public static String spliceFilePath(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      Object localObject = paramString1;
      if (!paramString1.endsWith(File.separator))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(File.separatorChar);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append(paramString2);
      return paramString1.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */