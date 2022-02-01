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
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject3;
    do
    {
      return;
      localObject3 = new File(paramString);
      Object localObject2 = null;
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdirs();
      }
      Object localObject1 = paramString;
      while (!((File)localObject3).isDirectory())
      {
        int i = ((String)localObject1).lastIndexOf(File.separator);
        if (i > 0)
        {
          localObject3 = ((String)localObject1).substring(0, i);
          File localFile = new File((String)localObject3);
          localObject2 = localObject1;
          localObject1 = localObject3;
          localObject3 = localFile;
        }
        else
        {
          VasUpdateWrapper.getLog().e("VasUpdate_FileUtil", "checkFileExist no dir path = " + paramString);
          return;
        }
      }
      if (!TextUtils.isEmpty(localObject2)) {
        new File(localObject2).delete();
      }
    } while (((File)localObject3).exists());
    ((File)localObject3).mkdirs();
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: aload_1
    //   10: invokevirtual 29	java/io/File:exists	()Z
    //   13: ifeq +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 76	java/io/File:delete	()Z
    //   20: pop
    //   21: aload_1
    //   22: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   25: ifnull +21 -> 46
    //   28: aload_1
    //   29: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   32: invokevirtual 29	java/io/File:exists	()Z
    //   35: ifne +11 -> 46
    //   38: aload_1
    //   39: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   42: invokevirtual 32	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: new 88	java/io/FileOutputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore_1
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
    //   76: astore 5
    //   78: aload_0
    //   79: aload 5
    //   81: invokevirtual 103	java/io/BufferedInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_m1
    //   87: if_icmpeq +61 -> 148
    //   90: aload_1
    //   91: aload 5
    //   93: iconst_0
    //   94: iload_2
    //   95: invokevirtual 107	java/io/FileOutputStream:write	([BII)V
    //   98: aload_1
    //   99: invokevirtual 110	java/io/FileOutputStream:flush	()V
    //   102: goto -24 -> 78
    //   105: astore 6
    //   107: aload_0
    //   108: astore 5
    //   110: aload_1
    //   111: astore_0
    //   112: aload 5
    //   114: astore_1
    //   115: aload 6
    //   117: astore 5
    //   119: aload 5
    //   121: invokevirtual 113	java/lang/Throwable:printStackTrace	()V
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   132: iload 4
    //   134: istore_3
    //   135: aload_1
    //   136: ifnull +10 -> 146
    //   139: aload_1
    //   140: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   143: iload 4
    //   145: istore_3
    //   146: iload_3
    //   147: ireturn
    //   148: iconst_1
    //   149: istore_3
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   158: aload_0
    //   159: ifnull -13 -> 146
    //   162: aload_0
    //   163: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_0
    //   169: aload_0
    //   170: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   173: iconst_1
    //   174: ireturn
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   180: goto -22 -> 158
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   188: goto -56 -> 132
    //   191: astore_0
    //   192: aload_0
    //   193: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_0
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 116	java/io/FileOutputStream:close	()V
    //   209: aload 5
    //   211: ifnull +8 -> 219
    //   214: aload 5
    //   216: invokevirtual 117	java/io/BufferedInputStream:close	()V
    //   219: aload_0
    //   220: athrow
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   226: goto -17 -> 209
    //   229: astore_1
    //   230: aload_1
    //   231: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   234: goto -15 -> 219
    //   237: astore_0
    //   238: goto -37 -> 201
    //   241: astore 6
    //   243: aload_0
    //   244: astore 5
    //   246: aload 6
    //   248: astore_0
    //   249: goto -48 -> 201
    //   252: astore 5
    //   254: aload_0
    //   255: astore 6
    //   257: aload 5
    //   259: astore_0
    //   260: aload_1
    //   261: astore 5
    //   263: aload 6
    //   265: astore_1
    //   266: goto -65 -> 201
    //   269: astore 5
    //   271: aconst_null
    //   272: astore_0
    //   273: aload 6
    //   275: astore_1
    //   276: goto -157 -> 119
    //   279: astore 5
    //   281: aload_1
    //   282: astore_0
    //   283: aload 6
    //   285: astore_1
    //   286: goto -167 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	paramFile1	File
    //   0	289	1	paramFile2	File
    //   84	11	2	i	int
    //   134	16	3	bool1	boolean
    //   7	137	4	bool2	boolean
    //   1	244	5	localObject1	Object
    //   252	6	5	localObject2	Object
    //   261	1	5	localFile1	File
    //   269	1	5	localThrowable1	Throwable
    //   279	1	5	localThrowable2	Throwable
    //   4	1	6	localObject3	Object
    //   105	11	6	localThrowable3	Throwable
    //   241	6	6	localObject4	Object
    //   255	29	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   71	78	105	java/lang/Throwable
    //   78	85	105	java/lang/Throwable
    //   90	102	105	java/lang/Throwable
    //   162	166	168	java/io/IOException
    //   154	158	175	java/io/IOException
    //   128	132	183	java/io/IOException
    //   139	143	191	java/io/IOException
    //   9	21	198	finally
    //   21	46	198	finally
    //   46	55	198	finally
    //   205	209	221	java/io/IOException
    //   214	219	229	java/io/IOException
    //   55	71	237	finally
    //   71	78	241	finally
    //   78	85	241	finally
    //   90	102	241	finally
    //   119	124	252	finally
    //   9	21	269	java/lang/Throwable
    //   21	46	269	java/lang/Throwable
    //   46	55	269	java/lang/Throwable
    //   55	71	279	java/lang/Throwable
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
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      paramString = new File(paramString);
    } while (!paramString.exists());
    paramString.delete();
  }
  
  /* Error */
  public static String readFileContent(File paramFile)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aconst_null
    //   3: astore 8
    //   5: aload_0
    //   6: invokevirtual 130	java/io/File:length	()J
    //   9: l2i
    //   10: istore_2
    //   11: new 132	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: iload_2
    //   16: invokespecial 135	java/io/ByteArrayOutputStream:<init>	(I)V
    //   19: astore 4
    //   21: new 93	java/io/BufferedInputStream
    //   24: dup
    //   25: new 95	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 96	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 99	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_0
    //   37: aload 4
    //   39: astore 6
    //   41: aload_0
    //   42: astore 5
    //   44: sipush 4096
    //   47: newarray byte
    //   49: astore 7
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +40 -> 93
    //   56: aload 4
    //   58: astore 6
    //   60: aload_0
    //   61: astore 5
    //   63: aload_0
    //   64: aload 7
    //   66: invokevirtual 138	java/io/InputStream:read	([B)I
    //   69: istore_3
    //   70: aload 4
    //   72: astore 6
    //   74: aload_0
    //   75: astore 5
    //   77: aload 4
    //   79: aload 7
    //   81: iconst_0
    //   82: iload_3
    //   83: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   86: iload_1
    //   87: iload_3
    //   88: iadd
    //   89: istore_1
    //   90: goto -39 -> 51
    //   93: aload 4
    //   95: astore 6
    //   97: aload_0
    //   98: astore 5
    //   100: aload 4
    //   102: ldc 141
    //   104: invokevirtual 144	java/io/ByteArrayOutputStream:toString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 7
    //   109: aload 7
    //   111: astore 5
    //   113: aload 4
    //   115: ifnull +8 -> 123
    //   118: aload 4
    //   120: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   123: aload 5
    //   125: astore 4
    //   127: aload_0
    //   128: ifnull +11 -> 139
    //   131: aload_0
    //   132: invokevirtual 146	java/io/InputStream:close	()V
    //   135: aload 5
    //   137: astore 4
    //   139: aload 4
    //   141: areturn
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   147: aload 5
    //   149: areturn
    //   150: astore 7
    //   152: aconst_null
    //   153: astore 4
    //   155: aconst_null
    //   156: astore_0
    //   157: aload 4
    //   159: astore 6
    //   161: aload_0
    //   162: astore 5
    //   164: aload 7
    //   166: invokevirtual 113	java/lang/Throwable:printStackTrace	()V
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   179: aload 8
    //   181: astore 4
    //   183: aload_0
    //   184: ifnull -45 -> 139
    //   187: aload_0
    //   188: invokevirtual 146	java/io/InputStream:close	()V
    //   191: aconst_null
    //   192: areturn
    //   193: astore_0
    //   194: aload_0
    //   195: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   198: aconst_null
    //   199: areturn
    //   200: astore_0
    //   201: aconst_null
    //   202: astore 4
    //   204: aconst_null
    //   205: astore 5
    //   207: aload 4
    //   209: ifnull +8 -> 217
    //   212: aload 4
    //   214: invokevirtual 145	java/io/ByteArrayOutputStream:close	()V
    //   217: aload 5
    //   219: ifnull +8 -> 227
    //   222: aload 5
    //   224: invokevirtual 146	java/io/InputStream:close	()V
    //   227: aload_0
    //   228: athrow
    //   229: astore 4
    //   231: aload 4
    //   233: invokevirtual 118	java/io/IOException:printStackTrace	()V
    //   236: goto -9 -> 227
    //   239: astore_0
    //   240: aconst_null
    //   241: astore 5
    //   243: goto -36 -> 207
    //   246: astore_0
    //   247: aload 6
    //   249: astore 4
    //   251: goto -44 -> 207
    //   254: astore 7
    //   256: aconst_null
    //   257: astore_0
    //   258: goto -101 -> 157
    //   261: astore 7
    //   263: goto -106 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	paramFile	File
    //   1	89	1	i	int
    //   10	44	2	j	int
    //   69	20	3	k	int
    //   19	194	4	localObject1	Object
    //   229	3	4	localIOException	IOException
    //   249	1	4	localObject2	Object
    //   42	200	5	localObject3	Object
    //   39	209	6	localObject4	Object
    //   49	61	7	localObject5	Object
    //   150	15	7	localThrowable1	Throwable
    //   254	1	7	localThrowable2	Throwable
    //   261	1	7	localThrowable3	Throwable
    //   3	177	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   118	123	142	java/io/IOException
    //   131	135	142	java/io/IOException
    //   5	21	150	java/lang/Throwable
    //   174	179	193	java/io/IOException
    //   187	191	193	java/io/IOException
    //   5	21	200	finally
    //   212	217	229	java/io/IOException
    //   222	227	229	java/io/IOException
    //   21	37	239	finally
    //   44	51	246	finally
    //   63	70	246	finally
    //   77	86	246	finally
    //   100	109	246	finally
    //   164	169	246	finally
    //   21	37	254	java/lang/Throwable
    //   44	51	261	java/lang/Throwable
    //   63	70	261	java/lang/Throwable
    //   77	86	261	java/lang/Throwable
    //   100	109	261	java/lang/Throwable
  }
  
  public static boolean removeFile(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return false;
      if (VasUpdateWrapper.getLog().isColorLevel()) {
        VasUpdateWrapper.getLog().i("VasUpdate_FileUtil", "removeFile from = " + paramString1 + " , to = " + paramString2);
      }
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean safeDeleteFile(File paramFile, String paramString)
  {
    if (!paramFile.exists()) {
      return true;
    }
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if (arrayOfFile != null)
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          safeDeleteFile(arrayOfFile[i], paramString);
          i += 1;
        }
      }
    }
    paramString = new File(paramFile.getParent() + File.separator + paramString + System.currentTimeMillis());
    paramFile.renameTo(paramString);
    return paramString.delete();
  }
  
  /* Error */
  public static String unZipFile(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 23	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_0
    //   11: new 56	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 173	java/io/File:getParent	()Ljava/lang/String;
    //   22: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: getstatic 38	java/io/File:separator	Ljava/lang/String;
    //   28: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: astore 5
    //   36: new 188	java/util/zip/ZipFile
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 189	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   44: astore 6
    //   46: aload 6
    //   48: invokevirtual 193	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   51: astore 10
    //   53: sipush 8192
    //   56: newarray byte
    //   58: astore 11
    //   60: aconst_null
    //   61: astore_3
    //   62: aconst_null
    //   63: astore 4
    //   65: aload 6
    //   67: astore 9
    //   69: aload_3
    //   70: astore 8
    //   72: aload 4
    //   74: astore 7
    //   76: aload 10
    //   78: invokeinterface 198 1 0
    //   83: ifeq +554 -> 637
    //   86: aload 6
    //   88: astore 9
    //   90: aload_3
    //   91: astore 8
    //   93: aload 4
    //   95: astore 7
    //   97: aload 10
    //   99: invokeinterface 202 1 0
    //   104: checkcast 204	java/util/zip/ZipEntry
    //   107: astore 12
    //   109: aload 6
    //   111: astore 9
    //   113: aload_3
    //   114: astore 8
    //   116: aload 4
    //   118: astore 7
    //   120: aload 12
    //   122: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   125: ldc 209
    //   127: invokevirtual 212	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   130: ifne -65 -> 65
    //   133: aload 6
    //   135: astore 9
    //   137: aload_3
    //   138: astore 8
    //   140: aload 4
    //   142: astore 7
    //   144: aload 12
    //   146: invokevirtual 213	java/util/zip/ZipEntry:isDirectory	()Z
    //   149: ifeq +208 -> 357
    //   152: aload 6
    //   154: astore 9
    //   156: aload_3
    //   157: astore 8
    //   159: aload 4
    //   161: astore 7
    //   163: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   166: invokeinterface 151 1 0
    //   171: ifeq +47 -> 218
    //   174: aload 6
    //   176: astore 9
    //   178: aload_3
    //   179: astore 8
    //   181: aload 4
    //   183: astore 7
    //   185: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   188: ldc 8
    //   190: new 56	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   197: ldc 215
    //   199: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 12
    //   204: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   207: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokeinterface 218 3 0
    //   218: aload 6
    //   220: astore 9
    //   222: aload_3
    //   223: astore 8
    //   225: aload 4
    //   227: astore 7
    //   229: new 40	java/lang/String
    //   232: dup
    //   233: new 56	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   240: aload 5
    //   242: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: aload 12
    //   247: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   250: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: ldc 220
    //   258: invokevirtual 224	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   261: ldc 226
    //   263: invokespecial 229	java/lang/String:<init>	([BLjava/lang/String;)V
    //   266: astore_0
    //   267: aload 6
    //   269: astore 9
    //   271: aload_3
    //   272: astore 8
    //   274: aload 4
    //   276: astore 7
    //   278: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   281: invokeinterface 151 1 0
    //   286: ifeq +43 -> 329
    //   289: aload 6
    //   291: astore 9
    //   293: aload_3
    //   294: astore 8
    //   296: aload 4
    //   298: astore 7
    //   300: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   303: ldc 8
    //   305: new 56	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   312: ldc 231
    //   314: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: aload_0
    //   318: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokeinterface 218 3 0
    //   329: aload 6
    //   331: astore 9
    //   333: aload_3
    //   334: astore 8
    //   336: aload 4
    //   338: astore 7
    //   340: new 23	java/io/File
    //   343: dup
    //   344: aload_0
    //   345: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   348: invokevirtual 234	java/io/File:mkdir	()Z
    //   351: pop
    //   352: aload_0
    //   353: astore_2
    //   354: goto -289 -> 65
    //   357: aload 6
    //   359: astore 9
    //   361: aload_3
    //   362: astore 8
    //   364: aload 4
    //   366: astore 7
    //   368: aload 12
    //   370: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   373: astore_0
    //   374: aload 6
    //   376: astore 9
    //   378: aload_3
    //   379: astore 8
    //   381: aload 4
    //   383: astore 7
    //   385: new 23	java/io/File
    //   388: dup
    //   389: new 56	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   396: aload 5
    //   398: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload 12
    //   403: invokevirtual 207	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   406: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokespecial 25	java/io/File:<init>	(Ljava/lang/String;)V
    //   415: astore_2
    //   416: aload 6
    //   418: astore 9
    //   420: aload_3
    //   421: astore 8
    //   423: aload 4
    //   425: astore 7
    //   427: aload_2
    //   428: invokevirtual 86	java/io/File:getParentFile	()Ljava/io/File;
    //   431: invokevirtual 32	java/io/File:mkdirs	()Z
    //   434: pop
    //   435: aload 6
    //   437: astore 9
    //   439: aload_3
    //   440: astore 8
    //   442: aload 4
    //   444: astore 7
    //   446: aload_2
    //   447: invokevirtual 29	java/io/File:exists	()Z
    //   450: ifeq +19 -> 469
    //   453: aload 6
    //   455: astore 9
    //   457: aload_3
    //   458: astore 8
    //   460: aload 4
    //   462: astore 7
    //   464: aload_2
    //   465: invokevirtual 76	java/io/File:delete	()Z
    //   468: pop
    //   469: aload 6
    //   471: astore 9
    //   473: aload_3
    //   474: astore 8
    //   476: aload 4
    //   478: astore 7
    //   480: new 236	java/io/BufferedOutputStream
    //   483: dup
    //   484: new 88	java/io/FileOutputStream
    //   487: dup
    //   488: aload_2
    //   489: invokespecial 91	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   492: invokespecial 239	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   495: astore_2
    //   496: aload 6
    //   498: aload 12
    //   500: invokevirtual 243	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   503: astore 4
    //   505: aload 4
    //   507: aload 11
    //   509: iconst_0
    //   510: sipush 8192
    //   513: invokevirtual 246	java/io/InputStream:read	([BII)I
    //   516: istore_1
    //   517: iload_1
    //   518: iconst_m1
    //   519: if_icmpeq +98 -> 617
    //   522: aload_2
    //   523: aload 11
    //   525: iconst_0
    //   526: iload_1
    //   527: invokevirtual 249	java/io/OutputStream:write	([BII)V
    //   530: goto -25 -> 505
    //   533: astore 5
    //   535: aload_2
    //   536: astore_3
    //   537: aload 5
    //   539: astore_2
    //   540: aload 4
    //   542: astore 5
    //   544: aload 6
    //   546: astore 9
    //   548: aload 5
    //   550: astore 8
    //   552: aload_3
    //   553: astore 7
    //   555: aload_2
    //   556: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   559: aload 6
    //   561: astore 9
    //   563: aload 5
    //   565: astore 8
    //   567: aload_3
    //   568: astore 7
    //   570: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   573: ldc 8
    //   575: ldc 252
    //   577: aload_2
    //   578: invokeinterface 255 4 0
    //   583: aload_3
    //   584: ifnull +7 -> 591
    //   587: aload_3
    //   588: invokevirtual 256	java/io/OutputStream:close	()V
    //   591: aload 5
    //   593: ifnull +8 -> 601
    //   596: aload 5
    //   598: invokevirtual 146	java/io/InputStream:close	()V
    //   601: aload_0
    //   602: astore_2
    //   603: aload 6
    //   605: ifnull +10 -> 615
    //   608: aload 6
    //   610: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   613: aload_0
    //   614: astore_2
    //   615: aload_2
    //   616: areturn
    //   617: aload 4
    //   619: invokevirtual 146	java/io/InputStream:close	()V
    //   622: aload_2
    //   623: invokevirtual 256	java/io/OutputStream:close	()V
    //   626: aload 4
    //   628: astore_3
    //   629: aload_2
    //   630: astore 4
    //   632: aload_0
    //   633: astore_2
    //   634: goto -569 -> 65
    //   637: aload 6
    //   639: astore 9
    //   641: aload_3
    //   642: astore 8
    //   644: aload 4
    //   646: astore 7
    //   648: aload 6
    //   650: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   653: aload_2
    //   654: ifnull +172 -> 826
    //   657: aload 6
    //   659: astore 9
    //   661: aload_3
    //   662: astore 8
    //   664: aload 4
    //   666: astore 7
    //   668: new 56	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   675: aload 5
    //   677: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_2
    //   681: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: astore_0
    //   688: aload 6
    //   690: astore 9
    //   692: aload_3
    //   693: astore 8
    //   695: aload 4
    //   697: astore 7
    //   699: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   702: ldc 8
    //   704: new 56	java/lang/StringBuilder
    //   707: dup
    //   708: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   711: ldc_w 259
    //   714: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload_0
    //   718: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokeinterface 218 3 0
    //   729: aload 4
    //   731: ifnull +8 -> 739
    //   734: aload 4
    //   736: invokevirtual 256	java/io/OutputStream:close	()V
    //   739: aload_3
    //   740: ifnull +7 -> 747
    //   743: aload_3
    //   744: invokevirtual 146	java/io/InputStream:close	()V
    //   747: aload_0
    //   748: astore_2
    //   749: aload 6
    //   751: ifnull -136 -> 615
    //   754: aload 6
    //   756: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   759: aload_0
    //   760: areturn
    //   761: astore_2
    //   762: aload_2
    //   763: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   766: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   769: ldc 8
    //   771: ldc_w 261
    //   774: aload_2
    //   775: invokeinterface 255 4 0
    //   780: aload_0
    //   781: areturn
    //   782: astore_2
    //   783: aload_2
    //   784: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   787: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   790: ldc 8
    //   792: ldc_w 261
    //   795: aload_2
    //   796: invokeinterface 255 4 0
    //   801: goto -62 -> 739
    //   804: astore_2
    //   805: aload_2
    //   806: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   809: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   812: ldc 8
    //   814: ldc_w 261
    //   817: aload_2
    //   818: invokeinterface 255 4 0
    //   823: goto -76 -> 747
    //   826: aload 6
    //   828: astore 9
    //   830: aload_3
    //   831: astore 8
    //   833: aload 4
    //   835: astore 7
    //   837: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   840: ldc 8
    //   842: ldc_w 263
    //   845: invokeinterface 73 3 0
    //   850: aload 4
    //   852: ifnull +8 -> 860
    //   855: aload 4
    //   857: invokevirtual 256	java/io/OutputStream:close	()V
    //   860: aload_3
    //   861: ifnull +7 -> 868
    //   864: aload_3
    //   865: invokevirtual 146	java/io/InputStream:close	()V
    //   868: aload 6
    //   870: ifnull +564 -> 1434
    //   873: aload 6
    //   875: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   878: aload_2
    //   879: areturn
    //   880: astore_0
    //   881: aload_0
    //   882: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   885: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   888: ldc 8
    //   890: ldc_w 261
    //   893: aload_0
    //   894: invokeinterface 255 4 0
    //   899: goto -39 -> 860
    //   902: astore_0
    //   903: aload_0
    //   904: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   907: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   910: ldc 8
    //   912: ldc_w 261
    //   915: aload_0
    //   916: invokeinterface 255 4 0
    //   921: goto -53 -> 868
    //   924: astore_0
    //   925: aload_0
    //   926: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   929: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   932: ldc 8
    //   934: ldc_w 261
    //   937: aload_0
    //   938: invokeinterface 255 4 0
    //   943: aload_2
    //   944: areturn
    //   945: astore_2
    //   946: aload_2
    //   947: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   950: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   953: ldc 8
    //   955: ldc_w 261
    //   958: aload_2
    //   959: invokeinterface 255 4 0
    //   964: goto -373 -> 591
    //   967: astore_2
    //   968: aload_2
    //   969: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   972: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   975: ldc 8
    //   977: ldc_w 261
    //   980: aload_2
    //   981: invokeinterface 255 4 0
    //   986: goto -385 -> 601
    //   989: astore_2
    //   990: aload_2
    //   991: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   994: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   997: ldc 8
    //   999: ldc_w 261
    //   1002: aload_2
    //   1003: invokeinterface 255 4 0
    //   1008: aload_0
    //   1009: areturn
    //   1010: astore_2
    //   1011: aconst_null
    //   1012: astore 6
    //   1014: aconst_null
    //   1015: astore 5
    //   1017: aconst_null
    //   1018: astore_3
    //   1019: aconst_null
    //   1020: astore_0
    //   1021: aload 6
    //   1023: astore 9
    //   1025: aload 5
    //   1027: astore 8
    //   1029: aload_3
    //   1030: astore 7
    //   1032: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1035: ldc 8
    //   1037: ldc_w 265
    //   1040: aload_2
    //   1041: invokeinterface 255 4 0
    //   1046: aload_3
    //   1047: ifnull +7 -> 1054
    //   1050: aload_3
    //   1051: invokevirtual 256	java/io/OutputStream:close	()V
    //   1054: aload 5
    //   1056: ifnull +8 -> 1064
    //   1059: aload 5
    //   1061: invokevirtual 146	java/io/InputStream:close	()V
    //   1064: aload_0
    //   1065: astore_2
    //   1066: aload 6
    //   1068: ifnull -453 -> 615
    //   1071: aload 6
    //   1073: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   1076: aload_0
    //   1077: areturn
    //   1078: astore_2
    //   1079: aload_2
    //   1080: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1083: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1086: ldc 8
    //   1088: ldc_w 261
    //   1091: aload_2
    //   1092: invokeinterface 255 4 0
    //   1097: aload_0
    //   1098: areturn
    //   1099: astore_2
    //   1100: aload_2
    //   1101: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1104: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1107: ldc 8
    //   1109: ldc_w 261
    //   1112: aload_2
    //   1113: invokeinterface 255 4 0
    //   1118: goto -64 -> 1054
    //   1121: astore_2
    //   1122: aload_2
    //   1123: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1126: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1129: ldc 8
    //   1131: ldc_w 261
    //   1134: aload_2
    //   1135: invokeinterface 255 4 0
    //   1140: goto -76 -> 1064
    //   1143: astore_0
    //   1144: aconst_null
    //   1145: astore 6
    //   1147: aconst_null
    //   1148: astore_3
    //   1149: aconst_null
    //   1150: astore_2
    //   1151: aload_2
    //   1152: ifnull +7 -> 1159
    //   1155: aload_2
    //   1156: invokevirtual 256	java/io/OutputStream:close	()V
    //   1159: aload_3
    //   1160: ifnull +7 -> 1167
    //   1163: aload_3
    //   1164: invokevirtual 146	java/io/InputStream:close	()V
    //   1167: aload 6
    //   1169: ifnull +8 -> 1177
    //   1172: aload 6
    //   1174: invokevirtual 257	java/util/zip/ZipFile:close	()V
    //   1177: aload_0
    //   1178: athrow
    //   1179: astore_2
    //   1180: aload_2
    //   1181: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1184: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1187: ldc 8
    //   1189: ldc_w 261
    //   1192: aload_2
    //   1193: invokeinterface 255 4 0
    //   1198: goto -39 -> 1159
    //   1201: astore_2
    //   1202: aload_2
    //   1203: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1206: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1209: ldc 8
    //   1211: ldc_w 261
    //   1214: aload_2
    //   1215: invokeinterface 255 4 0
    //   1220: goto -53 -> 1167
    //   1223: astore_2
    //   1224: aload_2
    //   1225: invokevirtual 250	java/lang/Exception:printStackTrace	()V
    //   1228: invokestatic 54	com/tencent/vas/update/wrapper/VasUpdateWrapper:getLog	()Lcom/tencent/vas/update/callback/IVasLog;
    //   1231: ldc 8
    //   1233: ldc_w 261
    //   1236: aload_2
    //   1237: invokeinterface 255 4 0
    //   1242: goto -65 -> 1177
    //   1245: astore_0
    //   1246: aconst_null
    //   1247: astore_3
    //   1248: aconst_null
    //   1249: astore_2
    //   1250: goto -99 -> 1151
    //   1253: astore_0
    //   1254: aload 4
    //   1256: astore_3
    //   1257: goto -106 -> 1151
    //   1260: astore_0
    //   1261: aload 9
    //   1263: astore 6
    //   1265: aload 8
    //   1267: astore_3
    //   1268: aload 7
    //   1270: astore_2
    //   1271: goto -120 -> 1151
    //   1274: astore_0
    //   1275: goto -124 -> 1151
    //   1278: astore_2
    //   1279: aconst_null
    //   1280: astore 5
    //   1282: aconst_null
    //   1283: astore_3
    //   1284: aconst_null
    //   1285: astore_0
    //   1286: goto -265 -> 1021
    //   1289: astore 5
    //   1291: aload_2
    //   1292: astore_3
    //   1293: aload 5
    //   1295: astore_2
    //   1296: aload 4
    //   1298: astore 5
    //   1300: goto -279 -> 1021
    //   1303: astore 5
    //   1305: aload_2
    //   1306: astore_0
    //   1307: aload 5
    //   1309: astore_2
    //   1310: aload_3
    //   1311: astore 5
    //   1313: aload 4
    //   1315: astore_3
    //   1316: goto -295 -> 1021
    //   1319: astore_2
    //   1320: aload_3
    //   1321: astore 5
    //   1323: aload 4
    //   1325: astore_3
    //   1326: goto -305 -> 1021
    //   1329: astore 5
    //   1331: aload_2
    //   1332: astore 4
    //   1334: aload 5
    //   1336: astore_2
    //   1337: aload_3
    //   1338: astore 5
    //   1340: aload 4
    //   1342: astore_3
    //   1343: goto -322 -> 1021
    //   1346: astore_2
    //   1347: aload_3
    //   1348: astore 5
    //   1350: aload 4
    //   1352: astore_3
    //   1353: goto -332 -> 1021
    //   1356: astore_2
    //   1357: aconst_null
    //   1358: astore 6
    //   1360: aconst_null
    //   1361: astore 5
    //   1363: aconst_null
    //   1364: astore_3
    //   1365: aconst_null
    //   1366: astore_0
    //   1367: goto -823 -> 544
    //   1370: astore_2
    //   1371: aconst_null
    //   1372: astore 5
    //   1374: aconst_null
    //   1375: astore_3
    //   1376: aconst_null
    //   1377: astore_0
    //   1378: goto -834 -> 544
    //   1381: astore 5
    //   1383: aload_2
    //   1384: astore_0
    //   1385: aload 5
    //   1387: astore_2
    //   1388: aload_3
    //   1389: astore 5
    //   1391: aload 4
    //   1393: astore_3
    //   1394: goto -850 -> 544
    //   1397: astore_2
    //   1398: aload_3
    //   1399: astore 5
    //   1401: aload 4
    //   1403: astore_3
    //   1404: goto -860 -> 544
    //   1407: astore 5
    //   1409: aload_2
    //   1410: astore 4
    //   1412: aload 5
    //   1414: astore_2
    //   1415: aload_3
    //   1416: astore 5
    //   1418: aload 4
    //   1420: astore_3
    //   1421: goto -877 -> 544
    //   1424: astore_2
    //   1425: aload_3
    //   1426: astore 5
    //   1428: aload 4
    //   1430: astore_3
    //   1431: goto -887 -> 544
    //   1434: aload_2
    //   1435: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1436	0	paramString	String
    //   516	11	1	i	int
    //   1	748	2	localObject1	Object
    //   761	14	2	localException1	java.lang.Exception
    //   782	14	2	localException2	java.lang.Exception
    //   804	140	2	localException3	java.lang.Exception
    //   945	14	2	localException4	java.lang.Exception
    //   967	14	2	localException5	java.lang.Exception
    //   989	14	2	localException6	java.lang.Exception
    //   1010	31	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1065	1	2	str1	String
    //   1078	14	2	localException7	java.lang.Exception
    //   1099	14	2	localException8	java.lang.Exception
    //   1121	14	2	localException9	java.lang.Exception
    //   1150	6	2	localObject2	Object
    //   1179	14	2	localException10	java.lang.Exception
    //   1201	14	2	localException11	java.lang.Exception
    //   1223	14	2	localException12	java.lang.Exception
    //   1249	22	2	localObject3	Object
    //   1278	14	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1295	15	2	localObject4	Object
    //   1319	13	2	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1336	1	2	localObject5	Object
    //   1346	1	2	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1356	1	2	localException13	java.lang.Exception
    //   1370	14	2	localException14	java.lang.Exception
    //   1387	1	2	localObject6	Object
    //   1397	13	2	localException15	java.lang.Exception
    //   1414	1	2	localObject7	Object
    //   1424	11	2	localException16	java.lang.Exception
    //   61	1370	3	localObject8	Object
    //   63	1366	4	localObject9	Object
    //   34	363	5	str2	String
    //   533	5	5	localException17	java.lang.Exception
    //   542	739	5	localObject10	Object
    //   1289	5	5	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1298	1	5	localObject11	Object
    //   1303	5	5	localOutOfMemoryError6	java.lang.OutOfMemoryError
    //   1311	11	5	localObject12	Object
    //   1329	6	5	localOutOfMemoryError7	java.lang.OutOfMemoryError
    //   1338	35	5	localObject13	Object
    //   1381	5	5	localException18	java.lang.Exception
    //   1389	11	5	localObject14	Object
    //   1407	6	5	localException19	java.lang.Exception
    //   1416	11	5	localObject15	Object
    //   44	1315	6	localObject16	Object
    //   74	1195	7	localObject17	Object
    //   70	1196	8	localObject18	Object
    //   67	1195	9	localObject19	Object
    //   51	47	10	localEnumeration	java.util.Enumeration
    //   58	466	11	arrayOfByte	byte[]
    //   107	392	12	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   505	517	533	java/lang/Exception
    //   522	530	533	java/lang/Exception
    //   617	626	533	java/lang/Exception
    //   754	759	761	java/lang/Exception
    //   734	739	782	java/lang/Exception
    //   743	747	804	java/lang/Exception
    //   855	860	880	java/lang/Exception
    //   864	868	902	java/lang/Exception
    //   873	878	924	java/lang/Exception
    //   587	591	945	java/lang/Exception
    //   596	601	967	java/lang/Exception
    //   608	613	989	java/lang/Exception
    //   36	46	1010	java/lang/OutOfMemoryError
    //   1071	1076	1078	java/lang/Exception
    //   1050	1054	1099	java/lang/Exception
    //   1059	1064	1121	java/lang/Exception
    //   36	46	1143	finally
    //   1155	1159	1179	java/lang/Exception
    //   1163	1167	1201	java/lang/Exception
    //   1172	1177	1223	java/lang/Exception
    //   46	60	1245	finally
    //   505	517	1253	finally
    //   522	530	1253	finally
    //   617	626	1253	finally
    //   76	86	1260	finally
    //   97	109	1260	finally
    //   120	133	1260	finally
    //   144	152	1260	finally
    //   163	174	1260	finally
    //   185	218	1260	finally
    //   229	267	1260	finally
    //   278	289	1260	finally
    //   300	329	1260	finally
    //   340	352	1260	finally
    //   368	374	1260	finally
    //   385	416	1260	finally
    //   427	435	1260	finally
    //   446	453	1260	finally
    //   464	469	1260	finally
    //   480	496	1260	finally
    //   555	559	1260	finally
    //   570	583	1260	finally
    //   648	653	1260	finally
    //   668	688	1260	finally
    //   699	729	1260	finally
    //   837	850	1260	finally
    //   1032	1046	1260	finally
    //   496	505	1274	finally
    //   46	60	1278	java/lang/OutOfMemoryError
    //   505	517	1289	java/lang/OutOfMemoryError
    //   522	530	1289	java/lang/OutOfMemoryError
    //   617	626	1289	java/lang/OutOfMemoryError
    //   76	86	1303	java/lang/OutOfMemoryError
    //   97	109	1303	java/lang/OutOfMemoryError
    //   120	133	1303	java/lang/OutOfMemoryError
    //   144	152	1303	java/lang/OutOfMemoryError
    //   163	174	1303	java/lang/OutOfMemoryError
    //   185	218	1303	java/lang/OutOfMemoryError
    //   229	267	1303	java/lang/OutOfMemoryError
    //   278	289	1303	java/lang/OutOfMemoryError
    //   300	329	1303	java/lang/OutOfMemoryError
    //   340	352	1303	java/lang/OutOfMemoryError
    //   368	374	1303	java/lang/OutOfMemoryError
    //   648	653	1303	java/lang/OutOfMemoryError
    //   668	688	1303	java/lang/OutOfMemoryError
    //   837	850	1303	java/lang/OutOfMemoryError
    //   385	416	1319	java/lang/OutOfMemoryError
    //   427	435	1319	java/lang/OutOfMemoryError
    //   446	453	1319	java/lang/OutOfMemoryError
    //   464	469	1319	java/lang/OutOfMemoryError
    //   480	496	1319	java/lang/OutOfMemoryError
    //   496	505	1329	java/lang/OutOfMemoryError
    //   699	729	1346	java/lang/OutOfMemoryError
    //   36	46	1356	java/lang/Exception
    //   46	60	1370	java/lang/Exception
    //   76	86	1381	java/lang/Exception
    //   97	109	1381	java/lang/Exception
    //   120	133	1381	java/lang/Exception
    //   144	152	1381	java/lang/Exception
    //   163	174	1381	java/lang/Exception
    //   185	218	1381	java/lang/Exception
    //   229	267	1381	java/lang/Exception
    //   278	289	1381	java/lang/Exception
    //   300	329	1381	java/lang/Exception
    //   340	352	1381	java/lang/Exception
    //   368	374	1381	java/lang/Exception
    //   648	653	1381	java/lang/Exception
    //   668	688	1381	java/lang/Exception
    //   837	850	1381	java/lang/Exception
    //   385	416	1397	java/lang/Exception
    //   427	435	1397	java/lang/Exception
    //   446	453	1397	java/lang/Exception
    //   464	469	1397	java/lang/Exception
    //   480	496	1397	java/lang/Exception
    //   496	505	1407	java/lang/Exception
    //   699	729	1424	java/lang/Exception
  }
  
  public static boolean writeFileContent(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      if (!paramString1.getParentFile().exists()) {
        paramString1.getParentFile().mkdirs();
      }
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label57:
          label94:
          paramString1.close();
          return bool2;
        }
        catch (IOException paramString1) {}
        localIOException = localIOException;
        bool1 = false;
      }
    }
    try
    {
      paramString1 = new FileOutputStream(paramString1, false);
      bool2 = bool1;
    }
    catch (FileNotFoundException paramString1)
    {
      bool2 = false;
      paramString1 = null;
      break label57;
    }
    try
    {
      paramString2 = paramString2 + "\r\n";
      bool1 = bool2;
      if (paramString1 != null)
      {
        paramString1.write(paramString2.getBytes());
        bool1 = bool2;
      }
    }
    catch (IOException paramString2)
    {
      bool1 = false;
      break label94;
    }
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool2 = false;
      }
    }
    if (paramString1 != null) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */