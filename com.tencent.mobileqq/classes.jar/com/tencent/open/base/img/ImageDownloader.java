package com.tencent.open.base.img;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ImageDownloader
{
  protected static String a = "ImageDownloader";
  protected static int b = 2048;
  protected static int c = 1048576;
  
  protected static void a(HttpURLConnection paramHttpURLConnection)
  {
    if (paramHttpURLConnection != null) {
      try
      {
        paramHttpURLConnection.disconnect();
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        LogUtility.c("", "", paramHttpURLConnection);
      }
    }
  }
  
  /* Error */
  public static boolean a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 12
    //   6: aload_0
    //   7: invokestatic 38	com/tencent/open/base/img/ImageDownloader:b	(Lcom/tencent/open/base/img/ImageInfo;)Ljava/net/HttpURLConnection;
    //   10: astore 5
    //   12: aload 5
    //   14: ifnonnull +65 -> 79
    //   17: getstatic 40	com/tencent/open/base/img/ImageDownloader:a	Ljava/lang/String;
    //   20: astore 6
    //   22: new 42	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   29: astore 7
    //   31: aload 7
    //   33: ldc 45
    //   35: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 7
    //   41: aload_0
    //   42: getfield 53	com/tencent/open/base/img/ImageInfo:b	Ljava/lang/String;
    //   45: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 7
    //   51: ldc 55
    //   53: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 6
    //   59: aload 7
    //   61: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 62	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 5
    //   69: ifnull +8 -> 77
    //   72: aload 5
    //   74: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   77: iconst_0
    //   78: ireturn
    //   79: aload 5
    //   81: invokevirtual 66	java/net/HttpURLConnection:getContentLength	()I
    //   84: i2l
    //   85: lstore_3
    //   86: invokestatic 72	com/tencent/open/appcommon/Common:p	()J
    //   89: lload_3
    //   90: lcmp
    //   91: ifge +65 -> 156
    //   94: getstatic 40	com/tencent/open/base/img/ImageDownloader:a	Ljava/lang/String;
    //   97: astore 6
    //   99: new 42	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   106: astore 7
    //   108: aload 7
    //   110: ldc 45
    //   112: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 7
    //   118: aload_0
    //   119: getfield 53	com/tencent/open/base/img/ImageInfo:b	Ljava/lang/String;
    //   122: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: pop
    //   126: aload 7
    //   128: ldc 74
    //   130: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload 6
    //   136: aload 7
    //   138: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 62	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload 5
    //   146: ifnull +8 -> 154
    //   149: aload 5
    //   151: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: aload 5
    //   158: invokevirtual 78	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   161: astore 7
    //   163: lconst_0
    //   164: lstore_3
    //   165: getstatic 80	com/tencent/open/base/img/ImageDownloader:b	I
    //   168: newarray byte
    //   170: astore 6
    //   172: new 82	java/io/ByteArrayOutputStream
    //   175: dup
    //   176: invokespecial 83	java/io/ByteArrayOutputStream:<init>	()V
    //   179: astore 13
    //   181: aload 7
    //   183: aload 6
    //   185: iconst_0
    //   186: getstatic 80	com/tencent/open/base/img/ImageDownloader:b	I
    //   189: invokevirtual 89	java/io/InputStream:read	([BII)I
    //   192: istore_1
    //   193: iload_1
    //   194: ifle +61 -> 255
    //   197: getstatic 91	com/tencent/open/base/img/ImageDownloader:c	I
    //   200: istore_2
    //   201: lload_3
    //   202: iload_2
    //   203: i2l
    //   204: lcmp
    //   205: iflt +33 -> 238
    //   208: aload 7
    //   210: ifnull +16 -> 226
    //   213: aload 7
    //   215: invokevirtual 94	java/io/InputStream:close	()V
    //   218: goto +8 -> 226
    //   221: astore_0
    //   222: aload_0
    //   223: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   226: aload 5
    //   228: ifnull +8 -> 236
    //   231: aload 5
    //   233: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   236: iconst_0
    //   237: ireturn
    //   238: aload 13
    //   240: aload 6
    //   242: iconst_0
    //   243: iload_1
    //   244: invokevirtual 101	java/io/ByteArrayOutputStream:write	([BII)V
    //   247: lload_3
    //   248: iload_1
    //   249: i2l
    //   250: ladd
    //   251: lstore_3
    //   252: goto -71 -> 181
    //   255: new 42	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   262: astore 6
    //   264: aload 6
    //   266: invokestatic 104	com/tencent/open/appcommon/Common:f	()Ljava/lang/String;
    //   269: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: getstatic 107	com/tencent/open/base/img/ImageCache:a	Ljava/lang/String;
    //   278: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 6
    //   284: aload_0
    //   285: getfield 109	com/tencent/open/base/img/ImageInfo:f	Ljava/lang/String;
    //   288: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 6
    //   294: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   297: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 6
    //   303: aload_0
    //   304: getfield 53	com/tencent/open/base/img/ImageInfo:b	Ljava/lang/String;
    //   307: invokestatic 119	com/tencent/open/base/FileUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   310: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 6
    //   316: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: astore 14
    //   321: new 42	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   328: astore 6
    //   330: aload 6
    //   332: aload 14
    //   334: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 6
    //   340: ldc 121
    //   342: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: new 111	java/io/File
    //   349: dup
    //   350: aload 6
    //   352: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   358: astore 11
    //   360: aload 11
    //   362: invokevirtual 127	java/io/File:getParent	()Ljava/lang/String;
    //   365: ifnull +23 -> 388
    //   368: aload 11
    //   370: invokevirtual 131	java/io/File:getParentFile	()Ljava/io/File;
    //   373: invokevirtual 135	java/io/File:exists	()Z
    //   376: ifne +12 -> 388
    //   379: aload 11
    //   381: invokevirtual 131	java/io/File:getParentFile	()Ljava/io/File;
    //   384: invokevirtual 138	java/io/File:mkdirs	()Z
    //   387: pop
    //   388: aload 11
    //   390: invokevirtual 135	java/io/File:exists	()Z
    //   393: ifeq +9 -> 402
    //   396: aload 11
    //   398: invokevirtual 141	java/io/File:delete	()Z
    //   401: pop
    //   402: aload 11
    //   404: invokevirtual 144	java/io/File:createNewFile	()Z
    //   407: pop
    //   408: new 42	java/lang/StringBuilder
    //   411: dup
    //   412: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   415: astore 6
    //   417: aload 6
    //   419: aload 14
    //   421: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 6
    //   427: ldc 121
    //   429: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: new 146	java/io/FileOutputStream
    //   436: dup
    //   437: aload 6
    //   439: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   445: astore 10
    //   447: aload 5
    //   449: astore 6
    //   451: aload 7
    //   453: astore 8
    //   455: aload 10
    //   457: astore 9
    //   459: aload 10
    //   461: aload 13
    //   463: invokevirtual 151	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   466: invokevirtual 154	java/io/FileOutputStream:write	([B)V
    //   469: aload 5
    //   471: astore 6
    //   473: aload 7
    //   475: astore 8
    //   477: aload 10
    //   479: astore 9
    //   481: aload 10
    //   483: invokevirtual 157	java/io/FileOutputStream:flush	()V
    //   486: aload 5
    //   488: astore 6
    //   490: aload 7
    //   492: astore 8
    //   494: aload 10
    //   496: astore 9
    //   498: new 111	java/io/File
    //   501: dup
    //   502: aload 14
    //   504: invokespecial 124	java/io/File:<init>	(Ljava/lang/String;)V
    //   507: astore 12
    //   509: aload 5
    //   511: astore 6
    //   513: aload 7
    //   515: astore 8
    //   517: aload 10
    //   519: astore 9
    //   521: aload 12
    //   523: invokevirtual 135	java/io/File:exists	()Z
    //   526: ifeq +21 -> 547
    //   529: aload 5
    //   531: astore 6
    //   533: aload 7
    //   535: astore 8
    //   537: aload 10
    //   539: astore 9
    //   541: aload 12
    //   543: invokevirtual 141	java/io/File:delete	()Z
    //   546: pop
    //   547: aload 5
    //   549: astore 6
    //   551: aload 7
    //   553: astore 8
    //   555: aload 10
    //   557: astore 9
    //   559: aload 11
    //   561: aload 12
    //   563: invokevirtual 161	java/io/File:renameTo	(Ljava/io/File;)Z
    //   566: pop
    //   567: aload 5
    //   569: astore 6
    //   571: aload 7
    //   573: astore 8
    //   575: aload 10
    //   577: astore 9
    //   579: ldc 163
    //   581: aload_0
    //   582: getfield 164	com/tencent/open/base/img/ImageInfo:a	Ljava/lang/String;
    //   585: invokestatic 62	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   588: aload 5
    //   590: astore 6
    //   592: aload 7
    //   594: astore 8
    //   596: aload 10
    //   598: astore 9
    //   600: aload_0
    //   601: aload 5
    //   603: invokevirtual 167	java/net/HttpURLConnection:getLastModified	()J
    //   606: putfield 171	com/tencent/open/base/img/ImageInfo:e	J
    //   609: aload 10
    //   611: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   614: aload 7
    //   616: ifnull +16 -> 632
    //   619: aload 7
    //   621: invokevirtual 94	java/io/InputStream:close	()V
    //   624: goto +8 -> 632
    //   627: astore_0
    //   628: aload_0
    //   629: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   632: aload 5
    //   634: ifnull +8 -> 642
    //   637: aload 5
    //   639: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   642: iconst_1
    //   643: ireturn
    //   644: astore 6
    //   646: aload 12
    //   648: astore_0
    //   649: aload 10
    //   651: astore 8
    //   653: goto +21 -> 674
    //   656: astore 6
    //   658: aconst_null
    //   659: astore_0
    //   660: aload 10
    //   662: astore 8
    //   664: goto +10 -> 674
    //   667: astore 6
    //   669: aconst_null
    //   670: astore_0
    //   671: aload_0
    //   672: astore 8
    //   674: aload 11
    //   676: astore 12
    //   678: aload_0
    //   679: astore 10
    //   681: aload 8
    //   683: astore_0
    //   684: aload 6
    //   686: astore 11
    //   688: goto +74 -> 762
    //   691: astore 9
    //   693: aload 5
    //   695: astore 6
    //   697: aload 7
    //   699: astore_0
    //   700: aload 9
    //   702: astore 5
    //   704: goto +210 -> 914
    //   707: astore 11
    //   709: aconst_null
    //   710: astore 10
    //   712: aload 10
    //   714: astore_0
    //   715: goto +47 -> 762
    //   718: astore 7
    //   720: aconst_null
    //   721: astore_0
    //   722: aload 5
    //   724: astore 6
    //   726: aload 7
    //   728: astore 5
    //   730: goto +184 -> 914
    //   733: astore 11
    //   735: goto +19 -> 754
    //   738: astore 5
    //   740: aconst_null
    //   741: astore 6
    //   743: aload 6
    //   745: astore_0
    //   746: goto +168 -> 914
    //   749: astore 11
    //   751: aconst_null
    //   752: astore 5
    //   754: aconst_null
    //   755: astore 7
    //   757: aconst_null
    //   758: astore 10
    //   760: aconst_null
    //   761: astore_0
    //   762: aload 5
    //   764: astore 6
    //   766: aload 7
    //   768: astore 8
    //   770: aload_0
    //   771: astore 9
    //   773: getstatic 40	com/tencent/open/base/img/ImageDownloader:a	Ljava/lang/String;
    //   776: ldc 174
    //   778: aload 11
    //   780: invokestatic 34	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   783: aload 12
    //   785: ifnull +39 -> 824
    //   788: aload 5
    //   790: astore 6
    //   792: aload 7
    //   794: astore 8
    //   796: aload_0
    //   797: astore 9
    //   799: aload 12
    //   801: invokevirtual 135	java/io/File:exists	()Z
    //   804: ifeq +20 -> 824
    //   807: aload 5
    //   809: astore 6
    //   811: aload 7
    //   813: astore 8
    //   815: aload_0
    //   816: astore 9
    //   818: aload 12
    //   820: invokevirtual 141	java/io/File:delete	()Z
    //   823: pop
    //   824: aload 10
    //   826: ifnull +39 -> 865
    //   829: aload 5
    //   831: astore 6
    //   833: aload 7
    //   835: astore 8
    //   837: aload_0
    //   838: astore 9
    //   840: aload 10
    //   842: invokevirtual 135	java/io/File:exists	()Z
    //   845: ifeq +20 -> 865
    //   848: aload 5
    //   850: astore 6
    //   852: aload 7
    //   854: astore 8
    //   856: aload_0
    //   857: astore 9
    //   859: aload 10
    //   861: invokevirtual 141	java/io/File:delete	()Z
    //   864: pop
    //   865: aload_0
    //   866: ifnull +10 -> 876
    //   869: aload_0
    //   870: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   873: goto +3 -> 876
    //   876: aload 7
    //   878: ifnull +15 -> 893
    //   881: aload 7
    //   883: invokevirtual 94	java/io/InputStream:close	()V
    //   886: goto +7 -> 893
    //   889: aload_0
    //   890: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   893: aload 5
    //   895: ifnull +8 -> 903
    //   898: aload 5
    //   900: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   903: iconst_0
    //   904: ireturn
    //   905: astore 5
    //   907: aload 8
    //   909: astore_0
    //   910: aload 9
    //   912: astore 8
    //   914: aload 8
    //   916: ifnull +11 -> 927
    //   919: aload 8
    //   921: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   924: goto +3 -> 927
    //   927: aload_0
    //   928: ifnull +14 -> 942
    //   931: aload_0
    //   932: invokevirtual 94	java/io/InputStream:close	()V
    //   935: goto +7 -> 942
    //   938: aload_0
    //   939: invokevirtual 97	java/lang/Exception:printStackTrace	()V
    //   942: aload 6
    //   944: ifnull +8 -> 952
    //   947: aload 6
    //   949: invokevirtual 27	java/net/HttpURLConnection:disconnect	()V
    //   952: goto +6 -> 958
    //   955: aload 5
    //   957: athrow
    //   958: goto -3 -> 955
    //   961: astore_0
    //   962: goto -73 -> 889
    //   965: astore_0
    //   966: goto -28 -> 938
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	969	0	paramImageInfo	ImageInfo
    //   192	57	1	i	int
    //   200	3	2	j	int
    //   85	167	3	l	long
    //   10	719	5	localObject1	Object
    //   738	1	5	localObject2	Object
    //   752	147	5	localObject3	Object
    //   905	51	5	localObject4	Object
    //   20	571	6	localObject5	Object
    //   644	1	6	localException1	Exception
    //   656	1	6	localException2	Exception
    //   667	18	6	localException3	Exception
    //   695	253	6	localObject6	Object
    //   29	669	7	localObject7	Object
    //   718	9	7	localObject8	Object
    //   755	127	7	localObject9	Object
    //   1	919	8	localObject10	Object
    //   457	142	9	localObject11	Object
    //   691	10	9	localObject12	Object
    //   771	140	9	localImageInfo	ImageInfo
    //   445	415	10	localObject13	Object
    //   358	329	11	localObject14	Object
    //   707	1	11	localException4	Exception
    //   733	1	11	localException5	Exception
    //   749	30	11	localException6	Exception
    //   4	815	12	localObject15	Object
    //   179	283	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   319	184	14	str	String
    // Exception table:
    //   from	to	target	type
    //   213	218	221	java/lang/Exception
    //   609	614	627	java/lang/Exception
    //   619	624	627	java/lang/Exception
    //   521	529	644	java/lang/Exception
    //   541	547	644	java/lang/Exception
    //   559	567	644	java/lang/Exception
    //   579	588	644	java/lang/Exception
    //   600	609	644	java/lang/Exception
    //   459	469	656	java/lang/Exception
    //   481	486	656	java/lang/Exception
    //   498	509	656	java/lang/Exception
    //   360	388	667	java/lang/Exception
    //   388	402	667	java/lang/Exception
    //   402	447	667	java/lang/Exception
    //   165	181	691	finally
    //   181	193	691	finally
    //   197	201	691	finally
    //   238	247	691	finally
    //   255	360	691	finally
    //   360	388	691	finally
    //   388	402	691	finally
    //   402	447	691	finally
    //   165	181	707	java/lang/Exception
    //   181	193	707	java/lang/Exception
    //   197	201	707	java/lang/Exception
    //   238	247	707	java/lang/Exception
    //   255	360	707	java/lang/Exception
    //   17	67	718	finally
    //   79	144	718	finally
    //   156	163	718	finally
    //   17	67	733	java/lang/Exception
    //   79	144	733	java/lang/Exception
    //   156	163	733	java/lang/Exception
    //   6	12	738	finally
    //   6	12	749	java/lang/Exception
    //   459	469	905	finally
    //   481	486	905	finally
    //   498	509	905	finally
    //   521	529	905	finally
    //   541	547	905	finally
    //   559	567	905	finally
    //   579	588	905	finally
    //   600	609	905	finally
    //   773	783	905	finally
    //   799	807	905	finally
    //   818	824	905	finally
    //   840	848	905	finally
    //   859	865	905	finally
    //   869	873	961	java/lang/Exception
    //   881	886	961	java/lang/Exception
    //   919	924	965	java/lang/Exception
    //   931	935	965	java/lang/Exception
  }
  
  protected static long b(HttpURLConnection paramHttpURLConnection)
  {
    paramHttpURLConnection = paramHttpURLConnection.getHeaderField("Cache-Control");
    if (paramHttpURLConnection == null) {
      return 0L;
    }
    paramHttpURLConnection = TextUtils.split(paramHttpURLConnection, ",");
    int i = 0;
    while (i < paramHttpURLConnection.length)
    {
      if (paramHttpURLConnection[i].contains("max-age")) {
        return Long.parseLong(paramHttpURLConnection[i].trim().replace("max-age=", ""));
      }
      i += 1;
    }
    return 0L;
  }
  
  protected static HttpURLConnection b(ImageInfo paramImageInfo)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject3;
      int i;
      try
      {
        localObject1 = MsfSdkUtils.insertMtype("yingyongbao", paramImageInfo.b);
        boolean bool = APNUtil.f(CommonDataAdapter.a().b());
        Object localObject4 = "";
        Object localObject5;
        Object localObject2;
        if (bool)
        {
          localObject3 = APNUtil.c(CommonDataAdapter.a().b());
          localObject5 = APNUtil.d(CommonDataAdapter.a().b());
          i = ((String)localObject1).indexOf('/', 7);
          if (i < 0)
          {
            localObject2 = ((String)localObject1).substring(7);
            localObject1 = "";
          }
          else
          {
            localObject2 = ((String)localObject1).substring(7, i);
            localObject1 = ((String)localObject1).substring(i);
          }
          Object localObject6 = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("https://");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localObject5);
          localStringBuilder.append((String)localObject1);
          LogUtility.c((String)localObject6, localStringBuilder.toString());
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("http://");
          ((StringBuilder)localObject6).append((String)localObject3);
          ((StringBuilder)localObject6).append(":");
          ((StringBuilder)localObject6).append((String)localObject5);
          ((StringBuilder)localObject6).append((String)localObject1);
          localObject3 = (HttpURLConnection)new URL(((StringBuilder)localObject6).toString()).openConnection();
          localObject1 = localObject3;
        }
        try
        {
          ((HttpURLConnection)localObject3).setRequestProperty("X-Online-Host", (String)localObject2);
          localObject2 = localObject3;
          continue;
          localObject2 = (HttpURLConnection)new URL((String)localObject1).openConnection();
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setRequestMethod("GET");
          int j = 1;
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setDoInput(true);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setAllowUserInteraction(true);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setConnectTimeout(60000);
          localObject1 = localObject2;
          ((HttpURLConnection)localObject2).setReadTimeout(120000);
          localObject1 = localObject2;
          if (paramImageInfo.e > 0L)
          {
            localObject1 = localObject2;
            localObject3 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            localObject1 = localObject2;
            ((SimpleDateFormat)localObject3).setTimeZone(TimeZone.getTimeZone("GMT"));
            localObject1 = localObject2;
            ((HttpURLConnection)localObject2).setRequestProperty("If-Modified-Since", ((SimpleDateFormat)localObject3).format(new Date(paramImageInfo.e)));
          }
          localObject1 = localObject2;
          i = ((HttpURLConnection)localObject2).getResponseCode();
          localObject1 = localObject2;
          localObject3 = a;
          localObject1 = localObject2;
          localObject5 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append("--getHttpConnection-- reponseCode=");
          localObject1 = localObject2;
          ((StringBuilder)localObject5).append(i);
          localObject1 = localObject2;
          LogUtility.c((String)localObject3, ((StringBuilder)localObject5).toString());
          if (i != 302)
          {
            if (i != 301) {
              break label968;
            }
            continue;
            if (i == 304)
            {
              localObject1 = localObject2;
              localObject3 = a;
              localObject1 = localObject2;
              localObject4 = new StringBuilder();
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append("--getimg-- ");
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append(paramImageInfo.b);
              localObject1 = localObject2;
              ((StringBuilder)localObject4).append(" not modified");
              localObject1 = localObject2;
              LogUtility.c((String)localObject3, ((StringBuilder)localObject4).toString());
              localObject1 = localObject2;
              paramImageInfo.c = (b((HttpURLConnection)localObject2) * 1000L);
              localObject1 = localObject2;
              paramImageInfo.d = System.currentTimeMillis();
              localObject1 = localObject2;
              a((HttpURLConnection)localObject2);
              break label985;
            }
            localObject1 = localObject2;
            a((HttpURLConnection)localObject2);
            break label985;
            localObject1 = localObject2;
            localObject3 = ((HttpURLConnection)localObject2).getContentType();
            if (localObject3 == null)
            {
              localObject3 = localObject4;
            }
            else
            {
              localObject1 = localObject2;
              localObject3 = ((String)localObject3).toLowerCase();
            }
            i = j;
            localObject1 = localObject2;
            if (((String)localObject3).indexOf("text/vnd.wap.wml") == -1)
            {
              i = j;
              localObject1 = localObject2;
              if (((String)localObject3).indexOf("application/vnd.wap.wmlc") == -1)
              {
                localObject1 = localObject2;
                if (((String)localObject3).indexOf("text") == -1) {
                  break label991;
                }
                i = j;
              }
            }
            localObject3 = localObject2;
            if (i != 0)
            {
              localObject1 = localObject2;
              a((HttpURLConnection)localObject2);
              localObject3 = null;
            }
            if (localObject3 != null)
            {
              localObject1 = localObject3;
              paramImageInfo.c = (b((HttpURLConnection)localObject3) * 1000L);
              localObject1 = localObject3;
              if (paramImageInfo.c == 0L)
              {
                localObject1 = localObject3;
                paramImageInfo.c = 86400000L;
              }
            }
            localObject1 = localObject3;
            paramImageInfo.d = System.currentTimeMillis();
            continue;
          }
          localObject1 = localObject2;
          paramImageInfo = ((HttpURLConnection)localObject2).getHeaderField("Location");
          localObject1 = localObject2;
          localObject3 = a;
          localObject1 = localObject2;
          localObject4 = new StringBuilder();
          localObject1 = localObject2;
          ((StringBuilder)localObject4).append("--getHttpConnection-- loc=");
          localObject1 = localObject2;
          ((StringBuilder)localObject4).append(paramImageInfo);
          localObject1 = localObject2;
          LogUtility.c((String)localObject3, ((StringBuilder)localObject4).toString());
          localObject1 = localObject2;
          a((HttpURLConnection)localObject2);
          break label985;
          localObject1 = localObject3;
          paramImageInfo = a;
          localObject1 = localObject3;
          localObject2 = new StringBuilder();
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append("--getHttpConnection-- uc=");
          localObject1 = localObject3;
          ((StringBuilder)localObject2).append(localObject3);
          localObject1 = localObject3;
          LogUtility.c(paramImageInfo, ((StringBuilder)localObject2).toString());
          return localObject3;
        }
        catch (Exception paramImageInfo) {}
        LogUtility.c(a, "--getHttpConnection-- Exception!!!", paramImageInfo);
      }
      catch (Exception paramImageInfo)
      {
        localObject1 = null;
      }
      a((HttpURLConnection)localObject1);
      return null;
      label968:
      if (i != 200) {
        if (i == 206)
        {
          continue;
          label985:
          localObject3 = null;
          continue;
          label991:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDownloader
 * JD-Core Version:    0.7.0.1
 */