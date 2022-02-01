package org.xwalk.core;

public class XWalkUpdater$PatchFileConfigParser
{
  private static final String ADD_FLAG = "ADD:";
  private static final int ADD_TYPE = 1;
  private static final int APK_FILE_TYPE = 1;
  private static final String DEL_FLAG = "DEL:";
  private static final int DEL_TYPE = 3;
  private static final int EXTRACTED_FILE_TYPE = 2;
  private static final String MOD_FLAG = "MOD:";
  private static final int MOD_TYPE = 2;
  private static final String PATCH_SUFFIX = ".patch";
  
  /* Error */
  public static java.util.ArrayList<XWalkUpdater.PatchFileConfig> getPatchFileConfigList(int paramInt)
  {
    // Byte code:
    //   0: new 37	java/io/FileInputStream
    //   3: dup
    //   4: new 39	java/io/File
    //   7: dup
    //   8: iload_0
    //   9: invokestatic 45	org/xwalk/core/XWalkEnvironment:getPatchConfig	(I)Ljava/lang/String;
    //   12: invokespecial 48	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokespecial 51	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   18: astore 4
    //   20: new 53	java/io/InputStreamReader
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 56	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: astore 8
    //   31: new 58	java/io/BufferedReader
    //   34: dup
    //   35: aload 8
    //   37: invokespecial 61	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore 10
    //   42: aload 8
    //   44: astore 6
    //   46: aload 10
    //   48: astore 7
    //   50: aload 4
    //   52: astore 9
    //   54: new 63	java/util/ArrayList
    //   57: dup
    //   58: invokespecial 64	java/util/ArrayList:<init>	()V
    //   61: astore 11
    //   63: aload 8
    //   65: astore 6
    //   67: aload 10
    //   69: astore 7
    //   71: aload 4
    //   73: astore 9
    //   75: aload 10
    //   77: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore 5
    //   82: aload 5
    //   84: ifnull +583 -> 667
    //   87: aload 5
    //   89: ifnull -26 -> 63
    //   92: aload 8
    //   94: astore 6
    //   96: aload 10
    //   98: astore 7
    //   100: aload 4
    //   102: astore 9
    //   104: aload 5
    //   106: invokevirtual 74	java/lang/String:isEmpty	()Z
    //   109: ifeq +6 -> 115
    //   112: goto -49 -> 63
    //   115: aload 8
    //   117: astore 6
    //   119: aload 10
    //   121: astore 7
    //   123: aload 4
    //   125: astore 9
    //   127: aload 5
    //   129: ldc 8
    //   131: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   134: istore_3
    //   135: iconst_0
    //   136: istore_1
    //   137: iload_3
    //   138: ifeq +28 -> 166
    //   141: aload 8
    //   143: astore 6
    //   145: aload 10
    //   147: astore 7
    //   149: aload 4
    //   151: astore 9
    //   153: aload 5
    //   155: iconst_4
    //   156: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   159: astore 5
    //   161: iconst_1
    //   162: istore_0
    //   163: goto +97 -> 260
    //   166: aload 8
    //   168: astore 6
    //   170: aload 10
    //   172: astore 7
    //   174: aload 4
    //   176: astore 9
    //   178: aload 5
    //   180: ldc 22
    //   182: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   185: ifeq +28 -> 213
    //   188: aload 8
    //   190: astore 6
    //   192: aload 10
    //   194: astore 7
    //   196: aload 4
    //   198: astore 9
    //   200: aload 5
    //   202: iconst_4
    //   203: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   206: astore 5
    //   208: iconst_2
    //   209: istore_0
    //   210: goto +50 -> 260
    //   213: aload 8
    //   215: astore 6
    //   217: aload 10
    //   219: astore 7
    //   221: aload 4
    //   223: astore 9
    //   225: aload 5
    //   227: ldc 15
    //   229: invokevirtual 78	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   232: ifeq +654 -> 886
    //   235: aload 8
    //   237: astore 6
    //   239: aload 10
    //   241: astore 7
    //   243: aload 4
    //   245: astore 9
    //   247: aload 5
    //   249: iconst_4
    //   250: invokevirtual 81	java/lang/String:substring	(I)Ljava/lang/String;
    //   253: astore 5
    //   255: iconst_3
    //   256: istore_0
    //   257: goto +3 -> 260
    //   260: aload 8
    //   262: astore 6
    //   264: aload 10
    //   266: astore 7
    //   268: aload 4
    //   270: astore 9
    //   272: aload 5
    //   274: ldc 83
    //   276: invokevirtual 87	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   279: astore 5
    //   281: aload 8
    //   283: astore 6
    //   285: aload 10
    //   287: astore 7
    //   289: aload 4
    //   291: astore 9
    //   293: aload 5
    //   295: arraylength
    //   296: istore_2
    //   297: iload_1
    //   298: iload_2
    //   299: if_icmpge -236 -> 63
    //   302: aload 5
    //   304: iload_1
    //   305: aaload
    //   306: astore 13
    //   308: aload 13
    //   310: ifnull +350 -> 660
    //   313: aload 8
    //   315: astore 6
    //   317: aload 10
    //   319: astore 7
    //   321: aload 4
    //   323: astore 9
    //   325: aload 13
    //   327: invokevirtual 74	java/lang/String:isEmpty	()Z
    //   330: ifeq +6 -> 336
    //   333: goto +327 -> 660
    //   336: aload 8
    //   338: astore 6
    //   340: aload 10
    //   342: astore 7
    //   344: aload 4
    //   346: astore 9
    //   348: new 89	org/xwalk/core/XWalkUpdater$PatchFileConfig
    //   351: dup
    //   352: invokespecial 90	org/xwalk/core/XWalkUpdater$PatchFileConfig:<init>	()V
    //   355: astore 12
    //   357: aload 8
    //   359: astore 6
    //   361: aload 10
    //   363: astore 7
    //   365: aload 4
    //   367: astore 9
    //   369: aload 12
    //   371: aload 13
    //   373: putfield 93	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   376: aload 8
    //   378: astore 6
    //   380: aload 10
    //   382: astore 7
    //   384: aload 4
    //   386: astore 9
    //   388: aload 12
    //   390: iload_0
    //   391: putfield 96	org/xwalk/core/XWalkUpdater$PatchFileConfig:type	I
    //   394: iload_0
    //   395: iconst_2
    //   396: if_icmpne +89 -> 485
    //   399: aload 8
    //   401: astore 6
    //   403: aload 10
    //   405: astore 7
    //   407: aload 4
    //   409: astore 9
    //   411: new 98	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   418: astore 13
    //   420: aload 8
    //   422: astore 6
    //   424: aload 10
    //   426: astore 7
    //   428: aload 4
    //   430: astore 9
    //   432: aload 13
    //   434: aload 12
    //   436: getfield 93	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   439: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 8
    //   445: astore 6
    //   447: aload 10
    //   449: astore 7
    //   451: aload 4
    //   453: astore 9
    //   455: aload 13
    //   457: ldc 26
    //   459: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 8
    //   465: astore 6
    //   467: aload 10
    //   469: astore 7
    //   471: aload 4
    //   473: astore 9
    //   475: aload 12
    //   477: aload 13
    //   479: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: putfield 109	org/xwalk/core/XWalkUpdater$PatchFileConfig:patchFileName	Ljava/lang/String;
    //   485: iload_0
    //   486: iconst_2
    //   487: if_icmpne +49 -> 536
    //   490: aload 8
    //   492: astore 6
    //   494: aload 10
    //   496: astore 7
    //   498: aload 4
    //   500: astore 9
    //   502: aload 12
    //   504: getfield 93	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileName	Ljava/lang/String;
    //   507: ldc 111
    //   509: invokevirtual 115	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: ifeq +24 -> 536
    //   515: aload 8
    //   517: astore 6
    //   519: aload 10
    //   521: astore 7
    //   523: aload 4
    //   525: astore 9
    //   527: aload 12
    //   529: iconst_1
    //   530: putfield 118	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
    //   533: goto +21 -> 554
    //   536: aload 8
    //   538: astore 6
    //   540: aload 10
    //   542: astore 7
    //   544: aload 4
    //   546: astore 9
    //   548: aload 12
    //   550: iconst_2
    //   551: putfield 118	org/xwalk/core/XWalkUpdater$PatchFileConfig:originalFileType	I
    //   554: aload 8
    //   556: astore 6
    //   558: aload 10
    //   560: astore 7
    //   562: aload 4
    //   564: astore 9
    //   566: new 98	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   573: astore 13
    //   575: aload 8
    //   577: astore 6
    //   579: aload 10
    //   581: astore 7
    //   583: aload 4
    //   585: astore 9
    //   587: aload 13
    //   589: ldc 120
    //   591: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload 8
    //   597: astore 6
    //   599: aload 10
    //   601: astore 7
    //   603: aload 4
    //   605: astore 9
    //   607: aload 13
    //   609: aload 12
    //   611: invokevirtual 121	org/xwalk/core/XWalkUpdater$PatchFileConfig:toString	()Ljava/lang/String;
    //   614: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 8
    //   620: astore 6
    //   622: aload 10
    //   624: astore 7
    //   626: aload 4
    //   628: astore 9
    //   630: ldc 123
    //   632: aload 13
    //   634: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 129	org/xwalk/core/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   640: aload 8
    //   642: astore 6
    //   644: aload 10
    //   646: astore 7
    //   648: aload 4
    //   650: astore 9
    //   652: aload 11
    //   654: aload 12
    //   656: invokevirtual 132	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   659: pop
    //   660: iload_1
    //   661: iconst_1
    //   662: iadd
    //   663: istore_1
    //   664: goto -367 -> 297
    //   667: aload 4
    //   669: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   672: aload 8
    //   674: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   677: aload 10
    //   679: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   682: aload 11
    //   684: areturn
    //   685: astore 6
    //   687: aload 10
    //   689: astore 5
    //   691: aload 6
    //   693: astore 10
    //   695: goto +58 -> 753
    //   698: astore 5
    //   700: aconst_null
    //   701: astore 7
    //   703: aload 8
    //   705: astore 6
    //   707: goto +155 -> 862
    //   710: astore 10
    //   712: aconst_null
    //   713: astore 5
    //   715: goto +38 -> 753
    //   718: astore 5
    //   720: goto +13 -> 733
    //   723: astore 10
    //   725: goto +22 -> 747
    //   728: astore 5
    //   730: aconst_null
    //   731: astore 4
    //   733: aconst_null
    //   734: astore 6
    //   736: aconst_null
    //   737: astore 7
    //   739: goto +123 -> 862
    //   742: astore 10
    //   744: aconst_null
    //   745: astore 4
    //   747: aconst_null
    //   748: astore 8
    //   750: aconst_null
    //   751: astore 5
    //   753: aload 8
    //   755: astore 6
    //   757: aload 5
    //   759: astore 7
    //   761: aload 4
    //   763: astore 9
    //   765: new 98	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   772: astore 11
    //   774: aload 8
    //   776: astore 6
    //   778: aload 5
    //   780: astore 7
    //   782: aload 4
    //   784: astore 9
    //   786: aload 11
    //   788: ldc 140
    //   790: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: pop
    //   794: aload 8
    //   796: astore 6
    //   798: aload 5
    //   800: astore 7
    //   802: aload 4
    //   804: astore 9
    //   806: aload 11
    //   808: aload 10
    //   810: invokevirtual 143	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   813: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload 8
    //   819: astore 6
    //   821: aload 5
    //   823: astore 7
    //   825: aload 4
    //   827: astore 9
    //   829: ldc 123
    //   831: aload 11
    //   833: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   836: invokestatic 146	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   839: aload 4
    //   841: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   844: aload 8
    //   846: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   849: aload 5
    //   851: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   854: aconst_null
    //   855: areturn
    //   856: astore 5
    //   858: aload 9
    //   860: astore 4
    //   862: aload 4
    //   864: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   867: aload 6
    //   869: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   872: aload 7
    //   874: invokestatic 138	com/tencent/xweb/util/c:a	(Ljava/io/Closeable;)V
    //   877: goto +6 -> 883
    //   880: aload 5
    //   882: athrow
    //   883: goto -3 -> 880
    //   886: iconst_0
    //   887: istore_0
    //   888: goto -628 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	paramInt	int
    //   136	528	1	i	int
    //   296	4	2	j	int
    //   134	4	3	bool	boolean
    //   18	845	4	localObject1	Object
    //   80	610	5	localObject2	Object
    //   698	1	5	localObject3	Object
    //   713	1	5	localObject4	Object
    //   718	1	5	localObject5	Object
    //   728	1	5	localObject6	Object
    //   751	99	5	localCloseable	java.io.Closeable
    //   856	25	5	localObject7	Object
    //   44	599	6	localInputStreamReader1	java.io.InputStreamReader
    //   685	7	6	localException1	java.lang.Exception
    //   705	163	6	localInputStreamReader2	java.io.InputStreamReader
    //   48	825	7	localObject8	Object
    //   29	816	8	localInputStreamReader3	java.io.InputStreamReader
    //   52	807	9	localObject9	Object
    //   40	654	10	localObject10	Object
    //   710	1	10	localException2	java.lang.Exception
    //   723	1	10	localException3	java.lang.Exception
    //   742	67	10	localException4	java.lang.Exception
    //   61	771	11	localObject11	Object
    //   355	300	12	localPatchFileConfig	XWalkUpdater.PatchFileConfig
    //   306	327	13	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   54	63	685	java/lang/Exception
    //   75	82	685	java/lang/Exception
    //   104	112	685	java/lang/Exception
    //   127	135	685	java/lang/Exception
    //   153	161	685	java/lang/Exception
    //   178	188	685	java/lang/Exception
    //   200	208	685	java/lang/Exception
    //   225	235	685	java/lang/Exception
    //   247	255	685	java/lang/Exception
    //   272	281	685	java/lang/Exception
    //   293	297	685	java/lang/Exception
    //   325	333	685	java/lang/Exception
    //   348	357	685	java/lang/Exception
    //   369	376	685	java/lang/Exception
    //   388	394	685	java/lang/Exception
    //   411	420	685	java/lang/Exception
    //   432	443	685	java/lang/Exception
    //   455	463	685	java/lang/Exception
    //   475	485	685	java/lang/Exception
    //   502	515	685	java/lang/Exception
    //   527	533	685	java/lang/Exception
    //   548	554	685	java/lang/Exception
    //   566	575	685	java/lang/Exception
    //   587	595	685	java/lang/Exception
    //   607	618	685	java/lang/Exception
    //   630	640	685	java/lang/Exception
    //   652	660	685	java/lang/Exception
    //   31	42	698	finally
    //   31	42	710	java/lang/Exception
    //   20	31	718	finally
    //   20	31	723	java/lang/Exception
    //   0	20	728	finally
    //   0	20	742	java/lang/Exception
    //   54	63	856	finally
    //   75	82	856	finally
    //   104	112	856	finally
    //   127	135	856	finally
    //   153	161	856	finally
    //   178	188	856	finally
    //   200	208	856	finally
    //   225	235	856	finally
    //   247	255	856	finally
    //   272	281	856	finally
    //   293	297	856	finally
    //   325	333	856	finally
    //   348	357	856	finally
    //   369	376	856	finally
    //   388	394	856	finally
    //   411	420	856	finally
    //   432	443	856	finally
    //   455	463	856	finally
    //   475	485	856	finally
    //   502	515	856	finally
    //   527	533	856	finally
    //   548	554	856	finally
    //   566	575	856	finally
    //   587	595	856	finally
    //   607	618	856	finally
    //   630	640	856	finally
    //   652	660	856	finally
    //   765	774	856	finally
    //   786	794	856	finally
    //   806	817	856	finally
    //   829	839	856	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkUpdater.PatchFileConfigParser
 * JD-Core Version:    0.7.0.1
 */