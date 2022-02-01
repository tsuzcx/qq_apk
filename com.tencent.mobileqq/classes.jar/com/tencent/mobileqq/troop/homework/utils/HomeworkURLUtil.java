package com.tencent.mobileqq.troop.homework.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class HomeworkURLUtil
{
  /* Error */
  public static String a(Context paramContext, String paramString, android.os.Bundle paramBundle1, android.os.Bundle paramBundle2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 10
    //   6: aconst_null
    //   7: astore 11
    //   9: aconst_null
    //   10: astore 14
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 12
    //   18: aconst_null
    //   19: astore 13
    //   21: aconst_null
    //   22: astore 8
    //   24: aload_0
    //   25: ifnonnull +13 -> 38
    //   28: ldc 19
    //   30: iconst_1
    //   31: ldc 21
    //   33: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aconst_null
    //   37: areturn
    //   38: ldc 19
    //   40: iconst_1
    //   41: iconst_2
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: ldc 29
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: aload_1
    //   53: aastore
    //   54: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   57: aload_1
    //   58: astore 6
    //   60: aload_1
    //   61: ldc 34
    //   63: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   66: ifeq +16 -> 82
    //   69: aload_1
    //   70: iconst_0
    //   71: aload_1
    //   72: bipush 35
    //   74: invokevirtual 44	java/lang/String:indexOf	(I)I
    //   77: invokevirtual 48	java/lang/String:substring	(II)Ljava/lang/String;
    //   80: astore 6
    //   82: aload 6
    //   84: ldc 50
    //   86: ldc 52
    //   88: invokevirtual 56	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   91: astore 6
    //   93: aload_2
    //   94: invokestatic 62	com/tencent/biz/common/util/HttpUtil:encodeUrl	(Landroid/os/Bundle;)Ljava/lang/String;
    //   97: astore 15
    //   99: aload 6
    //   101: astore_2
    //   102: aload 15
    //   104: ifnull +63 -> 167
    //   107: aload 6
    //   109: astore_2
    //   110: aload 15
    //   112: invokevirtual 66	java/lang/String:length	()I
    //   115: ifle +52 -> 167
    //   118: new 68	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   125: astore_2
    //   126: aload_2
    //   127: aload 6
    //   129: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: ldc 75
    //   135: astore_1
    //   136: aload 6
    //   138: ldc 75
    //   140: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   143: ifeq +6 -> 149
    //   146: ldc 77
    //   148: astore_1
    //   149: aload_2
    //   150: aload_1
    //   151: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_2
    //   156: aload 15
    //   158: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_2
    //   163: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore_2
    //   167: aload 14
    //   169: astore_1
    //   170: new 83	java/net/URL
    //   173: dup
    //   174: aload_2
    //   175: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   178: astore 15
    //   180: aload 14
    //   182: astore_1
    //   183: aload 15
    //   185: aload_0
    //   186: invokestatic 89	com/tencent/mobileqq/troop/homework/utils/HomeworkURLUtil:a	(Landroid/content/Context;)Ljava/net/Proxy;
    //   189: invokevirtual 93	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   192: checkcast 95	javax/net/ssl/HttpsURLConnection
    //   195: astore_2
    //   196: aload 9
    //   198: astore_1
    //   199: aload 10
    //   201: astore 6
    //   203: aload 11
    //   205: astore 7
    //   207: aload_2
    //   208: sipush 15000
    //   211: invokevirtual 99	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   214: aload 9
    //   216: astore_1
    //   217: aload 10
    //   219: astore 6
    //   221: aload 11
    //   223: astore 7
    //   225: aload_2
    //   226: sipush 30000
    //   229: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   232: aload 9
    //   234: astore_1
    //   235: aload 10
    //   237: astore 6
    //   239: aload 11
    //   241: astore 7
    //   243: aload_2
    //   244: ldc 104
    //   246: invokevirtual 107	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   249: aload 9
    //   251: astore_1
    //   252: aload 10
    //   254: astore 6
    //   256: aload 11
    //   258: astore 7
    //   260: aload_2
    //   261: aload 15
    //   263: invokestatic 110	com/tencent/mobileqq/troop/homework/utils/HomeworkURLUtil:a	(Ljavax/net/ssl/HttpsURLConnection;Ljava/net/URL;)V
    //   266: aload 9
    //   268: astore_1
    //   269: aload 10
    //   271: astore 6
    //   273: aload 11
    //   275: astore 7
    //   277: aload_2
    //   278: ldc 112
    //   280: ldc 114
    //   282: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 9
    //   287: astore_1
    //   288: aload 10
    //   290: astore 6
    //   292: aload 11
    //   294: astore 7
    //   296: aload_2
    //   297: ldc 120
    //   299: ldc 122
    //   301: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aload_3
    //   305: ifnull +129 -> 434
    //   308: aload 9
    //   310: astore_1
    //   311: aload 10
    //   313: astore 6
    //   315: aload 11
    //   317: astore 7
    //   319: aload_3
    //   320: invokevirtual 128	android/os/Bundle:keySet	()Ljava/util/Set;
    //   323: invokeinterface 134 1 0
    //   328: astore_0
    //   329: aload 9
    //   331: astore_1
    //   332: aload 10
    //   334: astore 6
    //   336: aload 11
    //   338: astore 7
    //   340: aload_0
    //   341: invokeinterface 140 1 0
    //   346: ifeq +88 -> 434
    //   349: aload 9
    //   351: astore_1
    //   352: aload 10
    //   354: astore 6
    //   356: aload 11
    //   358: astore 7
    //   360: aload_0
    //   361: invokeinterface 144 1 0
    //   366: checkcast 36	java/lang/String
    //   369: astore 12
    //   371: aload 9
    //   373: astore_1
    //   374: aload 10
    //   376: astore 6
    //   378: aload 11
    //   380: astore 7
    //   382: aload_3
    //   383: aload 12
    //   385: invokevirtual 148	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   388: astore 13
    //   390: aload 9
    //   392: astore_1
    //   393: aload 10
    //   395: astore 6
    //   397: aload 11
    //   399: astore 7
    //   401: aload 13
    //   403: instanceof 36
    //   406: ifeq -77 -> 329
    //   409: aload 9
    //   411: astore_1
    //   412: aload 10
    //   414: astore 6
    //   416: aload 11
    //   418: astore 7
    //   420: aload_2
    //   421: aload 12
    //   423: aload 13
    //   425: checkcast 36	java/lang/String
    //   428: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   431: goto -102 -> 329
    //   434: aload 9
    //   436: astore_1
    //   437: aload 10
    //   439: astore 6
    //   441: aload 11
    //   443: astore 7
    //   445: new 68	java/lang/StringBuilder
    //   448: dup
    //   449: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   452: astore_0
    //   453: aload 9
    //   455: astore_1
    //   456: aload 10
    //   458: astore 6
    //   460: aload 11
    //   462: astore 7
    //   464: aload_0
    //   465: ldc 150
    //   467: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: pop
    //   471: aload 9
    //   473: astore_1
    //   474: aload 10
    //   476: astore 6
    //   478: aload 11
    //   480: astore 7
    //   482: aload_0
    //   483: getstatic 156	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   486: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: pop
    //   490: aload 9
    //   492: astore_1
    //   493: aload 10
    //   495: astore 6
    //   497: aload 11
    //   499: astore 7
    //   501: aload_0
    //   502: ldc 158
    //   504: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 9
    //   510: astore_1
    //   511: aload 10
    //   513: astore 6
    //   515: aload 11
    //   517: astore 7
    //   519: aload_0
    //   520: getstatic 163	android/os/Build:MODEL	Ljava/lang/String;
    //   523: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 9
    //   529: astore_1
    //   530: aload 10
    //   532: astore 6
    //   534: aload 11
    //   536: astore 7
    //   538: aload_0
    //   539: ldc 158
    //   541: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 9
    //   547: astore_1
    //   548: aload 10
    //   550: astore 6
    //   552: aload 11
    //   554: astore 7
    //   556: aload_0
    //   557: getstatic 166	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   560: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: aload 9
    //   566: astore_1
    //   567: aload 10
    //   569: astore 6
    //   571: aload 11
    //   573: astore 7
    //   575: aload_2
    //   576: ldc 168
    //   578: aload_0
    //   579: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokevirtual 118	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   585: aload 9
    //   587: astore_1
    //   588: aload 10
    //   590: astore 6
    //   592: aload 11
    //   594: astore 7
    //   596: aload_2
    //   597: invokevirtual 171	javax/net/ssl/HttpsURLConnection:connect	()V
    //   600: aload 9
    //   602: astore_1
    //   603: aload 10
    //   605: astore 6
    //   607: aload 11
    //   609: astore 7
    //   611: aload_2
    //   612: invokevirtual 174	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   615: istore 4
    //   617: iload 4
    //   619: sipush 200
    //   622: if_icmpne +413 -> 1035
    //   625: aload 9
    //   627: astore_1
    //   628: aload 10
    //   630: astore 6
    //   632: aload 11
    //   634: astore 7
    //   636: aload_2
    //   637: invokevirtual 178	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   640: astore_0
    //   641: aload_0
    //   642: astore_3
    //   643: new 180	java/io/ByteArrayOutputStream
    //   646: dup
    //   647: invokespecial 181	java/io/ByteArrayOutputStream:<init>	()V
    //   650: astore 6
    //   652: aload_0
    //   653: astore_1
    //   654: aload_0
    //   655: astore 7
    //   657: aload_0
    //   658: astore 8
    //   660: aload_0
    //   661: astore_3
    //   662: aload_2
    //   663: invokevirtual 184	javax/net/ssl/HttpsURLConnection:getContentEncoding	()Ljava/lang/String;
    //   666: ifnull +45 -> 711
    //   669: aload_0
    //   670: astore_1
    //   671: aload_0
    //   672: astore 7
    //   674: aload_0
    //   675: astore 8
    //   677: aload_0
    //   678: astore_3
    //   679: aload_2
    //   680: invokevirtual 184	javax/net/ssl/HttpsURLConnection:getContentEncoding	()Ljava/lang/String;
    //   683: invokevirtual 187	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   686: ldc 114
    //   688: invokevirtual 40	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   691: ifeq +20 -> 711
    //   694: aload_0
    //   695: astore 7
    //   697: aload_0
    //   698: astore 8
    //   700: aload_0
    //   701: astore_3
    //   702: new 189	java/util/zip/GZIPInputStream
    //   705: dup
    //   706: aload_0
    //   707: invokespecial 192	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   710: astore_1
    //   711: aload_1
    //   712: astore 7
    //   714: aload_1
    //   715: astore 8
    //   717: aload_1
    //   718: astore_3
    //   719: sipush 512
    //   722: newarray byte
    //   724: astore_0
    //   725: aload_1
    //   726: astore 7
    //   728: aload_1
    //   729: astore 8
    //   731: aload_1
    //   732: astore_3
    //   733: aload_1
    //   734: aload_0
    //   735: invokevirtual 198	java/io/InputStream:read	([B)I
    //   738: istore 5
    //   740: iload 5
    //   742: iconst_m1
    //   743: if_icmpeq +23 -> 766
    //   746: aload_1
    //   747: astore 7
    //   749: aload_1
    //   750: astore 8
    //   752: aload_1
    //   753: astore_3
    //   754: aload 6
    //   756: aload_0
    //   757: iconst_0
    //   758: iload 5
    //   760: invokevirtual 202	java/io/ByteArrayOutputStream:write	([BII)V
    //   763: goto -38 -> 725
    //   766: aload 6
    //   768: astore_0
    //   769: aload_1
    //   770: ifnull +141 -> 911
    //   773: aload_1
    //   774: astore_3
    //   775: aload 6
    //   777: astore_0
    //   778: aload 9
    //   780: astore_1
    //   781: aload 10
    //   783: astore 6
    //   785: aload 11
    //   787: astore 7
    //   789: aload_3
    //   790: invokevirtual 204	java/io/InputStream:close	()V
    //   793: goto +118 -> 911
    //   796: astore_0
    //   797: aload 7
    //   799: astore_1
    //   800: goto +23 -> 823
    //   803: astore 7
    //   805: aload 8
    //   807: astore_1
    //   808: goto +58 -> 866
    //   811: astore_0
    //   812: goto +191 -> 1003
    //   815: astore_3
    //   816: aconst_null
    //   817: astore 6
    //   819: aload_0
    //   820: astore_1
    //   821: aload_3
    //   822: astore_0
    //   823: aload_1
    //   824: astore_3
    //   825: ldc 19
    //   827: iconst_1
    //   828: iconst_3
    //   829: anewarray 4	java/lang/Object
    //   832: dup
    //   833: iconst_0
    //   834: ldc 206
    //   836: aastore
    //   837: dup
    //   838: iconst_1
    //   839: aload_0
    //   840: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   843: aastore
    //   844: dup
    //   845: iconst_2
    //   846: aload_0
    //   847: aastore
    //   848: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   851: aload 6
    //   853: astore_0
    //   854: aload_1
    //   855: ifnull +56 -> 911
    //   858: aload 6
    //   860: astore_0
    //   861: aload_1
    //   862: astore_3
    //   863: goto -85 -> 778
    //   866: aload_1
    //   867: astore_3
    //   868: ldc 19
    //   870: iconst_1
    //   871: iconst_3
    //   872: anewarray 4	java/lang/Object
    //   875: dup
    //   876: iconst_0
    //   877: ldc 211
    //   879: aastore
    //   880: dup
    //   881: iconst_1
    //   882: aload 7
    //   884: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   887: aastore
    //   888: dup
    //   889: iconst_2
    //   890: aload 7
    //   892: aastore
    //   893: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   896: aload 6
    //   898: astore_0
    //   899: aload_1
    //   900: ifnull +11 -> 911
    //   903: aload 6
    //   905: astore_0
    //   906: aload_1
    //   907: astore_3
    //   908: goto -130 -> 778
    //   911: aload_0
    //   912: ifnonnull +9 -> 921
    //   915: ldc 214
    //   917: astore_0
    //   918: goto +402 -> 1320
    //   921: aload 9
    //   923: astore_1
    //   924: aload 10
    //   926: astore 6
    //   928: aload 11
    //   930: astore 7
    //   932: new 36	java/lang/String
    //   935: dup
    //   936: aload_0
    //   937: invokevirtual 218	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   940: invokespecial 221	java/lang/String:<init>	([B)V
    //   943: astore_0
    //   944: goto +376 -> 1320
    //   947: aload_0
    //   948: astore_3
    //   949: aload_0
    //   950: astore_1
    //   951: aload_0
    //   952: astore 6
    //   954: aload_0
    //   955: astore 7
    //   957: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq +154 -> 1114
    //   963: aload_0
    //   964: astore_1
    //   965: aload_0
    //   966: astore 6
    //   968: aload_0
    //   969: astore 7
    //   971: ldc 19
    //   973: iconst_2
    //   974: ldc 226
    //   976: iconst_2
    //   977: anewarray 4	java/lang/Object
    //   980: dup
    //   981: iconst_0
    //   982: iload 4
    //   984: invokestatic 232	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   987: aastore
    //   988: dup
    //   989: iconst_1
    //   990: aload_0
    //   991: aastore
    //   992: invokestatic 236	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   995: invokestatic 239	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   998: aload_0
    //   999: astore_3
    //   1000: goto +114 -> 1114
    //   1003: aload_3
    //   1004: ifnull +18 -> 1022
    //   1007: aload 9
    //   1009: astore_1
    //   1010: aload 10
    //   1012: astore 6
    //   1014: aload 11
    //   1016: astore 7
    //   1018: aload_3
    //   1019: invokevirtual 204	java/io/InputStream:close	()V
    //   1022: aload 9
    //   1024: astore_1
    //   1025: aload 10
    //   1027: astore 6
    //   1029: aload 11
    //   1031: astore 7
    //   1033: aload_0
    //   1034: athrow
    //   1035: aload 9
    //   1037: astore_1
    //   1038: aload 10
    //   1040: astore 6
    //   1042: aload 11
    //   1044: astore 7
    //   1046: new 68	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   1053: astore_0
    //   1054: aload 9
    //   1056: astore_1
    //   1057: aload 10
    //   1059: astore 6
    //   1061: aload 11
    //   1063: astore 7
    //   1065: aload_0
    //   1066: ldc 241
    //   1068: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: pop
    //   1072: aload 9
    //   1074: astore_1
    //   1075: aload 10
    //   1077: astore 6
    //   1079: aload 11
    //   1081: astore 7
    //   1083: aload_0
    //   1084: iload 4
    //   1086: invokevirtual 244	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1089: pop
    //   1090: aload 9
    //   1092: astore_1
    //   1093: aload 10
    //   1095: astore 6
    //   1097: aload 11
    //   1099: astore 7
    //   1101: ldc 19
    //   1103: iconst_1
    //   1104: aload_0
    //   1105: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1108: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1111: aload 8
    //   1113: astore_3
    //   1114: aload_2
    //   1115: ifnull +7 -> 1122
    //   1118: aload_2
    //   1119: invokevirtual 247	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1122: aload_3
    //   1123: areturn
    //   1124: astore_0
    //   1125: goto +169 -> 1294
    //   1128: astore_3
    //   1129: aload_2
    //   1130: astore_0
    //   1131: aload_1
    //   1132: astore_2
    //   1133: goto +31 -> 1164
    //   1136: astore_3
    //   1137: aload 6
    //   1139: astore_0
    //   1140: goto +72 -> 1212
    //   1143: astore_3
    //   1144: aload_2
    //   1145: astore_0
    //   1146: aload 7
    //   1148: astore_2
    //   1149: goto +104 -> 1253
    //   1152: astore_0
    //   1153: aload_1
    //   1154: astore_2
    //   1155: goto +139 -> 1294
    //   1158: astore_3
    //   1159: aconst_null
    //   1160: astore_2
    //   1161: aload 7
    //   1163: astore_0
    //   1164: aload_0
    //   1165: astore_1
    //   1166: ldc 19
    //   1168: iconst_1
    //   1169: iconst_3
    //   1170: anewarray 4	java/lang/Object
    //   1173: dup
    //   1174: iconst_0
    //   1175: ldc 249
    //   1177: aastore
    //   1178: dup
    //   1179: iconst_1
    //   1180: aload_3
    //   1181: invokevirtual 250	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1184: aastore
    //   1185: dup
    //   1186: iconst_2
    //   1187: aload_3
    //   1188: aastore
    //   1189: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1192: aload_2
    //   1193: astore_1
    //   1194: aload_0
    //   1195: ifnull +97 -> 1292
    //   1198: aload_0
    //   1199: astore_1
    //   1200: aload_1
    //   1201: invokevirtual 247	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1204: aload_2
    //   1205: areturn
    //   1206: astore_3
    //   1207: aconst_null
    //   1208: astore_0
    //   1209: aload 12
    //   1211: astore_2
    //   1212: aload_2
    //   1213: astore_1
    //   1214: ldc 19
    //   1216: iconst_1
    //   1217: iconst_3
    //   1218: anewarray 4	java/lang/Object
    //   1221: dup
    //   1222: iconst_0
    //   1223: ldc 252
    //   1225: aastore
    //   1226: dup
    //   1227: iconst_1
    //   1228: aload_3
    //   1229: invokevirtual 209	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1232: aastore
    //   1233: dup
    //   1234: iconst_2
    //   1235: aload_3
    //   1236: aastore
    //   1237: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1240: aload_0
    //   1241: astore_1
    //   1242: aload_2
    //   1243: ifnull +49 -> 1292
    //   1246: aload_2
    //   1247: astore_1
    //   1248: aload_0
    //   1249: astore_2
    //   1250: goto -50 -> 1200
    //   1253: aload_0
    //   1254: astore_1
    //   1255: ldc 19
    //   1257: iconst_1
    //   1258: iconst_3
    //   1259: anewarray 4	java/lang/Object
    //   1262: dup
    //   1263: iconst_0
    //   1264: ldc 254
    //   1266: aastore
    //   1267: dup
    //   1268: iconst_1
    //   1269: aload_3
    //   1270: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1273: aastore
    //   1274: dup
    //   1275: iconst_2
    //   1276: aload_3
    //   1277: aastore
    //   1278: invokestatic 32	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   1281: aload_2
    //   1282: astore_1
    //   1283: aload_0
    //   1284: ifnull +8 -> 1292
    //   1287: aload_0
    //   1288: astore_1
    //   1289: goto -89 -> 1200
    //   1292: aload_1
    //   1293: areturn
    //   1294: aload_2
    //   1295: ifnull +7 -> 1302
    //   1298: aload_2
    //   1299: invokevirtual 247	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1302: goto +5 -> 1307
    //   1305: aload_0
    //   1306: athrow
    //   1307: goto -2 -> 1305
    //   1310: astore 7
    //   1312: aconst_null
    //   1313: astore 6
    //   1315: aload_0
    //   1316: astore_1
    //   1317: goto -451 -> 866
    //   1320: goto -373 -> 947
    //   1323: astore_3
    //   1324: aconst_null
    //   1325: astore_2
    //   1326: aload 13
    //   1328: astore_0
    //   1329: goto -76 -> 1253
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1332	0	paramContext	Context
    //   0	1332	1	paramString	String
    //   0	1332	2	paramBundle1	android.os.Bundle
    //   0	1332	3	paramBundle2	android.os.Bundle
    //   615	470	4	i	int
    //   738	21	5	j	int
    //   58	1256	6	localObject1	Object
    //   13	785	7	localObject2	Object
    //   803	88	7	localIOException1	java.io.IOException
    //   930	232	7	localObject3	Object
    //   1310	1	7	localIOException2	java.io.IOException
    //   22	1090	8	localObject4	Object
    //   1	1090	9	localObject5	Object
    //   4	1090	10	localObject6	Object
    //   7	1091	11	localObject7	Object
    //   16	1194	12	str	String
    //   19	1308	13	localObject8	Object
    //   10	171	14	localObject9	Object
    //   97	165	15	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   662	669	796	java/lang/Exception
    //   679	694	796	java/lang/Exception
    //   702	711	796	java/lang/Exception
    //   719	725	796	java/lang/Exception
    //   733	740	796	java/lang/Exception
    //   754	763	796	java/lang/Exception
    //   662	669	803	java/io/IOException
    //   679	694	803	java/io/IOException
    //   702	711	803	java/io/IOException
    //   719	725	803	java/io/IOException
    //   733	740	803	java/io/IOException
    //   754	763	803	java/io/IOException
    //   643	652	811	finally
    //   662	669	811	finally
    //   679	694	811	finally
    //   702	711	811	finally
    //   719	725	811	finally
    //   733	740	811	finally
    //   754	763	811	finally
    //   825	851	811	finally
    //   868	896	811	finally
    //   643	652	815	java/lang/Exception
    //   207	214	1124	finally
    //   225	232	1124	finally
    //   243	249	1124	finally
    //   260	266	1124	finally
    //   277	285	1124	finally
    //   296	304	1124	finally
    //   319	329	1124	finally
    //   340	349	1124	finally
    //   360	371	1124	finally
    //   382	390	1124	finally
    //   401	409	1124	finally
    //   420	431	1124	finally
    //   445	453	1124	finally
    //   464	471	1124	finally
    //   482	490	1124	finally
    //   501	508	1124	finally
    //   519	527	1124	finally
    //   538	545	1124	finally
    //   556	564	1124	finally
    //   575	585	1124	finally
    //   596	600	1124	finally
    //   611	617	1124	finally
    //   636	641	1124	finally
    //   789	793	1124	finally
    //   932	944	1124	finally
    //   957	963	1124	finally
    //   971	998	1124	finally
    //   1018	1022	1124	finally
    //   1033	1035	1124	finally
    //   1046	1054	1124	finally
    //   1065	1072	1124	finally
    //   1083	1090	1124	finally
    //   1101	1111	1124	finally
    //   207	214	1128	java/lang/Throwable
    //   225	232	1128	java/lang/Throwable
    //   243	249	1128	java/lang/Throwable
    //   260	266	1128	java/lang/Throwable
    //   277	285	1128	java/lang/Throwable
    //   296	304	1128	java/lang/Throwable
    //   319	329	1128	java/lang/Throwable
    //   340	349	1128	java/lang/Throwable
    //   360	371	1128	java/lang/Throwable
    //   382	390	1128	java/lang/Throwable
    //   401	409	1128	java/lang/Throwable
    //   420	431	1128	java/lang/Throwable
    //   445	453	1128	java/lang/Throwable
    //   464	471	1128	java/lang/Throwable
    //   482	490	1128	java/lang/Throwable
    //   501	508	1128	java/lang/Throwable
    //   519	527	1128	java/lang/Throwable
    //   538	545	1128	java/lang/Throwable
    //   556	564	1128	java/lang/Throwable
    //   575	585	1128	java/lang/Throwable
    //   596	600	1128	java/lang/Throwable
    //   611	617	1128	java/lang/Throwable
    //   636	641	1128	java/lang/Throwable
    //   789	793	1128	java/lang/Throwable
    //   932	944	1128	java/lang/Throwable
    //   957	963	1128	java/lang/Throwable
    //   971	998	1128	java/lang/Throwable
    //   1018	1022	1128	java/lang/Throwable
    //   1033	1035	1128	java/lang/Throwable
    //   1046	1054	1128	java/lang/Throwable
    //   1065	1072	1128	java/lang/Throwable
    //   1083	1090	1128	java/lang/Throwable
    //   1101	1111	1128	java/lang/Throwable
    //   207	214	1136	java/lang/Exception
    //   225	232	1136	java/lang/Exception
    //   243	249	1136	java/lang/Exception
    //   260	266	1136	java/lang/Exception
    //   277	285	1136	java/lang/Exception
    //   296	304	1136	java/lang/Exception
    //   319	329	1136	java/lang/Exception
    //   340	349	1136	java/lang/Exception
    //   360	371	1136	java/lang/Exception
    //   382	390	1136	java/lang/Exception
    //   401	409	1136	java/lang/Exception
    //   420	431	1136	java/lang/Exception
    //   445	453	1136	java/lang/Exception
    //   464	471	1136	java/lang/Exception
    //   482	490	1136	java/lang/Exception
    //   501	508	1136	java/lang/Exception
    //   519	527	1136	java/lang/Exception
    //   538	545	1136	java/lang/Exception
    //   556	564	1136	java/lang/Exception
    //   575	585	1136	java/lang/Exception
    //   596	600	1136	java/lang/Exception
    //   611	617	1136	java/lang/Exception
    //   636	641	1136	java/lang/Exception
    //   789	793	1136	java/lang/Exception
    //   932	944	1136	java/lang/Exception
    //   957	963	1136	java/lang/Exception
    //   971	998	1136	java/lang/Exception
    //   1018	1022	1136	java/lang/Exception
    //   1033	1035	1136	java/lang/Exception
    //   1046	1054	1136	java/lang/Exception
    //   1065	1072	1136	java/lang/Exception
    //   1083	1090	1136	java/lang/Exception
    //   1101	1111	1136	java/lang/Exception
    //   207	214	1143	java/io/IOException
    //   225	232	1143	java/io/IOException
    //   243	249	1143	java/io/IOException
    //   260	266	1143	java/io/IOException
    //   277	285	1143	java/io/IOException
    //   296	304	1143	java/io/IOException
    //   319	329	1143	java/io/IOException
    //   340	349	1143	java/io/IOException
    //   360	371	1143	java/io/IOException
    //   382	390	1143	java/io/IOException
    //   401	409	1143	java/io/IOException
    //   420	431	1143	java/io/IOException
    //   445	453	1143	java/io/IOException
    //   464	471	1143	java/io/IOException
    //   482	490	1143	java/io/IOException
    //   501	508	1143	java/io/IOException
    //   519	527	1143	java/io/IOException
    //   538	545	1143	java/io/IOException
    //   556	564	1143	java/io/IOException
    //   575	585	1143	java/io/IOException
    //   596	600	1143	java/io/IOException
    //   611	617	1143	java/io/IOException
    //   636	641	1143	java/io/IOException
    //   789	793	1143	java/io/IOException
    //   932	944	1143	java/io/IOException
    //   957	963	1143	java/io/IOException
    //   971	998	1143	java/io/IOException
    //   1018	1022	1143	java/io/IOException
    //   1033	1035	1143	java/io/IOException
    //   1046	1054	1143	java/io/IOException
    //   1065	1072	1143	java/io/IOException
    //   1083	1090	1143	java/io/IOException
    //   1101	1111	1143	java/io/IOException
    //   170	180	1152	finally
    //   183	196	1152	finally
    //   1166	1192	1152	finally
    //   1214	1240	1152	finally
    //   1255	1281	1152	finally
    //   170	180	1158	java/lang/Throwable
    //   183	196	1158	java/lang/Throwable
    //   170	180	1206	java/lang/Exception
    //   183	196	1206	java/lang/Exception
    //   643	652	1310	java/io/IOException
    //   170	180	1323	java/io/IOException
    //   183	196	1323	java/io/IOException
  }
  
  @NonNull
  private static Proxy a(Context paramContext)
  {
    Proxy localProxy2 = Proxy.NO_PROXY;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    Proxy localProxy1 = localProxy2;
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      localProxy1 = localProxy2;
      if (localObject != null)
      {
        localProxy1 = localProxy2;
        if (NetworkUtil.isMobileNetworkInfo((NetworkInfo)localObject))
        {
          localObject = HttpUtil.getProxyHost(paramContext);
          int i = HttpUtil.getProxyPort(paramContext);
          localProxy1 = localProxy2;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localProxy1 = localProxy2;
            if (i >= 0) {
              localProxy1 = new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String)localObject, i));
            }
          }
        }
      }
    }
    return localProxy1;
  }
  
  private static void a(HttpsURLConnection paramHttpsURLConnection, URL paramURL)
  {
    HomeworkURLUtil.1 local1 = new HomeworkURLUtil.1(paramURL);
    paramHttpsURLConnection.setRequestProperty("host", paramURL.getHost());
    paramHttpsURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(paramURL.getHost(), local1));
    paramHttpsURLConnection.setHostnameVerifier(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.utils.HomeworkURLUtil
 * JD-Core Version:    0.7.0.1
 */