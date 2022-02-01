package com.tencent.smtt.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class n
{
  private static n c;
  private Context a = null;
  private File b = null;
  private String d = "https://log.tbs.qq.com/ajax?c=pu&v=2&k=";
  private String e = "https://log.tbs.qq.com/ajax?c=pu&tk=";
  private String f = "https://log.tbs.qq.com/ajax?c=dl&k=";
  private String g = "https://cfg.imtt.qq.com/tbs?v=2&mk=";
  private String h = "https://log.tbs.qq.com/ajax?c=ul&v=2&k=";
  private String i = "https://mqqad.html5.qq.com/adjs";
  private String j = "https://log.tbs.qq.com/ajax?c=ucfu&k=";
  private String k = "";
  private String l = "";
  private String m = "";
  private String n = "https://tbsrecovery.imtt.qq.com/getconfig";
  
  @TargetApi(11)
  private n(Context paramContext)
  {
    TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
    this.a = paramContext.getApplicationContext();
    k();
  }
  
  public static n a()
  {
    try
    {
      n localn = c;
      return localn;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static n a(Context paramContext)
  {
    try
    {
      if (c == null) {
        c = new n(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  private void k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 108	com/tencent/smtt/utils/n:l	()Ljava/io/File;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnonnull +13 -> 21
    //   11: ldc 78
    //   13: ldc 110
    //   15: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: new 114	java/io/BufferedInputStream
    //   24: dup
    //   25: new 116	java/io/FileInputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 119	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 122	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   36: astore_2
    //   37: aload_2
    //   38: astore_1
    //   39: new 124	java/util/Properties
    //   42: dup
    //   43: invokespecial 125	java/util/Properties:<init>	()V
    //   46: astore_3
    //   47: aload_2
    //   48: astore_1
    //   49: aload_3
    //   50: aload_2
    //   51: invokevirtual 128	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_2
    //   55: astore_1
    //   56: aload_3
    //   57: ldc 130
    //   59: ldc 66
    //   61: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   64: astore 4
    //   66: aload_2
    //   67: astore_1
    //   68: ldc 66
    //   70: aload 4
    //   72: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   75: ifne +11 -> 86
    //   78: aload_2
    //   79: astore_1
    //   80: aload_0
    //   81: aload 4
    //   83: putfield 40	com/tencent/smtt/utils/n:d	Ljava/lang/String;
    //   86: aload_2
    //   87: astore_1
    //   88: aload_3
    //   89: ldc 142
    //   91: ldc 66
    //   93: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: astore 4
    //   98: aload_2
    //   99: astore_1
    //   100: ldc 66
    //   102: aload 4
    //   104: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   107: ifne +11 -> 118
    //   110: aload_2
    //   111: astore_1
    //   112: aload_0
    //   113: aload 4
    //   115: putfield 48	com/tencent/smtt/utils/n:f	Ljava/lang/String;
    //   118: aload_2
    //   119: astore_1
    //   120: aload_3
    //   121: ldc 144
    //   123: ldc 66
    //   125: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 4
    //   130: aload_2
    //   131: astore_1
    //   132: new 146	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   139: astore 5
    //   141: aload_2
    //   142: astore_1
    //   143: aload 5
    //   145: ldc 149
    //   147: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_2
    //   152: astore_1
    //   153: aload 5
    //   155: aload 4
    //   157: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_2
    //   162: astore_1
    //   163: ldc 78
    //   165: aload 5
    //   167: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload_2
    //   174: astore_1
    //   175: ldc 66
    //   177: aload 4
    //   179: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   182: ifne +11 -> 193
    //   185: aload_2
    //   186: astore_1
    //   187: aload_0
    //   188: aload 4
    //   190: putfield 52	com/tencent/smtt/utils/n:g	Ljava/lang/String;
    //   193: aload_2
    //   194: astore_1
    //   195: aload_3
    //   196: ldc 161
    //   198: ldc 66
    //   200: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   203: astore 4
    //   205: aload_2
    //   206: astore_1
    //   207: new 146	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   214: astore 5
    //   216: aload_2
    //   217: astore_1
    //   218: aload 5
    //   220: ldc 163
    //   222: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: astore_1
    //   228: aload 5
    //   230: aload 4
    //   232: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_2
    //   237: astore_1
    //   238: ldc 78
    //   240: aload 5
    //   242: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_2
    //   249: astore_1
    //   250: ldc 66
    //   252: aload 4
    //   254: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   257: ifne +11 -> 268
    //   260: aload_2
    //   261: astore_1
    //   262: aload_0
    //   263: aload 4
    //   265: putfield 68	com/tencent/smtt/utils/n:k	Ljava/lang/String;
    //   268: aload_2
    //   269: astore_1
    //   270: aload_3
    //   271: ldc 165
    //   273: ldc 66
    //   275: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: astore 4
    //   280: aload_2
    //   281: astore_1
    //   282: new 146	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   289: astore 5
    //   291: aload_2
    //   292: astore_1
    //   293: aload 5
    //   295: ldc 167
    //   297: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload_2
    //   302: astore_1
    //   303: aload 5
    //   305: aload 4
    //   307: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: astore_1
    //   313: ldc 78
    //   315: aload 5
    //   317: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: aload_2
    //   324: astore_1
    //   325: ldc 66
    //   327: aload 4
    //   329: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   332: ifne +11 -> 343
    //   335: aload_2
    //   336: astore_1
    //   337: aload_0
    //   338: aload 4
    //   340: putfield 70	com/tencent/smtt/utils/n:l	Ljava/lang/String;
    //   343: aload_2
    //   344: astore_1
    //   345: aload_3
    //   346: ldc 169
    //   348: ldc 66
    //   350: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   353: astore 4
    //   355: aload_2
    //   356: astore_1
    //   357: new 146	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   364: astore 5
    //   366: aload_2
    //   367: astore_1
    //   368: aload 5
    //   370: ldc 171
    //   372: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_2
    //   377: astore_1
    //   378: aload 5
    //   380: aload 4
    //   382: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload_2
    //   387: astore_1
    //   388: ldc 78
    //   390: aload 5
    //   392: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 159	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   398: aload_2
    //   399: astore_1
    //   400: ldc 66
    //   402: aload 4
    //   404: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   407: ifne +11 -> 418
    //   410: aload_2
    //   411: astore_1
    //   412: aload_0
    //   413: aload 4
    //   415: putfield 72	com/tencent/smtt/utils/n:m	Ljava/lang/String;
    //   418: aload_2
    //   419: astore_1
    //   420: aload_3
    //   421: ldc 173
    //   423: ldc 66
    //   425: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   428: astore 4
    //   430: aload_2
    //   431: astore_1
    //   432: ldc 66
    //   434: aload 4
    //   436: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   439: ifne +11 -> 450
    //   442: aload_2
    //   443: astore_1
    //   444: aload_0
    //   445: aload 4
    //   447: putfield 56	com/tencent/smtt/utils/n:h	Ljava/lang/String;
    //   450: aload_2
    //   451: astore_1
    //   452: aload_3
    //   453: ldc 175
    //   455: ldc 66
    //   457: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   460: astore 4
    //   462: aload_2
    //   463: astore_1
    //   464: ldc 66
    //   466: aload 4
    //   468: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   471: ifne +11 -> 482
    //   474: aload_2
    //   475: astore_1
    //   476: aload_0
    //   477: aload 4
    //   479: putfield 60	com/tencent/smtt/utils/n:i	Ljava/lang/String;
    //   482: aload_2
    //   483: astore_1
    //   484: aload_3
    //   485: ldc 177
    //   487: ldc 66
    //   489: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   492: astore 4
    //   494: aload_2
    //   495: astore_1
    //   496: ldc 66
    //   498: aload 4
    //   500: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   503: ifne +11 -> 514
    //   506: aload_2
    //   507: astore_1
    //   508: aload_0
    //   509: aload 4
    //   511: putfield 64	com/tencent/smtt/utils/n:j	Ljava/lang/String;
    //   514: aload_2
    //   515: astore_1
    //   516: aload_3
    //   517: ldc 179
    //   519: ldc 66
    //   521: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   524: astore 4
    //   526: aload_2
    //   527: astore_1
    //   528: ldc 66
    //   530: aload 4
    //   532: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   535: ifne +11 -> 546
    //   538: aload_2
    //   539: astore_1
    //   540: aload_0
    //   541: aload 4
    //   543: putfield 76	com/tencent/smtt/utils/n:n	Ljava/lang/String;
    //   546: aload_2
    //   547: astore_1
    //   548: aload_3
    //   549: ldc 181
    //   551: ldc 66
    //   553: invokevirtual 134	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   556: astore_3
    //   557: aload_2
    //   558: astore_1
    //   559: ldc 66
    //   561: aload_3
    //   562: invokevirtual 140	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   565: ifne +10 -> 575
    //   568: aload_2
    //   569: astore_1
    //   570: aload_0
    //   571: aload_3
    //   572: putfield 44	com/tencent/smtt/utils/n:e	Ljava/lang/String;
    //   575: aload_2
    //   576: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   579: goto +107 -> 686
    //   582: astore_1
    //   583: aload_1
    //   584: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   587: goto +99 -> 686
    //   590: astore_3
    //   591: goto +12 -> 603
    //   594: astore_1
    //   595: aconst_null
    //   596: astore_2
    //   597: goto +97 -> 694
    //   600: astore_3
    //   601: aconst_null
    //   602: astore_2
    //   603: aload_2
    //   604: astore_1
    //   605: new 189	java/io/StringWriter
    //   608: dup
    //   609: invokespecial 190	java/io/StringWriter:<init>	()V
    //   612: astore 4
    //   614: aload_2
    //   615: astore_1
    //   616: aload_3
    //   617: new 192	java/io/PrintWriter
    //   620: dup
    //   621: aload 4
    //   623: invokespecial 195	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   626: invokevirtual 198	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   629: aload_2
    //   630: astore_1
    //   631: new 146	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 147	java/lang/StringBuilder:<init>	()V
    //   638: astore_3
    //   639: aload_2
    //   640: astore_1
    //   641: aload_3
    //   642: ldc 200
    //   644: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_2
    //   649: astore_1
    //   650: aload_3
    //   651: aload 4
    //   653: invokevirtual 201	java/io/StringWriter:toString	()Ljava/lang/String;
    //   656: invokevirtual 153	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: aload_2
    //   661: astore_1
    //   662: ldc 78
    //   664: aload_3
    //   665: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: invokestatic 112	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   671: aload_2
    //   672: ifnull +14 -> 686
    //   675: aload_2
    //   676: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   679: goto +7 -> 686
    //   682: astore_1
    //   683: goto -100 -> 583
    //   686: aload_0
    //   687: monitorexit
    //   688: return
    //   689: astore_3
    //   690: aload_1
    //   691: astore_2
    //   692: aload_3
    //   693: astore_1
    //   694: aload_2
    //   695: ifnull +15 -> 710
    //   698: aload_2
    //   699: invokevirtual 184	java/io/BufferedInputStream:close	()V
    //   702: goto +8 -> 710
    //   705: astore_2
    //   706: aload_2
    //   707: invokevirtual 187	java/io/IOException:printStackTrace	()V
    //   710: aload_1
    //   711: athrow
    //   712: astore_1
    //   713: aload_0
    //   714: monitorexit
    //   715: goto +5 -> 720
    //   718: aload_1
    //   719: athrow
    //   720: goto -2 -> 718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	723	0	this	n
    //   6	564	1	localObject1	Object
    //   582	2	1	localIOException1	java.io.IOException
    //   594	1	1	localObject2	Object
    //   604	58	1	localObject3	Object
    //   682	9	1	localIOException2	java.io.IOException
    //   693	18	1	localObject4	Object
    //   712	7	1	localObject5	Object
    //   36	663	2	localObject6	Object
    //   705	2	2	localIOException3	java.io.IOException
    //   46	526	3	localObject7	Object
    //   590	1	3	localThrowable1	Throwable
    //   600	17	3	localThrowable2	Throwable
    //   638	27	3	localStringBuilder1	StringBuilder
    //   689	4	3	localObject8	Object
    //   64	588	4	localObject9	Object
    //   139	252	5	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   575	579	582	java/io/IOException
    //   39	47	590	java/lang/Throwable
    //   49	54	590	java/lang/Throwable
    //   56	66	590	java/lang/Throwable
    //   68	78	590	java/lang/Throwable
    //   80	86	590	java/lang/Throwable
    //   88	98	590	java/lang/Throwable
    //   100	110	590	java/lang/Throwable
    //   112	118	590	java/lang/Throwable
    //   120	130	590	java/lang/Throwable
    //   132	141	590	java/lang/Throwable
    //   143	151	590	java/lang/Throwable
    //   153	161	590	java/lang/Throwable
    //   163	173	590	java/lang/Throwable
    //   175	185	590	java/lang/Throwable
    //   187	193	590	java/lang/Throwable
    //   195	205	590	java/lang/Throwable
    //   207	216	590	java/lang/Throwable
    //   218	226	590	java/lang/Throwable
    //   228	236	590	java/lang/Throwable
    //   238	248	590	java/lang/Throwable
    //   250	260	590	java/lang/Throwable
    //   262	268	590	java/lang/Throwable
    //   270	280	590	java/lang/Throwable
    //   282	291	590	java/lang/Throwable
    //   293	301	590	java/lang/Throwable
    //   303	311	590	java/lang/Throwable
    //   313	323	590	java/lang/Throwable
    //   325	335	590	java/lang/Throwable
    //   337	343	590	java/lang/Throwable
    //   345	355	590	java/lang/Throwable
    //   357	366	590	java/lang/Throwable
    //   368	376	590	java/lang/Throwable
    //   378	386	590	java/lang/Throwable
    //   388	398	590	java/lang/Throwable
    //   400	410	590	java/lang/Throwable
    //   412	418	590	java/lang/Throwable
    //   420	430	590	java/lang/Throwable
    //   432	442	590	java/lang/Throwable
    //   444	450	590	java/lang/Throwable
    //   452	462	590	java/lang/Throwable
    //   464	474	590	java/lang/Throwable
    //   476	482	590	java/lang/Throwable
    //   484	494	590	java/lang/Throwable
    //   496	506	590	java/lang/Throwable
    //   508	514	590	java/lang/Throwable
    //   516	526	590	java/lang/Throwable
    //   528	538	590	java/lang/Throwable
    //   540	546	590	java/lang/Throwable
    //   548	557	590	java/lang/Throwable
    //   559	568	590	java/lang/Throwable
    //   570	575	590	java/lang/Throwable
    //   2	7	594	finally
    //   11	18	594	finally
    //   21	37	594	finally
    //   2	7	600	java/lang/Throwable
    //   11	18	600	java/lang/Throwable
    //   21	37	600	java/lang/Throwable
    //   675	679	682	java/io/IOException
    //   39	47	689	finally
    //   49	54	689	finally
    //   56	66	689	finally
    //   68	78	689	finally
    //   80	86	689	finally
    //   88	98	689	finally
    //   100	110	689	finally
    //   112	118	689	finally
    //   120	130	689	finally
    //   132	141	689	finally
    //   143	151	689	finally
    //   153	161	689	finally
    //   163	173	689	finally
    //   175	185	689	finally
    //   187	193	689	finally
    //   195	205	689	finally
    //   207	216	689	finally
    //   218	226	689	finally
    //   228	236	689	finally
    //   238	248	689	finally
    //   250	260	689	finally
    //   262	268	689	finally
    //   270	280	689	finally
    //   282	291	689	finally
    //   293	301	689	finally
    //   303	311	689	finally
    //   313	323	689	finally
    //   325	335	689	finally
    //   337	343	689	finally
    //   345	355	689	finally
    //   357	366	689	finally
    //   368	376	689	finally
    //   378	386	689	finally
    //   388	398	689	finally
    //   400	410	689	finally
    //   412	418	689	finally
    //   420	430	689	finally
    //   432	442	689	finally
    //   444	450	689	finally
    //   452	462	689	finally
    //   464	474	689	finally
    //   476	482	689	finally
    //   484	494	689	finally
    //   496	506	689	finally
    //   508	514	689	finally
    //   516	526	689	finally
    //   528	538	689	finally
    //   540	546	689	finally
    //   548	557	689	finally
    //   559	568	689	finally
    //   570	575	689	finally
    //   605	614	689	finally
    //   616	629	689	finally
    //   631	639	689	finally
    //   641	648	689	finally
    //   650	660	689	finally
    //   662	671	689	finally
    //   698	702	705	java/io/IOException
    //   575	579	712	finally
    //   583	587	712	finally
    //   675	679	712	finally
    //   698	702	712	finally
    //   706	710	712	finally
    //   710	712	712	finally
  }
  
  private File l()
  {
    StringWriter localStringWriter = null;
    for (;;)
    {
      Object localObject;
      try
      {
        if (this.b == null)
        {
          localObject = this.a.getApplicationContext().getApplicationInfo().packageName;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            i1 = this.a.getPackageManager().checkPermission("android.permission.READ_EXTERNAL_STORAGE", (String)localObject);
            i2 = 1;
            if (i1 != 0) {
              break label385;
            }
            i1 = 1;
            if (this.a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", (String)localObject) != 0) {
              break label390;
            }
            break label392;
            localObject = new File(FileUtil.a(this.a, 8));
            this.b = ((File)localObject);
            continue;
            TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
            localObject = new File(FileUtil.a(this.a, 5));
            continue;
          }
          else
          {
            localObject = new File(FileUtil.a(this.a, 8));
            continue;
          }
          if (this.b == null) {
            break;
          }
          if (!this.b.isDirectory()) {
            return null;
          }
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("mTbsConfigDir is ");
        ((StringBuilder)localObject).append(this.b.getAbsolutePath());
        TbsLog.i("TbsCommonConfig", ((StringBuilder)localObject).toString());
        localObject = new File(this.b, "tbsnet.conf");
        StringBuilder localStringBuilder1;
        if (!((File)localObject).exists())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Get file(");
          localStringBuilder1.append(((File)localObject).getCanonicalPath());
          localStringBuilder1.append(") failed!");
          TbsLog.e("TbsCommonConfig", localStringBuilder1.toString());
          return null;
        }
        try
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("pathc:");
          localStringBuilder1.append(((File)localObject).getCanonicalPath());
          TbsLog.w("TbsCommonConfig", localStringBuilder1.toString());
          return localObject;
        }
        catch (Throwable localThrowable1) {}
        localStringWriter = new StringWriter();
      }
      catch (Throwable localThrowable2)
      {
        localObject = localStringWriter;
      }
      localThrowable2.printStackTrace(new PrintWriter(localStringWriter));
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("exceptions occurred2:");
      localStringBuilder2.append(localStringWriter.toString());
      TbsLog.e("TbsCommonConfig", localStringBuilder2.toString());
      return localObject;
      label385:
      int i1 = 0;
      continue;
      label390:
      int i2 = 0;
      label392:
      if (i1 == 0) {
        if (i2 == 0) {}
      }
    }
    return null;
  }
  
  public String b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.f;
  }
  
  public String d()
  {
    return this.k;
  }
  
  public String e()
  {
    return this.l;
  }
  
  public String f()
  {
    return this.m;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String h()
  {
    return this.h;
  }
  
  public String i()
  {
    return this.e;
  }
  
  public String j()
  {
    return this.n;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.n
 * JD-Core Version:    0.7.0.1
 */