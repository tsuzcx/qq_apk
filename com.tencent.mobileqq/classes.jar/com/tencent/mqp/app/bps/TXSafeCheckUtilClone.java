package com.tencent.mqp.app.bps;

import java.util.Map;
import java.util.jar.Attributes;

class TXSafeCheckUtilClone
{
  static String a = StringManager.a(StringManager.p);
  static String b = "";
  static String c = StringManager.a(StringManager.r);
  
  static
  {
    b = StringManager.a(StringManager.q);
    c = "";
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 7
    //   12: aconst_null
    //   13: astore 8
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore 9
    //   24: new 46	java/util/jar/JarFile
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 49	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   32: astore 5
    //   34: aload 9
    //   36: astore 6
    //   38: aload 10
    //   40: astore 7
    //   42: aload 11
    //   44: astore 8
    //   46: aload 12
    //   48: astore_0
    //   49: aload 5
    //   51: astore 4
    //   53: aload 5
    //   55: aload_1
    //   56: invokevirtual 53	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnonnull +10 -> 71
    //   64: aload 5
    //   66: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   69: iconst_2
    //   70: ireturn
    //   71: aload 9
    //   73: astore 6
    //   75: aload 10
    //   77: astore 7
    //   79: aload 11
    //   81: astore 8
    //   83: aload 12
    //   85: astore_0
    //   86: aload 5
    //   88: astore 4
    //   90: aload 5
    //   92: aload_1
    //   93: invokevirtual 60	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   96: astore_1
    //   97: aload_1
    //   98: astore 6
    //   100: aload_1
    //   101: astore 7
    //   103: aload_1
    //   104: astore 8
    //   106: aload_1
    //   107: astore_0
    //   108: aload 5
    //   110: astore 4
    //   112: getstatic 63	com/tencent/mqp/app/bps/StringManager:m	[B
    //   115: invokestatic 21	com/tencent/mqp/app/bps/StringManager:a	([B)Ljava/lang/String;
    //   118: invokestatic 69	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   121: astore 9
    //   123: aload_1
    //   124: astore 6
    //   126: aload_1
    //   127: astore 7
    //   129: aload_1
    //   130: astore 8
    //   132: aload_1
    //   133: astore_0
    //   134: aload 5
    //   136: astore 4
    //   138: sipush 8192
    //   141: newarray byte
    //   143: astore 10
    //   145: aload_1
    //   146: astore 6
    //   148: aload_1
    //   149: astore 7
    //   151: aload_1
    //   152: astore 8
    //   154: aload_1
    //   155: astore_0
    //   156: aload 5
    //   158: astore 4
    //   160: aload_1
    //   161: aload 10
    //   163: invokevirtual 75	java/io/InputStream:read	([B)I
    //   166: istore_3
    //   167: iload_3
    //   168: iconst_m1
    //   169: if_icmpeq +30 -> 199
    //   172: aload_1
    //   173: astore 6
    //   175: aload_1
    //   176: astore 7
    //   178: aload_1
    //   179: astore 8
    //   181: aload_1
    //   182: astore_0
    //   183: aload 5
    //   185: astore 4
    //   187: aload 9
    //   189: aload 10
    //   191: iconst_0
    //   192: iload_3
    //   193: invokevirtual 79	java/security/MessageDigest:update	([BII)V
    //   196: goto -51 -> 145
    //   199: aload_1
    //   200: astore 6
    //   202: aload_1
    //   203: astore 7
    //   205: aload_1
    //   206: astore 8
    //   208: aload_1
    //   209: astore_0
    //   210: aload 5
    //   212: astore 4
    //   214: aload 9
    //   216: invokevirtual 83	java/security/MessageDigest:digest	()[B
    //   219: astore 9
    //   221: aload_1
    //   222: astore 6
    //   224: aload_1
    //   225: astore 7
    //   227: aload_1
    //   228: astore 8
    //   230: aload_1
    //   231: astore_0
    //   232: aload 5
    //   234: astore 4
    //   236: aload 9
    //   238: iconst_0
    //   239: aload_2
    //   240: iconst_0
    //   241: aload 9
    //   243: arraylength
    //   244: invokestatic 89	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   247: aload_1
    //   248: ifnull +7 -> 255
    //   251: aload_1
    //   252: invokevirtual 90	java/io/InputStream:close	()V
    //   255: aload 5
    //   257: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   260: iconst_0
    //   261: ireturn
    //   262: astore_1
    //   263: goto +27 -> 290
    //   266: astore_1
    //   267: goto +65 -> 332
    //   270: astore_1
    //   271: goto +103 -> 374
    //   274: astore_1
    //   275: aconst_null
    //   276: astore_2
    //   277: aload 4
    //   279: astore_0
    //   280: aload_2
    //   281: astore 4
    //   283: goto +128 -> 411
    //   286: astore_1
    //   287: aconst_null
    //   288: astore 5
    //   290: aload 6
    //   292: astore_0
    //   293: aload 5
    //   295: astore 4
    //   297: aload_1
    //   298: invokevirtual 93	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   301: aload 6
    //   303: ifnull +11 -> 314
    //   306: aload 6
    //   308: invokevirtual 90	java/io/InputStream:close	()V
    //   311: goto +3 -> 314
    //   314: aload 5
    //   316: ifnull +8 -> 324
    //   319: aload 5
    //   321: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   324: sipush 139
    //   327: ireturn
    //   328: astore_1
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 7
    //   334: astore_0
    //   335: aload 5
    //   337: astore 4
    //   339: aload_1
    //   340: invokevirtual 94	java/lang/OutOfMemoryError:printStackTrace	()V
    //   343: aload 7
    //   345: ifnull +11 -> 356
    //   348: aload 7
    //   350: invokevirtual 90	java/io/InputStream:close	()V
    //   353: goto +3 -> 356
    //   356: aload 5
    //   358: ifnull +8 -> 366
    //   361: aload 5
    //   363: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   366: sipush 144
    //   369: ireturn
    //   370: astore_1
    //   371: aconst_null
    //   372: astore 5
    //   374: aload 8
    //   376: astore_0
    //   377: aload 5
    //   379: astore 4
    //   381: aload_1
    //   382: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   385: aload 8
    //   387: ifnull +11 -> 398
    //   390: aload 8
    //   392: invokevirtual 90	java/io/InputStream:close	()V
    //   395: goto +3 -> 398
    //   398: aload 5
    //   400: ifnull +8 -> 408
    //   403: aload 5
    //   405: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   408: iconst_3
    //   409: ireturn
    //   410: astore_1
    //   411: aload_0
    //   412: ifnull +10 -> 422
    //   415: aload_0
    //   416: invokevirtual 90	java/io/InputStream:close	()V
    //   419: goto +3 -> 422
    //   422: aload 4
    //   424: ifnull +8 -> 432
    //   427: aload 4
    //   429: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   432: goto +5 -> 437
    //   435: aload_1
    //   436: athrow
    //   437: goto -2 -> 435
    //   440: astore_0
    //   441: iconst_2
    //   442: ireturn
    //   443: astore_0
    //   444: goto -189 -> 255
    //   447: astore_0
    //   448: iconst_0
    //   449: ireturn
    //   450: astore_0
    //   451: goto -137 -> 314
    //   454: astore_0
    //   455: sipush 139
    //   458: ireturn
    //   459: astore_0
    //   460: goto -104 -> 356
    //   463: astore_0
    //   464: sipush 144
    //   467: ireturn
    //   468: astore_0
    //   469: goto -71 -> 398
    //   472: astore_0
    //   473: iconst_3
    //   474: ireturn
    //   475: astore_0
    //   476: goto -54 -> 422
    //   479: astore_0
    //   480: goto -48 -> 432
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramString1	String
    //   0	483	1	paramString2	String
    //   0	483	2	paramArrayOfByte	byte[]
    //   166	27	3	i	int
    //   19	409	4	localObject1	Object
    //   32	372	5	localJarFile	java.util.jar.JarFile
    //   7	300	6	localObject2	Object
    //   10	339	7	localObject3	Object
    //   13	378	8	localObject4	Object
    //   22	220	9	localObject5	Object
    //   1	189	10	arrayOfByte	byte[]
    //   4	76	11	localObject6	Object
    //   16	68	12	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	262	java/security/NoSuchAlgorithmException
    //   90	97	262	java/security/NoSuchAlgorithmException
    //   112	123	262	java/security/NoSuchAlgorithmException
    //   138	145	262	java/security/NoSuchAlgorithmException
    //   160	167	262	java/security/NoSuchAlgorithmException
    //   187	196	262	java/security/NoSuchAlgorithmException
    //   214	221	262	java/security/NoSuchAlgorithmException
    //   236	247	262	java/security/NoSuchAlgorithmException
    //   53	60	266	java/lang/OutOfMemoryError
    //   90	97	266	java/lang/OutOfMemoryError
    //   112	123	266	java/lang/OutOfMemoryError
    //   138	145	266	java/lang/OutOfMemoryError
    //   160	167	266	java/lang/OutOfMemoryError
    //   187	196	266	java/lang/OutOfMemoryError
    //   214	221	266	java/lang/OutOfMemoryError
    //   236	247	266	java/lang/OutOfMemoryError
    //   53	60	270	java/io/IOException
    //   90	97	270	java/io/IOException
    //   112	123	270	java/io/IOException
    //   138	145	270	java/io/IOException
    //   160	167	270	java/io/IOException
    //   187	196	270	java/io/IOException
    //   214	221	270	java/io/IOException
    //   236	247	270	java/io/IOException
    //   24	34	274	finally
    //   24	34	286	java/security/NoSuchAlgorithmException
    //   24	34	328	java/lang/OutOfMemoryError
    //   24	34	370	java/io/IOException
    //   53	60	410	finally
    //   90	97	410	finally
    //   112	123	410	finally
    //   138	145	410	finally
    //   160	167	410	finally
    //   187	196	410	finally
    //   214	221	410	finally
    //   236	247	410	finally
    //   297	301	410	finally
    //   339	343	410	finally
    //   381	385	410	finally
    //   64	69	440	java/io/IOException
    //   251	255	443	java/io/IOException
    //   255	260	447	java/io/IOException
    //   306	311	450	java/io/IOException
    //   319	324	454	java/io/IOException
    //   348	353	459	java/io/IOException
    //   361	366	463	java/io/IOException
    //   390	395	468	java/io/IOException
    //   403	408	472	java/io/IOException
    //   415	419	475	java/io/IOException
    //   427	432	479	java/io/IOException
  }
  
  public static int a(Map<String, Attributes> paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {
      return 17;
    }
    paramMap = (Attributes)paramMap.get(paramString1);
    if (paramMap == null) {
      return 7;
    }
    if (true == paramString2.equals(paramMap.getValue("SHA-256-Digest"))) {
      return 0;
    }
    return 143;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[16];
    char[] tmp8_6 = arrayOfChar1;
    tmp8_6[0] = 48;
    char[] tmp13_8 = tmp8_6;
    tmp13_8[1] = 49;
    char[] tmp18_13 = tmp13_8;
    tmp18_13[2] = 50;
    char[] tmp23_18 = tmp18_13;
    tmp23_18[3] = 51;
    char[] tmp28_23 = tmp23_18;
    tmp28_23[4] = 52;
    char[] tmp33_28 = tmp28_23;
    tmp33_28[5] = 53;
    char[] tmp38_33 = tmp33_28;
    tmp38_33[6] = 54;
    char[] tmp44_38 = tmp38_33;
    tmp44_38[7] = 55;
    char[] tmp50_44 = tmp44_38;
    tmp50_44[8] = 56;
    char[] tmp56_50 = tmp50_44;
    tmp56_50[9] = 57;
    char[] tmp62_56 = tmp56_50;
    tmp62_56[10] = 97;
    char[] tmp68_62 = tmp62_56;
    tmp68_62[11] = 98;
    char[] tmp74_68 = tmp68_62;
    tmp74_68[12] = 99;
    char[] tmp80_74 = tmp74_68;
    tmp80_74[13] = 100;
    char[] tmp86_80 = tmp80_74;
    tmp86_80[14] = 101;
    char[] tmp92_86 = tmp86_80;
    tmp92_86[15] = 102;
    tmp92_86;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i];
      int k = i * 2;
      arrayOfChar2[k] = arrayOfChar1[(j >>> 4 & 0xF)];
      arrayOfChar2[(k + 1)] = arrayOfChar1[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  /* Error */
  public static Map<String, Attributes> a(String paramString)
  {
    // Byte code:
    //   0: new 46	java/util/jar/JarFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 49	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 142	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +9 -> 26
    //   20: aload_1
    //   21: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_1
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 148	java/util/jar/Manifest:getEntries	()Ljava/util/Map;
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   37: aload_2
    //   38: areturn
    //   39: astore_2
    //   40: goto +16 -> 56
    //   43: astore_2
    //   44: goto +31 -> 75
    //   47: astore_1
    //   48: aconst_null
    //   49: astore_0
    //   50: goto +42 -> 92
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: invokevirtual 95	java/io/IOException:printStackTrace	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: aload_2
    //   78: invokevirtual 94	java/lang/OutOfMemoryError:printStackTrace	()V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 56	java/util/jar/JarFile:close	()V
    //   100: aload_1
    //   101: athrow
    //   102: astore_0
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: aload_2
    //   107: areturn
    //   108: astore_0
    //   109: aconst_null
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: goto -15 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	paramString	String
    //   8	26	1	localJarFile	java.util.jar.JarFile
    //   47	1	1	localObject1	Object
    //   55	31	1	localObject2	Object
    //   91	10	1	localObject3	Object
    //   15	23	2	localObject4	Object
    //   39	1	2	localIOException1	java.io.IOException
    //   43	1	2	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   53	6	2	localIOException2	java.io.IOException
    //   72	35	2	localOutOfMemoryError2	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   11	16	39	java/io/IOException
    //   28	33	39	java/io/IOException
    //   11	16	43	java/lang/OutOfMemoryError
    //   28	33	43	java/lang/OutOfMemoryError
    //   0	9	47	finally
    //   0	9	53	java/io/IOException
    //   0	9	72	java/lang/OutOfMemoryError
    //   11	16	91	finally
    //   28	33	91	finally
    //   58	62	91	finally
    //   77	81	91	finally
    //   20	24	102	java/io/IOException
    //   33	37	105	java/io/IOException
    //   66	70	108	java/io/IOException
    //   85	89	111	java/io/IOException
    //   96	100	114	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mqp.app.bps.TXSafeCheckUtilClone
 * JD-Core Version:    0.7.0.1
 */