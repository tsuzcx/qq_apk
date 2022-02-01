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
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 8
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   16: aload_2
    //   17: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 26
    //   22: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: astore 10
    //   30: new 32	java/io/FileOutputStream
    //   33: dup
    //   34: aload 10
    //   36: invokespecial 35	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   39: astore 5
    //   41: aload 5
    //   43: astore 7
    //   45: aload 9
    //   47: astore 6
    //   49: new 37	java/io/BufferedInputStream
    //   52: dup
    //   53: aload_0
    //   54: aload_1
    //   55: invokevirtual 43	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   58: invokespecial 46	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   61: astore_0
    //   62: sipush 8192
    //   65: newarray byte
    //   67: astore 6
    //   69: aload_0
    //   70: aload 6
    //   72: invokevirtual 50	java/io/BufferedInputStream:read	([B)I
    //   75: istore_3
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpeq +99 -> 177
    //   81: aload 5
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 56	java/io/OutputStream:write	([BII)V
    //   90: goto -21 -> 69
    //   93: astore 6
    //   95: aload_0
    //   96: astore 8
    //   98: aload 6
    //   100: astore_0
    //   101: aload 5
    //   103: astore 7
    //   105: aload 8
    //   107: astore 6
    //   109: ldc 8
    //   111: new 19	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   118: ldc 58
    //   120: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload_1
    //   124: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 60
    //   129: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_2
    //   133: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: aload_0
    //   140: invokestatic 66	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   143: pop
    //   144: aload 8
    //   146: ifnull +8 -> 154
    //   149: aload 8
    //   151: invokevirtual 69	java/io/BufferedInputStream:close	()V
    //   154: aload 5
    //   156: ifnull +19 -> 175
    //   159: aload 5
    //   161: checkcast 32	java/io/FileOutputStream
    //   164: invokevirtual 73	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   167: invokevirtual 78	java/io/FileDescriptor:sync	()V
    //   170: aload 5
    //   172: invokevirtual 79	java/io/OutputStream:close	()V
    //   175: iconst_0
    //   176: ireturn
    //   177: new 81	java/io/File
    //   180: dup
    //   181: aload 10
    //   183: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   186: new 81	java/io/File
    //   189: dup
    //   190: aload_2
    //   191: invokespecial 82	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: invokevirtual 86	java/io/File:renameTo	(Ljava/io/File;)Z
    //   197: istore 4
    //   199: aload_0
    //   200: ifnull +7 -> 207
    //   203: aload_0
    //   204: invokevirtual 69	java/io/BufferedInputStream:close	()V
    //   207: aload 5
    //   209: ifnull +19 -> 228
    //   212: aload 5
    //   214: checkcast 32	java/io/FileOutputStream
    //   217: invokevirtual 73	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   220: invokevirtual 78	java/io/FileDescriptor:sync	()V
    //   223: aload 5
    //   225: invokevirtual 79	java/io/OutputStream:close	()V
    //   228: iload 4
    //   230: ireturn
    //   231: astore_0
    //   232: ldc 8
    //   234: new 19	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   241: ldc 58
    //   243: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 60
    //   252: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_2
    //   256: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 88
    //   261: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   268: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   277: pop
    //   278: goto -71 -> 207
    //   281: astore_0
    //   282: ldc 8
    //   284: new 19	java/lang/StringBuilder
    //   287: dup
    //   288: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   291: ldc 58
    //   293: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc 60
    //   302: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_2
    //   306: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: ldc 88
    //   311: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_0
    //   315: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   318: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   327: pop
    //   328: goto -100 -> 228
    //   331: astore_0
    //   332: ldc 8
    //   334: new 19	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   341: ldc 58
    //   343: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: aload_1
    //   347: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 60
    //   352: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_2
    //   356: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 88
    //   361: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_0
    //   365: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   377: pop
    //   378: aload 5
    //   380: invokevirtual 79	java/io/OutputStream:close	()V
    //   383: goto -155 -> 228
    //   386: astore_0
    //   387: ldc 8
    //   389: new 19	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   396: ldc 58
    //   398: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_1
    //   402: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: ldc 60
    //   407: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: aload_2
    //   411: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: ldc 88
    //   416: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload_0
    //   420: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   423: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   432: pop
    //   433: goto -205 -> 228
    //   436: astore_0
    //   437: aload 5
    //   439: invokevirtual 79	java/io/OutputStream:close	()V
    //   442: aload_0
    //   443: athrow
    //   444: astore 5
    //   446: ldc 8
    //   448: new 19	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   455: ldc 58
    //   457: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_1
    //   461: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc 60
    //   466: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload_2
    //   470: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: ldc 88
    //   475: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload 5
    //   480: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   483: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   489: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   492: pop
    //   493: goto -51 -> 442
    //   496: astore_0
    //   497: ldc 8
    //   499: new 19	java/lang/StringBuilder
    //   502: dup
    //   503: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   506: ldc 58
    //   508: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: ldc 60
    //   517: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_2
    //   521: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc 88
    //   526: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload_0
    //   530: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   533: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   539: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   542: pop
    //   543: goto -389 -> 154
    //   546: astore_0
    //   547: ldc 8
    //   549: new 19	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   556: ldc 58
    //   558: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: aload_1
    //   562: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: ldc 60
    //   567: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: aload_2
    //   571: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: ldc 88
    //   576: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_0
    //   580: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   583: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   592: pop
    //   593: goto -418 -> 175
    //   596: astore_0
    //   597: ldc 8
    //   599: new 19	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   606: ldc 58
    //   608: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: aload_1
    //   612: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: ldc 60
    //   617: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: aload_2
    //   621: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: ldc 88
    //   626: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload_0
    //   630: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   633: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   639: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   642: pop
    //   643: aload 5
    //   645: invokevirtual 79	java/io/OutputStream:close	()V
    //   648: goto -473 -> 175
    //   651: astore_0
    //   652: ldc 8
    //   654: new 19	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   661: ldc 58
    //   663: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_1
    //   667: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: ldc 60
    //   672: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_2
    //   676: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: ldc 88
    //   681: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   684: aload_0
    //   685: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   688: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   697: pop
    //   698: goto -523 -> 175
    //   701: astore_0
    //   702: aload 5
    //   704: invokevirtual 79	java/io/OutputStream:close	()V
    //   707: aload_0
    //   708: athrow
    //   709: astore 5
    //   711: ldc 8
    //   713: new 19	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   720: ldc 58
    //   722: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: aload_1
    //   726: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: ldc 60
    //   731: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_2
    //   735: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: ldc 88
    //   740: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: aload 5
    //   745: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   748: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   754: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   757: pop
    //   758: goto -51 -> 707
    //   761: astore_0
    //   762: aconst_null
    //   763: astore 5
    //   765: aload 6
    //   767: ifnull +8 -> 775
    //   770: aload 6
    //   772: invokevirtual 69	java/io/BufferedInputStream:close	()V
    //   775: aload 5
    //   777: ifnull +19 -> 796
    //   780: aload 5
    //   782: checkcast 32	java/io/FileOutputStream
    //   785: invokevirtual 73	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   788: invokevirtual 78	java/io/FileDescriptor:sync	()V
    //   791: aload 5
    //   793: invokevirtual 79	java/io/OutputStream:close	()V
    //   796: aload_0
    //   797: athrow
    //   798: astore 6
    //   800: ldc 8
    //   802: new 19	java/lang/StringBuilder
    //   805: dup
    //   806: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   809: ldc 58
    //   811: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload_1
    //   815: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: ldc 60
    //   820: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload_2
    //   824: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: ldc 88
    //   829: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 6
    //   834: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   837: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   843: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   846: pop
    //   847: goto -72 -> 775
    //   850: astore 5
    //   852: ldc 8
    //   854: new 19	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   861: ldc 58
    //   863: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_1
    //   867: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc 60
    //   872: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: aload_2
    //   876: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   879: ldc 88
    //   881: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   884: aload 5
    //   886: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   889: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   895: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   898: pop
    //   899: goto -103 -> 796
    //   902: astore 6
    //   904: ldc 8
    //   906: new 19	java/lang/StringBuilder
    //   909: dup
    //   910: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   913: ldc 58
    //   915: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload_1
    //   919: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: ldc 60
    //   924: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: aload_2
    //   928: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: ldc 88
    //   933: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload 6
    //   938: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   941: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   950: pop
    //   951: aload 5
    //   953: invokevirtual 79	java/io/OutputStream:close	()V
    //   956: goto -160 -> 796
    //   959: astore 5
    //   961: ldc 8
    //   963: new 19	java/lang/StringBuilder
    //   966: dup
    //   967: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   970: ldc 58
    //   972: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: aload_1
    //   976: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: ldc 60
    //   981: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: aload_2
    //   985: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: ldc 88
    //   990: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: aload 5
    //   995: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   998: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1007: pop
    //   1008: goto -212 -> 796
    //   1011: astore_0
    //   1012: aload 5
    //   1014: invokevirtual 79	java/io/OutputStream:close	()V
    //   1017: aload_0
    //   1018: athrow
    //   1019: astore 5
    //   1021: ldc 8
    //   1023: new 19	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   1030: ldc 58
    //   1032: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: aload_1
    //   1036: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: ldc 60
    //   1041: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: aload_2
    //   1045: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: ldc 88
    //   1050: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload 5
    //   1055: invokevirtual 91	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1058: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1067: pop
    //   1068: goto -51 -> 1017
    //   1071: astore_0
    //   1072: aload 7
    //   1074: astore 5
    //   1076: goto -311 -> 765
    //   1079: astore 6
    //   1081: aload_0
    //   1082: astore 7
    //   1084: aload 6
    //   1086: astore_0
    //   1087: aload 7
    //   1089: astore 6
    //   1091: goto -326 -> 765
    //   1094: astore_0
    //   1095: aconst_null
    //   1096: astore 5
    //   1098: goto -997 -> 101
    //   1101: astore_0
    //   1102: goto -1001 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1105	0	paramAssetManager	android.content.res.AssetManager
    //   0	1105	1	paramString1	String
    //   0	1105	2	paramString2	String
    //   75	12	3	i	int
    //   197	32	4	bool	boolean
    //   39	399	5	localFileOutputStream	java.io.FileOutputStream
    //   444	259	5	localIOException1	java.io.IOException
    //   709	35	5	localIOException2	java.io.IOException
    //   763	29	5	localObject1	Object
    //   850	102	5	localIOException3	java.io.IOException
    //   959	54	5	localIOException4	java.io.IOException
    //   1019	35	5	localIOException5	java.io.IOException
    //   1074	23	5	localObject2	Object
    //   1	83	6	localObject3	Object
    //   93	6	6	localIOException6	java.io.IOException
    //   107	664	6	localObject4	Object
    //   798	35	6	localIOException7	java.io.IOException
    //   902	35	6	localIOException8	java.io.IOException
    //   1079	6	6	localObject5	Object
    //   1089	1	6	localObject6	Object
    //   43	1045	7	localObject7	Object
    //   7	143	8	localAssetManager	android.content.res.AssetManager
    //   4	42	9	localObject8	Object
    //   28	154	10	str	String
    // Exception table:
    //   from	to	target	type
    //   62	69	93	java/io/IOException
    //   69	76	93	java/io/IOException
    //   81	90	93	java/io/IOException
    //   177	199	93	java/io/IOException
    //   203	207	231	java/io/IOException
    //   223	228	281	java/io/IOException
    //   212	223	331	java/io/IOException
    //   378	383	386	java/io/IOException
    //   212	223	436	finally
    //   332	378	436	finally
    //   437	442	444	java/io/IOException
    //   149	154	496	java/io/IOException
    //   170	175	546	java/io/IOException
    //   159	170	596	java/io/IOException
    //   643	648	651	java/io/IOException
    //   159	170	701	finally
    //   597	643	701	finally
    //   702	707	709	java/io/IOException
    //   9	41	761	finally
    //   770	775	798	java/io/IOException
    //   791	796	850	java/io/IOException
    //   780	791	902	java/io/IOException
    //   951	956	959	java/io/IOException
    //   780	791	1011	finally
    //   904	951	1011	finally
    //   1012	1017	1019	java/io/IOException
    //   49	62	1071	finally
    //   109	144	1071	finally
    //   62	69	1079	finally
    //   69	76	1079	finally
    //   81	90	1079	finally
    //   177	199	1079	finally
    //   9	41	1094	java/io/IOException
    //   49	62	1101	java/io/IOException
  }
  
  /* Error */
  public static String loadFileAsString(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: ifnonnull +8 -> 12
    //   7: aload 4
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: aload_0
    //   13: invokevirtual 102	java/io/File:exists	()Z
    //   16: ifeq +81 -> 97
    //   19: aload_0
    //   20: invokevirtual 105	java/io/File:isDirectory	()Z
    //   23: ifeq +35 -> 58
    //   26: ldc 8
    //   28: new 19	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   35: ldc 107
    //   37: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: ldc 112
    //   46: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: invokevirtual 115	java/io/File:canRead	()Z
    //   62: ifne +67 -> 129
    //   65: ldc 8
    //   67: new 19	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   74: ldc 107
    //   76: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   83: ldc 117
    //   85: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aconst_null
    //   96: areturn
    //   97: ldc 8
    //   99: new 19	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   106: ldc 107
    //   108: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_0
    //   112: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: ldc 119
    //   117: invokevirtual 24	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 94	com/tencent/qqmini/v8rt/engine/Logger:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   126: pop
    //   127: aconst_null
    //   128: areturn
    //   129: new 121	java/io/FileInputStream
    //   132: dup
    //   133: aload_0
    //   134: invokespecial 124	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   137: astore_3
    //   138: new 126	java/io/InputStreamReader
    //   141: dup
    //   142: aload_3
    //   143: ldc 128
    //   145: invokespecial 131	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   148: astore_2
    //   149: aload_0
    //   150: invokevirtual 135	java/io/File:length	()J
    //   153: l2i
    //   154: istore_1
    //   155: iload_1
    //   156: sipush 12288
    //   159: if_icmple +100 -> 259
    //   162: sipush 4096
    //   165: newarray char
    //   167: astore_0
    //   168: new 19	java/lang/StringBuilder
    //   171: dup
    //   172: sipush 12288
    //   175: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   178: astore 5
    //   180: aload_2
    //   181: aload_0
    //   182: invokevirtual 141	java/io/InputStreamReader:read	([C)I
    //   185: istore_1
    //   186: iconst_m1
    //   187: iload_1
    //   188: if_icmpeq +42 -> 230
    //   191: aload 5
    //   193: aload_0
    //   194: iconst_0
    //   195: iload_1
    //   196: invokevirtual 144	java/lang/StringBuilder:append	([CII)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: goto -20 -> 180
    //   203: astore_0
    //   204: aload_2
    //   205: astore_0
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 147	java/io/InputStream:close	()V
    //   214: aload 4
    //   216: astore_3
    //   217: aload_0
    //   218: ifnull -208 -> 10
    //   221: aload_0
    //   222: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   225: aconst_null
    //   226: areturn
    //   227: astore_0
    //   228: aconst_null
    //   229: areturn
    //   230: aload 5
    //   232: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: astore_0
    //   236: aload_3
    //   237: ifnull +7 -> 244
    //   240: aload_3
    //   241: invokevirtual 147	java/io/InputStream:close	()V
    //   244: aload_0
    //   245: astore_3
    //   246: aload_2
    //   247: ifnull -237 -> 10
    //   250: aload_2
    //   251: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   254: aload_0
    //   255: areturn
    //   256: astore_2
    //   257: aload_0
    //   258: areturn
    //   259: iload_1
    //   260: newarray char
    //   262: astore_0
    //   263: new 150	java/lang/String
    //   266: dup
    //   267: aload_0
    //   268: iconst_0
    //   269: aload_2
    //   270: aload_0
    //   271: invokevirtual 141	java/io/InputStreamReader:read	([C)I
    //   274: invokespecial 153	java/lang/String:<init>	([CII)V
    //   277: astore_0
    //   278: goto -42 -> 236
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_3
    //   284: aconst_null
    //   285: astore_2
    //   286: aload_3
    //   287: ifnull +7 -> 294
    //   290: aload_3
    //   291: invokevirtual 147	java/io/InputStream:close	()V
    //   294: aload_2
    //   295: ifnull +7 -> 302
    //   298: aload_2
    //   299: invokevirtual 148	java/io/InputStreamReader:close	()V
    //   302: aload_0
    //   303: athrow
    //   304: astore_3
    //   305: goto -61 -> 244
    //   308: astore_2
    //   309: goto -95 -> 214
    //   312: astore_3
    //   313: goto -19 -> 294
    //   316: astore_2
    //   317: goto -15 -> 302
    //   320: astore_0
    //   321: aconst_null
    //   322: astore_2
    //   323: goto -37 -> 286
    //   326: astore_0
    //   327: goto -41 -> 286
    //   330: astore_0
    //   331: aconst_null
    //   332: astore_0
    //   333: aconst_null
    //   334: astore_3
    //   335: goto -129 -> 206
    //   338: astore_0
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -135 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	344	0	paramFile	File
    //   154	106	1	i	int
    //   148	103	2	localInputStreamReader	java.io.InputStreamReader
    //   256	14	2	localException1	java.lang.Exception
    //   285	14	2	localObject1	Object
    //   308	1	2	localException2	java.lang.Exception
    //   316	1	2	localException3	java.lang.Exception
    //   322	1	2	localObject2	Object
    //   9	282	3	localObject3	Object
    //   304	1	3	localException4	java.lang.Exception
    //   312	1	3	localException5	java.lang.Exception
    //   334	1	3	localObject4	Object
    //   1	214	4	localObject5	Object
    //   178	53	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   149	155	203	java/lang/Exception
    //   162	180	203	java/lang/Exception
    //   180	186	203	java/lang/Exception
    //   191	200	203	java/lang/Exception
    //   230	236	203	java/lang/Exception
    //   259	278	203	java/lang/Exception
    //   221	225	227	java/lang/Exception
    //   250	254	256	java/lang/Exception
    //   129	138	281	finally
    //   240	244	304	java/lang/Exception
    //   210	214	308	java/lang/Exception
    //   290	294	312	java/lang/Exception
    //   298	302	316	java/lang/Exception
    //   138	149	320	finally
    //   149	155	326	finally
    //   162	180	326	finally
    //   180	186	326	finally
    //   191	200	326	finally
    //   230	236	326	finally
    //   259	278	326	finally
    //   129	138	330	java/lang/Exception
    //   138	149	338	java/lang/Exception
  }
  
  public static String loadFileAsString(String paramString)
  {
    File localFile = new File(paramString);
    if ((!localFile.exists()) || (!localFile.isFile()))
    {
      Logger.e("AssetUtil", "can not open file " + paramString);
      return null;
    }
    return loadFileAsString(localFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.v8rt.engine.AssetUtil
 * JD-Core Version:    0.7.0.1
 */