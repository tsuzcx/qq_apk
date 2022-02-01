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
  private static final String tag = "FileUtils";
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
    //   1: istore 4
    //   3: aload_0
    //   4: ifnull +13 -> 17
    //   7: aload_0
    //   8: aload_1
    //   9: invokevirtual 84	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   12: ifeq +5 -> 17
    //   15: iconst_1
    //   16: ireturn
    //   17: new 86	java/io/FileInputStream
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: new 91	java/io/FileOutputStream
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   34: astore 7
    //   36: aload_0
    //   37: astore 8
    //   39: aload 7
    //   41: astore 9
    //   43: sipush 10240
    //   46: newarray byte
    //   48: astore 10
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_0
    //   53: astore 8
    //   55: aload 7
    //   57: astore 9
    //   59: aload_0
    //   60: aload 10
    //   62: invokevirtual 96	java/io/FileInputStream:read	([B)I
    //   65: istore_3
    //   66: iload_3
    //   67: iconst_m1
    //   68: if_icmpeq +26 -> 94
    //   71: aload_0
    //   72: astore 8
    //   74: aload 7
    //   76: astore 9
    //   78: aload 7
    //   80: aload 10
    //   82: iconst_0
    //   83: iload_3
    //   84: invokevirtual 100	java/io/FileOutputStream:write	([BII)V
    //   87: iload_2
    //   88: iload_3
    //   89: iadd
    //   90: istore_2
    //   91: goto -39 -> 52
    //   94: aload_0
    //   95: astore 8
    //   97: aload 7
    //   99: astore 9
    //   101: aload 7
    //   103: invokevirtual 103	java/io/FileOutputStream:flush	()V
    //   106: aload_0
    //   107: invokevirtual 106	java/io/FileInputStream:close	()V
    //   110: aload 7
    //   112: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   115: goto +203 -> 318
    //   118: astore_0
    //   119: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   122: ldc 111
    //   124: aload_0
    //   125: invokestatic 117	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   128: goto +190 -> 318
    //   131: astore 10
    //   133: iload_2
    //   134: istore_3
    //   135: goto +67 -> 202
    //   138: astore 10
    //   140: iload_2
    //   141: istore_3
    //   142: goto +119 -> 261
    //   145: astore 8
    //   147: goto +49 -> 196
    //   150: astore 8
    //   152: goto +103 -> 255
    //   155: astore_1
    //   156: aconst_null
    //   157: astore 9
    //   159: goto +222 -> 381
    //   162: astore 8
    //   164: aconst_null
    //   165: astore 7
    //   167: goto +29 -> 196
    //   170: astore 8
    //   172: aconst_null
    //   173: astore 7
    //   175: goto +80 -> 255
    //   178: astore_1
    //   179: aconst_null
    //   180: astore 9
    //   182: aload 9
    //   184: astore_0
    //   185: goto +196 -> 381
    //   188: astore 8
    //   190: aconst_null
    //   191: astore 7
    //   193: aload 7
    //   195: astore_0
    //   196: iconst_0
    //   197: istore_3
    //   198: aload 8
    //   200: astore 10
    //   202: aload_0
    //   203: astore 8
    //   205: aload 7
    //   207: astore 9
    //   209: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   212: ldc 111
    //   214: aload 10
    //   216: invokestatic 117	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_0
    //   220: ifnull +10 -> 230
    //   223: aload_0
    //   224: invokevirtual 106	java/io/FileInputStream:close	()V
    //   227: goto +3 -> 230
    //   230: iload_3
    //   231: istore_2
    //   232: aload 7
    //   234: ifnull +81 -> 315
    //   237: aload 7
    //   239: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   242: iload_3
    //   243: istore_2
    //   244: goto +71 -> 315
    //   247: astore 8
    //   249: aconst_null
    //   250: astore 7
    //   252: aload 7
    //   254: astore_0
    //   255: iconst_0
    //   256: istore_3
    //   257: aload 8
    //   259: astore 10
    //   261: aload_0
    //   262: astore 8
    //   264: aload 7
    //   266: astore 9
    //   268: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   271: ldc 111
    //   273: aload 10
    //   275: invokestatic 117	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: aload_0
    //   279: ifnull +10 -> 289
    //   282: aload_0
    //   283: invokevirtual 106	java/io/FileInputStream:close	()V
    //   286: goto +3 -> 289
    //   289: iload_3
    //   290: istore_2
    //   291: aload 7
    //   293: ifnull +22 -> 315
    //   296: aload 7
    //   298: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   301: iload_3
    //   302: istore_2
    //   303: goto +12 -> 315
    //   306: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   309: ldc 111
    //   311: aload_0
    //   312: invokestatic 117	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   315: iconst_0
    //   316: istore 4
    //   318: new 119	java/io/File
    //   321: dup
    //   322: aload_1
    //   323: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: astore_1
    //   327: aload_1
    //   328: invokevirtual 124	java/io/File:exists	()Z
    //   331: ifeq +19 -> 350
    //   334: aload_1
    //   335: invokevirtual 128	java/io/File:length	()J
    //   338: lstore 5
    //   340: aload_1
    //   341: astore_0
    //   342: lload 5
    //   344: iload_2
    //   345: i2l
    //   346: lcmp
    //   347: ifeq +13 -> 360
    //   350: iconst_0
    //   351: istore 4
    //   353: aload_1
    //   354: astore_0
    //   355: goto +5 -> 360
    //   358: aconst_null
    //   359: astore_0
    //   360: iload 4
    //   362: ifne +12 -> 374
    //   365: aload_0
    //   366: ifnull +8 -> 374
    //   369: aload_0
    //   370: invokevirtual 131	java/io/File:delete	()Z
    //   373: pop
    //   374: iload 4
    //   376: ireturn
    //   377: astore_1
    //   378: aload 8
    //   380: astore_0
    //   381: aload_0
    //   382: ifnull +10 -> 392
    //   385: aload_0
    //   386: invokevirtual 106	java/io/FileInputStream:close	()V
    //   389: goto +3 -> 392
    //   392: aload 9
    //   394: ifnull +20 -> 414
    //   397: aload 9
    //   399: invokevirtual 107	java/io/FileOutputStream:close	()V
    //   402: goto +12 -> 414
    //   405: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   408: ldc 111
    //   410: aload_0
    //   411: invokestatic 117	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   414: goto +5 -> 419
    //   417: aload_1
    //   418: athrow
    //   419: goto -2 -> 417
    //   422: astore_0
    //   423: goto -65 -> 358
    //   426: astore_0
    //   427: aload_1
    //   428: astore_0
    //   429: goto -69 -> 360
    //   432: astore_0
    //   433: iload_3
    //   434: istore_2
    //   435: goto -129 -> 306
    //   438: astore_0
    //   439: iload_3
    //   440: istore_2
    //   441: goto -135 -> 306
    //   444: astore_0
    //   445: goto -40 -> 405
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	448	0	paramString1	String
    //   0	448	1	paramString2	String
    //   51	390	2	i	int
    //   65	375	3	j	int
    //   1	374	4	bool	boolean
    //   338	5	5	l	long
    //   34	263	7	localFileOutputStream1	java.io.FileOutputStream
    //   37	59	8	str1	String
    //   145	1	8	localIOException1	java.io.IOException
    //   150	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   162	1	8	localIOException2	java.io.IOException
    //   170	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   188	11	8	localIOException3	java.io.IOException
    //   203	1	8	str2	String
    //   247	11	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   262	117	8	str3	String
    //   41	357	9	localFileOutputStream2	java.io.FileOutputStream
    //   48	33	10	arrayOfByte	byte[]
    //   131	1	10	localIOException4	java.io.IOException
    //   138	1	10	localFileNotFoundException4	java.io.FileNotFoundException
    //   200	74	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   106	115	118	java/io/IOException
    //   59	66	131	java/io/IOException
    //   78	87	131	java/io/IOException
    //   101	106	131	java/io/IOException
    //   59	66	138	java/io/FileNotFoundException
    //   78	87	138	java/io/FileNotFoundException
    //   101	106	138	java/io/FileNotFoundException
    //   43	50	145	java/io/IOException
    //   43	50	150	java/io/FileNotFoundException
    //   26	36	155	finally
    //   26	36	162	java/io/IOException
    //   26	36	170	java/io/FileNotFoundException
    //   17	26	178	finally
    //   17	26	188	java/io/IOException
    //   17	26	247	java/io/FileNotFoundException
    //   43	50	377	finally
    //   59	66	377	finally
    //   78	87	377	finally
    //   101	106	377	finally
    //   209	219	377	finally
    //   268	278	377	finally
    //   318	327	422	java/lang/IllegalArgumentException
    //   327	340	426	java/lang/IllegalArgumentException
    //   223	227	432	java/io/IOException
    //   237	242	432	java/io/IOException
    //   282	286	438	java/io/IOException
    //   296	301	438	java/io/IOException
    //   385	389	444	java/io/IOException
    //   397	402	444	java/io/IOException
  }
  
  public static void deleteAllFile(File paramFile)
  {
    if ((paramFile != null) && (paramFile.exists()) && (paramFile.isDirectory()))
    {
      if (paramFile.listFiles() == null) {
        return;
      }
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile.isFile()) {
          localFile.delete();
        } else if (localFile.isDirectory()) {
          deleteAllFile(localFile);
        }
        i += 1;
      }
      paramFile.delete();
    }
  }
  
  public static final void deleteClosedTempFile(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.endsWith(".qtmp")) {
        return;
      }
      paramString = new File(paramString);
      if ((paramString.exists()) && (!paramString.renameTo(paramString.getAbsoluteFile()))) {
        return;
      }
      paramString.delete();
    }
  }
  
  private static void deleteDir(File paramFile)
  {
    if ((paramFile != null) && (paramFile.isDirectory()))
    {
      String[] arrayOfString = paramFile.list();
      if (arrayOfString == null) {
        return;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (!TextUtils.isEmpty(str)) {
          new File(paramFile, str).delete();
        }
        i += 1;
      }
    }
  }
  
  public static final void deleteTempFile(String paramString)
  {
    if (paramString != null)
    {
      if (!paramString.endsWith(".qtmp")) {
        return;
      }
      new File(paramString).delete();
    }
  }
  
  /* Error */
  public static String estimateFileType(String paramString)
  {
    // Byte code:
    //   0: ldc 175
    //   2: astore_1
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore_2
    //   11: new 86	java/io/FileInputStream
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: astore_3
    //   20: aload_1
    //   21: astore_2
    //   22: aload_1
    //   23: astore 4
    //   25: iconst_2
    //   26: newarray byte
    //   28: astore 5
    //   30: aload_1
    //   31: astore_0
    //   32: aload_1
    //   33: astore_2
    //   34: aload_1
    //   35: astore 4
    //   37: aload_3
    //   38: aload 5
    //   40: invokevirtual 96	java/io/FileInputStream:read	([B)I
    //   43: iconst_m1
    //   44: if_icmpeq +14 -> 58
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: astore 4
    //   52: aload 5
    //   54: invokestatic 178	com/tencent/upload/utils/FileUtils:estimateFileType	([B)Ljava/lang/String;
    //   57: astore_0
    //   58: aload_0
    //   59: astore_2
    //   60: aload_0
    //   61: astore 4
    //   63: aload_3
    //   64: invokevirtual 106	java/io/FileInputStream:close	()V
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 106	java/io/FileInputStream:close	()V
    //   73: aload_0
    //   74: areturn
    //   75: astore_0
    //   76: aload_3
    //   77: astore_2
    //   78: goto +75 -> 153
    //   81: astore 4
    //   83: aload_3
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: aload 4
    //   89: astore_3
    //   90: goto +22 -> 112
    //   93: astore_2
    //   94: aload_3
    //   95: astore_0
    //   96: aload 4
    //   98: astore_1
    //   99: aload_2
    //   100: astore_3
    //   101: goto +35 -> 136
    //   104: astore_0
    //   105: goto +48 -> 153
    //   108: astore_3
    //   109: aload 4
    //   111: astore_0
    //   112: aload_0
    //   113: astore_2
    //   114: aload_3
    //   115: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   118: aload_1
    //   119: astore_2
    //   120: aload_0
    //   121: ifnull +30 -> 151
    //   124: aload_1
    //   125: astore_2
    //   126: aload_0
    //   127: invokevirtual 106	java/io/FileInputStream:close	()V
    //   130: aload_1
    //   131: areturn
    //   132: astore_3
    //   133: aload 5
    //   135: astore_0
    //   136: aload_0
    //   137: astore_2
    //   138: aload_3
    //   139: invokevirtual 182	java/io/FileNotFoundException:printStackTrace	()V
    //   142: aload_1
    //   143: astore_2
    //   144: aload_0
    //   145: ifnull +6 -> 151
    //   148: goto -24 -> 124
    //   151: aload_2
    //   152: areturn
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 106	java/io/FileInputStream:close	()V
    //   161: goto +5 -> 166
    //   164: aload_0
    //   165: athrow
    //   166: goto -2 -> 164
    //   169: astore_0
    //   170: aload_2
    //   171: areturn
    //   172: astore_1
    //   173: goto -12 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	paramString	String
    //   2	141	1	localObject1	Object
    //   172	1	1	localIOException1	java.io.IOException
    //   10	76	2	localObject2	Object
    //   93	7	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   113	58	2	localObject3	Object
    //   19	82	3	localObject4	Object
    //   108	7	3	localIOException2	java.io.IOException
    //   132	7	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   4	58	4	localObject5	Object
    //   81	29	4	localIOException3	java.io.IOException
    //   7	127	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	30	75	finally
    //   37	47	75	finally
    //   52	58	75	finally
    //   63	67	75	finally
    //   25	30	81	java/io/IOException
    //   37	47	81	java/io/IOException
    //   52	58	81	java/io/IOException
    //   63	67	81	java/io/IOException
    //   25	30	93	java/io/FileNotFoundException
    //   37	47	93	java/io/FileNotFoundException
    //   52	58	93	java/io/FileNotFoundException
    //   63	67	93	java/io/FileNotFoundException
    //   11	20	104	finally
    //   114	118	104	finally
    //   138	142	104	finally
    //   11	20	108	java/io/IOException
    //   11	20	132	java/io/FileNotFoundException
    //   69	73	169	java/io/IOException
    //   126	130	169	java/io/IOException
    //   157	161	172	java/io/IOException
  }
  
  public static String estimateFileType(byte[] paramArrayOfByte)
  {
    String str = "";
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2))
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(Integer.toString(paramArrayOfByte[i] & 0xFF));
        str = localStringBuilder.toString();
        i += 1;
      }
      i = Integer.parseInt(str);
      if (i != 6677)
      {
        if (i != 7173)
        {
          if (i != 7784)
          {
            if (i != 7790)
            {
              if (i != 8075)
              {
                if (i != 8273)
                {
                  if (i != 8297)
                  {
                    if (i != 13780)
                    {
                      if (i != 255216)
                      {
                        paramArrayOfByte = new StringBuilder();
                        paramArrayOfByte.append(unKnownFileTypeMark);
                        paramArrayOfByte.append(str);
                        return paramArrayOfByte.toString();
                      }
                      return "jpg";
                    }
                    return "png";
                  }
                  return "rar";
                }
                return "webp";
              }
              return "zip";
            }
            return "exe";
          }
          return "midi";
        }
        return "gif";
      }
      return "bmp";
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(unKnownFileTypeMark);
    paramArrayOfByte.append("");
    return paramArrayOfByte.toString();
  }
  
  public static boolean fileExistsAndNotEmpty(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = new File(paramString);
    return (paramString.exists()) && (paramString.length() > 0L);
  }
  
  public static final long getCacheDirUsedSpace(File paramFile)
  {
    long l = 0L;
    if (paramFile != null)
    {
      if (!paramFile.isDirectory()) {
        return 0L;
      }
      String[] arrayOfString = paramFile.list();
      if (arrayOfString == null) {
        return 0L;
      }
      int k = arrayOfString.length;
      int i = 0;
      int j = 0;
      while (i < k)
      {
        String str = arrayOfString[i];
        if (str != null) {
          j = (int)(j + new File(paramFile, str).length());
        }
        i += 1;
      }
      l = j;
    }
    return l;
  }
  
  private static final String getCachePathByPrefix(File paramFile, String paramString)
  {
    if (paramFile != null)
    {
      if (!paramFile.isDirectory()) {
        return null;
      }
      String[] arrayOfString = paramFile.list();
      if (arrayOfString == null) {
        return null;
      }
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.startsWith(paramString)) && (str.endsWith(".qtmp")))
        {
          File localFile = new File(paramFile, str);
          if ((localFile.length() != 0L) && (localFile.isFile()))
          {
            paramString = new StringBuilder(3);
            paramString.append(paramFile.getAbsolutePath());
            paramString.append(File.separator);
            paramString.append(str);
            return paramString.toString();
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static String getDefaultPrivatePath(Context paramContext, String paramString)
  {
    try
    {
      localFile = Environment.getExternalStorageDirectory();
    }
    catch (Exception localException)
    {
      File localFile;
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    localFile = null;
    if ((localFile != null) && (localFile.exists()))
    {
      if (paramContext == null) {
        return null;
      }
      localStringBuilder = new StringBuilder(11);
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("Android");
      localStringBuilder.append(File.separator);
      localStringBuilder.append("data");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramContext.getPackageName());
      localStringBuilder.append(File.separator);
      localStringBuilder.append("files");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return null;
  }
  
  private static File getExternalFilesDir(Context paramContext)
  {
    String str2 = UploadGlobalConfig.getUploadEnv().getSDKPrivatePath("uploader");
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      UploadLog.w(tag, "dirPath is empty");
      str1 = getDefaultPrivatePath(paramContext, "uploader");
    }
    try
    {
      paramContext = new File(str1);
    }
    catch (Exception paramContext)
    {
      UploadLog.e(tag, paramContext.toString());
      paramContext = null;
    }
    if (paramContext == null)
    {
      UploadLog.w(tag, "uploadDir == null");
      return null;
    }
    if (!paramContext.isDirectory())
    {
      if (paramContext.mkdirs()) {
        return paramContext;
      }
      return null;
    }
    return paramContext;
  }
  
  public static long getFileLength(String paramString)
  {
    if (paramString == null) {
      return 0L;
    }
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
    if (paramString == null) {
      return null;
    }
    int i = paramString.lastIndexOf("/");
    if (i == -1) {
      return null;
    }
    return paramString.substring(i + 1);
  }
  
  public static String getFilePathByPrefix(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
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
    if (getInternalAvailableSize() > 5)
    {
      paramContext = paramContext.getDir("uploader", 0);
      if (paramContext != null)
      {
        paramContext = getCachePathByPrefix(paramContext, paramString1);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    return null;
  }
  
  /* Error */
  public static String getFileSha1(File paramFile)
  {
    // Byte code:
    //   0: new 86	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_2
    //   9: aload_2
    //   10: astore_0
    //   11: ldc_w 324
    //   14: invokestatic 330	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore_3
    //   18: aload_2
    //   19: astore_0
    //   20: ldc_w 331
    //   23: newarray byte
    //   25: astore 4
    //   27: aload_2
    //   28: astore_0
    //   29: aload_2
    //   30: aload 4
    //   32: invokevirtual 96	java/io/FileInputStream:read	([B)I
    //   35: istore_1
    //   36: iload_1
    //   37: ifle +16 -> 53
    //   40: aload_2
    //   41: astore_0
    //   42: aload_3
    //   43: aload 4
    //   45: iconst_0
    //   46: iload_1
    //   47: invokevirtual 334	java/security/MessageDigest:update	([BII)V
    //   50: goto -23 -> 27
    //   53: aload_2
    //   54: astore_0
    //   55: aload_3
    //   56: invokevirtual 338	java/security/MessageDigest:digest	()[B
    //   59: invokestatic 343	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 106	java/io/FileInputStream:close	()V
    //   67: aload_3
    //   68: areturn
    //   69: astore_0
    //   70: aload_0
    //   71: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   74: aload_3
    //   75: areturn
    //   76: astore_2
    //   77: goto +72 -> 149
    //   80: astore_3
    //   81: goto +16 -> 97
    //   84: astore_3
    //   85: goto +36 -> 121
    //   88: astore_2
    //   89: aconst_null
    //   90: astore_0
    //   91: goto +58 -> 149
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_0
    //   99: ldc 41
    //   101: ldc_w 345
    //   104: aload_3
    //   105: invokestatic 279	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_2
    //   109: ifnull +38 -> 147
    //   112: aload_2
    //   113: invokevirtual 106	java/io/FileInputStream:close	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: aload_2
    //   122: astore_0
    //   123: ldc 41
    //   125: ldc_w 347
    //   128: aload_3
    //   129: invokestatic 279	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   132: aload_2
    //   133: ifnull +14 -> 147
    //   136: aload_2
    //   137: invokevirtual 106	java/io/FileInputStream:close	()V
    //   140: aconst_null
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   147: aconst_null
    //   148: areturn
    //   149: aload_0
    //   150: ifnull +15 -> 165
    //   153: aload_0
    //   154: invokevirtual 106	java/io/FileInputStream:close	()V
    //   157: goto +8 -> 165
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   165: goto +5 -> 170
    //   168: aload_2
    //   169: athrow
    //   170: goto -2 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramFile	File
    //   35	12	1	i	int
    //   8	56	2	localFileInputStream	java.io.FileInputStream
    //   76	1	2	localObject1	Object
    //   88	1	2	localObject2	Object
    //   96	73	2	localObject3	Object
    //   17	58	3	localObject4	Object
    //   80	1	3	localOutOfMemoryError1	OutOfMemoryError
    //   84	1	3	localException1	Exception
    //   94	11	3	localOutOfMemoryError2	OutOfMemoryError
    //   118	11	3	localException2	Exception
    //   25	19	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   63	67	69	java/io/IOException
    //   11	18	76	finally
    //   20	27	76	finally
    //   29	36	76	finally
    //   42	50	76	finally
    //   55	63	76	finally
    //   99	108	76	finally
    //   123	132	76	finally
    //   11	18	80	java/lang/OutOfMemoryError
    //   20	27	80	java/lang/OutOfMemoryError
    //   29	36	80	java/lang/OutOfMemoryError
    //   42	50	80	java/lang/OutOfMemoryError
    //   55	63	80	java/lang/OutOfMemoryError
    //   11	18	84	java/lang/Exception
    //   20	27	84	java/lang/Exception
    //   29	36	84	java/lang/Exception
    //   42	50	84	java/lang/Exception
    //   55	63	84	java/lang/Exception
    //   0	9	88	finally
    //   0	9	94	java/lang/OutOfMemoryError
    //   0	9	118	java/lang/Exception
    //   112	116	142	java/io/IOException
    //   136	140	142	java/io/IOException
    //   153	157	160	java/io/IOException
  }
  
  public static String getFileSha1(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return null;
      }
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
        localMessageDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
        paramArrayOfByte = StringUtils.toHexString(localMessageDigest.digest());
        return paramArrayOfByte;
      }
      catch (OutOfMemoryError paramArrayOfByte)
      {
        UploadLog.e("FileUtils", "getFileSha1->OutOfMemoryError###", paramArrayOfByte);
        return null;
      }
      catch (Exception paramArrayOfByte)
      {
        UploadLog.e("FileUtils", "getFileSha1->NoSuchAlgorithmException###", paramArrayOfByte);
      }
    }
    return null;
  }
  
  public static int getInternalAvailableSize()
  {
    StatFs localStatFs = new StatFs(Environment.getRootDirectory().getPath());
    int i = localStatFs.getBlockSize();
    double d1 = localStatFs.getAvailableBlocks();
    Double.isNaN(d1);
    double d2 = i;
    Double.isNaN(d2);
    return (int)(d1 * 1.0D * d2 / 1024.0D / 1024.0D);
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
    //   1: ifnull +153 -> 154
    //   4: aload_0
    //   5: invokevirtual 124	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 175
    //   13: areturn
    //   14: aload_0
    //   15: invokevirtual 128	java/io/File:length	()J
    //   18: lstore_3
    //   19: lload_3
    //   20: ldc2_w 403
    //   23: lcmp
    //   24: ifle +124 -> 148
    //   27: lload_3
    //   28: ldc2_w 405
    //   31: ldiv
    //   32: lstore_3
    //   33: bipush 32
    //   35: newarray byte
    //   37: astore_1
    //   38: new 86	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_0
    //   47: aload_0
    //   48: lload_3
    //   49: invokevirtual 410	java/io/FileInputStream:skip	(J)J
    //   52: pop2
    //   53: iconst_0
    //   54: istore_2
    //   55: iload_2
    //   56: iconst_4
    //   57: if_icmpge +32 -> 89
    //   60: aload_0
    //   61: aload_1
    //   62: iload_2
    //   63: bipush 8
    //   65: imul
    //   66: bipush 8
    //   68: invokevirtual 413	java/io/FileInputStream:read	([BII)I
    //   71: pop
    //   72: aload_0
    //   73: lload_3
    //   74: ldc2_w 414
    //   77: lsub
    //   78: invokevirtual 410	java/io/FileInputStream:skip	(J)J
    //   81: pop2
    //   82: iload_2
    //   83: iconst_1
    //   84: iadd
    //   85: istore_2
    //   86: goto -31 -> 55
    //   89: aload_1
    //   90: invokestatic 343	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   93: astore_1
    //   94: aload_0
    //   95: invokevirtual 106	java/io/FileInputStream:close	()V
    //   98: aload_1
    //   99: areturn
    //   100: astore 5
    //   102: aload_0
    //   103: astore_1
    //   104: aload 5
    //   106: astore_0
    //   107: goto +6 -> 113
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +7 -> 121
    //   117: aload_1
    //   118: invokevirtual 106	java/io/FileInputStream:close	()V
    //   121: aload_0
    //   122: athrow
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +19 -> 145
    //   129: aload_0
    //   130: invokevirtual 106	java/io/FileInputStream:close	()V
    //   133: ldc 175
    //   135: areturn
    //   136: aconst_null
    //   137: astore_0
    //   138: aload_0
    //   139: ifnull +6 -> 145
    //   142: goto -13 -> 129
    //   145: ldc 175
    //   147: areturn
    //   148: aload_0
    //   149: aload_1
    //   150: invokestatic 394	com/tencent/upload/utils/FileUtils:getMessageDigestByFile_REAL	(Ljava/io/File;Ljava/lang/String;)Ljava/lang/String;
    //   153: areturn
    //   154: ldc 175
    //   156: areturn
    //   157: astore_0
    //   158: goto -22 -> 136
    //   161: astore_0
    //   162: goto -39 -> 123
    //   165: astore_1
    //   166: goto -28 -> 138
    //   169: astore_1
    //   170: goto -45 -> 125
    //   173: astore_0
    //   174: aload_1
    //   175: areturn
    //   176: astore_1
    //   177: goto -56 -> 121
    //   180: astore_0
    //   181: ldc 175
    //   183: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	paramFile	File
    //   0	184	1	paramString	String
    //   54	32	2	i	int
    //   18	56	3	l	long
    //   100	5	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   47	53	100	finally
    //   60	82	100	finally
    //   89	94	100	finally
    //   38	47	110	finally
    //   38	47	157	java/io/FileNotFoundException
    //   38	47	161	java/io/IOException
    //   47	53	165	java/io/FileNotFoundException
    //   60	82	165	java/io/FileNotFoundException
    //   89	94	165	java/io/FileNotFoundException
    //   47	53	169	java/io/IOException
    //   60	82	169	java/io/IOException
    //   89	94	169	java/io/IOException
    //   94	98	173	java/io/IOException
    //   117	121	176	java/io/IOException
    //   129	133	180	java/io/IOException
  }
  
  /* Error */
  public static String getMessageDigestByFile_REAL(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +292 -> 293
    //   4: aload_0
    //   5: invokevirtual 124	java/io/File:exists	()Z
    //   8: ifne +6 -> 14
    //   11: ldc 175
    //   13: areturn
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore 5
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 7
    //   26: aconst_null
    //   27: astore 8
    //   29: aload 8
    //   31: astore_3
    //   32: aload_1
    //   33: invokestatic 330	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   36: astore_1
    //   37: aload 8
    //   39: astore_3
    //   40: aload_1
    //   41: invokevirtual 399	java/security/MessageDigest:reset	()V
    //   44: aload 8
    //   46: astore_3
    //   47: new 417	java/io/BufferedInputStream
    //   50: dup
    //   51: new 86	java/io/FileInputStream
    //   54: dup
    //   55: aload_0
    //   56: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   59: sipush 8192
    //   62: invokespecial 420	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   65: astore_0
    //   66: sipush 8192
    //   69: newarray byte
    //   71: astore_3
    //   72: aload_0
    //   73: aload_3
    //   74: invokevirtual 421	java/io/BufferedInputStream:read	([B)I
    //   77: istore_2
    //   78: iload_2
    //   79: ifle +13 -> 92
    //   82: aload_1
    //   83: aload_3
    //   84: iconst_0
    //   85: iload_2
    //   86: invokevirtual 334	java/security/MessageDigest:update	([BII)V
    //   89: goto -17 -> 72
    //   92: aload_1
    //   93: invokevirtual 338	java/security/MessageDigest:digest	()[B
    //   96: invokestatic 343	com/tencent/upload/utils/StringUtils:toHexString	([B)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_0
    //   101: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   104: aload_1
    //   105: areturn
    //   106: astore_0
    //   107: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   110: aload_0
    //   111: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   114: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_1
    //   118: areturn
    //   119: astore_1
    //   120: aload_0
    //   121: astore_3
    //   122: aload_1
    //   123: astore_0
    //   124: goto +145 -> 269
    //   127: astore_1
    //   128: goto +23 -> 151
    //   131: astore_1
    //   132: goto +46 -> 178
    //   135: astore_1
    //   136: goto +69 -> 205
    //   139: astore_1
    //   140: goto +92 -> 232
    //   143: astore_0
    //   144: goto +125 -> 269
    //   147: astore_1
    //   148: aload 4
    //   150: astore_0
    //   151: aload_0
    //   152: astore_3
    //   153: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   156: aload_1
    //   157: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   160: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   163: aload_0
    //   164: ifnull +102 -> 266
    //   167: aload_0
    //   168: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   171: ldc 175
    //   173: areturn
    //   174: astore_1
    //   175: aload 5
    //   177: astore_0
    //   178: aload_0
    //   179: astore_3
    //   180: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   183: aload_1
    //   184: invokevirtual 424	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   187: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload_0
    //   191: ifnull +75 -> 266
    //   194: aload_0
    //   195: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   198: ldc 175
    //   200: areturn
    //   201: astore_1
    //   202: aload 6
    //   204: astore_0
    //   205: aload_0
    //   206: astore_3
    //   207: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   210: aload_1
    //   211: invokevirtual 425	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   214: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload_0
    //   218: ifnull +48 -> 266
    //   221: aload_0
    //   222: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   225: ldc 175
    //   227: areturn
    //   228: astore_1
    //   229: aload 7
    //   231: astore_0
    //   232: aload_0
    //   233: astore_3
    //   234: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   237: aload_1
    //   238: invokevirtual 426	java/security/NoSuchAlgorithmException:toString	()Ljava/lang/String;
    //   241: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload_0
    //   245: ifnull +21 -> 266
    //   248: aload_0
    //   249: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   252: ldc 175
    //   254: areturn
    //   255: astore_0
    //   256: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   259: aload_0
    //   260: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   263: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   266: ldc 175
    //   268: areturn
    //   269: aload_3
    //   270: ifnull +21 -> 291
    //   273: aload_3
    //   274: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   277: goto +14 -> 291
    //   280: astore_1
    //   281: getstatic 109	com/tencent/upload/utils/FileUtils:tag	Ljava/lang/String;
    //   284: aload_1
    //   285: invokevirtual 423	java/io/IOException:toString	()Ljava/lang/String;
    //   288: invokestatic 268	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload_0
    //   292: athrow
    //   293: ldc 175
    //   295: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramFile	File
    //   0	296	1	paramString	String
    //   77	9	2	i	int
    //   31	243	3	localObject1	Object
    //   15	134	4	localObject2	Object
    //   18	158	5	localObject3	Object
    //   21	182	6	localObject4	Object
    //   24	206	7	localObject5	Object
    //   27	18	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   100	104	106	java/io/IOException
    //   66	72	119	finally
    //   72	78	119	finally
    //   82	89	119	finally
    //   92	100	119	finally
    //   66	72	127	java/io/IOException
    //   72	78	127	java/io/IOException
    //   82	89	127	java/io/IOException
    //   92	100	127	java/io/IOException
    //   66	72	131	java/lang/OutOfMemoryError
    //   72	78	131	java/lang/OutOfMemoryError
    //   82	89	131	java/lang/OutOfMemoryError
    //   92	100	131	java/lang/OutOfMemoryError
    //   66	72	135	java/io/FileNotFoundException
    //   72	78	135	java/io/FileNotFoundException
    //   82	89	135	java/io/FileNotFoundException
    //   92	100	135	java/io/FileNotFoundException
    //   66	72	139	java/security/NoSuchAlgorithmException
    //   72	78	139	java/security/NoSuchAlgorithmException
    //   82	89	139	java/security/NoSuchAlgorithmException
    //   92	100	139	java/security/NoSuchAlgorithmException
    //   32	37	143	finally
    //   40	44	143	finally
    //   47	66	143	finally
    //   153	163	143	finally
    //   180	190	143	finally
    //   207	217	143	finally
    //   234	244	143	finally
    //   32	37	147	java/io/IOException
    //   40	44	147	java/io/IOException
    //   47	66	147	java/io/IOException
    //   32	37	174	java/lang/OutOfMemoryError
    //   40	44	174	java/lang/OutOfMemoryError
    //   47	66	174	java/lang/OutOfMemoryError
    //   32	37	201	java/io/FileNotFoundException
    //   40	44	201	java/io/FileNotFoundException
    //   47	66	201	java/io/FileNotFoundException
    //   32	37	228	java/security/NoSuchAlgorithmException
    //   40	44	228	java/security/NoSuchAlgorithmException
    //   47	66	228	java/security/NoSuchAlgorithmException
    //   167	171	255	java/io/IOException
    //   194	198	255	java/io/IOException
    //   221	225	255	java/io/IOException
    //   248	252	255	java/io/IOException
    //   273	277	280	java/io/IOException
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
      double d1 = j;
      Double.isNaN(d1);
      double d2 = i;
      Double.isNaN(d2);
      return (int)(d1 * 1.0D * d2 / 1024.0D / 1024.0D);
    }
    catch (Exception localException)
    {
      UploadLog.e(tag, localException.toString());
    }
    return 0;
  }
  
  public static final String getTempFileAbsolutePath(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(8);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(".qtmp");
    return localStringBuilder.toString();
  }
  
  public static String getTempFilePath(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    if (paramString1 == null) {
      return null;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    int i = str.hashCode();
    int j = paramString1.hashCode();
    boolean bool = "mounted".equals(Environment.getExternalStorageState());
    paramString1 = tag;
    paramString2 = new StringBuilder();
    paramString2.append("mounted:");
    paramString2.append(bool);
    UploadLog.d(paramString1, paramString2.toString());
    if (bool)
    {
      k = getSdCardAvailableSize();
      if (k > 5)
      {
        paramString1 = getExternalFilesDir(paramContext);
        if (paramString1 != null) {
          return getTempFileAbsolutePath(paramString1.getAbsolutePath(), i, j, paramInt);
        }
        UploadLog.w(tag, "externalCacheDir == null");
      }
      else
      {
        paramString1 = tag;
        paramString2 = new StringBuilder();
        paramString2.append("not enough sdCardAvailableSize:");
        paramString2.append(k);
        UploadLog.w(paramString1, paramString2.toString());
      }
    }
    int k = getInternalAvailableSize();
    if (k > 5)
    {
      paramContext = paramContext.getDir("uploader", 0);
      if (paramContext != null) {
        return getTempFileAbsolutePath(paramContext.getAbsolutePath(), i, j, paramInt);
      }
      UploadLog.w(tag, "internalFilesDir == null");
      return null;
    }
    paramContext = tag;
    paramString1 = new StringBuilder();
    paramString1.append("not enough internalAvailableSize:");
    paramString1.append(k);
    UploadLog.w(paramContext, paramString1.toString());
    return null;
  }
  
  public static final String getTempFilePerfix(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder(3);
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    return localStringBuilder.toString();
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
    //   0: new 119	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 124	java/io/File:exists	()Z
    //   13: ifeq +147 -> 160
    //   16: new 463	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: aload_2
    //   21: invokevirtual 128	java/io/File:length	()J
    //   24: l2i
    //   25: invokespecial 464	java/io/ByteArrayOutputStream:<init>	(I)V
    //   28: astore 4
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore_0
    //   34: new 417	java/io/BufferedInputStream
    //   37: dup
    //   38: new 86	java/io/FileInputStream
    //   41: dup
    //   42: aload_2
    //   43: invokespecial 322	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: sipush 8192
    //   49: invokespecial 420	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   52: astore_2
    //   53: sipush 8192
    //   56: newarray byte
    //   58: astore_0
    //   59: aload_2
    //   60: aload_0
    //   61: iconst_0
    //   62: sipush 8192
    //   65: invokevirtual 465	java/io/BufferedInputStream:read	([BII)I
    //   68: istore_1
    //   69: iconst_m1
    //   70: iload_1
    //   71: if_icmpeq +14 -> 85
    //   74: aload 4
    //   76: aload_0
    //   77: iconst_0
    //   78: iload_1
    //   79: invokevirtual 466	java/io/ByteArrayOutputStream:write	([BII)V
    //   82: goto -23 -> 59
    //   85: aload 4
    //   87: invokevirtual 468	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: astore_0
    //   91: aload_2
    //   92: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   95: goto +8 -> 103
    //   98: astore_2
    //   99: aload_2
    //   100: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   103: aload 4
    //   105: invokevirtual 469	java/io/ByteArrayOutputStream:close	()V
    //   108: aload_0
    //   109: areturn
    //   110: astore_3
    //   111: aload_2
    //   112: astore_0
    //   113: aload_3
    //   114: astore_2
    //   115: goto +26 -> 141
    //   118: astore_3
    //   119: goto +12 -> 131
    //   122: astore_2
    //   123: goto +18 -> 141
    //   126: astore_0
    //   127: aload_3
    //   128: astore_2
    //   129: aload_0
    //   130: astore_3
    //   131: aload_2
    //   132: astore_0
    //   133: aload_3
    //   134: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   137: aload_2
    //   138: astore_0
    //   139: aload_3
    //   140: athrow
    //   141: aload_0
    //   142: invokevirtual 422	java/io/BufferedInputStream:close	()V
    //   145: goto +8 -> 153
    //   148: astore_0
    //   149: aload_0
    //   150: invokevirtual 181	java/io/IOException:printStackTrace	()V
    //   153: aload 4
    //   155: invokevirtual 469	java/io/ByteArrayOutputStream:close	()V
    //   158: aload_2
    //   159: athrow
    //   160: new 74	java/io/FileNotFoundException
    //   163: dup
    //   164: aload_0
    //   165: invokespecial 470	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   168: astore_0
    //   169: goto +5 -> 174
    //   172: aload_0
    //   173: athrow
    //   174: goto -2 -> 172
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramString	String
    //   68	11	1	i	int
    //   8	84	2	localObject1	Object
    //   98	14	2	localIOException1	java.io.IOException
    //   114	1	2	localObject2	Object
    //   122	1	2	localObject3	Object
    //   128	31	2	localObject4	Object
    //   31	1	3	localObject5	Object
    //   110	4	3	localObject6	Object
    //   118	10	3	localIOException2	java.io.IOException
    //   130	10	3	str	String
    //   28	126	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   91	95	98	java/io/IOException
    //   53	59	110	finally
    //   59	69	110	finally
    //   74	82	110	finally
    //   85	91	110	finally
    //   53	59	118	java/io/IOException
    //   59	69	118	java/io/IOException
    //   74	82	118	java/io/IOException
    //   85	91	118	java/io/IOException
    //   34	53	122	finally
    //   133	137	122	finally
    //   139	141	122	finally
    //   34	53	126	java/io/IOException
    //   141	145	148	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.upload.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */