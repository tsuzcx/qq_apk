package com.tencent.mobileqq.kandian.base.utils;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;

public class ZipUtil
{
  private static File a(File paramFile, ZipEntry paramZipEntry)
  {
    File localFile = new File(paramFile, paramZipEntry.getName());
    paramFile = paramFile.getCanonicalPath();
    String str = localFile.getCanonicalPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(File.separator);
    if (str.startsWith(localStringBuilder.toString())) {
      return localFile;
    }
    paramFile = new StringBuilder();
    paramFile.append("Entry is outside of the target dir: ");
    paramFile.append(paramZipEntry.getName());
    throw new IOException(paramFile.toString());
  }
  
  private static void a(File paramFile)
  {
    if (!paramFile.isDirectory())
    {
      if (paramFile.mkdirs()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to create directory ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  /* Error */
  private static void a(java.util.zip.ZipInputStream paramZipInputStream, File paramFile, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 72	java/io/File:getParentFile	()Ljava/io/File;
    //   4: astore 4
    //   6: aload 4
    //   8: invokevirtual 57	java/io/File:isDirectory	()Z
    //   11: ifne +48 -> 59
    //   14: aload 4
    //   16: invokevirtual 60	java/io/File:mkdirs	()Z
    //   19: ifeq +6 -> 25
    //   22: goto +37 -> 59
    //   25: new 27	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   32: astore_0
    //   33: aload_0
    //   34: ldc 62
    //   36: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: aload 4
    //   43: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: new 49	java/io/IOException
    //   50: dup
    //   51: aload_0
    //   52: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 52	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   58: athrow
    //   59: new 74	java/io/BufferedOutputStream
    //   62: dup
    //   63: new 76	java/io/FileOutputStream
    //   66: dup
    //   67: aload_1
    //   68: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   71: invokespecial 81	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   74: astore 5
    //   76: aconst_null
    //   77: astore 4
    //   79: aload 4
    //   81: astore_1
    //   82: aload_0
    //   83: aload_2
    //   84: invokevirtual 87	java/util/zip/ZipInputStream:read	([B)I
    //   87: istore_3
    //   88: iload_3
    //   89: ifle +17 -> 106
    //   92: aload 4
    //   94: astore_1
    //   95: aload 5
    //   97: aload_2
    //   98: iconst_0
    //   99: iload_3
    //   100: invokevirtual 91	java/io/BufferedOutputStream:write	([BII)V
    //   103: goto -24 -> 79
    //   106: aload 5
    //   108: invokevirtual 94	java/io/BufferedOutputStream:close	()V
    //   111: return
    //   112: astore_0
    //   113: goto +8 -> 121
    //   116: astore_0
    //   117: aload_0
    //   118: astore_1
    //   119: aload_0
    //   120: athrow
    //   121: aload_1
    //   122: ifnull +11 -> 133
    //   125: aload 5
    //   127: invokevirtual 94	java/io/BufferedOutputStream:close	()V
    //   130: goto +8 -> 138
    //   133: aload 5
    //   135: invokevirtual 94	java/io/BufferedOutputStream:close	()V
    //   138: goto +5 -> 143
    //   141: aload_0
    //   142: athrow
    //   143: goto -2 -> 141
    //   146: astore_1
    //   147: goto -9 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramZipInputStream	java.util.zip.ZipInputStream
    //   0	150	1	paramFile	File
    //   0	150	2	paramArrayOfByte	byte[]
    //   87	13	3	i	int
    //   4	89	4	localFile	File
    //   74	60	5	localBufferedOutputStream	java.io.BufferedOutputStream
    // Exception table:
    //   from	to	target	type
    //   82	88	112	finally
    //   95	103	112	finally
    //   119	121	112	finally
    //   82	88	116	java/lang/Throwable
    //   95	103	116	java/lang/Throwable
    //   125	130	146	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(android.content.Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: new 99	java/io/BufferedInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 105	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: aload_1
    //   15: invokevirtual 111	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   18: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore 6
    //   23: aconst_null
    //   24: astore_0
    //   25: aload 6
    //   27: new 13	java/io/File
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: invokestatic 118	com/tencent/mobileqq/kandian/base/utils/ZipUtil:a	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   38: istore 5
    //   40: iload 5
    //   42: istore_3
    //   43: aload 6
    //   45: invokevirtual 121	java/io/InputStream:close	()V
    //   48: iload 5
    //   50: ireturn
    //   51: astore_1
    //   52: goto +8 -> 60
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_1
    //   59: athrow
    //   60: aload_0
    //   61: ifnull +14 -> 75
    //   64: iload 4
    //   66: istore_3
    //   67: aload 6
    //   69: invokevirtual 121	java/io/InputStream:close	()V
    //   72: goto +11 -> 83
    //   75: iload 4
    //   77: istore_3
    //   78: aload 6
    //   80: invokevirtual 121	java/io/InputStream:close	()V
    //   83: iload 4
    //   85: istore_3
    //   86: aload_1
    //   87: athrow
    //   88: astore_0
    //   89: ldc 123
    //   91: iconst_1
    //   92: ldc 125
    //   94: aload_0
    //   95: invokestatic 131	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   98: iload_3
    //   99: ireturn
    //   100: astore_0
    //   101: goto -18 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	paramContext	android.content.Context
    //   0	104	1	paramString1	String
    //   0	104	2	paramString2	String
    //   5	94	3	bool1	boolean
    //   1	83	4	bool2	boolean
    //   38	11	5	bool3	boolean
    //   21	58	6	localBufferedInputStream	java.io.BufferedInputStream
    // Exception table:
    //   from	to	target	type
    //   25	40	51	finally
    //   58	60	51	finally
    //   25	40	55	java/lang/Throwable
    //   6	23	88	java/lang/Exception
    //   43	48	88	java/lang/Exception
    //   67	72	88	java/lang/Exception
    //   78	83	88	java/lang/Exception
    //   86	88	88	java/lang/Exception
    //   67	72	100	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(@Nullable InputStream paramInputStream, @Nullable File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokestatic 135	com/tencent/mobileqq/kandian/base/utils/ZipUtil:b	(Ljava/io/InputStream;Ljava/io/File;)Z
    //   5: istore_3
    //   6: iconst_0
    //   7: istore_2
    //   8: iload_3
    //   9: ifne +5 -> 14
    //   12: iconst_0
    //   13: ireturn
    //   14: new 83	java/util/zip/ZipInputStream
    //   17: dup
    //   18: new 99	java/io/BufferedInputStream
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 114	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: invokespecial 136	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 6
    //   31: aconst_null
    //   32: astore 5
    //   34: aload 5
    //   36: astore_0
    //   37: aload_1
    //   38: invokevirtual 60	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload 5
    //   44: astore_0
    //   45: aload 6
    //   47: invokevirtual 140	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   50: astore 4
    //   52: aload 5
    //   54: astore_0
    //   55: sipush 4096
    //   58: newarray byte
    //   60: astore 7
    //   62: aload 4
    //   64: ifnull +61 -> 125
    //   67: aload 5
    //   69: astore_0
    //   70: aload_1
    //   71: aload 4
    //   73: invokestatic 142	com/tencent/mobileqq/kandian/base/utils/ZipUtil:a	(Ljava/io/File;Ljava/util/zip/ZipEntry;)Ljava/io/File;
    //   76: astore 8
    //   78: aload 5
    //   80: astore_0
    //   81: aload 4
    //   83: invokevirtual 143	java/util/zip/ZipEntry:isDirectory	()Z
    //   86: ifeq +14 -> 100
    //   89: aload 5
    //   91: astore_0
    //   92: aload 8
    //   94: invokestatic 145	com/tencent/mobileqq/kandian/base/utils/ZipUtil:a	(Ljava/io/File;)V
    //   97: goto +15 -> 112
    //   100: aload 5
    //   102: astore_0
    //   103: aload 6
    //   105: aload 8
    //   107: aload 7
    //   109: invokestatic 147	com/tencent/mobileqq/kandian/base/utils/ZipUtil:a	(Ljava/util/zip/ZipInputStream;Ljava/io/File;[B)V
    //   112: aload 5
    //   114: astore_0
    //   115: aload 6
    //   117: invokevirtual 140	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   120: astore 4
    //   122: goto -60 -> 62
    //   125: aload 5
    //   127: astore_0
    //   128: aload 6
    //   130: invokevirtual 150	java/util/zip/ZipInputStream:closeEntry	()V
    //   133: aload 6
    //   135: invokevirtual 151	java/util/zip/ZipInputStream:close	()V
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_0
    //   141: iconst_1
    //   142: istore_2
    //   143: goto +32 -> 175
    //   146: astore_1
    //   147: goto +8 -> 155
    //   150: astore_1
    //   151: aload_1
    //   152: astore_0
    //   153: aload_1
    //   154: athrow
    //   155: aload_0
    //   156: ifnull +11 -> 167
    //   159: aload 6
    //   161: invokevirtual 151	java/util/zip/ZipInputStream:close	()V
    //   164: goto +8 -> 172
    //   167: aload 6
    //   169: invokevirtual 151	java/util/zip/ZipInputStream:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_0
    //   175: ldc 123
    //   177: iconst_1
    //   178: ldc 153
    //   180: aload_0
    //   181: invokestatic 131	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   184: iload_2
    //   185: ireturn
    //   186: astore_0
    //   187: goto -15 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramInputStream	InputStream
    //   0	190	1	paramFile	File
    //   7	178	2	bool1	boolean
    //   5	4	3	bool2	boolean
    //   50	71	4	localZipEntry	ZipEntry
    //   32	94	5	localObject	Object
    //   29	139	6	localZipInputStream	java.util.zip.ZipInputStream
    //   60	48	7	arrayOfByte	byte[]
    //   76	30	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   133	138	140	java/io/IOException
    //   37	42	146	finally
    //   45	52	146	finally
    //   55	62	146	finally
    //   70	78	146	finally
    //   81	89	146	finally
    //   92	97	146	finally
    //   103	112	146	finally
    //   115	122	146	finally
    //   128	133	146	finally
    //   153	155	146	finally
    //   37	42	150	java/lang/Throwable
    //   45	52	150	java/lang/Throwable
    //   55	62	150	java/lang/Throwable
    //   70	78	150	java/lang/Throwable
    //   81	89	150	java/lang/Throwable
    //   92	97	150	java/lang/Throwable
    //   103	112	150	java/lang/Throwable
    //   115	122	150	java/lang/Throwable
    //   128	133	150	java/lang/Throwable
    //   14	31	174	java/io/IOException
    //   159	164	174	java/io/IOException
    //   167	172	174	java/io/IOException
    //   172	174	174	java/io/IOException
    //   159	164	186	java/lang/Throwable
  }
  
  private static boolean b(@Nullable InputStream paramInputStream, @Nullable File paramFile)
  {
    if ((paramInputStream != null) && (paramFile != null)) {
      return true;
    }
    QLog.w("ZipUtil", 1, "unzip, params is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ZipUtil
 * JD-Core Version:    0.7.0.1
 */