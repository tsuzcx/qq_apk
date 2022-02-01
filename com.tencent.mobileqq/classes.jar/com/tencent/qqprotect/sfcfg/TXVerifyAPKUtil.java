package com.tencent.qqprotect.sfcfg;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;

public class TXVerifyAPKUtil
{
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
    //   12: ldc 17
    //   14: invokestatic 20	com/tencent/qqprotect/sfcfg/TXVerifyAPKUtil:a	(Ljava/lang/String;)Ljava/security/PublicKey;
    //   17: astore 13
    //   19: aload 13
    //   21: ifnonnull +7 -> 28
    //   24: sipush 129
    //   27: ireturn
    //   28: aload_0
    //   29: ifnull +628 -> 657
    //   32: ldc 22
    //   34: aload_0
    //   35: invokevirtual 28	java/lang/String:trim	()Ljava/lang/String;
    //   38: invokevirtual 32	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +6 -> 47
    //   44: goto +613 -> 657
    //   47: new 34	java/io/File
    //   50: dup
    //   51: aload_0
    //   52: invokespecial 37	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: invokevirtual 41	java/io/File:exists	()Z
    //   58: istore 6
    //   60: iload 6
    //   62: ifne +5 -> 67
    //   65: iconst_3
    //   66: ireturn
    //   67: aload_0
    //   68: invokestatic 46	com/tencent/qqprotect/sfcfg/TXSafeCheckUtil:a	(Ljava/lang/String;)Ljava/util/Map;
    //   71: astore 12
    //   73: aload 12
    //   75: ifnonnull +7 -> 82
    //   78: sipush 142
    //   81: ireturn
    //   82: new 48	java/util/jar/JarFile
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 49	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   90: astore_0
    //   91: aload 11
    //   93: astore 8
    //   95: aload_0
    //   96: astore 9
    //   98: aload_0
    //   99: aload_1
    //   100: invokevirtual 53	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   103: astore_1
    //   104: sipush 135
    //   107: istore_2
    //   108: aload_1
    //   109: ifnonnull +11 -> 120
    //   112: iconst_5
    //   113: istore_2
    //   114: aload 10
    //   116: astore_1
    //   117: goto +436 -> 553
    //   120: aload 11
    //   122: astore 8
    //   124: aload_0
    //   125: astore 9
    //   127: new 55	java/io/DataInputStream
    //   130: dup
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 59	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   136: invokespecial 62	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   139: astore_1
    //   140: aload_1
    //   141: invokevirtual 66	java/io/DataInputStream:readInt	()I
    //   144: ldc 67
    //   146: if_icmpeq +10 -> 156
    //   149: sipush 132
    //   152: istore_2
    //   153: goto +637 -> 790
    //   156: aload_1
    //   157: invokevirtual 66	java/io/DataInputStream:readInt	()I
    //   160: istore_3
    //   161: iload_3
    //   162: sipush 128
    //   165: if_icmplt +381 -> 546
    //   168: iload_3
    //   169: sipush 256
    //   172: if_icmple +6 -> 178
    //   175: goto +371 -> 546
    //   178: aload_1
    //   179: invokevirtual 66	java/io/DataInputStream:readInt	()I
    //   182: ldc 68
    //   184: if_icmpeq +10 -> 194
    //   187: sipush 134
    //   190: istore_2
    //   191: goto +599 -> 790
    //   194: aload_1
    //   195: invokevirtual 66	java/io/DataInputStream:readInt	()I
    //   198: istore 5
    //   200: aload_1
    //   201: invokevirtual 66	java/io/DataInputStream:readInt	()I
    //   204: istore 4
    //   206: iload 4
    //   208: ifgt +6 -> 214
    //   211: goto +579 -> 790
    //   214: aload_1
    //   215: invokevirtual 71	java/io/DataInputStream:readUTF	()Ljava/lang/String;
    //   218: astore 14
    //   220: iload_3
    //   221: newarray byte
    //   223: astore 15
    //   225: aload_1
    //   226: aload 15
    //   228: invokevirtual 75	java/io/DataInputStream:read	([B)I
    //   231: pop
    //   232: aload_1
    //   233: invokevirtual 78	java/io/DataInputStream:close	()V
    //   236: aload 11
    //   238: astore 8
    //   240: aload_0
    //   241: astore 9
    //   243: aload 14
    //   245: ldc 80
    //   247: invokevirtual 84	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   250: aload 15
    //   252: aload 13
    //   254: invokestatic 87	com/tencent/qqprotect/sfcfg/TXVerifyAPKUtil:a	([B[BLjava/security/PublicKey;)Z
    //   257: istore 6
    //   259: iload 6
    //   261: ifne +13 -> 274
    //   264: sipush 137
    //   267: istore_2
    //   268: aload 10
    //   270: astore_1
    //   271: goto +282 -> 553
    //   274: aload 11
    //   276: astore 8
    //   278: aload_0
    //   279: astore 9
    //   281: new 89	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   288: astore_1
    //   289: iconst_0
    //   290: istore_3
    //   291: aload 11
    //   293: astore 8
    //   295: aload_0
    //   296: astore 9
    //   298: iload_3
    //   299: aload 14
    //   301: invokevirtual 93	java/lang/String:length	()I
    //   304: if_icmpge +32 -> 336
    //   307: aload 11
    //   309: astore 8
    //   311: aload_0
    //   312: astore 9
    //   314: aload_1
    //   315: aload 14
    //   317: iload_3
    //   318: invokevirtual 97	java/lang/String:charAt	(I)C
    //   321: iload 5
    //   323: ixor
    //   324: i2c
    //   325: invokevirtual 101	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: iload_3
    //   330: iconst_1
    //   331: iadd
    //   332: istore_3
    //   333: goto -42 -> 291
    //   336: aload 11
    //   338: astore 8
    //   340: aload_0
    //   341: astore 9
    //   343: aload_1
    //   344: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: ldc 106
    //   349: invokevirtual 110	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   352: astore_1
    //   353: aload 11
    //   355: astore 8
    //   357: aload_0
    //   358: astore 9
    //   360: aload_1
    //   361: arraylength
    //   362: istore_3
    //   363: iload_3
    //   364: iload 4
    //   366: if_icmpeq +9 -> 375
    //   369: aload 10
    //   371: astore_1
    //   372: goto +181 -> 553
    //   375: aload 11
    //   377: astore 8
    //   379: aload_0
    //   380: astore 9
    //   382: aload_1
    //   383: arraylength
    //   384: istore_3
    //   385: iconst_0
    //   386: istore_2
    //   387: iload_2
    //   388: iload_3
    //   389: if_icmpge +78 -> 467
    //   392: aload 11
    //   394: astore 8
    //   396: aload_0
    //   397: astore 9
    //   399: aload_1
    //   400: iload_2
    //   401: aaload
    //   402: ldc 112
    //   404: invokevirtual 110	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   407: astore 13
    //   409: aload 11
    //   411: astore 8
    //   413: aload_0
    //   414: astore 9
    //   416: aload 13
    //   418: arraylength
    //   419: iconst_2
    //   420: if_icmpeq +6 -> 426
    //   423: goto +37 -> 460
    //   426: aload 11
    //   428: astore 8
    //   430: aload_0
    //   431: astore 9
    //   433: aload 12
    //   435: aload 13
    //   437: iconst_0
    //   438: aaload
    //   439: aload 13
    //   441: iconst_1
    //   442: aaload
    //   443: invokestatic 115	com/tencent/qqprotect/sfcfg/TXSafeCheckUtil:a	(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)I
    //   446: istore 4
    //   448: iload 4
    //   450: ifeq +10 -> 460
    //   453: aload_0
    //   454: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   457: iload 4
    //   459: ireturn
    //   460: iload_2
    //   461: iconst_1
    //   462: iadd
    //   463: istore_2
    //   464: goto -77 -> 387
    //   467: iconst_0
    //   468: istore_2
    //   469: aload 10
    //   471: astore_1
    //   472: goto +81 -> 553
    //   475: astore 8
    //   477: bipush 42
    //   479: istore_2
    //   480: aload_0
    //   481: astore_1
    //   482: aload 8
    //   484: astore_0
    //   485: goto +186 -> 671
    //   488: astore 8
    //   490: bipush 41
    //   492: istore_2
    //   493: aload_0
    //   494: astore_1
    //   495: aload 8
    //   497: astore_0
    //   498: goto +173 -> 671
    //   501: astore 8
    //   503: bipush 40
    //   505: istore_2
    //   506: aload_0
    //   507: astore_1
    //   508: aload 8
    //   510: astore_0
    //   511: goto +160 -> 671
    //   514: astore 8
    //   516: bipush 39
    //   518: istore_2
    //   519: aload_1
    //   520: astore 7
    //   522: aload_0
    //   523: astore_1
    //   524: aload 8
    //   526: astore_0
    //   527: goto +144 -> 671
    //   530: astore 8
    //   532: bipush 38
    //   534: istore_2
    //   535: aload_1
    //   536: astore 7
    //   538: aload_0
    //   539: astore_1
    //   540: aload 8
    //   542: astore_0
    //   543: goto +128 -> 671
    //   546: sipush 133
    //   549: istore_2
    //   550: goto +240 -> 790
    //   553: aload_0
    //   554: astore 7
    //   556: iload_2
    //   557: istore 4
    //   559: aload_1
    //   560: ifnull +15 -> 575
    //   563: iload_2
    //   564: istore_3
    //   565: aload_1
    //   566: invokevirtual 78	java/io/DataInputStream:close	()V
    //   569: iload_2
    //   570: istore 4
    //   572: aload_0
    //   573: astore 7
    //   575: iload 4
    //   577: istore_3
    //   578: aload 7
    //   580: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   583: iload 4
    //   585: istore_3
    //   586: goto +123 -> 709
    //   589: astore 7
    //   591: aload_1
    //   592: astore 8
    //   594: aload 7
    //   596: astore_1
    //   597: goto +155 -> 752
    //   600: astore 8
    //   602: bipush 37
    //   604: istore_2
    //   605: aload_1
    //   606: astore 7
    //   608: aload_0
    //   609: astore_1
    //   610: aload 8
    //   612: astore_0
    //   613: goto +58 -> 671
    //   616: astore 8
    //   618: bipush 36
    //   620: istore_2
    //   621: aload_0
    //   622: astore_1
    //   623: aload 8
    //   625: astore_0
    //   626: goto +45 -> 671
    //   629: astore 8
    //   631: aload_0
    //   632: astore_1
    //   633: aload 8
    //   635: astore_0
    //   636: goto +6 -> 642
    //   639: astore_0
    //   640: aconst_null
    //   641: astore_1
    //   642: bipush 34
    //   644: istore_2
    //   645: goto +26 -> 671
    //   648: astore_0
    //   649: aconst_null
    //   650: astore_1
    //   651: bipush 33
    //   653: istore_2
    //   654: goto +17 -> 671
    //   657: bipush 17
    //   659: ireturn
    //   660: astore_1
    //   661: aconst_null
    //   662: astore_0
    //   663: goto +89 -> 752
    //   666: astore_0
    //   667: aconst_null
    //   668: astore_1
    //   669: iconst_1
    //   670: istore_2
    //   671: aload 7
    //   673: astore 8
    //   675: aload_1
    //   676: astore 9
    //   678: aload_0
    //   679: invokevirtual 119	java/lang/Throwable:printStackTrace	()V
    //   682: aload 7
    //   684: ifnull +10 -> 694
    //   687: iload_2
    //   688: istore_3
    //   689: aload 7
    //   691: invokevirtual 78	java/io/DataInputStream:close	()V
    //   694: iload_2
    //   695: istore_3
    //   696: aload_1
    //   697: ifnull +12 -> 709
    //   700: aload_1
    //   701: astore 7
    //   703: iload_2
    //   704: istore 4
    //   706: goto -131 -> 575
    //   709: invokestatic 124	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   712: ifeq +34 -> 746
    //   715: new 89	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   722: astore_0
    //   723: aload_0
    //   724: ldc 126
    //   726: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: pop
    //   730: aload_0
    //   731: iload_3
    //   732: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: ldc 134
    //   738: iconst_2
    //   739: aload_0
    //   740: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 138	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: iload_3
    //   747: ireturn
    //   748: astore_1
    //   749: aload 9
    //   751: astore_0
    //   752: aload 8
    //   754: ifnull +8 -> 762
    //   757: aload 8
    //   759: invokevirtual 78	java/io/DataInputStream:close	()V
    //   762: aload_0
    //   763: ifnull +7 -> 770
    //   766: aload_0
    //   767: invokevirtual 116	java/util/jar/JarFile:close	()V
    //   770: goto +5 -> 775
    //   773: aload_1
    //   774: athrow
    //   775: goto -2 -> 773
    //   778: astore_0
    //   779: iload 4
    //   781: ireturn
    //   782: astore_0
    //   783: goto -74 -> 709
    //   786: astore_0
    //   787: goto -17 -> 770
    //   790: goto -237 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	793	0	paramString1	String
    //   0	793	1	paramString2	String
    //   107	597	2	i	int
    //   160	587	3	j	int
    //   204	576	4	k	int
    //   198	126	5	m	int
    //   58	202	6	bool	boolean
    //   1	578	7	str1	String
    //   589	6	7	localObject1	Object
    //   606	96	7	str2	String
    //   7	422	8	localObject2	Object
    //   475	8	8	localThrowable1	java.lang.Throwable
    //   488	8	8	localThrowable2	java.lang.Throwable
    //   501	8	8	localThrowable3	java.lang.Throwable
    //   514	11	8	localThrowable4	java.lang.Throwable
    //   530	11	8	localThrowable5	java.lang.Throwable
    //   592	1	8	str3	String
    //   600	11	8	localThrowable6	java.lang.Throwable
    //   616	8	8	localThrowable7	java.lang.Throwable
    //   629	5	8	localThrowable8	java.lang.Throwable
    //   673	85	8	str4	String
    //   96	654	9	str5	String
    //   10	460	10	localObject3	Object
    //   4	423	11	localObject4	Object
    //   71	363	12	localMap	java.util.Map
    //   17	423	13	localObject5	Object
    //   218	98	14	str6	String
    //   223	28	15	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   382	385	475	java/lang/Throwable
    //   399	409	475	java/lang/Throwable
    //   416	423	475	java/lang/Throwable
    //   433	448	475	java/lang/Throwable
    //   281	289	488	java/lang/Throwable
    //   298	307	488	java/lang/Throwable
    //   314	329	488	java/lang/Throwable
    //   343	353	488	java/lang/Throwable
    //   360	363	488	java/lang/Throwable
    //   243	259	501	java/lang/Throwable
    //   220	236	514	java/lang/Throwable
    //   214	220	530	java/lang/Throwable
    //   140	149	589	finally
    //   156	161	589	finally
    //   178	187	589	finally
    //   194	206	589	finally
    //   214	220	589	finally
    //   220	236	589	finally
    //   140	149	600	java/lang/Throwable
    //   156	161	600	java/lang/Throwable
    //   178	187	600	java/lang/Throwable
    //   194	206	600	java/lang/Throwable
    //   127	140	616	java/lang/Throwable
    //   98	104	629	java/lang/Throwable
    //   82	91	639	java/lang/Throwable
    //   67	73	648	java/lang/Throwable
    //   12	19	660	finally
    //   32	44	660	finally
    //   47	60	660	finally
    //   67	73	660	finally
    //   82	91	660	finally
    //   12	19	666	java/lang/Throwable
    //   32	44	666	java/lang/Throwable
    //   47	60	666	java/lang/Throwable
    //   98	104	748	finally
    //   127	140	748	finally
    //   243	259	748	finally
    //   281	289	748	finally
    //   298	307	748	finally
    //   314	329	748	finally
    //   343	353	748	finally
    //   360	363	748	finally
    //   382	385	748	finally
    //   399	409	748	finally
    //   416	423	748	finally
    //   433	448	748	finally
    //   678	682	748	finally
    //   453	457	778	java/io/IOException
    //   565	569	782	java/io/IOException
    //   578	583	782	java/io/IOException
    //   689	694	782	java/io/IOException
    //   757	762	786	java/io/IOException
    //   766	770	786	java/io/IOException
  }
  
  private static PublicKey a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCOEXXbretliROuhm/THXQOZ33e1bIvgPNnGFqrmALpZFXZ51u1CWJMBNXBX0us9jBHUlWSn5Pmz+kPLe7VHh1PrmzrSTxBH6dJq3iRclhyDFTc6txsOm92p/yaSwOaK/OP50YzAYcBT3lhjhQ5mvTUSzFN3gZLfr89sjuix+40dwIDAQAB";
    }
    paramString = new X509EncodedKeySpec(Base64.decode(str, 0));
    try
    {
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
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
      Signature localSignature = Signature.getInstance("MD5withRSA");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.sfcfg.TXVerifyAPKUtil
 * JD-Core Version:    0.7.0.1
 */