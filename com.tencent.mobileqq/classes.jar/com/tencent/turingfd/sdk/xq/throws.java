package com.tencent.turingfd.sdk.xq;

import android.os.Process;

public class throws
{
  public static final String a = import.a(import.b);
  public static final String b = import.a(import.c);
  public static final String c = import.a(import.d);
  public static final String d = import.a(import.e);
  public static final String e = import.a(import.f);
  public static long f = 0L;
  public static final String[] g = { "^/data/user/\\d+$", "^/data/data$" };
  
  /* Error */
  public static String a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 56	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   7: astore 12
    //   9: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   12: lstore 4
    //   14: new 67	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 68	java/util/ArrayList:<init>	()V
    //   21: astore 13
    //   23: aload_0
    //   24: invokevirtual 74	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   27: invokevirtual 78	android/content/Context:getFilesDir	()Ljava/io/File;
    //   30: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   33: astore 7
    //   35: aload 7
    //   37: ifnonnull +18 -> 55
    //   40: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   43: dup
    //   44: iconst_0
    //   45: ldc 87
    //   47: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   50: astore 7
    //   52: goto +238 -> 290
    //   55: aload 7
    //   57: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   60: astore 8
    //   62: aload 8
    //   64: ifnonnull +18 -> 82
    //   67: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   70: dup
    //   71: iconst_0
    //   72: ldc 87
    //   74: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   77: astore 7
    //   79: goto +211 -> 290
    //   82: getstatic 52	com/tencent/turingfd/sdk/xq/throws:g	[Ljava/lang/String;
    //   85: astore 9
    //   87: aload 9
    //   89: arraylength
    //   90: istore_2
    //   91: iconst_0
    //   92: istore_1
    //   93: iload_1
    //   94: iload_2
    //   95: if_icmpge +37 -> 132
    //   98: aload 9
    //   100: iload_1
    //   101: aaload
    //   102: invokestatic 96	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   105: aload 8
    //   107: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokevirtual 104	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   113: invokevirtual 110	java/util/regex/Matcher:find	()Z
    //   116: ifeq +9 -> 125
    //   119: iconst_0
    //   120: istore 6
    //   122: goto +13 -> 135
    //   125: iload_1
    //   126: iconst_1
    //   127: iadd
    //   128: istore_1
    //   129: goto -36 -> 93
    //   132: iconst_1
    //   133: istore 6
    //   135: aload 7
    //   137: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   140: astore 9
    //   142: aload_0
    //   143: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   146: astore 8
    //   148: aload 9
    //   150: ldc 115
    //   152: bipush 6
    //   154: invokevirtual 119	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   157: astore 10
    //   159: aload 9
    //   161: ldc 121
    //   163: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   166: ifeq +29 -> 195
    //   169: aload 10
    //   171: arraylength
    //   172: iconst_4
    //   173: if_icmplt +22 -> 195
    //   176: aload 10
    //   178: iconst_3
    //   179: aaload
    //   180: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   183: ifne +12 -> 195
    //   186: aload 10
    //   188: iconst_3
    //   189: aaload
    //   190: astore 7
    //   192: goto +48 -> 240
    //   195: aload 8
    //   197: astore 7
    //   199: aload 9
    //   201: ldc 133
    //   203: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   206: ifeq +34 -> 240
    //   209: aload 8
    //   211: astore 7
    //   213: aload 10
    //   215: arraylength
    //   216: iconst_5
    //   217: if_icmplt +23 -> 240
    //   220: aload 8
    //   222: astore 7
    //   224: aload 10
    //   226: iconst_4
    //   227: aaload
    //   228: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   231: ifne +9 -> 240
    //   234: aload 10
    //   236: iconst_4
    //   237: aaload
    //   238: astore 7
    //   240: iload 6
    //   242: ifeq +35 -> 277
    //   245: aload 7
    //   247: aload_0
    //   248: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   251: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   254: ifne +23 -> 277
    //   257: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   260: dup
    //   261: iload 6
    //   263: aload_0
    //   264: aload 7
    //   266: invokestatic 140	com/tencent/turingfd/sdk/xq/throws:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   269: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   272: astore 7
    //   274: goto +16 -> 290
    //   277: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   280: dup
    //   281: iload 6
    //   283: ldc 87
    //   285: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   288: astore 7
    //   290: aload 7
    //   292: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   295: ifeq +88 -> 383
    //   298: aload 7
    //   300: getfield 144	com/tencent/turingfd/sdk/xq/throws$do:b	Ljava/lang/String;
    //   303: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +77 -> 383
    //   309: iconst_0
    //   310: iconst_1
    //   311: iconst_0
    //   312: invokestatic 149	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   315: istore_2
    //   316: new 151	com/tencent/turingfd/sdk/xq/Lynx
    //   319: dup
    //   320: invokespecial 152	com/tencent/turingfd/sdk/xq/Lynx:<init>	()V
    //   323: astore 8
    //   325: new 56	java/lang/StringBuilder
    //   328: dup
    //   329: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   332: astore 9
    //   334: aload 9
    //   336: getstatic 26	com/tencent/turingfd/sdk/xq/throws:a	Ljava/lang/String;
    //   339: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: pop
    //   343: aload 9
    //   345: getstatic 34	com/tencent/turingfd/sdk/xq/throws:c	Ljava/lang/String;
    //   348: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload 8
    //   354: aload 9
    //   356: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   359: putfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   362: aload 8
    //   364: aload 7
    //   366: getfield 144	com/tencent/turingfd/sdk/xq/throws$do:b	Ljava/lang/String;
    //   369: putfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   372: aload 13
    //   374: aload 8
    //   376: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   379: pop
    //   380: goto +10 -> 390
    //   383: iconst_0
    //   384: iconst_0
    //   385: iconst_0
    //   386: invokestatic 149	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   389: istore_2
    //   390: aload_0
    //   391: invokevirtual 74	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   394: astore 14
    //   396: aload 14
    //   398: ifnonnull +18 -> 416
    //   401: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   404: dup
    //   405: iconst_0
    //   406: ldc 87
    //   408: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   411: astore 7
    //   413: goto +507 -> 920
    //   416: iconst_m1
    //   417: istore_1
    //   418: new 166	java/io/FileReader
    //   421: dup
    //   422: ldc 168
    //   424: invokespecial 171	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   427: astore 7
    //   429: new 173	java/io/BufferedReader
    //   432: dup
    //   433: aload 7
    //   435: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   438: astore 9
    //   440: aload 9
    //   442: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   445: astore 11
    //   447: aload 7
    //   449: astore 8
    //   451: aload 9
    //   453: astore 10
    //   455: aload 11
    //   457: ifnull +266 -> 723
    //   460: aload 11
    //   462: bipush 47
    //   464: invokevirtual 183	java/lang/String:indexOf	(I)I
    //   467: istore_3
    //   468: iload_3
    //   469: iload_1
    //   470: if_icmpne +6 -> 476
    //   473: goto +1367 -> 1840
    //   476: aload 11
    //   478: iload_3
    //   479: invokevirtual 187	java/lang/String:substring	(I)Ljava/lang/String;
    //   482: invokevirtual 190	java/lang/String:trim	()Ljava/lang/String;
    //   485: astore 8
    //   487: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   490: istore_1
    //   491: iload_1
    //   492: bipush 23
    //   494: if_icmpge +146 -> 640
    //   497: aload 8
    //   499: ldc 198
    //   501: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   504: ifne +6 -> 510
    //   507: goto +1336 -> 1843
    //   510: aload 8
    //   512: ldc 200
    //   514: invokevirtual 203	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   517: ifne +6 -> 523
    //   520: goto +1323 -> 1843
    //   523: aload 8
    //   525: bipush 47
    //   527: invokevirtual 206	java/lang/String:lastIndexOf	(I)I
    //   530: istore_3
    //   531: iconst_m1
    //   532: istore_1
    //   533: iload_3
    //   534: iconst_m1
    //   535: if_icmpne +6 -> 541
    //   538: goto +1302 -> 1840
    //   541: aload 8
    //   543: iload_3
    //   544: aload 8
    //   546: invokevirtual 210	java/lang/String:length	()I
    //   549: bipush 12
    //   551: isub
    //   552: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   555: bipush 64
    //   557: bipush 47
    //   559: invokevirtual 217	java/lang/String:replace	(CC)Ljava/lang/String;
    //   562: astore 8
    //   564: aload 8
    //   566: ldc 219
    //   568: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   571: ifne +6 -> 577
    //   574: goto +1269 -> 1843
    //   577: new 80	java/io/File
    //   580: dup
    //   581: aload 8
    //   583: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   586: astore 11
    //   588: ldc 222
    //   590: aload 11
    //   592: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   595: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   598: ifeq +32 -> 630
    //   601: aload 7
    //   603: astore 8
    //   605: aload 9
    //   607: astore 10
    //   609: aload 11
    //   611: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   614: ifnull +109 -> 723
    //   617: aload 11
    //   619: invokevirtual 83	java/io/File:getParentFile	()Ljava/io/File;
    //   622: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   625: astore 8
    //   627: goto +62 -> 689
    //   630: aload 11
    //   632: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   635: astore 8
    //   637: goto +52 -> 689
    //   640: aload 8
    //   642: ldc 219
    //   644: invokevirtual 125	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   647: ifne +6 -> 653
    //   650: goto +1193 -> 1843
    //   653: aload 8
    //   655: ldc 227
    //   657: invokevirtual 203	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   660: ifne +6 -> 666
    //   663: goto +1180 -> 1843
    //   666: aload 8
    //   668: ldc 115
    //   670: invokevirtual 230	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   673: astore 8
    //   675: aload 8
    //   677: arraylength
    //   678: bipush 7
    //   680: if_icmplt +1163 -> 1843
    //   683: aload 8
    //   685: iconst_3
    //   686: aaload
    //   687: astore 8
    //   689: goto +49 -> 738
    //   692: astore 8
    //   694: goto +16 -> 710
    //   697: astore 8
    //   699: goto +8 -> 707
    //   702: astore 8
    //   704: aconst_null
    //   705: astore 7
    //   707: aconst_null
    //   708: astore 9
    //   710: aload 8
    //   712: invokevirtual 235	java/lang/Throwable:printStackTrace	()V
    //   715: aload 9
    //   717: astore 10
    //   719: aload 7
    //   721: astore 8
    //   723: aconst_null
    //   724: astore 11
    //   726: aload 10
    //   728: astore 9
    //   730: aload 8
    //   732: astore 7
    //   734: aload 11
    //   736: astore 8
    //   738: aload 7
    //   740: invokestatic 238	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   743: aload 9
    //   745: invokestatic 238	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   748: aload 14
    //   750: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   753: astore 9
    //   755: aload 8
    //   757: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   760: ifne +115 -> 875
    //   763: aload 8
    //   765: ldc 240
    //   767: invokevirtual 243	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   770: istore_1
    //   771: iload_1
    //   772: iconst_m1
    //   773: if_icmpne +6 -> 779
    //   776: goto +99 -> 875
    //   779: aload 8
    //   781: iconst_0
    //   782: iload_1
    //   783: invokevirtual 213	java/lang/String:substring	(II)Ljava/lang/String;
    //   786: astore 7
    //   788: aload 7
    //   790: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   793: ifeq +6 -> 799
    //   796: goto +79 -> 875
    //   799: new 56	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   806: astore 8
    //   808: aload 8
    //   810: ldc 121
    //   812: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 8
    //   818: aload 7
    //   820: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: pop
    //   824: new 80	java/io/File
    //   827: dup
    //   828: aload 8
    //   830: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   833: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   836: astore 8
    //   838: aload 8
    //   840: invokevirtual 246	java/io/File:exists	()Z
    //   843: ifeq +14 -> 857
    //   846: aload 8
    //   848: invokevirtual 249	java/io/File:canWrite	()Z
    //   851: ifeq +6 -> 857
    //   854: goto +7 -> 861
    //   857: aload 9
    //   859: astore 7
    //   861: aload 9
    //   863: aload 7
    //   865: invokestatic 252	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   868: iconst_1
    //   869: ixor
    //   870: istore 6
    //   872: goto +10 -> 882
    //   875: iconst_0
    //   876: istore 6
    //   878: aload 9
    //   880: astore 7
    //   882: iload 6
    //   884: ifeq +23 -> 907
    //   887: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   890: dup
    //   891: iload 6
    //   893: aload_0
    //   894: aload 7
    //   896: invokestatic 140	com/tencent/turingfd/sdk/xq/throws:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   899: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   902: astore 7
    //   904: goto +16 -> 920
    //   907: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   910: dup
    //   911: iload 6
    //   913: ldc 87
    //   915: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   918: astore 7
    //   920: iload_2
    //   921: aload 7
    //   923: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   926: iconst_1
    //   927: invokestatic 149	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   930: istore_1
    //   931: aload 7
    //   933: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   936: ifeq +67 -> 1003
    //   939: new 151	com/tencent/turingfd/sdk/xq/Lynx
    //   942: dup
    //   943: invokespecial 152	com/tencent/turingfd/sdk/xq/Lynx:<init>	()V
    //   946: astore 8
    //   948: new 56	java/lang/StringBuilder
    //   951: dup
    //   952: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   955: astore 9
    //   957: aload 9
    //   959: getstatic 26	com/tencent/turingfd/sdk/xq/throws:a	Ljava/lang/String;
    //   962: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: pop
    //   966: aload 9
    //   968: getstatic 38	com/tencent/turingfd/sdk/xq/throws:d	Ljava/lang/String;
    //   971: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: pop
    //   975: aload 8
    //   977: aload 9
    //   979: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: putfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   985: aload 8
    //   987: aload 7
    //   989: getfield 144	com/tencent/turingfd/sdk/xq/throws$do:b	Ljava/lang/String;
    //   992: putfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   995: aload 13
    //   997: aload 8
    //   999: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1002: pop
    //   1003: getstatic 196	android/os/Build$VERSION:SDK_INT	I
    //   1006: bipush 17
    //   1008: if_icmpge +18 -> 1026
    //   1011: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   1014: dup
    //   1015: iconst_0
    //   1016: ldc 87
    //   1018: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   1021: astore 7
    //   1023: goto +362 -> 1385
    //   1026: new 56	java/lang/StringBuilder
    //   1029: dup
    //   1030: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1033: astore 8
    //   1035: getstatic 257	android/os/Build:BRAND	Ljava/lang/String;
    //   1038: astore 7
    //   1040: ldc_w 259
    //   1043: aload 7
    //   1045: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1048: ifeq +153 -> 1201
    //   1051: ldc_w 264
    //   1054: invokestatic 270	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   1057: astore 7
    //   1059: aload_0
    //   1060: invokevirtual 274	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1063: ldc_w 276
    //   1066: invokevirtual 280	java/lang/Class:getField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   1069: astore 9
    //   1071: aload 9
    //   1073: iconst_1
    //   1074: invokevirtual 286	java/lang/reflect/Field:setAccessible	(Z)V
    //   1077: aload_0
    //   1078: aload 9
    //   1080: aload_0
    //   1081: invokevirtual 290	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1084: checkcast 46	java/lang/String
    //   1087: invokevirtual 294	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   1090: astore 9
    //   1092: aload 9
    //   1094: ifnonnull +6 -> 1100
    //   1097: goto +50 -> 1147
    //   1100: aload 7
    //   1102: ldc_w 296
    //   1105: iconst_0
    //   1106: anewarray 266	java/lang/Class
    //   1109: invokevirtual 300	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   1112: astore 7
    //   1114: aload 7
    //   1116: ifnonnull +6 -> 1122
    //   1119: goto +28 -> 1147
    //   1122: aload 7
    //   1124: iconst_1
    //   1125: invokevirtual 303	java/lang/reflect/Method:setAccessible	(Z)V
    //   1128: aload 7
    //   1130: aload 9
    //   1132: iconst_0
    //   1133: anewarray 4	java/lang/Object
    //   1136: invokevirtual 307	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   1139: checkcast 46	java/lang/String
    //   1142: astore 7
    //   1144: goto +7 -> 1151
    //   1147: ldc 87
    //   1149: astore 7
    //   1151: new 46	java/lang/String
    //   1154: dup
    //   1155: ldc_w 309
    //   1158: iconst_0
    //   1159: invokestatic 315	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   1162: invokespecial 318	java/lang/String:<init>	([B)V
    //   1165: astore 9
    //   1167: aload 7
    //   1169: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1172: ifne +194 -> 1366
    //   1175: aload 9
    //   1177: aload 7
    //   1179: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1182: istore 6
    //   1184: iload 6
    //   1186: ifeq +180 -> 1366
    //   1189: aload 8
    //   1191: ldc_w 320
    //   1194: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: pop
    //   1198: goto +29 -> 1227
    //   1201: ldc_w 322
    //   1204: aload 7
    //   1206: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1209: ifeq +24 -> 1233
    //   1212: invokestatic 324	com/tencent/turingfd/sdk/xq/throws:a	()Z
    //   1215: ifeq +151 -> 1366
    //   1218: aload 8
    //   1220: ldc_w 326
    //   1223: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: pop
    //   1227: iconst_1
    //   1228: istore 6
    //   1230: goto +139 -> 1369
    //   1233: ldc_w 328
    //   1236: aload 7
    //   1238: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1241: ifeq +21 -> 1262
    //   1244: invokestatic 324	com/tencent/turingfd/sdk/xq/throws:a	()Z
    //   1247: ifeq +119 -> 1366
    //   1250: aload 8
    //   1252: ldc_w 330
    //   1255: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: pop
    //   1259: goto -32 -> 1227
    //   1262: ldc_w 332
    //   1265: aload 7
    //   1267: invokevirtual 262	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1270: ifeq +96 -> 1366
    //   1273: invokestatic 324	com/tencent/turingfd/sdk/xq/throws:a	()Z
    //   1276: ifeq +15 -> 1291
    //   1279: aload 8
    //   1281: ldc_w 334
    //   1284: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1287: pop
    //   1288: goto -61 -> 1227
    //   1291: new 46	java/lang/String
    //   1294: dup
    //   1295: ldc_w 336
    //   1298: invokestatic 341	com/tencent/turingfd/sdk/xq/instanceof:a	(Ljava/lang/String;)[B
    //   1301: invokespecial 318	java/lang/String:<init>	([B)V
    //   1304: astore 7
    //   1306: new 56	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1313: astore 9
    //   1315: aload 9
    //   1317: aload_0
    //   1318: invokevirtual 74	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   1321: invokevirtual 113	android/content/Context:getPackageName	()Ljava/lang/String;
    //   1324: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1327: pop
    //   1328: aload 9
    //   1330: ldc_w 343
    //   1333: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: pop
    //   1337: aload 7
    //   1339: aload 9
    //   1341: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1344: invokevirtual 346	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1347: istore 6
    //   1349: iload 6
    //   1351: ifeq +15 -> 1366
    //   1354: aload 8
    //   1356: ldc_w 348
    //   1359: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: pop
    //   1363: goto -136 -> 1227
    //   1366: iconst_0
    //   1367: istore 6
    //   1369: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   1372: dup
    //   1373: iload 6
    //   1375: aload 8
    //   1377: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   1383: astore 7
    //   1385: iload_1
    //   1386: aload 7
    //   1388: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   1391: iconst_2
    //   1392: invokestatic 149	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   1395: istore_2
    //   1396: aload 7
    //   1398: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   1401: ifeq +67 -> 1468
    //   1404: new 151	com/tencent/turingfd/sdk/xq/Lynx
    //   1407: dup
    //   1408: invokespecial 152	com/tencent/turingfd/sdk/xq/Lynx:<init>	()V
    //   1411: astore 8
    //   1413: new 56	java/lang/StringBuilder
    //   1416: dup
    //   1417: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1420: astore 9
    //   1422: aload 9
    //   1424: getstatic 26	com/tencent/turingfd/sdk/xq/throws:a	Ljava/lang/String;
    //   1427: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1430: pop
    //   1431: aload 9
    //   1433: getstatic 42	com/tencent/turingfd/sdk/xq/throws:e	Ljava/lang/String;
    //   1436: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1439: pop
    //   1440: aload 8
    //   1442: aload 9
    //   1444: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1447: putfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   1450: aload 8
    //   1452: aload 7
    //   1454: getfield 144	com/tencent/turingfd/sdk/xq/throws$do:b	Ljava/lang/String;
    //   1457: putfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   1460: aload 13
    //   1462: aload 8
    //   1464: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1467: pop
    //   1468: new 350	android/util/SparseArray
    //   1471: dup
    //   1472: invokespecial 351	android/util/SparseArray:<init>	()V
    //   1475: pop
    //   1476: new 350	android/util/SparseArray
    //   1479: dup
    //   1480: invokespecial 351	android/util/SparseArray:<init>	()V
    //   1483: aload_0
    //   1484: sipush 206
    //   1487: invokestatic 356	com/tencent/turingfd/sdk/xq/TNative$aa:d	(Landroid/util/SparseArray;Landroid/content/Context;I)Landroid/util/SparseArray;
    //   1490: sipush 206
    //   1493: ldc 46
    //   1495: invokestatic 359	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   1498: checkcast 46	java/lang/String
    //   1501: astore 8
    //   1503: aload 8
    //   1505: astore_0
    //   1506: aload 8
    //   1508: ifnonnull +6 -> 1514
    //   1511: ldc 87
    //   1513: astore_0
    //   1514: aload_0
    //   1515: invokestatic 364	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1518: istore_1
    //   1519: goto +5 -> 1524
    //   1522: iconst_0
    //   1523: istore_1
    //   1524: iload_1
    //   1525: ifle +17 -> 1542
    //   1528: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   1531: dup
    //   1532: iconst_1
    //   1533: ldc 87
    //   1535: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   1538: astore_0
    //   1539: goto +14 -> 1553
    //   1542: new 85	com/tencent/turingfd/sdk/xq/throws$do
    //   1545: dup
    //   1546: iconst_0
    //   1547: ldc 87
    //   1549: invokespecial 90	com/tencent/turingfd/sdk/xq/throws$do:<init>	(ZLjava/lang/String;)V
    //   1552: astore_0
    //   1553: iload_2
    //   1554: aload_0
    //   1555: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   1558: iconst_4
    //   1559: invokestatic 149	com/tencent/turingfd/sdk/xq/const:a	(IZI)I
    //   1562: istore_1
    //   1563: aload_0
    //   1564: getfield 143	com/tencent/turingfd/sdk/xq/throws$do:a	Z
    //   1567: ifeq +63 -> 1630
    //   1570: new 151	com/tencent/turingfd/sdk/xq/Lynx
    //   1573: dup
    //   1574: invokespecial 152	com/tencent/turingfd/sdk/xq/Lynx:<init>	()V
    //   1577: astore_0
    //   1578: new 56	java/lang/StringBuilder
    //   1581: dup
    //   1582: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1585: astore 8
    //   1587: aload 8
    //   1589: getstatic 26	com/tencent/turingfd/sdk/xq/throws:a	Ljava/lang/String;
    //   1592: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: pop
    //   1596: aload 8
    //   1598: ldc_w 366
    //   1601: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: pop
    //   1605: aload_0
    //   1606: aload 8
    //   1608: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1611: putfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   1614: aload_0
    //   1615: aload 7
    //   1617: getfield 144	com/tencent/turingfd/sdk/xq/throws$do:b	Ljava/lang/String;
    //   1620: putfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   1623: aload 13
    //   1625: aload_0
    //   1626: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1629: pop
    //   1630: iload_1
    //   1631: ifle +87 -> 1718
    //   1634: new 151	com/tencent/turingfd/sdk/xq/Lynx
    //   1637: dup
    //   1638: invokespecial 152	com/tencent/turingfd/sdk/xq/Lynx:<init>	()V
    //   1641: astore_0
    //   1642: new 56	java/lang/StringBuilder
    //   1645: dup
    //   1646: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1649: astore 7
    //   1651: aload 7
    //   1653: getstatic 26	com/tencent/turingfd/sdk/xq/throws:a	Ljava/lang/String;
    //   1656: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1659: pop
    //   1660: aload 7
    //   1662: getstatic 30	com/tencent/turingfd/sdk/xq/throws:b	Ljava/lang/String;
    //   1665: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1668: pop
    //   1669: aload_0
    //   1670: aload 7
    //   1672: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: putfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   1678: new 56	java/lang/StringBuilder
    //   1681: dup
    //   1682: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   1685: astore 7
    //   1687: aload 7
    //   1689: ldc 87
    //   1691: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: pop
    //   1695: aload 7
    //   1697: iload_1
    //   1698: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1701: pop
    //   1702: aload_0
    //   1703: aload 7
    //   1705: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1708: putfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   1711: aload 13
    //   1713: aload_0
    //   1714: invokevirtual 164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1717: pop
    //   1718: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   1721: lload 4
    //   1723: lsub
    //   1724: putstatic 44	com/tencent/turingfd/sdk/xq/throws:f	J
    //   1727: aload 13
    //   1729: invokevirtual 373	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1732: astore_0
    //   1733: aload_0
    //   1734: invokeinterface 378 1 0
    //   1739: ifeq +57 -> 1796
    //   1742: aload_0
    //   1743: invokeinterface 382 1 0
    //   1748: checkcast 151	com/tencent/turingfd/sdk/xq/Lynx
    //   1751: astore 7
    //   1753: aload 12
    //   1755: aload 7
    //   1757: getfield 160	com/tencent/turingfd/sdk/xq/Lynx:a	Ljava/lang/String;
    //   1760: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1763: pop
    //   1764: aload 12
    //   1766: ldc_w 384
    //   1769: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1772: pop
    //   1773: aload 12
    //   1775: aload 7
    //   1777: getfield 161	com/tencent/turingfd/sdk/xq/Lynx:b	Ljava/lang/String;
    //   1780: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1783: pop
    //   1784: aload 12
    //   1786: ldc_w 386
    //   1789: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: pop
    //   1793: goto -60 -> 1733
    //   1796: aload 12
    //   1798: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: areturn
    //   1802: astore_0
    //   1803: aload 7
    //   1805: invokestatic 238	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   1808: aload 9
    //   1810: invokestatic 238	com/tencent/turingfd/sdk/xq/const:a	(Ljava/io/Closeable;)V
    //   1813: goto +5 -> 1818
    //   1816: aload_0
    //   1817: athrow
    //   1818: goto -2 -> 1816
    //   1821: astore 7
    //   1823: goto -676 -> 1147
    //   1826: astore 7
    //   1828: goto -462 -> 1366
    //   1831: astore 7
    //   1833: goto -606 -> 1227
    //   1836: astore_0
    //   1837: goto -315 -> 1522
    //   1840: goto -1400 -> 440
    //   1843: iconst_m1
    //   1844: istore_1
    //   1845: goto -5 -> 1840
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1848	0	paramContext	android.content.Context
    //   92	1753	1	i	int
    //   90	1464	2	j	int
    //   467	77	3	k	int
    //   12	1710	4	l	long
    //   120	1254	6	bool	boolean
    //   33	1771	7	localObject1	Object
    //   1821	1	7	localObject2	Object
    //   1826	1	7	localObject3	Object
    //   1831	1	7	localObject4	Object
    //   60	628	8	localObject5	Object
    //   692	1	8	localObject6	Object
    //   697	1	8	localObject7	Object
    //   702	9	8	localObject8	Object
    //   721	886	8	localObject9	Object
    //   85	1724	9	localObject10	Object
    //   157	570	10	localObject11	Object
    //   445	290	11	localObject12	Object
    //   7	1790	12	localStringBuilder	java.lang.StringBuilder
    //   21	1707	13	localArrayList	java.util.ArrayList
    //   394	355	14	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   440	447	692	finally
    //   460	468	692	finally
    //   476	491	692	finally
    //   497	507	692	finally
    //   510	520	692	finally
    //   523	531	692	finally
    //   541	574	692	finally
    //   577	588	692	finally
    //   588	601	692	finally
    //   609	627	692	finally
    //   630	637	692	finally
    //   640	650	692	finally
    //   653	663	692	finally
    //   666	683	692	finally
    //   429	440	697	finally
    //   418	429	702	finally
    //   710	715	1802	finally
    //   1051	1092	1821	finally
    //   1100	1114	1821	finally
    //   1122	1144	1821	finally
    //   1151	1184	1826	finally
    //   1291	1349	1826	finally
    //   1189	1198	1831	finally
    //   1354	1363	1831	finally
    //   1476	1503	1836	finally
    //   1514	1519	1836	finally
  }
  
  /* Error */
  public static String a(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 56	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 59	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: aload_1
    //   12: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload 6
    //   18: ldc_w 390
    //   21: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_0
    //   26: invokevirtual 394	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   29: astore_0
    //   30: aload_0
    //   31: aload_1
    //   32: iconst_0
    //   33: invokevirtual 400	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   36: getfield 405	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   39: astore_0
    //   40: goto +6 -> 46
    //   43: ldc 87
    //   45: astore_0
    //   46: aload 6
    //   48: new 80	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: invokestatic 410	com/tencent/turingfd/sdk/xq/Andromeda:a	(Ljava/io/File;)Ljava/util/List;
    //   59: checkcast 67	java/util/ArrayList
    //   62: iconst_0
    //   63: invokevirtual 413	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   66: checkcast 46	java/lang/String
    //   69: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: goto +11 -> 84
    //   76: aload 6
    //   78: ldc 87
    //   80: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 6
    //   86: ldc_w 390
    //   89: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc2_w 414
    //   96: lstore 4
    //   98: lload 4
    //   100: lstore_2
    //   101: aload_0
    //   102: invokestatic 131	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: ifne +27 -> 132
    //   108: new 80	java/io/File
    //   111: dup
    //   112: aload_0
    //   113: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore_0
    //   117: lload 4
    //   119: lstore_2
    //   120: aload_0
    //   121: invokevirtual 246	java/io/File:exists	()Z
    //   124: ifeq +8 -> 132
    //   127: aload_0
    //   128: invokevirtual 417	java/io/File:length	()J
    //   131: lstore_2
    //   132: aload 6
    //   134: lload_2
    //   135: invokevirtual 420	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 6
    //   141: ldc_w 390
    //   144: invokevirtual 156	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: invokestatic 425	android/os/Process:myUid	()I
    //   153: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload 6
    //   159: invokevirtual 159	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: areturn
    //   163: astore_0
    //   164: goto -121 -> 43
    //   167: astore_1
    //   168: goto -92 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramContext	android.content.Context
    //   0	171	1	paramString	String
    //   100	35	2	l1	long
    //   96	22	4	l2	long
    //   7	151	6	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	40	163	android/content/pm/PackageManager$NameNotFoundException
    //   46	73	167	finally
  }
  
  public static boolean a()
  {
    try
    {
      int i = Process.myUid() / 100000;
      if (999 == i) {
        return true;
      }
    }
    finally
    {
      label17:
      break label17;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.throws
 * JD-Core Version:    0.7.0.1
 */