package com.tencent.qqmini.v8rt.engine;

import java.io.File;

public class AssetUtil
{
  public static final String LOG_TAG = "AssetUtil";
  
  /* Error */
  public static boolean copyAssetToFile(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   16: astore 5
    //   18: aload 5
    //   20: aload_2
    //   21: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 5
    //   27: ldc 26
    //   29: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 5
    //   35: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 8
    //   40: new 32	java/io/FileOutputStream
    //   43: dup
    //   44: aload 8
    //   46: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   49: astore 5
    //   51: aload 7
    //   53: astore 6
    //   55: aload 5
    //   57: astore 7
    //   59: new 37	java/io/BufferedInputStream
    //   62: dup
    //   63: aload_0
    //   64: aload_1
    //   65: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   68: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: astore_0
    //   72: sipush 8192
    //   75: newarray byte
    //   77: astore 6
    //   79: aload_0
    //   80: aload 6
    //   82: invokevirtual 50	java/io/BufferedInputStream:read	([B)I
    //   85: istore_3
    //   86: iload_3
    //   87: iconst_m1
    //   88: if_icmpeq +15 -> 103
    //   91: aload 5
    //   93: aload 6
    //   95: iconst_0
    //   96: iload_3
    //   97: invokevirtual 56	java/io/OutputStream:write	([BII)V
    //   100: goto -21 -> 79
    //   103: new 58	java/io/File
    //   106: dup
    //   107: aload 8
    //   109: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   112: new 58	java/io/File
    //   115: dup
    //   116: aload_2
    //   117: invokespecial 59	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: invokevirtual 63	java/io/File:renameTo	(Ljava/io/File;)Z
    //   123: istore 4
    //   125: aload_0
    //   126: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   129: goto +72 -> 201
    //   132: astore_0
    //   133: new 19	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   140: astore 6
    //   142: aload 6
    //   144: ldc 68
    //   146: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 6
    //   152: aload_1
    //   153: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 6
    //   159: ldc 70
    //   161: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 6
    //   167: aload_2
    //   168: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: ldc 72
    //   176: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 6
    //   182: aload_0
    //   183: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   186: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: ldc 8
    //   192: aload 6
    //   194: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   200: pop
    //   201: aload 5
    //   203: checkcast 32	java/io/FileOutputStream
    //   206: invokevirtual 85	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   209: invokevirtual 90	java/io/FileDescriptor:sync	()V
    //   212: aload 5
    //   214: invokevirtual 91	java/io/OutputStream:close	()V
    //   217: iload 4
    //   219: ireturn
    //   220: astore_0
    //   221: new 19	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   228: astore 5
    //   230: aload 5
    //   232: ldc 68
    //   234: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 5
    //   240: aload_1
    //   241: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: aload 5
    //   247: ldc 70
    //   249: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 5
    //   255: aload_2
    //   256: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 5
    //   262: ldc 72
    //   264: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 5
    //   270: aload_0
    //   271: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   274: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: ldc 8
    //   280: aload 5
    //   282: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   288: pop
    //   289: iload 4
    //   291: ireturn
    //   292: astore_0
    //   293: goto +93 -> 386
    //   296: astore_0
    //   297: new 19	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   304: astore 6
    //   306: aload 6
    //   308: ldc 68
    //   310: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 6
    //   316: aload_1
    //   317: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload 6
    //   323: ldc 70
    //   325: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 6
    //   331: aload_2
    //   332: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 6
    //   338: ldc 72
    //   340: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 6
    //   346: aload_0
    //   347: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   350: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: ldc 8
    //   356: aload 6
    //   358: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   364: pop
    //   365: aload 5
    //   367: invokevirtual 91	java/io/OutputStream:close	()V
    //   370: iload 4
    //   372: ireturn
    //   373: astore_0
    //   374: new 19	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   381: astore 5
    //   383: goto -153 -> 230
    //   386: aload 5
    //   388: invokevirtual 91	java/io/OutputStream:close	()V
    //   391: goto +74 -> 465
    //   394: astore 5
    //   396: new 19	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   403: astore 6
    //   405: aload 6
    //   407: ldc 68
    //   409: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 6
    //   415: aload_1
    //   416: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 6
    //   422: ldc 70
    //   424: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload 6
    //   430: aload_2
    //   431: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: aload 6
    //   437: ldc 72
    //   439: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload 6
    //   445: aload 5
    //   447: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   450: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: pop
    //   454: ldc 8
    //   456: aload 6
    //   458: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   464: pop
    //   465: aload_0
    //   466: athrow
    //   467: astore 7
    //   469: aload_0
    //   470: astore 6
    //   472: aload 7
    //   474: astore_0
    //   475: goto +474 -> 949
    //   478: astore 8
    //   480: goto +26 -> 506
    //   483: astore 8
    //   485: aload 9
    //   487: astore_0
    //   488: goto +18 -> 506
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 5
    //   495: goto +454 -> 949
    //   498: astore 8
    //   500: aconst_null
    //   501: astore 5
    //   503: aload 9
    //   505: astore_0
    //   506: aload_0
    //   507: astore 6
    //   509: aload 5
    //   511: astore 7
    //   513: new 19	java/lang/StringBuilder
    //   516: dup
    //   517: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   520: astore 9
    //   522: aload_0
    //   523: astore 6
    //   525: aload 5
    //   527: astore 7
    //   529: aload 9
    //   531: ldc 68
    //   533: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_0
    //   538: astore 6
    //   540: aload 5
    //   542: astore 7
    //   544: aload 9
    //   546: aload_1
    //   547: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_0
    //   552: astore 6
    //   554: aload 5
    //   556: astore 7
    //   558: aload 9
    //   560: ldc 70
    //   562: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: aload_0
    //   567: astore 6
    //   569: aload 5
    //   571: astore 7
    //   573: aload 9
    //   575: aload_2
    //   576: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: pop
    //   580: aload_0
    //   581: astore 6
    //   583: aload 5
    //   585: astore 7
    //   587: ldc 8
    //   589: aload 9
    //   591: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: aload 8
    //   596: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   599: pop
    //   600: aload_0
    //   601: ifnull +79 -> 680
    //   604: aload_0
    //   605: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   608: goto +72 -> 680
    //   611: astore_0
    //   612: new 19	java/lang/StringBuilder
    //   615: dup
    //   616: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   619: astore 6
    //   621: aload 6
    //   623: ldc 68
    //   625: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload 6
    //   631: aload_1
    //   632: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload 6
    //   638: ldc 70
    //   640: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 6
    //   646: aload_2
    //   647: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   650: pop
    //   651: aload 6
    //   653: ldc 72
    //   655: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: pop
    //   659: aload 6
    //   661: aload_0
    //   662: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   665: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: ldc 8
    //   671: aload 6
    //   673: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   679: pop
    //   680: aload 5
    //   682: ifnull +260 -> 942
    //   685: aload 5
    //   687: checkcast 32	java/io/FileOutputStream
    //   690: invokevirtual 85	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   693: invokevirtual 90	java/io/FileDescriptor:sync	()V
    //   696: aload 5
    //   698: invokevirtual 91	java/io/OutputStream:close	()V
    //   701: iconst_0
    //   702: ireturn
    //   703: astore 5
    //   705: new 19	java/lang/StringBuilder
    //   708: dup
    //   709: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   712: astore_0
    //   713: aload_0
    //   714: ldc 68
    //   716: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload_0
    //   721: aload_1
    //   722: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: pop
    //   726: aload_0
    //   727: ldc 70
    //   729: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload_0
    //   734: aload_2
    //   735: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload_0
    //   740: ldc 72
    //   742: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_0
    //   747: aload 5
    //   749: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   752: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: ldc 8
    //   758: aload_0
    //   759: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   765: pop
    //   766: iconst_0
    //   767: ireturn
    //   768: astore_0
    //   769: goto +92 -> 861
    //   772: astore_0
    //   773: new 19	java/lang/StringBuilder
    //   776: dup
    //   777: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   780: astore 6
    //   782: aload 6
    //   784: ldc 68
    //   786: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 6
    //   792: aload_1
    //   793: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: pop
    //   797: aload 6
    //   799: ldc 70
    //   801: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload 6
    //   807: aload_2
    //   808: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: pop
    //   812: aload 6
    //   814: ldc 72
    //   816: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 6
    //   822: aload_0
    //   823: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   826: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: ldc 8
    //   832: aload 6
    //   834: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   840: pop
    //   841: aload 5
    //   843: invokevirtual 91	java/io/OutputStream:close	()V
    //   846: iconst_0
    //   847: ireturn
    //   848: astore 5
    //   850: new 19	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   857: astore_0
    //   858: goto -145 -> 713
    //   861: aload 5
    //   863: invokevirtual 91	java/io/OutputStream:close	()V
    //   866: goto +74 -> 940
    //   869: astore 5
    //   871: new 19	java/lang/StringBuilder
    //   874: dup
    //   875: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   878: astore 6
    //   880: aload 6
    //   882: ldc 68
    //   884: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload 6
    //   890: aload_1
    //   891: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   894: pop
    //   895: aload 6
    //   897: ldc 70
    //   899: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: pop
    //   903: aload 6
    //   905: aload_2
    //   906: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: pop
    //   910: aload 6
    //   912: ldc 72
    //   914: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: pop
    //   918: aload 6
    //   920: aload 5
    //   922: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   925: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: ldc 8
    //   931: aload 6
    //   933: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   939: pop
    //   940: aload_0
    //   941: athrow
    //   942: iconst_0
    //   943: ireturn
    //   944: astore_0
    //   945: aload 7
    //   947: astore 5
    //   949: aload 6
    //   951: ifnull +82 -> 1033
    //   954: aload 6
    //   956: invokevirtual 66	java/io/BufferedInputStream:close	()V
    //   959: goto +74 -> 1033
    //   962: astore 6
    //   964: new 19	java/lang/StringBuilder
    //   967: dup
    //   968: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   971: astore 7
    //   973: aload 7
    //   975: ldc 68
    //   977: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   980: pop
    //   981: aload 7
    //   983: aload_1
    //   984: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 7
    //   990: ldc 70
    //   992: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: pop
    //   996: aload 7
    //   998: aload_2
    //   999: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: pop
    //   1003: aload 7
    //   1005: ldc 72
    //   1007: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1010: pop
    //   1011: aload 7
    //   1013: aload 6
    //   1015: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1018: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1021: pop
    //   1022: ldc 8
    //   1024: aload 7
    //   1026: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1029: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1032: pop
    //   1033: aload 5
    //   1035: ifnull +274 -> 1309
    //   1038: aload 5
    //   1040: checkcast 32	java/io/FileOutputStream
    //   1043: invokevirtual 85	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   1046: invokevirtual 90	java/io/FileDescriptor:sync	()V
    //   1049: aload 5
    //   1051: invokevirtual 91	java/io/OutputStream:close	()V
    //   1054: goto +255 -> 1309
    //   1057: astore 5
    //   1059: new 19	java/lang/StringBuilder
    //   1062: dup
    //   1063: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1066: astore 6
    //   1068: aload 6
    //   1070: ldc 68
    //   1072: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1075: pop
    //   1076: aload 6
    //   1078: aload_1
    //   1079: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: pop
    //   1083: aload 6
    //   1085: ldc 70
    //   1087: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1090: pop
    //   1091: aload 6
    //   1093: aload_2
    //   1094: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: pop
    //   1098: aload 6
    //   1100: ldc 72
    //   1102: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1105: pop
    //   1106: aload 6
    //   1108: aload 5
    //   1110: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1113: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: pop
    //   1117: ldc 8
    //   1119: aload 6
    //   1121: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1127: pop
    //   1128: goto +181 -> 1309
    //   1131: astore_0
    //   1132: goto +96 -> 1228
    //   1135: astore 6
    //   1137: new 19	java/lang/StringBuilder
    //   1140: dup
    //   1141: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1144: astore 7
    //   1146: aload 7
    //   1148: ldc 68
    //   1150: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: pop
    //   1154: aload 7
    //   1156: aload_1
    //   1157: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload 7
    //   1163: ldc 70
    //   1165: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: pop
    //   1169: aload 7
    //   1171: aload_2
    //   1172: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: pop
    //   1176: aload 7
    //   1178: ldc 72
    //   1180: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: pop
    //   1184: aload 7
    //   1186: aload 6
    //   1188: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1191: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: pop
    //   1195: ldc 8
    //   1197: aload 7
    //   1199: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1202: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1205: pop
    //   1206: aload 5
    //   1208: invokevirtual 91	java/io/OutputStream:close	()V
    //   1211: goto +98 -> 1309
    //   1214: astore 5
    //   1216: new 19	java/lang/StringBuilder
    //   1219: dup
    //   1220: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1223: astore 6
    //   1225: goto -157 -> 1068
    //   1228: aload 5
    //   1230: invokevirtual 91	java/io/OutputStream:close	()V
    //   1233: goto +74 -> 1307
    //   1236: astore 5
    //   1238: new 19	java/lang/StringBuilder
    //   1241: dup
    //   1242: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1245: astore 6
    //   1247: aload 6
    //   1249: ldc 68
    //   1251: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1254: pop
    //   1255: aload 6
    //   1257: aload_1
    //   1258: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1261: pop
    //   1262: aload 6
    //   1264: ldc 70
    //   1266: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: pop
    //   1270: aload 6
    //   1272: aload_2
    //   1273: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: aload 6
    //   1279: ldc 72
    //   1281: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: pop
    //   1285: aload 6
    //   1287: aload 5
    //   1289: invokevirtual 75	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1292: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: pop
    //   1296: ldc 8
    //   1298: aload 6
    //   1300: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1303: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1306: pop
    //   1307: aload_0
    //   1308: athrow
    //   1309: goto +5 -> 1314
    //   1312: aload_0
    //   1313: athrow
    //   1314: goto -2 -> 1312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1317	0	paramAssetManager	android.content.res.AssetManager
    //   0	1317	1	paramString1	String
    //   0	1317	2	paramString2	String
    //   85	12	3	i	int
    //   123	248	4	bool	boolean
    //   16	371	5	localObject1	Object
    //   394	52	5	localIOException1	java.io.IOException
    //   493	204	5	localObject2	Object
    //   703	139	5	localIOException2	java.io.IOException
    //   848	14	5	localIOException3	java.io.IOException
    //   869	52	5	localIOException4	java.io.IOException
    //   947	103	5	localObject3	Object
    //   1057	150	5	localIOException5	java.io.IOException
    //   1214	15	5	localIOException6	java.io.IOException
    //   1236	52	5	localIOException7	java.io.IOException
    //   4	951	6	localObject4	Object
    //   962	52	6	localIOException8	java.io.IOException
    //   1066	54	6	localStringBuilder1	StringBuilder
    //   1135	52	6	localIOException9	java.io.IOException
    //   1223	76	6	localStringBuilder2	StringBuilder
    //   1	57	7	localObject5	Object
    //   467	6	7	localObject6	Object
    //   511	687	7	localObject7	Object
    //   38	70	8	str	String
    //   478	1	8	localIOException10	java.io.IOException
    //   483	1	8	localIOException11	java.io.IOException
    //   498	97	8	localIOException12	java.io.IOException
    //   7	583	9	localStringBuilder3	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   125	129	132	java/io/IOException
    //   212	217	220	java/io/IOException
    //   201	212	292	finally
    //   297	365	292	finally
    //   201	212	296	java/io/IOException
    //   365	370	373	java/io/IOException
    //   386	391	394	java/io/IOException
    //   72	79	467	finally
    //   79	86	467	finally
    //   91	100	467	finally
    //   103	125	467	finally
    //   72	79	478	java/io/IOException
    //   79	86	478	java/io/IOException
    //   91	100	478	java/io/IOException
    //   103	125	478	java/io/IOException
    //   59	72	483	java/io/IOException
    //   9	51	491	finally
    //   9	51	498	java/io/IOException
    //   604	608	611	java/io/IOException
    //   696	701	703	java/io/IOException
    //   685	696	768	finally
    //   773	841	768	finally
    //   685	696	772	java/io/IOException
    //   841	846	848	java/io/IOException
    //   861	866	869	java/io/IOException
    //   59	72	944	finally
    //   513	522	944	finally
    //   529	537	944	finally
    //   544	551	944	finally
    //   558	566	944	finally
    //   573	580	944	finally
    //   587	600	944	finally
    //   954	959	962	java/io/IOException
    //   1049	1054	1057	java/io/IOException
    //   1038	1049	1131	finally
    //   1137	1206	1131	finally
    //   1038	1049	1135	java/io/IOException
    //   1206	1211	1214	java/io/IOException
    //   1228	1233	1236	java/io/IOException
  }
  
  /* Error */
  public static String loadFileAsString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: invokevirtual 102	java/io/File:exists	()Z
    //   13: ifeq +286 -> 299
    //   16: aload_0
    //   17: invokevirtual 105	java/io/File:isDirectory	()Z
    //   20: ifeq +43 -> 63
    //   23: new 19	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 107
    //   34: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_2
    //   39: aload_0
    //   40: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload_2
    //   45: ldc 112
    //   47: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: ldc 8
    //   53: aload_2
    //   54: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   60: pop
    //   61: aconst_null
    //   62: areturn
    //   63: aload_0
    //   64: invokevirtual 115	java/io/File:canRead	()Z
    //   67: ifne +43 -> 110
    //   70: new 19	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   77: astore_2
    //   78: aload_2
    //   79: ldc 107
    //   81: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: aload_0
    //   87: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_2
    //   92: ldc 117
    //   94: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: pop
    //   98: ldc 8
    //   100: aload_2
    //   101: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   107: pop
    //   108: aconst_null
    //   109: areturn
    //   110: new 119	java/io/FileInputStream
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 122	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: astore_3
    //   119: new 124	java/io/InputStreamReader
    //   122: dup
    //   123: aload_3
    //   124: ldc 126
    //   126: invokespecial 129	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   129: astore_2
    //   130: aload_0
    //   131: invokevirtual 133	java/io/File:length	()J
    //   134: l2i
    //   135: istore_1
    //   136: iload_1
    //   137: sipush 12288
    //   140: if_icmple +53 -> 193
    //   143: sipush 4096
    //   146: newarray char
    //   148: astore_0
    //   149: new 19	java/lang/StringBuilder
    //   152: dup
    //   153: sipush 12288
    //   156: invokespecial 136	java/lang/StringBuilder:<init>	(I)V
    //   159: astore 5
    //   161: aload_2
    //   162: aload_0
    //   163: invokevirtual 139	java/io/InputStreamReader:read	([C)I
    //   166: istore_1
    //   167: iconst_m1
    //   168: iload_1
    //   169: if_icmpeq +15 -> 184
    //   172: aload 5
    //   174: aload_0
    //   175: iconst_0
    //   176: iload_1
    //   177: invokevirtual 142	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: goto -20 -> 161
    //   184: aload 5
    //   186: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_0
    //   190: goto +22 -> 212
    //   193: iload_1
    //   194: newarray char
    //   196: astore_0
    //   197: new 144	java/lang/String
    //   200: dup
    //   201: aload_0
    //   202: iconst_0
    //   203: aload_2
    //   204: aload_0
    //   205: invokevirtual 139	java/io/InputStreamReader:read	([C)I
    //   208: invokespecial 147	java/lang/String:<init>	([CII)V
    //   211: astore_0
    //   212: aload_3
    //   213: invokevirtual 150	java/io/InputStream:close	()V
    //   216: aload_0
    //   217: astore_3
    //   218: aload_2
    //   219: invokevirtual 151	java/io/InputStreamReader:close	()V
    //   222: aload_3
    //   223: areturn
    //   224: astore_0
    //   225: goto +24 -> 249
    //   228: aload_2
    //   229: astore_0
    //   230: goto +44 -> 274
    //   233: astore_0
    //   234: aconst_null
    //   235: astore_2
    //   236: goto +13 -> 249
    //   239: aconst_null
    //   240: astore_0
    //   241: goto +33 -> 274
    //   244: astore_0
    //   245: aconst_null
    //   246: astore_3
    //   247: aload_3
    //   248: astore_2
    //   249: aload_3
    //   250: ifnull +10 -> 260
    //   253: aload_3
    //   254: invokevirtual 150	java/io/InputStream:close	()V
    //   257: goto +3 -> 260
    //   260: aload_2
    //   261: ifnull +7 -> 268
    //   264: aload_2
    //   265: invokevirtual 151	java/io/InputStreamReader:close	()V
    //   268: aload_0
    //   269: athrow
    //   270: aconst_null
    //   271: astore_3
    //   272: aload_3
    //   273: astore_0
    //   274: aload_3
    //   275: ifnull +10 -> 285
    //   278: aload_3
    //   279: invokevirtual 150	java/io/InputStream:close	()V
    //   282: goto +3 -> 285
    //   285: aload_0
    //   286: ifnull +11 -> 297
    //   289: aload 4
    //   291: astore_3
    //   292: aload_0
    //   293: astore_2
    //   294: goto -76 -> 218
    //   297: aconst_null
    //   298: areturn
    //   299: new 19	java/lang/StringBuilder
    //   302: dup
    //   303: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   306: astore_2
    //   307: aload_2
    //   308: ldc 107
    //   310: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_2
    //   315: aload_0
    //   316: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: ldc 153
    //   323: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: ldc 8
    //   329: aload_2
    //   330: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokestatic 81	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   336: pop
    //   337: aconst_null
    //   338: areturn
    //   339: astore_0
    //   340: goto -70 -> 270
    //   343: astore_0
    //   344: goto -105 -> 239
    //   347: astore_0
    //   348: goto -120 -> 228
    //   351: astore_3
    //   352: aload_0
    //   353: astore_3
    //   354: goto -136 -> 218
    //   357: astore_0
    //   358: aload_3
    //   359: areturn
    //   360: astore_3
    //   361: goto -101 -> 260
    //   364: astore_2
    //   365: goto -97 -> 268
    //   368: astore_2
    //   369: goto -84 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	372	0	paramFile	File
    //   135	59	1	i	int
    //   30	300	2	localObject1	Object
    //   364	1	2	localException1	java.lang.Exception
    //   368	1	2	localException2	java.lang.Exception
    //   118	174	3	localObject2	Object
    //   351	1	3	localException3	java.lang.Exception
    //   353	6	3	localFile	File
    //   360	1	3	localException4	java.lang.Exception
    //   1	289	4	localObject3	Object
    //   159	26	5	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   130	136	224	finally
    //   143	161	224	finally
    //   161	167	224	finally
    //   172	181	224	finally
    //   184	190	224	finally
    //   193	212	224	finally
    //   119	130	233	finally
    //   110	119	244	finally
    //   110	119	339	java/lang/Exception
    //   119	130	343	java/lang/Exception
    //   130	136	347	java/lang/Exception
    //   143	161	347	java/lang/Exception
    //   161	167	347	java/lang/Exception
    //   172	181	347	java/lang/Exception
    //   184	190	347	java/lang/Exception
    //   193	212	347	java/lang/Exception
    //   212	216	351	java/lang/Exception
    //   218	222	357	java/lang/Exception
    //   253	257	360	java/lang/Exception
    //   264	268	364	java/lang/Exception
    //   278	282	368	java/lang/Exception
  }
  
  public static String loadFileAsString(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
      return loadFileAsString((File)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("can not open file ");
    ((StringBuilder)localObject).append(paramString);
    Logger.e("AssetUtil", ((StringBuilder)localObject).toString());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.AssetUtil
 * JD-Core Version:    0.7.0.1
 */