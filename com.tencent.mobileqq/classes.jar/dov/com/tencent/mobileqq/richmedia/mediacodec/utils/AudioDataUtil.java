package dov.com.tencent.mobileqq.richmedia.mediacodec.utils;

public class AudioDataUtil
{
  private static int a(int paramInt1, int paramInt2)
  {
    int j = paramInt1 % paramInt2;
    int i = paramInt1;
    if (j != 0) {
      i = paramInt1 + (paramInt2 - j);
    }
    return i;
  }
  
  /* Error */
  public static int a(java.lang.String paramString1, java.lang.String paramString2, float paramFloat1, float paramFloat2)
  {
    // Byte code:
    //   0: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   3: lstore 9
    //   5: fload_2
    //   6: fconst_0
    //   7: fcmpg
    //   8: iflt +39 -> 47
    //   11: fload_2
    //   12: fconst_1
    //   13: fcmpl
    //   14: ifgt +33 -> 47
    //   17: fload_3
    //   18: fconst_0
    //   19: fcmpg
    //   20: iflt +27 -> 47
    //   23: fload_3
    //   24: fconst_1
    //   25: fcmpl
    //   26: ifgt +21 -> 47
    //   29: fload_2
    //   30: fload_3
    //   31: fcmpl
    //   32: ifgt +15 -> 47
    //   35: fload_2
    //   36: fload_3
    //   37: fcmpl
    //   38: ifne +41 -> 79
    //   41: fload_2
    //   42: fconst_0
    //   43: fcmpl
    //   44: ifeq +35 -> 79
    //   47: ldc 24
    //   49: ldc 26
    //   51: iconst_2
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: fload_2
    //   58: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: fload_3
    //   65: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   68: aastore
    //   69: invokestatic 38	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: ldc 39
    //   74: istore 5
    //   76: iload 5
    //   78: ireturn
    //   79: new 41	java/io/File
    //   82: dup
    //   83: aload_0
    //   84: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   87: astore 18
    //   89: aload 18
    //   91: invokevirtual 47	java/io/File:length	()J
    //   94: l2i
    //   95: istore 6
    //   97: aload 18
    //   99: invokevirtual 51	java/io/File:exists	()Z
    //   102: ifeq +8 -> 110
    //   105: iload 6
    //   107: ifgt +39 -> 146
    //   110: ldc 24
    //   112: ldc 53
    //   114: iconst_3
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: fload_2
    //   121: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   124: aastore
    //   125: dup
    //   126: iconst_1
    //   127: fload_3
    //   128: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   131: aastore
    //   132: dup
    //   133: iconst_2
    //   134: iload 6
    //   136: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   139: aastore
    //   140: invokestatic 38	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc 59
    //   145: ireturn
    //   146: aload_0
    //   147: aconst_null
    //   148: iconst_0
    //   149: invokestatic 64	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   152: astore_0
    //   153: fload_3
    //   154: fstore 4
    //   156: fload_3
    //   157: fconst_0
    //   158: fcmpl
    //   159: ifne +6 -> 165
    //   162: fconst_1
    //   163: fstore 4
    //   165: iload 6
    //   167: i2f
    //   168: fload_2
    //   169: fmul
    //   170: f2i
    //   171: aload_0
    //   172: getfield 70	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   175: invokestatic 72	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	(II)I
    //   178: istore 5
    //   180: iload 6
    //   182: i2f
    //   183: fload 4
    //   185: fmul
    //   186: f2i
    //   187: aload_0
    //   188: getfield 70	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   191: invokestatic 72	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	(II)I
    //   194: istore 6
    //   196: ldc 24
    //   198: new 74	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   205: ldc 77
    //   207: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload 5
    //   212: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   215: ldc 86
    //   217: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: iload 6
    //   222: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   225: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 93	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: iload 6
    //   233: iload 5
    //   235: isub
    //   236: istore 6
    //   238: sipush 20480
    //   241: newarray byte
    //   243: astore 19
    //   245: aconst_null
    //   246: astore_0
    //   247: aconst_null
    //   248: astore 14
    //   250: aconst_null
    //   251: astore 13
    //   253: aconst_null
    //   254: astore 16
    //   256: aconst_null
    //   257: astore 17
    //   259: aconst_null
    //   260: astore 15
    //   262: aload 17
    //   264: astore 12
    //   266: aload_0
    //   267: astore 11
    //   269: new 41	java/io/File
    //   272: dup
    //   273: aload_1
    //   274: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore_1
    //   278: aload 17
    //   280: astore 12
    //   282: aload_0
    //   283: astore 11
    //   285: aload_1
    //   286: invokevirtual 51	java/io/File:exists	()Z
    //   289: ifeq +15 -> 304
    //   292: aload 17
    //   294: astore 12
    //   296: aload_0
    //   297: astore 11
    //   299: aload_1
    //   300: invokevirtual 96	java/io/File:delete	()Z
    //   303: pop
    //   304: aload 17
    //   306: astore 12
    //   308: aload_0
    //   309: astore 11
    //   311: aload_1
    //   312: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   315: invokevirtual 51	java/io/File:exists	()Z
    //   318: ifne +18 -> 336
    //   321: aload 17
    //   323: astore 12
    //   325: aload_0
    //   326: astore 11
    //   328: aload_1
    //   329: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   332: invokevirtual 103	java/io/File:mkdirs	()Z
    //   335: pop
    //   336: aload 17
    //   338: astore 12
    //   340: aload_0
    //   341: astore 11
    //   343: aload_1
    //   344: invokevirtual 106	java/io/File:createNewFile	()Z
    //   347: pop
    //   348: aload 17
    //   350: astore 12
    //   352: aload_0
    //   353: astore 11
    //   355: new 108	java/io/FileOutputStream
    //   358: dup
    //   359: aload_1
    //   360: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   363: astore_0
    //   364: new 113	java/io/FileInputStream
    //   367: dup
    //   368: aload 18
    //   370: invokespecial 114	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   373: astore_1
    //   374: aload_1
    //   375: ifnull +76 -> 451
    //   378: aload_0
    //   379: ifnull +72 -> 451
    //   382: iload 5
    //   384: ifeq +392 -> 776
    //   387: iload 5
    //   389: i2l
    //   390: lstore 7
    //   392: aload_1
    //   393: lload 7
    //   395: invokevirtual 118	java/io/FileInputStream:skip	(J)J
    //   398: pop2
    //   399: goto +377 -> 776
    //   402: aload_1
    //   403: aload 19
    //   405: iconst_0
    //   406: sipush 20480
    //   409: invokevirtual 122	java/io/FileInputStream:read	([BII)I
    //   412: istore 5
    //   414: iload 5
    //   416: iconst_m1
    //   417: if_icmpeq +30 -> 447
    //   420: iload 5
    //   422: i2l
    //   423: lload 7
    //   425: ladd
    //   426: iload 6
    //   428: i2l
    //   429: lcmp
    //   430: ifle +68 -> 498
    //   433: aload_0
    //   434: aload 19
    //   436: iconst_0
    //   437: iload 6
    //   439: i2l
    //   440: lload 7
    //   442: lsub
    //   443: l2i
    //   444: invokevirtual 126	java/io/FileOutputStream:write	([BII)V
    //   447: aload_0
    //   448: invokevirtual 129	java/io/FileOutputStream:flush	()V
    //   451: aload_1
    //   452: ifnull +7 -> 459
    //   455: aload_1
    //   456: invokevirtual 132	java/io/FileInputStream:close	()V
    //   459: aload_0
    //   460: ifnull +7 -> 467
    //   463: aload_0
    //   464: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   467: ldc 24
    //   469: new 74	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   476: ldc 135
    //   478: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   484: lload 9
    //   486: lsub
    //   487: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   490: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 93	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   496: iconst_0
    //   497: ireturn
    //   498: aload_0
    //   499: aload 19
    //   501: iconst_0
    //   502: iload 5
    //   504: invokevirtual 126	java/io/FileOutputStream:write	([BII)V
    //   507: lload 7
    //   509: iload 5
    //   511: i2l
    //   512: ladd
    //   513: lstore 7
    //   515: goto -113 -> 402
    //   518: astore_1
    //   519: aload_1
    //   520: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   523: goto -64 -> 459
    //   526: astore_0
    //   527: aload_0
    //   528: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   531: goto -64 -> 467
    //   534: astore 11
    //   536: aconst_null
    //   537: astore_0
    //   538: aload 15
    //   540: astore_1
    //   541: aload 11
    //   543: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   546: ldc 142
    //   548: istore 5
    //   550: aload_0
    //   551: ifnull +7 -> 558
    //   554: aload_0
    //   555: invokevirtual 132	java/io/FileInputStream:close	()V
    //   558: aload_1
    //   559: ifnull -483 -> 76
    //   562: aload_1
    //   563: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   566: ldc 142
    //   568: ireturn
    //   569: astore_0
    //   570: aload_0
    //   571: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   574: ldc 142
    //   576: ireturn
    //   577: astore_0
    //   578: aload_0
    //   579: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   582: goto -24 -> 558
    //   585: astore_1
    //   586: aload 16
    //   588: astore_0
    //   589: aload_0
    //   590: astore 12
    //   592: aload 13
    //   594: astore 11
    //   596: ldc 24
    //   598: ldc 144
    //   600: invokestatic 146	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: aload_0
    //   604: astore 12
    //   606: aload 13
    //   608: astore 11
    //   610: aload_1
    //   611: invokevirtual 147	java/lang/Throwable:printStackTrace	()V
    //   614: ldc 142
    //   616: istore 5
    //   618: aload 13
    //   620: ifnull +8 -> 628
    //   623: aload 13
    //   625: invokevirtual 132	java/io/FileInputStream:close	()V
    //   628: aload_0
    //   629: ifnull -553 -> 76
    //   632: aload_0
    //   633: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   636: ldc 142
    //   638: ireturn
    //   639: astore_0
    //   640: aload_0
    //   641: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   644: ldc 142
    //   646: ireturn
    //   647: astore_1
    //   648: aload_1
    //   649: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   652: goto -24 -> 628
    //   655: astore_0
    //   656: aload 12
    //   658: astore_1
    //   659: aload 11
    //   661: ifnull +8 -> 669
    //   664: aload 11
    //   666: invokevirtual 132	java/io/FileInputStream:close	()V
    //   669: aload_1
    //   670: ifnull +7 -> 677
    //   673: aload_1
    //   674: invokevirtual 133	java/io/FileOutputStream:close	()V
    //   677: aload_0
    //   678: athrow
    //   679: astore 11
    //   681: aload 11
    //   683: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   686: goto -17 -> 669
    //   689: astore_1
    //   690: aload_1
    //   691: invokevirtual 141	java/io/IOException:printStackTrace	()V
    //   694: goto -17 -> 677
    //   697: astore 11
    //   699: aload_0
    //   700: astore_1
    //   701: aload 11
    //   703: astore_0
    //   704: aload 14
    //   706: astore 11
    //   708: goto -49 -> 659
    //   711: astore 12
    //   713: aload_1
    //   714: astore 11
    //   716: aload_0
    //   717: astore_1
    //   718: aload 12
    //   720: astore_0
    //   721: goto -62 -> 659
    //   724: astore 12
    //   726: aload_0
    //   727: astore 11
    //   729: aload 12
    //   731: astore_0
    //   732: goto -73 -> 659
    //   735: astore_1
    //   736: goto -147 -> 589
    //   739: astore 11
    //   741: aload_1
    //   742: astore 13
    //   744: aload 11
    //   746: astore_1
    //   747: goto -158 -> 589
    //   750: astore 11
    //   752: aconst_null
    //   753: astore 12
    //   755: aload_0
    //   756: astore_1
    //   757: aload 12
    //   759: astore_0
    //   760: goto -219 -> 541
    //   763: astore 11
    //   765: aload_1
    //   766: astore 12
    //   768: aload_0
    //   769: astore_1
    //   770: aload 12
    //   772: astore_0
    //   773: goto -232 -> 541
    //   776: lconst_0
    //   777: lstore 7
    //   779: goto -377 -> 402
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	782	0	paramString1	java.lang.String
    //   0	782	1	paramString2	java.lang.String
    //   0	782	2	paramFloat1	float
    //   0	782	3	paramFloat2	float
    //   154	30	4	f	float
    //   74	543	5	i	int
    //   95	343	6	j	int
    //   390	388	7	l1	long
    //   3	482	9	l2	long
    //   267	87	11	str1	java.lang.String
    //   534	8	11	localIOException1	java.io.IOException
    //   594	71	11	str2	java.lang.String
    //   679	3	11	localIOException2	java.io.IOException
    //   697	5	11	localObject1	Object
    //   706	22	11	localObject2	Object
    //   739	6	11	localThrowable	java.lang.Throwable
    //   750	1	11	localIOException3	java.io.IOException
    //   763	1	11	localIOException4	java.io.IOException
    //   264	393	12	localObject3	Object
    //   711	8	12	localObject4	Object
    //   724	6	12	localObject5	Object
    //   753	18	12	str3	java.lang.String
    //   251	492	13	str4	java.lang.String
    //   248	457	14	localObject6	Object
    //   260	279	15	localObject7	Object
    //   254	333	16	localObject8	Object
    //   257	92	17	localObject9	Object
    //   87	282	18	localFile	java.io.File
    //   243	257	19	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   455	459	518	java/io/IOException
    //   463	467	526	java/io/IOException
    //   269	278	534	java/io/IOException
    //   285	292	534	java/io/IOException
    //   299	304	534	java/io/IOException
    //   311	321	534	java/io/IOException
    //   328	336	534	java/io/IOException
    //   343	348	534	java/io/IOException
    //   355	364	534	java/io/IOException
    //   562	566	569	java/io/IOException
    //   554	558	577	java/io/IOException
    //   269	278	585	java/lang/Throwable
    //   285	292	585	java/lang/Throwable
    //   299	304	585	java/lang/Throwable
    //   311	321	585	java/lang/Throwable
    //   328	336	585	java/lang/Throwable
    //   343	348	585	java/lang/Throwable
    //   355	364	585	java/lang/Throwable
    //   632	636	639	java/io/IOException
    //   623	628	647	java/io/IOException
    //   269	278	655	finally
    //   285	292	655	finally
    //   299	304	655	finally
    //   311	321	655	finally
    //   328	336	655	finally
    //   343	348	655	finally
    //   355	364	655	finally
    //   596	603	655	finally
    //   610	614	655	finally
    //   664	669	679	java/io/IOException
    //   673	677	689	java/io/IOException
    //   364	374	697	finally
    //   392	399	711	finally
    //   402	414	711	finally
    //   433	447	711	finally
    //   447	451	711	finally
    //   498	507	711	finally
    //   541	546	724	finally
    //   364	374	735	java/lang/Throwable
    //   392	399	739	java/lang/Throwable
    //   402	414	739	java/lang/Throwable
    //   433	447	739	java/lang/Throwable
    //   447	451	739	java/lang/Throwable
    //   498	507	739	java/lang/Throwable
    //   364	374	750	java/io/IOException
    //   392	399	763	java/io/IOException
    //   402	414	763	java/io/IOException
    //   433	447	763	java/io/IOException
    //   447	451	763	java/io/IOException
    //   498	507	763	java/io/IOException
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2 * 2);
    paramInt2 = 0;
    while (paramInt2 < i / 2)
    {
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(paramInt2 * 2 + paramInt1)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt2 * 2 + paramInt1 + 1)];
      paramInt2 += 2;
    }
    return i;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    int j = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2 / paramInt3);
    paramInt2 = 0;
    while (paramInt2 < j - 1)
    {
      int i = 0;
      while (i < paramInt3)
      {
        paramArrayOfByte2[(paramInt2 * paramInt3 + i * 2)] = paramArrayOfByte1[(paramInt1 + paramInt2)];
        paramArrayOfByte2[(paramInt2 * paramInt3 + i * 2 + 1)] = paramArrayOfByte1[(paramInt1 + paramInt2 + 1)];
        i += 1;
      }
      paramInt2 += 2;
    }
    return j;
  }
  
  public static int b(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramInt2 * 3 / 2;
    paramInt2 = i;
    if (i % 2 == 1) {
      paramInt2 = i - 1;
    }
    i = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2);
    paramInt2 = 0;
    while (paramInt2 * 3 / 2 < i)
    {
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(paramInt2 * 3 / 2 + paramInt1 - paramInt2 / 2 % 2)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt2 * 3 / 2 + paramInt1 - paramInt2 / 2 % 2 + 1)];
      paramInt2 += 2;
    }
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = 0;
    int j = paramArrayOfByte1.length - paramInt1 - paramInt2;
    paramInt1 = j;
    if (j < 0) {
      paramInt1 = 0;
    }
    j = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2);
    paramInt2 = i;
    while (paramInt2 < j - 1)
    {
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(paramInt1 + j - paramInt2 - 2)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(paramInt1 + j - paramInt2 - 1)];
      paramInt2 += 2;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil
 * JD-Core Version:    0.7.0.1
 */