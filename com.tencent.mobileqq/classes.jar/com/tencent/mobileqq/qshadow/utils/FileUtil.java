package com.tencent.mobileqq.qshadow.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    while (i < j)
    {
      File localFile = arrayOfFile[i];
      try
      {
        forceDelete(localFile);
      }
      catch (IOException paramFile) {}
      i += 1;
    }
    if (paramFile == null) {
      return;
    }
    for (;;)
    {
      throw paramFile;
    }
  }
  
  /* Error */
  public static boolean copyFile(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 37	java/io/File:exists	()Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: invokevirtual 37	java/io/File:exists	()Z
    //   13: ifeq +11 -> 24
    //   16: aload_0
    //   17: invokevirtual 40	java/io/File:delete	()Z
    //   20: istore_3
    //   21: goto +5 -> 26
    //   24: iconst_1
    //   25: istore_3
    //   26: iload_3
    //   27: ifne +5 -> 32
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 43	java/io/File:createNewFile	()Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifne +12 -> 50
    //   41: iconst_0
    //   42: ireturn
    //   43: astore 4
    //   45: aload 4
    //   47: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   50: sipush 2048
    //   53: newarray byte
    //   55: astore 6
    //   57: aconst_null
    //   58: astore 7
    //   60: aconst_null
    //   61: astore 4
    //   63: aconst_null
    //   64: astore 5
    //   66: new 48	java/io/FileInputStream
    //   69: dup
    //   70: aload_1
    //   71: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   74: astore_1
    //   75: new 52	java/io/FileOutputStream
    //   78: dup
    //   79: aload_0
    //   80: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   83: astore_0
    //   84: aload_1
    //   85: aload 6
    //   87: iconst_0
    //   88: sipush 2048
    //   91: invokevirtual 57	java/io/FileInputStream:read	([BII)I
    //   94: istore_2
    //   95: iload_2
    //   96: iconst_m1
    //   97: if_icmpeq +14 -> 111
    //   100: aload_0
    //   101: aload 6
    //   103: iconst_0
    //   104: iload_2
    //   105: invokevirtual 61	java/io/FileOutputStream:write	([BII)V
    //   108: goto -24 -> 84
    //   111: aload_1
    //   112: invokevirtual 64	java/io/FileInputStream:close	()V
    //   115: goto +8 -> 123
    //   118: astore_1
    //   119: aload_1
    //   120: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   123: aload_0
    //   124: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   127: iconst_1
    //   128: ireturn
    //   129: astore 5
    //   131: goto +17 -> 148
    //   134: astore 4
    //   136: goto +28 -> 164
    //   139: astore 4
    //   141: goto +40 -> 181
    //   144: astore 5
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_1
    //   149: astore 4
    //   151: aload 5
    //   153: astore_1
    //   154: aload_0
    //   155: astore 5
    //   157: goto +158 -> 315
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_0
    //   164: aload_1
    //   165: astore 5
    //   167: aload 4
    //   169: astore 6
    //   171: aload_0
    //   172: astore 4
    //   174: goto +32 -> 206
    //   177: astore 4
    //   179: aconst_null
    //   180: astore_0
    //   181: aload_1
    //   182: astore 5
    //   184: aload 4
    //   186: astore 6
    //   188: aload_0
    //   189: astore 4
    //   191: goto +65 -> 256
    //   194: astore_1
    //   195: aconst_null
    //   196: astore 5
    //   198: goto +117 -> 315
    //   201: astore 6
    //   203: aconst_null
    //   204: astore 4
    //   206: aload 5
    //   208: astore_0
    //   209: aload 4
    //   211: astore_1
    //   212: aload 6
    //   214: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   217: aload 5
    //   219: ifnull +16 -> 235
    //   222: aload 5
    //   224: invokevirtual 64	java/io/FileInputStream:close	()V
    //   227: goto +8 -> 235
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   235: aload 4
    //   237: ifnull +65 -> 302
    //   240: aload 4
    //   242: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   245: iconst_1
    //   246: ireturn
    //   247: astore 6
    //   249: aconst_null
    //   250: astore 4
    //   252: aload 7
    //   254: astore 5
    //   256: aload 5
    //   258: astore_0
    //   259: aload 4
    //   261: astore_1
    //   262: aload 6
    //   264: invokevirtual 66	java/io/FileNotFoundException:printStackTrace	()V
    //   267: aload 5
    //   269: ifnull +16 -> 285
    //   272: aload 5
    //   274: invokevirtual 64	java/io/FileInputStream:close	()V
    //   277: goto +8 -> 285
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   285: aload 4
    //   287: ifnull +15 -> 302
    //   290: aload 4
    //   292: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   295: iconst_1
    //   296: ireturn
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   302: iconst_1
    //   303: ireturn
    //   304: astore 4
    //   306: aload_1
    //   307: astore 5
    //   309: aload 4
    //   311: astore_1
    //   312: aload_0
    //   313: astore 4
    //   315: aload 4
    //   317: ifnull +16 -> 333
    //   320: aload 4
    //   322: invokevirtual 64	java/io/FileInputStream:close	()V
    //   325: goto +8 -> 333
    //   328: astore_0
    //   329: aload_0
    //   330: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   333: aload 5
    //   335: ifnull +16 -> 351
    //   338: aload 5
    //   340: invokevirtual 65	java/io/FileOutputStream:close	()V
    //   343: goto +8 -> 351
    //   346: astore_0
    //   347: aload_0
    //   348: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   351: goto +5 -> 356
    //   354: aload_1
    //   355: athrow
    //   356: goto -2 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	359	0	paramFile1	File
    //   0	359	1	paramFile2	File
    //   94	11	2	i	int
    //   20	18	3	bool	boolean
    //   43	3	4	localIOException1	IOException
    //   61	1	4	localObject1	Object
    //   134	1	4	localIOException2	IOException
    //   139	1	4	localFileNotFoundException1	FileNotFoundException
    //   149	1	4	localFile1	File
    //   160	8	4	localIOException3	IOException
    //   172	1	4	localFile2	File
    //   177	8	4	localFileNotFoundException2	FileNotFoundException
    //   189	102	4	localFile3	File
    //   304	6	4	localObject2	Object
    //   313	8	4	localFile4	File
    //   64	1	5	localObject3	Object
    //   129	1	5	localObject4	Object
    //   144	8	5	localObject5	Object
    //   155	184	5	localObject6	Object
    //   55	132	6	localObject7	Object
    //   201	12	6	localIOException4	IOException
    //   247	16	6	localFileNotFoundException3	FileNotFoundException
    //   58	195	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   32	37	43	java/io/IOException
    //   111	115	118	java/io/IOException
    //   84	95	129	finally
    //   100	108	129	finally
    //   84	95	134	java/io/IOException
    //   100	108	134	java/io/IOException
    //   84	95	139	java/io/FileNotFoundException
    //   100	108	139	java/io/FileNotFoundException
    //   75	84	144	finally
    //   75	84	160	java/io/IOException
    //   75	84	177	java/io/FileNotFoundException
    //   66	75	194	finally
    //   66	75	201	java/io/IOException
    //   222	227	230	java/io/IOException
    //   66	75	247	java/io/FileNotFoundException
    //   272	277	280	java/io/IOException
    //   123	127	297	java/io/IOException
    //   240	245	297	java/io/IOException
    //   290	295	297	java/io/IOException
    //   212	217	304	finally
    //   262	267	304	finally
    //   320	325	328	java/io/IOException
    //   338	343	346	java/io/IOException
  }
  
  /* Error */
  public static void copyFileUsingFileStreams(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 48	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore_3
    //   12: new 52	java/io/FileOutputStream
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   20: astore_1
    //   21: sipush 1024
    //   24: newarray byte
    //   26: astore_0
    //   27: aload_3
    //   28: aload_0
    //   29: invokevirtual 73	java/io/InputStream:read	([B)I
    //   32: istore_2
    //   33: iload_2
    //   34: iconst_m1
    //   35: if_icmpeq +13 -> 48
    //   38: aload_1
    //   39: aload_0
    //   40: iconst_0
    //   41: iload_2
    //   42: invokevirtual 76	java/io/OutputStream:write	([BII)V
    //   45: goto -18 -> 27
    //   48: aload_3
    //   49: invokevirtual 77	java/io/InputStream:close	()V
    //   52: aload_1
    //   53: invokevirtual 78	java/io/OutputStream:close	()V
    //   56: return
    //   57: astore_0
    //   58: goto +16 -> 74
    //   61: astore_0
    //   62: aload 4
    //   64: astore_1
    //   65: goto +9 -> 74
    //   68: astore_0
    //   69: aconst_null
    //   70: astore_3
    //   71: aload 4
    //   73: astore_1
    //   74: aload_3
    //   75: invokevirtual 77	java/io/InputStream:close	()V
    //   78: aload_1
    //   79: invokevirtual 78	java/io/OutputStream:close	()V
    //   82: goto +5 -> 87
    //   85: aload_0
    //   86: athrow
    //   87: goto -2 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile1	File
    //   0	90	1	paramFile2	File
    //   32	10	2	i	int
    //   11	64	3	localFileInputStream	java.io.FileInputStream
    //   1	71	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	57	finally
    //   27	33	57	finally
    //   38	45	57	finally
    //   12	21	61	finally
    //   3	12	68	finally
  }
  
  private static void deleteDirectory(File paramFile)
  {
    if (!paramFile.exists()) {
      return;
    }
    cleanDirectory(paramFile);
    if (paramFile.delete()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unable to delete directory ");
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".");
    throw new IOException(localStringBuilder.toString());
  }
  
  private static void forceDelete(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      deleteDirectory(paramFile);
      return;
    }
    boolean bool = paramFile.exists();
    if (!paramFile.delete())
    {
      if (!bool)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("File does not exist: ");
        localStringBuilder.append(paramFile);
        throw new FileNotFoundException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to delete file: ");
      localStringBuilder.append(paramFile);
      throw new IOException(localStringBuilder.toString());
    }
  }
  
  public static boolean moveFile(File paramFile1, File paramFile2)
  {
    if (!copyFile(paramFile1, paramFile2)) {
      return false;
    }
    return paramFile2.delete();
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
    //   36: ifeq +48 -> 84
    //   39: aload_0
    //   40: invokeinterface 134 1 0
    //   45: checkcast 136	java/util/zip/ZipEntry
    //   48: astore_3
    //   49: aload_3
    //   50: invokevirtual 139	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   53: ldc 141
    //   55: invokevirtual 147	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   58: ifeq +6 -> 64
    //   61: goto -31 -> 30
    //   64: aload_3
    //   65: invokevirtual 148	java/util/zip/ZipEntry:isDirectory	()Z
    //   68: ifne -38 -> 30
    //   71: aload_1
    //   72: aload_3
    //   73: aload_2
    //   74: aload_3
    //   75: invokevirtual 139	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   78: invokestatic 152	com/tencent/mobileqq/qshadow/utils/FileUtil:writeOutZipEntry	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;Ljava/io/File;Ljava/lang/String;)V
    //   81: goto -51 -> 30
    //   84: aload_1
    //   85: invokevirtual 153	com/tencent/mobileqq/qshadow/utils/SafeZipFile:close	()V
    //   88: return
    //   89: astore_0
    //   90: aload_0
    //   91: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   94: return
    //   95: astore_0
    //   96: goto +6 -> 102
    //   99: astore_0
    //   100: aconst_null
    //   101: astore_1
    //   102: aload_1
    //   103: ifnull +15 -> 118
    //   106: aload_1
    //   107: invokevirtual 153	com/tencent/mobileqq/qshadow/utils/SafeZipFile:close	()V
    //   110: goto +8 -> 118
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual 46	java/io/IOException:printStackTrace	()V
    //   118: goto +5 -> 123
    //   121: aload_0
    //   122: athrow
    //   123: goto -2 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramString1	String
    //   0	126	1	paramString2	String
    //   8	66	2	localFile	File
    //   48	27	3	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   84	88	89	java/io/IOException
    //   25	30	95	finally
    //   30	61	95	finally
    //   64	81	95	finally
    //   9	25	99	finally
    //   106	110	113	java/io/IOException
  }
  
  private static File[] verifiedListFiles(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        localObject = paramFile.listFiles();
        if (localObject != null) {
          return localObject;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to list contents of ");
        ((StringBuilder)localObject).append(paramFile);
        throw new IOException(((StringBuilder)localObject).toString());
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFile);
      ((StringBuilder)localObject).append(" is not a directory");
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(" does not exist");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  /* Error */
  private static void writeOutInputStream(File paramFile, String paramString, java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 170	java/io/BufferedOutputStream
    //   6: dup
    //   7: new 52	java/io/FileOutputStream
    //   10: dup
    //   11: new 33	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: aload_1
    //   17: invokespecial 173	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   20: invokespecial 53	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   23: invokespecial 176	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   26: astore_0
    //   27: new 178	java/io/BufferedInputStream
    //   30: dup
    //   31: aload_2
    //   32: invokespecial 181	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   35: astore_1
    //   36: sipush 8192
    //   39: newarray byte
    //   41: astore_2
    //   42: aload_1
    //   43: aload_2
    //   44: iconst_0
    //   45: sipush 8192
    //   48: invokevirtual 182	java/io/BufferedInputStream:read	([BII)I
    //   51: istore_3
    //   52: iload_3
    //   53: iflt +13 -> 66
    //   56: aload_0
    //   57: aload_2
    //   58: iconst_0
    //   59: iload_3
    //   60: invokevirtual 183	java/io/BufferedOutputStream:write	([BII)V
    //   63: goto -21 -> 42
    //   66: aload_0
    //   67: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   70: return
    //   71: astore_1
    //   72: goto +7 -> 79
    //   75: astore_1
    //   76: aload 4
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 184	java/io/BufferedOutputStream:close	()V
    //   87: goto +5 -> 92
    //   90: aload_1
    //   91: athrow
    //   92: goto -2 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile	File
    //   0	95	1	paramString	String
    //   0	95	2	paramInputStream	java.io.InputStream
    //   51	9	3	i	int
    //   1	76	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   27	42	71	finally
    //   42	52	71	finally
    //   56	63	71	finally
    //   3	27	75	finally
  }
  
  /* Error */
  private static void writeOutZipEntry(java.util.zip.ZipFile paramZipFile, java.util.zip.ZipEntry paramZipEntry, File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 190	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_0
    //   6: aload_2
    //   7: aload_3
    //   8: aload_0
    //   9: invokestatic 192	com/tencent/mobileqq/qshadow/utils/FileUtil:writeOutInputStream	(Ljava/io/File;Ljava/lang/String;Ljava/io/InputStream;)V
    //   12: aload_0
    //   13: ifnull +7 -> 20
    //   16: aload_0
    //   17: invokevirtual 77	java/io/InputStream:close	()V
    //   20: return
    //   21: astore_1
    //   22: goto +6 -> 28
    //   25: astore_1
    //   26: aconst_null
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 77	java/io/InputStream:close	()V
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramZipFile	java.util.zip.ZipFile
    //   0	38	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	38	2	paramFile	File
    //   0	38	3	paramString	String
    // Exception table:
    //   from	to	target	type
    //   6	12	21	finally
    //   0	6	25	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */