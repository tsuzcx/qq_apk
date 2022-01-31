package com.tencent.proxyinner.utility;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class LogUploadUtil
{
  private static final int BUFFER = 8192;
  private static final String TAG = "FileUtil";
  private static final String dstPath = Environment.getExternalStorageDirectory() + "/Tencent/wns/logs/qqplugin.zip";
  private static final String srcPath = Environment.getExternalStorageDirectory() + "/Tencent/wns/logs/com.tencent.qqplugin";
  
  private static void compress(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    if (paramFile.isDirectory())
    {
      compressDirectory(paramFile, paramZipOutputStream, paramString);
      return;
    }
    compressFile(paramFile, paramZipOutputStream, paramString);
  }
  
  /* Error */
  static void compress(String paramString1, String paramString2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 57	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: new 57	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload 4
    //   30: invokevirtual 75	java/io/File:exists	()Z
    //   33: ifne +30 -> 63
    //   36: new 77	java/io/FileNotFoundException
    //   39: dup
    //   40: new 19	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   47: aload_0
    //   48: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 79
    //   53: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 80	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   62: athrow
    //   63: aconst_null
    //   64: astore_3
    //   65: aconst_null
    //   66: astore_2
    //   67: new 82	java/io/FileOutputStream
    //   70: dup
    //   71: aload_1
    //   72: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   75: astore_0
    //   76: new 87	java/util/zip/ZipOutputStream
    //   79: dup
    //   80: new 89	java/util/zip/CheckedOutputStream
    //   83: dup
    //   84: aload_0
    //   85: new 91	java/util/zip/CRC32
    //   88: dup
    //   89: invokespecial 92	java/util/zip/CRC32:<init>	()V
    //   92: invokespecial 95	java/util/zip/CheckedOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/zip/Checksum;)V
    //   95: invokespecial 98	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   98: astore_3
    //   99: aload 4
    //   101: aload_3
    //   102: ldc 100
    //   104: invokestatic 102	com/tencent/proxyinner/utility/LogUploadUtil:compress	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   107: aload_3
    //   108: ifnull +51 -> 159
    //   111: aload_3
    //   112: invokevirtual 105	java/util/zip/ZipOutputStream:close	()V
    //   115: aconst_null
    //   116: astore_0
    //   117: aload_0
    //   118: ifnull -110 -> 8
    //   121: aload_0
    //   122: invokevirtual 106	java/io/FileOutputStream:close	()V
    //   125: return
    //   126: astore_1
    //   127: aload_3
    //   128: astore_0
    //   129: aload_2
    //   130: ifnull +9 -> 139
    //   133: aload_2
    //   134: invokevirtual 105	java/util/zip/ZipOutputStream:close	()V
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 106	java/io/FileOutputStream:close	()V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_1
    //   154: aload_3
    //   155: astore_2
    //   156: goto -27 -> 129
    //   159: goto -42 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString1	String
    //   0	162	1	paramString2	String
    //   66	90	2	localZipOutputStream1	ZipOutputStream
    //   64	91	3	localZipOutputStream2	ZipOutputStream
    //   17	83	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   67	76	126	finally
    //   76	99	149	finally
    //   99	107	153	finally
  }
  
  private static void compressDirectory(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      compress(arrayOfFile[i], paramZipOutputStream, paramString + paramFile.getName() + "/");
      i += 1;
    }
  }
  
  private static void compressFile(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
    throws IOException
  {
    if (!paramFile.exists()) {}
    label104:
    do
    {
      return;
      localObject = null;
      try
      {
        localBufferedInputStream = new BufferedInputStream(new FileInputStream(paramFile));
        try
        {
          paramZipOutputStream.putNextEntry(new ZipEntry(paramString + paramFile.getName()));
          paramFile = new byte[8192];
          for (;;)
          {
            int i = localBufferedInputStream.read(paramFile, 0, 8192);
            if (i == -1) {
              break;
            }
            paramZipOutputStream.write(paramFile, 0, i);
          }
          if (paramFile == null) {
            break label104;
          }
        }
        finally
        {
          paramFile = localBufferedInputStream;
        }
      }
      finally
      {
        for (;;)
        {
          BufferedInputStream localBufferedInputStream;
          paramFile = localObject;
        }
      }
      paramFile.close();
      throw paramZipOutputStream;
    } while (localBufferedInputStream == null);
    localBufferedInputStream.close();
  }
  
  public static void upload(String paramString)
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          long l = System.currentTimeMillis();
          LogUploadUtil.compress(LogUploadUtil.srcPath, LogUploadUtil.dstPath);
          Log.i("FileUtil", "compress time " + (System.currentTimeMillis() - l));
          FileUploadUtil.upload(this.val$uin, LogUploadUtil.dstPath);
          return;
        }
        catch (IOException localIOException)
        {
          Log.e("FileUtil", localIOException.getLocalizedMessage());
        }
      }
    }).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.proxyinner.utility.LogUploadUtil
 * JD-Core Version:    0.7.0.1
 */