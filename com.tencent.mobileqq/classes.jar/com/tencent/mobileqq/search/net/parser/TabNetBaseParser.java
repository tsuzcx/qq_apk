package com.tencent.mobileqq.search.net.parser;

import com.tencent.mobileqq.search.model.ISearchResultGroupModel;

public class TabNetBaseParser
  implements INetSearchResultParser<ISearchResultGroupModel>
{
  private boolean a = false;
  
  /* Error */
  public java.util.List<ISearchResultGroupModel> a(Object... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +2099 -> 2100
    //   4: aload_1
    //   5: arraylength
    //   6: iconst_3
    //   7: if_icmpge +6 -> 13
    //   10: goto +2090 -> 2100
    //   13: aload_1
    //   14: iconst_0
    //   15: aaload
    //   16: instanceof 23
    //   19: istore 9
    //   21: ldc 25
    //   23: astore 21
    //   25: iload 9
    //   27: ifeq +14 -> 41
    //   30: aload_1
    //   31: iconst_0
    //   32: aaload
    //   33: checkcast 23	java/lang/String
    //   36: astore 22
    //   38: goto +7 -> 45
    //   41: ldc 25
    //   43: astore 22
    //   45: aload_1
    //   46: iconst_1
    //   47: aaload
    //   48: instanceof 27
    //   51: ifeq +14 -> 65
    //   54: aload_1
    //   55: iconst_1
    //   56: aaload
    //   57: checkcast 27	java/util/List
    //   60: astore 18
    //   62: goto +12 -> 74
    //   65: new 29	java/util/ArrayList
    //   68: dup
    //   69: invokespecial 30	java/util/ArrayList:<init>	()V
    //   72: astore 18
    //   74: aload_1
    //   75: iconst_2
    //   76: aaload
    //   77: instanceof 32
    //   80: ifeq +16 -> 96
    //   83: aload_1
    //   84: iconst_2
    //   85: aaload
    //   86: checkcast 32	java/lang/Integer
    //   89: invokevirtual 36	java/lang/Integer:intValue	()I
    //   92: istore_2
    //   93: goto +5 -> 98
    //   96: iconst_m1
    //   97: istore_2
    //   98: new 29	java/util/ArrayList
    //   101: dup
    //   102: invokespecial 30	java/util/ArrayList:<init>	()V
    //   105: astore 19
    //   107: new 29	java/util/ArrayList
    //   110: dup
    //   111: aload 18
    //   113: invokeinterface 39 1 0
    //   118: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   121: astore_1
    //   122: aload 18
    //   124: invokeinterface 46 1 0
    //   129: astore 35
    //   131: aconst_null
    //   132: astore 20
    //   134: aload 21
    //   136: astore 18
    //   138: aload 35
    //   140: invokeinterface 52 1 0
    //   145: istore 9
    //   147: ldc 54
    //   149: astore 26
    //   151: iload 9
    //   153: ifeq +1853 -> 2006
    //   156: aload 35
    //   158: invokeinterface 58 1 0
    //   163: checkcast 60	unify/search/UnifySearchCommon$ResultItemGroup
    //   166: astore 21
    //   168: aload 21
    //   170: getfield 64	unify/search/UnifySearchCommon$ResultItemGroup:group_mask	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   173: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   176: lstore 16
    //   178: aload 21
    //   180: getfield 74	unify/search/UnifySearchCommon$ResultItemGroup:group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   183: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   186: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   189: astore 36
    //   191: aload 21
    //   193: getfield 89	unify/search/UnifySearchCommon$ResultItemGroup:rpt_highlight_words	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   196: invokevirtual 94	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   199: astore 23
    //   201: new 29	java/util/ArrayList
    //   204: dup
    //   205: aload 23
    //   207: invokeinterface 39 1 0
    //   212: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   215: astore 30
    //   217: aload 23
    //   219: invokeinterface 46 1 0
    //   224: astore 23
    //   226: aload 23
    //   228: invokeinterface 52 1 0
    //   233: ifeq +27 -> 260
    //   236: aload 30
    //   238: aload 23
    //   240: invokeinterface 58 1 0
    //   245: checkcast 81	com/tencent/mobileqq/pb/ByteStringMicro
    //   248: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   251: invokeinterface 98 2 0
    //   256: pop
    //   257: goto -31 -> 226
    //   260: aload 21
    //   262: getfield 102	unify/search/UnifySearchCommon$ResultItemGroup:result_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   265: invokevirtual 105	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   268: astore 31
    //   270: new 29	java/util/ArrayList
    //   273: dup
    //   274: aload 31
    //   276: invokeinterface 39 1 0
    //   281: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   284: astore 24
    //   286: aload 21
    //   288: getfield 109	unify/search/UnifySearchCommon$ResultItemGroup:hide_title	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   291: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   294: iconst_1
    //   295: if_icmpne +9 -> 304
    //   298: iconst_1
    //   299: istore 9
    //   301: goto +6 -> 307
    //   304: iconst_0
    //   305: istore 9
    //   307: aload_0
    //   308: getfield 15	com/tencent/mobileqq/search/net/parser/TabNetBaseParser:a	Z
    //   311: ifeq +9 -> 320
    //   314: iconst_1
    //   315: istore 9
    //   317: goto +3 -> 320
    //   320: aload 21
    //   322: getfield 116	unify/search/UnifySearchCommon$ResultItemGroup:group_footer_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   325: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   328: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   331: astore 37
    //   333: aload 21
    //   335: getfield 119	unify/search/UnifySearchCommon$ResultItemGroup:group_footer_jump_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   338: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   341: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   344: astore 38
    //   346: aload 31
    //   348: invokeinterface 39 1 0
    //   353: i2l
    //   354: lstore 12
    //   356: iconst_0
    //   357: istore_3
    //   358: iload_3
    //   359: aload 31
    //   361: invokeinterface 39 1 0
    //   366: if_icmpge +1395 -> 1761
    //   369: aload 31
    //   371: iload_3
    //   372: invokeinterface 122 2 0
    //   377: checkcast 124	unify/search/UnifySearchCommon$ResultItem
    //   380: astore 23
    //   382: aload 23
    //   384: getfield 127	unify/search/UnifySearchCommon$ResultItem:sub_result_items	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   387: invokevirtual 105	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   390: astore 25
    //   392: aload 25
    //   394: invokeinterface 39 1 0
    //   399: iconst_1
    //   400: iadd
    //   401: istore 6
    //   403: new 29	java/util/ArrayList
    //   406: dup
    //   407: iload 6
    //   409: invokespecial 42	java/util/ArrayList:<init>	(I)V
    //   412: astore 32
    //   414: aload 32
    //   416: aload 23
    //   418: invokeinterface 98 2 0
    //   423: pop
    //   424: aload 32
    //   426: aload 25
    //   428: invokeinterface 131 2 0
    //   433: pop
    //   434: iconst_0
    //   435: istore 5
    //   437: aload 19
    //   439: astore 23
    //   441: aload_1
    //   442: astore 25
    //   444: aload 26
    //   446: astore 19
    //   448: aload 24
    //   450: astore_1
    //   451: aload 22
    //   453: astore 26
    //   455: iload 5
    //   457: iload 6
    //   459: if_icmpge +1277 -> 1736
    //   462: aload 32
    //   464: iload 5
    //   466: invokeinterface 122 2 0
    //   471: checkcast 124	unify/search/UnifySearchCommon$ResultItem
    //   474: astore 39
    //   476: aload 39
    //   478: getfield 134	unify/search/UnifySearchCommon$ResultItem:result_id	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   481: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   484: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   487: astore 41
    //   489: aload 39
    //   491: getfield 137	unify/search/UnifySearchCommon$ResultItem:layout_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   494: invokevirtual 140	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   497: istore 10
    //   499: aload 39
    //   501: getfield 143	unify/search/UnifySearchCommon$ResultItem:name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   504: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   507: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   510: astore 40
    //   512: aload 39
    //   514: getfield 144	unify/search/UnifySearchCommon$ResultItem:group_mask	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   517: invokevirtual 145	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   520: ifeq +16 -> 536
    //   523: aload 39
    //   525: getfield 144	unify/search/UnifySearchCommon$ResultItem:group_mask	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   528: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   531: lstore 14
    //   533: goto +7 -> 540
    //   536: lload 16
    //   538: lstore 14
    //   540: aload 23
    //   542: astore 33
    //   544: aload 39
    //   546: getfield 148	unify/search/UnifySearchCommon$ResultItem:pic_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   549: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   552: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   555: astore 42
    //   557: aload 39
    //   559: getfield 151	unify/search/UnifySearchCommon$ResultItem:jmp_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   562: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   565: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   568: astore 43
    //   570: aload 39
    //   572: getfield 154	unify/search/UnifySearchCommon$ResultItem:extension	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   575: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   578: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   581: astore 44
    //   583: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq +42 -> 628
    //   589: new 161	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   596: astore 22
    //   598: aload 22
    //   600: ldc 164
    //   602: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 22
    //   608: aload 44
    //   610: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: pop
    //   614: aload 19
    //   616: iconst_2
    //   617: aload 22
    //   619: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   622: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   625: goto +3 -> 628
    //   628: aload_1
    //   629: astore 22
    //   631: lload 14
    //   633: ldc2_w 176
    //   636: lcmp
    //   637: ifne +59 -> 696
    //   640: aload 44
    //   642: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   645: ifne +51 -> 696
    //   648: new 185	org/json/JSONObject
    //   651: dup
    //   652: aload 44
    //   654: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   657: astore_1
    //   658: aload_1
    //   659: ldc 190
    //   661: invokevirtual 194	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   664: istore 4
    //   666: aload_1
    //   667: ldc 196
    //   669: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   672: astore 34
    //   674: iload 4
    //   676: istore 7
    //   678: goto +28 -> 706
    //   681: astore_1
    //   682: goto +7 -> 689
    //   685: astore_1
    //   686: iconst_0
    //   687: istore 4
    //   689: aload_1
    //   690: invokevirtual 203	java/lang/Exception:printStackTrace	()V
    //   693: goto +6 -> 699
    //   696: iconst_0
    //   697: istore 4
    //   699: aconst_null
    //   700: astore 34
    //   702: iload 4
    //   704: istore 7
    //   706: lload 14
    //   708: ldc2_w 204
    //   711: lcmp
    //   712: ifne +218 -> 930
    //   715: aload 44
    //   717: aload 18
    //   719: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   722: ifne +208 -> 930
    //   725: new 185	org/json/JSONObject
    //   728: dup
    //   729: aload 44
    //   731: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   734: astore 29
    //   736: aload 18
    //   738: astore_1
    //   739: aload 29
    //   741: ldc 210
    //   743: invokevirtual 214	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   746: astore 23
    //   748: new 185	org/json/JSONObject
    //   751: dup
    //   752: aload 23
    //   754: iconst_0
    //   755: invokevirtual 217	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   758: invokevirtual 218	java/lang/Object:toString	()Ljava/lang/String;
    //   761: invokespecial 188	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   764: astore 24
    //   766: aload 24
    //   768: ldc 220
    //   770: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   773: astore 27
    //   775: aload 24
    //   777: ldc 222
    //   779: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   782: astore 23
    //   784: aload 24
    //   786: ldc 224
    //   788: invokevirtual 194	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   791: istore 4
    //   793: aload 24
    //   795: ldc 226
    //   797: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   800: astore 28
    //   802: aload 24
    //   804: ldc 228
    //   806: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   809: astore 24
    //   811: aload 29
    //   813: ldc 230
    //   815: invokevirtual 200	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   818: astore 29
    //   820: aload 28
    //   822: astore_1
    //   823: goto +129 -> 952
    //   826: astore 29
    //   828: aload 24
    //   830: astore_1
    //   831: aload 29
    //   833: astore 24
    //   835: goto +13 -> 848
    //   838: astore 24
    //   840: goto +8 -> 848
    //   843: astore 24
    //   845: aload_1
    //   846: astore 28
    //   848: aload_1
    //   849: astore 29
    //   851: aload 28
    //   853: astore_1
    //   854: goto +60 -> 914
    //   857: astore 24
    //   859: goto +8 -> 867
    //   862: astore 24
    //   864: aload_1
    //   865: astore 23
    //   867: aload 18
    //   869: astore_1
    //   870: aload 18
    //   872: astore 28
    //   874: goto +33 -> 907
    //   877: astore 24
    //   879: goto +5 -> 884
    //   882: astore 24
    //   884: aload_1
    //   885: astore 27
    //   887: goto +9 -> 896
    //   890: astore 24
    //   892: aload 18
    //   894: astore 27
    //   896: aload 27
    //   898: astore 28
    //   900: aload 28
    //   902: astore 23
    //   904: aload 23
    //   906: astore_1
    //   907: iconst_0
    //   908: istore 4
    //   910: aload 28
    //   912: astore 29
    //   914: aload 24
    //   916: invokevirtual 231	org/json/JSONException:printStackTrace	()V
    //   919: aload 29
    //   921: astore 24
    //   923: aload 18
    //   925: astore 29
    //   927: goto +25 -> 952
    //   930: aload 18
    //   932: astore 24
    //   934: aload 24
    //   936: astore 27
    //   938: aload 27
    //   940: astore 29
    //   942: aload 29
    //   944: astore 23
    //   946: aload 23
    //   948: astore_1
    //   949: iconst_0
    //   950: istore 4
    //   952: iload 10
    //   954: ifeq +417 -> 1371
    //   957: aload 39
    //   959: getfield 137	unify/search/UnifySearchCommon$ResultItem:layout_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   962: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   965: tableswitch	default:+75 -> 1040, 2:+320->1285, 3:+300->1265, 4:+280->1245, 5:+75->1040, 6:+260->1225, 7:+240->1205, 8:+220->1185, 9:+200->1165, 10:+75->1040, 11:+180->1145, 12:+160->1125, 13:+140->1105, 14:+120->1085, 15:+100->1065, 16:+80->1045
    //   1041: astore_1
    //   1042: goto +260 -> 1302
    //   1045: new 233	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem
    //   1048: dup
    //   1049: aload 26
    //   1051: lload 16
    //   1053: aload 30
    //   1055: aload 39
    //   1057: iload_2
    //   1058: invokespecial 236	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateNetSeaEntranceItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1061: astore_1
    //   1062: goto +240 -> 1302
    //   1065: new 238	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateQAItem
    //   1068: dup
    //   1069: aload 26
    //   1071: lload 16
    //   1073: aload 30
    //   1075: aload 39
    //   1077: iload_2
    //   1078: invokespecial 239	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateQAItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1081: astore_1
    //   1082: goto +220 -> 1302
    //   1085: new 241	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateTitleItem
    //   1088: dup
    //   1089: aload 26
    //   1091: lload 16
    //   1093: aload 30
    //   1095: aload 39
    //   1097: iload_2
    //   1098: invokespecial 242	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateTitleItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1101: astore_1
    //   1102: goto +200 -> 1302
    //   1105: new 244	com/tencent/mobileqq/search/model/NetSearchTemplateHorSlidingContainerItem
    //   1108: dup
    //   1109: aload 26
    //   1111: lload 16
    //   1113: aload 30
    //   1115: aload 39
    //   1117: iload_2
    //   1118: invokespecial 245	com/tencent/mobileqq/search/model/NetSearchTemplateHorSlidingContainerItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1121: astore_1
    //   1122: goto +180 -> 1302
    //   1125: new 247	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBigImageItem
    //   1128: dup
    //   1129: aload 26
    //   1131: lload 16
    //   1133: aload 30
    //   1135: aload 39
    //   1137: iload_2
    //   1138: invokespecial 248	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBigImageItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1141: astore_1
    //   1142: goto +160 -> 1302
    //   1145: new 250	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateFriendUpdatesItem
    //   1148: dup
    //   1149: aload 26
    //   1151: lload 16
    //   1153: aload 30
    //   1155: aload 39
    //   1157: iload_2
    //   1158: invokespecial 251	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateFriendUpdatesItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1161: astore_1
    //   1162: goto +140 -> 1302
    //   1165: new 253	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateSubItemTitle
    //   1168: dup
    //   1169: aload 26
    //   1171: lload 16
    //   1173: aload 30
    //   1175: aload 39
    //   1177: iload_2
    //   1178: invokespecial 254	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateSubItemTitle:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1181: astore_1
    //   1182: goto +120 -> 1302
    //   1185: new 256	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateSubItem
    //   1188: dup
    //   1189: aload 26
    //   1191: lload 16
    //   1193: aload 30
    //   1195: aload 39
    //   1197: iload_2
    //   1198: invokespecial 257	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateSubItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1201: astore_1
    //   1202: goto +100 -> 1302
    //   1205: new 259	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem
    //   1208: dup
    //   1209: aload 26
    //   1211: lload 16
    //   1213: aload 30
    //   1215: aload 39
    //   1217: iload_2
    //   1218: invokespecial 260	com/tencent/mobileqq/search/model/NetSearchTemplateHorizontalContainerItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1221: astore_1
    //   1222: goto +80 -> 1302
    //   1225: new 262	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateUniversalItem
    //   1228: dup
    //   1229: aload 26
    //   1231: lload 16
    //   1233: aload 30
    //   1235: aload 39
    //   1237: iload_2
    //   1238: invokespecial 263	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateUniversalItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1241: astore_1
    //   1242: goto +60 -> 1302
    //   1245: new 265	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBannerTitleItem
    //   1248: dup
    //   1249: aload 26
    //   1251: lload 16
    //   1253: aload 30
    //   1255: aload 39
    //   1257: iload_2
    //   1258: invokespecial 266	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBannerTitleItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1261: astore_1
    //   1262: goto +40 -> 1302
    //   1265: new 268	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateUpdatesItem
    //   1268: dup
    //   1269: aload 26
    //   1271: lload 16
    //   1273: aload 30
    //   1275: aload 39
    //   1277: iload_2
    //   1278: invokespecial 269	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateUpdatesItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1281: astore_1
    //   1282: goto +20 -> 1302
    //   1285: new 271	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateAvatarsItem
    //   1288: dup
    //   1289: aload 26
    //   1291: lload 16
    //   1293: aload 30
    //   1295: aload 39
    //   1297: iload_2
    //   1298: invokespecial 272	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateAvatarsItem:<init>	(Ljava/lang/String;JLjava/util/List;Lunify/search/UnifySearchCommon$ResultItem;I)V
    //   1301: astore_1
    //   1302: aload_1
    //   1303: ifnull +40 -> 1343
    //   1306: aload_1
    //   1307: invokevirtual 277	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem:b	()Z
    //   1310: ifeq +33 -> 1343
    //   1313: aload_1
    //   1314: aload 39
    //   1316: getfield 280	unify/search/UnifySearchCommon$ResultItem:seporator_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1319: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1322: putfield 284	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem:u	I
    //   1325: aload_1
    //   1326: iload 9
    //   1328: putfield 285	com/tencent/mobileqq/search/business/net/model/NetSearchTemplateBaseItem:a	Z
    //   1331: aload 22
    //   1333: aload_1
    //   1334: invokeinterface 98 2 0
    //   1339: pop
    //   1340: goto +9 -> 1349
    //   1343: lload 12
    //   1345: lconst_1
    //   1346: lsub
    //   1347: lstore 12
    //   1349: aload 19
    //   1351: astore_1
    //   1352: aload 20
    //   1354: astore 23
    //   1356: aload 22
    //   1358: astore 19
    //   1360: aload 21
    //   1362: astore 20
    //   1364: aload 23
    //   1366: astore 21
    //   1368: goto +333 -> 1701
    //   1371: lload 14
    //   1373: invokestatic 290	com/tencent/mobileqq/search/util/SearchUtils:b	(J)Z
    //   1376: ifne +58 -> 1434
    //   1379: new 161	java/lang/StringBuilder
    //   1382: dup
    //   1383: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1386: astore_1
    //   1387: aload_1
    //   1388: ldc_w 292
    //   1391: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1394: pop
    //   1395: aload_1
    //   1396: lload 14
    //   1398: invokevirtual 295	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1401: pop
    //   1402: aload 19
    //   1404: iconst_1
    //   1405: aload_1
    //   1406: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1409: invokestatic 298	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1412: aload 19
    //   1414: astore_1
    //   1415: aload 20
    //   1417: astore 23
    //   1419: aload 22
    //   1421: astore 19
    //   1423: aload 21
    //   1425: astore 20
    //   1427: aload 23
    //   1429: astore 21
    //   1431: goto +270 -> 1701
    //   1434: lload 14
    //   1436: ldc2_w 299
    //   1439: lcmp
    //   1440: ifne +43 -> 1483
    //   1443: new 302	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance
    //   1446: dup
    //   1447: aload 26
    //   1449: aload 44
    //   1451: bipush 252
    //   1453: aload 42
    //   1455: invokespecial 305	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:<init>	(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    //   1458: astore_1
    //   1459: aload_1
    //   1460: aload 39
    //   1462: getfield 280	unify/search/UnifySearchCommon$ResultItem:seporator_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1465: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1468: putfield 306	com/tencent/mobileqq/search/base/model/SearchResultModelForEntrance:u	I
    //   1471: aload 22
    //   1473: aload_1
    //   1474: invokeinterface 98 2 0
    //   1479: pop
    //   1480: goto -68 -> 1412
    //   1483: aload 21
    //   1485: astore 28
    //   1487: aload 20
    //   1489: astore 21
    //   1491: iload_3
    //   1492: istore 8
    //   1494: new 308	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem
    //   1497: dup
    //   1498: aload 26
    //   1500: aload 41
    //   1502: aload 40
    //   1504: aload 42
    //   1506: aload 43
    //   1508: aload 44
    //   1510: lload 14
    //   1512: aload 30
    //   1514: iload_2
    //   1515: aload 27
    //   1517: aload 23
    //   1519: iload 4
    //   1521: aload_1
    //   1522: aload 24
    //   1524: aload 29
    //   1526: invokespecial 311	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/util/List;ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1529: astore 20
    //   1531: aload 20
    //   1533: aload 39
    //   1535: getfield 280	unify/search/UnifySearchCommon$ResultItem:seporator_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1538: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1541: putfield 312	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:u	I
    //   1544: aload 20
    //   1546: iload 9
    //   1548: putfield 315	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:c	Z
    //   1551: aload 20
    //   1553: iload 8
    //   1555: putfield 318	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:j	I
    //   1558: aload 20
    //   1560: iload 8
    //   1562: putfield 321	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:k	I
    //   1565: aload 20
    //   1567: iload_2
    //   1568: putfield 323	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:a	I
    //   1571: iload 7
    //   1573: iconst_1
    //   1574: if_icmpne +106 -> 1680
    //   1577: lload 14
    //   1579: ldc2_w 176
    //   1582: lcmp
    //   1583: ifne +97 -> 1680
    //   1586: aload 20
    //   1588: aload 34
    //   1590: putfield 327	com/tencent/mobileqq/search/model/GroupBaseNetSearchModelItem:h	Ljava/lang/String;
    //   1593: aload 33
    //   1595: aload 20
    //   1597: invokeinterface 98 2 0
    //   1602: pop
    //   1603: lload 12
    //   1605: lconst_1
    //   1606: lsub
    //   1607: lstore 12
    //   1609: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1612: ifeq +54 -> 1666
    //   1615: new 161	java/lang/StringBuilder
    //   1618: dup
    //   1619: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   1622: astore_1
    //   1623: aload_1
    //   1624: ldc_w 329
    //   1627: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1630: pop
    //   1631: aload_1
    //   1632: aload 26
    //   1634: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1637: pop
    //   1638: aload_1
    //   1639: ldc_w 331
    //   1642: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1645: pop
    //   1646: aload_1
    //   1647: aload 40
    //   1649: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1652: pop
    //   1653: aload 19
    //   1655: iconst_2
    //   1656: aload_1
    //   1657: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1660: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1663: goto +3 -> 1666
    //   1666: aload 19
    //   1668: astore_1
    //   1669: aload 22
    //   1671: astore 19
    //   1673: aload 28
    //   1675: astore 20
    //   1677: goto +24 -> 1701
    //   1680: aload 19
    //   1682: astore_1
    //   1683: aload 22
    //   1685: astore 19
    //   1687: aload 19
    //   1689: aload 20
    //   1691: invokeinterface 98 2 0
    //   1696: pop
    //   1697: aload 28
    //   1699: astore 20
    //   1701: aload_1
    //   1702: astore 22
    //   1704: aload 19
    //   1706: astore_1
    //   1707: aload 33
    //   1709: astore 23
    //   1711: aload 20
    //   1713: astore 19
    //   1715: aload 21
    //   1717: astore 20
    //   1719: iload 5
    //   1721: iconst_1
    //   1722: iadd
    //   1723: istore 5
    //   1725: aload 19
    //   1727: astore 21
    //   1729: aload 22
    //   1731: astore 19
    //   1733: goto -1278 -> 455
    //   1736: iload_3
    //   1737: iconst_1
    //   1738: iadd
    //   1739: istore_3
    //   1740: aload_1
    //   1741: astore 24
    //   1743: aload 26
    //   1745: astore 22
    //   1747: aload 25
    //   1749: astore_1
    //   1750: aload 19
    //   1752: astore 26
    //   1754: aload 23
    //   1756: astore 19
    //   1758: goto -1400 -> 358
    //   1761: lload 16
    //   1763: ldc2_w 176
    //   1766: lcmp
    //   1767: ifne +108 -> 1875
    //   1770: aload 21
    //   1772: getfield 334	unify/search/UnifySearchCommon$ResultItemGroup:more_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1775: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1778: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1781: astore 20
    //   1783: aload 21
    //   1785: getfield 337	unify/search/UnifySearchCommon$ResultItemGroup:more_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1788: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1791: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1794: astore 23
    //   1796: aload 21
    //   1798: getfield 340	unify/search/UnifySearchCommon$ResultItemGroup:highlight_title_keyword	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1801: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1804: iconst_1
    //   1805: if_icmpne +9 -> 1814
    //   1808: iconst_1
    //   1809: istore 10
    //   1811: goto +6 -> 1817
    //   1814: iconst_0
    //   1815: istore 10
    //   1817: aload 21
    //   1819: getfield 343	unify/search/UnifySearchCommon$ResultItemGroup:hide_title_blank_view	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1822: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1825: iconst_1
    //   1826: if_icmpne +9 -> 1835
    //   1829: iconst_1
    //   1830: istore 11
    //   1832: goto +6 -> 1838
    //   1835: iconst_0
    //   1836: istore 11
    //   1838: new 345	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   1841: dup
    //   1842: aload 22
    //   1844: lload 16
    //   1846: ldc_w 347
    //   1849: aconst_null
    //   1850: lconst_0
    //   1851: aload 20
    //   1853: aload 23
    //   1855: aload 30
    //   1857: iload 9
    //   1859: iload 10
    //   1861: iload 11
    //   1863: aload 37
    //   1865: aload 38
    //   1867: invokespecial 350	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/String;)V
    //   1870: astore 20
    //   1872: goto +3 -> 1875
    //   1875: lload 12
    //   1877: lconst_0
    //   1878: lcmp
    //   1879: ifle +124 -> 2003
    //   1882: aload 21
    //   1884: getfield 353	unify/search/UnifySearchCommon$ResultItemGroup:total_result_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1887: invokevirtual 70	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1890: lstore 12
    //   1892: aload 21
    //   1894: getfield 334	unify/search/UnifySearchCommon$ResultItemGroup:more_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1897: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1900: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1903: astore 23
    //   1905: aload 21
    //   1907: getfield 337	unify/search/UnifySearchCommon$ResultItemGroup:more_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1910: invokevirtual 79	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1913: invokevirtual 85	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1916: astore 25
    //   1918: aload 21
    //   1920: getfield 340	unify/search/UnifySearchCommon$ResultItemGroup:highlight_title_keyword	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1923: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1926: iconst_1
    //   1927: if_icmpne +9 -> 1936
    //   1930: iconst_1
    //   1931: istore 10
    //   1933: goto +6 -> 1939
    //   1936: iconst_0
    //   1937: istore 10
    //   1939: aload 21
    //   1941: getfield 343	unify/search/UnifySearchCommon$ResultItemGroup:hide_title_blank_view	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1944: invokevirtual 113	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1947: iconst_1
    //   1948: if_icmpne +9 -> 1957
    //   1951: iconst_1
    //   1952: istore 11
    //   1954: goto +6 -> 1960
    //   1957: iconst_0
    //   1958: istore 11
    //   1960: aload_1
    //   1961: new 345	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel
    //   1964: dup
    //   1965: aload 22
    //   1967: lload 16
    //   1969: aload 36
    //   1971: aload 24
    //   1973: lload 12
    //   1975: aload 23
    //   1977: aload 25
    //   1979: aload 30
    //   1981: iload 9
    //   1983: iload 10
    //   1985: iload 11
    //   1987: aload 37
    //   1989: aload 38
    //   1991: invokespecial 350	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:<init>	(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;JLjava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZLjava/lang/String;Ljava/lang/String;)V
    //   1994: invokeinterface 98 2 0
    //   1999: pop
    //   2000: goto +3 -> 2003
    //   2003: goto -1865 -> 138
    //   2006: aload 20
    //   2008: ifnull +90 -> 2098
    //   2011: aload 19
    //   2013: invokeinterface 355 1 0
    //   2018: ifne +80 -> 2098
    //   2021: aload 20
    //   2023: aload 19
    //   2025: invokevirtual 358	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	(Ljava/util/List;)V
    //   2028: aload 20
    //   2030: aload 19
    //   2032: invokeinterface 39 1 0
    //   2037: i2l
    //   2038: invokevirtual 361	com/tencent/mobileqq/search/model/GroupBaseNetSearchModel:a	(J)V
    //   2041: aload_1
    //   2042: iconst_0
    //   2043: aload 20
    //   2045: invokeinterface 364 3 0
    //   2050: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2053: ifeq +45 -> 2098
    //   2056: new 161	java/lang/StringBuilder
    //   2059: dup
    //   2060: invokespecial 162	java/lang/StringBuilder:<init>	()V
    //   2063: astore 18
    //   2065: aload 18
    //   2067: ldc_w 366
    //   2070: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2073: pop
    //   2074: aload 18
    //   2076: aload 19
    //   2078: invokeinterface 39 1 0
    //   2083: invokevirtual 369	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2086: pop
    //   2087: ldc 54
    //   2089: iconst_2
    //   2090: aload 18
    //   2092: invokevirtual 171	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2095: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2098: aload_1
    //   2099: areturn
    //   2100: aconst_null
    //   2101: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2102	0	this	TabNetBaseParser
    //   0	2102	1	paramVarArgs	Object[]
    //   92	1476	2	i	int
    //   357	1383	3	j	int
    //   664	856	4	k	int
    //   435	1289	5	m	int
    //   401	59	6	n	int
    //   676	899	7	i1	int
    //   1492	69	8	i2	int
    //   19	1963	9	bool1	boolean
    //   497	1487	10	bool2	boolean
    //   1830	156	11	bool3	boolean
    //   354	1620	12	l1	long
    //   531	1047	14	l2	long
    //   176	1792	16	l3	long
    //   60	2031	18	localObject1	Object
    //   105	1972	19	localObject2	Object
    //   132	1912	20	localObject3	Object
    //   23	1917	21	localObject4	Object
    //   36	1930	22	localObject5	Object
    //   199	1777	23	localObject6	Object
    //   284	550	24	localObject7	Object
    //   838	1	24	localJSONException1	org.json.JSONException
    //   843	1	24	localJSONException2	org.json.JSONException
    //   857	1	24	localJSONException3	org.json.JSONException
    //   862	1	24	localJSONException4	org.json.JSONException
    //   877	1	24	localJSONException5	org.json.JSONException
    //   882	1	24	localJSONException6	org.json.JSONException
    //   890	25	24	localJSONException7	org.json.JSONException
    //   921	1051	24	localObject8	Object
    //   390	1588	25	localObject9	Object
    //   149	1604	26	localObject10	Object
    //   773	743	27	localObject11	Object
    //   800	898	28	localObject12	Object
    //   734	85	29	localObject13	Object
    //   826	6	29	localJSONException8	org.json.JSONException
    //   849	676	29	localObject14	Object
    //   215	1765	30	localArrayList1	java.util.ArrayList
    //   268	102	31	localList	java.util.List
    //   412	51	32	localArrayList2	java.util.ArrayList
    //   542	1166	33	localObject15	Object
    //   672	917	34	str1	java.lang.String
    //   129	28	35	localIterator	java.util.Iterator
    //   189	1781	36	str2	java.lang.String
    //   331	1657	37	str3	java.lang.String
    //   344	1646	38	str4	java.lang.String
    //   474	1060	39	localResultItem	unify.search.UnifySearchCommon.ResultItem
    //   510	1138	40	str5	java.lang.String
    //   487	1014	41	str6	java.lang.String
    //   555	950	42	str7	java.lang.String
    //   568	939	43	str8	java.lang.String
    //   581	928	44	str9	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   666	674	681	java/lang/Exception
    //   648	666	685	java/lang/Exception
    //   811	820	826	org/json/JSONException
    //   802	811	838	org/json/JSONException
    //   793	802	843	org/json/JSONException
    //   784	793	857	org/json/JSONException
    //   775	784	862	org/json/JSONException
    //   748	775	877	org/json/JSONException
    //   739	748	882	org/json/JSONException
    //   725	736	890	org/json/JSONException
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.TabNetBaseParser
 * JD-Core Version:    0.7.0.1
 */