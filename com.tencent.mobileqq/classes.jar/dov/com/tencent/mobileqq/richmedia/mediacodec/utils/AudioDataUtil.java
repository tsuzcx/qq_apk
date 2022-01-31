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
    //   312: invokevirtual 99	java/io/File:createNewFile	()Z
    //   315: pop
    //   316: aload 17
    //   318: astore 12
    //   320: aload_0
    //   321: astore 11
    //   323: new 101	java/io/FileOutputStream
    //   326: dup
    //   327: aload_1
    //   328: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   331: astore_0
    //   332: new 106	java/io/FileInputStream
    //   335: dup
    //   336: aload 18
    //   338: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   341: astore_1
    //   342: aload_1
    //   343: ifnull +76 -> 419
    //   346: aload_0
    //   347: ifnull +72 -> 419
    //   350: iload 5
    //   352: ifeq +392 -> 744
    //   355: iload 5
    //   357: i2l
    //   358: lstore 7
    //   360: aload_1
    //   361: lload 7
    //   363: invokevirtual 111	java/io/FileInputStream:skip	(J)J
    //   366: pop2
    //   367: goto +377 -> 744
    //   370: aload_1
    //   371: aload 19
    //   373: iconst_0
    //   374: sipush 20480
    //   377: invokevirtual 115	java/io/FileInputStream:read	([BII)I
    //   380: istore 5
    //   382: iload 5
    //   384: iconst_m1
    //   385: if_icmpeq +30 -> 415
    //   388: iload 5
    //   390: i2l
    //   391: lload 7
    //   393: ladd
    //   394: iload 6
    //   396: i2l
    //   397: lcmp
    //   398: ifle +68 -> 466
    //   401: aload_0
    //   402: aload 19
    //   404: iconst_0
    //   405: iload 6
    //   407: i2l
    //   408: lload 7
    //   410: lsub
    //   411: l2i
    //   412: invokevirtual 119	java/io/FileOutputStream:write	([BII)V
    //   415: aload_0
    //   416: invokevirtual 122	java/io/FileOutputStream:flush	()V
    //   419: aload_1
    //   420: ifnull +7 -> 427
    //   423: aload_1
    //   424: invokevirtual 125	java/io/FileInputStream:close	()V
    //   427: aload_0
    //   428: ifnull +7 -> 435
    //   431: aload_0
    //   432: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   435: ldc 24
    //   437: new 74	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   444: ldc 128
    //   446: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   452: lload 9
    //   454: lsub
    //   455: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   458: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 93	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: iconst_0
    //   465: ireturn
    //   466: aload_0
    //   467: aload 19
    //   469: iconst_0
    //   470: iload 5
    //   472: invokevirtual 119	java/io/FileOutputStream:write	([BII)V
    //   475: lload 7
    //   477: iload 5
    //   479: i2l
    //   480: ladd
    //   481: lstore 7
    //   483: goto -113 -> 370
    //   486: astore_1
    //   487: aload_1
    //   488: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   491: goto -64 -> 427
    //   494: astore_0
    //   495: aload_0
    //   496: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   499: goto -64 -> 435
    //   502: astore 11
    //   504: aconst_null
    //   505: astore_0
    //   506: aload 15
    //   508: astore_1
    //   509: aload 11
    //   511: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   514: ldc 135
    //   516: istore 5
    //   518: aload_0
    //   519: ifnull +7 -> 526
    //   522: aload_0
    //   523: invokevirtual 125	java/io/FileInputStream:close	()V
    //   526: aload_1
    //   527: ifnull -451 -> 76
    //   530: aload_1
    //   531: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   534: ldc 135
    //   536: ireturn
    //   537: astore_0
    //   538: aload_0
    //   539: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   542: ldc 135
    //   544: ireturn
    //   545: astore_0
    //   546: aload_0
    //   547: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   550: goto -24 -> 526
    //   553: astore_1
    //   554: aload 16
    //   556: astore_0
    //   557: aload_0
    //   558: astore 12
    //   560: aload 13
    //   562: astore 11
    //   564: ldc 24
    //   566: ldc 137
    //   568: invokestatic 139	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload_0
    //   572: astore 12
    //   574: aload 13
    //   576: astore 11
    //   578: aload_1
    //   579: invokevirtual 140	java/lang/Throwable:printStackTrace	()V
    //   582: ldc 135
    //   584: istore 5
    //   586: aload 13
    //   588: ifnull +8 -> 596
    //   591: aload 13
    //   593: invokevirtual 125	java/io/FileInputStream:close	()V
    //   596: aload_0
    //   597: ifnull -521 -> 76
    //   600: aload_0
    //   601: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   604: ldc 135
    //   606: ireturn
    //   607: astore_0
    //   608: aload_0
    //   609: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   612: ldc 135
    //   614: ireturn
    //   615: astore_1
    //   616: aload_1
    //   617: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   620: goto -24 -> 596
    //   623: astore_0
    //   624: aload 12
    //   626: astore_1
    //   627: aload 11
    //   629: ifnull +8 -> 637
    //   632: aload 11
    //   634: invokevirtual 125	java/io/FileInputStream:close	()V
    //   637: aload_1
    //   638: ifnull +7 -> 645
    //   641: aload_1
    //   642: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   645: aload_0
    //   646: athrow
    //   647: astore 11
    //   649: aload 11
    //   651: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   654: goto -17 -> 637
    //   657: astore_1
    //   658: aload_1
    //   659: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   662: goto -17 -> 645
    //   665: astore 11
    //   667: aload_0
    //   668: astore_1
    //   669: aload 11
    //   671: astore_0
    //   672: aload 14
    //   674: astore 11
    //   676: goto -49 -> 627
    //   679: astore 12
    //   681: aload_1
    //   682: astore 11
    //   684: aload_0
    //   685: astore_1
    //   686: aload 12
    //   688: astore_0
    //   689: goto -62 -> 627
    //   692: astore 12
    //   694: aload_0
    //   695: astore 11
    //   697: aload 12
    //   699: astore_0
    //   700: goto -73 -> 627
    //   703: astore_1
    //   704: goto -147 -> 557
    //   707: astore 11
    //   709: aload_1
    //   710: astore 13
    //   712: aload 11
    //   714: astore_1
    //   715: goto -158 -> 557
    //   718: astore 11
    //   720: aconst_null
    //   721: astore 12
    //   723: aload_0
    //   724: astore_1
    //   725: aload 12
    //   727: astore_0
    //   728: goto -219 -> 509
    //   731: astore 11
    //   733: aload_1
    //   734: astore 12
    //   736: aload_0
    //   737: astore_1
    //   738: aload 12
    //   740: astore_0
    //   741: goto -232 -> 509
    //   744: lconst_0
    //   745: lstore 7
    //   747: goto -377 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	750	0	paramString1	java.lang.String
    //   0	750	1	paramString2	java.lang.String
    //   0	750	2	paramFloat1	float
    //   0	750	3	paramFloat2	float
    //   154	30	4	f	float
    //   74	511	5	i	int
    //   95	311	6	j	int
    //   358	388	7	l1	long
    //   3	450	9	l2	long
    //   267	55	11	str1	java.lang.String
    //   502	8	11	localIOException1	java.io.IOException
    //   562	71	11	str2	java.lang.String
    //   647	3	11	localIOException2	java.io.IOException
    //   665	5	11	localObject1	Object
    //   674	22	11	localObject2	Object
    //   707	6	11	localThrowable	java.lang.Throwable
    //   718	1	11	localIOException3	java.io.IOException
    //   731	1	11	localIOException4	java.io.IOException
    //   264	361	12	localObject3	Object
    //   679	8	12	localObject4	Object
    //   692	6	12	localObject5	Object
    //   721	18	12	str3	java.lang.String
    //   251	460	13	str4	java.lang.String
    //   248	425	14	localObject6	Object
    //   260	247	15	localObject7	Object
    //   254	301	16	localObject8	Object
    //   257	60	17	localObject9	Object
    //   87	250	18	localFile	java.io.File
    //   243	225	19	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   423	427	486	java/io/IOException
    //   431	435	494	java/io/IOException
    //   269	278	502	java/io/IOException
    //   285	292	502	java/io/IOException
    //   299	304	502	java/io/IOException
    //   311	316	502	java/io/IOException
    //   323	332	502	java/io/IOException
    //   530	534	537	java/io/IOException
    //   522	526	545	java/io/IOException
    //   269	278	553	java/lang/Throwable
    //   285	292	553	java/lang/Throwable
    //   299	304	553	java/lang/Throwable
    //   311	316	553	java/lang/Throwable
    //   323	332	553	java/lang/Throwable
    //   600	604	607	java/io/IOException
    //   591	596	615	java/io/IOException
    //   269	278	623	finally
    //   285	292	623	finally
    //   299	304	623	finally
    //   311	316	623	finally
    //   323	332	623	finally
    //   564	571	623	finally
    //   578	582	623	finally
    //   632	637	647	java/io/IOException
    //   641	645	657	java/io/IOException
    //   332	342	665	finally
    //   360	367	679	finally
    //   370	382	679	finally
    //   401	415	679	finally
    //   415	419	679	finally
    //   466	475	679	finally
    //   509	514	692	finally
    //   332	342	703	java/lang/Throwable
    //   360	367	707	java/lang/Throwable
    //   370	382	707	java/lang/Throwable
    //   401	415	707	java/lang/Throwable
    //   415	419	707	java/lang/Throwable
    //   466	475	707	java/lang/Throwable
    //   332	342	718	java/io/IOException
    //   360	367	731	java/io/IOException
    //   370	382	731	java/io/IOException
    //   401	415	731	java/io/IOException
    //   415	419	731	java/io/IOException
    //   466	475	731	java/io/IOException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.utils.AudioDataUtil
 * JD-Core Version:    0.7.0.1
 */