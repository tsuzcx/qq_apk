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
    //   254: ifeq +73 -> 327
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
    //   287: if_icmpeq +148 -> 435
    //   290: aload_0
    //   291: getfield 41	com/tencent/securemodule/ae:k	Z
    //   294: istore_3
    //   295: iload_3
    //   296: ifeq +58 -> 354
    //   299: aload 13
    //   301: ifnull +8 -> 309
    //   304: aload 13
    //   306: invokevirtual 192	java/io/InputStream:close	()V
    //   309: aload 12
    //   311: ifnull +8 -> 319
    //   314: aload 12
    //   316: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   319: sipush -5003
    //   322: istore 4
    //   324: iload 4
    //   326: ireturn
    //   327: aload_1
    //   328: invokeinterface 180 1 0
    //   333: astore 13
    //   335: goto -63 -> 272
    //   338: astore_1
    //   339: aload_1
    //   340: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   343: goto -34 -> 309
    //   346: astore_1
    //   347: aload_1
    //   348: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   351: goto -32 -> 319
    //   354: aload_0
    //   355: aload_0
    //   356: getfield 43	com/tencent/securemodule/ae:l	J
    //   359: iload 7
    //   361: i2l
    //   362: ladd
    //   363: putfield 43	com/tencent/securemodule/ae:l	J
    //   366: aload_2
    //   367: ldc 135
    //   369: aload_0
    //   370: getfield 43	com/tencent/securemodule/ae:l	J
    //   373: invokevirtual 133	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   376: aload_0
    //   377: getfield 43	com/tencent/securemodule/ae:l	J
    //   380: ldc2_w 124
    //   383: lmul
    //   384: lload 8
    //   386: ldiv
    //   387: l2i
    //   388: istore 6
    //   390: iload 6
    //   392: iload 4
    //   394: if_icmpeq +698 -> 1092
    //   397: aload_2
    //   398: ldc 137
    //   400: iload 6
    //   402: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   405: aload_0
    //   406: iconst_2
    //   407: aload_2
    //   408: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   411: iload 6
    //   413: istore 4
    //   415: aload 12
    //   417: aload 27
    //   419: iconst_0
    //   420: iload 7
    //   422: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   425: iload 5
    //   427: iload 7
    //   429: iadd
    //   430: istore 5
    //   432: goto -157 -> 275
    //   435: aload 12
    //   437: invokevirtual 206	java/io/FileOutputStream:flush	()V
    //   440: iload 5
    //   442: i2l
    //   443: lstore 8
    //   445: aload_1
    //   446: invokeinterface 123 1 0
    //   451: lstore 10
    //   453: lload 8
    //   455: lload 10
    //   457: lcmp
    //   458: ifne +50 -> 508
    //   461: iconst_0
    //   462: istore 4
    //   464: iload 4
    //   466: istore 5
    //   468: aload 13
    //   470: ifnull +55 -> 525
    //   473: aload 13
    //   475: invokevirtual 192	java/io/InputStream:close	()V
    //   478: iload 4
    //   480: istore 5
    //   482: iload 5
    //   484: istore 4
    //   486: aload 12
    //   488: ifnull -164 -> 324
    //   491: aload 12
    //   493: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   496: iload 5
    //   498: ireturn
    //   499: astore_1
    //   500: aload_1
    //   501: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   504: sipush -7000
    //   507: ireturn
    //   508: bipush 249
    //   510: istore 4
    //   512: goto -48 -> 464
    //   515: astore_1
    //   516: sipush -7000
    //   519: istore 5
    //   521: aload_1
    //   522: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   525: goto -43 -> 482
    //   528: astore_2
    //   529: aload 21
    //   531: astore_1
    //   532: aload 15
    //   534: astore 12
    //   536: aload 12
    //   538: astore 13
    //   540: aload_1
    //   541: astore 14
    //   543: aload_2
    //   544: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   547: aload 12
    //   549: ifnull +535 -> 1084
    //   552: aload 12
    //   554: invokevirtual 192	java/io/InputStream:close	()V
    //   557: sipush -7001
    //   560: istore 5
    //   562: iload 5
    //   564: istore 4
    //   566: aload_1
    //   567: ifnull -243 -> 324
    //   570: aload_1
    //   571: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   574: iload 5
    //   576: ireturn
    //   577: astore_1
    //   578: aload_1
    //   579: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   582: sipush -7000
    //   585: ireturn
    //   586: astore_2
    //   587: sipush -7000
    //   590: istore 5
    //   592: aload_2
    //   593: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   596: goto -34 -> 562
    //   599: astore_2
    //   600: aload 22
    //   602: astore_1
    //   603: aload 16
    //   605: astore 12
    //   607: aload 12
    //   609: astore 13
    //   611: aload_1
    //   612: astore 14
    //   614: aload_2
    //   615: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   618: aload 12
    //   620: ifnull +456 -> 1076
    //   623: aload 12
    //   625: invokevirtual 192	java/io/InputStream:close	()V
    //   628: sipush -5054
    //   631: istore 5
    //   633: iload 5
    //   635: istore 4
    //   637: aload_1
    //   638: ifnull -314 -> 324
    //   641: aload_1
    //   642: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   645: iload 5
    //   647: ireturn
    //   648: astore_1
    //   649: aload_1
    //   650: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   653: sipush -7000
    //   656: ireturn
    //   657: astore_2
    //   658: sipush -7000
    //   661: istore 5
    //   663: aload_2
    //   664: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   667: goto -34 -> 633
    //   670: astore_2
    //   671: aload 23
    //   673: astore_1
    //   674: aload 17
    //   676: astore 12
    //   678: aload 12
    //   680: astore 13
    //   682: aload_1
    //   683: astore 14
    //   685: aload_2
    //   686: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   689: aload 12
    //   691: ifnull +377 -> 1068
    //   694: aload 12
    //   696: invokevirtual 192	java/io/InputStream:close	()V
    //   699: sipush -5055
    //   702: istore 5
    //   704: iload 5
    //   706: istore 4
    //   708: aload_1
    //   709: ifnull -385 -> 324
    //   712: aload_1
    //   713: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   716: iload 5
    //   718: ireturn
    //   719: astore_1
    //   720: aload_1
    //   721: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   724: sipush -7000
    //   727: ireturn
    //   728: astore_2
    //   729: sipush -7000
    //   732: istore 5
    //   734: aload_2
    //   735: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   738: goto -34 -> 704
    //   741: astore_2
    //   742: aload 24
    //   744: astore_1
    //   745: aload 18
    //   747: astore 12
    //   749: aload 12
    //   751: astore 13
    //   753: aload_1
    //   754: astore 14
    //   756: aload_2
    //   757: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   760: aload 12
    //   762: ifnull +298 -> 1060
    //   765: aload 12
    //   767: invokevirtual 192	java/io/InputStream:close	()V
    //   770: sipush -5056
    //   773: istore 5
    //   775: iload 5
    //   777: istore 4
    //   779: aload_1
    //   780: ifnull -456 -> 324
    //   783: aload_1
    //   784: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   787: iload 5
    //   789: ireturn
    //   790: astore_1
    //   791: aload_1
    //   792: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   795: sipush -7000
    //   798: ireturn
    //   799: astore_2
    //   800: sipush -7000
    //   803: istore 5
    //   805: aload_2
    //   806: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   809: goto -34 -> 775
    //   812: astore_2
    //   813: aload 25
    //   815: astore_1
    //   816: aload 19
    //   818: astore 12
    //   820: aload 12
    //   822: astore 13
    //   824: aload_1
    //   825: astore 14
    //   827: aload_2
    //   828: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   831: aload 12
    //   833: ifnull +219 -> 1052
    //   836: aload 12
    //   838: invokevirtual 192	java/io/InputStream:close	()V
    //   841: sipush -5000
    //   844: istore 5
    //   846: iload 5
    //   848: istore 4
    //   850: aload_1
    //   851: ifnull -527 -> 324
    //   854: aload_1
    //   855: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   858: iload 5
    //   860: ireturn
    //   861: astore_1
    //   862: aload_1
    //   863: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   866: sipush -7000
    //   869: ireturn
    //   870: astore_2
    //   871: sipush -7000
    //   874: istore 5
    //   876: aload_2
    //   877: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   880: goto -34 -> 846
    //   883: astore_1
    //   884: aload 13
    //   886: ifnull +8 -> 894
    //   889: aload 13
    //   891: invokevirtual 192	java/io/InputStream:close	()V
    //   894: aload 14
    //   896: ifnull +8 -> 904
    //   899: aload 14
    //   901: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   904: aload_1
    //   905: athrow
    //   906: astore_2
    //   907: aload_2
    //   908: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   911: goto -17 -> 894
    //   914: astore_2
    //   915: aload_2
    //   916: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   919: goto -15 -> 904
    //   922: astore_1
    //   923: aload 20
    //   925: astore 13
    //   927: aload 12
    //   929: astore 14
    //   931: goto -47 -> 884
    //   934: astore_1
    //   935: aload 12
    //   937: astore 14
    //   939: goto -55 -> 884
    //   942: astore_2
    //   943: aload 12
    //   945: astore_1
    //   946: aload 19
    //   948: astore 12
    //   950: goto -130 -> 820
    //   953: astore_2
    //   954: aload 12
    //   956: astore_1
    //   957: aload 13
    //   959: astore 12
    //   961: goto -141 -> 820
    //   964: astore_2
    //   965: aload 12
    //   967: astore_1
    //   968: aload 18
    //   970: astore 12
    //   972: goto -223 -> 749
    //   975: astore_2
    //   976: aload 12
    //   978: astore_1
    //   979: aload 13
    //   981: astore 12
    //   983: goto -234 -> 749
    //   986: astore_2
    //   987: aload 12
    //   989: astore_1
    //   990: aload 17
    //   992: astore 12
    //   994: goto -316 -> 678
    //   997: astore_2
    //   998: aload 12
    //   1000: astore_1
    //   1001: aload 13
    //   1003: astore 12
    //   1005: goto -327 -> 678
    //   1008: astore_2
    //   1009: aload 12
    //   1011: astore_1
    //   1012: aload 16
    //   1014: astore 12
    //   1016: goto -409 -> 607
    //   1019: astore_2
    //   1020: aload 12
    //   1022: astore_1
    //   1023: aload 13
    //   1025: astore 12
    //   1027: goto -420 -> 607
    //   1030: astore_2
    //   1031: aload 12
    //   1033: astore_1
    //   1034: aload 15
    //   1036: astore 12
    //   1038: goto -502 -> 536
    //   1041: astore_2
    //   1042: aload 12
    //   1044: astore_1
    //   1045: aload 13
    //   1047: astore 12
    //   1049: goto -513 -> 536
    //   1052: sipush -5000
    //   1055: istore 5
    //   1057: goto -211 -> 846
    //   1060: sipush -5056
    //   1063: istore 5
    //   1065: goto -290 -> 775
    //   1068: sipush -5055
    //   1071: istore 5
    //   1073: goto -369 -> 704
    //   1076: sipush -5054
    //   1079: istore 5
    //   1081: goto -448 -> 633
    //   1084: sipush -7001
    //   1087: istore 5
    //   1089: goto -527 -> 562
    //   1092: goto -677 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1095	0	this	ae
    //   0	1095	1	paramHttpEntity	org.apache.http.HttpEntity
    //   0	1095	2	paramBundle	android.os.Bundle
    //   0	1095	3	paramBoolean	boolean
    //   87	762	4	m	int
    //   273	815	5	n	int
    //   388	24	6	i1	int
    //   282	148	7	i2	int
    //   65	389	8	l1	long
    //   451	5	10	l2	long
    //   13	1035	12	localObject1	Object
    //   48	998	13	localObject2	Object
    //   52	886	14	localObject3	Object
    //   37	998	15	localObject4	Object
    //   19	994	16	localObject5	Object
    //   22	969	17	localObject6	Object
    //   25	944	18	localObject7	Object
    //   28	919	19	localObject8	Object
    //   34	890	20	localObject9	Object
    //   16	514	21	localObject10	Object
    //   1	600	22	localObject11	Object
    //   4	668	23	localObject12	Object
    //   7	736	24	localObject13	Object
    //   10	804	25	localObject14	Object
    //   31	203	26	localObject15	Object
    //   44	374	27	arrayOfByte	byte[]
    //   184	62	28	localFile	File
    // Exception table:
    //   from	to	target	type
    //   304	309	338	java/io/IOException
    //   314	319	346	java/io/IOException
    //   491	496	499	java/io/IOException
    //   473	478	515	java/io/IOException
    //   54	67	528	java/io/FileNotFoundException
    //   75	89	528	java/io/FileNotFoundException
    //   97	105	528	java/io/FileNotFoundException
    //   113	123	528	java/io/FileNotFoundException
    //   131	139	528	java/io/FileNotFoundException
    //   147	186	528	java/io/FileNotFoundException
    //   194	202	528	java/io/FileNotFoundException
    //   210	219	528	java/io/FileNotFoundException
    //   227	233	528	java/io/FileNotFoundException
    //   241	253	528	java/io/FileNotFoundException
    //   570	574	577	java/io/IOException
    //   552	557	586	java/io/IOException
    //   54	67	599	java/net/SocketException
    //   75	89	599	java/net/SocketException
    //   97	105	599	java/net/SocketException
    //   113	123	599	java/net/SocketException
    //   131	139	599	java/net/SocketException
    //   147	186	599	java/net/SocketException
    //   194	202	599	java/net/SocketException
    //   210	219	599	java/net/SocketException
    //   227	233	599	java/net/SocketException
    //   241	253	599	java/net/SocketException
    //   641	645	648	java/io/IOException
    //   623	628	657	java/io/IOException
    //   54	67	670	java/net/SocketTimeoutException
    //   75	89	670	java/net/SocketTimeoutException
    //   97	105	670	java/net/SocketTimeoutException
    //   113	123	670	java/net/SocketTimeoutException
    //   131	139	670	java/net/SocketTimeoutException
    //   147	186	670	java/net/SocketTimeoutException
    //   194	202	670	java/net/SocketTimeoutException
    //   210	219	670	java/net/SocketTimeoutException
    //   227	233	670	java/net/SocketTimeoutException
    //   241	253	670	java/net/SocketTimeoutException
    //   712	716	719	java/io/IOException
    //   694	699	728	java/io/IOException
    //   54	67	741	java/io/IOException
    //   75	89	741	java/io/IOException
    //   97	105	741	java/io/IOException
    //   113	123	741	java/io/IOException
    //   131	139	741	java/io/IOException
    //   147	186	741	java/io/IOException
    //   194	202	741	java/io/IOException
    //   210	219	741	java/io/IOException
    //   227	233	741	java/io/IOException
    //   241	253	741	java/io/IOException
    //   783	787	790	java/io/IOException
    //   765	770	799	java/io/IOException
    //   54	67	812	java/lang/Exception
    //   75	89	812	java/lang/Exception
    //   97	105	812	java/lang/Exception
    //   113	123	812	java/lang/Exception
    //   131	139	812	java/lang/Exception
    //   147	186	812	java/lang/Exception
    //   194	202	812	java/lang/Exception
    //   210	219	812	java/lang/Exception
    //   227	233	812	java/lang/Exception
    //   241	253	812	java/lang/Exception
    //   854	858	861	java/io/IOException
    //   836	841	870	java/io/IOException
    //   54	67	883	finally
    //   75	89	883	finally
    //   97	105	883	finally
    //   113	123	883	finally
    //   131	139	883	finally
    //   147	186	883	finally
    //   194	202	883	finally
    //   210	219	883	finally
    //   227	233	883	finally
    //   241	253	883	finally
    //   543	547	883	finally
    //   614	618	883	finally
    //   685	689	883	finally
    //   756	760	883	finally
    //   827	831	883	finally
    //   889	894	906	java/io/IOException
    //   899	904	914	java/io/IOException
    //   257	272	922	finally
    //   327	335	922	finally
    //   275	284	934	finally
    //   290	295	934	finally
    //   354	390	934	finally
    //   397	411	934	finally
    //   415	425	934	finally
    //   435	440	934	finally
    //   445	453	934	finally
    //   257	272	942	java/lang/Exception
    //   327	335	942	java/lang/Exception
    //   275	284	953	java/lang/Exception
    //   290	295	953	java/lang/Exception
    //   354	390	953	java/lang/Exception
    //   397	411	953	java/lang/Exception
    //   415	425	953	java/lang/Exception
    //   435	440	953	java/lang/Exception
    //   445	453	953	java/lang/Exception
    //   257	272	964	java/io/IOException
    //   327	335	964	java/io/IOException
    //   275	284	975	java/io/IOException
    //   290	295	975	java/io/IOException
    //   354	390	975	java/io/IOException
    //   397	411	975	java/io/IOException
    //   415	425	975	java/io/IOException
    //   435	440	975	java/io/IOException
    //   445	453	975	java/io/IOException
    //   257	272	986	java/net/SocketTimeoutException
    //   327	335	986	java/net/SocketTimeoutException
    //   275	284	997	java/net/SocketTimeoutException
    //   290	295	997	java/net/SocketTimeoutException
    //   354	390	997	java/net/SocketTimeoutException
    //   397	411	997	java/net/SocketTimeoutException
    //   415	425	997	java/net/SocketTimeoutException
    //   435	440	997	java/net/SocketTimeoutException
    //   445	453	997	java/net/SocketTimeoutException
    //   257	272	1008	java/net/SocketException
    //   327	335	1008	java/net/SocketException
    //   275	284	1019	java/net/SocketException
    //   290	295	1019	java/net/SocketException
    //   354	390	1019	java/net/SocketException
    //   397	411	1019	java/net/SocketException
    //   415	425	1019	java/net/SocketException
    //   435	440	1019	java/net/SocketException
    //   445	453	1019	java/net/SocketException
    //   257	272	1030	java/io/FileNotFoundException
    //   327	335	1030	java/io/FileNotFoundException
    //   275	284	1041	java/io/FileNotFoundException
    //   290	295	1041	java/io/FileNotFoundException
    //   354	390	1041	java/io/FileNotFoundException
    //   397	411	1041	java/io/FileNotFoundException
    //   415	425	1041	java/io/FileNotFoundException
    //   435	440	1041	java/io/FileNotFoundException
    //   445	453	1041	java/io/FileNotFoundException
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
    //   21: new 99	java/io/File
    //   24: dup
    //   25: new 142	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   32: aload_0
    //   33: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   36: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   42: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   49: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore 7
    //   60: aload 7
    //   62: invokevirtual 160	java/io/File:exists	()Z
    //   65: ifeq +340 -> 405
    //   68: aload_0
    //   69: getfield 39	com/tencent/securemodule/ae:j	Z
    //   72: ifne +161 -> 233
    //   75: aload_0
    //   76: getfield 37	com/tencent/securemodule/ae:i	I
    //   79: iconst_1
    //   80: if_icmpne +153 -> 233
    //   83: aload_0
    //   84: getfield 45	com/tencent/securemodule/ae:c	Landroid/content/Context;
    //   87: aload_0
    //   88: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   91: iconst_1
    //   92: invokevirtual 215	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   95: astore 6
    //   97: aload 7
    //   99: astore 10
    //   101: aload 8
    //   103: astore 11
    //   105: aload 6
    //   107: astore 9
    //   109: new 217	java/io/FileInputStream
    //   112: dup
    //   113: aload 7
    //   115: invokespecial 220	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   118: astore 8
    //   120: sipush 1024
    //   123: newarray byte
    //   125: astore 11
    //   127: aload 8
    //   129: aload 11
    //   131: invokevirtual 221	java/io/FileInputStream:read	([B)I
    //   134: istore 5
    //   136: iload_2
    //   137: istore 4
    //   139: aload 8
    //   141: astore 10
    //   143: aload 6
    //   145: astore 9
    //   147: iload 5
    //   149: iconst_m1
    //   150: if_icmpeq +266 -> 416
    //   153: aload 6
    //   155: aload 11
    //   157: iconst_0
    //   158: iload 5
    //   160: invokevirtual 203	java/io/FileOutputStream:write	([BII)V
    //   163: goto -36 -> 127
    //   166: astore 9
    //   168: aload 8
    //   170: astore 11
    //   172: aload 9
    //   174: astore 8
    //   176: aload 8
    //   178: invokevirtual 207	java/io/FileNotFoundException:printStackTrace	()V
    //   181: aload 11
    //   183: ifnull +672 -> 855
    //   186: aload 11
    //   188: invokevirtual 222	java/io/FileInputStream:close	()V
    //   191: sipush -7001
    //   194: istore_2
    //   195: aload 6
    //   197: ifnull +653 -> 850
    //   200: aload 6
    //   202: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   205: iload_2
    //   206: istore_3
    //   207: iload_3
    //   208: istore_2
    //   209: iload_1
    //   210: ifeq +21 -> 231
    //   213: iload_3
    //   214: istore_2
    //   215: aload 7
    //   217: invokevirtual 160	java/io/File:exists	()Z
    //   220: ifeq +11 -> 231
    //   223: aload 7
    //   225: invokevirtual 225	java/io/File:delete	()Z
    //   228: pop
    //   229: iload_3
    //   230: istore_2
    //   231: iload_2
    //   232: ireturn
    //   233: new 99	java/io/File
    //   236: dup
    //   237: new 142	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 31	com/tencent/securemodule/ae:f	Ljava/lang/String;
    //   248: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   254: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: aload_0
    //   258: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   261: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   270: astore 6
    //   272: aload 6
    //   274: invokevirtual 160	java/io/File:exists	()Z
    //   277: ifeq +23 -> 300
    //   280: aload 6
    //   282: invokevirtual 225	java/io/File:delete	()Z
    //   285: pop
    //   286: new 171	java/io/FileOutputStream
    //   289: dup
    //   290: aload 6
    //   292: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   295: astore 6
    //   297: goto -200 -> 97
    //   300: aload 6
    //   302: invokevirtual 163	java/io/File:getParentFile	()Ljava/io/File;
    //   305: invokevirtual 166	java/io/File:mkdirs	()Z
    //   308: pop
    //   309: aload 6
    //   311: invokevirtual 169	java/io/File:createNewFile	()Z
    //   314: pop
    //   315: new 171	java/io/FileOutputStream
    //   318: dup
    //   319: aload 6
    //   321: invokespecial 226	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   324: astore 6
    //   326: goto -229 -> 97
    //   329: astore 8
    //   331: aconst_null
    //   332: astore 6
    //   334: aload 13
    //   336: astore 12
    //   338: aload 7
    //   340: astore 10
    //   342: aload 12
    //   344: astore 11
    //   346: aload 6
    //   348: astore 9
    //   350: aload 8
    //   352: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   355: aload 12
    //   357: ifnull +486 -> 843
    //   360: aload 12
    //   362: invokevirtual 222	java/io/FileInputStream:close	()V
    //   365: sipush -7056
    //   368: istore_2
    //   369: aload 6
    //   371: ifnull +467 -> 838
    //   374: aload 6
    //   376: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   379: iload_2
    //   380: istore_3
    //   381: iload_3
    //   382: istore_2
    //   383: iload_1
    //   384: ifeq -153 -> 231
    //   387: iload_3
    //   388: istore_2
    //   389: aload 7
    //   391: invokevirtual 160	java/io/File:exists	()Z
    //   394: ifeq -163 -> 231
    //   397: aload 7
    //   399: invokevirtual 225	java/io/File:delete	()Z
    //   402: pop
    //   403: iload_3
    //   404: ireturn
    //   405: aconst_null
    //   406: astore 10
    //   408: aconst_null
    //   409: astore 9
    //   411: sipush -7001
    //   414: istore 4
    //   416: iload 4
    //   418: istore_2
    //   419: aload 10
    //   421: ifnull +11 -> 432
    //   424: aload 10
    //   426: invokevirtual 222	java/io/FileInputStream:close	()V
    //   429: iload 4
    //   431: istore_2
    //   432: aload 9
    //   434: ifnull +428 -> 862
    //   437: aload 9
    //   439: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   442: iload_2
    //   443: istore_3
    //   444: iload_3
    //   445: istore_2
    //   446: iload_1
    //   447: ifeq -216 -> 231
    //   450: iload_3
    //   451: istore_2
    //   452: aload 7
    //   454: invokevirtual 160	java/io/File:exists	()Z
    //   457: ifeq -226 -> 231
    //   460: aload 7
    //   462: invokevirtual 225	java/io/File:delete	()Z
    //   465: pop
    //   466: iload_3
    //   467: ireturn
    //   468: astore 6
    //   470: aload 6
    //   472: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   475: sipush -7000
    //   478: istore_2
    //   479: goto -47 -> 432
    //   482: astore 6
    //   484: aload 6
    //   486: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   489: goto -45 -> 444
    //   492: astore 8
    //   494: aload 8
    //   496: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   499: sipush -7000
    //   502: istore_2
    //   503: goto -308 -> 195
    //   506: astore 6
    //   508: aload 6
    //   510: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   513: goto -306 -> 207
    //   516: astore 8
    //   518: aload 8
    //   520: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   523: sipush -7000
    //   526: istore_2
    //   527: goto -158 -> 369
    //   530: astore 6
    //   532: aload 6
    //   534: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   537: goto -156 -> 381
    //   540: astore 8
    //   542: aconst_null
    //   543: astore 7
    //   545: aconst_null
    //   546: astore 6
    //   548: aload 14
    //   550: astore 12
    //   552: aload 7
    //   554: astore 10
    //   556: aload 12
    //   558: astore 11
    //   560: aload 6
    //   562: astore 9
    //   564: aload 8
    //   566: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   569: aload 12
    //   571: ifnull +8 -> 579
    //   574: aload 12
    //   576: invokevirtual 222	java/io/FileInputStream:close	()V
    //   579: aload 6
    //   581: ifnull +8 -> 589
    //   584: aload 6
    //   586: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   589: iload_3
    //   590: istore_2
    //   591: iload_1
    //   592: ifeq -361 -> 231
    //   595: iload_3
    //   596: istore_2
    //   597: aload 7
    //   599: invokevirtual 160	java/io/File:exists	()Z
    //   602: ifeq -371 -> 231
    //   605: aload 7
    //   607: invokevirtual 225	java/io/File:delete	()Z
    //   610: pop
    //   611: sipush -7000
    //   614: ireturn
    //   615: astore 8
    //   617: aload 8
    //   619: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   622: goto -43 -> 579
    //   625: astore 6
    //   627: aload 6
    //   629: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   632: goto -43 -> 589
    //   635: astore 8
    //   637: aconst_null
    //   638: astore 7
    //   640: aconst_null
    //   641: astore 6
    //   643: aload 11
    //   645: ifnull +8 -> 653
    //   648: aload 11
    //   650: invokevirtual 222	java/io/FileInputStream:close	()V
    //   653: aload 6
    //   655: ifnull +8 -> 663
    //   658: aload 6
    //   660: invokevirtual 193	java/io/FileOutputStream:close	()V
    //   663: iload_1
    //   664: ifeq +17 -> 681
    //   667: aload 7
    //   669: invokevirtual 160	java/io/File:exists	()Z
    //   672: ifeq +9 -> 681
    //   675: aload 7
    //   677: invokevirtual 225	java/io/File:delete	()Z
    //   680: pop
    //   681: aload 8
    //   683: athrow
    //   684: astore 9
    //   686: aload 9
    //   688: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   691: goto -38 -> 653
    //   694: astore 6
    //   696: aload 6
    //   698: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   701: goto -38 -> 663
    //   704: astore 8
    //   706: aconst_null
    //   707: astore 6
    //   709: goto -66 -> 643
    //   712: astore 8
    //   714: aload 10
    //   716: astore 7
    //   718: aload 9
    //   720: astore 6
    //   722: goto -79 -> 643
    //   725: astore 9
    //   727: aload 8
    //   729: astore 11
    //   731: aload 9
    //   733: astore 8
    //   735: goto -92 -> 643
    //   738: astore 8
    //   740: goto -97 -> 643
    //   743: astore 8
    //   745: aconst_null
    //   746: astore 6
    //   748: aload 14
    //   750: astore 12
    //   752: goto -200 -> 552
    //   755: astore 8
    //   757: aload 14
    //   759: astore 12
    //   761: goto -209 -> 552
    //   764: astore 9
    //   766: aload 8
    //   768: astore 12
    //   770: aload 9
    //   772: astore 8
    //   774: goto -222 -> 552
    //   777: astore 8
    //   779: aconst_null
    //   780: astore 7
    //   782: aconst_null
    //   783: astore 6
    //   785: aload 13
    //   787: astore 12
    //   789: goto -451 -> 338
    //   792: astore 8
    //   794: aload 13
    //   796: astore 12
    //   798: goto -460 -> 338
    //   801: astore 9
    //   803: aload 8
    //   805: astore 12
    //   807: aload 9
    //   809: astore 8
    //   811: goto -473 -> 338
    //   814: astore 8
    //   816: aconst_null
    //   817: astore 7
    //   819: aconst_null
    //   820: astore 6
    //   822: aload 12
    //   824: astore 11
    //   826: goto -650 -> 176
    //   829: astore 8
    //   831: aload 12
    //   833: astore 11
    //   835: goto -659 -> 176
    //   838: iload_2
    //   839: istore_3
    //   840: goto -459 -> 381
    //   843: sipush -7056
    //   846: istore_2
    //   847: goto -478 -> 369
    //   850: iload_2
    //   851: istore_3
    //   852: goto -645 -> 207
    //   855: sipush -7001
    //   858: istore_2
    //   859: goto -664 -> 195
    //   862: iload_2
    //   863: istore_3
    //   864: goto -420 -> 444
    //   867: astore 8
    //   869: aconst_null
    //   870: astore 6
    //   872: aload 12
    //   874: astore 11
    //   876: goto -700 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	879	0	this	ae
    //   0	879	1	paramBoolean	boolean
    //   1	862	2	m	int
    //   20	844	3	n	int
    //   137	293	4	i1	int
    //   134	25	5	i2	int
    //   95	280	6	localObject1	Object
    //   468	3	6	localIOException1	java.io.IOException
    //   482	3	6	localIOException2	java.io.IOException
    //   506	3	6	localIOException3	java.io.IOException
    //   530	3	6	localIOException4	java.io.IOException
    //   546	39	6	localObject2	Object
    //   625	3	6	localIOException5	java.io.IOException
    //   641	18	6	localObject3	Object
    //   694	3	6	localIOException6	java.io.IOException
    //   707	164	6	localObject4	Object
    //   58	760	7	localObject5	Object
    //   12	165	8	localObject6	Object
    //   329	22	8	localIOException7	java.io.IOException
    //   492	3	8	localIOException8	java.io.IOException
    //   516	3	8	localIOException9	java.io.IOException
    //   540	25	8	localException1	java.lang.Exception
    //   615	3	8	localIOException10	java.io.IOException
    //   635	47	8	localObject7	Object
    //   704	1	8	localObject8	Object
    //   712	16	8	localObject9	Object
    //   733	1	8	localObject10	Object
    //   738	1	8	localObject11	Object
    //   743	1	8	localException2	java.lang.Exception
    //   755	12	8	localException3	java.lang.Exception
    //   772	1	8	localObject12	Object
    //   777	1	8	localIOException11	java.io.IOException
    //   792	12	8	localIOException12	java.io.IOException
    //   809	1	8	localObject13	Object
    //   814	1	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   829	1	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   867	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   107	39	9	localObject14	Object
    //   166	7	9	localFileNotFoundException4	java.io.FileNotFoundException
    //   348	215	9	localObject15	Object
    //   684	35	9	localIOException13	java.io.IOException
    //   725	7	9	localObject16	Object
    //   764	7	9	localException4	java.lang.Exception
    //   801	7	9	localIOException14	java.io.IOException
    //   99	616	10	localObject17	Object
    //   9	866	11	localObject18	Object
    //   15	858	12	localObject19	Object
    //   3	792	13	localObject20	Object
    //   6	752	14	localObject21	Object
    // Exception table:
    //   from	to	target	type
    //   120	127	166	java/io/FileNotFoundException
    //   127	136	166	java/io/FileNotFoundException
    //   153	163	166	java/io/FileNotFoundException
    //   60	97	329	java/io/IOException
    //   233	297	329	java/io/IOException
    //   300	326	329	java/io/IOException
    //   424	429	468	java/io/IOException
    //   437	442	482	java/io/IOException
    //   186	191	492	java/io/IOException
    //   200	205	506	java/io/IOException
    //   360	365	516	java/io/IOException
    //   374	379	530	java/io/IOException
    //   21	60	540	java/lang/Exception
    //   574	579	615	java/io/IOException
    //   584	589	625	java/io/IOException
    //   21	60	635	finally
    //   648	653	684	java/io/IOException
    //   658	663	694	java/io/IOException
    //   60	97	704	finally
    //   233	297	704	finally
    //   300	326	704	finally
    //   109	120	712	finally
    //   350	355	712	finally
    //   564	569	712	finally
    //   120	127	725	finally
    //   127	136	725	finally
    //   153	163	725	finally
    //   176	181	738	finally
    //   60	97	743	java/lang/Exception
    //   233	297	743	java/lang/Exception
    //   300	326	743	java/lang/Exception
    //   109	120	755	java/lang/Exception
    //   120	127	764	java/lang/Exception
    //   127	136	764	java/lang/Exception
    //   153	163	764	java/lang/Exception
    //   21	60	777	java/io/IOException
    //   109	120	792	java/io/IOException
    //   120	127	801	java/io/IOException
    //   127	136	801	java/io/IOException
    //   153	163	801	java/io/IOException
    //   21	60	814	java/io/FileNotFoundException
    //   109	120	829	java/io/FileNotFoundException
    //   60	97	867	java/io/FileNotFoundException
    //   233	297	867	java/io/FileNotFoundException
    //   300	326	867	java/io/FileNotFoundException
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
    //   18: invokespecial 241	android/os/Bundle:<init>	()V
    //   21: astore 11
    //   23: aload 9
    //   25: astore 7
    //   27: iload 4
    //   29: istore_3
    //   30: aload_0
    //   31: invokevirtual 244	com/tencent/securemodule/ae:a	()Lorg/apache/http/client/HttpClient;
    //   34: astore 6
    //   36: aload 9
    //   38: astore 7
    //   40: aload 6
    //   42: astore 8
    //   44: iload 4
    //   46: istore_3
    //   47: aload_0
    //   48: aload_1
    //   49: invokespecial 246	com/tencent/securemodule/ae:c	(Ljava/lang/String;)I
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
    //   72: invokeinterface 252 1 0
    //   77: invokeinterface 257 1 0
    //   82: aload_1
    //   83: ifnull +3 -> 86
    //   86: iload_3
    //   87: ifeq +25 -> 112
    //   90: iload_3
    //   91: bipush 249
    //   93: if_icmpeq +19 -> 112
    //   96: aload 11
    //   98: ldc_w 259
    //   101: iload_3
    //   102: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   105: aload_0
    //   106: iconst_1
    //   107: aload 11
    //   109: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
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
    //   157: invokevirtual 263	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   160: ifnonnull +13 -> 173
    //   163: sipush -3053
    //   166: istore_3
    //   167: aload 10
    //   169: astore_1
    //   170: goto -105 -> 65
    //   173: aload 9
    //   175: astore 7
    //   177: aload 6
    //   179: astore 8
    //   181: iload 4
    //   183: istore_3
    //   184: aload_1
    //   185: invokestatic 268	com/tencent/securemodule/ax:c	(Ljava/lang/String;)Ljava/lang/String;
    //   188: astore_1
    //   189: aload 9
    //   191: astore 7
    //   193: aload 6
    //   195: astore 8
    //   197: iload 4
    //   199: istore_3
    //   200: aload_0
    //   201: new 142	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   208: aload_1
    //   209: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: ldc_w 270
    //   215: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: putfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   224: aload 9
    //   226: astore 7
    //   228: aload 6
    //   230: astore 8
    //   232: iload 4
    //   234: istore_3
    //   235: aload_0
    //   236: getfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   239: ifnonnull +19 -> 258
    //   242: aload 9
    //   244: astore 7
    //   246: aload 6
    //   248: astore 8
    //   250: iload 4
    //   252: istore_3
    //   253: aload_0
    //   254: aload_1
    //   255: putfield 35	com/tencent/securemodule/ae:h	Ljava/lang/String;
    //   258: aload 9
    //   260: astore 7
    //   262: aload 6
    //   264: astore 8
    //   266: iload 4
    //   268: istore_3
    //   269: new 99	java/io/File
    //   272: dup
    //   273: new 142	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   280: aload_0
    //   281: getfield 29	com/tencent/securemodule/ae:e	Ljava/lang/String;
    //   284: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: getstatic 150	java/io/File:separator	Ljava/lang/String;
    //   290: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload_0
    //   294: getfield 33	com/tencent/securemodule/ae:g	Ljava/lang/String;
    //   297: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokespecial 156	java/io/File:<init>	(Ljava/lang/String;)V
    //   306: astore_1
    //   307: aload 9
    //   309: astore 7
    //   311: aload 6
    //   313: astore 8
    //   315: iload 4
    //   317: istore_3
    //   318: aload_1
    //   319: invokevirtual 160	java/io/File:exists	()Z
    //   322: ifeq +72 -> 394
    //   325: aload 9
    //   327: astore 7
    //   329: aload 6
    //   331: astore 8
    //   333: iload 4
    //   335: istore_3
    //   336: aload_0
    //   337: aload_1
    //   338: invokevirtual 273	java/io/File:length	()J
    //   341: putfield 43	com/tencent/securemodule/ae:l	J
    //   344: aload 9
    //   346: astore 7
    //   348: aload 6
    //   350: astore 8
    //   352: iload 4
    //   354: istore_3
    //   355: aload_0
    //   356: getfield 27	com/tencent/securemodule/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   359: ldc_w 275
    //   362: new 142	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 277
    //   372: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: getfield 43	com/tencent/securemodule/ae:l	J
    //   379: invokevirtual 280	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   382: ldc_w 282
    //   385: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokevirtual 286	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload 9
    //   396: astore 7
    //   398: aload 6
    //   400: astore 8
    //   402: iload 4
    //   404: istore_3
    //   405: aload 6
    //   407: aload_0
    //   408: getfield 27	com/tencent/securemodule/ae:d	Lorg/apache/http/client/methods/HttpGet;
    //   411: invokeinterface 290 2 0
    //   416: astore_1
    //   417: aload_1
    //   418: astore 7
    //   420: aload 6
    //   422: astore 8
    //   424: iload 4
    //   426: istore_3
    //   427: aload_1
    //   428: invokeinterface 296 1 0
    //   433: invokeinterface 301 1 0
    //   438: istore 5
    //   440: iload 5
    //   442: sipush 200
    //   445: if_icmpeq +21 -> 466
    //   448: iload 5
    //   450: sipush 206
    //   453: if_icmpeq +13 -> 466
    //   456: sipush -3000
    //   459: iload 5
    //   461: isub
    //   462: istore_3
    //   463: goto -398 -> 65
    //   466: aload_1
    //   467: astore 7
    //   469: aload 6
    //   471: astore 8
    //   473: iload 4
    //   475: istore_3
    //   476: aload_0
    //   477: getfield 41	com/tencent/securemodule/ae:k	Z
    //   480: ifeq +10 -> 490
    //   483: sipush -3003
    //   486: istore_3
    //   487: goto -422 -> 65
    //   490: aload_1
    //   491: astore 7
    //   493: aload 6
    //   495: astore 8
    //   497: iload 4
    //   499: istore_3
    //   500: aload_1
    //   501: invokeinterface 305 1 0
    //   506: astore 9
    //   508: aload 9
    //   510: ifnonnull +10 -> 520
    //   513: sipush -4000
    //   516: istore_3
    //   517: goto -452 -> 65
    //   520: aload_1
    //   521: astore 7
    //   523: aload 6
    //   525: astore 8
    //   527: iload 4
    //   529: istore_3
    //   530: aload_0
    //   531: aload 9
    //   533: aload 11
    //   535: iload_2
    //   536: invokespecial 307	com/tencent/securemodule/ae:a	(Lorg/apache/http/HttpEntity;Landroid/os/Bundle;Z)I
    //   539: istore 4
    //   541: iload 4
    //   543: ifeq +16 -> 559
    //   546: iload 4
    //   548: bipush 249
    //   550: if_icmpne +569 -> 1119
    //   553: iload 4
    //   555: istore_3
    //   556: goto -491 -> 65
    //   559: aload_1
    //   560: astore 7
    //   562: aload 6
    //   564: astore 8
    //   566: iload 4
    //   568: istore_3
    //   569: aload_0
    //   570: iconst_1
    //   571: invokespecial 309	com/tencent/securemodule/ae:b	(Z)I
    //   574: istore 4
    //   576: iload 4
    //   578: ifeq +9 -> 587
    //   581: iload 4
    //   583: istore_3
    //   584: goto -519 -> 65
    //   587: iconst_0
    //   588: istore_3
    //   589: goto -524 -> 65
    //   592: astore 9
    //   594: aconst_null
    //   595: astore 8
    //   597: aconst_null
    //   598: astore 7
    //   600: sipush -3051
    //   603: istore_3
    //   604: aload 7
    //   606: astore 6
    //   608: aload 8
    //   610: astore_1
    //   611: aload 9
    //   613: invokevirtual 310	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   616: aload 8
    //   618: ifnull +15 -> 633
    //   621: aload 8
    //   623: invokeinterface 252 1 0
    //   628: invokeinterface 257 1 0
    //   633: aload 7
    //   635: ifnull +3 -> 638
    //   638: aload 11
    //   640: ldc_w 259
    //   643: sipush -3051
    //   646: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   649: aload_0
    //   650: iconst_1
    //   651: aload 11
    //   653: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   656: sipush -3051
    //   659: ireturn
    //   660: astore 9
    //   662: aconst_null
    //   663: astore 8
    //   665: aconst_null
    //   666: astore 7
    //   668: sipush -3054
    //   671: istore_3
    //   672: aload 7
    //   674: astore 6
    //   676: aload 8
    //   678: astore_1
    //   679: aload 9
    //   681: invokevirtual 208	java/net/SocketException:printStackTrace	()V
    //   684: aload 8
    //   686: ifnull +15 -> 701
    //   689: aload 8
    //   691: invokeinterface 252 1 0
    //   696: invokeinterface 257 1 0
    //   701: aload 7
    //   703: ifnull +3 -> 706
    //   706: aload 11
    //   708: ldc_w 259
    //   711: sipush -3054
    //   714: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   717: aload_0
    //   718: iconst_1
    //   719: aload 11
    //   721: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   724: sipush -3054
    //   727: ireturn
    //   728: astore 9
    //   730: aconst_null
    //   731: astore 8
    //   733: aconst_null
    //   734: astore 7
    //   736: sipush -3055
    //   739: istore_3
    //   740: aload 7
    //   742: astore 6
    //   744: aload 8
    //   746: astore_1
    //   747: aload 9
    //   749: invokevirtual 209	java/net/SocketTimeoutException:printStackTrace	()V
    //   752: aload 8
    //   754: ifnull +15 -> 769
    //   757: aload 8
    //   759: invokeinterface 252 1 0
    //   764: invokeinterface 257 1 0
    //   769: aload 7
    //   771: ifnull +3 -> 774
    //   774: aload 11
    //   776: ldc_w 259
    //   779: sipush -3055
    //   782: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   785: aload_0
    //   786: iconst_1
    //   787: aload 11
    //   789: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   792: sipush -3055
    //   795: ireturn
    //   796: astore 9
    //   798: aconst_null
    //   799: astore 8
    //   801: aconst_null
    //   802: astore 7
    //   804: sipush -3056
    //   807: istore_3
    //   808: aload 7
    //   810: astore 6
    //   812: aload 8
    //   814: astore_1
    //   815: aload 9
    //   817: invokevirtual 196	java/io/IOException:printStackTrace	()V
    //   820: aload 8
    //   822: ifnull +15 -> 837
    //   825: aload 8
    //   827: invokeinterface 252 1 0
    //   832: invokeinterface 257 1 0
    //   837: aload 7
    //   839: ifnull +3 -> 842
    //   842: aload 11
    //   844: ldc_w 259
    //   847: sipush -3056
    //   850: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   853: aload_0
    //   854: iconst_1
    //   855: aload 11
    //   857: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   860: sipush -3056
    //   863: ireturn
    //   864: astore 9
    //   866: aconst_null
    //   867: astore 8
    //   869: aconst_null
    //   870: astore 7
    //   872: sipush -3000
    //   875: istore_3
    //   876: aload 7
    //   878: astore 6
    //   880: aload 8
    //   882: astore_1
    //   883: aload 9
    //   885: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   888: aload 8
    //   890: ifnull +15 -> 905
    //   893: aload 8
    //   895: invokeinterface 252 1 0
    //   900: invokeinterface 257 1 0
    //   905: aload 7
    //   907: ifnull +3 -> 910
    //   910: aload 11
    //   912: ldc_w 259
    //   915: sipush -3000
    //   918: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   921: aload_0
    //   922: iconst_1
    //   923: aload 11
    //   925: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   928: sipush -3000
    //   931: ireturn
    //   932: astore 9
    //   934: aload 8
    //   936: astore_1
    //   937: aload 7
    //   939: astore 6
    //   941: aload 9
    //   943: astore 7
    //   945: aload_1
    //   946: ifnull +14 -> 960
    //   949: aload_1
    //   950: invokeinterface 252 1 0
    //   955: invokeinterface 257 1 0
    //   960: aload 6
    //   962: ifnull +3 -> 965
    //   965: iload_3
    //   966: ifeq +25 -> 991
    //   969: iload_3
    //   970: bipush 249
    //   972: if_icmpeq +19 -> 991
    //   975: aload 11
    //   977: ldc_w 259
    //   980: iload_3
    //   981: invokevirtual 140	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   984: aload_0
    //   985: iconst_1
    //   986: aload 11
    //   988: invokevirtual 199	com/tencent/securemodule/ae:a	(ILandroid/os/Bundle;)V
    //   991: aload 7
    //   993: athrow
    //   994: astore 7
    //   996: goto -51 -> 945
    //   999: astore 9
    //   1001: aconst_null
    //   1002: astore 7
    //   1004: aload 6
    //   1006: astore 8
    //   1008: goto -136 -> 872
    //   1011: astore 9
    //   1013: aload_1
    //   1014: astore 7
    //   1016: aload 6
    //   1018: astore 8
    //   1020: goto -148 -> 872
    //   1023: astore 9
    //   1025: aconst_null
    //   1026: astore 7
    //   1028: aload 6
    //   1030: astore 8
    //   1032: goto -228 -> 804
    //   1035: astore 9
    //   1037: aload_1
    //   1038: astore 7
    //   1040: aload 6
    //   1042: astore 8
    //   1044: goto -240 -> 804
    //   1047: astore 9
    //   1049: aconst_null
    //   1050: astore 7
    //   1052: aload 6
    //   1054: astore 8
    //   1056: goto -320 -> 736
    //   1059: astore 9
    //   1061: aload_1
    //   1062: astore 7
    //   1064: aload 6
    //   1066: astore 8
    //   1068: goto -332 -> 736
    //   1071: astore 9
    //   1073: aconst_null
    //   1074: astore 7
    //   1076: aload 6
    //   1078: astore 8
    //   1080: goto -412 -> 668
    //   1083: astore 9
    //   1085: aload_1
    //   1086: astore 7
    //   1088: aload 6
    //   1090: astore 8
    //   1092: goto -424 -> 668
    //   1095: astore 9
    //   1097: aconst_null
    //   1098: astore 7
    //   1100: aload 6
    //   1102: astore 8
    //   1104: goto -504 -> 600
    //   1107: astore 9
    //   1109: aload_1
    //   1110: astore 7
    //   1112: aload 6
    //   1114: astore 8
    //   1116: goto -516 -> 600
    //   1119: iload 4
    //   1121: istore_3
    //   1122: goto -1057 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1125	0	this	ae
    //   0	1125	1	paramString	String
    //   0	1125	2	paramBoolean	boolean
    //   29	1093	3	m	int
    //   3	1117	4	n	int
    //   438	24	5	i1	int
    //   34	1079	6	localObject1	Object
    //   25	967	7	localObject2	Object
    //   994	1	7	localObject3	Object
    //   1002	109	7	str	String
    //   6	1109	8	localObject4	Object
    //   9	523	9	localHttpEntity	org.apache.http.HttpEntity
    //   592	20	9	localClientProtocolException1	org.apache.http.client.ClientProtocolException
    //   660	20	9	localSocketException1	java.net.SocketException
    //   728	20	9	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   796	20	9	localIOException1	java.io.IOException
    //   864	20	9	localException1	java.lang.Exception
    //   932	10	9	localObject5	Object
    //   999	1	9	localException2	java.lang.Exception
    //   1011	1	9	localException3	java.lang.Exception
    //   1023	1	9	localIOException2	java.io.IOException
    //   1035	1	9	localIOException3	java.io.IOException
    //   1047	1	9	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   1059	1	9	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1071	1	9	localSocketException2	java.net.SocketException
    //   1083	1	9	localSocketException3	java.net.SocketException
    //   1095	1	9	localClientProtocolException2	org.apache.http.client.ClientProtocolException
    //   1107	1	9	localClientProtocolException3	org.apache.http.client.ClientProtocolException
    //   12	156	10	localObject6	Object
    //   21	966	11	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   30	36	592	org/apache/http/client/ClientProtocolException
    //   30	36	660	java/net/SocketException
    //   30	36	728	java/net/SocketTimeoutException
    //   30	36	796	java/io/IOException
    //   30	36	864	java/lang/Exception
    //   30	36	932	finally
    //   47	54	932	finally
    //   125	132	932	finally
    //   153	163	932	finally
    //   184	189	932	finally
    //   200	224	932	finally
    //   235	242	932	finally
    //   253	258	932	finally
    //   269	307	932	finally
    //   318	325	932	finally
    //   336	344	932	finally
    //   355	394	932	finally
    //   405	417	932	finally
    //   427	440	932	finally
    //   476	483	932	finally
    //   500	508	932	finally
    //   530	541	932	finally
    //   569	576	932	finally
    //   611	616	994	finally
    //   679	684	994	finally
    //   747	752	994	finally
    //   815	820	994	finally
    //   883	888	994	finally
    //   47	54	999	java/lang/Exception
    //   125	132	999	java/lang/Exception
    //   153	163	999	java/lang/Exception
    //   184	189	999	java/lang/Exception
    //   200	224	999	java/lang/Exception
    //   235	242	999	java/lang/Exception
    //   253	258	999	java/lang/Exception
    //   269	307	999	java/lang/Exception
    //   318	325	999	java/lang/Exception
    //   336	344	999	java/lang/Exception
    //   355	394	999	java/lang/Exception
    //   405	417	999	java/lang/Exception
    //   427	440	1011	java/lang/Exception
    //   476	483	1011	java/lang/Exception
    //   500	508	1011	java/lang/Exception
    //   530	541	1011	java/lang/Exception
    //   569	576	1011	java/lang/Exception
    //   47	54	1023	java/io/IOException
    //   125	132	1023	java/io/IOException
    //   153	163	1023	java/io/IOException
    //   184	189	1023	java/io/IOException
    //   200	224	1023	java/io/IOException
    //   235	242	1023	java/io/IOException
    //   253	258	1023	java/io/IOException
    //   269	307	1023	java/io/IOException
    //   318	325	1023	java/io/IOException
    //   336	344	1023	java/io/IOException
    //   355	394	1023	java/io/IOException
    //   405	417	1023	java/io/IOException
    //   427	440	1035	java/io/IOException
    //   476	483	1035	java/io/IOException
    //   500	508	1035	java/io/IOException
    //   530	541	1035	java/io/IOException
    //   569	576	1035	java/io/IOException
    //   47	54	1047	java/net/SocketTimeoutException
    //   125	132	1047	java/net/SocketTimeoutException
    //   153	163	1047	java/net/SocketTimeoutException
    //   184	189	1047	java/net/SocketTimeoutException
    //   200	224	1047	java/net/SocketTimeoutException
    //   235	242	1047	java/net/SocketTimeoutException
    //   253	258	1047	java/net/SocketTimeoutException
    //   269	307	1047	java/net/SocketTimeoutException
    //   318	325	1047	java/net/SocketTimeoutException
    //   336	344	1047	java/net/SocketTimeoutException
    //   355	394	1047	java/net/SocketTimeoutException
    //   405	417	1047	java/net/SocketTimeoutException
    //   427	440	1059	java/net/SocketTimeoutException
    //   476	483	1059	java/net/SocketTimeoutException
    //   500	508	1059	java/net/SocketTimeoutException
    //   530	541	1059	java/net/SocketTimeoutException
    //   569	576	1059	java/net/SocketTimeoutException
    //   47	54	1071	java/net/SocketException
    //   125	132	1071	java/net/SocketException
    //   153	163	1071	java/net/SocketException
    //   184	189	1071	java/net/SocketException
    //   200	224	1071	java/net/SocketException
    //   235	242	1071	java/net/SocketException
    //   253	258	1071	java/net/SocketException
    //   269	307	1071	java/net/SocketException
    //   318	325	1071	java/net/SocketException
    //   336	344	1071	java/net/SocketException
    //   355	394	1071	java/net/SocketException
    //   405	417	1071	java/net/SocketException
    //   427	440	1083	java/net/SocketException
    //   476	483	1083	java/net/SocketException
    //   500	508	1083	java/net/SocketException
    //   530	541	1083	java/net/SocketException
    //   569	576	1083	java/net/SocketException
    //   47	54	1095	org/apache/http/client/ClientProtocolException
    //   125	132	1095	org/apache/http/client/ClientProtocolException
    //   153	163	1095	org/apache/http/client/ClientProtocolException
    //   184	189	1095	org/apache/http/client/ClientProtocolException
    //   200	224	1095	org/apache/http/client/ClientProtocolException
    //   235	242	1095	org/apache/http/client/ClientProtocolException
    //   253	258	1095	org/apache/http/client/ClientProtocolException
    //   269	307	1095	org/apache/http/client/ClientProtocolException
    //   318	325	1095	org/apache/http/client/ClientProtocolException
    //   336	344	1095	org/apache/http/client/ClientProtocolException
    //   355	394	1095	org/apache/http/client/ClientProtocolException
    //   405	417	1095	org/apache/http/client/ClientProtocolException
    //   427	440	1107	org/apache/http/client/ClientProtocolException
    //   476	483	1107	org/apache/http/client/ClientProtocolException
    //   500	508	1107	org/apache/http/client/ClientProtocolException
    //   530	541	1107	org/apache/http/client/ClientProtocolException
    //   569	576	1107	org/apache/http/client/ClientProtocolException
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.securemodule.ae
 * JD-Core Version:    0.7.0.1
 */