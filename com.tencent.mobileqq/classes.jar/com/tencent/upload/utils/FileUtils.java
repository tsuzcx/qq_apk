package com.tencent.upload.utils;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadEnv;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtils
{
  public static final String FILE_TYPE_APNG = "apng";
  public static final String FILE_TYPE_BMP = "bmp";
  public static final String FILE_TYPE_GIF = "gif";
  public static final String FILE_TYPE_JPEG = "jpg";
  public static final String FILE_TYPE_PNG = "png";
  public static final String FILE_TYPE_SHARPP = "sharpp";
  public static final String FILE_TYPE_WEBP = "webp";
  public static final String UPLOAD_TEMP_DIR = "uploader";
  public static final String UPLOAD_TEMP_FILE_SEPERATOR = "_";
  public static final int UPLOAD_TEMP_SPACE_THRESHOLD = 5;
  public static final String UPLOAD_TEMP_SUFFIX = ".qtmp";
  private static final String tag = FileUtils.class.getSimpleName();
  public static String unKnownFileTypeMark = "unknown_";
  
  public static void clearUploadDir(Context paramContext, long paramLong1, long paramLong2)
  {
    File localFile = getExternalFilesDir(paramContext);
    if ((localFile != null) && (getCacheDirUsedSpace(localFile) >= paramLong1)) {
      deleteDir(localFile);
    }
    paramContext = paramContext.getDir("uploader", 0);
    if ((paramContext != null) && (getCacheDirUsedSpace(paramContext) >= paramLong2)) {
      deleteDir(paramContext);
    }
  }
  
  /* Error */
  public static boolean copyFile(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: aconst_null
    //   7: astore 12
    //   9: aload_0
    //   10: ifnull +18 -> 28
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 92	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifeq +10 -> 28
    //   21: iload 4
    //   23: istore 5
    //   25: iload 5
    //   27: ireturn
    //   28: new 94	java/io/FileInputStream
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   36: astore_0
    //   37: new 99	java/io/FileOutputStream
    //   40: dup
    //   41: aload_1
    //   42: invokespecial 100	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   45: astore 11
    //   47: aload 11
    //   49: astore 9
    //   51: aload_0
    //   52: astore 8
    //   54: sipush 10240
    //   57: newarray byte
    //   59: astore 10
    //   61: iconst_0
    //   62: istore_2
    //   63: aload 11
    //   65: astore 9
    //   67: aload_0
    //   68: astore 8
    //   70: aload_0
    //   71: aload 10
    //   73: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   76: istore_3
    //   77: iload_3
    //   78: iconst_m1
    //   79: if_icmpeq +26 -> 105
    //   82: aload 11
    //   84: astore 9
    //   86: aload_0
    //   87: astore 8
    //   89: aload 11
    //   91: aload 10
    //   93: iconst_0
    //   94: iload_3
    //   95: invokevirtual 108	java/io/FileOutputStream:write	([BII)V
    //   98: iload_2
    //   99: iload_3
    //   100: iadd
    //   101: istore_2
    //   102: goto -39 -> 63
    //   105: aload 11
    //   107: astore 9
    //   109: aload_0
    //   110: astore 8
    //   112: aload 11
    //   114: invokevirtual 111	java/io/FileOutputStream:flush	()V
    //   117: aload_0
    //   118: ifnull +7 -> 125
    //   121: aload_0
    //   122: invokevirtual 114	java/io/FileInputStream:close	()V
    //   125: iload_2
    //   126: istore_3
    //   127: iload 5
    //   129: istore 4
    //   131: aload 11
    //   133: ifnull +14 -> 147
    //   136: aload 11
    //   138: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   141: iload 5
    //   143: istore 4
    //   145: iload_2
    //   146: istore_3
    //   147: new 117	java/io/File
    //   150: dup
    //   151: aload_1
    //   152: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_0
    //   156: aload_0
    //   157: ifnull +26 -> 183
    //   160: aload_0
    //   161: invokevirtual 122	java/io/File:exists	()Z
    //   164: ifeq +19 -> 183
    //   167: aload_0
    //   168: invokevirtual 126	java/io/File:length	()J
    //   171: lstore 6
    //   173: aload_0
    //   174: astore_1
    //   175: lload 6
    //   177: iload_3
    //   178: i2l
    //   179: lcmp
    //   180: ifeq +8 -> 188
    //   183: iconst_0
    //   184: istore 4
    //   186: aload_0
    //   187: astore_1
    //   188: iload 4
    //   190: istore 5
    //   192: iload 4
    //   194: ifne -169 -> 25
    //   197: iload 4
    //   199: istore 5
    //   201: aload_1
    //   202: ifnull -177 -> 25
    //   205: aload_1
    //   206: invokevirtual 129	java/io/File:delete	()Z
    //   209: pop
    //   210: iload 4
    //   212: ireturn
    //   213: astore_0
    //   214: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   217: ldc 131
    //   219: aload_0
    //   220: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: iload_2
    //   224: istore_3
    //   225: iload 5
    //   227: istore 4
    //   229: goto -82 -> 147
    //   232: astore 10
    //   234: aconst_null
    //   235: astore 11
    //   237: aconst_null
    //   238: astore_0
    //   239: iconst_0
    //   240: istore_2
    //   241: aload 11
    //   243: astore 9
    //   245: aload_0
    //   246: astore 8
    //   248: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   251: ldc 131
    //   253: aload 10
    //   255: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   258: aload_0
    //   259: ifnull +7 -> 266
    //   262: aload_0
    //   263: invokevirtual 114	java/io/FileInputStream:close	()V
    //   266: aload 11
    //   268: ifnull +8 -> 276
    //   271: aload 11
    //   273: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   276: iconst_0
    //   277: istore 4
    //   279: iload_2
    //   280: istore_3
    //   281: goto -134 -> 147
    //   284: astore_0
    //   285: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   288: ldc 131
    //   290: aload_0
    //   291: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   294: iconst_0
    //   295: istore 4
    //   297: iload_2
    //   298: istore_3
    //   299: goto -152 -> 147
    //   302: astore 10
    //   304: aconst_null
    //   305: astore 11
    //   307: aconst_null
    //   308: astore_0
    //   309: iconst_0
    //   310: istore_2
    //   311: aload 11
    //   313: astore 9
    //   315: aload_0
    //   316: astore 8
    //   318: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   321: ldc 131
    //   323: aload 10
    //   325: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   328: aload_0
    //   329: ifnull +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 114	java/io/FileInputStream:close	()V
    //   336: aload 11
    //   338: ifnull +8 -> 346
    //   341: aload 11
    //   343: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   346: iconst_0
    //   347: istore 4
    //   349: iload_2
    //   350: istore_3
    //   351: goto -204 -> 147
    //   354: astore_0
    //   355: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   358: ldc 131
    //   360: aload_0
    //   361: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   364: iconst_0
    //   365: istore 4
    //   367: iload_2
    //   368: istore_3
    //   369: goto -222 -> 147
    //   372: astore_1
    //   373: aconst_null
    //   374: astore 9
    //   376: aconst_null
    //   377: astore_0
    //   378: aload_0
    //   379: ifnull +7 -> 386
    //   382: aload_0
    //   383: invokevirtual 114	java/io/FileInputStream:close	()V
    //   386: aload 9
    //   388: ifnull +8 -> 396
    //   391: aload 9
    //   393: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   396: aload_1
    //   397: athrow
    //   398: astore_0
    //   399: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   402: ldc 131
    //   404: aload_0
    //   405: invokestatic 137	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   408: goto -12 -> 396
    //   411: astore_0
    //   412: aload 12
    //   414: astore_0
    //   415: aload_0
    //   416: astore_1
    //   417: goto -229 -> 188
    //   420: astore_1
    //   421: goto -6 -> 415
    //   424: astore_1
    //   425: aconst_null
    //   426: astore 9
    //   428: goto -50 -> 378
    //   431: astore_1
    //   432: aload 8
    //   434: astore_0
    //   435: goto -57 -> 378
    //   438: astore 10
    //   440: aconst_null
    //   441: astore 11
    //   443: iconst_0
    //   444: istore_2
    //   445: goto -134 -> 311
    //   448: astore 10
    //   450: iconst_0
    //   451: istore_2
    //   452: goto -141 -> 311
    //   455: astore 10
    //   457: goto -146 -> 311
    //   460: astore 10
    //   462: aconst_null
    //   463: astore 11
    //   465: iconst_0
    //   466: istore_2
    //   467: goto -226 -> 241
    //   470: astore 10
    //   472: iconst_0
    //   473: istore_2
    //   474: goto -233 -> 241
    //   477: astore 10
    //   479: goto -238 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	paramString1	String
    //   0	482	1	paramString2	String
    //   62	412	2	i	int
    //   76	293	3	j	int
    //   4	362	4	bool1	boolean
    //   1	225	5	bool2	boolean
    //   171	5	6	l	long
    //   52	381	8	str	String
    //   49	378	9	localFileOutputStream1	java.io.FileOutputStream
    //   59	33	10	arrayOfByte	byte[]
    //   232	22	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   302	22	10	localIOException1	java.io.IOException
    //   438	1	10	localIOException2	java.io.IOException
    //   448	1	10	localIOException3	java.io.IOException
    //   455	1	10	localIOException4	java.io.IOException
    //   460	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   470	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   477	1	10	localFileNotFoundException4	java.io.FileNotFoundException
    //   45	419	11	localFileOutputStream2	java.io.FileOutputStream
    //   7	406	12	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   121	125	213	java/io/IOException
    //   136	141	213	java/io/IOException
    //   28	37	232	java/io/FileNotFoundException
    //   262	266	284	java/io/IOException
    //   271	276	284	java/io/IOException
    //   28	37	302	java/io/IOException
    //   332	336	354	java/io/IOException
    //   341	346	354	java/io/IOException
    //   28	37	372	finally
    //   382	386	398	java/io/IOException
    //   391	396	398	java/io/IOException
    //   147	156	411	java/lang/IllegalArgumentException
    //   160	173	420	java/lang/IllegalArgumentException
    //   37	47	424	finally
    //   54	61	431	finally
    //   70	77	431	finally
    //   89	98	431	finally
    //   112	117	431	finally
    //   248	258	431	finally
    //   318	328	431	finally
    //   37	47	438	java/io/IOException
    //   54	61	448	java/io/IOException
    //   70	77	455	java/io/IOException
    //   89	98	455	java/io/IOException
    //   112	117	455	java/io/IOException
    //   37	47	460	java/io/FileNotFoundException
    //   54	61	470	java/io/FileNotFoundException
    //   70	77	477	java/io/FileNotFoundException
    //   89	98	477	java/io/FileNotFoundException
    //   112	117	477	java/io/FileNotFoundException
  }
  
  public static void deleteAllFile(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isDirectory()) || (paramFile.listFiles() == null)) {
      return;
    }
    File[] arrayOfFile = paramFile.listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    if (i < j)
    {
      File localFile = arrayOfFile[i];
      if (localFile.isFile()) {
        localFile.delete();
      }
      for (;;)
      {
        i += 1;
        break;
        if (localFile.isDirectory()) {
          deleteAllFile(localFile);
        }
      }
    }
    paramFile.delete();
  }
  
  public static final void deleteClosedTempFile(String paramString)
  {
    if ((paramString == null) || (!paramString.endsWith(".qtmp"))) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while ((paramString.exists()) && (!paramString.renameTo(paramString.getAbsoluteFile())));
    paramString.delete();
  }
  
  private static void deleteDir(File paramFile)
  {
    String[] arrayOfString;
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      arrayOfString = paramFile.list();
      if (arrayOfString != null) {}
    }
    else
    {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label26:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if (!TextUtils.isEmpty(str)) {
        break label51;
      }
    }
    for (;;)
    {
      i += 1;
      break label26;
      break;
      label51:
      new File(paramFile, str).delete();
    }
  }
  
  public static final void deleteTempFile(String paramString)
  {
    if ((paramString == null) || (!paramString.endsWith(".qtmp"))) {
      return;
    }
    new File(paramString).delete();
  }
  
  /* Error */
  public static String estimateFileType(String paramString)
  {
    // Byte code:
    //   0: new 94	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 97	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_1
    //   11: iconst_2
    //   12: newarray byte
    //   14: astore_0
    //   15: aload_2
    //   16: astore_1
    //   17: aload_2
    //   18: aload_0
    //   19: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   22: iconst_m1
    //   23: if_icmpeq +130 -> 153
    //   26: aload_2
    //   27: astore_1
    //   28: aload_0
    //   29: invokestatic 182	com/tencent/upload/utils/FileUtils:estimateFileType	([B)Ljava/lang/String;
    //   32: astore_0
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 114	java/io/FileInputStream:close	()V
    //   39: aload_0
    //   40: astore_1
    //   41: aload_2
    //   42: ifnull +9 -> 51
    //   45: aload_2
    //   46: invokevirtual 114	java/io/FileInputStream:close	()V
    //   49: aload_0
    //   50: astore_1
    //   51: aload_1
    //   52: areturn
    //   53: astore_3
    //   54: aconst_null
    //   55: astore_2
    //   56: ldc 184
    //   58: astore_0
    //   59: aload_2
    //   60: astore_1
    //   61: aload_3
    //   62: invokevirtual 187	java/io/FileNotFoundException:printStackTrace	()V
    //   65: aload_0
    //   66: astore_1
    //   67: aload_2
    //   68: ifnull -17 -> 51
    //   71: aload_2
    //   72: invokevirtual 114	java/io/FileInputStream:close	()V
    //   75: aload_0
    //   76: areturn
    //   77: astore_1
    //   78: aload_0
    //   79: areturn
    //   80: astore_3
    //   81: aconst_null
    //   82: astore_2
    //   83: ldc 184
    //   85: astore_0
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   92: aload_0
    //   93: astore_1
    //   94: aload_2
    //   95: ifnull -44 -> 51
    //   98: aload_2
    //   99: invokevirtual 114	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: areturn
    //   104: astore_1
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_1
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 114	java/io/FileInputStream:close	()V
    //   118: aload_0
    //   119: athrow
    //   120: astore_1
    //   121: aload_0
    //   122: areturn
    //   123: astore_1
    //   124: goto -6 -> 118
    //   127: astore_0
    //   128: goto -18 -> 110
    //   131: astore_3
    //   132: ldc 184
    //   134: astore_0
    //   135: goto -49 -> 86
    //   138: astore_3
    //   139: goto -53 -> 86
    //   142: astore_3
    //   143: ldc 184
    //   145: astore_0
    //   146: goto -87 -> 59
    //   149: astore_3
    //   150: goto -91 -> 59
    //   153: ldc 184
    //   155: astore_0
    //   156: goto -123 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   10	57	1	localObject1	Object
    //   77	1	1	localIOException1	java.io.IOException
    //   87	7	1	localObject2	Object
    //   104	1	1	localIOException2	java.io.IOException
    //   109	6	1	localObject3	Object
    //   120	1	1	localIOException3	java.io.IOException
    //   123	1	1	localIOException4	java.io.IOException
    //   8	91	2	localFileInputStream	java.io.FileInputStream
    //   53	9	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   80	9	3	localIOException5	java.io.IOException
    //   131	1	3	localIOException6	java.io.IOException
    //   138	1	3	localIOException7	java.io.IOException
    //   142	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   149	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   0	9	53	java/io/FileNotFoundException
    //   71	75	77	java/io/IOException
    //   0	9	80	java/io/IOException
    //   98	102	104	java/io/IOException
    //   0	9	107	finally
    //   45	49	120	java/io/IOException
    //   114	118	123	java/io/IOException
    //   11	15	127	finally
    //   17	26	127	finally
    //   28	33	127	finally
    //   35	39	127	finally
    //   61	65	127	finally
    //   88	92	127	finally
    //   11	15	131	java/io/IOException
    //   17	26	131	java/io/IOException
    //   28	33	131	java/io/IOException
    //   35	39	138	java/io/IOException
    //   11	15	142	java/io/FileNotFoundException
    //   17	26	142	java/io/FileNotFoundException
    //   28	33	142	java/io/FileNotFoundException
    //   35	39	149	java/io/FileNotFoundException
  }
  
  public static String estimateFileType(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        str = str + Integer.toString(paramArrayOfByte[i] & 0xFF);
        i += 1;
      }
      switch (Integer.parseInt(str))
      {
      default: 
        return unKnownFileTypeMark + str;
      case 7790: 
        return "exe";
      case 7784: 
        return "midi";
      case 8297: 
        return "rar";
      case 8075: 
        return "zip";
      case 255216: 
        return "jpg";
      case 7173: 
        return "gif";
      case 6677: 
        return "bmp";
      case 13780: 
        return "png";
      }
      return "webp";
    }
    return unKnownFileTypeMark + "";
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return false;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (paramString.length() <= 0L));
    return true;
  }
  
  public static final long getCacheDirUsedSpace(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return 0L;
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int k = arrayOfString.length;
    int i = 0;
    int j = 0;
    if (i < k)
    {
      String str = arrayOfString[i];
      if (str == null) {}
      for (;;)
      {
        i += 1;
        break;
        j = (int)(j + new File(paramFile, str).length());
      }
    }
    return j;
  }
  
  private static final String getCachePathByPrefix(File paramFile, String paramString)
  {
    if ((paramFile == null) || (!paramFile.isDirectory())) {}
    String[] arrayOfString;
    do
    {
      return null;
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int j = arrayOfString.length;
    int i = 0;
    label30:
    String str;
    if (i < j)
    {
      str = arrayOfString[i];
      if ((str != null) && (str.startsWith(paramString)) && (str.endsWith(".qtmp"))) {
        break label72;
      }
    }
    label72:
    File localFile;
    do
    {
      i += 1;
      break label30;
      break;
      localFile = new File(paramFile, str);
    } while ((localFile.length() == 0L) || (!localFile.isFile()));
    return 3 + paramFile.getAbsolutePath() + File.separator + str;
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    Context localContext = null;
    try
    {
      paramContext = new File(UploadGlobalConfig.getUploadEnv().getSDKPrivatePath("uploader"));
      if ((paramContext.isDirectory()) || (paramContext.mkdirs())) {
        localContext = paramContext;
      }
      return localContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        UploadLog.e(tag, paramContext.toString());
        paramContext = null;
      }
    }
  }
  
  public static long getFileLength(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return 0L;
      try
      {
        paramString = new File(paramString);
        if (paramString.exists())
        {
          long l = paramString.length();
          return l;
        }
      }
      catch (Exception paramString)
      {
        UploadLog.e(tag, "getFileLength() ", paramString);
      }
    }
    return 0L;
  }
  
  public static String getFileName(String paramString)
  {
    int i = paramString.lastIndexOf(".");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    return str;
  }
  
  public static String getFileNameFromPath(String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf("/");
    } while (i == -1);
    return paramString.substring(i + 1);
  }
  
  public static String getFilePathByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {}
    do
    {
      do
      {
        do
        {
          return null;
          String str = paramString2;
          if (paramString2 == null) {
            str = "";
          }
          paramString1 = getTempFilePerfix(str.hashCode(), paramString1.hashCode());
          if (("mounted".equals(Environment.getExternalStorageState())) && (getSdCardAvailableSize() > 5))
          {
            paramString2 = getExternalFilesDir(paramContext);
            if (paramString2 != null)
            {
              paramString2 = getCachePathByPrefix(paramString2, paramString1);
              if (paramString2 != null) {
                return paramString2;
              }
            }
          }
        } while (getInternalAvailableSize() <= 5);
        paramContext = paramContext.getDir("uploader", 0);
      } while (paramContext == null);
      paramContext = getCachePathByPrefix(paramContext, paramString1);
    } while (paramContext == null);
    return paramContext;
  }
  
  /* Error */
  public static String getFileSha1(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 94	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_0
    //   14: ldc_w 304
    //   17: invokestatic 310	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   20: astore_3
    //   21: aload_2
    //   22: astore_0
    //   23: ldc_w 311
    //   26: newarray byte
    //   28: astore 5
    //   30: aload_2
    //   31: astore_0
    //   32: aload_2
    //   33: aload 5
    //   35: invokevirtual 104	java/io/FileInputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +45 -> 85
    //   43: aload_2
    //   44: astore_0
    //   45: aload_3
    //   46: aload 5
    //   48: iconst_0
    //   49: iload_1
    //   50: invokevirtual 314	java/security/MessageDigest:update	([BII)V
    //   53: goto -23 -> 30
    //   56: astore_3
    //   57: aload_2
    //   58: astore_0
    //   59: ldc_w 316
    //   62: ldc_w 318
    //   65: aload_3
    //   66: invokestatic 257	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   69: aload 4
    //   71: astore_0
    //   72: aload_2
    //   73: ifnull +10 -> 83
    //   76: aload_2
    //   77: invokevirtual 114	java/io/FileInputStream:close	()V
    //   80: aload 4
    //   82: astore_0
    //   83: aload_0
    //   84: areturn
    //   85: aload_2
    //   86: astore_0
    //   87: aload_3
    //   88: invokevirtual 322	java/security/MessageDigest:digest	()[B
    //   91: invokestatic 327	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   94: astore_3
    //   95: aload_3
    //   96: astore_0
    //   97: aload_2
    //   98: ifnull -15 -> 83
    //   101: aload_2
    //   102: invokevirtual 114	java/io/FileInputStream:close	()V
    //   105: aload_3
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   112: aload_3
    //   113: areturn
    //   114: astore_0
    //   115: aload_0
    //   116: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_3
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_0
    //   126: ldc_w 316
    //   129: ldc_w 329
    //   132: aload_3
    //   133: invokestatic 257	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   136: aload 4
    //   138: astore_0
    //   139: aload_2
    //   140: ifnull -57 -> 83
    //   143: aload_2
    //   144: invokevirtual 114	java/io/FileInputStream:close	()V
    //   147: aconst_null
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_2
    //   157: aconst_null
    //   158: astore_0
    //   159: aload_0
    //   160: ifnull +7 -> 167
    //   163: aload_0
    //   164: invokevirtual 114	java/io/FileInputStream:close	()V
    //   167: aload_2
    //   168: athrow
    //   169: astore_0
    //   170: aload_0
    //   171: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   174: goto -7 -> 167
    //   177: astore_2
    //   178: goto -19 -> 159
    //   181: astore_3
    //   182: goto -58 -> 124
    //   185: astore_3
    //   186: aconst_null
    //   187: astore_2
    //   188: goto -131 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramFile	File
    //   38	12	1	i	int
    //   11	133	2	localFileInputStream	java.io.FileInputStream
    //   156	12	2	localObject1	Object
    //   177	1	2	localObject2	Object
    //   187	1	2	localObject3	Object
    //   20	26	3	localMessageDigest	MessageDigest
    //   56	32	3	localException1	Exception
    //   94	19	3	str	String
    //   121	12	3	localOutOfMemoryError1	OutOfMemoryError
    //   181	1	3	localOutOfMemoryError2	OutOfMemoryError
    //   185	1	3	localException2	Exception
    //   1	136	4	localObject4	Object
    //   28	19	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   14	21	56	java/lang/Exception
    //   23	30	56	java/lang/Exception
    //   32	39	56	java/lang/Exception
    //   45	53	56	java/lang/Exception
    //   87	95	56	java/lang/Exception
    //   101	105	107	java/io/IOException
    //   76	80	114	java/io/IOException
    //   3	12	121	java/lang/OutOfMemoryError
    //   143	147	149	java/io/IOException
    //   3	12	156	finally
    //   163	167	169	java/io/IOException
    //   14	21	177	finally
    //   23	30	177	finally
    //   32	39	177	finally
    //   45	53	177	finally
    //   59	69	177	finally
    //   87	95	177	finally
    //   126	136	177	finally
    //   14	21	181	java/lang/OutOfMemoryError
    //   23	30	181	java/lang/OutOfMemoryError
    //   32	39	181	java/lang/OutOfMemoryError
    //   45	53	181	java/lang/OutOfMemoryError
    //   87	95	181	java/lang/OutOfMemoryError
    //   3	12	185	java/lang/Exception
  }
  
  public static String getFileSha1(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramArrayOfByte = StringUtils.toHexString(localMessageDigest.digest());
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      UploadLog.e("FileUtils", "getFileSha1->NoSuchAlgorithmException###", paramArrayOfByte);
      return null;
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      UploadLog.e("FileUtils", "getFileSha1->OutOfMemoryError###", paramArrayOfByte);
    }
    return null;
  }
  
  public static int getInternalAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d = localStatFs.getAvailableBlocks();
    return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
  }
  
  public static String getMd5(byte[] paramArrayOfByte)
  {
    return getMessageDigest(paramArrayOfByte, "MD5");
  }
  
  private static String getMd5ByFile(File paramFile)
  {
    return getMessageDigestByFile(paramFile, "MD5");
  }
  
  public static FileUtils.UploaderMD5 getMd5ByFile_FAKE(File paramFile)
  {
    return new FileUtils.UploaderMD5(0, getMd5ByFile(paramFile));
  }
  
  public static String getMd5ByFile_REAL(File paramFile)
  {
    return getMessageDigestByFile_REAL(paramFile, "MD5");
  }
  
  public static String getMessageDigest(byte[] paramArrayOfByte, String paramString)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramString.reset();
      paramString.update(paramArrayOfByte);
      paramArrayOfByte = StringUtils.toHexString(paramString.digest());
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte) {}
    return "";
  }
  
  /* Error */
  private static String getMessageDigestByFile(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 122	java/io/File:exists	()Z
    //   8: ifne +10 -> 18
    //   11: ldc 184
    //   13: astore 5
    //   15: aload 5
    //   17: areturn
    //   18: aload_0
    //   19: invokevirtual 126	java/io/File:length	()J
    //   22: lstore_3
    //   23: lload_3
    //   24: ldc2_w 379
    //   27: lcmp
    //   28: ifle +136 -> 164
    //   31: lload_3
    //   32: ldc2_w 381
    //   35: ldiv
    //   36: lstore_3
    //   37: bipush 32
    //   39: newarray byte
    //   41: astore 5
    //   43: aconst_null
    //   44: astore_1
    //   45: new 94	java/io/FileInputStream
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   53: astore_0
    //   54: aload_0
    //   55: lload_3
    //   56: invokevirtual 386	java/io/FileInputStream:skip	(J)J
    //   59: pop2
    //   60: iconst_0
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_4
    //   64: if_icmpge +33 -> 97
    //   67: aload_0
    //   68: aload 5
    //   70: iload_2
    //   71: bipush 8
    //   73: imul
    //   74: bipush 8
    //   76: invokevirtual 389	java/io/FileInputStream:read	([BII)I
    //   79: pop
    //   80: aload_0
    //   81: lload_3
    //   82: ldc2_w 390
    //   85: lsub
    //   86: invokevirtual 386	java/io/FileInputStream:skip	(J)J
    //   89: pop2
    //   90: iload_2
    //   91: iconst_1
    //   92: iadd
    //   93: istore_2
    //   94: goto -32 -> 62
    //   97: aload 5
    //   99: invokestatic 327	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   102: astore_1
    //   103: aload_1
    //   104: astore 5
    //   106: aload_0
    //   107: ifnull -92 -> 15
    //   110: aload_0
    //   111: invokevirtual 114	java/io/FileInputStream:close	()V
    //   114: aload_1
    //   115: areturn
    //   116: astore_0
    //   117: aload_1
    //   118: areturn
    //   119: astore_0
    //   120: aload_1
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 114	java/io/FileInputStream:close	()V
    //   130: ldc 184
    //   132: areturn
    //   133: astore_0
    //   134: aconst_null
    //   135: astore_0
    //   136: aload_0
    //   137: ifnull -7 -> 130
    //   140: aload_0
    //   141: invokevirtual 114	java/io/FileInputStream:close	()V
    //   144: goto -14 -> 130
    //   147: astore_0
    //   148: goto -18 -> 130
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: ifnull +7 -> 162
    //   158: aload_0
    //   159: invokevirtual 114	java/io/FileInputStream:close	()V
    //   162: aload_1
    //   163: athrow
    //   164: aload_0
    //   165: aload_1
    //   166: invokestatic 370	com/tencent/upload/utils/FileUtils:getMessageDigestByFile_REAL	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   169: areturn
    //   170: astore_0
    //   171: goto -41 -> 130
    //   174: astore_0
    //   175: goto -13 -> 162
    //   178: astore_1
    //   179: goto -25 -> 154
    //   182: astore_1
    //   183: goto -47 -> 136
    //   186: astore_1
    //   187: goto -65 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramFile	File
    //   0	190	1	paramString	String
    //   61	33	2	i	int
    //   22	60	3	l	long
    //   13	92	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   110	114	116	java/io/IOException
    //   45	54	119	java/io/FileNotFoundException
    //   45	54	133	java/io/IOException
    //   140	144	147	java/io/IOException
    //   45	54	151	finally
    //   126	130	170	java/io/IOException
    //   158	162	174	java/io/IOException
    //   54	60	178	finally
    //   67	90	178	finally
    //   97	103	178	finally
    //   54	60	182	java/io/IOException
    //   67	90	182	java/io/IOException
    //   97	103	182	java/io/IOException
    //   54	60	186	java/io/FileNotFoundException
    //   67	90	186	java/io/FileNotFoundException
    //   97	103	186	java/io/FileNotFoundException
  }
  
  /* Error */
  public static String getMessageDigestByFile_REAL(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 122	java/io/File:exists	()Z
    //   8: ifne +8 -> 16
    //   11: ldc 184
    //   13: astore_3
    //   14: aload_3
    //   15: areturn
    //   16: aconst_null
    //   17: astore 5
    //   19: aconst_null
    //   20: astore 6
    //   22: aconst_null
    //   23: astore 7
    //   25: aconst_null
    //   26: astore 4
    //   28: aload 7
    //   30: astore_3
    //   31: aload_1
    //   32: invokestatic 310	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   35: astore 8
    //   37: aload 7
    //   39: astore_3
    //   40: aload 8
    //   42: invokevirtual 375	java/security/MessageDigest:reset	()V
    //   45: aload 7
    //   47: astore_3
    //   48: new 393	java/io/BufferedInputStream
    //   51: dup
    //   52: new 94	java/io/FileInputStream
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   60: sipush 8192
    //   63: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   66: astore_0
    //   67: aload_0
    //   68: astore_1
    //   69: sipush 8192
    //   72: newarray byte
    //   74: astore_3
    //   75: aload_0
    //   76: astore_1
    //   77: aload_0
    //   78: aload_3
    //   79: invokevirtual 397	java/io/BufferedInputStream:read	([B)I
    //   82: istore_2
    //   83: iload_2
    //   84: ifle +40 -> 124
    //   87: aload_0
    //   88: astore_1
    //   89: aload 8
    //   91: aload_3
    //   92: iconst_0
    //   93: iload_2
    //   94: invokevirtual 314	java/security/MessageDigest:update	([BII)V
    //   97: goto -22 -> 75
    //   100: astore_3
    //   101: aload_0
    //   102: astore_1
    //   103: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   106: aload_3
    //   107: invokevirtual 398	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   110: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_0
    //   114: ifnull +7 -> 121
    //   117: aload_0
    //   118: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   121: ldc 184
    //   123: areturn
    //   124: aload_0
    //   125: astore_1
    //   126: aload 8
    //   128: invokevirtual 322	java/security/MessageDigest:digest	()[B
    //   131: invokestatic 327	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   134: astore_3
    //   135: aload_3
    //   136: astore_1
    //   137: aload_1
    //   138: astore_3
    //   139: aload_0
    //   140: ifnull -126 -> 14
    //   143: aload_0
    //   144: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   147: aload_1
    //   148: areturn
    //   149: astore_0
    //   150: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   153: aload_0
    //   154: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   157: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload_1
    //   161: areturn
    //   162: astore_0
    //   163: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   166: aload_0
    //   167: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   170: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: goto -52 -> 121
    //   176: astore_1
    //   177: aload 4
    //   179: astore_0
    //   180: aload_0
    //   181: astore_3
    //   182: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   185: aload_1
    //   186: invokevirtual 401	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   189: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: aload_0
    //   193: ifnull -72 -> 121
    //   196: aload_0
    //   197: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   200: goto -79 -> 121
    //   203: astore_0
    //   204: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   207: aload_0
    //   208: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   211: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: goto -93 -> 121
    //   217: astore_1
    //   218: aload 5
    //   220: astore_0
    //   221: aload_0
    //   222: astore_3
    //   223: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   226: aload_1
    //   227: invokevirtual 402	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   230: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_0
    //   234: ifnull -113 -> 121
    //   237: aload_0
    //   238: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   241: goto -120 -> 121
    //   244: astore_0
    //   245: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   248: aload_0
    //   249: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   252: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -134 -> 121
    //   258: astore_1
    //   259: aload 6
    //   261: astore_0
    //   262: aload_0
    //   263: astore_3
    //   264: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   267: aload_1
    //   268: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   271: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: ifnull -154 -> 121
    //   278: aload_0
    //   279: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   282: goto -161 -> 121
    //   285: astore_0
    //   286: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   289: aload_0
    //   290: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   293: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: goto -175 -> 121
    //   299: astore_0
    //   300: aload_3
    //   301: ifnull +7 -> 308
    //   304: aload_3
    //   305: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   308: aload_0
    //   309: athrow
    //   310: astore_1
    //   311: getstatic 50	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   314: aload_1
    //   315: invokevirtual 400	java/io/IOException:toString	()Ljava/lang/String;
    //   318: invokestatic 251	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: goto -13 -> 308
    //   324: astore_0
    //   325: aload_1
    //   326: astore_3
    //   327: goto -27 -> 300
    //   330: astore_1
    //   331: goto -69 -> 262
    //   334: astore_1
    //   335: goto -114 -> 221
    //   338: astore_1
    //   339: goto -159 -> 180
    //   342: astore_3
    //   343: aconst_null
    //   344: astore_0
    //   345: goto -244 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	paramFile	File
    //   0	348	1	paramString	String
    //   82	12	2	i	int
    //   13	79	3	localObject1	Object
    //   100	7	3	localNoSuchAlgorithmException1	NoSuchAlgorithmException
    //   134	193	3	localObject2	Object
    //   342	1	3	localNoSuchAlgorithmException2	NoSuchAlgorithmException
    //   26	152	4	localObject3	Object
    //   17	202	5	localObject4	Object
    //   20	240	6	localObject5	Object
    //   23	23	7	localObject6	Object
    //   35	92	8	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   69	75	100	java/security/NoSuchAlgorithmException
    //   77	83	100	java/security/NoSuchAlgorithmException
    //   89	97	100	java/security/NoSuchAlgorithmException
    //   126	135	100	java/security/NoSuchAlgorithmException
    //   143	147	149	java/io/IOException
    //   117	121	162	java/io/IOException
    //   31	37	176	java/io/FileNotFoundException
    //   40	45	176	java/io/FileNotFoundException
    //   48	67	176	java/io/FileNotFoundException
    //   196	200	203	java/io/IOException
    //   31	37	217	java/lang/OutOfMemoryError
    //   40	45	217	java/lang/OutOfMemoryError
    //   48	67	217	java/lang/OutOfMemoryError
    //   237	241	244	java/io/IOException
    //   31	37	258	java/io/IOException
    //   40	45	258	java/io/IOException
    //   48	67	258	java/io/IOException
    //   278	282	285	java/io/IOException
    //   31	37	299	finally
    //   40	45	299	finally
    //   48	67	299	finally
    //   182	192	299	finally
    //   223	233	299	finally
    //   264	274	299	finally
    //   304	308	310	java/io/IOException
    //   69	75	324	finally
    //   77	83	324	finally
    //   89	97	324	finally
    //   103	113	324	finally
    //   126	135	324	finally
    //   69	75	330	java/io/IOException
    //   77	83	330	java/io/IOException
    //   89	97	330	java/io/IOException
    //   126	135	330	java/io/IOException
    //   69	75	334	java/lang/OutOfMemoryError
    //   77	83	334	java/lang/OutOfMemoryError
    //   89	97	334	java/lang/OutOfMemoryError
    //   126	135	334	java/lang/OutOfMemoryError
    //   69	75	338	java/io/FileNotFoundException
    //   77	83	338	java/io/FileNotFoundException
    //   89	97	338	java/io/FileNotFoundException
    //   126	135	338	java/io/FileNotFoundException
    //   31	37	342	java/security/NoSuchAlgorithmException
    //   40	45	342	java/security/NoSuchAlgorithmException
    //   48	67	342	java/security/NoSuchAlgorithmException
  }
  
  public static String getSHA(byte[] paramArrayOfByte)
  {
    return getMessageDigest(paramArrayOfByte, "SHA-1");
  }
  
  private static String getSHAByFile(File paramFile)
  {
    return getMessageDigestByFile(paramFile, "SHA-1");
  }
  
  public static FileUtils.UploaderMD5 getSHAByFile_FAKE(File paramFile)
  {
    return new FileUtils.UploaderMD5(2, getSHAByFile(paramFile));
  }
  
  public static String getSHAByFile_REAL(File paramFile)
  {
    return getMessageDigestByFile_REAL(paramFile, "SHA-1");
  }
  
  public static int getSdCardAvailableSize()
  {
    try
    {
      StatFs localStatFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
      int i = localStatFs.getBlockSize();
      int j = localStatFs.getAvailableBlocks();
      double d = j;
      return (int)(i * (1.0D * d) / 1024.0D / 1024.0D);
    }
    catch (Exception localException)
    {
      UploadLog.e(tag, localException.toString());
    }
    return 0;
  }
  
  public static final String getTempFileAbsolutePath(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    return 8 + paramString + File.separator + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".qtmp";
  }
  
  public static String getTempFilePath(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {}
    int i;
    int j;
    do
    {
      do
      {
        return null;
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        i = str.hashCode();
        j = paramString1.hashCode();
        if (("mounted".equals(Environment.getExternalStorageState())) && (getSdCardAvailableSize() > 5))
        {
          paramString1 = getExternalFilesDir(paramContext);
          if (paramString1 != null) {
            return getTempFileAbsolutePath(paramString1.getAbsolutePath(), i, j, paramInt);
          }
        }
      } while (getInternalAvailableSize() <= 5);
      paramContext = paramContext.getDir("uploader", 0);
    } while (paramContext == null);
    return getTempFileAbsolutePath(paramContext.getAbsolutePath(), i, j, paramInt);
  }
  
  public static final String getTempFilePerfix(int paramInt1, int paramInt2)
  {
    return 3 + paramInt1 + "_" + paramInt2;
  }
  
  public static final boolean isFileExist(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new File(paramString).exists();
  }
  
  public static final boolean isValidTempFile(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).length() > 0L);
  }
  
  /* Error */
  public static byte[] toByteArray(String paramString)
  {
    // Byte code:
    //   0: new 117	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 122	java/io/File:exists	()Z
    //   13: ifne +12 -> 25
    //   16: new 82	java/io/FileNotFoundException
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 425	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   24: athrow
    //   25: new 427	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: aload_2
    //   30: invokevirtual 126	java/io/File:length	()J
    //   33: l2i
    //   34: invokespecial 428	java/io/ByteArrayOutputStream:<init>	(I)V
    //   37: astore 4
    //   39: new 393	java/io/BufferedInputStream
    //   42: dup
    //   43: new 94	java/io/FileInputStream
    //   46: dup
    //   47: aload_2
    //   48: invokespecial 302	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   51: sipush 8192
    //   54: invokespecial 396	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   57: astore_2
    //   58: aload_2
    //   59: astore_0
    //   60: sipush 8192
    //   63: newarray byte
    //   65: astore_3
    //   66: aload_2
    //   67: astore_0
    //   68: aload_2
    //   69: aload_3
    //   70: iconst_0
    //   71: sipush 8192
    //   74: invokevirtual 429	java/io/BufferedInputStream:read	([BII)I
    //   77: istore_1
    //   78: iconst_m1
    //   79: iload_1
    //   80: if_icmpeq +43 -> 123
    //   83: aload_2
    //   84: astore_0
    //   85: aload 4
    //   87: aload_3
    //   88: iconst_0
    //   89: iload_1
    //   90: invokevirtual 430	java/io/ByteArrayOutputStream:write	([BII)V
    //   93: goto -27 -> 66
    //   96: astore_3
    //   97: aload_2
    //   98: astore_0
    //   99: aload_3
    //   100: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   103: aload_2
    //   104: astore_0
    //   105: aload_3
    //   106: athrow
    //   107: astore_3
    //   108: aload_0
    //   109: astore_2
    //   110: aload_3
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   116: aload 4
    //   118: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: aload_2
    //   124: astore_0
    //   125: aload 4
    //   127: invokevirtual 433	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: astore_3
    //   131: aload_2
    //   132: invokevirtual 399	java/io/BufferedInputStream:close	()V
    //   135: aload 4
    //   137: invokevirtual 431	java/io/ByteArrayOutputStream:close	()V
    //   140: aload_3
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   147: goto -12 -> 135
    //   150: astore_2
    //   151: aload_2
    //   152: invokevirtual 188	java/io/IOException:printStackTrace	()V
    //   155: goto -39 -> 116
    //   158: astore_0
    //   159: aconst_null
    //   160: astore_2
    //   161: goto -49 -> 112
    //   164: astore_3
    //   165: aconst_null
    //   166: astore_2
    //   167: goto -70 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	String
    //   77	13	1	i	int
    //   8	124	2	localObject1	Object
    //   150	2	2	localIOException1	java.io.IOException
    //   160	7	2	localObject2	Object
    //   65	23	3	arrayOfByte1	byte[]
    //   96	10	3	localIOException2	java.io.IOException
    //   107	4	3	localObject3	Object
    //   130	11	3	arrayOfByte2	byte[]
    //   164	1	3	localIOException3	java.io.IOException
    //   37	99	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   60	66	96	java/io/IOException
    //   68	78	96	java/io/IOException
    //   85	93	96	java/io/IOException
    //   125	131	96	java/io/IOException
    //   60	66	107	finally
    //   68	78	107	finally
    //   85	93	107	finally
    //   99	103	107	finally
    //   105	107	107	finally
    //   125	131	107	finally
    //   131	135	142	java/io/IOException
    //   112	116	150	java/io/IOException
    //   39	58	158	finally
    //   39	58	164	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */