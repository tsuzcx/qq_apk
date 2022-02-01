package com.tencent.mobileqq.minigame.utils;

import android.content.Context;
import android.text.TextUtils;
import atwl;
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
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 7
    //   9: aconst_null
    //   10: astore 5
    //   12: new 19	java/io/FileOutputStream
    //   15: dup
    //   16: aload_2
    //   17: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aload 8
    //   24: astore 10
    //   26: aload 6
    //   28: invokevirtual 26	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   31: invokevirtual 32	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   34: astore 5
    //   36: aload 5
    //   38: astore 10
    //   40: aload 5
    //   42: astore 7
    //   44: new 34	java/io/BufferedInputStream
    //   47: dup
    //   48: aload_0
    //   49: aload_1
    //   50: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   56: astore_0
    //   57: aload 5
    //   59: astore 10
    //   61: aload 6
    //   63: astore 8
    //   65: aload_0
    //   66: astore 7
    //   68: sipush 8192
    //   71: newarray byte
    //   73: astore 9
    //   75: aload 5
    //   77: astore 10
    //   79: aload 6
    //   81: astore 8
    //   83: aload_0
    //   84: astore 7
    //   86: aload_0
    //   87: aload 9
    //   89: invokevirtual 47	java/io/BufferedInputStream:read	([B)I
    //   92: istore_3
    //   93: iload_3
    //   94: iconst_m1
    //   95: if_icmpeq +114 -> 209
    //   98: aload 5
    //   100: astore 10
    //   102: aload 6
    //   104: astore 8
    //   106: aload_0
    //   107: astore 7
    //   109: aload 6
    //   111: aload 9
    //   113: iconst_0
    //   114: iload_3
    //   115: invokevirtual 51	java/io/FileOutputStream:write	([BII)V
    //   118: goto -43 -> 75
    //   121: astore 9
    //   123: aload 5
    //   125: astore 10
    //   127: aload 6
    //   129: astore 8
    //   131: aload_0
    //   132: astore 7
    //   134: ldc 8
    //   136: iconst_1
    //   137: iconst_5
    //   138: anewarray 4	java/lang/Object
    //   141: dup
    //   142: iconst_0
    //   143: ldc 53
    //   145: aastore
    //   146: dup
    //   147: iconst_1
    //   148: aload_1
    //   149: aastore
    //   150: dup
    //   151: iconst_2
    //   152: ldc 55
    //   154: aastore
    //   155: dup
    //   156: iconst_3
    //   157: aload_2
    //   158: aastore
    //   159: dup
    //   160: iconst_4
    //   161: aload 9
    //   163: aastore
    //   164: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   167: aload_0
    //   168: ifnull +7 -> 175
    //   171: aload_0
    //   172: invokevirtual 64	java/io/BufferedInputStream:close	()V
    //   175: aload 6
    //   177: ifnull +26 -> 203
    //   180: aload 6
    //   182: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   185: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   188: aload 5
    //   190: ifnull +8 -> 198
    //   193: aload 5
    //   195: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   198: aload 6
    //   200: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   203: iconst_0
    //   204: istore 4
    //   206: iload 4
    //   208: ireturn
    //   209: iconst_1
    //   210: istore 4
    //   212: aload_0
    //   213: ifnull +7 -> 220
    //   216: aload_0
    //   217: invokevirtual 64	java/io/BufferedInputStream:close	()V
    //   220: aload 6
    //   222: ifnull -16 -> 206
    //   225: aload 6
    //   227: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   230: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   233: aload 5
    //   235: ifnull +8 -> 243
    //   238: aload 5
    //   240: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   243: aload 6
    //   245: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   248: iconst_1
    //   249: ireturn
    //   250: astore_0
    //   251: ldc 8
    //   253: iconst_1
    //   254: iconst_5
    //   255: anewarray 4	java/lang/Object
    //   258: dup
    //   259: iconst_0
    //   260: ldc 53
    //   262: aastore
    //   263: dup
    //   264: iconst_1
    //   265: aload_1
    //   266: aastore
    //   267: dup
    //   268: iconst_2
    //   269: ldc 55
    //   271: aastore
    //   272: dup
    //   273: iconst_3
    //   274: aload_2
    //   275: aastore
    //   276: dup
    //   277: iconst_4
    //   278: aload_0
    //   279: aastore
    //   280: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   283: iconst_1
    //   284: ireturn
    //   285: astore_0
    //   286: ldc 8
    //   288: iconst_1
    //   289: iconst_5
    //   290: anewarray 4	java/lang/Object
    //   293: dup
    //   294: iconst_0
    //   295: ldc 53
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: aload_1
    //   301: aastore
    //   302: dup
    //   303: iconst_2
    //   304: ldc 55
    //   306: aastore
    //   307: dup
    //   308: iconst_3
    //   309: aload_2
    //   310: aastore
    //   311: dup
    //   312: iconst_4
    //   313: aload_0
    //   314: aastore
    //   315: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   318: goto -98 -> 220
    //   321: astore_0
    //   322: ldc 8
    //   324: iconst_1
    //   325: iconst_5
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: ldc 53
    //   333: aastore
    //   334: dup
    //   335: iconst_1
    //   336: aload_1
    //   337: aastore
    //   338: dup
    //   339: iconst_2
    //   340: ldc 55
    //   342: aastore
    //   343: dup
    //   344: iconst_3
    //   345: aload_2
    //   346: aastore
    //   347: dup
    //   348: iconst_4
    //   349: aload_0
    //   350: aastore
    //   351: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   354: aload 6
    //   356: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   359: iconst_1
    //   360: ireturn
    //   361: astore_0
    //   362: ldc 8
    //   364: iconst_1
    //   365: iconst_5
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: ldc 53
    //   373: aastore
    //   374: dup
    //   375: iconst_1
    //   376: aload_1
    //   377: aastore
    //   378: dup
    //   379: iconst_2
    //   380: ldc 55
    //   382: aastore
    //   383: dup
    //   384: iconst_3
    //   385: aload_2
    //   386: aastore
    //   387: dup
    //   388: iconst_4
    //   389: aload_0
    //   390: aastore
    //   391: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   394: iconst_1
    //   395: ireturn
    //   396: astore_0
    //   397: aload 6
    //   399: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   402: aload_0
    //   403: athrow
    //   404: astore 5
    //   406: ldc 8
    //   408: iconst_1
    //   409: iconst_5
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: ldc 53
    //   417: aastore
    //   418: dup
    //   419: iconst_1
    //   420: aload_1
    //   421: aastore
    //   422: dup
    //   423: iconst_2
    //   424: ldc 55
    //   426: aastore
    //   427: dup
    //   428: iconst_3
    //   429: aload_2
    //   430: aastore
    //   431: dup
    //   432: iconst_4
    //   433: aload 5
    //   435: aastore
    //   436: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   439: goto -37 -> 402
    //   442: astore_0
    //   443: ldc 8
    //   445: iconst_1
    //   446: iconst_5
    //   447: anewarray 4	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: ldc 53
    //   454: aastore
    //   455: dup
    //   456: iconst_1
    //   457: aload_1
    //   458: aastore
    //   459: dup
    //   460: iconst_2
    //   461: ldc 55
    //   463: aastore
    //   464: dup
    //   465: iconst_3
    //   466: aload_2
    //   467: aastore
    //   468: dup
    //   469: iconst_4
    //   470: aload_0
    //   471: aastore
    //   472: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   475: goto -300 -> 175
    //   478: astore_0
    //   479: ldc 8
    //   481: iconst_1
    //   482: iconst_5
    //   483: anewarray 4	java/lang/Object
    //   486: dup
    //   487: iconst_0
    //   488: ldc 53
    //   490: aastore
    //   491: dup
    //   492: iconst_1
    //   493: aload_1
    //   494: aastore
    //   495: dup
    //   496: iconst_2
    //   497: ldc 55
    //   499: aastore
    //   500: dup
    //   501: iconst_3
    //   502: aload_2
    //   503: aastore
    //   504: dup
    //   505: iconst_4
    //   506: aload_0
    //   507: aastore
    //   508: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   511: goto -308 -> 203
    //   514: astore_0
    //   515: ldc 8
    //   517: iconst_1
    //   518: iconst_5
    //   519: anewarray 4	java/lang/Object
    //   522: dup
    //   523: iconst_0
    //   524: ldc 53
    //   526: aastore
    //   527: dup
    //   528: iconst_1
    //   529: aload_1
    //   530: aastore
    //   531: dup
    //   532: iconst_2
    //   533: ldc 55
    //   535: aastore
    //   536: dup
    //   537: iconst_3
    //   538: aload_2
    //   539: aastore
    //   540: dup
    //   541: iconst_4
    //   542: aload_0
    //   543: aastore
    //   544: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   547: aload 6
    //   549: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   552: goto -349 -> 203
    //   555: astore_0
    //   556: ldc 8
    //   558: iconst_1
    //   559: iconst_5
    //   560: anewarray 4	java/lang/Object
    //   563: dup
    //   564: iconst_0
    //   565: ldc 53
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: aload_1
    //   571: aastore
    //   572: dup
    //   573: iconst_2
    //   574: ldc 55
    //   576: aastore
    //   577: dup
    //   578: iconst_3
    //   579: aload_2
    //   580: aastore
    //   581: dup
    //   582: iconst_4
    //   583: aload_0
    //   584: aastore
    //   585: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   588: goto -385 -> 203
    //   591: astore_0
    //   592: aload 6
    //   594: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   597: aload_0
    //   598: athrow
    //   599: astore 5
    //   601: ldc 8
    //   603: iconst_1
    //   604: iconst_5
    //   605: anewarray 4	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: ldc 53
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload_1
    //   616: aastore
    //   617: dup
    //   618: iconst_2
    //   619: ldc 55
    //   621: aastore
    //   622: dup
    //   623: iconst_3
    //   624: aload_2
    //   625: aastore
    //   626: dup
    //   627: iconst_4
    //   628: aload 5
    //   630: aastore
    //   631: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   634: goto -37 -> 597
    //   637: astore_0
    //   638: aconst_null
    //   639: astore 6
    //   641: aconst_null
    //   642: astore 7
    //   644: aload 7
    //   646: ifnull +8 -> 654
    //   649: aload 7
    //   651: invokevirtual 64	java/io/BufferedInputStream:close	()V
    //   654: aload 6
    //   656: ifnull +26 -> 682
    //   659: aload 6
    //   661: invokevirtual 68	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   664: invokevirtual 73	java/io/FileDescriptor:sync	()V
    //   667: aload 10
    //   669: ifnull +8 -> 677
    //   672: aload 10
    //   674: invokevirtual 78	java/nio/channels/FileLock:release	()V
    //   677: aload 6
    //   679: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   682: aload_0
    //   683: athrow
    //   684: astore 5
    //   686: ldc 8
    //   688: iconst_1
    //   689: iconst_5
    //   690: anewarray 4	java/lang/Object
    //   693: dup
    //   694: iconst_0
    //   695: ldc 53
    //   697: aastore
    //   698: dup
    //   699: iconst_1
    //   700: aload_1
    //   701: aastore
    //   702: dup
    //   703: iconst_2
    //   704: ldc 55
    //   706: aastore
    //   707: dup
    //   708: iconst_3
    //   709: aload_2
    //   710: aastore
    //   711: dup
    //   712: iconst_4
    //   713: aload 5
    //   715: aastore
    //   716: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   719: goto -65 -> 654
    //   722: astore 5
    //   724: ldc 8
    //   726: iconst_1
    //   727: iconst_5
    //   728: anewarray 4	java/lang/Object
    //   731: dup
    //   732: iconst_0
    //   733: ldc 53
    //   735: aastore
    //   736: dup
    //   737: iconst_1
    //   738: aload_1
    //   739: aastore
    //   740: dup
    //   741: iconst_2
    //   742: ldc 55
    //   744: aastore
    //   745: dup
    //   746: iconst_3
    //   747: aload_2
    //   748: aastore
    //   749: dup
    //   750: iconst_4
    //   751: aload 5
    //   753: aastore
    //   754: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   757: goto -75 -> 682
    //   760: astore 5
    //   762: ldc 8
    //   764: iconst_1
    //   765: iconst_5
    //   766: anewarray 4	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: ldc 53
    //   773: aastore
    //   774: dup
    //   775: iconst_1
    //   776: aload_1
    //   777: aastore
    //   778: dup
    //   779: iconst_2
    //   780: ldc 55
    //   782: aastore
    //   783: dup
    //   784: iconst_3
    //   785: aload_2
    //   786: aastore
    //   787: dup
    //   788: iconst_4
    //   789: aload 5
    //   791: aastore
    //   792: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   795: aload 6
    //   797: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   800: goto -118 -> 682
    //   803: astore 5
    //   805: ldc 8
    //   807: iconst_1
    //   808: iconst_5
    //   809: anewarray 4	java/lang/Object
    //   812: dup
    //   813: iconst_0
    //   814: ldc 53
    //   816: aastore
    //   817: dup
    //   818: iconst_1
    //   819: aload_1
    //   820: aastore
    //   821: dup
    //   822: iconst_2
    //   823: ldc 55
    //   825: aastore
    //   826: dup
    //   827: iconst_3
    //   828: aload_2
    //   829: aastore
    //   830: dup
    //   831: iconst_4
    //   832: aload 5
    //   834: aastore
    //   835: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   838: goto -156 -> 682
    //   841: astore_0
    //   842: aload 6
    //   844: invokevirtual 79	java/io/FileOutputStream:close	()V
    //   847: aload_0
    //   848: athrow
    //   849: astore 5
    //   851: ldc 8
    //   853: iconst_1
    //   854: iconst_5
    //   855: anewarray 4	java/lang/Object
    //   858: dup
    //   859: iconst_0
    //   860: ldc 53
    //   862: aastore
    //   863: dup
    //   864: iconst_1
    //   865: aload_1
    //   866: aastore
    //   867: dup
    //   868: iconst_2
    //   869: ldc 55
    //   871: aastore
    //   872: dup
    //   873: iconst_3
    //   874: aload_2
    //   875: aastore
    //   876: dup
    //   877: iconst_4
    //   878: aload 5
    //   880: aastore
    //   881: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   884: goto -37 -> 847
    //   887: astore_0
    //   888: aconst_null
    //   889: astore 7
    //   891: goto -247 -> 644
    //   894: astore_0
    //   895: aload 8
    //   897: astore 6
    //   899: goto -255 -> 644
    //   902: astore 9
    //   904: aconst_null
    //   905: astore 6
    //   907: aconst_null
    //   908: astore_0
    //   909: goto -786 -> 123
    //   912: astore 9
    //   914: aconst_null
    //   915: astore_0
    //   916: aload 7
    //   918: astore 5
    //   920: goto -797 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	paramAssetManager	android.content.res.AssetManager
    //   0	923	1	paramString1	String
    //   0	923	2	paramString2	String
    //   92	23	3	i	int
    //   204	7	4	bool	boolean
    //   10	229	5	localFileLock	java.nio.channels.FileLock
    //   404	30	5	localIOException1	java.io.IOException
    //   599	30	5	localIOException2	java.io.IOException
    //   684	30	5	localIOException3	java.io.IOException
    //   722	30	5	localIOException4	java.io.IOException
    //   760	30	5	localIOException5	java.io.IOException
    //   803	30	5	localIOException6	java.io.IOException
    //   849	30	5	localIOException7	java.io.IOException
    //   918	1	5	localObject1	Object
    //   20	886	6	localObject2	Object
    //   7	910	7	localObject3	Object
    //   4	892	8	localObject4	Object
    //   73	39	9	arrayOfByte	byte[]
    //   121	41	9	localIOException8	java.io.IOException
    //   902	1	9	localIOException9	java.io.IOException
    //   912	1	9	localIOException10	java.io.IOException
    //   1	672	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   68	75	121	java/io/IOException
    //   86	93	121	java/io/IOException
    //   109	118	121	java/io/IOException
    //   243	248	250	java/io/IOException
    //   216	220	285	java/io/IOException
    //   225	233	321	java/io/IOException
    //   238	243	321	java/io/IOException
    //   354	359	361	java/io/IOException
    //   225	233	396	finally
    //   238	243	396	finally
    //   322	354	396	finally
    //   397	402	404	java/io/IOException
    //   171	175	442	java/io/IOException
    //   198	203	478	java/io/IOException
    //   180	188	514	java/io/IOException
    //   193	198	514	java/io/IOException
    //   547	552	555	java/io/IOException
    //   180	188	591	finally
    //   193	198	591	finally
    //   515	547	591	finally
    //   592	597	599	java/io/IOException
    //   12	22	637	finally
    //   649	654	684	java/io/IOException
    //   677	682	722	java/io/IOException
    //   659	667	760	java/io/IOException
    //   672	677	760	java/io/IOException
    //   795	800	803	java/io/IOException
    //   659	667	841	finally
    //   672	677	841	finally
    //   762	795	841	finally
    //   842	847	849	java/io/IOException
    //   26	36	887	finally
    //   44	57	887	finally
    //   68	75	894	finally
    //   86	93	894	finally
    //   109	118	894	finally
    //   134	167	894	finally
    //   12	22	902	java/io/IOException
    //   26	36	912	java/io/IOException
    //   44	57	912	java/io/IOException
  }
  
  public static boolean copyFileOrDir(Context paramContext, String paramString1, String paramString2, List<String> paramList)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramList == null) || (paramList.size() <= 0)) {
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
          str = paramString1 + File.separator + str;
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
    try
    {
      paramContext = new File(paramString2);
      if (paramContext.exists()) {
        atwl.a(paramContext);
      }
      label242:
      return false;
    }
    catch (Throwable paramContext)
    {
      break label242;
    }
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
    //   11: astore_0
    //   12: new 182	java/io/BufferedReader
    //   15: dup
    //   16: new 184	java/io/InputStreamReader
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 185	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   24: invokespecial 188	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_2
    //   28: aload_2
    //   29: astore 4
    //   31: aload_0
    //   32: astore_3
    //   33: new 138	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: aload_2
    //   43: astore 4
    //   45: aload_0
    //   46: astore_3
    //   47: aload_2
    //   48: invokevirtual 191	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore 7
    //   53: aload 7
    //   55: ifnull +74 -> 129
    //   58: aload_2
    //   59: astore 4
    //   61: aload_0
    //   62: astore_3
    //   63: aload 5
    //   65: aload 7
    //   67: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: goto -29 -> 42
    //   74: astore 5
    //   76: aload_2
    //   77: astore 4
    //   79: aload_0
    //   80: astore_3
    //   81: ldc 8
    //   83: iconst_1
    //   84: iconst_3
    //   85: anewarray 4	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: ldc 193
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_2
    //   99: aload 5
    //   101: aastore
    //   102: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   105: aload_2
    //   106: ifnull +7 -> 113
    //   109: aload_2
    //   110: invokevirtual 194	java/io/BufferedReader:close	()V
    //   113: aload 6
    //   115: astore_2
    //   116: aload_0
    //   117: ifnull +10 -> 127
    //   120: aload_0
    //   121: invokevirtual 197	java/io/InputStream:close	()V
    //   124: aload 6
    //   126: astore_2
    //   127: aload_2
    //   128: areturn
    //   129: aload_2
    //   130: astore 4
    //   132: aload_0
    //   133: astore_3
    //   134: aload 5
    //   136: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore 5
    //   141: aload 5
    //   143: astore_3
    //   144: aload_2
    //   145: ifnull +7 -> 152
    //   148: aload_2
    //   149: invokevirtual 194	java/io/BufferedReader:close	()V
    //   152: aload_3
    //   153: astore_2
    //   154: aload_0
    //   155: ifnull -28 -> 127
    //   158: aload_0
    //   159: invokevirtual 197	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: areturn
    //   164: astore_0
    //   165: ldc 8
    //   167: iconst_1
    //   168: iconst_3
    //   169: anewarray 4	java/lang/Object
    //   172: dup
    //   173: iconst_0
    //   174: ldc 199
    //   176: aastore
    //   177: dup
    //   178: iconst_1
    //   179: aload_1
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload_0
    //   184: aastore
    //   185: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   188: aload_3
    //   189: areturn
    //   190: astore_2
    //   191: ldc 8
    //   193: iconst_1
    //   194: iconst_3
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: ldc 201
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload_1
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: aload_2
    //   210: aastore
    //   211: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   214: goto -62 -> 152
    //   217: astore_2
    //   218: ldc 8
    //   220: iconst_1
    //   221: iconst_3
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: ldc 201
    //   229: aastore
    //   230: dup
    //   231: iconst_1
    //   232: aload_1
    //   233: aastore
    //   234: dup
    //   235: iconst_2
    //   236: aload_2
    //   237: aastore
    //   238: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   241: goto -128 -> 113
    //   244: astore_0
    //   245: ldc 8
    //   247: iconst_1
    //   248: iconst_3
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: ldc 199
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload_1
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: aload_0
    //   264: aastore
    //   265: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore_2
    //   271: aconst_null
    //   272: astore 4
    //   274: aconst_null
    //   275: astore_0
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 194	java/io/BufferedReader:close	()V
    //   286: aload_0
    //   287: ifnull +7 -> 294
    //   290: aload_0
    //   291: invokevirtual 197	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: athrow
    //   296: astore_3
    //   297: ldc 8
    //   299: iconst_1
    //   300: iconst_3
    //   301: anewarray 4	java/lang/Object
    //   304: dup
    //   305: iconst_0
    //   306: ldc 201
    //   308: aastore
    //   309: dup
    //   310: iconst_1
    //   311: aload_1
    //   312: aastore
    //   313: dup
    //   314: iconst_2
    //   315: aload_3
    //   316: aastore
    //   317: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   320: goto -34 -> 286
    //   323: astore_0
    //   324: ldc 8
    //   326: iconst_1
    //   327: iconst_3
    //   328: anewarray 4	java/lang/Object
    //   331: dup
    //   332: iconst_0
    //   333: ldc 199
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: aload_1
    //   339: aastore
    //   340: dup
    //   341: iconst_2
    //   342: aload_0
    //   343: aastore
    //   344: invokestatic 61	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   347: goto -53 -> 294
    //   350: astore_2
    //   351: aconst_null
    //   352: astore 4
    //   354: goto -78 -> 276
    //   357: astore_2
    //   358: aload_3
    //   359: astore_0
    //   360: goto -84 -> 276
    //   363: astore 5
    //   365: aconst_null
    //   366: astore_2
    //   367: aconst_null
    //   368: astore_0
    //   369: goto -293 -> 76
    //   372: astore 5
    //   374: aconst_null
    //   375: astore_2
    //   376: goto -300 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramContext	Context
    //   0	379	1	paramString	String
    //   27	127	2	localObject1	Object
    //   190	20	2	localIOException1	java.io.IOException
    //   217	20	2	localIOException2	java.io.IOException
    //   270	25	2	localObject2	Object
    //   350	1	2	localObject3	Object
    //   357	1	2	localObject4	Object
    //   366	10	2	localObject5	Object
    //   32	157	3	localObject6	Object
    //   296	63	3	localIOException3	java.io.IOException
    //   29	324	4	localObject7	Object
    //   40	24	5	localStringBuilder	java.lang.StringBuilder
    //   74	61	5	localIOException4	java.io.IOException
    //   139	3	5	str1	String
    //   363	1	5	localIOException5	java.io.IOException
    //   372	1	5	localIOException6	java.io.IOException
    //   1	124	6	localObject8	Object
    //   51	15	7	str2	String
    // Exception table:
    //   from	to	target	type
    //   33	42	74	java/io/IOException
    //   47	53	74	java/io/IOException
    //   63	71	74	java/io/IOException
    //   134	141	74	java/io/IOException
    //   158	162	164	java/io/IOException
    //   148	152	190	java/io/IOException
    //   109	113	217	java/io/IOException
    //   120	124	244	java/io/IOException
    //   3	12	270	finally
    //   281	286	296	java/io/IOException
    //   290	294	323	java/io/IOException
    //   12	28	350	finally
    //   33	42	357	finally
    //   47	53	357	finally
    //   63	71	357	finally
    //   81	105	357	finally
    //   134	141	357	finally
    //   3	12	363	java/io/IOException
    //   12	28	372	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */