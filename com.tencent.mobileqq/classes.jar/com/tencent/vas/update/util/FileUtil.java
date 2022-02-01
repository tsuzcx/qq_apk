package com.tencent.vas.update.util;

import android.text.TextUtils;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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
        ((IVasLog)localObject1).e("VasUpdate_FileUtil", ((StringBuilder)localObject2).toString());
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
    //   111: goto +8 -> 119
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   119: aload_0
    //   120: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   123: iconst_1
    //   124: ireturn
    //   125: astore_0
    //   126: aload_0
    //   127: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   130: iload_3
    //   131: ireturn
    //   132: astore_1
    //   133: goto +13 -> 146
    //   136: astore 4
    //   138: aload_0
    //   139: astore_1
    //   140: goto +20 -> 160
    //   143: astore_1
    //   144: aconst_null
    //   145: astore_0
    //   146: aload 5
    //   148: astore 4
    //   150: aload_0
    //   151: astore 5
    //   153: goto +69 -> 222
    //   156: astore 4
    //   158: aconst_null
    //   159: astore_1
    //   160: aload 5
    //   162: astore_0
    //   163: goto +17 -> 180
    //   166: astore_1
    //   167: aconst_null
    //   168: astore 5
    //   170: goto +52 -> 222
    //   173: astore 4
    //   175: aconst_null
    //   176: astore_1
    //   177: aload 6
    //   179: astore_0
    //   180: aload 4
    //   182: invokevirtual 118	java/lang/Throwable:printStackTrace	()V
    //   185: aload_0
    //   186: ifnull +15 -> 201
    //   189: aload_0
    //   190: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   193: goto +8 -> 201
    //   196: astore_0
    //   197: aload_0
    //   198: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   209: iconst_0
    //   210: ireturn
    //   211: astore 4
    //   213: aload_1
    //   214: astore 5
    //   216: aload 4
    //   218: astore_1
    //   219: aload_0
    //   220: astore 4
    //   222: aload 4
    //   224: ifnull +16 -> 240
    //   227: aload 4
    //   229: invokevirtual 113	java/io/FileOutputStream:close	()V
    //   232: goto +8 -> 240
    //   235: astore_0
    //   236: aload_0
    //   237: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   240: aload 5
    //   242: ifnull +16 -> 258
    //   245: aload 5
    //   247: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   250: goto +8 -> 258
    //   253: astore_0
    //   254: aload_0
    //   255: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   258: goto +5 -> 263
    //   261: aload_1
    //   262: athrow
    //   263: goto -2 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFile1	File
    //   0	266	1	paramFile2	File
    //   82	11	2	i	int
    //   1	130	3	bool	boolean
    //   3	1	4	localObject1	Object
    //   136	1	4	localThrowable1	Throwable
    //   148	1	4	localObject2	Object
    //   156	1	4	localThrowable2	Throwable
    //   173	8	4	localThrowable3	Throwable
    //   211	6	4	localObject3	Object
    //   220	8	4	localFile	File
    //   53	193	5	localObject4	Object
    //   6	172	6	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   106	111	114	java/io/IOException
    //   119	123	125	java/io/IOException
    //   205	209	125	java/io/IOException
    //   71	77	132	finally
    //   77	83	132	finally
    //   88	101	132	finally
    //   71	77	136	java/lang/Throwable
    //   77	83	136	java/lang/Throwable
    //   88	101	136	java/lang/Throwable
    //   55	71	143	finally
    //   55	71	156	java/lang/Throwable
    //   8	20	166	finally
    //   20	45	166	finally
    //   45	55	166	finally
    //   8	20	173	java/lang/Throwable
    //   20	45	173	java/lang/Throwable
    //   45	55	173	java/lang/Throwable
    //   189	193	196	java/io/IOException
    //   180	185	211	finally
    //   227	232	235	java/io/IOException
    //   245	250	253	java/io/IOException
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    try
    {
      if (!paramString.exists()) {
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
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
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
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokevirtual 130	java/io/File:length	()J
    //   10: l2i
    //   11: istore_2
    //   12: new 132	java/io/ByteArrayOutputStream
    //   15: dup
    //   16: iload_2
    //   17: invokespecial 135	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore 4
    //   22: new 93	java/io/BufferedInputStream
    //   25: dup
    //   26: new 95	java/io/FileInputStream
    //   29: dup
    //   30: aload_0
    //   31: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: invokespecial 99	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   37: astore_0
    //   38: aload 4
    //   40: astore 5
    //   42: aload_0
    //   43: astore 6
    //   45: sipush 4096
    //   48: newarray byte
    //   50: astore 7
    //   52: iconst_0
    //   53: istore_1
    //   54: iload_1
    //   55: iload_2
    //   56: if_icmpge +40 -> 96
    //   59: aload 4
    //   61: astore 5
    //   63: aload_0
    //   64: astore 6
    //   66: aload_0
    //   67: aload 7
    //   69: invokevirtual 138	java/io/InputStream:read	([B)I
    //   72: istore_3
    //   73: aload 4
    //   75: astore 5
    //   77: aload_0
    //   78: astore 6
    //   80: aload 4
    //   82: aload 7
    //   84: iconst_0
    //   85: iload_3
    //   86: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   89: iload_1
    //   90: iload_3
    //   91: iadd
    //   92: istore_1
    //   93: goto -39 -> 54
    //   96: aload 4
    //   98: astore 5
    //   100: aload_0
    //   101: astore 6
    //   103: aload 4
    //   105: ldc 141
    //   107: invokevirtual 144	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   110: astore 7
    //   112: aload 7
    //   114: astore 5
    //   116: aload 4
    //   118: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   121: aload 7
    //   123: astore 5
    //   125: aload_0
    //   126: invokevirtual 146	java/io/InputStream:close	()V
    //   129: aload 7
    //   131: areturn
    //   132: astore_0
    //   133: aload_0
    //   134: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   137: aload 5
    //   139: areturn
    //   140: astore 7
    //   142: goto +29 -> 171
    //   145: astore_0
    //   146: goto +74 -> 220
    //   149: astore 7
    //   151: aconst_null
    //   152: astore_0
    //   153: goto +18 -> 171
    //   156: astore_0
    //   157: aconst_null
    //   158: astore 4
    //   160: goto +60 -> 220
    //   163: astore 7
    //   165: aconst_null
    //   166: astore 4
    //   168: aload 4
    //   170: astore_0
    //   171: aload 4
    //   173: astore 5
    //   175: aload_0
    //   176: astore 6
    //   178: aload 7
    //   180: invokevirtual 118	java/lang/Throwable:printStackTrace	()V
    //   183: aload 4
    //   185: ifnull +12 -> 197
    //   188: aload 8
    //   190: astore 5
    //   192: aload 4
    //   194: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   197: aload_0
    //   198: ifnull +11 -> 209
    //   201: aload 8
    //   203: astore 5
    //   205: aload_0
    //   206: invokevirtual 146	java/io/InputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore_0
    //   212: aload 5
    //   214: astore 4
    //   216: aload 6
    //   218: astore 5
    //   220: aload 4
    //   222: ifnull +11 -> 233
    //   225: aload 4
    //   227: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   230: goto +3 -> 233
    //   233: aload 5
    //   235: ifnull +16 -> 251
    //   238: aload 5
    //   240: invokevirtual 146	java/io/InputStream:close	()V
    //   243: goto +8 -> 251
    //   246: aload 4
    //   248: invokevirtual 116	java/io/IOException:printStackTrace	()V
    //   251: goto +5 -> 256
    //   254: aload_0
    //   255: athrow
    //   256: goto -2 -> 254
    //   259: astore 4
    //   261: goto -15 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	paramFile	File
    //   53	40	1	i	int
    //   11	46	2	j	int
    //   72	20	3	k	int
    //   20	227	4	localObject1	Object
    //   259	1	4	localIOException	IOException
    //   1	238	5	localObject2	Object
    //   43	174	6	localFile	File
    //   50	80	7	localObject3	Object
    //   140	1	7	localThrowable1	Throwable
    //   149	1	7	localThrowable2	Throwable
    //   163	16	7	localThrowable3	Throwable
    //   4	198	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   116	121	132	java/io/IOException
    //   125	129	132	java/io/IOException
    //   192	197	132	java/io/IOException
    //   205	209	132	java/io/IOException
    //   45	52	140	java/lang/Throwable
    //   66	73	140	java/lang/Throwable
    //   80	89	140	java/lang/Throwable
    //   103	112	140	java/lang/Throwable
    //   22	38	145	finally
    //   22	38	149	java/lang/Throwable
    //   6	22	156	finally
    //   6	22	163	java/lang/Throwable
    //   45	52	211	finally
    //   66	73	211	finally
    //   80	89	211	finally
    //   103	112	211	finally
    //   178	183	211	finally
    //   225	230	259	java/io/IOException
    //   238	243	259	java/io/IOException
  }
  
  public static boolean removeFile(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if (VasUpdateWrapper.getLog().isColorLevel())
      {
        IVasLog localIVasLog = VasUpdateWrapper.getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeFile from = ");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(" , to = ");
        localStringBuilder.append(paramString2);
        localIVasLog.i("VasUpdate_FileUtil", localStringBuilder.toString());
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
    //   19: invokevirtual 173	java/io/File:getParent	()Ljava/lang/String;
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
    //   43: astore 6
    //   45: aconst_null
    //   46: astore 5
    //   48: new 188	java/util/zip/ZipFile
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 189	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   56: astore 4
    //   58: aload 4
    //   60: invokevirtual 193	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   63: astore 10
    //   65: sipush 8192
    //   68: newarray byte
    //   70: astore 11
    //   72: aconst_null
    //   73: astore_2
    //   74: aload_2
    //   75: astore_0
    //   76: aload 5
    //   78: astore_3
    //   79: aload_3
    //   80: astore 5
    //   82: aload_3
    //   83: astore 6
    //   85: aload 10
    //   87: invokeinterface 198 1 0
    //   92: ifeq +631 -> 723
    //   95: aload_3
    //   96: astore 5
    //   98: aload_3
    //   99: astore 6
    //   101: aload 10
    //   103: invokeinterface 202 1 0
    //   108: checkcast 204	java/util/zip/ZipEntry
    //   111: astore 12
    //   113: aload_3
    //   114: astore 5
    //   116: aload_3
    //   117: astore 6
    //   119: aload 12
    //   121: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   124: ldc 209
    //   126: invokevirtual 212	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   129: ifeq +6 -> 135
    //   132: goto -53 -> 79
    //   135: aload_3
    //   136: astore 5
    //   138: aload_3
    //   139: astore 6
    //   141: aload 12
    //   143: invokevirtual 213	java/util/zip/ZipEntry:isDirectory	()Z
    //   146: ifeq +286 -> 432
    //   149: aload_3
    //   150: astore 5
    //   152: aload_3
    //   153: astore 6
    //   155: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   158: invokeinterface 151 1 0
    //   163: ifeq +80 -> 243
    //   166: aload_3
    //   167: astore 5
    //   169: aload_3
    //   170: astore 6
    //   172: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   175: astore 7
    //   177: aload_3
    //   178: astore 5
    //   180: aload_3
    //   181: astore 6
    //   183: new 56	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   190: astore 8
    //   192: aload_3
    //   193: astore 5
    //   195: aload_3
    //   196: astore 6
    //   198: aload 8
    //   200: ldc 215
    //   202: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: astore 5
    //   209: aload_3
    //   210: astore 6
    //   212: aload 8
    //   214: aload 12
    //   216: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   219: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_3
    //   224: astore 5
    //   226: aload_3
    //   227: astore 6
    //   229: aload 7
    //   231: ldc 8
    //   233: aload 8
    //   235: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokeinterface 218 3 0
    //   243: aload_3
    //   244: astore 5
    //   246: aload_3
    //   247: astore 6
    //   249: new 56	java/lang/StringBuilder
    //   252: dup
    //   253: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   256: astore 7
    //   258: aload_3
    //   259: astore 5
    //   261: aload_3
    //   262: astore 6
    //   264: aload 7
    //   266: aload 9
    //   268: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: pop
    //   272: aload_3
    //   273: astore 5
    //   275: aload_3
    //   276: astore 6
    //   278: aload 7
    //   280: aload 12
    //   282: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   285: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_3
    //   290: astore 5
    //   292: aload_3
    //   293: astore 6
    //   295: new 40	java/lang/String
    //   298: dup
    //   299: aload 7
    //   301: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: ldc 220
    //   306: invokevirtual 224	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   309: ldc 226
    //   311: invokespecial 229	java/lang/String:<init>	([BLjava/lang/String;)V
    //   314: astore 7
    //   316: aload_3
    //   317: astore 5
    //   319: aload_3
    //   320: astore 6
    //   322: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   325: invokeinterface 151 1 0
    //   330: ifeq +77 -> 407
    //   333: aload_3
    //   334: astore 5
    //   336: aload_3
    //   337: astore 6
    //   339: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   342: astore 8
    //   344: aload_3
    //   345: astore 5
    //   347: aload_3
    //   348: astore 6
    //   350: new 56	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   357: astore 12
    //   359: aload_3
    //   360: astore 5
    //   362: aload_3
    //   363: astore 6
    //   365: aload 12
    //   367: ldc 231
    //   369: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload_3
    //   374: astore 5
    //   376: aload_3
    //   377: astore 6
    //   379: aload 12
    //   381: aload 7
    //   383: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: pop
    //   387: aload_3
    //   388: astore 5
    //   390: aload_3
    //   391: astore 6
    //   393: aload 8
    //   395: ldc 8
    //   397: aload 12
    //   399: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokeinterface 218 3 0
    //   407: aload_3
    //   408: astore 5
    //   410: aload_3
    //   411: astore 6
    //   413: new 23	java/io/File
    //   416: dup
    //   417: aload 7
    //   419: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   422: invokevirtual 234	java/io/File:mkdir	()Z
    //   425: pop
    //   426: aload 7
    //   428: astore_3
    //   429: goto -350 -> 79
    //   432: aload_3
    //   433: astore 5
    //   435: aload_3
    //   436: astore 6
    //   438: aload 12
    //   440: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   443: astore_3
    //   444: aload_3
    //   445: astore 5
    //   447: aload_3
    //   448: astore 6
    //   450: new 56	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   457: astore 7
    //   459: aload_3
    //   460: astore 5
    //   462: aload_3
    //   463: astore 6
    //   465: aload 7
    //   467: aload 9
    //   469: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_3
    //   474: astore 5
    //   476: aload_3
    //   477: astore 6
    //   479: aload 7
    //   481: aload 12
    //   483: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   486: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload_3
    //   491: astore 5
    //   493: aload_3
    //   494: astore 6
    //   496: new 23	java/io/File
    //   499: dup
    //   500: aload 7
    //   502: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   508: astore 7
    //   510: aload_3
    //   511: astore 5
    //   513: aload_3
    //   514: astore 6
    //   516: aload 7
    //   518: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   521: invokevirtual 32	java/io/File:mkdirs	()Z
    //   524: pop
    //   525: aload_3
    //   526: astore 5
    //   528: aload_3
    //   529: astore 6
    //   531: aload 7
    //   533: invokevirtual 29	java/io/File:exists	()Z
    //   536: ifeq +15 -> 551
    //   539: aload_3
    //   540: astore 5
    //   542: aload_3
    //   543: astore 6
    //   545: aload 7
    //   547: invokevirtual 76	java/io/File:delete	()Z
    //   550: pop
    //   551: aload_3
    //   552: astore 5
    //   554: aload_3
    //   555: astore 6
    //   557: new 236	java/io/BufferedOutputStream
    //   560: dup
    //   561: new 88	java/io/FileOutputStream
    //   564: dup
    //   565: aload 7
    //   567: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   570: invokespecial 239	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   573: astore 7
    //   575: aload_0
    //   576: astore 5
    //   578: aload_0
    //   579: astore 6
    //   581: aload_0
    //   582: astore 8
    //   584: aload 4
    //   586: aload 12
    //   588: invokevirtual 243	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   591: astore_0
    //   592: aload_0
    //   593: astore 5
    //   595: aload_0
    //   596: astore 6
    //   598: aload_0
    //   599: astore 8
    //   601: aload_0
    //   602: aload 11
    //   604: iconst_0
    //   605: sipush 8192
    //   608: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   611: istore_1
    //   612: iload_1
    //   613: iconst_m1
    //   614: if_icmpeq +24 -> 638
    //   617: aload_0
    //   618: astore 5
    //   620: aload_0
    //   621: astore 6
    //   623: aload_0
    //   624: astore 8
    //   626: aload 7
    //   628: aload 11
    //   630: iconst_0
    //   631: iload_1
    //   632: invokevirtual 249	java/io/OutputStream:write	([BII)V
    //   635: goto -43 -> 592
    //   638: aload_0
    //   639: astore 5
    //   641: aload_0
    //   642: astore 6
    //   644: aload_0
    //   645: astore 8
    //   647: aload_0
    //   648: invokevirtual 146	java/io/InputStream:close	()V
    //   651: aload_0
    //   652: astore 5
    //   654: aload_0
    //   655: astore 6
    //   657: aload_0
    //   658: astore 8
    //   660: aload 7
    //   662: invokevirtual 250	java/io/OutputStream:close	()V
    //   665: aload 7
    //   667: astore_2
    //   668: goto -589 -> 79
    //   671: astore_3
    //   672: aload 7
    //   674: astore_2
    //   675: aload 5
    //   677: astore_0
    //   678: goto +749 -> 1427
    //   681: astore 8
    //   683: aload_3
    //   684: astore_2
    //   685: aload 7
    //   687: astore_3
    //   688: aload 4
    //   690: astore 5
    //   692: aload 6
    //   694: astore_0
    //   695: aload 8
    //   697: astore 4
    //   699: goto +464 -> 1163
    //   702: astore 6
    //   704: aload_3
    //   705: astore_2
    //   706: aload 7
    //   708: astore_3
    //   709: aload 4
    //   711: astore 5
    //   713: aload 8
    //   715: astore_0
    //   716: aload 6
    //   718: astore 4
    //   720: goto +578 -> 1298
    //   723: aload_3
    //   724: astore 5
    //   726: aload_3
    //   727: astore 6
    //   729: aload 4
    //   731: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   734: aload_3
    //   735: ifnull +218 -> 953
    //   738: aload_3
    //   739: astore 5
    //   741: aload_3
    //   742: astore 6
    //   744: new 56	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   751: astore 7
    //   753: aload_3
    //   754: astore 5
    //   756: aload_3
    //   757: astore 6
    //   759: aload 7
    //   761: aload 9
    //   763: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: pop
    //   767: aload_3
    //   768: astore 5
    //   770: aload_3
    //   771: astore 6
    //   773: aload 7
    //   775: aload_3
    //   776: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload_3
    //   781: astore 5
    //   783: aload_3
    //   784: astore 6
    //   786: aload 7
    //   788: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: astore_3
    //   792: aload_3
    //   793: astore 5
    //   795: aload_3
    //   796: astore 6
    //   798: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   801: astore 7
    //   803: aload_3
    //   804: astore 5
    //   806: aload_3
    //   807: astore 6
    //   809: new 56	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   816: astore 8
    //   818: aload_3
    //   819: astore 5
    //   821: aload_3
    //   822: astore 6
    //   824: aload 8
    //   826: ldc 253
    //   828: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: pop
    //   832: aload_3
    //   833: astore 5
    //   835: aload_3
    //   836: astore 6
    //   838: aload 8
    //   840: aload_3
    //   841: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   844: pop
    //   845: aload_3
    //   846: astore 5
    //   848: aload_3
    //   849: astore 6
    //   851: aload 7
    //   853: ldc 8
    //   855: aload 8
    //   857: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   860: invokeinterface 218 3 0
    //   865: aload_2
    //   866: ifnull +29 -> 895
    //   869: aload_2
    //   870: invokevirtual 250	java/io/OutputStream:close	()V
    //   873: goto +22 -> 895
    //   876: astore_2
    //   877: aload_2
    //   878: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   881: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   884: ldc 8
    //   886: ldc_w 256
    //   889: aload_2
    //   890: invokeinterface 259 4 0
    //   895: aload_0
    //   896: ifnull +29 -> 925
    //   899: aload_0
    //   900: invokevirtual 146	java/io/InputStream:close	()V
    //   903: goto +22 -> 925
    //   906: astore_0
    //   907: aload_0
    //   908: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   911: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   914: ldc 8
    //   916: ldc_w 256
    //   919: aload_0
    //   920: invokeinterface 259 4 0
    //   925: aload 4
    //   927: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   930: aload_3
    //   931: areturn
    //   932: astore_0
    //   933: aload_0
    //   934: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   937: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   940: ldc 8
    //   942: ldc_w 256
    //   945: aload_0
    //   946: invokeinterface 259 4 0
    //   951: aload_3
    //   952: areturn
    //   953: aload_3
    //   954: astore 5
    //   956: aload_3
    //   957: astore 6
    //   959: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   962: ldc 8
    //   964: ldc_w 261
    //   967: invokeinterface 73 3 0
    //   972: aload_2
    //   973: ifnull +29 -> 1002
    //   976: aload_2
    //   977: invokevirtual 250	java/io/OutputStream:close	()V
    //   980: goto +22 -> 1002
    //   983: astore_2
    //   984: aload_2
    //   985: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   988: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   991: ldc 8
    //   993: ldc_w 256
    //   996: aload_2
    //   997: invokeinterface 259 4 0
    //   1002: aload_0
    //   1003: ifnull +29 -> 1032
    //   1006: aload_0
    //   1007: invokevirtual 146	java/io/InputStream:close	()V
    //   1010: goto +22 -> 1032
    //   1013: astore_0
    //   1014: aload_0
    //   1015: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1018: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1021: ldc 8
    //   1023: ldc_w 256
    //   1026: aload_0
    //   1027: invokeinterface 259 4 0
    //   1032: aload 4
    //   1034: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   1037: goto +22 -> 1059
    //   1040: astore_0
    //   1041: aload_0
    //   1042: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1045: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1048: ldc 8
    //   1050: ldc_w 256
    //   1053: aload_0
    //   1054: invokeinterface 259 4 0
    //   1059: aload_3
    //   1060: areturn
    //   1061: astore_3
    //   1062: goto +365 -> 1427
    //   1065: astore 6
    //   1067: aload_2
    //   1068: astore_3
    //   1069: aload 5
    //   1071: astore_2
    //   1072: aload 4
    //   1074: astore 5
    //   1076: aload 6
    //   1078: astore 4
    //   1080: goto +83 -> 1163
    //   1083: astore 7
    //   1085: aload_2
    //   1086: astore_3
    //   1087: aload 6
    //   1089: astore_2
    //   1090: aload 4
    //   1092: astore 5
    //   1094: aload 7
    //   1096: astore 4
    //   1098: goto +200 -> 1298
    //   1101: astore_3
    //   1102: goto +44 -> 1146
    //   1105: astore 6
    //   1107: aconst_null
    //   1108: astore_2
    //   1109: aload_2
    //   1110: astore_0
    //   1111: aload 4
    //   1113: astore 5
    //   1115: aload 6
    //   1117: astore 4
    //   1119: goto +44 -> 1163
    //   1122: astore 7
    //   1124: aconst_null
    //   1125: astore_2
    //   1126: aload_2
    //   1127: astore_0
    //   1128: aload 6
    //   1130: astore_3
    //   1131: aload 4
    //   1133: astore 5
    //   1135: aload 7
    //   1137: astore 4
    //   1139: goto +159 -> 1298
    //   1142: astore_3
    //   1143: aconst_null
    //   1144: astore 4
    //   1146: aconst_null
    //   1147: astore_2
    //   1148: aconst_null
    //   1149: astore_0
    //   1150: goto +277 -> 1427
    //   1153: astore 4
    //   1155: aconst_null
    //   1156: astore_2
    //   1157: aload_2
    //   1158: astore 5
    //   1160: aload 5
    //   1162: astore_0
    //   1163: aload_3
    //   1164: astore 8
    //   1166: aload 5
    //   1168: astore 6
    //   1170: aload_0
    //   1171: astore 7
    //   1173: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1176: ldc 8
    //   1178: ldc_w 263
    //   1181: aload 4
    //   1183: invokeinterface 259 4 0
    //   1188: aload_3
    //   1189: ifnull +29 -> 1218
    //   1192: aload_3
    //   1193: invokevirtual 250	java/io/OutputStream:close	()V
    //   1196: goto +22 -> 1218
    //   1199: astore_3
    //   1200: aload_3
    //   1201: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1204: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1207: ldc 8
    //   1209: ldc_w 256
    //   1212: aload_3
    //   1213: invokeinterface 259 4 0
    //   1218: aload_0
    //   1219: ifnull +29 -> 1248
    //   1222: aload_0
    //   1223: invokevirtual 146	java/io/InputStream:close	()V
    //   1226: goto +22 -> 1248
    //   1229: astore_0
    //   1230: aload_0
    //   1231: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1234: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1237: ldc 8
    //   1239: ldc_w 256
    //   1242: aload_0
    //   1243: invokeinterface 259 4 0
    //   1248: aload_2
    //   1249: astore_0
    //   1250: aload 5
    //   1252: ifnull +162 -> 1414
    //   1255: aload_2
    //   1256: astore_0
    //   1257: aload 5
    //   1259: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   1262: aload_2
    //   1263: areturn
    //   1264: astore_2
    //   1265: aload_2
    //   1266: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1269: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1272: ldc 8
    //   1274: ldc_w 256
    //   1277: aload_2
    //   1278: invokeinterface 259 4 0
    //   1283: aload_0
    //   1284: areturn
    //   1285: astore 4
    //   1287: aconst_null
    //   1288: astore_2
    //   1289: aload_2
    //   1290: astore 5
    //   1292: aload 5
    //   1294: astore_0
    //   1295: aload 6
    //   1297: astore_3
    //   1298: aload_3
    //   1299: astore 8
    //   1301: aload 5
    //   1303: astore 6
    //   1305: aload_0
    //   1306: astore 7
    //   1308: aload 4
    //   1310: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1313: aload_3
    //   1314: astore 8
    //   1316: aload 5
    //   1318: astore 6
    //   1320: aload_0
    //   1321: astore 7
    //   1323: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1326: ldc 8
    //   1328: ldc_w 265
    //   1331: aload 4
    //   1333: invokeinterface 259 4 0
    //   1338: aload_3
    //   1339: ifnull +29 -> 1368
    //   1342: aload_3
    //   1343: invokevirtual 250	java/io/OutputStream:close	()V
    //   1346: goto +22 -> 1368
    //   1349: astore_3
    //   1350: aload_3
    //   1351: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1354: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1357: ldc 8
    //   1359: ldc_w 256
    //   1362: aload_3
    //   1363: invokeinterface 259 4 0
    //   1368: aload_0
    //   1369: ifnull +29 -> 1398
    //   1372: aload_0
    //   1373: invokevirtual 146	java/io/InputStream:close	()V
    //   1376: goto +22 -> 1398
    //   1379: astore_0
    //   1380: aload_0
    //   1381: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1384: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1387: ldc 8
    //   1389: ldc_w 256
    //   1392: aload_0
    //   1393: invokeinterface 259 4 0
    //   1398: aload_2
    //   1399: astore_0
    //   1400: aload 5
    //   1402: ifnull +12 -> 1414
    //   1405: aload_2
    //   1406: astore_0
    //   1407: aload 5
    //   1409: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   1412: aload_2
    //   1413: astore_0
    //   1414: aload_0
    //   1415: areturn
    //   1416: astore_3
    //   1417: aload 8
    //   1419: astore_2
    //   1420: aload 7
    //   1422: astore_0
    //   1423: aload 6
    //   1425: astore 4
    //   1427: aload_2
    //   1428: ifnull +29 -> 1457
    //   1431: aload_2
    //   1432: invokevirtual 250	java/io/OutputStream:close	()V
    //   1435: goto +22 -> 1457
    //   1438: astore_2
    //   1439: aload_2
    //   1440: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1443: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1446: ldc 8
    //   1448: ldc_w 256
    //   1451: aload_2
    //   1452: invokeinterface 259 4 0
    //   1457: aload_0
    //   1458: ifnull +29 -> 1487
    //   1461: aload_0
    //   1462: invokevirtual 146	java/io/InputStream:close	()V
    //   1465: goto +22 -> 1487
    //   1468: astore_0
    //   1469: aload_0
    //   1470: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1473: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1476: ldc 8
    //   1478: ldc_w 256
    //   1481: aload_0
    //   1482: invokeinterface 259 4 0
    //   1487: aload 4
    //   1489: ifnull +30 -> 1519
    //   1492: aload 4
    //   1494: invokevirtual 251	java/util/zip/ZipFile:close	()V
    //   1497: goto +22 -> 1519
    //   1500: astore_0
    //   1501: aload_0
    //   1502: invokevirtual 254	java/lang/Exception:printStackTrace	()V
    //   1505: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1508: ldc 8
    //   1510: ldc_w 256
    //   1513: aload_0
    //   1514: invokeinterface 259 4 0
    //   1519: goto +5 -> 1524
    //   1522: aload_3
    //   1523: athrow
    //   1524: goto -2 -> 1522
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1527	0	paramString	String
    //   611	21	1	i	int
    //   16	854	2	localObject1	Object
    //   876	101	2	localException1	java.lang.Exception
    //   983	85	2	localException2	java.lang.Exception
    //   1071	192	2	localObject2	Object
    //   1264	14	2	localException3	java.lang.Exception
    //   1288	144	2	localObject3	Object
    //   1438	14	2	localException4	java.lang.Exception
    //   41	514	3	localObject4	Object
    //   671	13	3	localObject5	Object
    //   687	373	3	localObject6	Object
    //   1061	1	3	localObject7	Object
    //   1068	19	3	localObject8	Object
    //   1101	1	3	localObject9	Object
    //   1130	1	3	localObject10	Object
    //   1142	51	3	localObject11	Object
    //   1199	14	3	localException5	java.lang.Exception
    //   1297	46	3	localObject12	Object
    //   1349	14	3	localException6	java.lang.Exception
    //   1416	107	3	localObject13	Object
    //   56	1089	4	localObject14	Object
    //   1153	29	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1285	47	4	localException7	java.lang.Exception
    //   1425	68	4	localObject15	Object
    //   46	1362	5	localObject16	Object
    //   43	650	6	localObject17	Object
    //   702	15	6	localException8	java.lang.Exception
    //   727	231	6	localObject18	Object
    //   1065	23	6	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1105	24	6	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1168	256	6	localObject19	Object
    //   175	677	7	localObject20	Object
    //   1083	12	7	localException9	java.lang.Exception
    //   1122	14	7	localException10	java.lang.Exception
    //   1171	250	7	str1	String
    //   190	469	8	localObject21	Object
    //   681	33	8	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   816	602	8	localObject22	Object
    //   38	724	9	str2	String
    //   63	39	10	localEnumeration	java.util.Enumeration
    //   70	559	11	arrayOfByte	byte[]
    //   111	476	12	localObject23	Object
    // Exception table:
    //   from	to	target	type
    //   584	592	671	finally
    //   601	612	671	finally
    //   626	635	671	finally
    //   647	651	671	finally
    //   660	665	671	finally
    //   584	592	681	java/lang/OutOfMemoryError
    //   601	612	681	java/lang/OutOfMemoryError
    //   626	635	681	java/lang/OutOfMemoryError
    //   647	651	681	java/lang/OutOfMemoryError
    //   660	665	681	java/lang/OutOfMemoryError
    //   584	592	702	java/lang/Exception
    //   601	612	702	java/lang/Exception
    //   626	635	702	java/lang/Exception
    //   647	651	702	java/lang/Exception
    //   660	665	702	java/lang/Exception
    //   869	873	876	java/lang/Exception
    //   899	903	906	java/lang/Exception
    //   925	930	932	java/lang/Exception
    //   976	980	983	java/lang/Exception
    //   1006	1010	1013	java/lang/Exception
    //   1032	1037	1040	java/lang/Exception
    //   85	95	1061	finally
    //   101	113	1061	finally
    //   119	132	1061	finally
    //   141	149	1061	finally
    //   155	166	1061	finally
    //   172	177	1061	finally
    //   183	192	1061	finally
    //   198	206	1061	finally
    //   212	223	1061	finally
    //   229	243	1061	finally
    //   249	258	1061	finally
    //   264	272	1061	finally
    //   278	289	1061	finally
    //   295	316	1061	finally
    //   322	333	1061	finally
    //   339	344	1061	finally
    //   350	359	1061	finally
    //   365	373	1061	finally
    //   379	387	1061	finally
    //   393	407	1061	finally
    //   413	426	1061	finally
    //   438	444	1061	finally
    //   450	459	1061	finally
    //   465	473	1061	finally
    //   479	490	1061	finally
    //   496	510	1061	finally
    //   516	525	1061	finally
    //   531	539	1061	finally
    //   545	551	1061	finally
    //   557	575	1061	finally
    //   729	734	1061	finally
    //   744	753	1061	finally
    //   759	767	1061	finally
    //   773	780	1061	finally
    //   786	792	1061	finally
    //   798	803	1061	finally
    //   809	818	1061	finally
    //   824	832	1061	finally
    //   838	845	1061	finally
    //   851	865	1061	finally
    //   959	972	1061	finally
    //   85	95	1065	java/lang/OutOfMemoryError
    //   101	113	1065	java/lang/OutOfMemoryError
    //   119	132	1065	java/lang/OutOfMemoryError
    //   141	149	1065	java/lang/OutOfMemoryError
    //   155	166	1065	java/lang/OutOfMemoryError
    //   172	177	1065	java/lang/OutOfMemoryError
    //   183	192	1065	java/lang/OutOfMemoryError
    //   198	206	1065	java/lang/OutOfMemoryError
    //   212	223	1065	java/lang/OutOfMemoryError
    //   229	243	1065	java/lang/OutOfMemoryError
    //   249	258	1065	java/lang/OutOfMemoryError
    //   264	272	1065	java/lang/OutOfMemoryError
    //   278	289	1065	java/lang/OutOfMemoryError
    //   295	316	1065	java/lang/OutOfMemoryError
    //   322	333	1065	java/lang/OutOfMemoryError
    //   339	344	1065	java/lang/OutOfMemoryError
    //   350	359	1065	java/lang/OutOfMemoryError
    //   365	373	1065	java/lang/OutOfMemoryError
    //   379	387	1065	java/lang/OutOfMemoryError
    //   393	407	1065	java/lang/OutOfMemoryError
    //   413	426	1065	java/lang/OutOfMemoryError
    //   438	444	1065	java/lang/OutOfMemoryError
    //   450	459	1065	java/lang/OutOfMemoryError
    //   465	473	1065	java/lang/OutOfMemoryError
    //   479	490	1065	java/lang/OutOfMemoryError
    //   496	510	1065	java/lang/OutOfMemoryError
    //   516	525	1065	java/lang/OutOfMemoryError
    //   531	539	1065	java/lang/OutOfMemoryError
    //   545	551	1065	java/lang/OutOfMemoryError
    //   557	575	1065	java/lang/OutOfMemoryError
    //   729	734	1065	java/lang/OutOfMemoryError
    //   744	753	1065	java/lang/OutOfMemoryError
    //   759	767	1065	java/lang/OutOfMemoryError
    //   773	780	1065	java/lang/OutOfMemoryError
    //   786	792	1065	java/lang/OutOfMemoryError
    //   798	803	1065	java/lang/OutOfMemoryError
    //   809	818	1065	java/lang/OutOfMemoryError
    //   824	832	1065	java/lang/OutOfMemoryError
    //   838	845	1065	java/lang/OutOfMemoryError
    //   851	865	1065	java/lang/OutOfMemoryError
    //   959	972	1065	java/lang/OutOfMemoryError
    //   85	95	1083	java/lang/Exception
    //   101	113	1083	java/lang/Exception
    //   119	132	1083	java/lang/Exception
    //   141	149	1083	java/lang/Exception
    //   155	166	1083	java/lang/Exception
    //   172	177	1083	java/lang/Exception
    //   183	192	1083	java/lang/Exception
    //   198	206	1083	java/lang/Exception
    //   212	223	1083	java/lang/Exception
    //   229	243	1083	java/lang/Exception
    //   249	258	1083	java/lang/Exception
    //   264	272	1083	java/lang/Exception
    //   278	289	1083	java/lang/Exception
    //   295	316	1083	java/lang/Exception
    //   322	333	1083	java/lang/Exception
    //   339	344	1083	java/lang/Exception
    //   350	359	1083	java/lang/Exception
    //   365	373	1083	java/lang/Exception
    //   379	387	1083	java/lang/Exception
    //   393	407	1083	java/lang/Exception
    //   413	426	1083	java/lang/Exception
    //   438	444	1083	java/lang/Exception
    //   450	459	1083	java/lang/Exception
    //   465	473	1083	java/lang/Exception
    //   479	490	1083	java/lang/Exception
    //   496	510	1083	java/lang/Exception
    //   516	525	1083	java/lang/Exception
    //   531	539	1083	java/lang/Exception
    //   545	551	1083	java/lang/Exception
    //   557	575	1083	java/lang/Exception
    //   729	734	1083	java/lang/Exception
    //   744	753	1083	java/lang/Exception
    //   759	767	1083	java/lang/Exception
    //   773	780	1083	java/lang/Exception
    //   786	792	1083	java/lang/Exception
    //   798	803	1083	java/lang/Exception
    //   809	818	1083	java/lang/Exception
    //   824	832	1083	java/lang/Exception
    //   838	845	1083	java/lang/Exception
    //   851	865	1083	java/lang/Exception
    //   959	972	1083	java/lang/Exception
    //   58	72	1101	finally
    //   58	72	1105	java/lang/OutOfMemoryError
    //   58	72	1122	java/lang/Exception
    //   48	58	1142	finally
    //   48	58	1153	java/lang/OutOfMemoryError
    //   1192	1196	1199	java/lang/Exception
    //   1222	1226	1229	java/lang/Exception
    //   1257	1262	1264	java/lang/Exception
    //   1407	1412	1264	java/lang/Exception
    //   48	58	1285	java/lang/Exception
    //   1342	1346	1349	java/lang/Exception
    //   1372	1376	1379	java/lang/Exception
    //   1173	1188	1416	finally
    //   1308	1313	1416	finally
    //   1323	1338	1416	finally
    //   1431	1435	1438	java/lang/Exception
    //   1461	1465	1468	java/lang/Exception
    //   1492	1497	1500	java/lang/Exception
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
      label42:
      boolean bool2;
      break label42;
    }
    bool2 = false;
    break label49;
    bool2 = true;
    try
    {
      label49:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label62:
      break label62;
    }
    paramString1 = null;
    bool2 = false;
    label133:
    label147:
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("\r\n");
      paramString2 = localStringBuilder.toString();
      bool1 = bool2;
      if (paramString1 == null) {
        break label118;
      }
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      boolean bool1;
      label116:
      label118:
      break label116;
    }
    bool1 = false;
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      break label133;
    }
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool2;
    }
    catch (IOException paramString1)
    {
      break label147;
    }
    bool1 = false;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */