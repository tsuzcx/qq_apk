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
import java.util.Enumeration;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

@SuppressLint({"NewApi"})
public class FileUtil
{
  public static String a;
  public static final FileUtil.a b = new FileUtil.2();
  private static final int c = "lib/".length();
  private static RandomAccessFile d;
  
  static
  {
    a = null;
    d = null;
  }
  
  public static long a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l2;
    if (paramInputStream == null)
    {
      l2 = -1L;
      return l2;
    }
    byte[] arrayOfByte = new byte[4096];
    int i;
    for (long l1 = 0L;; l1 += i)
    {
      i = paramInputStream.read(arrayOfByte);
      l2 = l1;
      if (-1 == i) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static File a(Context paramContext, String paramString)
  {
    paramContext = new File(paramContext.getFilesDir(), "tbs");
    if (paramContext == null) {
      return null;
    }
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    if (!paramContext.canWrite())
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- no permission!");
      return null;
    }
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      TbsLog.e("FileHelper", "getPermanentTbsFile -- exception: " + paramContext);
    }
    return null;
  }
  
  public static File a(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramContext = d(paramContext);
      if (paramContext != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return null;
      paramContext = c(paramContext);
      break;
      paramContext = new File(paramContext);
      if ((paramContext != null) && (!paramContext.exists())) {
        paramContext.mkdirs();
      }
    } while (!paramContext.canWrite());
    paramContext = new File(paramContext, paramString);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      return paramContext;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  public static String a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    String str;
    if (paramContext == null) {
      str = "";
    }
    Object localObject2;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    return str;
                    try
                    {
                      localObject2 = Environment.getExternalStorageDirectory() + File.separator;
                      switch (paramInt)
                      {
                      default: 
                        return "";
                      }
                    }
                    catch (Exception localException)
                    {
                      for (;;)
                      {
                        localException.printStackTrace();
                        localObject2 = "";
                      }
                      localObject1 = localObject2;
                    }
                  } while (((String)localObject2).equals(""));
                  return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
                  localObject1 = localObject2;
                } while (((String)localObject2).equals(""));
                return (String)localObject2 + "tbs" + File.separator + "backup" + File.separator + paramString;
                localObject1 = localObject2;
              } while (((String)localObject2).equals(""));
              return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
              if (((String)localObject2).equals("")) {
                return b(paramContext, "backup");
              }
              paramString = (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + paramString;
              localObject1 = paramString;
            } while (!paramBoolean);
            localObject2 = new File(paramString);
            if (!((File)localObject2).exists()) {
              break;
            }
            localObject1 = paramString;
          } while (((File)localObject2).canWrite());
          if (((File)localObject2).exists()) {
            break;
          }
          ((File)localObject2).mkdirs();
          localObject1 = paramString;
        } while (((File)localObject2).canWrite());
        return b(paramContext, "backup");
        return b(paramContext, "backup");
        localObject1 = localObject2;
      } while (((String)localObject2).equals(""));
      return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      if (a != null) {
        return a;
      }
      a = b(paramContext, "tbslog");
      return a;
      Object localObject1 = localObject2;
    } while (((String)localObject2).equals(""));
    return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
    return b(paramContext, "env");
  }
  
  public static FileLock a(Context paramContext, FileOutputStream paramFileOutputStream)
  {
    if (paramFileOutputStream == null) {}
    for (;;)
    {
      return null;
      try
      {
        paramContext = paramFileOutputStream.getChannel().tryLock();
        boolean bool = paramContext.isValid();
        if (bool) {
          return paramContext;
        }
      }
      catch (OverlappingFileLockException paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static void a(Context paramContext, FileLock paramFileLock)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 83
    //   5: new 96	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   12: ldc 189
    //   14: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_1
    //   18: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 192	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_1
    //   28: invokevirtual 195	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   31: astore_0
    //   32: aload_0
    //   33: ifnull +16 -> 49
    //   36: aload_0
    //   37: invokevirtual 198	java/nio/channels/FileChannel:isOpen	()Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifeq +7 -> 49
    //   45: aload_1
    //   46: invokevirtual 201	java/nio/channels/FileLock:release	()V
    //   49: ldc 2
    //   51: monitorexit
    //   52: return
    //   53: astore_0
    //   54: aload_0
    //   55: invokevirtual 122	java/io/IOException:printStackTrace	()V
    //   58: goto -9 -> 49
    //   61: astore_0
    //   62: ldc 2
    //   64: monitorexit
    //   65: aload_0
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	paramContext	Context
    //   0	67	1	paramFileLock	FileLock
    //   40	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   45	49	53	java/io/IOException
    //   3	32	61	finally
    //   36	41	61	finally
    //   45	49	61	finally
    //   54	58	61	finally
  }
  
  public static void a(File paramFile, boolean paramBoolean)
  {
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        a(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void a(File paramFile, boolean paramBoolean, String paramString)
  {
    TbsLog.i("FileUtils", "delete file,ignore=" + paramBoolean + "except" + paramString + paramFile + Log.getStackTraceString(new Throwable()));
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      File[] arrayOfFile;
      do
      {
        return;
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        arrayOfFile = paramFile.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      if (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.getName().equals(paramString)) {}
        for (;;)
        {
          i += 1;
          break;
          a(localFile, paramBoolean);
        }
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void a(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
  {
    if (paramFileLock != null) {}
    try
    {
      FileChannel localFileChannel = paramFileLock.channel();
      if ((localFileChannel != null) && (localFileChannel.isOpen())) {
        paramFileLock.release();
      }
    }
    catch (Exception paramFileLock)
    {
      for (;;)
      {
        try
        {
          paramFileOutputStream.close();
          return;
        }
        catch (Exception paramFileLock)
        {
          paramFileLock.printStackTrace();
        }
        paramFileLock = paramFileLock;
        paramFileLock.printStackTrace();
      }
    }
    if (paramFileOutputStream != null) {}
  }
  
  public static boolean a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {}
    do
    {
      return true;
      if (paramContext == null) {
        break;
      }
    } while (paramContext.getApplicationContext().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
    return false;
    return false;
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
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return b(paramFile1, paramFile2, paramFileFilter, parama);
      }
      paramFile1 = paramFile1.listFiles(paramFileFilter);
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
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
  
  private static boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    paramString = new File(paramString);
    if (paramString.length() != paramLong1) {
      TbsLog.e("FileHelper", "file size doesn't match: " + paramString.length() + " vs " + paramLong1);
    }
    label122:
    do
    {
      return true;
      try
      {
        localFileInputStream = new FileInputStream(paramString);
        try
        {
          localCRC32 = new CRC32();
          byte[] arrayOfByte = new byte[8192];
          for (;;)
          {
            int i = localFileInputStream.read(arrayOfByte);
            if (i <= 0) {
              break;
            }
            localCRC32.update(arrayOfByte, 0, i);
          }
          if (localFileInputStream == null) {
            break label122;
          }
        }
        finally {}
      }
      finally
      {
        for (;;)
        {
          CRC32 localCRC32;
          FileInputStream localFileInputStream = null;
        }
      }
      localFileInputStream.close();
      throw paramString;
      paramLong1 = localCRC32.getValue();
      TbsLog.i("FileHelper", "" + paramString.getName() + ": crc = " + paramLong1 + ", zipCrc = " + paramLong3);
      if (paramLong1 == paramLong3) {
        break;
      }
    } while (localFileInputStream == null);
    localFileInputStream.close();
    return true;
    if (localFileInputStream != null) {
      localFileInputStream.close();
    }
    return false;
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean a(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return a(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  private static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, FileUtil.b paramb)
  {
    try
    {
      paramString1 = new ZipFile(paramString1);
      int j = 0;
      int i = 0;
      try
      {
        Enumeration localEnumeration = paramString1.entries();
        do
        {
          if (!localEnumeration.hasMoreElements()) {
            break;
          }
          localZipEntry = (ZipEntry)localEnumeration.nextElement();
          localObject = localZipEntry.getName();
        } while ((localObject == null) || (((String)localObject).contains("../")) || ((!((String)localObject).startsWith("lib/")) && (!((String)localObject).startsWith("assets/"))));
        str = ((String)localObject).substring(((String)localObject).lastIndexOf('/'));
        k = i;
        m = j;
        if (str.endsWith(".so"))
        {
          if ((((String)localObject).regionMatches(c, paramString2, 0, paramString2.length())) && (((String)localObject).charAt(c + paramString2.length()) == '/'))
          {
            m = 1;
            k = i;
          }
        }
        else {
          localObject = paramString1.getInputStream(localZipEntry);
        }
      }
      finally
      {
        try
        {
          for (;;)
          {
            ZipEntry localZipEntry;
            String str;
            int k;
            int m;
            boolean bool = paramb.a((InputStream)localObject, localZipEntry, str.substring(1));
            if (!bool)
            {
              if (localObject != null) {
                ((InputStream)localObject).close();
              }
              if (paramString1 != null) {
                paramString1.close();
              }
              return false;
              if ((paramString3 != null) && (((String)localObject).regionMatches(c, paramString3, 0, paramString3.length())) && (((String)localObject).charAt(c + paramString3.length()) == '/'))
              {
                k = 1;
                i = 1;
                m = j;
                if (j == 0) {}
              }
              else if ((paramString4 != null) && (((String)localObject).regionMatches(c, paramString4, 0, paramString4.length())) && (((String)localObject).charAt(c + paramString4.length()) == '/') && (j == 0))
              {
                k = i;
                m = j;
                if (i == 0) {}
              }
            }
            else
            {
              i = k;
              j = m;
              if (localObject != null)
              {
                ((InputStream)localObject).close();
                i = k;
                j = m;
              }
            }
          }
        }
        finally
        {
          Object localObject;
          if (localObject == null) {
            break label386;
          }
          ((InputStream)localObject).close();
        }
        paramString3 = finally;
        paramString2 = paramString1;
        paramString1 = paramString3;
      }
    }
    finally
    {
      for (;;)
      {
        label386:
        paramString2 = null;
      }
    }
    if (paramString2 != null) {
      paramString2.close();
    }
    throw paramString1;
    if (paramString1 != null) {
      paramString1.close();
    }
    return true;
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
    if (localObject == null) {}
    for (;;)
    {
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
          paramContext = Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + paramContext.getApplicationInfo().packageName + File.separator + "files" + File.separator + paramString;
          return paramContext;
        }
        catch (Exception paramContext)
        {
          paramContext.printStackTrace();
          return "";
        }
      }
      paramContext = localThrowable;
    }
  }
  
  public static void b(File paramFile)
  {
    a(paramFile, false);
  }
  
  public static boolean b(Context paramContext)
  {
    long l = p.a();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public static boolean b(File paramFile1, File paramFile2)
  {
    return a(paramFile1, paramFile2, null);
  }
  
  /* Error */
  private static boolean b(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtil.a parama)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: ifnull +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: aload_2
    //   14: ifnull +15 -> 29
    //   17: aload_2
    //   18: aload_0
    //   19: invokeinterface 449 2 0
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokevirtual 75	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 221	java/io/File:isFile	()Z
    //   40: istore 4
    //   42: iload 4
    //   44: ifne +29 -> 73
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 451	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 451	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 75	java/io/File:exists	()Z
    //   77: ifeq +52 -> 129
    //   80: aload_3
    //   81: ifnull +44 -> 125
    //   84: aload_3
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface 456 3 0
    //   92: istore 4
    //   94: iload 4
    //   96: ifeq +29 -> 125
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 451	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 451	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: aload_1
    //   126: invokestatic 263	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   129: aload_1
    //   130: invokevirtual 459	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 221	java/io/File:isFile	()Z
    //   138: ifeq +7 -> 145
    //   141: aload_2
    //   142: invokestatic 263	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   145: aload_2
    //   146: invokevirtual 75	java/io/File:exists	()Z
    //   149: ifne +40 -> 189
    //   152: aload_2
    //   153: invokevirtual 78	java/io/File:mkdirs	()Z
    //   156: istore 4
    //   158: iload 4
    //   160: ifne +29 -> 189
    //   163: iconst_0
    //   164: ifeq +11 -> 175
    //   167: new 451	java/lang/NullPointerException
    //   170: dup
    //   171: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   174: athrow
    //   175: iconst_0
    //   176: ifeq +11 -> 187
    //   179: new 451	java/lang/NullPointerException
    //   182: dup
    //   183: invokespecial 452	java/lang/NullPointerException:<init>	()V
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    //   189: new 297	java/io/FileInputStream
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokevirtual 460	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   200: astore_2
    //   201: new 170	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 412	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: invokevirtual 174	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   212: astore_3
    //   213: aload_2
    //   214: invokevirtual 463	java/nio/channels/FileChannel:size	()J
    //   217: lstore 5
    //   219: aload_3
    //   220: aload_2
    //   221: lconst_0
    //   222: lload 5
    //   224: invokevirtual 467	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   227: lload 5
    //   229: lcmp
    //   230: ifeq +25 -> 255
    //   233: aload_1
    //   234: invokestatic 263	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   263: aload_3
    //   264: ifnull +7 -> 271
    //   267: aload_3
    //   268: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   271: iconst_1
    //   272: ireturn
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_1
    //   276: aload 7
    //   278: astore_2
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 468	java/nio/channels/FileChannel:close	()V
    //   295: aload_0
    //   296: athrow
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -21 -> 279
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: goto -27 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramFile1	File
    //   0	309	1	paramFile2	File
    //   0	309	2	paramFileFilter	FileFilter
    //   0	309	3	parama	FileUtil.a
    //   40	119	4	bool	boolean
    //   217	11	5	l	long
    //   1	276	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	42	273	finally
    //   73	80	273	finally
    //   84	94	273	finally
    //   125	129	273	finally
    //   129	145	273	finally
    //   145	158	273	finally
    //   189	201	273	finally
    //   201	213	297	finally
    //   213	237	303	finally
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean b(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 60	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 470	com/tencent/smtt/utils/FileUtil:a	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 96	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 147	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 60	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: new 170	java/io/FileOutputStream
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 412	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: sipush 8192
    //   60: newarray byte
    //   62: astore 6
    //   64: aload_0
    //   65: aload 6
    //   67: invokevirtual 49	java/io/InputStream:read	([B)I
    //   70: istore 4
    //   72: iload 4
    //   74: ifle +66 -> 140
    //   77: aload_2
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: invokevirtual 471	java/io/FileOutputStream:write	([BII)V
    //   86: goto -22 -> 64
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 263	com/tencent/smtt/utils/FileUtil:b	(Ljava/io/File;)V
    //   96: new 58	java/io/IOException
    //   99: dup
    //   100: new 96	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 473
    //   110: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_3
    //   114: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: aload_1
    //   121: invokespecial 476	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   124: athrow
    //   125: astore_2
    //   126: aload_0
    //   127: astore_1
    //   128: aload_2
    //   129: astore_0
    //   130: aload_1
    //   131: ifnull +7 -> 138
    //   134: aload_1
    //   135: invokevirtual 240	java/io/FileOutputStream:close	()V
    //   138: aload_0
    //   139: athrow
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 240	java/io/FileOutputStream:close	()V
    //   148: aload 5
    //   150: aload_1
    //   151: invokevirtual 479	java/util/zip/ZipEntry:getSize	()J
    //   154: aload_1
    //   155: invokevirtual 482	java/util/zip/ZipEntry:getTime	()J
    //   158: aload_1
    //   159: invokevirtual 485	java/util/zip/ZipEntry:getCrc	()J
    //   162: invokestatic 487	com/tencent/smtt/utils/FileUtil:a	(Ljava/lang/String;JJJ)Z
    //   165: ifeq +31 -> 196
    //   168: ldc 83
    //   170: new 96	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 489
    //   180: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: aload 5
    //   185: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 91	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: iconst_0
    //   195: ireturn
    //   196: aload_3
    //   197: aload_1
    //   198: invokevirtual 482	java/util/zip/ZipEntry:getTime	()J
    //   201: invokevirtual 493	java/io/File:setLastModified	(J)Z
    //   204: ifne +28 -> 232
    //   207: ldc 83
    //   209: new 96	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   216: ldc_w 495
    //   219: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_3
    //   223: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 91	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   232: iconst_1
    //   233: ireturn
    //   234: astore_0
    //   235: aconst_null
    //   236: astore_1
    //   237: goto -107 -> 130
    //   240: astore_0
    //   241: aload_2
    //   242: astore_1
    //   243: goto -113 -> 130
    //   246: astore_1
    //   247: aconst_null
    //   248: astore_0
    //   249: goto -157 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramInputStream	InputStream
    //   0	252	1	paramZipEntry	ZipEntry
    //   0	252	2	paramString1	String
    //   0	252	3	paramString2	String
    //   70	12	4	i	int
    //   36	148	5	str	String
    //   62	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	64	89	java/io/IOException
    //   64	72	89	java/io/IOException
    //   77	86	89	java/io/IOException
    //   92	125	125	finally
    //   48	57	234	finally
    //   57	64	240	finally
    //   64	72	240	finally
    //   77	86	240	finally
    //   48	57	246	java/io/IOException
  }
  
  public static String c(Context paramContext)
  {
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
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
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.exists()) && (!localFile.mkdirs())) {
        throw new IOException("File '" + paramFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile);
  }
  
  static String d(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock e(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      if (!bool)
      {
        localObject1 = b(paramContext, true, "tbs_rename_lock");
        if (localObject1 == null)
        {
          TbsLog.i("FileHelper", "init -- failed to get rename fileLock#1!");
          paramContext = (Context)localObject2;
          TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #2 renameFileLock is " + paramContext);
          return paramContext;
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        boolean bool = true;
        continue;
        paramContext = a(paramContext, (FileOutputStream)localObject1);
        if (paramContext == null) {
          TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
        } else {
          TbsLog.i("FileHelper", "init -- get rename fileLock success!");
        }
      }
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
      localObject2 = a(paramContext, "tbs_rename_lock");
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + localObject2);
      try
      {
        d = new RandomAccessFile(((File)localObject2).getAbsolutePath(), "r");
        localObject2 = d.getChannel().tryLock(0L, 9223372036854775807L, true);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          TbsLog.e("FileHelper", "getTbsCoreLoadFileLock -- exception: " + localThrowable1);
        }
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- success: " + "tbs_rename_lock");
        return localThrowable1;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = g(paramContext);
      }
      if (localObject2 == null)
      {
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: " + "tbs_rename_lock");
        return localObject2;
      }
    }
  }
  
  public static FileLock f(Context paramContext)
  {
    Object localObject = null;
    paramContext = a(paramContext, "tbs_rename_lock");
    TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + paramContext);
    try
    {
      d = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      paramContext = d.getChannel().tryLock(0L, 9223372036854775807L, false);
      if (paramContext == null)
      {
        TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- failed: " + "tbs_rename_lock");
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        TbsLog.e("FileHelper", "getTbsCoreRenameFileLock -- excpetion: " + "tbs_rename_lock");
        paramContext = localObject;
      }
      TbsLog.i("FileHelper", "getTbsCoreRenameFileLock -- success: " + "tbs_rename_lock");
    }
    return paramContext;
  }
  
  private static FileLock g(Context paramContext)
  {
    FileLock localFileLock2 = null;
    Object localObject2 = null;
    FileLock localFileLock1 = null;
    Object localObject1 = localFileLock2;
    for (;;)
    {
      TbsLogReport.TbsLogInfo localTbsLogInfo;
      int i;
      try
      {
        localTbsLogInfo = TbsLogReport.getInstance(paramContext).tbsLogInfo();
        localObject1 = localFileLock2;
        localTbsLogInfo.setErrorCode(803);
        localObject1 = localFileLock2;
        File localFile = a(paramContext, "tbs_rename_lock");
        localObject1 = localFileLock2;
        bool = TbsDownloadConfig.getInstance(paramContext).getTbsCoreLoadRenameFileLockWaitEnable();
        localObject1 = localObject2;
        if (bool)
        {
          i = 0;
          if ((i < 20) && (localFileLock1 == null)) {
            try
            {
              Thread.sleep(100L);
              localObject1 = localFileLock1;
              d = new RandomAccessFile(localFile.getAbsolutePath(), "r");
              localObject1 = localFileLock1;
              localFileLock2 = d.getChannel().tryLock(0L, 9223372036854775807L, true);
              localFileLock1 = localFileLock2;
            }
            catch (Exception localException)
            {
              localObject1 = localFileLock1;
              localException.printStackTrace();
              continue;
            }
            catch (Throwable localThrowable)
            {
              localObject1 = localFileLock1;
              localThrowable.printStackTrace();
            }
          }
        }
        else
        {
          return localObject1;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      if (localFileLock1 != null)
      {
        localObject1 = localFileLock1;
        localTbsLogInfo.setErrorCode(802);
        localObject1 = localFileLock1;
        TbsLogReport.getInstance(paramContext).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, localTbsLogInfo);
        localObject1 = localFileLock1;
        paramContext = new StringBuilder().append("getTbsCoreLoadFileLock,retry num=").append(i).append("success=");
        if (localFileLock1 != null) {
          break label259;
        }
      }
      label259:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = localFileLock1;
        TbsLog.i("FileHelper", bool);
        return localFileLock1;
        localObject1 = localFileLock1;
        localTbsLogInfo.setErrorCode(801);
        break;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */