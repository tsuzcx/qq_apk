package com.tencent.smtt.sdk;

class TbsLogReport$a
{
  private final String a;
  private final String b;
  
  public TbsLogReport$a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  /* Error */
  private static void a(java.io.File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: new 24	java/io/RandomAccessFile
    //   8: dup
    //   9: aload_0
    //   10: ldc 26
    //   12: invokespecial 29	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   15: astore_0
    //   16: ldc 31
    //   18: iconst_2
    //   19: invokestatic 37	java/lang/Integer:parseInt	(Ljava/lang/String;I)I
    //   22: istore_1
    //   23: aload_0
    //   24: ldc2_w 38
    //   27: invokevirtual 43	java/io/RandomAccessFile:seek	(J)V
    //   30: aload_0
    //   31: invokevirtual 47	java/io/RandomAccessFile:read	()I
    //   34: istore_2
    //   35: iload_2
    //   36: iload_1
    //   37: iand
    //   38: ifle +23 -> 61
    //   41: aload_0
    //   42: ldc2_w 38
    //   45: invokevirtual 43	java/io/RandomAccessFile:seek	(J)V
    //   48: aload_0
    //   49: iload_1
    //   50: iconst_m1
    //   51: ixor
    //   52: sipush 255
    //   55: iand
    //   56: iload_2
    //   57: iand
    //   58: invokevirtual 51	java/io/RandomAccessFile:write	(I)V
    //   61: aload_0
    //   62: invokevirtual 54	java/io/RandomAccessFile:close	()V
    //   65: return
    //   66: astore_3
    //   67: goto +45 -> 112
    //   70: astore 4
    //   72: goto +18 -> 90
    //   75: astore 4
    //   77: aload_3
    //   78: astore_0
    //   79: aload 4
    //   81: astore_3
    //   82: goto +30 -> 112
    //   85: astore 4
    //   87: aload 5
    //   89: astore_0
    //   90: aload_0
    //   91: astore_3
    //   92: aload 4
    //   94: invokevirtual 57	java/lang/Exception:printStackTrace	()V
    //   97: aload_0
    //   98: ifnull +13 -> 111
    //   101: aload_0
    //   102: invokevirtual 54	java/io/RandomAccessFile:close	()V
    //   105: return
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   111: return
    //   112: aload_0
    //   113: ifnull +15 -> 128
    //   116: aload_0
    //   117: invokevirtual 54	java/io/RandomAccessFile:close	()V
    //   120: goto +8 -> 128
    //   123: astore_0
    //   124: aload_0
    //   125: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   128: aload_3
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramFile	java.io.File
    //   22	30	1	i	int
    //   34	24	2	j	int
    //   4	1	3	localObject1	Object
    //   66	12	3	localObject2	Object
    //   81	48	3	localObject3	Object
    //   70	1	4	localException1	java.lang.Exception
    //   75	5	4	localObject4	Object
    //   85	8	4	localException2	java.lang.Exception
    //   1	87	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   16	35	66	finally
    //   41	61	66	finally
    //   16	35	70	java/lang/Exception
    //   41	61	70	java/lang/Exception
    //   5	16	75	finally
    //   92	97	75	finally
    //   5	16	85	java/lang/Exception
    //   61	65	106	java/io/IOException
    //   101	105	106	java/io/IOException
    //   116	120	123	java/io/IOException
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: new 60	java/io/FileOutputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   8: invokespecial 63	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   11: astore_3
    //   12: new 65	java/util/zip/ZipOutputStream
    //   15: dup
    //   16: new 67	java/io/BufferedOutputStream
    //   19: dup
    //   20: aload_3
    //   21: invokespecial 70	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: invokespecial 71	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   27: astore 7
    //   29: aload_3
    //   30: astore 4
    //   32: aload 7
    //   34: astore 5
    //   36: sipush 2048
    //   39: newarray byte
    //   41: astore 8
    //   43: aload_3
    //   44: astore 4
    //   46: aload 7
    //   48: astore 5
    //   50: aload_0
    //   51: getfield 14	com/tencent/smtt/sdk/TbsLogReport$a:a	Ljava/lang/String;
    //   54: astore 9
    //   56: new 73	java/io/FileInputStream
    //   59: dup
    //   60: aload 9
    //   62: invokespecial 74	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   65: astore_2
    //   66: new 76	java/io/BufferedInputStream
    //   69: dup
    //   70: aload_2
    //   71: sipush 2048
    //   74: invokespecial 79	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   77: astore 6
    //   79: aload_2
    //   80: astore 4
    //   82: aload 6
    //   84: astore 5
    //   86: aload 7
    //   88: new 81	java/util/zip/ZipEntry
    //   91: dup
    //   92: aload 9
    //   94: aload 9
    //   96: ldc 83
    //   98: invokevirtual 89	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   101: iconst_1
    //   102: iadd
    //   103: invokevirtual 93	java/lang/String:substring	(I)Ljava/lang/String;
    //   106: invokespecial 94	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   109: invokevirtual 98	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   112: aload_2
    //   113: astore 4
    //   115: aload 6
    //   117: astore 5
    //   119: aload 6
    //   121: aload 8
    //   123: iconst_0
    //   124: sipush 2048
    //   127: invokevirtual 101	java/io/BufferedInputStream:read	([BII)I
    //   130: istore_1
    //   131: iload_1
    //   132: iconst_m1
    //   133: if_icmpeq +22 -> 155
    //   136: aload_2
    //   137: astore 4
    //   139: aload 6
    //   141: astore 5
    //   143: aload 7
    //   145: aload 8
    //   147: iconst_0
    //   148: iload_1
    //   149: invokevirtual 104	java/util/zip/ZipOutputStream:write	([BII)V
    //   152: goto -40 -> 112
    //   155: aload_2
    //   156: astore 4
    //   158: aload 6
    //   160: astore 5
    //   162: aload 7
    //   164: invokevirtual 107	java/util/zip/ZipOutputStream:flush	()V
    //   167: aload_2
    //   168: astore 4
    //   170: aload 6
    //   172: astore 5
    //   174: aload 7
    //   176: invokevirtual 110	java/util/zip/ZipOutputStream:closeEntry	()V
    //   179: aload_3
    //   180: astore 4
    //   182: aload 7
    //   184: astore 5
    //   186: aload 6
    //   188: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   191: goto +17 -> 208
    //   194: astore 6
    //   196: aload_3
    //   197: astore 4
    //   199: aload 7
    //   201: astore 5
    //   203: aload 6
    //   205: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   208: aload_3
    //   209: astore 4
    //   211: aload 7
    //   213: astore 5
    //   215: aload_2
    //   216: invokevirtual 112	java/io/FileInputStream:close	()V
    //   219: goto +126 -> 345
    //   222: astore_2
    //   223: aload_3
    //   224: astore 4
    //   226: aload 7
    //   228: astore 5
    //   230: aload_2
    //   231: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   234: goto +111 -> 345
    //   237: astore 8
    //   239: goto +38 -> 277
    //   242: astore 4
    //   244: goto +12 -> 256
    //   247: astore 4
    //   249: goto +21 -> 270
    //   252: astore 4
    //   254: aconst_null
    //   255: astore_2
    //   256: aconst_null
    //   257: astore 8
    //   259: aload 4
    //   261: astore 6
    //   263: goto +130 -> 393
    //   266: astore 4
    //   268: aconst_null
    //   269: astore_2
    //   270: aconst_null
    //   271: astore 6
    //   273: aload 4
    //   275: astore 8
    //   277: aload_2
    //   278: astore 4
    //   280: aload 6
    //   282: astore 5
    //   284: aload 8
    //   286: invokevirtual 57	java/lang/Exception:printStackTrace	()V
    //   289: aload 6
    //   291: ifnull +32 -> 323
    //   294: aload_3
    //   295: astore 4
    //   297: aload 7
    //   299: astore 5
    //   301: aload 6
    //   303: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   306: goto +17 -> 323
    //   309: astore 6
    //   311: aload_3
    //   312: astore 4
    //   314: aload 7
    //   316: astore 5
    //   318: aload 6
    //   320: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   323: aload_2
    //   324: ifnull +21 -> 345
    //   327: aload_3
    //   328: astore 4
    //   330: aload 7
    //   332: astore 5
    //   334: aload_2
    //   335: invokevirtual 112	java/io/FileInputStream:close	()V
    //   338: goto +7 -> 345
    //   341: astore_2
    //   342: goto -119 -> 223
    //   345: aload_3
    //   346: astore 4
    //   348: aload 7
    //   350: astore 5
    //   352: new 114	java/io/File
    //   355: dup
    //   356: aload_0
    //   357: getfield 16	com/tencent/smtt/sdk/TbsLogReport$a:b	Ljava/lang/String;
    //   360: invokespecial 115	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: invokestatic 117	com/tencent/smtt/sdk/TbsLogReport$a:a	(Ljava/io/File;)V
    //   366: aload 7
    //   368: invokevirtual 118	java/util/zip/ZipOutputStream:close	()V
    //   371: goto +8 -> 379
    //   374: astore_2
    //   375: aload_2
    //   376: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   379: aload_3
    //   380: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   383: return
    //   384: astore 6
    //   386: aload 5
    //   388: astore 8
    //   390: aload 4
    //   392: astore_2
    //   393: aload 8
    //   395: ifnull +32 -> 427
    //   398: aload_3
    //   399: astore 4
    //   401: aload 7
    //   403: astore 5
    //   405: aload 8
    //   407: invokevirtual 111	java/io/BufferedInputStream:close	()V
    //   410: goto +17 -> 427
    //   413: astore 8
    //   415: aload_3
    //   416: astore 4
    //   418: aload 7
    //   420: astore 5
    //   422: aload 8
    //   424: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   427: aload_2
    //   428: ifnull +29 -> 457
    //   431: aload_3
    //   432: astore 4
    //   434: aload 7
    //   436: astore 5
    //   438: aload_2
    //   439: invokevirtual 112	java/io/FileInputStream:close	()V
    //   442: goto +15 -> 457
    //   445: astore_2
    //   446: aload_3
    //   447: astore 4
    //   449: aload 7
    //   451: astore 5
    //   453: aload_2
    //   454: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   457: aload_3
    //   458: astore 4
    //   460: aload 7
    //   462: astore 5
    //   464: aload 6
    //   466: athrow
    //   467: astore 6
    //   469: aload 7
    //   471: astore_2
    //   472: goto +33 -> 505
    //   475: astore_2
    //   476: aconst_null
    //   477: astore 5
    //   479: goto +72 -> 551
    //   482: astore 6
    //   484: aconst_null
    //   485: astore_2
    //   486: goto +19 -> 505
    //   489: astore_2
    //   490: aconst_null
    //   491: astore 5
    //   493: aload 5
    //   495: astore_3
    //   496: goto +55 -> 551
    //   499: astore 6
    //   501: aconst_null
    //   502: astore_2
    //   503: aload_2
    //   504: astore_3
    //   505: aload_3
    //   506: astore 4
    //   508: aload_2
    //   509: astore 5
    //   511: aload 6
    //   513: invokevirtual 57	java/lang/Exception:printStackTrace	()V
    //   516: aload_2
    //   517: ifnull +15 -> 532
    //   520: aload_2
    //   521: invokevirtual 118	java/util/zip/ZipOutputStream:close	()V
    //   524: goto +8 -> 532
    //   527: astore_2
    //   528: aload_2
    //   529: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   532: aload_3
    //   533: ifnull +13 -> 546
    //   536: aload_3
    //   537: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   540: return
    //   541: astore_2
    //   542: aload_2
    //   543: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   546: return
    //   547: astore_2
    //   548: aload 4
    //   550: astore_3
    //   551: aload 5
    //   553: ifnull +18 -> 571
    //   556: aload 5
    //   558: invokevirtual 118	java/util/zip/ZipOutputStream:close	()V
    //   561: goto +10 -> 571
    //   564: astore 4
    //   566: aload 4
    //   568: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   571: aload_3
    //   572: ifnull +15 -> 587
    //   575: aload_3
    //   576: invokevirtual 119	java/io/FileOutputStream:close	()V
    //   579: goto +8 -> 587
    //   582: astore_3
    //   583: aload_3
    //   584: invokevirtual 58	java/io/IOException:printStackTrace	()V
    //   587: goto +5 -> 592
    //   590: aload_2
    //   591: athrow
    //   592: goto -2 -> 590
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	a
    //   130	19	1	i	int
    //   65	151	2	localFileInputStream	java.io.FileInputStream
    //   222	9	2	localIOException1	java.io.IOException
    //   255	80	2	localObject1	Object
    //   341	1	2	localIOException2	java.io.IOException
    //   374	2	2	localIOException3	java.io.IOException
    //   392	47	2	localObject2	Object
    //   445	9	2	localIOException4	java.io.IOException
    //   471	1	2	localZipOutputStream1	java.util.zip.ZipOutputStream
    //   475	1	2	localObject3	Object
    //   485	1	2	localObject4	Object
    //   489	1	2	localObject5	Object
    //   502	19	2	localObject6	Object
    //   527	2	2	localIOException5	java.io.IOException
    //   541	2	2	localIOException6	java.io.IOException
    //   547	44	2	localObject7	Object
    //   11	565	3	localObject8	Object
    //   582	2	3	localIOException7	java.io.IOException
    //   30	195	4	localObject9	Object
    //   242	1	4	localObject10	Object
    //   247	1	4	localException1	java.lang.Exception
    //   252	8	4	localObject11	Object
    //   266	8	4	localException2	java.lang.Exception
    //   278	271	4	localObject12	Object
    //   564	3	4	localIOException8	java.io.IOException
    //   34	523	5	localObject13	Object
    //   77	110	6	localBufferedInputStream	java.io.BufferedInputStream
    //   194	10	6	localIOException9	java.io.IOException
    //   261	41	6	localObject14	Object
    //   309	10	6	localIOException10	java.io.IOException
    //   384	81	6	localObject15	Object
    //   467	1	6	localException3	java.lang.Exception
    //   482	1	6	localException4	java.lang.Exception
    //   499	13	6	localException5	java.lang.Exception
    //   27	443	7	localZipOutputStream2	java.util.zip.ZipOutputStream
    //   41	105	8	arrayOfByte	byte[]
    //   237	1	8	localException6	java.lang.Exception
    //   257	149	8	localObject16	Object
    //   413	10	8	localIOException11	java.io.IOException
    //   54	41	9	str	String
    // Exception table:
    //   from	to	target	type
    //   186	191	194	java/io/IOException
    //   215	219	222	java/io/IOException
    //   86	112	237	java/lang/Exception
    //   119	131	237	java/lang/Exception
    //   143	152	237	java/lang/Exception
    //   162	167	237	java/lang/Exception
    //   174	179	237	java/lang/Exception
    //   66	79	242	finally
    //   66	79	247	java/lang/Exception
    //   56	66	252	finally
    //   56	66	266	java/lang/Exception
    //   301	306	309	java/io/IOException
    //   334	338	341	java/io/IOException
    //   366	371	374	java/io/IOException
    //   86	112	384	finally
    //   119	131	384	finally
    //   143	152	384	finally
    //   162	167	384	finally
    //   174	179	384	finally
    //   284	289	384	finally
    //   405	410	413	java/io/IOException
    //   438	442	445	java/io/IOException
    //   36	43	467	java/lang/Exception
    //   50	56	467	java/lang/Exception
    //   186	191	467	java/lang/Exception
    //   203	208	467	java/lang/Exception
    //   215	219	467	java/lang/Exception
    //   230	234	467	java/lang/Exception
    //   301	306	467	java/lang/Exception
    //   318	323	467	java/lang/Exception
    //   334	338	467	java/lang/Exception
    //   352	366	467	java/lang/Exception
    //   405	410	467	java/lang/Exception
    //   422	427	467	java/lang/Exception
    //   438	442	467	java/lang/Exception
    //   453	457	467	java/lang/Exception
    //   464	467	467	java/lang/Exception
    //   12	29	475	finally
    //   12	29	482	java/lang/Exception
    //   0	12	489	finally
    //   0	12	499	java/lang/Exception
    //   520	524	527	java/io/IOException
    //   379	383	541	java/io/IOException
    //   536	540	541	java/io/IOException
    //   36	43	547	finally
    //   50	56	547	finally
    //   186	191	547	finally
    //   203	208	547	finally
    //   215	219	547	finally
    //   230	234	547	finally
    //   301	306	547	finally
    //   318	323	547	finally
    //   334	338	547	finally
    //   352	366	547	finally
    //   405	410	547	finally
    //   422	427	547	finally
    //   438	442	547	finally
    //   453	457	547	finally
    //   464	467	547	finally
    //   511	516	547	finally
    //   556	561	564	java/io/IOException
    //   575	579	582	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsLogReport.a
 * JD-Core Version:    0.7.0.1
 */