package com.tencent.mobileqq.intervideo.now;

import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.io.File;
import java.util.zip.ZipOutputStream;

public class LogUploadUtil
{
  private static final String a;
  private static final String b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/Tencent/wns/logs/com.tencent.qqplugin");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append("/Tencent/wns/logs/qqplugin.zip");
    b = localStringBuilder.toString();
  }
  
  private static void a(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    if (paramFile.isDirectory())
    {
      b(paramFile, paramZipOutputStream, paramString);
      return;
    }
    c(paramFile, paramZipOutputStream, paramString);
  }
  
  public static void a(String paramString)
  {
    ThreadManagerV2.excute(new LogUploadUtil.1(paramString), 16, null, false);
  }
  
  /* Error */
  static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +168 -> 169
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 44	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: new 44	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: astore_1
    //   28: aload 4
    //   30: invokevirtual 69	java/io/File:exists	()Z
    //   33: ifeq +100 -> 133
    //   36: aconst_null
    //   37: astore_3
    //   38: new 71	java/io/FileOutputStream
    //   41: dup
    //   42: aload_1
    //   43: invokespecial 74	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   46: astore_1
    //   47: new 76	java/util/zip/ZipOutputStream
    //   50: dup
    //   51: new 78	java/util/zip/CheckedOutputStream
    //   54: dup
    //   55: aload_1
    //   56: new 80	java/util/zip/CRC32
    //   59: dup
    //   60: invokespecial 81	java/util/zip/CRC32:<init>	()V
    //   63: invokespecial 84	java/util/zip/CheckedOutputStream:<init>	(Ljava/io/OutputStream;Ljava/util/zip/Checksum;)V
    //   66: invokespecial 87	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   69: astore_2
    //   70: aload 4
    //   72: aload_2
    //   73: ldc 89
    //   75: invokestatic 91	com/tencent/mobileqq/intervideo/now/LogUploadUtil:a	(Ljava/io/File;Ljava/util/zip/ZipOutputStream;Ljava/lang/String;)V
    //   78: aload_2
    //   79: invokevirtual 94	java/util/zip/ZipOutputStream:close	()V
    //   82: iconst_0
    //   83: ifeq +11 -> 94
    //   86: new 96	java/lang/NullPointerException
    //   89: dup
    //   90: invokespecial 97	java/lang/NullPointerException:<init>	()V
    //   93: athrow
    //   94: return
    //   95: astore_0
    //   96: goto +14 -> 110
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_2
    //   102: goto +8 -> 110
    //   105: astore_0
    //   106: aconst_null
    //   107: astore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +12 -> 123
    //   114: aload_2
    //   115: invokevirtual 94	java/util/zip/ZipOutputStream:close	()V
    //   118: aload_3
    //   119: astore_1
    //   120: goto +3 -> 123
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   131: aload_0
    //   132: athrow
    //   133: new 11	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   140: astore_1
    //   141: aload_1
    //   142: aload_0
    //   143: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_1
    //   148: ldc 99
    //   150: invokestatic 104	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   153: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: new 106	java/io/FileNotFoundException
    //   160: dup
    //   161: aload_1
    //   162: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokespecial 107	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   168: athrow
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString1	String
    //   0	170	1	paramString2	String
    //   69	46	2	localZipOutputStream	ZipOutputStream
    //   37	82	3	localObject	Object
    //   17	54	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   70	78	95	finally
    //   47	70	99	finally
    //   38	47	105	finally
  }
  
  private static void b(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    File[] arrayOfFile = paramFile.listFiles();
    int i = 0;
    while (i < arrayOfFile.length)
    {
      File localFile = arrayOfFile[i];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramFile.getName());
      localStringBuilder.append("/");
      a(localFile, paramZipOutputStream, localStringBuilder.toString());
      i += 1;
    }
  }
  
  /* Error */
  private static void c(File paramFile, ZipOutputStream paramZipOutputStream, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 69	java/io/File:exists	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: new 118	java/io/BufferedInputStream
    //   11: dup
    //   12: new 120	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 121	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   20: invokespecial 124	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore 4
    //   25: new 11	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 14	java/lang/StringBuilder:<init>	()V
    //   32: astore 5
    //   34: aload 5
    //   36: aload_2
    //   37: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: aload_0
    //   44: invokevirtual 114	java/io/File:getName	()Ljava/lang/String;
    //   47: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_1
    //   52: new 126	java/util/zip/ZipEntry
    //   55: dup
    //   56: aload 5
    //   58: invokevirtual 33	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokespecial 127	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   64: invokevirtual 131	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   67: sipush 8192
    //   70: newarray byte
    //   72: astore_0
    //   73: aload 4
    //   75: aload_0
    //   76: iconst_0
    //   77: sipush 8192
    //   80: invokevirtual 135	java/io/BufferedInputStream:read	([BII)I
    //   83: istore_3
    //   84: iload_3
    //   85: iconst_m1
    //   86: if_icmpeq +13 -> 99
    //   89: aload_1
    //   90: aload_0
    //   91: iconst_0
    //   92: iload_3
    //   93: invokevirtual 139	java/util/zip/ZipOutputStream:write	([BII)V
    //   96: goto -23 -> 73
    //   99: aload 4
    //   101: invokevirtual 140	java/io/BufferedInputStream:close	()V
    //   104: return
    //   105: astore_1
    //   106: aload 4
    //   108: astore_0
    //   109: goto +6 -> 115
    //   112: astore_1
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +7 -> 123
    //   119: aload_0
    //   120: invokevirtual 140	java/io/BufferedInputStream:close	()V
    //   123: goto +5 -> 128
    //   126: aload_1
    //   127: athrow
    //   128: goto -2 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramFile	File
    //   0	131	1	paramZipOutputStream	ZipOutputStream
    //   0	131	2	paramString	String
    //   83	10	3	i	int
    //   23	84	4	localBufferedInputStream	java.io.BufferedInputStream
    //   32	25	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   25	73	105	finally
    //   73	84	105	finally
    //   89	96	105	finally
    //   8	25	112	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.LogUploadUtil
 * JD-Core Version:    0.7.0.1
 */