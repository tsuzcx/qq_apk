import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.jetbrains.annotations.NotNull;

public class nlu
{
  /* Error */
  public static String a(Context paramContext, String paramString, android.os.Bundle paramBundle1, android.os.Bundle paramBundle2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 7
    //   12: aload_0
    //   13: ifnonnull +15 -> 28
    //   16: ldc 14
    //   18: iconst_1
    //   19: ldc 16
    //   21: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: ldc 14
    //   30: iconst_1
    //   31: iconst_2
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: ldc 24
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: aload_1
    //   43: aastore
    //   44: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   47: aload_1
    //   48: astore 6
    //   50: aload_1
    //   51: ldc 29
    //   53: invokevirtual 35	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +16 -> 72
    //   59: aload_1
    //   60: iconst_0
    //   61: aload_1
    //   62: bipush 35
    //   64: invokevirtual 39	java/lang/String:indexOf	(I)I
    //   67: invokevirtual 43	java/lang/String:substring	(II)Ljava/lang/String;
    //   70: astore 6
    //   72: aload 6
    //   74: ldc 45
    //   76: ldc 47
    //   78: invokevirtual 51	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   81: astore_1
    //   82: aload_2
    //   83: invokestatic 56	nlw:a	(Landroid/os/Bundle;)Ljava/lang/String;
    //   86: astore 6
    //   88: aload_1
    //   89: astore_2
    //   90: aload 6
    //   92: ifnull +51 -> 143
    //   95: aload_1
    //   96: astore_2
    //   97: aload 6
    //   99: invokevirtual 60	java/lang/String:length	()I
    //   102: ifle +41 -> 143
    //   105: new 62	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   112: aload_1
    //   113: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: astore_2
    //   117: aload_1
    //   118: ldc 72
    //   120: invokevirtual 35	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   123: ifeq +196 -> 319
    //   126: ldc 74
    //   128: astore_1
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 6
    //   136: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore_2
    //   143: aload 10
    //   145: astore_1
    //   146: new 80	java/net/URL
    //   149: dup
    //   150: aload_2
    //   151: invokespecial 83	java/net/URL:<init>	(Ljava/lang/String;)V
    //   154: astore_2
    //   155: aload 10
    //   157: astore_1
    //   158: aload_2
    //   159: aload_0
    //   160: invokestatic 86	nlu:a	(Landroid/content/Context;)Ljava/net/Proxy;
    //   163: invokevirtual 90	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   166: checkcast 92	javax/net/ssl/HttpsURLConnection
    //   169: astore_0
    //   170: aload_0
    //   171: sipush 15000
    //   174: invokevirtual 96	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   177: aload_0
    //   178: sipush 30000
    //   181: invokevirtual 99	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   184: aload_0
    //   185: ldc 101
    //   187: invokevirtual 104	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   190: aload_0
    //   191: aload_2
    //   192: invokestatic 107	nlu:a	(Ljavax/net/ssl/HttpsURLConnection;Ljava/net/URL;)V
    //   195: aload_0
    //   196: ldc 109
    //   198: ldc 111
    //   200: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload_0
    //   204: ldc 117
    //   206: ldc 119
    //   208: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload_3
    //   212: ifnull +113 -> 325
    //   215: aload_3
    //   216: invokevirtual 125	android/os/Bundle:keySet	()Ljava/util/Set;
    //   219: invokeinterface 131 1 0
    //   224: astore_1
    //   225: aload_1
    //   226: invokeinterface 137 1 0
    //   231: ifeq +94 -> 325
    //   234: aload_1
    //   235: invokeinterface 141 1 0
    //   240: checkcast 31	java/lang/String
    //   243: astore_2
    //   244: aload_3
    //   245: aload_2
    //   246: invokevirtual 145	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   249: astore 6
    //   251: aload 6
    //   253: instanceof 31
    //   256: ifeq -31 -> 225
    //   259: aload_0
    //   260: aload_2
    //   261: aload 6
    //   263: checkcast 31	java/lang/String
    //   266: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   269: goto -44 -> 225
    //   272: astore_3
    //   273: aconst_null
    //   274: astore_1
    //   275: aload_0
    //   276: astore_2
    //   277: aload_1
    //   278: astore_0
    //   279: aload_2
    //   280: astore_1
    //   281: ldc 14
    //   283: iconst_1
    //   284: iconst_3
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: ldc 147
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: aload_3
    //   296: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   299: aastore
    //   300: dup
    //   301: iconst_2
    //   302: aload_3
    //   303: aastore
    //   304: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   307: aload_0
    //   308: astore_1
    //   309: aload_2
    //   310: ifnull -284 -> 26
    //   313: aload_2
    //   314: invokevirtual 153	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   317: aload_0
    //   318: areturn
    //   319: ldc 72
    //   321: astore_1
    //   322: goto -193 -> 129
    //   325: aload_0
    //   326: ldc 155
    //   328: new 62	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   335: ldc 157
    //   337: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 163	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   343: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: ldc 165
    //   348: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: getstatic 170	android/os/Build:MODEL	Ljava/lang/String;
    //   354: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc 165
    //   359: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: getstatic 173	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   365: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   368: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokevirtual 115	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   374: aload_0
    //   375: invokevirtual 176	javax/net/ssl/HttpsURLConnection:connect	()V
    //   378: aload_0
    //   379: invokevirtual 179	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   382: istore 4
    //   384: iload 4
    //   386: sipush 200
    //   389: if_icmpne +430 -> 819
    //   392: aload_0
    //   393: invokevirtual 183	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   396: astore_1
    //   397: aload_1
    //   398: astore_3
    //   399: new 185	java/io/ByteArrayOutputStream
    //   402: dup
    //   403: invokespecial 186	java/io/ByteArrayOutputStream:<init>	()V
    //   406: astore 6
    //   408: aload_1
    //   409: astore_2
    //   410: aload_1
    //   411: astore 8
    //   413: aload_1
    //   414: astore_3
    //   415: aload_1
    //   416: astore 7
    //   418: aload_0
    //   419: invokevirtual 189	javax/net/ssl/HttpsURLConnection:getContentEncoding	()Ljava/lang/String;
    //   422: ifnull +45 -> 467
    //   425: aload_1
    //   426: astore_2
    //   427: aload_1
    //   428: astore 8
    //   430: aload_1
    //   431: astore_3
    //   432: aload_1
    //   433: astore 7
    //   435: aload_0
    //   436: invokevirtual 189	javax/net/ssl/HttpsURLConnection:getContentEncoding	()Ljava/lang/String;
    //   439: invokevirtual 192	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   442: ldc 111
    //   444: invokevirtual 35	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   447: ifeq +20 -> 467
    //   450: aload_1
    //   451: astore 8
    //   453: aload_1
    //   454: astore_3
    //   455: aload_1
    //   456: astore 7
    //   458: new 194	java/util/zip/GZIPInputStream
    //   461: dup
    //   462: aload_1
    //   463: invokespecial 197	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   466: astore_2
    //   467: aload_2
    //   468: astore 8
    //   470: aload_2
    //   471: astore_3
    //   472: aload_2
    //   473: astore 7
    //   475: sipush 512
    //   478: newarray byte
    //   480: astore_1
    //   481: aload_2
    //   482: astore 8
    //   484: aload_2
    //   485: astore_3
    //   486: aload_2
    //   487: astore 7
    //   489: aload_2
    //   490: aload_1
    //   491: invokevirtual 203	java/io/InputStream:read	([B)I
    //   494: istore 5
    //   496: iload 5
    //   498: iconst_m1
    //   499: if_icmpeq +119 -> 618
    //   502: aload_2
    //   503: astore 8
    //   505: aload_2
    //   506: astore_3
    //   507: aload_2
    //   508: astore 7
    //   510: aload 6
    //   512: aload_1
    //   513: iconst_0
    //   514: iload 5
    //   516: invokevirtual 207	java/io/ByteArrayOutputStream:write	([BII)V
    //   519: goto -38 -> 481
    //   522: astore_2
    //   523: aload 8
    //   525: astore_1
    //   526: aload_1
    //   527: astore_3
    //   528: ldc 14
    //   530: iconst_1
    //   531: iconst_3
    //   532: anewarray 4	java/lang/Object
    //   535: dup
    //   536: iconst_0
    //   537: ldc 209
    //   539: aastore
    //   540: dup
    //   541: iconst_1
    //   542: aload_2
    //   543: invokevirtual 150	java/io/IOException:getMessage	()Ljava/lang/String;
    //   546: aastore
    //   547: dup
    //   548: iconst_2
    //   549: aload_2
    //   550: aastore
    //   551: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   554: aload 6
    //   556: astore_3
    //   557: aload_1
    //   558: ifnull +10 -> 568
    //   561: aload_1
    //   562: invokevirtual 211	java/io/InputStream:close	()V
    //   565: aload 6
    //   567: astore_3
    //   568: aload_3
    //   569: ifnonnull +235 -> 804
    //   572: ldc 213
    //   574: astore_1
    //   575: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +30 -> 608
    //   581: ldc 14
    //   583: iconst_2
    //   584: ldc 218
    //   586: iconst_2
    //   587: anewarray 4	java/lang/Object
    //   590: dup
    //   591: iconst_0
    //   592: iload 4
    //   594: invokestatic 224	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   597: aastore
    //   598: dup
    //   599: iconst_1
    //   600: aload_1
    //   601: aastore
    //   602: invokestatic 228	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   605: invokestatic 231	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_0
    //   609: ifnull +312 -> 921
    //   612: aload_0
    //   613: invokevirtual 153	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   616: aload_1
    //   617: areturn
    //   618: aload 6
    //   620: astore_3
    //   621: aload_2
    //   622: ifnull -54 -> 568
    //   625: aload_2
    //   626: invokevirtual 211	java/io/InputStream:close	()V
    //   629: aload 6
    //   631: astore_3
    //   632: goto -64 -> 568
    //   635: astore_3
    //   636: aconst_null
    //   637: astore_1
    //   638: aload_0
    //   639: astore_2
    //   640: aload_1
    //   641: astore_0
    //   642: aload_2
    //   643: astore_1
    //   644: ldc 14
    //   646: iconst_1
    //   647: iconst_3
    //   648: anewarray 4	java/lang/Object
    //   651: dup
    //   652: iconst_0
    //   653: ldc 233
    //   655: aastore
    //   656: dup
    //   657: iconst_1
    //   658: aload_3
    //   659: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   662: aastore
    //   663: dup
    //   664: iconst_2
    //   665: aload_3
    //   666: aastore
    //   667: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   670: aload_0
    //   671: astore_1
    //   672: aload_2
    //   673: ifnull -647 -> 26
    //   676: aload_2
    //   677: invokevirtual 153	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   680: aload_0
    //   681: areturn
    //   682: astore_2
    //   683: aconst_null
    //   684: astore 6
    //   686: aload_1
    //   687: astore_3
    //   688: ldc 14
    //   690: iconst_1
    //   691: iconst_3
    //   692: anewarray 4	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: ldc 236
    //   699: aastore
    //   700: dup
    //   701: iconst_1
    //   702: aload_2
    //   703: invokevirtual 234	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   706: aastore
    //   707: dup
    //   708: iconst_2
    //   709: aload_2
    //   710: aastore
    //   711: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   714: aload 6
    //   716: astore_3
    //   717: aload_1
    //   718: ifnull -150 -> 568
    //   721: aload_1
    //   722: invokevirtual 211	java/io/InputStream:close	()V
    //   725: aload 6
    //   727: astore_3
    //   728: goto -160 -> 568
    //   731: astore_3
    //   732: aconst_null
    //   733: astore_1
    //   734: aload_0
    //   735: astore_2
    //   736: aload_1
    //   737: astore_0
    //   738: aload_2
    //   739: astore_1
    //   740: ldc 14
    //   742: iconst_1
    //   743: iconst_3
    //   744: anewarray 4	java/lang/Object
    //   747: dup
    //   748: iconst_0
    //   749: ldc 238
    //   751: aastore
    //   752: dup
    //   753: iconst_1
    //   754: aload_3
    //   755: invokevirtual 239	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   758: aastore
    //   759: dup
    //   760: iconst_2
    //   761: aload_3
    //   762: aastore
    //   763: invokestatic 27	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   766: aload_0
    //   767: astore_1
    //   768: aload_2
    //   769: ifnull -743 -> 26
    //   772: aload_2
    //   773: invokevirtual 153	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   776: aload_0
    //   777: areturn
    //   778: astore_1
    //   779: aload_3
    //   780: ifnull +7 -> 787
    //   783: aload_3
    //   784: invokevirtual 211	java/io/InputStream:close	()V
    //   787: aload_1
    //   788: athrow
    //   789: astore_1
    //   790: aload_0
    //   791: astore_2
    //   792: aload_1
    //   793: astore_0
    //   794: aload_2
    //   795: ifnull +7 -> 802
    //   798: aload_2
    //   799: invokevirtual 153	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   802: aload_0
    //   803: athrow
    //   804: new 31	java/lang/String
    //   807: dup
    //   808: aload_3
    //   809: invokevirtual 243	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   812: invokespecial 246	java/lang/String:<init>	([B)V
    //   815: astore_1
    //   816: goto -241 -> 575
    //   819: ldc 14
    //   821: iconst_1
    //   822: new 62	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   829: ldc 248
    //   831: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: iload 4
    //   836: invokevirtual 251	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 22	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: aconst_null
    //   846: astore_1
    //   847: goto -239 -> 608
    //   850: astore_0
    //   851: aload_1
    //   852: astore_2
    //   853: goto -59 -> 794
    //   856: astore_3
    //   857: aconst_null
    //   858: astore_0
    //   859: aload 9
    //   861: astore_2
    //   862: goto -124 -> 738
    //   865: astore_3
    //   866: aload_0
    //   867: astore_2
    //   868: aload_1
    //   869: astore_0
    //   870: goto -132 -> 738
    //   873: astore_3
    //   874: aconst_null
    //   875: astore_0
    //   876: aload 8
    //   878: astore_2
    //   879: goto -237 -> 642
    //   882: astore_3
    //   883: aload_0
    //   884: astore_2
    //   885: aload_1
    //   886: astore_0
    //   887: goto -245 -> 642
    //   890: astore_3
    //   891: aconst_null
    //   892: astore_0
    //   893: aload 7
    //   895: astore_2
    //   896: goto -617 -> 279
    //   899: astore_3
    //   900: aload_0
    //   901: astore_2
    //   902: aload_1
    //   903: astore_0
    //   904: goto -625 -> 279
    //   907: astore_2
    //   908: aload 7
    //   910: astore_1
    //   911: goto -225 -> 686
    //   914: astore_2
    //   915: aconst_null
    //   916: astore 6
    //   918: goto -392 -> 526
    //   921: aload_1
    //   922: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	paramContext	Context
    //   0	923	1	paramString	String
    //   0	923	2	paramBundle1	android.os.Bundle
    //   0	923	3	paramBundle2	android.os.Bundle
    //   382	453	4	i	int
    //   494	21	5	j	int
    //   48	869	6	localObject1	Object
    //   10	899	7	localObject2	Object
    //   1	876	8	localObject3	Object
    //   4	856	9	localObject4	Object
    //   7	149	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   170	211	272	java/io/IOException
    //   215	225	272	java/io/IOException
    //   225	269	272	java/io/IOException
    //   325	384	272	java/io/IOException
    //   392	397	272	java/io/IOException
    //   561	565	272	java/io/IOException
    //   625	629	272	java/io/IOException
    //   721	725	272	java/io/IOException
    //   783	787	272	java/io/IOException
    //   787	789	272	java/io/IOException
    //   804	816	272	java/io/IOException
    //   819	845	272	java/io/IOException
    //   418	425	522	java/io/IOException
    //   435	450	522	java/io/IOException
    //   458	467	522	java/io/IOException
    //   475	481	522	java/io/IOException
    //   489	496	522	java/io/IOException
    //   510	519	522	java/io/IOException
    //   170	211	635	java/lang/Exception
    //   215	225	635	java/lang/Exception
    //   225	269	635	java/lang/Exception
    //   325	384	635	java/lang/Exception
    //   392	397	635	java/lang/Exception
    //   561	565	635	java/lang/Exception
    //   625	629	635	java/lang/Exception
    //   721	725	635	java/lang/Exception
    //   783	787	635	java/lang/Exception
    //   787	789	635	java/lang/Exception
    //   804	816	635	java/lang/Exception
    //   819	845	635	java/lang/Exception
    //   399	408	682	java/lang/Exception
    //   170	211	731	java/lang/Throwable
    //   215	225	731	java/lang/Throwable
    //   225	269	731	java/lang/Throwable
    //   325	384	731	java/lang/Throwable
    //   392	397	731	java/lang/Throwable
    //   561	565	731	java/lang/Throwable
    //   625	629	731	java/lang/Throwable
    //   721	725	731	java/lang/Throwable
    //   783	787	731	java/lang/Throwable
    //   787	789	731	java/lang/Throwable
    //   804	816	731	java/lang/Throwable
    //   819	845	731	java/lang/Throwable
    //   399	408	778	finally
    //   418	425	778	finally
    //   435	450	778	finally
    //   458	467	778	finally
    //   475	481	778	finally
    //   489	496	778	finally
    //   510	519	778	finally
    //   528	554	778	finally
    //   688	714	778	finally
    //   170	211	789	finally
    //   215	225	789	finally
    //   225	269	789	finally
    //   325	384	789	finally
    //   392	397	789	finally
    //   561	565	789	finally
    //   575	608	789	finally
    //   625	629	789	finally
    //   721	725	789	finally
    //   783	787	789	finally
    //   787	789	789	finally
    //   804	816	789	finally
    //   819	845	789	finally
    //   146	155	850	finally
    //   158	170	850	finally
    //   281	307	850	finally
    //   644	670	850	finally
    //   740	766	850	finally
    //   146	155	856	java/lang/Throwable
    //   158	170	856	java/lang/Throwable
    //   575	608	865	java/lang/Throwable
    //   146	155	873	java/lang/Exception
    //   158	170	873	java/lang/Exception
    //   575	608	882	java/lang/Exception
    //   146	155	890	java/io/IOException
    //   158	170	890	java/io/IOException
    //   575	608	899	java/io/IOException
    //   418	425	907	java/lang/Exception
    //   435	450	907	java/lang/Exception
    //   458	467	907	java/lang/Exception
    //   475	481	907	java/lang/Exception
    //   489	496	907	java/lang/Exception
    //   510	519	907	java/lang/Exception
    //   399	408	914	java/io/IOException
  }
  
  @NotNull
  private static Proxy a(Context paramContext)
  {
    Proxy localProxy = Proxy.NO_PROXY;
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject != null) && (bgnt.a((NetworkInfo)localObject)))
      {
        localObject = nlw.a(paramContext);
        int i = nlw.a(paramContext);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i >= 0)) {
          return new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String)localObject, i));
        }
      }
    }
    return localProxy;
  }
  
  private static void a(HttpsURLConnection paramHttpsURLConnection, URL paramURL)
  {
    nlv localnlv = new nlv(paramURL);
    paramHttpsURLConnection.setRequestProperty("host", paramURL.getHost());
    paramHttpsURLConnection.setSSLSocketFactory(new bgvb(paramURL.getHost(), localnlv));
    paramHttpsURLConnection.setHostnameVerifier(localnlv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nlu
 * JD-Core Version:    0.7.0.1
 */