package oicq.wlogin_sdk.request;

import android.content.Context;
import com.tencent.secprotocol.t.ReportLogHelper;
import oicq.wlogin_sdk.tlv_type.tlv_t104;
import oicq.wlogin_sdk.tools.util;

public class k
  extends oicq_request
{
  public static int K = 130;
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
    int k = t.x;
    Object localObject = t.b(this.x.h);
    ((async_context)localObject)._tgtgt_key = util.get_rand_16byte(t.C);
    byte[] arrayOfByte = ((async_context)localObject)._tgtgt_key;
    localObject = ((async_context)localObject)._t104;
    if (localObject == null) {
      localObject = new tlv_t104();
    }
    for (;;)
    {
      ReportLogHelper.startTimeTask();
      ReportLogHelper.report(7, 0);
      int i = 0;
      for (;;)
      {
        a(paramLong3, a(paramLong1, paramLong2, k, paramLong3, paramInt1, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, arrayOfByte, paramInt2, null, null, paramInt3, paramInt4, paramArrayOfLong, paramInt5, paramLong4, paramInt6, paramInt7, paramInt8, paramInt9, paramArrayOfByte4, ((tlv_t104)localObject).get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo), this.y);
        int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j != 0)
        {
          ReportLogHelper.report(7, 2);
          paramInt1 = j;
        }
        for (;;)
        {
          ReportLogHelper.report(7, 1);
          ReportLogHelper.stopTimeTask();
          return paramInt1;
          j = b();
          util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
          if (j != 180)
          {
            ReportLogHelper.report(7, 3);
            paramInt1 = j;
          }
          else
          {
            if (i < 1) {
              break;
            }
            paramInt1 = j;
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(long paramLong1, long paramLong2, long paramLong3, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt2, int paramInt3, long[] paramArrayOfLong, int paramInt4, long paramLong4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, byte[] paramArrayOfByte4, WUserSigInfo paramWUserSigInfo)
  {
    ReportLogHelper.report(6, 0);
    int k = t.x;
    tlv_t104 localtlv_t104 = t.b(this.x.h)._t104;
    if (localtlv_t104 == null) {
      localtlv_t104 = new tlv_t104();
    }
    for (;;)
    {
      paramArrayOfByte2 = c(paramArrayOfByte2);
      if (paramArrayOfByte2 == null) {
        return -1014;
      }
      int i = 0;
      for (;;)
      {
        byte[] arrayOfByte = a(paramLong1, paramLong2, k, paramLong3, paramInt1, paramArrayOfByte1, null, null, null, 0, paramArrayOfByte2, paramArrayOfByte3, paramInt2, paramInt3, paramArrayOfLong, paramInt4, paramLong4, paramInt5, paramInt6, paramInt7, paramInt8, paramArrayOfByte4, localtlv_t104.get_data(), t.F, paramWUserSigInfo._domains, paramWUserSigInfo);
        a(this.i, this.t, this.j, paramLong3, this.m, this.n, k, this.p, arrayOfByte);
        int j = a(String.valueOf(this.x.f), false, paramWUserSigInfo);
        if (j != 0)
        {
          ReportLogHelper.report(6, 2);
          paramInt1 = j;
        }
        for (;;)
        {
          ReportLogHelper.report(6, 1);
          return paramInt1;
          j = b();
          util.LOGI("retry num:" + i + " ret:" + j, "" + paramLong3);
          if (j != 180)
          {
            ReportLogHelper.report(6, 3);
            paramInt1 = j;
          }
          else
          {
            if (i < 1) {
              break;
            }
            paramInt1 = j;
          }
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
    //   4: astore 53
    //   6: aload 53
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
    //   268: astore 54
    //   270: new 183	java/util/ArrayList
    //   273: dup
    //   274: invokespecial 184	java/util/ArrayList:<init>	()V
    //   277: astore 51
    //   279: iconst_0
    //   280: istore 31
    //   282: ldc 186
    //   284: ldc 152
    //   286: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: invokestatic 192	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   292: invokestatic 197	oicq/wlogin_sdk/report/c:a	(Ljava/lang/Thread;)V
    //   295: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   298: lstore 45
    //   300: lconst_0
    //   301: lstore 35
    //   303: lconst_0
    //   304: lstore 37
    //   306: lconst_0
    //   307: lstore 41
    //   309: lconst_0
    //   310: lstore 39
    //   312: new 134	java/lang/StringBuilder
    //   315: dup
    //   316: ldc 205
    //   318: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   321: getstatic 211	oicq/wlogin_sdk/tools/util:LOG_TAG_GATEWAY_LOGIN_NEW_DOV	Ljava/lang/String;
    //   324: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: astore 52
    //   329: aload 53
    //   331: arraylength
    //   332: istore 34
    //   334: iconst_0
    //   335: istore 32
    //   337: iload 32
    //   339: iload 34
    //   341: if_icmpge +3083 -> 3424
    //   344: aload 53
    //   346: iload 32
    //   348: iaload
    //   349: istore 33
    //   351: aconst_null
    //   352: astore 50
    //   354: aconst_null
    //   355: astore 48
    //   357: aconst_null
    //   358: astore 49
    //   360: iload 33
    //   362: lookupswitch	default:+298->660, 1:+390->752, 8:+1325->1687, 24:+356->718, 256:+566->928, 260:+698->1060, 262:+421->783, 263:+600->962, 264:+635->997, 274:+790->1152, 278:+533->895, 321:+1289->1651, 322:+761->1123, 324:+895->1257, 325:+1070->1432, 327:+1100->1462, 340:+1255->1617, 358:+1134->1496, 362:+1192->1554, 370:+1424->1786, 375:+2132->2494, 389:+1502->1864, 391:+1730->2092, 392:+1796->2158, 401:+1928->2290, 404:+1862->2224, 513:+1985->2347, 514:+2063->2425, 792:+2614->2976, 1024:+1540->1902, 1297:+1357->1719, 1302:+2165->2527, 1313:+2223->2585, 1317:+2288->2650, 1348:+2737->3099, 1349:+2835->3197, 1352:+2954->3316
    //   661: daload
    //   662: astore 47
    //   664: lload 37
    //   666: lstore 43
    //   668: lload 35
    //   670: lstore 37
    //   672: lload 43
    //   674: lstore 35
    //   676: aload 47
    //   678: ifnull +3016 -> 3694
    //   681: aload 51
    //   683: aload 47
    //   685: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   688: pop
    //   689: aload 47
    //   691: arraylength
    //   692: iload 31
    //   694: iadd
    //   695: istore 31
    //   697: iload 32
    //   699: iconst_1
    //   700: iadd
    //   701: istore 32
    //   703: lload 37
    //   705: lstore 43
    //   707: lload 35
    //   709: lstore 37
    //   711: lload 43
    //   713: lstore 35
    //   715: goto -378 -> 337
    //   718: new 217	oicq/wlogin_sdk/tlv_type/tlv_t18
    //   721: dup
    //   722: invokespecial 218	oicq/wlogin_sdk/tlv_type/tlv_t18:<init>	()V
    //   725: lload_1
    //   726: iload 5
    //   728: lload 6
    //   730: iload 8
    //   732: invokevirtual 222	oicq/wlogin_sdk/tlv_type/tlv_t18:get_tlv_18	(JIJI)[B
    //   735: astore 47
    //   737: lload 35
    //   739: lstore 43
    //   741: lload 37
    //   743: lstore 35
    //   745: lload 43
    //   747: lstore 37
    //   749: goto -73 -> 676
    //   752: new 224	oicq/wlogin_sdk/tlv_type/tlv_t1
    //   755: dup
    //   756: invokespecial 225	oicq/wlogin_sdk/tlv_type/tlv_t1:<init>	()V
    //   759: lload 6
    //   761: aload 9
    //   763: invokevirtual 229	oicq/wlogin_sdk/tlv_type/tlv_t1:get_tlv_1	(J[B)[B
    //   766: astore 47
    //   768: lload 35
    //   770: lstore 43
    //   772: lload 37
    //   774: lstore 35
    //   776: lload 43
    //   778: lstore 37
    //   780: goto -104 -> 676
    //   783: new 231	oicq/wlogin_sdk/tlv_type/tlv_t106
    //   786: dup
    //   787: invokespecial 232	oicq/wlogin_sdk/tlv_type/tlv_t106:<init>	()V
    //   790: astore 47
    //   792: aload 14
    //   794: ifnull +41 -> 835
    //   797: aload 14
    //   799: arraylength
    //   800: ifle +35 -> 835
    //   803: aload 47
    //   805: aload 14
    //   807: aload 14
    //   809: arraylength
    //   810: invokevirtual 236	oicq/wlogin_sdk/tlv_type/tlv_t106:set_data	([BI)V
    //   813: aload 47
    //   815: invokevirtual 239	oicq/wlogin_sdk/tlv_type/tlv_t106:get_buf	()[B
    //   818: astore 47
    //   820: lload 35
    //   822: lstore 43
    //   824: lload 37
    //   826: lstore 35
    //   828: lload 43
    //   830: lstore 37
    //   832: goto -156 -> 676
    //   835: aload 47
    //   837: lload_1
    //   838: lload_3
    //   839: iload 5
    //   841: lload 6
    //   843: aload 10
    //   845: aload 9
    //   847: iconst_1
    //   848: aload 11
    //   850: aload 54
    //   852: getfield 242	oicq/wlogin_sdk/request/async_context:_msalt	J
    //   855: aload_0
    //   856: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   859: getfield 245	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   862: invokevirtual 248	java/lang/String:getBytes	()[B
    //   865: aload 12
    //   867: getstatic 251	oicq/wlogin_sdk/request/t:W	I
    //   870: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   873: iload 13
    //   875: invokevirtual 258	oicq/wlogin_sdk/tlv_type/tlv_t106:get_tlv_106	(JJIJ[B[BI[BJ[B[BI[BI)[B
    //   878: astore 47
    //   880: lload 35
    //   882: lstore 43
    //   884: lload 37
    //   886: lstore 35
    //   888: lload 43
    //   890: lstore 37
    //   892: goto -216 -> 676
    //   895: new 260	oicq/wlogin_sdk/tlv_type/tlv_t116
    //   898: dup
    //   899: invokespecial 261	oicq/wlogin_sdk/tlv_type/tlv_t116:<init>	()V
    //   902: iload 16
    //   904: iload 17
    //   906: aload 18
    //   908: invokevirtual 265	oicq/wlogin_sdk/tlv_type/tlv_t116:get_tlv_116	(II[J)[B
    //   911: astore 47
    //   913: lload 35
    //   915: lstore 43
    //   917: lload 37
    //   919: lstore 35
    //   921: lload 43
    //   923: lstore 37
    //   925: goto -249 -> 676
    //   928: new 267	oicq/wlogin_sdk/tlv_type/tlv_t100
    //   931: dup
    //   932: invokespecial 268	oicq/wlogin_sdk/tlv_type/tlv_t100:<init>	()V
    //   935: lload_1
    //   936: lload 20
    //   938: iload 5
    //   940: iload 19
    //   942: invokevirtual 272	oicq/wlogin_sdk/tlv_type/tlv_t100:get_tlv_100	(JJII)[B
    //   945: astore 47
    //   947: lload 35
    //   949: lstore 43
    //   951: lload 37
    //   953: lstore 35
    //   955: lload 43
    //   957: lstore 37
    //   959: goto -283 -> 676
    //   962: new 274	oicq/wlogin_sdk/tlv_type/tlv_t107
    //   965: dup
    //   966: invokespecial 275	oicq/wlogin_sdk/tlv_type/tlv_t107:<init>	()V
    //   969: iload 22
    //   971: iload 23
    //   973: iload 24
    //   975: iload 25
    //   977: invokevirtual 279	oicq/wlogin_sdk/tlv_type/tlv_t107:get_tlv_107	(IIII)[B
    //   980: astore 47
    //   982: lload 35
    //   984: lstore 43
    //   986: lload 37
    //   988: lstore 35
    //   990: lload 43
    //   992: lstore 37
    //   994: goto -318 -> 676
    //   997: aload 49
    //   999: astore 47
    //   1001: aload 26
    //   1003: ifnull -339 -> 664
    //   1006: aload 26
    //   1008: arraylength
    //   1009: ifne +22 -> 1031
    //   1012: lload 35
    //   1014: lstore 43
    //   1016: aload 50
    //   1018: astore 47
    //   1020: lload 37
    //   1022: lstore 35
    //   1024: lload 43
    //   1026: lstore 37
    //   1028: goto -352 -> 676
    //   1031: new 281	oicq/wlogin_sdk/tlv_type/tlv_t108
    //   1034: dup
    //   1035: invokespecial 282	oicq/wlogin_sdk/tlv_type/tlv_t108:<init>	()V
    //   1038: aload 26
    //   1040: invokevirtual 285	oicq/wlogin_sdk/tlv_type/tlv_t108:get_tlv_108	([B)[B
    //   1043: astore 47
    //   1045: lload 35
    //   1047: lstore 43
    //   1049: lload 37
    //   1051: lstore 35
    //   1053: lload 43
    //   1055: lstore 37
    //   1057: goto -381 -> 676
    //   1060: aload 49
    //   1062: astore 47
    //   1064: aload 27
    //   1066: ifnull -402 -> 664
    //   1069: aload 27
    //   1071: arraylength
    //   1072: ifne +22 -> 1094
    //   1075: lload 35
    //   1077: lstore 43
    //   1079: aload 50
    //   1081: astore 47
    //   1083: lload 37
    //   1085: lstore 35
    //   1087: lload 43
    //   1089: lstore 37
    //   1091: goto -415 -> 676
    //   1094: new 81	oicq/wlogin_sdk/tlv_type/tlv_t104
    //   1097: dup
    //   1098: invokespecial 82	oicq/wlogin_sdk/tlv_type/tlv_t104:<init>	()V
    //   1101: aload 27
    //   1103: invokevirtual 288	oicq/wlogin_sdk/tlv_type/tlv_t104:get_tlv_104	([B)[B
    //   1106: astore 47
    //   1108: lload 35
    //   1110: lstore 43
    //   1112: lload 37
    //   1114: lstore 35
    //   1116: lload 43
    //   1118: lstore 37
    //   1120: goto -444 -> 676
    //   1123: new 290	oicq/wlogin_sdk/tlv_type/tlv_t142
    //   1126: dup
    //   1127: invokespecial 291	oicq/wlogin_sdk/tlv_type/tlv_t142:<init>	()V
    //   1130: aload 28
    //   1132: invokevirtual 294	oicq/wlogin_sdk/tlv_type/tlv_t142:get_tlv_142	([B)[B
    //   1135: astore 47
    //   1137: lload 35
    //   1139: lstore 43
    //   1141: lload 37
    //   1143: lstore 35
    //   1145: lload 43
    //   1147: lstore 37
    //   1149: goto -473 -> 676
    //   1152: aload 49
    //   1154: astore 47
    //   1156: aload_0
    //   1157: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1160: getfield 245	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1163: ifnull -499 -> 664
    //   1166: aload_0
    //   1167: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1170: getfield 245	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1173: invokestatic 298	oicq/wlogin_sdk/tools/util:check_uin_account	(Ljava/lang/String;)Ljava/lang/Boolean;
    //   1176: invokevirtual 304	java/lang/Boolean:booleanValue	()Z
    //   1179: ifeq +22 -> 1201
    //   1182: lload 35
    //   1184: lstore 43
    //   1186: aload 50
    //   1188: astore 47
    //   1190: lload 37
    //   1192: lstore 35
    //   1194: lload 43
    //   1196: lstore 37
    //   1198: goto -522 -> 676
    //   1201: new 306	oicq/wlogin_sdk/tlv_type/tlv_t112
    //   1204: dup
    //   1205: invokespecial 307	oicq/wlogin_sdk/tlv_type/tlv_t112:<init>	()V
    //   1208: aload_0
    //   1209: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1212: getfield 245	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1215: invokevirtual 248	java/lang/String:getBytes	()[B
    //   1218: invokevirtual 310	oicq/wlogin_sdk/tlv_type/tlv_t112:get_tlv_112	([B)[B
    //   1221: astore 47
    //   1223: aload 52
    //   1225: ldc_w 312
    //   1228: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: aload_0
    //   1232: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1235: getfield 245	oicq/wlogin_sdk/request/t:g	Ljava/lang/String;
    //   1238: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: pop
    //   1242: lload 35
    //   1244: lstore 43
    //   1246: lload 37
    //   1248: lstore 35
    //   1250: lload 43
    //   1252: lstore 37
    //   1254: goto -578 -> 676
    //   1257: new 314	oicq/wlogin_sdk/tlv_type/tlv_t109
    //   1260: dup
    //   1261: invokespecial 315	oicq/wlogin_sdk/tlv_type/tlv_t109:<init>	()V
    //   1264: getstatic 318	oicq/wlogin_sdk/request/t:P	[B
    //   1267: invokevirtual 321	oicq/wlogin_sdk/tlv_type/tlv_t109:get_tlv_109	([B)[B
    //   1270: astore 47
    //   1272: new 323	oicq/wlogin_sdk/tlv_type/tlv_t52d
    //   1275: dup
    //   1276: invokespecial 324	oicq/wlogin_sdk/tlv_type/tlv_t52d:<init>	()V
    //   1279: aload_0
    //   1280: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   1283: invokevirtual 328	oicq/wlogin_sdk/tlv_type/tlv_t52d:get_tlv_52d	(Landroid/content/Context;)[B
    //   1286: astore 48
    //   1288: new 330	oicq/wlogin_sdk/tlv_type/tlv_t124
    //   1291: dup
    //   1292: invokespecial 331	oicq/wlogin_sdk/tlv_type/tlv_t124:<init>	()V
    //   1295: astore 49
    //   1297: invokestatic 334	oicq/wlogin_sdk/tools/util:get_os_type	()[B
    //   1300: astore 50
    //   1302: invokestatic 337	oicq/wlogin_sdk/tools/util:get_os_version	()[B
    //   1305: astore 55
    //   1307: getstatic 340	oicq/wlogin_sdk/request/t:E	I
    //   1310: istore 33
    //   1312: getstatic 343	oicq/wlogin_sdk/request/t:D	[B
    //   1315: astore 56
    //   1317: getstatic 346	oicq/wlogin_sdk/request/t:G	[B
    //   1320: astore 57
    //   1322: aload 49
    //   1324: aload 50
    //   1326: aload 55
    //   1328: iload 33
    //   1330: aload 56
    //   1332: iconst_0
    //   1333: newarray byte
    //   1335: aload 57
    //   1337: invokevirtual 350	oicq/wlogin_sdk/tlv_type/tlv_t124:get_tlv_124	([B[BI[B[B[B)[B
    //   1340: astore 49
    //   1342: new 352	oicq/wlogin_sdk/tlv_type/tlv_t128
    //   1345: dup
    //   1346: invokespecial 353	oicq/wlogin_sdk/tlv_type/tlv_t128:<init>	()V
    //   1349: getstatic 356	oicq/wlogin_sdk/request/t:V	I
    //   1352: getstatic 251	oicq/wlogin_sdk/request/t:W	I
    //   1355: getstatic 359	oicq/wlogin_sdk/request/t:X	I
    //   1358: getstatic 362	oicq/wlogin_sdk/request/t:aa	I
    //   1361: getstatic 364	oicq/wlogin_sdk/request/t:J	[B
    //   1364: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   1367: getstatic 367	oicq/wlogin_sdk/request/t:Q	[B
    //   1370: invokevirtual 371	oicq/wlogin_sdk/tlv_type/tlv_t128:get_tlv_128	(IIII[B[B[B)[B
    //   1373: astore 50
    //   1375: new 373	oicq/wlogin_sdk/tlv_type/tlv_t16e
    //   1378: dup
    //   1379: invokespecial 374	oicq/wlogin_sdk/tlv_type/tlv_t16e:<init>	()V
    //   1382: getstatic 364	oicq/wlogin_sdk/request/t:J	[B
    //   1385: invokevirtual 377	oicq/wlogin_sdk/tlv_type/tlv_t16e:get_tlv_16e	([B)[B
    //   1388: astore 55
    //   1390: new 379	oicq/wlogin_sdk/tlv_type/tlv_t144
    //   1393: dup
    //   1394: invokespecial 380	oicq/wlogin_sdk/tlv_type/tlv_t144:<init>	()V
    //   1397: aload 47
    //   1399: aload 48
    //   1401: aload 49
    //   1403: aload 50
    //   1405: aload 55
    //   1407: aload 54
    //   1409: getfield 75	oicq/wlogin_sdk/request/async_context:_tgtgt_key	[B
    //   1412: invokevirtual 384	oicq/wlogin_sdk/tlv_type/tlv_t144:get_tlv_144	([B[B[B[B[B[B)[B
    //   1415: astore 47
    //   1417: lload 35
    //   1419: lstore 43
    //   1421: lload 37
    //   1423: lstore 35
    //   1425: lload 43
    //   1427: lstore 37
    //   1429: goto -753 -> 676
    //   1432: new 386	oicq/wlogin_sdk/tlv_type/tlv_t145
    //   1435: dup
    //   1436: invokespecial 387	oicq/wlogin_sdk/tlv_type/tlv_t145:<init>	()V
    //   1439: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   1442: invokevirtual 390	oicq/wlogin_sdk/tlv_type/tlv_t145:get_tlv_145	([B)[B
    //   1445: astore 47
    //   1447: lload 35
    //   1449: lstore 43
    //   1451: lload 37
    //   1453: lstore 35
    //   1455: lload 43
    //   1457: lstore 37
    //   1459: goto -783 -> 676
    //   1462: new 392	oicq/wlogin_sdk/tlv_type/tlv_t147
    //   1465: dup
    //   1466: invokespecial 393	oicq/wlogin_sdk/tlv_type/tlv_t147:<init>	()V
    //   1469: lload_1
    //   1470: getstatic 396	oicq/wlogin_sdk/request/t:H	[B
    //   1473: getstatic 398	oicq/wlogin_sdk/request/t:I	[B
    //   1476: invokevirtual 402	oicq/wlogin_sdk/tlv_type/tlv_t147:get_tlv_147	(J[B[B)[B
    //   1479: astore 47
    //   1481: lload 35
    //   1483: lstore 43
    //   1485: lload 37
    //   1487: lstore 35
    //   1489: lload 43
    //   1491: lstore 37
    //   1493: goto -817 -> 676
    //   1496: iload 16
    //   1498: sipush 128
    //   1501: iand
    //   1502: ifne +22 -> 1524
    //   1505: lload 35
    //   1507: lstore 43
    //   1509: aload 50
    //   1511: astore 47
    //   1513: lload 37
    //   1515: lstore 35
    //   1517: lload 43
    //   1519: lstore 37
    //   1521: goto -845 -> 676
    //   1524: new 404	oicq/wlogin_sdk/tlv_type/tlv_t166
    //   1527: dup
    //   1528: invokespecial 405	oicq/wlogin_sdk/tlv_type/tlv_t166:<init>	()V
    //   1531: getstatic 407	oicq/wlogin_sdk/request/t:y	I
    //   1534: invokevirtual 411	oicq/wlogin_sdk/tlv_type/tlv_t166:get_tlv_166	(I)[B
    //   1537: astore 47
    //   1539: lload 35
    //   1541: lstore 43
    //   1543: lload 37
    //   1545: lstore 35
    //   1547: lload 43
    //   1549: lstore 37
    //   1551: goto -875 -> 676
    //   1554: aload 49
    //   1556: astore 47
    //   1558: aload 15
    //   1560: ifnull -896 -> 664
    //   1563: aload 15
    //   1565: arraylength
    //   1566: ifne +22 -> 1588
    //   1569: lload 35
    //   1571: lstore 43
    //   1573: aload 50
    //   1575: astore 47
    //   1577: lload 37
    //   1579: lstore 35
    //   1581: lload 43
    //   1583: lstore 37
    //   1585: goto -909 -> 676
    //   1588: new 413	oicq/wlogin_sdk/tlv_type/tlv_t16a
    //   1591: dup
    //   1592: invokespecial 414	oicq/wlogin_sdk/tlv_type/tlv_t16a:<init>	()V
    //   1595: aload 15
    //   1597: invokevirtual 417	oicq/wlogin_sdk/tlv_type/tlv_t16a:get_tlv_16a	([B)[B
    //   1600: astore 47
    //   1602: lload 35
    //   1604: lstore 43
    //   1606: lload 37
    //   1608: lstore 35
    //   1610: lload 43
    //   1612: lstore 37
    //   1614: goto -938 -> 676
    //   1617: new 419	oicq/wlogin_sdk/tlv_type/tlv_t154
    //   1620: dup
    //   1621: invokespecial 420	oicq/wlogin_sdk/tlv_type/tlv_t154:<init>	()V
    //   1624: aload_0
    //   1625: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1628: getfield 421	oicq/wlogin_sdk/request/t:i	I
    //   1631: invokevirtual 424	oicq/wlogin_sdk/tlv_type/tlv_t154:get_tlv_154	(I)[B
    //   1634: astore 47
    //   1636: lload 35
    //   1638: lstore 43
    //   1640: lload 37
    //   1642: lstore 35
    //   1644: lload 43
    //   1646: lstore 37
    //   1648: goto -972 -> 676
    //   1651: new 426	oicq/wlogin_sdk/tlv_type/tlv_t141
    //   1654: dup
    //   1655: invokespecial 427	oicq/wlogin_sdk/tlv_type/tlv_t141:<init>	()V
    //   1658: getstatic 343	oicq/wlogin_sdk/request/t:D	[B
    //   1661: getstatic 340	oicq/wlogin_sdk/request/t:E	I
    //   1664: getstatic 346	oicq/wlogin_sdk/request/t:G	[B
    //   1667: invokevirtual 431	oicq/wlogin_sdk/tlv_type/tlv_t141:get_tlv_141	([BI[B)[B
    //   1670: astore 47
    //   1672: lload 35
    //   1674: lstore 43
    //   1676: lload 37
    //   1678: lstore 35
    //   1680: lload 43
    //   1682: lstore 37
    //   1684: goto -1008 -> 676
    //   1687: new 433	oicq/wlogin_sdk/tlv_type/tlv_t8
    //   1690: dup
    //   1691: invokespecial 434	oicq/wlogin_sdk/tlv_type/tlv_t8:<init>	()V
    //   1694: iconst_0
    //   1695: getstatic 436	oicq/wlogin_sdk/request/t:v	I
    //   1698: iconst_0
    //   1699: invokevirtual 440	oicq/wlogin_sdk/tlv_type/tlv_t8:get_tlv_8	(III)[B
    //   1702: astore 47
    //   1704: lload 35
    //   1706: lstore 43
    //   1708: lload 37
    //   1710: lstore 35
    //   1712: lload 43
    //   1714: lstore 37
    //   1716: goto -1040 -> 676
    //   1719: aload 49
    //   1721: astore 47
    //   1723: aload 29
    //   1725: ifnull -1061 -> 664
    //   1728: aload 29
    //   1730: invokeinterface 445 1 0
    //   1735: ifne +22 -> 1757
    //   1738: lload 35
    //   1740: lstore 43
    //   1742: aload 50
    //   1744: astore 47
    //   1746: lload 37
    //   1748: lstore 35
    //   1750: lload 43
    //   1752: lstore 37
    //   1754: goto -1078 -> 676
    //   1757: new 447	oicq/wlogin_sdk/tlv_type/tlv_t511
    //   1760: dup
    //   1761: invokespecial 448	oicq/wlogin_sdk/tlv_type/tlv_t511:<init>	()V
    //   1764: aload 29
    //   1766: invokevirtual 452	oicq/wlogin_sdk/tlv_type/tlv_t511:get_tlv_511	(Ljava/util/List;)[B
    //   1769: astore 47
    //   1771: lload 35
    //   1773: lstore 43
    //   1775: lload 37
    //   1777: lstore 35
    //   1779: lload 43
    //   1781: lstore 37
    //   1783: goto -1107 -> 676
    //   1786: aload 49
    //   1788: astore 47
    //   1790: aload_0
    //   1791: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1794: getfield 455	oicq/wlogin_sdk/request/t:s	[B
    //   1797: ifnull -1133 -> 664
    //   1800: aload_0
    //   1801: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1804: getfield 455	oicq/wlogin_sdk/request/t:s	[B
    //   1807: arraylength
    //   1808: ifne +22 -> 1830
    //   1811: lload 35
    //   1813: lstore 43
    //   1815: aload 50
    //   1817: astore 47
    //   1819: lload 37
    //   1821: lstore 35
    //   1823: lload 43
    //   1825: lstore 37
    //   1827: goto -1151 -> 676
    //   1830: new 457	oicq/wlogin_sdk/tlv_type/tlv_t172
    //   1833: dup
    //   1834: invokespecial 458	oicq/wlogin_sdk/tlv_type/tlv_t172:<init>	()V
    //   1837: aload_0
    //   1838: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1841: getfield 455	oicq/wlogin_sdk/request/t:s	[B
    //   1844: invokevirtual 461	oicq/wlogin_sdk/tlv_type/tlv_t172:get_tlv_172	([B)[B
    //   1847: astore 47
    //   1849: lload 35
    //   1851: lstore 43
    //   1853: lload 37
    //   1855: lstore 35
    //   1857: lload 43
    //   1859: lstore 37
    //   1861: goto -1185 -> 676
    //   1864: aload 49
    //   1866: astore 47
    //   1868: iload 13
    //   1870: iconst_3
    //   1871: if_icmpne -1207 -> 664
    //   1874: new 463	oicq/wlogin_sdk/tlv_type/tlv_t185
    //   1877: dup
    //   1878: invokespecial 464	oicq/wlogin_sdk/tlv_type/tlv_t185:<init>	()V
    //   1881: iconst_1
    //   1882: invokevirtual 467	oicq/wlogin_sdk/tlv_type/tlv_t185:get_tlv_185	(I)[B
    //   1885: astore 47
    //   1887: lload 35
    //   1889: lstore 43
    //   1891: lload 37
    //   1893: lstore 35
    //   1895: lload 43
    //   1897: lstore 37
    //   1899: goto -1223 -> 676
    //   1902: aload_0
    //   1903: getfield 41	oicq/wlogin_sdk/request/k:x	Loicq/wlogin_sdk/request/t;
    //   1906: lload 6
    //   1908: lload_1
    //   1909: invokevirtual 470	oicq/wlogin_sdk/request/t:a	(JJ)Loicq/wlogin_sdk/sharemem/WloginSigInfo;
    //   1912: astore 48
    //   1914: aload 49
    //   1916: astore 47
    //   1918: aload 48
    //   1920: ifnull -1256 -> 664
    //   1923: aload 49
    //   1925: astore 47
    //   1927: aload 48
    //   1929: getfield 475	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1932: ifnull -1268 -> 664
    //   1935: aload 48
    //   1937: getfield 475	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   1940: arraylength
    //   1941: ifne +22 -> 1963
    //   1944: lload 35
    //   1946: lstore 43
    //   1948: aload 50
    //   1950: astore 47
    //   1952: lload 37
    //   1954: lstore 35
    //   1956: lload 43
    //   1958: lstore 37
    //   1960: goto -1284 -> 676
    //   1963: aload 49
    //   1965: astore 47
    //   1967: aload 48
    //   1969: getfield 478	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1972: ifnull -1308 -> 664
    //   1975: aload 48
    //   1977: getfield 478	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   1980: arraylength
    //   1981: ifne +22 -> 2003
    //   1984: lload 35
    //   1986: lstore 43
    //   1988: aload 50
    //   1990: astore 47
    //   1992: lload 37
    //   1994: lstore 35
    //   1996: lload 43
    //   1998: lstore 37
    //   2000: goto -1324 -> 676
    //   2003: aload 49
    //   2005: astore 47
    //   2007: aload 48
    //   2009: getfield 481	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   2012: ifnull -1348 -> 664
    //   2015: aload 48
    //   2017: getfield 481	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   2020: arraylength
    //   2021: ifne +22 -> 2043
    //   2024: lload 35
    //   2026: lstore 43
    //   2028: aload 50
    //   2030: astore 47
    //   2032: lload 37
    //   2034: lstore 35
    //   2036: lload 43
    //   2038: lstore 37
    //   2040: goto -1364 -> 676
    //   2043: new 483	oicq/wlogin_sdk/tlv_type/tlv_t400
    //   2046: dup
    //   2047: invokespecial 484	oicq/wlogin_sdk/tlv_type/tlv_t400:<init>	()V
    //   2050: aload 48
    //   2052: getfield 475	oicq/wlogin_sdk/sharemem/WloginSigInfo:_G	[B
    //   2055: lload 6
    //   2057: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   2060: aload 48
    //   2062: getfield 478	oicq/wlogin_sdk/sharemem/WloginSigInfo:_dpwd	[B
    //   2065: lload_1
    //   2066: lload_3
    //   2067: aload 48
    //   2069: getfield 481	oicq/wlogin_sdk/sharemem/WloginSigInfo:_randseed	[B
    //   2072: invokevirtual 488	oicq/wlogin_sdk/tlv_type/tlv_t400:get_tlv_400	([BJ[B[BJJ[B)[B
    //   2075: astore 47
    //   2077: lload 35
    //   2079: lstore 43
    //   2081: lload 37
    //   2083: lstore 35
    //   2085: lload 43
    //   2087: lstore 37
    //   2089: goto -1413 -> 676
    //   2092: aload 49
    //   2094: astore 47
    //   2096: getstatic 491	oicq/wlogin_sdk/request/t:O	[B
    //   2099: ifnull -1435 -> 664
    //   2102: getstatic 491	oicq/wlogin_sdk/request/t:O	[B
    //   2105: arraylength
    //   2106: ifne +22 -> 2128
    //   2109: lload 35
    //   2111: lstore 43
    //   2113: aload 50
    //   2115: astore 47
    //   2117: lload 37
    //   2119: lstore 35
    //   2121: lload 43
    //   2123: lstore 37
    //   2125: goto -1449 -> 676
    //   2128: new 493	oicq/wlogin_sdk/tlv_type/tlv_t187
    //   2131: dup
    //   2132: invokespecial 494	oicq/wlogin_sdk/tlv_type/tlv_t187:<init>	()V
    //   2135: getstatic 491	oicq/wlogin_sdk/request/t:O	[B
    //   2138: invokevirtual 497	oicq/wlogin_sdk/tlv_type/tlv_t187:get_tlv_187	([B)[B
    //   2141: astore 47
    //   2143: lload 35
    //   2145: lstore 43
    //   2147: lload 37
    //   2149: lstore 35
    //   2151: lload 43
    //   2153: lstore 37
    //   2155: goto -1479 -> 676
    //   2158: aload 49
    //   2160: astore 47
    //   2162: getstatic 318	oicq/wlogin_sdk/request/t:P	[B
    //   2165: ifnull -1501 -> 664
    //   2168: getstatic 318	oicq/wlogin_sdk/request/t:P	[B
    //   2171: arraylength
    //   2172: ifne +22 -> 2194
    //   2175: lload 35
    //   2177: lstore 43
    //   2179: aload 50
    //   2181: astore 47
    //   2183: lload 37
    //   2185: lstore 35
    //   2187: lload 43
    //   2189: lstore 37
    //   2191: goto -1515 -> 676
    //   2194: new 499	oicq/wlogin_sdk/tlv_type/tlv_t188
    //   2197: dup
    //   2198: invokespecial 500	oicq/wlogin_sdk/tlv_type/tlv_t188:<init>	()V
    //   2201: getstatic 318	oicq/wlogin_sdk/request/t:P	[B
    //   2204: invokevirtual 503	oicq/wlogin_sdk/tlv_type/tlv_t188:get_tlv_188	([B)[B
    //   2207: astore 47
    //   2209: lload 35
    //   2211: lstore 43
    //   2213: lload 37
    //   2215: lstore 35
    //   2217: lload 43
    //   2219: lstore 37
    //   2221: goto -1545 -> 676
    //   2224: aload 49
    //   2226: astore 47
    //   2228: getstatic 504	oicq/wlogin_sdk/request/t:M	[B
    //   2231: ifnull -1567 -> 664
    //   2234: getstatic 504	oicq/wlogin_sdk/request/t:M	[B
    //   2237: arraylength
    //   2238: ifne +22 -> 2260
    //   2241: lload 35
    //   2243: lstore 43
    //   2245: aload 50
    //   2247: astore 47
    //   2249: lload 37
    //   2251: lstore 35
    //   2253: lload 43
    //   2255: lstore 37
    //   2257: goto -1581 -> 676
    //   2260: new 506	oicq/wlogin_sdk/tlv_type/tlv_t194
    //   2263: dup
    //   2264: invokespecial 507	oicq/wlogin_sdk/tlv_type/tlv_t194:<init>	()V
    //   2267: getstatic 504	oicq/wlogin_sdk/request/t:M	[B
    //   2270: invokevirtual 510	oicq/wlogin_sdk/tlv_type/tlv_t194:get_tlv_194	([B)[B
    //   2273: astore 47
    //   2275: lload 35
    //   2277: lstore 43
    //   2279: lload 37
    //   2281: lstore 35
    //   2283: lload 43
    //   2285: lstore 37
    //   2287: goto -1611 -> 676
    //   2290: new 512	oicq/wlogin_sdk/tlv_type/tlv_t191
    //   2293: dup
    //   2294: invokespecial 513	oicq/wlogin_sdk/tlv_type/tlv_t191:<init>	()V
    //   2297: getstatic 14	oicq/wlogin_sdk/request/k:K	I
    //   2300: invokevirtual 516	oicq/wlogin_sdk/tlv_type/tlv_t191:get_tlv_191	(I)[B
    //   2303: astore 47
    //   2305: new 134	java/lang/StringBuilder
    //   2308: dup
    //   2309: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2312: ldc_w 518
    //   2315: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2318: getstatic 14	oicq/wlogin_sdk/request/k:K	I
    //   2321: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2324: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2327: ldc 152
    //   2329: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2332: lload 35
    //   2334: lstore 43
    //   2336: lload 37
    //   2338: lstore 35
    //   2340: lload 43
    //   2342: lstore 37
    //   2344: goto -1668 -> 676
    //   2347: aload 49
    //   2349: astore 47
    //   2351: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2354: ifnull -1690 -> 664
    //   2357: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2360: arraylength
    //   2361: ifne +22 -> 2383
    //   2364: lload 35
    //   2366: lstore 43
    //   2368: aload 50
    //   2370: astore 47
    //   2372: lload 37
    //   2374: lstore 35
    //   2376: lload 43
    //   2378: lstore 37
    //   2380: goto -1704 -> 676
    //   2383: new 520	oicq/wlogin_sdk/tlv_type/tlv_t201
    //   2386: dup
    //   2387: invokespecial 521	oicq/wlogin_sdk/tlv_type/tlv_t201:<init>	()V
    //   2390: getstatic 16	oicq/wlogin_sdk/request/k:L	[B
    //   2393: getstatic 18	oicq/wlogin_sdk/request/k:M	[B
    //   2396: ldc_w 523
    //   2399: invokevirtual 248	java/lang/String:getBytes	()[B
    //   2402: getstatic 20	oicq/wlogin_sdk/request/k:N	[B
    //   2405: invokevirtual 527	oicq/wlogin_sdk/tlv_type/tlv_t201:get_tlv_201	([B[B[B[B)[B
    //   2408: astore 47
    //   2410: lload 35
    //   2412: lstore 43
    //   2414: lload 37
    //   2416: lstore 35
    //   2418: lload 43
    //   2420: lstore 37
    //   2422: goto -1746 -> 676
    //   2425: aload 49
    //   2427: astore 47
    //   2429: getstatic 530	oicq/wlogin_sdk/request/t:S	[B
    //   2432: ifnull -1768 -> 664
    //   2435: getstatic 530	oicq/wlogin_sdk/request/t:S	[B
    //   2438: arraylength
    //   2439: ifne +22 -> 2461
    //   2442: lload 35
    //   2444: lstore 43
    //   2446: aload 50
    //   2448: astore 47
    //   2450: lload 37
    //   2452: lstore 35
    //   2454: lload 43
    //   2456: lstore 37
    //   2458: goto -1782 -> 676
    //   2461: new 532	oicq/wlogin_sdk/tlv_type/tlv_t202
    //   2464: dup
    //   2465: invokespecial 533	oicq/wlogin_sdk/tlv_type/tlv_t202:<init>	()V
    //   2468: getstatic 530	oicq/wlogin_sdk/request/t:S	[B
    //   2471: getstatic 536	oicq/wlogin_sdk/request/t:T	[B
    //   2474: invokevirtual 540	oicq/wlogin_sdk/tlv_type/tlv_t202:get_tlv_202	([B[B)[B
    //   2477: astore 47
    //   2479: lload 35
    //   2481: lstore 43
    //   2483: lload 37
    //   2485: lstore 35
    //   2487: lload 43
    //   2489: lstore 37
    //   2491: goto -1815 -> 676
    //   2494: new 542	oicq/wlogin_sdk/tlv_type/tlv_t177
    //   2497: dup
    //   2498: invokespecial 543	oicq/wlogin_sdk/tlv_type/tlv_t177:<init>	()V
    //   2501: ldc2_w 544
    //   2504: ldc_w 547
    //   2507: invokevirtual 551	oicq/wlogin_sdk/tlv_type/tlv_t177:get_tlv_177	(JLjava/lang/String;)[B
    //   2510: astore 47
    //   2512: lload 35
    //   2514: lstore 43
    //   2516: lload 37
    //   2518: lstore 35
    //   2520: lload 43
    //   2522: lstore 37
    //   2524: goto -1848 -> 676
    //   2527: new 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2530: dup
    //   2531: sipush 1302
    //   2534: invokespecial 556	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2537: astore 47
    //   2539: iconst_4
    //   2540: newarray byte
    //   2542: astore 48
    //   2544: aload 48
    //   2546: iconst_0
    //   2547: aload 30
    //   2549: getfield 559	oicq/wlogin_sdk/request/WUserSigInfo:_source_type	I
    //   2552: invokestatic 563	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   2555: aload 47
    //   2557: aload 48
    //   2559: iconst_4
    //   2560: invokevirtual 564	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2563: aload 47
    //   2565: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2568: astore 47
    //   2570: lload 35
    //   2572: lstore 43
    //   2574: lload 37
    //   2576: lstore 35
    //   2578: lload 43
    //   2580: lstore 37
    //   2582: goto -1906 -> 676
    //   2585: new 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2588: dup
    //   2589: sipush 1313
    //   2592: invokespecial 556	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2595: astore 47
    //   2597: bipush 6
    //   2599: newarray byte
    //   2601: astore 48
    //   2603: aload 48
    //   2605: iconst_0
    //   2606: getstatic 568	oicq/wlogin_sdk/request/t:aA	I
    //   2609: invokestatic 563	oicq/wlogin_sdk/tools/util:int32_to_buf	([BII)V
    //   2612: aload 48
    //   2614: iconst_4
    //   2615: iconst_0
    //   2616: invokestatic 571	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   2619: aload 47
    //   2621: aload 48
    //   2623: bipush 6
    //   2625: invokevirtual 564	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2628: aload 47
    //   2630: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2633: astore 47
    //   2635: lload 35
    //   2637: lstore 43
    //   2639: lload 37
    //   2641: lstore 35
    //   2643: lload 43
    //   2645: lstore 37
    //   2647: goto -1971 -> 676
    //   2650: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   2653: lstore 43
    //   2655: lload 43
    //   2657: lstore 41
    //   2659: new 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2662: dup
    //   2663: sipush 1334
    //   2666: invokespecial 556	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2669: astore 47
    //   2671: aload_0
    //   2672: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   2675: invokestatic 576	com/tencent/loginsecsdk/ProtocolDet:getLoginExtraData	(Landroid/content/Context;)[B
    //   2678: astore 48
    //   2680: aload 48
    //   2682: ifnull +195 -> 2877
    //   2685: aload 48
    //   2687: arraylength
    //   2688: ifle +189 -> 2877
    //   2691: new 134	java/lang/StringBuilder
    //   2694: dup
    //   2695: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2698: ldc_w 578
    //   2701: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2704: aload 48
    //   2706: arraylength
    //   2707: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2710: ldc_w 580
    //   2713: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2716: aload 48
    //   2718: invokestatic 584	oicq/wlogin_sdk/tools/util:buf_to_string	([B)Ljava/lang/String;
    //   2721: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2724: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2727: new 134	java/lang/StringBuilder
    //   2730: dup
    //   2731: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2734: lload 6
    //   2736: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2739: ldc 152
    //   2741: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2744: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2747: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2750: aload 47
    //   2752: aload 48
    //   2754: aload 48
    //   2756: arraylength
    //   2757: invokevirtual 564	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2760: aload 47
    //   2762: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2765: astore 47
    //   2767: new 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   2770: dup
    //   2771: sipush 1317
    //   2774: invokespecial 556	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   2777: astore 48
    //   2779: aload 47
    //   2781: arraylength
    //   2782: iconst_2
    //   2783: iadd
    //   2784: newarray byte
    //   2786: astore 49
    //   2788: aload 49
    //   2790: iconst_0
    //   2791: iconst_1
    //   2792: invokestatic 571	oicq/wlogin_sdk/tools/util:int16_to_buf	([BII)V
    //   2795: aload 47
    //   2797: iconst_0
    //   2798: aload 49
    //   2800: iconst_2
    //   2801: aload 47
    //   2803: arraylength
    //   2804: invokestatic 588	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2807: aload 48
    //   2809: aload 49
    //   2811: aload 49
    //   2813: arraylength
    //   2814: invokevirtual 564	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   2817: aload 48
    //   2819: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   2822: astore 47
    //   2824: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   2827: lstore 43
    //   2829: lload 43
    //   2831: lstore 39
    //   2833: new 134	java/lang/StringBuilder
    //   2836: dup
    //   2837: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2840: ldc_w 590
    //   2843: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2846: lload 39
    //   2848: lload 41
    //   2850: lsub
    //   2851: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2854: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2857: ldc 152
    //   2859: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2862: lload 35
    //   2864: lstore 43
    //   2866: lload 37
    //   2868: lstore 35
    //   2870: lload 43
    //   2872: lstore 37
    //   2874: goto -2198 -> 676
    //   2877: ldc_w 592
    //   2880: new 134	java/lang/StringBuilder
    //   2883: dup
    //   2884: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2887: lload 6
    //   2889: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2892: ldc 152
    //   2894: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2897: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2900: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2903: aconst_null
    //   2904: astore 47
    //   2906: goto -82 -> 2824
    //   2909: astore 48
    //   2911: aconst_null
    //   2912: astore 47
    //   2914: new 134	java/lang/StringBuilder
    //   2917: dup
    //   2918: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2921: ldc_w 594
    //   2924: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2927: aload 48
    //   2929: invokestatic 600	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2932: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2935: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2938: new 134	java/lang/StringBuilder
    //   2941: dup
    //   2942: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   2945: lload 6
    //   2947: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2950: ldc 152
    //   2952: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2955: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2958: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   2961: lload 35
    //   2963: lstore 43
    //   2965: lload 37
    //   2967: lstore 35
    //   2969: lload 43
    //   2971: lstore 37
    //   2973: goto -2297 -> 676
    //   2976: aload 49
    //   2978: astore 47
    //   2980: aload 54
    //   2982: getfield 603	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2985: ifnull -2321 -> 664
    //   2988: aload 49
    //   2990: astore 47
    //   2992: aload 54
    //   2994: getfield 603	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   2997: arraylength
    //   2998: ifeq -2334 -> 664
    //   3001: new 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   3004: dup
    //   3005: sipush 792
    //   3008: invokespecial 556	oicq/wlogin_sdk/tlv_type/tlv_t:<init>	(I)V
    //   3011: astore 47
    //   3013: aload 47
    //   3015: aload 54
    //   3017: getfield 603	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   3020: aload 54
    //   3022: getfield 603	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   3025: arraylength
    //   3026: invokevirtual 564	oicq/wlogin_sdk/tlv_type/tlv_t:set_data	([BI)V
    //   3029: aload 47
    //   3031: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   3034: astore 47
    //   3036: new 134	java/lang/StringBuilder
    //   3039: dup
    //   3040: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3043: ldc_w 605
    //   3046: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3049: aload 54
    //   3051: getfield 603	oicq/wlogin_sdk/request/async_context:tgtQR	[B
    //   3054: arraylength
    //   3055: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3058: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3061: new 134	java/lang/StringBuilder
    //   3064: dup
    //   3065: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3068: ldc 152
    //   3070: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3073: lload 6
    //   3075: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3078: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3081: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3084: lload 35
    //   3086: lstore 43
    //   3088: lload 37
    //   3090: lstore 35
    //   3092: lload 43
    //   3094: lstore 37
    //   3096: goto -2420 -> 676
    //   3099: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   3102: lstore 37
    //   3104: new 607	oicq/wlogin_sdk/tlv_type/tlv_t544
    //   3107: dup
    //   3108: invokespecial 608	oicq/wlogin_sdk/tlv_type/tlv_t544:<init>	()V
    //   3111: aload_0
    //   3112: getfield 50	oicq/wlogin_sdk/request/k:a	Landroid/content/Context;
    //   3115: lload 6
    //   3117: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   3120: arraylength
    //   3121: getstatic 254	oicq/wlogin_sdk/request/t:B	[B
    //   3124: ldc_w 547
    //   3127: invokevirtual 611	java/lang/String:length	()I
    //   3130: ldc_w 547
    //   3133: aload_0
    //   3134: getfield 31	oicq/wlogin_sdk/request/k:u	I
    //   3137: invokevirtual 615	oicq/wlogin_sdk/tlv_type/tlv_t544:get_tlv_544	(Landroid/content/Context;JI[BILjava/lang/String;I)[B
    //   3140: astore 47
    //   3142: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   3145: lstore 35
    //   3147: new 134	java/lang/StringBuilder
    //   3150: dup
    //   3151: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3154: ldc_w 617
    //   3157: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3160: lload 35
    //   3162: lload 37
    //   3164: lsub
    //   3165: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3168: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3171: new 134	java/lang/StringBuilder
    //   3174: dup
    //   3175: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3178: ldc 152
    //   3180: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: lload 6
    //   3185: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3188: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3191: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3194: goto -2518 -> 676
    //   3197: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3200: ifnull +10 -> 3210
    //   3203: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3206: arraylength
    //   3207: ifne +12 -> 3219
    //   3210: getstatic 622	oicq/wlogin_sdk/request/t:u	Landroid/content/Context;
    //   3213: invokestatic 625	oicq/wlogin_sdk/tools/util:get_qimei	(Landroid/content/Context;)[B
    //   3216: putstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3219: aload 49
    //   3221: astore 47
    //   3223: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3226: ifnull -2562 -> 664
    //   3229: aload 49
    //   3231: astore 47
    //   3233: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3236: arraylength
    //   3237: ifle -2573 -> 664
    //   3240: new 627	oicq/wlogin_sdk/tlv_type/tlv_t545
    //   3243: dup
    //   3244: invokespecial 628	oicq/wlogin_sdk/tlv_type/tlv_t545:<init>	()V
    //   3247: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3250: invokevirtual 631	oicq/wlogin_sdk/tlv_type/tlv_t545:get_tlv_545	([B)[B
    //   3253: astore 47
    //   3255: new 134	java/lang/StringBuilder
    //   3258: dup
    //   3259: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3262: ldc_w 633
    //   3265: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: getstatic 620	oicq/wlogin_sdk/request/t:U	[B
    //   3271: arraylength
    //   3272: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3275: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3278: new 134	java/lang/StringBuilder
    //   3281: dup
    //   3282: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3285: ldc 152
    //   3287: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3290: lload 6
    //   3292: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3295: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3298: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3301: lload 35
    //   3303: lstore 43
    //   3305: lload 37
    //   3307: lstore 35
    //   3309: lload 43
    //   3311: lstore 37
    //   3313: goto -2637 -> 676
    //   3316: aload 49
    //   3318: astore 47
    //   3320: getstatic 636	oicq/wlogin_sdk/request/t:ao	[B
    //   3323: ifnull -2659 -> 664
    //   3326: aload 49
    //   3328: astore 47
    //   3330: getstatic 636	oicq/wlogin_sdk/request/t:ao	[B
    //   3333: arraylength
    //   3334: ifle -2670 -> 664
    //   3337: new 638	oicq/wlogin_sdk/tlv_type/tlv_t548
    //   3340: dup
    //   3341: invokespecial 639	oicq/wlogin_sdk/tlv_type/tlv_t548:<init>	()V
    //   3344: getstatic 636	oicq/wlogin_sdk/request/t:ao	[B
    //   3347: invokevirtual 642	oicq/wlogin_sdk/tlv_type/tlv_t548:get_tlv_548	([B)[B
    //   3350: astore 49
    //   3352: aload 48
    //   3354: astore 47
    //   3356: aload 49
    //   3358: ifnull +17 -> 3375
    //   3361: aload 48
    //   3363: astore 47
    //   3365: aload 49
    //   3367: arraylength
    //   3368: ifle +7 -> 3375
    //   3371: aload 49
    //   3373: astore 47
    //   3375: new 134	java/lang/StringBuilder
    //   3378: dup
    //   3379: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3382: ldc_w 644
    //   3385: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3388: astore 48
    //   3390: aload 49
    //   3392: ifnonnull +24 -> 3416
    //   3395: iconst_0
    //   3396: istore 33
    //   3398: aload 48
    //   3400: iload 33
    //   3402: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3405: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3408: ldc 152
    //   3410: invokestatic 159	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;Ljava/lang/String;)V
    //   3413: goto -2749 -> 664
    //   3416: aload 49
    //   3418: arraylength
    //   3419: istore 33
    //   3421: goto -23 -> 3398
    //   3424: aload 30
    //   3426: getfield 648	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3429: invokevirtual 654	java/util/HashMap:keySet	()Ljava/util/Set;
    //   3432: invokeinterface 660 1 0
    //   3437: astore 9
    //   3439: aload 9
    //   3441: invokeinterface 665 1 0
    //   3446: ifeq +110 -> 3556
    //   3449: aload 9
    //   3451: invokeinterface 669 1 0
    //   3456: checkcast 671	java/lang/Integer
    //   3459: astore 11
    //   3461: aload 30
    //   3463: getfield 648	oicq/wlogin_sdk/request/WUserSigInfo:extraLoginTLVMap	Ljava/util/HashMap;
    //   3466: aload 11
    //   3468: invokevirtual 675	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   3471: checkcast 553	oicq/wlogin_sdk/tlv_type/tlv_t
    //   3474: invokevirtual 565	oicq/wlogin_sdk/tlv_type/tlv_t:get_buf	()[B
    //   3477: astore 10
    //   3479: aload 51
    //   3481: aload 10
    //   3483: invokevirtual 215	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3486: pop
    //   3487: iload 31
    //   3489: aload 10
    //   3491: arraylength
    //   3492: iadd
    //   3493: istore 31
    //   3495: new 134	java/lang/StringBuilder
    //   3498: dup
    //   3499: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   3502: ldc_w 677
    //   3505: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3508: aload 11
    //   3510: invokevirtual 680	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3513: ldc_w 682
    //   3516: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3519: astore 11
    //   3521: aload 10
    //   3523: ifnull +27 -> 3550
    //   3526: aload 10
    //   3528: arraylength
    //   3529: istore 5
    //   3531: aload 52
    //   3533: aload 11
    //   3535: iload 5
    //   3537: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3540: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3543: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3546: pop
    //   3547: goto -108 -> 3439
    //   3550: iconst_0
    //   3551: istore 5
    //   3553: goto -22 -> 3531
    //   3556: aload 52
    //   3558: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3561: invokestatic 684	oicq/wlogin_sdk/tools/util:LOGI	(Ljava/lang/String;)V
    //   3564: iload 31
    //   3566: newarray byte
    //   3568: astore 9
    //   3570: aload 51
    //   3572: invokevirtual 685	java/util/ArrayList:size	()I
    //   3575: istore 13
    //   3577: iconst_0
    //   3578: istore 8
    //   3580: iconst_0
    //   3581: istore 5
    //   3583: iload 5
    //   3585: iload 13
    //   3587: if_icmpge +45 -> 3632
    //   3590: aload 51
    //   3592: iload 5
    //   3594: invokevirtual 688	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3597: checkcast 689	[B
    //   3600: astore 10
    //   3602: aload 10
    //   3604: iconst_0
    //   3605: aload 9
    //   3607: iload 8
    //   3609: aload 10
    //   3611: arraylength
    //   3612: invokestatic 588	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3615: iload 8
    //   3617: aload 10
    //   3619: arraylength
    //   3620: iadd
    //   3621: istore 8
    //   3623: iload 5
    //   3625: iconst_1
    //   3626: iadd
    //   3627: istore 5
    //   3629: goto -46 -> 3583
    //   3632: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   3635: lstore_1
    //   3636: invokestatic 694	oicq/wlogin_sdk/report/a:a	()Loicq/wlogin_sdk/report/a;
    //   3639: iconst_1
    //   3640: lload_1
    //   3641: lload 45
    //   3643: lsub
    //   3644: lload 37
    //   3646: lload 35
    //   3648: lsub
    //   3649: lload 39
    //   3651: lload 41
    //   3653: lsub
    //   3654: invokevirtual 697	oicq/wlogin_sdk/report/a:a	(IJJJ)V
    //   3657: invokestatic 192	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3660: invokestatic 699	oicq/wlogin_sdk/report/c:b	(Ljava/lang/Thread;)V
    //   3663: aload_0
    //   3664: aload 9
    //   3666: aload_0
    //   3667: getfield 31	oicq/wlogin_sdk/request/k:u	I
    //   3670: iload 13
    //   3672: invokevirtual 702	oicq/wlogin_sdk/request/k:b	([BII)[B
    //   3675: areturn
    //   3676: astore 48
    //   3678: aconst_null
    //   3679: astore 47
    //   3681: goto -767 -> 2914
    //   3684: astore 48
    //   3686: goto -772 -> 2914
    //   3689: astore 48
    //   3691: goto -777 -> 2914
    //   3694: goto -2997 -> 697
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	3697	0	this	k
    //   0	3697	1	paramLong1	long
    //   0	3697	3	paramLong2	long
    //   0	3697	5	paramInt1	int
    //   0	3697	6	paramLong3	long
    //   0	3697	8	paramInt2	int
    //   0	3697	9	paramArrayOfByte1	byte[]
    //   0	3697	10	paramArrayOfByte2	byte[]
    //   0	3697	11	paramArrayOfByte3	byte[]
    //   0	3697	12	paramArrayOfByte4	byte[]
    //   0	3697	13	paramInt3	int
    //   0	3697	14	paramArrayOfByte5	byte[]
    //   0	3697	15	paramArrayOfByte6	byte[]
    //   0	3697	16	paramInt4	int
    //   0	3697	17	paramInt5	int
    //   0	3697	18	paramArrayOfLong	long[]
    //   0	3697	19	paramInt6	int
    //   0	3697	20	paramLong4	long
    //   0	3697	22	paramInt7	int
    //   0	3697	23	paramInt8	int
    //   0	3697	24	paramInt9	int
    //   0	3697	25	paramInt10	int
    //   0	3697	26	paramArrayOfByte7	byte[]
    //   0	3697	27	paramArrayOfByte8	byte[]
    //   0	3697	28	paramArrayOfByte9	byte[]
    //   0	3697	29	paramList	java.util.List<String>
    //   0	3697	30	paramWUserSigInfo	WUserSigInfo
    //   280	3285	31	i	int
    //   335	367	32	j	int
    //   349	3071	33	k	int
    //   332	10	34	m	int
    //   301	3346	35	l1	long
    //   304	3341	37	l2	long
    //   310	3340	39	l3	long
    //   307	3345	41	l4	long
    //   666	2644	43	l5	long
    //   298	3344	45	l6	long
    //   662	3018	47	localObject1	Object
    //   355	2463	48	localObject2	Object
    //   2909	453	48	localThrowable1	java.lang.Throwable
    //   3388	11	48	localStringBuilder1	java.lang.StringBuilder
    //   3676	1	48	localThrowable2	java.lang.Throwable
    //   3684	1	48	localThrowable3	java.lang.Throwable
    //   3689	1	48	localThrowable4	java.lang.Throwable
    //   358	3059	49	localObject3	Object
    //   352	2095	50	arrayOfByte1	byte[]
    //   277	3314	51	localArrayList	java.util.ArrayList
    //   327	3230	52	localStringBuilder2	java.lang.StringBuilder
    //   4	341	53	arrayOfInt	int[]
    //   268	2782	54	localasync_context	async_context
    //   1305	101	55	arrayOfByte2	byte[]
    //   1315	16	56	arrayOfByte3	byte[]
    //   1320	16	57	arrayOfByte4	byte[]
    // Exception table:
    //   from	to	target	type
    //   2650	2655	2909	java/lang/Throwable
    //   2659	2680	3676	java/lang/Throwable
    //   2685	2824	3676	java/lang/Throwable
    //   2877	2903	3676	java/lang/Throwable
    //   2824	2829	3684	java/lang/Throwable
    //   2833	2862	3689	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.request.k
 * JD-Core Version:    0.7.0.1
 */