package com.tencent.turingfd.sdk.xq;

import android.util.LruCache;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class Carambola
{
  public static Set<Integer> a = new HashSet();
  public static LruCache<String, String> b = new LruCache(200);
  public static final c;
  public static long d = -1L;
  public static long e = -1L;
  public static long f = 180000L;
  public static AtomicBoolean g = new AtomicBoolean(false);
  public static Carambola.do h;
  
  /* Error */
  public static Casaba a(android.content.Context paramContext, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: getstatic 29	com/tencent/turingfd/sdk/xq/Carambola:a	Ljava/util/Set;
    //   8: astore 9
    //   10: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   13: lstore 7
    //   15: new 63	java/util/HashMap
    //   18: dup
    //   19: invokespecial 64	java/util/HashMap:<init>	()V
    //   22: astore 11
    //   24: new 66	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   31: astore 10
    //   33: aload 10
    //   35: ldc 69
    //   37: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 10
    //   43: getstatic 78	com/tencent/turingfd/sdk/xq/native:a	I
    //   46: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload 11
    //   52: ldc 83
    //   54: aload 10
    //   56: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: getstatic 96	com/tencent/turingfd/sdk/xq/Filbert:a	Lcom/tencent/turingfd/sdk/xq/Filbert;
    //   66: astore 12
    //   68: aload 9
    //   70: ifnull +50 -> 120
    //   73: aload 9
    //   75: invokeinterface 102 1 0
    //   80: astore 9
    //   82: aload 9
    //   84: invokeinterface 108 1 0
    //   89: ifeq +25 -> 114
    //   92: aload 12
    //   94: aload 9
    //   96: invokeinterface 112 1 0
    //   101: checkcast 114	java/lang/Integer
    //   104: invokevirtual 118	java/lang/Integer:intValue	()I
    //   107: iconst_0
    //   108: invokevirtual 121	com/tencent/turingfd/sdk/xq/Filbert:b	(II)V
    //   111: goto -29 -> 82
    //   114: aload 12
    //   116: aload_0
    //   117: invokevirtual 124	com/tencent/turingfd/sdk/xq/Filbert:a	(Landroid/content/Context;)V
    //   120: aload 12
    //   122: iconst_2
    //   123: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   126: ifeq +32 -> 158
    //   129: aload_0
    //   130: invokestatic 132	com/tencent/turingfd/sdk/xq/implements:a	(Landroid/content/Context;)Ljava/lang/String;
    //   133: astore 10
    //   135: aload 10
    //   137: astore 9
    //   139: aload 10
    //   141: ifnonnull +7 -> 148
    //   144: ldc 69
    //   146: astore 9
    //   148: aload 11
    //   150: ldc 134
    //   152: aload 9
    //   154: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: aload 12
    //   160: bipush 28
    //   162: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   165: ifeq +23 -> 188
    //   168: aload 11
    //   170: ldc 136
    //   172: getstatic 141	com/tencent/turingfd/sdk/xq/Cranberry:a	Lcom/tencent/turingfd/sdk/xq/Cranberry;
    //   175: aload_0
    //   176: iconst_1
    //   177: iconst_1
    //   178: invokevirtual 144	com/tencent/turingfd/sdk/xq/Cranberry:a	(Landroid/content/Context;ZI)Lcom/tencent/turingfd/sdk/xq/Chestnut;
    //   181: getfield 149	com/tencent/turingfd/sdk/xq/Chestnut:b	Ljava/lang/String;
    //   184: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   187: pop
    //   188: aload 12
    //   190: bipush 22
    //   192: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   195: ifeq +15 -> 210
    //   198: aload 11
    //   200: ldc 151
    //   202: aload_0
    //   203: invokestatic 154	com/tencent/turingfd/sdk/xq/throws:a	(Landroid/content/Context;)Ljava/lang/String;
    //   206: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   209: pop
    //   210: aload 12
    //   212: bipush 100
    //   214: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   217: ifeq +32 -> 249
    //   220: aload_0
    //   221: invokestatic 157	com/tencent/turingfd/sdk/xq/const:a	(Landroid/content/Context;)Ljava/lang/String;
    //   224: astore 10
    //   226: aload 10
    //   228: astore 9
    //   230: aload 10
    //   232: ifnonnull +7 -> 239
    //   235: ldc 69
    //   237: astore 9
    //   239: aload 11
    //   241: ldc 159
    //   243: aload 9
    //   245: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   248: pop
    //   249: aload 12
    //   251: bipush 101
    //   253: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   256: ifeq +31 -> 287
    //   259: aload_0
    //   260: invokestatic 164	com/tencent/turingfd/sdk/xq/private:a	(Landroid/content/Context;)I
    //   263: ifle +10 -> 273
    //   266: ldc 83
    //   268: astore 9
    //   270: goto +7 -> 277
    //   273: ldc 166
    //   275: astore 9
    //   277: aload 11
    //   279: ldc 168
    //   281: aload 9
    //   283: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload 12
    //   289: bipush 102
    //   291: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   294: ifeq +48 -> 342
    //   297: aload_0
    //   298: invokevirtual 174	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   301: ldc 176
    //   303: iconst_0
    //   304: invokestatic 182	android/provider/Settings$Secure:getInt	(Landroid/content/ContentResolver;Ljava/lang/String;I)I
    //   307: ifeq +8 -> 315
    //   310: iconst_1
    //   311: istore_2
    //   312: goto +5 -> 317
    //   315: iconst_0
    //   316: istore_2
    //   317: iload_2
    //   318: ifeq +10 -> 328
    //   321: ldc 83
    //   323: astore 9
    //   325: goto +7 -> 332
    //   328: ldc 166
    //   330: astore 9
    //   332: aload 11
    //   334: ldc 184
    //   336: aload 9
    //   338: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   341: pop
    //   342: aload 12
    //   344: bipush 103
    //   346: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   349: ifeq +43 -> 392
    //   352: new 66	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   359: astore 9
    //   361: aload 9
    //   363: ldc 69
    //   365: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload 9
    //   371: aload_0
    //   372: invokestatic 186	com/tencent/turingfd/sdk/xq/const:g	(Landroid/content/Context;)I
    //   375: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 11
    //   381: ldc 188
    //   383: aload 9
    //   385: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload 12
    //   394: bipush 104
    //   396: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   399: ifeq +43 -> 442
    //   402: new 66	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   409: astore 9
    //   411: aload 9
    //   413: ldc 69
    //   415: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 9
    //   421: aload_0
    //   422: invokestatic 190	com/tencent/turingfd/sdk/xq/const:d	(Landroid/content/Context;)I
    //   425: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 11
    //   431: ldc 192
    //   433: aload 9
    //   435: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   438: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   441: pop
    //   442: aload 12
    //   444: bipush 105
    //   446: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   449: ifeq +43 -> 492
    //   452: new 66	java/lang/StringBuilder
    //   455: dup
    //   456: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   459: astore 9
    //   461: aload 9
    //   463: ldc 69
    //   465: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 9
    //   471: aload_0
    //   472: invokestatic 195	com/tencent/turingfd/sdk/xq/switch:a	(Landroid/content/Context;)I
    //   475: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 11
    //   481: ldc 197
    //   483: aload 9
    //   485: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   491: pop
    //   492: aload 12
    //   494: bipush 106
    //   496: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   499: ifeq +31 -> 530
    //   502: invokestatic 199	com/tencent/turingfd/sdk/xq/const:b	()Ljava/lang/String;
    //   505: astore 10
    //   507: aload 10
    //   509: astore 9
    //   511: aload 10
    //   513: ifnonnull +7 -> 520
    //   516: ldc 69
    //   518: astore 9
    //   520: aload 11
    //   522: ldc 201
    //   524: aload 9
    //   526: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   529: pop
    //   530: aload 12
    //   532: bipush 115
    //   534: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   537: ifeq +31 -> 568
    //   540: invokestatic 203	com/tencent/turingfd/sdk/xq/const:d	()Ljava/lang/String;
    //   543: astore 10
    //   545: aload 10
    //   547: astore 9
    //   549: aload 10
    //   551: ifnonnull +7 -> 558
    //   554: ldc 69
    //   556: astore 9
    //   558: aload 11
    //   560: ldc 205
    //   562: aload 9
    //   564: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   567: pop
    //   568: aload 12
    //   570: bipush 116
    //   572: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   575: ifeq +31 -> 606
    //   578: invokestatic 207	com/tencent/turingfd/sdk/xq/const:c	()Ljava/lang/String;
    //   581: astore 10
    //   583: aload 10
    //   585: astore 9
    //   587: aload 10
    //   589: ifnonnull +7 -> 596
    //   592: ldc 69
    //   594: astore 9
    //   596: aload 11
    //   598: ldc 209
    //   600: aload 9
    //   602: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   605: pop
    //   606: aload 12
    //   608: bipush 107
    //   610: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   613: ifeq +32 -> 645
    //   616: aload_0
    //   617: invokestatic 212	com/tencent/turingfd/sdk/xq/const:j	(Landroid/content/Context;)Ljava/lang/String;
    //   620: astore 10
    //   622: aload 10
    //   624: astore 9
    //   626: aload 10
    //   628: ifnonnull +7 -> 635
    //   631: ldc 69
    //   633: astore 9
    //   635: aload 11
    //   637: ldc 214
    //   639: aload 9
    //   641: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   644: pop
    //   645: aload 12
    //   647: bipush 113
    //   649: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   652: ifeq +30 -> 682
    //   655: invokestatic 216	com/tencent/turingfd/sdk/xq/const:f	()Z
    //   658: ifeq +10 -> 668
    //   661: ldc 83
    //   663: astore 9
    //   665: goto +7 -> 672
    //   668: ldc 166
    //   670: astore 9
    //   672: aload 11
    //   674: ldc 218
    //   676: aload 9
    //   678: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   681: pop
    //   682: aload 12
    //   684: bipush 114
    //   686: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   689: ifeq +41 -> 730
    //   692: aload_0
    //   693: invokestatic 221	com/tencent/turingfd/sdk/xq/const:c	(Landroid/content/Context;)Z
    //   696: istore 4
    //   698: goto +6 -> 704
    //   701: iconst_0
    //   702: istore 4
    //   704: iload 4
    //   706: ifeq +10 -> 716
    //   709: ldc 83
    //   711: astore 9
    //   713: goto +7 -> 720
    //   716: ldc 166
    //   718: astore 9
    //   720: aload 11
    //   722: ldc 223
    //   724: aload 9
    //   726: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   729: pop
    //   730: new 66	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   737: astore 9
    //   739: aload 9
    //   741: ldc 69
    //   743: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload 9
    //   749: aload_0
    //   750: invokestatic 225	com/tencent/turingfd/sdk/xq/const:b	(Landroid/content/Context;)I
    //   753: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: pop
    //   757: aload 11
    //   759: ldc 227
    //   761: aload 9
    //   763: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   769: pop
    //   770: aload 12
    //   772: bipush 44
    //   774: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   777: ifeq +14 -> 791
    //   780: aload 11
    //   782: ldc 229
    //   784: invokestatic 231	com/tencent/turingfd/sdk/xq/const:a	()Ljava/lang/String;
    //   787: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   790: pop
    //   791: aload 12
    //   793: bipush 17
    //   795: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   798: ifeq +255 -> 1053
    //   801: new 233	android/util/SparseArray
    //   804: dup
    //   805: invokespecial 234	android/util/SparseArray:<init>	()V
    //   808: aload_0
    //   809: new 63	java/util/HashMap
    //   812: dup
    //   813: invokespecial 64	java/util/HashMap:<init>	()V
    //   816: iconst_0
    //   817: invokestatic 239	com/tencent/turingfd/sdk/xq/TNative$aa:h	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   820: astore 9
    //   822: aload 9
    //   824: invokestatic 242	com/tencent/turingfd/sdk/xq/const:b	(Landroid/util/SparseArray;)I
    //   827: ifeq +6 -> 833
    //   830: goto +208 -> 1038
    //   833: aload 9
    //   835: sipush 205
    //   838: ldc 244
    //   840: invokestatic 247	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;ILjava/lang/Class;)Ljava/lang/Object;
    //   843: checkcast 244	java/lang/String
    //   846: astore 10
    //   848: aload 10
    //   850: astore 9
    //   852: aload 10
    //   854: ifnonnull +7 -> 861
    //   857: ldc 69
    //   859: astore 9
    //   861: new 66	java/lang/StringBuilder
    //   864: dup
    //   865: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   868: astore 10
    //   870: aload 9
    //   872: ldc 249
    //   874: invokevirtual 253	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   877: astore 12
    //   879: aload 12
    //   881: arraylength
    //   882: istore_3
    //   883: iconst_0
    //   884: istore_2
    //   885: iload_2
    //   886: iload_3
    //   887: if_icmpge +141 -> 1028
    //   890: aload 12
    //   892: iload_2
    //   893: aaload
    //   894: astore 9
    //   896: aload 9
    //   898: ldc 255
    //   900: invokevirtual 253	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   903: astore 13
    //   905: aload 13
    //   907: iconst_0
    //   908: aaload
    //   909: ldc 166
    //   911: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   914: ifeq +6 -> 920
    //   917: goto +104 -> 1021
    //   920: aload 10
    //   922: aload 9
    //   924: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   927: pop
    //   928: aload 10
    //   930: ldc 255
    //   932: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: pop
    //   936: aload 13
    //   938: aload 13
    //   940: arraylength
    //   941: iconst_1
    //   942: isub
    //   943: aaload
    //   944: astore 9
    //   946: aload 9
    //   948: invokestatic 262	com/tencent/turingfd/sdk/xq/const:a	(Ljava/lang/String;)Ljava/lang/String;
    //   951: astore 13
    //   953: getstatic 36	com/tencent/turingfd/sdk/xq/Carambola:b	Landroid/util/LruCache;
    //   956: aload 9
    //   958: invokestatic 262	com/tencent/turingfd/sdk/xq/const:a	(Ljava/lang/String;)Ljava/lang/String;
    //   961: invokevirtual 266	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   964: ifnull +22 -> 986
    //   967: getstatic 36	com/tencent/turingfd/sdk/xq/Carambola:b	Landroid/util/LruCache;
    //   970: aload 9
    //   972: invokestatic 262	com/tencent/turingfd/sdk/xq/const:a	(Ljava/lang/String;)Ljava/lang/String;
    //   975: invokevirtual 266	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   978: checkcast 244	java/lang/String
    //   981: astore 9
    //   983: goto +22 -> 1005
    //   986: aload_0
    //   987: aload 9
    //   989: invokestatic 271	com/tencent/turingfd/sdk/xq/Andromeda:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   992: astore 9
    //   994: getstatic 36	com/tencent/turingfd/sdk/xq/Carambola:b	Landroid/util/LruCache;
    //   997: aload 13
    //   999: aload 9
    //   1001: invokevirtual 272	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: pop
    //   1005: aload 10
    //   1007: aload 9
    //   1009: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: pop
    //   1013: aload 10
    //   1015: ldc 249
    //   1017: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1020: pop
    //   1021: iload_2
    //   1022: iconst_1
    //   1023: iadd
    //   1024: istore_2
    //   1025: goto -140 -> 885
    //   1028: aload 10
    //   1030: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1033: astore 9
    //   1035: goto +7 -> 1042
    //   1038: ldc 69
    //   1040: astore 9
    //   1042: aload 11
    //   1044: ldc_w 274
    //   1047: aload 9
    //   1049: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1052: pop
    //   1053: new 66	java/lang/StringBuilder
    //   1056: dup
    //   1057: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1060: astore 9
    //   1062: aload 9
    //   1064: ldc 69
    //   1066: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: aload 9
    //   1072: aload_0
    //   1073: invokestatic 276	com/tencent/turingfd/sdk/xq/const:f	(Landroid/content/Context;)I
    //   1076: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1079: pop
    //   1080: aload 11
    //   1082: ldc_w 278
    //   1085: aload 9
    //   1087: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1090: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1093: pop
    //   1094: getstatic 96	com/tencent/turingfd/sdk/xq/Filbert:a	Lcom/tencent/turingfd/sdk/xq/Filbert;
    //   1097: sipush 10002
    //   1100: invokevirtual 127	com/tencent/turingfd/sdk/xq/Filbert:a	(I)Z
    //   1103: ifne +14 -> 1117
    //   1106: aload 11
    //   1108: ldc_w 280
    //   1111: ldc 166
    //   1113: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1116: pop
    //   1117: aload 11
    //   1119: ldc_w 282
    //   1122: getstatic 96	com/tencent/turingfd/sdk/xq/Filbert:a	Lcom/tencent/turingfd/sdk/xq/Filbert;
    //   1125: invokevirtual 283	com/tencent/turingfd/sdk/xq/Filbert:a	()Ljava/lang/String;
    //   1128: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1131: pop
    //   1132: new 66	java/lang/StringBuilder
    //   1135: dup
    //   1136: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1139: astore 9
    //   1141: getstatic 288	com/tencent/turingfd/sdk/xq/Bullace:b	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1144: getfield 293	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   1147: invokevirtual 298	java/util/LinkedList:size	()I
    //   1150: istore_3
    //   1151: iconst_0
    //   1152: istore_2
    //   1153: iload_2
    //   1154: iload_3
    //   1155: if_icmpge +72 -> 1227
    //   1158: getstatic 300	com/tencent/turingfd/sdk/xq/Bullace:a	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1161: astore 10
    //   1163: aload 10
    //   1165: monitorenter
    //   1166: getstatic 288	com/tencent/turingfd/sdk/xq/Bullace:b	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1169: getfield 293	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   1172: invokevirtual 303	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   1175: checkcast 305	com/tencent/turingfd/sdk/xq/Cantaloupe
    //   1178: astore 12
    //   1180: aload 10
    //   1182: monitorexit
    //   1183: getstatic 308	com/tencent/turingfd/sdk/xq/Bullace:c	Ljava/util/List;
    //   1186: aload 12
    //   1188: invokeinterface 313 2 0
    //   1193: pop
    //   1194: aload 9
    //   1196: aload 12
    //   1198: invokevirtual 314	com/tencent/turingfd/sdk/xq/Cantaloupe:a	()Ljava/lang/String;
    //   1201: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: pop
    //   1205: aload 9
    //   1207: ldc_w 316
    //   1210: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1213: pop
    //   1214: iload_2
    //   1215: iconst_1
    //   1216: iadd
    //   1217: istore_2
    //   1218: goto -65 -> 1153
    //   1221: astore_0
    //   1222: aload 10
    //   1224: monitorexit
    //   1225: aload_0
    //   1226: athrow
    //   1227: getstatic 300	com/tencent/turingfd/sdk/xq/Bullace:a	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1230: getfield 293	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   1233: invokevirtual 298	java/util/LinkedList:size	()I
    //   1236: istore_3
    //   1237: iconst_0
    //   1238: istore_2
    //   1239: iload_2
    //   1240: iload_3
    //   1241: if_icmpge +72 -> 1313
    //   1244: getstatic 300	com/tencent/turingfd/sdk/xq/Bullace:a	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1247: astore 10
    //   1249: aload 10
    //   1251: monitorenter
    //   1252: getstatic 300	com/tencent/turingfd/sdk/xq/Bullace:a	Lcom/tencent/turingfd/sdk/xq/synchronized;
    //   1255: getfield 293	com/tencent/turingfd/sdk/xq/synchronized:b	Ljava/util/LinkedList;
    //   1258: invokevirtual 303	java/util/LinkedList:poll	()Ljava/lang/Object;
    //   1261: checkcast 305	com/tencent/turingfd/sdk/xq/Cantaloupe
    //   1264: astore 12
    //   1266: aload 10
    //   1268: monitorexit
    //   1269: getstatic 308	com/tencent/turingfd/sdk/xq/Bullace:c	Ljava/util/List;
    //   1272: aload 12
    //   1274: invokeinterface 313 2 0
    //   1279: pop
    //   1280: aload 9
    //   1282: aload 12
    //   1284: invokevirtual 314	com/tencent/turingfd/sdk/xq/Cantaloupe:a	()Ljava/lang/String;
    //   1287: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: aload 9
    //   1293: ldc_w 316
    //   1296: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1299: pop
    //   1300: iload_2
    //   1301: iconst_1
    //   1302: iadd
    //   1303: istore_2
    //   1304: goto -65 -> 1239
    //   1307: astore_0
    //   1308: aload 10
    //   1310: monitorexit
    //   1311: aload_0
    //   1312: athrow
    //   1313: aload 9
    //   1315: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: astore 10
    //   1320: aload 10
    //   1322: astore 9
    //   1324: aload 10
    //   1326: invokestatic 322	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1329: ifeq +8 -> 1337
    //   1332: ldc_w 324
    //   1335: astore 9
    //   1337: aload 11
    //   1339: ldc_w 326
    //   1342: aload 9
    //   1344: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1347: pop
    //   1348: getstatic 328	com/tencent/turingfd/sdk/xq/Carambola:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1351: getfield 334	com/tencent/turingfd/sdk/xq/final:k	Ljava/util/Map;
    //   1354: astore 9
    //   1356: new 66	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1363: astore 10
    //   1365: aload 9
    //   1367: invokeinterface 340 1 0
    //   1372: invokeinterface 102 1 0
    //   1377: astore 12
    //   1379: aload 12
    //   1381: invokeinterface 108 1 0
    //   1386: ifeq +91 -> 1477
    //   1389: aload 12
    //   1391: invokeinterface 112 1 0
    //   1396: checkcast 114	java/lang/Integer
    //   1399: invokevirtual 118	java/lang/Integer:intValue	()I
    //   1402: istore_2
    //   1403: aload 10
    //   1405: iload_2
    //   1406: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1409: pop
    //   1410: aload 10
    //   1412: ldc_w 342
    //   1415: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1418: pop
    //   1419: aload 10
    //   1421: ldc 249
    //   1423: ldc_w 344
    //   1426: ldc_w 342
    //   1429: ldc_w 346
    //   1432: aload 9
    //   1434: iload_2
    //   1435: invokestatic 350	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1438: invokeinterface 351 2 0
    //   1443: checkcast 244	java/lang/String
    //   1446: invokestatic 354	com/tencent/turingfd/sdk/xq/const:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1449: invokestatic 354	com/tencent/turingfd/sdk/xq/const:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1452: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: pop
    //   1456: aload 12
    //   1458: invokeinterface 108 1 0
    //   1463: ifeq -84 -> 1379
    //   1466: aload 10
    //   1468: ldc 249
    //   1470: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1473: pop
    //   1474: goto -95 -> 1379
    //   1477: aload 11
    //   1479: ldc_w 356
    //   1482: aload 10
    //   1484: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1490: pop
    //   1491: new 233	android/util/SparseArray
    //   1494: dup
    //   1495: invokespecial 234	android/util/SparseArray:<init>	()V
    //   1498: aload_0
    //   1499: aload 11
    //   1501: iconst_1
    //   1502: invokestatic 358	com/tencent/turingfd/sdk/xq/TNative$aa:g	(Landroid/util/SparseArray;Landroid/content/Context;Ljava/util/Map;I)Landroid/util/SparseArray;
    //   1505: astore 9
    //   1507: aload 9
    //   1509: invokestatic 242	com/tencent/turingfd/sdk/xq/const:b	(Landroid/util/SparseArray;)I
    //   1512: ifeq +11 -> 1523
    //   1515: iconst_0
    //   1516: newarray byte
    //   1518: astore 9
    //   1520: goto +86 -> 1606
    //   1523: aload 9
    //   1525: invokestatic 361	com/tencent/turingfd/sdk/xq/const:a	(Landroid/util/SparseArray;)[B
    //   1528: astore 9
    //   1530: new 66	java/lang/StringBuilder
    //   1533: dup
    //   1534: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1537: astore 10
    //   1539: aload 10
    //   1541: ldc_w 363
    //   1544: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1547: pop
    //   1548: aload 10
    //   1550: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1553: lload 7
    //   1555: lsub
    //   1556: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1559: pop
    //   1560: aload 10
    //   1562: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1565: astore 10
    //   1567: getstatic 370	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   1570: astore 11
    //   1572: new 63	java/util/HashMap
    //   1575: dup
    //   1576: invokespecial 64	java/util/HashMap:<init>	()V
    //   1579: astore 11
    //   1581: aload 11
    //   1583: ldc_w 372
    //   1586: aload 10
    //   1588: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1591: pop
    //   1592: aload_0
    //   1593: aload 11
    //   1595: invokestatic 375	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   1598: goto +8 -> 1606
    //   1601: iconst_0
    //   1602: newarray byte
    //   1604: astore 9
    //   1606: iconst_0
    //   1607: newarray byte
    //   1609: astore 10
    //   1611: getstatic 328	com/tencent/turingfd/sdk/xq/Carambola:c	Lcom/tencent/turingfd/sdk/xq/final;
    //   1614: invokevirtual 378	com/tencent/turingfd/sdk/xq/final:b	()Lcom/tencent/turingfd/sdk/xq/catch;
    //   1617: checkcast 380	com/tencent/turingfd/sdk/xq/interface
    //   1620: iconst_5
    //   1621: aload 9
    //   1623: iconst_0
    //   1624: iconst_0
    //   1625: invokevirtual 383	com/tencent/turingfd/sdk/xq/interface:a	(I[BII)Lcom/tencent/turingfd/sdk/xq/catch$do;
    //   1628: getfield 388	com/tencent/turingfd/sdk/xq/catch$do:b	[B
    //   1631: astore 9
    //   1633: new 390	com/tencent/turingfd/sdk/xq/Bryony
    //   1636: dup
    //   1637: invokespecial 391	com/tencent/turingfd/sdk/xq/Bryony:<init>	()V
    //   1640: aload 9
    //   1642: invokestatic 394	com/tencent/turingfd/sdk/xq/const:a	(Lcom/tencent/turingfd/sdk/xq/else;[B)Lcom/tencent/turingfd/sdk/xq/else;
    //   1645: checkcast 390	com/tencent/turingfd/sdk/xq/Bryony
    //   1648: astore 9
    //   1650: aload 9
    //   1652: getfield 396	com/tencent/turingfd/sdk/xq/Bryony:b	I
    //   1655: ifne +40 -> 1695
    //   1658: getstatic 308	com/tencent/turingfd/sdk/xq/Bullace:c	Ljava/util/List;
    //   1661: invokeinterface 397 1 0
    //   1666: ifle +11 -> 1677
    //   1669: getstatic 308	com/tencent/turingfd/sdk/xq/Bullace:c	Ljava/util/List;
    //   1672: invokeinterface 400 1 0
    //   1677: new 402	com/tencent/turingfd/sdk/xq/Casaba
    //   1680: dup
    //   1681: iconst_0
    //   1682: aload 9
    //   1684: getfield 404	com/tencent/turingfd/sdk/xq/Bryony:c	Ljava/lang/String;
    //   1687: invokespecial 407	com/tencent/turingfd/sdk/xq/Casaba:<init>	(ILjava/lang/String;)V
    //   1690: astore 9
    //   1692: goto +39 -> 1731
    //   1695: invokestatic 409	com/tencent/turingfd/sdk/xq/Bullace:a	()V
    //   1698: new 402	com/tencent/turingfd/sdk/xq/Casaba
    //   1701: dup
    //   1702: aload 9
    //   1704: getfield 396	com/tencent/turingfd/sdk/xq/Bryony:b	I
    //   1707: ldc 69
    //   1709: invokespecial 407	com/tencent/turingfd/sdk/xq/Casaba:<init>	(ILjava/lang/String;)V
    //   1712: astore 9
    //   1714: goto +17 -> 1731
    //   1717: new 402	com/tencent/turingfd/sdk/xq/Casaba
    //   1720: dup
    //   1721: sipush -999
    //   1724: ldc 69
    //   1726: invokespecial 407	com/tencent/turingfd/sdk/xq/Casaba:<init>	(ILjava/lang/String;)V
    //   1729: astore 9
    //   1731: new 66	java/lang/StringBuilder
    //   1734: dup
    //   1735: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   1738: astore 11
    //   1740: aload 11
    //   1742: iconst_2
    //   1743: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1746: pop
    //   1747: aload 11
    //   1749: ldc_w 342
    //   1752: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: pop
    //   1756: aload 11
    //   1758: iconst_1
    //   1759: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1762: pop
    //   1763: aload 11
    //   1765: ldc_w 342
    //   1768: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1771: pop
    //   1772: iload_1
    //   1773: ifeq +10 -> 1783
    //   1776: ldc 83
    //   1778: astore 10
    //   1780: goto +7 -> 1787
    //   1783: ldc 166
    //   1785: astore 10
    //   1787: aload 11
    //   1789: aload 10
    //   1791: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1794: pop
    //   1795: aload 11
    //   1797: ldc_w 342
    //   1800: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1803: pop
    //   1804: aload 11
    //   1806: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   1809: lload 5
    //   1811: lsub
    //   1812: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1815: pop
    //   1816: aload 11
    //   1818: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1821: astore 10
    //   1823: getstatic 370	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   1826: astore 11
    //   1828: new 63	java/util/HashMap
    //   1831: dup
    //   1832: invokespecial 64	java/util/HashMap:<init>	()V
    //   1835: astore 11
    //   1837: aload 11
    //   1839: ldc_w 411
    //   1842: aload 10
    //   1844: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1847: pop
    //   1848: aload_0
    //   1849: aload 11
    //   1851: invokestatic 375	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   1854: aload 9
    //   1856: areturn
    //   1857: astore 9
    //   1859: goto -1158 -> 701
    //   1862: astore 9
    //   1864: goto -826 -> 1038
    //   1867: astore 9
    //   1869: goto -268 -> 1601
    //   1872: astore 9
    //   1874: aload 10
    //   1876: astore 9
    //   1878: goto -245 -> 1633
    //   1881: astore 9
    //   1883: goto -166 -> 1717
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1886	0	paramContext	android.content.Context
    //   0	1886	1	paramBoolean	boolean
    //   311	1124	2	i	int
    //   882	360	3	j	int
    //   696	9	4	bool	boolean
    //   3	1807	5	l1	long
    //   13	1541	7	l2	long
    //   8	1847	9	localObject1	Object
    //   1857	1	9	localObject2	Object
    //   1862	1	9	localObject3	Object
    //   1867	1	9	localObject4	Object
    //   1872	1	9	localObject5	Object
    //   1876	1	9	localObject6	Object
    //   1881	1	9	localObject7	Object
    //   31	1844	10	localObject8	Object
    //   22	1828	11	localObject9	Object
    //   66	1391	12	localObject10	Object
    //   903	95	13	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   1166	1183	1221	finally
    //   1222	1225	1221	finally
    //   1252	1269	1307	finally
    //   1308	1311	1307	finally
    //   692	698	1857	finally
    //   801	822	1862	finally
    //   1491	1507	1867	finally
    //   1611	1633	1872	finally
    //   1633	1677	1881	finally
    //   1677	1692	1881	finally
    //   1695	1714	1881	finally
  }
  
  /* Error */
  public static void a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 416	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   6: aload_0
    //   7: invokevirtual 418	com/tencent/turingfd/sdk/xq/Fig:b	(Landroid/content/Context;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifne +7 -> 19
    //   15: ldc 2
    //   17: monitorexit
    //   18: return
    //   19: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   22: lstore 5
    //   24: getstatic 40	com/tencent/turingfd/sdk/xq/Carambola:d	J
    //   27: lconst_0
    //   28: lcmp
    //   29: ifge +31 -> 60
    //   32: getstatic 370	com/tencent/turingfd/sdk/xq/Date:a	Ljava/lang/String;
    //   35: astore 7
    //   37: aload_0
    //   38: ldc_w 420
    //   41: invokestatic 422	com/tencent/turingfd/sdk/xq/Date:b	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic 427	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   47: invokevirtual 430	java/lang/Long:longValue	()J
    //   50: lstore_3
    //   51: goto +5 -> 56
    //   54: lconst_0
    //   55: lstore_3
    //   56: lload_3
    //   57: putstatic 40	com/tencent/turingfd/sdk/xq/Carambola:d	J
    //   60: getstatic 42	com/tencent/turingfd/sdk/xq/Carambola:e	J
    //   63: lconst_0
    //   64: lcmp
    //   65: ifge +47 -> 112
    //   68: getstatic 416	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   71: invokevirtual 434	java/lang/Object:getClass	()Ljava/lang/Class;
    //   74: pop
    //   75: getstatic 416	com/tencent/turingfd/sdk/xq/Fig:b	Lcom/tencent/turingfd/sdk/xq/Fig;
    //   78: aload_0
    //   79: invokevirtual 437	com/tencent/turingfd/sdk/xq/Fig:c	(Landroid/content/Context;)Lcom/tencent/turingfd/sdk/xq/Lyra;
    //   82: getfield 440	com/tencent/turingfd/sdk/xq/Lyra:k	Ljava/util/Map;
    //   85: ldc_w 442
    //   88: invokeinterface 351 2 0
    //   93: checkcast 244	java/lang/String
    //   96: invokestatic 446	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   99: istore_1
    //   100: iload_1
    //   101: i2l
    //   102: lstore_3
    //   103: goto +5 -> 108
    //   106: lconst_1
    //   107: lstore_3
    //   108: lload_3
    //   109: putstatic 42	com/tencent/turingfd/sdk/xq/Carambola:e	J
    //   112: getstatic 40	com/tencent/turingfd/sdk/xq/Carambola:d	J
    //   115: lload 5
    //   117: lsub
    //   118: invokestatic 452	java/lang/Math:abs	(J)J
    //   121: lstore_3
    //   122: getstatic 42	com/tencent/turingfd/sdk/xq/Carambola:e	J
    //   125: lstore 5
    //   127: lload_3
    //   128: lload 5
    //   130: ldc2_w 453
    //   133: lmul
    //   134: ldc2_w 455
    //   137: lmul
    //   138: lcmp
    //   139: ifgt +7 -> 146
    //   142: ldc 2
    //   144: monitorexit
    //   145: return
    //   146: getstatic 53	com/tencent/turingfd/sdk/xq/Carambola:g	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   149: invokevirtual 458	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   152: istore_2
    //   153: iload_2
    //   154: ifeq +7 -> 161
    //   157: ldc 2
    //   159: monitorexit
    //   160: return
    //   161: iconst_0
    //   162: istore_1
    //   163: iload_1
    //   164: iconst_3
    //   165: if_icmpge +85 -> 250
    //   168: aload_0
    //   169: iconst_1
    //   170: invokestatic 460	com/tencent/turingfd/sdk/xq/Carambola:a	(Landroid/content/Context;Z)Lcom/tencent/turingfd/sdk/xq/Casaba;
    //   173: getfield 461	com/tencent/turingfd/sdk/xq/Casaba:a	I
    //   176: ifne +67 -> 243
    //   179: invokestatic 61	java/lang/System:currentTimeMillis	()J
    //   182: lstore_3
    //   183: lload_3
    //   184: putstatic 40	com/tencent/turingfd/sdk/xq/Carambola:d	J
    //   187: new 63	java/util/HashMap
    //   190: dup
    //   191: invokespecial 64	java/util/HashMap:<init>	()V
    //   194: astore 7
    //   196: new 66	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   203: astore 8
    //   205: aload 8
    //   207: ldc 69
    //   209: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 8
    //   215: lload_3
    //   216: invokevirtual 366	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: pop
    //   220: aload 7
    //   222: ldc_w 420
    //   225: aload 8
    //   227: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   233: pop
    //   234: aload_0
    //   235: aload 7
    //   237: invokestatic 375	com/tencent/turingfd/sdk/xq/Date:a	(Landroid/content/Context;Ljava/util/Map;)V
    //   240: goto +10 -> 250
    //   243: iload_1
    //   244: iconst_1
    //   245: iadd
    //   246: istore_1
    //   247: goto -84 -> 163
    //   250: ldc 2
    //   252: monitorexit
    //   253: return
    //   254: astore_0
    //   255: ldc 2
    //   257: monitorexit
    //   258: goto +5 -> 263
    //   261: aload_0
    //   262: athrow
    //   263: goto -2 -> 261
    //   266: astore 7
    //   268: goto -214 -> 54
    //   271: astore 7
    //   273: goto -167 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	android.content.Context
    //   99	148	1	i	int
    //   10	144	2	bool	boolean
    //   50	166	3	l1	long
    //   22	107	5	l2	long
    //   35	201	7	localObject1	Object
    //   266	1	7	localObject2	Object
    //   271	1	7	localObject3	Object
    //   203	23	8	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   3	11	254	finally
    //   19	37	254	finally
    //   56	60	254	finally
    //   60	75	254	finally
    //   108	112	254	finally
    //   112	127	254	finally
    //   146	153	254	finally
    //   168	240	254	finally
    //   37	51	266	finally
    //   75	100	271	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Carambola
 * JD-Core Version:    0.7.0.1
 */