package com.tencent.qqperf.monitor.backgroundcpu;

import android.os.Handler;
import android.os.Looper;

class BatteryLog$LogHandler
  extends Handler
{
  public BatteryLog$LogHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 19	android/os/Message:what	I
    //   4: ifne +533 -> 537
    //   7: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   10: ifnonnull +62 -> 72
    //   13: new 27	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   20: astore_1
    //   21: aload_1
    //   22: invokestatic 36	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   25: invokevirtual 41	java/io/File:getPath	()Ljava/lang/String;
    //   28: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_1
    //   33: ldc 47
    //   35: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_1
    //   40: ldc 49
    //   42: ldc 51
    //   44: getstatic 55	java/io/File:separator	Ljava/lang/String;
    //   47: invokevirtual 61	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   50: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_1
    //   55: ldc 63
    //   57: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload_1
    //   62: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 72	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokestatic 75	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: pop
    //   72: new 27	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   84: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: invokestatic 78	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:c	()Ljava/lang/String;
    //   92: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 80
    //   99: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: invokestatic 84	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:d	()J
    //   107: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: ldc 89
    //   114: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 91	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	(Ljava/lang/String;)Ljava/lang/String;
    //   125: pop
    //   126: new 27	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   133: astore_1
    //   134: aload_1
    //   135: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   138: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: invokestatic 78	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:c	()Ljava/lang/String;
    //   146: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: ldc 80
    //   153: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: invokestatic 84	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:d	()J
    //   161: invokevirtual 87	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: ldc 93
    //   168: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 95	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:c	(Ljava/lang/String;)Ljava/lang/String;
    //   179: pop
    //   180: new 38	java/io/File
    //   183: dup
    //   184: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   187: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: astore_1
    //   191: new 38	java/io/File
    //   194: dup
    //   195: invokestatic 101	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:e	()Ljava/lang/String;
    //   198: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: new 38	java/io/File
    //   206: dup
    //   207: invokestatic 104	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:f	()Ljava/lang/String;
    //   210: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: astore 9
    //   215: aload 8
    //   217: invokevirtual 108	java/io/File:exists	()Z
    //   220: ifeq +9 -> 229
    //   223: aload 8
    //   225: invokevirtual 111	java/io/File:delete	()Z
    //   228: pop
    //   229: aload 9
    //   231: invokevirtual 108	java/io/File:exists	()Z
    //   234: ifeq +9 -> 243
    //   237: aload 9
    //   239: invokevirtual 111	java/io/File:delete	()Z
    //   242: pop
    //   243: aload_1
    //   244: invokevirtual 108	java/io/File:exists	()Z
    //   247: ifne +8 -> 255
    //   250: aload_1
    //   251: invokevirtual 114	java/io/File:mkdirs	()Z
    //   254: pop
    //   255: aload 8
    //   257: invokevirtual 117	java/io/File:createNewFile	()Z
    //   260: pop
    //   261: new 119	java/io/BufferedWriter
    //   264: dup
    //   265: new 121	java/io/FileWriter
    //   268: dup
    //   269: aload 8
    //   271: invokespecial 124	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   274: sipush 8192
    //   277: invokespecial 127	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   280: invokestatic 130	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/io/BufferedWriter;)Ljava/io/BufferedWriter;
    //   283: pop
    //   284: aload 9
    //   286: invokevirtual 117	java/io/File:createNewFile	()Z
    //   289: pop
    //   290: new 119	java/io/BufferedWriter
    //   293: dup
    //   294: new 121	java/io/FileWriter
    //   297: dup
    //   298: aload 9
    //   300: invokespecial 124	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   303: sipush 8192
    //   306: invokespecial 127	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   309: invokestatic 132	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	(Ljava/io/BufferedWriter;)Ljava/io/BufferedWriter;
    //   312: pop
    //   313: aconst_null
    //   314: astore 11
    //   316: invokestatic 138	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   319: invokevirtual 144	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   322: astore 8
    //   324: aload 8
    //   326: ldc 49
    //   328: sipush 128
    //   331: invokevirtual 150	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   334: astore_1
    //   335: new 27	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   342: astore 9
    //   344: aload 9
    //   346: aload_1
    //   347: getfield 155	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   350: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 9
    //   356: ldc 51
    //   358: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 9
    //   364: aload_1
    //   365: getfield 158	android/content/pm/PackageInfo:versionCode	I
    //   368: invokevirtual 161	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 9
    //   374: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore_1
    //   378: aload 8
    //   380: ldc 49
    //   382: sipush 128
    //   385: invokevirtual 165	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   388: getfield 171	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   391: ldc 173
    //   393: invokevirtual 179	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   396: invokevirtual 182	java/lang/Object:toString	()Ljava/lang/String;
    //   399: astore 10
    //   401: aload_1
    //   402: astore 9
    //   404: goto +42 -> 446
    //   407: astore 8
    //   409: goto +7 -> 416
    //   412: astore 8
    //   414: aconst_null
    //   415: astore_1
    //   416: aload_1
    //   417: astore 9
    //   419: aload 11
    //   421: astore 10
    //   423: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +20 -> 446
    //   429: ldc 189
    //   431: iconst_2
    //   432: ldc 191
    //   434: aload 8
    //   436: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: aload 11
    //   441: astore 10
    //   443: aload_1
    //   444: astore 9
    //   446: bipush 10
    //   448: anewarray 181	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: ldc 196
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload 9
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: invokestatic 201	com/tencent/common/config/AppSetting:i	()Ljava/lang/String;
    //   466: aastore
    //   467: dup
    //   468: iconst_3
    //   469: ldc 203
    //   471: aastore
    //   472: dup
    //   473: iconst_4
    //   474: aload 10
    //   476: aastore
    //   477: dup
    //   478: iconst_5
    //   479: getstatic 208	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   482: aastore
    //   483: dup
    //   484: bipush 6
    //   486: getstatic 211	android/os/Build:MODEL	Ljava/lang/String;
    //   489: aastore
    //   490: dup
    //   491: bipush 7
    //   493: getstatic 216	android/os/Build$VERSION:SDK_INT	I
    //   496: invokestatic 222	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: bipush 8
    //   503: invokestatic 84	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:d	()J
    //   506: invokestatic 227	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: bipush 9
    //   513: ldc 229
    //   515: aastore
    //   516: invokestatic 232	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	([Ljava/lang/Object;)V
    //   519: return
    //   520: astore_1
    //   521: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +360 -> 884
    //   527: ldc 189
    //   529: iconst_2
    //   530: ldc 191
    //   532: aload_1
    //   533: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: return
    //   537: aload_1
    //   538: getfield 19	android/os/Message:what	I
    //   541: iconst_2
    //   542: if_icmpne +189 -> 731
    //   545: aload_1
    //   546: getfield 235	android/os/Message:arg1	I
    //   549: ifne +11 -> 560
    //   552: invokestatic 239	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:g	()Ljava/io/BufferedWriter;
    //   555: astore 8
    //   557: goto +8 -> 565
    //   560: invokestatic 242	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:h	()Ljava/io/BufferedWriter;
    //   563: astore 8
    //   565: aload 8
    //   567: ifnull +317 -> 884
    //   570: invokestatic 245	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/StringBuilder;
    //   573: astore 9
    //   575: aload_1
    //   576: getfield 249	android/os/Message:obj	Ljava/lang/Object;
    //   579: checkcast 251	[Ljava/lang/Object;
    //   582: checkcast 251	[Ljava/lang/Object;
    //   585: astore_1
    //   586: aload_1
    //   587: arraylength
    //   588: istore 4
    //   590: iconst_0
    //   591: istore_2
    //   592: iload_2
    //   593: iload 4
    //   595: if_icmpge +94 -> 689
    //   598: aload_1
    //   599: iload_2
    //   600: aaload
    //   601: astore 10
    //   603: aload 10
    //   605: instanceof 251
    //   608: ifne +34 -> 642
    //   611: aload 10
    //   613: instanceof 253
    //   616: ifeq +6 -> 622
    //   619: goto +23 -> 642
    //   622: aload 9
    //   624: aload 10
    //   626: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 9
    //   632: ldc_w 258
    //   635: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: pop
    //   639: goto +43 -> 682
    //   642: aload 10
    //   644: checkcast 251	[Ljava/lang/Object;
    //   647: checkcast 251	[Ljava/lang/Object;
    //   650: astore 10
    //   652: aload 10
    //   654: arraylength
    //   655: istore 5
    //   657: iconst_0
    //   658: istore_3
    //   659: iload_3
    //   660: iload 5
    //   662: if_icmpge +20 -> 682
    //   665: aload 9
    //   667: aload 10
    //   669: iload_3
    //   670: aaload
    //   671: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   674: pop
    //   675: iload_3
    //   676: iconst_1
    //   677: iadd
    //   678: istore_3
    //   679: goto -20 -> 659
    //   682: iload_2
    //   683: iconst_1
    //   684: iadd
    //   685: istore_2
    //   686: goto -94 -> 592
    //   689: aload 9
    //   691: ldc_w 260
    //   694: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload 8
    //   700: aload 9
    //   702: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokevirtual 263	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   708: aload 8
    //   710: invokevirtual 266	java/io/BufferedWriter:flush	()V
    //   713: return
    //   714: astore_1
    //   715: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   718: ifeq +166 -> 884
    //   721: ldc 189
    //   723: iconst_2
    //   724: ldc 191
    //   726: aload_1
    //   727: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   730: return
    //   731: aload_1
    //   732: getfield 19	android/os/Message:what	I
    //   735: iconst_1
    //   736: if_icmpne +148 -> 884
    //   739: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   742: ifnonnull +45 -> 787
    //   745: new 27	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   752: astore 8
    //   754: aload 8
    //   756: invokestatic 36	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   759: invokevirtual 41	java/io/File:getPath	()Ljava/lang/String;
    //   762: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: aload 8
    //   768: ldc_w 268
    //   771: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload 8
    //   777: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 72	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   783: invokestatic 75	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   786: pop
    //   787: new 38	java/io/File
    //   790: dup
    //   791: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   794: invokespecial 98	java/io/File:<init>	(Ljava/lang/String;)V
    //   797: invokevirtual 272	java/io/File:listFiles	()[Ljava/io/File;
    //   800: astore 8
    //   802: aload 8
    //   804: arraylength
    //   805: istore 4
    //   807: iconst_0
    //   808: istore_2
    //   809: iload_2
    //   810: iload 4
    //   812: if_icmpge +72 -> 884
    //   815: aload 8
    //   817: iload_2
    //   818: aaload
    //   819: astore 9
    //   821: aload 9
    //   823: invokestatic 275	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/io/File;)J
    //   826: lstore 6
    //   828: lload 6
    //   830: ldc2_w 276
    //   833: lcmp
    //   834: ifeq +63 -> 897
    //   837: lload 6
    //   839: aload_1
    //   840: getfield 249	android/os/Message:obj	Ljava/lang/Object;
    //   843: checkcast 224	java/lang/Long
    //   846: invokevirtual 280	java/lang/Long:longValue	()J
    //   849: lcmp
    //   850: ifle +47 -> 897
    //   853: iconst_0
    //   854: istore_3
    //   855: goto +3 -> 858
    //   858: iload_3
    //   859: ifeq +18 -> 877
    //   862: aload 9
    //   864: invokevirtual 111	java/io/File:delete	()Z
    //   867: pop
    //   868: goto +9 -> 877
    //   871: aload 9
    //   873: invokevirtual 111	java/io/File:delete	()Z
    //   876: pop
    //   877: iload_2
    //   878: iconst_1
    //   879: iadd
    //   880: istore_2
    //   881: goto -72 -> 809
    //   884: return
    //   885: astore_1
    //   886: return
    //   887: astore 10
    //   889: goto -18 -> 871
    //   892: astore 9
    //   894: goto -17 -> 877
    //   897: iconst_1
    //   898: istore_3
    //   899: goto -41 -> 858
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	902	0	this	LogHandler
    //   0	902	1	paramMessage	android.os.Message
    //   591	290	2	i	int
    //   658	241	3	j	int
    //   588	225	4	k	int
    //   655	8	5	m	int
    //   826	12	6	l	long
    //   201	178	8	localObject1	java.lang.Object
    //   407	1	8	localThrowable1	java.lang.Throwable
    //   412	23	8	localThrowable2	java.lang.Throwable
    //   555	261	8	localObject2	java.lang.Object
    //   213	659	9	localObject3	java.lang.Object
    //   892	1	9	localThrowable3	java.lang.Throwable
    //   399	269	10	localObject4	java.lang.Object
    //   887	1	10	localThrowable4	java.lang.Throwable
    //   314	126	11	localObject5	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   378	401	407	java/lang/Throwable
    //   316	378	412	java/lang/Throwable
    //   215	229	520	java/lang/Throwable
    //   229	243	520	java/lang/Throwable
    //   243	255	520	java/lang/Throwable
    //   255	313	520	java/lang/Throwable
    //   423	439	520	java/lang/Throwable
    //   446	519	520	java/lang/Throwable
    //   698	713	714	java/lang/Throwable
    //   787	807	885	java/lang/Throwable
    //   821	828	887	java/lang/Throwable
    //   837	853	887	java/lang/Throwable
    //   862	868	887	java/lang/Throwable
    //   871	877	892	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryLog.LogHandler
 * JD-Core Version:    0.7.0.1
 */