package com.tencent.securemodule;

import android.content.Context;
import android.net.Proxy;
import android.os.Environment;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.client.methods.HttpGet;

public class ae
  extends ad
{
  private Context c;
  private HttpGet d = null;
  private String e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private int i = 0;
  private boolean j = false;
  private boolean k = false;
  private long l = 0L;
  
  public ae(Context paramContext)
  {
    this.c = paramContext;
    this.j = "mounted".equals(Environment.getExternalStorageState());
    if (this.j) {
      this.e = "/sdcard/qqsecure";
    }
    for (this.f = "/sdcard/qqsecure";; this.f = paramContext.getFilesDir().getAbsolutePath())
    {
      this.d = new HttpGet();
      if (af.c(paramContext) == af.a.b)
      {
        a(Proxy.getDefaultHost(), Proxy.getDefaultPort());
        a(true);
      }
      return;
      this.e = paramContext.getCacheDir().getAbsolutePath();
    }
  }
  
  /* Error */
  private int a(org.apache.http.HttpEntity paramHttpEntity, android.os.Bundle paramBundle, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 22
    //   3: aconst_null
    //   4: astore 23
    //   6: aconst_null
    //   7: astore 24
    //   9: aconst_null
    //   10: astore 25
    //   12: aconst_null
    //   13: astore 12
    //   15: aconst_null
    //   16: astore 21
    //   18: aconst_null
    //   19: astore 16
    //   21: aconst_null
    //   22: astore 17
    //   24: aconst_null
    //   25: astore 18
    //   27: aconst_null
    //   28: astore 19
    //   30: aconst_null
    //   31: astore 26
    //   33: aconst_null
    //   34: astore 20
    //   36: aconst_null
    //   37: astore 15
    //   39: sipush 8192
    //   42: newarray byte
    //   44: astore 27
    //   46: aload 26
    //   48: astore 13
    //   50: aload 12
    //   52: astore 14
    //   54: aload_1
    //   55: invokeinterface 123 1 0
    //   60: aload_0
    //   61: getfield 43	com/tencent/securemodule/ae:l	J
    //   64: ladd
    //   65: lstore 8
    //   67: aload 26
    //   69: astore 13
    //   71: aload 12
    //   73: astore 14
    //   75: aload_0
    //   76: getfield 43	com/tencent/securemodule/ae:l	J
    //   79: ldc2_w 124
    //   82: lmul
    //   83: lload 8
    //   85: ldiv
    //   86: l2i
    //   87: istore 4
    //   89: aload 26
    //   91: astore 13
    //   93: aload 12
    //   95: astore 14
    //   97: aload_2
    //   98: ldc 127
    //   100: lload 8
    //   102: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   105: aload 26
    //   107: astore 13
    //   109: aload 12
    //   111: astore 14
    //   113: aload_2
    //   114: ldc 135
    //   116: aload_0
    //   117: getfield 43	com/tencent/securemodule/ae:l	J
    //   120: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   123: aload 26
    //   125: astore 13
    //   127: aload 12
    //   129: astore 14
    //   131: aload_2
    //   132: ldc 137
    //   134: iload 4
    //   136: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   139: aload 26
    //   141: astore 13
    //   143: aload 12
    //   145: astore 14
    //   147: new 99	java/io/File
    //   150: dup
    //   151: new 142	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   158: aload_0
    //   159: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   162: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   168: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_0
    //   172: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   175: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   184: astore 28
    //   186: aload 26
    //   188: astore 13
    //   190: aload 12
    //   192: astore 14
    //   194: aload 28
    //   196: invokevirtual 160	java/io/File:exists	()Z
    //   199: ifne +34 -> 233
    //   202: aload 26
    //   204: astore 13
    //   206: aload 12
    //   208: astore 14
    //   210: aload 28
    //   212: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   215: invokevirtual 166	java/io/File:mkdirs	()Z
    //   218: pop
    //   219: aload 26
    //   221: astore 13
    //   223: aload 12
    //   225: astore 14
    //   227: aload 28
    //   229: invokevirtual 169	java/io/File:createNewFile	()Z
    //   232: pop
    //   233: aload 26
    //   235: astore 13
    //   237: aload 12
    //   239: astore 14
    //   241: new 171	java/io/FileOutputStream
    //   244: dup
    //   245: aload 28
    //   247: iconst_1
    //   248: invokespecial 174	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   251: astore 12
    //   253: iload_3
    //   254: ifeq +87 -> 341
    //   257: new 176	java/util/zip/InflaterInputStream
    //   260: dup
    //   261: aload_1
    //   262: invokeinterface 180 1 0
    //   267: invokespecial 183	java/util/zip/InflaterInputStream:<init>	(Ljava/io/InputStream;)V
    //   270: astore 13
    //   272: iconst_0
    //   273: istore 5
    //   275: aload 13
    //   277: aload 27
    //   279: invokevirtual 189	java/io/InputStream:read	([B)I
    //   282: istore 7
    //   284: iload 7
    //   286: iconst_m1
    //   287: if_icmpeq +176 -> 463
    //   290: aload_0
    //   291: getfield 41	com/tencent/securemodule/ae:k	Z
    //   294: istore_3
    //   295: iload_3
    //   296: ifeq +86 -> 382
    //   299: aload 13
    //   301: ifnull +15 -> 316
    //   304: ldc 191
    //   306: ldc 193
    //   308: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   311: aload 13
    //   313: invokevirtual 201	java/io/InputStream:close	()V
    //   316: aload 12
    //   318: ifnull +15 -> 333
    //   321: ldc 191
    //   323: ldc 203
    //   325: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   328: aload 12
    //   330: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   333: sipush -5003
    //   336: istore 4
    //   338: iload 4
    //   340: ireturn
    //   341: aload_1
    //   342: invokeinterface 180 1 0
    //   347: astore 13
    //   349: goto -77 -> 272
    //   352: astore_1
    //   353: ldc 191
    //   355: ldc 206
    //   357: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   360: aload_1
    //   361: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   364: goto -48 -> 316
    //   367: astore_1
    //   368: ldc 191
    //   370: ldc 213
    //   372: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   375: aload_1
    //   376: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   379: goto -46 -> 333
    //   382: aload_0
    //   383: aload_0
    //   384: getfield 43	com/tencent/securemodule/ae:l	J
    //   387: iload 7
    //   389: i2l
    //   390: ladd
    //   391: putfield 43	com/tencent/securemodule/ae:l	J
    //   394: aload_2
    //   395: ldc 135
    //   397: aload_0
    //   398: getfield 43	com/tencent/securemodule/ae:l	J
    //   401: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   404: aload_0
    //   405: getfield 43	com/tencent/securemodule/ae:l	J
    //   408: ldc2_w 124
    //   411: lmul
    //   412: lload 8
    //   414: ldiv
    //   415: l2i
    //   416: istore 6
    //   418: iload 6
    //   420: iload 4
    //   422: if_icmpeq +1020 -> 1442
    //   425: aload_2
    //   426: ldc 137
    //   428: iload 6
    //   430: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   433: aload_0
    //   434: iconst_2
    //   435: aload_2
    //   436: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   439: iload 6
    //   441: istore 4
    //   443: aload 12
    //   445: aload 27
    //   447: iconst_0
    //   448: iload 7
    //   450: invokevirtual 220	java/io/FileOutputStream:write	([BII)V
    //   453: iload 5
    //   455: iload 7
    //   457: iadd
    //   458: istore 5
    //   460: goto -185 -> 275
    //   463: aload 12
    //   465: invokevirtual 223	java/io/FileOutputStream:flush	()V
    //   468: iload 5
    //   470: i2l
    //   471: lstore 8
    //   473: aload_1
    //   474: invokeinterface 123 1 0
    //   479: lstore 10
    //   481: lload 8
    //   483: lload 10
    //   485: lcmp
    //   486: ifne +71 -> 557
    //   489: iconst_0
    //   490: istore 4
    //   492: iload 4
    //   494: istore 5
    //   496: aload 13
    //   498: ifnull +83 -> 581
    //   501: ldc 191
    //   503: ldc 193
    //   505: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   508: aload 13
    //   510: invokevirtual 201	java/io/InputStream:close	()V
    //   513: iload 4
    //   515: istore 5
    //   517: iload 5
    //   519: istore 4
    //   521: aload 12
    //   523: ifnull -185 -> 338
    //   526: ldc 191
    //   528: ldc 203
    //   530: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   533: aload 12
    //   535: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   538: iload 5
    //   540: ireturn
    //   541: astore_1
    //   542: ldc 191
    //   544: ldc 213
    //   546: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   549: aload_1
    //   550: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   553: sipush -7000
    //   556: ireturn
    //   557: bipush 249
    //   559: istore 4
    //   561: goto -69 -> 492
    //   564: astore_1
    //   565: sipush -7000
    //   568: istore 5
    //   570: ldc 191
    //   572: ldc 206
    //   574: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   577: aload_1
    //   578: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   581: goto -64 -> 517
    //   584: astore_2
    //   585: aload 21
    //   587: astore_1
    //   588: aload 15
    //   590: astore 12
    //   592: aload 12
    //   594: astore 13
    //   596: aload_1
    //   597: astore 14
    //   599: ldc 191
    //   601: ldc 225
    //   603: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   606: aload 12
    //   608: astore 13
    //   610: aload_1
    //   611: astore 14
    //   613: aload_2
    //   614: invokevirtual 226	java/io/FileNotFoundException:printStackTrace	()V
    //   617: aload 12
    //   619: ifnull +815 -> 1434
    //   622: ldc 191
    //   624: ldc 193
    //   626: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   629: aload 12
    //   631: invokevirtual 201	java/io/InputStream:close	()V
    //   634: sipush -7001
    //   637: istore 5
    //   639: iload 5
    //   641: istore 4
    //   643: aload_1
    //   644: ifnull -306 -> 338
    //   647: ldc 191
    //   649: ldc 203
    //   651: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   654: aload_1
    //   655: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   658: iload 5
    //   660: ireturn
    //   661: astore_1
    //   662: ldc 191
    //   664: ldc 213
    //   666: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   669: aload_1
    //   670: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   673: sipush -7000
    //   676: ireturn
    //   677: astore_2
    //   678: sipush -7000
    //   681: istore 5
    //   683: ldc 191
    //   685: ldc 206
    //   687: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   690: aload_2
    //   691: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   694: goto -55 -> 639
    //   697: astore_2
    //   698: aload 22
    //   700: astore_1
    //   701: aload 16
    //   703: astore 12
    //   705: aload 12
    //   707: astore 13
    //   709: aload_1
    //   710: astore 14
    //   712: ldc 191
    //   714: new 142	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   721: ldc 228
    //   723: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload_2
    //   727: invokevirtual 231	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   730: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   739: aload 12
    //   741: astore 13
    //   743: aload_1
    //   744: astore 14
    //   746: aload_2
    //   747: invokevirtual 232	java/net/SocketException:printStackTrace	()V
    //   750: aload 12
    //   752: ifnull +674 -> 1426
    //   755: ldc 191
    //   757: ldc 193
    //   759: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   762: aload 12
    //   764: invokevirtual 201	java/io/InputStream:close	()V
    //   767: sipush -5054
    //   770: istore 5
    //   772: iload 5
    //   774: istore 4
    //   776: aload_1
    //   777: ifnull -439 -> 338
    //   780: ldc 191
    //   782: ldc 203
    //   784: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   787: aload_1
    //   788: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   791: iload 5
    //   793: ireturn
    //   794: astore_1
    //   795: ldc 191
    //   797: ldc 213
    //   799: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   802: aload_1
    //   803: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   806: sipush -7000
    //   809: ireturn
    //   810: astore_2
    //   811: sipush -7000
    //   814: istore 5
    //   816: ldc 191
    //   818: ldc 206
    //   820: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   823: aload_2
    //   824: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   827: goto -55 -> 772
    //   830: astore_2
    //   831: aload 23
    //   833: astore_1
    //   834: aload 17
    //   836: astore 12
    //   838: aload 12
    //   840: astore 13
    //   842: aload_1
    //   843: astore 14
    //   845: ldc 191
    //   847: new 142	java/lang/StringBuilder
    //   850: dup
    //   851: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   854: ldc 234
    //   856: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload_2
    //   860: invokevirtual 235	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   863: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   872: aload 12
    //   874: astore 13
    //   876: aload_1
    //   877: astore 14
    //   879: aload_2
    //   880: invokevirtual 236	java/net/SocketTimeoutException:printStackTrace	()V
    //   883: aload 12
    //   885: ifnull +533 -> 1418
    //   888: ldc 191
    //   890: ldc 193
    //   892: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   895: aload 12
    //   897: invokevirtual 201	java/io/InputStream:close	()V
    //   900: sipush -5055
    //   903: istore 5
    //   905: iload 5
    //   907: istore 4
    //   909: aload_1
    //   910: ifnull -572 -> 338
    //   913: ldc 191
    //   915: ldc 203
    //   917: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   920: aload_1
    //   921: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   924: iload 5
    //   926: ireturn
    //   927: astore_1
    //   928: ldc 191
    //   930: ldc 213
    //   932: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   935: aload_1
    //   936: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   939: sipush -7000
    //   942: ireturn
    //   943: astore_2
    //   944: sipush -7000
    //   947: istore 5
    //   949: ldc 191
    //   951: ldc 206
    //   953: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   956: aload_2
    //   957: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   960: goto -55 -> 905
    //   963: astore_2
    //   964: aload 24
    //   966: astore_1
    //   967: aload 18
    //   969: astore 12
    //   971: aload 12
    //   973: astore 13
    //   975: aload_1
    //   976: astore 14
    //   978: ldc 191
    //   980: ldc 238
    //   982: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   985: aload 12
    //   987: astore 13
    //   989: aload_1
    //   990: astore 14
    //   992: aload_2
    //   993: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   996: aload 12
    //   998: ifnull +412 -> 1410
    //   1001: ldc 191
    //   1003: ldc 193
    //   1005: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1008: aload 12
    //   1010: invokevirtual 201	java/io/InputStream:close	()V
    //   1013: sipush -5056
    //   1016: istore 5
    //   1018: iload 5
    //   1020: istore 4
    //   1022: aload_1
    //   1023: ifnull -685 -> 338
    //   1026: ldc 191
    //   1028: ldc 203
    //   1030: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1033: aload_1
    //   1034: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   1037: iload 5
    //   1039: ireturn
    //   1040: astore_1
    //   1041: ldc 191
    //   1043: ldc 213
    //   1045: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1048: aload_1
    //   1049: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1052: sipush -7000
    //   1055: ireturn
    //   1056: astore_2
    //   1057: sipush -7000
    //   1060: istore 5
    //   1062: ldc 191
    //   1064: ldc 206
    //   1066: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1069: aload_2
    //   1070: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1073: goto -55 -> 1018
    //   1076: astore_2
    //   1077: aload 25
    //   1079: astore_1
    //   1080: aload 19
    //   1082: astore 12
    //   1084: aload 12
    //   1086: astore 13
    //   1088: aload_1
    //   1089: astore 14
    //   1091: ldc 191
    //   1093: aload_2
    //   1094: invokevirtual 239	java/lang/Exception:toString	()Ljava/lang/String;
    //   1097: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1100: aload 12
    //   1102: astore 13
    //   1104: aload_1
    //   1105: astore 14
    //   1107: ldc 191
    //   1109: ldc 241
    //   1111: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1114: aload 12
    //   1116: astore 13
    //   1118: aload_1
    //   1119: astore 14
    //   1121: aload_2
    //   1122: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   1125: aload 12
    //   1127: ifnull +275 -> 1402
    //   1130: ldc 191
    //   1132: ldc 193
    //   1134: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1137: aload 12
    //   1139: invokevirtual 201	java/io/InputStream:close	()V
    //   1142: sipush -5000
    //   1145: istore 5
    //   1147: iload 5
    //   1149: istore 4
    //   1151: aload_1
    //   1152: ifnull -814 -> 338
    //   1155: ldc 191
    //   1157: ldc 203
    //   1159: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1162: aload_1
    //   1163: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   1166: iload 5
    //   1168: ireturn
    //   1169: astore_1
    //   1170: ldc 191
    //   1172: ldc 213
    //   1174: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1177: aload_1
    //   1178: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1181: sipush -7000
    //   1184: ireturn
    //   1185: astore_2
    //   1186: sipush -7000
    //   1189: istore 5
    //   1191: ldc 191
    //   1193: ldc 206
    //   1195: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1198: aload_2
    //   1199: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1202: goto -55 -> 1147
    //   1205: astore_1
    //   1206: aload 13
    //   1208: ifnull +15 -> 1223
    //   1211: ldc 191
    //   1213: ldc 193
    //   1215: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1218: aload 13
    //   1220: invokevirtual 201	java/io/InputStream:close	()V
    //   1223: aload 14
    //   1225: ifnull +15 -> 1240
    //   1228: ldc 191
    //   1230: ldc 203
    //   1232: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1235: aload 14
    //   1237: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   1240: aload_1
    //   1241: athrow
    //   1242: astore_2
    //   1243: ldc 191
    //   1245: ldc 206
    //   1247: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1250: aload_2
    //   1251: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1254: goto -31 -> 1223
    //   1257: astore_2
    //   1258: ldc 191
    //   1260: ldc 213
    //   1262: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1265: aload_2
    //   1266: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1269: goto -29 -> 1240
    //   1272: astore_1
    //   1273: aload 20
    //   1275: astore 13
    //   1277: aload 12
    //   1279: astore 14
    //   1281: goto -75 -> 1206
    //   1284: astore_1
    //   1285: aload 12
    //   1287: astore 14
    //   1289: goto -83 -> 1206
    //   1292: astore_2
    //   1293: aload 12
    //   1295: astore_1
    //   1296: aload 19
    //   1298: astore 12
    //   1300: goto -216 -> 1084
    //   1303: astore_2
    //   1304: aload 12
    //   1306: astore_1
    //   1307: aload 13
    //   1309: astore 12
    //   1311: goto -227 -> 1084
    //   1314: astore_2
    //   1315: aload 12
    //   1317: astore_1
    //   1318: aload 18
    //   1320: astore 12
    //   1322: goto -351 -> 971
    //   1325: astore_2
    //   1326: aload 12
    //   1328: astore_1
    //   1329: aload 13
    //   1331: astore 12
    //   1333: goto -362 -> 971
    //   1336: astore_2
    //   1337: aload 12
    //   1339: astore_1
    //   1340: aload 17
    //   1342: astore 12
    //   1344: goto -506 -> 838
    //   1347: astore_2
    //   1348: aload 12
    //   1350: astore_1
    //   1351: aload 13
    //   1353: astore 12
    //   1355: goto -517 -> 838
    //   1358: astore_2
    //   1359: aload 12
    //   1361: astore_1
    //   1362: aload 16
    //   1364: astore 12
    //   1366: goto -661 -> 705
    //   1369: astore_2
    //   1370: aload 12
    //   1372: astore_1
    //   1373: aload 13
    //   1375: astore 12
    //   1377: goto -672 -> 705
    //   1380: astore_2
    //   1381: aload 12
    //   1383: astore_1
    //   1384: aload 15
    //   1386: astore 12
    //   1388: goto -796 -> 592
    //   1391: astore_2
    //   1392: aload 12
    //   1394: astore_1
    //   1395: aload 13
    //   1397: astore 12
    //   1399: goto -807 -> 592
    //   1402: sipush -5000
    //   1405: istore 5
    //   1407: goto -260 -> 1147
    //   1410: sipush -5056
    //   1413: istore 5
    //   1415: goto -397 -> 1018
    //   1418: sipush -5055
    //   1421: istore 5
    //   1423: goto -518 -> 905
    //   1426: sipush -5054
    //   1429: istore 5
    //   1431: goto -659 -> 772
    //   1434: sipush -7001
    //   1437: istore 5
    //   1439: goto -800 -> 639
    //   1442: goto -999 -> 443
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1445	0	this	ae
    //   0	1445	1	paramHttpEntity	org.apache.http.HttpEntity
    //   0	1445	2	paramBundle	android.os.Bundle
    //   0	1445	3	paramBoolean	boolean
    //   87	1063	4	m	int
    //   273	1165	5	n	int
    //   416	24	6	i1	int
    //   282	176	7	i2	int
    //   65	417	8	l1	long
    //   479	5	10	l2	long
    //   13	1385	12	localObject1	Object
    //   48	1348	13	localObject2	Object
    //   52	1236	14	localObject3	Object
    //   37	1348	15	localObject4	Object
    //   19	1344	16	localObject5	Object
    //   22	1319	17	localObject6	Object
    //   25	1294	18	localObject7	Object
    //   28	1269	19	localObject8	Object
    //   34	1240	20	localObject9	Object
    //   16	570	21	localObject10	Object
    //   1	698	22	localObject11	Object
    //   4	828	23	localObject12	Object
    //   7	958	24	localObject13	Object
    //   10	1068	25	localObject14	Object
    //   31	203	26	localObject15	Object
    //   44	402	27	arrayOfByte	byte[]
    //   184	62	28	localFile	File
    // Exception table:
    //   from	to	target	type
    //   311	316	352	java/io/IOException
    //   328	333	367	java/io/IOException
    //   533	538	541	java/io/IOException
    //   508	513	564	java/io/IOException
    //   54	67	584	java/io/FileNotFoundException
    //   75	89	584	java/io/FileNotFoundException
    //   97	105	584	java/io/FileNotFoundException
    //   113	123	584	java/io/FileNotFoundException
    //   131	139	584	java/io/FileNotFoundException
    //   147	186	584	java/io/FileNotFoundException
    //   194	202	584	java/io/FileNotFoundException
    //   210	219	584	java/io/FileNotFoundException
    //   227	233	584	java/io/FileNotFoundException
    //   241	253	584	java/io/FileNotFoundException
    //   654	658	661	java/io/IOException
    //   629	634	677	java/io/IOException
    //   54	67	697	java/net/SocketException
    //   75	89	697	java/net/SocketException
    //   97	105	697	java/net/SocketException
    //   113	123	697	java/net/SocketException
    //   131	139	697	java/net/SocketException
    //   147	186	697	java/net/SocketException
    //   194	202	697	java/net/SocketException
    //   210	219	697	java/net/SocketException
    //   227	233	697	java/net/SocketException
    //   241	253	697	java/net/SocketException
    //   787	791	794	java/io/IOException
    //   762	767	810	java/io/IOException
    //   54	67	830	java/net/SocketTimeoutException
    //   75	89	830	java/net/SocketTimeoutException
    //   97	105	830	java/net/SocketTimeoutException
    //   113	123	830	java/net/SocketTimeoutException
    //   131	139	830	java/net/SocketTimeoutException
    //   147	186	830	java/net/SocketTimeoutException
    //   194	202	830	java/net/SocketTimeoutException
    //   210	219	830	java/net/SocketTimeoutException
    //   227	233	830	java/net/SocketTimeoutException
    //   241	253	830	java/net/SocketTimeoutException
    //   920	924	927	java/io/IOException
    //   895	900	943	java/io/IOException
    //   54	67	963	java/io/IOException
    //   75	89	963	java/io/IOException
    //   97	105	963	java/io/IOException
    //   113	123	963	java/io/IOException
    //   131	139	963	java/io/IOException
    //   147	186	963	java/io/IOException
    //   194	202	963	java/io/IOException
    //   210	219	963	java/io/IOException
    //   227	233	963	java/io/IOException
    //   241	253	963	java/io/IOException
    //   1033	1037	1040	java/io/IOException
    //   1008	1013	1056	java/io/IOException
    //   54	67	1076	java/lang/Exception
    //   75	89	1076	java/lang/Exception
    //   97	105	1076	java/lang/Exception
    //   113	123	1076	java/lang/Exception
    //   131	139	1076	java/lang/Exception
    //   147	186	1076	java/lang/Exception
    //   194	202	1076	java/lang/Exception
    //   210	219	1076	java/lang/Exception
    //   227	233	1076	java/lang/Exception
    //   241	253	1076	java/lang/Exception
    //   1162	1166	1169	java/io/IOException
    //   1137	1142	1185	java/io/IOException
    //   54	67	1205	finally
    //   75	89	1205	finally
    //   97	105	1205	finally
    //   113	123	1205	finally
    //   131	139	1205	finally
    //   147	186	1205	finally
    //   194	202	1205	finally
    //   210	219	1205	finally
    //   227	233	1205	finally
    //   241	253	1205	finally
    //   599	606	1205	finally
    //   613	617	1205	finally
    //   712	739	1205	finally
    //   746	750	1205	finally
    //   845	872	1205	finally
    //   879	883	1205	finally
    //   978	985	1205	finally
    //   992	996	1205	finally
    //   1091	1100	1205	finally
    //   1107	1114	1205	finally
    //   1121	1125	1205	finally
    //   1218	1223	1242	java/io/IOException
    //   1235	1240	1257	java/io/IOException
    //   257	272	1272	finally
    //   341	349	1272	finally
    //   275	284	1284	finally
    //   290	295	1284	finally
    //   382	418	1284	finally
    //   425	439	1284	finally
    //   443	453	1284	finally
    //   463	468	1284	finally
    //   473	481	1284	finally
    //   257	272	1292	java/lang/Exception
    //   341	349	1292	java/lang/Exception
    //   275	284	1303	java/lang/Exception
    //   290	295	1303	java/lang/Exception
    //   382	418	1303	java/lang/Exception
    //   425	439	1303	java/lang/Exception
    //   443	453	1303	java/lang/Exception
    //   463	468	1303	java/lang/Exception
    //   473	481	1303	java/lang/Exception
    //   257	272	1314	java/io/IOException
    //   341	349	1314	java/io/IOException
    //   275	284	1325	java/io/IOException
    //   290	295	1325	java/io/IOException
    //   382	418	1325	java/io/IOException
    //   425	439	1325	java/io/IOException
    //   443	453	1325	java/io/IOException
    //   463	468	1325	java/io/IOException
    //   473	481	1325	java/io/IOException
    //   257	272	1336	java/net/SocketTimeoutException
    //   341	349	1336	java/net/SocketTimeoutException
    //   275	284	1347	java/net/SocketTimeoutException
    //   290	295	1347	java/net/SocketTimeoutException
    //   382	418	1347	java/net/SocketTimeoutException
    //   425	439	1347	java/net/SocketTimeoutException
    //   443	453	1347	java/net/SocketTimeoutException
    //   463	468	1347	java/net/SocketTimeoutException
    //   473	481	1347	java/net/SocketTimeoutException
    //   257	272	1358	java/net/SocketException
    //   341	349	1358	java/net/SocketException
    //   275	284	1369	java/net/SocketException
    //   290	295	1369	java/net/SocketException
    //   382	418	1369	java/net/SocketException
    //   425	439	1369	java/net/SocketException
    //   443	453	1369	java/net/SocketException
    //   463	468	1369	java/net/SocketException
    //   473	481	1369	java/net/SocketException
    //   257	272	1380	java/io/FileNotFoundException
    //   341	349	1380	java/io/FileNotFoundException
    //   275	284	1391	java/io/FileNotFoundException
    //   290	295	1391	java/io/FileNotFoundException
    //   382	418	1391	java/io/FileNotFoundException
    //   425	439	1391	java/io/FileNotFoundException
    //   443	453	1391	java/io/FileNotFoundException
    //   463	468	1391	java/io/FileNotFoundException
    //   473	481	1391	java/io/FileNotFoundException
  }
  
  /* Error */
  private int b(boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 13
    //   5: aconst_null
    //   6: astore 14
    //   8: aconst_null
    //   9: astore 11
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 12
    //   17: sipush -7000
    //   20: istore_3
    //   21: ldc 245
    //   23: new 142	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   30: aload_0
    //   31: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   34: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   40: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: aload_0
    //   44: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   47: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   56: ldc 245
    //   58: new 142	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   65: aload_0
    //   66: getfield 31	com/tencent/securemodule/ae:f	Ljava/lang/String;
    //   69: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   75: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   82: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   91: new 99	java/io/File
    //   94: dup
    //   95: new 142	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   102: aload_0
    //   103: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   106: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   112: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload_0
    //   116: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   119: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore 7
    //   130: aload 7
    //   132: invokevirtual 160	java/io/File:exists	()Z
    //   135: ifeq +367 -> 502
    //   138: aload_0
    //   139: getfield 39	com/tencent/securemodule/ae:j	Z
    //   142: ifne +168 -> 310
    //   145: aload_0
    //   146: getfield 37	com/tencent/securemodule/ae:i	I
    //   149: iconst_1
    //   150: if_icmpne +160 -> 310
    //   153: aload_0
    //   154: getfield 45	com/tencent/securemodule/ae:c	Landroid/content/Context;
    //   157: aload_0
    //   158: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   161: iconst_1
    //   162: invokevirtual 249	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   165: astore 6
    //   167: aload 7
    //   169: astore 10
    //   171: aload 8
    //   173: astore 11
    //   175: aload 6
    //   177: astore 9
    //   179: new 251	java/io/FileInputStream
    //   182: dup
    //   183: aload 7
    //   185: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   188: astore 8
    //   190: sipush 1024
    //   193: newarray byte
    //   195: astore 11
    //   197: aload 8
    //   199: aload 11
    //   201: invokevirtual 255	java/io/FileInputStream:read	([B)I
    //   204: istore 5
    //   206: iload_2
    //   207: istore 4
    //   209: aload 8
    //   211: astore 10
    //   213: aload 6
    //   215: astore 9
    //   217: iload 5
    //   219: iconst_m1
    //   220: if_icmpeq +293 -> 513
    //   223: aload 6
    //   225: aload 11
    //   227: iconst_0
    //   228: iload 5
    //   230: invokevirtual 220	java/io/FileOutputStream:write	([BII)V
    //   233: goto -36 -> 197
    //   236: astore 9
    //   238: aload 8
    //   240: astore 11
    //   242: aload 9
    //   244: astore 8
    //   246: ldc 191
    //   248: ldc 225
    //   250: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   253: aload 8
    //   255: invokevirtual 226	java/io/FileNotFoundException:printStackTrace	()V
    //   258: aload 11
    //   260: ifnull +792 -> 1052
    //   263: aload 11
    //   265: invokevirtual 256	java/io/FileInputStream:close	()V
    //   268: sipush -7001
    //   271: istore_2
    //   272: aload 6
    //   274: ifnull +773 -> 1047
    //   277: aload 6
    //   279: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   282: iload_2
    //   283: istore_3
    //   284: iload_3
    //   285: istore_2
    //   286: iload_1
    //   287: ifeq +21 -> 308
    //   290: iload_3
    //   291: istore_2
    //   292: aload 7
    //   294: invokevirtual 160	java/io/File:exists	()Z
    //   297: ifeq +11 -> 308
    //   300: aload 7
    //   302: invokevirtual 259	java/io/File:delete	()Z
    //   305: pop
    //   306: iload_3
    //   307: istore_2
    //   308: iload_2
    //   309: ireturn
    //   310: new 99	java/io/File
    //   313: dup
    //   314: new 142	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   321: aload_0
    //   322: getfield 31	com/tencent/securemodule/ae:f	Ljava/lang/String;
    //   325: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   331: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   338: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   347: astore 6
    //   349: aload 6
    //   351: invokevirtual 160	java/io/File:exists	()Z
    //   354: ifeq +23 -> 377
    //   357: aload 6
    //   359: invokevirtual 259	java/io/File:delete	()Z
    //   362: pop
    //   363: new 171	java/io/FileOutputStream
    //   366: dup
    //   367: aload 6
    //   369: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   372: astore 6
    //   374: goto -207 -> 167
    //   377: aload 6
    //   379: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   382: invokevirtual 166	java/io/File:mkdirs	()Z
    //   385: pop
    //   386: aload 6
    //   388: invokevirtual 169	java/io/File:createNewFile	()Z
    //   391: pop
    //   392: new 171	java/io/FileOutputStream
    //   395: dup
    //   396: aload 6
    //   398: invokespecial 260	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   401: astore 6
    //   403: goto -236 -> 167
    //   406: astore 8
    //   408: aconst_null
    //   409: astore 6
    //   411: aload 13
    //   413: astore 12
    //   415: aload 7
    //   417: astore 10
    //   419: aload 12
    //   421: astore 11
    //   423: aload 6
    //   425: astore 9
    //   427: ldc 191
    //   429: ldc_w 262
    //   432: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   435: aload 7
    //   437: astore 10
    //   439: aload 12
    //   441: astore 11
    //   443: aload 6
    //   445: astore 9
    //   447: aload 8
    //   449: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   452: aload 12
    //   454: ifnull +586 -> 1040
    //   457: aload 12
    //   459: invokevirtual 256	java/io/FileInputStream:close	()V
    //   462: sipush -7056
    //   465: istore_2
    //   466: aload 6
    //   468: ifnull +567 -> 1035
    //   471: aload 6
    //   473: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   476: iload_2
    //   477: istore_3
    //   478: iload_3
    //   479: istore_2
    //   480: iload_1
    //   481: ifeq -173 -> 308
    //   484: iload_3
    //   485: istore_2
    //   486: aload 7
    //   488: invokevirtual 160	java/io/File:exists	()Z
    //   491: ifeq -183 -> 308
    //   494: aload 7
    //   496: invokevirtual 259	java/io/File:delete	()Z
    //   499: pop
    //   500: iload_3
    //   501: ireturn
    //   502: aconst_null
    //   503: astore 10
    //   505: aconst_null
    //   506: astore 9
    //   508: sipush -7001
    //   511: istore 4
    //   513: iload 4
    //   515: istore_2
    //   516: aload 10
    //   518: ifnull +11 -> 529
    //   521: aload 10
    //   523: invokevirtual 256	java/io/FileInputStream:close	()V
    //   526: iload 4
    //   528: istore_2
    //   529: aload 9
    //   531: ifnull +528 -> 1059
    //   534: aload 9
    //   536: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   539: iload_2
    //   540: istore_3
    //   541: iload_3
    //   542: istore_2
    //   543: iload_1
    //   544: ifeq -236 -> 308
    //   547: iload_3
    //   548: istore_2
    //   549: aload 7
    //   551: invokevirtual 160	java/io/File:exists	()Z
    //   554: ifeq -246 -> 308
    //   557: aload 7
    //   559: invokevirtual 259	java/io/File:delete	()Z
    //   562: pop
    //   563: iload_3
    //   564: ireturn
    //   565: astore 6
    //   567: ldc 191
    //   569: ldc_w 264
    //   572: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   575: aload 6
    //   577: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   580: sipush -7000
    //   583: istore_2
    //   584: goto -55 -> 529
    //   587: astore 6
    //   589: ldc 191
    //   591: ldc_w 266
    //   594: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   597: aload 6
    //   599: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   602: goto -61 -> 541
    //   605: astore 8
    //   607: ldc 191
    //   609: ldc_w 264
    //   612: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   615: aload 8
    //   617: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   620: sipush -7000
    //   623: istore_2
    //   624: goto -352 -> 272
    //   627: astore 6
    //   629: ldc 191
    //   631: ldc_w 266
    //   634: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   637: aload 6
    //   639: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   642: goto -358 -> 284
    //   645: astore 8
    //   647: ldc 191
    //   649: ldc_w 264
    //   652: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   655: aload 8
    //   657: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   660: sipush -7000
    //   663: istore_2
    //   664: goto -198 -> 466
    //   667: astore 6
    //   669: ldc 191
    //   671: ldc_w 266
    //   674: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   677: aload 6
    //   679: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   682: goto -204 -> 478
    //   685: astore 8
    //   687: aconst_null
    //   688: astore 7
    //   690: aconst_null
    //   691: astore 6
    //   693: aload 14
    //   695: astore 12
    //   697: aload 7
    //   699: astore 10
    //   701: aload 12
    //   703: astore 11
    //   705: aload 6
    //   707: astore 9
    //   709: ldc 191
    //   711: ldc_w 268
    //   714: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   717: aload 7
    //   719: astore 10
    //   721: aload 12
    //   723: astore 11
    //   725: aload 6
    //   727: astore 9
    //   729: aload 8
    //   731: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   734: aload 12
    //   736: ifnull +8 -> 744
    //   739: aload 12
    //   741: invokevirtual 256	java/io/FileInputStream:close	()V
    //   744: aload 6
    //   746: ifnull +8 -> 754
    //   749: aload 6
    //   751: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   754: iload_3
    //   755: istore_2
    //   756: iload_1
    //   757: ifeq -449 -> 308
    //   760: iload_3
    //   761: istore_2
    //   762: aload 7
    //   764: invokevirtual 160	java/io/File:exists	()Z
    //   767: ifeq -459 -> 308
    //   770: aload 7
    //   772: invokevirtual 259	java/io/File:delete	()Z
    //   775: pop
    //   776: sipush -7000
    //   779: ireturn
    //   780: astore 8
    //   782: ldc 191
    //   784: ldc_w 264
    //   787: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   790: aload 8
    //   792: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   795: goto -51 -> 744
    //   798: astore 6
    //   800: ldc 191
    //   802: ldc_w 266
    //   805: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   808: aload 6
    //   810: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   813: goto -59 -> 754
    //   816: astore 8
    //   818: aconst_null
    //   819: astore 7
    //   821: aconst_null
    //   822: astore 6
    //   824: aload 11
    //   826: ifnull +8 -> 834
    //   829: aload 11
    //   831: invokevirtual 256	java/io/FileInputStream:close	()V
    //   834: aload 6
    //   836: ifnull +8 -> 844
    //   839: aload 6
    //   841: invokevirtual 204	java/io/FileOutputStream:close	()V
    //   844: iload_1
    //   845: ifeq +17 -> 862
    //   848: aload 7
    //   850: invokevirtual 160	java/io/File:exists	()Z
    //   853: ifeq +9 -> 862
    //   856: aload 7
    //   858: invokevirtual 259	java/io/File:delete	()Z
    //   861: pop
    //   862: aload 8
    //   864: athrow
    //   865: astore 9
    //   867: ldc 191
    //   869: ldc_w 264
    //   872: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   875: aload 9
    //   877: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   880: goto -46 -> 834
    //   883: astore 6
    //   885: ldc 191
    //   887: ldc_w 266
    //   890: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   893: aload 6
    //   895: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   898: goto -54 -> 844
    //   901: astore 8
    //   903: aconst_null
    //   904: astore 6
    //   906: goto -82 -> 824
    //   909: astore 8
    //   911: aload 10
    //   913: astore 7
    //   915: aload 9
    //   917: astore 6
    //   919: goto -95 -> 824
    //   922: astore 9
    //   924: aload 8
    //   926: astore 11
    //   928: aload 9
    //   930: astore 8
    //   932: goto -108 -> 824
    //   935: astore 8
    //   937: goto -113 -> 824
    //   940: astore 8
    //   942: aconst_null
    //   943: astore 6
    //   945: aload 14
    //   947: astore 12
    //   949: goto -252 -> 697
    //   952: astore 8
    //   954: aload 14
    //   956: astore 12
    //   958: goto -261 -> 697
    //   961: astore 9
    //   963: aload 8
    //   965: astore 12
    //   967: aload 9
    //   969: astore 8
    //   971: goto -274 -> 697
    //   974: astore 8
    //   976: aconst_null
    //   977: astore 7
    //   979: aconst_null
    //   980: astore 6
    //   982: aload 13
    //   984: astore 12
    //   986: goto -571 -> 415
    //   989: astore 8
    //   991: aload 13
    //   993: astore 12
    //   995: goto -580 -> 415
    //   998: astore 9
    //   1000: aload 8
    //   1002: astore 12
    //   1004: aload 9
    //   1006: astore 8
    //   1008: goto -593 -> 415
    //   1011: astore 8
    //   1013: aconst_null
    //   1014: astore 7
    //   1016: aconst_null
    //   1017: astore 6
    //   1019: aload 12
    //   1021: astore 11
    //   1023: goto -777 -> 246
    //   1026: astore 8
    //   1028: aload 12
    //   1030: astore 11
    //   1032: goto -786 -> 246
    //   1035: iload_2
    //   1036: istore_3
    //   1037: goto -559 -> 478
    //   1040: sipush -7056
    //   1043: istore_2
    //   1044: goto -578 -> 466
    //   1047: iload_2
    //   1048: istore_3
    //   1049: goto -765 -> 284
    //   1052: sipush -7001
    //   1055: istore_2
    //   1056: goto -784 -> 272
    //   1059: iload_2
    //   1060: istore_3
    //   1061: goto -520 -> 541
    //   1064: astore 8
    //   1066: aconst_null
    //   1067: astore 6
    //   1069: aload 12
    //   1071: astore 11
    //   1073: goto -827 -> 246
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1076	0	this	ae
    //   0	1076	1	paramBoolean	boolean
    //   1	1059	2	m	int
    //   20	1041	3	n	int
    //   207	320	4	i1	int
    //   204	25	5	i2	int
    //   165	307	6	localObject1	Object
    //   565	11	6	localIOException1	java.io.IOException
    //   587	11	6	localIOException2	java.io.IOException
    //   627	11	6	localIOException3	java.io.IOException
    //   667	11	6	localIOException4	java.io.IOException
    //   691	59	6	localObject2	Object
    //   798	11	6	localIOException5	java.io.IOException
    //   822	18	6	localObject3	Object
    //   883	11	6	localIOException6	java.io.IOException
    //   904	164	6	localObject4	Object
    //   128	887	7	localObject5	Object
    //   12	242	8	localObject6	Object
    //   406	42	8	localIOException7	java.io.IOException
    //   605	11	8	localIOException8	java.io.IOException
    //   645	11	8	localIOException9	java.io.IOException
    //   685	45	8	localException1	java.lang.Exception
    //   780	11	8	localIOException10	java.io.IOException
    //   816	47	8	localObject7	Object
    //   901	1	8	localObject8	Object
    //   909	16	8	localObject9	Object
    //   930	1	8	localObject10	Object
    //   935	1	8	localObject11	Object
    //   940	1	8	localException2	java.lang.Exception
    //   952	12	8	localException3	java.lang.Exception
    //   969	1	8	localObject12	Object
    //   974	1	8	localIOException11	java.io.IOException
    //   989	12	8	localIOException12	java.io.IOException
    //   1006	1	8	localObject13	Object
    //   1011	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1026	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   1064	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   177	39	9	localObject14	Object
    //   236	7	9	localFileNotFoundException4	java.io.FileNotFoundException
    //   425	303	9	localObject15	Object
    //   865	51	9	localIOException13	java.io.IOException
    //   922	7	9	localObject16	Object
    //   961	7	9	localException4	java.lang.Exception
    //   998	7	9	localIOException14	java.io.IOException
    //   169	743	10	localObject17	Object
    //   9	1063	11	localObject18	Object
    //   15	1055	12	localObject19	Object
    //   3	989	13	localObject20	Object
    //   6	949	14	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   190	197	236	java/io/FileNotFoundException
    //   197	206	236	java/io/FileNotFoundException
    //   223	233	236	java/io/FileNotFoundException
    //   130	167	406	java/io/IOException
    //   310	374	406	java/io/IOException
    //   377	403	406	java/io/IOException
    //   521	526	565	java/io/IOException
    //   534	539	587	java/io/IOException
    //   263	268	605	java/io/IOException
    //   277	282	627	java/io/IOException
    //   457	462	645	java/io/IOException
    //   471	476	667	java/io/IOException
    //   91	130	685	java/lang/Exception
    //   739	744	780	java/io/IOException
    //   749	754	798	java/io/IOException
    //   91	130	816	finally
    //   829	834	865	java/io/IOException
    //   839	844	883	java/io/IOException
    //   130	167	901	finally
    //   310	374	901	finally
    //   377	403	901	finally
    //   179	190	909	finally
    //   427	435	909	finally
    //   447	452	909	finally
    //   709	717	909	finally
    //   729	734	909	finally
    //   190	197	922	finally
    //   197	206	922	finally
    //   223	233	922	finally
    //   246	258	935	finally
    //   130	167	940	java/lang/Exception
    //   310	374	940	java/lang/Exception
    //   377	403	940	java/lang/Exception
    //   179	190	952	java/lang/Exception
    //   190	197	961	java/lang/Exception
    //   197	206	961	java/lang/Exception
    //   223	233	961	java/lang/Exception
    //   91	130	974	java/io/IOException
    //   179	190	989	java/io/IOException
    //   190	197	998	java/io/IOException
    //   197	206	998	java/io/IOException
    //   223	233	998	java/io/IOException
    //   91	130	1011	java/io/FileNotFoundException
    //   179	190	1026	java/io/FileNotFoundException
    //   130	167	1064	java/io/FileNotFoundException
    //   310	374	1064	java/io/FileNotFoundException
    //   377	403	1064	java/io/FileNotFoundException
  }
  
  private int c(String paramString)
  {
    localObject = null;
    try
    {
      paramString = new URI(paramString);
      m = -1000;
    }
    catch (URISyntaxException paramString)
    {
      for (;;)
      {
        ax.a("HttpBase", "url error: " + paramString.getMessage());
        paramString.printStackTrace();
        int m = -1053;
        paramString = localObject;
      }
    }
    if (paramString != null)
    {
      this.d.setURI(paramString);
      m = 0;
    }
    return m;
  }
  
  /* Error */
  public int a(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush -3000
    //   3: istore 4
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 9
    //   11: aconst_null
    //   12: astore 10
    //   14: new 129	android/os/Bundle
    //   17: dup
    //   18: invokespecial 286	android/os/Bundle:<init>	()V
    //   21: astore 11
    //   23: aload 9
    //   25: astore 7
    //   27: iload 4
    //   29: istore_3
    //   30: aload_0
    //   31: invokevirtual 289	com/tencent/securemodule/ae:a	()Lorg/apache/http/client/HttpClient;
    //   34: astore 6
    //   36: aload 9
    //   38: astore 7
    //   40: aload 6
    //   42: astore 8
    //   44: iload 4
    //   46: istore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 291	com/tencent/securemodule/ae:c	(Ljava/lang/String;)I
    //   52: istore 4
    //   54: iload 4
    //   56: ifeq +58 -> 114
    //   59: iload 4
    //   61: istore_3
    //   62: aload 10
    //   64: astore_1
    //   65: aload 6
    //   67: ifnull +15 -> 82
    //   70: aload 6
    //   72: invokeinterface 297 1 0
    //   77: invokeinterface 302 1 0
    //   82: aload_1
    //   83: ifnull +3 -> 86
    //   86: iload_3
    //   87: ifeq +25 -> 112
    //   90: iload_3
    //   91: bipush 249
    //   93: if_icmpeq +19 -> 112
    //   96: aload 11
    //   98: ldc_w 304
    //   101: iload_3
    //   102: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   105: aload_0
    //   106: iconst_1
    //   107: aload 11
    //   109: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   112: iload_3
    //   113: ireturn
    //   114: aload 9
    //   116: astore 7
    //   118: aload 6
    //   120: astore 8
    //   122: iload 4
    //   124: istore_3
    //   125: aload_0
    //   126: getfield 41	com/tencent/securemodule/ae:k	Z
    //   129: ifeq +13 -> 142
    //   132: sipush -3003
    //   135: istore_3
    //   136: aload 10
    //   138: astore_1
    //   139: goto -74 -> 65
    //   142: aload 9
    //   144: astore 7
    //   146: aload 6
    //   148: astore 8
    //   150: iload 4
    //   152: istore_3
    //   153: aload_0
    //   154: getfield 27	com/tencent/securemodule/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   157: invokevirtual 308	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   160: ifnonnull +33 -> 193
    //   163: sipush -3053
    //   166: istore_3
    //   167: aload 9
    //   169: astore 7
    //   171: aload 6
    //   173: astore 8
    //   175: ldc 191
    //   177: ldc_w 310
    //   180: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   183: sipush -3053
    //   186: istore_3
    //   187: aload 10
    //   189: astore_1
    //   190: goto -125 -> 65
    //   193: aload 9
    //   195: astore 7
    //   197: aload 6
    //   199: astore 8
    //   201: iload 4
    //   203: istore_3
    //   204: aload_1
    //   205: invokestatic 315	com/tencent/securemodule/az:c	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore_1
    //   209: aload 9
    //   211: astore 7
    //   213: aload 6
    //   215: astore 8
    //   217: iload 4
    //   219: istore_3
    //   220: aload_0
    //   221: new 142	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   228: aload_1
    //   229: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc_w 317
    //   235: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: putfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   244: aload 9
    //   246: astore 7
    //   248: aload 6
    //   250: astore 8
    //   252: iload 4
    //   254: istore_3
    //   255: aload_0
    //   256: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   259: ifnonnull +19 -> 278
    //   262: aload 9
    //   264: astore 7
    //   266: aload 6
    //   268: astore 8
    //   270: iload 4
    //   272: istore_3
    //   273: aload_0
    //   274: aload_1
    //   275: putfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   278: aload 9
    //   280: astore 7
    //   282: aload 6
    //   284: astore 8
    //   286: iload 4
    //   288: istore_3
    //   289: new 99	java/io/File
    //   292: dup
    //   293: new 142	java/lang/StringBuilder
    //   296: dup
    //   297: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   300: aload_0
    //   301: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   304: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   310: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_0
    //   314: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   317: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   326: astore_1
    //   327: aload 9
    //   329: astore 7
    //   331: aload 6
    //   333: astore 8
    //   335: iload 4
    //   337: istore_3
    //   338: aload_1
    //   339: invokevirtual 160	java/io/File:exists	()Z
    //   342: ifeq +72 -> 414
    //   345: aload 9
    //   347: astore 7
    //   349: aload 6
    //   351: astore 8
    //   353: iload 4
    //   355: istore_3
    //   356: aload_0
    //   357: aload_1
    //   358: invokevirtual 320	java/io/File:length	()J
    //   361: putfield 43	com/tencent/securemodule/ae:l	J
    //   364: aload 9
    //   366: astore 7
    //   368: aload 6
    //   370: astore 8
    //   372: iload 4
    //   374: istore_3
    //   375: aload_0
    //   376: getfield 27	com/tencent/securemodule/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   379: ldc_w 322
    //   382: new 142	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 324
    //   392: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_0
    //   396: getfield 43	com/tencent/securemodule/ae:l	J
    //   399: invokevirtual 327	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   402: ldc_w 329
    //   405: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokevirtual 333	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   414: aload 9
    //   416: astore 7
    //   418: aload 6
    //   420: astore 8
    //   422: iload 4
    //   424: istore_3
    //   425: aload 6
    //   427: aload_0
    //   428: getfield 27	com/tencent/securemodule/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   431: invokeinterface 337 2 0
    //   436: astore_1
    //   437: aload_1
    //   438: astore 7
    //   440: aload 6
    //   442: astore 8
    //   444: iload 4
    //   446: istore_3
    //   447: aload_1
    //   448: invokeinterface 343 1 0
    //   453: invokeinterface 348 1 0
    //   458: istore 5
    //   460: aload_1
    //   461: astore 7
    //   463: aload 6
    //   465: astore 8
    //   467: iload 4
    //   469: istore_3
    //   470: ldc 191
    //   472: new 142	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 350
    //   482: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: iload 5
    //   487: invokevirtual 353	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   490: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 198	com/tencent/securemodule/ax:b	(Ljava/lang/String;Ljava/lang/Object;)V
    //   496: iload 5
    //   498: sipush 200
    //   501: if_icmpeq +21 -> 522
    //   504: iload 5
    //   506: sipush 206
    //   509: if_icmpeq +13 -> 522
    //   512: sipush -3000
    //   515: iload 5
    //   517: isub
    //   518: istore_3
    //   519: goto -454 -> 65
    //   522: aload_1
    //   523: astore 7
    //   525: aload 6
    //   527: astore 8
    //   529: iload 4
    //   531: istore_3
    //   532: aload_0
    //   533: getfield 41	com/tencent/securemodule/ae:k	Z
    //   536: ifeq +10 -> 546
    //   539: sipush -3003
    //   542: istore_3
    //   543: goto -478 -> 65
    //   546: aload_1
    //   547: astore 7
    //   549: aload 6
    //   551: astore 8
    //   553: iload 4
    //   555: istore_3
    //   556: aload_1
    //   557: invokeinterface 357 1 0
    //   562: astore 9
    //   564: aload 9
    //   566: ifnonnull +29 -> 595
    //   569: sipush -4000
    //   572: istore_3
    //   573: aload_1
    //   574: astore 7
    //   576: aload 6
    //   578: astore 8
    //   580: ldc 191
    //   582: ldc_w 359
    //   585: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   588: sipush -4000
    //   591: istore_3
    //   592: goto -527 -> 65
    //   595: aload_1
    //   596: astore 7
    //   598: aload 6
    //   600: astore 8
    //   602: iload 4
    //   604: istore_3
    //   605: aload_0
    //   606: aload 9
    //   608: aload 11
    //   610: iload_2
    //   611: invokespecial 361	com/tencent/securemodule/ae:a	(Lorg/apache/http/HttpEntity;Landroid/os/Bundle;Z)I
    //   614: istore 4
    //   616: iload 4
    //   618: ifeq +16 -> 634
    //   621: iload 4
    //   623: bipush 249
    //   625: if_icmpne +782 -> 1407
    //   628: iload 4
    //   630: istore_3
    //   631: goto -566 -> 65
    //   634: aload_1
    //   635: astore 7
    //   637: aload 6
    //   639: astore 8
    //   641: iload 4
    //   643: istore_3
    //   644: aload_0
    //   645: iconst_1
    //   646: invokespecial 363	com/tencent/securemodule/ae:b	(Z)I
    //   649: istore 4
    //   651: iload 4
    //   653: ifeq +9 -> 662
    //   656: iload 4
    //   658: istore_3
    //   659: goto -594 -> 65
    //   662: iconst_0
    //   663: istore_3
    //   664: goto -599 -> 65
    //   667: astore 9
    //   669: aconst_null
    //   670: astore 8
    //   672: aconst_null
    //   673: astore 7
    //   675: sipush -3051
    //   678: istore 4
    //   680: iload 4
    //   682: istore_3
    //   683: aload 7
    //   685: astore 6
    //   687: aload 8
    //   689: astore_1
    //   690: ldc 191
    //   692: new 142	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   699: ldc_w 365
    //   702: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: aload 9
    //   707: invokevirtual 366	org/apache/http/client/ClientProtocolException:getMessage	()Ljava/lang/String;
    //   710: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   719: iload 4
    //   721: istore_3
    //   722: aload 7
    //   724: astore 6
    //   726: aload 8
    //   728: astore_1
    //   729: aload 9
    //   731: invokevirtual 367	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   734: aload 8
    //   736: ifnull +15 -> 751
    //   739: aload 8
    //   741: invokeinterface 297 1 0
    //   746: invokeinterface 302 1 0
    //   751: aload 7
    //   753: ifnull +3 -> 756
    //   756: aload 11
    //   758: ldc_w 304
    //   761: sipush -3051
    //   764: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   767: aload_0
    //   768: iconst_1
    //   769: aload 11
    //   771: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   774: sipush -3051
    //   777: ireturn
    //   778: astore 9
    //   780: aconst_null
    //   781: astore 8
    //   783: aconst_null
    //   784: astore 7
    //   786: sipush -3054
    //   789: istore 4
    //   791: iload 4
    //   793: istore_3
    //   794: aload 7
    //   796: astore 6
    //   798: aload 8
    //   800: astore_1
    //   801: ldc 191
    //   803: new 142	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   810: ldc 228
    //   812: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: aload 9
    //   817: invokevirtual 231	java/net/SocketException:getMessage	()Ljava/lang/String;
    //   820: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   829: iload 4
    //   831: istore_3
    //   832: aload 7
    //   834: astore 6
    //   836: aload 8
    //   838: astore_1
    //   839: aload 9
    //   841: invokevirtual 232	java/net/SocketException:printStackTrace	()V
    //   844: aload 8
    //   846: ifnull +15 -> 861
    //   849: aload 8
    //   851: invokeinterface 297 1 0
    //   856: invokeinterface 302 1 0
    //   861: aload 7
    //   863: ifnull +3 -> 866
    //   866: aload 11
    //   868: ldc_w 304
    //   871: sipush -3054
    //   874: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   877: aload_0
    //   878: iconst_1
    //   879: aload 11
    //   881: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   884: sipush -3054
    //   887: ireturn
    //   888: astore 9
    //   890: aconst_null
    //   891: astore 8
    //   893: aconst_null
    //   894: astore 7
    //   896: sipush -3055
    //   899: istore 4
    //   901: iload 4
    //   903: istore_3
    //   904: aload 7
    //   906: astore 6
    //   908: aload 8
    //   910: astore_1
    //   911: ldc 191
    //   913: new 142	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   920: ldc 234
    //   922: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   925: aload 9
    //   927: invokevirtual 235	java/net/SocketTimeoutException:getMessage	()Ljava/lang/String;
    //   930: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   933: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   936: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   939: iload 4
    //   941: istore_3
    //   942: aload 7
    //   944: astore 6
    //   946: aload 8
    //   948: astore_1
    //   949: aload 9
    //   951: invokevirtual 236	java/net/SocketTimeoutException:printStackTrace	()V
    //   954: aload 8
    //   956: ifnull +15 -> 971
    //   959: aload 8
    //   961: invokeinterface 297 1 0
    //   966: invokeinterface 302 1 0
    //   971: aload 7
    //   973: ifnull +3 -> 976
    //   976: aload 11
    //   978: ldc_w 304
    //   981: sipush -3055
    //   984: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   987: aload_0
    //   988: iconst_1
    //   989: aload 11
    //   991: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   994: sipush -3055
    //   997: ireturn
    //   998: astore 9
    //   1000: aconst_null
    //   1001: astore 8
    //   1003: aconst_null
    //   1004: astore 7
    //   1006: sipush -3056
    //   1009: istore 4
    //   1011: iload 4
    //   1013: istore_3
    //   1014: aload 7
    //   1016: astore 6
    //   1018: aload 8
    //   1020: astore_1
    //   1021: ldc 191
    //   1023: new 142	java/lang/StringBuilder
    //   1026: dup
    //   1027: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1030: ldc_w 369
    //   1033: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1036: aload 9
    //   1038: invokevirtual 370	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1041: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1047: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1050: iload 4
    //   1052: istore_3
    //   1053: aload 7
    //   1055: astore 6
    //   1057: aload 8
    //   1059: astore_1
    //   1060: aload 9
    //   1062: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   1065: aload 8
    //   1067: ifnull +15 -> 1082
    //   1070: aload 8
    //   1072: invokeinterface 297 1 0
    //   1077: invokeinterface 302 1 0
    //   1082: aload 7
    //   1084: ifnull +3 -> 1087
    //   1087: aload 11
    //   1089: ldc_w 304
    //   1092: sipush -3056
    //   1095: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1098: aload_0
    //   1099: iconst_1
    //   1100: aload 11
    //   1102: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   1105: sipush -3056
    //   1108: ireturn
    //   1109: astore 9
    //   1111: aconst_null
    //   1112: astore 8
    //   1114: aconst_null
    //   1115: astore 7
    //   1117: sipush -3000
    //   1120: istore 4
    //   1122: iload 4
    //   1124: istore_3
    //   1125: aload 7
    //   1127: astore 6
    //   1129: aload 8
    //   1131: astore_1
    //   1132: ldc 191
    //   1134: new 142	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   1141: ldc_w 372
    //   1144: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: aload 9
    //   1149: invokevirtual 373	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1152: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokestatic 208	com/tencent/securemodule/ax:a	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1161: iload 4
    //   1163: istore_3
    //   1164: aload 7
    //   1166: astore 6
    //   1168: aload 8
    //   1170: astore_1
    //   1171: aload 9
    //   1173: invokevirtual 242	java/lang/Exception:printStackTrace	()V
    //   1176: aload 8
    //   1178: ifnull +15 -> 1193
    //   1181: aload 8
    //   1183: invokeinterface 297 1 0
    //   1188: invokeinterface 302 1 0
    //   1193: aload 7
    //   1195: ifnull +3 -> 1198
    //   1198: aload 11
    //   1200: ldc_w 304
    //   1203: sipush -3000
    //   1206: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1209: aload_0
    //   1210: iconst_1
    //   1211: aload 11
    //   1213: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   1216: sipush -3000
    //   1219: ireturn
    //   1220: astore 9
    //   1222: aload 8
    //   1224: astore_1
    //   1225: aload 7
    //   1227: astore 6
    //   1229: aload 9
    //   1231: astore 7
    //   1233: aload_1
    //   1234: ifnull +14 -> 1248
    //   1237: aload_1
    //   1238: invokeinterface 297 1 0
    //   1243: invokeinterface 302 1 0
    //   1248: aload 6
    //   1250: ifnull +3 -> 1253
    //   1253: iload_3
    //   1254: ifeq +25 -> 1279
    //   1257: iload_3
    //   1258: bipush 249
    //   1260: if_icmpeq +19 -> 1279
    //   1263: aload 11
    //   1265: ldc_w 304
    //   1268: iload_3
    //   1269: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1272: aload_0
    //   1273: iconst_1
    //   1274: aload 11
    //   1276: invokevirtual 216	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   1279: aload 7
    //   1281: athrow
    //   1282: astore 7
    //   1284: goto -51 -> 1233
    //   1287: astore 9
    //   1289: aconst_null
    //   1290: astore 7
    //   1292: aload 6
    //   1294: astore 8
    //   1296: goto -179 -> 1117
    //   1299: astore 9
    //   1301: aload_1
    //   1302: astore 7
    //   1304: aload 6
    //   1306: astore 8
    //   1308: goto -191 -> 1117
    //   1311: astore 9
    //   1313: aconst_null
    //   1314: astore 7
    //   1316: aload 6
    //   1318: astore 8
    //   1320: goto -314 -> 1006
    //   1323: astore 9
    //   1325: aload_1
    //   1326: astore 7
    //   1328: aload 6
    //   1330: astore 8
    //   1332: goto -326 -> 1006
    //   1335: astore 9
    //   1337: aconst_null
    //   1338: astore 7
    //   1340: aload 6
    //   1342: astore 8
    //   1344: goto -448 -> 896
    //   1347: astore 9
    //   1349: aload_1
    //   1350: astore 7
    //   1352: aload 6
    //   1354: astore 8
    //   1356: goto -460 -> 896
    //   1359: astore 9
    //   1361: aconst_null
    //   1362: astore 7
    //   1364: aload 6
    //   1366: astore 8
    //   1368: goto -582 -> 786
    //   1371: astore 9
    //   1373: aload_1
    //   1374: astore 7
    //   1376: aload 6
    //   1378: astore 8
    //   1380: goto -594 -> 786
    //   1383: astore 9
    //   1385: aconst_null
    //   1386: astore 7
    //   1388: aload 6
    //   1390: astore 8
    //   1392: goto -717 -> 675
    //   1395: astore 9
    //   1397: aload_1
    //   1398: astore 7
    //   1400: aload 6
    //   1402: astore 8
    //   1404: goto -729 -> 675
    //   1407: iload 4
    //   1409: istore_3
    //   1410: goto -1345 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1413	0	this	ae
    //   0	1413	1	paramString	String
    //   0	1413	2	paramBoolean	boolean
    //   29	1381	3	m	int
    //   3	1405	4	n	int
    //   458	60	5	i1	int
    //   34	1367	6	localObject1	Object
    //   25	1255	7	localObject2	Object
    //   1282	1	7	localObject3	Object
    //   1290	109	7	str	String
    //   6	1397	8	localObject4	Object
    //   9	598	9	localHttpEntity	org.apache.http.HttpEntity
    //   667	63	9	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   778	62	9	localSocketException1	java.net.SocketException
    //   888	62	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   998	63	9	localIOException1	java.io.IOException
    //   1109	63	9	localException1	java.lang.Exception
    //   1220	10	9	localObject5	Object
    //   1287	1	9	localException2	java.lang.Exception
    //   1299	1	9	localException3	java.lang.Exception
    //   1311	1	9	localIOException2	java.io.IOException
    //   1323	1	9	localIOException3	java.io.IOException
    //   1335	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1347	1	9	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1359	1	9	localSocketException2	java.net.SocketException
    //   1371	1	9	localSocketException3	java.net.SocketException
    //   1383	1	9	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    //   1395	1	9	localClientProtocolException3	org.apache.http.client.ClientProtocolException
    //   12	176	10	localObject6	Object
    //   21	1254	11	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   30	36	667	org/apache/http/client/ClientProtocolException
    //   30	36	778	java/net/SocketException
    //   30	36	888	java/net/SocketTimeoutException
    //   30	36	998	java/io/IOException
    //   30	36	1109	java/lang/Exception
    //   30	36	1220	finally
    //   47	54	1220	finally
    //   125	132	1220	finally
    //   153	163	1220	finally
    //   175	183	1220	finally
    //   204	209	1220	finally
    //   220	244	1220	finally
    //   255	262	1220	finally
    //   273	278	1220	finally
    //   289	327	1220	finally
    //   338	345	1220	finally
    //   356	364	1220	finally
    //   375	414	1220	finally
    //   425	437	1220	finally
    //   447	460	1220	finally
    //   470	496	1220	finally
    //   532	539	1220	finally
    //   556	564	1220	finally
    //   580	588	1220	finally
    //   605	616	1220	finally
    //   644	651	1220	finally
    //   690	719	1282	finally
    //   729	734	1282	finally
    //   801	829	1282	finally
    //   839	844	1282	finally
    //   911	939	1282	finally
    //   949	954	1282	finally
    //   1021	1050	1282	finally
    //   1060	1065	1282	finally
    //   1132	1161	1282	finally
    //   1171	1176	1282	finally
    //   47	54	1287	java/lang/Exception
    //   125	132	1287	java/lang/Exception
    //   153	163	1287	java/lang/Exception
    //   175	183	1287	java/lang/Exception
    //   204	209	1287	java/lang/Exception
    //   220	244	1287	java/lang/Exception
    //   255	262	1287	java/lang/Exception
    //   273	278	1287	java/lang/Exception
    //   289	327	1287	java/lang/Exception
    //   338	345	1287	java/lang/Exception
    //   356	364	1287	java/lang/Exception
    //   375	414	1287	java/lang/Exception
    //   425	437	1287	java/lang/Exception
    //   447	460	1299	java/lang/Exception
    //   470	496	1299	java/lang/Exception
    //   532	539	1299	java/lang/Exception
    //   556	564	1299	java/lang/Exception
    //   580	588	1299	java/lang/Exception
    //   605	616	1299	java/lang/Exception
    //   644	651	1299	java/lang/Exception
    //   47	54	1311	java/io/IOException
    //   125	132	1311	java/io/IOException
    //   153	163	1311	java/io/IOException
    //   175	183	1311	java/io/IOException
    //   204	209	1311	java/io/IOException
    //   220	244	1311	java/io/IOException
    //   255	262	1311	java/io/IOException
    //   273	278	1311	java/io/IOException
    //   289	327	1311	java/io/IOException
    //   338	345	1311	java/io/IOException
    //   356	364	1311	java/io/IOException
    //   375	414	1311	java/io/IOException
    //   425	437	1311	java/io/IOException
    //   447	460	1323	java/io/IOException
    //   470	496	1323	java/io/IOException
    //   532	539	1323	java/io/IOException
    //   556	564	1323	java/io/IOException
    //   580	588	1323	java/io/IOException
    //   605	616	1323	java/io/IOException
    //   644	651	1323	java/io/IOException
    //   47	54	1335	java/net/SocketTimeoutException
    //   125	132	1335	java/net/SocketTimeoutException
    //   153	163	1335	java/net/SocketTimeoutException
    //   175	183	1335	java/net/SocketTimeoutException
    //   204	209	1335	java/net/SocketTimeoutException
    //   220	244	1335	java/net/SocketTimeoutException
    //   255	262	1335	java/net/SocketTimeoutException
    //   273	278	1335	java/net/SocketTimeoutException
    //   289	327	1335	java/net/SocketTimeoutException
    //   338	345	1335	java/net/SocketTimeoutException
    //   356	364	1335	java/net/SocketTimeoutException
    //   375	414	1335	java/net/SocketTimeoutException
    //   425	437	1335	java/net/SocketTimeoutException
    //   447	460	1347	java/net/SocketTimeoutException
    //   470	496	1347	java/net/SocketTimeoutException
    //   532	539	1347	java/net/SocketTimeoutException
    //   556	564	1347	java/net/SocketTimeoutException
    //   580	588	1347	java/net/SocketTimeoutException
    //   605	616	1347	java/net/SocketTimeoutException
    //   644	651	1347	java/net/SocketTimeoutException
    //   47	54	1359	java/net/SocketException
    //   125	132	1359	java/net/SocketException
    //   153	163	1359	java/net/SocketException
    //   175	183	1359	java/net/SocketException
    //   204	209	1359	java/net/SocketException
    //   220	244	1359	java/net/SocketException
    //   255	262	1359	java/net/SocketException
    //   273	278	1359	java/net/SocketException
    //   289	327	1359	java/net/SocketException
    //   338	345	1359	java/net/SocketException
    //   356	364	1359	java/net/SocketException
    //   375	414	1359	java/net/SocketException
    //   425	437	1359	java/net/SocketException
    //   447	460	1371	java/net/SocketException
    //   470	496	1371	java/net/SocketException
    //   532	539	1371	java/net/SocketException
    //   556	564	1371	java/net/SocketException
    //   580	588	1371	java/net/SocketException
    //   605	616	1371	java/net/SocketException
    //   644	651	1371	java/net/SocketException
    //   47	54	1383	org/apache/http/client/ClientProtocolException
    //   125	132	1383	org/apache/http/client/ClientProtocolException
    //   153	163	1383	org/apache/http/client/ClientProtocolException
    //   175	183	1383	org/apache/http/client/ClientProtocolException
    //   204	209	1383	org/apache/http/client/ClientProtocolException
    //   220	244	1383	org/apache/http/client/ClientProtocolException
    //   255	262	1383	org/apache/http/client/ClientProtocolException
    //   273	278	1383	org/apache/http/client/ClientProtocolException
    //   289	327	1383	org/apache/http/client/ClientProtocolException
    //   338	345	1383	org/apache/http/client/ClientProtocolException
    //   356	364	1383	org/apache/http/client/ClientProtocolException
    //   375	414	1383	org/apache/http/client/ClientProtocolException
    //   425	437	1383	org/apache/http/client/ClientProtocolException
    //   447	460	1395	org/apache/http/client/ClientProtocolException
    //   470	496	1395	org/apache/http/client/ClientProtocolException
    //   532	539	1395	org/apache/http/client/ClientProtocolException
    //   556	564	1395	org/apache/http/client/ClientProtocolException
    //   580	588	1395	org/apache/http/client/ClientProtocolException
    //   605	616	1395	org/apache/http/client/ClientProtocolException
    //   644	651	1395	org/apache/http/client/ClientProtocolException
  }
  
  public void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public String b()
  {
    return this.f + File.separator + this.h;
  }
  
  public void b(String paramString)
  {
    this.h = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.securemodule.ae
 * JD-Core Version:    0.7.0.1
 */