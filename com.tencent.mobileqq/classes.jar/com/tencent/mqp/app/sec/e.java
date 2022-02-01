package com.tencent.mqp.app.sec;

import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  private static final String FAKE_PATH_USE_CACHE = "abcdef";
  private static String sCachedMd5;
  private static AtomicBoolean sIsDownloading = new AtomicBoolean(false);
  private static boolean sIsFirstTimeUseCache = true;
  public static String tag = "downloadfile";
  public static String zipfeaturefilepath = "";
  
  /* Error */
  public static String d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 9
    //   12: new 41	java/net/URL
    //   15: dup
    //   16: aload_0
    //   17: invokespecial 44	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 48	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   23: checkcast 50	java/net/HttpURLConnection
    //   26: astore 10
    //   28: new 52	java/io/BufferedInputStream
    //   31: dup
    //   32: aload 10
    //   34: invokevirtual 56	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 59	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore 11
    //   42: new 61	java/io/FileOutputStream
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   50: astore 4
    //   52: aload 4
    //   54: astore_0
    //   55: sipush 512
    //   58: newarray byte
    //   60: astore 5
    //   62: aload 4
    //   64: astore_0
    //   65: aload 11
    //   67: aload 5
    //   69: iconst_0
    //   70: sipush 512
    //   73: invokevirtual 66	java/io/BufferedInputStream:read	([BII)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +18 -> 97
    //   82: aload 4
    //   84: astore_0
    //   85: aload 4
    //   87: aload 5
    //   89: iconst_0
    //   90: iload_2
    //   91: invokevirtual 70	java/io/FileOutputStream:write	([BII)V
    //   94: goto -32 -> 62
    //   97: aload 4
    //   99: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   102: aload 11
    //   104: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   107: aload 10
    //   109: ifnull +70 -> 179
    //   112: aload 10
    //   114: invokevirtual 77	java/net/HttpURLConnection:disconnect	()V
    //   117: goto +62 -> 179
    //   120: astore 5
    //   122: goto +14 -> 136
    //   125: astore_1
    //   126: aconst_null
    //   127: astore_0
    //   128: goto +520 -> 648
    //   131: astore 5
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: astore_0
    //   139: aload 5
    //   141: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   144: aload 4
    //   146: ifnull +11 -> 157
    //   149: aload 4
    //   151: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   154: goto +3 -> 157
    //   157: aload 11
    //   159: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   162: aload 10
    //   164: ifnull +15 -> 179
    //   167: aload 10
    //   169: invokevirtual 77	java/net/HttpURLConnection:disconnect	()V
    //   172: goto +7 -> 179
    //   175: aload_0
    //   176: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   179: new 82	java/io/File
    //   182: dup
    //   183: aload_1
    //   184: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   187: invokevirtual 87	java/io/File:exists	()Z
    //   190: ifne +20 -> 210
    //   193: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +12 -> 208
    //   199: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   202: iconst_2
    //   203: ldc 96
    //   205: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aconst_null
    //   209: areturn
    //   210: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   213: ifeq +12 -> 225
    //   216: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   219: iconst_2
    //   220: ldc 101
    //   222: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: new 103	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   232: astore_0
    //   233: aload_0
    //   234: aload_1
    //   235: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload_0
    //   240: ldc 110
    //   242: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload_0
    //   247: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 5
    //   252: new 82	java/io/File
    //   255: dup
    //   256: aload 5
    //   258: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 87	java/io/File:exists	()Z
    //   266: ifeq +8 -> 274
    //   269: aload_0
    //   270: invokevirtual 117	java/io/File:delete	()Z
    //   273: pop
    //   274: aload_1
    //   275: invokestatic 121	com/tencent/mqp/app/sec/e:validateZipFile	(Ljava/lang/String;)Z
    //   278: ifne +14 -> 292
    //   281: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   284: iconst_1
    //   285: ldc 123
    //   287: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aconst_null
    //   291: areturn
    //   292: new 125	com/tencent/commonsdk/zip/QZipFile
    //   295: dup
    //   296: aload_1
    //   297: invokespecial 126	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   300: astore 4
    //   302: aload 4
    //   304: astore_0
    //   305: aload 4
    //   307: invokevirtual 130	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   310: astore 10
    //   312: aload 4
    //   314: astore_0
    //   315: aload 10
    //   317: invokeinterface 135 1 0
    //   322: ifeq +54 -> 376
    //   325: aload 4
    //   327: astore_0
    //   328: aload 10
    //   330: invokeinterface 139 1 0
    //   335: checkcast 141	java/util/zip/ZipEntry
    //   338: astore 11
    //   340: aload 4
    //   342: astore_0
    //   343: aload 11
    //   345: invokevirtual 144	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   348: ldc 146
    //   350: invokevirtual 152	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   353: iconst_m1
    //   354: if_icmpeq +6 -> 360
    //   357: goto -45 -> 312
    //   360: aload 4
    //   362: astore_0
    //   363: aload 4
    //   365: aload 11
    //   367: aload 5
    //   369: invokestatic 156	com/tencent/mqp/app/sec/e:s	(Lcom/tencent/commonsdk/zip/QZipFile;Ljava/util/zip/ZipEntry;Ljava/lang/String;)Z
    //   372: pop
    //   373: goto -61 -> 312
    //   376: aload 4
    //   378: astore_0
    //   379: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +15 -> 397
    //   385: aload 4
    //   387: astore_0
    //   388: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   391: iconst_2
    //   392: ldc 158
    //   394: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 4
    //   399: astore_0
    //   400: new 82	java/io/File
    //   403: dup
    //   404: aload 5
    //   406: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   409: invokevirtual 87	java/io/File:exists	()Z
    //   412: istore_3
    //   413: aload 9
    //   415: astore_0
    //   416: iload_3
    //   417: ifeq +6 -> 423
    //   420: aload 5
    //   422: astore_0
    //   423: aload 4
    //   425: invokevirtual 159	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   428: goto +10 -> 438
    //   431: astore 4
    //   433: aload 4
    //   435: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   438: new 82	java/io/File
    //   441: dup
    //   442: aload_1
    //   443: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   446: invokevirtual 117	java/io/File:delete	()Z
    //   449: ifeq +22 -> 471
    //   452: aload_0
    //   453: astore_1
    //   454: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +120 -> 577
    //   460: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   463: iconst_2
    //   464: ldc 161
    //   466: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: areturn
    //   471: aload_0
    //   472: astore_1
    //   473: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +101 -> 577
    //   479: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   482: iconst_2
    //   483: ldc 163
    //   485: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: aload_0
    //   489: areturn
    //   490: astore 5
    //   492: goto +15 -> 507
    //   495: astore 4
    //   497: aconst_null
    //   498: astore_0
    //   499: goto +82 -> 581
    //   502: astore 5
    //   504: aconst_null
    //   505: astore 4
    //   507: aload 4
    //   509: astore_0
    //   510: aload 5
    //   512: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   515: aload 4
    //   517: ifnull +16 -> 533
    //   520: aload 4
    //   522: invokevirtual 159	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   525: goto +8 -> 533
    //   528: astore_0
    //   529: aload_0
    //   530: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   533: new 82	java/io/File
    //   536: dup
    //   537: aload_1
    //   538: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   541: invokevirtual 117	java/io/File:delete	()Z
    //   544: ifeq +18 -> 562
    //   547: aload 8
    //   549: astore_1
    //   550: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +24 -> 577
    //   556: aload 6
    //   558: astore_0
    //   559: goto -99 -> 460
    //   562: aload 8
    //   564: astore_1
    //   565: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   568: ifeq +9 -> 577
    //   571: aload 7
    //   573: astore_0
    //   574: goto -95 -> 479
    //   577: aload_1
    //   578: areturn
    //   579: astore 4
    //   581: aload_0
    //   582: ifnull +15 -> 597
    //   585: aload_0
    //   586: invokevirtual 159	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   589: goto +8 -> 597
    //   592: astore_0
    //   593: aload_0
    //   594: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   597: new 82	java/io/File
    //   600: dup
    //   601: aload_1
    //   602: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   605: invokevirtual 117	java/io/File:delete	()Z
    //   608: ifeq +21 -> 629
    //   611: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   614: ifeq +30 -> 644
    //   617: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   620: iconst_2
    //   621: ldc 161
    //   623: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   626: goto +18 -> 644
    //   629: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +12 -> 644
    //   635: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   638: iconst_2
    //   639: ldc 163
    //   641: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload 4
    //   646: athrow
    //   647: astore_1
    //   648: aload_0
    //   649: ifnull +10 -> 659
    //   652: aload_0
    //   653: invokevirtual 73	java/io/FileOutputStream:close	()V
    //   656: goto +3 -> 659
    //   659: aload 11
    //   661: invokevirtual 74	java/io/BufferedInputStream:close	()V
    //   664: aload 10
    //   666: ifnull +15 -> 681
    //   669: aload 10
    //   671: invokevirtual 77	java/net/HttpURLConnection:disconnect	()V
    //   674: goto +7 -> 681
    //   677: aload_0
    //   678: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   681: aload_1
    //   682: athrow
    //   683: astore_0
    //   684: aload_0
    //   685: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   688: aconst_null
    //   689: areturn
    //   690: astore_0
    //   691: goto -516 -> 175
    //   694: astore_0
    //   695: goto -18 -> 677
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	paramString1	String
    //   0	698	1	paramString2	String
    //   76	15	2	i	int
    //   412	5	3	bool	boolean
    //   50	374	4	localObject1	Object
    //   431	3	4	localIOException1	java.io.IOException
    //   495	1	4	localObject2	Object
    //   505	16	4	localObject3	Object
    //   579	66	4	localObject4	Object
    //   60	28	5	arrayOfByte	byte[]
    //   120	1	5	localIOException2	java.io.IOException
    //   131	9	5	localIOException3	java.io.IOException
    //   250	171	5	str	String
    //   490	1	5	localIOException4	java.io.IOException
    //   502	9	5	localIOException5	java.io.IOException
    //   1	556	6	localObject5	Object
    //   4	568	7	localObject6	Object
    //   7	556	8	localObject7	Object
    //   10	404	9	localObject8	Object
    //   26	644	10	localObject9	Object
    //   40	620	11	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   55	62	120	java/io/IOException
    //   65	77	120	java/io/IOException
    //   85	94	120	java/io/IOException
    //   42	52	125	finally
    //   42	52	131	java/io/IOException
    //   423	428	431	java/io/IOException
    //   305	312	490	java/io/IOException
    //   315	325	490	java/io/IOException
    //   328	340	490	java/io/IOException
    //   343	357	490	java/io/IOException
    //   363	373	490	java/io/IOException
    //   379	385	490	java/io/IOException
    //   388	397	490	java/io/IOException
    //   400	413	490	java/io/IOException
    //   292	302	495	finally
    //   292	302	502	java/io/IOException
    //   520	525	528	java/io/IOException
    //   305	312	579	finally
    //   315	325	579	finally
    //   328	340	579	finally
    //   343	357	579	finally
    //   363	373	579	finally
    //   379	385	579	finally
    //   388	397	579	finally
    //   400	413	579	finally
    //   510	515	579	finally
    //   585	589	592	java/io/IOException
    //   55	62	647	finally
    //   65	77	647	finally
    //   85	94	647	finally
    //   139	144	647	finally
    //   12	42	683	java/lang/Exception
    //   97	107	690	java/io/IOException
    //   112	117	690	java/io/IOException
    //   149	154	690	java/io/IOException
    //   157	162	690	java/io/IOException
    //   167	172	690	java/io/IOException
    //   652	656	694	java/io/IOException
    //   659	664	694	java/io/IOException
    //   669	674	694	java/io/IOException
  }
  
  /* Error */
  private static boolean s(com.tencent.commonsdk.zip.QZipFile paramQZipFile, java.util.zip.ZipEntry paramZipEntry, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: aload_1
    //   5: invokevirtual 167	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   8: astore 4
    //   10: new 61	java/io/FileOutputStream
    //   13: dup
    //   14: aload_2
    //   15: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_0
    //   19: sipush 8192
    //   22: newarray byte
    //   24: astore_1
    //   25: aload 4
    //   27: aload_1
    //   28: invokevirtual 172	java/io/InputStream:read	([B)I
    //   31: istore_3
    //   32: iload_3
    //   33: ifle +13 -> 46
    //   36: aload_0
    //   37: aload_1
    //   38: iconst_0
    //   39: iload_3
    //   40: invokevirtual 175	java/io/OutputStream:write	([BII)V
    //   43: goto -18 -> 25
    //   46: aload 4
    //   48: ifnull +16 -> 64
    //   51: aload 4
    //   53: invokevirtual 176	java/io/InputStream:close	()V
    //   56: goto +8 -> 64
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   64: aload_0
    //   65: invokevirtual 177	java/io/OutputStream:close	()V
    //   68: iconst_1
    //   69: ireturn
    //   70: astore_0
    //   71: aload_0
    //   72: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore_1
    //   78: aload 4
    //   80: astore_2
    //   81: goto +77 -> 158
    //   84: astore_1
    //   85: goto +15 -> 100
    //   88: astore_1
    //   89: aconst_null
    //   90: astore_0
    //   91: aload 4
    //   93: astore_2
    //   94: goto +64 -> 158
    //   97: astore_1
    //   98: aconst_null
    //   99: astore_0
    //   100: aload 4
    //   102: astore_2
    //   103: goto +17 -> 120
    //   106: astore_1
    //   107: aconst_null
    //   108: astore_2
    //   109: aload_2
    //   110: astore_0
    //   111: goto +47 -> 158
    //   114: astore_1
    //   115: aconst_null
    //   116: astore_0
    //   117: aload 5
    //   119: astore_2
    //   120: aload_1
    //   121: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   124: aload_2
    //   125: ifnull +15 -> 140
    //   128: aload_2
    //   129: invokevirtual 176	java/io/InputStream:close	()V
    //   132: goto +8 -> 140
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   140: aload_0
    //   141: ifnull +14 -> 155
    //   144: aload_0
    //   145: invokevirtual 177	java/io/OutputStream:close	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_0
    //   151: aload_0
    //   152: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   155: iconst_0
    //   156: ireturn
    //   157: astore_1
    //   158: aload_2
    //   159: ifnull +15 -> 174
    //   162: aload_2
    //   163: invokevirtual 176	java/io/InputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   174: aload_0
    //   175: ifnull +15 -> 190
    //   178: aload_0
    //   179: invokevirtual 177	java/io/OutputStream:close	()V
    //   182: goto +8 -> 190
    //   185: astore_0
    //   186: aload_0
    //   187: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   190: goto +5 -> 195
    //   193: aload_1
    //   194: athrow
    //   195: goto -2 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	paramQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   0	198	1	paramZipEntry	java.util.zip.ZipEntry
    //   0	198	2	paramString	String
    //   31	9	3	i	int
    //   8	93	4	localInputStream	java.io.InputStream
    //   1	117	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   51	56	59	java/io/IOException
    //   64	68	70	java/io/IOException
    //   19	25	77	finally
    //   25	32	77	finally
    //   36	43	77	finally
    //   19	25	84	java/io/IOException
    //   25	32	84	java/io/IOException
    //   36	43	84	java/io/IOException
    //   10	19	88	finally
    //   10	19	97	java/io/IOException
    //   3	10	106	finally
    //   3	10	114	java/io/IOException
    //   128	132	135	java/io/IOException
    //   144	148	150	java/io/IOException
    //   120	124	157	finally
    //   162	166	169	java/io/IOException
    //   178	182	185	java/io/IOException
  }
  
  /* Error */
  private static boolean validateZipFile(String paramString)
  {
    // Byte code:
    //   0: new 82	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 181	java/io/File:length	()J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifne +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aconst_null
    //   21: astore_3
    //   22: aconst_null
    //   23: astore_0
    //   24: new 183	java/io/RandomAccessFile
    //   27: dup
    //   28: aload_2
    //   29: ldc 185
    //   31: invokespecial 188	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 192	java/io/RandomAccessFile:readInt	()I
    //   39: istore_1
    //   40: iload_1
    //   41: ldc 193
    //   43: if_icmpeq +9 -> 52
    //   46: aload_2
    //   47: invokevirtual 194	java/io/RandomAccessFile:close	()V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_2
    //   53: aload_2
    //   54: invokevirtual 195	java/io/RandomAccessFile:length	()J
    //   57: ldc2_w 196
    //   60: lsub
    //   61: invokevirtual 201	java/io/RandomAccessFile:seek	(J)V
    //   64: aload_2
    //   65: invokevirtual 192	java/io/RandomAccessFile:readInt	()I
    //   68: istore_1
    //   69: iload_1
    //   70: ldc 202
    //   72: if_icmpeq +9 -> 81
    //   75: aload_2
    //   76: invokevirtual 194	java/io/RandomAccessFile:close	()V
    //   79: iconst_0
    //   80: ireturn
    //   81: aload_2
    //   82: invokevirtual 194	java/io/RandomAccessFile:close	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore_3
    //   88: aload_2
    //   89: astore_0
    //   90: aload_3
    //   91: astore_2
    //   92: goto +32 -> 124
    //   95: astore_3
    //   96: goto +12 -> 108
    //   99: astore_2
    //   100: goto +24 -> 124
    //   103: astore_0
    //   104: aload_3
    //   105: astore_2
    //   106: aload_0
    //   107: astore_3
    //   108: aload_2
    //   109: astore_0
    //   110: aload_3
    //   111: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   114: aload_2
    //   115: ifnull +7 -> 122
    //   118: aload_2
    //   119: invokevirtual 194	java/io/RandomAccessFile:close	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: aload_0
    //   125: ifnull +7 -> 132
    //   128: aload_0
    //   129: invokevirtual 194	java/io/RandomAccessFile:close	()V
    //   132: aload_2
    //   133: athrow
    //   134: astore_0
    //   135: iconst_0
    //   136: ireturn
    //   137: astore_0
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: goto -56 -> 85
    //   144: astore_0
    //   145: iconst_0
    //   146: ireturn
    //   147: astore_0
    //   148: goto -16 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramString	String
    //   39	34	1	i	int
    //   8	84	2	localObject1	Object
    //   99	1	2	localObject2	Object
    //   105	28	2	localObject3	Object
    //   21	1	3	localObject4	Object
    //   87	4	3	localObject5	Object
    //   95	10	3	localIOException	java.io.IOException
    //   107	4	3	str	String
    // Exception table:
    //   from	to	target	type
    //   35	40	87	finally
    //   52	69	87	finally
    //   35	40	95	java/io/IOException
    //   52	69	95	java/io/IOException
    //   24	35	99	finally
    //   110	114	99	finally
    //   24	35	103	java/io/IOException
    //   46	50	134	java/io/IOException
    //   75	79	137	java/io/IOException
    //   81	85	140	java/io/IOException
    //   118	122	144	java/io/IOException
    //   128	132	147	java/io/IOException
  }
  
  /* Error */
  public static String x(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/mqp/app/sec/e:sIsDownloading	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3: astore 4
    //   5: iconst_1
    //   6: istore_2
    //   7: aload 4
    //   9: iconst_0
    //   10: iconst_1
    //   11: invokevirtual 212	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   14: istore_3
    //   15: aconst_null
    //   16: astore 6
    //   18: aconst_null
    //   19: astore 5
    //   21: iload_3
    //   22: ifne +14 -> 36
    //   25: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   28: iconst_1
    //   29: ldc 214
    //   31: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: aconst_null
    //   35: areturn
    //   36: new 82	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
    //   44: ldc 222
    //   46: invokespecial 223	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: astore 4
    //   51: aload 4
    //   53: invokevirtual 87	java/io/File:exists	()Z
    //   56: ifne +9 -> 65
    //   59: aload 4
    //   61: invokevirtual 226	java/io/File:mkdir	()Z
    //   64: pop
    //   65: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +11 -> 79
    //   71: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   74: iconst_2
    //   75: aload_1
    //   76: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: new 103	java/lang/StringBuilder
    //   82: dup
    //   83: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   86: astore 4
    //   88: aload 4
    //   90: aload_0
    //   91: invokevirtual 220	android/content/Context:getFilesDir	()Ljava/io/File;
    //   94: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: aload 4
    //   100: ldc 231
    //   102: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: putstatic 233	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   114: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   117: ifeq +13 -> 130
    //   120: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   123: iconst_2
    //   124: getstatic 233	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   127: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: new 235	org/json/JSONObject
    //   133: dup
    //   134: aload_1
    //   135: invokespecial 236	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   138: astore_0
    //   139: aload_0
    //   140: ldc 238
    //   142: invokevirtual 242	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   145: invokevirtual 245	java/lang/String:trim	()Ljava/lang/String;
    //   148: astore 7
    //   150: aload_0
    //   151: ldc 247
    //   153: invokevirtual 242	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   156: invokevirtual 245	java/lang/String:trim	()Ljava/lang/String;
    //   159: astore 8
    //   161: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +12 -> 176
    //   167: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   170: iconst_2
    //   171: aload 8
    //   173: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: new 103	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   183: astore_0
    //   184: aload_0
    //   185: getstatic 233	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   188: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_0
    //   193: ldc 110
    //   195: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_0
    //   200: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore_1
    //   204: new 82	java/io/File
    //   207: dup
    //   208: aload_1
    //   209: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: invokevirtual 87	java/io/File:exists	()Z
    //   215: ifne +11 -> 226
    //   218: aload 8
    //   220: ifnull +510 -> 730
    //   223: goto +502 -> 725
    //   226: getstatic 249	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   229: ifnull +45 -> 274
    //   232: getstatic 249	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   235: astore 4
    //   237: aload 4
    //   239: astore_0
    //   240: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +40 -> 283
    //   246: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   249: iconst_2
    //   250: iconst_2
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: ldc 251
    //   258: aastore
    //   259: dup
    //   260: iconst_1
    //   261: getstatic 249	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   264: aastore
    //   265: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   268: aload 4
    //   270: astore_0
    //   271: goto +12 -> 283
    //   274: aload_1
    //   275: invokestatic 259	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   278: astore_0
    //   279: aload_0
    //   280: putstatic 249	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   283: aload_0
    //   284: ifnull +441 -> 725
    //   287: aload_0
    //   288: aload 7
    //   290: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   293: ifne +6 -> 299
    //   296: goto +429 -> 725
    //   299: getstatic 264	com/tencent/mqp/app/sec/e:sIsFirstTimeUseCache	Z
    //   302: istore_3
    //   303: iload_3
    //   304: ifeq +12 -> 316
    //   307: aload_1
    //   308: astore_0
    //   309: iconst_0
    //   310: putstatic 264	com/tencent/mqp/app/sec/e:sIsFirstTimeUseCache	Z
    //   313: goto +419 -> 732
    //   316: ldc 8
    //   318: astore_1
    //   319: goto +413 -> 732
    //   322: aload_1
    //   323: astore_0
    //   324: iload_2
    //   325: ifeq +159 -> 484
    //   328: aconst_null
    //   329: astore 4
    //   331: iconst_2
    //   332: istore_2
    //   333: iload_2
    //   334: iflt +70 -> 404
    //   337: aload_1
    //   338: astore_0
    //   339: aload 8
    //   341: getstatic 233	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   344: invokestatic 266	com/tencent/mqp/app/sec/e:d	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   347: astore 4
    //   349: aload 4
    //   351: ifnull +6 -> 357
    //   354: goto +50 -> 404
    //   357: iload_2
    //   358: iconst_1
    //   359: isub
    //   360: istore_2
    //   361: aload_1
    //   362: astore_0
    //   363: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +15 -> 381
    //   369: aload_1
    //   370: astore_0
    //   371: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   374: iconst_2
    //   375: ldc_w 268
    //   378: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_1
    //   382: astore_0
    //   383: ldc2_w 269
    //   386: invokestatic 275	java/lang/Thread:sleep	(J)V
    //   389: goto -56 -> 333
    //   392: astore 9
    //   394: aload_1
    //   395: astore_0
    //   396: aload 9
    //   398: invokevirtual 276	java/lang/InterruptedException:printStackTrace	()V
    //   401: goto -68 -> 333
    //   404: aload_1
    //   405: astore_0
    //   406: aload 4
    //   408: ifnull +76 -> 484
    //   411: aload_1
    //   412: astore_0
    //   413: aload 4
    //   415: invokestatic 259	com/tencent/qqprotect/singleupdate/MD5FileUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   418: astore 8
    //   420: aload_1
    //   421: astore_0
    //   422: aload 8
    //   424: ifnull +60 -> 484
    //   427: aload_1
    //   428: astore_0
    //   429: aload 8
    //   431: aload 7
    //   433: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   436: istore_3
    //   437: aload_1
    //   438: astore_0
    //   439: iload_3
    //   440: ifeq +44 -> 484
    //   443: aload 8
    //   445: putstatic 249	com/tencent/mqp/app/sec/e:sCachedMd5	Ljava/lang/String;
    //   448: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   451: ifeq +13 -> 464
    //   454: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   457: iconst_2
    //   458: ldc_w 278
    //   461: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   464: aload 4
    //   466: astore_0
    //   467: goto +17 -> 484
    //   470: astore_1
    //   471: aload 4
    //   473: astore_0
    //   474: goto +6 -> 480
    //   477: astore_1
    //   478: aconst_null
    //   479: astore_0
    //   480: aload_1
    //   481: invokevirtual 279	org/json/JSONException:printStackTrace	()V
    //   484: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +42 -> 529
    //   490: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   493: astore_1
    //   494: new 103	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   501: astore 4
    //   503: aload 4
    //   505: ldc_w 281
    //   508: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: pop
    //   512: aload 4
    //   514: aload_0
    //   515: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_1
    //   520: iconst_2
    //   521: aload 4
    //   523: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: ifnonnull +186 -> 716
    //   533: invokestatic 92	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +180 -> 716
    //   539: getstatic 94	com/tencent/mqp/app/sec/e:tag	Ljava/lang/String;
    //   542: iconst_2
    //   543: ldc_w 283
    //   546: invokestatic 99	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: new 103	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   556: astore_1
    //   557: aload_1
    //   558: getstatic 233	com/tencent/mqp/app/sec/e:zipfeaturefilepath	Ljava/lang/String;
    //   561: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_1
    //   566: ldc 110
    //   568: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_1
    //   573: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   576: astore 7
    //   578: new 82	java/io/File
    //   581: dup
    //   582: aload 7
    //   584: invokespecial 83	java/io/File:<init>	(Ljava/lang/String;)V
    //   587: astore_1
    //   588: aload_1
    //   589: invokevirtual 87	java/io/File:exists	()Z
    //   592: ifeq +8 -> 600
    //   595: aload_1
    //   596: invokevirtual 117	java/io/File:delete	()Z
    //   599: pop
    //   600: aload 5
    //   602: astore_1
    //   603: new 61	java/io/FileOutputStream
    //   606: dup
    //   607: aload 7
    //   609: invokespecial 62	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   612: astore 4
    //   614: aload 4
    //   616: ldc_w 285
    //   619: invokevirtual 289	java/lang/String:getBytes	()[B
    //   622: invokevirtual 292	java/io/OutputStream:write	([B)V
    //   625: aload 4
    //   627: invokevirtual 177	java/io/OutputStream:close	()V
    //   630: aload 7
    //   632: astore_0
    //   633: goto +83 -> 716
    //   636: astore_0
    //   637: aload_0
    //   638: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   641: aload 7
    //   643: astore_0
    //   644: goto +72 -> 716
    //   647: astore_0
    //   648: aload 4
    //   650: astore_1
    //   651: goto +47 -> 698
    //   654: astore 5
    //   656: goto +13 -> 669
    //   659: astore_0
    //   660: goto +38 -> 698
    //   663: astore 5
    //   665: aload 6
    //   667: astore 4
    //   669: aload 4
    //   671: astore_1
    //   672: aload 5
    //   674: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   677: aload 4
    //   679: ifnull +37 -> 716
    //   682: aload 4
    //   684: invokevirtual 177	java/io/OutputStream:close	()V
    //   687: goto +29 -> 716
    //   690: astore_1
    //   691: aload_1
    //   692: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   695: goto +21 -> 716
    //   698: aload_1
    //   699: ifnull +15 -> 714
    //   702: aload_1
    //   703: invokevirtual 177	java/io/OutputStream:close	()V
    //   706: goto +8 -> 714
    //   709: astore_1
    //   710: aload_1
    //   711: invokevirtual 80	java/io/IOException:printStackTrace	()V
    //   714: aload_0
    //   715: athrow
    //   716: getstatic 30	com/tencent/mqp/app/sec/e:sIsDownloading	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   719: iconst_0
    //   720: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   723: aload_0
    //   724: areturn
    //   725: aconst_null
    //   726: astore_1
    //   727: goto -405 -> 322
    //   730: aconst_null
    //   731: astore_1
    //   732: iconst_0
    //   733: istore_2
    //   734: goto -412 -> 322
    //   737: astore_1
    //   738: goto -258 -> 480
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	741	0	paramContext	android.content.Context
    //   0	741	1	paramString	String
    //   6	728	2	i	int
    //   14	426	3	bool	boolean
    //   3	680	4	localObject1	Object
    //   19	582	5	localObject2	Object
    //   654	1	5	localIOException1	java.io.IOException
    //   663	10	5	localIOException2	java.io.IOException
    //   16	650	6	localObject3	Object
    //   148	494	7	str1	String
    //   159	285	8	str2	String
    //   392	5	9	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   383	389	392	java/lang/InterruptedException
    //   443	464	470	org/json/JSONException
    //   130	176	477	org/json/JSONException
    //   176	218	477	org/json/JSONException
    //   226	237	477	org/json/JSONException
    //   240	268	477	org/json/JSONException
    //   274	283	477	org/json/JSONException
    //   287	296	477	org/json/JSONException
    //   299	303	477	org/json/JSONException
    //   625	630	636	java/io/IOException
    //   614	625	647	finally
    //   614	625	654	java/io/IOException
    //   603	614	659	finally
    //   672	677	659	finally
    //   603	614	663	java/io/IOException
    //   682	687	690	java/io/IOException
    //   702	706	709	java/io/IOException
    //   309	313	737	org/json/JSONException
    //   339	349	737	org/json/JSONException
    //   363	369	737	org/json/JSONException
    //   371	381	737	org/json/JSONException
    //   383	389	737	org/json/JSONException
    //   396	401	737	org/json/JSONException
    //   413	420	737	org/json/JSONException
    //   429	437	737	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.sec.e
 * JD-Core Version:    0.7.0.1
 */