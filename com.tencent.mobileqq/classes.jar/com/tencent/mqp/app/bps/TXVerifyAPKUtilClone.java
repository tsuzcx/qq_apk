package com.tencent.mqp.app.bps;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

class TXVerifyAPKUtilClone
{
  private static String a = StringManager.a(StringManager.u);
  private static String b = StringManager.a(StringManager.v);
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 10
    //   12: getstatic 22	com/tencent/mqp/app/bps/TXVerifyAPKUtilClone:a	Ljava/lang/String;
    //   15: invokestatic 41	com/tencent/mqp/app/bps/TXVerifyAPKUtilClone:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   18: astore 13
    //   20: aload 13
    //   22: ifnonnull +7 -> 29
    //   25: sipush 129
    //   28: ireturn
    //   29: aload_0
    //   30: ifnull +628 -> 658
    //   33: ldc 8
    //   35: aload_0
    //   36: invokevirtual 47	java/lang/String:trim	()Ljava/lang/String;
    //   39: invokevirtual 51	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   42: ifeq +6 -> 48
    //   45: goto +613 -> 658
    //   48: new 53	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 56	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokevirtual 60	java/io/File:exists	()Z
    //   59: istore 6
    //   61: iload 6
    //   63: ifne +5 -> 68
    //   66: iconst_3
    //   67: ireturn
    //   68: aload_0
    //   69: invokestatic 65	com/tencent/mqp/app/bps/TXSafeCheckUtilClone:a	(Ljava/lang/String;)Ljava/util/Map;
    //   72: astore 12
    //   74: aload 12
    //   76: ifnonnull +7 -> 83
    //   79: sipush 142
    //   82: ireturn
    //   83: new 67	java/util/jar/JarFile
    //   86: dup
    //   87: aload_0
    //   88: invokespecial 68	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   91: astore_0
    //   92: aload 11
    //   94: astore 8
    //   96: aload_0
    //   97: astore 9
    //   99: aload_0
    //   100: aload_1
    //   101: invokevirtual 72	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   104: astore_1
    //   105: sipush 135
    //   108: istore_2
    //   109: aload_1
    //   110: ifnonnull +11 -> 121
    //   113: iconst_5
    //   114: istore_2
    //   115: aload 10
    //   117: astore_1
    //   118: goto +436 -> 554
    //   121: aload 11
    //   123: astore 8
    //   125: aload_0
    //   126: astore 9
    //   128: new 74	java/io/DataInputStream
    //   131: dup
    //   132: aload_0
    //   133: aload_1
    //   134: invokevirtual 78	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   137: invokespecial 81	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   140: astore_1
    //   141: aload_1
    //   142: invokevirtual 85	java/io/DataInputStream:readInt	()I
    //   145: ldc 86
    //   147: if_icmpeq +10 -> 157
    //   150: sipush 132
    //   153: istore_2
    //   154: goto +640 -> 794
    //   157: aload_1
    //   158: invokevirtual 85	java/io/DataInputStream:readInt	()I
    //   161: istore_3
    //   162: iload_3
    //   163: sipush 128
    //   166: if_icmplt +381 -> 547
    //   169: iload_3
    //   170: sipush 256
    //   173: if_icmple +6 -> 179
    //   176: goto +371 -> 547
    //   179: aload_1
    //   180: invokevirtual 85	java/io/DataInputStream:readInt	()I
    //   183: ldc 87
    //   185: if_icmpeq +10 -> 195
    //   188: sipush 134
    //   191: istore_2
    //   192: goto +602 -> 794
    //   195: aload_1
    //   196: invokevirtual 85	java/io/DataInputStream:readInt	()I
    //   199: istore 5
    //   201: aload_1
    //   202: invokevirtual 85	java/io/DataInputStream:readInt	()I
    //   205: istore 4
    //   207: iload 4
    //   209: ifgt +6 -> 215
    //   212: goto +582 -> 794
    //   215: aload_1
    //   216: invokevirtual 90	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   219: astore 14
    //   221: iload_3
    //   222: newarray byte
    //   224: astore 15
    //   226: aload_1
    //   227: aload 15
    //   229: invokevirtual 94	java/io/DataInputStream:read	([B)I
    //   232: pop
    //   233: aload_1
    //   234: invokevirtual 97	java/io/DataInputStream:close	()V
    //   237: aload 11
    //   239: astore 8
    //   241: aload_0
    //   242: astore 9
    //   244: aload 14
    //   246: ldc 99
    //   248: invokevirtual 103	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   251: aload 15
    //   253: aload 13
    //   255: invokestatic 106	com/tencent/mqp/app/bps/TXVerifyAPKUtilClone:a	([B[BLjava/security/PublicKey;)Z
    //   258: istore 6
    //   260: iload 6
    //   262: ifne +13 -> 275
    //   265: sipush 137
    //   268: istore_2
    //   269: aload 10
    //   271: astore_1
    //   272: goto +282 -> 554
    //   275: aload 11
    //   277: astore 8
    //   279: aload_0
    //   280: astore 9
    //   282: new 108	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   289: astore_1
    //   290: iconst_0
    //   291: istore_3
    //   292: aload 11
    //   294: astore 8
    //   296: aload_0
    //   297: astore 9
    //   299: iload_3
    //   300: aload 14
    //   302: invokevirtual 112	java/lang/String:length	()I
    //   305: if_icmpge +32 -> 337
    //   308: aload 11
    //   310: astore 8
    //   312: aload_0
    //   313: astore 9
    //   315: aload_1
    //   316: aload 14
    //   318: iload_3
    //   319: invokevirtual 116	java/lang/String:charAt	(I)C
    //   322: iload 5
    //   324: ixor
    //   325: i2c
    //   326: invokevirtual 120	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: iload_3
    //   331: iconst_1
    //   332: iadd
    //   333: istore_3
    //   334: goto -42 -> 292
    //   337: aload 11
    //   339: astore 8
    //   341: aload_0
    //   342: astore 9
    //   344: aload_1
    //   345: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: ldc 125
    //   350: invokevirtual 129	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   353: astore_1
    //   354: aload 11
    //   356: astore 8
    //   358: aload_0
    //   359: astore 9
    //   361: aload_1
    //   362: arraylength
    //   363: istore_3
    //   364: iload_3
    //   365: iload 4
    //   367: if_icmpeq +9 -> 376
    //   370: aload 10
    //   372: astore_1
    //   373: goto +181 -> 554
    //   376: aload 11
    //   378: astore 8
    //   380: aload_0
    //   381: astore 9
    //   383: aload_1
    //   384: arraylength
    //   385: istore_3
    //   386: iconst_0
    //   387: istore_2
    //   388: iload_2
    //   389: iload_3
    //   390: if_icmpge +78 -> 468
    //   393: aload 11
    //   395: astore 8
    //   397: aload_0
    //   398: astore 9
    //   400: aload_1
    //   401: iload_2
    //   402: aaload
    //   403: ldc 131
    //   405: invokevirtual 129	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   408: astore 13
    //   410: aload 11
    //   412: astore 8
    //   414: aload_0
    //   415: astore 9
    //   417: aload 13
    //   419: arraylength
    //   420: iconst_2
    //   421: if_icmpeq +6 -> 427
    //   424: goto +37 -> 461
    //   427: aload 11
    //   429: astore 8
    //   431: aload_0
    //   432: astore 9
    //   434: aload 12
    //   436: aload 13
    //   438: iconst_0
    //   439: aaload
    //   440: aload 13
    //   442: iconst_1
    //   443: aaload
    //   444: invokestatic 134	com/tencent/mqp/app/bps/TXSafeCheckUtilClone:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   447: istore 4
    //   449: iload 4
    //   451: ifeq +10 -> 461
    //   454: aload_0
    //   455: invokevirtual 135	java/util/jar/JarFile:close	()V
    //   458: iload 4
    //   460: ireturn
    //   461: iload_2
    //   462: iconst_1
    //   463: iadd
    //   464: istore_2
    //   465: goto -77 -> 388
    //   468: iconst_0
    //   469: istore_2
    //   470: aload 10
    //   472: astore_1
    //   473: goto +81 -> 554
    //   476: astore 8
    //   478: bipush 42
    //   480: istore_2
    //   481: aload_0
    //   482: astore_1
    //   483: aload 8
    //   485: astore_0
    //   486: goto +186 -> 672
    //   489: astore 8
    //   491: bipush 41
    //   493: istore_2
    //   494: aload_0
    //   495: astore_1
    //   496: aload 8
    //   498: astore_0
    //   499: goto +173 -> 672
    //   502: astore 8
    //   504: bipush 40
    //   506: istore_2
    //   507: aload_0
    //   508: astore_1
    //   509: aload 8
    //   511: astore_0
    //   512: goto +160 -> 672
    //   515: astore 8
    //   517: bipush 39
    //   519: istore_2
    //   520: aload_1
    //   521: astore 7
    //   523: aload_0
    //   524: astore_1
    //   525: aload 8
    //   527: astore_0
    //   528: goto +144 -> 672
    //   531: astore 8
    //   533: bipush 38
    //   535: istore_2
    //   536: aload_1
    //   537: astore 7
    //   539: aload_0
    //   540: astore_1
    //   541: aload 8
    //   543: astore_0
    //   544: goto +128 -> 672
    //   547: sipush 133
    //   550: istore_2
    //   551: goto +243 -> 794
    //   554: aload_0
    //   555: astore 7
    //   557: iload_2
    //   558: istore 4
    //   560: aload_1
    //   561: ifnull +15 -> 576
    //   564: iload_2
    //   565: istore_3
    //   566: aload_1
    //   567: invokevirtual 97	java/io/DataInputStream:close	()V
    //   570: iload_2
    //   571: istore 4
    //   573: aload_0
    //   574: astore 7
    //   576: iload 4
    //   578: istore_3
    //   579: aload 7
    //   581: invokevirtual 135	java/util/jar/JarFile:close	()V
    //   584: iload 4
    //   586: istore_3
    //   587: goto +123 -> 710
    //   590: astore 7
    //   592: aload_1
    //   593: astore 8
    //   595: aload 7
    //   597: astore_1
    //   598: goto +158 -> 756
    //   601: astore 8
    //   603: bipush 37
    //   605: istore_2
    //   606: aload_1
    //   607: astore 7
    //   609: aload_0
    //   610: astore_1
    //   611: aload 8
    //   613: astore_0
    //   614: goto +58 -> 672
    //   617: astore 8
    //   619: bipush 36
    //   621: istore_2
    //   622: aload_0
    //   623: astore_1
    //   624: aload 8
    //   626: astore_0
    //   627: goto +45 -> 672
    //   630: astore 8
    //   632: aload_0
    //   633: astore_1
    //   634: aload 8
    //   636: astore_0
    //   637: goto +6 -> 643
    //   640: astore_0
    //   641: aconst_null
    //   642: astore_1
    //   643: bipush 34
    //   645: istore_2
    //   646: goto +26 -> 672
    //   649: astore_0
    //   650: aconst_null
    //   651: astore_1
    //   652: bipush 33
    //   654: istore_2
    //   655: goto +17 -> 672
    //   658: bipush 17
    //   660: ireturn
    //   661: astore_1
    //   662: aconst_null
    //   663: astore_0
    //   664: goto +92 -> 756
    //   667: astore_0
    //   668: aconst_null
    //   669: astore_1
    //   670: iconst_1
    //   671: istore_2
    //   672: aload 7
    //   674: astore 8
    //   676: aload_1
    //   677: astore 9
    //   679: aload_0
    //   680: invokevirtual 138	java/lang/Throwable:printStackTrace	()V
    //   683: aload 7
    //   685: ifnull +10 -> 695
    //   688: iload_2
    //   689: istore_3
    //   690: aload 7
    //   692: invokevirtual 97	java/io/DataInputStream:close	()V
    //   695: iload_2
    //   696: istore_3
    //   697: aload_1
    //   698: ifnull +12 -> 710
    //   701: aload_1
    //   702: astore 7
    //   704: iload_2
    //   705: istore 4
    //   707: goto -131 -> 576
    //   710: invokestatic 143	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +37 -> 750
    //   716: getstatic 26	com/tencent/mqp/app/bps/TXVerifyAPKUtilClone:b	Ljava/lang/String;
    //   719: astore_0
    //   720: new 108	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   727: astore_1
    //   728: aload_1
    //   729: ldc 145
    //   731: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_1
    //   736: iload_3
    //   737: invokevirtual 151	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: pop
    //   741: aload_0
    //   742: iconst_2
    //   743: aload_1
    //   744: invokevirtual 123	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: iload_3
    //   751: ireturn
    //   752: astore_1
    //   753: aload 9
    //   755: astore_0
    //   756: aload 8
    //   758: ifnull +8 -> 766
    //   761: aload 8
    //   763: invokevirtual 97	java/io/DataInputStream:close	()V
    //   766: aload_0
    //   767: ifnull +7 -> 774
    //   770: aload_0
    //   771: invokevirtual 135	java/util/jar/JarFile:close	()V
    //   774: goto +5 -> 779
    //   777: aload_1
    //   778: athrow
    //   779: goto -2 -> 777
    //   782: astore_0
    //   783: iload 4
    //   785: ireturn
    //   786: astore_0
    //   787: goto -77 -> 710
    //   790: astore_0
    //   791: goto -17 -> 774
    //   794: goto -240 -> 554
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	797	0	paramString1	String
    //   0	797	1	paramString2	String
    //   108	597	2	i	int
    //   161	590	3	j	int
    //   205	579	4	k	int
    //   199	126	5	m	int
    //   59	202	6	bool	boolean
    //   1	579	7	str1	String
    //   590	6	7	localObject1	Object
    //   607	96	7	str2	String
    //   7	423	8	localObject2	Object
    //   476	8	8	localThrowable1	java.lang.Throwable
    //   489	8	8	localThrowable2	java.lang.Throwable
    //   502	8	8	localThrowable3	java.lang.Throwable
    //   515	11	8	localThrowable4	java.lang.Throwable
    //   531	11	8	localThrowable5	java.lang.Throwable
    //   593	1	8	str3	String
    //   601	11	8	localThrowable6	java.lang.Throwable
    //   617	8	8	localThrowable7	java.lang.Throwable
    //   630	5	8	localThrowable8	java.lang.Throwable
    //   674	88	8	str4	String
    //   97	657	9	str5	String
    //   10	461	10	localObject3	Object
    //   4	424	11	localObject4	Object
    //   72	363	12	localMap	java.util.Map
    //   18	423	13	localObject5	Object
    //   219	98	14	str6	String
    //   224	28	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   383	386	476	java/lang/Throwable
    //   400	410	476	java/lang/Throwable
    //   417	424	476	java/lang/Throwable
    //   434	449	476	java/lang/Throwable
    //   282	290	489	java/lang/Throwable
    //   299	308	489	java/lang/Throwable
    //   315	330	489	java/lang/Throwable
    //   344	354	489	java/lang/Throwable
    //   361	364	489	java/lang/Throwable
    //   244	260	502	java/lang/Throwable
    //   221	237	515	java/lang/Throwable
    //   215	221	531	java/lang/Throwable
    //   141	150	590	finally
    //   157	162	590	finally
    //   179	188	590	finally
    //   195	207	590	finally
    //   215	221	590	finally
    //   221	237	590	finally
    //   141	150	601	java/lang/Throwable
    //   157	162	601	java/lang/Throwable
    //   179	188	601	java/lang/Throwable
    //   195	207	601	java/lang/Throwable
    //   128	141	617	java/lang/Throwable
    //   99	105	630	java/lang/Throwable
    //   83	92	640	java/lang/Throwable
    //   68	74	649	java/lang/Throwable
    //   12	20	661	finally
    //   33	45	661	finally
    //   48	61	661	finally
    //   68	74	661	finally
    //   83	92	661	finally
    //   12	20	667	java/lang/Throwable
    //   33	45	667	java/lang/Throwable
    //   48	61	667	java/lang/Throwable
    //   99	105	752	finally
    //   128	141	752	finally
    //   244	260	752	finally
    //   282	290	752	finally
    //   299	308	752	finally
    //   315	330	752	finally
    //   344	354	752	finally
    //   361	364	752	finally
    //   383	386	752	finally
    //   400	410	752	finally
    //   417	424	752	finally
    //   434	449	752	finally
    //   679	683	752	finally
    //   454	458	782	java/io/IOException
    //   566	570	786	java/io/IOException
    //   579	584	786	java/io/IOException
    //   690	695	786	java/io/IOException
    //   761	766	790	java/io/IOException
    //   770	774	790	java/io/IOException
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = a;
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance(TXSafeCheckUtilClone.a).generatePublic(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static boolean a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PublicKey paramPublicKey)
  {
    try
    {
      Signature localSignature = Signature.getInstance(TXSafeCheckUtilClone.b);
      localSignature.initVerify(paramPublicKey);
      localSignature.update(paramArrayOfByte1);
      boolean bool = localSignature.verify(paramArrayOfByte2);
      return bool;
    }
    catch (Exception paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.bps.TXVerifyAPKUtilClone
 * JD-Core Version:    0.7.0.1
 */