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
    //   31: astore 9
    //   33: aload_0
    //   34: invokevirtual 41	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 47 1 0
    //   46: ifeq +196 -> 242
    //   49: aload_0
    //   50: invokeinterface 51 1 0
    //   55: checkcast 53	com/tencent/qphone/base/util/QLog$LogFile
    //   58: astore 10
    //   60: iload_2
    //   61: istore_3
    //   62: aload 10
    //   64: invokevirtual 56	com/tencent/qphone/base/util/QLog$LogFile:exists	()Z
    //   67: ifeq +387 -> 454
    //   70: new 58	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   77: astore 11
    //   79: aload 11
    //   81: aload 10
    //   83: invokevirtual 63	com/tencent/qphone/base/util/QLog$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 11
    //   92: aload 10
    //   94: getfield 70	com/tencent/qphone/base/util/QLog$LogFile:stuffix	Ljava/lang/String;
    //   97: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload 9
    //   103: new 72	java/util/zip/ZipEntry
    //   106: dup
    //   107: aload 11
    //   109: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokespecial 76	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   115: invokevirtual 80	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   118: aload 9
    //   120: bipush 9
    //   122: invokevirtual 84	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   125: aload 10
    //   127: invokevirtual 88	com/tencent/qphone/base/util/QLog$LogFile:length	()J
    //   130: lstore 6
    //   132: new 90	java/io/FileInputStream
    //   135: dup
    //   136: aload 10
    //   138: invokespecial 91	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   141: astore 10
    //   143: sipush 20480
    //   146: newarray byte
    //   148: astore 11
    //   150: lconst_0
    //   151: lstore 4
    //   153: aload 10
    //   155: aload 11
    //   157: iconst_0
    //   158: sipush 20480
    //   161: invokevirtual 95	java/io/FileInputStream:read	([BII)I
    //   164: istore_3
    //   165: iload_3
    //   166: iconst_m1
    //   167: if_icmpeq +37 -> 204
    //   170: aload 9
    //   172: aload 11
    //   174: iconst_0
    //   175: iload_3
    //   176: invokevirtual 99	java/util/zip/ZipOutputStream:write	([BII)V
    //   179: lload 4
    //   181: iload_3
    //   182: i2l
    //   183: ladd
    //   184: lstore 4
    //   186: lload 4
    //   188: lload 6
    //   190: lcmp
    //   191: iflt +8 -> 199
    //   194: iconst_1
    //   195: istore_2
    //   196: goto +8 -> 204
    //   199: iconst_1
    //   200: istore_2
    //   201: goto -48 -> 153
    //   204: aload 10
    //   206: invokevirtual 102	java/io/FileInputStream:close	()V
    //   209: aload 9
    //   211: invokevirtual 105	java/util/zip/ZipOutputStream:flush	()V
    //   214: aload 9
    //   216: invokevirtual 108	java/util/zip/ZipOutputStream:closeEntry	()V
    //   219: iload_2
    //   220: istore_3
    //   221: goto +233 -> 454
    //   224: astore_0
    //   225: aload 10
    //   227: invokevirtual 102	java/io/FileInputStream:close	()V
    //   230: aload 9
    //   232: invokevirtual 105	java/util/zip/ZipOutputStream:flush	()V
    //   235: aload 9
    //   237: invokevirtual 108	java/util/zip/ZipOutputStream:closeEntry	()V
    //   240: aload_0
    //   241: athrow
    //   242: iload_2
    //   243: ifeq +8 -> 251
    //   246: aload 9
    //   248: invokevirtual 109	java/util/zip/ZipOutputStream:close	()V
    //   251: new 23	java/io/File
    //   254: dup
    //   255: invokestatic 114	com/tencent/qphone/base/util/QLog:getLogPath	()Ljava/lang/String;
    //   258: ldc 116
    //   260: invokespecial 119	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 120	java/io/File:exists	()Z
    //   268: ifeq +47 -> 315
    //   271: aload_0
    //   272: invokevirtual 123	java/io/File:delete	()Z
    //   275: istore 8
    //   277: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   280: ifeq +35 -> 315
    //   283: new 58	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   290: astore_0
    //   291: aload_0
    //   292: ldc 128
    //   294: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload_0
    //   299: iload 8
    //   301: invokevirtual 131	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 8
    //   307: iconst_2
    //   308: aload_0
    //   309: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   318: ifeq +11 -> 329
    //   321: ldc 8
    //   323: iconst_2
    //   324: ldc 137
    //   326: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_1
    //   330: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   333: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +103 -> 439
    //   339: ldc 8
    //   341: iconst_2
    //   342: ldc 140
    //   344: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: goto +92 -> 439
    //   350: astore_0
    //   351: goto +63 -> 414
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   359: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +39 -> 401
    //   365: new 58	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   372: astore 9
    //   374: aload 9
    //   376: ldc 145
    //   378: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 9
    //   384: aload_0
    //   385: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: ldc 8
    //   391: iconst_2
    //   392: aload 9
    //   394: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: aload_0
    //   398: invokestatic 152	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   401: aload_1
    //   402: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   405: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   408: ifeq +31 -> 439
    //   411: goto -72 -> 339
    //   414: aload_1
    //   415: invokevirtual 138	java/io/BufferedOutputStream:close	()V
    //   418: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +11 -> 432
    //   424: ldc 8
    //   426: iconst_2
    //   427: ldc 140
    //   429: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_0
    //   433: athrow
    //   434: astore_0
    //   435: aload_0
    //   436: invokevirtual 143	java/io/IOException:printStackTrace	()V
    //   439: invokestatic 126	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +11 -> 453
    //   445: ldc 8
    //   447: iconst_2
    //   448: ldc 154
    //   450: invokestatic 156	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: return
    //   454: iload_3
    //   455: istore_2
    //   456: goto -416 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramArrayList	java.util.ArrayList<com.tencent.qphone.base.util.QLog.LogFile>
    //   0	459	1	paramString	String
    //   39	417	2	i	int
    //   61	394	3	j	int
    //   151	36	4	l1	long
    //   130	59	6	l2	long
    //   275	25	8	bool	boolean
    //   31	362	9	localObject1	Object
    //   58	168	10	localObject2	Object
    //   77	96	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   143	150	224	finally
    //   153	165	224	finally
    //   170	179	224	finally
    //   33	38	350	finally
    //   40	60	350	finally
    //   62	143	350	finally
    //   204	219	350	finally
    //   225	242	350	finally
    //   246	251	350	finally
    //   251	315	350	finally
    //   315	329	350	finally
    //   355	401	350	finally
    //   33	38	354	java/io/IOException
    //   40	60	354	java/io/IOException
    //   62	143	354	java/io/IOException
    //   204	219	354	java/io/IOException
    //   225	242	354	java/io/IOException
    //   246	251	354	java/io/IOException
    //   251	315	354	java/io/IOException
    //   315	329	354	java/io/IOException
    //   0	33	434	java/io/IOException
    //   329	339	434	java/io/IOException
    //   339	347	434	java/io/IOException
    //   401	411	434	java/io/IOException
    //   414	432	434	java/io/IOException
    //   432	434	434	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.log.utils.FileUtil
 * JD-Core Version:    0.7.0.1
 */