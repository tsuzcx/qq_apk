package com.tencent.qqmini.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class AssetsUtil
{
  public static final String TAG = "AssetsUtil";
  
  /* Error */
  private static boolean copyAssetToFile(android.content.res.AssetManager paramAssetManager, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 10
    //   9: new 19	java/io/FileOutputStream
    //   12: dup
    //   13: aload_2
    //   14: invokespecial 22	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   17: astore 4
    //   19: aload 4
    //   21: invokevirtual 26	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: invokevirtual 32	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   27: astore 5
    //   29: aload 6
    //   31: astore 7
    //   33: aload 4
    //   35: astore 8
    //   37: aload 5
    //   39: astore 9
    //   41: new 34	java/io/BufferedInputStream
    //   44: dup
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 40	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   50: invokespecial 43	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   53: astore_0
    //   54: sipush 8192
    //   57: newarray byte
    //   59: astore 6
    //   61: aload_0
    //   62: aload 6
    //   64: invokevirtual 47	java/io/BufferedInputStream:read	([B)I
    //   67: istore_3
    //   68: iload_3
    //   69: iconst_m1
    //   70: if_icmpeq +15 -> 85
    //   73: aload 4
    //   75: aload 6
    //   77: iconst_0
    //   78: iload_3
    //   79: invokevirtual 51	java/io/FileOutputStream:write	([BII)V
    //   82: goto -21 -> 61
    //   85: aload_0
    //   86: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   89: goto +54 -> 143
    //   92: astore_0
    //   93: new 56	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   100: astore 6
    //   102: aload 6
    //   104: ldc 59
    //   106: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: aload_1
    //   113: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 6
    //   119: ldc 65
    //   121: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload 6
    //   127: aload_2
    //   128: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: pop
    //   132: ldc 8
    //   134: aload 6
    //   136: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_0
    //   140: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload 4
    //   145: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   148: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   151: aload 5
    //   153: ifnull +8 -> 161
    //   156: aload 5
    //   158: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   161: aload 4
    //   163: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_0
    //   169: new 56	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   176: astore 4
    //   178: aload 4
    //   180: ldc 59
    //   182: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: aload_1
    //   189: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload 4
    //   195: ldc 65
    //   197: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload 4
    //   203: aload_2
    //   204: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 8
    //   210: aload 4
    //   212: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: aload_0
    //   216: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   219: iconst_1
    //   220: ireturn
    //   221: astore_0
    //   222: goto +74 -> 296
    //   225: astore_0
    //   226: new 56	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   233: astore 5
    //   235: aload 5
    //   237: ldc 59
    //   239: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 5
    //   245: aload_1
    //   246: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 5
    //   252: ldc 65
    //   254: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload 5
    //   260: aload_2
    //   261: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: ldc 8
    //   267: aload 5
    //   269: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: aload_0
    //   273: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   276: aload 4
    //   278: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   281: iconst_1
    //   282: ireturn
    //   283: astore_0
    //   284: new 56	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   291: astore 4
    //   293: goto -115 -> 178
    //   296: aload 4
    //   298: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   301: goto +56 -> 357
    //   304: astore 4
    //   306: new 56	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   313: astore 5
    //   315: aload 5
    //   317: ldc 59
    //   319: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 5
    //   325: aload_1
    //   326: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 5
    //   332: ldc 65
    //   334: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 5
    //   340: aload_2
    //   341: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: ldc 8
    //   347: aload 5
    //   349: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: aload 4
    //   354: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   357: aload_0
    //   358: athrow
    //   359: astore 6
    //   361: aload_0
    //   362: astore 7
    //   364: aload 4
    //   366: astore 8
    //   368: aload 5
    //   370: astore 4
    //   372: aload 6
    //   374: astore_0
    //   375: goto +492 -> 867
    //   378: astore 7
    //   380: aload_0
    //   381: astore 10
    //   383: aload 4
    //   385: astore 6
    //   387: aload 5
    //   389: astore_0
    //   390: aload 7
    //   392: astore 4
    //   394: goto +68 -> 462
    //   397: astore 7
    //   399: aload 4
    //   401: astore 6
    //   403: aload 5
    //   405: astore_0
    //   406: aload 7
    //   408: astore 4
    //   410: goto +52 -> 462
    //   413: astore_0
    //   414: aconst_null
    //   415: astore 5
    //   417: aload 4
    //   419: astore 8
    //   421: aload 5
    //   423: astore 4
    //   425: goto +442 -> 867
    //   428: astore 5
    //   430: aconst_null
    //   431: astore_0
    //   432: aload 4
    //   434: astore 6
    //   436: aload 5
    //   438: astore 4
    //   440: goto +22 -> 462
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 8
    //   447: aload 8
    //   449: astore 4
    //   451: goto +416 -> 867
    //   454: astore 4
    //   456: aconst_null
    //   457: astore 6
    //   459: aload 6
    //   461: astore_0
    //   462: aload 10
    //   464: astore 7
    //   466: aload 6
    //   468: astore 8
    //   470: aload_0
    //   471: astore 9
    //   473: new 56	java/lang/StringBuilder
    //   476: dup
    //   477: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   480: astore 5
    //   482: aload 10
    //   484: astore 7
    //   486: aload 6
    //   488: astore 8
    //   490: aload_0
    //   491: astore 9
    //   493: aload 5
    //   495: ldc 59
    //   497: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: pop
    //   501: aload 10
    //   503: astore 7
    //   505: aload 6
    //   507: astore 8
    //   509: aload_0
    //   510: astore 9
    //   512: aload 5
    //   514: aload_1
    //   515: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload 10
    //   521: astore 7
    //   523: aload 6
    //   525: astore 8
    //   527: aload_0
    //   528: astore 9
    //   530: aload 5
    //   532: ldc 65
    //   534: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: pop
    //   538: aload 10
    //   540: astore 7
    //   542: aload 6
    //   544: astore 8
    //   546: aload_0
    //   547: astore 9
    //   549: aload 5
    //   551: aload_2
    //   552: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: aload 10
    //   558: astore 7
    //   560: aload 6
    //   562: astore 8
    //   564: aload_0
    //   565: astore 9
    //   567: ldc 8
    //   569: aload 5
    //   571: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aload 4
    //   576: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   579: aload 10
    //   581: ifnull +64 -> 645
    //   584: aload 10
    //   586: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   589: goto +56 -> 645
    //   592: astore 4
    //   594: new 56	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   601: astore 5
    //   603: aload 5
    //   605: ldc 59
    //   607: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 5
    //   613: aload_1
    //   614: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 5
    //   620: ldc 65
    //   622: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   625: pop
    //   626: aload 5
    //   628: aload_2
    //   629: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   632: pop
    //   633: ldc 8
    //   635: aload 5
    //   637: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: aload 4
    //   642: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   645: aload 6
    //   647: ifnull +213 -> 860
    //   650: aload 6
    //   652: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   655: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   658: aload_0
    //   659: ifnull +7 -> 666
    //   662: aload_0
    //   663: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   666: aload 6
    //   668: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   671: iconst_0
    //   672: ireturn
    //   673: astore 4
    //   675: new 56	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   682: astore_0
    //   683: aload_0
    //   684: ldc 59
    //   686: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload_0
    //   691: aload_1
    //   692: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload_0
    //   697: ldc 65
    //   699: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: pop
    //   703: aload_0
    //   704: aload_2
    //   705: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: ldc 8
    //   711: aload_0
    //   712: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: aload 4
    //   717: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   720: iconst_0
    //   721: ireturn
    //   722: astore_0
    //   723: goto +74 -> 797
    //   726: astore_0
    //   727: new 56	java/lang/StringBuilder
    //   730: dup
    //   731: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   734: astore 4
    //   736: aload 4
    //   738: ldc 59
    //   740: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 4
    //   746: aload_1
    //   747: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: pop
    //   751: aload 4
    //   753: ldc 65
    //   755: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 4
    //   761: aload_2
    //   762: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: ldc 8
    //   768: aload 4
    //   770: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: aload_0
    //   774: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   777: aload 6
    //   779: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   782: iconst_0
    //   783: ireturn
    //   784: astore 4
    //   786: new 56	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   793: astore_0
    //   794: goto -111 -> 683
    //   797: aload 6
    //   799: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   802: goto +56 -> 858
    //   805: astore 4
    //   807: new 56	java/lang/StringBuilder
    //   810: dup
    //   811: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   814: astore 5
    //   816: aload 5
    //   818: ldc 59
    //   820: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: aload 5
    //   826: aload_1
    //   827: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: pop
    //   831: aload 5
    //   833: ldc 65
    //   835: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: pop
    //   839: aload 5
    //   841: aload_2
    //   842: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: pop
    //   846: ldc 8
    //   848: aload 5
    //   850: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: aload 4
    //   855: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   858: aload_0
    //   859: athrow
    //   860: iconst_0
    //   861: ireturn
    //   862: astore_0
    //   863: aload 9
    //   865: astore 4
    //   867: aload 7
    //   869: ifnull +64 -> 933
    //   872: aload 7
    //   874: invokevirtual 54	java/io/BufferedInputStream:close	()V
    //   877: goto +56 -> 933
    //   880: astore 5
    //   882: new 56	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   889: astore 6
    //   891: aload 6
    //   893: ldc 59
    //   895: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload 6
    //   901: aload_1
    //   902: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload 6
    //   908: ldc 65
    //   910: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 6
    //   916: aload_2
    //   917: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: ldc 8
    //   923: aload 6
    //   925: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: aload 5
    //   930: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   933: aload 8
    //   935: ifnull +227 -> 1162
    //   938: aload 8
    //   940: invokevirtual 79	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   943: invokevirtual 84	java/io/FileDescriptor:sync	()V
    //   946: aload 4
    //   948: ifnull +8 -> 956
    //   951: aload 4
    //   953: invokevirtual 89	java/nio/channels/FileLock:release	()V
    //   956: aload 8
    //   958: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   961: goto +201 -> 1162
    //   964: astore 4
    //   966: new 56	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   973: astore 5
    //   975: aload 5
    //   977: ldc 59
    //   979: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: pop
    //   983: aload 5
    //   985: aload_1
    //   986: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   989: pop
    //   990: aload 5
    //   992: ldc 65
    //   994: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload 5
    //   1000: aload_2
    //   1001: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1004: pop
    //   1005: ldc 8
    //   1007: aload 5
    //   1009: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1012: aload 4
    //   1014: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1017: goto +145 -> 1162
    //   1020: astore_0
    //   1021: goto +78 -> 1099
    //   1024: astore 4
    //   1026: new 56	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1033: astore 5
    //   1035: aload 5
    //   1037: ldc 59
    //   1039: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: pop
    //   1043: aload 5
    //   1045: aload_1
    //   1046: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: pop
    //   1050: aload 5
    //   1052: ldc 65
    //   1054: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 5
    //   1060: aload_2
    //   1061: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: ldc 8
    //   1067: aload 5
    //   1069: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1072: aload 4
    //   1074: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1077: aload 8
    //   1079: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   1082: goto +80 -> 1162
    //   1085: astore 4
    //   1087: new 56	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1094: astore 5
    //   1096: goto -121 -> 975
    //   1099: aload 8
    //   1101: invokevirtual 90	java/io/FileOutputStream:close	()V
    //   1104: goto +56 -> 1160
    //   1107: astore 4
    //   1109: new 56	java/lang/StringBuilder
    //   1112: dup
    //   1113: invokespecial 57	java/lang/StringBuilder:<init>	()V
    //   1116: astore 5
    //   1118: aload 5
    //   1120: ldc 59
    //   1122: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1125: pop
    //   1126: aload 5
    //   1128: aload_1
    //   1129: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: pop
    //   1133: aload 5
    //   1135: ldc 65
    //   1137: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: aload 5
    //   1143: aload_2
    //   1144: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: pop
    //   1148: ldc 8
    //   1150: aload 5
    //   1152: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1155: aload 4
    //   1157: invokestatic 75	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1160: aload_0
    //   1161: athrow
    //   1162: goto +5 -> 1167
    //   1165: aload_0
    //   1166: athrow
    //   1167: goto -2 -> 1165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1170	0	paramAssetManager	android.content.res.AssetManager
    //   0	1170	1	paramString1	String
    //   0	1170	2	paramString2	String
    //   67	12	3	i	int
    //   17	280	4	localObject1	Object
    //   304	61	4	localIOException1	java.io.IOException
    //   370	80	4	localObject2	Object
    //   454	121	4	localIOException2	java.io.IOException
    //   592	49	4	localIOException3	java.io.IOException
    //   673	43	4	localIOException4	java.io.IOException
    //   734	35	4	localStringBuilder1	StringBuilder
    //   784	1	4	localIOException5	java.io.IOException
    //   805	49	4	localIOException6	java.io.IOException
    //   865	87	4	localObject3	Object
    //   964	49	4	localIOException7	java.io.IOException
    //   1024	49	4	localIOException8	java.io.IOException
    //   1085	1	4	localIOException9	java.io.IOException
    //   1107	49	4	localIOException10	java.io.IOException
    //   27	395	5	localObject4	Object
    //   428	9	5	localIOException11	java.io.IOException
    //   480	369	5	localStringBuilder2	StringBuilder
    //   880	49	5	localIOException12	java.io.IOException
    //   973	178	5	localStringBuilder3	StringBuilder
    //   1	134	6	localObject5	Object
    //   359	14	6	localObject6	Object
    //   385	539	6	localObject7	Object
    //   4	359	7	localObject8	Object
    //   378	13	7	localIOException13	java.io.IOException
    //   397	10	7	localIOException14	java.io.IOException
    //   464	409	7	localObject9	Object
    //   35	1065	8	localObject10	Object
    //   39	825	9	localObject11	Object
    //   7	578	10	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   85	89	92	java/io/IOException
    //   161	166	168	java/io/IOException
    //   143	151	221	finally
    //   156	161	221	finally
    //   226	276	221	finally
    //   143	151	225	java/io/IOException
    //   156	161	225	java/io/IOException
    //   276	281	283	java/io/IOException
    //   296	301	304	java/io/IOException
    //   54	61	359	finally
    //   61	68	359	finally
    //   73	82	359	finally
    //   54	61	378	java/io/IOException
    //   61	68	378	java/io/IOException
    //   73	82	378	java/io/IOException
    //   41	54	397	java/io/IOException
    //   19	29	413	finally
    //   19	29	428	java/io/IOException
    //   9	19	443	finally
    //   9	19	454	java/io/IOException
    //   584	589	592	java/io/IOException
    //   666	671	673	java/io/IOException
    //   650	658	722	finally
    //   662	666	722	finally
    //   727	777	722	finally
    //   650	658	726	java/io/IOException
    //   662	666	726	java/io/IOException
    //   777	782	784	java/io/IOException
    //   797	802	805	java/io/IOException
    //   41	54	862	finally
    //   473	482	862	finally
    //   493	501	862	finally
    //   512	519	862	finally
    //   530	538	862	finally
    //   549	556	862	finally
    //   567	579	862	finally
    //   872	877	880	java/io/IOException
    //   956	961	964	java/io/IOException
    //   938	946	1020	finally
    //   951	956	1020	finally
    //   1026	1077	1020	finally
    //   938	946	1024	java/io/IOException
    //   951	956	1024	java/io/IOException
    //   1077	1082	1085	java/io/IOException
    //   1099	1104	1107	java/io/IOException
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
              QMLog.e("AssetsUtil", String.format("copyAssetToFile from=%s, to=%s fail", new Object[] { str, localObject }));
              return false;
            }
          }
        }
        return true;
      }
      catch (Throwable paramContext)
      {
        QMLog.e("AssetsUtil", String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", new Object[] { paramString1, paramString2 }), paramContext);
      }
    }
    try
    {
      if (new File(paramString2).exists()) {
        FileUtils.delete(paramString2, false);
      }
      return false;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.AssetsUtil
 * JD-Core Version:    0.7.0.1
 */