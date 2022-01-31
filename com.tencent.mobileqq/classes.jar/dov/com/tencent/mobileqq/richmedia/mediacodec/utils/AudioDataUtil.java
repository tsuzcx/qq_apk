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
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 14
    //   6: aconst_null
    //   7: astore 12
    //   9: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   12: lstore 7
    //   14: fload_2
    //   15: fconst_0
    //   16: fcmpg
    //   17: iflt +39 -> 56
    //   20: fload_2
    //   21: fconst_1
    //   22: fcmpl
    //   23: ifgt +33 -> 56
    //   26: fload_3
    //   27: fconst_0
    //   28: fcmpg
    //   29: iflt +27 -> 56
    //   32: fload_3
    //   33: fconst_1
    //   34: fcmpl
    //   35: ifgt +21 -> 56
    //   38: fload_2
    //   39: fload_3
    //   40: fcmpl
    //   41: ifgt +15 -> 56
    //   44: fload_2
    //   45: fload_3
    //   46: fcmpl
    //   47: ifne +41 -> 88
    //   50: fload_2
    //   51: fconst_0
    //   52: fcmpl
    //   53: ifeq +35 -> 88
    //   56: ldc 24
    //   58: ldc 26
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: fload_2
    //   67: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: fload_3
    //   74: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   77: aastore
    //   78: invokestatic 38	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: ldc 39
    //   83: istore 5
    //   85: iload 5
    //   87: ireturn
    //   88: new 41	java/io/File
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 11
    //   98: aload 11
    //   100: invokevirtual 47	java/io/File:length	()J
    //   103: l2i
    //   104: istore 6
    //   106: aload 11
    //   108: invokevirtual 51	java/io/File:exists	()Z
    //   111: ifeq +8 -> 119
    //   114: iload 6
    //   116: ifgt +39 -> 155
    //   119: ldc 24
    //   121: ldc 53
    //   123: iconst_3
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: fload_2
    //   130: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   133: aastore
    //   134: dup
    //   135: iconst_1
    //   136: fload_3
    //   137: invokestatic 32	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   140: aastore
    //   141: dup
    //   142: iconst_2
    //   143: iload 6
    //   145: invokestatic 58	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: invokestatic 38	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: ldc 59
    //   154: ireturn
    //   155: aload_0
    //   156: aconst_null
    //   157: iconst_0
    //   158: invokestatic 64	com/tencent/mobileqq/shortvideo/util/AudioEncoder:a	(Ljava/lang/String;Ljava/lang/String;I)Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   161: astore_0
    //   162: fload_3
    //   163: fstore 4
    //   165: fload_3
    //   166: fconst_0
    //   167: fcmpl
    //   168: ifne +6 -> 174
    //   171: fconst_1
    //   172: fstore 4
    //   174: iload 6
    //   176: i2f
    //   177: fload_2
    //   178: fmul
    //   179: f2i
    //   180: aload_0
    //   181: getfield 70	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   184: invokestatic 72	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	(II)I
    //   187: istore 5
    //   189: iload 6
    //   191: i2f
    //   192: fload 4
    //   194: fmul
    //   195: f2i
    //   196: aload_0
    //   197: getfield 70	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:b	I
    //   200: invokestatic 72	dov/com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	(II)I
    //   203: istore 6
    //   205: ldc 24
    //   207: new 74	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   214: ldc 77
    //   216: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: iload 5
    //   221: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   224: ldc 86
    //   226: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: iload 6
    //   231: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 93	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: iload 6
    //   242: iload 5
    //   244: isub
    //   245: newarray byte
    //   247: astore 15
    //   249: new 41	java/io/File
    //   252: dup
    //   253: aload_1
    //   254: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   257: astore_0
    //   258: aload_0
    //   259: invokevirtual 51	java/io/File:exists	()Z
    //   262: ifeq +8 -> 270
    //   265: aload_0
    //   266: invokevirtual 96	java/io/File:delete	()Z
    //   269: pop
    //   270: aload_0
    //   271: invokevirtual 99	java/io/File:createNewFile	()Z
    //   274: pop
    //   275: new 101	java/io/FileOutputStream
    //   278: dup
    //   279: aload_0
    //   280: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   283: astore_0
    //   284: new 106	java/io/FileInputStream
    //   287: dup
    //   288: aload 11
    //   290: invokespecial 107	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   293: astore 11
    //   295: aload 11
    //   297: ifnull +29 -> 326
    //   300: iload 5
    //   302: ifeq +16 -> 318
    //   305: iload 5
    //   307: i2l
    //   308: lstore 9
    //   310: aload 11
    //   312: lload 9
    //   314: invokevirtual 111	java/io/FileInputStream:skip	(J)J
    //   317: pop2
    //   318: aload 11
    //   320: aload 15
    //   322: invokevirtual 115	java/io/FileInputStream:read	([B)I
    //   325: pop
    //   326: aload_0
    //   327: aload 15
    //   329: invokevirtual 119	java/io/FileOutputStream:write	([B)V
    //   332: aload_0
    //   333: invokevirtual 122	java/io/FileOutputStream:flush	()V
    //   336: aload 11
    //   338: ifnull +8 -> 346
    //   341: aload 11
    //   343: invokevirtual 125	java/io/FileInputStream:close	()V
    //   346: aload_0
    //   347: ifnull +7 -> 354
    //   350: aload_0
    //   351: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   354: ldc 24
    //   356: new 74	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   363: ldc 128
    //   365: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokestatic 22	java/lang/System:currentTimeMillis	()J
    //   371: lload 7
    //   373: lsub
    //   374: invokevirtual 131	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   377: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 93	com/tencent/biz/qqstory/support/logging/SLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: iconst_0
    //   384: ireturn
    //   385: astore_1
    //   386: aload_1
    //   387: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   390: goto -44 -> 346
    //   393: astore_0
    //   394: aload_0
    //   395: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   398: goto -44 -> 354
    //   401: astore_1
    //   402: aconst_null
    //   403: astore_0
    //   404: aload 12
    //   406: astore 11
    //   408: aload_1
    //   409: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   412: ldc 135
    //   414: istore 5
    //   416: aload 11
    //   418: ifnull +8 -> 426
    //   421: aload 11
    //   423: invokevirtual 125	java/io/FileInputStream:close	()V
    //   426: aload_0
    //   427: ifnull -342 -> 85
    //   430: aload_0
    //   431: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   434: ldc 135
    //   436: ireturn
    //   437: astore_0
    //   438: aload_0
    //   439: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   442: ldc 135
    //   444: ireturn
    //   445: astore_1
    //   446: aload_1
    //   447: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   450: goto -24 -> 426
    //   453: astore_0
    //   454: aconst_null
    //   455: astore 11
    //   457: aload 13
    //   459: astore_1
    //   460: ldc 24
    //   462: ldc 137
    //   464: invokestatic 139	com/tencent/biz/qqstory/support/logging/SLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   467: aload_0
    //   468: invokevirtual 140	java/lang/Throwable:printStackTrace	()V
    //   471: ldc 135
    //   473: istore 5
    //   475: aload 11
    //   477: ifnull +8 -> 485
    //   480: aload 11
    //   482: invokevirtual 125	java/io/FileInputStream:close	()V
    //   485: aload_1
    //   486: ifnull -401 -> 85
    //   489: aload_1
    //   490: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   493: ldc 135
    //   495: ireturn
    //   496: astore_0
    //   497: aload_0
    //   498: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   501: ldc 135
    //   503: ireturn
    //   504: astore_0
    //   505: aload_0
    //   506: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   509: goto -24 -> 485
    //   512: astore_0
    //   513: aconst_null
    //   514: astore 11
    //   516: aload 14
    //   518: astore_1
    //   519: aload 11
    //   521: ifnull +8 -> 529
    //   524: aload 11
    //   526: invokevirtual 125	java/io/FileInputStream:close	()V
    //   529: aload_1
    //   530: ifnull +7 -> 537
    //   533: aload_1
    //   534: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   537: aload_0
    //   538: athrow
    //   539: astore 11
    //   541: aload 11
    //   543: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   546: goto -17 -> 529
    //   549: astore_1
    //   550: aload_1
    //   551: invokevirtual 134	java/io/IOException:printStackTrace	()V
    //   554: goto -17 -> 537
    //   557: astore 12
    //   559: aconst_null
    //   560: astore 11
    //   562: aload_0
    //   563: astore_1
    //   564: aload 12
    //   566: astore_0
    //   567: goto -48 -> 519
    //   570: astore 12
    //   572: aload_0
    //   573: astore_1
    //   574: aload 12
    //   576: astore_0
    //   577: goto -58 -> 519
    //   580: astore 12
    //   582: aload_0
    //   583: astore_1
    //   584: aload 12
    //   586: astore_0
    //   587: goto -68 -> 519
    //   590: astore_0
    //   591: goto -72 -> 519
    //   594: astore 12
    //   596: aconst_null
    //   597: astore 11
    //   599: aload_0
    //   600: astore_1
    //   601: aload 12
    //   603: astore_0
    //   604: goto -144 -> 460
    //   607: astore 12
    //   609: aload_0
    //   610: astore_1
    //   611: aload 12
    //   613: astore_0
    //   614: goto -154 -> 460
    //   617: astore_1
    //   618: aload 12
    //   620: astore 11
    //   622: goto -214 -> 408
    //   625: astore_1
    //   626: goto -218 -> 408
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	629	0	paramString1	java.lang.String
    //   0	629	1	paramString2	java.lang.String
    //   0	629	2	paramFloat1	float
    //   0	629	3	paramFloat2	float
    //   163	30	4	f	float
    //   83	391	5	i	int
    //   104	141	6	j	int
    //   12	360	7	l1	long
    //   308	5	9	l2	long
    //   96	429	11	localObject1	Object
    //   539	3	11	localIOException	java.io.IOException
    //   560	61	11	localThrowable1	java.lang.Throwable
    //   7	398	12	localObject2	Object
    //   557	8	12	localObject3	Object
    //   570	5	12	localObject4	Object
    //   580	5	12	localObject5	Object
    //   594	8	12	localThrowable2	java.lang.Throwable
    //   607	12	12	localThrowable3	java.lang.Throwable
    //   1	457	13	localObject6	Object
    //   4	513	14	localObject7	Object
    //   247	81	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   341	346	385	java/io/IOException
    //   350	354	393	java/io/IOException
    //   249	270	401	java/io/IOException
    //   270	284	401	java/io/IOException
    //   430	434	437	java/io/IOException
    //   421	426	445	java/io/IOException
    //   249	270	453	java/lang/Throwable
    //   270	284	453	java/lang/Throwable
    //   489	493	496	java/io/IOException
    //   480	485	504	java/io/IOException
    //   249	270	512	finally
    //   270	284	512	finally
    //   524	529	539	java/io/IOException
    //   533	537	549	java/io/IOException
    //   284	295	557	finally
    //   310	318	570	finally
    //   318	326	570	finally
    //   326	336	570	finally
    //   408	412	580	finally
    //   460	471	590	finally
    //   284	295	594	java/lang/Throwable
    //   310	318	607	java/lang/Throwable
    //   318	326	607	java/lang/Throwable
    //   326	336	607	java/lang/Throwable
    //   284	295	617	java/io/IOException
    //   310	318	625	java/io/IOException
    //   318	326	625	java/io/IOException
    //   326	336	625	java/io/IOException
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