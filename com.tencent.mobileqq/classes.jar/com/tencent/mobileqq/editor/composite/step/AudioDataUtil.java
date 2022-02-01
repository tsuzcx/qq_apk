package com.tencent.mobileqq.editor.composite.step;

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
    //   3: lstore 12
    //   5: fload_2
    //   6: fconst_0
    //   7: fcmpg
    //   8: iflt +735 -> 743
    //   11: fconst_1
    //   12: fstore 4
    //   14: fload_2
    //   15: fconst_1
    //   16: fcmpl
    //   17: ifgt +726 -> 743
    //   20: fload_3
    //   21: fconst_0
    //   22: fcmpg
    //   23: iflt +720 -> 743
    //   26: fload_3
    //   27: fconst_1
    //   28: fcmpl
    //   29: ifgt +714 -> 743
    //   32: fload_2
    //   33: fload_3
    //   34: fcmpl
    //   35: ifgt +708 -> 743
    //   38: fload_2
    //   39: fload_3
    //   40: fcmpl
    //   41: ifne +12 -> 53
    //   44: fload_2
    //   45: fconst_0
    //   46: fcmpl
    //   47: ifeq +6 -> 53
    //   50: goto +693 -> 743
    //   53: new 24	java/io/File
    //   56: dup
    //   57: aload_0
    //   58: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   61: astore 20
    //   63: aload 20
    //   65: invokevirtual 30	java/io/File:length	()J
    //   68: l2i
    //   69: istore 5
    //   71: aload 20
    //   73: invokevirtual 34	java/io/File:exists	()Z
    //   76: ifeq +631 -> 707
    //   79: iload 5
    //   81: ifgt +6 -> 87
    //   84: goto +623 -> 707
    //   87: aconst_null
    //   88: astore 19
    //   90: aconst_null
    //   91: astore 17
    //   93: aconst_null
    //   94: astore 16
    //   96: aconst_null
    //   97: astore 18
    //   99: aload_0
    //   100: aconst_null
    //   101: iconst_0
    //   102: invokestatic 39	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   105: astore_0
    //   106: fload_3
    //   107: fconst_0
    //   108: fcmpl
    //   109: ifne +9 -> 118
    //   112: fload 4
    //   114: fstore_3
    //   115: goto +3 -> 118
    //   118: iload 5
    //   120: i2f
    //   121: fstore 4
    //   123: fload 4
    //   125: fload_2
    //   126: fmul
    //   127: f2i
    //   128: aload_0
    //   129: getfield 45	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   132: invokestatic 47	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	(II)I
    //   135: istore 5
    //   137: fload 4
    //   139: fload_3
    //   140: fmul
    //   141: f2i
    //   142: aload_0
    //   143: getfield 45	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   146: invokestatic 47	com/tencent/mobileqq/editor/composite/step/AudioDataUtil:a	(II)I
    //   149: istore 6
    //   151: new 49	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   158: astore_0
    //   159: aload_0
    //   160: ldc 52
    //   162: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_0
    //   167: iload 5
    //   169: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload_0
    //   174: ldc 61
    //   176: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_0
    //   181: iload 6
    //   183: invokevirtual 59	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: ldc 63
    //   189: aload_0
    //   190: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 72	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: sipush 20480
    //   199: newarray byte
    //   201: astore 21
    //   203: new 24	java/io/File
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;)V
    //   211: astore_0
    //   212: aload_0
    //   213: invokevirtual 34	java/io/File:exists	()Z
    //   216: ifeq +8 -> 224
    //   219: aload_0
    //   220: invokevirtual 75	java/io/File:delete	()Z
    //   223: pop
    //   224: aload_0
    //   225: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
    //   228: invokevirtual 34	java/io/File:exists	()Z
    //   231: ifne +11 -> 242
    //   234: aload_0
    //   235: invokevirtual 79	java/io/File:getParentFile	()Ljava/io/File;
    //   238: invokevirtual 82	java/io/File:mkdirs	()Z
    //   241: pop
    //   242: aload_0
    //   243: invokevirtual 85	java/io/File:createNewFile	()Z
    //   246: pop
    //   247: new 87	java/io/FileOutputStream
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 90	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   255: astore_0
    //   256: aload 17
    //   258: astore_1
    //   259: aload_0
    //   260: astore 16
    //   262: new 92	java/io/FileInputStream
    //   265: dup
    //   266: aload 20
    //   268: invokespecial 93	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   271: astore 17
    //   273: iload 5
    //   275: ifeq +49 -> 324
    //   278: iload 5
    //   280: i2l
    //   281: lstore 8
    //   283: aload 17
    //   285: lload 8
    //   287: invokevirtual 97	java/io/FileInputStream:skip	(J)J
    //   290: pop2
    //   291: goto +33 -> 324
    //   294: astore_1
    //   295: aload 17
    //   297: astore 16
    //   299: goto +370 -> 669
    //   302: astore_1
    //   303: aload 17
    //   305: astore 18
    //   307: aload_1
    //   308: astore 17
    //   310: goto +223 -> 533
    //   313: astore_1
    //   314: aload 17
    //   316: astore 18
    //   318: aload_1
    //   319: astore 17
    //   321: goto +281 -> 602
    //   324: lconst_0
    //   325: lstore 8
    //   327: aload 17
    //   329: astore_1
    //   330: aload_1
    //   331: aload 21
    //   333: iconst_0
    //   334: sipush 20480
    //   337: invokevirtual 101	java/io/FileInputStream:read	([BII)I
    //   340: istore 7
    //   342: iload 7
    //   344: iconst_m1
    //   345: if_icmpeq +426 -> 771
    //   348: iload 7
    //   350: i2l
    //   351: lload 8
    //   353: ladd
    //   354: lstore 10
    //   356: iload 6
    //   358: iload 5
    //   360: isub
    //   361: i2l
    //   362: lstore 14
    //   364: lload 10
    //   366: lload 14
    //   368: lcmp
    //   369: ifle +23 -> 392
    //   372: lload 14
    //   374: lload 8
    //   376: lsub
    //   377: l2i
    //   378: istore 5
    //   380: aload_0
    //   381: aload 21
    //   383: iconst_0
    //   384: iload 5
    //   386: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   389: goto +19 -> 408
    //   392: aload_0
    //   393: aload 21
    //   395: iconst_0
    //   396: iload 7
    //   398: invokevirtual 105	java/io/FileOutputStream:write	([BII)V
    //   401: lload 10
    //   403: lstore 8
    //   405: goto -75 -> 330
    //   408: aload_0
    //   409: invokevirtual 108	java/io/FileOutputStream:flush	()V
    //   412: aload_1
    //   413: invokevirtual 111	java/io/FileInputStream:close	()V
    //   416: goto +8 -> 424
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   424: aload_0
    //   425: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   428: goto +8 -> 436
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   436: new 49	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   443: astore_0
    //   444: aload_0
    //   445: ldc 117
    //   447: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_0
    //   452: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   455: lload 12
    //   457: lsub
    //   458: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   461: pop
    //   462: ldc 63
    //   464: aload_0
    //   465: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 72	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: iconst_0
    //   472: ireturn
    //   473: astore 16
    //   475: goto +15 -> 490
    //   478: astore 17
    //   480: goto +15 -> 495
    //   483: astore 17
    //   485: goto +18 -> 503
    //   488: astore 16
    //   490: goto +169 -> 659
    //   493: astore 17
    //   495: aload_1
    //   496: astore 18
    //   498: goto +35 -> 533
    //   501: astore 17
    //   503: aload_1
    //   504: astore 18
    //   506: goto +96 -> 602
    //   509: astore 17
    //   511: goto +22 -> 533
    //   514: astore 17
    //   516: aload 19
    //   518: astore 18
    //   520: goto +82 -> 602
    //   523: astore_1
    //   524: aconst_null
    //   525: astore_0
    //   526: goto +143 -> 669
    //   529: astore 17
    //   531: aconst_null
    //   532: astore_0
    //   533: aload 18
    //   535: astore_1
    //   536: aload_0
    //   537: astore 16
    //   539: ldc 63
    //   541: ldc 122
    //   543: invokestatic 125	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload 18
    //   548: astore_1
    //   549: aload_0
    //   550: astore 16
    //   552: aload 17
    //   554: invokevirtual 126	java/lang/Throwable:printStackTrace	()V
    //   557: aload 18
    //   559: ifnull +16 -> 575
    //   562: aload 18
    //   564: invokevirtual 111	java/io/FileInputStream:close	()V
    //   567: goto +8 -> 575
    //   570: astore_1
    //   571: aload_1
    //   572: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   575: aload_0
    //   576: ifnull +15 -> 591
    //   579: aload_0
    //   580: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   583: goto +8 -> 591
    //   586: astore_0
    //   587: aload_0
    //   588: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   591: ldc 127
    //   593: ireturn
    //   594: astore 17
    //   596: aconst_null
    //   597: astore_0
    //   598: aload 19
    //   600: astore 18
    //   602: aload 18
    //   604: astore_1
    //   605: aload_0
    //   606: astore 16
    //   608: aload 17
    //   610: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   613: aload 18
    //   615: ifnull +16 -> 631
    //   618: aload 18
    //   620: invokevirtual 111	java/io/FileInputStream:close	()V
    //   623: goto +8 -> 631
    //   626: astore_1
    //   627: aload_1
    //   628: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   631: aload_0
    //   632: ifnull +15 -> 647
    //   635: aload_0
    //   636: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   639: goto +8 -> 647
    //   642: astore_0
    //   643: aload_0
    //   644: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   647: ldc 127
    //   649: ireturn
    //   650: astore 17
    //   652: aload 16
    //   654: astore_0
    //   655: aload 17
    //   657: astore 16
    //   659: aload 16
    //   661: astore 17
    //   663: aload_1
    //   664: astore 16
    //   666: aload 17
    //   668: astore_1
    //   669: aload 16
    //   671: ifnull +18 -> 689
    //   674: aload 16
    //   676: invokevirtual 111	java/io/FileInputStream:close	()V
    //   679: goto +10 -> 689
    //   682: astore 16
    //   684: aload 16
    //   686: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   689: aload_0
    //   690: ifnull +15 -> 705
    //   693: aload_0
    //   694: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   697: goto +8 -> 705
    //   700: astore_0
    //   701: aload_0
    //   702: invokevirtual 114	java/io/IOException:printStackTrace	()V
    //   705: aload_1
    //   706: athrow
    //   707: ldc 63
    //   709: ldc 129
    //   711: iconst_3
    //   712: anewarray 4	java/lang/Object
    //   715: dup
    //   716: iconst_0
    //   717: fload_2
    //   718: invokestatic 135	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   721: aastore
    //   722: dup
    //   723: iconst_1
    //   724: fload_3
    //   725: invokestatic 135	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   728: aastore
    //   729: dup
    //   730: iconst_2
    //   731: iload 5
    //   733: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   736: aastore
    //   737: invokestatic 143	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: ldc 144
    //   742: ireturn
    //   743: ldc 63
    //   745: ldc 146
    //   747: iconst_2
    //   748: anewarray 4	java/lang/Object
    //   751: dup
    //   752: iconst_0
    //   753: fload_2
    //   754: invokestatic 135	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   757: aastore
    //   758: dup
    //   759: iconst_1
    //   760: fload_3
    //   761: invokestatic 135	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   764: aastore
    //   765: invokestatic 143	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   768: ldc 147
    //   770: ireturn
    //   771: goto -363 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	paramString1	java.lang.String
    //   0	774	1	paramString2	java.lang.String
    //   0	774	2	paramFloat1	float
    //   0	774	3	paramFloat2	float
    //   12	126	4	f	float
    //   69	663	5	i	int
    //   149	212	6	j	int
    //   340	57	7	k	int
    //   281	123	8	l1	long
    //   354	48	10	l2	long
    //   3	453	12	l3	long
    //   362	11	14	l4	long
    //   94	204	16	localObject1	Object
    //   473	1	16	localObject2	Object
    //   488	1	16	localObject3	Object
    //   537	138	16	localObject4	Object
    //   682	3	16	localIOException1	java.io.IOException
    //   91	237	17	localObject5	Object
    //   478	1	17	localThrowable1	java.lang.Throwable
    //   483	1	17	localIOException2	java.io.IOException
    //   493	1	17	localThrowable2	java.lang.Throwable
    //   501	1	17	localIOException3	java.io.IOException
    //   509	1	17	localThrowable3	java.lang.Throwable
    //   514	1	17	localIOException4	java.io.IOException
    //   529	24	17	localThrowable4	java.lang.Throwable
    //   594	15	17	localIOException5	java.io.IOException
    //   650	6	17	localObject6	Object
    //   661	6	17	localObject7	Object
    //   97	522	18	localObject8	Object
    //   88	511	19	localObject9	Object
    //   61	206	20	localFile	java.io.File
    //   201	193	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   283	291	294	finally
    //   283	291	302	java/lang/Throwable
    //   283	291	313	java/io/IOException
    //   412	416	419	java/io/IOException
    //   424	428	431	java/io/IOException
    //   380	389	473	finally
    //   392	401	473	finally
    //   408	412	473	finally
    //   380	389	478	java/lang/Throwable
    //   392	401	478	java/lang/Throwable
    //   408	412	478	java/lang/Throwable
    //   380	389	483	java/io/IOException
    //   392	401	483	java/io/IOException
    //   408	412	483	java/io/IOException
    //   330	342	488	finally
    //   330	342	493	java/lang/Throwable
    //   330	342	501	java/io/IOException
    //   262	273	509	java/lang/Throwable
    //   262	273	514	java/io/IOException
    //   203	224	523	finally
    //   224	242	523	finally
    //   242	256	523	finally
    //   203	224	529	java/lang/Throwable
    //   224	242	529	java/lang/Throwable
    //   242	256	529	java/lang/Throwable
    //   562	567	570	java/io/IOException
    //   579	583	586	java/io/IOException
    //   203	224	594	java/io/IOException
    //   224	242	594	java/io/IOException
    //   242	256	594	java/io/IOException
    //   618	623	626	java/io/IOException
    //   635	639	642	java/io/IOException
    //   262	273	650	finally
    //   539	546	650	finally
    //   552	557	650	finally
    //   608	613	650	finally
    //   674	679	682	java/io/IOException
    //   693	697	700	java/io/IOException
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2 * 2);
    paramInt2 = 0;
    while (paramInt2 < i / 2)
    {
      int j = paramInt2 * 2 + paramInt1;
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[j];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(j + 1)];
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
        int k = paramInt2 * paramInt3 + i * 2;
        int m = paramInt1 + paramInt2;
        paramArrayOfByte2[k] = paramArrayOfByte1[m];
        paramArrayOfByte2[(k + 1)] = paramArrayOfByte1[(m + 1)];
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
    for (;;)
    {
      int j = paramInt2 * 3 / 2;
      if (j >= i) {
        break;
      }
      j = j + paramInt1 - paramInt2 / 2 % 2;
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[j];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(j + 1)];
      paramInt2 += 2;
    }
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int j = paramArrayOfByte1.length - paramInt1 - paramInt2;
    int i = 0;
    paramInt1 = j;
    if (j < 0) {
      paramInt1 = 0;
    }
    j = Math.min(paramArrayOfByte1.length - paramInt1, paramInt2);
    paramInt2 = i;
    while (paramInt2 < j - 1)
    {
      i = paramInt1 + j - paramInt2;
      paramArrayOfByte2[paramInt2] = paramArrayOfByte1[(i - 2)];
      paramArrayOfByte2[(paramInt2 + 1)] = paramArrayOfByte1[(i - 1)];
      paramInt2 += 2;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.step.AudioDataUtil
 * JD-Core Version:    0.7.0.1
 */