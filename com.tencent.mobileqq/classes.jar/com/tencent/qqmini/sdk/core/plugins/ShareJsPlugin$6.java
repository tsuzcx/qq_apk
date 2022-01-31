package com.tencent.qqmini.sdk.core.plugins;

import bekr;

class ShareJsPlugin$6
  implements Runnable
{
  ShareJsPlugin$6(ShareJsPlugin paramShareJsPlugin, bekr parambekr) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_1
    //   3: istore 9
    //   5: aload_0
    //   6: getfield 14	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:this$0	Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin;
    //   9: getfield 29	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin:mMiniAppContext	Lbehq;
    //   12: invokeinterface 35 1 0
    //   17: invokestatic 40	beny:a	(Landroid/content/Context;)Lbeny;
    //   20: astore 10
    //   22: new 42	org/json/JSONObject
    //   25: dup
    //   26: aload_0
    //   27: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   30: getfield 48	bekr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   33: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   36: astore 11
    //   38: aload 11
    //   40: ldc 53
    //   42: invokevirtual 57	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   45: astore 12
    //   47: aload 11
    //   49: ldc 59
    //   51: iconst_0
    //   52: invokevirtual 63	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   55: istore_2
    //   56: iload_2
    //   57: tableswitch	default:+737 -> 794, 0:+82->139, 1:+204->261
    //   81: lstore_2
    //   82: new 67	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   89: aload_0
    //   90: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   93: getfield 70	bekr:a	Ljava/lang/String;
    //   96: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 76
    //   101: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_2
    //   105: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 89	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: return
    //   115: aload 10
    //   117: aload 12
    //   119: iload_1
    //   120: invokevirtual 95	org/json/JSONArray:optString	(I)Ljava/lang/String;
    //   123: bipush 9
    //   125: aload 11
    //   127: ldc 97
    //   129: invokevirtual 100	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokevirtual 103	beny:a	(Ljava/lang/CharSequence;ILjava/lang/String;)V
    //   135: iload_1
    //   136: iconst_1
    //   137: iadd
    //   138: istore_1
    //   139: iload_1
    //   140: aload 12
    //   142: invokevirtual 107	org/json/JSONArray:length	()I
    //   145: if_icmpge +56 -> 201
    //   148: aload 12
    //   150: iload_1
    //   151: invokevirtual 111	org/json/JSONArray:isNull	(I)Z
    //   154: ifeq -39 -> 115
    //   157: aload_0
    //   158: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   161: invokevirtual 113	bekr:b	()Ljava/lang/String;
    //   164: pop
    //   165: return
    //   166: astore 10
    //   168: ldc 65
    //   170: new 67	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   177: aload_0
    //   178: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   181: getfield 70	bekr:a	Ljava/lang/String;
    //   184: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: ldc 115
    //   189: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload 10
    //   197: invokestatic 118	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   200: return
    //   201: aload 10
    //   203: ldc 120
    //   205: invokevirtual 123	beny:a	(Ljava/lang/CharSequence;)V
    //   208: aload 10
    //   210: invokevirtual 126	beny:show	()V
    //   213: aload 10
    //   215: iconst_1
    //   216: invokevirtual 129	beny:a	(Z)V
    //   219: aload 10
    //   221: new 131	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$1
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 134	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$1:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6;)V
    //   229: invokevirtual 137	beny:a	(Lbeof;)V
    //   232: aload 10
    //   234: new 139	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$2
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 140	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$2:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6;)V
    //   242: invokevirtual 144	beny:setOnCancelListener	(Landroid/content/DialogInterface$OnCancelListener;)V
    //   245: aload 10
    //   247: new 146	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$3
    //   250: dup
    //   251: aload_0
    //   252: aload 10
    //   254: invokespecial 149	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6$3:<init>	(Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6;Lbeny;)V
    //   257: invokevirtual 152	beny:a	(Lbeod;)V
    //   260: return
    //   261: new 154	java/util/HashMap
    //   264: dup
    //   265: invokespecial 155	java/util/HashMap:<init>	()V
    //   268: astore 10
    //   270: aload_0
    //   271: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   274: getfield 48	bekr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   277: ifnull +37 -> 314
    //   280: ldc 157
    //   282: aload_0
    //   283: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   286: getfield 48	bekr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   289: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   292: ifne +22 -> 314
    //   295: ldc 165
    //   297: aload_0
    //   298: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   301: getfield 48	bekr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   304: invokevirtual 163	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   307: istore 6
    //   309: iload 6
    //   311: ifeq +94 -> 405
    //   314: new 42	org/json/JSONObject
    //   317: dup
    //   318: invokespecial 166	org/json/JSONObject:<init>	()V
    //   321: ldc 168
    //   323: ldc 170
    //   325: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   328: pop
    //   329: aload_0
    //   330: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   333: invokevirtual 113	bekr:b	()Ljava/lang/String;
    //   336: pop
    //   337: ldc 65
    //   339: new 67	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   346: aload_0
    //   347: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   350: getfield 70	bekr:a	Ljava/lang/String;
    //   353: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: ldc 176
    //   358: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 89	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   367: return
    //   368: astore 10
    //   370: ldc 65
    //   372: new 67	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   379: aload_0
    //   380: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   383: getfield 70	bekr:a	Ljava/lang/String;
    //   386: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 115
    //   391: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: aload 10
    //   399: invokestatic 118	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -65 -> 337
    //   405: new 42	org/json/JSONObject
    //   408: dup
    //   409: aload_0
    //   410: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   413: getfield 48	bekr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   416: invokespecial 51	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   419: ldc 53
    //   421: invokevirtual 180	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   424: checkcast 91	org/json/JSONArray
    //   427: astore 11
    //   429: aload 11
    //   431: ifnonnull +366 -> 797
    //   434: new 42	org/json/JSONObject
    //   437: dup
    //   438: invokespecial 166	org/json/JSONObject:<init>	()V
    //   441: ldc 168
    //   443: ldc 182
    //   445: invokevirtual 174	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   448: pop
    //   449: aload_0
    //   450: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   453: invokevirtual 113	bekr:b	()Ljava/lang/String;
    //   456: pop
    //   457: ldc 65
    //   459: new 67	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   466: aload_0
    //   467: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   470: getfield 70	bekr:a	Ljava/lang/String;
    //   473: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc 184
    //   478: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 89	betc:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: return
    //   488: astore 10
    //   490: aload 10
    //   492: invokevirtual 187	org/json/JSONException:printStackTrace	()V
    //   495: ldc 65
    //   497: aload 10
    //   499: invokevirtual 190	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   502: aload 10
    //   504: invokestatic 118	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   507: aload_0
    //   508: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   511: invokevirtual 113	bekr:b	()Ljava/lang/String;
    //   514: pop
    //   515: return
    //   516: astore 10
    //   518: ldc 65
    //   520: new 67	java/lang/StringBuilder
    //   523: dup
    //   524: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   527: aload_0
    //   528: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   531: getfield 70	bekr:a	Ljava/lang/String;
    //   534: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: ldc 115
    //   539: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: aload 10
    //   547: invokestatic 118	betc:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   550: goto -93 -> 457
    //   553: iload 5
    //   555: aload 11
    //   557: invokevirtual 107	org/json/JSONArray:length	()I
    //   560: if_icmpge +122 -> 682
    //   563: aload 11
    //   565: iload 5
    //   567: invokevirtual 193	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   570: astore 12
    //   572: aload 12
    //   574: ldc 195
    //   576: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   579: ifeq +19 -> 598
    //   582: aload 10
    //   584: ldc 201
    //   586: iload 5
    //   588: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   591: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   594: pop
    //   595: iconst_1
    //   596: istore 4
    //   598: aload 12
    //   600: ldc 212
    //   602: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   605: ifeq +18 -> 623
    //   608: aload 10
    //   610: ldc 214
    //   612: iload 5
    //   614: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   617: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   620: pop
    //   621: iconst_1
    //   622: istore_3
    //   623: aload 12
    //   625: ldc 216
    //   627: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   630: ifeq +18 -> 648
    //   633: aload 10
    //   635: ldc 218
    //   637: iload 5
    //   639: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   645: pop
    //   646: iconst_1
    //   647: istore_2
    //   648: aload 12
    //   650: ldc 220
    //   652: invokevirtual 199	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   655: ifeq +18 -> 673
    //   658: aload 10
    //   660: ldc 222
    //   662: iload 5
    //   664: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: invokevirtual 210	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   670: pop
    //   671: iconst_1
    //   672: istore_1
    //   673: iload 5
    //   675: iconst_1
    //   676: iadd
    //   677: istore 5
    //   679: goto -126 -> 553
    //   682: iload 4
    //   684: iconst_m1
    //   685: if_icmpne +106 -> 791
    //   688: iconst_0
    //   689: istore 4
    //   691: iload_3
    //   692: iconst_m1
    //   693: if_icmpne +95 -> 788
    //   696: iconst_0
    //   697: istore_3
    //   698: iload_2
    //   699: iconst_m1
    //   700: if_icmpne +85 -> 785
    //   703: iconst_0
    //   704: istore_2
    //   705: iload_1
    //   706: iconst_m1
    //   707: if_icmpne +75 -> 782
    //   710: iconst_0
    //   711: istore_1
    //   712: aload_0
    //   713: getfield 14	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:this$0	Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin;
    //   716: invokestatic 226	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin:access$000	(Lcom/tencent/qqmini/sdk/core/plugins/ShareJsPlugin;)Lcom/tencent/qqmini/sdk/core/proxy/ShareProxy;
    //   719: astore 11
    //   721: iload 4
    //   723: iconst_1
    //   724: if_icmpne +34 -> 758
    //   727: iconst_1
    //   728: istore 6
    //   730: goto +82 -> 812
    //   733: aload 11
    //   735: iload 6
    //   737: iload 7
    //   739: iload 8
    //   741: iload 9
    //   743: aload 10
    //   745: aload_0
    //   746: getfield 16	com/tencent/qqmini/sdk/core/plugins/ShareJsPlugin$6:val$req	Lbekr;
    //   749: getfield 229	bekr:jdField_b_of_type_Int	I
    //   752: invokeinterface 235 7 0
    //   757: return
    //   758: iconst_0
    //   759: istore 6
    //   761: goto +51 -> 812
    //   764: iconst_0
    //   765: istore 7
    //   767: goto +53 -> 820
    //   770: iconst_0
    //   771: istore 8
    //   773: goto +55 -> 828
    //   776: iconst_0
    //   777: istore 9
    //   779: goto -46 -> 733
    //   782: goto -70 -> 712
    //   785: goto -80 -> 705
    //   788: goto -90 -> 698
    //   791: goto -100 -> 691
    //   794: goto -714 -> 80
    //   797: iconst_0
    //   798: istore 5
    //   800: iconst_m1
    //   801: istore_1
    //   802: iconst_m1
    //   803: istore_2
    //   804: iconst_m1
    //   805: istore_3
    //   806: iconst_m1
    //   807: istore 4
    //   809: goto -256 -> 553
    //   812: iload_3
    //   813: iconst_1
    //   814: if_icmpne -50 -> 764
    //   817: iconst_1
    //   818: istore 7
    //   820: iload_2
    //   821: iconst_1
    //   822: if_icmpne -52 -> 770
    //   825: iconst_1
    //   826: istore 8
    //   828: iload_1
    //   829: iconst_1
    //   830: if_icmpne -54 -> 776
    //   833: goto -100 -> 733
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	836	0	this	6
    //   1	830	1	i	int
    //   55	768	2	j	int
    //   622	193	3	k	int
    //   596	212	4	m	int
    //   553	246	5	n	int
    //   307	453	6	bool1	boolean
    //   737	82	7	bool2	boolean
    //   739	88	8	bool3	boolean
    //   3	775	9	bool4	boolean
    //   20	96	10	localbeny	beny
    //   166	87	10	localJSONException1	org.json.JSONException
    //   268	1	10	localHashMap	java.util.HashMap
    //   368	30	10	localJSONException2	org.json.JSONException
    //   488	15	10	localJSONException3	org.json.JSONException
    //   516	228	10	localJSONException4	org.json.JSONException
    //   36	698	11	localObject1	Object
    //   45	604	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	56	166	org/json/JSONException
    //   80	114	166	org/json/JSONException
    //   115	135	166	org/json/JSONException
    //   139	165	166	org/json/JSONException
    //   201	260	166	org/json/JSONException
    //   261	309	166	org/json/JSONException
    //   337	367	166	org/json/JSONException
    //   370	402	166	org/json/JSONException
    //   490	515	166	org/json/JSONException
    //   712	721	166	org/json/JSONException
    //   733	757	166	org/json/JSONException
    //   314	337	368	org/json/JSONException
    //   405	429	488	org/json/JSONException
    //   457	487	488	org/json/JSONException
    //   518	550	488	org/json/JSONException
    //   553	572	488	org/json/JSONException
    //   572	595	488	org/json/JSONException
    //   598	621	488	org/json/JSONException
    //   623	646	488	org/json/JSONException
    //   648	671	488	org/json/JSONException
    //   434	457	516	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ShareJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */