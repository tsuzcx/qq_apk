package com.tencent.ttpic.baseutils.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtils
{
  private static final String TAG = "ZipUtils";
  
  /* Error */
  private static void doZip(ZipOutputStream paramZipOutputStream, File paramFile, String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +232 -> 233
    //   4: aload_1
    //   5: ifnull +228 -> 233
    //   8: aload_1
    //   9: invokevirtual 24	java/io/File:exists	()Z
    //   12: ifeq +211 -> 223
    //   15: aload_2
    //   16: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifeq +11 -> 30
    //   22: aload_1
    //   23: invokevirtual 34	java/io/File:getName	()Ljava/lang/String;
    //   26: astore_2
    //   27: goto +44 -> 71
    //   30: new 36	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   37: astore 7
    //   39: aload 7
    //   41: aload_2
    //   42: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload 7
    //   48: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   51: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 7
    //   57: aload_1
    //   58: invokevirtual 34	java/io/File:getName	()Ljava/lang/String;
    //   61: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 7
    //   67: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: astore_2
    //   71: aload_1
    //   72: invokevirtual 50	java/io/File:isFile	()Z
    //   75: istore 6
    //   77: iconst_0
    //   78: istore 4
    //   80: iload 6
    //   82: ifeq +94 -> 176
    //   85: new 52	java/io/BufferedInputStream
    //   88: dup
    //   89: new 54	java/io/FileInputStream
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: invokespecial 60	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore_1
    //   101: aload_0
    //   102: new 62	java/util/zip/ZipEntry
    //   105: dup
    //   106: aload_2
    //   107: invokespecial 65	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   110: invokevirtual 71	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   113: aload_1
    //   114: aload_3
    //   115: iconst_0
    //   116: aload_3
    //   117: arraylength
    //   118: invokevirtual 75	java/io/BufferedInputStream:read	([BII)I
    //   121: istore 4
    //   123: iconst_m1
    //   124: iload 4
    //   126: if_icmpeq +14 -> 140
    //   129: aload_0
    //   130: aload_3
    //   131: iconst_0
    //   132: iload 4
    //   134: invokevirtual 79	java/util/zip/ZipOutputStream:write	([BII)V
    //   137: goto -24 -> 113
    //   140: aload_1
    //   141: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   144: return
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   150: return
    //   151: astore_0
    //   152: goto +6 -> 158
    //   155: astore_0
    //   156: aconst_null
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +15 -> 174
    //   162: aload_1
    //   163: invokevirtual 82	java/io/BufferedInputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   174: aload_0
    //   175: athrow
    //   176: aload_1
    //   177: invokevirtual 88	java/io/File:isDirectory	()Z
    //   180: ifeq +42 -> 222
    //   183: aload_1
    //   184: invokevirtual 92	java/io/File:listFiles	()[Ljava/io/File;
    //   187: astore_1
    //   188: aload_1
    //   189: ifnull +33 -> 222
    //   192: aload_1
    //   193: arraylength
    //   194: istore 5
    //   196: iload 4
    //   198: iload 5
    //   200: if_icmpge +22 -> 222
    //   203: aload_0
    //   204: aload_1
    //   205: iload 4
    //   207: aaload
    //   208: aload_2
    //   209: aload_3
    //   210: invokestatic 94	com/tencent/ttpic/baseutils/zip/ZipUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   213: iload 4
    //   215: iconst_1
    //   216: iadd
    //   217: istore 4
    //   219: goto -23 -> 196
    //   222: return
    //   223: new 96	java/io/FileNotFoundException
    //   226: dup
    //   227: ldc 98
    //   229: invokespecial 99	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   232: athrow
    //   233: new 18	java/io/IOException
    //   236: dup
    //   237: ldc 101
    //   239: invokespecial 102	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   242: astore_0
    //   243: goto +5 -> 248
    //   246: aload_0
    //   247: athrow
    //   248: goto -2 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	paramZipOutputStream	ZipOutputStream
    //   0	251	1	paramFile	File
    //   0	251	2	paramString	String
    //   0	251	3	paramArrayOfByte	byte[]
    //   78	140	4	i	int
    //   194	7	5	j	int
    //   75	6	6	bool	boolean
    //   37	29	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   140	144	145	java/io/IOException
    //   101	113	151	java/io/IOException
    //   113	123	151	java/io/IOException
    //   129	137	151	java/io/IOException
    //   146	150	151	java/io/IOException
    //   85	101	155	java/io/IOException
    //   162	166	169	java/io/IOException
  }
  
  /* Error */
  public static String unZip(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: istore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aconst_null
    //   12: astore 7
    //   14: iload_3
    //   15: ifeq +8 -> 23
    //   18: ldc 2
    //   20: monitorexit
    //   21: aconst_null
    //   22: areturn
    //   23: new 20	java/io/File
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore_0
    //   32: aload_0
    //   33: invokevirtual 24	java/io/File:exists	()Z
    //   36: istore_3
    //   37: iload_3
    //   38: ifne +8 -> 46
    //   41: ldc 2
    //   43: monitorexit
    //   44: aconst_null
    //   45: areturn
    //   46: new 20	java/io/File
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   54: astore 4
    //   56: aload 4
    //   58: invokevirtual 24	java/io/File:exists	()Z
    //   61: ifne +9 -> 70
    //   64: aload 4
    //   66: invokevirtual 108	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: new 54	java/io/FileInputStream
    //   73: dup
    //   74: aload_0
    //   75: invokespecial 57	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   78: astore 8
    //   80: aload 8
    //   82: astore 4
    //   84: new 110	java/util/zip/ZipInputStream
    //   87: dup
    //   88: new 52	java/io/BufferedInputStream
    //   91: dup
    //   92: aload 8
    //   94: invokespecial 60	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   97: invokespecial 111	java/util/zip/ZipInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 10
    //   102: aconst_null
    //   103: astore 4
    //   105: aload 4
    //   107: astore 6
    //   109: aload 6
    //   111: astore_0
    //   112: aload 4
    //   114: astore 5
    //   116: aload 10
    //   118: invokevirtual 115	java/util/zip/ZipInputStream:getNextEntry	()Ljava/util/zip/ZipEntry;
    //   121: astore 7
    //   123: aload 7
    //   125: ifnull +569 -> 694
    //   128: getstatic 117	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   131: astore 4
    //   133: new 36	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   140: astore 9
    //   142: aload 9
    //   144: ldc 119
    //   146: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 9
    //   152: aload 7
    //   154: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: aload 4
    //   160: aload 9
    //   162: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 128	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload 7
    //   170: invokevirtual 129	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   173: astore 4
    //   175: aload 4
    //   177: ldc 131
    //   179: invokevirtual 136	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   182: ifeq +10 -> 192
    //   185: aload 5
    //   187: astore 4
    //   189: goto -77 -> 112
    //   192: aload 7
    //   194: invokevirtual 137	java/util/zip/ZipEntry:isDirectory	()Z
    //   197: ifeq +136 -> 333
    //   200: new 36	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   207: astore 7
    //   209: aload 7
    //   211: aload_1
    //   212: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 7
    //   218: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   221: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: pop
    //   225: aload 7
    //   227: aload 4
    //   229: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 7
    //   235: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: astore 4
    //   240: getstatic 117	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   243: astore 7
    //   245: new 36	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   252: astore 9
    //   254: aload 9
    //   256: ldc 139
    //   258: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 9
    //   264: aload 4
    //   266: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 7
    //   272: aload 9
    //   274: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   277: invokestatic 128	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: new 20	java/io/File
    //   283: dup
    //   284: aload 4
    //   286: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   289: astore 7
    //   291: aload 7
    //   293: invokevirtual 24	java/io/File:exists	()Z
    //   296: ifne +9 -> 305
    //   299: aload 7
    //   301: invokevirtual 108	java/io/File:mkdirs	()Z
    //   304: pop
    //   305: aload 4
    //   307: aconst_null
    //   308: invokestatic 144	com/tencent/ttpic/baseutils/io/FileUtils:deleteFiles	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 5
    //   313: astore 4
    //   315: aload 5
    //   317: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   320: ifeq -208 -> 112
    //   323: aload 7
    //   325: invokevirtual 147	java/io/File:getPath	()Ljava/lang/String;
    //   328: astore 4
    //   330: goto -218 -> 112
    //   333: sipush 4096
    //   336: newarray byte
    //   338: astore 11
    //   340: new 36	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   347: astore 7
    //   349: aload 7
    //   351: aload_1
    //   352: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 7
    //   358: getstatic 44	java/io/File:separator	Ljava/lang/String;
    //   361: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 7
    //   367: aload 4
    //   369: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 7
    //   375: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: astore 4
    //   380: getstatic 117	com/tencent/ttpic/baseutils/zip/ZipUtils:TAG	Ljava/lang/String;
    //   383: astore 7
    //   385: new 36	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   392: astore 9
    //   394: aload 9
    //   396: ldc 149
    //   398: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload 9
    //   404: aload 4
    //   406: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 7
    //   412: aload 9
    //   414: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokestatic 128	com/tencent/ttpic/baseutils/log/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   420: new 20	java/io/File
    //   423: dup
    //   424: aload 4
    //   426: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   429: astore 4
    //   431: new 151	java/io/FileOutputStream
    //   434: dup
    //   435: aload 4
    //   437: invokespecial 152	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   440: astore 4
    //   442: new 154	java/io/BufferedOutputStream
    //   445: dup
    //   446: aload 4
    //   448: sipush 4096
    //   451: invokespecial 157	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   454: astore 6
    //   456: aload 6
    //   458: astore 7
    //   460: aload 4
    //   462: astore 9
    //   464: aload 10
    //   466: aload 11
    //   468: invokevirtual 160	java/util/zip/ZipInputStream:read	([B)I
    //   471: istore_2
    //   472: iload_2
    //   473: iconst_m1
    //   474: if_icmpeq +23 -> 497
    //   477: aload 6
    //   479: astore 7
    //   481: aload 4
    //   483: astore 9
    //   485: aload 6
    //   487: aload 11
    //   489: iconst_0
    //   490: iload_2
    //   491: invokevirtual 161	java/io/BufferedOutputStream:write	([BII)V
    //   494: goto -38 -> 456
    //   497: aload 6
    //   499: astore 7
    //   501: aload 4
    //   503: astore 9
    //   505: aload 6
    //   507: invokevirtual 164	java/io/BufferedOutputStream:flush	()V
    //   510: aload 6
    //   512: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   515: aload 4
    //   517: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   520: aload 6
    //   522: astore 7
    //   524: aload 4
    //   526: astore 6
    //   528: goto +119 -> 647
    //   531: astore 7
    //   533: aload 6
    //   535: astore_0
    //   536: aload 7
    //   538: astore 6
    //   540: goto +95 -> 635
    //   543: astore 7
    //   545: aload 6
    //   547: astore_0
    //   548: aload 7
    //   550: astore 6
    //   552: goto +33 -> 585
    //   555: astore_1
    //   556: goto +13 -> 569
    //   559: astore 6
    //   561: goto +24 -> 585
    //   564: astore_1
    //   565: aload 6
    //   567: astore 4
    //   569: aload_0
    //   570: astore 7
    //   572: goto +90 -> 662
    //   575: astore 7
    //   577: aload 6
    //   579: astore 4
    //   581: aload 7
    //   583: astore 6
    //   585: aload_0
    //   586: astore 7
    //   588: aload 4
    //   590: astore 9
    //   592: aload 6
    //   594: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   597: aload_0
    //   598: ifnull +10 -> 608
    //   601: aload_0
    //   602: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   605: goto +3 -> 608
    //   608: aload_0
    //   609: astore 7
    //   611: aload 4
    //   613: astore 6
    //   615: aload 4
    //   617: ifnull +30 -> 647
    //   620: aload 4
    //   622: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   625: aload_0
    //   626: astore 7
    //   628: aload 4
    //   630: astore 6
    //   632: goto +15 -> 647
    //   635: aload 6
    //   637: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   640: aload 4
    //   642: astore 6
    //   644: aload_0
    //   645: astore 7
    //   647: aload 7
    //   649: astore_0
    //   650: aload 5
    //   652: astore 4
    //   654: goto -542 -> 112
    //   657: astore_1
    //   658: aload 9
    //   660: astore 4
    //   662: aload 7
    //   664: ifnull +11 -> 675
    //   667: aload 7
    //   669: invokevirtual 165	java/io/BufferedOutputStream:close	()V
    //   672: goto +3 -> 675
    //   675: aload 4
    //   677: ifnull +15 -> 692
    //   680: aload 4
    //   682: invokevirtual 166	java/io/FileOutputStream:close	()V
    //   685: goto +7 -> 692
    //   688: aload_0
    //   689: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   692: aload_1
    //   693: athrow
    //   694: aload 10
    //   696: invokevirtual 171	java/util/zip/ZipInputStream:close	()V
    //   699: aload 8
    //   701: invokevirtual 172	java/io/FileInputStream:close	()V
    //   704: goto +109 -> 813
    //   707: astore_1
    //   708: aload 5
    //   710: astore_0
    //   711: aload_1
    //   712: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   715: aload_0
    //   716: astore 5
    //   718: goto +95 -> 813
    //   721: astore_1
    //   722: aload 10
    //   724: astore_0
    //   725: aload 8
    //   727: astore 4
    //   729: goto +94 -> 823
    //   732: astore 6
    //   734: aload 10
    //   736: astore_1
    //   737: aload 5
    //   739: astore_0
    //   740: goto +34 -> 774
    //   743: astore 6
    //   745: aconst_null
    //   746: astore_0
    //   747: aload 7
    //   749: astore_1
    //   750: goto +24 -> 774
    //   753: astore_1
    //   754: aconst_null
    //   755: astore 4
    //   757: aload 4
    //   759: astore_0
    //   760: goto +63 -> 823
    //   763: astore 6
    //   765: aconst_null
    //   766: astore 8
    //   768: aload 8
    //   770: astore_0
    //   771: aload 7
    //   773: astore_1
    //   774: aload_1
    //   775: astore 5
    //   777: aload 8
    //   779: astore 4
    //   781: aload 6
    //   783: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   786: aload_1
    //   787: ifnull +10 -> 797
    //   790: aload_1
    //   791: invokevirtual 171	java/util/zip/ZipInputStream:close	()V
    //   794: goto +3 -> 797
    //   797: aload_0
    //   798: astore 5
    //   800: aload 8
    //   802: ifnull +11 -> 813
    //   805: aload 8
    //   807: invokevirtual 172	java/io/FileInputStream:close	()V
    //   810: aload_0
    //   811: astore 5
    //   813: ldc 2
    //   815: monitorexit
    //   816: aload 5
    //   818: areturn
    //   819: astore_1
    //   820: aload 5
    //   822: astore_0
    //   823: aload_0
    //   824: ifnull +10 -> 834
    //   827: aload_0
    //   828: invokevirtual 171	java/util/zip/ZipInputStream:close	()V
    //   831: goto +3 -> 834
    //   834: aload 4
    //   836: ifnull +15 -> 851
    //   839: aload 4
    //   841: invokevirtual 172	java/io/FileInputStream:close	()V
    //   844: goto +7 -> 851
    //   847: aload_0
    //   848: invokestatic 170	com/tencent/ttpic/baseutils/log/LogUtils:e	(Ljava/lang/Throwable;)V
    //   851: aload_1
    //   852: athrow
    //   853: astore_0
    //   854: ldc 2
    //   856: monitorexit
    //   857: goto +5 -> 862
    //   860: aload_0
    //   861: athrow
    //   862: goto -2 -> 860
    //   865: astore 6
    //   867: goto -232 -> 635
    //   870: astore_0
    //   871: goto -183 -> 688
    //   874: astore_1
    //   875: goto -164 -> 711
    //   878: astore_0
    //   879: goto -32 -> 847
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	paramString1	String
    //   0	882	1	paramString2	String
    //   471	20	2	i	int
    //   7	31	3	bool	boolean
    //   54	786	4	localObject1	Object
    //   9	812	5	localObject2	Object
    //   107	444	6	localObject3	Object
    //   559	19	6	localIOException1	java.io.IOException
    //   583	60	6	localObject4	Object
    //   732	1	6	localIOException2	java.io.IOException
    //   743	1	6	localIOException3	java.io.IOException
    //   763	19	6	localIOException4	java.io.IOException
    //   865	1	6	localIOException5	java.io.IOException
    //   12	511	7	localObject5	Object
    //   531	6	7	localIOException6	java.io.IOException
    //   543	6	7	localIOException7	java.io.IOException
    //   570	1	7	str1	String
    //   575	7	7	localIOException8	java.io.IOException
    //   586	186	7	str2	String
    //   78	728	8	localFileInputStream	java.io.FileInputStream
    //   140	519	9	localObject6	Object
    //   100	635	10	localZipInputStream	ZipInputStream
    //   338	150	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   510	520	531	java/io/IOException
    //   464	472	543	java/io/IOException
    //   485	494	543	java/io/IOException
    //   505	510	543	java/io/IOException
    //   442	456	555	finally
    //   442	456	559	java/io/IOException
    //   431	442	564	finally
    //   431	442	575	java/io/IOException
    //   464	472	657	finally
    //   485	494	657	finally
    //   505	510	657	finally
    //   592	597	657	finally
    //   694	704	707	java/io/IOException
    //   116	123	721	finally
    //   128	185	721	finally
    //   192	305	721	finally
    //   305	311	721	finally
    //   315	330	721	finally
    //   333	431	721	finally
    //   510	520	721	finally
    //   601	605	721	finally
    //   620	625	721	finally
    //   635	640	721	finally
    //   667	672	721	finally
    //   680	685	721	finally
    //   688	692	721	finally
    //   692	694	721	finally
    //   116	123	732	java/io/IOException
    //   128	185	732	java/io/IOException
    //   192	305	732	java/io/IOException
    //   305	311	732	java/io/IOException
    //   315	330	732	java/io/IOException
    //   333	431	732	java/io/IOException
    //   635	640	732	java/io/IOException
    //   688	692	732	java/io/IOException
    //   692	694	732	java/io/IOException
    //   84	102	743	java/io/IOException
    //   70	80	753	finally
    //   70	80	763	java/io/IOException
    //   84	102	819	finally
    //   781	786	819	finally
    //   3	8	853	finally
    //   23	37	853	finally
    //   46	70	853	finally
    //   694	704	853	finally
    //   711	715	853	finally
    //   790	794	853	finally
    //   805	810	853	finally
    //   827	831	853	finally
    //   839	844	853	finally
    //   847	851	853	finally
    //   851	853	853	finally
    //   601	605	865	java/io/IOException
    //   620	625	865	java/io/IOException
    //   667	672	870	java/io/IOException
    //   680	685	870	java/io/IOException
    //   790	794	874	java/io/IOException
    //   805	810	874	java/io/IOException
    //   827	831	878	java/io/IOException
    //   839	844	878	java/io/IOException
  }
  
  public static byte[] unZip(byte[] paramArrayOfByte)
  {
    ZipInputStream localZipInputStream = null;
    ByteArrayOutputStream localByteArrayOutputStream = null;
    Object localObject = localZipInputStream;
    try
    {
      ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
      localObject = localZipInputStream;
      localZipInputStream = new ZipInputStream(localByteArrayInputStream);
      paramArrayOfByte = localByteArrayOutputStream;
      for (;;)
      {
        localObject = paramArrayOfByte;
        if (localZipInputStream.getNextEntry() == null) {
          break;
        }
        localObject = paramArrayOfByte;
        byte[] arrayOfByte = new byte[1024];
        localObject = paramArrayOfByte;
        localByteArrayOutputStream = new ByteArrayOutputStream();
        for (;;)
        {
          localObject = paramArrayOfByte;
          int i = localZipInputStream.read(arrayOfByte, 0, arrayOfByte.length);
          if (i == -1) {
            break;
          }
          localObject = paramArrayOfByte;
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        localObject = paramArrayOfByte;
        paramArrayOfByte = localByteArrayOutputStream.toByteArray();
        localObject = paramArrayOfByte;
        localByteArrayOutputStream.flush();
        localObject = paramArrayOfByte;
        localByteArrayOutputStream.close();
      }
      localObject = paramArrayOfByte;
      localZipInputStream.close();
      localObject = paramArrayOfByte;
      localByteArrayInputStream.close();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localObject;
  }
  
  public static boolean zip(File paramFile1, File paramFile2)
  {
    return zip(new File[] { paramFile1 }, paramFile2);
  }
  
  /* Error */
  public static boolean zip(File[] paramArrayOfFile, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +143 -> 144
    //   4: aload_0
    //   5: arraylength
    //   6: iconst_1
    //   7: if_icmplt +137 -> 144
    //   10: aload_1
    //   11: ifnull +133 -> 144
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 4
    //   20: sipush 4096
    //   23: newarray byte
    //   25: astore 6
    //   27: new 67	java/util/zip/ZipOutputStream
    //   30: dup
    //   31: new 154	java/io/BufferedOutputStream
    //   34: dup
    //   35: new 151	java/io/FileOutputStream
    //   38: dup
    //   39: aload_1
    //   40: iconst_0
    //   41: invokespecial 201	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   44: invokespecial 204	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   47: invokespecial 205	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_1
    //   51: aload_0
    //   52: arraylength
    //   53: istore_3
    //   54: iconst_0
    //   55: istore_2
    //   56: iload_2
    //   57: iload_3
    //   58: if_icmpge +20 -> 78
    //   61: aload_1
    //   62: aload_0
    //   63: iload_2
    //   64: aaload
    //   65: aconst_null
    //   66: aload 6
    //   68: invokestatic 94	com/tencent/ttpic/baseutils/zip/ZipUtils:doZip	(Ljava/util/zip/ZipOutputStream;Ljava/io/File;Ljava/lang/String;[B)V
    //   71: iload_2
    //   72: iconst_1
    //   73: iadd
    //   74: istore_2
    //   75: goto -19 -> 56
    //   78: aload_1
    //   79: invokevirtual 206	java/util/zip/ZipOutputStream:flush	()V
    //   82: aload_1
    //   83: invokevirtual 209	java/util/zip/ZipOutputStream:closeEntry	()V
    //   86: aload_1
    //   87: invokevirtual 210	java/util/zip/ZipOutputStream:close	()V
    //   90: goto +8 -> 98
    //   93: astore_0
    //   94: aload_0
    //   95: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   98: iconst_1
    //   99: ireturn
    //   100: astore_0
    //   101: goto +10 -> 111
    //   104: goto +25 -> 129
    //   107: astore_0
    //   108: aload 4
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +15 -> 127
    //   115: aload_1
    //   116: invokevirtual 210	java/util/zip/ZipOutputStream:close	()V
    //   119: goto +8 -> 127
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   127: aload_0
    //   128: athrow
    //   129: aload_1
    //   130: ifnull +14 -> 144
    //   133: aload_1
    //   134: invokevirtual 210	java/util/zip/ZipOutputStream:close	()V
    //   137: iconst_0
    //   138: ireturn
    //   139: astore_0
    //   140: aload_0
    //   141: invokevirtual 85	java/io/IOException:printStackTrace	()V
    //   144: iconst_0
    //   145: ireturn
    //   146: astore_0
    //   147: aload 5
    //   149: astore_1
    //   150: goto -21 -> 129
    //   153: astore_0
    //   154: goto -50 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramArrayOfFile	File[]
    //   0	157	1	paramFile	File
    //   55	20	2	i	int
    //   53	6	3	j	int
    //   18	91	4	localObject1	Object
    //   15	133	5	localObject2	Object
    //   25	42	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   86	90	93	java/io/IOException
    //   51	54	100	finally
    //   61	71	100	finally
    //   78	86	100	finally
    //   20	51	107	finally
    //   115	119	122	java/io/IOException
    //   133	137	139	java/io/IOException
    //   20	51	146	java/io/IOException
    //   51	54	153	java/io/IOException
    //   61	71	153	java/io/IOException
    //   78	86	153	java/io/IOException
  }
  
  public static byte[] zip(byte[] paramArrayOfByte)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ZipOutputStream localZipOutputStream = new ZipOutputStream(localByteArrayOutputStream);
      ZipEntry localZipEntry = new ZipEntry("placeHolder.dat");
      localZipEntry.setSize(paramArrayOfByte.length);
      localZipOutputStream.putNextEntry(localZipEntry);
      localZipOutputStream.write(paramArrayOfByte);
      localZipOutputStream.closeEntry();
      localZipOutputStream.close();
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.zip.ZipUtils
 * JD-Core Version:    0.7.0.1
 */