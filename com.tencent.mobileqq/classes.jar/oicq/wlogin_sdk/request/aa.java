package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.report.Reporter;
import oicq.wlogin_sdk.tools.util;

public class aa
  extends oicq_request
{
  public aa(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 15;
    this.v = "wtlogin.exchange_emp";
    this.x = paramt;
    this.x.m = 0;
    this.y = oicq_request.EncryptionMethod.EM_ST;
    this.a = paramContext;
  }
  
  /* Error */
  private byte[] a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, byte[] paramArrayOfByte5, java.util.List<String> paramList, int paramInt11, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: new 50	oicq/wlogin_sdk/tlv_type/tlv_t18
    //   3: dup
    //   4: invokespecial 51	oicq/wlogin_sdk/tlv_type/tlv_t18:<init>	()V
    //   7: astore 64
    //   9: new 53	oicq/wlogin_sdk/tlv_type/tlv_t1
    //   12: dup
    //   13: invokespecial 54	oicq/wlogin_sdk/tlv_type/tlv_t1:<init>	()V
    //   16: astore 65
    //   18: new 56	oicq/wlogin_sdk/tlv_type/tlv_t106
    //   21: dup
    //   22: invokespecial 57	oicq/wlogin_sdk/tlv_type/tlv_t106:<init>	()V
    //   25: astore 66
    //   27: new 59	oicq/wlogin_sdk/tlv_type/tlv_t116
    //   30: dup
    //   31: invokespecial 60	oicq/wlogin_sdk/tlv_type/tlv_t116:<init>	()V
    //   34: astore 69
    //   36: new 62	oicq/wlogin_sdk/tlv_type/tlv_t100
    //   39: dup
    //   40: invokespecial 63	oicq/wlogin_sdk/tlv_type/tlv_t100:<init>	()V
    //   43: astore 67
    //   45: new 65	oicq/wlogin_sdk/tlv_type/tlv_t107
    //   48: dup
    //   49: invokespecial 66	oicq/wlogin_sdk/tlv_type/tlv_t107:<init>	()V
    //   52: astore 68
    //   54: new 68	oicq/wlogin_sdk/tlv_type/tlv_t108
    //   57: dup
    //   58: invokespecial 69	oicq/wlogin_sdk/tlv_type/tlv_t108:<init>	()V
    //   61: astore 83
    //   63: new 71	oicq/wlogin_sdk/tlv_type/tlv_t109
    //   66: dup
    //   67: invokespecial 72	oicq/wlogin_sdk/tlv_type/tlv_t109:<init>	()V
    //   70: astore 79
    //   72: new 74	oicq/wlogin_sdk/tlv_type/tlv_t52d
    //   75: dup
    //   76: invokespecial 75	oicq/wlogin_sdk/tlv_type/tlv_t52d:<init>	()V
    //   79: astore 78
    //   81: new 77	oicq/wlogin_sdk/tlv_type/tlv_t124
    //   84: dup
    //   85: invokespecial 78	oicq/wlogin_sdk/tlv_type/tlv_t124:<init>	()V
    //   88: astore 77
    //   90: new 80	oicq/wlogin_sdk/tlv_type/tlv_t128
    //   93: dup
    //   94: invokespecial 81	oicq/wlogin_sdk/tlv_type/tlv_t128:<init>	()V
    //   97: astore 76
    //   99: new 83	oicq/wlogin_sdk/tlv_type/tlv_t142
    //   102: dup
    //   103: invokespecial 84	oicq/wlogin_sdk/tlv_type/tlv_t142:<init>	()V
    //   106: astore 74
    //   108: new 86	oicq/wlogin_sdk/tlv_type/tlv_t112
    //   111: dup
    //   112: invokespecial 87	oicq/wlogin_sdk/tlv_type/tlv_t112:<init>	()V
    //   115: astore 73
    //   117: new 89	oicq/wlogin_sdk/tlv_type/tlv_t144
    //   120: dup
    //   121: invokespecial 90	oicq/wlogin_sdk/tlv_type/tlv_t144:<init>	()V
    //   124: astore 72
    //   126: new 92	oicq/wlogin_sdk/tlv_type/tlv_t145
    //   129: dup
    //   130: invokespecial 93	oicq/wlogin_sdk/tlv_type/tlv_t145:<init>	()V
    //   133: astore 47
    //   135: new 95	oicq/wlogin_sdk/tlv_type/tlv_t147
    //   138: dup
    //   139: invokespecial 96	oicq/wlogin_sdk/tlv_type/tlv_t147:<init>	()V
    //   142: astore 49
    //   144: new 98	oicq/wlogin_sdk/tlv_type/tlv_t166
    //   147: dup
    //   148: invokespecial 99	oicq/wlogin_sdk/tlv_type/tlv_t166:<init>	()V
    //   151: astore 82
    //   153: new 101	oicq/wlogin_sdk/tlv_type/tlv_t16a
    //   156: dup
    //   157: invokespecial 102	oicq/wlogin_sdk/tlv_type/tlv_t16a:<init>	()V
    //   160: astore 57
    //   162: new 104	oicq/wlogin_sdk/tlv_type/tlv_t141
    //   165: dup
    //   166: invokespecial 105	oicq/wlogin_sdk/tlv_type/tlv_t141:<init>	()V
    //   169: astore 56
    //   171: new 107	oicq/wlogin_sdk/tlv_type/tlv_t8
    //   174: dup
    //   175: invokespecial 108	oicq/wlogin_sdk/tlv_type/tlv_t8:<init>	()V
    //   178: astore 70
    //   180: new 110	oicq/wlogin_sdk/tlv_type/tlv_t154
    //   183: dup
    //   184: invokespecial 111	oicq/wlogin_sdk/tlv_type/tlv_t154:<init>	()V
    //   187: astore 55
    //   189: new 113	oicq/wlogin_sdk/tlv_type/tlv_t511
    //   192: dup
    //   193: invokespecial 114	oicq/wlogin_sdk/tlv_type/tlv_t511:<init>	()V
    //   196: astore 58
    //   198: new 116	oicq/wlogin_sdk/tlv_type/tlv_t16e
    //   201: dup
    //   202: invokespecial 117	oicq/wlogin_sdk/tlv_type/tlv_t16e:<init>	()V
    //   205: astore 75
    //   207: new 119	oicq/wlogin_sdk/tlv_type/tlv_t172
    //   210: dup
    //   211: invokespecial 120	oicq/wlogin_sdk/tlv_type/tlv_t172:<init>	()V
    //   214: astore 54
    //   216: new 122	oicq/wlogin_sdk/tlv_type/tlv_t177
    //   219: dup
    //   220: invokespecial 123	oicq/wlogin_sdk/tlv_type/tlv_t177:<init>	()V
    //   223: astore 48
    //   225: new 125	oicq/wlogin_sdk/tlv_type/tlv_t400
    //   228: dup
    //   229: invokespecial 126	oicq/wlogin_sdk/tlv_type/tlv_t400:<init>	()V
    //   232: astore 59
    //   234: new 128	oicq/wlogin_sdk/tlv_type/tlv_t187
    //   237: dup
    //   238: invokespecial 129	oicq/wlogin_sdk/tlv_type/tlv_t187:<init>	()V
    //   241: astore 50
    //   243: new 131	oicq/wlogin_sdk/tlv_type/tlv_t188
    //   246: dup
    //   247: invokespecial 132	oicq/wlogin_sdk/tlv_type/tlv_t188:<init>	()V
    //   250: astore 51
    //   252: new 134	oicq/wlogin_sdk/tlv_type/tlv_t194
    //   255: dup
    //   256: invokespecial 135	oicq/wlogin_sdk/tlv_type/tlv_t194:<init>	()V
    //   259: astore 52
    //   261: new 137	oicq/wlogin_sdk/tlv_type/tlv_t201
    //   264: dup
    //   265: invokespecial 138	oicq/wlogin_sdk/tlv_type/tlv_t201:<init>	()V
    //   268: astore 53
    //   270: new 140	oicq/wlogin_sdk/tlv_type/tlv_t202
    //   273: dup
    //   274: invokespecial 141	oicq/wlogin_sdk/tlv_type/tlv_t202:<init>	()V
    //   277: astore 81
    //   279: new 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   282: dup
    //   283: sipush 1302
    //   286: invokespecial 146	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   289: astore 71
    //   291: new 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   294: dup
    //   295: sipush 1313
    //   298: invokespecial 146	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   301: astore 61
    //   303: new 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   306: dup
    //   307: sipush 1317
    //   310: invokespecial 146	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   313: astore 62
    //   315: new 148	oicq/wlogin_sdk/tlv_type/tlv_t545
    //   318: dup
    //   319: invokespecial 149	oicq/wlogin_sdk/tlv_type/tlv_t545:<init>	()V
    //   322: astore 80
    //   324: new 151	oicq/wlogin_sdk/tlv_type/tlv_t544
    //   327: dup
    //   328: invokespecial 152	oicq/wlogin_sdk/tlv_type/tlv_t544:<init>	()V
    //   331: astore 63
    //   333: invokestatic 158	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   336: invokestatic 163	oicq/wlogin_sdk/report/c:a	(Ljava/lang/Thread;)V
    //   339: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   342: lstore 45
    //   344: aload_0
    //   345: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   348: lload 4
    //   350: lload 22
    //   352: invokevirtual 172	oicq/wlogin_sdk/request/t:a	(JJ)Loicq/wlogin_sdk/sharemem/WloginSigInfo;
    //   355: astore 60
    //   357: aload 64
    //   359: lload_1
    //   360: iload_3
    //   361: lload 4
    //   363: iload 6
    //   365: invokevirtual 176	oicq/wlogin_sdk/tlv_type/tlv_t18:get_tlv_18	(JIJI)[B
    //   368: astore 64
    //   370: aload 65
    //   372: lload 4
    //   374: aload 7
    //   376: invokevirtual 180	oicq/wlogin_sdk/tlv_type/tlv_t1:get_tlv_1	(J[B)[B
    //   379: astore 65
    //   381: aload 66
    //   383: aload 8
    //   385: aload 8
    //   387: arraylength
    //   388: invokevirtual 184	oicq/wlogin_sdk/tlv_type/tlv_t106:set_data	([BI)V
    //   391: aload 66
    //   393: invokevirtual 188	oicq/wlogin_sdk/tlv_type/tlv_t106:get_buf	()[B
    //   396: astore 66
    //   398: ldc 190
    //   400: aload 66
    //   402: invokestatic 196	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   405: invokestatic 200	oicq/wlogin_sdk/tools/util:LOGD	(Ljava/lang/String;Ljava/lang/String;)V
    //   408: aload 67
    //   410: lload_1
    //   411: lload 14
    //   413: iload_3
    //   414: iload 13
    //   416: invokevirtual 204	oicq/wlogin_sdk/tlv_type/tlv_t100:get_tlv_100	(JJII)[B
    //   419: astore 67
    //   421: aload 68
    //   423: iload 17
    //   425: iload 18
    //   427: iload 19
    //   429: iload 20
    //   431: invokevirtual 208	oicq/wlogin_sdk/tlv_type/tlv_t107:get_tlv_107	(IIII)[B
    //   434: astore 68
    //   436: aload 69
    //   438: iload 10
    //   440: iload 11
    //   442: aload 12
    //   444: invokevirtual 212	oicq/wlogin_sdk/tlv_type/tlv_t116:get_tlv_116	(II[J)[B
    //   447: astore 69
    //   449: aload 47
    //   451: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   454: invokevirtual 220	oicq/wlogin_sdk/tlv_type/tlv_t145:get_tlv_145	([B)[B
    //   457: astore 47
    //   459: aload 55
    //   461: aload_0
    //   462: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   465: getfield 223	oicq/wlogin_sdk/request/t:i	I
    //   468: invokevirtual 227	oicq/wlogin_sdk/tlv_type/tlv_t154:get_tlv_154	(I)[B
    //   471: astore 55
    //   473: aload 56
    //   475: getstatic 230	oicq/wlogin_sdk/request/t:D	[B
    //   478: getstatic 233	oicq/wlogin_sdk/request/t:E	I
    //   481: getstatic 236	oicq/wlogin_sdk/request/t:G	[B
    //   484: invokevirtual 240	oicq/wlogin_sdk/tlv_type/tlv_t141:get_tlv_141	([BI[B)[B
    //   487: astore 56
    //   489: aload 70
    //   491: iconst_0
    //   492: getstatic 242	oicq/wlogin_sdk/request/t:v	I
    //   495: iconst_0
    //   496: invokevirtual 246	oicq/wlogin_sdk/tlv_type/tlv_t8:get_tlv_8	(III)[B
    //   499: astore 70
    //   501: aload 49
    //   503: lload 22
    //   505: getstatic 249	oicq/wlogin_sdk/request/t:H	[B
    //   508: getstatic 251	oicq/wlogin_sdk/request/t:I	[B
    //   511: invokevirtual 255	oicq/wlogin_sdk/tlv_type/tlv_t147:get_tlv_147	(J[B[B)[B
    //   514: astore 49
    //   516: aload 48
    //   518: ldc2_w 256
    //   521: ldc_w 259
    //   524: invokevirtual 263	oicq/wlogin_sdk/tlv_type/tlv_t177:get_tlv_177	(JLjava/lang/String;)[B
    //   527: astore 48
    //   529: aload 21
    //   531: ifnull +24 -> 555
    //   534: aload 21
    //   536: arraylength
    //   537: ifle +18 -> 555
    //   540: aload 83
    //   542: aload 21
    //   544: invokevirtual 266	oicq/wlogin_sdk/tlv_type/tlv_t108:get_tlv_108	([B)[B
    //   547: astore 21
    //   549: bipush 13
    //   551: istore_3
    //   552: goto +11 -> 563
    //   555: bipush 12
    //   557: istore_3
    //   558: iconst_0
    //   559: newarray byte
    //   561: astore 21
    //   563: iload 10
    //   565: sipush 128
    //   568: iand
    //   569: ifeq +20 -> 589
    //   572: aload 82
    //   574: getstatic 268	oicq/wlogin_sdk/request/t:y	I
    //   577: invokevirtual 271	oicq/wlogin_sdk/tlv_type/tlv_t166:get_tlv_166	(I)[B
    //   580: astore 8
    //   582: iload_3
    //   583: iconst_1
    //   584: iadd
    //   585: istore_3
    //   586: goto +8 -> 594
    //   589: iconst_0
    //   590: newarray byte
    //   592: astore 8
    //   594: aload_0
    //   595: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   598: getfield 274	oicq/wlogin_sdk/request/t:s	[B
    //   601: ifnull +35 -> 636
    //   604: aload_0
    //   605: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   608: getfield 274	oicq/wlogin_sdk/request/t:s	[B
    //   611: arraylength
    //   612: ifle +24 -> 636
    //   615: aload 54
    //   617: aload_0
    //   618: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   621: getfield 274	oicq/wlogin_sdk/request/t:s	[B
    //   624: invokevirtual 277	oicq/wlogin_sdk/tlv_type/tlv_t172:get_tlv_172	([B)[B
    //   627: astore 7
    //   629: iload_3
    //   630: iconst_1
    //   631: iadd
    //   632: istore_3
    //   633: goto +8 -> 641
    //   636: iconst_0
    //   637: newarray byte
    //   639: astore 7
    //   641: getstatic 280	oicq/wlogin_sdk/request/t:O	[B
    //   644: ifnull +27 -> 671
    //   647: getstatic 280	oicq/wlogin_sdk/request/t:O	[B
    //   650: arraylength
    //   651: ifle +20 -> 671
    //   654: aload 50
    //   656: getstatic 280	oicq/wlogin_sdk/request/t:O	[B
    //   659: invokevirtual 283	oicq/wlogin_sdk/tlv_type/tlv_t187:get_tlv_187	([B)[B
    //   662: astore 12
    //   664: iload_3
    //   665: iconst_1
    //   666: iadd
    //   667: istore_3
    //   668: goto +8 -> 676
    //   671: iconst_0
    //   672: newarray byte
    //   674: astore 12
    //   676: aload 7
    //   678: astore 50
    //   680: getstatic 286	oicq/wlogin_sdk/request/t:P	[B
    //   683: ifnull +27 -> 710
    //   686: getstatic 286	oicq/wlogin_sdk/request/t:P	[B
    //   689: arraylength
    //   690: ifle +20 -> 710
    //   693: aload 51
    //   695: getstatic 286	oicq/wlogin_sdk/request/t:P	[B
    //   698: invokevirtual 289	oicq/wlogin_sdk/tlv_type/tlv_t188:get_tlv_188	([B)[B
    //   701: astore 7
    //   703: iload_3
    //   704: iconst_1
    //   705: iadd
    //   706: istore_3
    //   707: goto +8 -> 715
    //   710: iconst_0
    //   711: newarray byte
    //   713: astore 7
    //   715: aload 12
    //   717: astore 51
    //   719: getstatic 292	oicq/wlogin_sdk/request/t:M	[B
    //   722: ifnull +27 -> 749
    //   725: getstatic 292	oicq/wlogin_sdk/request/t:M	[B
    //   728: arraylength
    //   729: ifle +20 -> 749
    //   732: aload 52
    //   734: getstatic 292	oicq/wlogin_sdk/request/t:M	[B
    //   737: invokevirtual 295	oicq/wlogin_sdk/tlv_type/tlv_t194:get_tlv_194	([B)[B
    //   740: astore 12
    //   742: iload_3
    //   743: iconst_1
    //   744: iadd
    //   745: istore_3
    //   746: goto +8 -> 754
    //   749: iconst_0
    //   750: newarray byte
    //   752: astore 12
    //   754: aload 7
    //   756: astore 52
    //   758: getstatic 300	oicq/wlogin_sdk/request/k:L	[B
    //   761: ifnull +39 -> 800
    //   764: getstatic 300	oicq/wlogin_sdk/request/k:L	[B
    //   767: arraylength
    //   768: ifle +32 -> 800
    //   771: aload 53
    //   773: getstatic 300	oicq/wlogin_sdk/request/k:L	[B
    //   776: getstatic 301	oicq/wlogin_sdk/request/k:M	[B
    //   779: ldc_w 303
    //   782: invokevirtual 308	java/lang/String:getBytes	()[B
    //   785: getstatic 311	oicq/wlogin_sdk/request/k:N	[B
    //   788: invokevirtual 315	oicq/wlogin_sdk/tlv_type/tlv_t201:get_tlv_201	([B[B[B[B)[B
    //   791: astore 7
    //   793: iload_3
    //   794: iconst_1
    //   795: iadd
    //   796: istore_3
    //   797: goto +8 -> 805
    //   800: iconst_0
    //   801: newarray byte
    //   803: astore 7
    //   805: aload 8
    //   807: astore 53
    //   809: aload 12
    //   811: astore 54
    //   813: getstatic 318	oicq/wlogin_sdk/request/t:S	[B
    //   816: ifnull +30 -> 846
    //   819: getstatic 318	oicq/wlogin_sdk/request/t:S	[B
    //   822: arraylength
    //   823: ifle +23 -> 846
    //   826: aload 81
    //   828: getstatic 318	oicq/wlogin_sdk/request/t:S	[B
    //   831: getstatic 321	oicq/wlogin_sdk/request/t:T	[B
    //   834: invokevirtual 325	oicq/wlogin_sdk/tlv_type/tlv_t202:get_tlv_202	([B[B)[B
    //   837: astore 12
    //   839: iload_3
    //   840: iconst_1
    //   841: iadd
    //   842: istore_3
    //   843: goto +8 -> 851
    //   846: iconst_0
    //   847: newarray byte
    //   849: astore 12
    //   851: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   854: ifnull +10 -> 864
    //   857: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   860: arraylength
    //   861: ifne +12 -> 873
    //   864: getstatic 330	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   867: invokestatic 334	oicq/wlogin_sdk/tools/util:get_qimei	(Landroid/content/Context;)[B
    //   870: putstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   873: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   876: ifnull +75 -> 951
    //   879: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   882: arraylength
    //   883: ifle +68 -> 951
    //   886: aload 80
    //   888: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   891: invokevirtual 337	oicq/wlogin_sdk/tlv_type/tlv_t545:get_tlv_545	([B)[B
    //   894: astore 8
    //   896: new 339	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   903: astore 80
    //   905: aload 80
    //   907: getstatic 343	oicq/wlogin_sdk/tools/util:LOG_TAG_QIMEI	Ljava/lang/String;
    //   910: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload 80
    //   916: ldc_w 349
    //   919: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: pop
    //   923: aload 80
    //   925: getstatic 328	oicq/wlogin_sdk/request/t:U	[B
    //   928: arraylength
    //   929: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   932: pop
    //   933: aload 80
    //   935: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   938: ldc_w 358
    //   941: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   944: iload_3
    //   945: iconst_1
    //   946: iadd
    //   947: istore_3
    //   948: goto +65 -> 1013
    //   951: new 363	oicq/wlogin_sdk/report/event/b
    //   954: dup
    //   955: ldc_w 365
    //   958: ldc_w 367
    //   961: ldc_w 358
    //   964: invokespecial 370	oicq/wlogin_sdk/report/event/b:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   967: invokestatic 375	oicq/wlogin_sdk/report/event/c:a	(Loicq/wlogin_sdk/report/event/b;)V
    //   970: new 339	java/lang/StringBuilder
    //   973: dup
    //   974: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   977: astore 8
    //   979: aload 8
    //   981: getstatic 343	oicq/wlogin_sdk/tools/util:LOG_TAG_QIMEI	Ljava/lang/String;
    //   984: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: pop
    //   988: aload 8
    //   990: ldc_w 377
    //   993: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: pop
    //   997: aload 8
    //   999: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1002: ldc_w 358
    //   1005: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1008: iconst_0
    //   1009: newarray byte
    //   1011: astore 8
    //   1013: aload 79
    //   1015: getstatic 286	oicq/wlogin_sdk/request/t:P	[B
    //   1018: invokevirtual 380	oicq/wlogin_sdk/tlv_type/tlv_t109:get_tlv_109	([B)[B
    //   1021: astore 79
    //   1023: aload 78
    //   1025: aload_0
    //   1026: getfield 44	oicq/wlogin_sdk/request/aa:a	Landroid/content/Context;
    //   1029: invokevirtual 383	oicq/wlogin_sdk/tlv_type/tlv_t52d:get_tlv_52d	(Landroid/content/Context;)[B
    //   1032: astore 78
    //   1034: invokestatic 386	oicq/wlogin_sdk/tools/util:get_os_type	()[B
    //   1037: astore 80
    //   1039: invokestatic 389	oicq/wlogin_sdk/tools/util:get_os_version	()[B
    //   1042: astore 81
    //   1044: getstatic 233	oicq/wlogin_sdk/request/t:E	I
    //   1047: istore 6
    //   1049: getstatic 230	oicq/wlogin_sdk/request/t:D	[B
    //   1052: astore 82
    //   1054: getstatic 236	oicq/wlogin_sdk/request/t:G	[B
    //   1057: astore 83
    //   1059: aload 77
    //   1061: aload 80
    //   1063: aload 81
    //   1065: iload 6
    //   1067: aload 82
    //   1069: iconst_0
    //   1070: newarray byte
    //   1072: aload 83
    //   1074: invokevirtual 393	oicq/wlogin_sdk/tlv_type/tlv_t124:get_tlv_124	([B[BI[B[B[B)[B
    //   1077: astore 77
    //   1079: aload 76
    //   1081: getstatic 396	oicq/wlogin_sdk/request/t:V	I
    //   1084: getstatic 399	oicq/wlogin_sdk/request/t:W	I
    //   1087: getstatic 402	oicq/wlogin_sdk/request/t:X	I
    //   1090: getstatic 405	oicq/wlogin_sdk/request/t:aa	I
    //   1093: getstatic 408	oicq/wlogin_sdk/request/t:J	[B
    //   1096: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1099: getstatic 411	oicq/wlogin_sdk/request/t:Q	[B
    //   1102: invokevirtual 415	oicq/wlogin_sdk/tlv_type/tlv_t128:get_tlv_128	(IIII[B[B[B)[B
    //   1105: astore 76
    //   1107: aload 75
    //   1109: getstatic 408	oicq/wlogin_sdk/request/t:J	[B
    //   1112: invokevirtual 418	oicq/wlogin_sdk/tlv_type/tlv_t16e:get_tlv_16e	([B)[B
    //   1115: astore 75
    //   1117: ldc_w 420
    //   1120: ldc_w 358
    //   1123: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1126: aload 72
    //   1128: aload 79
    //   1130: aload 78
    //   1132: aload 77
    //   1134: aload 76
    //   1136: aload 75
    //   1138: aload_0
    //   1139: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   1142: getfield 423	oicq/wlogin_sdk/request/t:h	J
    //   1145: invokestatic 427	oicq/wlogin_sdk/request/t:b	(J)Loicq/wlogin_sdk/request/async_context;
    //   1148: getfield 432	oicq/wlogin_sdk/request/async_context:_tgtgt_key	[B
    //   1151: invokevirtual 436	oicq/wlogin_sdk/tlv_type/tlv_t144:get_tlv_144	([B[B[B[B[B[B)[B
    //   1154: astore 72
    //   1156: aload 74
    //   1158: aload 24
    //   1160: invokevirtual 439	oicq/wlogin_sdk/tlv_type/tlv_t142:get_tlv_142	([B)[B
    //   1163: astore 74
    //   1165: iload_3
    //   1166: iconst_1
    //   1167: iadd
    //   1168: iconst_1
    //   1169: iadd
    //   1170: istore_3
    //   1171: aload_0
    //   1172: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   1175: getfield 442	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1178: ifnull +52 -> 1230
    //   1181: aload_0
    //   1182: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   1185: getfield 442	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1188: invokestatic 446	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1191: invokevirtual 452	java/lang/Boolean:booleanValue	()Z
    //   1194: ifne +36 -> 1230
    //   1197: aload 73
    //   1199: aload_0
    //   1200: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   1203: getfield 442	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1206: invokevirtual 308	java/lang/String:getBytes	()[B
    //   1209: invokevirtual 455	oicq/wlogin_sdk/tlv_type/tlv_t112:get_tlv_112	([B)[B
    //   1212: astore 24
    //   1214: ldc_w 457
    //   1217: ldc_w 358
    //   1220: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1223: iload_3
    //   1224: iconst_1
    //   1225: iadd
    //   1226: istore_3
    //   1227: goto +8 -> 1235
    //   1230: iconst_0
    //   1231: newarray byte
    //   1233: astore 24
    //   1235: aload 9
    //   1237: ifnull +34 -> 1271
    //   1240: aload 9
    //   1242: arraylength
    //   1243: ifle +28 -> 1271
    //   1246: aload 57
    //   1248: aload 9
    //   1250: invokevirtual 460	oicq/wlogin_sdk/tlv_type/tlv_t16a:get_tlv_16a	([B)[B
    //   1253: astore 9
    //   1255: iload_3
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore_3
    //   1259: ldc_w 462
    //   1262: ldc_w 358
    //   1265: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1268: goto +8 -> 1276
    //   1271: iconst_0
    //   1272: newarray byte
    //   1274: astore 9
    //   1276: aload 7
    //   1278: astore 57
    //   1280: aload 25
    //   1282: astore 7
    //   1284: aload 7
    //   1286: ifnull +38 -> 1324
    //   1289: aload 25
    //   1291: invokeinterface 468 1 0
    //   1296: ifle +28 -> 1324
    //   1299: aload 58
    //   1301: aload 7
    //   1303: invokevirtual 472	oicq/wlogin_sdk/tlv_type/tlv_t511:get_tlv_511	(Ljava/util/List;)[B
    //   1306: astore 7
    //   1308: iload_3
    //   1309: iconst_1
    //   1310: iadd
    //   1311: istore_3
    //   1312: ldc_w 474
    //   1315: ldc_w 358
    //   1318: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1321: goto +8 -> 1329
    //   1324: iconst_0
    //   1325: newarray byte
    //   1327: astore 7
    //   1329: aload 9
    //   1331: astore 58
    //   1333: aload 60
    //   1335: ifnull +100 -> 1435
    //   1338: aload 60
    //   1340: getfield 479	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1343: ifnull +92 -> 1435
    //   1346: aload 60
    //   1348: getfield 479	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1351: arraylength
    //   1352: ifle +83 -> 1435
    //   1355: aload 60
    //   1357: getfield 482	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1360: ifnull +75 -> 1435
    //   1363: aload 60
    //   1365: getfield 482	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1368: arraylength
    //   1369: ifle +66 -> 1435
    //   1372: aload 60
    //   1374: getfield 485	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1377: ifnull +58 -> 1435
    //   1380: aload 60
    //   1382: getfield 485	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1385: arraylength
    //   1386: ifle +49 -> 1435
    //   1389: aload 59
    //   1391: aload 60
    //   1393: getfield 479	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1396: lload 4
    //   1398: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1401: aload 60
    //   1403: getfield 482	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1406: lload 22
    //   1408: lconst_1
    //   1409: aload 60
    //   1411: getfield 485	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1414: invokevirtual 489	oicq/wlogin_sdk/tlv_type/tlv_t400:get_tlv_400	([BJ[B[BJJ[B)[B
    //   1417: astore 25
    //   1419: iload_3
    //   1420: iconst_1
    //   1421: iadd
    //   1422: istore_3
    //   1423: ldc_w 491
    //   1426: ldc_w 358
    //   1429: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1432: goto +45 -> 1477
    //   1435: new 339	java/lang/StringBuilder
    //   1438: dup
    //   1439: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1442: astore 9
    //   1444: aload 9
    //   1446: ldc_w 358
    //   1449: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1452: pop
    //   1453: aload 9
    //   1455: lload 4
    //   1457: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1460: pop
    //   1461: ldc_w 496
    //   1464: aload 9
    //   1466: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1469: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1472: iconst_0
    //   1473: newarray byte
    //   1475: astore 25
    //   1477: aload 47
    //   1479: astore 59
    //   1481: aload 7
    //   1483: astore 60
    //   1485: iconst_4
    //   1486: newarray byte
    //   1488: astore 7
    //   1490: aload 7
    //   1492: iconst_0
    //   1493: iload 26
    //   1495: invokestatic 500	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   1498: aload 71
    //   1500: aload 7
    //   1502: iconst_4
    //   1503: invokevirtual 501	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   1506: aload 71
    //   1508: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   1511: astore 71
    //   1513: ldc_w 504
    //   1516: ldc_w 358
    //   1519: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1522: bipush 6
    //   1524: newarray byte
    //   1526: astore 7
    //   1528: aload 7
    //   1530: iconst_0
    //   1531: getstatic 507	oicq/wlogin_sdk/request/t:aA	I
    //   1534: invokestatic 500	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   1537: aload 7
    //   1539: iconst_4
    //   1540: iconst_0
    //   1541: invokestatic 510	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   1544: aload 61
    //   1546: aload 7
    //   1548: bipush 6
    //   1550: invokevirtual 501	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   1553: aload 61
    //   1555: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   1558: astore 61
    //   1560: iload_3
    //   1561: iconst_1
    //   1562: iadd
    //   1563: iconst_1
    //   1564: iadd
    //   1565: istore_3
    //   1566: ldc_w 512
    //   1569: ldc_w 358
    //   1572: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1575: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   1578: lstore_1
    //   1579: ldc_w 259
    //   1582: invokevirtual 308	java/lang/String:getBytes	()[B
    //   1585: astore 7
    //   1587: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1590: arraylength
    //   1591: bipush 10
    //   1593: iadd
    //   1594: iconst_2
    //   1595: iadd
    //   1596: aload 7
    //   1598: arraylength
    //   1599: iadd
    //   1600: iconst_4
    //   1601: iadd
    //   1602: newarray byte
    //   1604: astore 9
    //   1606: aload 9
    //   1608: iconst_0
    //   1609: lload 4
    //   1611: l2i
    //   1612: i2l
    //   1613: invokestatic 516	oicq/wlogin_sdk/tools/util:int64_to_buf	([BIJ)V
    //   1616: aload 9
    //   1618: iconst_4
    //   1619: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1622: arraylength
    //   1623: invokestatic 510	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   1626: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1629: iconst_0
    //   1630: aload 9
    //   1632: bipush 6
    //   1634: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1637: arraylength
    //   1638: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1641: bipush 6
    //   1643: getstatic 216	oicq/wlogin_sdk/request/t:B	[B
    //   1646: arraylength
    //   1647: iadd
    //   1648: istore 6
    //   1650: aload 9
    //   1652: iload 6
    //   1654: aload 7
    //   1656: arraylength
    //   1657: invokestatic 510	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   1660: iload 6
    //   1662: iconst_2
    //   1663: iadd
    //   1664: istore 6
    //   1666: aload 7
    //   1668: iconst_0
    //   1669: aload 9
    //   1671: iload 6
    //   1673: aload 7
    //   1675: arraylength
    //   1676: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1679: aload 9
    //   1681: iload 6
    //   1683: aload 7
    //   1685: arraylength
    //   1686: iadd
    //   1687: aload_0
    //   1688: getfield 16	oicq/wlogin_sdk/request/aa:u	I
    //   1691: invokestatic 500	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   1694: aload 63
    //   1696: lload 4
    //   1698: invokestatic 524	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1701: ldc_w 526
    //   1704: aload 9
    //   1706: invokevirtual 530	oicq/wlogin_sdk/tlv_type/tlv_t544:get_tlv_544	(Ljava/lang/String;Ljava/lang/String;[B)[B
    //   1709: astore 47
    //   1711: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   1714: lstore 4
    //   1716: new 339	java/lang/StringBuilder
    //   1719: dup
    //   1720: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1723: astore 7
    //   1725: aload 7
    //   1727: ldc_w 532
    //   1730: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1733: pop
    //   1734: lload 4
    //   1736: lload_1
    //   1737: lsub
    //   1738: lstore 22
    //   1740: aload 7
    //   1742: lload 22
    //   1744: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1747: pop
    //   1748: aload 7
    //   1750: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: ldc_w 358
    //   1756: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   1759: lconst_0
    //   1760: lstore 14
    //   1762: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   1765: lstore_1
    //   1766: new 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   1769: dup
    //   1770: sipush 1334
    //   1773: invokespecial 146	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   1776: astore 7
    //   1778: aload_0
    //   1779: getfield 44	oicq/wlogin_sdk/request/aa:a	Landroid/content/Context;
    //   1782: invokestatic 537	com/tencent/loginsecsdk/ProtocolDet:getLoginExtraData	(Landroid/content/Context;)[B
    //   1785: astore 63
    //   1787: aload 63
    //   1789: ifnull +1692 -> 3481
    //   1792: aload 63
    //   1794: arraylength
    //   1795: ifle +1686 -> 3481
    //   1798: aload 7
    //   1800: aload 63
    //   1802: aload 63
    //   1804: arraylength
    //   1805: invokevirtual 501	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   1808: aload 7
    //   1810: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   1813: astore 7
    //   1815: aload 7
    //   1817: arraylength
    //   1818: istore 6
    //   1820: iload 6
    //   1822: iconst_2
    //   1823: iadd
    //   1824: newarray byte
    //   1826: astore 9
    //   1828: aload 9
    //   1830: iconst_0
    //   1831: iconst_1
    //   1832: invokestatic 510	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   1835: aload 7
    //   1837: arraylength
    //   1838: istore 6
    //   1840: aload 7
    //   1842: iconst_0
    //   1843: aload 9
    //   1845: iconst_2
    //   1846: iload 6
    //   1848: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   1851: aload 62
    //   1853: aload 9
    //   1855: aload 9
    //   1857: arraylength
    //   1858: invokevirtual 501	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   1861: aload 62
    //   1863: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   1866: astore 7
    //   1868: iload_3
    //   1869: iconst_1
    //   1870: iadd
    //   1871: istore_3
    //   1872: aload 7
    //   1874: astore 9
    //   1876: iload_3
    //   1877: istore 6
    //   1879: lload 14
    //   1881: lstore 4
    //   1883: new 339	java/lang/StringBuilder
    //   1886: dup
    //   1887: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1890: astore 62
    //   1892: aload 7
    //   1894: astore 9
    //   1896: iload_3
    //   1897: istore 6
    //   1899: lload 14
    //   1901: lstore 4
    //   1903: aload 62
    //   1905: ldc_w 539
    //   1908: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: pop
    //   1912: aload 7
    //   1914: astore 9
    //   1916: iload_3
    //   1917: istore 6
    //   1919: lload 14
    //   1921: lstore 4
    //   1923: aload 62
    //   1925: aload 63
    //   1927: arraylength
    //   1928: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1931: pop
    //   1932: aload 7
    //   1934: astore 9
    //   1936: iload_3
    //   1937: istore 6
    //   1939: lload 14
    //   1941: lstore 4
    //   1943: aload 62
    //   1945: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1948: astore 62
    //   1950: aload 7
    //   1952: astore 9
    //   1954: iload_3
    //   1955: istore 6
    //   1957: lload 14
    //   1959: lstore 4
    //   1961: new 339	java/lang/StringBuilder
    //   1964: dup
    //   1965: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1968: astore 63
    //   1970: aload 7
    //   1972: astore 9
    //   1974: iload_3
    //   1975: istore 6
    //   1977: lload 14
    //   1979: lstore 4
    //   1981: aload 63
    //   1983: ldc_w 358
    //   1986: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: pop
    //   1990: aload 7
    //   1992: astore 9
    //   1994: iload_3
    //   1995: istore 6
    //   1997: lload 14
    //   1999: lstore 4
    //   2001: aload 63
    //   2003: aload_0
    //   2004: getfield 26	oicq/wlogin_sdk/request/aa:x	Loicq/wlogin_sdk/request/t;
    //   2007: getfield 542	oicq/wlogin_sdk/request/t:f	J
    //   2010: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2013: pop
    //   2014: aload 7
    //   2016: astore 9
    //   2018: iload_3
    //   2019: istore 6
    //   2021: lload 14
    //   2023: lstore 4
    //   2025: aload 62
    //   2027: aload 63
    //   2029: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2032: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2035: goto +3 -> 2038
    //   2038: aload 7
    //   2040: astore 9
    //   2042: iload_3
    //   2043: istore 6
    //   2045: lload 14
    //   2047: lstore 4
    //   2049: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   2052: lstore 14
    //   2054: aload 7
    //   2056: astore 9
    //   2058: iload_3
    //   2059: istore 6
    //   2061: lload 14
    //   2063: lstore 4
    //   2065: new 339	java/lang/StringBuilder
    //   2068: dup
    //   2069: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2072: astore 62
    //   2074: aload 7
    //   2076: astore 9
    //   2078: iload_3
    //   2079: istore 6
    //   2081: lload 14
    //   2083: lstore 4
    //   2085: aload 62
    //   2087: ldc_w 544
    //   2090: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2093: pop
    //   2094: aload 7
    //   2096: astore 9
    //   2098: iload_3
    //   2099: istore 6
    //   2101: lload 14
    //   2103: lstore 4
    //   2105: aload 62
    //   2107: lload 14
    //   2109: lload_1
    //   2110: lsub
    //   2111: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2114: pop
    //   2115: aload 7
    //   2117: astore 9
    //   2119: iload_3
    //   2120: istore 6
    //   2122: lload 14
    //   2124: lstore 4
    //   2126: aload 62
    //   2128: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2131: ldc_w 358
    //   2134: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2137: lload 14
    //   2139: lstore 4
    //   2141: goto +71 -> 2212
    //   2144: astore 7
    //   2146: iload 6
    //   2148: istore_3
    //   2149: goto +19 -> 2168
    //   2152: astore 7
    //   2154: goto +7 -> 2161
    //   2157: astore 7
    //   2159: lconst_0
    //   2160: lstore_1
    //   2161: aconst_null
    //   2162: astore 9
    //   2164: lload 14
    //   2166: lstore 4
    //   2168: new 339	java/lang/StringBuilder
    //   2171: dup
    //   2172: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2175: astore 62
    //   2177: aload 62
    //   2179: ldc_w 546
    //   2182: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2185: pop
    //   2186: aload 62
    //   2188: aload 7
    //   2190: invokestatic 552	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2193: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2196: pop
    //   2197: aload 62
    //   2199: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2202: ldc_w 358
    //   2205: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2208: aload 9
    //   2210: astore 7
    //   2212: aload 64
    //   2214: arraylength
    //   2215: istore 6
    //   2217: aload 65
    //   2219: arraylength
    //   2220: istore 10
    //   2222: aload 66
    //   2224: arraylength
    //   2225: istore 11
    //   2227: aload 69
    //   2229: arraylength
    //   2230: istore 13
    //   2232: aload 67
    //   2234: arraylength
    //   2235: istore 16
    //   2237: aload 68
    //   2239: arraylength
    //   2240: istore 17
    //   2242: aload 21
    //   2244: arraylength
    //   2245: istore 18
    //   2247: aload 72
    //   2249: arraylength
    //   2250: istore 19
    //   2252: aload 74
    //   2254: arraylength
    //   2255: istore 20
    //   2257: aload 24
    //   2259: arraylength
    //   2260: istore 26
    //   2262: aload 59
    //   2264: arraylength
    //   2265: istore 28
    //   2267: aload 53
    //   2269: arraylength
    //   2270: istore 29
    //   2272: aload 58
    //   2274: arraylength
    //   2275: istore 30
    //   2277: aload 55
    //   2279: arraylength
    //   2280: istore 31
    //   2282: aload 56
    //   2284: arraylength
    //   2285: istore 32
    //   2287: aload 70
    //   2289: arraylength
    //   2290: istore 33
    //   2292: aload 60
    //   2294: arraylength
    //   2295: istore 34
    //   2297: aload 49
    //   2299: arraylength
    //   2300: istore 35
    //   2302: aload 50
    //   2304: arraylength
    //   2305: istore 36
    //   2307: aload 48
    //   2309: arraylength
    //   2310: istore 37
    //   2312: aload 25
    //   2314: arraylength
    //   2315: istore 38
    //   2317: aload 51
    //   2319: arraylength
    //   2320: istore 39
    //   2322: aload 52
    //   2324: arraylength
    //   2325: istore 40
    //   2327: aload 54
    //   2329: arraylength
    //   2330: istore 41
    //   2332: aload 57
    //   2334: arraylength
    //   2335: istore 42
    //   2337: aload 12
    //   2339: arraylength
    //   2340: istore 43
    //   2342: aload 71
    //   2344: arraylength
    //   2345: istore 44
    //   2347: aload 61
    //   2349: astore 9
    //   2351: iload 6
    //   2353: iload 10
    //   2355: iadd
    //   2356: iload 11
    //   2358: iadd
    //   2359: iload 13
    //   2361: iadd
    //   2362: iload 16
    //   2364: iadd
    //   2365: iload 17
    //   2367: iadd
    //   2368: iload 18
    //   2370: iadd
    //   2371: iload 19
    //   2373: iadd
    //   2374: iload 20
    //   2376: iadd
    //   2377: iload 26
    //   2379: iadd
    //   2380: iload 28
    //   2382: iadd
    //   2383: iload 29
    //   2385: iadd
    //   2386: iload 30
    //   2388: iadd
    //   2389: iload 31
    //   2391: iadd
    //   2392: iload 32
    //   2394: iadd
    //   2395: iload 33
    //   2397: iadd
    //   2398: iload 34
    //   2400: iadd
    //   2401: iload 35
    //   2403: iadd
    //   2404: iload 36
    //   2406: iadd
    //   2407: iload 37
    //   2409: iadd
    //   2410: iload 38
    //   2412: iadd
    //   2413: iload 39
    //   2415: iadd
    //   2416: iload 40
    //   2418: iadd
    //   2419: iload 41
    //   2421: iadd
    //   2422: iload 42
    //   2424: iadd
    //   2425: iload 43
    //   2427: iadd
    //   2428: iload 44
    //   2430: iadd
    //   2431: aload 9
    //   2433: arraylength
    //   2434: iadd
    //   2435: istore 10
    //   2437: iload 10
    //   2439: istore 6
    //   2441: aload 7
    //   2443: ifnull +11 -> 2454
    //   2446: iload 10
    //   2448: aload 7
    //   2450: arraylength
    //   2451: iadd
    //   2452: istore 6
    //   2454: aload 8
    //   2456: ifnull +28 -> 2484
    //   2459: aload 8
    //   2461: astore 61
    //   2463: iload 6
    //   2465: istore 10
    //   2467: aload 61
    //   2469: arraylength
    //   2470: ifle +18 -> 2488
    //   2473: iload 6
    //   2475: aload 61
    //   2477: arraylength
    //   2478: iadd
    //   2479: istore 10
    //   2481: goto +7 -> 2488
    //   2484: iload 6
    //   2486: istore 10
    //   2488: aload 7
    //   2490: astore 61
    //   2492: aload 47
    //   2494: ifnull +18 -> 2512
    //   2497: iload 10
    //   2499: aload 47
    //   2501: arraylength
    //   2502: iadd
    //   2503: istore 10
    //   2505: iload_3
    //   2506: iconst_1
    //   2507: iadd
    //   2508: istore_3
    //   2509: goto +3 -> 2512
    //   2512: aload 8
    //   2514: astore 62
    //   2516: aload 27
    //   2518: getfield 558	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   2521: invokevirtual 564	java/util/HashMap:keySet	()Ljava/util/Set;
    //   2524: invokeinterface 570 1 0
    //   2529: astore 63
    //   2531: iload 10
    //   2533: istore 6
    //   2535: aload 12
    //   2537: astore 7
    //   2539: aload 9
    //   2541: astore 8
    //   2543: iload_3
    //   2544: istore 10
    //   2546: aload 63
    //   2548: astore 9
    //   2550: aload 9
    //   2552: invokeinterface 575 1 0
    //   2557: ifeq +105 -> 2662
    //   2560: aload 9
    //   2562: invokeinterface 579 1 0
    //   2567: checkcast 581	java/lang/Integer
    //   2570: astore 12
    //   2572: aload 27
    //   2574: getfield 558	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   2577: aload 12
    //   2579: invokevirtual 585	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   2582: checkcast 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2585: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2588: astore 63
    //   2590: iload 6
    //   2592: aload 63
    //   2594: arraylength
    //   2595: iadd
    //   2596: istore 6
    //   2598: iload 10
    //   2600: iconst_1
    //   2601: iadd
    //   2602: istore 10
    //   2604: new 339	java/lang/StringBuilder
    //   2607: dup
    //   2608: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2611: astore 73
    //   2613: aload 73
    //   2615: ldc_w 587
    //   2618: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2621: pop
    //   2622: aload 73
    //   2624: aload 12
    //   2626: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2629: pop
    //   2630: aload 73
    //   2632: ldc_w 592
    //   2635: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: aload 73
    //   2641: aload 63
    //   2643: arraylength
    //   2644: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2647: pop
    //   2648: aload 73
    //   2650: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2653: ldc_w 358
    //   2656: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2659: goto -109 -> 2550
    //   2662: iload 6
    //   2664: newarray byte
    //   2666: astore 9
    //   2668: aload 64
    //   2670: iconst_0
    //   2671: aload 9
    //   2673: iconst_0
    //   2674: aload 64
    //   2676: arraylength
    //   2677: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2680: aload 64
    //   2682: arraylength
    //   2683: iconst_0
    //   2684: iadd
    //   2685: istore_3
    //   2686: aload 65
    //   2688: iconst_0
    //   2689: aload 9
    //   2691: iload_3
    //   2692: aload 65
    //   2694: arraylength
    //   2695: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2698: iload_3
    //   2699: aload 65
    //   2701: arraylength
    //   2702: iadd
    //   2703: istore_3
    //   2704: aload 66
    //   2706: iconst_0
    //   2707: aload 9
    //   2709: iload_3
    //   2710: aload 66
    //   2712: arraylength
    //   2713: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2716: iload_3
    //   2717: aload 66
    //   2719: arraylength
    //   2720: iadd
    //   2721: istore_3
    //   2722: aload 69
    //   2724: iconst_0
    //   2725: aload 9
    //   2727: iload_3
    //   2728: aload 69
    //   2730: arraylength
    //   2731: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2734: iload_3
    //   2735: aload 69
    //   2737: arraylength
    //   2738: iadd
    //   2739: istore_3
    //   2740: aload 67
    //   2742: iconst_0
    //   2743: aload 9
    //   2745: iload_3
    //   2746: aload 67
    //   2748: arraylength
    //   2749: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2752: iload_3
    //   2753: aload 67
    //   2755: arraylength
    //   2756: iadd
    //   2757: istore_3
    //   2758: aload 68
    //   2760: iconst_0
    //   2761: aload 9
    //   2763: iload_3
    //   2764: aload 68
    //   2766: arraylength
    //   2767: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2770: iload_3
    //   2771: aload 68
    //   2773: arraylength
    //   2774: iadd
    //   2775: istore_3
    //   2776: aload 21
    //   2778: iconst_0
    //   2779: aload 9
    //   2781: iload_3
    //   2782: aload 21
    //   2784: arraylength
    //   2785: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2788: iload_3
    //   2789: aload 21
    //   2791: arraylength
    //   2792: iadd
    //   2793: istore_3
    //   2794: aload 72
    //   2796: iconst_0
    //   2797: aload 9
    //   2799: iload_3
    //   2800: aload 72
    //   2802: arraylength
    //   2803: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2806: iload_3
    //   2807: aload 72
    //   2809: arraylength
    //   2810: iadd
    //   2811: istore_3
    //   2812: aload 74
    //   2814: iconst_0
    //   2815: aload 9
    //   2817: iload_3
    //   2818: aload 74
    //   2820: arraylength
    //   2821: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2824: iload_3
    //   2825: aload 74
    //   2827: arraylength
    //   2828: iadd
    //   2829: istore_3
    //   2830: aload 24
    //   2832: iconst_0
    //   2833: aload 9
    //   2835: iload_3
    //   2836: aload 24
    //   2838: arraylength
    //   2839: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2842: iload_3
    //   2843: aload 24
    //   2845: arraylength
    //   2846: iadd
    //   2847: istore_3
    //   2848: aload 59
    //   2850: iconst_0
    //   2851: aload 9
    //   2853: iload_3
    //   2854: aload 59
    //   2856: arraylength
    //   2857: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2860: iload_3
    //   2861: aload 59
    //   2863: arraylength
    //   2864: iadd
    //   2865: istore_3
    //   2866: aload 53
    //   2868: iconst_0
    //   2869: aload 9
    //   2871: iload_3
    //   2872: aload 53
    //   2874: arraylength
    //   2875: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2878: iload_3
    //   2879: aload 53
    //   2881: arraylength
    //   2882: iadd
    //   2883: istore_3
    //   2884: aload 58
    //   2886: iconst_0
    //   2887: aload 9
    //   2889: iload_3
    //   2890: aload 58
    //   2892: arraylength
    //   2893: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2896: iload_3
    //   2897: aload 58
    //   2899: arraylength
    //   2900: iadd
    //   2901: istore_3
    //   2902: aload 55
    //   2904: iconst_0
    //   2905: aload 9
    //   2907: iload_3
    //   2908: aload 55
    //   2910: arraylength
    //   2911: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2914: iload_3
    //   2915: aload 55
    //   2917: arraylength
    //   2918: iadd
    //   2919: istore_3
    //   2920: aload 56
    //   2922: iconst_0
    //   2923: aload 9
    //   2925: iload_3
    //   2926: aload 56
    //   2928: arraylength
    //   2929: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2932: iload_3
    //   2933: aload 56
    //   2935: arraylength
    //   2936: iadd
    //   2937: istore_3
    //   2938: aload 70
    //   2940: iconst_0
    //   2941: aload 9
    //   2943: iload_3
    //   2944: aload 70
    //   2946: arraylength
    //   2947: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2950: iload_3
    //   2951: aload 70
    //   2953: arraylength
    //   2954: iadd
    //   2955: istore_3
    //   2956: aload 60
    //   2958: iconst_0
    //   2959: aload 9
    //   2961: iload_3
    //   2962: aload 60
    //   2964: arraylength
    //   2965: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2968: iload_3
    //   2969: aload 60
    //   2971: arraylength
    //   2972: iadd
    //   2973: istore_3
    //   2974: aload 49
    //   2976: iconst_0
    //   2977: aload 9
    //   2979: iload_3
    //   2980: aload 49
    //   2982: arraylength
    //   2983: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2986: iload_3
    //   2987: aload 49
    //   2989: arraylength
    //   2990: iadd
    //   2991: istore_3
    //   2992: aload 50
    //   2994: iconst_0
    //   2995: aload 9
    //   2997: iload_3
    //   2998: aload 50
    //   3000: arraylength
    //   3001: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3004: iload_3
    //   3005: aload 50
    //   3007: arraylength
    //   3008: iadd
    //   3009: istore_3
    //   3010: aload 48
    //   3012: iconst_0
    //   3013: aload 9
    //   3015: iload_3
    //   3016: aload 48
    //   3018: arraylength
    //   3019: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3022: iload_3
    //   3023: aload 48
    //   3025: arraylength
    //   3026: iadd
    //   3027: istore_3
    //   3028: aload 25
    //   3030: iconst_0
    //   3031: aload 9
    //   3033: iload_3
    //   3034: aload 25
    //   3036: arraylength
    //   3037: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3040: iload_3
    //   3041: aload 25
    //   3043: arraylength
    //   3044: iadd
    //   3045: istore_3
    //   3046: aload 51
    //   3048: iconst_0
    //   3049: aload 9
    //   3051: iload_3
    //   3052: aload 51
    //   3054: arraylength
    //   3055: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3058: iload_3
    //   3059: aload 51
    //   3061: arraylength
    //   3062: iadd
    //   3063: istore_3
    //   3064: aload 52
    //   3066: iconst_0
    //   3067: aload 9
    //   3069: iload_3
    //   3070: aload 52
    //   3072: arraylength
    //   3073: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3076: iload_3
    //   3077: aload 52
    //   3079: arraylength
    //   3080: iadd
    //   3081: istore_3
    //   3082: aload 54
    //   3084: iconst_0
    //   3085: aload 9
    //   3087: iload_3
    //   3088: aload 54
    //   3090: arraylength
    //   3091: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3094: iload_3
    //   3095: aload 54
    //   3097: arraylength
    //   3098: iadd
    //   3099: istore_3
    //   3100: aload 57
    //   3102: iconst_0
    //   3103: aload 9
    //   3105: iload_3
    //   3106: aload 57
    //   3108: arraylength
    //   3109: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3112: iload_3
    //   3113: aload 57
    //   3115: arraylength
    //   3116: iadd
    //   3117: istore_3
    //   3118: aload 7
    //   3120: iconst_0
    //   3121: aload 9
    //   3123: iload_3
    //   3124: aload 7
    //   3126: arraylength
    //   3127: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3130: iload_3
    //   3131: aload 7
    //   3133: arraylength
    //   3134: iadd
    //   3135: istore_3
    //   3136: aload 71
    //   3138: iconst_0
    //   3139: aload 9
    //   3141: iload_3
    //   3142: aload 71
    //   3144: arraylength
    //   3145: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3148: iload_3
    //   3149: aload 71
    //   3151: arraylength
    //   3152: iadd
    //   3153: istore_3
    //   3154: aload 8
    //   3156: iconst_0
    //   3157: aload 9
    //   3159: iload_3
    //   3160: aload 8
    //   3162: arraylength
    //   3163: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3166: iload_3
    //   3167: aload 8
    //   3169: arraylength
    //   3170: iadd
    //   3171: istore 6
    //   3173: iload 6
    //   3175: istore_3
    //   3176: aload 61
    //   3178: ifnull +23 -> 3201
    //   3181: aload 61
    //   3183: iconst_0
    //   3184: aload 9
    //   3186: iload 6
    //   3188: aload 61
    //   3190: arraylength
    //   3191: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3194: iload 6
    //   3196: aload 61
    //   3198: arraylength
    //   3199: iadd
    //   3200: istore_3
    //   3201: iload_3
    //   3202: istore 6
    //   3204: aload 47
    //   3206: ifnull +22 -> 3228
    //   3209: aload 47
    //   3211: iconst_0
    //   3212: aload 9
    //   3214: iload_3
    //   3215: aload 47
    //   3217: arraylength
    //   3218: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3221: iload_3
    //   3222: aload 47
    //   3224: arraylength
    //   3225: iadd
    //   3226: istore 6
    //   3228: iload 6
    //   3230: istore_3
    //   3231: aload 62
    //   3233: ifnull +70 -> 3303
    //   3236: iload 6
    //   3238: istore_3
    //   3239: aload 62
    //   3241: arraylength
    //   3242: ifle +61 -> 3303
    //   3245: aload 62
    //   3247: iconst_0
    //   3248: aload 9
    //   3250: iload 6
    //   3252: aload 62
    //   3254: arraylength
    //   3255: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3258: iload 6
    //   3260: aload 62
    //   3262: arraylength
    //   3263: iadd
    //   3264: istore_3
    //   3265: new 339	java/lang/StringBuilder
    //   3268: dup
    //   3269: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3272: astore 7
    //   3274: aload 7
    //   3276: ldc_w 594
    //   3279: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3282: pop
    //   3283: aload 7
    //   3285: aload 62
    //   3287: arraylength
    //   3288: invokevirtual 352	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3291: pop
    //   3292: aload 7
    //   3294: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3297: ldc_w 358
    //   3300: invokestatic 361	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3303: aload 27
    //   3305: getfield 558	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3308: invokevirtual 564	java/util/HashMap:keySet	()Ljava/util/Set;
    //   3311: invokeinterface 570 1 0
    //   3316: astore 7
    //   3318: aload 7
    //   3320: invokeinterface 575 1 0
    //   3325: ifeq +88 -> 3413
    //   3328: aload 7
    //   3330: invokeinterface 579 1 0
    //   3335: checkcast 581	java/lang/Integer
    //   3338: astore 8
    //   3340: aload 27
    //   3342: getfield 558	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3345: aload 8
    //   3347: invokevirtual 585	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3350: checkcast 143	oicq/wlogin_sdk/tlv_type/tlv_t
    //   3353: invokevirtual 502	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   3356: astore 12
    //   3358: aload 12
    //   3360: iconst_0
    //   3361: aload 9
    //   3363: iload_3
    //   3364: aload 12
    //   3366: arraylength
    //   3367: invokestatic 520	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3370: iload_3
    //   3371: aload 12
    //   3373: arraylength
    //   3374: iadd
    //   3375: istore_3
    //   3376: new 339	java/lang/StringBuilder
    //   3379: dup
    //   3380: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3383: astore 12
    //   3385: aload 12
    //   3387: ldc_w 587
    //   3390: invokevirtual 347	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3393: pop
    //   3394: aload 12
    //   3396: aload 8
    //   3398: invokevirtual 590	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3401: pop
    //   3402: aload 12
    //   3404: invokevirtual 356	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3407: invokestatic 597	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   3410: goto -92 -> 3318
    //   3413: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   3416: lstore 14
    //   3418: invokestatic 602	oicq/wlogin_sdk/report/a:a	()Loicq/wlogin_sdk/report/a;
    //   3421: iconst_2
    //   3422: lload 14
    //   3424: lload 45
    //   3426: lsub
    //   3427: lload 22
    //   3429: lload 4
    //   3431: lload_1
    //   3432: lsub
    //   3433: invokevirtual 605	oicq/wlogin_sdk/report/a:a	(IJJJ)V
    //   3436: invokestatic 158	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3439: invokestatic 607	oicq/wlogin_sdk/report/c:b	(Ljava/lang/Thread;)V
    //   3442: aload_0
    //   3443: aload_0
    //   3444: aload 9
    //   3446: aload_0
    //   3447: getfield 16	oicq/wlogin_sdk/request/aa:u	I
    //   3450: iload 10
    //   3452: invokevirtual 610	oicq/wlogin_sdk/request/aa:a	([BII)[B
    //   3455: aload_0
    //   3456: getfield 40	oicq/wlogin_sdk/request/aa:y	Loicq/wlogin_sdk/request/oicq_request$EncryptionMethod;
    //   3459: aload_0
    //   3460: getfield 613	oicq/wlogin_sdk/request/aa:A	[B
    //   3463: aload_0
    //   3464: getfield 614	oicq/wlogin_sdk/request/aa:B	[B
    //   3467: invokevirtual 617	oicq/wlogin_sdk/request/aa:a	([BLoicq/wlogin_sdk/request/oicq_request$EncryptionMethod;[B[B)[B
    //   3470: areturn
    //   3471: astore 7
    //   3473: goto -1312 -> 2161
    //   3476: astore 7
    //   3478: goto -1317 -> 2161
    //   3481: aconst_null
    //   3482: astore 7
    //   3484: goto -1446 -> 2038
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3487	0	this	aa
    //   0	3487	1	paramLong1	long
    //   0	3487	3	paramInt1	int
    //   0	3487	4	paramLong2	long
    //   0	3487	6	paramInt2	int
    //   0	3487	7	paramArrayOfByte1	byte[]
    //   0	3487	8	paramArrayOfByte2	byte[]
    //   0	3487	9	paramArrayOfByte3	byte[]
    //   0	3487	10	paramInt3	int
    //   0	3487	11	paramInt4	int
    //   0	3487	12	paramArrayOfLong	long[]
    //   0	3487	13	paramInt5	int
    //   0	3487	14	paramLong3	long
    //   0	3487	16	paramInt6	int
    //   0	3487	17	paramInt7	int
    //   0	3487	18	paramInt8	int
    //   0	3487	19	paramInt9	int
    //   0	3487	20	paramInt10	int
    //   0	3487	21	paramArrayOfByte4	byte[]
    //   0	3487	22	paramLong4	long
    //   0	3487	24	paramArrayOfByte5	byte[]
    //   0	3487	25	paramList	java.util.List<String>
    //   0	3487	26	paramInt11	int
    //   0	3487	27	paramWUserSigInfo	WUserSigInfo
    //   2265	118	28	i	int
    //   2270	116	29	j	int
    //   2275	114	30	k	int
    //   2280	112	31	m	int
    //   2285	110	32	n	int
    //   2290	108	33	i1	int
    //   2295	106	34	i2	int
    //   2300	104	35	i3	int
    //   2305	102	36	i4	int
    //   2310	100	37	i5	int
    //   2315	98	38	i6	int
    //   2320	96	39	i7	int
    //   2325	94	40	i8	int
    //   2330	92	41	i9	int
    //   2335	90	42	i10	int
    //   2340	88	43	i11	int
    //   2345	86	44	i12	int
    //   342	3083	45	l	long
    //   133	3090	47	localObject1	Object
    //   223	2801	48	localObject2	Object
    //   142	2846	49	localObject3	Object
    //   241	2765	50	localObject4	Object
    //   250	2810	51	localObject5	Object
    //   259	2819	52	localObject6	Object
    //   268	2612	53	localObject7	Object
    //   214	2882	54	localObject8	Object
    //   187	2729	55	localObject9	Object
    //   169	2765	56	localObject10	Object
    //   160	2954	57	localObject11	Object
    //   196	2702	58	localObject12	Object
    //   232	2630	59	localObject13	Object
    //   355	2615	60	localObject14	Object
    //   301	2896	61	localObject15	Object
    //   313	2973	62	localObject16	Object
    //   331	2311	63	localObject17	Object
    //   7	2674	64	localObject18	Object
    //   16	2684	65	localObject19	Object
    //   25	2693	66	localObject20	Object
    //   43	2711	67	localObject21	Object
    //   52	2720	68	localObject22	Object
    //   34	2702	69	localObject23	Object
    //   178	2774	70	localObject24	Object
    //   289	2861	71	localObject25	Object
    //   124	2684	72	localObject26	Object
    //   115	2534	73	localObject27	Object
    //   106	2720	74	localObject28	Object
    //   205	932	75	localObject29	Object
    //   97	1038	76	localObject30	Object
    //   88	1045	77	localObject31	Object
    //   79	1052	78	localObject32	Object
    //   70	1059	79	localObject33	Object
    //   322	740	80	localObject34	Object
    //   277	787	81	localObject35	Object
    //   151	917	82	localObject36	Object
    //   61	1012	83	localObject37	Object
    // Exception table:
    //   from	to	target	type
    //   1883	1892	2144	java/lang/Throwable
    //   1903	1912	2144	java/lang/Throwable
    //   1923	1932	2144	java/lang/Throwable
    //   1943	1950	2144	java/lang/Throwable
    //   1961	1970	2144	java/lang/Throwable
    //   1981	1990	2144	java/lang/Throwable
    //   2001	2014	2144	java/lang/Throwable
    //   2025	2035	2144	java/lang/Throwable
    //   2049	2054	2144	java/lang/Throwable
    //   2065	2074	2144	java/lang/Throwable
    //   2085	2094	2144	java/lang/Throwable
    //   2105	2115	2144	java/lang/Throwable
    //   2126	2137	2144	java/lang/Throwable
    //   1766	1787	2152	java/lang/Throwable
    //   1792	1820	2152	java/lang/Throwable
    //   1762	1766	2157	java/lang/Throwable
    //   1840	1868	3471	java/lang/Throwable
    //   1820	1840	3476	java/lang/Throwable
  }
  
  public int a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong3, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte4, long paramLong4, WUserSigInfo paramWUserSigInfo)
  {
    Object localObject2 = new StringBuilder();
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramLong2);
    util.LOGI("start request_tgtgt_nopicsig", ((StringBuilder)localObject2).toString());
    int j = t.x;
    byte[] arrayOfByte = c(paramArrayOfByte2);
    if (arrayOfByte == null) {
      return -1014;
    }
    paramInt1 = 0;
    paramArrayOfByte2 = (byte[])localObject1;
    for (;;)
    {
      localObject1 = paramWUserSigInfo;
      localObject2 = this;
      if ((((aa)localObject2).y == oicq_request.EncryptionMethod.EM_ST) && ((((aa)localObject2).B == null) || (((aa)localObject2).B.length == 0) || (((aa)localObject2).A == null) || (((aa)localObject2).A.length == 0)))
      {
        ((aa)localObject2).y = oicq_request.EncryptionMethod.EM_ECDH;
        t.at.attr_api(2413503);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramArrayOfByte2);
        ((StringBuilder)localObject2).append(paramLong2);
        util.LOGI("using wt st encrypt body but no st key", ((StringBuilder)localObject2).toString());
      }
      a(paramLong2, a(paramLong1, j, paramLong2, paramInt2, paramArrayOfByte1, arrayOfByte, paramArrayOfByte3, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong3, j, paramInt7, paramInt8, paramInt9, paramInt10, paramArrayOfByte4, paramLong4, t.F, ((WUserSigInfo)localObject1)._domains, ((WUserSigInfo)localObject1)._source_type, paramWUserSigInfo), this.y);
      paramInt6 = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
      int i;
      if (paramInt6 != 0)
      {
        paramInt1 = paramInt6;
      }
      else
      {
        paramInt6 = b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("retry num:");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" ret:");
        ((StringBuilder)localObject1).append(paramInt6);
        localObject2 = ((StringBuilder)localObject1).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localObject1 = paramArrayOfByte2;
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(paramLong2);
        util.LOGI((String)localObject2, localStringBuilder.toString());
        if (paramInt6 != 180)
        {
          paramInt1 = paramInt6;
        }
        else
        {
          i = paramInt1 + 1;
          if (paramInt1 < 1) {
            break label461;
          }
          paramInt1 = paramInt6;
        }
      }
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("end request_tgtgt_nopicsig ret ");
      paramArrayOfByte1.append(paramInt1);
      paramArrayOfByte1 = paramArrayOfByte1.toString();
      paramArrayOfByte3 = new StringBuilder();
      paramArrayOfByte3.append(paramArrayOfByte2);
      paramArrayOfByte3.append(paramLong2);
      util.LOGI(paramArrayOfByte1, paramArrayOfByte3.toString());
      return paramInt1;
      label461:
      paramArrayOfByte2 = (byte[])localObject1;
      paramInt1 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     oicq.wlogin_sdk.request.aa
 * JD-Core Version:    0.7.0.1
 */