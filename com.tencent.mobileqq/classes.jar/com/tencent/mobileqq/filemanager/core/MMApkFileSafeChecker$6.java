package com.tencent.mobileqq.filemanager.core;

class MMApkFileSafeChecker$6
  implements Runnable
{
  MMApkFileSafeChecker$6(MMApkFileSafeChecker paramMMApkFileSafeChecker, String paramString, MMApkFileSafeChecker.IGetDigestResult paramIGetDigestResult) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 9
    //   8: new 33	java/io/BufferedInputStream
    //   11: dup
    //   12: new 35	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 18	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:a	Ljava/lang/String;
    //   20: invokespecial 38	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: invokespecial 41	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 6
    //   28: aload 6
    //   30: astore 5
    //   32: sipush 10240
    //   35: newarray byte
    //   37: astore 10
    //   39: aload 6
    //   41: astore 5
    //   43: ldc 43
    //   45: invokestatic 49	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   48: astore 4
    //   50: aload 6
    //   52: astore 5
    //   54: ldc 51
    //   56: invokestatic 49	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   59: astore 7
    //   61: goto +25 -> 86
    //   64: astore 7
    //   66: goto +8 -> 74
    //   69: astore 7
    //   71: aconst_null
    //   72: astore 4
    //   74: aload 6
    //   76: astore 5
    //   78: aload 7
    //   80: invokevirtual 54	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   83: aconst_null
    //   84: astore 7
    //   86: aload 6
    //   88: astore 5
    //   90: aload 6
    //   92: aload 10
    //   94: invokevirtual 60	java/io/InputStream:read	([B)I
    //   97: istore_1
    //   98: iload_1
    //   99: ifle +32 -> 131
    //   102: aload 6
    //   104: astore 5
    //   106: aload 4
    //   108: aload 10
    //   110: iconst_0
    //   111: iload_1
    //   112: invokevirtual 64	java/security/MessageDigest:update	([BII)V
    //   115: aload 6
    //   117: astore 5
    //   119: aload 7
    //   121: aload 10
    //   123: iconst_0
    //   124: iload_1
    //   125: invokevirtual 64	java/security/MessageDigest:update	([BII)V
    //   128: goto -42 -> 86
    //   131: aload 6
    //   133: astore 5
    //   135: aload 6
    //   137: invokevirtual 67	java/io/InputStream:close	()V
    //   140: goto +14 -> 154
    //   143: astore 10
    //   145: aload 6
    //   147: astore 5
    //   149: aload 10
    //   151: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   154: aload 4
    //   156: ifnull +17 -> 173
    //   159: aload 6
    //   161: astore 5
    //   163: aload 4
    //   165: invokevirtual 72	java/security/MessageDigest:digest	()[B
    //   168: astore 4
    //   170: goto +6 -> 176
    //   173: aconst_null
    //   174: astore 4
    //   176: aload 9
    //   178: astore 5
    //   180: aload 7
    //   182: ifnull +31 -> 213
    //   185: aload 6
    //   187: astore 5
    //   189: aload 7
    //   191: invokevirtual 72	java/security/MessageDigest:digest	()[B
    //   194: astore 7
    //   196: aload 7
    //   198: astore 5
    //   200: goto +13 -> 213
    //   203: astore 7
    //   205: goto +69 -> 274
    //   208: astore 7
    //   210: goto +135 -> 345
    //   213: iconst_1
    //   214: istore_2
    //   215: aload 6
    //   217: invokevirtual 67	java/io/InputStream:close	()V
    //   220: goto +10 -> 230
    //   223: astore 6
    //   225: aload 6
    //   227: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   230: aload 5
    //   232: astore 7
    //   234: aload 4
    //   236: astore 5
    //   238: goto +150 -> 388
    //   241: astore 7
    //   243: aconst_null
    //   244: astore 4
    //   246: goto +28 -> 274
    //   249: astore 7
    //   251: aconst_null
    //   252: astore 4
    //   254: goto +91 -> 345
    //   257: astore 4
    //   259: aconst_null
    //   260: astore 5
    //   262: goto +221 -> 483
    //   265: astore 7
    //   267: aconst_null
    //   268: astore 6
    //   270: aload 6
    //   272: astore 4
    //   274: aload 6
    //   276: astore 5
    //   278: aload 7
    //   280: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   283: iload_3
    //   284: istore_2
    //   285: aload 8
    //   287: astore 7
    //   289: aload 4
    //   291: astore 5
    //   293: aload 6
    //   295: ifnull +93 -> 388
    //   298: aload 4
    //   300: astore 5
    //   302: aload 6
    //   304: invokevirtual 67	java/io/InputStream:close	()V
    //   307: iload_3
    //   308: istore_2
    //   309: aload 8
    //   311: astore 7
    //   313: aload 4
    //   315: astore 5
    //   317: goto +71 -> 388
    //   320: astore 4
    //   322: aload 4
    //   324: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   327: iload_3
    //   328: istore_2
    //   329: aload 8
    //   331: astore 7
    //   333: goto +55 -> 388
    //   336: astore 7
    //   338: aconst_null
    //   339: astore 6
    //   341: aload 6
    //   343: astore 4
    //   345: aload 6
    //   347: astore 5
    //   349: aload 7
    //   351: invokevirtual 73	java/io/FileNotFoundException:printStackTrace	()V
    //   354: iload_3
    //   355: istore_2
    //   356: aload 8
    //   358: astore 7
    //   360: aload 4
    //   362: astore 5
    //   364: aload 6
    //   366: ifnull +22 -> 388
    //   369: aload 4
    //   371: astore 5
    //   373: aload 6
    //   375: invokevirtual 67	java/io/InputStream:close	()V
    //   378: aload 4
    //   380: astore 5
    //   382: aload 8
    //   384: astore 7
    //   386: iload_3
    //   387: istore_2
    //   388: new 75	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo
    //   391: dup
    //   392: aload_0
    //   393: getfield 16	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:this$0	Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker;
    //   396: invokespecial 78	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:<init>	(Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker;)V
    //   399: astore 4
    //   401: aload 4
    //   403: aload 5
    //   405: putfield 81	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:a	[B
    //   408: aload 4
    //   410: aload 7
    //   412: putfield 83	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:b	[B
    //   415: aload 4
    //   417: aload_0
    //   418: getfield 18	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:a	Ljava/lang/String;
    //   421: invokestatic 89	com/tencent/mobileqq/filemanager/util/FileUtil:f	(Ljava/lang/String;)J
    //   424: putfield 93	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:c	J
    //   427: aload 4
    //   429: invokestatic 99	java/lang/System:currentTimeMillis	()J
    //   432: putfield 102	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:d	J
    //   435: iload_2
    //   436: ifeq +32 -> 468
    //   439: aload 4
    //   441: getfield 81	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:a	[B
    //   444: ifnull +24 -> 468
    //   447: aload 4
    //   449: getfield 83	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo:b	[B
    //   452: ifnull +16 -> 468
    //   455: aload_0
    //   456: getfield 16	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:this$0	Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker;
    //   459: aload_0
    //   460: getfield 18	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:a	Ljava/lang/String;
    //   463: aload 4
    //   465: invokestatic 107	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker:a	(Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$FileDigestInfo;)V
    //   468: aload_0
    //   469: getfield 20	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:b	Lcom/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$IGetDigestResult;
    //   472: iload_2
    //   473: aload 4
    //   475: invokeinterface 112 3 0
    //   480: return
    //   481: astore 4
    //   483: aload 5
    //   485: ifnull +18 -> 503
    //   488: aload 5
    //   490: invokevirtual 67	java/io/InputStream:close	()V
    //   493: goto +10 -> 503
    //   496: astore 5
    //   498: aload 5
    //   500: invokevirtual 68	java/io/IOException:printStackTrace	()V
    //   503: goto +6 -> 509
    //   506: aload 4
    //   508: athrow
    //   509: goto -3 -> 506
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	6
    //   97	28	1	i	int
    //   214	259	2	bool1	boolean
    //   1	386	3	bool2	boolean
    //   48	205	4	localObject1	Object
    //   257	1	4	localObject2	Object
    //   272	42	4	localObject3	Object
    //   320	3	4	localIOException1	java.io.IOException
    //   343	131	4	localObject4	Object
    //   481	26	4	localObject5	Object
    //   30	459	5	localObject6	Object
    //   496	3	5	localIOException2	java.io.IOException
    //   26	190	6	localBufferedInputStream	java.io.BufferedInputStream
    //   223	3	6	localIOException3	java.io.IOException
    //   268	106	6	localObject7	Object
    //   59	1	7	localMessageDigest	java.security.MessageDigest
    //   64	1	7	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   69	10	7	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   84	113	7	arrayOfByte1	byte[]
    //   203	1	7	localIOException4	java.io.IOException
    //   208	1	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   232	1	7	localObject8	Object
    //   241	1	7	localIOException5	java.io.IOException
    //   249	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   265	14	7	localIOException6	java.io.IOException
    //   287	45	7	localObject9	Object
    //   336	14	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   358	53	7	localObject10	Object
    //   3	380	8	localObject11	Object
    //   6	171	9	localObject12	Object
    //   37	85	10	arrayOfByte2	byte[]
    //   143	7	10	localIOException7	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   54	61	64	java/security/NoSuchAlgorithmException
    //   43	50	69	java/security/NoSuchAlgorithmException
    //   135	140	143	java/io/IOException
    //   189	196	203	java/io/IOException
    //   189	196	208	java/io/FileNotFoundException
    //   215	220	223	java/io/IOException
    //   32	39	241	java/io/IOException
    //   43	50	241	java/io/IOException
    //   54	61	241	java/io/IOException
    //   78	83	241	java/io/IOException
    //   90	98	241	java/io/IOException
    //   106	115	241	java/io/IOException
    //   119	128	241	java/io/IOException
    //   149	154	241	java/io/IOException
    //   163	170	241	java/io/IOException
    //   32	39	249	java/io/FileNotFoundException
    //   43	50	249	java/io/FileNotFoundException
    //   54	61	249	java/io/FileNotFoundException
    //   78	83	249	java/io/FileNotFoundException
    //   90	98	249	java/io/FileNotFoundException
    //   106	115	249	java/io/FileNotFoundException
    //   119	128	249	java/io/FileNotFoundException
    //   135	140	249	java/io/FileNotFoundException
    //   149	154	249	java/io/FileNotFoundException
    //   163	170	249	java/io/FileNotFoundException
    //   8	28	257	finally
    //   8	28	265	java/io/IOException
    //   302	307	320	java/io/IOException
    //   373	378	320	java/io/IOException
    //   8	28	336	java/io/FileNotFoundException
    //   32	39	481	finally
    //   43	50	481	finally
    //   54	61	481	finally
    //   78	83	481	finally
    //   90	98	481	finally
    //   106	115	481	finally
    //   119	128	481	finally
    //   135	140	481	finally
    //   149	154	481	finally
    //   163	170	481	finally
    //   189	196	481	finally
    //   278	283	481	finally
    //   349	354	481	finally
    //   488	493	496	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.6
 * JD-Core Version:    0.7.0.1
 */