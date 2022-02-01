package com.tencent.qqmini.sdk.launcher.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils
{
  private static final String TAG = "FileUtils";
  
  public static void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_1
    //   12: invokevirtual 38	java/io/File:exists	()Z
    //   15: ifeq +8 -> 23
    //   18: aload_1
    //   19: invokevirtual 41	java/io/File:delete	()Z
    //   22: pop
    //   23: new 43	java/io/FileOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   31: astore_1
    //   32: new 48	java/io/BufferedInputStream
    //   35: dup
    //   36: new 50	java/io/FileInputStream
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   44: invokespecial 54	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore_0
    //   48: sipush 1024
    //   51: newarray byte
    //   53: astore 4
    //   55: aload_0
    //   56: aload 4
    //   58: invokevirtual 55	java/io/BufferedInputStream:read	([B)I
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_m1
    //   64: if_icmpeq +18 -> 82
    //   67: aload_1
    //   68: aload 4
    //   70: iconst_0
    //   71: iload_2
    //   72: invokevirtual 56	java/io/FileOutputStream:write	([BII)V
    //   75: aload_1
    //   76: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   79: goto -24 -> 55
    //   82: iconst_1
    //   83: istore_3
    //   84: aload_1
    //   85: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   88: aload_0
    //   89: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: astore 5
    //   96: aload_0
    //   97: astore 4
    //   99: aload 5
    //   101: astore_0
    //   102: goto +28 -> 130
    //   105: goto +53 -> 158
    //   108: goto +76 -> 184
    //   111: astore_0
    //   112: goto +18 -> 130
    //   115: aload 5
    //   117: astore_0
    //   118: goto +40 -> 158
    //   121: aload 6
    //   123: astore_0
    //   124: goto +60 -> 184
    //   127: astore_0
    //   128: aconst_null
    //   129: astore_1
    //   130: aload_1
    //   131: ifnull +10 -> 141
    //   134: aload_1
    //   135: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   138: goto +3 -> 141
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   151: aload_0
    //   152: athrow
    //   153: aconst_null
    //   154: astore_1
    //   155: aload 5
    //   157: astore_0
    //   158: aload_1
    //   159: ifnull +10 -> 169
    //   162: aload_1
    //   163: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   166: goto +3 -> 169
    //   169: aload_0
    //   170: ifnull +32 -> 202
    //   173: aload_0
    //   174: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   177: iconst_0
    //   178: ireturn
    //   179: aconst_null
    //   180: astore_1
    //   181: aload 6
    //   183: astore_0
    //   184: aload_1
    //   185: ifnull +10 -> 195
    //   188: aload_1
    //   189: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   192: goto +3 -> 195
    //   195: aload_0
    //   196: ifnull +6 -> 202
    //   199: goto -26 -> 173
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: goto -26 -> 179
    //   208: astore_0
    //   209: goto -56 -> 153
    //   212: astore_0
    //   213: goto -92 -> 121
    //   216: astore_0
    //   217: goto -102 -> 115
    //   220: astore 4
    //   222: goto -114 -> 108
    //   225: astore 4
    //   227: goto -122 -> 105
    //   230: astore_1
    //   231: goto -143 -> 88
    //   234: astore_0
    //   235: iload_3
    //   236: ireturn
    //   237: astore_1
    //   238: goto -97 -> 141
    //   241: astore_1
    //   242: goto -91 -> 151
    //   245: astore_1
    //   246: goto -77 -> 169
    //   249: astore_1
    //   250: goto -55 -> 195
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramFile1	File
    //   0	253	1	paramFile2	File
    //   61	11	2	i	int
    //   1	235	3	bool	boolean
    //   9	138	4	localObject1	Object
    //   220	1	4	localIOException	IOException
    //   225	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   3	1	5	localObject2	Object
    //   94	62	5	localObject3	Object
    //   6	176	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   48	55	94	finally
    //   55	62	94	finally
    //   67	79	94	finally
    //   32	48	111	finally
    //   11	23	127	finally
    //   23	32	127	finally
    //   11	23	204	java/io/IOException
    //   23	32	204	java/io/IOException
    //   11	23	208	java/lang/OutOfMemoryError
    //   23	32	208	java/lang/OutOfMemoryError
    //   32	48	212	java/io/IOException
    //   32	48	216	java/lang/OutOfMemoryError
    //   48	55	220	java/io/IOException
    //   55	62	220	java/io/IOException
    //   67	79	220	java/io/IOException
    //   48	55	225	java/lang/OutOfMemoryError
    //   55	62	225	java/lang/OutOfMemoryError
    //   67	79	225	java/lang/OutOfMemoryError
    //   84	88	230	java/io/IOException
    //   88	92	234	java/io/IOException
    //   173	177	234	java/io/IOException
    //   134	138	237	java/io/IOException
    //   146	151	241	java/io/IOException
    //   162	166	245	java/io/IOException
    //   188	192	249	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      boolean bool = copyFile(paramString1, createFile(paramString2));
      return bool;
    }
    catch (IOException paramString1)
    {
      label27:
      break label27;
    }
    return false;
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      if ((paramString.getParentFile() != null) && (!paramString.getParentFile().exists()))
      {
        if (paramString.getParentFile().mkdirs())
        {
          paramString.createNewFile();
          return paramString;
        }
      }
      else {
        paramString.createNewFile();
      }
    }
    return paramString;
  }
  
  public static void delete(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    paramString = new File(paramString);
    if (!paramString.exists()) {
      return;
    }
    if (paramString.isFile())
    {
      paramString.delete();
      return;
    }
    File[] arrayOfFile = paramString.listFiles();
    if (arrayOfFile == null) {
      return;
    }
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
      i += 1;
    }
    if (!paramBoolean) {
      paramString.delete();
    }
  }
  
  public static boolean deleteFile(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length > 0))
      {
        int i = 0;
        while (i < arrayOfFile.length)
        {
          deleteFile(arrayOfFile[i]);
          i += 1;
        }
      }
    }
    return paramFile.delete();
  }
  
  public static boolean deleteFile(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      return paramString.delete();
    }
    return true;
  }
  
  public static String readFileToStr(File paramFile)
  {
    if (paramFile != null) {
      try
      {
        if (paramFile.exists())
        {
          paramFile = readFileToString(paramFile);
          return paramFile;
        }
      }
      catch (Throwable paramFile)
      {
        paramFile.printStackTrace();
        return "";
      }
    }
    return null;
  }
  
  /* Error */
  public static String readFileToString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 38	java/io/File:exists	()Z
    //   13: ifeq +286 -> 299
    //   16: aload_0
    //   17: invokevirtual 102	java/io/File:isDirectory	()Z
    //   20: ifne +239 -> 259
    //   23: aload_0
    //   24: invokevirtual 122	java/io/File:canRead	()Z
    //   27: ifeq +192 -> 219
    //   30: new 50	java/io/FileInputStream
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: new 124	java/io/InputStreamReader
    //   42: dup
    //   43: aload_3
    //   44: ldc 126
    //   46: invokespecial 129	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   49: astore_2
    //   50: aload_0
    //   51: invokevirtual 133	java/io/File:length	()J
    //   54: l2i
    //   55: istore_1
    //   56: iload_1
    //   57: sipush 12288
    //   60: if_icmple +53 -> 113
    //   63: sipush 4096
    //   66: newarray char
    //   68: astore_0
    //   69: new 135	java/lang/StringBuilder
    //   72: dup
    //   73: sipush 12288
    //   76: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   79: astore 5
    //   81: aload_2
    //   82: aload_0
    //   83: invokevirtual 141	java/io/InputStreamReader:read	([C)I
    //   86: istore_1
    //   87: iconst_m1
    //   88: iload_1
    //   89: if_icmpeq +15 -> 104
    //   92: aload 5
    //   94: aload_0
    //   95: iconst_0
    //   96: iload_1
    //   97: invokevirtual 145	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: goto -20 -> 81
    //   104: aload 5
    //   106: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: goto +22 -> 132
    //   113: iload_1
    //   114: newarray char
    //   116: astore_0
    //   117: new 150	java/lang/String
    //   120: dup
    //   121: aload_0
    //   122: iconst_0
    //   123: aload_2
    //   124: aload_0
    //   125: invokevirtual 141	java/io/InputStreamReader:read	([C)I
    //   128: invokespecial 153	java/lang/String:<init>	([CII)V
    //   131: astore_0
    //   132: aload_3
    //   133: invokevirtual 154	java/io/InputStream:close	()V
    //   136: aload_0
    //   137: astore_3
    //   138: aload_2
    //   139: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   142: aload_3
    //   143: areturn
    //   144: astore_0
    //   145: goto +24 -> 169
    //   148: aload_2
    //   149: astore_0
    //   150: goto +44 -> 194
    //   153: astore_0
    //   154: aconst_null
    //   155: astore_2
    //   156: goto +13 -> 169
    //   159: aconst_null
    //   160: astore_0
    //   161: goto +33 -> 194
    //   164: astore_0
    //   165: aconst_null
    //   166: astore_3
    //   167: aload_3
    //   168: astore_2
    //   169: aload_3
    //   170: ifnull +10 -> 180
    //   173: aload_3
    //   174: invokevirtual 154	java/io/InputStream:close	()V
    //   177: goto +3 -> 180
    //   180: aload_2
    //   181: ifnull +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 155	java/io/InputStreamReader:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: aconst_null
    //   191: astore_3
    //   192: aload_3
    //   193: astore_0
    //   194: aload_3
    //   195: ifnull +10 -> 205
    //   198: aload_3
    //   199: invokevirtual 154	java/io/InputStream:close	()V
    //   202: goto +3 -> 205
    //   205: aload_0
    //   206: ifnull +11 -> 217
    //   209: aload 4
    //   211: astore_3
    //   212: aload_0
    //   213: astore_2
    //   214: goto -76 -> 138
    //   217: aconst_null
    //   218: areturn
    //   219: new 135	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   226: astore_2
    //   227: aload_2
    //   228: ldc 158
    //   230: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload_2
    //   235: aload_0
    //   236: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: ldc 166
    //   243: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: new 30	java/io/IOException
    //   250: dup
    //   251: aload_2
    //   252: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   255: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   258: athrow
    //   259: new 135	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   266: astore_2
    //   267: aload_2
    //   268: ldc 158
    //   270: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload_2
    //   275: aload_0
    //   276: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_2
    //   281: ldc 169
    //   283: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: new 30	java/io/IOException
    //   290: dup
    //   291: aload_2
    //   292: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokespecial 167	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   298: athrow
    //   299: new 135	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 156	java/lang/StringBuilder:<init>	()V
    //   306: astore_2
    //   307: aload_2
    //   308: ldc 158
    //   310: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_2
    //   315: aload_0
    //   316: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: ldc 171
    //   323: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: new 173	java/io/FileNotFoundException
    //   330: dup
    //   331: aload_2
    //   332: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokespecial 174	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   338: astore_0
    //   339: goto +5 -> 344
    //   342: aload_0
    //   343: athrow
    //   344: goto -2 -> 342
    //   347: astore_0
    //   348: goto -158 -> 190
    //   351: astore_0
    //   352: goto -193 -> 159
    //   355: astore_0
    //   356: goto -208 -> 148
    //   359: astore_3
    //   360: aload_0
    //   361: astore_3
    //   362: goto -224 -> 138
    //   365: astore_0
    //   366: aload_3
    //   367: areturn
    //   368: astore_3
    //   369: goto -189 -> 180
    //   372: astore_2
    //   373: goto -185 -> 188
    //   376: astore_2
    //   377: goto -172 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramFile	File
    //   55	59	1	i	int
    //   49	283	2	localObject1	Object
    //   372	1	2	localException1	java.lang.Exception
    //   376	1	2	localException2	java.lang.Exception
    //   38	174	3	localObject2	Object
    //   359	1	3	localException3	java.lang.Exception
    //   361	6	3	localFile	File
    //   368	1	3	localException4	java.lang.Exception
    //   1	209	4	localObject3	Object
    //   79	26	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	56	144	finally
    //   63	81	144	finally
    //   81	87	144	finally
    //   92	101	144	finally
    //   104	110	144	finally
    //   113	132	144	finally
    //   39	50	153	finally
    //   30	39	164	finally
    //   30	39	347	java/lang/Exception
    //   39	50	351	java/lang/Exception
    //   50	56	355	java/lang/Exception
    //   63	81	355	java/lang/Exception
    //   81	87	355	java/lang/Exception
    //   92	101	355	java/lang/Exception
    //   104	110	355	java/lang/Exception
    //   113	132	355	java/lang/Exception
    //   132	136	359	java/lang/Exception
    //   138	142	365	java/lang/Exception
    //   173	177	368	java/lang/Exception
    //   184	188	372	java/lang/Exception
    //   198	202	376	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      paramString1 = new File(paramString1);
      bool1 = bool2;
      if (paramString1.exists()) {
        bool1 = paramString1.renameTo(new File(paramString2));
      }
    }
    return bool1;
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label24:
      boolean bool2;
      break label24;
    }
    bool2 = false;
    break label31;
    bool2 = true;
    try
    {
      label31:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label44:
      boolean bool1;
      break label44;
    }
    paramString1 = null;
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      label67:
      break label67;
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
      label84:
      break label84;
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
      label98:
      break label98;
    }
    bool1 = false;
    return bool1;
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte)
  {
    return writeFile(paramString, paramArrayOfByte, false);
  }
  
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return writeFile(paramString, paramArrayOfByte, paramBoolean, paramArrayOfByte.length);
  }
  
  /* Error */
  public static boolean writeFile(String paramString, byte[] paramArrayOfByte, boolean paramBoolean, int paramInt)
  {
    // Byte code:
    //   0: new 34	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_0
    //   16: invokevirtual 38	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_0
    //   23: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 38	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_0
    //   33: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 80	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_0
    //   41: invokevirtual 83	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 43	java/io/FileOutputStream
    //   48: dup
    //   49: aload_0
    //   50: iload_2
    //   51: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_0
    //   55: aload_0
    //   56: aload_1
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 56	java/io/FileOutputStream:write	([BII)V
    //   62: aload_0
    //   63: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   66: aload_0
    //   67: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore 4
    //   74: aload_0
    //   75: astore_1
    //   76: aload 4
    //   78: astore_0
    //   79: goto +10 -> 89
    //   82: goto +17 -> 99
    //   85: astore_0
    //   86: aload 4
    //   88: astore_1
    //   89: aload_1
    //   90: ifnull +7 -> 97
    //   93: aload_1
    //   94: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   97: aload_0
    //   98: athrow
    //   99: aload_0
    //   100: ifnull +7 -> 107
    //   103: aload_0
    //   104: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   107: iconst_0
    //   108: ireturn
    //   109: astore_0
    //   110: aload 5
    //   112: astore_0
    //   113: goto -14 -> 99
    //   116: astore_1
    //   117: goto -35 -> 82
    //   120: astore_0
    //   121: iconst_0
    //   122: ireturn
    //   123: astore_1
    //   124: goto -27 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	paramString	String
    //   0	127	1	paramArrayOfByte	byte[]
    //   0	127	2	paramBoolean	boolean
    //   0	127	3	paramInt	int
    //   13	1	4	localObject1	Object
    //   72	15	4	localObject2	Object
    //   10	101	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	85	finally
    //   40	45	85	finally
    //   45	55	85	finally
    //   15	40	109	java/io/IOException
    //   40	45	109	java/io/IOException
    //   45	55	109	java/io/IOException
    //   55	66	116	java/io/IOException
    //   66	70	120	java/io/IOException
    //   103	107	120	java/io/IOException
    //   93	97	123	java/io/IOException
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
    //   0: new 34	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aconst_null
    //   10: astore 5
    //   12: aconst_null
    //   13: astore 4
    //   15: aload_1
    //   16: invokevirtual 38	java/io/File:exists	()Z
    //   19: ifne +26 -> 45
    //   22: aload_1
    //   23: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   26: invokevirtual 38	java/io/File:exists	()Z
    //   29: ifne +11 -> 40
    //   32: aload_1
    //   33: invokevirtual 77	java/io/File:getParentFile	()Ljava/io/File;
    //   36: invokevirtual 80	java/io/File:mkdirs	()Z
    //   39: pop
    //   40: aload_1
    //   41: invokevirtual 83	java/io/File:createNewFile	()Z
    //   44: pop
    //   45: new 43	java/io/FileOutputStream
    //   48: dup
    //   49: aload_1
    //   50: iload_2
    //   51: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   54: astore_1
    //   55: aload_1
    //   56: aload_0
    //   57: iconst_0
    //   58: iload_3
    //   59: invokevirtual 56	java/io/FileOutputStream:write	([BII)V
    //   62: aload_1
    //   63: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   66: aload_1
    //   67: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   70: iconst_1
    //   71: ireturn
    //   72: astore_0
    //   73: goto +10 -> 83
    //   76: goto +17 -> 93
    //   79: astore_0
    //   80: aload 4
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   101: iconst_0
    //   102: ireturn
    //   103: astore_0
    //   104: aload 5
    //   106: astore_1
    //   107: goto -14 -> 93
    //   110: astore_0
    //   111: goto -35 -> 76
    //   114: astore_0
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_1
    //   118: goto -27 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramArrayOfByte	byte[]
    //   0	121	1	paramString	String
    //   0	121	2	paramBoolean	boolean
    //   0	121	3	paramInt	int
    //   13	68	4	localObject1	Object
    //   10	95	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	66	72	finally
    //   15	40	79	finally
    //   40	45	79	finally
    //   45	55	79	finally
    //   15	40	103	java/io/IOException
    //   40	45	103	java/io/IOException
    //   45	55	103	java/io/IOException
    //   55	66	110	java/io/IOException
    //   66	70	114	java/io/IOException
    //   97	101	114	java/io/IOException
    //   87	91	117	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */