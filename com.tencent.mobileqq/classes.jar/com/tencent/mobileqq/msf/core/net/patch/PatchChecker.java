package com.tencent.mobileqq.msf.core.net.patch;

public class PatchChecker
{
  public static final String PATCH_TYPE_DEX = "dex";
  
  /* Error */
  private static int checkJarPatchSignature(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   6: invokevirtual 33	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   9: ldc 35
    //   11: bipush 64
    //   13: invokevirtual 41	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   16: getfield 47	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   19: iconst_0
    //   20: aaload
    //   21: astore 6
    //   23: new 49	java/util/jar/JarFile
    //   26: dup
    //   27: aload_0
    //   28: invokestatic 55	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial 58	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   34: astore 4
    //   36: aload 4
    //   38: astore 5
    //   40: aload 4
    //   42: invokevirtual 62	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   45: astore 7
    //   47: sipush 301
    //   50: istore_1
    //   51: aload 4
    //   53: astore 5
    //   55: aload 7
    //   57: invokeinterface 68 1 0
    //   62: ifeq +550 -> 612
    //   65: aload 4
    //   67: astore 5
    //   69: aload 7
    //   71: invokeinterface 72 1 0
    //   76: checkcast 74	java/util/jar/JarEntry
    //   79: astore 8
    //   81: iload_1
    //   82: istore_2
    //   83: aload 4
    //   85: astore 5
    //   87: aload 8
    //   89: invokevirtual 77	java/util/jar/JarEntry:isDirectory	()Z
    //   92: ifne +191 -> 283
    //   95: iload_1
    //   96: istore_2
    //   97: aload 4
    //   99: astore 5
    //   101: aload 8
    //   103: invokevirtual 81	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   106: ldc 83
    //   108: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   111: ifne +172 -> 283
    //   114: aload 4
    //   116: astore 5
    //   118: aload 4
    //   120: aload 8
    //   122: invokestatic 93	com/tencent/mobileqq/msf/core/net/patch/PatchChecker:loadPatchCertificates	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   125: astore 9
    //   127: iload_1
    //   128: istore_2
    //   129: aload 9
    //   131: ifnull +152 -> 283
    //   134: iload_1
    //   135: istore_2
    //   136: aload 4
    //   138: astore 5
    //   140: aload 9
    //   142: arraylength
    //   143: iconst_1
    //   144: if_icmpne +139 -> 283
    //   147: aload 4
    //   149: astore 5
    //   151: new 95	android/content/pm/Signature
    //   154: dup
    //   155: aload 9
    //   157: iconst_0
    //   158: aaload
    //   159: invokevirtual 101	java/security/cert/Certificate:getEncoded	()[B
    //   162: invokespecial 104	android/content/pm/Signature:<init>	([B)V
    //   165: aload 6
    //   167: invokevirtual 108	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   170: ifeq +106 -> 276
    //   173: sipush 300
    //   176: istore_1
    //   177: aload 4
    //   179: astore 5
    //   181: ldc 110
    //   183: iconst_1
    //   184: new 112	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 114
    //   190: invokespecial 115	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload 8
    //   195: invokevirtual 81	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   198: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 121
    //   203: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: iload_1
    //   207: invokevirtual 124	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload_1
    //   217: istore_2
    //   218: sipush 300
    //   221: iload_1
    //   222: if_icmpeq +61 -> 283
    //   225: iload_1
    //   226: istore_2
    //   227: iload_2
    //   228: istore_1
    //   229: aload 4
    //   231: ifnull +10 -> 241
    //   234: aload 4
    //   236: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   239: iload_2
    //   240: istore_1
    //   241: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   244: astore 4
    //   246: iload_1
    //   247: sipush 300
    //   250: if_icmpne +263 -> 513
    //   253: iconst_1
    //   254: istore_3
    //   255: aload 4
    //   257: aload_0
    //   258: iload_3
    //   259: invokestatic 142	com/tencent/mobileqq/msf/core/net/patch/PatchSharedPreUtil:updatePatchVerifyStatus	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   262: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   265: ldc 144
    //   267: ldc 146
    //   269: iload_1
    //   270: aload_0
    //   271: invokestatic 152	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   274: iload_1
    //   275: ireturn
    //   276: sipush 301
    //   279: istore_1
    //   280: goto -103 -> 177
    //   283: iload_2
    //   284: istore_1
    //   285: goto -234 -> 51
    //   288: astore 6
    //   290: aload 5
    //   292: astore 4
    //   294: aload 6
    //   296: astore 5
    //   298: ldc 110
    //   300: iconst_1
    //   301: new 112	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   308: ldc 155
    //   310: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload 5
    //   315: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload 4
    //   326: ifnull +8 -> 334
    //   329: aload 4
    //   331: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   334: sipush 302
    //   337: istore_1
    //   338: goto -97 -> 241
    //   341: astore 6
    //   343: aconst_null
    //   344: astore 4
    //   346: aload 4
    //   348: astore 5
    //   350: ldc 110
    //   352: iconst_1
    //   353: new 112	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   360: ldc 160
    //   362: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: aload 6
    //   367: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   376: aload 4
    //   378: ifnull +8 -> 386
    //   381: aload 4
    //   383: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   386: sipush 302
    //   389: istore_1
    //   390: goto -149 -> 241
    //   393: astore 6
    //   395: aconst_null
    //   396: astore 4
    //   398: aload 4
    //   400: astore 5
    //   402: ldc 110
    //   404: iconst_1
    //   405: new 112	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   412: ldc 162
    //   414: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload 6
    //   419: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload 4
    //   430: ifnull +8 -> 438
    //   433: aload 4
    //   435: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   438: sipush 302
    //   441: istore_1
    //   442: goto -201 -> 241
    //   445: astore 6
    //   447: aconst_null
    //   448: astore 4
    //   450: aload 4
    //   452: astore 5
    //   454: ldc 110
    //   456: iconst_1
    //   457: new 112	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   464: ldc 164
    //   466: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 6
    //   471: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload 4
    //   482: ifnull +8 -> 490
    //   485: aload 4
    //   487: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   490: sipush 302
    //   493: istore_1
    //   494: goto -253 -> 241
    //   497: astore_0
    //   498: aconst_null
    //   499: astore 5
    //   501: aload 5
    //   503: ifnull +8 -> 511
    //   506: aload 5
    //   508: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   511: aload_0
    //   512: athrow
    //   513: iconst_0
    //   514: istore_3
    //   515: goto -260 -> 255
    //   518: astore 4
    //   520: aload 4
    //   522: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   525: goto -14 -> 511
    //   528: astore 4
    //   530: aload 4
    //   532: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   535: goto -201 -> 334
    //   538: astore 4
    //   540: aload 4
    //   542: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   545: goto -159 -> 386
    //   548: astore 4
    //   550: aload 4
    //   552: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   555: goto -117 -> 438
    //   558: astore 4
    //   560: aload 4
    //   562: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   565: goto -75 -> 490
    //   568: astore 4
    //   570: aload 4
    //   572: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   575: iload_2
    //   576: istore_1
    //   577: goto -336 -> 241
    //   580: astore_0
    //   581: goto -80 -> 501
    //   584: astore_0
    //   585: aload 4
    //   587: astore 5
    //   589: goto -88 -> 501
    //   592: astore 6
    //   594: goto -144 -> 450
    //   597: astore 6
    //   599: goto -201 -> 398
    //   602: astore 6
    //   604: goto -258 -> 346
    //   607: astore 5
    //   609: goto -311 -> 298
    //   612: iload_1
    //   613: istore_2
    //   614: goto -387 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	paramString	String
    //   50	563	1	i	int
    //   82	532	2	j	int
    //   254	261	3	bool	boolean
    //   34	452	4	localObject1	Object
    //   518	3	4	localIOException1	java.io.IOException
    //   528	3	4	localIOException2	java.io.IOException
    //   538	3	4	localIOException3	java.io.IOException
    //   548	3	4	localIOException4	java.io.IOException
    //   558	3	4	localIOException5	java.io.IOException
    //   568	18	4	localIOException6	java.io.IOException
    //   1	587	5	localObject2	Object
    //   607	1	5	localCertificateEncodingException1	java.security.cert.CertificateEncodingException
    //   21	145	6	localSignature	android.content.pm.Signature
    //   288	7	6	localCertificateEncodingException2	java.security.cert.CertificateEncodingException
    //   341	25	6	localIOException7	java.io.IOException
    //   393	25	6	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   445	25	6	localThrowable1	java.lang.Throwable
    //   592	1	6	localThrowable2	java.lang.Throwable
    //   597	1	6	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   602	1	6	localIOException8	java.io.IOException
    //   45	25	7	localEnumeration	java.util.Enumeration
    //   79	115	8	localJarEntry	java.util.jar.JarEntry
    //   125	31	9	arrayOfCertificate	java.security.cert.Certificate[]
    // Exception table:
    //   from	to	target	type
    //   3	36	288	java/security/cert/CertificateEncodingException
    //   3	36	341	java/io/IOException
    //   3	36	393	android/content/pm/PackageManager$NameNotFoundException
    //   3	36	445	java/lang/Throwable
    //   3	36	497	finally
    //   506	511	518	java/io/IOException
    //   329	334	528	java/io/IOException
    //   381	386	538	java/io/IOException
    //   433	438	548	java/io/IOException
    //   485	490	558	java/io/IOException
    //   234	239	568	java/io/IOException
    //   40	47	580	finally
    //   55	65	580	finally
    //   69	81	580	finally
    //   87	95	580	finally
    //   101	114	580	finally
    //   118	127	580	finally
    //   140	147	580	finally
    //   151	173	580	finally
    //   181	216	580	finally
    //   350	376	580	finally
    //   402	428	580	finally
    //   454	480	580	finally
    //   298	324	584	finally
    //   40	47	592	java/lang/Throwable
    //   55	65	592	java/lang/Throwable
    //   69	81	592	java/lang/Throwable
    //   87	95	592	java/lang/Throwable
    //   101	114	592	java/lang/Throwable
    //   118	127	592	java/lang/Throwable
    //   140	147	592	java/lang/Throwable
    //   151	173	592	java/lang/Throwable
    //   181	216	592	java/lang/Throwable
    //   40	47	597	android/content/pm/PackageManager$NameNotFoundException
    //   55	65	597	android/content/pm/PackageManager$NameNotFoundException
    //   69	81	597	android/content/pm/PackageManager$NameNotFoundException
    //   87	95	597	android/content/pm/PackageManager$NameNotFoundException
    //   101	114	597	android/content/pm/PackageManager$NameNotFoundException
    //   118	127	597	android/content/pm/PackageManager$NameNotFoundException
    //   140	147	597	android/content/pm/PackageManager$NameNotFoundException
    //   151	173	597	android/content/pm/PackageManager$NameNotFoundException
    //   181	216	597	android/content/pm/PackageManager$NameNotFoundException
    //   40	47	602	java/io/IOException
    //   55	65	602	java/io/IOException
    //   69	81	602	java/io/IOException
    //   87	95	602	java/io/IOException
    //   101	114	602	java/io/IOException
    //   118	127	602	java/io/IOException
    //   140	147	602	java/io/IOException
    //   151	173	602	java/io/IOException
    //   181	216	602	java/io/IOException
    //   40	47	607	java/security/cert/CertificateEncodingException
    //   55	65	607	java/security/cert/CertificateEncodingException
    //   69	81	607	java/security/cert/CertificateEncodingException
    //   87	95	607	java/security/cert/CertificateEncodingException
    //   101	114	607	java/security/cert/CertificateEncodingException
    //   118	127	607	java/security/cert/CertificateEncodingException
    //   140	147	607	java/security/cert/CertificateEncodingException
    //   151	173	607	java/security/cert/CertificateEncodingException
    //   181	216	607	java/security/cert/CertificateEncodingException
  }
  
  public static boolean checkPatchValid(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("dex".equals(paramString1))
    {
      bool1 = bool2;
      if (300 == checkJarPatchSignature(paramString2)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  private static java.security.cert.Certificate[] loadPatchCertificates(java.util.jar.JarFile paramJarFile, java.util.jar.JarEntry paramJarEntry)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 5
    //   8: new 176	java/io/BufferedInputStream
    //   11: dup
    //   12: aload_0
    //   13: aload_1
    //   14: invokevirtual 180	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   17: invokespecial 183	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   20: astore_2
    //   21: aload_2
    //   22: astore_0
    //   23: sipush 4096
    //   26: newarray byte
    //   28: astore 6
    //   30: aload_2
    //   31: astore_0
    //   32: aload_2
    //   33: aload 6
    //   35: iconst_0
    //   36: aload 6
    //   38: arraylength
    //   39: invokevirtual 189	java/io/InputStream:read	([BII)I
    //   42: iconst_m1
    //   43: if_icmpne -13 -> 30
    //   46: aload 5
    //   48: astore_0
    //   49: aload_1
    //   50: ifnull +12 -> 62
    //   53: aload_2
    //   54: astore_0
    //   55: aload_1
    //   56: invokevirtual 193	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   59: astore_1
    //   60: aload_1
    //   61: astore_0
    //   62: aload_0
    //   63: astore_1
    //   64: aload_2
    //   65: ifnull +9 -> 74
    //   68: aload_2
    //   69: invokevirtual 194	java/io/InputStream:close	()V
    //   72: aload_0
    //   73: astore_1
    //   74: aload_1
    //   75: areturn
    //   76: astore_1
    //   77: aconst_null
    //   78: astore_2
    //   79: aload_2
    //   80: astore_0
    //   81: ldc 110
    //   83: iconst_1
    //   84: new 112	java/lang/StringBuilder
    //   87: dup
    //   88: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   91: ldc 196
    //   93: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload 4
    //   108: astore_1
    //   109: aload_2
    //   110: ifnull -36 -> 74
    //   113: aload_2
    //   114: invokevirtual 194	java/io/InputStream:close	()V
    //   117: aconst_null
    //   118: areturn
    //   119: astore_0
    //   120: aload_3
    //   121: astore_1
    //   122: aload_0
    //   123: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   126: aload_1
    //   127: areturn
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: aload_2
    //   132: astore_0
    //   133: ldc 110
    //   135: iconst_1
    //   136: new 112	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   143: ldc 198
    //   145: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: aload 4
    //   160: astore_1
    //   161: aload_2
    //   162: ifnull -88 -> 74
    //   165: aload_2
    //   166: invokevirtual 194	java/io/InputStream:close	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_0
    //   172: aload_3
    //   173: astore_1
    //   174: goto -52 -> 122
    //   177: astore_1
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: ifnull +7 -> 188
    //   184: aload_0
    //   185: invokevirtual 194	java/io/InputStream:close	()V
    //   188: aload_1
    //   189: athrow
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 167	java/io/IOException:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_2
    //   199: aload_0
    //   200: astore_1
    //   201: aload_2
    //   202: astore_0
    //   203: goto -81 -> 122
    //   206: astore_1
    //   207: goto -27 -> 180
    //   210: astore_1
    //   211: goto -80 -> 131
    //   214: astore_1
    //   215: goto -136 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramJarFile	java.util.jar.JarFile
    //   0	218	1	paramJarEntry	java.util.jar.JarEntry
    //   20	146	2	localBufferedInputStream	java.io.BufferedInputStream
    //   198	4	2	localIOException	java.io.IOException
    //   4	169	3	localObject1	Object
    //   1	158	4	localObject2	Object
    //   6	41	5	localObject3	Object
    //   28	9	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   8	21	76	java/io/IOException
    //   113	117	119	java/io/IOException
    //   8	21	128	java/lang/RuntimeException
    //   165	169	171	java/io/IOException
    //   8	21	177	finally
    //   184	188	190	java/io/IOException
    //   68	72	198	java/io/IOException
    //   23	30	206	finally
    //   32	46	206	finally
    //   55	60	206	finally
    //   81	106	206	finally
    //   133	158	206	finally
    //   23	30	210	java/lang/RuntimeException
    //   32	46	210	java/lang/RuntimeException
    //   55	60	210	java/lang/RuntimeException
    //   23	30	214	java/io/IOException
    //   32	46	214	java/io/IOException
    //   55	60	214	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchChecker
 * JD-Core Version:    0.7.0.1
 */