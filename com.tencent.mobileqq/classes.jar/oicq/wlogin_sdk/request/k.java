package oicq.wlogin_sdk.request;

import android.content.Context;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tools.util;

public class k
  extends oicq_request
{
  public static int K = 0;
  public static byte[] L = new byte[0];
  public static byte[] M = new byte[0];
  public static byte[] N = new byte[0];
  
  public k(t paramt, Context paramContext)
  {
    this.t = 2064;
    this.u = 9;
    this.v = "wtlogin.login";
    this.x = paramt;
    this.x.m = 0;
    this.a = paramContext;
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, int paramInt4, long[] paramArrayOfLong, int paramInt5, long paramLong4, int paramInt6, int paramInt7, int paramInt8, int paramInt9, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int j = t.x;
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.C);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    for (;;)
    {
      int i = 0;
      for (;;)
      {
        a(paramLong3, a(paramLong1, paramLong2, j, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (k != 0) {
          return k;
        }
        k = b();
        util.LOGI("retry num:" + i + " ret:" + k, "" + paramLong3);
        if (k != 180) {
          return k;
        }
        if (i >= 1) {
          return k;
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    int m = t.x;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      int j;
      if (paramArrayOfByte2 == null)
      {
        j = -1014;
        return j;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, m, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo);
        a(this.i, this.t, this.j, paramLong3, this.m, this.n, m, this.p, arrayOfByte);
        int k = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        j = k;
        if (k != 0) {
          break;
        }
        j = b();
        util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
        if (j != 180) {
          return j;
        }
        if (i >= 1) {
          return j;
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public byte[] a(long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt3, byte[] paramArrayOfByte5, byte[] paramArrayOfByte6, int paramInt4, int paramInt5, long[] paramArrayOfLong, int paramInt6, long paramLong4, int paramInt7, int paramInt8, int paramInt9, int paramInt10, byte[] paramArrayOfByte7, byte[] paramArrayOfByte8, byte[] paramArrayOfByte9, java.util.List<String> paramList, WUserSigInfo paramWUserSigInfo)
  {
    // Byte code:
    //   0: bipush 37
    //   2: newarray int
    //   4: astore 52
    //   6: aload 52
    //   8: dup
    //   9: iconst_0
    //   10: bipush 24
    //   12: iastore
    //   13: dup
    //   14: iconst_1
    //   15: iconst_1
    //   16: iastore
    //   17: dup
    //   18: iconst_2
    //   19: sipush 262
    //   22: iastore
    //   23: dup
    //   24: iconst_3
    //   25: sipush 278
    //   28: iastore
    //   29: dup
    //   30: iconst_4
    //   31: sipush 256
    //   34: iastore
    //   35: dup
    //   36: iconst_5
    //   37: sipush 263
    //   40: iastore
    //   41: dup
    //   42: bipush 6
    //   44: sipush 264
    //   47: iastore
    //   48: dup
    //   49: bipush 7
    //   51: sipush 260
    //   54: iastore
    //   55: dup
    //   56: bipush 8
    //   58: sipush 322
    //   61: iastore
    //   62: dup
    //   63: bipush 9
    //   65: sipush 274
    //   68: iastore
    //   69: dup
    //   70: bipush 10
    //   72: sipush 324
    //   75: iastore
    //   76: dup
    //   77: bipush 11
    //   79: sipush 325
    //   82: iastore
    //   83: dup
    //   84: bipush 12
    //   86: sipush 327
    //   89: iastore
    //   90: dup
    //   91: bipush 13
    //   93: sipush 358
    //   96: iastore
    //   97: dup
    //   98: bipush 14
    //   100: sipush 362
    //   103: iastore
    //   104: dup
    //   105: bipush 15
    //   107: sipush 340
    //   110: iastore
    //   111: dup
    //   112: bipush 16
    //   114: sipush 321
    //   117: iastore
    //   118: dup
    //   119: bipush 17
    //   121: bipush 8
    //   123: iastore
    //   124: dup
    //   125: bipush 18
    //   127: sipush 1297
    //   130: iastore
    //   131: dup
    //   132: bipush 19
    //   134: sipush 370
    //   137: iastore
    //   138: dup
    //   139: bipush 20
    //   141: sipush 389
    //   144: iastore
    //   145: dup
    //   146: bipush 21
    //   148: sipush 1024
    //   151: iastore
    //   152: dup
    //   153: bipush 22
    //   155: sipush 391
    //   158: iastore
    //   159: dup
    //   160: bipush 23
    //   162: sipush 392
    //   165: iastore
    //   166: dup
    //   167: bipush 24
    //   169: sipush 404
    //   172: iastore
    //   173: dup
    //   174: bipush 25
    //   176: sipush 401
    //   179: iastore
    //   180: dup
    //   181: bipush 26
    //   183: sipush 513
    //   186: iastore
    //   187: dup
    //   188: bipush 27
    //   190: sipush 514
    //   193: iastore
    //   194: dup
    //   195: bipush 28
    //   197: sipush 375
    //   200: iastore
    //   201: dup
    //   202: bipush 29
    //   204: sipush 1302
    //   207: iastore
    //   208: dup
    //   209: bipush 30
    //   211: sipush 1313
    //   214: iastore
    //   215: dup
    //   216: bipush 31
    //   218: sipush 1317
    //   221: iastore
    //   222: dup
    //   223: bipush 32
    //   225: sipush 1321
    //   228: iastore
    //   229: dup
    //   230: bipush 33
    //   232: sipush 792
    //   235: iastore
    //   236: dup
    //   237: bipush 34
    //   239: sipush 1348
    //   242: iastore
    //   243: dup
    //   244: bipush 35
    //   246: sipush 1349
    //   249: iastore
    //   250: dup
    //   251: bipush 36
    //   253: sipush 1352
    //   256: iastore
    //   257: pop
    //   258: aload_0
    //   259: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   262: getfield 57	oicq/wlogin_sdk/request/t:h	J
    //   265: invokestatic 61	oicq/wlogin_sdk/request/t:b	(J)Loicq/wlogin_sdk/request/async_context;
    //   268: astore 53
    //   270: new 171	java/util/ArrayList
    //   273: dup
    //   274: invokespecial 172	java/util/ArrayList:<init>	()V
    //   277: astore 51
    //   279: iconst_0
    //   280: istore 31
    //   282: ldc 174
    //   284: ldc 140
    //   286: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: invokestatic 180	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   292: invokestatic 185	oicq/wlogin_sdk/report/c:a	(Ljava/lang/Thread;)V
    //   295: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   298: lstore 45
    //   300: lconst_0
    //   301: lstore 35
    //   303: lconst_0
    //   304: lstore 37
    //   306: lconst_0
    //   307: lstore 41
    //   309: lconst_0
    //   310: lstore 39
    //   312: aload 52
    //   314: arraylength
    //   315: istore 34
    //   317: iconst_0
    //   318: istore 32
    //   320: iload 32
    //   322: iload 34
    //   324: if_icmpge +3038 -> 3362
    //   327: aload 52
    //   329: iload 32
    //   331: iaload
    //   332: istore 33
    //   334: aconst_null
    //   335: astore 50
    //   337: aconst_null
    //   338: astore 48
    //   340: aconst_null
    //   341: astore 49
    //   343: iload 33
    //   345: lookupswitch	default:+299->644, 1:+391->736, 8:+1307->1652, 24:+357->702, 256:+567->912, 260:+699->1044, 262:+422->767, 263:+601->946, 264:+636->981, 274:+791->1136, 278:+534->879, 321:+1271->1616, 322:+762->1107, 324:+877->1222, 325:+1052->1397, 327:+1082->1427, 340:+1237->1582, 358:+1116->1461, 362:+1174->1519, 370:+1406->1751, 375:+2087->2432, 389:+1484->1829, 391:+1712->2057, 392:+1778->2123, 401:+1910->2255, 404:+1844->2189, 513:+1940->2285, 514:+2018->2363, 792:+2569->2914, 1024:+1522->1867, 1297:+1339->1684, 1302:+2120->2465, 1313:+2178->2523, 1317:+2243->2588, 1348:+2692->3037, 1349:+2790->3135, 1352:+2909->3254
    //   645: daload
    //   646: astore 47
    //   648: lload 37
    //   650: lstore 43
    //   652: lload 35
    //   654: lstore 37
    //   656: lload 43
    //   658: lstore 35
    //   660: aload 47
    //   662: ifnull +2959 -> 3621
    //   665: aload 51
    //   667: aload 47
    //   669: invokevirtual 195	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   672: pop
    //   673: aload 47
    //   675: arraylength
    //   676: iload 31
    //   678: iadd
    //   679: istore 31
    //   681: iload 32
    //   683: iconst_1
    //   684: iadd
    //   685: istore 32
    //   687: lload 37
    //   689: lstore 43
    //   691: lload 35
    //   693: lstore 37
    //   695: lload 43
    //   697: lstore 35
    //   699: goto -379 -> 320
    //   702: new 197	oicq/wlogin_sdk/tlv_type/tlv_t18
    //   705: dup
    //   706: invokespecial 198	oicq/wlogin_sdk/tlv_type/tlv_t18:<init>	()V
    //   709: lload_1
    //   710: iload 5
    //   712: lload 6
    //   714: iload 8
    //   716: invokevirtual 202	oicq/wlogin_sdk/tlv_type/tlv_t18:get_tlv_18	(JIJI)[B
    //   719: astore 47
    //   721: lload 35
    //   723: lstore 43
    //   725: lload 37
    //   727: lstore 35
    //   729: lload 43
    //   731: lstore 37
    //   733: goto -73 -> 660
    //   736: new 204	oicq/wlogin_sdk/tlv_type/tlv_t1
    //   739: dup
    //   740: invokespecial 205	oicq/wlogin_sdk/tlv_type/tlv_t1:<init>	()V
    //   743: lload 6
    //   745: aload 9
    //   747: invokevirtual 209	oicq/wlogin_sdk/tlv_type/tlv_t1:get_tlv_1	(J[B)[B
    //   750: astore 47
    //   752: lload 35
    //   754: lstore 43
    //   756: lload 37
    //   758: lstore 35
    //   760: lload 43
    //   762: lstore 37
    //   764: goto -104 -> 660
    //   767: new 211	oicq/wlogin_sdk/tlv_type/tlv_t106
    //   770: dup
    //   771: invokespecial 212	oicq/wlogin_sdk/tlv_type/tlv_t106:<init>	()V
    //   774: astore 47
    //   776: aload 14
    //   778: ifnull +41 -> 819
    //   781: aload 14
    //   783: arraylength
    //   784: ifle +35 -> 819
    //   787: aload 47
    //   789: aload 14
    //   791: aload 14
    //   793: arraylength
    //   794: invokevirtual 216	oicq/wlogin_sdk/tlv_type/tlv_t106:set_data	([BI)V
    //   797: aload 47
    //   799: invokevirtual 219	oicq/wlogin_sdk/tlv_type/tlv_t106:get_buf	()[B
    //   802: astore 47
    //   804: lload 35
    //   806: lstore 43
    //   808: lload 37
    //   810: lstore 35
    //   812: lload 43
    //   814: lstore 37
    //   816: goto -156 -> 660
    //   819: aload 47
    //   821: lload_1
    //   822: lload_3
    //   823: iload 5
    //   825: lload 6
    //   827: aload 10
    //   829: aload 9
    //   831: iconst_1
    //   832: aload 11
    //   834: aload 53
    //   836: getfield 222	oicq/wlogin_sdk/request/async_context:_msalt	J
    //   839: aload_0
    //   840: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   843: getfield 225	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   846: invokevirtual 228	java/lang/String:getBytes	()[B
    //   849: aload 12
    //   851: getstatic 231	oicq/wlogin_sdk/request/t:W	I
    //   854: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   857: iload 13
    //   859: invokevirtual 238	oicq/wlogin_sdk/tlv_type/tlv_t106:get_tlv_106	(JJIJ[B[BI[BJ[B[BI[BI)[B
    //   862: astore 47
    //   864: lload 35
    //   866: lstore 43
    //   868: lload 37
    //   870: lstore 35
    //   872: lload 43
    //   874: lstore 37
    //   876: goto -216 -> 660
    //   879: new 240	oicq/wlogin_sdk/tlv_type/tlv_t116
    //   882: dup
    //   883: invokespecial 241	oicq/wlogin_sdk/tlv_type/tlv_t116:<init>	()V
    //   886: iload 16
    //   888: iload 17
    //   890: aload 18
    //   892: invokevirtual 245	oicq/wlogin_sdk/tlv_type/tlv_t116:get_tlv_116	(II[J)[B
    //   895: astore 47
    //   897: lload 35
    //   899: lstore 43
    //   901: lload 37
    //   903: lstore 35
    //   905: lload 43
    //   907: lstore 37
    //   909: goto -249 -> 660
    //   912: new 247	oicq/wlogin_sdk/tlv_type/tlv_t100
    //   915: dup
    //   916: invokespecial 248	oicq/wlogin_sdk/tlv_type/tlv_t100:<init>	()V
    //   919: lload_1
    //   920: lload 20
    //   922: iload 5
    //   924: iload 19
    //   926: invokevirtual 252	oicq/wlogin_sdk/tlv_type/tlv_t100:get_tlv_100	(JJII)[B
    //   929: astore 47
    //   931: lload 35
    //   933: lstore 43
    //   935: lload 37
    //   937: lstore 35
    //   939: lload 43
    //   941: lstore 37
    //   943: goto -283 -> 660
    //   946: new 254	oicq/wlogin_sdk/tlv_type/tlv_t107
    //   949: dup
    //   950: invokespecial 255	oicq/wlogin_sdk/tlv_type/tlv_t107:<init>	()V
    //   953: iload 22
    //   955: iload 23
    //   957: iload 24
    //   959: iload 25
    //   961: invokevirtual 259	oicq/wlogin_sdk/tlv_type/tlv_t107:get_tlv_107	(IIII)[B
    //   964: astore 47
    //   966: lload 35
    //   968: lstore 43
    //   970: lload 37
    //   972: lstore 35
    //   974: lload 43
    //   976: lstore 37
    //   978: goto -318 -> 660
    //   981: aload 49
    //   983: astore 47
    //   985: aload 26
    //   987: ifnull -339 -> 648
    //   990: aload 26
    //   992: arraylength
    //   993: ifne +22 -> 1015
    //   996: lload 35
    //   998: lstore 43
    //   1000: aload 50
    //   1002: astore 47
    //   1004: lload 37
    //   1006: lstore 35
    //   1008: lload 43
    //   1010: lstore 37
    //   1012: goto -352 -> 660
    //   1015: new 261	oicq/wlogin_sdk/tlv_type/tlv_t108
    //   1018: dup
    //   1019: invokespecial 262	oicq/wlogin_sdk/tlv_type/tlv_t108:<init>	()V
    //   1022: aload 26
    //   1024: invokevirtual 265	oicq/wlogin_sdk/tlv_type/tlv_t108:get_tlv_108	([B)[B
    //   1027: astore 47
    //   1029: lload 35
    //   1031: lstore 43
    //   1033: lload 37
    //   1035: lstore 35
    //   1037: lload 43
    //   1039: lstore 37
    //   1041: goto -381 -> 660
    //   1044: aload 49
    //   1046: astore 47
    //   1048: aload 27
    //   1050: ifnull -402 -> 648
    //   1053: aload 27
    //   1055: arraylength
    //   1056: ifne +22 -> 1078
    //   1059: lload 35
    //   1061: lstore 43
    //   1063: aload 50
    //   1065: astore 47
    //   1067: lload 37
    //   1069: lstore 35
    //   1071: lload 43
    //   1073: lstore 37
    //   1075: goto -415 -> 660
    //   1078: new 81	oicq/wlogin_sdk/tlv_type/tlv_t104
    //   1081: dup
    //   1082: invokespecial 82	oicq/wlogin_sdk/tlv_type/tlv_t104:<init>	()V
    //   1085: aload 27
    //   1087: invokevirtual 268	oicq/wlogin_sdk/tlv_type/tlv_t104:get_tlv_104	([B)[B
    //   1090: astore 47
    //   1092: lload 35
    //   1094: lstore 43
    //   1096: lload 37
    //   1098: lstore 35
    //   1100: lload 43
    //   1102: lstore 37
    //   1104: goto -444 -> 660
    //   1107: new 270	oicq/wlogin_sdk/tlv_type/tlv_t142
    //   1110: dup
    //   1111: invokespecial 271	oicq/wlogin_sdk/tlv_type/tlv_t142:<init>	()V
    //   1114: aload 28
    //   1116: invokevirtual 274	oicq/wlogin_sdk/tlv_type/tlv_t142:get_tlv_142	([B)[B
    //   1119: astore 47
    //   1121: lload 35
    //   1123: lstore 43
    //   1125: lload 37
    //   1127: lstore 35
    //   1129: lload 43
    //   1131: lstore 37
    //   1133: goto -473 -> 660
    //   1136: aload 49
    //   1138: astore 47
    //   1140: aload_0
    //   1141: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1144: getfield 225	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1147: ifnull -499 -> 648
    //   1150: aload_0
    //   1151: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1154: getfield 225	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1157: invokestatic 278	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1160: invokevirtual 284	java/lang/Boolean:booleanValue	()Z
    //   1163: ifeq +22 -> 1185
    //   1166: lload 35
    //   1168: lstore 43
    //   1170: aload 50
    //   1172: astore 47
    //   1174: lload 37
    //   1176: lstore 35
    //   1178: lload 43
    //   1180: lstore 37
    //   1182: goto -522 -> 660
    //   1185: new 286	oicq/wlogin_sdk/tlv_type/tlv_t112
    //   1188: dup
    //   1189: invokespecial 287	oicq/wlogin_sdk/tlv_type/tlv_t112:<init>	()V
    //   1192: aload_0
    //   1193: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1196: getfield 225	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1199: invokevirtual 228	java/lang/String:getBytes	()[B
    //   1202: invokevirtual 290	oicq/wlogin_sdk/tlv_type/tlv_t112:get_tlv_112	([B)[B
    //   1205: astore 47
    //   1207: lload 35
    //   1209: lstore 43
    //   1211: lload 37
    //   1213: lstore 35
    //   1215: lload 43
    //   1217: lstore 37
    //   1219: goto -559 -> 660
    //   1222: new 292	oicq/wlogin_sdk/tlv_type/tlv_t109
    //   1225: dup
    //   1226: invokespecial 293	oicq/wlogin_sdk/tlv_type/tlv_t109:<init>	()V
    //   1229: getstatic 296	oicq/wlogin_sdk/request/t:P	[B
    //   1232: invokevirtual 299	oicq/wlogin_sdk/tlv_type/tlv_t109:get_tlv_109	([B)[B
    //   1235: astore 47
    //   1237: new 301	oicq/wlogin_sdk/tlv_type/tlv_t52d
    //   1240: dup
    //   1241: invokespecial 302	oicq/wlogin_sdk/tlv_type/tlv_t52d:<init>	()V
    //   1244: aload_0
    //   1245: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   1248: invokevirtual 306	oicq/wlogin_sdk/tlv_type/tlv_t52d:get_tlv_52d	(Landroid/content/Context;)[B
    //   1251: astore 48
    //   1253: new 308	oicq/wlogin_sdk/tlv_type/tlv_t124
    //   1256: dup
    //   1257: invokespecial 309	oicq/wlogin_sdk/tlv_type/tlv_t124:<init>	()V
    //   1260: astore 49
    //   1262: invokestatic 312	oicq/wlogin_sdk/tools/util:get_os_type	()[B
    //   1265: astore 50
    //   1267: invokestatic 315	oicq/wlogin_sdk/tools/util:get_os_version	()[B
    //   1270: astore 54
    //   1272: getstatic 318	oicq/wlogin_sdk/request/t:E	I
    //   1275: istore 33
    //   1277: getstatic 321	oicq/wlogin_sdk/request/t:D	[B
    //   1280: astore 55
    //   1282: getstatic 324	oicq/wlogin_sdk/request/t:G	[B
    //   1285: astore 56
    //   1287: aload 49
    //   1289: aload 50
    //   1291: aload 54
    //   1293: iload 33
    //   1295: aload 55
    //   1297: iconst_0
    //   1298: newarray byte
    //   1300: aload 56
    //   1302: invokevirtual 328	oicq/wlogin_sdk/tlv_type/tlv_t124:get_tlv_124	([B[BI[B[B[B)[B
    //   1305: astore 49
    //   1307: new 330	oicq/wlogin_sdk/tlv_type/tlv_t128
    //   1310: dup
    //   1311: invokespecial 331	oicq/wlogin_sdk/tlv_type/tlv_t128:<init>	()V
    //   1314: getstatic 334	oicq/wlogin_sdk/request/t:V	I
    //   1317: getstatic 231	oicq/wlogin_sdk/request/t:W	I
    //   1320: getstatic 337	oicq/wlogin_sdk/request/t:X	I
    //   1323: getstatic 340	oicq/wlogin_sdk/request/t:aa	I
    //   1326: getstatic 342	oicq/wlogin_sdk/request/t:J	[B
    //   1329: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   1332: getstatic 345	oicq/wlogin_sdk/request/t:Q	[B
    //   1335: invokevirtual 349	oicq/wlogin_sdk/tlv_type/tlv_t128:get_tlv_128	(IIII[B[B[B)[B
    //   1338: astore 50
    //   1340: new 351	oicq/wlogin_sdk/tlv_type/tlv_t16e
    //   1343: dup
    //   1344: invokespecial 352	oicq/wlogin_sdk/tlv_type/tlv_t16e:<init>	()V
    //   1347: getstatic 342	oicq/wlogin_sdk/request/t:J	[B
    //   1350: invokevirtual 355	oicq/wlogin_sdk/tlv_type/tlv_t16e:get_tlv_16e	([B)[B
    //   1353: astore 54
    //   1355: new 357	oicq/wlogin_sdk/tlv_type/tlv_t144
    //   1358: dup
    //   1359: invokespecial 358	oicq/wlogin_sdk/tlv_type/tlv_t144:<init>	()V
    //   1362: aload 47
    //   1364: aload 48
    //   1366: aload 49
    //   1368: aload 50
    //   1370: aload 54
    //   1372: aload 53
    //   1374: getfield 75	oicq/wlogin_sdk/request/async_context:_tgtgt_key	[B
    //   1377: invokevirtual 362	oicq/wlogin_sdk/tlv_type/tlv_t144:get_tlv_144	([B[B[B[B[B[B)[B
    //   1380: astore 47
    //   1382: lload 35
    //   1384: lstore 43
    //   1386: lload 37
    //   1388: lstore 35
    //   1390: lload 43
    //   1392: lstore 37
    //   1394: goto -734 -> 660
    //   1397: new 364	oicq/wlogin_sdk/tlv_type/tlv_t145
    //   1400: dup
    //   1401: invokespecial 365	oicq/wlogin_sdk/tlv_type/tlv_t145:<init>	()V
    //   1404: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   1407: invokevirtual 368	oicq/wlogin_sdk/tlv_type/tlv_t145:get_tlv_145	([B)[B
    //   1410: astore 47
    //   1412: lload 35
    //   1414: lstore 43
    //   1416: lload 37
    //   1418: lstore 35
    //   1420: lload 43
    //   1422: lstore 37
    //   1424: goto -764 -> 660
    //   1427: new 370	oicq/wlogin_sdk/tlv_type/tlv_t147
    //   1430: dup
    //   1431: invokespecial 371	oicq/wlogin_sdk/tlv_type/tlv_t147:<init>	()V
    //   1434: lload_1
    //   1435: getstatic 374	oicq/wlogin_sdk/request/t:H	[B
    //   1438: getstatic 376	oicq/wlogin_sdk/request/t:I	[B
    //   1441: invokevirtual 380	oicq/wlogin_sdk/tlv_type/tlv_t147:get_tlv_147	(J[B[B)[B
    //   1444: astore 47
    //   1446: lload 35
    //   1448: lstore 43
    //   1450: lload 37
    //   1452: lstore 35
    //   1454: lload 43
    //   1456: lstore 37
    //   1458: goto -798 -> 660
    //   1461: iload 16
    //   1463: sipush 128
    //   1466: iand
    //   1467: ifne +22 -> 1489
    //   1470: lload 35
    //   1472: lstore 43
    //   1474: aload 50
    //   1476: astore 47
    //   1478: lload 37
    //   1480: lstore 35
    //   1482: lload 43
    //   1484: lstore 37
    //   1486: goto -826 -> 660
    //   1489: new 382	oicq/wlogin_sdk/tlv_type/tlv_t166
    //   1492: dup
    //   1493: invokespecial 383	oicq/wlogin_sdk/tlv_type/tlv_t166:<init>	()V
    //   1496: getstatic 385	oicq/wlogin_sdk/request/t:y	I
    //   1499: invokevirtual 389	oicq/wlogin_sdk/tlv_type/tlv_t166:get_tlv_166	(I)[B
    //   1502: astore 47
    //   1504: lload 35
    //   1506: lstore 43
    //   1508: lload 37
    //   1510: lstore 35
    //   1512: lload 43
    //   1514: lstore 37
    //   1516: goto -856 -> 660
    //   1519: aload 49
    //   1521: astore 47
    //   1523: aload 15
    //   1525: ifnull -877 -> 648
    //   1528: aload 15
    //   1530: arraylength
    //   1531: ifne +22 -> 1553
    //   1534: lload 35
    //   1536: lstore 43
    //   1538: aload 50
    //   1540: astore 47
    //   1542: lload 37
    //   1544: lstore 35
    //   1546: lload 43
    //   1548: lstore 37
    //   1550: goto -890 -> 660
    //   1553: new 391	oicq/wlogin_sdk/tlv_type/tlv_t16a
    //   1556: dup
    //   1557: invokespecial 392	oicq/wlogin_sdk/tlv_type/tlv_t16a:<init>	()V
    //   1560: aload 15
    //   1562: invokevirtual 395	oicq/wlogin_sdk/tlv_type/tlv_t16a:get_tlv_16a	([B)[B
    //   1565: astore 47
    //   1567: lload 35
    //   1569: lstore 43
    //   1571: lload 37
    //   1573: lstore 35
    //   1575: lload 43
    //   1577: lstore 37
    //   1579: goto -919 -> 660
    //   1582: new 397	oicq/wlogin_sdk/tlv_type/tlv_t154
    //   1585: dup
    //   1586: invokespecial 398	oicq/wlogin_sdk/tlv_type/tlv_t154:<init>	()V
    //   1589: aload_0
    //   1590: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1593: getfield 399	oicq/wlogin_sdk/request/t:i	I
    //   1596: invokevirtual 402	oicq/wlogin_sdk/tlv_type/tlv_t154:get_tlv_154	(I)[B
    //   1599: astore 47
    //   1601: lload 35
    //   1603: lstore 43
    //   1605: lload 37
    //   1607: lstore 35
    //   1609: lload 43
    //   1611: lstore 37
    //   1613: goto -953 -> 660
    //   1616: new 404	oicq/wlogin_sdk/tlv_type/tlv_t141
    //   1619: dup
    //   1620: invokespecial 405	oicq/wlogin_sdk/tlv_type/tlv_t141:<init>	()V
    //   1623: getstatic 321	oicq/wlogin_sdk/request/t:D	[B
    //   1626: getstatic 318	oicq/wlogin_sdk/request/t:E	I
    //   1629: getstatic 324	oicq/wlogin_sdk/request/t:G	[B
    //   1632: invokevirtual 409	oicq/wlogin_sdk/tlv_type/tlv_t141:get_tlv_141	([BI[B)[B
    //   1635: astore 47
    //   1637: lload 35
    //   1639: lstore 43
    //   1641: lload 37
    //   1643: lstore 35
    //   1645: lload 43
    //   1647: lstore 37
    //   1649: goto -989 -> 660
    //   1652: new 411	oicq/wlogin_sdk/tlv_type/tlv_t8
    //   1655: dup
    //   1656: invokespecial 412	oicq/wlogin_sdk/tlv_type/tlv_t8:<init>	()V
    //   1659: iconst_0
    //   1660: getstatic 414	oicq/wlogin_sdk/request/t:v	I
    //   1663: iconst_0
    //   1664: invokevirtual 418	oicq/wlogin_sdk/tlv_type/tlv_t8:get_tlv_8	(III)[B
    //   1667: astore 47
    //   1669: lload 35
    //   1671: lstore 43
    //   1673: lload 37
    //   1675: lstore 35
    //   1677: lload 43
    //   1679: lstore 37
    //   1681: goto -1021 -> 660
    //   1684: aload 49
    //   1686: astore 47
    //   1688: aload 29
    //   1690: ifnull -1042 -> 648
    //   1693: aload 29
    //   1695: invokeinterface 423 1 0
    //   1700: ifne +22 -> 1722
    //   1703: lload 35
    //   1705: lstore 43
    //   1707: aload 50
    //   1709: astore 47
    //   1711: lload 37
    //   1713: lstore 35
    //   1715: lload 43
    //   1717: lstore 37
    //   1719: goto -1059 -> 660
    //   1722: new 425	oicq/wlogin_sdk/tlv_type/tlv_t511
    //   1725: dup
    //   1726: invokespecial 426	oicq/wlogin_sdk/tlv_type/tlv_t511:<init>	()V
    //   1729: aload 29
    //   1731: invokevirtual 430	oicq/wlogin_sdk/tlv_type/tlv_t511:get_tlv_511	(Ljava/util/List;)[B
    //   1734: astore 47
    //   1736: lload 35
    //   1738: lstore 43
    //   1740: lload 37
    //   1742: lstore 35
    //   1744: lload 43
    //   1746: lstore 37
    //   1748: goto -1088 -> 660
    //   1751: aload 49
    //   1753: astore 47
    //   1755: aload_0
    //   1756: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1759: getfield 433	oicq/wlogin_sdk/request/t:s	[B
    //   1762: ifnull -1114 -> 648
    //   1765: aload_0
    //   1766: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1769: getfield 433	oicq/wlogin_sdk/request/t:s	[B
    //   1772: arraylength
    //   1773: ifne +22 -> 1795
    //   1776: lload 35
    //   1778: lstore 43
    //   1780: aload 50
    //   1782: astore 47
    //   1784: lload 37
    //   1786: lstore 35
    //   1788: lload 43
    //   1790: lstore 37
    //   1792: goto -1132 -> 660
    //   1795: new 435	oicq/wlogin_sdk/tlv_type/tlv_t172
    //   1798: dup
    //   1799: invokespecial 436	oicq/wlogin_sdk/tlv_type/tlv_t172:<init>	()V
    //   1802: aload_0
    //   1803: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1806: getfield 433	oicq/wlogin_sdk/request/t:s	[B
    //   1809: invokevirtual 439	oicq/wlogin_sdk/tlv_type/tlv_t172:get_tlv_172	([B)[B
    //   1812: astore 47
    //   1814: lload 35
    //   1816: lstore 43
    //   1818: lload 37
    //   1820: lstore 35
    //   1822: lload 43
    //   1824: lstore 37
    //   1826: goto -1166 -> 660
    //   1829: aload 49
    //   1831: astore 47
    //   1833: iload 13
    //   1835: iconst_3
    //   1836: if_icmpne -1188 -> 648
    //   1839: new 441	oicq/wlogin_sdk/tlv_type/tlv_t185
    //   1842: dup
    //   1843: invokespecial 442	oicq/wlogin_sdk/tlv_type/tlv_t185:<init>	()V
    //   1846: iconst_1
    //   1847: invokevirtual 445	oicq/wlogin_sdk/tlv_type/tlv_t185:get_tlv_185	(I)[B
    //   1850: astore 47
    //   1852: lload 35
    //   1854: lstore 43
    //   1856: lload 37
    //   1858: lstore 35
    //   1860: lload 43
    //   1862: lstore 37
    //   1864: goto -1204 -> 660
    //   1867: aload_0
    //   1868: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1871: lload 6
    //   1873: lload_1
    //   1874: invokevirtual 448	oicq/wlogin_sdk/request/t:a	(JJ)Loicq/wlogin_sdk/sharemem/WloginSigInfo;
    //   1877: astore 48
    //   1879: aload 49
    //   1881: astore 47
    //   1883: aload 48
    //   1885: ifnull -1237 -> 648
    //   1888: aload 49
    //   1890: astore 47
    //   1892: aload 48
    //   1894: getfield 453	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1897: ifnull -1249 -> 648
    //   1900: aload 48
    //   1902: getfield 453	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1905: arraylength
    //   1906: ifne +22 -> 1928
    //   1909: lload 35
    //   1911: lstore 43
    //   1913: aload 50
    //   1915: astore 47
    //   1917: lload 37
    //   1919: lstore 35
    //   1921: lload 43
    //   1923: lstore 37
    //   1925: goto -1265 -> 660
    //   1928: aload 49
    //   1930: astore 47
    //   1932: aload 48
    //   1934: getfield 456	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1937: ifnull -1289 -> 648
    //   1940: aload 48
    //   1942: getfield 456	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1945: arraylength
    //   1946: ifne +22 -> 1968
    //   1949: lload 35
    //   1951: lstore 43
    //   1953: aload 50
    //   1955: astore 47
    //   1957: lload 37
    //   1959: lstore 35
    //   1961: lload 43
    //   1963: lstore 37
    //   1965: goto -1305 -> 660
    //   1968: aload 49
    //   1970: astore 47
    //   1972: aload 48
    //   1974: getfield 459	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1977: ifnull -1329 -> 648
    //   1980: aload 48
    //   1982: getfield 459	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   1985: arraylength
    //   1986: ifne +22 -> 2008
    //   1989: lload 35
    //   1991: lstore 43
    //   1993: aload 50
    //   1995: astore 47
    //   1997: lload 37
    //   1999: lstore 35
    //   2001: lload 43
    //   2003: lstore 37
    //   2005: goto -1345 -> 660
    //   2008: new 461	oicq/wlogin_sdk/tlv_type/tlv_t400
    //   2011: dup
    //   2012: invokespecial 462	oicq/wlogin_sdk/tlv_type/tlv_t400:<init>	()V
    //   2015: aload 48
    //   2017: getfield 453	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   2020: lload 6
    //   2022: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   2025: aload 48
    //   2027: getfield 456	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   2030: lload_1
    //   2031: lload_3
    //   2032: aload 48
    //   2034: getfield 459	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   2037: invokevirtual 466	oicq/wlogin_sdk/tlv_type/tlv_t400:get_tlv_400	([BJ[B[BJJ[B)[B
    //   2040: astore 47
    //   2042: lload 35
    //   2044: lstore 43
    //   2046: lload 37
    //   2048: lstore 35
    //   2050: lload 43
    //   2052: lstore 37
    //   2054: goto -1394 -> 660
    //   2057: aload 49
    //   2059: astore 47
    //   2061: getstatic 469	oicq/wlogin_sdk/request/t:O	[B
    //   2064: ifnull -1416 -> 648
    //   2067: getstatic 469	oicq/wlogin_sdk/request/t:O	[B
    //   2070: arraylength
    //   2071: ifne +22 -> 2093
    //   2074: lload 35
    //   2076: lstore 43
    //   2078: aload 50
    //   2080: astore 47
    //   2082: lload 37
    //   2084: lstore 35
    //   2086: lload 43
    //   2088: lstore 37
    //   2090: goto -1430 -> 660
    //   2093: new 471	oicq/wlogin_sdk/tlv_type/tlv_t187
    //   2096: dup
    //   2097: invokespecial 472	oicq/wlogin_sdk/tlv_type/tlv_t187:<init>	()V
    //   2100: getstatic 469	oicq/wlogin_sdk/request/t:O	[B
    //   2103: invokevirtual 475	oicq/wlogin_sdk/tlv_type/tlv_t187:get_tlv_187	([B)[B
    //   2106: astore 47
    //   2108: lload 35
    //   2110: lstore 43
    //   2112: lload 37
    //   2114: lstore 35
    //   2116: lload 43
    //   2118: lstore 37
    //   2120: goto -1460 -> 660
    //   2123: aload 49
    //   2125: astore 47
    //   2127: getstatic 296	oicq/wlogin_sdk/request/t:P	[B
    //   2130: ifnull -1482 -> 648
    //   2133: getstatic 296	oicq/wlogin_sdk/request/t:P	[B
    //   2136: arraylength
    //   2137: ifne +22 -> 2159
    //   2140: lload 35
    //   2142: lstore 43
    //   2144: aload 50
    //   2146: astore 47
    //   2148: lload 37
    //   2150: lstore 35
    //   2152: lload 43
    //   2154: lstore 37
    //   2156: goto -1496 -> 660
    //   2159: new 477	oicq/wlogin_sdk/tlv_type/tlv_t188
    //   2162: dup
    //   2163: invokespecial 478	oicq/wlogin_sdk/tlv_type/tlv_t188:<init>	()V
    //   2166: getstatic 296	oicq/wlogin_sdk/request/t:P	[B
    //   2169: invokevirtual 481	oicq/wlogin_sdk/tlv_type/tlv_t188:get_tlv_188	([B)[B
    //   2172: astore 47
    //   2174: lload 35
    //   2176: lstore 43
    //   2178: lload 37
    //   2180: lstore 35
    //   2182: lload 43
    //   2184: lstore 37
    //   2186: goto -1526 -> 660
    //   2189: aload 49
    //   2191: astore 47
    //   2193: getstatic 482	oicq/wlogin_sdk/request/t:M	[B
    //   2196: ifnull -1548 -> 648
    //   2199: getstatic 482	oicq/wlogin_sdk/request/t:M	[B
    //   2202: arraylength
    //   2203: ifne +22 -> 2225
    //   2206: lload 35
    //   2208: lstore 43
    //   2210: aload 50
    //   2212: astore 47
    //   2214: lload 37
    //   2216: lstore 35
    //   2218: lload 43
    //   2220: lstore 37
    //   2222: goto -1562 -> 660
    //   2225: new 484	oicq/wlogin_sdk/tlv_type/tlv_t194
    //   2228: dup
    //   2229: invokespecial 485	oicq/wlogin_sdk/tlv_type/tlv_t194:<init>	()V
    //   2232: getstatic 482	oicq/wlogin_sdk/request/t:M	[B
    //   2235: invokevirtual 488	oicq/wlogin_sdk/tlv_type/tlv_t194:get_tlv_194	([B)[B
    //   2238: astore 47
    //   2240: lload 35
    //   2242: lstore 43
    //   2244: lload 37
    //   2246: lstore 35
    //   2248: lload 43
    //   2250: lstore 37
    //   2252: goto -1592 -> 660
    //   2255: new 490	oicq/wlogin_sdk/tlv_type/tlv_t191
    //   2258: dup
    //   2259: invokespecial 491	oicq/wlogin_sdk/tlv_type/tlv_t191:<init>	()V
    //   2262: getstatic 14	oicq/wlogin_sdk/request/k:K	I
    //   2265: invokevirtual 494	oicq/wlogin_sdk/tlv_type/tlv_t191:get_tlv_191	(I)[B
    //   2268: astore 47
    //   2270: lload 35
    //   2272: lstore 43
    //   2274: lload 37
    //   2276: lstore 35
    //   2278: lload 43
    //   2280: lstore 37
    //   2282: goto -1622 -> 660
    //   2285: aload 49
    //   2287: astore 47
    //   2289: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2292: ifnull -1644 -> 648
    //   2295: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2298: arraylength
    //   2299: ifne +22 -> 2321
    //   2302: lload 35
    //   2304: lstore 43
    //   2306: aload 50
    //   2308: astore 47
    //   2310: lload 37
    //   2312: lstore 35
    //   2314: lload 43
    //   2316: lstore 37
    //   2318: goto -1658 -> 660
    //   2321: new 496	oicq/wlogin_sdk/tlv_type/tlv_t201
    //   2324: dup
    //   2325: invokespecial 497	oicq/wlogin_sdk/tlv_type/tlv_t201:<init>	()V
    //   2328: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2331: getstatic 18	oicq/wlogin_sdk/request/k:M	[B
    //   2334: ldc_w 499
    //   2337: invokevirtual 228	java/lang/String:getBytes	()[B
    //   2340: getstatic 20	oicq/wlogin_sdk/request/k:N	[B
    //   2343: invokevirtual 503	oicq/wlogin_sdk/tlv_type/tlv_t201:get_tlv_201	([B[B[B[B)[B
    //   2346: astore 47
    //   2348: lload 35
    //   2350: lstore 43
    //   2352: lload 37
    //   2354: lstore 35
    //   2356: lload 43
    //   2358: lstore 37
    //   2360: goto -1700 -> 660
    //   2363: aload 49
    //   2365: astore 47
    //   2367: getstatic 506	oicq/wlogin_sdk/request/t:S	[B
    //   2370: ifnull -1722 -> 648
    //   2373: getstatic 506	oicq/wlogin_sdk/request/t:S	[B
    //   2376: arraylength
    //   2377: ifne +22 -> 2399
    //   2380: lload 35
    //   2382: lstore 43
    //   2384: aload 50
    //   2386: astore 47
    //   2388: lload 37
    //   2390: lstore 35
    //   2392: lload 43
    //   2394: lstore 37
    //   2396: goto -1736 -> 660
    //   2399: new 508	oicq/wlogin_sdk/tlv_type/tlv_t202
    //   2402: dup
    //   2403: invokespecial 509	oicq/wlogin_sdk/tlv_type/tlv_t202:<init>	()V
    //   2406: getstatic 506	oicq/wlogin_sdk/request/t:S	[B
    //   2409: getstatic 512	oicq/wlogin_sdk/request/t:T	[B
    //   2412: invokevirtual 516	oicq/wlogin_sdk/tlv_type/tlv_t202:get_tlv_202	([B[B)[B
    //   2415: astore 47
    //   2417: lload 35
    //   2419: lstore 43
    //   2421: lload 37
    //   2423: lstore 35
    //   2425: lload 43
    //   2427: lstore 37
    //   2429: goto -1769 -> 660
    //   2432: new 518	oicq/wlogin_sdk/tlv_type/tlv_t177
    //   2435: dup
    //   2436: invokespecial 519	oicq/wlogin_sdk/tlv_type/tlv_t177:<init>	()V
    //   2439: ldc2_w 520
    //   2442: ldc_w 523
    //   2445: invokevirtual 527	oicq/wlogin_sdk/tlv_type/tlv_t177:get_tlv_177	(JLjava/lang/String;)[B
    //   2448: astore 47
    //   2450: lload 35
    //   2452: lstore 43
    //   2454: lload 37
    //   2456: lstore 35
    //   2458: lload 43
    //   2460: lstore 37
    //   2462: goto -1802 -> 660
    //   2465: new 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2468: dup
    //   2469: sipush 1302
    //   2472: invokespecial 532	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2475: astore 47
    //   2477: iconst_4
    //   2478: newarray byte
    //   2480: astore 48
    //   2482: aload 48
    //   2484: iconst_0
    //   2485: aload 30
    //   2487: getfield 535	oicq/wlogin_sdk/request/WUserSigInfo:_source_type	I
    //   2490: invokestatic 539	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   2493: aload 47
    //   2495: aload 48
    //   2497: iconst_4
    //   2498: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2501: aload 47
    //   2503: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2506: astore 47
    //   2508: lload 35
    //   2510: lstore 43
    //   2512: lload 37
    //   2514: lstore 35
    //   2516: lload 43
    //   2518: lstore 37
    //   2520: goto -1860 -> 660
    //   2523: new 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2526: dup
    //   2527: sipush 1313
    //   2530: invokespecial 532	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2533: astore 47
    //   2535: bipush 6
    //   2537: newarray byte
    //   2539: astore 48
    //   2541: aload 48
    //   2543: iconst_0
    //   2544: getstatic 544	oicq/wlogin_sdk/request/t:aA	I
    //   2547: invokestatic 539	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   2550: aload 48
    //   2552: iconst_4
    //   2553: iconst_0
    //   2554: invokestatic 547	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   2557: aload 47
    //   2559: aload 48
    //   2561: bipush 6
    //   2563: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2566: aload 47
    //   2568: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2571: astore 47
    //   2573: lload 35
    //   2575: lstore 43
    //   2577: lload 37
    //   2579: lstore 35
    //   2581: lload 43
    //   2583: lstore 37
    //   2585: goto -1925 -> 660
    //   2588: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   2591: lstore 43
    //   2593: lload 43
    //   2595: lstore 41
    //   2597: new 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2600: dup
    //   2601: sipush 1334
    //   2604: invokespecial 532	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2607: astore 47
    //   2609: aload_0
    //   2610: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   2613: invokestatic 552	com/tencent/loginsecsdk/ProtocolDet:getLoginExtraData	(Landroid/content/Context;)[B
    //   2616: astore 48
    //   2618: aload 48
    //   2620: ifnull +195 -> 2815
    //   2623: aload 48
    //   2625: arraylength
    //   2626: ifle +189 -> 2815
    //   2629: new 122	java/lang/StringBuilder
    //   2632: dup
    //   2633: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2636: ldc_w 554
    //   2639: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2642: aload 48
    //   2644: arraylength
    //   2645: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2648: ldc_w 556
    //   2651: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2654: aload 48
    //   2656: invokestatic 560	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   2659: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2662: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2665: new 122	java/lang/StringBuilder
    //   2668: dup
    //   2669: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2672: lload 6
    //   2674: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2677: ldc 140
    //   2679: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2682: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2685: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2688: aload 47
    //   2690: aload 48
    //   2692: aload 48
    //   2694: arraylength
    //   2695: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2698: aload 47
    //   2700: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2703: astore 47
    //   2705: new 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2708: dup
    //   2709: sipush 1317
    //   2712: invokespecial 532	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2715: astore 48
    //   2717: aload 47
    //   2719: arraylength
    //   2720: iconst_2
    //   2721: iadd
    //   2722: newarray byte
    //   2724: astore 49
    //   2726: aload 49
    //   2728: iconst_0
    //   2729: iconst_1
    //   2730: invokestatic 547	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   2733: aload 47
    //   2735: iconst_0
    //   2736: aload 49
    //   2738: iconst_2
    //   2739: aload 47
    //   2741: arraylength
    //   2742: invokestatic 564	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2745: aload 48
    //   2747: aload 49
    //   2749: aload 49
    //   2751: arraylength
    //   2752: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2755: aload 48
    //   2757: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2760: astore 47
    //   2762: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   2765: lstore 43
    //   2767: lload 43
    //   2769: lstore 39
    //   2771: new 122	java/lang/StringBuilder
    //   2774: dup
    //   2775: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2778: ldc_w 566
    //   2781: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2784: lload 39
    //   2786: lload 41
    //   2788: lsub
    //   2789: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2792: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2795: ldc 140
    //   2797: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2800: lload 35
    //   2802: lstore 43
    //   2804: lload 37
    //   2806: lstore 35
    //   2808: lload 43
    //   2810: lstore 37
    //   2812: goto -2152 -> 660
    //   2815: ldc_w 568
    //   2818: new 122	java/lang/StringBuilder
    //   2821: dup
    //   2822: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2825: lload 6
    //   2827: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2830: ldc 140
    //   2832: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2835: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2838: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2841: aconst_null
    //   2842: astore 47
    //   2844: goto -82 -> 2762
    //   2847: astore 48
    //   2849: aconst_null
    //   2850: astore 47
    //   2852: new 122	java/lang/StringBuilder
    //   2855: dup
    //   2856: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2859: ldc_w 570
    //   2862: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2865: aload 48
    //   2867: invokestatic 576	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2870: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2873: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2876: new 122	java/lang/StringBuilder
    //   2879: dup
    //   2880: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2883: lload 6
    //   2885: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2888: ldc 140
    //   2890: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2893: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2896: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2899: lload 35
    //   2901: lstore 43
    //   2903: lload 37
    //   2905: lstore 35
    //   2907: lload 43
    //   2909: lstore 37
    //   2911: goto -2251 -> 660
    //   2914: aload 49
    //   2916: astore 47
    //   2918: aload 53
    //   2920: getfield 579	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2923: ifnull -2275 -> 648
    //   2926: aload 49
    //   2928: astore 47
    //   2930: aload 53
    //   2932: getfield 579	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2935: arraylength
    //   2936: ifeq -2288 -> 648
    //   2939: new 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2942: dup
    //   2943: sipush 792
    //   2946: invokespecial 532	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2949: astore 47
    //   2951: aload 47
    //   2953: aload 53
    //   2955: getfield 579	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2958: aload 53
    //   2960: getfield 579	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2963: arraylength
    //   2964: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2967: aload 47
    //   2969: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2972: astore 47
    //   2974: new 122	java/lang/StringBuilder
    //   2977: dup
    //   2978: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   2981: ldc_w 581
    //   2984: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2987: aload 53
    //   2989: getfield 579	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2992: arraylength
    //   2993: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2996: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2999: new 122	java/lang/StringBuilder
    //   3002: dup
    //   3003: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3006: ldc 140
    //   3008: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3011: lload 6
    //   3013: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3016: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3019: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3022: lload 35
    //   3024: lstore 43
    //   3026: lload 37
    //   3028: lstore 35
    //   3030: lload 43
    //   3032: lstore 37
    //   3034: goto -2374 -> 660
    //   3037: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   3040: lstore 37
    //   3042: new 583	oicq/wlogin_sdk/tlv_type/tlv_t544
    //   3045: dup
    //   3046: invokespecial 584	oicq/wlogin_sdk/tlv_type/tlv_t544:<init>	()V
    //   3049: aload_0
    //   3050: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   3053: lload 6
    //   3055: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   3058: arraylength
    //   3059: getstatic 234	oicq/wlogin_sdk/request/t:B	[B
    //   3062: ldc_w 523
    //   3065: invokevirtual 587	java/lang/String:length	()I
    //   3068: ldc_w 523
    //   3071: aload_0
    //   3072: getfield 31	oicq/wlogin_sdk/request/k:u	I
    //   3075: invokevirtual 591	oicq/wlogin_sdk/tlv_type/tlv_t544:get_tlv_544	(Landroid/content/Context;JI[BILjava/lang/String;I)[B
    //   3078: astore 47
    //   3080: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   3083: lstore 35
    //   3085: new 122	java/lang/StringBuilder
    //   3088: dup
    //   3089: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3092: ldc_w 593
    //   3095: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3098: lload 35
    //   3100: lload 37
    //   3102: lsub
    //   3103: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3106: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3109: new 122	java/lang/StringBuilder
    //   3112: dup
    //   3113: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3116: ldc 140
    //   3118: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3121: lload 6
    //   3123: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3126: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3129: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3132: goto -2472 -> 660
    //   3135: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3138: ifnull +10 -> 3148
    //   3141: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3144: arraylength
    //   3145: ifne +12 -> 3157
    //   3148: getstatic 598	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   3151: invokestatic 601	oicq/wlogin_sdk/tools/util:get_qimei	(Landroid/content/Context;)[B
    //   3154: putstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3157: aload 49
    //   3159: astore 47
    //   3161: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3164: ifnull -2516 -> 648
    //   3167: aload 49
    //   3169: astore 47
    //   3171: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3174: arraylength
    //   3175: ifle -2527 -> 648
    //   3178: new 603	oicq/wlogin_sdk/tlv_type/tlv_t545
    //   3181: dup
    //   3182: invokespecial 604	oicq/wlogin_sdk/tlv_type/tlv_t545:<init>	()V
    //   3185: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3188: invokevirtual 607	oicq/wlogin_sdk/tlv_type/tlv_t545:get_tlv_545	([B)[B
    //   3191: astore 47
    //   3193: new 122	java/lang/StringBuilder
    //   3196: dup
    //   3197: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3200: ldc_w 609
    //   3203: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3206: getstatic 596	oicq/wlogin_sdk/request/t:U	[B
    //   3209: arraylength
    //   3210: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3213: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3216: new 122	java/lang/StringBuilder
    //   3219: dup
    //   3220: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3223: ldc 140
    //   3225: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3228: lload 6
    //   3230: invokevirtual 143	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3233: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3236: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3239: lload 35
    //   3241: lstore 43
    //   3243: lload 37
    //   3245: lstore 35
    //   3247: lload 43
    //   3249: lstore 37
    //   3251: goto -2591 -> 660
    //   3254: aload 49
    //   3256: astore 47
    //   3258: getstatic 612	oicq/wlogin_sdk/request/t:ao	[B
    //   3261: ifnull -2613 -> 648
    //   3264: aload 49
    //   3266: astore 47
    //   3268: getstatic 612	oicq/wlogin_sdk/request/t:ao	[B
    //   3271: arraylength
    //   3272: ifle -2624 -> 648
    //   3275: new 614	oicq/wlogin_sdk/tlv_type/tlv_t548
    //   3278: dup
    //   3279: invokespecial 615	oicq/wlogin_sdk/tlv_type/tlv_t548:<init>	()V
    //   3282: getstatic 612	oicq/wlogin_sdk/request/t:ao	[B
    //   3285: invokevirtual 618	oicq/wlogin_sdk/tlv_type/tlv_t548:get_tlv_548	([B)[B
    //   3288: astore 49
    //   3290: aload 48
    //   3292: astore 47
    //   3294: aload 49
    //   3296: ifnull +17 -> 3313
    //   3299: aload 48
    //   3301: astore 47
    //   3303: aload 49
    //   3305: arraylength
    //   3306: ifle +7 -> 3313
    //   3309: aload 49
    //   3311: astore 47
    //   3313: new 122	java/lang/StringBuilder
    //   3316: dup
    //   3317: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3320: ldc_w 620
    //   3323: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: astore 48
    //   3328: aload 49
    //   3330: ifnonnull +24 -> 3354
    //   3333: iconst_0
    //   3334: istore 33
    //   3336: aload 48
    //   3338: iload 33
    //   3340: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3343: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3346: ldc 140
    //   3348: invokestatic 147	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3351: goto -2703 -> 648
    //   3354: aload 49
    //   3356: arraylength
    //   3357: istore 33
    //   3359: goto -23 -> 3336
    //   3362: aload 30
    //   3364: getfield 624	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3367: invokevirtual 630	java/util/HashMap:keySet	()Ljava/util/Set;
    //   3370: invokeinterface 636 1 0
    //   3375: astore 9
    //   3377: aload 9
    //   3379: invokeinterface 641 1 0
    //   3384: ifeq +107 -> 3491
    //   3387: aload 9
    //   3389: invokeinterface 645 1 0
    //   3394: checkcast 647	java/lang/Integer
    //   3397: astore 11
    //   3399: aload 30
    //   3401: getfield 624	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3404: aload 11
    //   3406: invokevirtual 651	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3409: checkcast 529	oicq/wlogin_sdk/tlv_type/tlv_t
    //   3412: invokevirtual 541	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   3415: astore 10
    //   3417: aload 51
    //   3419: aload 10
    //   3421: invokevirtual 195	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3424: pop
    //   3425: iload 31
    //   3427: aload 10
    //   3429: arraylength
    //   3430: iadd
    //   3431: istore 31
    //   3433: new 122	java/lang/StringBuilder
    //   3436: dup
    //   3437: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   3440: ldc_w 653
    //   3443: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3446: aload 11
    //   3448: invokevirtual 656	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3451: ldc_w 658
    //   3454: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3457: astore 11
    //   3459: aload 10
    //   3461: ifnull +24 -> 3485
    //   3464: aload 10
    //   3466: arraylength
    //   3467: istore 5
    //   3469: aload 11
    //   3471: iload 5
    //   3473: invokevirtual 132	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3476: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3479: invokestatic 661	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   3482: goto -105 -> 3377
    //   3485: iconst_0
    //   3486: istore 5
    //   3488: goto -19 -> 3469
    //   3491: iload 31
    //   3493: newarray byte
    //   3495: astore 9
    //   3497: aload 51
    //   3499: invokevirtual 662	java/util/ArrayList:size	()I
    //   3502: istore 13
    //   3504: iconst_0
    //   3505: istore 8
    //   3507: iconst_0
    //   3508: istore 5
    //   3510: iload 5
    //   3512: iload 13
    //   3514: if_icmpge +45 -> 3559
    //   3517: aload 51
    //   3519: iload 5
    //   3521: invokevirtual 665	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3524: checkcast 666	[B
    //   3527: astore 10
    //   3529: aload 10
    //   3531: iconst_0
    //   3532: aload 9
    //   3534: iload 8
    //   3536: aload 10
    //   3538: arraylength
    //   3539: invokestatic 564	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3542: iload 8
    //   3544: aload 10
    //   3546: arraylength
    //   3547: iadd
    //   3548: istore 8
    //   3550: iload 5
    //   3552: iconst_1
    //   3553: iadd
    //   3554: istore 5
    //   3556: goto -46 -> 3510
    //   3559: invokestatic 191	java/lang/System:currentTimeMillis	()J
    //   3562: lstore_1
    //   3563: invokestatic 671	oicq/wlogin_sdk/report/a:a	()Loicq/wlogin_sdk/report/a;
    //   3566: iconst_1
    //   3567: lload_1
    //   3568: lload 45
    //   3570: lsub
    //   3571: lload 37
    //   3573: lload 35
    //   3575: lsub
    //   3576: lload 39
    //   3578: lload 41
    //   3580: lsub
    //   3581: invokevirtual 674	oicq/wlogin_sdk/report/a:a	(IJJJ)V
    //   3584: invokestatic 180	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3587: invokestatic 676	oicq/wlogin_sdk/report/c:b	(Ljava/lang/Thread;)V
    //   3590: aload_0
    //   3591: aload 9
    //   3593: aload_0
    //   3594: getfield 31	oicq/wlogin_sdk/request/k:u	I
    //   3597: iload 13
    //   3599: invokevirtual 679	oicq/wlogin_sdk/request/k:b	([BII)[B
    //   3602: areturn
    //   3603: astore 48
    //   3605: aconst_null
    //   3606: astore 47
    //   3608: goto -756 -> 2852
    //   3611: astore 48
    //   3613: goto -761 -> 2852
    //   3616: astore 48
    //   3618: goto -766 -> 2852
    //   3621: goto -2940 -> 681
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3624	0	this	k
    //   0	3624	1	paramLong1	long
    //   0	3624	3	paramLong2	long
    //   0	3624	5	paramInt1	int
    //   0	3624	6	paramLong3	long
    //   0	3624	8	paramInt2	int
    //   0	3624	9	paramArrayOfByte1	byte[]
    //   0	3624	10	paramArrayOfByte2	byte[]
    //   0	3624	11	paramArrayOfByte3	byte[]
    //   0	3624	12	paramArrayOfByte4	byte[]
    //   0	3624	13	paramInt3	int
    //   0	3624	14	paramArrayOfByte5	byte[]
    //   0	3624	15	paramArrayOfByte6	byte[]
    //   0	3624	16	paramInt4	int
    //   0	3624	17	paramInt5	int
    //   0	3624	18	paramArrayOfLong	long[]
    //   0	3624	19	paramInt6	int
    //   0	3624	20	paramLong4	long
    //   0	3624	22	paramInt7	int
    //   0	3624	23	paramInt8	int
    //   0	3624	24	paramInt9	int
    //   0	3624	25	paramInt10	int
    //   0	3624	26	paramArrayOfByte7	byte[]
    //   0	3624	27	paramArrayOfByte8	byte[]
    //   0	3624	28	paramArrayOfByte9	byte[]
    //   0	3624	29	paramList	java.util.List<String>
    //   0	3624	30	paramWUserSigInfo	WUserSigInfo
    //   280	3212	31	i	int
    //   318	368	32	j	int
    //   332	3026	33	k	int
    //   315	10	34	m	int
    //   301	3273	35	l1	long
    //   304	3268	37	l2	long
    //   310	3267	39	l3	long
    //   307	3272	41	l4	long
    //   650	2598	43	l5	long
    //   298	3271	45	l6	long
    //   646	2961	47	localObject1	Object
    //   338	2418	48	localObject2	Object
    //   2847	453	48	localThrowable1	java.lang.Throwable
    //   3326	11	48	localStringBuilder	java.lang.StringBuilder
    //   3603	1	48	localThrowable2	java.lang.Throwable
    //   3611	1	48	localThrowable3	java.lang.Throwable
    //   3616	1	48	localThrowable4	java.lang.Throwable
    //   341	3014	49	localObject3	Object
    //   335	2050	50	arrayOfByte1	byte[]
    //   277	3241	51	localArrayList	java.util.ArrayList
    //   4	324	52	arrayOfInt	int[]
    //   268	2720	53	localasync_context	async_context
    //   1270	101	54	arrayOfByte2	byte[]
    //   1280	16	55	arrayOfByte3	byte[]
    //   1285	16	56	arrayOfByte4	byte[]
    // Exception table:
    //   from	to	target	type
    //   2588	2593	2847	java/lang/Throwable
    //   2597	2618	3603	java/lang/Throwable
    //   2623	2762	3603	java/lang/Throwable
    //   2815	2841	3603	java/lang/Throwable
    //   2762	2767	3611	java/lang/Throwable
    //   2771	2800	3616	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */