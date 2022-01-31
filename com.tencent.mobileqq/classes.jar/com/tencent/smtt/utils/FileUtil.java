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
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
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
  private static final String APK_ASSETS = "assets/";
  private static final String APK_LIB = "lib/";
  private static final int APK_LIB_LEN = "lib/".length();
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int ENU_NEW_TBS_BACKUP_PATH = 4;
  public static final int ENU_NEW_TBS_BACKUP_PATH1 = 7;
  public static final int ENU_OLD_TBS_BACKUP_PATH1 = 1;
  public static final int ENU_OLD_TBS_BACKUP_PATH2 = 2;
  public static final int ENU_OLD_TBS_BACKUP_PATH3 = 3;
  public static final int ENU_TBS_LOCALINSTALL = 5;
  public static final int ENU_TBS_LOG = 6;
  private static final String LIB_SUFFIX = ".so";
  public static final FileUtil.FileComparator SIMPLE_COMPARATOR = new FileUtil.2();
  private static final String TAG = "FileHelper";
  public static String TBSLOG_PATH = null;
  public static final String TBS_CORE_LOCK_FILE = "tbslock.txt";
  public static final String TBS_CORE_PRIVATE = "core_private";
  public static final String TBS_DOWNLOADING_LOCK_FILE_PRENAME = "tbs_download_lock_file";
  public static final String TBS_FILE_CORE_SHARE = "core_share";
  public static final String TBS_FILE_SHARE = "share";
  public static final String TBS_RENAME_LOCK_FILE = "tbs_rename_lock";
  private static final String TBS_SDCARD_DIR = "tbs";
  private static final String TBS_SDCARD_SHARE_DIR = ".tbs";
  public static final int ZIP_BUFFER_SIZE = 4096;
  private static RandomAccessFile raf = null;
  
  public static void closeQuietly(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Exception paramCloseable)
    {
      paramCloseable.printStackTrace();
    }
  }
  
  public static int copy(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    long l = copyLarge(paramInputStream, paramOutputStream);
    if (l > 2147483647L) {
      return -1;
    }
    return (int)l;
  }
  
  /* Error */
  @SuppressLint({"NewApi"})
  private static boolean copyFileIfChanged(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 120	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 127	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 129	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 137	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 120	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 123	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: new 143	java/io/FileOutputStream
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: sipush 8192
    //   60: newarray byte
    //   62: astore 6
    //   64: aload_0
    //   65: aload 6
    //   67: invokevirtual 152	java/io/InputStream:read	([B)I
    //   70: istore 4
    //   72: iload 4
    //   74: ifle +65 -> 139
    //   77: aload_2
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: invokevirtual 156	java/io/FileOutputStream:write	([BII)V
    //   86: goto -22 -> 64
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 159	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   96: new 118	java/io/IOException
    //   99: dup
    //   100: new 129	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   107: ldc 161
    //   109: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_3
    //   113: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload_1
    //   120: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: athrow
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 168	java/io/FileOutputStream:close	()V
    //   147: aload 5
    //   149: aload_1
    //   150: invokevirtual 174	java/util/zip/ZipEntry:getSize	()J
    //   153: aload_1
    //   154: invokevirtual 177	java/util/zip/ZipEntry:getTime	()J
    //   157: aload_1
    //   158: invokevirtual 180	java/util/zip/ZipEntry:getCrc	()J
    //   161: invokestatic 184	com/tencent/smtt/utils/FileUtil:isFileDifferent	(Ljava/lang/String;JJJ)Z
    //   164: ifeq +30 -> 194
    //   167: ldc 40
    //   169: new 129	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   176: ldc 186
    //   178: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 5
    //   183: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 192	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: aload_3
    //   195: aload_1
    //   196: invokevirtual 177	java/util/zip/ZipEntry:getTime	()J
    //   199: invokevirtual 196	java/io/File:setLastModified	(J)Z
    //   202: ifne +27 -> 229
    //   205: ldc 40
    //   207: new 129	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   214: ldc 198
    //   216: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_3
    //   220: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 192	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: iconst_1
    //   230: ireturn
    //   231: astore_0
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -105 -> 129
    //   237: astore_0
    //   238: aload_2
    //   239: astore_1
    //   240: goto -111 -> 129
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_0
    //   246: goto -154 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	paramInputStream	InputStream
    //   0	249	1	paramZipEntry	ZipEntry
    //   0	249	2	paramString1	String
    //   0	249	3	paramString2	String
    //   70	12	4	i	int
    //   36	146	5	str	String
    //   62	17	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	64	89	java/io/IOException
    //   64	72	89	java/io/IOException
    //   77	86	89	java/io/IOException
    //   92	124	124	finally
    //   48	57	231	finally
    //   57	64	237	finally
    //   64	72	237	finally
    //   77	86	237	finally
    //   48	57	243	java/io/IOException
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2)
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtil.FileComparator paramFileComparator)
  {
    if ((paramFile1 == null) || (paramFile2 == null)) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile1.exists());
      if (paramFile1.isFile()) {
        return performCopyFile(paramFile1, paramFile2, paramFileFilter, paramFileComparator);
      }
      paramFile1 = paramFile1.listFiles(paramFileFilter);
    } while (paramFile1 == null);
    boolean bool = true;
    int j = paramFile1.length;
    int i = 0;
    while (i < j)
    {
      paramFileComparator = paramFile1[i];
      if (!copyFiles(paramFileComparator, new File(paramFile2, paramFileComparator.getName()), paramFileFilter)) {
        bool = false;
      }
      i += 1;
    }
    return bool;
  }
  
  public static long copyLarge(InputStream paramInputStream, OutputStream paramOutputStream)
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
  
  public static boolean copyTbsFilesIfNeeded(File paramFile1, File paramFile2)
  {
    return copyTbsFilesIfNeeded(paramFile1.getPath(), paramFile2.getPath());
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2)
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return copyTbsFilesIfNeeded(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  private static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return iterateOverTbsFiles(paramString1, paramString3, paramString4, paramString5, new FileUtil.1(paramString2));
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
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
        delete(arrayOfFile[i], paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static void delete(File paramFile, boolean paramBoolean, String paramString)
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
          delete(localFile, paramBoolean);
        }
      }
    } while (paramBoolean);
    paramFile.delete();
  }
  
  public static boolean ensureDirectory(File paramFile)
  {
    if (paramFile == null) {
      return false;
    }
    if ((paramFile.exists()) && (paramFile.isDirectory())) {
      return true;
    }
    delete(paramFile);
    return paramFile.mkdirs();
  }
  
  public static void freeFileLock(FileLock paramFileLock, FileOutputStream paramFileOutputStream)
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
  
  public static String getFileLockPath(Context paramContext)
  {
    return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
  }
  
  public static File getLockFile(Context paramContext, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramContext = getTbsCorePrivateDir(paramContext);
      if (paramContext != null) {
        break label23;
      }
    }
    label23:
    do
    {
      return null;
      paramContext = getFileLockPath(paramContext);
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
  
  public static FileOutputStream getLockFos(Context paramContext, boolean paramBoolean, String paramString)
  {
    paramContext = getLockFile(paramContext, paramBoolean, paramString);
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
  
  public static File getPermanentTbsFile(Context paramContext, String paramString)
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
  
  public static File getSDcardDir()
  {
    try
    {
      File localFile = Environment.getExternalStorageDirectory();
      return localFile;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private static String getStandardExternalFilesDir(Context paramContext, String paramString)
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
  
  public static String getTBSSdcardFilePath(Context paramContext, int paramInt)
  {
    return getTBSSdcardFilePath(paramContext, paramContext.getApplicationInfo().packageName, paramInt, true);
  }
  
  public static String getTBSSdcardFilePath(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
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
                return getStandardExternalFilesDir(paramContext, "backup");
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
        return getStandardExternalFilesDir(paramContext, "backup");
        return getStandardExternalFilesDir(paramContext, "backup");
        localObject1 = localObject2;
      } while (((String)localObject2).equals(""));
      return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
      if (TBSLOG_PATH != null) {
        return TBSLOG_PATH;
      }
      TBSLOG_PATH = getStandardExternalFilesDir(paramContext, "tbslog");
      return TBSLOG_PATH;
      Object localObject1 = localObject2;
    } while (((String)localObject2).equals(""));
    return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
  }
  
  public static FileLock getTbsCoreLoadFileLock(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #1");
    try
    {
      bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
      if (!bool)
      {
        localObject1 = getLockFos(paramContext, true, "tbs_rename_lock");
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
        paramContext = tryFileLock(paramContext, (FileOutputStream)localObject1);
        if (paramContext == null) {
          TbsLog.i("FileHelper", "init -- failed to get rename fileLock#2!");
        } else {
          TbsLog.i("FileHelper", "init -- get rename fileLock success!");
        }
      }
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #3");
      localObject2 = getPermanentTbsFile(paramContext, "tbs_rename_lock");
      TbsLog.i("FileHelper", "getTbsCoreLoadFileLock #4 " + localObject2);
      try
      {
        raf = new RandomAccessFile(((File)localObject2).getAbsolutePath(), "r");
        localObject2 = raf.getChannel().tryLock(0L, 9223372036854775807L, true);
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
        localObject2 = retryFileLockIfNeeded(paramContext);
      }
      if (localObject2 == null)
      {
        TbsLog.i("FileHelper", "getTbsCoreLoadFileLock -- failed: " + "tbs_rename_lock");
        return localObject2;
      }
    }
  }
  
  static String getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(QbSdk.getTbsFolderDir(paramContext), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock getTbsCoreRenameFileLock(Context paramContext)
  {
    Object localObject = null;
    paramContext = getPermanentTbsFile(paramContext, "tbs_rename_lock");
    TbsLog.i("FileHelper", "getTbsCoreRenameFileLock #1 " + paramContext);
    try
    {
      raf = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      paramContext = raf.getChannel().tryLock(0L, 9223372036854775807L, false);
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
  
  public static File getTbsSdcardShareDir()
  {
    File localFile = new File(getSDcardDir().getAbsolutePath() + "/" + ".tbs");
    if ((localFile != null) && (!localFile.exists())) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public static boolean hasEnoughFreeSpace(Context paramContext)
  {
    long l = TbsUtils.getROMAvailableSize();
    if (l >= TbsDownloadConfig.getInstance(paramContext).getDownloadMinFreeSpace()) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        TbsLog.e("TbsDownload", "[TbsApkDwonloader.hasEnoughFreeSpace] freeSpace too small,  freeSpace = " + l);
      }
      return bool;
    }
  }
  
  public static boolean hasSDcard()
  {
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private static boolean isFileDifferent(String paramString, long paramLong1, long paramLong2, long paramLong3)
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
  
  public static boolean isFileValid(File paramFile)
  {
    return (paramFile != null) && (paramFile.exists()) && (paramFile.isFile()) && (paramFile.length() > 0L);
  }
  
  public static boolean isSdcardDirWritable(Context paramContext)
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
  
  private static boolean iterateOverTbsFiles(String paramString1, String paramString2, String paramString3, String paramString4, FileUtil.IterateHandler paramIterateHandler)
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
          if ((((String)localObject).regionMatches(APK_LIB_LEN, paramString2, 0, paramString2.length())) && (((String)localObject).charAt(APK_LIB_LEN + paramString2.length()) == '/'))
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
            boolean bool = paramIterateHandler.handleEntry((InputStream)localObject, localZipEntry, str.substring(1));
            if (!bool)
            {
              if (localObject != null) {
                ((InputStream)localObject).close();
              }
              if (paramString1 != null) {
                paramString1.close();
              }
              return false;
              if ((paramString3 != null) && (((String)localObject).regionMatches(APK_LIB_LEN, paramString3, 0, paramString3.length())) && (((String)localObject).charAt(APK_LIB_LEN + paramString3.length()) == '/'))
              {
                k = 1;
                i = 1;
                m = j;
                if (j == 0) {}
              }
              else if ((paramString4 != null) && (((String)localObject).regionMatches(APK_LIB_LEN, paramString4, 0, paramString4.length())) && (((String)localObject).charAt(APK_LIB_LEN + paramString4.length()) == '/') && (j == 0))
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
            break label384;
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
        label384:
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
  
  public static FileInputStream openInputStream(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream openOutputStream(File paramFile)
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
  
  /* Error */
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileUtil.FileComparator paramFileComparator)
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
    //   19: invokeinterface 645 2 0
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokevirtual 211	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 214	java/io/File:isFile	()Z
    //   40: istore 4
    //   42: iload 4
    //   44: ifne +29 -> 73
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 647	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 647	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 211	java/io/File:exists	()Z
    //   77: ifeq +52 -> 129
    //   80: aload_3
    //   81: ifnull +44 -> 125
    //   84: aload_3
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface 652 3 0
    //   92: istore 4
    //   94: iload 4
    //   96: ifeq +29 -> 125
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 647	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 647	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: aload_1
    //   126: invokestatic 159	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   129: aload_1
    //   130: invokevirtual 638	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 214	java/io/File:isFile	()Z
    //   138: ifeq +7 -> 145
    //   141: aload_2
    //   142: invokestatic 159	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   145: aload_2
    //   146: invokevirtual 211	java/io/File:exists	()Z
    //   149: ifne +40 -> 189
    //   152: aload_2
    //   153: invokevirtual 313	java/io/File:mkdirs	()Z
    //   156: istore 4
    //   158: iload 4
    //   160: ifne +29 -> 189
    //   163: iconst_0
    //   164: ifeq +11 -> 175
    //   167: new 647	java/lang/NullPointerException
    //   170: dup
    //   171: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   174: athrow
    //   175: iconst_0
    //   176: ifeq +11 -> 187
    //   179: new 647	java/lang/NullPointerException
    //   182: dup
    //   183: invokespecial 648	java/lang/NullPointerException:<init>	()V
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    //   189: new 534	java/io/FileInputStream
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 535	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokevirtual 653	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   200: astore_2
    //   201: new 143	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 146	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: invokevirtual 654	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   212: astore_0
    //   213: aload_2
    //   214: invokevirtual 657	java/nio/channels/FileChannel:size	()J
    //   217: lstore 5
    //   219: aload_0
    //   220: aload_2
    //   221: lconst_0
    //   222: lload 5
    //   224: invokevirtual 661	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   227: lload 5
    //   229: lcmp
    //   230: ifeq +25 -> 255
    //   233: aload_1
    //   234: invokestatic 159	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 662	java/nio/channels/FileChannel:close	()V
    //   245: aload_0
    //   246: ifnull +7 -> 253
    //   249: aload_0
    //   250: invokevirtual 662	java/nio/channels/FileChannel:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: aload_2
    //   256: ifnull +7 -> 263
    //   259: aload_2
    //   260: invokevirtual 662	java/nio/channels/FileChannel:close	()V
    //   263: aload_0
    //   264: ifnull +7 -> 271
    //   267: aload_0
    //   268: invokevirtual 662	java/nio/channels/FileChannel:close	()V
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
    //   284: invokevirtual 662	java/nio/channels/FileChannel:close	()V
    //   287: aload_1
    //   288: ifnull +7 -> 295
    //   291: aload_1
    //   292: invokevirtual 662	java/nio/channels/FileChannel:close	()V
    //   295: aload_0
    //   296: athrow
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -21 -> 279
    //   303: astore_3
    //   304: aload_0
    //   305: astore_1
    //   306: aload_3
    //   307: astore_0
    //   308: goto -29 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramFile1	File
    //   0	311	1	paramFile2	File
    //   0	311	2	paramFileFilter	FileFilter
    //   0	311	3	paramFileComparator	FileUtil.FileComparator
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
  public static byte[] read(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: ifnonnull +7 -> 10
    //   6: aload_3
    //   7: astore_1
    //   8: aload_1
    //   9: areturn
    //   10: aload_0
    //   11: invokestatic 667	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   14: astore_0
    //   15: aload_0
    //   16: astore_1
    //   17: aload_0
    //   18: invokestatic 671	com/tencent/smtt/utils/FileUtil:toByteArrayOutputStream	(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;
    //   21: invokevirtual 677	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: ifnull -20 -> 8
    //   31: aload_0
    //   32: invokestatic 679	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   35: aload_2
    //   36: areturn
    //   37: astore_2
    //   38: aconst_null
    //   39: astore_0
    //   40: aload_0
    //   41: astore_1
    //   42: aload_2
    //   43: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   46: aload_3
    //   47: astore_1
    //   48: aload_0
    //   49: ifnull -41 -> 8
    //   52: aload_0
    //   53: invokestatic 679	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_0
    //   61: aload_0
    //   62: astore_1
    //   63: aload_2
    //   64: invokevirtual 680	java/lang/OutOfMemoryError:printStackTrace	()V
    //   67: aload_0
    //   68: astore_1
    //   69: aload_2
    //   70: athrow
    //   71: astore_0
    //   72: aload_1
    //   73: ifnull +7 -> 80
    //   76: aload_1
    //   77: invokestatic 679	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: athrow
    //   82: astore_0
    //   83: aconst_null
    //   84: astore_1
    //   85: goto -13 -> 72
    //   88: astore_2
    //   89: goto -28 -> 61
    //   92: astore_2
    //   93: goto -53 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	paramFile	File
    //   7	78	1	localObject1	Object
    //   24	12	2	arrayOfByte	byte[]
    //   37	6	2	localException1	Exception
    //   58	12	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   88	1	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   92	1	2	localException2	Exception
    //   1	46	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	15	37	java/lang/Exception
    //   10	15	58	java/lang/OutOfMemoryError
    //   17	25	71	finally
    //   42	46	71	finally
    //   63	67	71	finally
    //   69	71	71	finally
    //   10	15	82	finally
    //   17	25	88	java/lang/OutOfMemoryError
    //   17	25	92	java/lang/Exception
  }
  
  /* Error */
  public static void releaseTbsCoreRenameFileLock(Context paramContext, FileLock paramFileLock)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 40
    //   5: new 129	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   12: ldc_w 684
    //   15: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_1
    //   19: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 295	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 321	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   32: astore_0
    //   33: aload_0
    //   34: ifnull +16 -> 50
    //   37: aload_0
    //   38: invokevirtual 326	java/nio/channels/FileChannel:isOpen	()Z
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +7 -> 50
    //   46: aload_1
    //   47: invokevirtual 329	java/nio/channels/FileLock:release	()V
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: astore_0
    //   55: aload_0
    //   56: invokevirtual 353	java/io/IOException:printStackTrace	()V
    //   59: goto -9 -> 50
    //   62: astore_0
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_0
    //   67: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   0	68	1	paramFileLock	FileLock
    //   41	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   46	50	54	java/io/IOException
    //   3	33	62	finally
    //   37	42	62	finally
    //   46	50	62	finally
    //   55	59	62	finally
  }
  
  public static boolean removeTbsFiles(File paramFile)
  {
    boolean bool2 = false;
    int i = 0;
    boolean bool1 = bool2;
    if (paramFile.exists())
    {
      paramFile = paramFile.listFiles();
      bool1 = bool2;
      if (paramFile != null)
      {
        bool1 = false;
        if (i < paramFile.length)
        {
          if (!paramFile[i].delete()) {
            TbsLog.w("FileHelper", "Could not delete native binary: " + paramFile[i].getPath());
          }
          for (;;)
          {
            i += 1;
            break;
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean removeTbsFiles(String paramString)
  {
    return removeTbsFiles(new File(paramString));
  }
  
  private static FileLock retryFileLockIfNeeded(Context paramContext)
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
        File localFile = getPermanentTbsFile(paramContext, "tbs_rename_lock");
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
              raf = new RandomAccessFile(localFile.getAbsolutePath(), "r");
              localObject1 = localFileLock1;
              localFileLock2 = raf.getChannel().tryLock(0L, 9223372036854775807L, true);
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
          break label258;
        }
      }
      label258:
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
  
  public static byte[] toByteArray(InputStream paramInputStream)
  {
    return toByteArrayOutputStream(paramInputStream).toByteArray();
  }
  
  public static ByteArrayOutputStream toByteArrayOutputStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    copy(paramInputStream, localByteArrayOutputStream);
    return localByteArrayOutputStream;
  }
  
  public static FileLock tryFileLock(Context paramContext, FileOutputStream paramFileOutputStream)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */