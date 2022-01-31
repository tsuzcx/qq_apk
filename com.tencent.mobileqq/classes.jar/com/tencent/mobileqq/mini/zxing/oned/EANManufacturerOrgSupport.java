package com.tencent.mobileqq.mini.zxing.oned;

import java.util.ArrayList;
import java.util.List;

final class EANManufacturerOrgSupport
{
  private final List<String> countryIdentifiers = new ArrayList();
  private final List<int[]> ranges = new ArrayList();
  
  private void add(int[] paramArrayOfInt, String paramString)
  {
    this.ranges.add(paramArrayOfInt);
    this.countryIdentifiers.add(paramString);
  }
  
  /* Error */
  private void initIfNeeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 18	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:ranges	Ljava/util/List;
    //   6: invokeinterface 33 1 0
    //   11: istore_1
    //   12: iload_1
    //   13: ifne +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: iconst_2
    //   21: newarray int
    //   23: dup
    //   24: iconst_0
    //   25: iconst_0
    //   26: iastore
    //   27: dup
    //   28: iconst_1
    //   29: bipush 19
    //   31: iastore
    //   32: ldc 35
    //   34: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   37: aload_0
    //   38: iconst_2
    //   39: newarray int
    //   41: dup
    //   42: iconst_0
    //   43: bipush 30
    //   45: iastore
    //   46: dup
    //   47: iconst_1
    //   48: bipush 39
    //   50: iastore
    //   51: ldc 39
    //   53: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   56: aload_0
    //   57: iconst_2
    //   58: newarray int
    //   60: dup
    //   61: iconst_0
    //   62: bipush 60
    //   64: iastore
    //   65: dup
    //   66: iconst_1
    //   67: sipush 139
    //   70: iastore
    //   71: ldc 35
    //   73: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   76: aload_0
    //   77: iconst_2
    //   78: newarray int
    //   80: dup
    //   81: iconst_0
    //   82: sipush 300
    //   85: iastore
    //   86: dup
    //   87: iconst_1
    //   88: sipush 379
    //   91: iastore
    //   92: ldc 41
    //   94: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   97: aload_0
    //   98: iconst_1
    //   99: newarray int
    //   101: dup
    //   102: iconst_0
    //   103: sipush 380
    //   106: iastore
    //   107: ldc 43
    //   109: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   112: aload_0
    //   113: iconst_1
    //   114: newarray int
    //   116: dup
    //   117: iconst_0
    //   118: sipush 383
    //   121: iastore
    //   122: ldc 45
    //   124: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   127: aload_0
    //   128: iconst_1
    //   129: newarray int
    //   131: dup
    //   132: iconst_0
    //   133: sipush 385
    //   136: iastore
    //   137: ldc 47
    //   139: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   142: aload_0
    //   143: iconst_1
    //   144: newarray int
    //   146: dup
    //   147: iconst_0
    //   148: sipush 387
    //   151: iastore
    //   152: ldc 49
    //   154: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   157: aload_0
    //   158: iconst_2
    //   159: newarray int
    //   161: dup
    //   162: iconst_0
    //   163: sipush 400
    //   166: iastore
    //   167: dup
    //   168: iconst_1
    //   169: sipush 440
    //   172: iastore
    //   173: ldc 51
    //   175: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   178: aload_0
    //   179: iconst_2
    //   180: newarray int
    //   182: dup
    //   183: iconst_0
    //   184: sipush 450
    //   187: iastore
    //   188: dup
    //   189: iconst_1
    //   190: sipush 459
    //   193: iastore
    //   194: ldc 53
    //   196: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   199: aload_0
    //   200: iconst_2
    //   201: newarray int
    //   203: dup
    //   204: iconst_0
    //   205: sipush 460
    //   208: iastore
    //   209: dup
    //   210: iconst_1
    //   211: sipush 469
    //   214: iastore
    //   215: ldc 55
    //   217: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   220: aload_0
    //   221: iconst_1
    //   222: newarray int
    //   224: dup
    //   225: iconst_0
    //   226: sipush 471
    //   229: iastore
    //   230: ldc 57
    //   232: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   235: aload_0
    //   236: iconst_1
    //   237: newarray int
    //   239: dup
    //   240: iconst_0
    //   241: sipush 474
    //   244: iastore
    //   245: ldc 59
    //   247: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   250: aload_0
    //   251: iconst_1
    //   252: newarray int
    //   254: dup
    //   255: iconst_0
    //   256: sipush 475
    //   259: iastore
    //   260: ldc 61
    //   262: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   265: aload_0
    //   266: iconst_1
    //   267: newarray int
    //   269: dup
    //   270: iconst_0
    //   271: sipush 476
    //   274: iastore
    //   275: ldc 63
    //   277: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   280: aload_0
    //   281: iconst_1
    //   282: newarray int
    //   284: dup
    //   285: iconst_0
    //   286: sipush 477
    //   289: iastore
    //   290: ldc 65
    //   292: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   295: aload_0
    //   296: iconst_1
    //   297: newarray int
    //   299: dup
    //   300: iconst_0
    //   301: sipush 478
    //   304: iastore
    //   305: ldc 67
    //   307: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   310: aload_0
    //   311: iconst_1
    //   312: newarray int
    //   314: dup
    //   315: iconst_0
    //   316: sipush 479
    //   319: iastore
    //   320: ldc 69
    //   322: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   325: aload_0
    //   326: iconst_1
    //   327: newarray int
    //   329: dup
    //   330: iconst_0
    //   331: sipush 480
    //   334: iastore
    //   335: ldc 71
    //   337: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   340: aload_0
    //   341: iconst_1
    //   342: newarray int
    //   344: dup
    //   345: iconst_0
    //   346: sipush 481
    //   349: iastore
    //   350: ldc 73
    //   352: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   355: aload_0
    //   356: iconst_1
    //   357: newarray int
    //   359: dup
    //   360: iconst_0
    //   361: sipush 482
    //   364: iastore
    //   365: ldc 75
    //   367: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   370: aload_0
    //   371: iconst_1
    //   372: newarray int
    //   374: dup
    //   375: iconst_0
    //   376: sipush 484
    //   379: iastore
    //   380: ldc 77
    //   382: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   385: aload_0
    //   386: iconst_1
    //   387: newarray int
    //   389: dup
    //   390: iconst_0
    //   391: sipush 485
    //   394: iastore
    //   395: ldc 79
    //   397: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   400: aload_0
    //   401: iconst_1
    //   402: newarray int
    //   404: dup
    //   405: iconst_0
    //   406: sipush 486
    //   409: iastore
    //   410: ldc 81
    //   412: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   415: aload_0
    //   416: iconst_1
    //   417: newarray int
    //   419: dup
    //   420: iconst_0
    //   421: sipush 487
    //   424: iastore
    //   425: ldc 83
    //   427: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   430: aload_0
    //   431: iconst_1
    //   432: newarray int
    //   434: dup
    //   435: iconst_0
    //   436: sipush 489
    //   439: iastore
    //   440: ldc 85
    //   442: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   445: aload_0
    //   446: iconst_2
    //   447: newarray int
    //   449: dup
    //   450: iconst_0
    //   451: sipush 490
    //   454: iastore
    //   455: dup
    //   456: iconst_1
    //   457: sipush 499
    //   460: iastore
    //   461: ldc 53
    //   463: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   466: aload_0
    //   467: iconst_2
    //   468: newarray int
    //   470: dup
    //   471: iconst_0
    //   472: sipush 500
    //   475: iastore
    //   476: dup
    //   477: iconst_1
    //   478: sipush 509
    //   481: iastore
    //   482: ldc 87
    //   484: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   487: aload_0
    //   488: iconst_1
    //   489: newarray int
    //   491: dup
    //   492: iconst_0
    //   493: sipush 520
    //   496: iastore
    //   497: ldc 89
    //   499: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   502: aload_0
    //   503: iconst_1
    //   504: newarray int
    //   506: dup
    //   507: iconst_0
    //   508: sipush 528
    //   511: iastore
    //   512: ldc 91
    //   514: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   517: aload_0
    //   518: iconst_1
    //   519: newarray int
    //   521: dup
    //   522: iconst_0
    //   523: sipush 529
    //   526: iastore
    //   527: ldc 93
    //   529: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   532: aload_0
    //   533: iconst_1
    //   534: newarray int
    //   536: dup
    //   537: iconst_0
    //   538: sipush 531
    //   541: iastore
    //   542: ldc 95
    //   544: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   547: aload_0
    //   548: iconst_1
    //   549: newarray int
    //   551: dup
    //   552: iconst_0
    //   553: sipush 535
    //   556: iastore
    //   557: ldc 97
    //   559: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   562: aload_0
    //   563: iconst_1
    //   564: newarray int
    //   566: dup
    //   567: iconst_0
    //   568: sipush 539
    //   571: iastore
    //   572: ldc 99
    //   574: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   577: aload_0
    //   578: iconst_2
    //   579: newarray int
    //   581: dup
    //   582: iconst_0
    //   583: sipush 540
    //   586: iastore
    //   587: dup
    //   588: iconst_1
    //   589: sipush 549
    //   592: iastore
    //   593: ldc 101
    //   595: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   598: aload_0
    //   599: iconst_1
    //   600: newarray int
    //   602: dup
    //   603: iconst_0
    //   604: sipush 560
    //   607: iastore
    //   608: ldc 103
    //   610: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   613: aload_0
    //   614: iconst_1
    //   615: newarray int
    //   617: dup
    //   618: iconst_0
    //   619: sipush 569
    //   622: iastore
    //   623: ldc 105
    //   625: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   628: aload_0
    //   629: iconst_2
    //   630: newarray int
    //   632: dup
    //   633: iconst_0
    //   634: sipush 570
    //   637: iastore
    //   638: dup
    //   639: iconst_1
    //   640: sipush 579
    //   643: iastore
    //   644: ldc 107
    //   646: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   649: aload_0
    //   650: iconst_1
    //   651: newarray int
    //   653: dup
    //   654: iconst_0
    //   655: sipush 590
    //   658: iastore
    //   659: ldc 109
    //   661: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   664: aload_0
    //   665: iconst_1
    //   666: newarray int
    //   668: dup
    //   669: iconst_0
    //   670: sipush 594
    //   673: iastore
    //   674: ldc 111
    //   676: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   679: aload_0
    //   680: iconst_1
    //   681: newarray int
    //   683: dup
    //   684: iconst_0
    //   685: sipush 599
    //   688: iastore
    //   689: ldc 113
    //   691: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   694: aload_0
    //   695: iconst_2
    //   696: newarray int
    //   698: dup
    //   699: iconst_0
    //   700: sipush 600
    //   703: iastore
    //   704: dup
    //   705: iconst_1
    //   706: sipush 601
    //   709: iastore
    //   710: ldc 115
    //   712: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   715: aload_0
    //   716: iconst_1
    //   717: newarray int
    //   719: dup
    //   720: iconst_0
    //   721: sipush 603
    //   724: iastore
    //   725: ldc 117
    //   727: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   730: aload_0
    //   731: iconst_1
    //   732: newarray int
    //   734: dup
    //   735: iconst_0
    //   736: sipush 608
    //   739: iastore
    //   740: ldc 119
    //   742: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   745: aload_0
    //   746: iconst_1
    //   747: newarray int
    //   749: dup
    //   750: iconst_0
    //   751: sipush 609
    //   754: iastore
    //   755: ldc 121
    //   757: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   760: aload_0
    //   761: iconst_1
    //   762: newarray int
    //   764: dup
    //   765: iconst_0
    //   766: sipush 611
    //   769: iastore
    //   770: ldc 123
    //   772: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   775: aload_0
    //   776: iconst_1
    //   777: newarray int
    //   779: dup
    //   780: iconst_0
    //   781: sipush 613
    //   784: iastore
    //   785: ldc 125
    //   787: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   790: aload_0
    //   791: iconst_1
    //   792: newarray int
    //   794: dup
    //   795: iconst_0
    //   796: sipush 616
    //   799: iastore
    //   800: ldc 127
    //   802: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   805: aload_0
    //   806: iconst_1
    //   807: newarray int
    //   809: dup
    //   810: iconst_0
    //   811: sipush 618
    //   814: iastore
    //   815: ldc 129
    //   817: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   820: aload_0
    //   821: iconst_1
    //   822: newarray int
    //   824: dup
    //   825: iconst_0
    //   826: sipush 619
    //   829: iastore
    //   830: ldc 131
    //   832: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   835: aload_0
    //   836: iconst_1
    //   837: newarray int
    //   839: dup
    //   840: iconst_0
    //   841: sipush 621
    //   844: iastore
    //   845: ldc 133
    //   847: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   850: aload_0
    //   851: iconst_1
    //   852: newarray int
    //   854: dup
    //   855: iconst_0
    //   856: sipush 622
    //   859: iastore
    //   860: ldc 135
    //   862: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   865: aload_0
    //   866: iconst_1
    //   867: newarray int
    //   869: dup
    //   870: iconst_0
    //   871: sipush 624
    //   874: iastore
    //   875: ldc 137
    //   877: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   880: aload_0
    //   881: iconst_1
    //   882: newarray int
    //   884: dup
    //   885: iconst_0
    //   886: sipush 625
    //   889: iastore
    //   890: ldc 139
    //   892: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   895: aload_0
    //   896: iconst_1
    //   897: newarray int
    //   899: dup
    //   900: iconst_0
    //   901: sipush 626
    //   904: iastore
    //   905: ldc 141
    //   907: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   910: aload_0
    //   911: iconst_1
    //   912: newarray int
    //   914: dup
    //   915: iconst_0
    //   916: sipush 627
    //   919: iastore
    //   920: ldc 143
    //   922: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   925: aload_0
    //   926: iconst_1
    //   927: newarray int
    //   929: dup
    //   930: iconst_0
    //   931: sipush 628
    //   934: iastore
    //   935: ldc 145
    //   937: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   940: aload_0
    //   941: iconst_1
    //   942: newarray int
    //   944: dup
    //   945: iconst_0
    //   946: sipush 629
    //   949: iastore
    //   950: ldc 147
    //   952: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   955: aload_0
    //   956: iconst_2
    //   957: newarray int
    //   959: dup
    //   960: iconst_0
    //   961: sipush 640
    //   964: iastore
    //   965: dup
    //   966: iconst_1
    //   967: sipush 649
    //   970: iastore
    //   971: ldc 149
    //   973: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   976: aload_0
    //   977: iconst_2
    //   978: newarray int
    //   980: dup
    //   981: iconst_0
    //   982: sipush 690
    //   985: iastore
    //   986: dup
    //   987: iconst_1
    //   988: sipush 695
    //   991: iastore
    //   992: ldc 151
    //   994: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   997: aload_0
    //   998: iconst_2
    //   999: newarray int
    //   1001: dup
    //   1002: iconst_0
    //   1003: sipush 700
    //   1006: iastore
    //   1007: dup
    //   1008: iconst_1
    //   1009: sipush 709
    //   1012: iastore
    //   1013: ldc 153
    //   1015: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1018: aload_0
    //   1019: iconst_1
    //   1020: newarray int
    //   1022: dup
    //   1023: iconst_0
    //   1024: sipush 729
    //   1027: iastore
    //   1028: ldc 155
    //   1030: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1033: aload_0
    //   1034: iconst_2
    //   1035: newarray int
    //   1037: dup
    //   1038: iconst_0
    //   1039: sipush 730
    //   1042: iastore
    //   1043: dup
    //   1044: iconst_1
    //   1045: sipush 739
    //   1048: iastore
    //   1049: ldc 157
    //   1051: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1054: aload_0
    //   1055: iconst_1
    //   1056: newarray int
    //   1058: dup
    //   1059: iconst_0
    //   1060: sipush 740
    //   1063: iastore
    //   1064: ldc 159
    //   1066: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1069: aload_0
    //   1070: iconst_1
    //   1071: newarray int
    //   1073: dup
    //   1074: iconst_0
    //   1075: sipush 741
    //   1078: iastore
    //   1079: ldc 161
    //   1081: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1084: aload_0
    //   1085: iconst_1
    //   1086: newarray int
    //   1088: dup
    //   1089: iconst_0
    //   1090: sipush 742
    //   1093: iastore
    //   1094: ldc 163
    //   1096: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1099: aload_0
    //   1100: iconst_1
    //   1101: newarray int
    //   1103: dup
    //   1104: iconst_0
    //   1105: sipush 743
    //   1108: iastore
    //   1109: ldc 165
    //   1111: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1114: aload_0
    //   1115: iconst_1
    //   1116: newarray int
    //   1118: dup
    //   1119: iconst_0
    //   1120: sipush 744
    //   1123: iastore
    //   1124: ldc 167
    //   1126: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1129: aload_0
    //   1130: iconst_1
    //   1131: newarray int
    //   1133: dup
    //   1134: iconst_0
    //   1135: sipush 745
    //   1138: iastore
    //   1139: ldc 169
    //   1141: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1144: aload_0
    //   1145: iconst_1
    //   1146: newarray int
    //   1148: dup
    //   1149: iconst_0
    //   1150: sipush 746
    //   1153: iastore
    //   1154: ldc 171
    //   1156: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1159: aload_0
    //   1160: iconst_1
    //   1161: newarray int
    //   1163: dup
    //   1164: iconst_0
    //   1165: sipush 750
    //   1168: iastore
    //   1169: ldc 173
    //   1171: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1174: aload_0
    //   1175: iconst_2
    //   1176: newarray int
    //   1178: dup
    //   1179: iconst_0
    //   1180: sipush 754
    //   1183: iastore
    //   1184: dup
    //   1185: iconst_1
    //   1186: sipush 755
    //   1189: iastore
    //   1190: ldc 175
    //   1192: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1195: aload_0
    //   1196: iconst_1
    //   1197: newarray int
    //   1199: dup
    //   1200: iconst_0
    //   1201: sipush 759
    //   1204: iastore
    //   1205: ldc 177
    //   1207: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1210: aload_0
    //   1211: iconst_2
    //   1212: newarray int
    //   1214: dup
    //   1215: iconst_0
    //   1216: sipush 760
    //   1219: iastore
    //   1220: dup
    //   1221: iconst_1
    //   1222: sipush 769
    //   1225: iastore
    //   1226: ldc 179
    //   1228: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1231: aload_0
    //   1232: iconst_1
    //   1233: newarray int
    //   1235: dup
    //   1236: iconst_0
    //   1237: sipush 770
    //   1240: iastore
    //   1241: ldc 181
    //   1243: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1246: aload_0
    //   1247: iconst_1
    //   1248: newarray int
    //   1250: dup
    //   1251: iconst_0
    //   1252: sipush 773
    //   1255: iastore
    //   1256: ldc 183
    //   1258: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1261: aload_0
    //   1262: iconst_1
    //   1263: newarray int
    //   1265: dup
    //   1266: iconst_0
    //   1267: sipush 775
    //   1270: iastore
    //   1271: ldc 185
    //   1273: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1276: aload_0
    //   1277: iconst_1
    //   1278: newarray int
    //   1280: dup
    //   1281: iconst_0
    //   1282: sipush 777
    //   1285: iastore
    //   1286: ldc 187
    //   1288: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1291: aload_0
    //   1292: iconst_1
    //   1293: newarray int
    //   1295: dup
    //   1296: iconst_0
    //   1297: sipush 779
    //   1300: iastore
    //   1301: ldc 189
    //   1303: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1306: aload_0
    //   1307: iconst_1
    //   1308: newarray int
    //   1310: dup
    //   1311: iconst_0
    //   1312: sipush 780
    //   1315: iastore
    //   1316: ldc 191
    //   1318: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1321: aload_0
    //   1322: iconst_1
    //   1323: newarray int
    //   1325: dup
    //   1326: iconst_0
    //   1327: sipush 784
    //   1330: iastore
    //   1331: ldc 193
    //   1333: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1336: aload_0
    //   1337: iconst_1
    //   1338: newarray int
    //   1340: dup
    //   1341: iconst_0
    //   1342: sipush 785
    //   1345: iastore
    //   1346: ldc 185
    //   1348: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1351: aload_0
    //   1352: iconst_1
    //   1353: newarray int
    //   1355: dup
    //   1356: iconst_0
    //   1357: sipush 786
    //   1360: iastore
    //   1361: ldc 195
    //   1363: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1366: aload_0
    //   1367: iconst_2
    //   1368: newarray int
    //   1370: dup
    //   1371: iconst_0
    //   1372: sipush 789
    //   1375: iastore
    //   1376: dup
    //   1377: iconst_1
    //   1378: sipush 790
    //   1381: iastore
    //   1382: ldc 197
    //   1384: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1387: aload_0
    //   1388: iconst_2
    //   1389: newarray int
    //   1391: dup
    //   1392: iconst_0
    //   1393: sipush 800
    //   1396: iastore
    //   1397: dup
    //   1398: iconst_1
    //   1399: sipush 839
    //   1402: iastore
    //   1403: ldc 199
    //   1405: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1408: aload_0
    //   1409: iconst_2
    //   1410: newarray int
    //   1412: dup
    //   1413: iconst_0
    //   1414: sipush 840
    //   1417: iastore
    //   1418: dup
    //   1419: iconst_1
    //   1420: sipush 849
    //   1423: iastore
    //   1424: ldc 201
    //   1426: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1429: aload_0
    //   1430: iconst_1
    //   1431: newarray int
    //   1433: dup
    //   1434: iconst_0
    //   1435: sipush 850
    //   1438: iastore
    //   1439: ldc 203
    //   1441: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1444: aload_0
    //   1445: iconst_1
    //   1446: newarray int
    //   1448: dup
    //   1449: iconst_0
    //   1450: sipush 858
    //   1453: iastore
    //   1454: ldc 205
    //   1456: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1459: aload_0
    //   1460: iconst_1
    //   1461: newarray int
    //   1463: dup
    //   1464: iconst_0
    //   1465: sipush 859
    //   1468: iastore
    //   1469: ldc 207
    //   1471: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1474: aload_0
    //   1475: iconst_1
    //   1476: newarray int
    //   1478: dup
    //   1479: iconst_0
    //   1480: sipush 860
    //   1483: iastore
    //   1484: ldc 209
    //   1486: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1489: aload_0
    //   1490: iconst_1
    //   1491: newarray int
    //   1493: dup
    //   1494: iconst_0
    //   1495: sipush 865
    //   1498: iastore
    //   1499: ldc 211
    //   1501: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1504: aload_0
    //   1505: iconst_1
    //   1506: newarray int
    //   1508: dup
    //   1509: iconst_0
    //   1510: sipush 867
    //   1513: iastore
    //   1514: ldc 213
    //   1516: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1519: aload_0
    //   1520: iconst_2
    //   1521: newarray int
    //   1523: dup
    //   1524: iconst_0
    //   1525: sipush 868
    //   1528: iastore
    //   1529: dup
    //   1530: iconst_1
    //   1531: sipush 869
    //   1534: iastore
    //   1535: ldc 215
    //   1537: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1540: aload_0
    //   1541: iconst_2
    //   1542: newarray int
    //   1544: dup
    //   1545: iconst_0
    //   1546: sipush 870
    //   1549: iastore
    //   1550: dup
    //   1551: iconst_1
    //   1552: sipush 879
    //   1555: iastore
    //   1556: ldc 217
    //   1558: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1561: aload_0
    //   1562: iconst_1
    //   1563: newarray int
    //   1565: dup
    //   1566: iconst_0
    //   1567: sipush 880
    //   1570: iastore
    //   1571: ldc 219
    //   1573: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1576: aload_0
    //   1577: iconst_1
    //   1578: newarray int
    //   1580: dup
    //   1581: iconst_0
    //   1582: sipush 885
    //   1585: iastore
    //   1586: ldc 221
    //   1588: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1591: aload_0
    //   1592: iconst_1
    //   1593: newarray int
    //   1595: dup
    //   1596: iconst_0
    //   1597: sipush 888
    //   1600: iastore
    //   1601: ldc 223
    //   1603: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1606: aload_0
    //   1607: iconst_1
    //   1608: newarray int
    //   1610: dup
    //   1611: iconst_0
    //   1612: sipush 890
    //   1615: iastore
    //   1616: ldc 225
    //   1618: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1621: aload_0
    //   1622: iconst_1
    //   1623: newarray int
    //   1625: dup
    //   1626: iconst_0
    //   1627: sipush 893
    //   1630: iastore
    //   1631: ldc 227
    //   1633: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1636: aload_0
    //   1637: iconst_1
    //   1638: newarray int
    //   1640: dup
    //   1641: iconst_0
    //   1642: sipush 896
    //   1645: iastore
    //   1646: ldc 229
    //   1648: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1651: aload_0
    //   1652: iconst_1
    //   1653: newarray int
    //   1655: dup
    //   1656: iconst_0
    //   1657: sipush 899
    //   1660: iastore
    //   1661: ldc 231
    //   1663: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1666: aload_0
    //   1667: iconst_2
    //   1668: newarray int
    //   1670: dup
    //   1671: iconst_0
    //   1672: sipush 900
    //   1675: iastore
    //   1676: dup
    //   1677: iconst_1
    //   1678: sipush 919
    //   1681: iastore
    //   1682: ldc 233
    //   1684: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1687: aload_0
    //   1688: iconst_2
    //   1689: newarray int
    //   1691: dup
    //   1692: iconst_0
    //   1693: sipush 930
    //   1696: iastore
    //   1697: dup
    //   1698: iconst_1
    //   1699: sipush 939
    //   1702: iastore
    //   1703: ldc 235
    //   1705: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1708: aload_0
    //   1709: iconst_2
    //   1710: newarray int
    //   1712: dup
    //   1713: iconst_0
    //   1714: sipush 940
    //   1717: iastore
    //   1718: dup
    //   1719: iconst_1
    //   1720: sipush 949
    //   1723: iastore
    //   1724: ldc 63
    //   1726: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1729: aload_0
    //   1730: iconst_1
    //   1731: newarray int
    //   1733: dup
    //   1734: iconst_0
    //   1735: sipush 955
    //   1738: iastore
    //   1739: ldc 237
    //   1741: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1744: aload_0
    //   1745: iconst_1
    //   1746: newarray int
    //   1748: dup
    //   1749: iconst_0
    //   1750: sipush 958
    //   1753: iastore
    //   1754: ldc 239
    //   1756: invokespecial 37	com/tencent/mobileqq/mini/zxing/oned/EANManufacturerOrgSupport:add	([ILjava/lang/String;)V
    //   1759: goto -1743 -> 16
    //   1762: astore_2
    //   1763: aload_0
    //   1764: monitorexit
    //   1765: aload_2
    //   1766: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1767	0	this	EANManufacturerOrgSupport
    //   11	2	1	bool	boolean
    //   1762	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	1762	finally
    //   19	1759	1762	finally
  }
  
  String lookupCountryIdentifier(String paramString)
  {
    initIfNeeded();
    int k = Integer.parseInt(paramString.substring(0, 3));
    int m = this.ranges.size();
    int i = 0;
    while (i < m)
    {
      paramString = (int[])this.ranges.get(i);
      int j = paramString[0];
      if (k < j) {
        return null;
      }
      if (paramString.length == 1) {}
      while (k <= j)
      {
        return (String)this.countryIdentifiers.get(i);
        j = paramString[1];
      }
      i += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.zxing.oned.EANManufacturerOrgSupport
 * JD-Core Version:    0.7.0.1
 */