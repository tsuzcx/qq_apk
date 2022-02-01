package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/StreamingHprofReader;", "", "sourceProvider", "Lshark/StreamingSourceProvider;", "header", "Lshark/HprofHeader;", "(Lshark/StreamingSourceProvider;Lshark/HprofHeader;)V", "readRecords", "", "recordTags", "", "Lshark/HprofRecordTag;", "listener", "Lshark/OnHprofRecordTagListener;", "Companion", "shark-hprof"}, k=1, mv={1, 4, 1})
public final class StreamingHprofReader
{
  @NotNull
  public static final StreamingHprofReader.Companion a = new StreamingHprofReader.Companion(null);
  private final StreamingSourceProvider b;
  private final HprofHeader c;
  
  private StreamingHprofReader(StreamingSourceProvider paramStreamingSourceProvider, HprofHeader paramHprofHeader)
  {
    this.b = paramStreamingSourceProvider;
    this.c = paramHprofHeader;
  }
  
  /* Error */
  public final long a(@NotNull java.util.Set<? extends HprofRecordTag> paramSet, @NotNull OnHprofRecordTagListener paramOnHprofRecordTagListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 58
    //   3: invokestatic 64	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 65
    //   9: invokestatic 64	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield 49	shark/StreamingHprofReader:b	Lshark/StreamingSourceProvider;
    //   16: invokeinterface 70 1 0
    //   21: checkcast 72	java/io/Closeable
    //   24: astore 17
    //   26: aconst_null
    //   27: checkcast 57	java/lang/Throwable
    //   30: astore 18
    //   32: aload 17
    //   34: astore 21
    //   36: aload 18
    //   38: astore 20
    //   40: aload 17
    //   42: astore 19
    //   44: aload 17
    //   46: checkcast 74	okio/BufferedSource
    //   49: astore 25
    //   51: aload 17
    //   53: astore 21
    //   55: aload 18
    //   57: astore 20
    //   59: aload 17
    //   61: astore 19
    //   63: new 76	shark/HprofRecordReader
    //   66: dup
    //   67: aload_0
    //   68: getfield 51	shark/StreamingHprofReader:c	Lshark/HprofHeader;
    //   71: aload 25
    //   73: invokespecial 79	shark/HprofRecordReader:<init>	(Lshark/HprofHeader;Lokio/BufferedSource;)V
    //   76: astore 24
    //   78: aload 17
    //   80: astore 21
    //   82: aload 18
    //   84: astore 20
    //   86: aload 17
    //   88: astore 19
    //   90: aload 24
    //   92: aload_0
    //   93: getfield 51	shark/StreamingHprofReader:c	Lshark/HprofHeader;
    //   96: invokevirtual 84	shark/HprofHeader:a	()I
    //   99: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   102: aload 17
    //   104: astore 21
    //   106: aload 18
    //   108: astore 20
    //   110: aload 17
    //   112: astore 19
    //   114: getstatic 93	shark/PrimitiveType:INT	Lshark/PrimitiveType;
    //   117: invokevirtual 96	shark/PrimitiveType:getByteSize	()I
    //   120: istore 5
    //   122: aload 17
    //   124: astore 21
    //   126: aload 18
    //   128: astore 20
    //   130: aload 17
    //   132: astore 19
    //   134: aload 24
    //   136: iconst_2
    //   137: invokevirtual 99	shark/HprofRecordReader:a	(I)I
    //   140: istore 6
    //   142: aload 17
    //   144: astore 21
    //   146: aload 18
    //   148: astore 20
    //   150: aload 17
    //   152: astore 19
    //   154: aload 25
    //   156: invokeinterface 103 1 0
    //   161: istore 8
    //   163: iload 8
    //   165: ifne +3372 -> 3537
    //   168: aload 17
    //   170: astore 21
    //   172: aload 18
    //   174: astore 20
    //   176: aload 17
    //   178: astore 19
    //   180: aload 24
    //   182: invokevirtual 106	shark/HprofRecordReader:J	()I
    //   185: istore_3
    //   186: aload 17
    //   188: astore 21
    //   190: aload 18
    //   192: astore 20
    //   194: aload 17
    //   196: astore 19
    //   198: aload 24
    //   200: iload 5
    //   202: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   205: aload 17
    //   207: astore 21
    //   209: aload 18
    //   211: astore 20
    //   213: aload 17
    //   215: astore 19
    //   217: aload 24
    //   219: invokevirtual 110	shark/HprofRecordReader:I	()J
    //   222: lstore 9
    //   224: aload 17
    //   226: astore 21
    //   228: aload 18
    //   230: astore 20
    //   232: aload 17
    //   234: astore 19
    //   236: getstatic 115	shark/HprofRecordTag:STRING_IN_UTF8	Lshark/HprofRecordTag;
    //   239: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   242: istore 4
    //   244: iload_3
    //   245: iload 4
    //   247: if_icmpne +97 -> 344
    //   250: aload 17
    //   252: astore 21
    //   254: aload 18
    //   256: astore 20
    //   258: aload 17
    //   260: astore 19
    //   262: aload_1
    //   263: getstatic 115	shark/HprofRecordTag:STRING_IN_UTF8	Lshark/HprofRecordTag;
    //   266: invokeinterface 124 2 0
    //   271: ifeq +39 -> 310
    //   274: aload 17
    //   276: astore 21
    //   278: aload 18
    //   280: astore 20
    //   282: aload 17
    //   284: astore 19
    //   286: aload_2
    //   287: getstatic 115	shark/HprofRecordTag:STRING_IN_UTF8	Lshark/HprofRecordTag;
    //   290: lload 9
    //   292: aload 24
    //   294: invokeinterface 129 5 0
    //   299: aload 17
    //   301: astore 23
    //   303: aload 18
    //   305: astore 22
    //   307: goto +30 -> 337
    //   310: aload 17
    //   312: astore 21
    //   314: aload 18
    //   316: astore 20
    //   318: aload 17
    //   320: astore 19
    //   322: aload 24
    //   324: lload 9
    //   326: invokevirtual 132	shark/HprofRecordReader:b	(J)V
    //   329: aload 18
    //   331: astore 22
    //   333: aload 17
    //   335: astore 23
    //   337: aload 23
    //   339: astore 21
    //   341: goto +3173 -> 3514
    //   344: aload 17
    //   346: astore 21
    //   348: aload 18
    //   350: astore 20
    //   352: aload 17
    //   354: astore 19
    //   356: getstatic 135	shark/HprofRecordTag:LOAD_CLASS	Lshark/HprofRecordTag;
    //   359: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   362: istore 4
    //   364: iload_3
    //   365: iload 4
    //   367: if_icmpne +93 -> 460
    //   370: aload 17
    //   372: astore 21
    //   374: aload 18
    //   376: astore 20
    //   378: aload 17
    //   380: astore 19
    //   382: aload_1
    //   383: getstatic 135	shark/HprofRecordTag:LOAD_CLASS	Lshark/HprofRecordTag;
    //   386: invokeinterface 124 2 0
    //   391: ifeq +39 -> 430
    //   394: aload 17
    //   396: astore 21
    //   398: aload 18
    //   400: astore 20
    //   402: aload 17
    //   404: astore 19
    //   406: aload_2
    //   407: getstatic 135	shark/HprofRecordTag:LOAD_CLASS	Lshark/HprofRecordTag;
    //   410: lload 9
    //   412: aload 24
    //   414: invokeinterface 129 5 0
    //   419: aload 17
    //   421: astore 23
    //   423: aload 18
    //   425: astore 22
    //   427: goto -90 -> 337
    //   430: aload 17
    //   432: astore 21
    //   434: aload 18
    //   436: astore 20
    //   438: aload 17
    //   440: astore 19
    //   442: aload 24
    //   444: lload 9
    //   446: invokevirtual 132	shark/HprofRecordReader:b	(J)V
    //   449: aload 17
    //   451: astore 23
    //   453: aload 18
    //   455: astore 22
    //   457: goto -120 -> 337
    //   460: aload 17
    //   462: astore 21
    //   464: aload 18
    //   466: astore 20
    //   468: aload 17
    //   470: astore 19
    //   472: getstatic 138	shark/HprofRecordTag:STACK_FRAME	Lshark/HprofRecordTag;
    //   475: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   478: istore 4
    //   480: iload_3
    //   481: iload 4
    //   483: if_icmpne +93 -> 576
    //   486: aload 17
    //   488: astore 21
    //   490: aload 18
    //   492: astore 20
    //   494: aload 17
    //   496: astore 19
    //   498: aload_1
    //   499: getstatic 138	shark/HprofRecordTag:STACK_FRAME	Lshark/HprofRecordTag;
    //   502: invokeinterface 124 2 0
    //   507: ifeq +39 -> 546
    //   510: aload 17
    //   512: astore 21
    //   514: aload 18
    //   516: astore 20
    //   518: aload 17
    //   520: astore 19
    //   522: aload_2
    //   523: getstatic 138	shark/HprofRecordTag:STACK_FRAME	Lshark/HprofRecordTag;
    //   526: lload 9
    //   528: aload 24
    //   530: invokeinterface 129 5 0
    //   535: aload 17
    //   537: astore 23
    //   539: aload 18
    //   541: astore 22
    //   543: goto -206 -> 337
    //   546: aload 17
    //   548: astore 21
    //   550: aload 18
    //   552: astore 20
    //   554: aload 17
    //   556: astore 19
    //   558: aload 24
    //   560: lload 9
    //   562: invokevirtual 132	shark/HprofRecordReader:b	(J)V
    //   565: aload 17
    //   567: astore 23
    //   569: aload 18
    //   571: astore 22
    //   573: goto -236 -> 337
    //   576: aload 17
    //   578: astore 21
    //   580: aload 18
    //   582: astore 20
    //   584: aload 17
    //   586: astore 19
    //   588: getstatic 141	shark/HprofRecordTag:STACK_TRACE	Lshark/HprofRecordTag;
    //   591: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   594: istore 4
    //   596: iload_3
    //   597: iload 4
    //   599: if_icmpne +93 -> 692
    //   602: aload 17
    //   604: astore 21
    //   606: aload 18
    //   608: astore 20
    //   610: aload 17
    //   612: astore 19
    //   614: aload_1
    //   615: getstatic 141	shark/HprofRecordTag:STACK_TRACE	Lshark/HprofRecordTag;
    //   618: invokeinterface 124 2 0
    //   623: ifeq +39 -> 662
    //   626: aload 17
    //   628: astore 21
    //   630: aload 18
    //   632: astore 20
    //   634: aload 17
    //   636: astore 19
    //   638: aload_2
    //   639: getstatic 141	shark/HprofRecordTag:STACK_TRACE	Lshark/HprofRecordTag;
    //   642: lload 9
    //   644: aload 24
    //   646: invokeinterface 129 5 0
    //   651: aload 17
    //   653: astore 23
    //   655: aload 18
    //   657: astore 22
    //   659: goto -322 -> 337
    //   662: aload 17
    //   664: astore 21
    //   666: aload 18
    //   668: astore 20
    //   670: aload 17
    //   672: astore 19
    //   674: aload 24
    //   676: lload 9
    //   678: invokevirtual 132	shark/HprofRecordReader:b	(J)V
    //   681: aload 17
    //   683: astore 23
    //   685: aload 18
    //   687: astore 22
    //   689: goto -352 -> 337
    //   692: aload 17
    //   694: astore 21
    //   696: aload 18
    //   698: astore 20
    //   700: aload 17
    //   702: astore 19
    //   704: iload_3
    //   705: getstatic 144	shark/HprofRecordTag:HEAP_DUMP	Lshark/HprofRecordTag;
    //   708: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   711: if_icmpne +6 -> 717
    //   714: goto +25 -> 739
    //   717: aload 17
    //   719: astore 21
    //   721: aload 18
    //   723: astore 20
    //   725: aload 17
    //   727: astore 19
    //   729: iload_3
    //   730: getstatic 147	shark/HprofRecordTag:HEAP_DUMP_SEGMENT	Lshark/HprofRecordTag;
    //   733: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   736: if_icmpne +2657 -> 3393
    //   739: aload 17
    //   741: astore 21
    //   743: aload 18
    //   745: astore 20
    //   747: aload 17
    //   749: astore 19
    //   751: aload 24
    //   753: invokevirtual 149	shark/HprofRecordReader:a	()J
    //   756: lstore 15
    //   758: lconst_0
    //   759: lstore 11
    //   761: iconst_0
    //   762: istore_3
    //   763: aload 17
    //   765: astore 23
    //   767: aload 18
    //   769: astore 22
    //   771: aload 17
    //   773: astore 21
    //   775: aload 18
    //   777: astore 20
    //   779: aload 17
    //   781: astore 19
    //   783: aload 24
    //   785: invokevirtual 149	shark/HprofRecordReader:a	()J
    //   788: lload 15
    //   790: lsub
    //   791: lload 9
    //   793: lcmp
    //   794: ifge -457 -> 337
    //   797: aload 17
    //   799: astore 21
    //   801: aload 18
    //   803: astore 20
    //   805: aload 17
    //   807: astore 19
    //   809: aload 24
    //   811: invokevirtual 149	shark/HprofRecordReader:a	()J
    //   814: lstore 13
    //   816: aload 17
    //   818: astore 21
    //   820: aload 18
    //   822: astore 20
    //   824: aload 17
    //   826: astore 19
    //   828: aload 24
    //   830: invokevirtual 106	shark/HprofRecordReader:J	()I
    //   833: istore 4
    //   835: aload 17
    //   837: astore 21
    //   839: aload 18
    //   841: astore 20
    //   843: aload 17
    //   845: astore 19
    //   847: getstatic 152	shark/HprofRecordTag:ROOT_UNKNOWN	Lshark/HprofRecordTag;
    //   850: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   853: istore 7
    //   855: aload 18
    //   857: astore 21
    //   859: iload 4
    //   861: iload 7
    //   863: if_icmpne +78 -> 941
    //   866: aload 17
    //   868: astore 18
    //   870: aload 17
    //   872: astore 19
    //   874: aload 21
    //   876: astore 20
    //   878: aload_1
    //   879: getstatic 152	shark/HprofRecordTag:ROOT_UNKNOWN	Lshark/HprofRecordTag;
    //   882: invokeinterface 124 2 0
    //   887: ifeq +32 -> 919
    //   890: aload 17
    //   892: astore 18
    //   894: aload 17
    //   896: astore 19
    //   898: aload 21
    //   900: astore 20
    //   902: aload_2
    //   903: getstatic 152	shark/HprofRecordTag:ROOT_UNKNOWN	Lshark/HprofRecordTag;
    //   906: ldc2_w 153
    //   909: aload 24
    //   911: invokeinterface 129 5 0
    //   916: goto +2694 -> 3610
    //   919: aload 17
    //   921: astore 18
    //   923: aload 17
    //   925: astore 19
    //   927: aload 21
    //   929: astore 20
    //   931: aload 24
    //   933: iload 6
    //   935: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   938: goto +2672 -> 3610
    //   941: aload 17
    //   943: astore 18
    //   945: aload 17
    //   947: astore 19
    //   949: aload 21
    //   951: astore 20
    //   953: iload 4
    //   955: getstatic 157	shark/HprofRecordTag:ROOT_JNI_GLOBAL	Lshark/HprofRecordTag;
    //   958: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   961: if_icmpne +81 -> 1042
    //   964: aload 17
    //   966: astore 18
    //   968: aload 17
    //   970: astore 19
    //   972: aload 21
    //   974: astore 20
    //   976: aload_1
    //   977: getstatic 157	shark/HprofRecordTag:ROOT_JNI_GLOBAL	Lshark/HprofRecordTag;
    //   980: invokeinterface 124 2 0
    //   985: ifeq +32 -> 1017
    //   988: aload 17
    //   990: astore 18
    //   992: aload 17
    //   994: astore 19
    //   996: aload 21
    //   998: astore 20
    //   1000: aload_2
    //   1001: getstatic 157	shark/HprofRecordTag:ROOT_JNI_GLOBAL	Lshark/HprofRecordTag;
    //   1004: ldc2_w 153
    //   1007: aload 24
    //   1009: invokeinterface 129 5 0
    //   1014: goto +2596 -> 3610
    //   1017: aload 17
    //   1019: astore 18
    //   1021: aload 17
    //   1023: astore 19
    //   1025: aload 21
    //   1027: astore 20
    //   1029: aload 24
    //   1031: iload 6
    //   1033: iload 6
    //   1035: iadd
    //   1036: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1039: goto +2571 -> 3610
    //   1042: aload 17
    //   1044: astore 18
    //   1046: aload 17
    //   1048: astore 19
    //   1050: aload 21
    //   1052: astore 20
    //   1054: iload 4
    //   1056: getstatic 160	shark/HprofRecordTag:ROOT_JNI_LOCAL	Lshark/HprofRecordTag;
    //   1059: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1062: if_icmpne +84 -> 1146
    //   1065: aload 17
    //   1067: astore 18
    //   1069: aload 17
    //   1071: astore 19
    //   1073: aload 21
    //   1075: astore 20
    //   1077: aload_1
    //   1078: getstatic 160	shark/HprofRecordTag:ROOT_JNI_LOCAL	Lshark/HprofRecordTag;
    //   1081: invokeinterface 124 2 0
    //   1086: ifeq +32 -> 1118
    //   1089: aload 17
    //   1091: astore 18
    //   1093: aload 17
    //   1095: astore 19
    //   1097: aload 21
    //   1099: astore 20
    //   1101: aload_2
    //   1102: getstatic 160	shark/HprofRecordTag:ROOT_JNI_LOCAL	Lshark/HprofRecordTag;
    //   1105: ldc2_w 153
    //   1108: aload 24
    //   1110: invokeinterface 129 5 0
    //   1115: goto +2495 -> 3610
    //   1118: aload 17
    //   1120: astore 18
    //   1122: aload 17
    //   1124: astore 19
    //   1126: aload 21
    //   1128: astore 20
    //   1130: aload 24
    //   1132: iload 6
    //   1134: iload 5
    //   1136: iadd
    //   1137: iload 5
    //   1139: iadd
    //   1140: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1143: goto +2467 -> 3610
    //   1146: aload 17
    //   1148: astore 18
    //   1150: aload 17
    //   1152: astore 19
    //   1154: aload 21
    //   1156: astore 20
    //   1158: iload 4
    //   1160: getstatic 163	shark/HprofRecordTag:ROOT_JAVA_FRAME	Lshark/HprofRecordTag;
    //   1163: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1166: if_icmpne +84 -> 1250
    //   1169: aload 17
    //   1171: astore 18
    //   1173: aload 17
    //   1175: astore 19
    //   1177: aload 21
    //   1179: astore 20
    //   1181: aload_1
    //   1182: getstatic 163	shark/HprofRecordTag:ROOT_JAVA_FRAME	Lshark/HprofRecordTag;
    //   1185: invokeinterface 124 2 0
    //   1190: ifeq +32 -> 1222
    //   1193: aload 17
    //   1195: astore 18
    //   1197: aload 17
    //   1199: astore 19
    //   1201: aload 21
    //   1203: astore 20
    //   1205: aload_2
    //   1206: getstatic 163	shark/HprofRecordTag:ROOT_JAVA_FRAME	Lshark/HprofRecordTag;
    //   1209: ldc2_w 153
    //   1212: aload 24
    //   1214: invokeinterface 129 5 0
    //   1219: goto +2391 -> 3610
    //   1222: aload 17
    //   1224: astore 18
    //   1226: aload 17
    //   1228: astore 19
    //   1230: aload 21
    //   1232: astore 20
    //   1234: aload 24
    //   1236: iload 6
    //   1238: iload 5
    //   1240: iadd
    //   1241: iload 5
    //   1243: iadd
    //   1244: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1247: goto +2363 -> 3610
    //   1250: aload 17
    //   1252: astore 18
    //   1254: aload 17
    //   1256: astore 19
    //   1258: aload 21
    //   1260: astore 20
    //   1262: iload 4
    //   1264: getstatic 166	shark/HprofRecordTag:ROOT_NATIVE_STACK	Lshark/HprofRecordTag;
    //   1267: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1270: if_icmpne +81 -> 1351
    //   1273: aload 17
    //   1275: astore 18
    //   1277: aload 17
    //   1279: astore 19
    //   1281: aload 21
    //   1283: astore 20
    //   1285: aload_1
    //   1286: getstatic 166	shark/HprofRecordTag:ROOT_NATIVE_STACK	Lshark/HprofRecordTag;
    //   1289: invokeinterface 124 2 0
    //   1294: ifeq +32 -> 1326
    //   1297: aload 17
    //   1299: astore 18
    //   1301: aload 17
    //   1303: astore 19
    //   1305: aload 21
    //   1307: astore 20
    //   1309: aload_2
    //   1310: getstatic 166	shark/HprofRecordTag:ROOT_NATIVE_STACK	Lshark/HprofRecordTag;
    //   1313: ldc2_w 153
    //   1316: aload 24
    //   1318: invokeinterface 129 5 0
    //   1323: goto +2287 -> 3610
    //   1326: aload 17
    //   1328: astore 18
    //   1330: aload 17
    //   1332: astore 19
    //   1334: aload 21
    //   1336: astore 20
    //   1338: aload 24
    //   1340: iload 6
    //   1342: iload 5
    //   1344: iadd
    //   1345: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1348: goto +2262 -> 3610
    //   1351: aload 17
    //   1353: astore 18
    //   1355: aload 17
    //   1357: astore 19
    //   1359: aload 21
    //   1361: astore 20
    //   1363: iload 4
    //   1365: getstatic 169	shark/HprofRecordTag:ROOT_STICKY_CLASS	Lshark/HprofRecordTag;
    //   1368: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1371: if_icmpne +78 -> 1449
    //   1374: aload 17
    //   1376: astore 18
    //   1378: aload 17
    //   1380: astore 19
    //   1382: aload 21
    //   1384: astore 20
    //   1386: aload_1
    //   1387: getstatic 169	shark/HprofRecordTag:ROOT_STICKY_CLASS	Lshark/HprofRecordTag;
    //   1390: invokeinterface 124 2 0
    //   1395: ifeq +32 -> 1427
    //   1398: aload 17
    //   1400: astore 18
    //   1402: aload 17
    //   1404: astore 19
    //   1406: aload 21
    //   1408: astore 20
    //   1410: aload_2
    //   1411: getstatic 169	shark/HprofRecordTag:ROOT_STICKY_CLASS	Lshark/HprofRecordTag;
    //   1414: ldc2_w 153
    //   1417: aload 24
    //   1419: invokeinterface 129 5 0
    //   1424: goto +2186 -> 3610
    //   1427: aload 17
    //   1429: astore 18
    //   1431: aload 17
    //   1433: astore 19
    //   1435: aload 21
    //   1437: astore 20
    //   1439: aload 24
    //   1441: iload 6
    //   1443: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1446: goto +2164 -> 3610
    //   1449: aload 17
    //   1451: astore 18
    //   1453: aload 17
    //   1455: astore 19
    //   1457: aload 21
    //   1459: astore 20
    //   1461: iload 4
    //   1463: getstatic 172	shark/HprofRecordTag:ROOT_THREAD_BLOCK	Lshark/HprofRecordTag;
    //   1466: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1469: if_icmpne +81 -> 1550
    //   1472: aload 17
    //   1474: astore 18
    //   1476: aload 17
    //   1478: astore 19
    //   1480: aload 21
    //   1482: astore 20
    //   1484: aload_1
    //   1485: getstatic 172	shark/HprofRecordTag:ROOT_THREAD_BLOCK	Lshark/HprofRecordTag;
    //   1488: invokeinterface 124 2 0
    //   1493: ifeq +32 -> 1525
    //   1496: aload 17
    //   1498: astore 18
    //   1500: aload 17
    //   1502: astore 19
    //   1504: aload 21
    //   1506: astore 20
    //   1508: aload_2
    //   1509: getstatic 172	shark/HprofRecordTag:ROOT_THREAD_BLOCK	Lshark/HprofRecordTag;
    //   1512: ldc2_w 153
    //   1515: aload 24
    //   1517: invokeinterface 129 5 0
    //   1522: goto +2088 -> 3610
    //   1525: aload 17
    //   1527: astore 18
    //   1529: aload 17
    //   1531: astore 19
    //   1533: aload 21
    //   1535: astore 20
    //   1537: aload 24
    //   1539: iload 6
    //   1541: iload 5
    //   1543: iadd
    //   1544: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1547: goto +2063 -> 3610
    //   1550: aload 17
    //   1552: astore 18
    //   1554: aload 17
    //   1556: astore 19
    //   1558: aload 21
    //   1560: astore 20
    //   1562: iload 4
    //   1564: getstatic 175	shark/HprofRecordTag:ROOT_MONITOR_USED	Lshark/HprofRecordTag;
    //   1567: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1570: if_icmpne +78 -> 1648
    //   1573: aload 17
    //   1575: astore 18
    //   1577: aload 17
    //   1579: astore 19
    //   1581: aload 21
    //   1583: astore 20
    //   1585: aload_1
    //   1586: getstatic 175	shark/HprofRecordTag:ROOT_MONITOR_USED	Lshark/HprofRecordTag;
    //   1589: invokeinterface 124 2 0
    //   1594: ifeq +32 -> 1626
    //   1597: aload 17
    //   1599: astore 18
    //   1601: aload 17
    //   1603: astore 19
    //   1605: aload 21
    //   1607: astore 20
    //   1609: aload_2
    //   1610: getstatic 175	shark/HprofRecordTag:ROOT_MONITOR_USED	Lshark/HprofRecordTag;
    //   1613: ldc2_w 153
    //   1616: aload 24
    //   1618: invokeinterface 129 5 0
    //   1623: goto +1987 -> 3610
    //   1626: aload 17
    //   1628: astore 18
    //   1630: aload 17
    //   1632: astore 19
    //   1634: aload 21
    //   1636: astore 20
    //   1638: aload 24
    //   1640: iload 6
    //   1642: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1645: goto +1965 -> 3610
    //   1648: aload 17
    //   1650: astore 18
    //   1652: aload 17
    //   1654: astore 19
    //   1656: aload 21
    //   1658: astore 20
    //   1660: iload 4
    //   1662: getstatic 178	shark/HprofRecordTag:ROOT_THREAD_OBJECT	Lshark/HprofRecordTag;
    //   1665: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1668: if_icmpne +84 -> 1752
    //   1671: aload 17
    //   1673: astore 18
    //   1675: aload 17
    //   1677: astore 19
    //   1679: aload 21
    //   1681: astore 20
    //   1683: aload_1
    //   1684: getstatic 178	shark/HprofRecordTag:ROOT_THREAD_OBJECT	Lshark/HprofRecordTag;
    //   1687: invokeinterface 124 2 0
    //   1692: ifeq +32 -> 1724
    //   1695: aload 17
    //   1697: astore 18
    //   1699: aload 17
    //   1701: astore 19
    //   1703: aload 21
    //   1705: astore 20
    //   1707: aload_2
    //   1708: getstatic 178	shark/HprofRecordTag:ROOT_THREAD_OBJECT	Lshark/HprofRecordTag;
    //   1711: ldc2_w 153
    //   1714: aload 24
    //   1716: invokeinterface 129 5 0
    //   1721: goto +1889 -> 3610
    //   1724: aload 17
    //   1726: astore 18
    //   1728: aload 17
    //   1730: astore 19
    //   1732: aload 21
    //   1734: astore 20
    //   1736: aload 24
    //   1738: iload 6
    //   1740: iload 5
    //   1742: iadd
    //   1743: iload 5
    //   1745: iadd
    //   1746: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1749: goto +1861 -> 3610
    //   1752: aload 17
    //   1754: astore 18
    //   1756: aload 17
    //   1758: astore 19
    //   1760: aload 21
    //   1762: astore 20
    //   1764: iload 4
    //   1766: getstatic 181	shark/HprofRecordTag:ROOT_INTERNED_STRING	Lshark/HprofRecordTag;
    //   1769: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1772: if_icmpne +78 -> 1850
    //   1775: aload 17
    //   1777: astore 18
    //   1779: aload 17
    //   1781: astore 19
    //   1783: aload 21
    //   1785: astore 20
    //   1787: aload_1
    //   1788: getstatic 181	shark/HprofRecordTag:ROOT_INTERNED_STRING	Lshark/HprofRecordTag;
    //   1791: invokeinterface 124 2 0
    //   1796: ifeq +32 -> 1828
    //   1799: aload 17
    //   1801: astore 18
    //   1803: aload 17
    //   1805: astore 19
    //   1807: aload 21
    //   1809: astore 20
    //   1811: aload_2
    //   1812: getstatic 181	shark/HprofRecordTag:ROOT_INTERNED_STRING	Lshark/HprofRecordTag;
    //   1815: ldc2_w 153
    //   1818: aload 24
    //   1820: invokeinterface 129 5 0
    //   1825: goto +1785 -> 3610
    //   1828: aload 17
    //   1830: astore 18
    //   1832: aload 17
    //   1834: astore 19
    //   1836: aload 21
    //   1838: astore 20
    //   1840: aload 24
    //   1842: iload 6
    //   1844: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1847: goto +1763 -> 3610
    //   1850: aload 17
    //   1852: astore 18
    //   1854: aload 17
    //   1856: astore 19
    //   1858: aload 21
    //   1860: astore 20
    //   1862: iload 4
    //   1864: getstatic 184	shark/HprofRecordTag:ROOT_FINALIZING	Lshark/HprofRecordTag;
    //   1867: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1870: if_icmpne +78 -> 1948
    //   1873: aload 17
    //   1875: astore 18
    //   1877: aload 17
    //   1879: astore 19
    //   1881: aload 21
    //   1883: astore 20
    //   1885: aload_1
    //   1886: getstatic 184	shark/HprofRecordTag:ROOT_FINALIZING	Lshark/HprofRecordTag;
    //   1889: invokeinterface 124 2 0
    //   1894: ifeq +32 -> 1926
    //   1897: aload 17
    //   1899: astore 18
    //   1901: aload 17
    //   1903: astore 19
    //   1905: aload 21
    //   1907: astore 20
    //   1909: aload_2
    //   1910: getstatic 184	shark/HprofRecordTag:ROOT_FINALIZING	Lshark/HprofRecordTag;
    //   1913: ldc2_w 153
    //   1916: aload 24
    //   1918: invokeinterface 129 5 0
    //   1923: goto +1687 -> 3610
    //   1926: aload 17
    //   1928: astore 18
    //   1930: aload 17
    //   1932: astore 19
    //   1934: aload 21
    //   1936: astore 20
    //   1938: aload 24
    //   1940: iload 6
    //   1942: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   1945: goto +1665 -> 3610
    //   1948: aload 17
    //   1950: astore 18
    //   1952: aload 17
    //   1954: astore 19
    //   1956: aload 21
    //   1958: astore 20
    //   1960: iload 4
    //   1962: getstatic 187	shark/HprofRecordTag:ROOT_DEBUGGER	Lshark/HprofRecordTag;
    //   1965: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   1968: if_icmpne +78 -> 2046
    //   1971: aload 17
    //   1973: astore 18
    //   1975: aload 17
    //   1977: astore 19
    //   1979: aload 21
    //   1981: astore 20
    //   1983: aload_1
    //   1984: getstatic 187	shark/HprofRecordTag:ROOT_DEBUGGER	Lshark/HprofRecordTag;
    //   1987: invokeinterface 124 2 0
    //   1992: ifeq +32 -> 2024
    //   1995: aload 17
    //   1997: astore 18
    //   1999: aload 17
    //   2001: astore 19
    //   2003: aload 21
    //   2005: astore 20
    //   2007: aload_2
    //   2008: getstatic 187	shark/HprofRecordTag:ROOT_DEBUGGER	Lshark/HprofRecordTag;
    //   2011: ldc2_w 153
    //   2014: aload 24
    //   2016: invokeinterface 129 5 0
    //   2021: goto +1589 -> 3610
    //   2024: aload 17
    //   2026: astore 18
    //   2028: aload 17
    //   2030: astore 19
    //   2032: aload 21
    //   2034: astore 20
    //   2036: aload 24
    //   2038: iload 6
    //   2040: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   2043: goto +1567 -> 3610
    //   2046: aload 17
    //   2048: astore 18
    //   2050: aload 17
    //   2052: astore 19
    //   2054: aload 21
    //   2056: astore 20
    //   2058: iload 4
    //   2060: getstatic 190	shark/HprofRecordTag:ROOT_REFERENCE_CLEANUP	Lshark/HprofRecordTag;
    //   2063: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2066: if_icmpne +78 -> 2144
    //   2069: aload 17
    //   2071: astore 18
    //   2073: aload 17
    //   2075: astore 19
    //   2077: aload 21
    //   2079: astore 20
    //   2081: aload_1
    //   2082: getstatic 190	shark/HprofRecordTag:ROOT_REFERENCE_CLEANUP	Lshark/HprofRecordTag;
    //   2085: invokeinterface 124 2 0
    //   2090: ifeq +32 -> 2122
    //   2093: aload 17
    //   2095: astore 18
    //   2097: aload 17
    //   2099: astore 19
    //   2101: aload 21
    //   2103: astore 20
    //   2105: aload_2
    //   2106: getstatic 190	shark/HprofRecordTag:ROOT_REFERENCE_CLEANUP	Lshark/HprofRecordTag;
    //   2109: ldc2_w 153
    //   2112: aload 24
    //   2114: invokeinterface 129 5 0
    //   2119: goto +1491 -> 3610
    //   2122: aload 17
    //   2124: astore 18
    //   2126: aload 17
    //   2128: astore 19
    //   2130: aload 21
    //   2132: astore 20
    //   2134: aload 24
    //   2136: iload 6
    //   2138: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   2141: goto +1469 -> 3610
    //   2144: aload 17
    //   2146: astore 18
    //   2148: aload 17
    //   2150: astore 19
    //   2152: aload 21
    //   2154: astore 20
    //   2156: iload 4
    //   2158: getstatic 193	shark/HprofRecordTag:ROOT_VM_INTERNAL	Lshark/HprofRecordTag;
    //   2161: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2164: if_icmpne +78 -> 2242
    //   2167: aload 17
    //   2169: astore 18
    //   2171: aload 17
    //   2173: astore 19
    //   2175: aload 21
    //   2177: astore 20
    //   2179: aload_1
    //   2180: getstatic 193	shark/HprofRecordTag:ROOT_VM_INTERNAL	Lshark/HprofRecordTag;
    //   2183: invokeinterface 124 2 0
    //   2188: ifeq +32 -> 2220
    //   2191: aload 17
    //   2193: astore 18
    //   2195: aload 17
    //   2197: astore 19
    //   2199: aload 21
    //   2201: astore 20
    //   2203: aload_2
    //   2204: getstatic 193	shark/HprofRecordTag:ROOT_VM_INTERNAL	Lshark/HprofRecordTag;
    //   2207: ldc2_w 153
    //   2210: aload 24
    //   2212: invokeinterface 129 5 0
    //   2217: goto +1393 -> 3610
    //   2220: aload 17
    //   2222: astore 18
    //   2224: aload 17
    //   2226: astore 19
    //   2228: aload 21
    //   2230: astore 20
    //   2232: aload 24
    //   2234: iload 6
    //   2236: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   2239: goto +1371 -> 3610
    //   2242: aload 17
    //   2244: astore 18
    //   2246: aload 17
    //   2248: astore 19
    //   2250: aload 21
    //   2252: astore 20
    //   2254: iload 4
    //   2256: getstatic 196	shark/HprofRecordTag:ROOT_JNI_MONITOR	Lshark/HprofRecordTag;
    //   2259: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2262: if_icmpne +84 -> 2346
    //   2265: aload 17
    //   2267: astore 18
    //   2269: aload 17
    //   2271: astore 19
    //   2273: aload 21
    //   2275: astore 20
    //   2277: aload_1
    //   2278: getstatic 196	shark/HprofRecordTag:ROOT_JNI_MONITOR	Lshark/HprofRecordTag;
    //   2281: invokeinterface 124 2 0
    //   2286: ifeq +32 -> 2318
    //   2289: aload 17
    //   2291: astore 18
    //   2293: aload 17
    //   2295: astore 19
    //   2297: aload 21
    //   2299: astore 20
    //   2301: aload_2
    //   2302: getstatic 196	shark/HprofRecordTag:ROOT_JNI_MONITOR	Lshark/HprofRecordTag;
    //   2305: ldc2_w 153
    //   2308: aload 24
    //   2310: invokeinterface 129 5 0
    //   2315: goto +1295 -> 3610
    //   2318: aload 17
    //   2320: astore 18
    //   2322: aload 17
    //   2324: astore 19
    //   2326: aload 21
    //   2328: astore 20
    //   2330: aload 24
    //   2332: iload 6
    //   2334: iload 5
    //   2336: iadd
    //   2337: iload 5
    //   2339: iadd
    //   2340: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   2343: goto +1267 -> 3610
    //   2346: aload 17
    //   2348: astore 18
    //   2350: aload 17
    //   2352: astore 19
    //   2354: aload 21
    //   2356: astore 20
    //   2358: iload 4
    //   2360: getstatic 199	shark/HprofRecordTag:ROOT_UNREACHABLE	Lshark/HprofRecordTag;
    //   2363: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2366: if_icmpne +78 -> 2444
    //   2369: aload 17
    //   2371: astore 18
    //   2373: aload 17
    //   2375: astore 19
    //   2377: aload 21
    //   2379: astore 20
    //   2381: aload_1
    //   2382: getstatic 199	shark/HprofRecordTag:ROOT_UNREACHABLE	Lshark/HprofRecordTag;
    //   2385: invokeinterface 124 2 0
    //   2390: ifeq +32 -> 2422
    //   2393: aload 17
    //   2395: astore 18
    //   2397: aload 17
    //   2399: astore 19
    //   2401: aload 21
    //   2403: astore 20
    //   2405: aload_2
    //   2406: getstatic 199	shark/HprofRecordTag:ROOT_UNREACHABLE	Lshark/HprofRecordTag;
    //   2409: ldc2_w 153
    //   2412: aload 24
    //   2414: invokeinterface 129 5 0
    //   2419: goto +1191 -> 3610
    //   2422: aload 17
    //   2424: astore 18
    //   2426: aload 17
    //   2428: astore 19
    //   2430: aload 21
    //   2432: astore 20
    //   2434: aload 24
    //   2436: iload 6
    //   2438: invokevirtual 87	shark/HprofRecordReader:b	(I)V
    //   2441: goto +1169 -> 3610
    //   2444: aload 17
    //   2446: astore 18
    //   2448: aload 17
    //   2450: astore 19
    //   2452: aload 21
    //   2454: astore 20
    //   2456: iload 4
    //   2458: getstatic 202	shark/HprofRecordTag:CLASS_DUMP	Lshark/HprofRecordTag;
    //   2461: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2464: if_icmpne +76 -> 2540
    //   2467: aload 17
    //   2469: astore 18
    //   2471: aload 17
    //   2473: astore 19
    //   2475: aload 21
    //   2477: astore 20
    //   2479: aload_1
    //   2480: getstatic 202	shark/HprofRecordTag:CLASS_DUMP	Lshark/HprofRecordTag;
    //   2483: invokeinterface 124 2 0
    //   2488: ifeq +32 -> 2520
    //   2491: aload 17
    //   2493: astore 18
    //   2495: aload 17
    //   2497: astore 19
    //   2499: aload 21
    //   2501: astore 20
    //   2503: aload_2
    //   2504: getstatic 202	shark/HprofRecordTag:CLASS_DUMP	Lshark/HprofRecordTag;
    //   2507: ldc2_w 153
    //   2510: aload 24
    //   2512: invokeinterface 129 5 0
    //   2517: goto +1093 -> 3610
    //   2520: aload 17
    //   2522: astore 18
    //   2524: aload 17
    //   2526: astore 19
    //   2528: aload 21
    //   2530: astore 20
    //   2532: aload 24
    //   2534: invokevirtual 205	shark/HprofRecordReader:E	()V
    //   2537: goto +1073 -> 3610
    //   2540: aload 17
    //   2542: astore 18
    //   2544: aload 17
    //   2546: astore 19
    //   2548: aload 21
    //   2550: astore 20
    //   2552: iload 4
    //   2554: getstatic 208	shark/HprofRecordTag:INSTANCE_DUMP	Lshark/HprofRecordTag;
    //   2557: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2560: if_icmpne +76 -> 2636
    //   2563: aload 17
    //   2565: astore 18
    //   2567: aload 17
    //   2569: astore 19
    //   2571: aload 21
    //   2573: astore 20
    //   2575: aload_1
    //   2576: getstatic 208	shark/HprofRecordTag:INSTANCE_DUMP	Lshark/HprofRecordTag;
    //   2579: invokeinterface 124 2 0
    //   2584: ifeq +32 -> 2616
    //   2587: aload 17
    //   2589: astore 18
    //   2591: aload 17
    //   2593: astore 19
    //   2595: aload 21
    //   2597: astore 20
    //   2599: aload_2
    //   2600: getstatic 208	shark/HprofRecordTag:INSTANCE_DUMP	Lshark/HprofRecordTag;
    //   2603: ldc2_w 153
    //   2606: aload 24
    //   2608: invokeinterface 129 5 0
    //   2613: goto +997 -> 3610
    //   2616: aload 17
    //   2618: astore 18
    //   2620: aload 17
    //   2622: astore 19
    //   2624: aload 21
    //   2626: astore 20
    //   2628: aload 24
    //   2630: invokevirtual 211	shark/HprofRecordReader:D	()V
    //   2633: goto +977 -> 3610
    //   2636: aload 17
    //   2638: astore 18
    //   2640: aload 17
    //   2642: astore 19
    //   2644: aload 21
    //   2646: astore 20
    //   2648: iload 4
    //   2650: getstatic 214	shark/HprofRecordTag:OBJECT_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2653: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2656: if_icmpne +76 -> 2732
    //   2659: aload 17
    //   2661: astore 18
    //   2663: aload 17
    //   2665: astore 19
    //   2667: aload 21
    //   2669: astore 20
    //   2671: aload_1
    //   2672: getstatic 214	shark/HprofRecordTag:OBJECT_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2675: invokeinterface 124 2 0
    //   2680: ifeq +32 -> 2712
    //   2683: aload 17
    //   2685: astore 18
    //   2687: aload 17
    //   2689: astore 19
    //   2691: aload 21
    //   2693: astore 20
    //   2695: aload_2
    //   2696: getstatic 214	shark/HprofRecordTag:OBJECT_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2699: ldc2_w 153
    //   2702: aload 24
    //   2704: invokeinterface 129 5 0
    //   2709: goto +901 -> 3610
    //   2712: aload 17
    //   2714: astore 18
    //   2716: aload 17
    //   2718: astore 19
    //   2720: aload 21
    //   2722: astore 20
    //   2724: aload 24
    //   2726: invokevirtual 217	shark/HprofRecordReader:F	()V
    //   2729: goto +881 -> 3610
    //   2732: aload 17
    //   2734: astore 18
    //   2736: aload 17
    //   2738: astore 19
    //   2740: aload 21
    //   2742: astore 20
    //   2744: iload 4
    //   2746: getstatic 220	shark/HprofRecordTag:PRIMITIVE_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2749: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2752: if_icmpne +76 -> 2828
    //   2755: aload 17
    //   2757: astore 18
    //   2759: aload 17
    //   2761: astore 19
    //   2763: aload 21
    //   2765: astore 20
    //   2767: aload_1
    //   2768: getstatic 220	shark/HprofRecordTag:PRIMITIVE_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2771: invokeinterface 124 2 0
    //   2776: ifeq +32 -> 2808
    //   2779: aload 17
    //   2781: astore 18
    //   2783: aload 17
    //   2785: astore 19
    //   2787: aload 21
    //   2789: astore 20
    //   2791: aload_2
    //   2792: getstatic 220	shark/HprofRecordTag:PRIMITIVE_ARRAY_DUMP	Lshark/HprofRecordTag;
    //   2795: ldc2_w 153
    //   2798: aload 24
    //   2800: invokeinterface 129 5 0
    //   2805: goto +805 -> 3610
    //   2808: aload 17
    //   2810: astore 18
    //   2812: aload 17
    //   2814: astore 19
    //   2816: aload 21
    //   2818: astore 20
    //   2820: aload 24
    //   2822: invokevirtual 223	shark/HprofRecordReader:G	()V
    //   2825: goto +785 -> 3610
    //   2828: aload 17
    //   2830: astore 18
    //   2832: aload 17
    //   2834: astore 19
    //   2836: aload 21
    //   2838: astore 20
    //   2840: iload 4
    //   2842: getstatic 226	shark/HprofRecordTag:PRIMITIVE_ARRAY_NODATA	Lshark/HprofRecordTag;
    //   2845: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2848: if_icmpeq +458 -> 3306
    //   2851: aload 17
    //   2853: astore 18
    //   2855: aload 17
    //   2857: astore 19
    //   2859: aload 21
    //   2861: astore 20
    //   2863: iload 4
    //   2865: getstatic 229	shark/HprofRecordTag:HEAP_DUMP_INFO	Lshark/HprofRecordTag;
    //   2868: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   2871: if_icmpne +76 -> 2947
    //   2874: aload 17
    //   2876: astore 18
    //   2878: aload 17
    //   2880: astore 19
    //   2882: aload 21
    //   2884: astore 20
    //   2886: aload_1
    //   2887: getstatic 229	shark/HprofRecordTag:HEAP_DUMP_INFO	Lshark/HprofRecordTag;
    //   2890: invokeinterface 124 2 0
    //   2895: ifeq +32 -> 2927
    //   2898: aload 17
    //   2900: astore 18
    //   2902: aload 17
    //   2904: astore 19
    //   2906: aload 21
    //   2908: astore 20
    //   2910: aload_2
    //   2911: getstatic 229	shark/HprofRecordTag:HEAP_DUMP_INFO	Lshark/HprofRecordTag;
    //   2914: ldc2_w 153
    //   2917: aload 24
    //   2919: invokeinterface 129 5 0
    //   2924: goto +686 -> 3610
    //   2927: aload 17
    //   2929: astore 18
    //   2931: aload 17
    //   2933: astore 19
    //   2935: aload 21
    //   2937: astore 20
    //   2939: aload 24
    //   2941: invokevirtual 232	shark/HprofRecordReader:H	()V
    //   2944: goto +666 -> 3610
    //   2947: aload 17
    //   2949: astore 18
    //   2951: aload 17
    //   2953: astore 19
    //   2955: aload 21
    //   2957: astore 20
    //   2959: new 234	java/lang/StringBuilder
    //   2962: dup
    //   2963: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   2966: astore_1
    //   2967: aload 17
    //   2969: astore 18
    //   2971: aload 17
    //   2973: astore 19
    //   2975: aload 21
    //   2977: astore 20
    //   2979: aload_1
    //   2980: ldc 237
    //   2982: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2985: pop
    //   2986: aload 17
    //   2988: astore 18
    //   2990: aload 17
    //   2992: astore 19
    //   2994: aload 21
    //   2996: astore 20
    //   2998: iconst_1
    //   2999: anewarray 4	java/lang/Object
    //   3002: astore_2
    //   3003: aload 17
    //   3005: astore 18
    //   3007: aload 17
    //   3009: astore 19
    //   3011: aload 21
    //   3013: astore 20
    //   3015: aload_2
    //   3016: iconst_0
    //   3017: iload 4
    //   3019: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3022: aastore
    //   3023: aload 17
    //   3025: astore 18
    //   3027: aload 17
    //   3029: astore 19
    //   3031: aload 21
    //   3033: astore 20
    //   3035: ldc 249
    //   3037: aload_2
    //   3038: aload_2
    //   3039: arraylength
    //   3040: invokestatic 255	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   3043: invokestatic 261	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3046: astore_2
    //   3047: aload 17
    //   3049: astore 18
    //   3051: aload 17
    //   3053: astore 19
    //   3055: aload 21
    //   3057: astore 20
    //   3059: aload_2
    //   3060: ldc_w 263
    //   3063: invokestatic 266	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3066: aload 17
    //   3068: astore 18
    //   3070: aload 17
    //   3072: astore 19
    //   3074: aload 21
    //   3076: astore 20
    //   3078: aload_1
    //   3079: aload_2
    //   3080: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3083: pop
    //   3084: aload 17
    //   3086: astore 18
    //   3088: aload 17
    //   3090: astore 19
    //   3092: aload 21
    //   3094: astore 20
    //   3096: aload_1
    //   3097: ldc_w 268
    //   3100: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: pop
    //   3104: aload 17
    //   3106: astore 18
    //   3108: aload 17
    //   3110: astore 19
    //   3112: aload 21
    //   3114: astore 20
    //   3116: aload_1
    //   3117: lload 13
    //   3119: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3122: pop
    //   3123: aload 17
    //   3125: astore 18
    //   3127: aload 17
    //   3129: astore 19
    //   3131: aload 21
    //   3133: astore 20
    //   3135: aload_1
    //   3136: ldc_w 273
    //   3139: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3142: pop
    //   3143: aload 17
    //   3145: astore 18
    //   3147: aload 17
    //   3149: astore 19
    //   3151: aload 21
    //   3153: astore 20
    //   3155: iconst_1
    //   3156: anewarray 4	java/lang/Object
    //   3159: astore_2
    //   3160: aload 17
    //   3162: astore 18
    //   3164: aload 17
    //   3166: astore 19
    //   3168: aload 21
    //   3170: astore 20
    //   3172: aload_2
    //   3173: iconst_0
    //   3174: iload_3
    //   3175: invokestatic 247	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3178: aastore
    //   3179: aload 17
    //   3181: astore 18
    //   3183: aload 17
    //   3185: astore 19
    //   3187: aload 21
    //   3189: astore 20
    //   3191: ldc 249
    //   3193: aload_2
    //   3194: aload_2
    //   3195: arraylength
    //   3196: invokestatic 255	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   3199: invokestatic 261	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3202: astore_2
    //   3203: aload 17
    //   3205: astore 18
    //   3207: aload 17
    //   3209: astore 19
    //   3211: aload 21
    //   3213: astore 20
    //   3215: aload_2
    //   3216: ldc_w 263
    //   3219: invokestatic 266	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   3222: aload 17
    //   3224: astore 18
    //   3226: aload 17
    //   3228: astore 19
    //   3230: aload 21
    //   3232: astore 20
    //   3234: aload_1
    //   3235: aload_2
    //   3236: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: pop
    //   3240: aload 17
    //   3242: astore 18
    //   3244: aload 17
    //   3246: astore 19
    //   3248: aload 21
    //   3250: astore 20
    //   3252: aload_1
    //   3253: ldc_w 268
    //   3256: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3259: pop
    //   3260: aload 17
    //   3262: astore 18
    //   3264: aload 17
    //   3266: astore 19
    //   3268: aload 21
    //   3270: astore 20
    //   3272: aload_1
    //   3273: lload 11
    //   3275: invokevirtual 271	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3278: pop
    //   3279: aload 17
    //   3281: astore 18
    //   3283: aload 17
    //   3285: astore 19
    //   3287: aload 21
    //   3289: astore 20
    //   3291: new 275	java/lang/IllegalStateException
    //   3294: dup
    //   3295: aload_1
    //   3296: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3299: invokespecial 282	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   3302: checkcast 57	java/lang/Throwable
    //   3305: athrow
    //   3306: aload 17
    //   3308: astore 18
    //   3310: aload 17
    //   3312: astore 19
    //   3314: aload 21
    //   3316: astore 20
    //   3318: new 234	java/lang/StringBuilder
    //   3321: dup
    //   3322: invokespecial 235	java/lang/StringBuilder:<init>	()V
    //   3325: astore_1
    //   3326: aload 17
    //   3328: astore 18
    //   3330: aload 17
    //   3332: astore 19
    //   3334: aload 21
    //   3336: astore 20
    //   3338: aload_1
    //   3339: getstatic 226	shark/HprofRecordTag:PRIMITIVE_ARRAY_NODATA	Lshark/HprofRecordTag;
    //   3342: invokevirtual 285	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3345: pop
    //   3346: aload 17
    //   3348: astore 18
    //   3350: aload 17
    //   3352: astore 19
    //   3354: aload 21
    //   3356: astore 20
    //   3358: aload_1
    //   3359: ldc_w 287
    //   3362: invokevirtual 241	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3365: pop
    //   3366: aload 17
    //   3368: astore 18
    //   3370: aload 17
    //   3372: astore 19
    //   3374: aload 21
    //   3376: astore 20
    //   3378: new 289	java/lang/UnsupportedOperationException
    //   3381: dup
    //   3382: aload_1
    //   3383: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3386: invokespecial 290	java/lang/UnsupportedOperationException:<init>	(Ljava/lang/String;)V
    //   3389: checkcast 57	java/lang/Throwable
    //   3392: athrow
    //   3393: aload 18
    //   3395: astore 23
    //   3397: aload 17
    //   3399: astore 18
    //   3401: aload 17
    //   3403: astore 19
    //   3405: aload 23
    //   3407: astore 20
    //   3409: iload_3
    //   3410: getstatic 293	shark/HprofRecordTag:HEAP_DUMP_END	Lshark/HprofRecordTag;
    //   3413: invokevirtual 118	shark/HprofRecordTag:getTag	()I
    //   3416: if_icmpne +71 -> 3487
    //   3419: aload 17
    //   3421: astore 21
    //   3423: aload 23
    //   3425: astore 22
    //   3427: aload 17
    //   3429: astore 18
    //   3431: aload 17
    //   3433: astore 19
    //   3435: aload 23
    //   3437: astore 20
    //   3439: aload_1
    //   3440: getstatic 293	shark/HprofRecordTag:HEAP_DUMP_END	Lshark/HprofRecordTag;
    //   3443: invokeinterface 124 2 0
    //   3448: ifeq +66 -> 3514
    //   3451: aload 17
    //   3453: astore 18
    //   3455: aload 17
    //   3457: astore 19
    //   3459: aload 23
    //   3461: astore 20
    //   3463: aload_2
    //   3464: getstatic 293	shark/HprofRecordTag:HEAP_DUMP_END	Lshark/HprofRecordTag;
    //   3467: lload 9
    //   3469: aload 24
    //   3471: invokeinterface 129 5 0
    //   3476: aload 17
    //   3478: astore 21
    //   3480: aload 23
    //   3482: astore 22
    //   3484: goto +30 -> 3514
    //   3487: aload 17
    //   3489: astore 18
    //   3491: aload 17
    //   3493: astore 19
    //   3495: aload 23
    //   3497: astore 20
    //   3499: aload 24
    //   3501: lload 9
    //   3503: invokevirtual 132	shark/HprofRecordReader:b	(J)V
    //   3506: aload 23
    //   3508: astore 22
    //   3510: aload 17
    //   3512: astore 21
    //   3514: aload 21
    //   3516: astore 17
    //   3518: aload 22
    //   3520: astore 18
    //   3522: goto -3380 -> 142
    //   3525: astore_1
    //   3526: aload 18
    //   3528: astore 19
    //   3530: goto +56 -> 3586
    //   3533: astore_1
    //   3534: goto +61 -> 3595
    //   3537: aload 17
    //   3539: astore_1
    //   3540: aload 18
    //   3542: astore 20
    //   3544: aload_1
    //   3545: astore 19
    //   3547: aload 24
    //   3549: invokevirtual 149	shark/HprofRecordReader:a	()J
    //   3552: lstore 9
    //   3554: aload 17
    //   3556: aload 18
    //   3558: invokestatic 299	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   3561: lload 9
    //   3563: lreturn
    //   3564: astore_1
    //   3565: aload 19
    //   3567: astore 21
    //   3569: goto +26 -> 3595
    //   3572: astore_2
    //   3573: aload_1
    //   3574: astore 19
    //   3576: aload_2
    //   3577: astore_1
    //   3578: goto +8 -> 3586
    //   3581: astore_1
    //   3582: goto +13 -> 3595
    //   3585: astore_1
    //   3586: aload 19
    //   3588: astore 21
    //   3590: aload_1
    //   3591: astore 20
    //   3593: aload_1
    //   3594: athrow
    //   3595: aload 21
    //   3597: aload 20
    //   3599: invokestatic 299	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   3602: goto +5 -> 3607
    //   3605: aload_1
    //   3606: athrow
    //   3607: goto -2 -> 3605
    //   3610: lload 13
    //   3612: lstore 11
    //   3614: iload 4
    //   3616: istore_3
    //   3617: aload 21
    //   3619: astore 18
    //   3621: goto -2858 -> 763
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3624	0	this	StreamingHprofReader
    //   0	3624	1	paramSet	java.util.Set<? extends HprofRecordTag>
    //   0	3624	2	paramOnHprofRecordTagListener	OnHprofRecordTagListener
    //   185	3432	3	i	int
    //   242	3373	4	j	int
    //   120	2220	5	k	int
    //   140	2297	6	m	int
    //   853	11	7	n	int
    //   161	3	8	bool	boolean
    //   222	3340	9	l1	long
    //   759	2854	11	l2	long
    //   814	2797	13	l3	long
    //   756	33	15	l4	long
    //   24	3531	17	localObject1	Object
    //   30	3590	18	localObject2	Object
    //   42	3545	19	localObject3	Object
    //   38	3560	20	localObject4	Object
    //   34	3584	21	localObject5	Object
    //   305	3214	22	localObject6	Object
    //   301	3206	23	localObject7	Object
    //   76	3472	24	localHprofRecordReader	HprofRecordReader
    //   49	106	25	localBufferedSource	okio.BufferedSource
    // Exception table:
    //   from	to	target	type
    //   878	890	3525	java/lang/Throwable
    //   902	916	3525	java/lang/Throwable
    //   931	938	3525	java/lang/Throwable
    //   953	964	3525	java/lang/Throwable
    //   976	988	3525	java/lang/Throwable
    //   1000	1014	3525	java/lang/Throwable
    //   1029	1039	3525	java/lang/Throwable
    //   1054	1065	3525	java/lang/Throwable
    //   1077	1089	3525	java/lang/Throwable
    //   1101	1115	3525	java/lang/Throwable
    //   1130	1143	3525	java/lang/Throwable
    //   1158	1169	3525	java/lang/Throwable
    //   1181	1193	3525	java/lang/Throwable
    //   1205	1219	3525	java/lang/Throwable
    //   1234	1247	3525	java/lang/Throwable
    //   1262	1273	3525	java/lang/Throwable
    //   1285	1297	3525	java/lang/Throwable
    //   1309	1323	3525	java/lang/Throwable
    //   1338	1348	3525	java/lang/Throwable
    //   1363	1374	3525	java/lang/Throwable
    //   1386	1398	3525	java/lang/Throwable
    //   1410	1424	3525	java/lang/Throwable
    //   1439	1446	3525	java/lang/Throwable
    //   1461	1472	3525	java/lang/Throwable
    //   1484	1496	3525	java/lang/Throwable
    //   1508	1522	3525	java/lang/Throwable
    //   1537	1547	3525	java/lang/Throwable
    //   1562	1573	3525	java/lang/Throwable
    //   1585	1597	3525	java/lang/Throwable
    //   1609	1623	3525	java/lang/Throwable
    //   1638	1645	3525	java/lang/Throwable
    //   1660	1671	3525	java/lang/Throwable
    //   1683	1695	3525	java/lang/Throwable
    //   1707	1721	3525	java/lang/Throwable
    //   1736	1749	3525	java/lang/Throwable
    //   1764	1775	3525	java/lang/Throwable
    //   1787	1799	3525	java/lang/Throwable
    //   1811	1825	3525	java/lang/Throwable
    //   1840	1847	3525	java/lang/Throwable
    //   1862	1873	3525	java/lang/Throwable
    //   1885	1897	3525	java/lang/Throwable
    //   1909	1923	3525	java/lang/Throwable
    //   1938	1945	3525	java/lang/Throwable
    //   1960	1971	3525	java/lang/Throwable
    //   1983	1995	3525	java/lang/Throwable
    //   2007	2021	3525	java/lang/Throwable
    //   2036	2043	3525	java/lang/Throwable
    //   2058	2069	3525	java/lang/Throwable
    //   2081	2093	3525	java/lang/Throwable
    //   2105	2119	3525	java/lang/Throwable
    //   2134	2141	3525	java/lang/Throwable
    //   2156	2167	3525	java/lang/Throwable
    //   2179	2191	3525	java/lang/Throwable
    //   2203	2217	3525	java/lang/Throwable
    //   2232	2239	3525	java/lang/Throwable
    //   2254	2265	3525	java/lang/Throwable
    //   2277	2289	3525	java/lang/Throwable
    //   2301	2315	3525	java/lang/Throwable
    //   2330	2343	3525	java/lang/Throwable
    //   2358	2369	3525	java/lang/Throwable
    //   2381	2393	3525	java/lang/Throwable
    //   2405	2419	3525	java/lang/Throwable
    //   2434	2441	3525	java/lang/Throwable
    //   2456	2467	3525	java/lang/Throwable
    //   2479	2491	3525	java/lang/Throwable
    //   2503	2517	3525	java/lang/Throwable
    //   2532	2537	3525	java/lang/Throwable
    //   2552	2563	3525	java/lang/Throwable
    //   2575	2587	3525	java/lang/Throwable
    //   2599	2613	3525	java/lang/Throwable
    //   2628	2633	3525	java/lang/Throwable
    //   2648	2659	3525	java/lang/Throwable
    //   2671	2683	3525	java/lang/Throwable
    //   2695	2709	3525	java/lang/Throwable
    //   2724	2729	3525	java/lang/Throwable
    //   2744	2755	3525	java/lang/Throwable
    //   2767	2779	3525	java/lang/Throwable
    //   2791	2805	3525	java/lang/Throwable
    //   2820	2825	3525	java/lang/Throwable
    //   2840	2851	3525	java/lang/Throwable
    //   2863	2874	3525	java/lang/Throwable
    //   2886	2898	3525	java/lang/Throwable
    //   2910	2924	3525	java/lang/Throwable
    //   2939	2944	3525	java/lang/Throwable
    //   2959	2967	3525	java/lang/Throwable
    //   2979	2986	3525	java/lang/Throwable
    //   2998	3003	3525	java/lang/Throwable
    //   3015	3023	3525	java/lang/Throwable
    //   3035	3047	3525	java/lang/Throwable
    //   3059	3066	3525	java/lang/Throwable
    //   3078	3084	3525	java/lang/Throwable
    //   3096	3104	3525	java/lang/Throwable
    //   3116	3123	3525	java/lang/Throwable
    //   3135	3143	3525	java/lang/Throwable
    //   3155	3160	3525	java/lang/Throwable
    //   3172	3179	3525	java/lang/Throwable
    //   3191	3203	3525	java/lang/Throwable
    //   3215	3222	3525	java/lang/Throwable
    //   3234	3240	3525	java/lang/Throwable
    //   3252	3260	3525	java/lang/Throwable
    //   3272	3279	3525	java/lang/Throwable
    //   3291	3306	3525	java/lang/Throwable
    //   3318	3326	3525	java/lang/Throwable
    //   3338	3346	3525	java/lang/Throwable
    //   3358	3366	3525	java/lang/Throwable
    //   3378	3393	3525	java/lang/Throwable
    //   3409	3419	3525	java/lang/Throwable
    //   3439	3451	3525	java/lang/Throwable
    //   3463	3476	3525	java/lang/Throwable
    //   3499	3506	3525	java/lang/Throwable
    //   180	186	3533	finally
    //   198	205	3533	finally
    //   217	224	3533	finally
    //   236	244	3533	finally
    //   356	364	3533	finally
    //   472	480	3533	finally
    //   588	596	3533	finally
    //   704	714	3533	finally
    //   729	739	3533	finally
    //   751	758	3533	finally
    //   783	797	3533	finally
    //   809	816	3533	finally
    //   828	835	3533	finally
    //   847	855	3533	finally
    //   878	890	3564	finally
    //   902	916	3564	finally
    //   931	938	3564	finally
    //   953	964	3564	finally
    //   976	988	3564	finally
    //   1000	1014	3564	finally
    //   1029	1039	3564	finally
    //   1054	1065	3564	finally
    //   1077	1089	3564	finally
    //   1101	1115	3564	finally
    //   1130	1143	3564	finally
    //   1158	1169	3564	finally
    //   1181	1193	3564	finally
    //   1205	1219	3564	finally
    //   1234	1247	3564	finally
    //   1262	1273	3564	finally
    //   1285	1297	3564	finally
    //   1309	1323	3564	finally
    //   1338	1348	3564	finally
    //   1363	1374	3564	finally
    //   1386	1398	3564	finally
    //   1410	1424	3564	finally
    //   1439	1446	3564	finally
    //   1461	1472	3564	finally
    //   1484	1496	3564	finally
    //   1508	1522	3564	finally
    //   1537	1547	3564	finally
    //   1562	1573	3564	finally
    //   1585	1597	3564	finally
    //   1609	1623	3564	finally
    //   1638	1645	3564	finally
    //   1660	1671	3564	finally
    //   1683	1695	3564	finally
    //   1707	1721	3564	finally
    //   1736	1749	3564	finally
    //   1764	1775	3564	finally
    //   1787	1799	3564	finally
    //   1811	1825	3564	finally
    //   1840	1847	3564	finally
    //   1862	1873	3564	finally
    //   1885	1897	3564	finally
    //   1909	1923	3564	finally
    //   1938	1945	3564	finally
    //   1960	1971	3564	finally
    //   1983	1995	3564	finally
    //   2007	2021	3564	finally
    //   2036	2043	3564	finally
    //   2058	2069	3564	finally
    //   2081	2093	3564	finally
    //   2105	2119	3564	finally
    //   2134	2141	3564	finally
    //   2156	2167	3564	finally
    //   2179	2191	3564	finally
    //   2203	2217	3564	finally
    //   2232	2239	3564	finally
    //   2254	2265	3564	finally
    //   2277	2289	3564	finally
    //   2301	2315	3564	finally
    //   2330	2343	3564	finally
    //   2358	2369	3564	finally
    //   2381	2393	3564	finally
    //   2405	2419	3564	finally
    //   2434	2441	3564	finally
    //   2456	2467	3564	finally
    //   2479	2491	3564	finally
    //   2503	2517	3564	finally
    //   2532	2537	3564	finally
    //   2552	2563	3564	finally
    //   2575	2587	3564	finally
    //   2599	2613	3564	finally
    //   2628	2633	3564	finally
    //   2648	2659	3564	finally
    //   2671	2683	3564	finally
    //   2695	2709	3564	finally
    //   2724	2729	3564	finally
    //   2744	2755	3564	finally
    //   2767	2779	3564	finally
    //   2791	2805	3564	finally
    //   2820	2825	3564	finally
    //   2840	2851	3564	finally
    //   2863	2874	3564	finally
    //   2886	2898	3564	finally
    //   2910	2924	3564	finally
    //   2939	2944	3564	finally
    //   2959	2967	3564	finally
    //   2979	2986	3564	finally
    //   2998	3003	3564	finally
    //   3015	3023	3564	finally
    //   3035	3047	3564	finally
    //   3059	3066	3564	finally
    //   3078	3084	3564	finally
    //   3096	3104	3564	finally
    //   3116	3123	3564	finally
    //   3135	3143	3564	finally
    //   3155	3160	3564	finally
    //   3172	3179	3564	finally
    //   3191	3203	3564	finally
    //   3215	3222	3564	finally
    //   3234	3240	3564	finally
    //   3252	3260	3564	finally
    //   3272	3279	3564	finally
    //   3291	3306	3564	finally
    //   3318	3326	3564	finally
    //   3338	3346	3564	finally
    //   3358	3366	3564	finally
    //   3378	3393	3564	finally
    //   3409	3419	3564	finally
    //   3439	3451	3564	finally
    //   3463	3476	3564	finally
    //   3499	3506	3564	finally
    //   3547	3554	3564	finally
    //   3547	3554	3572	java/lang/Throwable
    //   44	51	3581	finally
    //   63	78	3581	finally
    //   90	102	3581	finally
    //   114	122	3581	finally
    //   134	142	3581	finally
    //   154	163	3581	finally
    //   262	274	3581	finally
    //   286	299	3581	finally
    //   322	329	3581	finally
    //   382	394	3581	finally
    //   406	419	3581	finally
    //   442	449	3581	finally
    //   498	510	3581	finally
    //   522	535	3581	finally
    //   558	565	3581	finally
    //   614	626	3581	finally
    //   638	651	3581	finally
    //   674	681	3581	finally
    //   3593	3595	3581	finally
    //   44	51	3585	java/lang/Throwable
    //   63	78	3585	java/lang/Throwable
    //   90	102	3585	java/lang/Throwable
    //   114	122	3585	java/lang/Throwable
    //   134	142	3585	java/lang/Throwable
    //   154	163	3585	java/lang/Throwable
    //   180	186	3585	java/lang/Throwable
    //   198	205	3585	java/lang/Throwable
    //   217	224	3585	java/lang/Throwable
    //   236	244	3585	java/lang/Throwable
    //   262	274	3585	java/lang/Throwable
    //   286	299	3585	java/lang/Throwable
    //   322	329	3585	java/lang/Throwable
    //   356	364	3585	java/lang/Throwable
    //   382	394	3585	java/lang/Throwable
    //   406	419	3585	java/lang/Throwable
    //   442	449	3585	java/lang/Throwable
    //   472	480	3585	java/lang/Throwable
    //   498	510	3585	java/lang/Throwable
    //   522	535	3585	java/lang/Throwable
    //   558	565	3585	java/lang/Throwable
    //   588	596	3585	java/lang/Throwable
    //   614	626	3585	java/lang/Throwable
    //   638	651	3585	java/lang/Throwable
    //   674	681	3585	java/lang/Throwable
    //   704	714	3585	java/lang/Throwable
    //   729	739	3585	java/lang/Throwable
    //   751	758	3585	java/lang/Throwable
    //   783	797	3585	java/lang/Throwable
    //   809	816	3585	java/lang/Throwable
    //   828	835	3585	java/lang/Throwable
    //   847	855	3585	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.StreamingHprofReader
 * JD-Core Version:    0.7.0.1
 */