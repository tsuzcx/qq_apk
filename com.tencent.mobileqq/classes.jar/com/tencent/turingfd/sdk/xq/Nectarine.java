package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import java.util.concurrent.atomic.AtomicReference;

public class Nectarine
{
  public static final String a = import.a(import.H0);
  
  /* Error */
  public static Mango a()
  {
    // Byte code:
    //   0: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: getstatic 54	com/tencent/turingfd/sdk/xq/import:I0	[I
    //   7: invokestatic 17	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   10: invokestatic 60	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   13: getstatic 63	com/tencent/turingfd/sdk/xq/import:J0	[I
    //   16: invokestatic 17	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   19: iconst_0
    //   20: anewarray 56	java/lang/Class
    //   23: invokevirtual 67	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: invokevirtual 73	java/lang/reflect/Method:setAccessible	(Z)V
    //   34: aload 5
    //   36: aconst_null
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 77	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: invokestatic 83	java/security/Security:getProviders	()[Ljava/security/Provider;
    //   48: astore 6
    //   50: aload 6
    //   52: ifnonnull +10 -> 62
    //   55: sipush -1201
    //   58: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   61: areturn
    //   62: aload 6
    //   64: arraylength
    //   65: istore_1
    //   66: iconst_0
    //   67: istore_0
    //   68: iload_0
    //   69: iload_1
    //   70: if_icmpge +38 -> 108
    //   73: aload 6
    //   75: iload_0
    //   76: aaload
    //   77: invokevirtual 94	java/security/Provider:getName	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +17 -> 101
    //   87: aload 5
    //   89: getstatic 19	com/tencent/turingfd/sdk/xq/Nectarine:a	Ljava/lang/String;
    //   92: invokevirtual 100	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   95: ifeq +6 -> 101
    //   98: goto +13 -> 111
    //   101: iload_0
    //   102: iconst_1
    //   103: iadd
    //   104: istore_0
    //   105: goto -37 -> 68
    //   108: aconst_null
    //   109: astore 5
    //   111: aload 5
    //   113: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   116: ifeq +10 -> 126
    //   119: sipush -1202
    //   122: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   125: areturn
    //   126: aload 5
    //   128: ldc 108
    //   130: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   133: arraylength
    //   134: iconst_1
    //   135: if_icmple +8 -> 143
    //   138: iconst_1
    //   139: istore_0
    //   140: goto +5 -> 145
    //   143: iconst_0
    //   144: istore_0
    //   145: aload 5
    //   147: invokestatic 118	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   150: astore 6
    //   152: aload 6
    //   154: aconst_null
    //   155: invokevirtual 122	java/security/KeyStore:load	(Ljava/security/KeyStore$LoadStoreParameter;)V
    //   158: invokestatic 128	android/os/Process:myUid	()I
    //   161: istore_2
    //   162: new 130	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   169: astore 7
    //   171: aload 7
    //   173: ldc 135
    //   175: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 7
    //   181: iload_2
    //   182: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 6
    //   188: aload 7
    //   190: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 149	java/security/KeyStore:getCertificate	(Ljava/lang/String;)Ljava/security/cert/Certificate;
    //   196: astore 7
    //   198: aload 7
    //   200: ifnull +8 -> 208
    //   203: iconst_1
    //   204: istore_1
    //   205: goto +5 -> 210
    //   208: iconst_0
    //   209: istore_1
    //   210: iload_1
    //   211: ifne +175 -> 386
    //   214: ldc 151
    //   216: aload 5
    //   218: invokestatic 156	java/security/KeyPairGenerator:getInstance	(Ljava/lang/String;Ljava/lang/String;)Ljava/security/KeyPairGenerator;
    //   221: astore 5
    //   223: new 130	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   230: astore 7
    //   232: aload 7
    //   234: ldc 135
    //   236: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload 7
    //   242: iload_2
    //   243: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 7
    //   249: getstatic 159	com/tencent/turingfd/sdk/xq/import:K0	[I
    //   252: invokestatic 17	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   255: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 7
    //   261: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: astore 7
    //   266: iload_0
    //   267: ifeq +536 -> 803
    //   270: bipush 16
    //   272: istore_1
    //   273: goto +3 -> 276
    //   276: aload 7
    //   278: iload_1
    //   279: invokestatic 164	com/tencent/turingfd/sdk/xq/Mandarin:a	(Ljava/lang/String;I)Lcom/tencent/turingfd/sdk/xq/Mandarin;
    //   282: iconst_1
    //   283: anewarray 96	java/lang/String
    //   286: dup
    //   287: iconst_0
    //   288: ldc 166
    //   290: aastore
    //   291: invokevirtual 169	com/tencent/turingfd/sdk/xq/Mandarin:a	([Ljava/lang/String;)Lcom/tencent/turingfd/sdk/xq/Mandarin;
    //   294: iconst_1
    //   295: anewarray 96	java/lang/String
    //   298: dup
    //   299: iconst_0
    //   300: ldc 171
    //   302: aastore
    //   303: invokevirtual 174	com/tencent/turingfd/sdk/xq/Mandarin:b	([Ljava/lang/String;)Lcom/tencent/turingfd/sdk/xq/Mandarin;
    //   306: invokevirtual 177	com/tencent/turingfd/sdk/xq/Mandarin:a	()Ljava/security/spec/AlgorithmParameterSpec;
    //   309: astore 7
    //   311: aload 5
    //   313: aload 7
    //   315: invokevirtual 181	java/security/KeyPairGenerator:initialize	(Ljava/security/spec/AlgorithmParameterSpec;)V
    //   318: aload 5
    //   320: invokevirtual 185	java/security/KeyPairGenerator:generateKeyPair	()Ljava/security/KeyPair;
    //   323: pop
    //   324: goto +62 -> 386
    //   327: goto +59 -> 386
    //   330: sipush -1701
    //   333: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   336: areturn
    //   337: sipush -1605
    //   340: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   343: areturn
    //   344: sipush -1604
    //   347: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   350: areturn
    //   351: sipush -1603
    //   354: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   357: areturn
    //   358: sipush -1602
    //   361: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   364: areturn
    //   365: sipush -1601
    //   368: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   371: areturn
    //   372: sipush -1502
    //   375: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   378: areturn
    //   379: sipush -1501
    //   382: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   385: areturn
    //   386: iload_0
    //   387: ifeq +82 -> 469
    //   390: new 130	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   397: astore 5
    //   399: aload 5
    //   401: ldc 135
    //   403: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 5
    //   409: iload_2
    //   410: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: new 187	com/tencent/turingfd/sdk/xq/Melon
    //   417: dup
    //   418: aload 6
    //   420: aload 5
    //   422: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 191	java/security/KeyStore:getCertificateChain	(Ljava/lang/String;)[Ljava/security/cert/Certificate;
    //   428: invokespecial 194	com/tencent/turingfd/sdk/xq/Melon:<init>	([Ljava/security/cert/Certificate;)V
    //   431: astore 5
    //   433: new 85	com/tencent/turingfd/sdk/xq/Mango
    //   436: dup
    //   437: iconst_0
    //   438: bipush 100
    //   440: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   443: lload_3
    //   444: lsub
    //   445: aload 5
    //   447: getfield 197	com/tencent/turingfd/sdk/xq/Melon:h	Ljava/lang/String;
    //   450: iconst_m1
    //   451: invokespecial 200	com/tencent/turingfd/sdk/xq/Mango:<init>	(IIJLjava/lang/String;I)V
    //   454: astore 5
    //   456: aload 5
    //   458: areturn
    //   459: astore 5
    //   461: aload 5
    //   463: invokevirtual 203	java/security/KeyStoreException:printStackTrace	()V
    //   466: goto +143 -> 609
    //   469: new 130	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   476: astore 5
    //   478: aload 5
    //   480: ldc 135
    //   482: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 5
    //   488: iload_2
    //   489: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: aload 6
    //   495: aload 5
    //   497: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: getstatic 206	com/tencent/turingfd/sdk/xq/import:L0	[I
    //   503: invokestatic 17	com/tencent/turingfd/sdk/xq/import:a	([I)Ljava/lang/String;
    //   506: invokevirtual 210	java/lang/String:toCharArray	()[C
    //   509: invokevirtual 214	java/security/KeyStore:getKey	(Ljava/lang/String;[C)Ljava/security/Key;
    //   512: astore 5
    //   514: aload 5
    //   516: ifnull +93 -> 609
    //   519: aload 5
    //   521: invokeinterface 220 1 0
    //   526: invokestatic 223	com/tencent/turingfd/sdk/xq/Nectarine:a	([B)Lcom/tencent/turingfd/sdk/xq/Nectarine$if;
    //   529: astore 5
    //   531: aload 5
    //   533: getfield 228	com/tencent/turingfd/sdk/xq/Nectarine$if:a	I
    //   536: istore_0
    //   537: iload_0
    //   538: ifeq +8 -> 546
    //   541: iload_0
    //   542: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   545: areturn
    //   546: aload 5
    //   548: getfield 231	com/tencent/turingfd/sdk/xq/Nectarine$if:b	Lcom/tencent/turingfd/sdk/xq/Melon;
    //   551: astore 5
    //   553: new 130	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   560: astore 7
    //   562: aload 7
    //   564: ldc 135
    //   566: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   569: pop
    //   570: aload 7
    //   572: iload_2
    //   573: invokevirtual 142	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: pop
    //   577: aload 6
    //   579: aload 7
    //   581: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokevirtual 235	java/security/KeyStore:deleteEntry	(Ljava/lang/String;)V
    //   587: new 85	com/tencent/turingfd/sdk/xq/Mango
    //   590: dup
    //   591: iconst_0
    //   592: bipush 100
    //   594: invokestatic 51	java/lang/System:currentTimeMillis	()J
    //   597: lload_3
    //   598: lsub
    //   599: aload 5
    //   601: getfield 197	com/tencent/turingfd/sdk/xq/Melon:h	Ljava/lang/String;
    //   604: iconst_m1
    //   605: invokespecial 200	com/tencent/turingfd/sdk/xq/Mango:<init>	(IIJLjava/lang/String;I)V
    //   608: areturn
    //   609: sipush -1901
    //   612: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   615: areturn
    //   616: sipush -1803
    //   619: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   622: areturn
    //   623: sipush -1802
    //   626: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   629: areturn
    //   630: sipush -1801
    //   633: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   636: areturn
    //   637: sipush -1304
    //   640: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   643: areturn
    //   644: sipush -1303
    //   647: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   650: areturn
    //   651: sipush -1302
    //   654: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   657: areturn
    //   658: sipush -1301
    //   661: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   664: areturn
    //   665: sipush -1104
    //   668: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   671: areturn
    //   672: sipush -1103
    //   675: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   678: areturn
    //   679: sipush -1102
    //   682: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   685: areturn
    //   686: sipush -1101
    //   689: invokestatic 88	com/tencent/turingfd/sdk/xq/Mango:a	(I)Lcom/tencent/turingfd/sdk/xq/Mango;
    //   692: areturn
    //   693: astore 5
    //   695: goto -9 -> 686
    //   698: astore 5
    //   700: goto -21 -> 679
    //   703: astore 5
    //   705: goto -33 -> 672
    //   708: astore 5
    //   710: goto -45 -> 665
    //   713: astore 5
    //   715: goto -57 -> 658
    //   718: astore 5
    //   720: goto -69 -> 651
    //   723: astore 5
    //   725: goto -81 -> 644
    //   728: astore 5
    //   730: goto -93 -> 637
    //   733: astore 7
    //   735: goto -527 -> 208
    //   738: astore 5
    //   740: goto -361 -> 379
    //   743: astore 5
    //   745: goto -373 -> 372
    //   748: astore 5
    //   750: goto -385 -> 365
    //   753: astore 5
    //   755: goto -397 -> 358
    //   758: astore 5
    //   760: goto -409 -> 351
    //   763: astore 5
    //   765: goto -421 -> 344
    //   768: astore 5
    //   770: goto -433 -> 337
    //   773: astore 5
    //   775: goto -445 -> 330
    //   778: astore 5
    //   780: goto -453 -> 327
    //   783: astore 5
    //   785: goto -155 -> 630
    //   788: astore 5
    //   790: goto -167 -> 623
    //   793: astore 5
    //   795: goto -179 -> 616
    //   798: astore 6
    //   800: goto -213 -> 587
    //   803: iconst_4
    //   804: istore_1
    //   805: goto -529 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   67	475	0	i	int
    //   65	740	1	j	int
    //   161	412	2	k	int
    //   3	595	3	l	long
    //   26	431	5	localObject1	Object
    //   459	3	5	localKeyStoreException1	java.security.KeyStoreException
    //   476	124	5	localObject2	Object
    //   693	1	5	localInvocationTargetException1	java.lang.reflect.InvocationTargetException
    //   698	1	5	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   703	1	5	localIllegalAccessException1	java.lang.IllegalAccessException
    //   708	1	5	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   713	1	5	localKeyStoreException2	java.security.KeyStoreException
    //   718	1	5	localCertificateException	java.security.cert.CertificateException
    //   723	1	5	localIOException	java.io.IOException
    //   728	1	5	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   738	1	5	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   743	1	5	localNoSuchProviderException	java.security.NoSuchProviderException
    //   748	1	5	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   753	1	5	localNoSuchMethodException2	java.lang.NoSuchMethodException
    //   758	1	5	localIllegalAccessException2	java.lang.IllegalAccessException
    //   763	1	5	localInvocationTargetException2	java.lang.reflect.InvocationTargetException
    //   768	1	5	localInstantiationException	java.lang.InstantiationException
    //   773	1	5	localInvalidAlgorithmParameterException	java.security.InvalidAlgorithmParameterException
    //   778	1	5	localObject3	Object
    //   783	1	5	localKeyStoreException3	java.security.KeyStoreException
    //   788	1	5	localNoSuchAlgorithmException3	java.security.NoSuchAlgorithmException
    //   793	1	5	localUnrecoverableKeyException	java.security.UnrecoverableKeyException
    //   48	530	6	localObject4	Object
    //   798	1	6	localObject5	Object
    //   169	411	7	localObject6	Object
    //   733	1	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   390	456	459	java/security/KeyStoreException
    //   4	45	693	java/lang/reflect/InvocationTargetException
    //   4	45	698	java/lang/NoSuchMethodException
    //   4	45	703	java/lang/IllegalAccessException
    //   4	45	708	java/lang/ClassNotFoundException
    //   145	158	713	java/security/KeyStoreException
    //   145	158	718	java/security/cert/CertificateException
    //   145	158	723	java/io/IOException
    //   145	158	728	java/security/NoSuchAlgorithmException
    //   162	198	733	finally
    //   214	223	738	java/security/NoSuchAlgorithmException
    //   214	223	743	java/security/NoSuchProviderException
    //   223	266	748	java/lang/ClassNotFoundException
    //   276	311	748	java/lang/ClassNotFoundException
    //   223	266	753	java/lang/NoSuchMethodException
    //   276	311	753	java/lang/NoSuchMethodException
    //   223	266	758	java/lang/IllegalAccessException
    //   276	311	758	java/lang/IllegalAccessException
    //   223	266	763	java/lang/reflect/InvocationTargetException
    //   276	311	763	java/lang/reflect/InvocationTargetException
    //   223	266	768	java/lang/InstantiationException
    //   276	311	768	java/lang/InstantiationException
    //   311	318	773	java/security/InvalidAlgorithmParameterException
    //   318	324	778	finally
    //   469	514	783	java/security/KeyStoreException
    //   469	514	788	java/security/NoSuchAlgorithmException
    //   469	514	793	java/security/UnrecoverableKeyException
    //   553	587	798	finally
  }
  
  public static Mango a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    Intent localIntent = new Intent();
    localIntent.setAction(import.a(import.M0));
    localIntent.setPackage(import.a(import.N0));
    Object localObject = new Object();
    AtomicReference localAtomicReference = new AtomicReference();
    localAtomicReference.set(Mango.b(-2001));
    if (paramContext.getApplicationContext().bindService(localIntent, new Nectarine.do(localAtomicReference, l, localObject), 1)) {}
    try
    {
      try
      {
        localObject.wait(5000L);
      }
      finally
      {
        break label110;
      }
    }
    catch (InterruptedException paramContext)
    {
      label105:
      break label105;
    }
    break label125;
    label110:
    throw paramContext;
    localAtomicReference.set(Mango.b(-2002));
    label125:
    return (Mango)localAtomicReference.get();
  }
  
  public static Nectarine.if a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return new Nectarine.if(-3001, null);
    }
    if (paramArrayOfByte.length < 4) {
      return new Nectarine.if(-3001, null);
    }
    Object localObject = new byte[4];
    System.arraycopy(paramArrayOfByte, 0, localObject, 0, 4);
    int j = 0;
    int i = 0;
    while (j < 4)
    {
      i += ((localObject[j] & 0xFF) << j * 8);
      j += 1;
    }
    if (i > 1048576) {
      return new Nectarine.if(-3003, null);
    }
    localObject = new byte[i];
    int k = paramArrayOfByte.length;
    j = i + 4;
    if (k < j) {
      return new Nectarine.if(-3004, null);
    }
    System.arraycopy(paramArrayOfByte, 4, localObject, 0, i);
    localObject = new Melon(new String((byte[])localObject), "");
    i = paramArrayOfByte.length - j;
    if (i != 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, j, arrayOfByte, 0, i);
      Base64.encodeToString(arrayOfByte, 2);
      return new Nectarine.if(0, (Melon)localObject);
    }
    return new Nectarine.if(-3005, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Nectarine
 * JD-Core Version:    0.7.0.1
 */