package com.tencent.qqprotect.sfcfg;

import java.util.Map;
import java.util.jar.Attributes;

public class TXSafeCheckUtil
{
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
    //   24: new 19	java/util/jar/JarFile
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 22	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
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
    //   56: invokevirtual 26	java/util/jar/JarFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   59: astore_1
    //   60: aload_1
    //   61: ifnonnull +10 -> 71
    //   64: aload 5
    //   66: invokevirtual 29	java/util/jar/JarFile:close	()V
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
    //   93: invokevirtual 33	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
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
    //   112: ldc 35
    //   114: invokestatic 41	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   117: astore 9
    //   119: aload_1
    //   120: astore 6
    //   122: aload_1
    //   123: astore 7
    //   125: aload_1
    //   126: astore 8
    //   128: aload_1
    //   129: astore_0
    //   130: aload 5
    //   132: astore 4
    //   134: sipush 8192
    //   137: newarray byte
    //   139: astore 10
    //   141: aload_1
    //   142: astore 6
    //   144: aload_1
    //   145: astore 7
    //   147: aload_1
    //   148: astore 8
    //   150: aload_1
    //   151: astore_0
    //   152: aload 5
    //   154: astore 4
    //   156: aload_1
    //   157: aload 10
    //   159: invokevirtual 47	java/io/InputStream:read	([B)I
    //   162: istore_3
    //   163: iload_3
    //   164: iconst_m1
    //   165: if_icmpeq +30 -> 195
    //   168: aload_1
    //   169: astore 6
    //   171: aload_1
    //   172: astore 7
    //   174: aload_1
    //   175: astore 8
    //   177: aload_1
    //   178: astore_0
    //   179: aload 5
    //   181: astore 4
    //   183: aload 9
    //   185: aload 10
    //   187: iconst_0
    //   188: iload_3
    //   189: invokevirtual 51	java/security/MessageDigest:update	([BII)V
    //   192: goto -51 -> 141
    //   195: aload_1
    //   196: astore 6
    //   198: aload_1
    //   199: astore 7
    //   201: aload_1
    //   202: astore 8
    //   204: aload_1
    //   205: astore_0
    //   206: aload 5
    //   208: astore 4
    //   210: aload 9
    //   212: invokevirtual 55	java/security/MessageDigest:digest	()[B
    //   215: astore 9
    //   217: aload_1
    //   218: astore 6
    //   220: aload_1
    //   221: astore 7
    //   223: aload_1
    //   224: astore 8
    //   226: aload_1
    //   227: astore_0
    //   228: aload 5
    //   230: astore 4
    //   232: aload 9
    //   234: iconst_0
    //   235: aload_2
    //   236: iconst_0
    //   237: aload 9
    //   239: arraylength
    //   240: invokestatic 61	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   243: aload_1
    //   244: ifnull +7 -> 251
    //   247: aload_1
    //   248: invokevirtual 62	java/io/InputStream:close	()V
    //   251: aload 5
    //   253: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_1
    //   259: goto +27 -> 286
    //   262: astore_1
    //   263: goto +65 -> 328
    //   266: astore_1
    //   267: goto +103 -> 370
    //   270: astore_1
    //   271: aconst_null
    //   272: astore_2
    //   273: aload 4
    //   275: astore_0
    //   276: aload_2
    //   277: astore 4
    //   279: goto +128 -> 407
    //   282: astore_1
    //   283: aconst_null
    //   284: astore 5
    //   286: aload 6
    //   288: astore_0
    //   289: aload 5
    //   291: astore 4
    //   293: aload_1
    //   294: invokevirtual 65	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   297: aload 6
    //   299: ifnull +11 -> 310
    //   302: aload 6
    //   304: invokevirtual 62	java/io/InputStream:close	()V
    //   307: goto +3 -> 310
    //   310: aload 5
    //   312: ifnull +8 -> 320
    //   315: aload 5
    //   317: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   320: sipush 139
    //   323: ireturn
    //   324: astore_1
    //   325: aconst_null
    //   326: astore 5
    //   328: aload 7
    //   330: astore_0
    //   331: aload 5
    //   333: astore 4
    //   335: aload_1
    //   336: invokevirtual 66	java/lang/OutOfMemoryError:printStackTrace	()V
    //   339: aload 7
    //   341: ifnull +11 -> 352
    //   344: aload 7
    //   346: invokevirtual 62	java/io/InputStream:close	()V
    //   349: goto +3 -> 352
    //   352: aload 5
    //   354: ifnull +8 -> 362
    //   357: aload 5
    //   359: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   362: sipush 144
    //   365: ireturn
    //   366: astore_1
    //   367: aconst_null
    //   368: astore 5
    //   370: aload 8
    //   372: astore_0
    //   373: aload 5
    //   375: astore 4
    //   377: aload_1
    //   378: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   381: aload 8
    //   383: ifnull +11 -> 394
    //   386: aload 8
    //   388: invokevirtual 62	java/io/InputStream:close	()V
    //   391: goto +3 -> 394
    //   394: aload 5
    //   396: ifnull +8 -> 404
    //   399: aload 5
    //   401: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   404: iconst_3
    //   405: ireturn
    //   406: astore_1
    //   407: aload_0
    //   408: ifnull +10 -> 418
    //   411: aload_0
    //   412: invokevirtual 62	java/io/InputStream:close	()V
    //   415: goto +3 -> 418
    //   418: aload 4
    //   420: ifnull +8 -> 428
    //   423: aload 4
    //   425: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   428: goto +5 -> 433
    //   431: aload_1
    //   432: athrow
    //   433: goto -2 -> 431
    //   436: astore_0
    //   437: iconst_2
    //   438: ireturn
    //   439: astore_0
    //   440: goto -189 -> 251
    //   443: astore_0
    //   444: iconst_0
    //   445: ireturn
    //   446: astore_0
    //   447: goto -137 -> 310
    //   450: astore_0
    //   451: sipush 139
    //   454: ireturn
    //   455: astore_0
    //   456: goto -104 -> 352
    //   459: astore_0
    //   460: sipush 144
    //   463: ireturn
    //   464: astore_0
    //   465: goto -71 -> 394
    //   468: astore_0
    //   469: iconst_3
    //   470: ireturn
    //   471: astore_0
    //   472: goto -54 -> 418
    //   475: astore_0
    //   476: goto -48 -> 428
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	479	0	paramString1	String
    //   0	479	1	paramString2	String
    //   0	479	2	paramArrayOfByte	byte[]
    //   162	27	3	i	int
    //   19	405	4	localObject1	Object
    //   32	368	5	localJarFile	java.util.jar.JarFile
    //   7	296	6	localObject2	Object
    //   10	335	7	localObject3	Object
    //   13	374	8	localObject4	Object
    //   22	216	9	localObject5	Object
    //   1	185	10	arrayOfByte	byte[]
    //   4	76	11	localObject6	Object
    //   16	68	12	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   53	60	258	java/security/NoSuchAlgorithmException
    //   90	97	258	java/security/NoSuchAlgorithmException
    //   112	119	258	java/security/NoSuchAlgorithmException
    //   134	141	258	java/security/NoSuchAlgorithmException
    //   156	163	258	java/security/NoSuchAlgorithmException
    //   183	192	258	java/security/NoSuchAlgorithmException
    //   210	217	258	java/security/NoSuchAlgorithmException
    //   232	243	258	java/security/NoSuchAlgorithmException
    //   53	60	262	java/lang/OutOfMemoryError
    //   90	97	262	java/lang/OutOfMemoryError
    //   112	119	262	java/lang/OutOfMemoryError
    //   134	141	262	java/lang/OutOfMemoryError
    //   156	163	262	java/lang/OutOfMemoryError
    //   183	192	262	java/lang/OutOfMemoryError
    //   210	217	262	java/lang/OutOfMemoryError
    //   232	243	262	java/lang/OutOfMemoryError
    //   53	60	266	java/io/IOException
    //   90	97	266	java/io/IOException
    //   112	119	266	java/io/IOException
    //   134	141	266	java/io/IOException
    //   156	163	266	java/io/IOException
    //   183	192	266	java/io/IOException
    //   210	217	266	java/io/IOException
    //   232	243	266	java/io/IOException
    //   24	34	270	finally
    //   24	34	282	java/security/NoSuchAlgorithmException
    //   24	34	324	java/lang/OutOfMemoryError
    //   24	34	366	java/io/IOException
    //   53	60	406	finally
    //   90	97	406	finally
    //   112	119	406	finally
    //   134	141	406	finally
    //   156	163	406	finally
    //   183	192	406	finally
    //   210	217	406	finally
    //   232	243	406	finally
    //   293	297	406	finally
    //   335	339	406	finally
    //   377	381	406	finally
    //   64	69	436	java/io/IOException
    //   247	251	439	java/io/IOException
    //   251	256	443	java/io/IOException
    //   302	307	446	java/io/IOException
    //   315	320	450	java/io/IOException
    //   344	349	455	java/io/IOException
    //   357	362	459	java/io/IOException
    //   386	391	464	java/io/IOException
    //   399	404	468	java/io/IOException
    //   411	415	471	java/io/IOException
    //   423	428	475	java/io/IOException
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
    //   0: new 19	java/util/jar/JarFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 22	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: astore_0
    //   11: aload_1
    //   12: invokevirtual 115	java/util/jar/JarFile:getManifest	()Ljava/util/jar/Manifest;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +9 -> 26
    //   20: aload_1
    //   21: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   24: aconst_null
    //   25: areturn
    //   26: aload_1
    //   27: astore_0
    //   28: aload_2
    //   29: invokevirtual 121	java/util/jar/Manifest:getEntries	()Ljava/util/Map;
    //   32: astore_2
    //   33: aload_1
    //   34: invokevirtual 29	java/util/jar/JarFile:close	()V
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
    //   59: invokevirtual 67	java/io/IOException:printStackTrace	()V
    //   62: aload_1
    //   63: ifnull +7 -> 70
    //   66: aload_1
    //   67: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_2
    //   73: aconst_null
    //   74: astore_1
    //   75: aload_1
    //   76: astore_0
    //   77: aload_2
    //   78: invokevirtual 66	java/lang/OutOfMemoryError:printStackTrace	()V
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 29	java/util/jar/JarFile:close	()V
    //   89: aconst_null
    //   90: areturn
    //   91: astore_1
    //   92: aload_0
    //   93: ifnull +7 -> 100
    //   96: aload_0
    //   97: invokevirtual 29	java/util/jar/JarFile:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.sfcfg.TXSafeCheckUtil
 * JD-Core Version:    0.7.0.1
 */