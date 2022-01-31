package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.TbsDownloadConfig;
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
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;

@SuppressLint({"NewApi"})
public class FileUtil
{
  private static final String APK_ASSETS = "assets/";
  private static final String APK_LIB = "lib/";
  private static final int APK_LIB_LEN = "lib/".length();
  private static final int DEFAULT_BUFFER_SIZE = 4096;
  public static final int ENU_NEW_TBS_BACKUP_PATH = 4;
  public static final int ENU_OLD_TBS_BACKUP_PATH1 = 1;
  public static final int ENU_OLD_TBS_BACKUP_PATH2 = 2;
  public static final int ENU_OLD_TBS_BACKUP_PATH3 = 3;
  public static final int ENU_TBS_LOCALINSTALL = 5;
  public static final int ENU_TBS_LOG = 6;
  private static final String LIB_SUFFIX = ".so";
  public static final FileComparator SIMPLE_COMPARATOR = new FileComparator()
  {
    public boolean equals(File paramAnonymousFile1, File paramAnonymousFile2)
    {
      return (paramAnonymousFile1.length() == paramAnonymousFile2.length()) && (paramAnonymousFile1.lastModified() == paramAnonymousFile2.lastModified());
    }
  };
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
    throws IOException, OutOfMemoryError
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
    throws Exception
  {
    // Byte code:
    //   0: new 129	java/io/File
    //   3: dup
    //   4: aload_2
    //   5: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokestatic 136	com/tencent/smtt/utils/FileUtil:ensureDirectory	(Ljava/io/File;)Z
    //   11: pop
    //   12: new 138	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   19: aload_2
    //   20: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: getstatic 146	java/io/File:separator	Ljava/lang/String;
    //   26: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_3
    //   30: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore 5
    //   38: new 129	java/io/File
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore_3
    //   48: new 152	java/io/FileOutputStream
    //   51: dup
    //   52: aload_3
    //   53: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   56: astore_2
    //   57: sipush 8192
    //   60: newarray byte
    //   62: astore 6
    //   64: aload_0
    //   65: aload 6
    //   67: invokevirtual 161	java/io/InputStream:read	([B)I
    //   70: istore 4
    //   72: iload 4
    //   74: ifle +65 -> 139
    //   77: aload_2
    //   78: aload 6
    //   80: iconst_0
    //   81: iload 4
    //   83: invokevirtual 165	java/io/FileOutputStream:write	([BII)V
    //   86: goto -22 -> 64
    //   89: astore_1
    //   90: aload_2
    //   91: astore_0
    //   92: aload_3
    //   93: invokestatic 168	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   96: new 119	java/io/IOException
    //   99: dup
    //   100: new 138	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   107: ldc 170
    //   109: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_3
    //   113: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: aload_1
    //   120: invokespecial 176	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: athrow
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: astore_0
    //   129: aload_1
    //   130: ifnull +7 -> 137
    //   133: aload_1
    //   134: invokevirtual 177	java/io/FileOutputStream:close	()V
    //   137: aload_0
    //   138: athrow
    //   139: aload_2
    //   140: ifnull +7 -> 147
    //   143: aload_2
    //   144: invokevirtual 177	java/io/FileOutputStream:close	()V
    //   147: aload 5
    //   149: aload_1
    //   150: invokevirtual 183	java/util/zip/ZipEntry:getSize	()J
    //   153: aload_1
    //   154: invokevirtual 186	java/util/zip/ZipEntry:getTime	()J
    //   157: aload_1
    //   158: invokevirtual 189	java/util/zip/ZipEntry:getCrc	()J
    //   161: invokestatic 193	com/tencent/smtt/utils/FileUtil:isFileDifferent	(Ljava/lang/String;JJJ)Z
    //   164: ifeq +30 -> 194
    //   167: ldc 48
    //   169: new 138	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   176: ldc 195
    //   178: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 5
    //   183: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokestatic 201	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: iconst_0
    //   193: ireturn
    //   194: aload_3
    //   195: aload_1
    //   196: invokevirtual 186	java/util/zip/ZipEntry:getTime	()J
    //   199: invokevirtual 205	java/io/File:setLastModified	(J)Z
    //   202: ifne +27 -> 229
    //   205: ldc 48
    //   207: new 138	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   214: ldc 207
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_3
    //   220: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 201	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, null);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter)
    throws Exception
  {
    return copyFiles(paramFile1, paramFile2, paramFileFilter, SIMPLE_COMPARATOR);
  }
  
  public static boolean copyFiles(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
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
    throws IOException, OutOfMemoryError
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
    throws Exception
  {
    return copyTbsFilesIfNeeded(paramFile1.getPath(), paramFile2.getPath());
  }
  
  @SuppressLint({"InlinedApi"})
  public static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2)
    throws Exception
  {
    String str2 = Build.CPU_ABI;
    if (Build.VERSION.SDK_INT >= 8) {}
    for (String str1 = Build.CPU_ABI2;; str1 = null) {
      return copyTbsFilesIfNeeded(paramString1, paramString2, str2, str1, PropertyUtils.getQuickly("ro.product.cpu.upgradeabi", "armeabi"));
    }
  }
  
  private static boolean copyTbsFilesIfNeeded(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws Exception
  {
    iterateOverTbsFiles(paramString1, paramString3, paramString4, paramString5, new IterateHandler()
    {
      public boolean handleEntry(InputStream paramAnonymousInputStream, ZipEntry paramAnonymousZipEntry, String paramAnonymousString)
        throws Exception
      {
        try
        {
          boolean bool = FileUtil.copyFileIfChanged(paramAnonymousInputStream, paramAnonymousZipEntry, this.val$dstDir, paramAnonymousString);
          return bool;
        }
        catch (Exception paramAnonymousInputStream)
        {
          throw new Exception("copyFileIfChanged Exception", paramAnonymousInputStream);
        }
      }
    });
  }
  
  public static void delete(File paramFile)
  {
    delete(paramFile, false);
  }
  
  public static void delete(File paramFile, boolean paramBoolean)
  {
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
      Object localObject1 = localObject2;
    } while (((String)localObject2).equals(""));
    return (String)localObject2 + "tencent" + File.separator + "tbs" + File.separator + paramString;
    if (TBSLOG_PATH != null) {
      return TBSLOG_PATH;
    }
    TBSLOG_PATH = getStandardExternalFilesDir(paramContext, "tbslog");
    return TBSLOG_PATH;
  }
  
  public static FileLock getTbsCoreLoadFileLock(Context paramContext)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    do
    {
      try
      {
        bool = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        if (!bool)
        {
          localObject1 = getLockFos(paramContext, true, "tbs_rename_lock");
          if (localObject1 == null)
          {
            paramContext = localObject2;
            return paramContext;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        do
        {
          for (;;)
          {
            boolean bool = true;
          }
          localObject1 = tryFileLock(paramContext, (FileOutputStream)localObject1);
          paramContext = (Context)localObject1;
        } while (localObject1 != null);
        return localObject1;
      }
      paramContext = getLockFile(paramContext, true, "tbs_rename_lock");
      try
      {
        raf = new RandomAccessFile(paramContext.getAbsolutePath(), "r");
        paramContext = raf.getChannel().tryLock(0L, 9223372036854775807L, true);
        localObject1 = paramContext;
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          paramContext.printStackTrace();
        }
      }
      paramContext = (Context)localObject1;
    } while (localObject1 != null);
    return localObject1;
  }
  
  static String getTbsCorePrivateDir(Context paramContext)
  {
    paramContext = new File(paramContext.getDir("tbs", 0), "core_private");
    if ((paramContext == null) || ((!paramContext.isDirectory()) && (!paramContext.mkdir()))) {
      return null;
    }
    return paramContext.getAbsolutePath();
  }
  
  public static FileLock getTbsCoreRenameFileLock(Context paramContext)
  {
    Object localObject = null;
    paramContext = getLockFile(paramContext, true, "tbs_rename_lock");
    try
    {
      raf = new RandomAccessFile(paramContext.getAbsolutePath(), "rw");
      paramContext = raf.getChannel().tryLock(0L, 9223372036854775807L, false);
      if (paramContext == null) {}
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
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
    throws Exception
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
  
  /* Error */
  private static boolean iterateOverTbsFiles(String paramString1, String paramString2, String paramString3, String paramString4, IterateHandler paramIterateHandler)
    throws Exception
  {
    // Byte code:
    //   0: new 505	java/util/zip/ZipFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 506	java/util/zip/ZipFile:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: iconst_0
    //   10: istore 6
    //   12: iconst_0
    //   13: istore 5
    //   15: aload_0
    //   16: invokevirtual 510	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   19: astore 10
    //   21: aload 10
    //   23: invokeinterface 515 1 0
    //   28: ifeq +318 -> 346
    //   31: aload 10
    //   33: invokeinterface 519 1 0
    //   38: checkcast 179	java/util/zip/ZipEntry
    //   41: astore 11
    //   43: aload 11
    //   45: invokevirtual 520	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   48: astore 13
    //   50: aload 13
    //   52: ifnull -31 -> 21
    //   55: aload 13
    //   57: ldc 24
    //   59: invokevirtual 524	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   62: ifne +13 -> 75
    //   65: aload 13
    //   67: ldc 21
    //   69: invokevirtual 524	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   72: ifeq -51 -> 21
    //   75: aload 13
    //   77: aload 13
    //   79: bipush 47
    //   81: invokevirtual 528	java/lang/String:lastIndexOf	(I)I
    //   84: invokevirtual 532	java/lang/String:substring	(I)Ljava/lang/String;
    //   87: astore 12
    //   89: iload 5
    //   91: istore 7
    //   93: iload 6
    //   95: istore 8
    //   97: aload 12
    //   99: ldc 43
    //   101: invokevirtual 535	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   104: ifeq +45 -> 149
    //   107: aload 13
    //   109: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   112: aload_1
    //   113: iconst_0
    //   114: aload_1
    //   115: invokevirtual 84	java/lang/String:length	()I
    //   118: invokevirtual 539	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   121: ifeq +80 -> 201
    //   124: aload 13
    //   126: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   129: aload_1
    //   130: invokevirtual 84	java/lang/String:length	()I
    //   133: iadd
    //   134: invokevirtual 543	java/lang/String:charAt	(I)C
    //   137: bipush 47
    //   139: if_icmpne +62 -> 201
    //   142: iconst_1
    //   143: istore 8
    //   145: iload 5
    //   147: istore 7
    //   149: aload_0
    //   150: aload 11
    //   152: invokevirtual 547	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   155: astore 13
    //   157: aload 4
    //   159: aload 13
    //   161: aload 11
    //   163: aload 12
    //   165: iconst_1
    //   166: invokevirtual 532	java/lang/String:substring	(I)Ljava/lang/String;
    //   169: invokeinterface 551 4 0
    //   174: istore 9
    //   176: iload 9
    //   178: ifne +178 -> 356
    //   181: aload 13
    //   183: ifnull +8 -> 191
    //   186: aload 13
    //   188: invokevirtual 552	java/io/InputStream:close	()V
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 553	java/util/zip/ZipFile:close	()V
    //   199: iconst_0
    //   200: ireturn
    //   201: aload_2
    //   202: ifnull +56 -> 258
    //   205: aload 13
    //   207: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   210: aload_2
    //   211: iconst_0
    //   212: aload_2
    //   213: invokevirtual 84	java/lang/String:length	()I
    //   216: invokevirtual 539	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   219: ifeq +39 -> 258
    //   222: aload 13
    //   224: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   227: aload_2
    //   228: invokevirtual 84	java/lang/String:length	()I
    //   231: iadd
    //   232: invokevirtual 543	java/lang/String:charAt	(I)C
    //   235: bipush 47
    //   237: if_icmpne +21 -> 258
    //   240: iconst_1
    //   241: istore 7
    //   243: iconst_1
    //   244: istore 5
    //   246: iload 6
    //   248: istore 8
    //   250: iload 6
    //   252: ifeq -103 -> 149
    //   255: goto -234 -> 21
    //   258: aload_3
    //   259: ifnull -238 -> 21
    //   262: aload 13
    //   264: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   267: aload_3
    //   268: iconst_0
    //   269: aload_3
    //   270: invokevirtual 84	java/lang/String:length	()I
    //   273: invokevirtual 539	java/lang/String:regionMatches	(ILjava/lang/String;II)Z
    //   276: ifeq -255 -> 21
    //   279: aload 13
    //   281: getstatic 86	com/tencent/smtt/utils/FileUtil:APK_LIB_LEN	I
    //   284: aload_3
    //   285: invokevirtual 84	java/lang/String:length	()I
    //   288: iadd
    //   289: invokevirtual 543	java/lang/String:charAt	(I)C
    //   292: bipush 47
    //   294: if_icmpne -273 -> 21
    //   297: iload 6
    //   299: ifne -278 -> 21
    //   302: iload 5
    //   304: istore 7
    //   306: iload 6
    //   308: istore 8
    //   310: iload 5
    //   312: ifeq -163 -> 149
    //   315: goto -294 -> 21
    //   318: astore_1
    //   319: aload 13
    //   321: ifnull +8 -> 329
    //   324: aload 13
    //   326: invokevirtual 552	java/io/InputStream:close	()V
    //   329: aload_1
    //   330: athrow
    //   331: astore_2
    //   332: aload_0
    //   333: astore_1
    //   334: aload_2
    //   335: astore_0
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 553	java/util/zip/ZipFile:close	()V
    //   344: aload_0
    //   345: athrow
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokevirtual 553	java/util/zip/ZipFile:close	()V
    //   354: iconst_1
    //   355: ireturn
    //   356: iload 7
    //   358: istore 5
    //   360: iload 8
    //   362: istore 6
    //   364: aload 13
    //   366: ifnull -345 -> 21
    //   369: aload 13
    //   371: invokevirtual 552	java/io/InputStream:close	()V
    //   374: iload 7
    //   376: istore 5
    //   378: iload 8
    //   380: istore 6
    //   382: goto -361 -> 21
    //   385: astore_0
    //   386: aconst_null
    //   387: astore_1
    //   388: goto -52 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	391	0	paramString1	String
    //   0	391	1	paramString2	String
    //   0	391	2	paramString3	String
    //   0	391	3	paramString4	String
    //   0	391	4	paramIterateHandler	IterateHandler
    //   13	364	5	i	int
    //   10	371	6	j	int
    //   91	284	7	k	int
    //   95	284	8	m	int
    //   174	3	9	bool	boolean
    //   19	13	10	localEnumeration	java.util.Enumeration
    //   41	121	11	localZipEntry	ZipEntry
    //   87	77	12	str	String
    //   48	322	13	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   157	176	318	finally
    //   15	21	331	finally
    //   21	50	331	finally
    //   55	75	331	finally
    //   75	89	331	finally
    //   97	142	331	finally
    //   149	157	331	finally
    //   186	191	331	finally
    //   205	240	331	finally
    //   262	297	331	finally
    //   324	329	331	finally
    //   329	331	331	finally
    //   369	374	331	finally
    //   0	9	385	finally
  }
  
  public static FileInputStream openInputStream(File paramFile)
    throws IOException
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
    throws IOException
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
  private static boolean performCopyFile(File paramFile1, File paramFile2, FileFilter paramFileFilter, FileComparator paramFileComparator)
    throws Exception
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
    //   19: invokeinterface 582 2 0
    //   24: ifne +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_0
    //   30: invokevirtual 220	java/io/File:exists	()Z
    //   33: ifeq +14 -> 47
    //   36: aload_0
    //   37: invokevirtual 223	java/io/File:isFile	()Z
    //   40: istore 4
    //   42: iload 4
    //   44: ifne +29 -> 73
    //   47: iconst_0
    //   48: ifeq +11 -> 59
    //   51: new 584	java/lang/NullPointerException
    //   54: dup
    //   55: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   58: athrow
    //   59: iconst_0
    //   60: ifeq +11 -> 71
    //   63: new 584	java/lang/NullPointerException
    //   66: dup
    //   67: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   70: athrow
    //   71: iconst_0
    //   72: ireturn
    //   73: aload_1
    //   74: invokevirtual 220	java/io/File:exists	()Z
    //   77: ifeq +52 -> 129
    //   80: aload_3
    //   81: ifnull +44 -> 125
    //   84: aload_3
    //   85: aload_0
    //   86: aload_1
    //   87: invokeinterface 587 3 0
    //   92: istore 4
    //   94: iload 4
    //   96: ifeq +29 -> 125
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 584	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 584	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_1
    //   124: ireturn
    //   125: aload_1
    //   126: invokestatic 168	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   129: aload_1
    //   130: invokevirtual 575	java/io/File:getParentFile	()Ljava/io/File;
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 223	java/io/File:isFile	()Z
    //   138: ifeq +7 -> 145
    //   141: aload_2
    //   142: invokestatic 168	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   145: aload_2
    //   146: invokevirtual 220	java/io/File:exists	()Z
    //   149: ifne +40 -> 189
    //   152: aload_2
    //   153: invokevirtual 299	java/io/File:mkdirs	()Z
    //   156: istore 4
    //   158: iload 4
    //   160: ifne +29 -> 189
    //   163: iconst_0
    //   164: ifeq +11 -> 175
    //   167: new 584	java/lang/NullPointerException
    //   170: dup
    //   171: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   174: athrow
    //   175: iconst_0
    //   176: ifeq +11 -> 187
    //   179: new 584	java/lang/NullPointerException
    //   182: dup
    //   183: invokespecial 585	java/lang/NullPointerException:<init>	()V
    //   186: athrow
    //   187: iconst_0
    //   188: ireturn
    //   189: new 476	java/io/FileInputStream
    //   192: dup
    //   193: aload_0
    //   194: invokespecial 477	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   197: invokevirtual 588	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   200: astore_2
    //   201: new 152	java/io/FileOutputStream
    //   204: dup
    //   205: aload_1
    //   206: invokespecial 155	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: invokevirtual 589	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   212: astore_3
    //   213: aload_2
    //   214: invokevirtual 592	java/nio/channels/FileChannel:size	()J
    //   217: lstore 5
    //   219: aload_3
    //   220: aload_2
    //   221: lconst_0
    //   222: lload 5
    //   224: invokevirtual 596	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   227: lload 5
    //   229: lcmp
    //   230: ifeq +49 -> 279
    //   233: aload_1
    //   234: invokestatic 168	com/tencent/smtt/utils/FileUtil:delete	(Ljava/io/File;)V
    //   237: aload_2
    //   238: ifnull +7 -> 245
    //   241: aload_2
    //   242: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   245: aload_3
    //   246: ifnull +7 -> 253
    //   249: aload_3
    //   250: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   253: iconst_0
    //   254: ireturn
    //   255: astore_0
    //   256: aconst_null
    //   257: astore_1
    //   258: aload 7
    //   260: astore_2
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   277: aload_0
    //   278: athrow
    //   279: aload_2
    //   280: ifnull +7 -> 287
    //   283: aload_2
    //   284: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 597	java/nio/channels/FileChannel:close	()V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -39 -> 261
    //   303: astore_0
    //   304: aload_3
    //   305: astore_1
    //   306: goto -45 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	paramFile1	File
    //   0	309	1	paramFile2	File
    //   0	309	2	paramFileFilter	FileFilter
    //   0	309	3	paramFileComparator	FileComparator
    //   40	119	4	bool	boolean
    //   217	11	5	l	long
    //   1	258	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	42	255	finally
    //   73	80	255	finally
    //   84	94	255	finally
    //   125	129	255	finally
    //   129	145	255	finally
    //   145	158	255	finally
    //   189	201	255	finally
    //   201	213	297	finally
    //   213	237	303	finally
  }
  
  /* Error */
  public static byte[] read(File paramFile)
    throws OutOfMemoryError
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: ifnonnull +8 -> 14
    //   9: aload 4
    //   11: astore_2
    //   12: aload_2
    //   13: areturn
    //   14: aload_0
    //   15: invokestatic 600	com/tencent/smtt/utils/FileUtil:openInputStream	(Ljava/io/File;)Ljava/io/FileInputStream;
    //   18: astore_0
    //   19: aload_0
    //   20: astore_1
    //   21: aload_0
    //   22: invokestatic 604	com/tencent/smtt/utils/FileUtil:toByteArrayOutputStream	(Ljava/io/InputStream;)Ljava/io/ByteArrayOutputStream;
    //   25: invokevirtual 610	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   28: astore_2
    //   29: aload_2
    //   30: astore_1
    //   31: aload_1
    //   32: astore_2
    //   33: aload_0
    //   34: ifnull -22 -> 12
    //   37: aload_0
    //   38: invokestatic 612	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   41: aload_1
    //   42: areturn
    //   43: astore_2
    //   44: aconst_null
    //   45: astore_0
    //   46: aload_0
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   52: aload 4
    //   54: astore_2
    //   55: aload_0
    //   56: ifnull -44 -> 12
    //   59: aload_3
    //   60: astore_1
    //   61: goto -24 -> 37
    //   64: aload_0
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 613	java/lang/OutOfMemoryError:printStackTrace	()V
    //   70: aload_0
    //   71: astore_1
    //   72: aload_2
    //   73: athrow
    //   74: astore_0
    //   75: aload_1
    //   76: ifnull +7 -> 83
    //   79: aload_1
    //   80: invokestatic 612	com/tencent/smtt/utils/FileUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: aconst_null
    //   87: astore_1
    //   88: goto -13 -> 75
    //   91: astore_2
    //   92: goto -28 -> 64
    //   95: astore_2
    //   96: goto -50 -> 46
    //   99: astore_2
    //   100: aconst_null
    //   101: astore_0
    //   102: goto -38 -> 64
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	paramFile	File
    //   20	68	1	localObject1	Object
    //   11	22	2	localObject2	Object
    //   43	6	2	localException1	Exception
    //   54	19	2	localObject3	Object
    //   91	1	2	localOutOfMemoryError1	OutOfMemoryError
    //   95	1	2	localException2	Exception
    //   99	1	2	localOutOfMemoryError2	OutOfMemoryError
    //   1	59	3	localObject4	Object
    //   3	50	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   14	19	43	java/lang/Exception
    //   21	29	74	finally
    //   48	52	74	finally
    //   66	70	74	finally
    //   72	74	74	finally
    //   14	19	85	finally
    //   21	29	91	java/lang/OutOfMemoryError
    //   21	29	95	java/lang/Exception
    //   14	19	99	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static void releaseTbsCoreRenameFileLock(Context paramContext, FileLock paramFileLock)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: invokevirtual 307	java/nio/channels/FileLock:channel	()Ljava/nio/channels/FileChannel;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnull +16 -> 25
    //   12: aload_0
    //   13: invokevirtual 312	java/nio/channels/FileChannel:isOpen	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifeq +7 -> 25
    //   21: aload_1
    //   22: invokevirtual 315	java/nio/channels/FileLock:release	()V
    //   25: ldc 2
    //   27: monitorexit
    //   28: return
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 339	java/io/IOException:printStackTrace	()V
    //   34: goto -9 -> 25
    //   37: astore_0
    //   38: ldc 2
    //   40: monitorexit
    //   41: aload_0
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	paramContext	Context
    //   0	43	1	paramFileLock	FileLock
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	25	29	java/io/IOException
    //   3	8	37	finally
    //   12	17	37	finally
    //   21	25	37	finally
    //   30	34	37	finally
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
  
  public static byte[] toByteArray(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
  {
    return toByteArrayOutputStream(paramInputStream).toByteArray();
  }
  
  public static ByteArrayOutputStream toByteArrayOutputStream(InputStream paramInputStream)
    throws IOException, OutOfMemoryError
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
  
  public static abstract interface FileComparator
  {
    public abstract boolean equals(File paramFile1, File paramFile2);
  }
  
  public static abstract interface IterateHandler
  {
    public abstract boolean handleEntry(InputStream paramInputStream, ZipEntry paramZipEntry, String paramString)
      throws Exception;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */