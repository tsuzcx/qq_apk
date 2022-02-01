package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

@SuppressLint({"NewApi"})
public class FileUtil
{
  public static String a;
  public static final FileUtil.a b = new FileUtil.2();
  private static final int c = 4;
  private static RandomAccessFile d;
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream == null) {
      return -1L;
    }
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l = 0L;; l += i)
    {
      i = paramInputStream.read(arrayOfByte);
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    return l;
  }
  
  public static File a(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), "tbs");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite()) {
      paramContext = "getPermanentTbsFile -- no permission!";
    }
    for (;;)
    {
      TbsLog.e("FileHelper", paramContext);
      return null;
      paramContext = new File(paramContext, paramString);
      if (paramContext.exists()) {
        break;
      }
      try
      {
        paramContext.createNewFile();
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramString = new StringBuilder();
        paramString.append("getPermanentTbsFile -- exception: ");
        paramString.append(paramContext);
        paramContext = paramString.toString();
      }
    }
    return paramContext;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      paramContext = d(paramContext);
    } else {
      paramContext = c(paramContext);
    }
    if (paramContext == null) {
      return null;
    }
    paramContext = new File(paramContext);
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite()) {
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {
      try
      {
        paramContext.createNewFile();
        return paramContext;
      }
      catch (IOException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return paramContext;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramContext == null) {
      return "";
    }
    String str;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(Environment.getExternalStorageDirectory());
      ((StringBuilder)localObject1).append(File.separator);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      str = "";
    }
    switch (paramInt)
    {
    default: 
      return "";
    case 8: 
      return b(paramContext, "env");
    case 7: 
      if (str.equals("")) {
        return str;
      }
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append("backup");
      paramContext.append(File.separator);
      paramContext.append("core");
      return paramContext.toString();
    case 6: 
      paramString = a;
      if (paramString != null) {
        return paramString;
      }
      a = b(paramContext, "tbslog");
      return a;
    case 5: 
      if (str.equals("")) {
        return str;
      }
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    case 4: 
      if (str.equals("")) {
        return b(paramContext, "backup");
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("tencent");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("tbs");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("backup");
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(paramString);
      str = ((StringBuilder)localObject2).toString();
      paramString = str;
      if (paramBoolean)
      {
        localObject2 = new File(str);
        if (((File)localObject2).exists())
        {
          paramString = str;
          if (((File)localObject2).canWrite()) {}
        }
        else if (!((File)localObject2).exists())
        {
          ((File)localObject2).mkdirs();
          paramString = str;
          if (!((File)localObject2).canWrite()) {
            return b(paramContext, "backup");
          }
        }
        else
        {
          paramString = b(paramContext, "backup");
        }
      }
      return paramString;
    case 3: 
      if (str.equals("")) {
        return str;
      }
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("tencent");
      paramContext.append(File.separator);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append("backup");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    case 2: 
      if (str.equals("")) {
        return str;
      }
      paramContext = new StringBuilder();
      paramContext.append(str);
      paramContext.append("tbs");
      paramContext.append(File.separator);
      paramContext.append("backup");
      paramContext.append(File.separator);
      paramContext.append(paramString);
      return paramContext.toString();
    }
    if (str.equals("")) {
      return str;
    }
    paramContext = new StringBuilder();
    paramContext.append(str);
    paramContext.append("tencent");
    paramContext.append(File.separator);
    paramContext.append("tbs");
    paramContext.append(File.separator);
    paramContext.append(paramString);
    return paramContext.toString();
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {
      return null;
    }
    try
    {
      paramContext = paramFileOutputStream.getChannel().tryLock();
      boolean bool = paramContext.isValid();
      if (bool) {
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (OverlappingFileLockException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext, FileLock paramFileLock)
  {
    try
    {
      paramContext = new StringBuilder();
      paramContext.append("releaseTbsCoreRenameFileLock -- lock: ");
      paramContext.append(paramFileLock);
      TbsLog.i("FileHelper", paramContext.toString());
      paramContext = paramFileLock.channel();
      if (paramContext != null)
      {
        boolean bool = paramContext.isOpen();
        if (bool) {
          try
          {
            paramFileLock.release();
          }
          catch (IOException paramContext)
          {
            paramContext.printStackTrace();
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    a(paramFile, paramBoolean, false);
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete file,ignore=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append("except");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(Log.getStackTraceString(new Throwable()));
    TbsLog.i("FileUtils", ((StringBuilder)localObject).toString());
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return;
      }
      if (paramFile.isFile())
      {
        paramFile.delete();
        return;
      }
      localObject = paramFile.listFiles();
      if (localObject == null) {
        return;
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        File localFile = localObject[i];
        if (!localFile.getName().equals(paramString)) {
          a(localFile, paramBoolean);
        }
        i += 1;
      }
      if (!paramBoolean) {
        paramFile.delete();
      }
    }
  }
  
  public static void a(File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("delete file,ignore=");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append("isSoftLink=");
    ((StringBuilder)localObject).append(paramBoolean2);
    TbsLog.i("FileUtils", ((StringBuilder)localObject).toString());
    if (paramFile == null) {
      return;
    }
    if ((!paramBoolean2) && (!paramFile.exists())) {
      return;
    }
    if (((paramBoolean2) && (!paramFile.isDirectory())) || (paramFile.isFile()))
    {
      paramFile.delete();
      return;
    }
    localObject = paramFile.listFiles();
    if (localObject == null) {
      return;
    }
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      a(localObject[i], paramBoolean1, paramBoolean2);
      i += 1;
    }
    if (!paramBoolean1) {
      paramFile.delete();
    }
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {
      try
      {
        FileChannel localFileChannel = paramFileLock.channel();
        if ((localFileChannel != null) && (localFileChannel.isOpen())) {
          paramFileLock.release();
        }
      }
      catch (Exception paramFileLock)
      {
        paramFileLock.printStackTrace();
      }
    }
    if (paramFileOutputStream != null) {
      try
      {
        paramFileOutputStream.close();
        return;
      }
      catch (Exception paramFileLock)
      {
        paramFileLock.printStackTrace();
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return true;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean a(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    b(paramFile);
    return paramFile.mkdirs();
  }
  
  public static boolean a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.getPath(), paramFile2.getPath());
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return a(paramFile1, paramFile2, paramFileFilter, b);
  }
  
  public static boolean a(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtil.a parama)
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
        return b(paramFile1, paramFile2, paramFileFilter, parama);
      }
      paramFile1 = paramFile1.listFiles(paramFileFilter);
      if (paramFile1 == null) {
        return false;
      }
      int j = paramFile1.length;
      int i = 0;
      boolean bool = true;
      while (i < j)
      {
        parama = paramFile1[i];
        if (!a(parama, new File(paramFile2, parama.getName()), paramFileFilter)) {
          bool = false;
        }
        i += 1;
      }
      return bool;
    }
    return false;
  }
  
  /* Error */
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: new 47	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 285	java/io/File:length	()J
    //   13: lload_1
    //   14: lcmp
    //   15: ifeq +59 -> 74
    //   18: new 83	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   25: astore 8
    //   27: aload 8
    //   29: ldc_w 287
    //   32: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 8
    //   38: aload_0
    //   39: invokevirtual 285	java/io/File:length	()J
    //   42: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 8
    //   48: ldc_w 292
    //   51: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 8
    //   57: lload_1
    //   58: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 72
    //   64: aload 8
    //   66: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 78	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_1
    //   73: ireturn
    //   74: new 294	java/io/FileInputStream
    //   77: dup
    //   78: aload_0
    //   79: invokespecial 296	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   82: astore 8
    //   84: new 298	java/util/zip/CRC32
    //   87: dup
    //   88: invokespecial 299	java/util/zip/CRC32:<init>	()V
    //   91: astore 9
    //   93: sipush 8192
    //   96: newarray byte
    //   98: astore 10
    //   100: aload 8
    //   102: aload 10
    //   104: invokevirtual 300	java/io/FileInputStream:read	([B)I
    //   107: istore 7
    //   109: iload 7
    //   111: ifle +16 -> 127
    //   114: aload 9
    //   116: aload 10
    //   118: iconst_0
    //   119: iload 7
    //   121: invokevirtual 303	java/util/zip/CRC32:update	([BII)V
    //   124: goto -24 -> 100
    //   127: aload 9
    //   129: invokevirtual 306	java/util/zip/CRC32:getValue	()J
    //   132: lstore_1
    //   133: new 83	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   140: astore 9
    //   142: aload 9
    //   144: ldc 126
    //   146: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 9
    //   152: aload_0
    //   153: invokevirtual 228	java/io/File:getName	()Ljava/lang/String;
    //   156: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 9
    //   162: ldc_w 308
    //   165: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 9
    //   171: lload_1
    //   172: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 9
    //   178: ldc_w 310
    //   181: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 9
    //   187: lload 5
    //   189: invokevirtual 290	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 72
    //   195: aload 9
    //   197: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokestatic 183	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: lload_1
    //   204: lload 5
    //   206: lcmp
    //   207: ifeq +10 -> 217
    //   210: aload 8
    //   212: invokevirtual 311	java/io/FileInputStream:close	()V
    //   215: iconst_1
    //   216: ireturn
    //   217: aload 8
    //   219: invokevirtual 311	java/io/FileInputStream:close	()V
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_0
    //   225: goto +7 -> 232
    //   228: astore_0
    //   229: aconst_null
    //   230: astore 8
    //   232: aload 8
    //   234: ifnull +8 -> 242
    //   237: aload 8
    //   239: invokevirtual 311	java/io/FileInputStream:close	()V
    //   242: goto +5 -> 247
    //   245: aload_0
    //   246: athrow
    //   247: goto -2 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	250	0	paramString	String
    //   0	250	1	paramLong1	long
    //   0	250	3	paramLong2	long
    //   0	250	5	paramLong3	long
    //   107	13	7	i	int
    //   25	213	8	localObject1	Object
    //   91	105	9	localObject2	Object
    //   98	19	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   84	100	224	finally
    //   100	109	224	finally
    //   114	124	224	finally
    //   127	203	224	finally
    //   74	84	228	finally
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    String str1;
    if (Build.VERSION.SDK_INT >= 8) {
      str1 = Build.CPU_ABI2;
    } else {
      str1 = null;
    }
    return a(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, FileUtil.b paramb)
  {
    // Byte code:
    //   0: new 337	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 338	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 342	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   13: astore 10
    //   15: iconst_0
    //   16: istore 6
    //   18: iconst_0
    //   19: istore 5
    //   21: aload 10
    //   23: invokeinterface 347 1 0
    //   28: ifeq +347 -> 375
    //   31: aload 10
    //   33: invokeinterface 351 1 0
    //   38: checkcast 353	java/util/zip/ZipEntry
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 354	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnonnull +6 -> 58
    //   55: goto -34 -> 21
    //   58: aload 13
    //   60: ldc_w 356
    //   63: invokevirtual 360	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +6 -> 72
    //   69: goto -48 -> 21
    //   72: aload 13
    //   74: ldc_w 362
    //   77: invokevirtual 366	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   80: ifne +17 -> 97
    //   83: aload 13
    //   85: ldc_w 368
    //   88: invokevirtual 366	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   91: ifne +6 -> 97
    //   94: goto -73 -> 21
    //   97: aload 13
    //   99: aload 13
    //   101: bipush 47
    //   103: invokevirtual 372	java/lang/String:lastIndexOf	(I)I
    //   106: invokevirtual 376	java/lang/String:substring	(I)Ljava/lang/String;
    //   109: astore 12
    //   111: iload 6
    //   113: istore 7
    //   115: iload 5
    //   117: istore 8
    //   119: aload 12
    //   121: ldc_w 378
    //   124: invokevirtual 381	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   127: ifeq +158 -> 285
    //   130: aload 13
    //   132: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   135: aload_1
    //   136: iconst_0
    //   137: aload_1
    //   138: invokevirtual 386	java/lang/String:length	()I
    //   141: invokevirtual 390	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   144: ifeq +31 -> 175
    //   147: aload 13
    //   149: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   152: aload_1
    //   153: invokevirtual 386	java/lang/String:length	()I
    //   156: iadd
    //   157: invokevirtual 394	java/lang/String:charAt	(I)C
    //   160: bipush 47
    //   162: if_icmpne +13 -> 175
    //   165: iconst_1
    //   166: istore 7
    //   168: iload 5
    //   170: istore 8
    //   172: goto +113 -> 285
    //   175: aload_2
    //   176: ifnull +49 -> 225
    //   179: aload 13
    //   181: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   184: aload_2
    //   185: iconst_0
    //   186: aload_2
    //   187: invokevirtual 386	java/lang/String:length	()I
    //   190: invokevirtual 390	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   193: ifeq +32 -> 225
    //   196: aload 13
    //   198: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   201: aload_2
    //   202: invokevirtual 386	java/lang/String:length	()I
    //   205: iadd
    //   206: invokevirtual 394	java/lang/String:charAt	(I)C
    //   209: bipush 47
    //   211: if_icmpne +14 -> 225
    //   214: iload 6
    //   216: ifeq +188 -> 404
    //   219: iconst_1
    //   220: istore 5
    //   222: goto -201 -> 21
    //   225: aload_3
    //   226: ifnull -205 -> 21
    //   229: aload 13
    //   231: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   234: aload_3
    //   235: iconst_0
    //   236: aload_3
    //   237: invokevirtual 386	java/lang/String:length	()I
    //   240: invokevirtual 390	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   243: ifeq -222 -> 21
    //   246: aload 13
    //   248: getstatic 383	com/tencent/smtt/utils/FileUtil:c	I
    //   251: aload_3
    //   252: invokevirtual 386	java/lang/String:length	()I
    //   255: iadd
    //   256: invokevirtual 394	java/lang/String:charAt	(I)C
    //   259: bipush 47
    //   261: if_icmpne -240 -> 21
    //   264: iload 6
    //   266: ifne -245 -> 21
    //   269: iload 6
    //   271: istore 7
    //   273: iload 5
    //   275: istore 8
    //   277: iload 5
    //   279: ifeq +6 -> 285
    //   282: goto -261 -> 21
    //   285: aload_0
    //   286: aload 11
    //   288: invokevirtual 398	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   291: astore 13
    //   293: aload 4
    //   295: aload 13
    //   297: aload 11
    //   299: aload 12
    //   301: iconst_1
    //   302: invokevirtual 376	java/lang/String:substring	(I)Ljava/lang/String;
    //   305: invokeinterface 403 4 0
    //   310: istore 9
    //   312: iload 9
    //   314: ifne +19 -> 333
    //   317: aload 13
    //   319: ifnull +8 -> 327
    //   322: aload 13
    //   324: invokevirtual 404	java/io/InputStream:close	()V
    //   327: aload_0
    //   328: invokevirtual 405	java/util/zip/ZipFile:close	()V
    //   331: iconst_0
    //   332: ireturn
    //   333: iload 7
    //   335: istore 6
    //   337: iload 8
    //   339: istore 5
    //   341: aload 13
    //   343: ifnull -322 -> 21
    //   346: aload 13
    //   348: invokevirtual 404	java/io/InputStream:close	()V
    //   351: iload 7
    //   353: istore 6
    //   355: iload 8
    //   357: istore 5
    //   359: goto -338 -> 21
    //   362: astore_1
    //   363: aload 13
    //   365: ifnull +8 -> 373
    //   368: aload 13
    //   370: invokevirtual 404	java/io/InputStream:close	()V
    //   373: aload_1
    //   374: athrow
    //   375: aload_0
    //   376: invokevirtual 405	java/util/zip/ZipFile:close	()V
    //   379: iconst_1
    //   380: ireturn
    //   381: astore_1
    //   382: goto +6 -> 388
    //   385: astore_1
    //   386: aconst_null
    //   387: astore_0
    //   388: aload_0
    //   389: ifnull +7 -> 396
    //   392: aload_0
    //   393: invokevirtual 405	java/util/zip/ZipFile:close	()V
    //   396: goto +5 -> 401
    //   399: aload_1
    //   400: athrow
    //   401: goto -2 -> 399
    //   404: iconst_1
    //   405: istore 8
    //   407: iload 6
    //   409: istore 7
    //   411: goto -126 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	414	0	paramString1	String
    //   0	414	1	paramString2	String
    //   0	414	2	paramString3	String
    //   0	414	3	paramString4	String
    //   0	414	4	paramb	FileUtil.b
    //   19	339	5	i	int
    //   16	392	6	j	int
    //   113	297	7	k	int
    //   117	289	8	m	int
    //   310	3	9	bool	boolean
    //   13	19	10	localEnumeration	java.util.Enumeration
    //   41	257	11	localZipEntry	java.util.zip.ZipEntry
    //   109	191	12	str	String
    //   48	321	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   293	312	362	finally
    //   9	15	381	finally
    //   21	50	381	finally
    //   58	69	381	finally
    //   72	94	381	finally
    //   97	111	381	finally
    //   119	165	381	finally
    //   179	214	381	finally
    //   229	264	381	finally
    //   285	293	381	finally
    //   322	327	381	finally
    //   346	351	381	finally
    //   368	373	381	finally
    //   373	375	381	finally
    //   0	9	385	finally
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return a(paramString1, paramString3, paramString4, paramString5, new FileUtil.1(paramString2));
  }
  
  public static FileOutputStream b(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = a(paramContext, paramBoolean, paramString);
    if (paramContext != null) {
      try
      {
        paramContext = new FileOutputStream(paramContext);
        return paramContext;
      }
      catch (FileNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  private static String b(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return "";
    }
    Object localObject = paramContext.getApplicationContext();
    if (localObject != null) {
      paramContext = (Context)localObject;
    }
    try
    {
      localObject = paramContext.getExternalFilesDir(paramString).getAbsolutePath();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(Environment.getExternalStorageDirectory());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("Android");
        localStringBuilder.append(File.separator);
        localStringBuilder.append("data");
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramContext.getApplicationInfo().packageName);
        localStringBuilder.append(File.separator);
        localStringBuilder.append("files");
        localStringBuilder.append(File.separator);
        localStringBuilder.append(paramString);
        paramContext = localStringBuilder.toString();
        return paramContext;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static void b(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static boolean b(Context paramContext)
  {
    long l = q.a();
    boolean bool;
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool)
    {
      paramContext = new StringBuilder();
      paramContext.append("[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = ");
      paramContext.append(l);
      TbsLog.e("TbsDownload", paramContext.toString());
    }
    return bool;
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, null);
  }
  
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtil.a parama)
  {
    if (paramFile1 != null)
    {
      if (paramFile2 == null) {
        return false;
      }
      if ((paramFileFilter != null) && (!paramFileFilter.accept(paramFile1))) {
        return false;
      }
      paramFileFilter = null;
      Object localObject = null;
      try
      {
        if (paramFile1.exists())
        {
          if (!paramFile1.isFile()) {
            return false;
          }
          if (paramFile2.exists())
          {
            if ((parama != null) && (parama.a(paramFile1, paramFile2))) {
              return true;
            }
            b(paramFile2);
          }
          parama = paramFile2.getParentFile();
          if (parama.isFile()) {
            b(parama);
          }
          if ((!parama.exists()) && (!parama.mkdirs())) {
            return false;
          }
          parama = new FileInputStream(paramFile1).getChannel();
          paramFile1 = localObject;
          try
          {
            paramFileFilter = new FileOutputStream(paramFile2).getChannel();
            paramFile1 = paramFileFilter;
            long l = parama.size();
            paramFile1 = paramFileFilter;
            if (paramFileFilter.transferFrom(parama, 0L, l) != l)
            {
              paramFile1 = paramFileFilter;
              b(paramFile2);
              if (parama != null) {
                parama.close();
              }
              if (paramFileFilter != null) {
                paramFileFilter.close();
              }
              return false;
            }
            if (parama != null) {
              parama.close();
            }
            if (paramFileFilter != null) {
              paramFileFilter.close();
            }
            return true;
          }
          finally
          {
            paramFile2 = parama;
            parama = paramFile1;
            paramFile1 = paramFileFilter;
            paramFileFilter = parama;
            break label221;
          }
        }
        return false;
      }
      finally
      {
        parama = null;
        paramFile2 = paramFileFilter;
        paramFileFilter = parama;
        label221:
        if (paramFile2 != null) {
          paramFile2.close();
        }
        if (paramFileFilter != null) {
          paramFileFilter.close();
        }
      }
    }
    return false;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(InputStream paramInputStream, java.util.zip.ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 47	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 471	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 83	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   19: astore 5
    //   21: aload 5
    //   23: aload_2
    //   24: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload 5
    //   30: getstatic 134	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: aload_3
    //   40: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 5
    //   46: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: astore 7
    //   51: new 47	java/io/File
    //   54: dup
    //   55: aload 7
    //   57: invokespecial 106	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 6
    //   62: aconst_null
    //   63: astore 5
    //   65: aconst_null
    //   66: astore_2
    //   67: new 161	java/io/FileOutputStream
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 416	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   76: astore_3
    //   77: sipush 8192
    //   80: newarray byte
    //   82: astore_2
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 36	java/io/InputStream:read	([B)I
    //   88: istore 4
    //   90: iload 4
    //   92: ifle +14 -> 106
    //   95: aload_3
    //   96: aload_2
    //   97: iconst_0
    //   98: iload 4
    //   100: invokevirtual 472	java/io/FileOutputStream:write	([BII)V
    //   103: goto -20 -> 83
    //   106: aload_3
    //   107: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   110: aload 7
    //   112: aload_1
    //   113: invokevirtual 475	java/util/zip/ZipEntry:getSize	()J
    //   116: aload_1
    //   117: invokevirtual 478	java/util/zip/ZipEntry:getTime	()J
    //   120: aload_1
    //   121: invokevirtual 481	java/util/zip/ZipEntry:getCrc	()J
    //   124: invokestatic 483	com/tencent/smtt/utils/FileUtil:a	(Ljava/lang/String;JJJ)Z
    //   127: ifeq +37 -> 164
    //   130: new 83	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   137: astore_0
    //   138: aload_0
    //   139: ldc_w 485
    //   142: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_0
    //   147: aload 7
    //   149: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 72
    //   155: aload_0
    //   156: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 78	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: iconst_0
    //   163: ireturn
    //   164: aload 6
    //   166: aload_1
    //   167: invokevirtual 478	java/util/zip/ZipEntry:getTime	()J
    //   170: invokevirtual 489	java/io/File:setLastModified	(J)Z
    //   173: ifne +35 -> 208
    //   176: new 83	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   183: astore_0
    //   184: aload_0
    //   185: ldc_w 491
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_0
    //   193: aload 6
    //   195: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: ldc 72
    //   201: aload_0
    //   202: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 78	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: iconst_1
    //   209: ireturn
    //   210: astore_0
    //   211: aload_3
    //   212: astore_2
    //   213: goto +68 -> 281
    //   216: astore_1
    //   217: aload_3
    //   218: astore_0
    //   219: goto +11 -> 230
    //   222: astore_0
    //   223: goto +58 -> 281
    //   226: astore_1
    //   227: aload 5
    //   229: astore_0
    //   230: aload_0
    //   231: astore_2
    //   232: aload 6
    //   234: invokestatic 259	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   237: aload_0
    //   238: astore_2
    //   239: new 83	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   246: astore_3
    //   247: aload_0
    //   248: astore_2
    //   249: aload_3
    //   250: ldc_w 493
    //   253: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_0
    //   258: astore_2
    //   259: aload_3
    //   260: aload 6
    //   262: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload_0
    //   267: astore_2
    //   268: new 45	java/io/IOException
    //   271: dup
    //   272: aload_3
    //   273: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload_1
    //   277: invokespecial 496	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   280: athrow
    //   281: aload_2
    //   282: ifnull +7 -> 289
    //   285: aload_2
    //   286: invokevirtual 239	java/io/FileOutputStream:close	()V
    //   289: goto +5 -> 294
    //   292: aload_0
    //   293: athrow
    //   294: goto -2 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	paramInputStream	InputStream
    //   0	297	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	297	2	paramString1	String
    //   0	297	3	paramString2	String
    //   88	11	4	i	int
    //   19	209	5	localStringBuilder	StringBuilder
    //   60	201	6	localFile	File
    //   49	99	7	str	String
    // Exception table:
    //   from	to	target	type
    //   77	83	210	finally
    //   83	90	210	finally
    //   95	103	210	finally
    //   77	83	216	java/io/IOException
    //   83	90	216	java/io/IOException
    //   95	103	216	java/io/IOException
    //   67	77	222	finally
    //   232	237	222	finally
    //   239	247	222	finally
    //   249	257	222	finally
    //   259	266	222	finally
    //   268	281	222	finally
    //   67	77	226	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    paramContext = new StringBuilder();
    paramContext.append(Environment.getExternalStorageDirectory());
    paramContext.append(File.separator);
    paramContext.append("tbs");
    paramContext.append(File.separator);
    paramContext.append("file_locks");
    return paramContext.toString();
  }
  
  public static boolean c(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = a(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  public static FileOutputStream d(File paramFile)
  {
    Object localObject;
    if (paramFile.exists())
    {
      if (!paramFile.isDirectory())
      {
        if (!paramFile.canWrite())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("File '");
          ((StringBuilder)localObject).append(paramFile);
          ((StringBuilder)localObject).append("' cannot be written to");
          throw new IOException(((StringBuilder)localObject).toString());
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' exists but is a directory");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = paramFile.getParentFile();
      if ((localObject != null) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("File '");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append("' could not be created");
        throw new IOException(((StringBuilder)localObject).toString());
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  static String d(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((!paramContext.isDirectory()) && (!paramContext.mkdir())) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock e(Context paramContext)
  {
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
    Object localObject1 = a(paramContext, "tbs_rename_lock");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getTbsCoreLoadFileLock #4 ");
    ((StringBuilder)localObject2).append(localObject1);
    TbsLog.i("FileHelper", ((StringBuilder)localObject2).toString());
    StringBuilder localStringBuilder;
    try
    {
      d = new RandomAccessFile(((File)localObject1).getAbsolutePath(), "r");
      localObject1 = d.getChannel().tryLock(0L, 9223372036854775807L, true);
    }
    catch (Throwable localThrowable)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getTbsCoreLoadFileLock -- exception: ");
      ((StringBuilder)localObject2).append(localThrowable);
      TbsLog.e("FileHelper", ((StringBuilder)localObject2).toString());
      localStringBuilder = null;
    }
    localObject2 = localStringBuilder;
    if (localStringBuilder == null) {
      localObject2 = g(paramContext);
    }
    if (localObject2 == null)
    {
      localStringBuilder = new StringBuilder();
      paramContext = "getTbsCoreLoadFileLock -- failed: ";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      paramContext = "getTbsCoreLoadFileLock -- success: ";
    }
    localStringBuilder.append(paramContext);
    localStringBuilder.append("tbs_rename_lock");
    TbsLog.i("FileHelper", localStringBuilder.toString());
    return localObject2;
  }
  
  public static FileLock f(Context paramContext)
  {
    paramContext = a(paramContext, "tbs_rename_lock");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTbsCoreRenameFileLock #1 ");
    localStringBuilder.append(paramContext);
    TbsLog.i("FileHelper", localStringBuilder.toString());
    try
    {
      d = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      paramContext = d.getChannel().tryLock(0L, 9223372036854775807L, false);
    }
    catch (Throwable paramContext)
    {
      label74:
      String str;
      break label74;
    }
    paramContext = new StringBuilder();
    paramContext.append("getTbsCoreRenameFileLock -- excpetion: ");
    paramContext.append("tbs_rename_lock");
    TbsLog.e("FileHelper", paramContext.toString());
    paramContext = null;
    if (paramContext == null)
    {
      localStringBuilder = new StringBuilder();
      str = "getTbsCoreRenameFileLock -- failed: ";
    }
    else
    {
      localStringBuilder = new StringBuilder();
      str = "getTbsCoreRenameFileLock -- success: ";
    }
    localStringBuilder.append(str);
    localStringBuilder.append("tbs_rename_lock");
    TbsLog.i("FileHelper", localStringBuilder.toString());
    return paramContext;
  }
  
  private static FileLock g(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    for (;;)
    {
      try
      {
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        localTbsLogInfo.setErrorCode(803);
        localFile = a(paramContext, "tbs_rename_lock");
        bool = TbsDownloadConfig.getInstance(paramContext).getTbsCoreLoadRenameFileLockWaitEnable();
        if (bool)
        {
          bool = false;
          localObject1 = null;
          i = 0;
          if ((i >= 20) || (localObject1 != null)) {}
        }
      }
      catch (Exception localException1)
      {
        TbsLogReport.TbsLogInfo localTbsLogInfo;
        File localFile;
        boolean bool;
        int i;
        FileLock localFileLock;
        paramContext = localException3;
      }
      try
      {
        try
        {
          Thread.sleep(100L);
        }
        catch (Exception localException2) {}
      }
      catch (Throwable localThrowable)
      {
        Context localContext;
        continue;
      }
      try
      {
        localException2.printStackTrace();
        d = new RandomAccessFile(localFile.getAbsolutePath(), "r");
        localFileLock = d.getChannel().tryLock(0L, 9223372036854775807L, true);
        localObject1 = localFileLock;
        i += 1;
      }
      catch (Exception localException3)
      {
        paramContext = localObject1;
        localObject1 = localException3;
        break label221;
      }
    }
    if (localObject1 != null) {
      localTbsLogInfo.setErrorCode(802);
    } else {
      localTbsLogInfo.setErrorCode(801);
    }
    TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, localTbsLogInfo);
    paramContext = new StringBuilder();
    paramContext.append("getTbsCoreLoadFileLock,retry num=");
    paramContext.append(i);
    paramContext.append("success=");
    if (localObject1 == null) {
      bool = true;
    }
    paramContext.append(bool);
    TbsLog.i("FileHelper", paramContext.toString());
    return localObject1;
    label221:
    localException1.printStackTrace();
    localContext = paramContext;
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */