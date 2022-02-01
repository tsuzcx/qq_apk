package com.tencent.qphone.base.util.log.utils;

public class FileUtil
{
  private static final String TAG = "FileUtil";
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<com.tencent.qphone.base.util.QLog.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 19	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 21	java/io/FileOutputStream
    //   7: dup
    //   8: new 23	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 29	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 32	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 34	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 35	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 12
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 41	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface 47 1 0
    //   46: ifeq +256 -> 302
    //   49: aload_0
    //   50: invokeinterface 51 1 0
    //   55: checkcast 53	com/tencent/qphone/base/util/QLog$LogFile
    //   58: astore 13
    //   60: aload 13
    //   62: invokevirtual 56	com/tencent/qphone/base/util/QLog$LogFile:exists	()Z
    //   65: ifeq +372 -> 437
    //   68: aload 12
    //   70: new 58	java/util/zip/ZipEntry
    //   73: dup
    //   74: new 60	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   81: aload 13
    //   83: invokevirtual 65	com/tencent/qphone/base/util/QLog$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 13
    //   91: getfield 72	com/tencent/qphone/base/util/QLog$LogFile:stuffix	Ljava/lang/String;
    //   94: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 76	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 80	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 12
    //   108: bipush 9
    //   110: invokevirtual 84	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: aload 13
    //   115: invokevirtual 88	com/tencent/qphone/base/util/QLog$LogFile:length	()J
    //   118: lstore 9
    //   120: new 90	java/io/FileInputStream
    //   123: dup
    //   124: aload 13
    //   126: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 13
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 14
    //   138: lconst_0
    //   139: lstore 5
    //   141: aload 13
    //   143: aload 14
    //   145: iconst_0
    //   146: sipush 20480
    //   149: invokevirtual 95	java/io/FileInputStream:read	([BII)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpeq +39 -> 196
    //   160: aload 12
    //   162: aload 14
    //   164: iconst_0
    //   165: iload 4
    //   167: invokevirtual 99	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: iconst_1
    //   171: istore_3
    //   172: iconst_1
    //   173: istore_2
    //   174: lload 5
    //   176: iload 4
    //   178: i2l
    //   179: ladd
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore 5
    //   186: lload 7
    //   188: lload 9
    //   190: lcmp
    //   191: iflt -50 -> 141
    //   194: iload_3
    //   195: istore_2
    //   196: aload 13
    //   198: invokevirtual 102	java/io/FileInputStream:close	()V
    //   201: aload 12
    //   203: invokevirtual 105	java/util/zip/ZipOutputStream:flush	()V
    //   206: aload 12
    //   208: invokevirtual 108	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto +226 -> 437
    //   214: astore_0
    //   215: aload 13
    //   217: invokevirtual 102	java/io/FileInputStream:close	()V
    //   220: aload 12
    //   222: invokevirtual 105	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 12
    //   227: invokevirtual 108	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: aload_0
    //   234: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   237: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   240: ifeq +29 -> 269
    //   243: ldc 8
    //   245: iconst_2
    //   246: new 60	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   253: ldc 118
    //   255: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_0
    //   259: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: aload_0
    //   266: invokestatic 125	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: aload_1
    //   270: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   273: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +11 -> 287
    //   279: ldc 8
    //   281: iconst_2
    //   282: ldc 128
    //   284: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +11 -> 301
    //   293: ldc 8
    //   295: iconst_2
    //   296: ldc 134
    //   298: invokestatic 136	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   301: return
    //   302: iload_2
    //   303: ifeq +8 -> 311
    //   306: aload 12
    //   308: invokevirtual 137	java/util/zip/ZipOutputStream:close	()V
    //   311: new 23	java/io/File
    //   314: dup
    //   315: invokestatic 140	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   318: ldc 142
    //   320: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: astore_0
    //   324: aload_0
    //   325: ifnull +48 -> 373
    //   328: aload_0
    //   329: invokevirtual 146	java/io/File:exists	()Z
    //   332: ifeq +41 -> 373
    //   335: aload_0
    //   336: invokevirtual 149	java/io/File:delete	()Z
    //   339: istore 11
    //   341: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +29 -> 373
    //   347: ldc 8
    //   349: iconst_2
    //   350: new 60	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   357: ldc 151
    //   359: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload 11
    //   364: invokevirtual 154	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   367: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   376: ifeq +11 -> 387
    //   379: ldc 8
    //   381: iconst_2
    //   382: ldc 156
    //   384: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   387: aload_1
    //   388: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   391: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq -107 -> 287
    //   397: ldc 8
    //   399: iconst_2
    //   400: ldc 128
    //   402: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: goto -118 -> 287
    //   408: astore_0
    //   409: aload_0
    //   410: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   413: goto -126 -> 287
    //   416: astore_0
    //   417: aload_1
    //   418: invokevirtual 126	java/io/BufferedOutputStream:close	()V
    //   421: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +11 -> 435
    //   427: ldc 8
    //   429: iconst_2
    //   430: ldc 128
    //   432: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   435: aload_0
    //   436: athrow
    //   437: goto -397 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	440	0	paramArrayList	java.util.ArrayList<com.tencent.qphone.base.util.QLog.LogFile>
    //   0	440	1	paramString	String
    //   34	269	2	i	int
    //   171	24	3	j	int
    //   152	25	4	k	int
    //   139	46	5	l1	long
    //   180	7	7	l2	long
    //   118	71	9	l3	long
    //   339	24	11	bool	boolean
    //   31	276	12	localZipOutputStream	java.util.zip.ZipOutputStream
    //   58	158	13	localObject	Object
    //   136	27	14	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	138	214	finally
    //   141	154	214	finally
    //   160	170	214	finally
    //   35	40	232	java/io/IOException
    //   40	131	232	java/io/IOException
    //   196	211	232	java/io/IOException
    //   215	232	232	java/io/IOException
    //   306	311	232	java/io/IOException
    //   311	324	232	java/io/IOException
    //   328	373	232	java/io/IOException
    //   373	387	232	java/io/IOException
    //   0	33	408	java/io/IOException
    //   269	287	408	java/io/IOException
    //   387	405	408	java/io/IOException
    //   417	435	408	java/io/IOException
    //   435	437	408	java/io/IOException
    //   35	40	416	finally
    //   40	131	416	finally
    //   196	211	416	finally
    //   215	232	416	finally
    //   233	269	416	finally
    //   306	311	416	finally
    //   311	324	416	finally
    //   328	373	416	finally
    //   373	387	416	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */