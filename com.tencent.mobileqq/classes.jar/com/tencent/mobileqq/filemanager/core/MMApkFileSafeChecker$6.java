package com.tencent.mobileqq.filemanager.core;

import atmo;
import atmy;

public class MMApkFileSafeChecker$6
  implements Runnable
{
  public MMApkFileSafeChecker$6(atmo paramatmo, String paramString, atmy paramatmy) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 10
    //   5: aconst_null
    //   6: astore 9
    //   8: new 32	java/io/BufferedInputStream
    //   11: dup
    //   12: new 34	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 17	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   20: invokespecial 37	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: invokespecial 40	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore 6
    //   28: aload 6
    //   30: astore 5
    //   32: sipush 10240
    //   35: newarray byte
    //   37: astore 11
    //   39: aload 6
    //   41: astore 5
    //   43: ldc 42
    //   45: invokestatic 48	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   48: astore 4
    //   50: aload 6
    //   52: astore 5
    //   54: ldc 50
    //   56: invokestatic 48	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   59: astore 8
    //   61: aload 6
    //   63: astore 5
    //   65: aload 6
    //   67: aload 11
    //   69: invokevirtual 56	java/io/InputStream:read	([B)I
    //   72: istore_1
    //   73: iload_1
    //   74: ifle +189 -> 263
    //   77: aload 6
    //   79: astore 5
    //   81: aload 4
    //   83: aload 11
    //   85: iconst_0
    //   86: iload_1
    //   87: invokevirtual 60	java/security/MessageDigest:update	([BII)V
    //   90: aload 6
    //   92: astore 5
    //   94: aload 8
    //   96: aload 11
    //   98: iconst_0
    //   99: iload_1
    //   100: invokevirtual 60	java/security/MessageDigest:update	([BII)V
    //   103: goto -42 -> 61
    //   106: astore 7
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 6
    //   113: astore 5
    //   115: aload 7
    //   117: invokevirtual 63	java/io/FileNotFoundException:printStackTrace	()V
    //   120: aload 9
    //   122: astore 8
    //   124: aload 4
    //   126: astore 5
    //   128: iload_3
    //   129: istore_2
    //   130: aload 6
    //   132: ifnull +18 -> 150
    //   135: aload 6
    //   137: invokevirtual 66	java/io/InputStream:close	()V
    //   140: iload_3
    //   141: istore_2
    //   142: aload 4
    //   144: astore 5
    //   146: aload 9
    //   148: astore 8
    //   150: new 68	atmw
    //   153: dup
    //   154: aload_0
    //   155: getfield 15	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:this$0	Latmo;
    //   158: invokespecial 71	atmw:<init>	(Latmo;)V
    //   161: astore 4
    //   163: aload 4
    //   165: aload 5
    //   167: putfield 74	atmw:jdField_a_of_type_ArrayOfByte	[B
    //   170: aload 4
    //   172: aload 8
    //   174: putfield 77	atmw:jdField_b_of_type_ArrayOfByte	[B
    //   177: aload 4
    //   179: aload_0
    //   180: getfield 17	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   183: invokestatic 83	com/tencent/mobileqq/filemanager/util/FileUtil:getFileSize	(Ljava/lang/String;)J
    //   186: putfield 86	atmw:jdField_a_of_type_Long	J
    //   189: aload 4
    //   191: invokestatic 92	java/lang/System:currentTimeMillis	()J
    //   194: putfield 94	atmw:jdField_b_of_type_Long	J
    //   197: iload_2
    //   198: ifeq +32 -> 230
    //   201: aload 4
    //   203: getfield 74	atmw:jdField_a_of_type_ArrayOfByte	[B
    //   206: ifnull +24 -> 230
    //   209: aload 4
    //   211: getfield 77	atmw:jdField_b_of_type_ArrayOfByte	[B
    //   214: ifnull +16 -> 230
    //   217: aload_0
    //   218: getfield 15	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:this$0	Latmo;
    //   221: aload_0
    //   222: getfield 17	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   225: aload 4
    //   227: invokestatic 99	atmo:a	(Latmo;Ljava/lang/String;Latmw;)V
    //   230: aload_0
    //   231: getfield 19	com/tencent/mobileqq/filemanager/core/MMApkFileSafeChecker$6:jdField_a_of_type_Atmy	Latmy;
    //   234: iload_2
    //   235: aload 4
    //   237: invokeinterface 104 3 0
    //   242: return
    //   243: astore 7
    //   245: aconst_null
    //   246: astore 4
    //   248: aload 6
    //   250: astore 5
    //   252: aload 7
    //   254: invokevirtual 105	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   257: aconst_null
    //   258: astore 8
    //   260: goto -199 -> 61
    //   263: aload 6
    //   265: astore 5
    //   267: aload 6
    //   269: invokevirtual 66	java/io/InputStream:close	()V
    //   272: aload 4
    //   274: ifnull +260 -> 534
    //   277: aload 6
    //   279: astore 5
    //   281: aload 4
    //   283: invokevirtual 109	java/security/MessageDigest:digest	()[B
    //   286: astore 4
    //   288: aload 10
    //   290: astore 7
    //   292: aload 8
    //   294: ifnull +14 -> 308
    //   297: aload 6
    //   299: astore 5
    //   301: aload 8
    //   303: invokevirtual 109	java/security/MessageDigest:digest	()[B
    //   306: astore 7
    //   308: iconst_1
    //   309: istore_3
    //   310: aload 7
    //   312: astore 8
    //   314: aload 4
    //   316: astore 5
    //   318: iload_3
    //   319: istore_2
    //   320: aload 6
    //   322: ifnull -172 -> 150
    //   325: aload 6
    //   327: invokevirtual 66	java/io/InputStream:close	()V
    //   330: aload 7
    //   332: astore 8
    //   334: aload 4
    //   336: astore 5
    //   338: iload_3
    //   339: istore_2
    //   340: goto -190 -> 150
    //   343: astore 5
    //   345: aload 5
    //   347: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   350: aload 7
    //   352: astore 8
    //   354: aload 4
    //   356: astore 5
    //   358: iload_3
    //   359: istore_2
    //   360: goto -210 -> 150
    //   363: astore 7
    //   365: aload 6
    //   367: astore 5
    //   369: aload 7
    //   371: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   374: goto -102 -> 272
    //   377: astore 7
    //   379: aconst_null
    //   380: astore 4
    //   382: aload 6
    //   384: astore 5
    //   386: aload 7
    //   388: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   391: aload 9
    //   393: astore 8
    //   395: aload 4
    //   397: astore 5
    //   399: iload_3
    //   400: istore_2
    //   401: aload 6
    //   403: ifnull -253 -> 150
    //   406: aload 6
    //   408: invokevirtual 66	java/io/InputStream:close	()V
    //   411: aload 9
    //   413: astore 8
    //   415: aload 4
    //   417: astore 5
    //   419: iload_3
    //   420: istore_2
    //   421: goto -271 -> 150
    //   424: astore 5
    //   426: aload 5
    //   428: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   431: aload 9
    //   433: astore 8
    //   435: aload 4
    //   437: astore 5
    //   439: iload_3
    //   440: istore_2
    //   441: goto -291 -> 150
    //   444: astore 5
    //   446: aload 5
    //   448: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   451: aload 9
    //   453: astore 8
    //   455: aload 4
    //   457: astore 5
    //   459: iload_3
    //   460: istore_2
    //   461: goto -311 -> 150
    //   464: astore 4
    //   466: aconst_null
    //   467: astore 5
    //   469: aload 5
    //   471: ifnull +8 -> 479
    //   474: aload 5
    //   476: invokevirtual 66	java/io/InputStream:close	()V
    //   479: aload 4
    //   481: athrow
    //   482: astore 5
    //   484: aload 5
    //   486: invokevirtual 110	java/io/IOException:printStackTrace	()V
    //   489: goto -10 -> 479
    //   492: astore 4
    //   494: goto -25 -> 469
    //   497: astore 7
    //   499: aconst_null
    //   500: astore 6
    //   502: aconst_null
    //   503: astore 4
    //   505: goto -123 -> 382
    //   508: astore 7
    //   510: goto -128 -> 382
    //   513: astore 7
    //   515: aconst_null
    //   516: astore 6
    //   518: aconst_null
    //   519: astore 4
    //   521: goto -410 -> 111
    //   524: astore 7
    //   526: goto -415 -> 111
    //   529: astore 7
    //   531: goto -283 -> 248
    //   534: aconst_null
    //   535: astore 4
    //   537: goto -249 -> 288
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	6
    //   72	28	1	i	int
    //   129	332	2	bool1	boolean
    //   1	459	3	bool2	boolean
    //   48	408	4	localObject1	Object
    //   464	16	4	localObject2	Object
    //   492	1	4	localObject3	Object
    //   503	33	4	localObject4	Object
    //   30	307	5	localObject5	Object
    //   343	3	5	localIOException1	java.io.IOException
    //   356	62	5	localObject6	Object
    //   424	3	5	localIOException2	java.io.IOException
    //   437	1	5	localObject7	Object
    //   444	3	5	localIOException3	java.io.IOException
    //   457	18	5	localObject8	Object
    //   482	3	5	localIOException4	java.io.IOException
    //   26	491	6	localBufferedInputStream	java.io.BufferedInputStream
    //   106	10	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   243	10	7	localNoSuchAlgorithmException1	java.security.NoSuchAlgorithmException
    //   290	61	7	localObject9	Object
    //   363	7	7	localIOException5	java.io.IOException
    //   377	10	7	localIOException6	java.io.IOException
    //   497	1	7	localIOException7	java.io.IOException
    //   508	1	7	localIOException8	java.io.IOException
    //   513	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   524	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    //   529	1	7	localNoSuchAlgorithmException2	java.security.NoSuchAlgorithmException
    //   59	395	8	localObject10	Object
    //   6	446	9	localObject11	Object
    //   3	286	10	localObject12	Object
    //   37	60	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   32	39	106	java/io/FileNotFoundException
    //   43	50	106	java/io/FileNotFoundException
    //   54	61	106	java/io/FileNotFoundException
    //   65	73	106	java/io/FileNotFoundException
    //   81	90	106	java/io/FileNotFoundException
    //   94	103	106	java/io/FileNotFoundException
    //   252	257	106	java/io/FileNotFoundException
    //   267	272	106	java/io/FileNotFoundException
    //   281	288	106	java/io/FileNotFoundException
    //   369	374	106	java/io/FileNotFoundException
    //   43	50	243	java/security/NoSuchAlgorithmException
    //   325	330	343	java/io/IOException
    //   267	272	363	java/io/IOException
    //   32	39	377	java/io/IOException
    //   43	50	377	java/io/IOException
    //   54	61	377	java/io/IOException
    //   65	73	377	java/io/IOException
    //   81	90	377	java/io/IOException
    //   94	103	377	java/io/IOException
    //   252	257	377	java/io/IOException
    //   281	288	377	java/io/IOException
    //   369	374	377	java/io/IOException
    //   406	411	424	java/io/IOException
    //   135	140	444	java/io/IOException
    //   8	28	464	finally
    //   474	479	482	java/io/IOException
    //   32	39	492	finally
    //   43	50	492	finally
    //   54	61	492	finally
    //   65	73	492	finally
    //   81	90	492	finally
    //   94	103	492	finally
    //   115	120	492	finally
    //   252	257	492	finally
    //   267	272	492	finally
    //   281	288	492	finally
    //   301	308	492	finally
    //   369	374	492	finally
    //   386	391	492	finally
    //   8	28	497	java/io/IOException
    //   301	308	508	java/io/IOException
    //   8	28	513	java/io/FileNotFoundException
    //   301	308	524	java/io/FileNotFoundException
    //   54	61	529	java/security/NoSuchAlgorithmException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.MMApkFileSafeChecker.6
 * JD-Core Version:    0.7.0.1
 */