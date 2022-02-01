package com.tencent.mobileqq.qshadow.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class FileUtil
{
  private static final int BUFFER_SIZE = 2048;
  private static final String TAG = "FileUtil";
  
  public static void cleanDirectory(File paramFile)
  {
    File[] arrayOfFile = verifiedListFiles(paramFile);
    int j = arrayOfFile.length;
    paramFile = null;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j) {
        localFile = arrayOfFile[i];
      }
      try
      {
        forceDelete(localFile);
        label27:
        i += 1;
        continue;
        if (paramFile != null) {
          throw paramFile;
        }
      }
      catch (IOException paramFile)
      {
        break label27;
      }
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: aload_1
    //   13: invokevirtual 37	java/io/File:exists	()Z
    //   16: ifne +5 -> 21
    //   19: iconst_0
    //   20: ireturn
    //   21: aload_0
    //   22: invokevirtual 37	java/io/File:exists	()Z
    //   25: ifeq +317 -> 342
    //   28: aload_0
    //   29: invokevirtual 40	java/io/File:delete	()Z
    //   32: istore_3
    //   33: iload_3
    //   34: ifeq -15 -> 19
    //   37: aload_0
    //   38: invokevirtual 43	java/io/File:createNewFile	()Z
    //   41: istore_3
    //   42: iload_3
    //   43: ifeq -24 -> 19
    //   46: sipush 2048
    //   49: newarray byte
    //   51: astore 8
    //   53: new 45	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: astore_1
    //   62: aload 7
    //   64: astore 4
    //   66: aload_1
    //   67: astore 5
    //   69: new 49	java/io/FileOutputStream
    //   72: dup
    //   73: aload_0
    //   74: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   77: astore_0
    //   78: aload_1
    //   79: aload 8
    //   81: iconst_0
    //   82: sipush 2048
    //   85: invokevirtual 54	java/io/FileInputStream:read	([BII)I
    //   88: istore_2
    //   89: iload_2
    //   90: iconst_m1
    //   91: if_icmpeq +49 -> 140
    //   94: aload_0
    //   95: aload 8
    //   97: iconst_0
    //   98: iload_2
    //   99: invokevirtual 58	java/io/FileOutputStream:write	([BII)V
    //   102: goto -24 -> 78
    //   105: astore 4
    //   107: aload 4
    //   109: invokevirtual 61	java/io/FileNotFoundException:printStackTrace	()V
    //   112: aload_1
    //   113: ifnull +7 -> 120
    //   116: aload_1
    //   117: invokevirtual 64	java/io/FileInputStream:close	()V
    //   120: aload_0
    //   121: ifnull +7 -> 128
    //   124: aload_0
    //   125: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   128: iconst_1
    //   129: ireturn
    //   130: astore 8
    //   132: aload 8
    //   134: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   137: goto -91 -> 46
    //   140: aload_1
    //   141: ifnull +7 -> 148
    //   144: aload_1
    //   145: invokevirtual 64	java/io/FileInputStream:close	()V
    //   148: aload_0
    //   149: ifnull -21 -> 128
    //   152: aload_0
    //   153: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   156: goto -28 -> 128
    //   159: astore_0
    //   160: aload_0
    //   161: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   164: goto -36 -> 128
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   172: goto -24 -> 148
    //   175: astore_1
    //   176: aload_1
    //   177: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   180: goto -60 -> 120
    //   183: astore_0
    //   184: aload_0
    //   185: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   188: goto -60 -> 128
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload 6
    //   196: astore 4
    //   198: aload_1
    //   199: astore 5
    //   201: aload_0
    //   202: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   205: aload_1
    //   206: ifnull +7 -> 213
    //   209: aload_1
    //   210: invokevirtual 64	java/io/FileInputStream:close	()V
    //   213: aload 6
    //   215: ifnull -87 -> 128
    //   218: aload 6
    //   220: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   223: goto -95 -> 128
    //   226: astore_0
    //   227: aload_0
    //   228: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   231: goto -103 -> 128
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   239: goto -26 -> 213
    //   242: astore_0
    //   243: aconst_null
    //   244: astore_1
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 64	java/io/FileInputStream:close	()V
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   263: aload_0
    //   264: athrow
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   270: goto -17 -> 253
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   278: goto -15 -> 263
    //   281: astore_0
    //   282: aload 5
    //   284: astore_1
    //   285: goto -40 -> 245
    //   288: astore 5
    //   290: aload_0
    //   291: astore 4
    //   293: aload 5
    //   295: astore_0
    //   296: goto -51 -> 245
    //   299: astore 5
    //   301: aload_0
    //   302: astore 4
    //   304: aload 5
    //   306: astore_0
    //   307: goto -62 -> 245
    //   310: astore_0
    //   311: goto -117 -> 194
    //   314: astore 4
    //   316: aload_0
    //   317: astore 6
    //   319: aload 4
    //   321: astore_0
    //   322: goto -128 -> 194
    //   325: astore 4
    //   327: aconst_null
    //   328: astore_0
    //   329: aload 5
    //   331: astore_1
    //   332: goto -225 -> 107
    //   335: astore 4
    //   337: aconst_null
    //   338: astore_0
    //   339: goto -232 -> 107
    //   342: iconst_1
    //   343: istore_3
    //   344: goto -311 -> 33
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	347	0	paramFile1	File
    //   0	347	1	paramFile2	File
    //   88	11	2	i	int
    //   32	312	3	bool	boolean
    //   4	61	4	localObject1	Object
    //   105	3	4	localFileNotFoundException1	FileNotFoundException
    //   196	107	4	localFile1	File
    //   314	6	4	localIOException1	IOException
    //   325	1	4	localFileNotFoundException2	FileNotFoundException
    //   335	1	4	localFileNotFoundException3	FileNotFoundException
    //   10	273	5	localFile2	File
    //   288	6	5	localObject2	Object
    //   299	31	5	localObject3	Object
    //   1	317	6	localFile3	File
    //   7	56	7	localObject4	Object
    //   51	45	8	arrayOfByte	byte[]
    //   130	3	8	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   78	89	105	java/io/FileNotFoundException
    //   94	102	105	java/io/FileNotFoundException
    //   37	42	130	java/io/IOException
    //   152	156	159	java/io/IOException
    //   144	148	167	java/io/IOException
    //   116	120	175	java/io/IOException
    //   124	128	183	java/io/IOException
    //   53	62	191	java/io/IOException
    //   218	223	226	java/io/IOException
    //   209	213	234	java/io/IOException
    //   53	62	242	finally
    //   249	253	265	java/io/IOException
    //   258	263	273	java/io/IOException
    //   69	78	281	finally
    //   201	205	281	finally
    //   78	89	288	finally
    //   94	102	288	finally
    //   107	112	299	finally
    //   69	78	310	java/io/IOException
    //   78	89	314	java/io/IOException
    //   94	102	314	java/io/IOException
    //   53	62	325	java/io/FileNotFoundException
    //   69	78	335	java/io/FileNotFoundException
  }
  
  /* Error */
  public static void copyFileUsingFileStreams(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 45	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 47	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 49	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 50	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: sipush 1024
    //   23: newarray byte
    //   25: astore_3
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 73	java/io/InputStream:read	([B)I
    //   31: istore_2
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpeq +30 -> 64
    //   37: aload_1
    //   38: aload_3
    //   39: iconst_0
    //   40: iload_2
    //   41: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   44: goto -18 -> 26
    //   47: astore 4
    //   49: aload_0
    //   50: astore_3
    //   51: aload 4
    //   53: astore_0
    //   54: aload_3
    //   55: invokevirtual 77	java/io/InputStream:close	()V
    //   58: aload_1
    //   59: invokevirtual 78	java/io/OutputStream:close	()V
    //   62: aload_0
    //   63: athrow
    //   64: aload_0
    //   65: invokevirtual 77	java/io/InputStream:close	()V
    //   68: aload_1
    //   69: invokevirtual 78	java/io/OutputStream:close	()V
    //   72: return
    //   73: astore_0
    //   74: aconst_null
    //   75: astore_1
    //   76: goto -22 -> 54
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_0
    //   84: astore_3
    //   85: aload 4
    //   87: astore_0
    //   88: goto -34 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramFile1	File
    //   0	91	1	paramFile2	File
    //   31	10	2	i	int
    //   1	84	3	localObject1	Object
    //   47	5	4	localObject2	Object
    //   79	7	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	47	finally
    //   26	32	47	finally
    //   37	44	47	finally
    //   2	11	73	finally
    //   11	20	79	finally
  }
  
  private static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {}
    do
    {
      return;
      cleanDirectory(paramFile);
    } while (paramFile.delete());
    throw new IOException("Unable to delete directory " + paramFile + ".");
  }
  
  private static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory()) {
      deleteDirectory(paramFile);
    }
    boolean bool;
    do
    {
      return;
      bool = paramFile.exists();
    } while (paramFile.delete());
    if (!bool) {
      throw new FileNotFoundException("File does not exist: " + paramFile);
    }
    throw new IOException("Unable to delete file: " + paramFile);
  }
  
  public static boolean moveFile(File paramFile1, File paramFile2)
  {
    if (!copyFile(paramFile1, paramFile2)) {}
    while (!paramFile2.delete()) {
      return false;
    }
    return true;
  }
  
  /* Error */
  public static void unZipFolder(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 33	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: new 120	com/tencent/mobileqq/qshadow/utils/SafeZipFile
    //   12: dup
    //   13: new 33	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 121	com/tencent/mobileqq/qshadow/utils/SafeZipFile:<init>	(Ljava/io/File;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokevirtual 125	com/tencent/mobileqq/qshadow/utils/SafeZipFile:entries	()Ljava/util/Enumeration;
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface 130 1 0
    //   36: ifeq +56 -> 92
    //   39: aload_0
    //   40: invokeinterface 134 1 0
    //   45: checkcast 136	java/util/zip/ZipEntry
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 139	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 141
    //   55: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifne -28 -> 30
    //   61: aload_3
    //   62: invokevirtual 148	java/util/zip/ZipEntry:isDirectory	()Z
    //   65: ifne -35 -> 30
    //   68: aload_1
    //   69: aload_3
    //   70: aload_2
    //   71: aload_3
    //   72: invokevirtual 139	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   75: invokestatic 152	com/tencent/mobileqq/qshadow/utils/FileUtil:writeOutZipEntry	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;)V
    //   78: goto -48 -> 30
    //   81: astore_0
    //   82: aload_1
    //   83: ifnull +7 -> 90
    //   86: aload_1
    //   87: invokevirtual 153	com/tencent/mobileqq/qshadow/utils/SafeZipFile:close	()V
    //   90: aload_0
    //   91: athrow
    //   92: aload_1
    //   93: ifnull +7 -> 100
    //   96: aload_1
    //   97: invokevirtual 153	com/tencent/mobileqq/qshadow/utils/SafeZipFile:close	()V
    //   100: return
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   106: return
    //   107: astore_1
    //   108: aload_1
    //   109: invokevirtual 66	java/io/IOException:printStackTrace	()V
    //   112: goto -22 -> 90
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_1
    //   118: goto -36 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	121	0	paramString1	String
    //   0	121	1	paramString2	String
    //   8	63	2	localFile	File
    //   48	24	3	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   25	30	81	finally
    //   30	78	81	finally
    //   96	100	101	java/io/IOException
    //   86	90	107	java/io/IOException
    //   9	25	115	finally
  }
  
  private static File[] verifiedListFiles(File paramFile)
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    return arrayOfFile;
  }
  
  private static void writeOutInputStream(File paramFile, String paramString, InputStream paramInputStream)
  {
    try
    {
      paramString = new BufferedOutputStream(new FileOutputStream(new File(paramFile, paramString)));
      try
      {
        paramFile = new BufferedInputStream(paramInputStream);
        paramInputStream = new byte[8192];
        for (;;)
        {
          int i = paramFile.read(paramInputStream, 0, 8192);
          if (i < 0) {
            break;
          }
          paramString.write(paramInputStream, 0, i);
        }
        if (paramString == null) {
          break label72;
        }
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        label72:
        paramString = null;
      }
    }
    paramString.close();
    throw paramFile;
    if (paramString != null) {
      paramString.close();
    }
  }
  
  private static void writeOutZipEntry(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    ZipFile localZipFile = null;
    try
    {
      paramZipFile = paramZipFile.getInputStream(paramZipEntry);
      localZipFile = paramZipFile;
      writeOutInputStream(paramFile, paramString, paramZipFile);
      return;
    }
    finally
    {
      if (localZipFile != null) {
        localZipFile.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */