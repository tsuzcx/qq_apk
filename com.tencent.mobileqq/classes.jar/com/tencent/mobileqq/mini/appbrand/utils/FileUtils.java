package com.tencent.mobileqq.mini.appbrand.utils;

import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtils
{
  public static final String TAG = "MiniAppFileUtils";
  private static char[] hexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static boolean copyFile(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    return copyFile(paramVFSFile1, paramVFSFile2, false);
  }
  
  /* Error */
  public static boolean copyFile(VFSFile paramVFSFile1, VFSFile paramVFSFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 8
    //   12: iconst_1
    //   13: istore 5
    //   15: aload_1
    //   16: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   19: ifeq +8 -> 27
    //   22: aload_1
    //   23: invokevirtual 52	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   26: pop
    //   27: aload_1
    //   28: invokevirtual 56	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   31: ifnull +21 -> 52
    //   34: aload_1
    //   35: invokevirtual 56	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   38: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   41: ifne +11 -> 52
    //   44: aload_1
    //   45: invokevirtual 56	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   48: invokevirtual 59	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   51: pop
    //   52: new 61	com/tencent/mm/vfs/VFSFileOutputStream
    //   55: dup
    //   56: aload_1
    //   57: invokespecial 64	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   60: astore_1
    //   61: aload 7
    //   63: astore 6
    //   65: aload_1
    //   66: astore 7
    //   68: new 66	java/io/BufferedInputStream
    //   71: dup
    //   72: new 68	com/tencent/mm/vfs/VFSFileInputStream
    //   75: dup
    //   76: aload_0
    //   77: invokespecial 69	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   80: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   83: astore_0
    //   84: invokestatic 78	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   87: sipush 4096
    //   90: invokevirtual 82	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   93: astore 6
    //   95: aload_0
    //   96: aload 6
    //   98: invokevirtual 86	java/io/BufferedInputStream:read	([B)I
    //   101: istore_3
    //   102: iload_3
    //   103: iconst_m1
    //   104: if_icmpeq +65 -> 169
    //   107: aload_1
    //   108: aload 6
    //   110: iconst_0
    //   111: iload_3
    //   112: invokevirtual 90	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   115: aload_1
    //   116: invokevirtual 93	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   119: goto -24 -> 95
    //   122: astore 7
    //   124: aload_0
    //   125: astore 6
    //   127: aload_1
    //   128: astore_0
    //   129: aload 7
    //   131: astore_1
    //   132: iload_2
    //   133: ifeq +12 -> 145
    //   136: ldc 8
    //   138: iconst_1
    //   139: ldc 95
    //   141: aload_1
    //   142: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   153: aload 6
    //   155: ifnull +322 -> 477
    //   158: aload 6
    //   160: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   163: iconst_0
    //   164: istore 4
    //   166: iload 4
    //   168: ireturn
    //   169: invokestatic 78	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   172: aload 6
    //   174: invokevirtual 109	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   177: aload_1
    //   178: ifnull +7 -> 185
    //   181: aload_1
    //   182: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   185: iload 5
    //   187: istore 4
    //   189: aload_0
    //   190: ifnull -24 -> 166
    //   193: aload_0
    //   194: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   197: iconst_1
    //   198: ireturn
    //   199: astore_0
    //   200: iload 5
    //   202: istore 4
    //   204: iload_2
    //   205: ifeq -39 -> 166
    //   208: ldc 8
    //   210: iconst_1
    //   211: ldc 95
    //   213: aload_0
    //   214: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   217: iconst_1
    //   218: ireturn
    //   219: astore_1
    //   220: iload_2
    //   221: ifeq -36 -> 185
    //   224: ldc 8
    //   226: iconst_1
    //   227: ldc 95
    //   229: aload_1
    //   230: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   233: goto -48 -> 185
    //   236: astore_0
    //   237: iload_2
    //   238: ifeq -85 -> 153
    //   241: ldc 8
    //   243: iconst_1
    //   244: ldc 95
    //   246: aload_0
    //   247: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   250: goto -97 -> 153
    //   253: astore_0
    //   254: iload_2
    //   255: ifeq +12 -> 267
    //   258: ldc 8
    //   260: iconst_1
    //   261: ldc 95
    //   263: aload_0
    //   264: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: iconst_0
    //   268: ireturn
    //   269: astore_0
    //   270: aconst_null
    //   271: astore_1
    //   272: aload 9
    //   274: astore 8
    //   276: iload_2
    //   277: ifeq +19 -> 296
    //   280: aload 8
    //   282: astore 6
    //   284: aload_1
    //   285: astore 7
    //   287: ldc 8
    //   289: iconst_1
    //   290: ldc 95
    //   292: aload_0
    //   293: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   304: aload 8
    //   306: ifnull +171 -> 477
    //   309: aload 8
    //   311: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   314: iconst_0
    //   315: ireturn
    //   316: astore_0
    //   317: iload_2
    //   318: ifeq -14 -> 304
    //   321: ldc 8
    //   323: iconst_1
    //   324: ldc 95
    //   326: aload_0
    //   327: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   330: goto -26 -> 304
    //   333: astore_0
    //   334: iload_2
    //   335: ifeq +12 -> 347
    //   338: ldc 8
    //   340: iconst_1
    //   341: ldc 95
    //   343: aload_0
    //   344: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   347: iconst_0
    //   348: ireturn
    //   349: astore_0
    //   350: aconst_null
    //   351: astore_1
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   360: aload 6
    //   362: ifnull +8 -> 370
    //   365: aload 6
    //   367: invokevirtual 105	java/io/BufferedInputStream:close	()V
    //   370: aload_0
    //   371: athrow
    //   372: astore_1
    //   373: iload_2
    //   374: ifeq -14 -> 360
    //   377: ldc 8
    //   379: iconst_1
    //   380: ldc 95
    //   382: aload_1
    //   383: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   386: goto -26 -> 360
    //   389: astore_1
    //   390: iload_2
    //   391: ifeq -21 -> 370
    //   394: ldc 8
    //   396: iconst_1
    //   397: ldc 95
    //   399: aload_1
    //   400: invokestatic 101	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   403: goto -33 -> 370
    //   406: astore_0
    //   407: aload 7
    //   409: astore_1
    //   410: goto -58 -> 352
    //   413: astore 7
    //   415: aload_0
    //   416: astore 6
    //   418: aload 7
    //   420: astore_0
    //   421: goto -69 -> 352
    //   424: astore 7
    //   426: aload_0
    //   427: astore_1
    //   428: aload 7
    //   430: astore_0
    //   431: goto -79 -> 352
    //   434: astore_0
    //   435: aload 9
    //   437: astore 8
    //   439: goto -163 -> 276
    //   442: astore 6
    //   444: aload_0
    //   445: astore 8
    //   447: aload 6
    //   449: astore_0
    //   450: goto -174 -> 276
    //   453: astore_1
    //   454: aconst_null
    //   455: astore_0
    //   456: aload 8
    //   458: astore 6
    //   460: goto -328 -> 132
    //   463: astore 6
    //   465: aload_1
    //   466: astore_0
    //   467: aload 6
    //   469: astore_1
    //   470: aload 8
    //   472: astore 6
    //   474: goto -342 -> 132
    //   477: iconst_0
    //   478: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	paramVFSFile1	VFSFile
    //   0	479	1	paramVFSFile2	VFSFile
    //   0	479	2	paramBoolean	boolean
    //   101	11	3	i	int
    //   164	39	4	bool1	boolean
    //   13	188	5	bool2	boolean
    //   4	413	6	localObject1	Object
    //   442	6	6	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   458	1	6	localObject2	Object
    //   463	5	6	localIOException1	IOException
    //   472	1	6	localObject3	Object
    //   7	60	7	localVFSFile1	VFSFile
    //   122	8	7	localIOException2	IOException
    //   285	123	7	localVFSFile2	VFSFile
    //   413	6	7	localObject4	Object
    //   424	5	7	localObject5	Object
    //   10	461	8	localObject6	Object
    //   1	435	9	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   84	95	122	java/io/IOException
    //   95	102	122	java/io/IOException
    //   107	119	122	java/io/IOException
    //   169	177	122	java/io/IOException
    //   193	197	199	java/io/IOException
    //   181	185	219	java/io/IOException
    //   149	153	236	java/io/IOException
    //   158	163	253	java/io/IOException
    //   15	27	269	java/lang/OutOfMemoryError
    //   27	52	269	java/lang/OutOfMemoryError
    //   52	61	269	java/lang/OutOfMemoryError
    //   300	304	316	java/io/IOException
    //   309	314	333	java/io/IOException
    //   15	27	349	finally
    //   27	52	349	finally
    //   52	61	349	finally
    //   356	360	372	java/io/IOException
    //   365	370	389	java/io/IOException
    //   68	84	406	finally
    //   287	296	406	finally
    //   84	95	413	finally
    //   95	102	413	finally
    //   107	119	413	finally
    //   169	177	413	finally
    //   136	145	424	finally
    //   68	84	434	java/lang/OutOfMemoryError
    //   84	95	442	java/lang/OutOfMemoryError
    //   95	102	442	java/lang/OutOfMemoryError
    //   107	119	442	java/lang/OutOfMemoryError
    //   169	177	442	java/lang/OutOfMemoryError
    //   15	27	453	java/io/IOException
    //   27	52	453	java/io/IOException
    //   52	61	453	java/io/IOException
    //   68	84	463	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    VFSFile localVFSFile;
    do
    {
      return false;
      localVFSFile = new VFSFile(paramString1);
    } while (!localVFSFile.exists());
    try
    {
      boolean bool = copyFile(localVFSFile, createFile(paramString2));
      return bool;
    }
    catch (IOException localIOException)
    {
      QLog.d("MiniAppFileUtils", 2, "copy fail from " + paramString1 + " to " + paramString2 + " " + localIOException.getMessage());
    }
    return false;
  }
  
  public static VFSFile createFile(String paramString)
  {
    paramString = new VFSFile(paramString);
    if (!paramString.exists())
    {
      if ((paramString.getParentFile() == null) || (paramString.getParentFile().exists())) {
        break label50;
      }
      if (paramString.getParentFile().mkdirs()) {
        paramString.createNewFile();
      }
    }
    return paramString;
    label50:
    paramString.createNewFile();
    return paramString;
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      VFSFile[] arrayOfVFSFile;
      do
      {
        do
        {
          return;
          paramString = new VFSFile(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfVFSFile = paramString.listFiles();
      } while (arrayOfVFSFile == null);
      int j = arrayOfVFSFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfVFSFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
  }
  
  public static void deleteDirectory(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      return;
    }
    paramString = new VFSFile(paramString);
    VFSFile[] arrayOfVFSFile = paramString.listFiles();
    if ((arrayOfVFSFile != null) && (arrayOfVFSFile.length > 0))
    {
      int i = 0;
      if (i < arrayOfVFSFile.length)
      {
        if (arrayOfVFSFile[i].isDirectory()) {
          deleteDirectory(arrayOfVFSFile[i].getAbsolutePath());
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfVFSFile[i].delete();
        }
      }
    }
    paramString.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    boolean bool = true;
    paramString = new VFSFile(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
  }
  
  public static void deleteFilesInDirectory(String paramString)
  {
    if ((paramString == null) || (paramString.trim().length() == 0)) {}
    do
    {
      return;
      paramString = new VFSFile(paramString).listFiles();
    } while ((paramString == null) || (paramString.length <= 0));
    int i = 0;
    label38:
    if (i < paramString.length)
    {
      if (!paramString[i].isDirectory()) {
        break label69;
      }
      deleteDirectory(paramString[i].getAbsolutePath());
    }
    for (;;)
    {
      i += 1;
      break label38;
      break;
      label69:
      paramString[i].delete();
    }
  }
  
  /* Error */
  public static byte[] encodeFile(String paramString)
  {
    // Byte code:
    //   0: ldc 185
    //   2: invokestatic 191	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   5: astore_3
    //   6: new 68	com/tencent/mm/vfs/VFSFileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 192	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: sipush 16384
    //   18: newarray byte
    //   20: astore_0
    //   21: aload_2
    //   22: aload_0
    //   23: invokevirtual 193	com/tencent/mm/vfs/VFSFileInputStream:read	([B)I
    //   26: istore_1
    //   27: iload_1
    //   28: iconst_m1
    //   29: if_icmpeq +22 -> 51
    //   32: aload_3
    //   33: aload_0
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 196	java/security/MessageDigest:update	([BII)V
    //   39: goto -18 -> 21
    //   42: astore_0
    //   43: aload_2
    //   44: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   47: aconst_null
    //   48: astore_0
    //   49: aload_0
    //   50: areturn
    //   51: aload_3
    //   52: invokevirtual 201	java/security/MessageDigest:digest	()[B
    //   55: astore_0
    //   56: aload_2
    //   57: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   60: goto -11 -> 49
    //   63: astore_2
    //   64: goto -15 -> 49
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: goto -21 -> 49
    //   73: astore_0
    //   74: aload_2
    //   75: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   78: aload_0
    //   79: athrow
    //   80: astore_0
    //   81: aconst_null
    //   82: areturn
    //   83: astore_2
    //   84: goto -6 -> 78
    //   87: astore_0
    //   88: aconst_null
    //   89: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramString	String
    //   26	10	1	i	int
    //   14	43	2	localVFSFileInputStream	com.tencent.mm.vfs.VFSFileInputStream
    //   63	12	2	localIOException1	IOException
    //   83	1	2	localIOException2	IOException
    //   5	47	3	localMessageDigest	java.security.MessageDigest
    // Exception table:
    //   from	to	target	type
    //   21	27	42	java/io/IOException
    //   32	39	42	java/io/IOException
    //   51	56	42	java/io/IOException
    //   56	60	63	java/io/IOException
    //   43	47	67	java/io/IOException
    //   21	27	73	finally
    //   32	39	73	finally
    //   51	56	73	finally
    //   0	21	80	java/io/FileNotFoundException
    //   43	47	80	java/io/FileNotFoundException
    //   56	60	80	java/io/FileNotFoundException
    //   74	78	80	java/io/FileNotFoundException
    //   78	80	80	java/io/FileNotFoundException
    //   74	78	83	java/io/IOException
    //   0	21	87	java/security/NoSuchAlgorithmException
    //   43	47	87	java/security/NoSuchAlgorithmException
    //   56	60	87	java/security/NoSuchAlgorithmException
    //   74	78	87	java/security/NoSuchAlgorithmException
    //   78	80	87	java/security/NoSuchAlgorithmException
  }
  
  public static String encodeFile2HexStr(String paramString)
  {
    return HexUtil.bytes2HexStr(encodeFile(paramString));
  }
  
  public static boolean fileExists(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new VFSFile(paramString);
    } while ((paramString == null) || (!paramString.exists()));
    return true;
  }
  
  /* Error */
  public static byte[] fileToBytes(VFSFile paramVFSFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   4: ifne +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 66	java/io/BufferedInputStream
    //   12: dup
    //   13: new 68	com/tencent/mm/vfs/VFSFileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 69	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   21: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 5
    //   26: aload_0
    //   27: invokevirtual 219	com/tencent/mm/vfs/VFSFile:length	()J
    //   30: lstore_3
    //   31: lload_3
    //   32: ldc2_w 220
    //   35: lcmp
    //   36: ifgt +9 -> 45
    //   39: lload_3
    //   40: lconst_0
    //   41: lcmp
    //   42: ifgt +53 -> 95
    //   45: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   48: ifeq +28 -> 76
    //   51: ldc 226
    //   53: iconst_2
    //   54: new 121	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   61: ldc 228
    //   63: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: lload_3
    //   67: invokevirtual 231	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   70: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload 5
    //   78: ifnull -71 -> 7
    //   81: aload 5
    //   83: invokevirtual 234	java/io/InputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 237	java/lang/Throwable:printStackTrace	()V
    //   93: aconst_null
    //   94: areturn
    //   95: lload_3
    //   96: l2i
    //   97: istore_1
    //   98: iload_1
    //   99: newarray byte
    //   101: astore 6
    //   103: iconst_0
    //   104: istore_1
    //   105: iload_1
    //   106: aload 6
    //   108: arraylength
    //   109: if_icmpge +28 -> 137
    //   112: aload 5
    //   114: aload 6
    //   116: iload_1
    //   117: aload 6
    //   119: arraylength
    //   120: iload_1
    //   121: isub
    //   122: invokevirtual 240	java/io/InputStream:read	([BII)I
    //   125: istore_2
    //   126: iload_2
    //   127: iflt +10 -> 137
    //   130: iload_1
    //   131: iload_2
    //   132: iadd
    //   133: istore_1
    //   134: goto -29 -> 105
    //   137: iload_1
    //   138: aload 6
    //   140: arraylength
    //   141: if_icmpge +34 -> 175
    //   144: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +28 -> 175
    //   150: ldc 226
    //   152: iconst_2
    //   153: new 121	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   160: ldc 242
    //   162: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: aload_0
    //   166: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload 5
    //   177: ifnull +8 -> 185
    //   180: aload 5
    //   182: invokevirtual 234	java/io/InputStream:close	()V
    //   185: aload 6
    //   187: areturn
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 237	java/lang/Throwable:printStackTrace	()V
    //   193: goto -8 -> 185
    //   196: astore 5
    //   198: aconst_null
    //   199: astore 5
    //   201: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +28 -> 232
    //   207: ldc 226
    //   209: iconst_2
    //   210: new 121	java/lang/StringBuilder
    //   213: dup
    //   214: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   217: ldc 247
    //   219: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: aload_0
    //   223: invokevirtual 245	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   226: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 143	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: aload 5
    //   234: ifnull -227 -> 7
    //   237: aload 5
    //   239: invokevirtual 234	java/io/InputStream:close	()V
    //   242: aconst_null
    //   243: areturn
    //   244: astore_0
    //   245: aload_0
    //   246: invokevirtual 237	java/lang/Throwable:printStackTrace	()V
    //   249: aconst_null
    //   250: areturn
    //   251: astore_0
    //   252: aconst_null
    //   253: astore 5
    //   255: aload 5
    //   257: ifnull +8 -> 265
    //   260: aload 5
    //   262: invokevirtual 234	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: astore 5
    //   269: aload 5
    //   271: invokevirtual 237	java/lang/Throwable:printStackTrace	()V
    //   274: goto -9 -> 265
    //   277: astore_0
    //   278: goto -23 -> 255
    //   281: astore_0
    //   282: goto -27 -> 255
    //   285: astore 6
    //   287: goto -86 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	paramVFSFile	VFSFile
    //   97	45	1	i	int
    //   125	8	2	j	int
    //   30	66	3	l	long
    //   24	157	5	localBufferedInputStream	java.io.BufferedInputStream
    //   196	1	5	localThrowable1	java.lang.Throwable
    //   199	62	5	localObject	Object
    //   267	3	5	localThrowable2	java.lang.Throwable
    //   101	85	6	arrayOfByte	byte[]
    //   285	1	6	localThrowable3	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   81	86	88	java/lang/Throwable
    //   180	185	188	java/lang/Throwable
    //   9	26	196	java/lang/Throwable
    //   237	242	244	java/lang/Throwable
    //   9	26	251	finally
    //   260	265	267	java/lang/Throwable
    //   26	31	277	finally
    //   45	76	277	finally
    //   98	103	277	finally
    //   105	126	277	finally
    //   137	175	277	finally
    //   201	232	281	finally
    //   26	31	285	java/lang/Throwable
    //   45	76	285	java/lang/Throwable
    //   98	103	285	java/lang/Throwable
    //   105	126	285	java/lang/Throwable
    //   137	175	285	java/lang/Throwable
  }
  
  public static long getFileOrFolderSize(String paramString)
  {
    long l2 = 0L;
    paramString = new VFSFile(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label36;
      }
      l1 = paramString.length();
    }
    label36:
    int j;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            l1 = l2;
          } while (!paramString.isDirectory());
          paramString = paramString.listFiles();
          l1 = l2;
        } while (paramString == null);
        l1 = l2;
      } while (paramString.length <= 0);
      j = paramString.length;
      i = 0;
      l1 = l2;
    } while (i >= j);
    Object localObject = paramString[i];
    l1 = l2;
    if (localObject != null)
    {
      l1 = l2;
      if (localObject.exists())
      {
        if (!localObject.isDirectory()) {
          break label133;
        }
        l1 = l2 + getFileOrFolderSize(localObject.getAbsolutePath());
      }
    }
    for (;;)
    {
      i += 1;
      l2 = l1;
      break;
      label133:
      l1 = l2;
      if (localObject.isFile()) {
        l1 = l2 + localObject.length();
      }
    }
  }
  
  public static String getFileSHA1(String paramString)
  {
    try
    {
      paramString = getHash(paramString, "SHA1");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  /* Error */
  public static long getFileSizes(String paramString)
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 6
    //   5: new 45	com/tencent/mm/vfs/VFSFile
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 113	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   13: astore_0
    //   14: aload_0
    //   15: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   18: ifeq +37 -> 55
    //   21: new 68	com/tencent/mm/vfs/VFSFileInputStream
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 69	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   29: astore_0
    //   30: aload_0
    //   31: invokevirtual 267	com/tencent/mm/vfs/VFSFileInputStream:available	()I
    //   34: istore_1
    //   35: iload_1
    //   36: i2l
    //   37: lstore 4
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +10 -> 53
    //   46: aload_0
    //   47: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   50: lload 4
    //   52: lstore_2
    //   53: lload_2
    //   54: lreturn
    //   55: iconst_0
    //   56: ifeq -3 -> 53
    //   59: new 269	java/lang/NullPointerException
    //   62: dup
    //   63: invokespecial 270	java/lang/NullPointerException:<init>	()V
    //   66: athrow
    //   67: astore_0
    //   68: lconst_0
    //   69: lreturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull -21 -> 53
    //   77: aload_0
    //   78: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   81: lconst_0
    //   82: lreturn
    //   83: astore_0
    //   84: lconst_0
    //   85: lreturn
    //   86: astore_0
    //   87: aload 6
    //   89: ifnull +8 -> 97
    //   92: aload 6
    //   94: invokevirtual 197	com/tencent/mm/vfs/VFSFileInputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: astore_0
    //   100: lload 4
    //   102: lreturn
    //   103: astore 6
    //   105: goto -8 -> 97
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload 7
    //   115: astore_0
    //   116: goto -29 -> 87
    //   119: astore 6
    //   121: goto -48 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramString	String
    //   34	2	1	i	int
    //   1	53	2	l1	long
    //   37	64	4	l2	long
    //   3	90	6	localObject1	Object
    //   103	1	6	localIOException	IOException
    //   111	1	6	str	String
    //   119	1	6	localException	Exception
    //   108	6	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   59	67	67	java/io/IOException
    //   5	30	70	java/lang/Exception
    //   77	81	83	java/io/IOException
    //   5	30	86	finally
    //   46	50	99	java/io/IOException
    //   92	97	103	java/io/IOException
    //   30	35	108	finally
    //   30	35	119	java/lang/Exception
  }
  
  /* Error */
  private static String getHash(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 66	java/io/BufferedInputStream
    //   3: dup
    //   4: new 68	com/tencent/mm/vfs/VFSFileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 192	com/tencent/mm/vfs/VFSFileInputStream:<init>	(Ljava/lang/String;)V
    //   12: invokespecial 72	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_0
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore_3
    //   22: aload_1
    //   23: invokestatic 191	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   26: astore_1
    //   27: aload_0
    //   28: aload_3
    //   29: invokevirtual 271	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: ifle +28 -> 62
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 196	java/security/MessageDigest:update	([BII)V
    //   44: goto -17 -> 27
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_3
    //   51: astore_0
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 234	java/io/InputStream:close	()V
    //   60: aload_0
    //   61: athrow
    //   62: aload_0
    //   63: ifnull +7 -> 70
    //   66: aload_0
    //   67: invokevirtual 234	java/io/InputStream:close	()V
    //   70: aload_1
    //   71: invokevirtual 201	java/security/MessageDigest:digest	()[B
    //   74: invokestatic 274	com/tencent/mobileqq/mini/appbrand/utils/FileUtils:toHexString	([B)Ljava/lang/String;
    //   77: areturn
    //   78: astore_0
    //   79: goto -9 -> 70
    //   82: astore_1
    //   83: goto -23 -> 60
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -37 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	paramString1	String
    //   0	92	1	paramString2	String
    //   32	9	2	i	int
    //   21	18	3	arrayOfByte	byte[]
    //   47	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   16	27	47	finally
    //   27	33	47	finally
    //   37	44	47	finally
    //   66	70	78	java/io/IOException
    //   56	60	82	java/io/IOException
    //   0	16	86	finally
  }
  
  public static boolean moveFile(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new VFSFile(paramString1);
    } while (!paramString1.exists());
    try
    {
      copyFile(paramString1, createFile(paramString2));
      paramString1.delete();
      return true;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new VFSFile(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new VFSFile(paramString2));
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(hexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(hexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    return writeFile(paramString1, paramString2, true);
  }
  
  public static boolean writeFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = new VFSFile(paramString1);
    boolean bool2 = true;
    bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
      bool1 = bool2;
      String str;
      return false;
    }
    catch (IOException localIOException)
    {
      try
      {
        for (;;)
        {
          paramString1 = new VFSFileOutputStream(paramString1, false);
          str = paramString2;
          if (paramBoolean) {}
          try
          {
            str = paramString2 + "\r\n";
            paramBoolean = bool1;
            if (paramString1 != null)
            {
              paramString1.write(str.getBytes());
              paramBoolean = bool1;
            }
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              paramBoolean = false;
            }
          }
          bool1 = paramBoolean;
          if (paramString1 != null) {}
          try
          {
            paramString1.flush();
            bool1 = paramBoolean;
          }
          catch (IOException paramString2)
          {
            for (;;)
            {
              bool1 = false;
            }
          }
          if (paramString1 != null) {}
          try
          {
            paramString1.close();
            return bool1;
          }
          catch (IOException paramString1) {}
          localIOException = localIOException;
          bool1 = false;
        }
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          bool1 = false;
          paramString1 = null;
        }
      }
    }
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString)
  {
    return writeFile(paramArrayOfByte, paramString, false);
  }
  
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean)
  {
    return writeFile(paramArrayOfByte, paramString, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(byte[] paramArrayOfByte, String paramString, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 45	com/tencent/mm/vfs/VFSFile
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 113	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   14: astore_1
    //   15: aload_1
    //   16: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 56	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   26: invokevirtual 49	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 56	com/tencent/mm/vfs/VFSFile:getParentFile	()Lcom/tencent/mm/vfs/VFSFile;
    //   36: invokevirtual 59	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 146	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   44: pop
    //   45: new 61	com/tencent/mm/vfs/VFSFileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 293	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 90	com/tencent/mm/vfs/VFSFileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 93	com/tencent/mm/vfs/VFSFileOutputStream:flush	()V
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   74: iconst_1
    //   75: istore_2
    //   76: iload_2
    //   77: ireturn
    //   78: astore_0
    //   79: aconst_null
    //   80: astore_0
    //   81: iload 4
    //   83: istore_2
    //   84: aload_0
    //   85: ifnull -9 -> 76
    //   88: aload_0
    //   89: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_0
    //   95: iconst_0
    //   96: ireturn
    //   97: astore_0
    //   98: aload 5
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 104	com/tencent/mm/vfs/VFSFileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore_0
    //   119: goto -18 -> 101
    //   122: astore_0
    //   123: aload_1
    //   124: astore_0
    //   125: goto -44 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramArrayOfByte	byte[]
    //   0	128	1	paramString	String
    //   0	128	2	paramBoolean	boolean
    //   0	128	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	40	78	java/io/IOException
    //   40	45	78	java/io/IOException
    //   45	55	78	java/io/IOException
    //   88	92	94	java/io/IOException
    //   15	40	97	finally
    //   40	45	97	finally
    //   45	55	97	finally
    //   70	74	111	java/io/IOException
    //   105	109	114	java/io/IOException
    //   55	66	118	finally
    //   55	66	122	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */