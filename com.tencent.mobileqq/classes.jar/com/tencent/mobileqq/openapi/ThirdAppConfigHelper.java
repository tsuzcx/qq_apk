package com.tencent.mobileqq.openapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Random;

public class ThirdAppConfigHelper
{
  static final String[] a = { "1234567890twstest", "123AppShadowQQ", "gwatchdm2016" };
  static final String[] b = { "com.tencent.tws.devicemanager", "com.tencent.shadowqq", "com.tencent.tws.gdevicemanager" };
  static final String[] c = { "E63D0E11EF7837C5A1BEB948742B0CB6", "CCD4AD38DC6669F875BC37E3F8840648", "E63D0E11EF7837C5A1BEB948742B0CB6" };
  private static HashMap<String, ThirdAppConfigHelper.ThirdAppConfig> d = new HashMap();
  
  /* Error */
  public static final ThirdAppConfigHelper.ThirdAppConfig a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   9: aload_1
    //   10: invokevirtual 53	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   13: ifeq +18 -> 31
    //   16: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   19: aload_1
    //   20: invokevirtual 57	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 59	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig
    //   26: astore_0
    //   27: aload_3
    //   28: monitorexit
    //   29: aload_0
    //   30: areturn
    //   31: aload_3
    //   32: monitorexit
    //   33: aload_0
    //   34: invokevirtual 65	android/content/Context:getFilesDir	()Ljava/io/File;
    //   37: astore_3
    //   38: new 67	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: aload_1
    //   50: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 4
    //   56: ldc 74
    //   58: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: new 76	java/io/File
    //   65: dup
    //   66: aload_3
    //   67: aload 4
    //   69: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 83	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 8
    //   77: aload 8
    //   79: invokevirtual 87	java/io/File:exists	()Z
    //   82: istore_2
    //   83: aconst_null
    //   84: astore 7
    //   86: iload_2
    //   87: ifeq +658 -> 745
    //   90: aload 8
    //   92: invokevirtual 91	java/io/File:length	()J
    //   95: lconst_0
    //   96: lcmp
    //   97: ifne +6 -> 103
    //   100: goto +645 -> 745
    //   103: new 59	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig
    //   106: dup
    //   107: invokespecial 92	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:<init>	()V
    //   110: astore 6
    //   112: new 94	java/io/ByteArrayInputStream
    //   115: dup
    //   116: aload 8
    //   118: invokestatic 100	com/tencent/mobileqq/utils/FileUtils:fileToBytes	(Ljava/io/File;)[B
    //   121: invokespecial 103	java/io/ByteArrayInputStream:<init>	([B)V
    //   124: astore_3
    //   125: new 105	java/io/ObjectInputStream
    //   128: dup
    //   129: aload_3
    //   130: invokespecial 108	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   133: astore_0
    //   134: aload_0
    //   135: astore 4
    //   137: aload_3
    //   138: astore 5
    //   140: aload 6
    //   142: aload_0
    //   143: invokevirtual 112	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   146: checkcast 22	java/lang/String
    //   149: putfield 115	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:a	Ljava/lang/String;
    //   152: aload_0
    //   153: astore 4
    //   155: aload_3
    //   156: astore 5
    //   158: aload 6
    //   160: aload_0
    //   161: invokevirtual 118	java/io/ObjectInputStream:readBoolean	()Z
    //   164: putfield 121	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:b	Z
    //   167: aload_0
    //   168: astore 4
    //   170: aload_3
    //   171: astore 5
    //   173: aload 6
    //   175: getfield 121	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:b	Z
    //   178: ifeq +429 -> 607
    //   181: aload_0
    //   182: astore 4
    //   184: aload_3
    //   185: astore 5
    //   187: aload 6
    //   189: aload_0
    //   190: invokevirtual 112	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   193: checkcast 22	java/lang/String
    //   196: putfield 123	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:c	Ljava/lang/String;
    //   199: aload_0
    //   200: astore 4
    //   202: aload_3
    //   203: astore 5
    //   205: aload 6
    //   207: aload_0
    //   208: invokevirtual 112	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   211: checkcast 22	java/lang/String
    //   214: putfield 125	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:d	Ljava/lang/String;
    //   217: aload_0
    //   218: astore 4
    //   220: aload_3
    //   221: astore 5
    //   223: aload 6
    //   225: aload_0
    //   226: invokevirtual 129	java/io/ObjectInputStream:readInt	()I
    //   229: putfield 133	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:e	I
    //   232: aload_0
    //   233: astore 4
    //   235: aload_3
    //   236: astore 5
    //   238: aload 6
    //   240: aload_0
    //   241: invokevirtual 129	java/io/ObjectInputStream:readInt	()I
    //   244: putfield 136	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:f	I
    //   247: aload_0
    //   248: astore 4
    //   250: aload_3
    //   251: astore 5
    //   253: aload 6
    //   255: aload_0
    //   256: invokevirtual 129	java/io/ObjectInputStream:readInt	()I
    //   259: putfield 139	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:g	I
    //   262: aload_0
    //   263: astore 4
    //   265: aload_3
    //   266: astore 5
    //   268: aload 6
    //   270: aload_0
    //   271: invokevirtual 142	java/io/ObjectInputStream:readLong	()J
    //   274: putfield 146	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:i	J
    //   277: aload_0
    //   278: astore 4
    //   280: aload_3
    //   281: astore 5
    //   283: aload 6
    //   285: aload_0
    //   286: invokevirtual 142	java/io/ObjectInputStream:readLong	()J
    //   289: putfield 149	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:h	J
    //   292: aload_0
    //   293: astore 4
    //   295: aload_3
    //   296: astore 5
    //   298: invokestatic 154	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   301: aload 6
    //   303: getfield 146	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:i	J
    //   306: lsub
    //   307: invokestatic 160	java/lang/Math:abs	(J)J
    //   310: ldc2_w 161
    //   313: lcmp
    //   314: ifle +156 -> 470
    //   317: aload_0
    //   318: astore 4
    //   320: aload_3
    //   321: astore 5
    //   323: aload 6
    //   325: iconst_1
    //   326: putfield 165	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:j	Z
    //   329: aload_0
    //   330: astore 4
    //   332: aload_3
    //   333: astore 5
    //   335: aload 6
    //   337: invokestatic 154	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTimeMillis	()J
    //   340: putfield 168	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:l	J
    //   343: aload_0
    //   344: astore 4
    //   346: aload_3
    //   347: astore 5
    //   349: aload 6
    //   351: new 170	java/util/Random
    //   354: dup
    //   355: invokespecial 171	java/util/Random:<init>	()V
    //   358: invokevirtual 174	java/util/Random:nextLong	()J
    //   361: putfield 177	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:k	J
    //   364: aload_0
    //   365: astore 4
    //   367: aload_3
    //   368: astore 5
    //   370: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +97 -> 470
    //   376: aload_0
    //   377: astore 4
    //   379: aload_3
    //   380: astore 5
    //   382: new 67	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   389: astore 9
    //   391: aload_0
    //   392: astore 4
    //   394: aload_3
    //   395: astore 5
    //   397: aload 9
    //   399: ldc 184
    //   401: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_0
    //   406: astore 4
    //   408: aload_3
    //   409: astore 5
    //   411: aload 9
    //   413: aload 6
    //   415: getfield 146	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:i	J
    //   418: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload_0
    //   423: astore 4
    //   425: aload_3
    //   426: astore 5
    //   428: aload 9
    //   430: ldc 189
    //   432: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_0
    //   437: astore 4
    //   439: aload_3
    //   440: astore 5
    //   442: aload 9
    //   444: aload 6
    //   446: getfield 168	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:l	J
    //   449: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload_0
    //   454: astore 4
    //   456: aload_3
    //   457: astore 5
    //   459: ldc 191
    //   461: iconst_2
    //   462: aload 9
    //   464: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: aload_0
    //   471: astore 4
    //   473: aload_3
    //   474: astore 5
    //   476: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +128 -> 607
    //   482: aload_0
    //   483: astore 4
    //   485: aload_3
    //   486: astore 5
    //   488: new 67	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   495: astore 9
    //   497: aload_0
    //   498: astore 4
    //   500: aload_3
    //   501: astore 5
    //   503: aload 9
    //   505: ldc 196
    //   507: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload_0
    //   512: astore 4
    //   514: aload_3
    //   515: astore 5
    //   517: aload 9
    //   519: aload 6
    //   521: getfield 123	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:c	Ljava/lang/String;
    //   524: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_0
    //   529: astore 4
    //   531: aload_3
    //   532: astore 5
    //   534: aload 9
    //   536: ldc 198
    //   538: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_0
    //   543: astore 4
    //   545: aload_3
    //   546: astore 5
    //   548: aload 9
    //   550: aload 6
    //   552: getfield 136	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:f	I
    //   555: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload_0
    //   560: astore 4
    //   562: aload_3
    //   563: astore 5
    //   565: aload 9
    //   567: ldc 198
    //   569: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: pop
    //   573: aload_0
    //   574: astore 4
    //   576: aload_3
    //   577: astore 5
    //   579: aload 9
    //   581: aload 6
    //   583: getfield 139	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:g	I
    //   586: invokevirtual 201	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: aload_0
    //   591: astore 4
    //   593: aload_3
    //   594: astore 5
    //   596: ldc 191
    //   598: iconst_2
    //   599: aload 9
    //   601: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_0
    //   608: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   611: aload_3
    //   612: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   615: aload 6
    //   617: astore_0
    //   618: goto +133 -> 751
    //   621: astore 6
    //   623: goto +33 -> 656
    //   626: astore_0
    //   627: aconst_null
    //   628: astore 4
    //   630: goto +92 -> 722
    //   633: astore 6
    //   635: aconst_null
    //   636: astore_0
    //   637: goto +19 -> 656
    //   640: astore_0
    //   641: aconst_null
    //   642: astore 4
    //   644: aload 4
    //   646: astore_3
    //   647: goto +75 -> 722
    //   650: astore 6
    //   652: aconst_null
    //   653: astore_0
    //   654: aload_0
    //   655: astore_3
    //   656: aload_0
    //   657: astore 4
    //   659: aload_3
    //   660: astore 5
    //   662: ldc 191
    //   664: iconst_1
    //   665: ldc 207
    //   667: aload 6
    //   669: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   672: aload_0
    //   673: astore 4
    //   675: aload_3
    //   676: astore 5
    //   678: aload 8
    //   680: invokevirtual 213	java/io/File:delete	()Z
    //   683: pop
    //   684: aload_0
    //   685: ifnull +10 -> 695
    //   688: aload_0
    //   689: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   692: goto +3 -> 695
    //   695: aload 7
    //   697: astore_0
    //   698: aload_3
    //   699: ifnull +52 -> 751
    //   702: aload_3
    //   703: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   706: aload 7
    //   708: astore_0
    //   709: goto +42 -> 751
    //   712: aload 7
    //   714: astore_0
    //   715: goto +36 -> 751
    //   718: astore_0
    //   719: aload 5
    //   721: astore_3
    //   722: aload 4
    //   724: ifnull +11 -> 735
    //   727: aload 4
    //   729: invokevirtual 204	java/io/ObjectInputStream:close	()V
    //   732: goto +3 -> 735
    //   735: aload_3
    //   736: ifnull +7 -> 743
    //   739: aload_3
    //   740: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   743: aload_0
    //   744: athrow
    //   745: aload_0
    //   746: aload_1
    //   747: invokestatic 215	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:b	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig;
    //   750: astore_0
    //   751: aload_0
    //   752: ifnull +27 -> 779
    //   755: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   758: astore_3
    //   759: aload_3
    //   760: monitorenter
    //   761: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   764: aload_1
    //   765: aload_0
    //   766: invokevirtual 219	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   769: pop
    //   770: aload_3
    //   771: monitorexit
    //   772: aload_0
    //   773: areturn
    //   774: astore_0
    //   775: aload_3
    //   776: monitorexit
    //   777: aload_0
    //   778: athrow
    //   779: aload_0
    //   780: areturn
    //   781: astore_0
    //   782: aload_3
    //   783: monitorexit
    //   784: aload_0
    //   785: athrow
    //   786: astore_0
    //   787: goto -176 -> 611
    //   790: astore_0
    //   791: goto -176 -> 615
    //   794: astore 4
    //   796: goto -112 -> 684
    //   799: astore_0
    //   800: goto -105 -> 695
    //   803: astore_0
    //   804: goto -92 -> 712
    //   807: astore_1
    //   808: goto -73 -> 735
    //   811: astore_1
    //   812: goto -69 -> 743
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	paramContext	Context
    //   0	815	1	paramString	String
    //   82	5	2	bool	boolean
    //   45	683	4	localObject2	Object
    //   794	1	4	localException1	Exception
    //   138	582	5	localObject3	Object
    //   110	506	6	localThirdAppConfig	ThirdAppConfigHelper.ThirdAppConfig
    //   621	1	6	localException2	Exception
    //   633	1	6	localException3	Exception
    //   650	18	6	localException4	Exception
    //   84	629	7	localObject4	Object
    //   75	604	8	localFile	java.io.File
    //   389	211	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   140	152	621	java/lang/Exception
    //   158	167	621	java/lang/Exception
    //   173	181	621	java/lang/Exception
    //   187	199	621	java/lang/Exception
    //   205	217	621	java/lang/Exception
    //   223	232	621	java/lang/Exception
    //   238	247	621	java/lang/Exception
    //   253	262	621	java/lang/Exception
    //   268	277	621	java/lang/Exception
    //   283	292	621	java/lang/Exception
    //   298	317	621	java/lang/Exception
    //   323	329	621	java/lang/Exception
    //   335	343	621	java/lang/Exception
    //   349	364	621	java/lang/Exception
    //   370	376	621	java/lang/Exception
    //   382	391	621	java/lang/Exception
    //   397	405	621	java/lang/Exception
    //   411	422	621	java/lang/Exception
    //   428	436	621	java/lang/Exception
    //   442	453	621	java/lang/Exception
    //   459	470	621	java/lang/Exception
    //   476	482	621	java/lang/Exception
    //   488	497	621	java/lang/Exception
    //   503	511	621	java/lang/Exception
    //   517	528	621	java/lang/Exception
    //   534	542	621	java/lang/Exception
    //   548	559	621	java/lang/Exception
    //   565	573	621	java/lang/Exception
    //   579	590	621	java/lang/Exception
    //   596	607	621	java/lang/Exception
    //   125	134	626	finally
    //   125	134	633	java/lang/Exception
    //   112	125	640	finally
    //   112	125	650	java/lang/Exception
    //   140	152	718	finally
    //   158	167	718	finally
    //   173	181	718	finally
    //   187	199	718	finally
    //   205	217	718	finally
    //   223	232	718	finally
    //   238	247	718	finally
    //   253	262	718	finally
    //   268	277	718	finally
    //   283	292	718	finally
    //   298	317	718	finally
    //   323	329	718	finally
    //   335	343	718	finally
    //   349	364	718	finally
    //   370	376	718	finally
    //   382	391	718	finally
    //   397	405	718	finally
    //   411	422	718	finally
    //   428	436	718	finally
    //   442	453	718	finally
    //   459	470	718	finally
    //   476	482	718	finally
    //   488	497	718	finally
    //   503	511	718	finally
    //   517	528	718	finally
    //   534	542	718	finally
    //   548	559	718	finally
    //   565	573	718	finally
    //   579	590	718	finally
    //   596	607	718	finally
    //   662	672	718	finally
    //   678	684	718	finally
    //   761	772	774	finally
    //   775	777	774	finally
    //   6	29	781	finally
    //   31	33	781	finally
    //   782	784	781	finally
    //   607	611	786	java/lang/Exception
    //   611	615	790	java/lang/Exception
    //   678	684	794	java/lang/Exception
    //   688	692	799	java/lang/Exception
    //   702	706	803	java/lang/Exception
    //   727	732	807	java/lang/Exception
    //   739	743	811	java/lang/Exception
  }
  
  public static final void a(Context paramContext, ThirdAppConfigHelper.ThirdAppConfig paramThirdAppConfig)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveNewKey, ");
      localStringBuilder.append(paramThirdAppConfig.i);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramThirdAppConfig.l);
      QLog.d("OpenApi.Config", 2, localStringBuilder.toString());
    }
    if (paramThirdAppConfig.j)
    {
      paramThirdAppConfig.i = paramThirdAppConfig.l;
      paramThirdAppConfig.h = paramThirdAppConfig.k;
      paramThirdAppConfig.j = false;
      b(paramContext, paramThirdAppConfig);
    }
  }
  
  public static final boolean a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramContext[0].toByteArray());
      paramContext = HexUtil.bytes2HexStr(localMessageDigest.digest()).toUpperCase();
      boolean bool = paramString2.equals(paramContext);
      if ((!bool) && (QLog.isColorLevel()))
      {
        paramString2 = new StringBuilder();
        paramString2.append("verifysig fail, pkg = ");
        paramString2.append(paramString1);
        paramString2.append(", sign = ");
        paramString2.append(paramContext);
        QLog.d("OpenApi.Config", 2, paramString2.toString());
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OpenApi.Config", 2, "verifysig", paramContext);
      }
    }
    return false;
  }
  
  private static ThirdAppConfigHelper.ThirdAppConfig b(Context paramContext, String paramString)
  {
    int j = a.length;
    int i = 0;
    while (i < j)
    {
      if (a[i].equals(paramString))
      {
        ThirdAppConfigHelper.ThirdAppConfig localThirdAppConfig = new ThirdAppConfigHelper.ThirdAppConfig();
        localThirdAppConfig.a = paramString;
        localThirdAppConfig.b = true;
        localThirdAppConfig.c = b[i];
        localThirdAppConfig.d = c[i];
        localThirdAppConfig.i = NetConnInfoCenter.getServerTimeMillis();
        localThirdAppConfig.h = new Random().nextLong();
        localThirdAppConfig.e = 1073741823;
        localThirdAppConfig.f = 2147483647;
        localThirdAppConfig.g = 7;
        b(paramContext, localThirdAppConfig);
        return localThirdAppConfig;
      }
      i += 1;
    }
    return null;
  }
  
  /* Error */
  public static final void b(Context paramContext, ThirdAppConfigHelper.ThirdAppConfig paramThirdAppConfig)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   6: astore_2
    //   7: aload_2
    //   8: monitorenter
    //   9: getstatic 20	com/tencent/mobileqq/openapi/ThirdAppConfigHelper:d	Ljava/util/HashMap;
    //   12: aload_1
    //   13: getfield 115	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:a	Ljava/lang/String;
    //   16: aload_1
    //   17: invokevirtual 219	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   20: pop
    //   21: aload_2
    //   22: monitorexit
    //   23: aconst_null
    //   24: astore 4
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_3
    //   29: astore_2
    //   30: new 283	java/io/ByteArrayOutputStream
    //   33: dup
    //   34: invokespecial 284	java/io/ByteArrayOutputStream:<init>	()V
    //   37: astore 5
    //   39: aload_3
    //   40: astore_2
    //   41: new 286	java/io/ObjectOutputStream
    //   44: dup
    //   45: aload 5
    //   47: invokespecial 289	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   50: astore_3
    //   51: aload_3
    //   52: aload_1
    //   53: getfield 115	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:a	Ljava/lang/String;
    //   56: invokevirtual 293	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   59: aload_3
    //   60: aload_1
    //   61: getfield 121	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:b	Z
    //   64: invokevirtual 297	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   67: aload_1
    //   68: getfield 121	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:b	Z
    //   71: ifeq +59 -> 130
    //   74: aload_3
    //   75: aload_1
    //   76: getfield 123	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:c	Ljava/lang/String;
    //   79: invokevirtual 293	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   82: aload_3
    //   83: aload_1
    //   84: getfield 125	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:d	Ljava/lang/String;
    //   87: invokevirtual 293	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   90: aload_3
    //   91: aload_1
    //   92: getfield 133	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:e	I
    //   95: invokevirtual 301	java/io/ObjectOutputStream:writeInt	(I)V
    //   98: aload_3
    //   99: aload_1
    //   100: getfield 136	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:f	I
    //   103: invokevirtual 301	java/io/ObjectOutputStream:writeInt	(I)V
    //   106: aload_3
    //   107: aload_1
    //   108: getfield 139	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:g	I
    //   111: invokevirtual 301	java/io/ObjectOutputStream:writeInt	(I)V
    //   114: aload_3
    //   115: aload_1
    //   116: getfield 146	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:i	J
    //   119: invokevirtual 305	java/io/ObjectOutputStream:writeLong	(J)V
    //   122: aload_3
    //   123: aload_1
    //   124: getfield 149	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:h	J
    //   127: invokevirtual 305	java/io/ObjectOutputStream:writeLong	(J)V
    //   130: aload_3
    //   131: invokevirtual 308	java/io/ObjectOutputStream:flush	()V
    //   134: aload_0
    //   135: invokevirtual 65	android/content/Context:getFilesDir	()Ljava/io/File;
    //   138: astore_0
    //   139: new 67	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 68	java/lang/StringBuilder:<init>	()V
    //   146: astore_2
    //   147: aload_2
    //   148: aload_1
    //   149: getfield 115	com/tencent/mobileqq/openapi/ThirdAppConfigHelper$ThirdAppConfig:a	Ljava/lang/String;
    //   152: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc 74
    //   159: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: new 76	java/io/File
    //   166: dup
    //   167: aload_0
    //   168: aload_2
    //   169: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokespecial 83	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   175: invokevirtual 311	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   178: aload 5
    //   180: invokevirtual 312	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   183: iconst_0
    //   184: invokestatic 316	com/tencent/mobileqq/utils/FileUtils:pushData2File	(Ljava/lang/String;[BZ)Z
    //   187: pop
    //   188: aload_3
    //   189: invokevirtual 317	java/io/ObjectOutputStream:close	()V
    //   192: goto +51 -> 243
    //   195: astore_0
    //   196: goto +51 -> 247
    //   199: astore_1
    //   200: aload_3
    //   201: astore_0
    //   202: goto +13 -> 215
    //   205: astore_0
    //   206: aload_2
    //   207: astore_3
    //   208: goto +39 -> 247
    //   211: astore_1
    //   212: aload 4
    //   214: astore_0
    //   215: aload_0
    //   216: astore_2
    //   217: invokestatic 182	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +15 -> 235
    //   223: aload_0
    //   224: astore_2
    //   225: ldc 191
    //   227: iconst_2
    //   228: ldc_w 319
    //   231: aload_1
    //   232: invokestatic 210	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   235: aload_0
    //   236: ifnull +7 -> 243
    //   239: aload_0
    //   240: invokevirtual 317	java/io/ObjectOutputStream:close	()V
    //   243: ldc 2
    //   245: monitorexit
    //   246: return
    //   247: aload_3
    //   248: ifnull +7 -> 255
    //   251: aload_3
    //   252: invokevirtual 317	java/io/ObjectOutputStream:close	()V
    //   255: aload_0
    //   256: athrow
    //   257: astore_0
    //   258: aload_2
    //   259: monitorexit
    //   260: aload_0
    //   261: athrow
    //   262: astore_0
    //   263: ldc 2
    //   265: monitorexit
    //   266: aload_0
    //   267: athrow
    //   268: astore_0
    //   269: goto -26 -> 243
    //   272: astore_1
    //   273: goto -18 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramContext	Context
    //   0	276	1	paramThirdAppConfig	ThirdAppConfigHelper.ThirdAppConfig
    //   6	253	2	localObject1	Object
    //   27	225	3	localObject2	Object
    //   24	189	4	localObject3	Object
    //   37	142	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	130	195	finally
    //   130	188	195	finally
    //   51	130	199	java/lang/Exception
    //   130	188	199	java/lang/Exception
    //   30	39	205	finally
    //   41	51	205	finally
    //   217	223	205	finally
    //   225	235	205	finally
    //   30	39	211	java/lang/Exception
    //   41	51	211	java/lang/Exception
    //   9	23	257	finally
    //   258	260	257	finally
    //   3	9	262	finally
    //   188	192	262	finally
    //   239	243	262	finally
    //   251	255	262	finally
    //   255	257	262	finally
    //   260	262	262	finally
    //   188	192	268	java/lang/Exception
    //   239	243	268	java/lang/Exception
    //   251	255	272	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.openapi.ThirdAppConfigHelper
 * JD-Core Version:    0.7.0.1
 */