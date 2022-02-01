package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class AssetsUtil
{
  public static final String TAG = "[minigame] AssetsUtil";
  
  /* Error */
  private static boolean copyAssetToFile(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: new 19	java/io/FileOutputStream
    //   9: dup
    //   10: aload_2
    //   11: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   14: astore 4
    //   16: aload 4
    //   18: invokevirtual 26	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   21: invokevirtual 32	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   24: astore 5
    //   26: aload 4
    //   28: astore 7
    //   30: aload 5
    //   32: astore 6
    //   34: new 34	java/io/BufferedInputStream
    //   37: dup
    //   38: aload_0
    //   39: aload_1
    //   40: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   43: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   46: astore 8
    //   48: sipush 8192
    //   51: newarray byte
    //   53: astore_0
    //   54: aload 8
    //   56: aload_0
    //   57: invokevirtual 47	java/io/BufferedInputStream:read	([B)I
    //   60: istore_3
    //   61: iload_3
    //   62: iconst_m1
    //   63: if_icmpeq +14 -> 77
    //   66: aload 4
    //   68: aload_0
    //   69: iconst_0
    //   70: iload_3
    //   71: invokevirtual 51	java/io/FileOutputStream:write	([BII)V
    //   74: goto -20 -> 54
    //   77: aload 8
    //   79: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   82: goto +36 -> 118
    //   85: astore_0
    //   86: ldc 8
    //   88: iconst_1
    //   89: iconst_5
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: ldc 56
    //   97: aastore
    //   98: dup
    //   99: iconst_1
    //   100: aload_1
    //   101: aastore
    //   102: dup
    //   103: iconst_2
    //   104: ldc 58
    //   106: aastore
    //   107: dup
    //   108: iconst_3
    //   109: aload_2
    //   110: aastore
    //   111: dup
    //   112: iconst_4
    //   113: aload_0
    //   114: aastore
    //   115: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   118: aload 4
    //   120: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   123: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   126: aload 5
    //   128: ifnull +8 -> 136
    //   131: aload 5
    //   133: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   136: aload 4
    //   138: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   141: iconst_1
    //   142: ireturn
    //   143: astore_0
    //   144: ldc 8
    //   146: iconst_1
    //   147: iconst_5
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: ldc 56
    //   155: aastore
    //   156: dup
    //   157: iconst_1
    //   158: aload_1
    //   159: aastore
    //   160: dup
    //   161: iconst_2
    //   162: ldc 58
    //   164: aastore
    //   165: dup
    //   166: iconst_3
    //   167: aload_2
    //   168: aastore
    //   169: dup
    //   170: iconst_4
    //   171: aload_0
    //   172: aastore
    //   173: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   176: iconst_1
    //   177: ireturn
    //   178: astore_0
    //   179: goto +78 -> 257
    //   182: astore_0
    //   183: ldc 8
    //   185: iconst_1
    //   186: iconst_5
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: ldc 56
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload_1
    //   198: aastore
    //   199: dup
    //   200: iconst_2
    //   201: ldc 58
    //   203: aastore
    //   204: dup
    //   205: iconst_3
    //   206: aload_2
    //   207: aastore
    //   208: dup
    //   209: iconst_4
    //   210: aload_0
    //   211: aastore
    //   212: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   215: aload 4
    //   217: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   220: iconst_1
    //   221: ireturn
    //   222: astore_0
    //   223: ldc 8
    //   225: iconst_1
    //   226: iconst_5
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: ldc 56
    //   234: aastore
    //   235: dup
    //   236: iconst_1
    //   237: aload_1
    //   238: aastore
    //   239: dup
    //   240: iconst_2
    //   241: ldc 58
    //   243: aastore
    //   244: dup
    //   245: iconst_3
    //   246: aload_2
    //   247: aastore
    //   248: dup
    //   249: iconst_4
    //   250: aload_0
    //   251: aastore
    //   252: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   255: iconst_1
    //   256: ireturn
    //   257: aload 4
    //   259: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   262: goto +38 -> 300
    //   265: astore 4
    //   267: ldc 8
    //   269: iconst_1
    //   270: iconst_5
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: ldc 56
    //   278: aastore
    //   279: dup
    //   280: iconst_1
    //   281: aload_1
    //   282: aastore
    //   283: dup
    //   284: iconst_2
    //   285: ldc 58
    //   287: aastore
    //   288: dup
    //   289: iconst_3
    //   290: aload_2
    //   291: aastore
    //   292: dup
    //   293: iconst_4
    //   294: aload 4
    //   296: aastore
    //   297: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   300: aload_0
    //   301: athrow
    //   302: astore_0
    //   303: aload 8
    //   305: astore 6
    //   307: goto +60 -> 367
    //   310: astore_0
    //   311: aload 8
    //   313: astore 10
    //   315: aload 4
    //   317: astore 8
    //   319: aload 5
    //   321: astore 4
    //   323: goto +55 -> 378
    //   326: astore_0
    //   327: aload 4
    //   329: astore 8
    //   331: aload 5
    //   333: astore 4
    //   335: goto +43 -> 378
    //   338: astore_0
    //   339: goto +22 -> 361
    //   342: astore_0
    //   343: aconst_null
    //   344: astore 5
    //   346: aload 4
    //   348: astore 8
    //   350: aload 5
    //   352: astore 4
    //   354: goto +24 -> 378
    //   357: astore_0
    //   358: aconst_null
    //   359: astore 4
    //   361: aconst_null
    //   362: astore 5
    //   364: aconst_null
    //   365: astore 6
    //   367: goto +308 -> 675
    //   370: astore_0
    //   371: aconst_null
    //   372: astore 8
    //   374: aload 8
    //   376: astore 4
    //   378: aload 10
    //   380: astore 9
    //   382: aload 8
    //   384: astore 7
    //   386: aload 4
    //   388: astore 6
    //   390: ldc 8
    //   392: iconst_1
    //   393: iconst_5
    //   394: anewarray 4	java/lang/Object
    //   397: dup
    //   398: iconst_0
    //   399: ldc 56
    //   401: aastore
    //   402: dup
    //   403: iconst_1
    //   404: aload_1
    //   405: aastore
    //   406: dup
    //   407: iconst_2
    //   408: ldc 58
    //   410: aastore
    //   411: dup
    //   412: iconst_3
    //   413: aload_2
    //   414: aastore
    //   415: dup
    //   416: iconst_4
    //   417: aload_0
    //   418: aastore
    //   419: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   422: aload 10
    //   424: ifnull +44 -> 468
    //   427: aload 10
    //   429: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   432: goto +36 -> 468
    //   435: astore_0
    //   436: ldc 8
    //   438: iconst_1
    //   439: iconst_5
    //   440: anewarray 4	java/lang/Object
    //   443: dup
    //   444: iconst_0
    //   445: ldc 56
    //   447: aastore
    //   448: dup
    //   449: iconst_1
    //   450: aload_1
    //   451: aastore
    //   452: dup
    //   453: iconst_2
    //   454: ldc 58
    //   456: aastore
    //   457: dup
    //   458: iconst_3
    //   459: aload_2
    //   460: aastore
    //   461: dup
    //   462: iconst_4
    //   463: aload_0
    //   464: aastore
    //   465: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   468: aload 8
    //   470: ifnull +187 -> 657
    //   473: aload 8
    //   475: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   478: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   481: aload 4
    //   483: ifnull +8 -> 491
    //   486: aload 4
    //   488: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   491: aload 8
    //   493: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   496: iconst_0
    //   497: ireturn
    //   498: astore_0
    //   499: ldc 8
    //   501: iconst_1
    //   502: iconst_5
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: ldc 56
    //   510: aastore
    //   511: dup
    //   512: iconst_1
    //   513: aload_1
    //   514: aastore
    //   515: dup
    //   516: iconst_2
    //   517: ldc 58
    //   519: aastore
    //   520: dup
    //   521: iconst_3
    //   522: aload_2
    //   523: aastore
    //   524: dup
    //   525: iconst_4
    //   526: aload_0
    //   527: aastore
    //   528: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   531: iconst_0
    //   532: ireturn
    //   533: astore_0
    //   534: goto +78 -> 612
    //   537: astore_0
    //   538: ldc 8
    //   540: iconst_1
    //   541: iconst_5
    //   542: anewarray 4	java/lang/Object
    //   545: dup
    //   546: iconst_0
    //   547: ldc 56
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_1
    //   553: aastore
    //   554: dup
    //   555: iconst_2
    //   556: ldc 58
    //   558: aastore
    //   559: dup
    //   560: iconst_3
    //   561: aload_2
    //   562: aastore
    //   563: dup
    //   564: iconst_4
    //   565: aload_0
    //   566: aastore
    //   567: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   570: aload 8
    //   572: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   575: iconst_0
    //   576: ireturn
    //   577: astore_0
    //   578: ldc 8
    //   580: iconst_1
    //   581: iconst_5
    //   582: anewarray 4	java/lang/Object
    //   585: dup
    //   586: iconst_0
    //   587: ldc 56
    //   589: aastore
    //   590: dup
    //   591: iconst_1
    //   592: aload_1
    //   593: aastore
    //   594: dup
    //   595: iconst_2
    //   596: ldc 58
    //   598: aastore
    //   599: dup
    //   600: iconst_3
    //   601: aload_2
    //   602: aastore
    //   603: dup
    //   604: iconst_4
    //   605: aload_0
    //   606: aastore
    //   607: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   610: iconst_0
    //   611: ireturn
    //   612: aload 8
    //   614: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   617: goto +38 -> 655
    //   620: astore 4
    //   622: ldc 8
    //   624: iconst_1
    //   625: iconst_5
    //   626: anewarray 4	java/lang/Object
    //   629: dup
    //   630: iconst_0
    //   631: ldc 56
    //   633: aastore
    //   634: dup
    //   635: iconst_1
    //   636: aload_1
    //   637: aastore
    //   638: dup
    //   639: iconst_2
    //   640: ldc 58
    //   642: aastore
    //   643: dup
    //   644: iconst_3
    //   645: aload_2
    //   646: aastore
    //   647: dup
    //   648: iconst_4
    //   649: aload 4
    //   651: aastore
    //   652: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   655: aload_0
    //   656: athrow
    //   657: iconst_0
    //   658: ireturn
    //   659: astore_0
    //   660: aload 7
    //   662: astore 4
    //   664: aload 6
    //   666: astore 5
    //   668: aload 9
    //   670: astore 6
    //   672: goto -305 -> 367
    //   675: aload 6
    //   677: ifnull +46 -> 723
    //   680: aload 6
    //   682: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   685: goto +38 -> 723
    //   688: astore 6
    //   690: ldc 8
    //   692: iconst_1
    //   693: iconst_5
    //   694: anewarray 4	java/lang/Object
    //   697: dup
    //   698: iconst_0
    //   699: ldc 56
    //   701: aastore
    //   702: dup
    //   703: iconst_1
    //   704: aload_1
    //   705: aastore
    //   706: dup
    //   707: iconst_2
    //   708: ldc 58
    //   710: aastore
    //   711: dup
    //   712: iconst_3
    //   713: aload_2
    //   714: aastore
    //   715: dup
    //   716: iconst_4
    //   717: aload 6
    //   719: aastore
    //   720: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   723: aload 4
    //   725: ifnull +197 -> 922
    //   728: aload 4
    //   730: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   733: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   736: aload 5
    //   738: ifnull +8 -> 746
    //   741: aload 5
    //   743: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   746: aload 4
    //   748: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   751: goto +171 -> 922
    //   754: astore 4
    //   756: ldc 8
    //   758: iconst_1
    //   759: iconst_5
    //   760: anewarray 4	java/lang/Object
    //   763: dup
    //   764: iconst_0
    //   765: ldc 56
    //   767: aastore
    //   768: dup
    //   769: iconst_1
    //   770: aload_1
    //   771: aastore
    //   772: dup
    //   773: iconst_2
    //   774: ldc 58
    //   776: aastore
    //   777: dup
    //   778: iconst_3
    //   779: aload_2
    //   780: aastore
    //   781: dup
    //   782: iconst_4
    //   783: aload 4
    //   785: aastore
    //   786: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   789: goto +133 -> 922
    //   792: astore_0
    //   793: goto +84 -> 877
    //   796: astore 5
    //   798: ldc 8
    //   800: iconst_1
    //   801: iconst_5
    //   802: anewarray 4	java/lang/Object
    //   805: dup
    //   806: iconst_0
    //   807: ldc 56
    //   809: aastore
    //   810: dup
    //   811: iconst_1
    //   812: aload_1
    //   813: aastore
    //   814: dup
    //   815: iconst_2
    //   816: ldc 58
    //   818: aastore
    //   819: dup
    //   820: iconst_3
    //   821: aload_2
    //   822: aastore
    //   823: dup
    //   824: iconst_4
    //   825: aload 5
    //   827: aastore
    //   828: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   831: aload 4
    //   833: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   836: goto +86 -> 922
    //   839: astore 4
    //   841: ldc 8
    //   843: iconst_1
    //   844: iconst_5
    //   845: anewarray 4	java/lang/Object
    //   848: dup
    //   849: iconst_0
    //   850: ldc 56
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: aload_1
    //   856: aastore
    //   857: dup
    //   858: iconst_2
    //   859: ldc 58
    //   861: aastore
    //   862: dup
    //   863: iconst_3
    //   864: aload_2
    //   865: aastore
    //   866: dup
    //   867: iconst_4
    //   868: aload 4
    //   870: aastore
    //   871: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   874: goto +48 -> 922
    //   877: aload 4
    //   879: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   882: goto +38 -> 920
    //   885: astore 4
    //   887: ldc 8
    //   889: iconst_1
    //   890: iconst_5
    //   891: anewarray 4	java/lang/Object
    //   894: dup
    //   895: iconst_0
    //   896: ldc 56
    //   898: aastore
    //   899: dup
    //   900: iconst_1
    //   901: aload_1
    //   902: aastore
    //   903: dup
    //   904: iconst_2
    //   905: ldc 58
    //   907: aastore
    //   908: dup
    //   909: iconst_3
    //   910: aload_2
    //   911: aastore
    //   912: dup
    //   913: iconst_4
    //   914: aload 4
    //   916: aastore
    //   917: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   920: aload_0
    //   921: athrow
    //   922: goto +5 -> 927
    //   925: aload_0
    //   926: athrow
    //   927: goto -2 -> 925
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	930	0	paramAssetManager	android.content.res.AssetManager
    //   0	930	1	paramString1	String
    //   0	930	2	paramString2	String
    //   60	11	3	i	int
    //   14	244	4	localFileOutputStream	java.io.FileOutputStream
    //   265	51	4	localIOException1	java.io.IOException
    //   321	166	4	localObject1	Object
    //   620	30	4	localIOException2	java.io.IOException
    //   662	85	4	localObject2	Object
    //   754	78	4	localIOException3	java.io.IOException
    //   839	39	4	localIOException4	java.io.IOException
    //   885	30	4	localIOException5	java.io.IOException
    //   24	718	5	localObject3	Object
    //   796	30	5	localIOException6	java.io.IOException
    //   32	649	6	localObject4	Object
    //   688	30	6	localIOException7	java.io.IOException
    //   28	633	7	localObject5	Object
    //   46	567	8	localObject6	Object
    //   1	668	9	localObject7	Object
    //   4	424	10	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   77	82	85	java/io/IOException
    //   136	141	143	java/io/IOException
    //   118	126	178	finally
    //   131	136	178	finally
    //   183	215	178	finally
    //   118	126	182	java/io/IOException
    //   131	136	182	java/io/IOException
    //   215	220	222	java/io/IOException
    //   257	262	265	java/io/IOException
    //   48	54	302	finally
    //   54	61	302	finally
    //   66	74	302	finally
    //   48	54	310	java/io/IOException
    //   54	61	310	java/io/IOException
    //   66	74	310	java/io/IOException
    //   34	48	326	java/io/IOException
    //   16	26	338	finally
    //   16	26	342	java/io/IOException
    //   6	16	357	finally
    //   6	16	370	java/io/IOException
    //   427	432	435	java/io/IOException
    //   491	496	498	java/io/IOException
    //   473	481	533	finally
    //   486	491	533	finally
    //   538	570	533	finally
    //   473	481	537	java/io/IOException
    //   486	491	537	java/io/IOException
    //   570	575	577	java/io/IOException
    //   612	617	620	java/io/IOException
    //   34	48	659	finally
    //   390	422	659	finally
    //   680	685	688	java/io/IOException
    //   746	751	754	java/io/IOException
    //   728	736	792	finally
    //   741	746	792	finally
    //   798	831	792	finally
    //   728	736	796	java/io/IOException
    //   741	746	796	java/io/IOException
    //   831	836	839	java/io/IOException
    //   877	882	885	java/io/IOException
  }
  
  public static boolean copyFileOrDir(Context paramContext, String paramString1, String paramString2, List<String> paramList)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramList != null))
    {
      if (paramList.size() <= 0) {
        return false;
      }
      try
      {
        paramContext = paramContext.getAssets();
        Object localObject = new File(paramString2);
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str = (String)paramList.next();
          if (!TextUtils.isEmpty(str))
          {
            localObject = new File(paramString2, str);
            if (!((File)localObject).exists()) {
              ((File)localObject).getParentFile().mkdirs();
            }
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString1);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(str);
            str = localStringBuilder.toString();
            localObject = ((File)localObject).getAbsolutePath();
            if (!copyAssetToFile(paramContext, str, (String)localObject))
            {
              QLog.e("[minigame] AssetsUtil", 1, String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
              return false;
            }
          }
        }
        return true;
      }
      catch (Throwable paramContext)
      {
        QLog.e("[minigame] AssetsUtil", 1, String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
      }
    }
    try
    {
      paramContext = new File(paramString2);
      if (paramContext.exists()) {
        FileUtils.deleteFile(paramContext);
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  /* Error */
  @java.lang.Deprecated
  public static String getContentFromAssets(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: invokevirtual 101	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   7: aload_1
    //   8: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   11: astore_2
    //   12: new 182	java/io/BufferedReader
    //   15: dup
    //   16: new 184	java/io/InputStreamReader
    //   19: dup
    //   20: aload_2
    //   21: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_0
    //   28: aload_0
    //   29: astore_3
    //   30: aload_2
    //   31: astore 4
    //   33: new 138	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_0
    //   43: astore_3
    //   44: aload_2
    //   45: astore 4
    //   47: aload_0
    //   48: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +19 -> 74
    //   58: aload_0
    //   59: astore_3
    //   60: aload_2
    //   61: astore 4
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: aload_0
    //   75: astore_3
    //   76: aload_2
    //   77: astore 4
    //   79: aload 5
    //   81: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: astore 5
    //   86: aload_0
    //   87: invokevirtual 192	java/io/BufferedReader:close	()V
    //   90: goto +27 -> 117
    //   93: astore_0
    //   94: ldc 8
    //   96: iconst_1
    //   97: iconst_3
    //   98: anewarray 4	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: ldc 194
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: aload_1
    //   109: aastore
    //   110: dup
    //   111: iconst_2
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   117: aload 5
    //   119: astore_0
    //   120: aload_2
    //   121: ifnull +173 -> 294
    //   124: aload_2
    //   125: invokevirtual 197	java/io/InputStream:close	()V
    //   128: aload 5
    //   130: areturn
    //   131: astore_0
    //   132: ldc 8
    //   134: iconst_1
    //   135: iconst_3
    //   136: anewarray 4	java/lang/Object
    //   139: dup
    //   140: iconst_0
    //   141: ldc 199
    //   143: aastore
    //   144: dup
    //   145: iconst_1
    //   146: aload_1
    //   147: aastore
    //   148: dup
    //   149: iconst_2
    //   150: aload_0
    //   151: aastore
    //   152: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   155: aload 5
    //   157: areturn
    //   158: astore 5
    //   160: goto +30 -> 190
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_3
    //   166: goto +134 -> 300
    //   169: astore 5
    //   171: aconst_null
    //   172: astore_0
    //   173: goto +17 -> 190
    //   176: astore_0
    //   177: aconst_null
    //   178: astore_3
    //   179: aload_3
    //   180: astore_2
    //   181: goto +119 -> 300
    //   184: astore 5
    //   186: aconst_null
    //   187: astore_2
    //   188: aload_2
    //   189: astore_0
    //   190: aload_0
    //   191: astore_3
    //   192: aload_2
    //   193: astore 4
    //   195: ldc 8
    //   197: iconst_1
    //   198: iconst_3
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: ldc 201
    //   206: aastore
    //   207: dup
    //   208: iconst_1
    //   209: aload_1
    //   210: aastore
    //   211: dup
    //   212: iconst_2
    //   213: aload 5
    //   215: aastore
    //   216: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   219: aload_0
    //   220: ifnull +34 -> 254
    //   223: aload_0
    //   224: invokevirtual 192	java/io/BufferedReader:close	()V
    //   227: goto +27 -> 254
    //   230: astore_0
    //   231: ldc 8
    //   233: iconst_1
    //   234: iconst_3
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: ldc 194
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload_1
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aload_0
    //   250: aastore
    //   251: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   254: aload 6
    //   256: astore_0
    //   257: aload_2
    //   258: ifnull +36 -> 294
    //   261: aload_2
    //   262: invokevirtual 197	java/io/InputStream:close	()V
    //   265: aconst_null
    //   266: areturn
    //   267: astore_0
    //   268: ldc 8
    //   270: iconst_1
    //   271: iconst_3
    //   272: anewarray 4	java/lang/Object
    //   275: dup
    //   276: iconst_0
    //   277: ldc 199
    //   279: aastore
    //   280: dup
    //   281: iconst_1
    //   282: aload_1
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: aastore
    //   288: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   291: aload 6
    //   293: astore_0
    //   294: aload_0
    //   295: areturn
    //   296: astore_0
    //   297: aload 4
    //   299: astore_2
    //   300: aload_3
    //   301: ifnull +34 -> 335
    //   304: aload_3
    //   305: invokevirtual 192	java/io/BufferedReader:close	()V
    //   308: goto +27 -> 335
    //   311: astore_3
    //   312: ldc 8
    //   314: iconst_1
    //   315: iconst_3
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: ldc 194
    //   323: aastore
    //   324: dup
    //   325: iconst_1
    //   326: aload_1
    //   327: aastore
    //   328: dup
    //   329: iconst_2
    //   330: aload_3
    //   331: aastore
    //   332: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   335: aload_2
    //   336: ifnull +34 -> 370
    //   339: aload_2
    //   340: invokevirtual 197	java/io/InputStream:close	()V
    //   343: goto +27 -> 370
    //   346: astore_2
    //   347: ldc 8
    //   349: iconst_1
    //   350: iconst_3
    //   351: anewarray 4	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 199
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload_1
    //   362: aastore
    //   363: dup
    //   364: iconst_2
    //   365: aload_2
    //   366: aastore
    //   367: invokestatic 64	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   370: goto +5 -> 375
    //   373: aload_0
    //   374: athrow
    //   375: goto -2 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramContext	Context
    //   0	378	1	paramString	String
    //   11	329	2	localObject1	Object
    //   346	20	2	localIOException1	java.io.IOException
    //   29	276	3	localContext	Context
    //   311	20	3	localIOException2	java.io.IOException
    //   31	267	4	localObject2	Object
    //   40	116	5	localObject3	Object
    //   158	1	5	localIOException3	java.io.IOException
    //   169	1	5	localIOException4	java.io.IOException
    //   184	30	5	localIOException5	java.io.IOException
    //   1	291	6	localObject4	Object
    //   51	15	7	str	String
    // Exception table:
    //   from	to	target	type
    //   86	90	93	java/io/IOException
    //   124	128	131	java/io/IOException
    //   33	42	158	java/io/IOException
    //   47	53	158	java/io/IOException
    //   63	71	158	java/io/IOException
    //   79	86	158	java/io/IOException
    //   12	28	163	finally
    //   12	28	169	java/io/IOException
    //   3	12	176	finally
    //   3	12	184	java/io/IOException
    //   223	227	230	java/io/IOException
    //   261	265	267	java/io/IOException
    //   33	42	296	finally
    //   47	53	296	finally
    //   63	71	296	finally
    //   79	86	296	finally
    //   195	219	296	finally
    //   304	308	311	java/io/IOException
    //   339	343	346	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */