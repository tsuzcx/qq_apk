package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipFile;

public class FileUtil
{
  private static final String TAG = "VasUpdate_FileUtil";
  
  public static void checkFilePathExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    File localFile = new File(paramString);
    Object localObject3 = null;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    Object localObject1 = paramString;
    while (!localFile.isDirectory())
    {
      int i = ((String)localObject1).lastIndexOf(File.separator);
      Object localObject2;
      if (i > 0)
      {
        localObject2 = ((String)localObject1).substring(0, i);
        localFile = new File((String)localObject2);
        localObject3 = localObject1;
        localObject1 = localObject2;
      }
      else
      {
        localObject1 = VasUpdateWrapper.getLog();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkFileExist no dir path = ");
        ((StringBuilder)localObject2).append(paramString);
        ((IVasLog)localObject1).c("VasUpdate_FileUtil", ((StringBuilder)localObject2).toString());
        return;
      }
    }
    if (!TextUtils.isEmpty(localObject3)) {
      new File(localObject3).delete();
    }
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_1
    //   9: invokevirtual 29	java/io/File:exists	()Z
    //   12: ifeq +8 -> 20
    //   15: aload_1
    //   16: invokevirtual 76	java/io/File:delete	()Z
    //   19: pop
    //   20: aload_1
    //   21: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   24: ifnull +21 -> 45
    //   27: aload_1
    //   28: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   31: invokevirtual 29	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_1
    //   38: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   41: invokevirtual 32	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: new 88	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   53: astore 5
    //   55: new 93	java/io/BufferedInputStream
    //   58: dup
    //   59: new 95	java/io/FileInputStream
    //   62: dup
    //   63: aload_0
    //   64: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   67: invokespecial 99	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   70: astore_0
    //   71: sipush 4096
    //   74: newarray byte
    //   76: astore_1
    //   77: aload_0
    //   78: aload_1
    //   79: invokevirtual 103	java/io/BufferedInputStream:read	([B)I
    //   82: istore_2
    //   83: iload_2
    //   84: iconst_m1
    //   85: if_icmpeq +19 -> 104
    //   88: aload 5
    //   90: aload_1
    //   91: iconst_0
    //   92: iload_2
    //   93: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   96: aload 5
    //   98: invokevirtual 110	java/io/FileOutputStream:flush	()V
    //   101: goto -24 -> 77
    //   104: iconst_1
    //   105: istore_3
    //   106: aload 5
    //   108: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   111: goto +21 -> 132
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   119: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   122: ldc 8
    //   124: ldc 118
    //   126: aload_1
    //   127: invokeinterface 122 4 0
    //   132: aload_0
    //   133: invokevirtual 123	java/io/BufferedInputStream:close	()V
    //   136: iconst_1
    //   137: ireturn
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   143: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   146: ldc 8
    //   148: ldc 118
    //   150: aload_0
    //   151: invokeinterface 122 4 0
    //   156: iload_3
    //   157: ireturn
    //   158: astore_1
    //   159: goto +13 -> 172
    //   162: astore 4
    //   164: aload_0
    //   165: astore_1
    //   166: goto +20 -> 186
    //   169: astore_1
    //   170: aconst_null
    //   171: astore_0
    //   172: aload 5
    //   174: astore 4
    //   176: aload_0
    //   177: astore 5
    //   179: goto +96 -> 275
    //   182: astore 4
    //   184: aconst_null
    //   185: astore_1
    //   186: aload 5
    //   188: astore_0
    //   189: goto +17 -> 206
    //   192: astore_1
    //   193: aconst_null
    //   194: astore 5
    //   196: goto +79 -> 275
    //   199: astore 4
    //   201: aconst_null
    //   202: astore_1
    //   203: aload 6
    //   205: astore_0
    //   206: aload 4
    //   208: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   211: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   214: ldc 8
    //   216: ldc 118
    //   218: aload 4
    //   220: invokeinterface 122 4 0
    //   225: aload_0
    //   226: ifnull +28 -> 254
    //   229: aload_0
    //   230: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   233: goto +21 -> 254
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   241: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   244: ldc 8
    //   246: ldc 118
    //   248: aload_0
    //   249: invokeinterface 122 4 0
    //   254: aload_1
    //   255: ifnull +7 -> 262
    //   258: aload_1
    //   259: invokevirtual 123	java/io/BufferedInputStream:close	()V
    //   262: iconst_0
    //   263: ireturn
    //   264: astore 4
    //   266: aload_1
    //   267: astore 5
    //   269: aload 4
    //   271: astore_1
    //   272: aload_0
    //   273: astore 4
    //   275: aload 4
    //   277: ifnull +29 -> 306
    //   280: aload 4
    //   282: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   285: goto +21 -> 306
    //   288: astore_0
    //   289: aload_0
    //   290: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   293: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   296: ldc 8
    //   298: ldc 118
    //   300: aload_0
    //   301: invokeinterface 122 4 0
    //   306: aload 5
    //   308: ifnull +29 -> 337
    //   311: aload 5
    //   313: invokevirtual 123	java/io/BufferedInputStream:close	()V
    //   316: goto +21 -> 337
    //   319: astore_0
    //   320: aload_0
    //   321: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   324: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   327: ldc 8
    //   329: ldc 118
    //   331: aload_0
    //   332: invokeinterface 122 4 0
    //   337: goto +5 -> 342
    //   340: aload_1
    //   341: athrow
    //   342: goto -2 -> 340
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	paramFile1	File
    //   0	345	1	paramFile2	File
    //   82	11	2	i	int
    //   1	156	3	bool	boolean
    //   3	1	4	localObject1	Object
    //   162	1	4	localThrowable1	Throwable
    //   174	1	4	localObject2	Object
    //   182	1	4	localThrowable2	Throwable
    //   199	20	4	localThrowable3	Throwable
    //   264	6	4	localObject3	Object
    //   273	8	4	localFile	File
    //   53	259	5	localObject4	Object
    //   6	198	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   106	111	114	java/io/IOException
    //   132	136	138	java/io/IOException
    //   258	262	138	java/io/IOException
    //   71	77	158	finally
    //   77	83	158	finally
    //   88	101	158	finally
    //   71	77	162	java/lang/Throwable
    //   77	83	162	java/lang/Throwable
    //   88	101	162	java/lang/Throwable
    //   55	71	169	finally
    //   55	71	182	java/lang/Throwable
    //   8	20	192	finally
    //   20	45	192	finally
    //   45	55	192	finally
    //   8	20	199	java/lang/Throwable
    //   20	45	199	java/lang/Throwable
    //   45	55	199	java/lang/Throwable
    //   229	233	236	java/io/IOException
    //   206	225	264	finally
    //   280	285	288	java/io/IOException
    //   311	316	319	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {
      try
      {
        boolean bool = copyFile(paramString1, createFile(paramString2));
        return bool;
      }
      catch (Throwable paramString1)
      {
        paramString1.printStackTrace();
        VasUpdateWrapper.getLog().a("VasUpdate_FileUtil", "copyFile exception", paramString1);
      }
    }
    return false;
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      if (paramString.exists()) {
        return paramString;
      }
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else
      {
        paramString.createNewFile();
        return paramString;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      VasUpdateWrapper.getLog().a("VasUpdate_FileUtil", "createFile exception", localThrowable);
    }
    return paramString;
  }
  
  public static void deleteFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static boolean filePatch(String paramString1, String paramString2)
  {
    return false;
  }
  
  private static void handleClose(OutputStream paramOutputStream, InputStream paramInputStream, ZipFile paramZipFile)
  {
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.close();
      }
      catch (Exception paramOutputStream)
      {
        paramOutputStream.printStackTrace();
        VasUpdateWrapper.getLog().a("VasUpdate_FileUtil", "unCompressFile close error: ", paramOutputStream);
      }
    }
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (Exception paramOutputStream)
      {
        paramOutputStream.printStackTrace();
        VasUpdateWrapper.getLog().a("VasUpdate_FileUtil", "unCompressFile close error: ", paramOutputStream);
      }
    }
    if (paramZipFile != null) {
      try
      {
        paramZipFile.close();
        return;
      }
      catch (Exception paramOutputStream)
      {
        paramOutputStream.printStackTrace();
        VasUpdateWrapper.getLog().a("VasUpdate_FileUtil", "unCompressFile close error: ", paramOutputStream);
      }
    }
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_0
    //   4: invokevirtual 160	java/io/File:length	()J
    //   7: l2i
    //   8: istore_2
    //   9: new 162	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: iload_2
    //   14: invokespecial 165	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore 4
    //   19: new 93	java/io/BufferedInputStream
    //   22: dup
    //   23: new 95	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: invokespecial 99	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   34: astore_0
    //   35: aload 4
    //   37: astore 5
    //   39: aload_0
    //   40: astore 6
    //   42: sipush 4096
    //   45: newarray byte
    //   47: astore 7
    //   49: iconst_0
    //   50: istore_1
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +40 -> 93
    //   56: aload 4
    //   58: astore 5
    //   60: aload_0
    //   61: astore 6
    //   63: aload_0
    //   64: aload 7
    //   66: invokevirtual 166	java/io/InputStream:read	([B)I
    //   69: istore_3
    //   70: aload 4
    //   72: astore 5
    //   74: aload_0
    //   75: astore 6
    //   77: aload 4
    //   79: aload 7
    //   81: iconst_0
    //   82: iload_3
    //   83: invokevirtual 167	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_3
    //   88: iadd
    //   89: istore_1
    //   90: goto -39 -> 51
    //   93: aload 4
    //   95: astore 5
    //   97: aload_0
    //   98: astore 6
    //   100: aload 4
    //   102: ldc 169
    //   104: invokevirtual 172	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 7
    //   109: aload 7
    //   111: astore 5
    //   113: aload 4
    //   115: invokevirtual 173	java/io/ByteArrayOutputStream:close	()V
    //   118: aload 7
    //   120: astore 5
    //   122: aload_0
    //   123: invokevirtual 151	java/io/InputStream:close	()V
    //   126: aload 7
    //   128: areturn
    //   129: astore_0
    //   130: aload_0
    //   131: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   134: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   137: ldc 8
    //   139: ldc 175
    //   141: aload_0
    //   142: invokeinterface 122 4 0
    //   147: aload 5
    //   149: areturn
    //   150: astore 7
    //   152: goto +36 -> 188
    //   155: astore_0
    //   156: aconst_null
    //   157: astore 6
    //   159: goto +95 -> 254
    //   162: astore 7
    //   164: aconst_null
    //   165: astore_0
    //   166: goto +22 -> 188
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 4
    //   173: aload 4
    //   175: astore 6
    //   177: goto +77 -> 254
    //   180: astore 7
    //   182: aconst_null
    //   183: astore 4
    //   185: aload 4
    //   187: astore_0
    //   188: aload 4
    //   190: astore 5
    //   192: aload_0
    //   193: astore 6
    //   195: aload 7
    //   197: invokevirtual 124	java/lang/Throwable:printStackTrace	()V
    //   200: aload 4
    //   202: astore 5
    //   204: aload_0
    //   205: astore 6
    //   207: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   210: ldc 8
    //   212: ldc 175
    //   214: aload 7
    //   216: invokeinterface 122 4 0
    //   221: aload 4
    //   223: ifnull +12 -> 235
    //   226: aload 8
    //   228: astore 5
    //   230: aload 4
    //   232: invokevirtual 173	java/io/ByteArrayOutputStream:close	()V
    //   235: aload_0
    //   236: ifnull +11 -> 247
    //   239: aload 8
    //   241: astore 5
    //   243: aload_0
    //   244: invokevirtual 151	java/io/InputStream:close	()V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: aload 5
    //   252: astore 4
    //   254: aload 4
    //   256: ifnull +11 -> 267
    //   259: aload 4
    //   261: invokevirtual 173	java/io/ByteArrayOutputStream:close	()V
    //   264: goto +3 -> 267
    //   267: aload 6
    //   269: ifnull +30 -> 299
    //   272: aload 6
    //   274: invokevirtual 151	java/io/InputStream:close	()V
    //   277: goto +22 -> 299
    //   280: aload 4
    //   282: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   285: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   288: ldc 8
    //   290: ldc 175
    //   292: aload 4
    //   294: invokeinterface 122 4 0
    //   299: goto +5 -> 304
    //   302: aload_0
    //   303: athrow
    //   304: goto -2 -> 302
    //   307: astore 4
    //   309: goto -29 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramFile	File
    //   50	40	1	i	int
    //   8	46	2	j	int
    //   69	20	3	k	int
    //   17	276	4	localObject1	Object
    //   307	1	4	localIOException	IOException
    //   37	214	5	localObject2	Object
    //   40	233	6	localObject3	Object
    //   47	80	7	localObject4	Object
    //   150	1	7	localThrowable1	Throwable
    //   162	1	7	localThrowable2	Throwable
    //   180	35	7	localThrowable3	Throwable
    //   1	239	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   113	118	129	java/io/IOException
    //   122	126	129	java/io/IOException
    //   230	235	129	java/io/IOException
    //   243	247	129	java/io/IOException
    //   42	49	150	java/lang/Throwable
    //   63	70	150	java/lang/Throwable
    //   77	86	150	java/lang/Throwable
    //   100	109	150	java/lang/Throwable
    //   19	35	155	finally
    //   19	35	162	java/lang/Throwable
    //   3	19	169	finally
    //   3	19	180	java/lang/Throwable
    //   42	49	249	finally
    //   63	70	249	finally
    //   77	86	249	finally
    //   100	109	249	finally
    //   195	200	249	finally
    //   207	221	249	finally
    //   259	264	307	java/io/IOException
    //   272	277	307	java/io/IOException
  }
  
  public static boolean removeFile(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (VasUpdateWrapper.getLog().a())
      {
        IVasLog localIVasLog = VasUpdateWrapper.getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeFile from = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" , to = ");
        localStringBuilder.append(paramString2);
        localIVasLog.b("VasUpdate_FileUtil", localStringBuilder.toString());
      }
      paramString1 = new File(paramString1);
      if (!paramString1.exists()) {
        return false;
      }
      return paramString1.renameTo(new File(paramString2));
    }
    return false;
  }
  
  public static boolean safeDeleteFile(File paramFile, String paramString)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      localObject = paramFile.listFiles();
      if (localObject != null)
      {
        int i = 0;
        while (i < localObject.length)
        {
          safeDeleteFile(localObject[i], paramString);
          i += 1;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile.getParent());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    paramString = new File(((StringBuilder)localObject).toString());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
  
  /* Error */
  public static String unZipFile(String paramString)
  {
    // Byte code:
    //   0: new 23	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: new 56	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 200	java/io/File:getParent	()Ljava/lang/String;
    //   22: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_2
    //   27: getstatic 38	java/io/File:separator	Ljava/lang/String;
    //   30: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 9
    //   40: aconst_null
    //   41: astore_3
    //   42: aconst_null
    //   43: astore 5
    //   45: aconst_null
    //   46: astore 6
    //   48: new 153	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 212	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 4
    //   60: invokevirtual 216	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   63: astore 10
    //   65: sipush 8192
    //   68: newarray byte
    //   70: astore 11
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_0
    //   76: aload 6
    //   78: astore_3
    //   79: aload_3
    //   80: astore 5
    //   82: aload_3
    //   83: astore 6
    //   85: aload 10
    //   87: invokeinterface 221 1 0
    //   92: ifeq +525 -> 617
    //   95: aload_3
    //   96: astore 5
    //   98: aload_3
    //   99: astore 6
    //   101: aload 10
    //   103: invokeinterface 225 1 0
    //   108: checkcast 227	java/util/zip/ZipEntry
    //   111: astore 12
    //   113: aload_3
    //   114: astore 5
    //   116: aload_3
    //   117: astore 6
    //   119: aload 12
    //   121: invokevirtual 230	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: ldc 232
    //   126: invokevirtual 235	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +6 -> 135
    //   132: goto -53 -> 79
    //   135: aload_3
    //   136: astore 5
    //   138: aload_3
    //   139: astore 6
    //   141: aload 12
    //   143: invokevirtual 236	java/util/zip/ZipEntry:isDirectory	()Z
    //   146: ifeq +192 -> 338
    //   149: aload_3
    //   150: astore 5
    //   152: aload_3
    //   153: astore 6
    //   155: new 56	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   162: astore 7
    //   164: aload_3
    //   165: astore 5
    //   167: aload_3
    //   168: astore 6
    //   170: aload 7
    //   172: aload 9
    //   174: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload_3
    //   179: astore 5
    //   181: aload_3
    //   182: astore 6
    //   184: aload 7
    //   186: aload 12
    //   188: invokevirtual 230	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   191: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: astore 5
    //   198: aload_3
    //   199: astore 6
    //   201: new 40	java/lang/String
    //   204: dup
    //   205: aload 7
    //   207: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: ldc 238
    //   212: invokevirtual 242	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   215: ldc 244
    //   217: invokespecial 247	java/lang/String:<init>	([BLjava/lang/String;)V
    //   220: astore 7
    //   222: aload_3
    //   223: astore 5
    //   225: aload_3
    //   226: astore 6
    //   228: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   231: invokeinterface 178 1 0
    //   236: ifeq +77 -> 313
    //   239: aload_3
    //   240: astore 5
    //   242: aload_3
    //   243: astore 6
    //   245: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   248: astore 8
    //   250: aload_3
    //   251: astore 5
    //   253: aload_3
    //   254: astore 6
    //   256: new 56	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   263: astore 12
    //   265: aload_3
    //   266: astore 5
    //   268: aload_3
    //   269: astore 6
    //   271: aload 12
    //   273: ldc 249
    //   275: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload_3
    //   280: astore 5
    //   282: aload_3
    //   283: astore 6
    //   285: aload 12
    //   287: aload 7
    //   289: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_3
    //   294: astore 5
    //   296: aload_3
    //   297: astore 6
    //   299: aload 8
    //   301: ldc 8
    //   303: aload 12
    //   305: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   308: invokeinterface 251 3 0
    //   313: aload_3
    //   314: astore 5
    //   316: aload_3
    //   317: astore 6
    //   319: new 23	java/io/File
    //   322: dup
    //   323: aload 7
    //   325: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   328: invokevirtual 254	java/io/File:mkdir	()Z
    //   331: pop
    //   332: aload 7
    //   334: astore_3
    //   335: goto -256 -> 79
    //   338: aload_3
    //   339: astore 5
    //   341: aload_3
    //   342: astore 6
    //   344: aload 12
    //   346: invokevirtual 230	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   349: astore_3
    //   350: aload_3
    //   351: astore 5
    //   353: aload_3
    //   354: astore 6
    //   356: new 56	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   363: astore 7
    //   365: aload_3
    //   366: astore 5
    //   368: aload_3
    //   369: astore 6
    //   371: aload 7
    //   373: aload 9
    //   375: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_3
    //   380: astore 5
    //   382: aload_3
    //   383: astore 6
    //   385: aload 7
    //   387: aload 12
    //   389: invokevirtual 230	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   392: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_3
    //   397: astore 5
    //   399: aload_3
    //   400: astore 6
    //   402: new 23	java/io/File
    //   405: dup
    //   406: aload 7
    //   408: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   414: astore 7
    //   416: aload_3
    //   417: astore 5
    //   419: aload_3
    //   420: astore 6
    //   422: aload 7
    //   424: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   427: invokevirtual 32	java/io/File:mkdirs	()Z
    //   430: pop
    //   431: aload_3
    //   432: astore 5
    //   434: aload_3
    //   435: astore 6
    //   437: aload 7
    //   439: invokevirtual 29	java/io/File:exists	()Z
    //   442: ifeq +15 -> 457
    //   445: aload_3
    //   446: astore 5
    //   448: aload_3
    //   449: astore 6
    //   451: aload 7
    //   453: invokevirtual 76	java/io/File:delete	()Z
    //   456: pop
    //   457: aload_3
    //   458: astore 5
    //   460: aload_3
    //   461: astore 6
    //   463: new 256	java/io/BufferedOutputStream
    //   466: dup
    //   467: new 88	java/io/FileOutputStream
    //   470: dup
    //   471: aload 7
    //   473: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   476: invokespecial 259	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   479: astore 7
    //   481: aload_0
    //   482: astore 8
    //   484: aload_0
    //   485: astore 5
    //   487: aload_0
    //   488: astore 6
    //   490: aload 4
    //   492: aload 12
    //   494: invokevirtual 263	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   497: astore_0
    //   498: aload_0
    //   499: astore 8
    //   501: aload_0
    //   502: astore 5
    //   504: aload_0
    //   505: astore 6
    //   507: aload_0
    //   508: aload 11
    //   510: iconst_0
    //   511: sipush 8192
    //   514: invokevirtual 266	java/io/InputStream:read	([BII)I
    //   517: istore_1
    //   518: iload_1
    //   519: iconst_m1
    //   520: if_icmpeq +24 -> 544
    //   523: aload_0
    //   524: astore 8
    //   526: aload_0
    //   527: astore 5
    //   529: aload_0
    //   530: astore 6
    //   532: aload 7
    //   534: aload 11
    //   536: iconst_0
    //   537: iload_1
    //   538: invokevirtual 267	java/io/OutputStream:write	([BII)V
    //   541: goto -43 -> 498
    //   544: aload_0
    //   545: astore 8
    //   547: aload_0
    //   548: astore 5
    //   550: aload_0
    //   551: astore 6
    //   553: aload_0
    //   554: invokevirtual 151	java/io/InputStream:close	()V
    //   557: aload_0
    //   558: astore 8
    //   560: aload_0
    //   561: astore 5
    //   563: aload_0
    //   564: astore 6
    //   566: aload 7
    //   568: invokevirtual 145	java/io/OutputStream:close	()V
    //   571: aload 7
    //   573: astore_2
    //   574: goto -495 -> 79
    //   577: astore_3
    //   578: aload 7
    //   580: astore_2
    //   581: aload 8
    //   583: astore_0
    //   584: goto +394 -> 978
    //   587: astore 6
    //   589: aload_3
    //   590: astore_2
    //   591: aload 7
    //   593: astore_3
    //   594: aload 5
    //   596: astore_0
    //   597: aload 6
    //   599: astore 5
    //   601: goto +274 -> 875
    //   604: astore 5
    //   606: aload_3
    //   607: astore_2
    //   608: aload 7
    //   610: astore_3
    //   611: aload 6
    //   613: astore_0
    //   614: goto +304 -> 918
    //   617: aload_3
    //   618: astore 5
    //   620: aload_3
    //   621: astore 6
    //   623: aload 4
    //   625: invokevirtual 154	java/util/zip/ZipFile:close	()V
    //   628: aload_3
    //   629: ifnull +140 -> 769
    //   632: aload_3
    //   633: astore 5
    //   635: aload_3
    //   636: astore 6
    //   638: new 56	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   645: astore 7
    //   647: aload_3
    //   648: astore 5
    //   650: aload_3
    //   651: astore 6
    //   653: aload 7
    //   655: aload 9
    //   657: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload_3
    //   662: astore 5
    //   664: aload_3
    //   665: astore 6
    //   667: aload 7
    //   669: aload_3
    //   670: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload_3
    //   675: astore 5
    //   677: aload_3
    //   678: astore 6
    //   680: aload 7
    //   682: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: astore_3
    //   686: aload_3
    //   687: astore 5
    //   689: aload_3
    //   690: astore 6
    //   692: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   695: astore 7
    //   697: aload_3
    //   698: astore 5
    //   700: aload_3
    //   701: astore 6
    //   703: new 56	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   710: astore 8
    //   712: aload_3
    //   713: astore 5
    //   715: aload_3
    //   716: astore 6
    //   718: aload 8
    //   720: ldc_w 269
    //   723: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload_3
    //   728: astore 5
    //   730: aload_3
    //   731: astore 6
    //   733: aload 8
    //   735: aload_3
    //   736: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload_3
    //   741: astore 5
    //   743: aload_3
    //   744: astore 6
    //   746: aload 7
    //   748: ldc 8
    //   750: aload 8
    //   752: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   755: invokeinterface 251 3 0
    //   760: aload_2
    //   761: aload_0
    //   762: aload 4
    //   764: invokestatic 271	com/tencent/vas/update/util/FileUtil:handleClose	(Ljava/io/OutputStream;Ljava/io/InputStream;Ljava/util/zip/ZipFile;)V
    //   767: aload_3
    //   768: areturn
    //   769: aload_3
    //   770: astore 5
    //   772: aload_3
    //   773: astore 6
    //   775: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   778: ldc 8
    //   780: ldc_w 273
    //   783: invokeinterface 73 3 0
    //   788: aload_2
    //   789: aload_0
    //   790: aload 4
    //   792: invokestatic 271	com/tencent/vas/update/util/FileUtil:handleClose	(Ljava/io/OutputStream;Ljava/io/InputStream;Ljava/util/zip/ZipFile;)V
    //   795: aload_3
    //   796: areturn
    //   797: astore_3
    //   798: goto +180 -> 978
    //   801: astore 6
    //   803: aload_2
    //   804: astore_3
    //   805: aload 5
    //   807: astore_2
    //   808: aload 6
    //   810: astore 5
    //   812: goto +63 -> 875
    //   815: astore 5
    //   817: aload_2
    //   818: astore_3
    //   819: aload 6
    //   821: astore_2
    //   822: goto +96 -> 918
    //   825: astore_3
    //   826: goto +32 -> 858
    //   829: astore 5
    //   831: aconst_null
    //   832: astore_2
    //   833: aload_2
    //   834: astore_0
    //   835: goto +40 -> 875
    //   838: astore 6
    //   840: aconst_null
    //   841: astore_2
    //   842: aload_2
    //   843: astore_0
    //   844: aload 5
    //   846: astore_3
    //   847: aload 6
    //   849: astore 5
    //   851: goto +67 -> 918
    //   854: astore_3
    //   855: aconst_null
    //   856: astore 4
    //   858: aconst_null
    //   859: astore_2
    //   860: aconst_null
    //   861: astore_0
    //   862: goto +116 -> 978
    //   865: astore 5
    //   867: aconst_null
    //   868: astore_2
    //   869: aload_2
    //   870: astore 4
    //   872: aload 4
    //   874: astore_0
    //   875: aload_3
    //   876: astore 8
    //   878: aload 4
    //   880: astore 6
    //   882: aload_0
    //   883: astore 7
    //   885: aload 5
    //   887: invokevirtual 274	java/lang/OutOfMemoryError:printStackTrace	()V
    //   890: aload_3
    //   891: astore 8
    //   893: aload 4
    //   895: astore 6
    //   897: aload_0
    //   898: astore 7
    //   900: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   903: ldc 8
    //   905: ldc_w 276
    //   908: aload 5
    //   910: invokeinterface 122 4 0
    //   915: goto +43 -> 958
    //   918: aload_3
    //   919: astore 8
    //   921: aload 4
    //   923: astore 6
    //   925: aload_0
    //   926: astore 7
    //   928: aload 5
    //   930: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   933: aload_3
    //   934: astore 8
    //   936: aload 4
    //   938: astore 6
    //   940: aload_0
    //   941: astore 7
    //   943: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/factory/api/IVasLog;
    //   946: ldc 8
    //   948: ldc_w 278
    //   951: aload 5
    //   953: invokeinterface 122 4 0
    //   958: aload_3
    //   959: aload_0
    //   960: aload 4
    //   962: invokestatic 271	com/tencent/vas/update/util/FileUtil:handleClose	(Ljava/io/OutputStream;Ljava/io/InputStream;Ljava/util/zip/ZipFile;)V
    //   965: aload_2
    //   966: areturn
    //   967: astore_3
    //   968: aload 8
    //   970: astore_2
    //   971: aload 7
    //   973: astore_0
    //   974: aload 6
    //   976: astore 4
    //   978: aload_2
    //   979: aload_0
    //   980: aload 4
    //   982: invokestatic 271	com/tencent/vas/update/util/FileUtil:handleClose	(Ljava/io/OutputStream;Ljava/io/InputStream;Ljava/util/zip/ZipFile;)V
    //   985: goto +5 -> 990
    //   988: aload_3
    //   989: athrow
    //   990: goto -2 -> 988
    //   993: astore 6
    //   995: aconst_null
    //   996: astore_2
    //   997: aload_2
    //   998: astore 4
    //   1000: aload 4
    //   1002: astore_0
    //   1003: aload 5
    //   1005: astore_3
    //   1006: aload 6
    //   1008: astore 5
    //   1010: goto -92 -> 918
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1013	0	paramString	String
    //   517	21	1	i	int
    //   16	982	2	localObject1	Object
    //   41	420	3	localObject2	Object
    //   577	13	3	localObject3	Object
    //   593	203	3	localObject4	Object
    //   797	1	3	localObject5	Object
    //   804	15	3	localObject6	Object
    //   825	1	3	localObject7	Object
    //   846	1	3	localObject8	Object
    //   854	105	3	localOutputStream	OutputStream
    //   967	22	3	localObject9	Object
    //   1005	1	3	localObject10	Object
    //   56	945	4	localObject11	Object
    //   43	557	5	localObject12	Object
    //   604	1	5	localException1	Exception
    //   618	193	5	localObject13	Object
    //   815	1	5	localException2	Exception
    //   829	16	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   849	1	5	localObject14	Object
    //   865	139	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1008	1	5	localObject15	Object
    //   46	519	6	localObject16	Object
    //   587	25	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   621	153	6	localObject17	Object
    //   801	19	6	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   838	10	6	localException3	Exception
    //   880	95	6	localObject18	Object
    //   993	14	6	localException4	Exception
    //   162	810	7	localObject19	Object
    //   248	721	8	localObject20	Object
    //   38	618	9	str	String
    //   63	39	10	localEnumeration	java.util.Enumeration
    //   70	465	11	arrayOfByte	byte[]
    //   111	382	12	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   490	498	577	finally
    //   507	518	577	finally
    //   532	541	577	finally
    //   553	557	577	finally
    //   566	571	577	finally
    //   490	498	587	java/lang/OutOfMemoryError
    //   507	518	587	java/lang/OutOfMemoryError
    //   532	541	587	java/lang/OutOfMemoryError
    //   553	557	587	java/lang/OutOfMemoryError
    //   566	571	587	java/lang/OutOfMemoryError
    //   490	498	604	java/lang/Exception
    //   507	518	604	java/lang/Exception
    //   532	541	604	java/lang/Exception
    //   553	557	604	java/lang/Exception
    //   566	571	604	java/lang/Exception
    //   85	95	797	finally
    //   101	113	797	finally
    //   119	132	797	finally
    //   141	149	797	finally
    //   155	164	797	finally
    //   170	178	797	finally
    //   184	195	797	finally
    //   201	222	797	finally
    //   228	239	797	finally
    //   245	250	797	finally
    //   256	265	797	finally
    //   271	279	797	finally
    //   285	293	797	finally
    //   299	313	797	finally
    //   319	332	797	finally
    //   344	350	797	finally
    //   356	365	797	finally
    //   371	379	797	finally
    //   385	396	797	finally
    //   402	416	797	finally
    //   422	431	797	finally
    //   437	445	797	finally
    //   451	457	797	finally
    //   463	481	797	finally
    //   623	628	797	finally
    //   638	647	797	finally
    //   653	661	797	finally
    //   667	674	797	finally
    //   680	686	797	finally
    //   692	697	797	finally
    //   703	712	797	finally
    //   718	727	797	finally
    //   733	740	797	finally
    //   746	760	797	finally
    //   775	788	797	finally
    //   85	95	801	java/lang/OutOfMemoryError
    //   101	113	801	java/lang/OutOfMemoryError
    //   119	132	801	java/lang/OutOfMemoryError
    //   141	149	801	java/lang/OutOfMemoryError
    //   155	164	801	java/lang/OutOfMemoryError
    //   170	178	801	java/lang/OutOfMemoryError
    //   184	195	801	java/lang/OutOfMemoryError
    //   201	222	801	java/lang/OutOfMemoryError
    //   228	239	801	java/lang/OutOfMemoryError
    //   245	250	801	java/lang/OutOfMemoryError
    //   256	265	801	java/lang/OutOfMemoryError
    //   271	279	801	java/lang/OutOfMemoryError
    //   285	293	801	java/lang/OutOfMemoryError
    //   299	313	801	java/lang/OutOfMemoryError
    //   319	332	801	java/lang/OutOfMemoryError
    //   344	350	801	java/lang/OutOfMemoryError
    //   356	365	801	java/lang/OutOfMemoryError
    //   371	379	801	java/lang/OutOfMemoryError
    //   385	396	801	java/lang/OutOfMemoryError
    //   402	416	801	java/lang/OutOfMemoryError
    //   422	431	801	java/lang/OutOfMemoryError
    //   437	445	801	java/lang/OutOfMemoryError
    //   451	457	801	java/lang/OutOfMemoryError
    //   463	481	801	java/lang/OutOfMemoryError
    //   623	628	801	java/lang/OutOfMemoryError
    //   638	647	801	java/lang/OutOfMemoryError
    //   653	661	801	java/lang/OutOfMemoryError
    //   667	674	801	java/lang/OutOfMemoryError
    //   680	686	801	java/lang/OutOfMemoryError
    //   692	697	801	java/lang/OutOfMemoryError
    //   703	712	801	java/lang/OutOfMemoryError
    //   718	727	801	java/lang/OutOfMemoryError
    //   733	740	801	java/lang/OutOfMemoryError
    //   746	760	801	java/lang/OutOfMemoryError
    //   775	788	801	java/lang/OutOfMemoryError
    //   85	95	815	java/lang/Exception
    //   101	113	815	java/lang/Exception
    //   119	132	815	java/lang/Exception
    //   141	149	815	java/lang/Exception
    //   155	164	815	java/lang/Exception
    //   170	178	815	java/lang/Exception
    //   184	195	815	java/lang/Exception
    //   201	222	815	java/lang/Exception
    //   228	239	815	java/lang/Exception
    //   245	250	815	java/lang/Exception
    //   256	265	815	java/lang/Exception
    //   271	279	815	java/lang/Exception
    //   285	293	815	java/lang/Exception
    //   299	313	815	java/lang/Exception
    //   319	332	815	java/lang/Exception
    //   344	350	815	java/lang/Exception
    //   356	365	815	java/lang/Exception
    //   371	379	815	java/lang/Exception
    //   385	396	815	java/lang/Exception
    //   402	416	815	java/lang/Exception
    //   422	431	815	java/lang/Exception
    //   437	445	815	java/lang/Exception
    //   451	457	815	java/lang/Exception
    //   463	481	815	java/lang/Exception
    //   623	628	815	java/lang/Exception
    //   638	647	815	java/lang/Exception
    //   653	661	815	java/lang/Exception
    //   667	674	815	java/lang/Exception
    //   680	686	815	java/lang/Exception
    //   692	697	815	java/lang/Exception
    //   703	712	815	java/lang/Exception
    //   718	727	815	java/lang/Exception
    //   733	740	815	java/lang/Exception
    //   746	760	815	java/lang/Exception
    //   775	788	815	java/lang/Exception
    //   58	72	825	finally
    //   58	72	829	java/lang/OutOfMemoryError
    //   58	72	838	java/lang/Exception
    //   48	58	854	finally
    //   48	58	865	java/lang/OutOfMemoryError
    //   885	890	967	finally
    //   900	915	967	finally
    //   928	933	967	finally
    //   943	958	967	finally
    //   48	58	993	java/lang/Exception
  }
  
  public static boolean writeFileContent(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          boolean bool;
          paramString1 = new FileOutputStream(paramString1, false);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("\r\n");
          paramString1.write(localStringBuilder.toString().getBytes());
          paramString1.flush();
          paramString1.close();
          return bool;
        }
        catch (FileNotFoundException|IOException paramString1) {}
        localIOException = localIOException;
      }
    }
    bool = false;
    break label49;
    bool = true;
    label49:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */