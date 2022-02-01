package com.tencent.mobileqq.msf.core.net.patch;

public class PatchChecker
{
  public static final String PATCH_TYPE_DEX = "dex";
  
  /* Error */
  private static int checkJarPatchSignature(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: sipush 302
    //   6: istore_3
    //   7: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10: invokevirtual 33	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   13: ldc 35
    //   15: bipush 64
    //   17: invokevirtual 41	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   20: getfield 47	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   23: iconst_0
    //   24: aaload
    //   25: astore 7
    //   27: new 49	java/util/jar/JarFile
    //   30: dup
    //   31: aload_0
    //   32: invokestatic 55	com/tencent/mobileqq/msf/core/net/patch/PatchCommonUtil:getPatchPath	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokespecial 58	java/util/jar/JarFile:<init>	(Ljava/lang/String;)V
    //   38: astore 6
    //   40: aload 6
    //   42: astore 5
    //   44: aload 6
    //   46: invokevirtual 62	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   49: astore 8
    //   51: sipush 301
    //   54: istore_2
    //   55: iload_2
    //   56: istore_1
    //   57: aload 6
    //   59: astore 5
    //   61: aload 8
    //   63: invokeinterface 68 1 0
    //   68: ifeq +187 -> 255
    //   71: aload 6
    //   73: astore 5
    //   75: aload 8
    //   77: invokeinterface 72 1 0
    //   82: checkcast 74	java/util/jar/JarEntry
    //   85: astore 9
    //   87: aload 6
    //   89: astore 5
    //   91: aload 9
    //   93: invokevirtual 77	java/util/jar/JarEntry:isDirectory	()Z
    //   96: ifne -41 -> 55
    //   99: aload 6
    //   101: astore 5
    //   103: aload 9
    //   105: invokevirtual 81	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   108: ldc 83
    //   110: invokevirtual 89	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   113: ifne -58 -> 55
    //   116: aload 6
    //   118: astore 5
    //   120: aload 6
    //   122: aload 9
    //   124: invokestatic 93	com/tencent/mobileqq/msf/core/net/patch/PatchChecker:loadPatchCertificates	(Ljava/util/jar/JarFile;Ljava/util/jar/JarEntry;)[Ljava/security/cert/Certificate;
    //   127: astore 10
    //   129: aload 10
    //   131: ifnull -76 -> 55
    //   134: aload 6
    //   136: astore 5
    //   138: aload 10
    //   140: arraylength
    //   141: iconst_1
    //   142: if_icmpne -87 -> 55
    //   145: aload 6
    //   147: astore 5
    //   149: new 95	android/content/pm/Signature
    //   152: dup
    //   153: aload 10
    //   155: iconst_0
    //   156: aaload
    //   157: invokevirtual 101	java/security/cert/Certificate:getEncoded	()[B
    //   160: invokespecial 104	android/content/pm/Signature:<init>	([B)V
    //   163: aload 7
    //   165: invokevirtual 108	android/content/pm/Signature:equals	(Ljava/lang/Object;)Z
    //   168: ifeq +505 -> 673
    //   171: sipush 300
    //   174: istore_1
    //   175: goto +3 -> 178
    //   178: aload 6
    //   180: astore 5
    //   182: new 110	java/lang/StringBuilder
    //   185: dup
    //   186: ldc 112
    //   188: invokespecial 113	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   191: astore 10
    //   193: aload 6
    //   195: astore 5
    //   197: aload 10
    //   199: aload 9
    //   201: invokevirtual 81	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   204: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 6
    //   210: astore 5
    //   212: aload 10
    //   214: ldc 119
    //   216: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 6
    //   222: astore 5
    //   224: aload 10
    //   226: iload_1
    //   227: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 6
    //   233: astore 5
    //   235: ldc 124
    //   237: iconst_1
    //   238: aload 10
    //   240: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: iload_1
    //   247: istore_2
    //   248: sipush 300
    //   251: iload_1
    //   252: if_icmpeq -197 -> 55
    //   255: iload_1
    //   256: istore_2
    //   257: iload_2
    //   258: istore_1
    //   259: aload 6
    //   261: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   264: iload_2
    //   265: istore_1
    //   266: goto +341 -> 607
    //   269: astore 5
    //   271: aload 5
    //   273: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   276: goto +331 -> 607
    //   279: astore 7
    //   281: goto +30 -> 311
    //   284: astore 7
    //   286: goto +101 -> 387
    //   289: astore 7
    //   291: goto +172 -> 463
    //   294: astore 7
    //   296: goto +243 -> 539
    //   299: astore_0
    //   300: aconst_null
    //   301: astore 5
    //   303: goto +342 -> 645
    //   306: astore 7
    //   308: aconst_null
    //   309: astore 6
    //   311: aload 6
    //   313: astore 5
    //   315: new 110	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   322: astore 8
    //   324: aload 6
    //   326: astore 5
    //   328: aload 8
    //   330: ldc 142
    //   332: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 6
    //   338: astore 5
    //   340: aload 8
    //   342: aload 7
    //   344: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 6
    //   350: astore 5
    //   352: ldc 124
    //   354: iconst_1
    //   355: aload 8
    //   357: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: iload_3
    //   364: istore_1
    //   365: aload 6
    //   367: ifnull +240 -> 607
    //   370: iload_3
    //   371: istore_1
    //   372: aload 6
    //   374: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   377: iload_3
    //   378: istore_1
    //   379: goto +228 -> 607
    //   382: astore 7
    //   384: aconst_null
    //   385: astore 6
    //   387: aload 6
    //   389: astore 5
    //   391: new 110	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   398: astore 8
    //   400: aload 6
    //   402: astore 5
    //   404: aload 8
    //   406: ldc 147
    //   408: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 6
    //   414: astore 5
    //   416: aload 8
    //   418: aload 7
    //   420: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload 6
    //   426: astore 5
    //   428: ldc 124
    //   430: iconst_1
    //   431: aload 8
    //   433: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   439: iload_3
    //   440: istore_1
    //   441: aload 6
    //   443: ifnull +164 -> 607
    //   446: iload_3
    //   447: istore_1
    //   448: aload 6
    //   450: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   453: iload_3
    //   454: istore_1
    //   455: goto +152 -> 607
    //   458: astore 7
    //   460: aconst_null
    //   461: astore 6
    //   463: aload 6
    //   465: astore 5
    //   467: new 110	java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   474: astore 8
    //   476: aload 6
    //   478: astore 5
    //   480: aload 8
    //   482: ldc 149
    //   484: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 6
    //   490: astore 5
    //   492: aload 8
    //   494: aload 7
    //   496: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: pop
    //   500: aload 6
    //   502: astore 5
    //   504: ldc 124
    //   506: iconst_1
    //   507: aload 8
    //   509: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iload_3
    //   516: istore_1
    //   517: aload 6
    //   519: ifnull +88 -> 607
    //   522: iload_3
    //   523: istore_1
    //   524: aload 6
    //   526: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   529: iload_3
    //   530: istore_1
    //   531: goto +76 -> 607
    //   534: astore 7
    //   536: aconst_null
    //   537: astore 6
    //   539: aload 6
    //   541: astore 5
    //   543: new 110	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   550: astore 8
    //   552: aload 6
    //   554: astore 5
    //   556: aload 8
    //   558: ldc 151
    //   560: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 6
    //   566: astore 5
    //   568: aload 8
    //   570: aload 7
    //   572: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   575: pop
    //   576: aload 6
    //   578: astore 5
    //   580: ldc 124
    //   582: iconst_1
    //   583: aload 8
    //   585: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: iload_3
    //   592: istore_1
    //   593: aload 6
    //   595: ifnull +12 -> 607
    //   598: iload_3
    //   599: istore_1
    //   600: aload 6
    //   602: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   605: iload_3
    //   606: istore_1
    //   607: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   610: astore 5
    //   612: iload_1
    //   613: sipush 300
    //   616: if_icmpne +6 -> 622
    //   619: iconst_1
    //   620: istore 4
    //   622: aload 5
    //   624: aload_0
    //   625: iload 4
    //   627: invokestatic 157	com/tencent/mobileqq/msf/core/net/patch/PatchSharedPreUtil:updatePatchVerifyStatus	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   630: invokestatic 29	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   633: ldc 159
    //   635: ldc 161
    //   637: iload_1
    //   638: aload_0
    //   639: invokestatic 167	com/tencent/mobileqq/msf/core/net/patch/PatchReporter:reportPatchEvent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   642: iload_1
    //   643: ireturn
    //   644: astore_0
    //   645: aload 5
    //   647: ifnull +18 -> 665
    //   650: aload 5
    //   652: invokevirtual 136	java/util/jar/JarFile:close	()V
    //   655: goto +10 -> 665
    //   658: astore 5
    //   660: aload 5
    //   662: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   665: goto +5 -> 670
    //   668: aload_0
    //   669: athrow
    //   670: goto -2 -> 668
    //   673: sipush 301
    //   676: istore_1
    //   677: goto -499 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	paramString	String
    //   56	621	1	i	int
    //   54	211	2	j	int
    //   6	600	3	k	int
    //   1	625	4	bool	boolean
    //   42	192	5	localJarFile1	java.util.jar.JarFile
    //   269	3	5	localIOException1	java.io.IOException
    //   301	350	5	localObject1	Object
    //   658	3	5	localIOException2	java.io.IOException
    //   38	563	6	localJarFile2	java.util.jar.JarFile
    //   25	139	7	localSignature	android.content.pm.Signature
    //   279	1	7	localThrowable1	java.lang.Throwable
    //   284	1	7	localNameNotFoundException1	android.content.pm.PackageManager.NameNotFoundException
    //   289	1	7	localIOException3	java.io.IOException
    //   294	1	7	localCertificateEncodingException1	java.security.cert.CertificateEncodingException
    //   306	37	7	localThrowable2	java.lang.Throwable
    //   382	37	7	localNameNotFoundException2	android.content.pm.PackageManager.NameNotFoundException
    //   458	37	7	localIOException4	java.io.IOException
    //   534	37	7	localCertificateEncodingException2	java.security.cert.CertificateEncodingException
    //   49	535	8	localObject2	Object
    //   85	115	9	localJarEntry	java.util.jar.JarEntry
    //   127	112	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   259	264	269	java/io/IOException
    //   372	377	269	java/io/IOException
    //   448	453	269	java/io/IOException
    //   524	529	269	java/io/IOException
    //   600	605	269	java/io/IOException
    //   44	51	279	java/lang/Throwable
    //   61	71	279	java/lang/Throwable
    //   75	87	279	java/lang/Throwable
    //   91	99	279	java/lang/Throwable
    //   103	116	279	java/lang/Throwable
    //   120	129	279	java/lang/Throwable
    //   138	145	279	java/lang/Throwable
    //   149	171	279	java/lang/Throwable
    //   182	193	279	java/lang/Throwable
    //   197	208	279	java/lang/Throwable
    //   212	220	279	java/lang/Throwable
    //   224	231	279	java/lang/Throwable
    //   235	246	279	java/lang/Throwable
    //   44	51	284	android/content/pm/PackageManager$NameNotFoundException
    //   61	71	284	android/content/pm/PackageManager$NameNotFoundException
    //   75	87	284	android/content/pm/PackageManager$NameNotFoundException
    //   91	99	284	android/content/pm/PackageManager$NameNotFoundException
    //   103	116	284	android/content/pm/PackageManager$NameNotFoundException
    //   120	129	284	android/content/pm/PackageManager$NameNotFoundException
    //   138	145	284	android/content/pm/PackageManager$NameNotFoundException
    //   149	171	284	android/content/pm/PackageManager$NameNotFoundException
    //   182	193	284	android/content/pm/PackageManager$NameNotFoundException
    //   197	208	284	android/content/pm/PackageManager$NameNotFoundException
    //   212	220	284	android/content/pm/PackageManager$NameNotFoundException
    //   224	231	284	android/content/pm/PackageManager$NameNotFoundException
    //   235	246	284	android/content/pm/PackageManager$NameNotFoundException
    //   44	51	289	java/io/IOException
    //   61	71	289	java/io/IOException
    //   75	87	289	java/io/IOException
    //   91	99	289	java/io/IOException
    //   103	116	289	java/io/IOException
    //   120	129	289	java/io/IOException
    //   138	145	289	java/io/IOException
    //   149	171	289	java/io/IOException
    //   182	193	289	java/io/IOException
    //   197	208	289	java/io/IOException
    //   212	220	289	java/io/IOException
    //   224	231	289	java/io/IOException
    //   235	246	289	java/io/IOException
    //   44	51	294	java/security/cert/CertificateEncodingException
    //   61	71	294	java/security/cert/CertificateEncodingException
    //   75	87	294	java/security/cert/CertificateEncodingException
    //   91	99	294	java/security/cert/CertificateEncodingException
    //   103	116	294	java/security/cert/CertificateEncodingException
    //   120	129	294	java/security/cert/CertificateEncodingException
    //   138	145	294	java/security/cert/CertificateEncodingException
    //   149	171	294	java/security/cert/CertificateEncodingException
    //   182	193	294	java/security/cert/CertificateEncodingException
    //   197	208	294	java/security/cert/CertificateEncodingException
    //   212	220	294	java/security/cert/CertificateEncodingException
    //   224	231	294	java/security/cert/CertificateEncodingException
    //   235	246	294	java/security/cert/CertificateEncodingException
    //   7	40	299	finally
    //   7	40	306	java/lang/Throwable
    //   7	40	382	android/content/pm/PackageManager$NameNotFoundException
    //   7	40	458	java/io/IOException
    //   7	40	534	java/security/cert/CertificateEncodingException
    //   44	51	644	finally
    //   61	71	644	finally
    //   75	87	644	finally
    //   91	99	644	finally
    //   103	116	644	finally
    //   120	129	644	finally
    //   138	145	644	finally
    //   149	171	644	finally
    //   182	193	644	finally
    //   197	208	644	finally
    //   212	220	644	finally
    //   224	231	644	finally
    //   235	246	644	finally
    //   315	324	644	finally
    //   328	336	644	finally
    //   340	348	644	finally
    //   352	363	644	finally
    //   391	400	644	finally
    //   404	412	644	finally
    //   416	424	644	finally
    //   428	439	644	finally
    //   467	476	644	finally
    //   480	488	644	finally
    //   492	500	644	finally
    //   504	515	644	finally
    //   543	552	644	finally
    //   556	564	644	finally
    //   568	576	644	finally
    //   580	591	644	finally
    //   650	655	658	java/io/IOException
  }
  
  public static boolean checkPatchValid(String paramString1, String paramString2)
  {
    boolean bool3 = "dex".equals(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
    //   1: astore_3
    //   2: new 176	java/io/BufferedInputStream
    //   5: dup
    //   6: aload_0
    //   7: aload_1
    //   8: invokevirtual 180	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   11: invokespecial 183	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   14: astore_2
    //   15: aload_2
    //   16: astore_0
    //   17: sipush 4096
    //   20: newarray byte
    //   22: astore 4
    //   24: aload_2
    //   25: astore_0
    //   26: aload_2
    //   27: aload 4
    //   29: iconst_0
    //   30: aload 4
    //   32: arraylength
    //   33: invokevirtual 189	java/io/InputStream:read	([BII)I
    //   36: iconst_m1
    //   37: if_icmpeq +6 -> 43
    //   40: goto -16 -> 24
    //   43: aload_3
    //   44: astore_0
    //   45: aload_1
    //   46: ifnull +12 -> 58
    //   49: aload_2
    //   50: astore_0
    //   51: aload_1
    //   52: invokevirtual 193	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   55: astore_1
    //   56: aload_1
    //   57: astore_0
    //   58: aload_2
    //   59: invokevirtual 194	java/io/InputStream:close	()V
    //   62: aload_0
    //   63: areturn
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   69: aload_0
    //   70: areturn
    //   71: astore_1
    //   72: goto +16 -> 88
    //   75: astore_1
    //   76: goto +71 -> 147
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_0
    //   82: goto +115 -> 197
    //   85: astore_1
    //   86: aconst_null
    //   87: astore_2
    //   88: aload_2
    //   89: astore_0
    //   90: new 110	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   97: astore_3
    //   98: aload_2
    //   99: astore_0
    //   100: aload_3
    //   101: ldc 196
    //   103: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: astore_0
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_2
    //   116: astore_0
    //   117: ldc 124
    //   119: iconst_1
    //   120: aload_3
    //   121: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_2
    //   128: ifnull +66 -> 194
    //   131: aload_2
    //   132: invokevirtual 194	java/io/InputStream:close	()V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_0
    //   138: aload_0
    //   139: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   142: aconst_null
    //   143: areturn
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_2
    //   147: aload_2
    //   148: astore_0
    //   149: new 110	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   156: astore_3
    //   157: aload_2
    //   158: astore_0
    //   159: aload_3
    //   160: ldc 198
    //   162: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_2
    //   167: astore_0
    //   168: aload_3
    //   169: aload_1
    //   170: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_2
    //   175: astore_0
    //   176: ldc 124
    //   178: iconst_1
    //   179: aload_3
    //   180: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: aload_2
    //   187: ifnull +7 -> 194
    //   190: aload_2
    //   191: invokevirtual 194	java/io/InputStream:close	()V
    //   194: aconst_null
    //   195: areturn
    //   196: astore_1
    //   197: aload_0
    //   198: ifnull +15 -> 213
    //   201: aload_0
    //   202: invokevirtual 194	java/io/InputStream:close	()V
    //   205: goto +8 -> 213
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 139	java/io/IOException:printStackTrace	()V
    //   213: goto +5 -> 218
    //   216: aload_1
    //   217: athrow
    //   218: goto -2 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	221	0	paramJarFile	java.util.jar.JarFile
    //   0	221	1	paramJarEntry	java.util.jar.JarEntry
    //   14	177	2	localBufferedInputStream	java.io.BufferedInputStream
    //   1	179	3	localStringBuilder	java.lang.StringBuilder
    //   22	9	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   58	62	64	java/io/IOException
    //   17	24	71	java/lang/RuntimeException
    //   26	40	71	java/lang/RuntimeException
    //   51	56	71	java/lang/RuntimeException
    //   17	24	75	java/io/IOException
    //   26	40	75	java/io/IOException
    //   51	56	75	java/io/IOException
    //   2	15	79	finally
    //   2	15	85	java/lang/RuntimeException
    //   131	135	137	java/io/IOException
    //   190	194	137	java/io/IOException
    //   2	15	144	java/io/IOException
    //   17	24	196	finally
    //   26	40	196	finally
    //   51	56	196	finally
    //   90	98	196	finally
    //   100	107	196	finally
    //   109	115	196	finally
    //   117	127	196	finally
    //   149	157	196	finally
    //   159	166	196	finally
    //   168	174	196	finally
    //   176	186	196	finally
    //   201	205	208	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.patch.PatchChecker
 * JD-Core Version:    0.7.0.1
 */