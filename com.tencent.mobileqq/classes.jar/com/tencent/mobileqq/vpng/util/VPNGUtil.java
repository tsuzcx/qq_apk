package com.tencent.mobileqq.vpng.util;

public class VPNGUtil
{
  private static final char[] a = { 73, 69, 78, 68 };
  private static final char[] b = { 118, 80, 78, 103 };
  private static final byte[] c = { -119, 80, 78, 71, 13, 10, 26, 10 };
  
  /* Error */
  public static boolean a(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 6
    //   6: iconst_0
    //   7: istore 4
    //   9: iconst_0
    //   10: istore 5
    //   12: iconst_0
    //   13: istore_3
    //   14: iload 6
    //   16: ifne +579 -> 595
    //   19: aload_1
    //   20: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: new 49	java/io/RandomAccessFile
    //   31: dup
    //   32: aload_0
    //   33: ldc 51
    //   35: invokespecial 54	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: astore_0
    //   39: new 56	java/io/FileOutputStream
    //   42: dup
    //   43: new 58	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: invokespecial 64	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore 9
    //   56: aload_0
    //   57: astore 7
    //   59: aload 9
    //   61: astore 8
    //   63: new 66	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct
    //   66: dup
    //   67: aconst_null
    //   68: invokespecial 69	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:<init>	(Lcom/tencent/mobileqq/vpng/util/VPNGUtil$1;)V
    //   71: astore 10
    //   73: aload_0
    //   74: astore 7
    //   76: aload 9
    //   78: astore 8
    //   80: bipush 8
    //   82: newarray byte
    //   84: astore 11
    //   86: aload_0
    //   87: astore 7
    //   89: aload 9
    //   91: astore 8
    //   93: bipush 8
    //   95: newarray byte
    //   97: astore 12
    //   99: aload_0
    //   100: astore 7
    //   102: aload 9
    //   104: astore 8
    //   106: aload_0
    //   107: aload 12
    //   109: iconst_0
    //   110: bipush 8
    //   112: invokevirtual 73	java/io/RandomAccessFile:read	([BII)I
    //   115: ifle +219 -> 334
    //   118: aload_0
    //   119: astore 7
    //   121: aload 9
    //   123: astore 8
    //   125: getstatic 29	com/tencent/mobileqq/vpng/util/VPNGUtil:c	[B
    //   128: aload 12
    //   130: invokestatic 79	java/util/Arrays:equals	([B[B)Z
    //   133: ifne +6 -> 139
    //   136: goto +198 -> 334
    //   139: aload_0
    //   140: astore 7
    //   142: aload 9
    //   144: astore 8
    //   146: aload_0
    //   147: aload 11
    //   149: iconst_0
    //   150: bipush 8
    //   152: invokevirtual 73	java/io/RandomAccessFile:read	([BII)I
    //   155: pop
    //   156: aload_0
    //   157: astore 7
    //   159: aload 9
    //   161: astore 8
    //   163: aload 10
    //   165: aload 11
    //   167: invokestatic 82	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:a	(Lcom/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct;[B)V
    //   170: aload_0
    //   171: astore 7
    //   173: aload 9
    //   175: astore 8
    //   177: getstatic 22	com/tencent/mobileqq/vpng/util/VPNGUtil:b	[C
    //   180: aload 10
    //   182: getfield 83	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:b	[C
    //   185: invokestatic 86	java/util/Arrays:equals	([C[C)Z
    //   188: ifeq +65 -> 253
    //   191: aload_0
    //   192: astore 7
    //   194: aload 9
    //   196: astore 8
    //   198: aload 10
    //   200: getfield 89	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:a	I
    //   203: istore_2
    //   204: aload_0
    //   205: astore 7
    //   207: aload 9
    //   209: astore 8
    //   211: iload_2
    //   212: newarray byte
    //   214: astore 10
    //   216: aload_0
    //   217: astore 7
    //   219: aload 9
    //   221: astore 8
    //   223: aload_0
    //   224: aload 10
    //   226: iconst_0
    //   227: iload_2
    //   228: invokevirtual 73	java/io/RandomAccessFile:read	([BII)I
    //   231: pop
    //   232: aload_0
    //   233: astore 7
    //   235: aload 9
    //   237: astore 8
    //   239: aload 9
    //   241: aload 10
    //   243: iconst_0
    //   244: iload_2
    //   245: invokevirtual 93	java/io/FileOutputStream:write	([BII)V
    //   248: iconst_1
    //   249: istore_3
    //   250: goto +28 -> 278
    //   253: aload_0
    //   254: astore 7
    //   256: aload 9
    //   258: astore 8
    //   260: getstatic 17	com/tencent/mobileqq/vpng/util/VPNGUtil:a	[C
    //   263: aload 10
    //   265: getfield 83	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:b	[C
    //   268: invokestatic 86	java/util/Arrays:equals	([C[C)Z
    //   271: istore 6
    //   273: iload 6
    //   275: ifeq +37 -> 312
    //   278: aload_0
    //   279: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   282: goto +8 -> 290
    //   285: astore_0
    //   286: aload_0
    //   287: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   290: iload_3
    //   291: istore 4
    //   293: aload 9
    //   295: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   298: goto +240 -> 538
    //   301: astore_0
    //   302: aload_0
    //   303: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   306: iload 4
    //   308: istore_3
    //   309: goto +229 -> 538
    //   312: aload_0
    //   313: astore 7
    //   315: aload 9
    //   317: astore 8
    //   319: aload_0
    //   320: aload 10
    //   322: getfield 89	com/tencent/mobileqq/vpng/util/VPNGUtil$PNGStruct:a	I
    //   325: iconst_4
    //   326: iadd
    //   327: invokevirtual 104	java/io/RandomAccessFile:skipBytes	(I)I
    //   330: pop
    //   331: goto -192 -> 139
    //   334: aload_0
    //   335: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   338: goto +8 -> 346
    //   341: astore_0
    //   342: aload_0
    //   343: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   346: aload 9
    //   348: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   351: iconst_0
    //   352: ireturn
    //   353: astore_0
    //   354: aload_0
    //   355: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   358: iconst_0
    //   359: ireturn
    //   360: astore 10
    //   362: aload_0
    //   363: astore 11
    //   365: aload 9
    //   367: astore_0
    //   368: goto +67 -> 435
    //   371: astore 10
    //   373: aload_0
    //   374: astore 11
    //   376: aload 9
    //   378: astore_0
    //   379: goto +113 -> 492
    //   382: astore_1
    //   383: aconst_null
    //   384: astore 8
    //   386: goto +173 -> 559
    //   389: astore 10
    //   391: aconst_null
    //   392: astore 7
    //   394: aload_0
    //   395: astore 11
    //   397: aload 7
    //   399: astore_0
    //   400: goto +35 -> 435
    //   403: astore 10
    //   405: aconst_null
    //   406: astore 7
    //   408: aload_0
    //   409: astore 11
    //   411: aload 7
    //   413: astore_0
    //   414: goto +78 -> 492
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 8
    //   421: aload 8
    //   423: astore_0
    //   424: goto +135 -> 559
    //   427: astore 10
    //   429: aconst_null
    //   430: astore 11
    //   432: aload 11
    //   434: astore_0
    //   435: aload 11
    //   437: astore 7
    //   439: aload_0
    //   440: astore 8
    //   442: aload 10
    //   444: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   447: aload 11
    //   449: ifnull +18 -> 467
    //   452: aload 11
    //   454: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   457: goto +10 -> 467
    //   460: astore 7
    //   462: aload 7
    //   464: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   467: iload 5
    //   469: istore_3
    //   470: aload_0
    //   471: ifnull +67 -> 538
    //   474: aload_0
    //   475: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   478: iload 5
    //   480: istore_3
    //   481: goto +57 -> 538
    //   484: astore 10
    //   486: aconst_null
    //   487: astore 11
    //   489: aload 11
    //   491: astore_0
    //   492: aload 11
    //   494: astore 7
    //   496: aload_0
    //   497: astore 8
    //   499: aload 10
    //   501: invokevirtual 105	java/io/FileNotFoundException:printStackTrace	()V
    //   504: aload 11
    //   506: ifnull +18 -> 524
    //   509: aload 11
    //   511: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   514: goto +10 -> 524
    //   517: astore 7
    //   519: aload 7
    //   521: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   524: iload 5
    //   526: istore_3
    //   527: aload_0
    //   528: ifnull +10 -> 538
    //   531: aload_0
    //   532: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   535: iload 5
    //   537: istore_3
    //   538: iload_3
    //   539: ifne +14 -> 553
    //   542: new 58	java/io/File
    //   545: dup
    //   546: aload_1
    //   547: invokespecial 61	java/io/File:<init>	(Ljava/lang/String;)V
    //   550: invokevirtual 108	java/io/File:deleteOnExit	()V
    //   553: iload_3
    //   554: ireturn
    //   555: astore_1
    //   556: aload 7
    //   558: astore_0
    //   559: aload_0
    //   560: ifnull +15 -> 575
    //   563: aload_0
    //   564: invokevirtual 96	java/io/RandomAccessFile:close	()V
    //   567: goto +8 -> 575
    //   570: astore_0
    //   571: aload_0
    //   572: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   575: aload 8
    //   577: ifnull +16 -> 593
    //   580: aload 8
    //   582: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   585: goto +8 -> 593
    //   588: astore_0
    //   589: aload_0
    //   590: invokevirtual 99	java/io/IOException:printStackTrace	()V
    //   593: aload_1
    //   594: athrow
    //   595: iconst_0
    //   596: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	597	0	paramString1	java.lang.String
    //   0	597	1	paramString2	java.lang.String
    //   203	42	2	i	int
    //   13	541	3	bool1	boolean
    //   7	300	4	bool2	boolean
    //   10	526	5	bool3	boolean
    //   4	270	6	bool4	boolean
    //   57	381	7	localObject1	Object
    //   460	3	7	localIOException1	java.io.IOException
    //   494	1	7	localObject2	Object
    //   517	40	7	localIOException2	java.io.IOException
    //   61	520	8	localObject3	Object
    //   54	323	9	localFileOutputStream	java.io.FileOutputStream
    //   71	250	10	localObject4	Object
    //   360	1	10	localIOException3	java.io.IOException
    //   371	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   389	1	10	localIOException4	java.io.IOException
    //   403	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   427	16	10	localIOException5	java.io.IOException
    //   484	16	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   84	426	11	localObject5	Object
    //   97	32	12	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   278	282	285	java/io/IOException
    //   293	298	301	java/io/IOException
    //   474	478	301	java/io/IOException
    //   531	535	301	java/io/IOException
    //   334	338	341	java/io/IOException
    //   346	351	353	java/io/IOException
    //   63	73	360	java/io/IOException
    //   80	86	360	java/io/IOException
    //   93	99	360	java/io/IOException
    //   106	118	360	java/io/IOException
    //   125	136	360	java/io/IOException
    //   146	156	360	java/io/IOException
    //   163	170	360	java/io/IOException
    //   177	191	360	java/io/IOException
    //   198	204	360	java/io/IOException
    //   211	216	360	java/io/IOException
    //   223	232	360	java/io/IOException
    //   239	248	360	java/io/IOException
    //   260	273	360	java/io/IOException
    //   319	331	360	java/io/IOException
    //   63	73	371	java/io/FileNotFoundException
    //   80	86	371	java/io/FileNotFoundException
    //   93	99	371	java/io/FileNotFoundException
    //   106	118	371	java/io/FileNotFoundException
    //   125	136	371	java/io/FileNotFoundException
    //   146	156	371	java/io/FileNotFoundException
    //   163	170	371	java/io/FileNotFoundException
    //   177	191	371	java/io/FileNotFoundException
    //   198	204	371	java/io/FileNotFoundException
    //   211	216	371	java/io/FileNotFoundException
    //   223	232	371	java/io/FileNotFoundException
    //   239	248	371	java/io/FileNotFoundException
    //   260	273	371	java/io/FileNotFoundException
    //   319	331	371	java/io/FileNotFoundException
    //   39	56	382	finally
    //   39	56	389	java/io/IOException
    //   39	56	403	java/io/FileNotFoundException
    //   28	39	417	finally
    //   28	39	427	java/io/IOException
    //   452	457	460	java/io/IOException
    //   28	39	484	java/io/FileNotFoundException
    //   509	514	517	java/io/IOException
    //   63	73	555	finally
    //   80	86	555	finally
    //   93	99	555	finally
    //   106	118	555	finally
    //   125	136	555	finally
    //   146	156	555	finally
    //   163	170	555	finally
    //   177	191	555	finally
    //   198	204	555	finally
    //   211	216	555	finally
    //   223	232	555	finally
    //   239	248	555	finally
    //   260	273	555	finally
    //   319	331	555	finally
    //   442	447	555	finally
    //   499	504	555	finally
    //   563	567	570	java/io/IOException
    //   580	585	588	java/io/IOException
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      j = j << 8 | paramArrayOfByte[i] & 0xFF;
      i += 1;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vpng.util.VPNGUtil
 * JD-Core Version:    0.7.0.1
 */