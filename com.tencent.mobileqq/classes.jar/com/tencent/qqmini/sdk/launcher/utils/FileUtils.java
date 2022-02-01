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
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 5
    //   6: aconst_null
    //   7: astore 6
    //   9: iconst_0
    //   10: istore 4
    //   12: aload_1
    //   13: invokevirtual 38	java/io/File:exists	()Z
    //   16: ifeq +8 -> 24
    //   19: aload_1
    //   20: invokevirtual 41	java/io/File:delete	()Z
    //   23: pop
    //   24: new 43	java/io/FileOutputStream
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 46	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   32: astore_1
    //   33: new 48	java/io/BufferedInputStream
    //   36: dup
    //   37: new 50	java/io/FileInputStream
    //   40: dup
    //   41: aload_0
    //   42: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   45: invokespecial 54	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: astore_0
    //   49: sipush 1024
    //   52: newarray byte
    //   54: astore 5
    //   56: aload_0
    //   57: aload 5
    //   59: invokevirtual 55	java/io/BufferedInputStream:read	([B)I
    //   62: istore_2
    //   63: iload_2
    //   64: iconst_m1
    //   65: if_icmpeq +52 -> 117
    //   68: aload_1
    //   69: aload 5
    //   71: iconst_0
    //   72: iload_2
    //   73: invokevirtual 56	java/io/FileOutputStream:write	([BII)V
    //   76: aload_1
    //   77: invokevirtual 59	java/io/FileOutputStream:flush	()V
    //   80: goto -24 -> 56
    //   83: astore 5
    //   85: aload_0
    //   86: astore 5
    //   88: aload_1
    //   89: astore_0
    //   90: aload 5
    //   92: astore_1
    //   93: aload_0
    //   94: ifnull +7 -> 101
    //   97: aload_0
    //   98: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   101: iload 4
    //   103: istore_3
    //   104: aload_1
    //   105: ifnull +10 -> 115
    //   108: aload_1
    //   109: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   112: iload 4
    //   114: istore_3
    //   115: iload_3
    //   116: ireturn
    //   117: iconst_1
    //   118: istore_3
    //   119: aload_1
    //   120: ifnull +7 -> 127
    //   123: aload_1
    //   124: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   127: aload_0
    //   128: ifnull -13 -> 115
    //   131: aload_0
    //   132: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   135: iconst_1
    //   136: ireturn
    //   137: astore_0
    //   138: iconst_1
    //   139: ireturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 7
    //   145: astore_0
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   154: iload 4
    //   156: istore_3
    //   157: aload_0
    //   158: ifnull -43 -> 115
    //   161: aload_0
    //   162: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   165: iconst_0
    //   166: ireturn
    //   167: astore_0
    //   168: iconst_0
    //   169: ireturn
    //   170: astore_0
    //   171: aconst_null
    //   172: astore_1
    //   173: aload_1
    //   174: ifnull +7 -> 181
    //   177: aload_1
    //   178: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 63	java/io/BufferedInputStream:close	()V
    //   191: aload_0
    //   192: athrow
    //   193: astore_1
    //   194: goto -67 -> 127
    //   197: astore_0
    //   198: goto -97 -> 101
    //   201: astore_0
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_1
    //   205: goto -51 -> 154
    //   208: astore_1
    //   209: goto -28 -> 181
    //   212: astore_1
    //   213: goto -22 -> 191
    //   216: astore_0
    //   217: goto -44 -> 173
    //   220: astore 6
    //   222: aload_0
    //   223: astore 5
    //   225: aload 6
    //   227: astore_0
    //   228: goto -55 -> 173
    //   231: astore_0
    //   232: aload 7
    //   234: astore_0
    //   235: goto -89 -> 146
    //   238: astore 5
    //   240: goto -94 -> 146
    //   243: astore_0
    //   244: aconst_null
    //   245: astore_0
    //   246: aload 6
    //   248: astore_1
    //   249: goto -156 -> 93
    //   252: astore_0
    //   253: aload_1
    //   254: astore_0
    //   255: aload 6
    //   257: astore_1
    //   258: goto -165 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramFile1	File
    //   0	261	1	paramFile2	File
    //   62	11	2	i	int
    //   103	54	3	bool1	boolean
    //   10	145	4	bool2	boolean
    //   4	66	5	arrayOfByte	byte[]
    //   83	1	5	localIOException	IOException
    //   86	138	5	localFile	File
    //   238	1	5	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   7	1	6	localObject1	Object
    //   220	36	6	localObject2	Object
    //   1	232	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   49	56	83	java/io/IOException
    //   56	63	83	java/io/IOException
    //   68	80	83	java/io/IOException
    //   131	135	137	java/io/IOException
    //   12	24	140	java/lang/OutOfMemoryError
    //   24	33	140	java/lang/OutOfMemoryError
    //   161	165	167	java/io/IOException
    //   12	24	170	finally
    //   24	33	170	finally
    //   123	127	193	java/io/IOException
    //   97	101	197	java/io/IOException
    //   108	112	201	java/io/IOException
    //   150	154	204	java/io/IOException
    //   177	181	208	java/io/IOException
    //   186	191	212	java/io/IOException
    //   33	49	216	finally
    //   49	56	220	finally
    //   56	63	220	finally
    //   68	80	220	finally
    //   33	49	231	java/lang/OutOfMemoryError
    //   49	56	238	java/lang/OutOfMemoryError
    //   56	63	238	java/lang/OutOfMemoryError
    //   68	80	238	java/lang/OutOfMemoryError
    //   12	24	243	java/io/IOException
    //   24	33	243	java/io/IOException
    //   33	49	252	java/io/IOException
  }
  
  public static boolean copyFile(String paramString1, String paramString2)
  {
    boolean bool = false;
    paramString1 = new File(paramString1);
    if (paramString1.exists()) {}
    try
    {
      bool = copyFile(paramString1, createFile(paramString2));
      return bool;
    }
    catch (IOException paramString1) {}
    return false;
  }
  
  public static File createFile(String paramString)
  {
    paramString = new File(paramString);
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
      File[] arrayOfFile;
      do
      {
        do
        {
          return;
          paramString = new File(paramString);
        } while ((paramString == null) || (!paramString.exists()));
        if (paramString.isFile())
        {
          paramString.delete();
          return;
        }
        arrayOfFile = paramString.listFiles();
      } while (arrayOfFile == null);
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        delete(arrayOfFile[i].getAbsolutePath(), paramBoolean);
        i += 1;
      }
    } while (paramBoolean);
    paramString.delete();
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
    boolean bool = true;
    paramString = new File(paramString);
    if (paramString.exists()) {
      bool = paramString.delete();
    }
    return bool;
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
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 38	java/io/File:exists	()Z
    //   16: ifeq +81 -> 97
    //   19: aload_0
    //   20: invokevirtual 102	java/io/File:isDirectory	()Z
    //   23: ifeq +35 -> 58
    //   26: new 30	java/io/IOException
    //   29: dup
    //   30: new 121	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   37: ldc 124
    //   39: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc 133
    //   48: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   57: athrow
    //   58: aload_0
    //   59: invokevirtual 140	java/io/File:canRead	()Z
    //   62: ifne +67 -> 129
    //   65: new 30	java/io/IOException
    //   68: dup
    //   69: new 121	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   76: ldc 124
    //   78: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_0
    //   82: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: ldc 142
    //   87: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 137	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   96: athrow
    //   97: new 144	java/io/FileNotFoundException
    //   100: dup
    //   101: new 121	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   108: ldc 124
    //   110: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   117: ldc 146
    //   119: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 147	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   128: athrow
    //   129: new 50	java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: new 149	java/io/InputStreamReader
    //   141: dup
    //   142: aload_3
    //   143: ldc 151
    //   145: invokespecial 154	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 158	java/io/File:length	()J
    //   153: l2i
    //   154: istore_1
    //   155: iload_1
    //   156: sipush 12288
    //   159: if_icmple +100 -> 259
    //   162: sipush 4096
    //   165: newarray char
    //   167: astore_0
    //   168: new 121	java/lang/StringBuilder
    //   171: dup
    //   172: sipush 12288
    //   175: invokespecial 161	java/lang/StringBuilder:<init>	(I)V
    //   178: astore 5
    //   180: aload_2
    //   181: aload_0
    //   182: invokevirtual 164	java/io/InputStreamReader:read	([C)I
    //   185: istore_1
    //   186: iconst_m1
    //   187: iload_1
    //   188: if_icmpeq +42 -> 230
    //   191: aload 5
    //   193: aload_0
    //   194: iconst_0
    //   195: iload_1
    //   196: invokevirtual 167	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -20 -> 180
    //   203: astore_0
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 168	java/io/InputStream:close	()V
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: ifnull -208 -> 10
    //   221: aload_0
    //   222: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: areturn
    //   230: aload 5
    //   232: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore_0
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 168	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: astore_3
    //   246: aload_2
    //   247: ifnull -237 -> 10
    //   250: aload_2
    //   251: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   254: aload_0
    //   255: areturn
    //   256: astore_2
    //   257: aload_0
    //   258: areturn
    //   259: iload_1
    //   260: newarray char
    //   262: astore_0
    //   263: new 171	java/lang/String
    //   266: dup
    //   267: aload_0
    //   268: iconst_0
    //   269: aload_2
    //   270: aload_0
    //   271: invokevirtual 164	java/io/InputStreamReader:read	([C)I
    //   274: invokespecial 174	java/lang/String:<init>	([CII)V
    //   277: astore_0
    //   278: goto -42 -> 236
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 168	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 169	java/io/InputStreamReader:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_3
    //   305: goto -61 -> 244
    //   308: astore_2
    //   309: goto -95 -> 214
    //   312: astore_3
    //   313: goto -19 -> 294
    //   316: astore_2
    //   317: goto -15 -> 302
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_2
    //   323: goto -37 -> 286
    //   326: astore_0
    //   327: goto -41 -> 286
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_3
    //   335: goto -129 -> 206
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -135 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramFile	File
    //   154	106	1	i	int
    //   148	103	2	localInputStreamReader	java.io.InputStreamReader
    //   256	14	2	localException1	java.lang.Exception
    //   285	14	2	localObject1	Object
    //   308	1	2	localException2	java.lang.Exception
    //   316	1	2	localException3	java.lang.Exception
    //   322	1	2	localObject2	Object
    //   9	282	3	localObject3	Object
    //   304	1	3	localException4	java.lang.Exception
    //   312	1	3	localException5	java.lang.Exception
    //   334	1	3	localObject4	Object
    //   1	214	4	localObject5	Object
    //   178	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	155	203	java/lang/Exception
    //   162	180	203	java/lang/Exception
    //   180	186	203	java/lang/Exception
    //   191	200	203	java/lang/Exception
    //   230	236	203	java/lang/Exception
    //   259	278	203	java/lang/Exception
    //   221	225	227	java/lang/Exception
    //   250	254	256	java/lang/Exception
    //   129	138	281	finally
    //   240	244	304	java/lang/Exception
    //   210	214	308	java/lang/Exception
    //   290	294	312	java/lang/Exception
    //   298	302	316	java/lang/Exception
    //   138	149	320	finally
    //   149	155	326	finally
    //   162	180	326	finally
    //   180	186	326	finally
    //   191	200	326	finally
    //   230	236	326	finally
    //   259	278	326	finally
    //   129	138	330	java/lang/Exception
    //   138	149	338	java/lang/Exception
  }
  
  public static boolean rename(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    do
    {
      return false;
      paramString1 = new File(paramString1);
    } while (!paramString1.exists());
    return paramString1.renameTo(new File(paramString2));
  }
  
  public static boolean writeFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
      bool1 = bool2;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          label39:
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
      break label39;
    }
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      for (;;)
      {
        bool1 = false;
      }
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
    //   0: iconst_0
    //   1: istore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 34	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_0
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
    //   67: ifnull +7 -> 74
    //   70: aload_0
    //   71: invokevirtual 62	java/io/FileOutputStream:close	()V
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
    //   89: invokevirtual 62	java/io/FileOutputStream:close	()V
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
    //   106: invokevirtual 62	java/io/FileOutputStream:close	()V
    //   109: aload_0
    //   110: athrow
    //   111: astore_0
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_1
    //   115: goto -6 -> 109
    //   118: astore 5
    //   120: aload_0
    //   121: astore_1
    //   122: aload 5
    //   124: astore_0
    //   125: goto -24 -> 101
    //   128: astore_1
    //   129: goto -48 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramString	String
    //   0	132	1	paramArrayOfByte	byte[]
    //   0	132	2	paramBoolean	boolean
    //   0	132	3	paramInt	int
    //   1	81	4	bool	boolean
    //   4	95	5	localObject1	Object
    //   118	5	5	localObject2	Object
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
    //   55	66	128	java/io/IOException
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
    //   6: new 34	java/io/File
    //   9: dup
    //   10: aload_1
    //   11: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_1
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
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 62	java/io/FileOutputStream:close	()V
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
    //   89: invokevirtual 62	java/io/FileOutputStream:close	()V
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
    //   106: invokevirtual 62	java/io/FileOutputStream:close	()V
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
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.utils.FileUtils
 * JD-Core Version:    0.7.0.1
 */