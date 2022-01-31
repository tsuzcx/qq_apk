import android.os.Handler;
import com.tencent.biz.qrcode.activity.QRLoginActivity;

public class osp
  extends Handler
{
  public osp(QRLoginActivity paramQRLoginActivity) {}
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 26	android/os/Message:getData	()Landroid/os/Bundle;
    //   4: astore 22
    //   6: aload_1
    //   7: getfield 30	android/os/Message:what	I
    //   10: tableswitch	default:+26 -> 36, 1:+27->37, 2:+3481->3491, 3:+3729->3739
    //   37: aload 22
    //   39: ldc 32
    //   41: iconst_1
    //   42: invokevirtual 38	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   45: istore_2
    //   46: aload 22
    //   48: ldc 40
    //   50: invokevirtual 44	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   53: astore 23
    //   55: aload 22
    //   57: ldc 46
    //   59: invokevirtual 44	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   62: astore 40
    //   64: aload 22
    //   66: ldc 48
    //   68: invokevirtual 44	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   71: astore 22
    //   73: aload 22
    //   75: astore_1
    //   76: aload 22
    //   78: ifnonnull +7 -> 85
    //   81: iconst_0
    //   82: newarray byte
    //   84: astore_1
    //   85: aload_0
    //   86: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   89: getfield 53	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   92: iconst_0
    //   93: invokevirtual 59	android/widget/LinearLayout:setVisibility	(I)V
    //   96: aload_0
    //   97: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   100: getfield 62	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetProgressBar	Landroid/widget/ProgressBar;
    //   103: bipush 8
    //   105: invokevirtual 65	android/widget/ProgressBar:setVisibility	(I)V
    //   108: iload_2
    //   109: ifne +3366 -> 3475
    //   112: aload 23
    //   114: ifnull +9 -> 123
    //   117: aload 23
    //   119: arraylength
    //   120: ifne +332 -> 452
    //   123: aload_0
    //   124: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   127: aload_0
    //   128: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   131: ldc 66
    //   133: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   136: putfield 74	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   139: aload_0
    //   140: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   143: ldc 75
    //   145: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   148: astore_1
    //   149: aload_0
    //   150: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   153: ldc 76
    //   155: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   158: astore 23
    //   160: aload_0
    //   161: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   164: ldc 77
    //   166: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   169: astore 22
    //   171: aconst_null
    //   172: astore 24
    //   174: aconst_null
    //   175: astore 25
    //   177: iconst_1
    //   178: istore_2
    //   179: iconst_1
    //   180: istore_3
    //   181: aconst_null
    //   182: astore 26
    //   184: aconst_null
    //   185: astore 28
    //   187: iconst_0
    //   188: istore 4
    //   190: iconst_0
    //   191: istore 7
    //   193: iload 4
    //   195: istore 9
    //   197: iload_3
    //   198: istore 11
    //   200: iload_2
    //   201: istore 6
    //   203: aload 25
    //   205: astore 29
    //   207: aload 24
    //   209: astore 30
    //   211: aload 22
    //   213: astore 32
    //   215: aload 23
    //   217: astore 34
    //   219: aload_1
    //   220: astore 36
    //   222: iload 7
    //   224: aload 40
    //   226: arraylength
    //   227: if_icmpge +2513 -> 2740
    //   230: aload 40
    //   232: iload 7
    //   234: baload
    //   235: istore 5
    //   237: iload 7
    //   239: iconst_1
    //   240: iadd
    //   241: istore 7
    //   243: iload 5
    //   245: bipush 8
    //   247: ishl
    //   248: ldc 78
    //   250: iand
    //   251: aload 40
    //   253: iload 7
    //   255: baload
    //   256: sipush 255
    //   259: iand
    //   260: ior
    //   261: istore 6
    //   263: iload 7
    //   265: iconst_1
    //   266: iadd
    //   267: istore 5
    //   269: aload 40
    //   271: iload 5
    //   273: baload
    //   274: istore 7
    //   276: iload 5
    //   278: iconst_1
    //   279: iadd
    //   280: istore 5
    //   282: iload 7
    //   284: bipush 8
    //   286: ishl
    //   287: ldc 78
    //   289: iand
    //   290: aload 40
    //   292: iload 5
    //   294: baload
    //   295: sipush 255
    //   298: iand
    //   299: ior
    //   300: istore 20
    //   302: iload 6
    //   304: iconst_5
    //   305: if_icmpne +166 -> 471
    //   308: iload 5
    //   310: iconst_1
    //   311: iadd
    //   312: istore 7
    //   314: iload 4
    //   316: istore 9
    //   318: iload_3
    //   319: istore 11
    //   321: iload_2
    //   322: istore 6
    //   324: aload 25
    //   326: astore 29
    //   328: aload 24
    //   330: astore 30
    //   332: aload 22
    //   334: astore 32
    //   336: aload 23
    //   338: astore 34
    //   340: aload_1
    //   341: astore 36
    //   343: new 80	java/lang/String
    //   346: dup
    //   347: aload 40
    //   349: iload 7
    //   351: iload 20
    //   353: invokespecial 83	java/lang/String:<init>	([BII)V
    //   356: astore 31
    //   358: iload_3
    //   359: istore 5
    //   361: aload 25
    //   363: astore 27
    //   365: aload 24
    //   367: astore 29
    //   369: aload_1
    //   370: astore 26
    //   372: aload 23
    //   374: astore 25
    //   376: aload 22
    //   378: astore 24
    //   380: aload 29
    //   382: astore 23
    //   384: aload 27
    //   386: astore 22
    //   388: iload_2
    //   389: istore_3
    //   390: iload 5
    //   392: istore_2
    //   393: aload 31
    //   395: astore_1
    //   396: iload 7
    //   398: istore 5
    //   400: iload 5
    //   402: iload 20
    //   404: iadd
    //   405: istore 7
    //   407: aload 26
    //   409: astore 27
    //   411: aload 25
    //   413: astore 29
    //   415: aload 24
    //   417: astore 30
    //   419: iload_3
    //   420: istore 5
    //   422: aload_1
    //   423: astore 26
    //   425: iload_2
    //   426: istore_3
    //   427: iload 5
    //   429: istore_2
    //   430: aload 22
    //   432: astore 25
    //   434: aload 23
    //   436: astore 24
    //   438: aload 30
    //   440: astore 22
    //   442: aload 29
    //   444: astore 23
    //   446: aload 27
    //   448: astore_1
    //   449: goto -256 -> 193
    //   452: aload_0
    //   453: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   456: new 80	java/lang/String
    //   459: dup
    //   460: aload 23
    //   462: invokespecial 86	java/lang/String:<init>	([B)V
    //   465: putfield 74	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   468: goto -329 -> 139
    //   471: iload 6
    //   473: iconst_3
    //   474: if_icmpne +102 -> 576
    //   477: iload 5
    //   479: iconst_1
    //   480: iadd
    //   481: istore 5
    //   483: iload 4
    //   485: istore 9
    //   487: iload_3
    //   488: istore 11
    //   490: iload_2
    //   491: istore 6
    //   493: aload 25
    //   495: astore 29
    //   497: aload 24
    //   499: astore 30
    //   501: aload 22
    //   503: astore 32
    //   505: aload 23
    //   507: astore 34
    //   509: aload_1
    //   510: astore 36
    //   512: new 80	java/lang/String
    //   515: dup
    //   516: aload 40
    //   518: iload 5
    //   520: iload 20
    //   522: invokespecial 83	java/lang/String:<init>	([BII)V
    //   525: astore 27
    //   527: aload 27
    //   529: astore 28
    //   531: iload_2
    //   532: istore 6
    //   534: aload 22
    //   536: astore 27
    //   538: aload 23
    //   540: astore 29
    //   542: aload_1
    //   543: astore 30
    //   545: aload 26
    //   547: astore_1
    //   548: iload_3
    //   549: istore_2
    //   550: iload 6
    //   552: istore_3
    //   553: aload 25
    //   555: astore 22
    //   557: aload 24
    //   559: astore 23
    //   561: aload 27
    //   563: astore 24
    //   565: aload 29
    //   567: astore 25
    //   569: aload 30
    //   571: astore 26
    //   573: goto -173 -> 400
    //   576: iload 6
    //   578: bipush 32
    //   580: if_icmpne +3313 -> 3893
    //   583: iload 5
    //   585: istore 8
    //   587: iload 4
    //   589: istore 10
    //   591: iload_3
    //   592: istore 12
    //   594: iload_2
    //   595: istore 7
    //   597: aload 25
    //   599: astore 38
    //   601: aload 24
    //   603: astore 37
    //   605: aload 22
    //   607: astore 35
    //   609: aload 23
    //   611: astore 33
    //   613: aload_1
    //   614: astore 31
    //   616: iload 4
    //   618: istore 9
    //   620: iload_3
    //   621: istore 11
    //   623: iload_2
    //   624: istore 6
    //   626: aload 25
    //   628: astore 29
    //   630: aload 24
    //   632: astore 30
    //   634: aload 22
    //   636: astore 32
    //   638: aload 23
    //   640: astore 34
    //   642: aload_1
    //   643: astore 36
    //   645: iload 20
    //   647: newarray byte
    //   649: astore 27
    //   651: iload 5
    //   653: iconst_1
    //   654: iadd
    //   655: istore 5
    //   657: iload 5
    //   659: istore 8
    //   661: iload 4
    //   663: istore 10
    //   665: iload_3
    //   666: istore 12
    //   668: iload_2
    //   669: istore 7
    //   671: aload 25
    //   673: astore 38
    //   675: aload 24
    //   677: astore 37
    //   679: aload 22
    //   681: astore 35
    //   683: aload 23
    //   685: astore 33
    //   687: aload_1
    //   688: astore 31
    //   690: iload 4
    //   692: istore 9
    //   694: iload_3
    //   695: istore 11
    //   697: iload_2
    //   698: istore 6
    //   700: aload 25
    //   702: astore 29
    //   704: aload 24
    //   706: astore 30
    //   708: aload 22
    //   710: astore 32
    //   712: aload 23
    //   714: astore 34
    //   716: aload_1
    //   717: astore 36
    //   719: aload 40
    //   721: iload 5
    //   723: aload 27
    //   725: iconst_0
    //   726: iload 20
    //   728: invokestatic 92	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   731: iload 5
    //   733: istore 8
    //   735: iload 4
    //   737: istore 10
    //   739: iload_3
    //   740: istore 12
    //   742: iload_2
    //   743: istore 7
    //   745: aload 25
    //   747: astore 38
    //   749: aload 24
    //   751: astore 37
    //   753: aload 22
    //   755: astore 35
    //   757: aload 23
    //   759: astore 33
    //   761: aload_1
    //   762: astore 31
    //   764: iload 4
    //   766: istore 9
    //   768: iload_3
    //   769: istore 11
    //   771: iload_2
    //   772: istore 6
    //   774: aload 25
    //   776: astore 29
    //   778: aload 24
    //   780: astore 30
    //   782: aload 22
    //   784: astore 32
    //   786: aload 23
    //   788: astore 34
    //   790: aload_1
    //   791: astore 36
    //   793: new 94	com/tencent/ims/devlock_verify_scheme$SchemePkg
    //   796: dup
    //   797: invokespecial 95	com/tencent/ims/devlock_verify_scheme$SchemePkg:<init>	()V
    //   800: astore 41
    //   802: iload 5
    //   804: istore 8
    //   806: iload 4
    //   808: istore 10
    //   810: iload_3
    //   811: istore 12
    //   813: iload_2
    //   814: istore 7
    //   816: aload 25
    //   818: astore 38
    //   820: aload 24
    //   822: astore 37
    //   824: aload 22
    //   826: astore 35
    //   828: aload 23
    //   830: astore 33
    //   832: aload_1
    //   833: astore 31
    //   835: iload 4
    //   837: istore 9
    //   839: iload_3
    //   840: istore 11
    //   842: iload_2
    //   843: istore 6
    //   845: aload 25
    //   847: astore 29
    //   849: aload 24
    //   851: astore 30
    //   853: aload 22
    //   855: astore 32
    //   857: aload 23
    //   859: astore 34
    //   861: aload_1
    //   862: astore 36
    //   864: aload 41
    //   866: aload 27
    //   868: invokevirtual 99	com/tencent/ims/devlock_verify_scheme$SchemePkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   871: pop
    //   872: iconst_1
    //   873: istore 14
    //   875: iconst_1
    //   876: istore 17
    //   878: iconst_1
    //   879: istore 15
    //   881: iconst_1
    //   882: istore 18
    //   884: iconst_1
    //   885: istore 16
    //   887: iconst_1
    //   888: istore 19
    //   890: iconst_1
    //   891: istore 13
    //   893: iload 5
    //   895: istore 8
    //   897: iload 17
    //   899: istore 10
    //   901: iload_3
    //   902: istore 12
    //   904: iload_2
    //   905: istore 7
    //   907: aload 25
    //   909: astore 38
    //   911: aload 24
    //   913: astore 37
    //   915: aload 22
    //   917: astore 35
    //   919: aload 23
    //   921: astore 33
    //   923: aload_1
    //   924: astore 31
    //   926: iload 18
    //   928: istore 9
    //   930: iload_3
    //   931: istore 11
    //   933: iload_2
    //   934: istore 6
    //   936: aload 25
    //   938: astore 29
    //   940: aload 24
    //   942: astore 30
    //   944: aload 22
    //   946: astore 32
    //   948: aload 23
    //   950: astore 34
    //   952: aload_1
    //   953: astore 36
    //   955: aload 41
    //   957: getfield 103	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   960: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   963: ifeq +75 -> 1038
    //   966: iload 5
    //   968: istore 8
    //   970: iload 17
    //   972: istore 10
    //   974: iload_3
    //   975: istore 12
    //   977: iload_2
    //   978: istore 7
    //   980: aload 25
    //   982: astore 38
    //   984: aload 24
    //   986: astore 37
    //   988: aload 22
    //   990: astore 35
    //   992: aload 23
    //   994: astore 33
    //   996: aload_1
    //   997: astore 31
    //   999: iload 18
    //   1001: istore 9
    //   1003: iload_3
    //   1004: istore 11
    //   1006: iload_2
    //   1007: istore 6
    //   1009: aload 25
    //   1011: astore 29
    //   1013: aload 24
    //   1015: astore 30
    //   1017: aload 22
    //   1019: astore 32
    //   1021: aload 23
    //   1023: astore 34
    //   1025: aload_1
    //   1026: astore 36
    //   1028: aload 41
    //   1030: getfield 103	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_verify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1033: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1036: istore 13
    //   1038: iload 5
    //   1040: istore 7
    //   1042: iload 19
    //   1044: istore 4
    //   1046: iload 13
    //   1048: iconst_1
    //   1049: if_icmpne -856 -> 193
    //   1052: iconst_1
    //   1053: istore 13
    //   1055: iload 5
    //   1057: istore 8
    //   1059: iload 17
    //   1061: istore 10
    //   1063: iload_3
    //   1064: istore 12
    //   1066: iload_2
    //   1067: istore 7
    //   1069: aload 25
    //   1071: astore 38
    //   1073: aload 24
    //   1075: astore 37
    //   1077: aload 22
    //   1079: astore 35
    //   1081: aload 23
    //   1083: astore 33
    //   1085: aload_1
    //   1086: astore 31
    //   1088: iload 18
    //   1090: istore 9
    //   1092: iload_3
    //   1093: istore 11
    //   1095: iload_2
    //   1096: istore 6
    //   1098: aload 25
    //   1100: astore 29
    //   1102: aload 24
    //   1104: astore 30
    //   1106: aload 22
    //   1108: astore 32
    //   1110: aload 23
    //   1112: astore 34
    //   1114: aload_1
    //   1115: astore 36
    //   1117: aload 41
    //   1119: getfield 116	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1122: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1125: ifeq +75 -> 1200
    //   1128: iload 5
    //   1130: istore 8
    //   1132: iload 17
    //   1134: istore 10
    //   1136: iload_3
    //   1137: istore 12
    //   1139: iload_2
    //   1140: istore 7
    //   1142: aload 25
    //   1144: astore 38
    //   1146: aload 24
    //   1148: astore 37
    //   1150: aload 22
    //   1152: astore 35
    //   1154: aload 23
    //   1156: astore 33
    //   1158: aload_1
    //   1159: astore 31
    //   1161: iload 18
    //   1163: istore 9
    //   1165: iload_3
    //   1166: istore 11
    //   1168: iload_2
    //   1169: istore 6
    //   1171: aload 25
    //   1173: astore 29
    //   1175: aload 24
    //   1177: astore 30
    //   1179: aload 22
    //   1181: astore 32
    //   1183: aload 23
    //   1185: astore 34
    //   1187: aload_1
    //   1188: astore 36
    //   1190: aload 41
    //   1192: getfield 116	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_use_local_scheme	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1195: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1198: istore 13
    //   1200: iload 5
    //   1202: istore 7
    //   1204: iload 19
    //   1206: istore 4
    //   1208: iload 13
    //   1210: iconst_1
    //   1211: if_icmpeq -1018 -> 193
    //   1214: aload_1
    //   1215: astore 27
    //   1217: iload 5
    //   1219: istore 8
    //   1221: iload 17
    //   1223: istore 10
    //   1225: iload_3
    //   1226: istore 12
    //   1228: iload_2
    //   1229: istore 7
    //   1231: aload 25
    //   1233: astore 38
    //   1235: aload 24
    //   1237: astore 37
    //   1239: aload 22
    //   1241: astore 35
    //   1243: aload 23
    //   1245: astore 33
    //   1247: aload_1
    //   1248: astore 31
    //   1250: iload 18
    //   1252: istore 9
    //   1254: iload_3
    //   1255: istore 11
    //   1257: iload_2
    //   1258: istore 6
    //   1260: aload 25
    //   1262: astore 29
    //   1264: aload 24
    //   1266: astore 30
    //   1268: aload 22
    //   1270: astore 32
    //   1272: aload 23
    //   1274: astore 34
    //   1276: aload_1
    //   1277: astore 36
    //   1279: aload 41
    //   1281: getfield 120	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1284: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1287: ifeq +75 -> 1362
    //   1290: iload 5
    //   1292: istore 8
    //   1294: iload 17
    //   1296: istore 10
    //   1298: iload_3
    //   1299: istore 12
    //   1301: iload_2
    //   1302: istore 7
    //   1304: aload 25
    //   1306: astore 38
    //   1308: aload 24
    //   1310: astore 37
    //   1312: aload 22
    //   1314: astore 35
    //   1316: aload 23
    //   1318: astore 33
    //   1320: aload_1
    //   1321: astore 31
    //   1323: iload 18
    //   1325: istore 9
    //   1327: iload_3
    //   1328: istore 11
    //   1330: iload_2
    //   1331: istore 6
    //   1333: aload 25
    //   1335: astore 29
    //   1337: aload 24
    //   1339: astore 30
    //   1341: aload 22
    //   1343: astore 32
    //   1345: aload 23
    //   1347: astore 34
    //   1349: aload_1
    //   1350: astore 36
    //   1352: aload 41
    //   1354: getfield 120	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1357: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1360: astore 27
    //   1362: aload 23
    //   1364: astore_1
    //   1365: iload 5
    //   1367: istore 8
    //   1369: iload 17
    //   1371: istore 10
    //   1373: iload_3
    //   1374: istore 12
    //   1376: iload_2
    //   1377: istore 7
    //   1379: aload 25
    //   1381: astore 38
    //   1383: aload 24
    //   1385: astore 37
    //   1387: aload 22
    //   1389: astore 35
    //   1391: aload 23
    //   1393: astore 33
    //   1395: aload 27
    //   1397: astore 31
    //   1399: iload 18
    //   1401: istore 9
    //   1403: iload_3
    //   1404: istore 11
    //   1406: iload_2
    //   1407: istore 6
    //   1409: aload 25
    //   1411: astore 29
    //   1413: aload 24
    //   1415: astore 30
    //   1417: aload 22
    //   1419: astore 32
    //   1421: aload 23
    //   1423: astore 34
    //   1425: aload 27
    //   1427: astore 36
    //   1429: aload 41
    //   1431: getfield 129	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1434: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1437: ifeq +76 -> 1513
    //   1440: iload 5
    //   1442: istore 8
    //   1444: iload 17
    //   1446: istore 10
    //   1448: iload_3
    //   1449: istore 12
    //   1451: iload_2
    //   1452: istore 7
    //   1454: aload 25
    //   1456: astore 38
    //   1458: aload 24
    //   1460: astore 37
    //   1462: aload 22
    //   1464: astore 35
    //   1466: aload 23
    //   1468: astore 33
    //   1470: aload 27
    //   1472: astore 31
    //   1474: iload 18
    //   1476: istore 9
    //   1478: iload_3
    //   1479: istore 11
    //   1481: iload_2
    //   1482: istore 6
    //   1484: aload 25
    //   1486: astore 29
    //   1488: aload 24
    //   1490: astore 30
    //   1492: aload 22
    //   1494: astore 32
    //   1496: aload 23
    //   1498: astore 34
    //   1500: aload 27
    //   1502: astore 36
    //   1504: aload 41
    //   1506: getfield 129	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_text	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1509: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1512: astore_1
    //   1513: aload 22
    //   1515: astore 23
    //   1517: iload 5
    //   1519: istore 8
    //   1521: iload 17
    //   1523: istore 10
    //   1525: iload_3
    //   1526: istore 12
    //   1528: iload_2
    //   1529: istore 7
    //   1531: aload 25
    //   1533: astore 38
    //   1535: aload 24
    //   1537: astore 37
    //   1539: aload 22
    //   1541: astore 35
    //   1543: aload_1
    //   1544: astore 33
    //   1546: aload 27
    //   1548: astore 31
    //   1550: iload 18
    //   1552: istore 9
    //   1554: iload_3
    //   1555: istore 11
    //   1557: iload_2
    //   1558: istore 6
    //   1560: aload 25
    //   1562: astore 29
    //   1564: aload 24
    //   1566: astore 30
    //   1568: aload 22
    //   1570: astore 32
    //   1572: aload_1
    //   1573: astore 34
    //   1575: aload 27
    //   1577: astore 36
    //   1579: aload 41
    //   1581: getfield 132	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1584: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1587: ifeq +75 -> 1662
    //   1590: iload 5
    //   1592: istore 8
    //   1594: iload 17
    //   1596: istore 10
    //   1598: iload_3
    //   1599: istore 12
    //   1601: iload_2
    //   1602: istore 7
    //   1604: aload 25
    //   1606: astore 38
    //   1608: aload 24
    //   1610: astore 37
    //   1612: aload 22
    //   1614: astore 35
    //   1616: aload_1
    //   1617: astore 33
    //   1619: aload 27
    //   1621: astore 31
    //   1623: iload 18
    //   1625: istore 9
    //   1627: iload_3
    //   1628: istore 11
    //   1630: iload_2
    //   1631: istore 6
    //   1633: aload 25
    //   1635: astore 29
    //   1637: aload 24
    //   1639: astore 30
    //   1641: aload 22
    //   1643: astore 32
    //   1645: aload_1
    //   1646: astore 34
    //   1648: aload 27
    //   1650: astore 36
    //   1652: aload 41
    //   1654: getfield 132	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_subtext	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1657: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1660: astore 23
    //   1662: iload 5
    //   1664: istore 8
    //   1666: iload 17
    //   1668: istore 10
    //   1670: iload_3
    //   1671: istore 12
    //   1673: iload_2
    //   1674: istore 7
    //   1676: aload 25
    //   1678: astore 38
    //   1680: aload 24
    //   1682: astore 37
    //   1684: aload 23
    //   1686: astore 35
    //   1688: aload_1
    //   1689: astore 33
    //   1691: aload 27
    //   1693: astore 31
    //   1695: iload 18
    //   1697: istore 9
    //   1699: iload_3
    //   1700: istore 11
    //   1702: iload_2
    //   1703: istore 6
    //   1705: aload 25
    //   1707: astore 29
    //   1709: aload 24
    //   1711: astore 30
    //   1713: aload 23
    //   1715: astore 32
    //   1717: aload_1
    //   1718: astore 34
    //   1720: aload 27
    //   1722: astore 36
    //   1724: aload 41
    //   1726: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1729: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1732: ifeq +80 -> 1812
    //   1735: iload 5
    //   1737: istore 8
    //   1739: iload 17
    //   1741: istore 10
    //   1743: iload_3
    //   1744: istore 12
    //   1746: iload_2
    //   1747: istore 7
    //   1749: aload 25
    //   1751: astore 38
    //   1753: aload 24
    //   1755: astore 37
    //   1757: aload 23
    //   1759: astore 35
    //   1761: aload_1
    //   1762: astore 33
    //   1764: aload 27
    //   1766: astore 31
    //   1768: iload 18
    //   1770: istore 9
    //   1772: iload_3
    //   1773: istore 11
    //   1775: iload_2
    //   1776: istore 6
    //   1778: aload 25
    //   1780: astore 29
    //   1782: aload 24
    //   1784: astore 30
    //   1786: aload 23
    //   1788: astore 32
    //   1790: aload_1
    //   1791: astore 34
    //   1793: aload 27
    //   1795: astore 36
    //   1797: aload_0
    //   1798: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   1801: aload 41
    //   1803: getfield 135	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1806: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1809: putfield 138	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   1812: iload 5
    //   1814: istore 8
    //   1816: iload 17
    //   1818: istore 10
    //   1820: iload_3
    //   1821: istore 12
    //   1823: iload_2
    //   1824: istore 7
    //   1826: aload 25
    //   1828: astore 38
    //   1830: aload 24
    //   1832: astore 37
    //   1834: aload 23
    //   1836: astore 35
    //   1838: aload_1
    //   1839: astore 33
    //   1841: aload 27
    //   1843: astore 31
    //   1845: iload 18
    //   1847: istore 9
    //   1849: iload_3
    //   1850: istore 11
    //   1852: iload_2
    //   1853: istore 6
    //   1855: aload 25
    //   1857: astore 29
    //   1859: aload 24
    //   1861: astore 30
    //   1863: aload 23
    //   1865: astore 32
    //   1867: aload_1
    //   1868: astore 34
    //   1870: aload 27
    //   1872: astore 36
    //   1874: aload 41
    //   1876: getfield 141	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1879: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   1882: ifeq +791 -> 2673
    //   1885: iload 5
    //   1887: istore 8
    //   1889: iload 17
    //   1891: istore 10
    //   1893: iload_3
    //   1894: istore 12
    //   1896: iload_2
    //   1897: istore 7
    //   1899: aload 25
    //   1901: astore 38
    //   1903: aload 24
    //   1905: astore 37
    //   1907: aload 23
    //   1909: astore 35
    //   1911: aload_1
    //   1912: astore 33
    //   1914: aload 27
    //   1916: astore 31
    //   1918: iload 18
    //   1920: istore 9
    //   1922: iload_3
    //   1923: istore 11
    //   1925: iload_2
    //   1926: istore 6
    //   1928: aload 25
    //   1930: astore 29
    //   1932: aload 24
    //   1934: astore 30
    //   1936: aload 23
    //   1938: astore 32
    //   1940: aload_1
    //   1941: astore 34
    //   1943: aload 27
    //   1945: astore 36
    //   1947: aload 41
    //   1949: getfield 141	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button1_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1952: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1955: astore 24
    //   1957: iload_2
    //   1958: istore 4
    //   1960: iload 4
    //   1962: istore_2
    //   1963: iload 5
    //   1965: istore 8
    //   1967: iload 17
    //   1969: istore 10
    //   1971: iload_3
    //   1972: istore 12
    //   1974: iload 4
    //   1976: istore 7
    //   1978: aload 25
    //   1980: astore 38
    //   1982: aload 24
    //   1984: astore 37
    //   1986: aload 23
    //   1988: astore 35
    //   1990: aload_1
    //   1991: astore 33
    //   1993: aload 27
    //   1995: astore 31
    //   1997: iload 18
    //   1999: istore 9
    //   2001: iload_3
    //   2002: istore 11
    //   2004: iload 4
    //   2006: istore 6
    //   2008: aload 25
    //   2010: astore 29
    //   2012: aload 24
    //   2014: astore 30
    //   2016: aload 23
    //   2018: astore 32
    //   2020: aload_1
    //   2021: astore 34
    //   2023: aload 27
    //   2025: astore 36
    //   2027: aload_0
    //   2028: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2031: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   2034: ifne +5 -> 2039
    //   2037: iconst_0
    //   2038: istore_2
    //   2039: iload 5
    //   2041: istore 8
    //   2043: iload 17
    //   2045: istore 10
    //   2047: iload_3
    //   2048: istore 12
    //   2050: iload_2
    //   2051: istore 7
    //   2053: aload 25
    //   2055: astore 38
    //   2057: aload 24
    //   2059: astore 37
    //   2061: aload 23
    //   2063: astore 35
    //   2065: aload_1
    //   2066: astore 33
    //   2068: aload 27
    //   2070: astore 31
    //   2072: iload 18
    //   2074: istore 9
    //   2076: iload_3
    //   2077: istore 11
    //   2079: iload_2
    //   2080: istore 6
    //   2082: aload 25
    //   2084: astore 29
    //   2086: aload 24
    //   2088: astore 30
    //   2090: aload 23
    //   2092: astore 32
    //   2094: aload_1
    //   2095: astore 34
    //   2097: aload 27
    //   2099: astore 36
    //   2101: aload 41
    //   2103: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2106: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2109: ifeq +80 -> 2189
    //   2112: iload 5
    //   2114: istore 8
    //   2116: iload 17
    //   2118: istore 10
    //   2120: iload_3
    //   2121: istore 12
    //   2123: iload_2
    //   2124: istore 7
    //   2126: aload 25
    //   2128: astore 38
    //   2130: aload 24
    //   2132: astore 37
    //   2134: aload 23
    //   2136: astore 35
    //   2138: aload_1
    //   2139: astore 33
    //   2141: aload 27
    //   2143: astore 31
    //   2145: iload 18
    //   2147: istore 9
    //   2149: iload_3
    //   2150: istore 11
    //   2152: iload_2
    //   2153: istore 6
    //   2155: aload 25
    //   2157: astore 29
    //   2159: aload 24
    //   2161: astore 30
    //   2163: aload 23
    //   2165: astore 32
    //   2167: aload_1
    //   2168: astore 34
    //   2170: aload 27
    //   2172: astore 36
    //   2174: aload_0
    //   2175: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2178: aload 41
    //   2180: getfield 147	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button1_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2183: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2186: putfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_Int	I
    //   2189: iload 5
    //   2191: istore 8
    //   2193: iload 17
    //   2195: istore 10
    //   2197: iload_3
    //   2198: istore 12
    //   2200: iload_2
    //   2201: istore 7
    //   2203: aload 25
    //   2205: astore 38
    //   2207: aload 24
    //   2209: astore 37
    //   2211: aload 23
    //   2213: astore 35
    //   2215: aload_1
    //   2216: astore 33
    //   2218: aload 27
    //   2220: astore 31
    //   2222: iload 18
    //   2224: istore 9
    //   2226: iload_3
    //   2227: istore 11
    //   2229: iload_2
    //   2230: istore 6
    //   2232: aload 25
    //   2234: astore 29
    //   2236: aload 24
    //   2238: astore 30
    //   2240: aload 23
    //   2242: astore 32
    //   2244: aload_1
    //   2245: astore 34
    //   2247: aload 27
    //   2249: astore 36
    //   2251: aload 41
    //   2253: getfield 152	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2256: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2259: ifeq +80 -> 2339
    //   2262: iload 5
    //   2264: istore 8
    //   2266: iload 17
    //   2268: istore 10
    //   2270: iload_3
    //   2271: istore 12
    //   2273: iload_2
    //   2274: istore 7
    //   2276: aload 25
    //   2278: astore 38
    //   2280: aload 24
    //   2282: astore 37
    //   2284: aload 23
    //   2286: astore 35
    //   2288: aload_1
    //   2289: astore 33
    //   2291: aload 27
    //   2293: astore 31
    //   2295: iload 18
    //   2297: istore 9
    //   2299: iload_3
    //   2300: istore 11
    //   2302: iload_2
    //   2303: istore 6
    //   2305: aload 25
    //   2307: astore 29
    //   2309: aload 24
    //   2311: astore 30
    //   2313: aload 23
    //   2315: astore 32
    //   2317: aload_1
    //   2318: astore 34
    //   2320: aload 27
    //   2322: astore 36
    //   2324: aload_0
    //   2325: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2328: aload 41
    //   2330: getfield 152	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2333: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2336: putfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   2339: iconst_0
    //   2340: istore 4
    //   2342: iconst_0
    //   2343: istore_3
    //   2344: iload 5
    //   2346: istore 8
    //   2348: iload 17
    //   2350: istore 10
    //   2352: iload_3
    //   2353: istore 12
    //   2355: iload_2
    //   2356: istore 7
    //   2358: aload 25
    //   2360: astore 38
    //   2362: aload 24
    //   2364: astore 37
    //   2366: aload 23
    //   2368: astore 35
    //   2370: aload_1
    //   2371: astore 33
    //   2373: aload 27
    //   2375: astore 31
    //   2377: iload 18
    //   2379: istore 9
    //   2381: iload 4
    //   2383: istore 11
    //   2385: iload_2
    //   2386: istore 6
    //   2388: aload 25
    //   2390: astore 29
    //   2392: aload 24
    //   2394: astore 30
    //   2396: aload 23
    //   2398: astore 32
    //   2400: aload_1
    //   2401: astore 34
    //   2403: aload 27
    //   2405: astore 36
    //   2407: aload 25
    //   2409: astore 39
    //   2411: aload 41
    //   2413: getfield 155	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2416: invokevirtual 123	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   2419: ifeq +1465 -> 3884
    //   2422: iload 5
    //   2424: istore 8
    //   2426: iload 17
    //   2428: istore 10
    //   2430: iload_3
    //   2431: istore 12
    //   2433: iload_2
    //   2434: istore 7
    //   2436: aload 25
    //   2438: astore 38
    //   2440: aload 24
    //   2442: astore 37
    //   2444: aload 23
    //   2446: astore 35
    //   2448: aload_1
    //   2449: astore 33
    //   2451: aload 27
    //   2453: astore 31
    //   2455: iload 18
    //   2457: istore 9
    //   2459: iload 4
    //   2461: istore 11
    //   2463: iload_2
    //   2464: istore 6
    //   2466: aload 25
    //   2468: astore 29
    //   2470: aload 24
    //   2472: astore 30
    //   2474: aload 23
    //   2476: astore 32
    //   2478: aload_1
    //   2479: astore 34
    //   2481: aload 27
    //   2483: astore 36
    //   2485: aload 41
    //   2487: getfield 155	com/tencent/ims/devlock_verify_scheme$SchemePkg:str_button2_caption	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2490: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2493: astore 22
    //   2495: iload 5
    //   2497: istore 8
    //   2499: iload 17
    //   2501: istore 10
    //   2503: iload_3
    //   2504: istore 12
    //   2506: iload_2
    //   2507: istore 7
    //   2509: aload 22
    //   2511: astore 38
    //   2513: aload 24
    //   2515: astore 37
    //   2517: aload 23
    //   2519: astore 35
    //   2521: aload_1
    //   2522: astore 33
    //   2524: aload 27
    //   2526: astore 31
    //   2528: iload 18
    //   2530: istore 9
    //   2532: iload 4
    //   2534: istore 11
    //   2536: iload_2
    //   2537: istore 6
    //   2539: aload 22
    //   2541: astore 29
    //   2543: aload 24
    //   2545: astore 30
    //   2547: aload 23
    //   2549: astore 32
    //   2551: aload_1
    //   2552: astore 34
    //   2554: aload 27
    //   2556: astore 36
    //   2558: aload 22
    //   2560: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2563: istore 21
    //   2565: aload 22
    //   2567: astore 39
    //   2569: iload 21
    //   2571: ifne +1313 -> 3884
    //   2574: iconst_1
    //   2575: istore_3
    //   2576: aload 41
    //   2578: getfield 164	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2581: invokevirtual 109	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2584: ifeq +18 -> 2602
    //   2587: aload_0
    //   2588: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2591: aload 41
    //   2593: getfield 164	com/tencent/ims/devlock_verify_scheme$SchemePkg:u32_button2_auth	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2596: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2599: putfield 166	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   2602: iload_3
    //   2603: istore 4
    //   2605: iload_3
    //   2606: ifeq +23 -> 2629
    //   2609: aload_0
    //   2610: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2613: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   2616: istore 6
    //   2618: iload_3
    //   2619: istore 4
    //   2621: iload 6
    //   2623: ifne +6 -> 2629
    //   2626: iconst_0
    //   2627: istore 4
    //   2629: aload 23
    //   2631: astore 25
    //   2633: aload_1
    //   2634: astore 29
    //   2636: iload 4
    //   2638: istore_3
    //   2639: aload 26
    //   2641: astore_1
    //   2642: iload_2
    //   2643: istore 6
    //   2645: iload 14
    //   2647: istore 4
    //   2649: iload_3
    //   2650: istore_2
    //   2651: iload 6
    //   2653: istore_3
    //   2654: aload 24
    //   2656: astore 23
    //   2658: aload 25
    //   2660: astore 24
    //   2662: aload 29
    //   2664: astore 25
    //   2666: aload 27
    //   2668: astore 26
    //   2670: goto -2270 -> 400
    //   2673: iconst_0
    //   2674: istore 4
    //   2676: goto -716 -> 1960
    //   2679: astore 29
    //   2681: iload 12
    //   2683: istore 4
    //   2685: iload 7
    //   2687: istore_3
    //   2688: aload 38
    //   2690: astore 22
    //   2692: aload 37
    //   2694: astore 23
    //   2696: aload 35
    //   2698: astore 24
    //   2700: aload 33
    //   2702: astore 25
    //   2704: aload 31
    //   2706: astore 27
    //   2708: iload 10
    //   2710: istore_2
    //   2711: iload 8
    //   2713: istore 5
    //   2715: aload 29
    //   2717: invokevirtual 169	java/lang/Throwable:printStackTrace	()V
    //   2720: iload 4
    //   2722: istore 6
    //   2724: aload 26
    //   2726: astore_1
    //   2727: iload_2
    //   2728: istore 4
    //   2730: iload 6
    //   2732: istore_2
    //   2733: aload 27
    //   2735: astore 26
    //   2737: goto -2337 -> 400
    //   2740: aload_1
    //   2741: astore 27
    //   2743: iload_3
    //   2744: istore 5
    //   2746: iload 4
    //   2748: istore_3
    //   2749: aload 24
    //   2751: astore_1
    //   2752: aload 23
    //   2754: astore 24
    //   2756: aload 25
    //   2758: astore 23
    //   2760: aload 26
    //   2762: ifnull +15 -> 2777
    //   2765: aload 26
    //   2767: astore 25
    //   2769: aload 26
    //   2771: invokevirtual 172	java/lang/String:length	()I
    //   2774: ifne +14 -> 2788
    //   2777: aload_0
    //   2778: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2781: ldc 173
    //   2783: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   2786: astore 25
    //   2788: aload_0
    //   2789: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2792: aload 25
    //   2794: putfield 175	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   2797: aload_0
    //   2798: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2801: getfield 179	com/tencent/biz/qrcode/activity/QRLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2804: invokevirtual 184	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2807: astore 26
    //   2809: aload_0
    //   2810: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2813: getfield 187	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2816: aload_0
    //   2817: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2820: getfield 179	com/tencent/biz/qrcode/activity/QRLoginActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2823: aload 26
    //   2825: invokestatic 193	com/tencent/mobileqq/utils/ContactUtils:j	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   2828: invokevirtual 199	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2831: aload_0
    //   2832: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2835: aload 27
    //   2837: invokevirtual 202	com/tencent/biz/qrcode/activity/QRLoginActivity:setTitle	(Ljava/lang/CharSequence;)V
    //   2840: iload_3
    //   2841: ifne +1036 -> 3877
    //   2844: aload 28
    //   2846: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2849: ifne +326 -> 3175
    //   2852: aload_0
    //   2853: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2856: ldc 203
    //   2858: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   2861: astore 23
    //   2863: aconst_null
    //   2864: astore 22
    //   2866: aload 28
    //   2868: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2871: ifne +337 -> 3208
    //   2874: aload_0
    //   2875: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2878: getfield 205	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2881: aload 28
    //   2883: invokevirtual 199	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2886: aload 22
    //   2888: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2891: ifne +332 -> 3223
    //   2894: aload_0
    //   2895: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2898: getfield 207	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   2901: aload 22
    //   2903: invokevirtual 199	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   2906: iload_2
    //   2907: ifeq +441 -> 3348
    //   2910: aload_1
    //   2911: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2914: ifeq +960 -> 3874
    //   2917: aload_0
    //   2918: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2921: getfield 149	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_Int	I
    //   2924: iconst_1
    //   2925: if_icmpne +326 -> 3251
    //   2928: aload_0
    //   2929: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2932: getfield 74	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2935: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2938: ifne +300 -> 3238
    //   2941: aload_0
    //   2942: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2945: ldc 208
    //   2947: iconst_1
    //   2948: anewarray 210	java/lang/Object
    //   2951: dup
    //   2952: iconst_0
    //   2953: aload_0
    //   2954: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2957: getfield 74	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2960: aastore
    //   2961: invokevirtual 213	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   2964: astore_1
    //   2965: aload_0
    //   2966: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2969: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   2972: aload_1
    //   2973: invokevirtual 219	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   2976: aload_0
    //   2977: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2980: getfield 138	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   2983: iconst_2
    //   2984: if_icmpne +280 -> 3264
    //   2987: aload_0
    //   2988: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   2991: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   2994: ldc 220
    //   2996: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   2999: aload_0
    //   3000: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3003: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3006: aload_0
    //   3007: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3010: ldc 224
    //   3012: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3015: iload 5
    //   3017: ifeq +443 -> 3460
    //   3020: aload 23
    //   3022: astore_1
    //   3023: aload 23
    //   3025: invokestatic 161	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3028: ifeq +24 -> 3052
    //   3031: aload_0
    //   3032: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3035: getfield 166	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_Int	I
    //   3038: iconst_1
    //   3039: if_icmpne +324 -> 3363
    //   3042: aload_0
    //   3043: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3046: ldc 229
    //   3048: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3051: astore_1
    //   3052: aload_0
    //   3053: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3056: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3059: aload_1
    //   3060: invokevirtual 219	android/widget/Button:setText	(Ljava/lang/CharSequence;)V
    //   3063: aload_0
    //   3064: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3067: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   3070: iconst_2
    //   3071: if_icmpne +305 -> 3376
    //   3074: aload_0
    //   3075: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3078: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3081: ldc 220
    //   3083: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   3086: aload_0
    //   3087: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3090: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3093: aload_0
    //   3094: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3097: ldc 224
    //   3099: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3102: new 233	osq
    //   3105: dup
    //   3106: aload_0
    //   3107: aload 26
    //   3109: invokespecial 236	osq:<init>	(Losp;Ljava/lang/String;)V
    //   3112: invokevirtual 239	osq:start	()V
    //   3115: return
    //   3116: astore_1
    //   3117: aload 36
    //   3119: astore 27
    //   3121: aload 34
    //   3123: astore_1
    //   3124: aload 32
    //   3126: astore 23
    //   3128: aload 30
    //   3130: astore 24
    //   3132: aload 29
    //   3134: astore 22
    //   3136: iload 6
    //   3138: istore_2
    //   3139: iload 11
    //   3141: istore 4
    //   3143: iload 9
    //   3145: istore_3
    //   3146: aload 24
    //   3148: astore 25
    //   3150: aload 23
    //   3152: astore 24
    //   3154: aload 22
    //   3156: astore 23
    //   3158: aload 24
    //   3160: astore 22
    //   3162: aload_1
    //   3163: astore 24
    //   3165: aload 25
    //   3167: astore_1
    //   3168: iload 4
    //   3170: istore 5
    //   3172: goto -412 -> 2760
    //   3175: aload_0
    //   3176: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3179: ldc 240
    //   3181: iconst_2
    //   3182: anewarray 210	java/lang/Object
    //   3185: dup
    //   3186: iconst_0
    //   3187: aload_0
    //   3188: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3191: getfield 74	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3194: aastore
    //   3195: dup
    //   3196: iconst_1
    //   3197: aload 25
    //   3199: aastore
    //   3200: invokevirtual 213	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   3203: astore 28
    //   3205: goto -353 -> 2852
    //   3208: aload_0
    //   3209: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3212: getfield 205	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3215: bipush 8
    //   3217: invokevirtual 241	android/widget/TextView:setVisibility	(I)V
    //   3220: goto -334 -> 2886
    //   3223: aload_0
    //   3224: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3227: getfield 207	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   3230: bipush 8
    //   3232: invokevirtual 241	android/widget/TextView:setVisibility	(I)V
    //   3235: goto -329 -> 2906
    //   3238: aload_0
    //   3239: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3242: ldc 229
    //   3244: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3247: astore_1
    //   3248: goto -283 -> 2965
    //   3251: aload_0
    //   3252: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3255: ldc 242
    //   3257: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3260: astore_1
    //   3261: goto -296 -> 2965
    //   3264: aload_0
    //   3265: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3268: getfield 138	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   3271: iconst_3
    //   3272: if_icmpne +34 -> 3306
    //   3275: aload_0
    //   3276: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3279: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3282: ldc 243
    //   3284: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   3287: aload_0
    //   3288: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3291: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3294: aload_0
    //   3295: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3298: ldc 244
    //   3300: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3303: goto -288 -> 3015
    //   3306: aload_0
    //   3307: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3310: getfield 138	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_Int	I
    //   3313: iconst_1
    //   3314: if_icmpne -299 -> 3015
    //   3317: aload_0
    //   3318: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3321: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3324: ldc 245
    //   3326: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   3329: aload_0
    //   3330: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3333: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3336: aload_0
    //   3337: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3340: ldc 246
    //   3342: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3345: goto -330 -> 3015
    //   3348: aload_0
    //   3349: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3352: getfield 216	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3355: bipush 8
    //   3357: invokevirtual 247	android/widget/Button:setVisibility	(I)V
    //   3360: goto -345 -> 3015
    //   3363: aload_0
    //   3364: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3367: ldc 242
    //   3369: invokevirtual 70	com/tencent/biz/qrcode/activity/QRLoginActivity:getString	(I)Ljava/lang/String;
    //   3372: astore_1
    //   3373: goto -321 -> 3052
    //   3376: aload_0
    //   3377: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3380: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   3383: iconst_3
    //   3384: if_icmpne +34 -> 3418
    //   3387: aload_0
    //   3388: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3391: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3394: ldc 243
    //   3396: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   3399: aload_0
    //   3400: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3403: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3406: aload_0
    //   3407: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3410: ldc 244
    //   3412: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3415: goto -313 -> 3102
    //   3418: aload_0
    //   3419: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3422: getfield 144	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_d_of_type_Int	I
    //   3425: iconst_1
    //   3426: if_icmpne -324 -> 3102
    //   3429: aload_0
    //   3430: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3433: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3436: ldc 245
    //   3438: invokevirtual 223	android/widget/Button:setBackgroundResource	(I)V
    //   3441: aload_0
    //   3442: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3445: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3448: aload_0
    //   3449: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3452: ldc 246
    //   3454: invokevirtual 228	android/widget/Button:setTextAppearance	(Landroid/content/Context;I)V
    //   3457: goto -355 -> 3102
    //   3460: aload_0
    //   3461: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3464: getfield 231	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_b_of_type_AndroidWidgetButton	Landroid/widget/Button;
    //   3467: bipush 8
    //   3469: invokevirtual 247	android/widget/Button:setVisibility	(I)V
    //   3472: goto -370 -> 3102
    //   3475: aload_0
    //   3476: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3479: new 80	java/lang/String
    //   3482: dup
    //   3483: aload_1
    //   3484: invokespecial 86	java/lang/String:<init>	([B)V
    //   3487: invokevirtual 250	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3490: return
    //   3491: aload 22
    //   3493: ldc 32
    //   3495: iconst_1
    //   3496: invokevirtual 38	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3499: istore_2
    //   3500: aload 22
    //   3502: ldc 48
    //   3504: invokevirtual 44	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   3507: astore_1
    //   3508: aload 22
    //   3510: ldc 252
    //   3512: invokevirtual 44	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   3515: astore 22
    //   3517: aload 22
    //   3519: ifnull +185 -> 3704
    //   3522: new 254	org/json/JSONObject
    //   3525: dup
    //   3526: new 80	java/lang/String
    //   3529: dup
    //   3530: aload 22
    //   3532: ldc_w 256
    //   3535: invokespecial 259	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3538: invokespecial 261	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   3541: astore 22
    //   3543: aload_0
    //   3544: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3547: aload 22
    //   3549: ldc_w 263
    //   3552: invokevirtual 267	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   3555: putfield 270	com/tencent/biz/qrcode/activity/QRLoginActivity:e	I
    //   3558: aload_0
    //   3559: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3562: aload 22
    //   3564: ldc_w 272
    //   3567: invokevirtual 276	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   3570: putfield 279	com/tencent/biz/qrcode/activity/QRLoginActivity:f	Ljava/lang/String;
    //   3573: aload_0
    //   3574: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3577: aload 22
    //   3579: ldc_w 281
    //   3582: invokevirtual 285	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   3585: putfield 288	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_Long	J
    //   3588: invokestatic 293	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3591: ifeq +68 -> 3659
    //   3594: ldc_w 295
    //   3597: iconst_2
    //   3598: new 297	java/lang/StringBuilder
    //   3601: dup
    //   3602: invokespecial 298	java/lang/StringBuilder:<init>	()V
    //   3605: ldc_w 300
    //   3608: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3611: aload_0
    //   3612: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3615: getfield 270	com/tencent/biz/qrcode/activity/QRLoginActivity:e	I
    //   3618: invokevirtual 307	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3621: ldc_w 309
    //   3624: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3627: aload_0
    //   3628: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3631: getfield 279	com/tencent/biz/qrcode/activity/QRLoginActivity:f	Ljava/lang/String;
    //   3634: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3637: ldc_w 311
    //   3640: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3643: aload_0
    //   3644: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3647: getfield 288	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_Long	J
    //   3650: invokevirtual 314	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3653: invokevirtual 317	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3656: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3659: aload_0
    //   3660: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3663: getfield 323	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3666: invokevirtual 328	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   3669: ifeq +13 -> 3682
    //   3672: aload_0
    //   3673: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3676: getfield 323	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3679: invokevirtual 331	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   3682: iload_2
    //   3683: ifne +40 -> 3723
    //   3686: aload_0
    //   3687: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3690: invokevirtual 333	com/tencent/biz/qrcode/activity/QRLoginActivity:b	()V
    //   3693: return
    //   3694: astore 22
    //   3696: aload 22
    //   3698: invokevirtual 334	java/lang/Exception:printStackTrace	()V
    //   3701: goto -42 -> 3659
    //   3704: invokestatic 337	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3707: ifeq -48 -> 3659
    //   3710: ldc_w 295
    //   3713: iconst_4
    //   3714: ldc_w 339
    //   3717: invokestatic 320	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3720: goto -61 -> 3659
    //   3723: aload_0
    //   3724: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3727: new 80	java/lang/String
    //   3730: dup
    //   3731: aload_1
    //   3732: invokespecial 86	java/lang/String:<init>	([B)V
    //   3735: invokevirtual 250	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3738: return
    //   3739: aload_0
    //   3740: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3743: getfield 323	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3746: ifnull +26 -> 3772
    //   3749: aload_0
    //   3750: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3753: getfield 323	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3756: invokevirtual 328	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   3759: ifeq +13 -> 3772
    //   3762: aload_0
    //   3763: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3766: getfield 323	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   3769: invokevirtual 331	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   3772: aload_0
    //   3773: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3776: getfield 62	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetProgressBar	Landroid/widget/ProgressBar;
    //   3779: bipush 8
    //   3781: invokevirtual 65	android/widget/ProgressBar:setVisibility	(I)V
    //   3784: aload_0
    //   3785: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3788: getfield 53	com/tencent/biz/qrcode/activity/QRLoginActivity:jdField_a_of_type_AndroidWidgetLinearLayout	Landroid/widget/LinearLayout;
    //   3791: iconst_0
    //   3792: invokevirtual 59	android/widget/LinearLayout:setVisibility	(I)V
    //   3795: aload_0
    //   3796: getfield 10	osp:a	Lcom/tencent/biz/qrcode/activity/QRLoginActivity;
    //   3799: aconst_null
    //   3800: invokevirtual 250	com/tencent/biz/qrcode/activity/QRLoginActivity:a	(Ljava/lang/String;)V
    //   3803: return
    //   3804: astore 25
    //   3806: iload_3
    //   3807: istore 4
    //   3809: iload 16
    //   3811: istore_3
    //   3812: goto -666 -> 3146
    //   3815: astore_1
    //   3816: aload 25
    //   3818: astore_1
    //   3819: aload 24
    //   3821: astore 25
    //   3823: iload_3
    //   3824: istore 5
    //   3826: iload_2
    //   3827: istore_3
    //   3828: iload 5
    //   3830: istore_2
    //   3831: aload 23
    //   3833: astore 24
    //   3835: aload 25
    //   3837: astore 23
    //   3839: goto -693 -> 3146
    //   3842: astore 29
    //   3844: aload 23
    //   3846: astore 25
    //   3848: iload_2
    //   3849: istore 6
    //   3851: iload 15
    //   3853: istore_2
    //   3854: iload_3
    //   3855: istore 4
    //   3857: iload 6
    //   3859: istore_3
    //   3860: aload 24
    //   3862: astore 23
    //   3864: aload 25
    //   3866: astore 24
    //   3868: aload_1
    //   3869: astore 25
    //   3871: goto -1156 -> 2715
    //   3874: goto -909 -> 2965
    //   3877: aload 24
    //   3879: astore 28
    //   3881: goto -1015 -> 2866
    //   3884: iconst_0
    //   3885: istore_3
    //   3886: aload 39
    //   3888: astore 22
    //   3890: goto -1314 -> 2576
    //   3893: iload_2
    //   3894: istore 6
    //   3896: aload 22
    //   3898: astore 27
    //   3900: aload 23
    //   3902: astore 29
    //   3904: aload_1
    //   3905: astore 30
    //   3907: aload 26
    //   3909: astore_1
    //   3910: iload_3
    //   3911: istore_2
    //   3912: iload 6
    //   3914: istore_3
    //   3915: aload 25
    //   3917: astore 22
    //   3919: aload 24
    //   3921: astore 23
    //   3923: aload 27
    //   3925: astore 24
    //   3927: aload 29
    //   3929: astore 25
    //   3931: aload 30
    //   3933: astore 26
    //   3935: goto -3535 -> 400
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3938	0	this	osp
    //   0	3938	1	paramMessage	android.os.Message
    //   45	3867	2	i	int
    //   180	3735	3	j	int
    //   188	3668	4	k	int
    //   235	3594	5	m	int
    //   201	3712	6	n	int
    //   191	2495	7	i1	int
    //   585	2127	8	i2	int
    //   195	2949	9	i3	int
    //   589	2120	10	i4	int
    //   198	2942	11	i5	int
    //   592	2090	12	i6	int
    //   891	321	13	i7	int
    //   873	1773	14	i8	int
    //   879	2973	15	i9	int
    //   885	2925	16	i10	int
    //   876	1624	17	i11	int
    //   882	1647	18	i12	int
    //   888	317	19	i13	int
    //   300	427	20	i14	int
    //   2563	7	21	bool	boolean
    //   4	3574	22	localObject1	java.lang.Object
    //   3694	3	22	localException1	java.lang.Exception
    //   3888	30	22	localObject2	java.lang.Object
    //   53	3869	23	localObject3	java.lang.Object
    //   172	3754	24	localObject4	java.lang.Object
    //   175	3023	25	localObject5	java.lang.Object
    //   3804	13	25	localException2	java.lang.Exception
    //   3821	109	25	localObject6	java.lang.Object
    //   182	3752	26	localObject7	java.lang.Object
    //   363	3561	27	localObject8	java.lang.Object
    //   185	3695	28	localObject9	java.lang.Object
    //   205	2458	29	localObject10	java.lang.Object
    //   2679	454	29	localThrowable1	java.lang.Throwable
    //   3842	1	29	localThrowable2	java.lang.Throwable
    //   3902	26	29	localObject11	java.lang.Object
    //   209	3723	30	localObject12	java.lang.Object
    //   356	2349	31	localObject13	java.lang.Object
    //   213	2912	32	localObject14	java.lang.Object
    //   611	2090	33	localObject15	java.lang.Object
    //   217	2905	34	localObject16	java.lang.Object
    //   607	2090	35	localObject17	java.lang.Object
    //   220	2898	36	localObject18	java.lang.Object
    //   603	2090	37	localObject19	java.lang.Object
    //   599	2090	38	localObject20	java.lang.Object
    //   2409	1478	39	localObject21	java.lang.Object
    //   62	658	40	arrayOfByte	byte[]
    //   800	1792	41	localSchemePkg	com.tencent.ims.devlock_verify_scheme.SchemePkg
    // Exception table:
    //   from	to	target	type
    //   645	651	2679	java/lang/Throwable
    //   719	731	2679	java/lang/Throwable
    //   793	802	2679	java/lang/Throwable
    //   864	872	2679	java/lang/Throwable
    //   955	966	2679	java/lang/Throwable
    //   1028	1038	2679	java/lang/Throwable
    //   1117	1128	2679	java/lang/Throwable
    //   1190	1200	2679	java/lang/Throwable
    //   1279	1290	2679	java/lang/Throwable
    //   1352	1362	2679	java/lang/Throwable
    //   1429	1440	2679	java/lang/Throwable
    //   1504	1513	2679	java/lang/Throwable
    //   1579	1590	2679	java/lang/Throwable
    //   1652	1662	2679	java/lang/Throwable
    //   1724	1735	2679	java/lang/Throwable
    //   1797	1812	2679	java/lang/Throwable
    //   1874	1885	2679	java/lang/Throwable
    //   1947	1957	2679	java/lang/Throwable
    //   2027	2037	2679	java/lang/Throwable
    //   2101	2112	2679	java/lang/Throwable
    //   2174	2189	2679	java/lang/Throwable
    //   2251	2262	2679	java/lang/Throwable
    //   2324	2339	2679	java/lang/Throwable
    //   2411	2422	2679	java/lang/Throwable
    //   2485	2495	2679	java/lang/Throwable
    //   2558	2565	2679	java/lang/Throwable
    //   222	230	3116	java/lang/Exception
    //   343	358	3116	java/lang/Exception
    //   512	527	3116	java/lang/Exception
    //   645	651	3116	java/lang/Exception
    //   719	731	3116	java/lang/Exception
    //   793	802	3116	java/lang/Exception
    //   864	872	3116	java/lang/Exception
    //   955	966	3116	java/lang/Exception
    //   1028	1038	3116	java/lang/Exception
    //   1117	1128	3116	java/lang/Exception
    //   1190	1200	3116	java/lang/Exception
    //   1279	1290	3116	java/lang/Exception
    //   1352	1362	3116	java/lang/Exception
    //   1429	1440	3116	java/lang/Exception
    //   1504	1513	3116	java/lang/Exception
    //   1579	1590	3116	java/lang/Exception
    //   1652	1662	3116	java/lang/Exception
    //   1724	1735	3116	java/lang/Exception
    //   1797	1812	3116	java/lang/Exception
    //   1874	1885	3116	java/lang/Exception
    //   1947	1957	3116	java/lang/Exception
    //   2027	2037	3116	java/lang/Exception
    //   2101	2112	3116	java/lang/Exception
    //   2174	2189	3116	java/lang/Exception
    //   2251	2262	3116	java/lang/Exception
    //   2324	2339	3116	java/lang/Exception
    //   2411	2422	3116	java/lang/Exception
    //   2485	2495	3116	java/lang/Exception
    //   2558	2565	3116	java/lang/Exception
    //   3522	3659	3694	java/lang/Exception
    //   2576	2602	3804	java/lang/Exception
    //   2609	2618	3804	java/lang/Exception
    //   2715	2720	3815	java/lang/Exception
    //   2576	2602	3842	java/lang/Throwable
    //   2609	2618	3842	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osp
 * JD-Core Version:    0.7.0.1
 */