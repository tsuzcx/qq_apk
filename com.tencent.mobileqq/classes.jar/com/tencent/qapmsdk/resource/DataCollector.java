package com.tencent.qapmsdk.resource;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.resource.NetworkCollector;
import com.tencent.qapmsdk.common.resource.StatCollector;
import com.tencent.qapmsdk.resource.meta.NetFlow;
import com.tencent.qapmsdk.resource.meta.StatInfo;

class DataCollector
{
  private static final String TAG = "QAPM_resource_DataCollector";
  private NetworkCollector networkCollector = new NetworkCollector();
  private StatCollector statCollector = new StatCollector();
  private int uid = 0;
  
  DataCollector()
  {
    initUid();
  }
  
  private void initUid()
  {
    try
    {
      if ((this.uid == 0) && (BaseInfo.app != null)) {
        this.uid = BaseInfo.app.getPackageManager().getApplicationInfo(BaseInfo.app.getPackageName(), 0).uid;
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
    }
  }
  
  /* Error */
  java.util.ArrayList<java.lang.Double> collectAppCpuByTop(int paramInt)
  {
    // Byte code:
    //   0: dconst_0
    //   1: dstore 8
    //   3: dconst_0
    //   4: dstore 10
    //   6: dload 8
    //   8: dstore_2
    //   9: dload 8
    //   11: dstore 4
    //   13: dload 8
    //   15: dstore 6
    //   17: invokestatic 85	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   20: ldc 87
    //   22: iconst_1
    //   23: anewarray 4	java/lang/Object
    //   26: dup
    //   27: iconst_0
    //   28: iload_1
    //   29: invokestatic 93	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: aastore
    //   33: invokestatic 99	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual 103	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   39: astore 21
    //   41: iconst_1
    //   42: istore 20
    //   44: dload 8
    //   46: dstore_2
    //   47: dload 8
    //   49: dstore 4
    //   51: dload 8
    //   53: dstore 6
    //   55: invokestatic 109	com/tencent/qapmsdk/common/util/AndroidVersion:isO	()Z
    //   58: ifeq +72 -> 130
    //   61: dload 8
    //   63: dstore_2
    //   64: dload 8
    //   66: dstore 4
    //   68: dload 8
    //   70: dstore 6
    //   72: aload 21
    //   74: ldc2_w 110
    //   77: getstatic 117	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   80: invokevirtual 123	java/lang/Process:waitFor	(JLjava/util/concurrent/TimeUnit;)Z
    //   83: istore 20
    //   85: iload 20
    //   87: ifne +109 -> 196
    //   90: dload 8
    //   92: dstore_2
    //   93: dload 8
    //   95: dstore 4
    //   97: dload 8
    //   99: dstore 6
    //   101: new 125	java/util/ArrayList
    //   104: dup
    //   105: iconst_2
    //   106: anewarray 127	java/lang/Double
    //   109: dup
    //   110: iconst_0
    //   111: dconst_0
    //   112: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   115: aastore
    //   116: dup
    //   117: iconst_1
    //   118: dconst_0
    //   119: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   122: aastore
    //   123: invokestatic 136	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   126: invokespecial 139	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   129: areturn
    //   130: dload 8
    //   132: dstore_2
    //   133: dload 8
    //   135: dstore 4
    //   137: dload 8
    //   139: dstore 6
    //   141: aload 21
    //   143: invokevirtual 142	java/lang/Process:waitFor	()I
    //   146: pop
    //   147: goto -62 -> 85
    //   150: astore 21
    //   152: getstatic 67	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   155: ldc 8
    //   157: aload 21
    //   159: invokevirtual 71	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   162: dload 10
    //   164: dstore 4
    //   166: new 125	java/util/ArrayList
    //   169: dup
    //   170: iconst_2
    //   171: anewarray 127	java/lang/Double
    //   174: dup
    //   175: iconst_0
    //   176: dload_2
    //   177: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: dload 4
    //   185: invokestatic 130	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   188: aastore
    //   189: invokestatic 136	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   192: invokespecial 139	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   195: areturn
    //   196: dload 8
    //   198: dstore_2
    //   199: dload 8
    //   201: dstore 4
    //   203: dload 8
    //   205: dstore 6
    //   207: aload 21
    //   209: invokevirtual 146	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   212: astore 22
    //   214: dload 8
    //   216: dstore_2
    //   217: dload 8
    //   219: dstore 4
    //   221: dload 8
    //   223: dstore 6
    //   225: aload 22
    //   227: sipush 1024
    //   230: invokestatic 152	com/tencent/qapmsdk/common/util/FileUtil:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   233: astore 21
    //   235: dload 8
    //   237: dstore_2
    //   238: dload 8
    //   240: dstore 4
    //   242: dload 8
    //   244: dstore 6
    //   246: aload 22
    //   248: invokevirtual 157	java/io/InputStream:close	()V
    //   251: dload 8
    //   253: dstore_2
    //   254: dload 8
    //   256: dstore 4
    //   258: dload 8
    //   260: dstore 6
    //   262: ldc 159
    //   264: invokestatic 165	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   267: astore 30
    //   269: dload 8
    //   271: dstore_2
    //   272: dload 8
    //   274: dstore 4
    //   276: dload 8
    //   278: dstore 6
    //   280: getstatic 170	com/tencent/qapmsdk/resource/ResourceCollectorConstant:PID_REG	Ljava/lang/String;
    //   283: invokestatic 165	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   286: astore 31
    //   288: dload 8
    //   290: dstore_2
    //   291: dload 8
    //   293: dstore 4
    //   295: dload 8
    //   297: dstore 6
    //   299: aload 21
    //   301: ldc 172
    //   303: invokevirtual 176	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   306: astore 32
    //   308: dload 8
    //   310: dstore_2
    //   311: dload 8
    //   313: dstore 4
    //   315: dload 8
    //   317: dstore 6
    //   319: aload 32
    //   321: arraylength
    //   322: istore 18
    //   324: ldc 178
    //   326: astore 23
    //   328: ldc 178
    //   330: astore 28
    //   332: ldc 178
    //   334: astore 26
    //   336: ldc 178
    //   338: astore 24
    //   340: ldc 178
    //   342: astore 21
    //   344: iconst_0
    //   345: istore_1
    //   346: iload_1
    //   347: iload 18
    //   349: if_icmpge +284 -> 633
    //   352: dload 8
    //   354: dstore_2
    //   355: dload 8
    //   357: dstore 4
    //   359: dload 8
    //   361: dstore 6
    //   363: aload 32
    //   365: iload_1
    //   366: aaload
    //   367: invokevirtual 181	java/lang/String:trim	()Ljava/lang/String;
    //   370: astore 33
    //   372: dload 8
    //   374: dstore_2
    //   375: dload 8
    //   377: dstore 4
    //   379: dload 8
    //   381: dstore 6
    //   383: aload 33
    //   385: ldc 183
    //   387: invokevirtual 187	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   390: istore 19
    //   392: aload 26
    //   394: astore 27
    //   396: aload 24
    //   398: astore 25
    //   400: aload 21
    //   402: astore 22
    //   404: iload 19
    //   406: iconst_m1
    //   407: if_icmpeq +176 -> 583
    //   410: dload 8
    //   412: dstore_2
    //   413: dload 8
    //   415: dstore 4
    //   417: dload 8
    //   419: dstore 6
    //   421: aload 33
    //   423: iconst_0
    //   424: iload 19
    //   426: invokevirtual 191	java/lang/String:substring	(II)Ljava/lang/String;
    //   429: astore 29
    //   431: dload 8
    //   433: dstore_2
    //   434: dload 8
    //   436: dstore 4
    //   438: dload 8
    //   440: dstore 6
    //   442: aload 30
    //   444: aload 33
    //   446: invokevirtual 195	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   449: astore 34
    //   451: dload 8
    //   453: dstore_2
    //   454: aload 29
    //   456: astore 28
    //   458: aload 26
    //   460: astore 27
    //   462: aload 24
    //   464: astore 25
    //   466: aload 21
    //   468: astore 22
    //   470: dload 8
    //   472: dstore 4
    //   474: dload 8
    //   476: dstore 6
    //   478: aload 34
    //   480: invokevirtual 200	java/util/regex/Matcher:find	()Z
    //   483: ifeq +100 -> 583
    //   486: dload 8
    //   488: dstore_2
    //   489: aload 29
    //   491: astore 28
    //   493: aload 26
    //   495: astore 27
    //   497: aload 24
    //   499: astore 25
    //   501: aload 21
    //   503: astore 22
    //   505: dload 8
    //   507: dstore 4
    //   509: dload 8
    //   511: dstore 6
    //   513: aload 34
    //   515: invokevirtual 203	java/util/regex/Matcher:groupCount	()I
    //   518: iconst_3
    //   519: if_icmpne +64 -> 583
    //   522: dload 8
    //   524: dstore_2
    //   525: dload 8
    //   527: dstore 4
    //   529: dload 8
    //   531: dstore 6
    //   533: aload 34
    //   535: iconst_1
    //   536: invokevirtual 207	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   539: astore 22
    //   541: dload 8
    //   543: dstore_2
    //   544: dload 8
    //   546: dstore 4
    //   548: dload 8
    //   550: dstore 6
    //   552: aload 34
    //   554: iconst_2
    //   555: invokevirtual 207	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   558: astore 25
    //   560: dload 8
    //   562: dstore_2
    //   563: dload 8
    //   565: dstore 4
    //   567: dload 8
    //   569: dstore 6
    //   571: aload 34
    //   573: iconst_3
    //   574: invokevirtual 207	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   577: astore 27
    //   579: aload 29
    //   581: astore 28
    //   583: dload 8
    //   585: dstore_2
    //   586: dload 8
    //   588: dstore 4
    //   590: dload 8
    //   592: dstore 6
    //   594: aload 31
    //   596: aload 33
    //   598: invokevirtual 195	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   601: invokevirtual 200	java/util/regex/Matcher:find	()Z
    //   604: ifeq +276 -> 880
    //   607: dload 8
    //   609: dstore_2
    //   610: dload 8
    //   612: dstore 4
    //   614: dload 8
    //   616: dstore 6
    //   618: aload 33
    //   620: ldc 209
    //   622: invokevirtual 176	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   625: bipush 8
    //   627: aaload
    //   628: astore 23
    //   630: goto +250 -> 880
    //   633: dload 8
    //   635: dstore_2
    //   636: dload 8
    //   638: dstore 4
    //   640: dload 8
    //   642: dstore 6
    //   644: aload 28
    //   646: invokestatic 212	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   649: invokevirtual 215	java/lang/Integer:intValue	()I
    //   652: ifeq +220 -> 872
    //   655: dload 8
    //   657: dstore_2
    //   658: dload 8
    //   660: dstore 4
    //   662: dload 8
    //   664: dstore 6
    //   666: aload 21
    //   668: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   671: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   674: dstore 12
    //   676: dload 8
    //   678: dstore_2
    //   679: dload 8
    //   681: dstore 4
    //   683: dload 8
    //   685: dstore 6
    //   687: aload 24
    //   689: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   692: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   695: dstore 14
    //   697: dload 8
    //   699: dstore_2
    //   700: dload 8
    //   702: dstore 4
    //   704: dload 8
    //   706: dstore 6
    //   708: aload 26
    //   710: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   713: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   716: dstore 16
    //   718: dload 8
    //   720: dstore_2
    //   721: dload 8
    //   723: dstore 4
    //   725: dload 8
    //   727: dstore 6
    //   729: aload 28
    //   731: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   734: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   737: dstore 8
    //   739: dload 8
    //   741: dstore_2
    //   742: dload 8
    //   744: dstore 4
    //   746: dload 8
    //   748: dstore 6
    //   750: dload 16
    //   752: dload 12
    //   754: dload 14
    //   756: dadd
    //   757: dadd
    //   758: dload 8
    //   760: ddiv
    //   761: dstore 8
    //   763: dload 8
    //   765: dstore_2
    //   766: dload 8
    //   768: dstore 4
    //   770: dload 8
    //   772: dstore 6
    //   774: aload 23
    //   776: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   779: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   782: dstore 12
    //   784: dload 8
    //   786: dstore_2
    //   787: dload 8
    //   789: dstore 4
    //   791: dload 8
    //   793: dstore 6
    //   795: aload 28
    //   797: invokestatic 218	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   800: invokevirtual 222	java/lang/Double:doubleValue	()D
    //   803: dstore 14
    //   805: dload 12
    //   807: dload 14
    //   809: ddiv
    //   810: dstore_2
    //   811: dload 8
    //   813: dstore 4
    //   815: dload_2
    //   816: dstore 6
    //   818: dload 4
    //   820: dstore_2
    //   821: dload 6
    //   823: dstore 4
    //   825: goto -659 -> 166
    //   828: astore 21
    //   830: dload 4
    //   832: dstore_2
    //   833: getstatic 67	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   836: ldc 8
    //   838: aload 21
    //   840: invokevirtual 71	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   843: dload 10
    //   845: dstore 4
    //   847: goto -681 -> 166
    //   850: astore 21
    //   852: dload 6
    //   854: dstore_2
    //   855: getstatic 67	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   858: ldc 8
    //   860: aload 21
    //   862: invokevirtual 71	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   865: dload 10
    //   867: dstore 4
    //   869: goto -703 -> 166
    //   872: dconst_0
    //   873: dstore_2
    //   874: dconst_0
    //   875: dstore 4
    //   877: goto -62 -> 815
    //   880: iload_1
    //   881: iconst_1
    //   882: iadd
    //   883: istore_1
    //   884: aload 27
    //   886: astore 26
    //   888: aload 25
    //   890: astore 24
    //   892: aload 22
    //   894: astore 21
    //   896: goto -550 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	899	0	this	DataCollector
    //   0	899	1	paramInt	int
    //   8	866	2	d1	double
    //   11	865	4	d2	double
    //   15	838	6	d3	double
    //   1	811	8	d4	double
    //   4	862	10	d5	double
    //   674	132	12	d6	double
    //   695	113	14	d7	double
    //   716	35	16	d8	double
    //   322	28	18	i	int
    //   390	35	19	j	int
    //   42	44	20	bool	boolean
    //   39	103	21	localProcess	java.lang.Process
    //   150	58	21	localInterruptedException	java.lang.InterruptedException
    //   233	434	21	str1	String
    //   828	11	21	localIOException	java.io.IOException
    //   850	11	21	localNumberFormatException	java.lang.NumberFormatException
    //   894	1	21	localObject1	Object
    //   212	681	22	localObject2	Object
    //   326	449	23	str2	String
    //   338	553	24	localObject3	Object
    //   398	491	25	localObject4	Object
    //   334	553	26	localObject5	Object
    //   394	491	27	localObject6	Object
    //   330	466	28	localObject7	Object
    //   429	151	29	str3	String
    //   267	176	30	localPattern1	java.util.regex.Pattern
    //   286	309	31	localPattern2	java.util.regex.Pattern
    //   306	58	32	arrayOfString	String[]
    //   370	249	33	str4	String
    //   449	123	34	localMatcher	java.util.regex.Matcher
    // Exception table:
    //   from	to	target	type
    //   17	41	150	java/lang/InterruptedException
    //   55	61	150	java/lang/InterruptedException
    //   72	85	150	java/lang/InterruptedException
    //   101	130	150	java/lang/InterruptedException
    //   141	147	150	java/lang/InterruptedException
    //   207	214	150	java/lang/InterruptedException
    //   225	235	150	java/lang/InterruptedException
    //   246	251	150	java/lang/InterruptedException
    //   262	269	150	java/lang/InterruptedException
    //   280	288	150	java/lang/InterruptedException
    //   299	308	150	java/lang/InterruptedException
    //   319	324	150	java/lang/InterruptedException
    //   363	372	150	java/lang/InterruptedException
    //   383	392	150	java/lang/InterruptedException
    //   421	431	150	java/lang/InterruptedException
    //   442	451	150	java/lang/InterruptedException
    //   478	486	150	java/lang/InterruptedException
    //   513	522	150	java/lang/InterruptedException
    //   533	541	150	java/lang/InterruptedException
    //   552	560	150	java/lang/InterruptedException
    //   571	579	150	java/lang/InterruptedException
    //   594	607	150	java/lang/InterruptedException
    //   618	630	150	java/lang/InterruptedException
    //   644	655	150	java/lang/InterruptedException
    //   666	676	150	java/lang/InterruptedException
    //   687	697	150	java/lang/InterruptedException
    //   708	718	150	java/lang/InterruptedException
    //   729	739	150	java/lang/InterruptedException
    //   750	763	150	java/lang/InterruptedException
    //   774	784	150	java/lang/InterruptedException
    //   795	805	150	java/lang/InterruptedException
    //   17	41	828	java/io/IOException
    //   55	61	828	java/io/IOException
    //   72	85	828	java/io/IOException
    //   101	130	828	java/io/IOException
    //   141	147	828	java/io/IOException
    //   207	214	828	java/io/IOException
    //   225	235	828	java/io/IOException
    //   246	251	828	java/io/IOException
    //   262	269	828	java/io/IOException
    //   280	288	828	java/io/IOException
    //   299	308	828	java/io/IOException
    //   319	324	828	java/io/IOException
    //   363	372	828	java/io/IOException
    //   383	392	828	java/io/IOException
    //   421	431	828	java/io/IOException
    //   442	451	828	java/io/IOException
    //   478	486	828	java/io/IOException
    //   513	522	828	java/io/IOException
    //   533	541	828	java/io/IOException
    //   552	560	828	java/io/IOException
    //   571	579	828	java/io/IOException
    //   594	607	828	java/io/IOException
    //   618	630	828	java/io/IOException
    //   644	655	828	java/io/IOException
    //   666	676	828	java/io/IOException
    //   687	697	828	java/io/IOException
    //   708	718	828	java/io/IOException
    //   729	739	828	java/io/IOException
    //   750	763	828	java/io/IOException
    //   774	784	828	java/io/IOException
    //   795	805	828	java/io/IOException
    //   17	41	850	java/lang/NumberFormatException
    //   55	61	850	java/lang/NumberFormatException
    //   72	85	850	java/lang/NumberFormatException
    //   101	130	850	java/lang/NumberFormatException
    //   141	147	850	java/lang/NumberFormatException
    //   207	214	850	java/lang/NumberFormatException
    //   225	235	850	java/lang/NumberFormatException
    //   246	251	850	java/lang/NumberFormatException
    //   262	269	850	java/lang/NumberFormatException
    //   280	288	850	java/lang/NumberFormatException
    //   299	308	850	java/lang/NumberFormatException
    //   319	324	850	java/lang/NumberFormatException
    //   363	372	850	java/lang/NumberFormatException
    //   383	392	850	java/lang/NumberFormatException
    //   421	431	850	java/lang/NumberFormatException
    //   442	451	850	java/lang/NumberFormatException
    //   478	486	850	java/lang/NumberFormatException
    //   513	522	850	java/lang/NumberFormatException
    //   533	541	850	java/lang/NumberFormatException
    //   552	560	850	java/lang/NumberFormatException
    //   571	579	850	java/lang/NumberFormatException
    //   594	607	850	java/lang/NumberFormatException
    //   618	630	850	java/lang/NumberFormatException
    //   644	655	850	java/lang/NumberFormatException
    //   666	676	850	java/lang/NumberFormatException
    //   687	697	850	java/lang/NumberFormatException
    //   708	718	850	java/lang/NumberFormatException
    //   729	739	850	java/lang/NumberFormatException
    //   750	763	850	java/lang/NumberFormatException
    //   774	784	850	java/lang/NumberFormatException
    //   795	805	850	java/lang/NumberFormatException
  }
  
  @NonNull
  StatInfo collectStatInfo()
  {
    StatInfo localStatInfo = new StatInfo();
    try
    {
      long[] arrayOfLong = this.statCollector.getStatInfo();
      if (arrayOfLong != null)
      {
        localStatInfo.cpuSysJiffies = arrayOfLong[0];
        localStatInfo.cpuSysUsedJiffies = arrayOfLong[1];
        localStatInfo.cpuJiffies = arrayOfLong[2];
        localStatInfo.threadNum = arrayOfLong[3];
        localStatInfo.memory = arrayOfLong[4];
      }
      return localStatInfo;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
    }
    return localStatInfo;
  }
  
  long collectorCpuJiffices(long paramLong1, long paramLong2)
  {
    paramLong2 = paramLong1 + paramLong2;
    paramLong1 = paramLong2;
    if (paramLong2 < 0L) {
      paramLong1 = 9223372036854775807L;
    }
    return paramLong1;
  }
  
  @NonNull
  NetFlow collectorNetFollow(boolean paramBoolean)
  {
    NetFlow localNetFlow = new NetFlow();
    initUid();
    if (this.uid == 0) {}
    do
    {
      return localNetFlow;
      try
      {
        long[] arrayOfLong = this.networkCollector.getTotalBytes();
        if (arrayOfLong != null)
        {
          localNetFlow.rxBytes = arrayOfLong[0];
          localNetFlow.rxPackets = arrayOfLong[1];
          localNetFlow.txBytes = arrayOfLong[2];
          localNetFlow.txPackets = arrayOfLong[3];
          return localNetFlow;
        }
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_resource_DataCollector", localException);
        return localNetFlow;
      }
    } while (!paramBoolean);
    localNetFlow.rxBytes = TrafficStats.getUidRxBytes(this.uid);
    localNetFlow.rxPackets = TrafficStats.getUidRxPackets(this.uid);
    localNetFlow.txBytes = TrafficStats.getUidTxBytes(this.uid);
    localNetFlow.txPackets = TrafficStats.getUidTxPackets(this.uid);
    return localNetFlow;
  }
  
  long collectorSysCpuJiffices(String[] paramArrayOfString)
  {
    long l2 = Long.parseLong(paramArrayOfString[2]) + Long.parseLong(paramArrayOfString[3]) + Long.parseLong(paramArrayOfString[4]) + Long.parseLong(paramArrayOfString[5]) + Long.parseLong(paramArrayOfString[6]) + Long.parseLong(paramArrayOfString[7]) + Long.parseLong(paramArrayOfString[8]);
    long l1 = l2;
    if (l2 < 0L) {
      l1 = 9223372036854775807L;
    }
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.resource.DataCollector
 * JD-Core Version:    0.7.0.1
 */