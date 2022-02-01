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
    //   7: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
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
    //   68: invokestatic 74	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: pop
    //   72: new 27	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
    //   84: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: invokestatic 77	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   92: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 79
    //   99: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: invokestatic 82	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()J
    //   107: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_1
    //   112: ldc 87
    //   114: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 89	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	(Ljava/lang/String;)Ljava/lang/String;
    //   125: pop
    //   126: new 27	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   133: astore_1
    //   134: aload_1
    //   135: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
    //   138: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: invokestatic 77	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/lang/String;
    //   146: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: ldc 79
    //   153: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: aload_1
    //   158: invokestatic 82	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()J
    //   161: invokevirtual 85	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload_1
    //   166: ldc 91
    //   168: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload_1
    //   173: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 94	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:c	(Ljava/lang/String;)Ljava/lang/String;
    //   179: pop
    //   180: new 38	java/io/File
    //   183: dup
    //   184: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
    //   187: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   190: astore_1
    //   191: new 38	java/io/File
    //   194: dup
    //   195: invokestatic 99	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:c	()Ljava/lang/String;
    //   198: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   201: astore 8
    //   203: new 38	java/io/File
    //   206: dup
    //   207: invokestatic 102	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:d	()Ljava/lang/String;
    //   210: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   213: astore 9
    //   215: aload 8
    //   217: invokevirtual 106	java/io/File:exists	()Z
    //   220: ifeq +9 -> 229
    //   223: aload 8
    //   225: invokevirtual 109	java/io/File:delete	()Z
    //   228: pop
    //   229: aload 9
    //   231: invokevirtual 106	java/io/File:exists	()Z
    //   234: ifeq +9 -> 243
    //   237: aload 9
    //   239: invokevirtual 109	java/io/File:delete	()Z
    //   242: pop
    //   243: aload_1
    //   244: invokevirtual 106	java/io/File:exists	()Z
    //   247: ifne +8 -> 255
    //   250: aload_1
    //   251: invokevirtual 112	java/io/File:mkdirs	()Z
    //   254: pop
    //   255: aload 8
    //   257: invokevirtual 115	java/io/File:createNewFile	()Z
    //   260: pop
    //   261: new 117	java/io/BufferedWriter
    //   264: dup
    //   265: new 119	java/io/FileWriter
    //   268: dup
    //   269: aload 8
    //   271: invokespecial 122	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   274: sipush 8192
    //   277: invokespecial 125	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   280: invokestatic 128	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/io/BufferedWriter;)Ljava/io/BufferedWriter;
    //   283: pop
    //   284: aload 9
    //   286: invokevirtual 115	java/io/File:createNewFile	()Z
    //   289: pop
    //   290: new 117	java/io/BufferedWriter
    //   293: dup
    //   294: new 119	java/io/FileWriter
    //   297: dup
    //   298: aload 9
    //   300: invokespecial 122	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   303: sipush 8192
    //   306: invokespecial 125	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   309: invokestatic 130	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	(Ljava/io/BufferedWriter;)Ljava/io/BufferedWriter;
    //   312: pop
    //   313: aconst_null
    //   314: astore 11
    //   316: invokestatic 136	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   319: invokevirtual 142	com/tencent/qphone/base/util/BaseApplication:getPackageManager	()Landroid/content/pm/PackageManager;
    //   322: astore 8
    //   324: aload 8
    //   326: ldc 49
    //   328: sipush 128
    //   331: invokevirtual 148	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   334: astore_1
    //   335: new 27	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   342: astore 9
    //   344: aload 9
    //   346: aload_1
    //   347: getfield 153	android/content/pm/PackageInfo:versionName	Ljava/lang/String;
    //   350: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: pop
    //   354: aload 9
    //   356: ldc 51
    //   358: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: aload 9
    //   364: aload_1
    //   365: getfield 156	android/content/pm/PackageInfo:versionCode	I
    //   368: invokevirtual 159	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 9
    //   374: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: astore_1
    //   378: aload 8
    //   380: ldc 49
    //   382: sipush 128
    //   385: invokevirtual 163	android/content/pm/PackageManager:getApplicationInfo	(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    //   388: getfield 169	android/content/pm/ApplicationInfo:metaData	Landroid/os/Bundle;
    //   391: ldc 171
    //   393: invokevirtual 177	android/os/Bundle:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   396: invokevirtual 180	java/lang/Object:toString	()Ljava/lang/String;
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
    //   423: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   426: ifeq +20 -> 446
    //   429: ldc 187
    //   431: iconst_2
    //   432: ldc 189
    //   434: aload 8
    //   436: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   439: aload 11
    //   441: astore 10
    //   443: aload_1
    //   444: astore 9
    //   446: bipush 10
    //   448: anewarray 179	java/lang/Object
    //   451: dup
    //   452: iconst_0
    //   453: ldc 194
    //   455: aastore
    //   456: dup
    //   457: iconst_1
    //   458: aload 9
    //   460: aastore
    //   461: dup
    //   462: iconst_2
    //   463: invokestatic 199	com/tencent/common/config/AppSetting:g	()Ljava/lang/String;
    //   466: aastore
    //   467: dup
    //   468: iconst_3
    //   469: ldc 201
    //   471: aastore
    //   472: dup
    //   473: iconst_4
    //   474: aload 10
    //   476: aastore
    //   477: dup
    //   478: iconst_5
    //   479: getstatic 206	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   482: aastore
    //   483: dup
    //   484: bipush 6
    //   486: getstatic 209	android/os/Build:MODEL	Ljava/lang/String;
    //   489: aastore
    //   490: dup
    //   491: bipush 7
    //   493: getstatic 214	android/os/Build$VERSION:SDK_INT	I
    //   496: invokestatic 220	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: bipush 8
    //   503: invokestatic 82	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()J
    //   506: invokestatic 225	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   509: aastore
    //   510: dup
    //   511: bipush 9
    //   513: ldc 227
    //   515: aastore
    //   516: invokestatic 230	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	([Ljava/lang/Object;)V
    //   519: return
    //   520: astore_1
    //   521: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   524: ifeq +359 -> 883
    //   527: ldc 187
    //   529: iconst_2
    //   530: ldc 189
    //   532: aload_1
    //   533: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   536: return
    //   537: aload_1
    //   538: getfield 19	android/os/Message:what	I
    //   541: iconst_2
    //   542: if_icmpne +188 -> 730
    //   545: aload_1
    //   546: getfield 233	android/os/Message:arg1	I
    //   549: ifne +11 -> 560
    //   552: invokestatic 236	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/io/BufferedWriter;
    //   555: astore 8
    //   557: goto +8 -> 565
    //   560: invokestatic 238	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:b	()Ljava/io/BufferedWriter;
    //   563: astore 8
    //   565: aload 8
    //   567: ifnull +316 -> 883
    //   570: invokestatic 241	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/StringBuilder;
    //   573: astore 9
    //   575: aload_1
    //   576: getfield 245	android/os/Message:obj	Ljava/lang/Object;
    //   579: checkcast 247	[Ljava/lang/Object;
    //   582: checkcast 247	[Ljava/lang/Object;
    //   585: astore_1
    //   586: aload_1
    //   587: arraylength
    //   588: istore 4
    //   590: iconst_0
    //   591: istore_2
    //   592: iload_2
    //   593: iload 4
    //   595: if_icmpge +93 -> 688
    //   598: aload_1
    //   599: iload_2
    //   600: aaload
    //   601: astore 10
    //   603: aload 10
    //   605: instanceof 247
    //   608: ifne +33 -> 641
    //   611: aload 10
    //   613: instanceof 249
    //   616: ifeq +6 -> 622
    //   619: goto +22 -> 641
    //   622: aload 9
    //   624: aload 10
    //   626: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload 9
    //   632: ldc 254
    //   634: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: goto +43 -> 681
    //   641: aload 10
    //   643: checkcast 247	[Ljava/lang/Object;
    //   646: checkcast 247	[Ljava/lang/Object;
    //   649: astore 10
    //   651: aload 10
    //   653: arraylength
    //   654: istore 5
    //   656: iconst_0
    //   657: istore_3
    //   658: iload_3
    //   659: iload 5
    //   661: if_icmpge +20 -> 681
    //   664: aload 9
    //   666: aload 10
    //   668: iload_3
    //   669: aaload
    //   670: invokevirtual 252	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: iload_3
    //   675: iconst_1
    //   676: iadd
    //   677: istore_3
    //   678: goto -20 -> 658
    //   681: iload_2
    //   682: iconst_1
    //   683: iadd
    //   684: istore_2
    //   685: goto -93 -> 592
    //   688: aload 9
    //   690: ldc_w 256
    //   693: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload 8
    //   699: aload 9
    //   701: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokevirtual 259	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   707: aload 8
    //   709: invokevirtual 262	java/io/BufferedWriter:flush	()V
    //   712: return
    //   713: astore_1
    //   714: invokestatic 185	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   717: ifeq +166 -> 883
    //   720: ldc 187
    //   722: iconst_2
    //   723: ldc 189
    //   725: aload_1
    //   726: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   729: return
    //   730: aload_1
    //   731: getfield 19	android/os/Message:what	I
    //   734: iconst_1
    //   735: if_icmpne +148 -> 883
    //   738: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
    //   741: ifnonnull +45 -> 786
    //   744: new 27	java/lang/StringBuilder
    //   747: dup
    //   748: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   751: astore 8
    //   753: aload 8
    //   755: invokestatic 36	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   758: invokevirtual 41	java/io/File:getPath	()Ljava/lang/String;
    //   761: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: pop
    //   765: aload 8
    //   767: ldc_w 264
    //   770: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   773: pop
    //   774: aload 8
    //   776: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   779: invokestatic 72	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   782: invokestatic 74	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/lang/String;)Ljava/lang/String;
    //   785: pop
    //   786: new 38	java/io/File
    //   789: dup
    //   790: invokestatic 25	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	()Ljava/lang/String;
    //   793: invokespecial 97	java/io/File:<init>	(Ljava/lang/String;)V
    //   796: invokevirtual 268	java/io/File:listFiles	()[Ljava/io/File;
    //   799: astore 8
    //   801: aload 8
    //   803: arraylength
    //   804: istore 4
    //   806: iconst_0
    //   807: istore_2
    //   808: iload_2
    //   809: iload 4
    //   811: if_icmpge +72 -> 883
    //   814: aload 8
    //   816: iload_2
    //   817: aaload
    //   818: astore 9
    //   820: aload 9
    //   822: invokestatic 271	com/tencent/qqperf/monitor/backgroundcpu/BatteryLog:a	(Ljava/io/File;)J
    //   825: lstore 6
    //   827: lload 6
    //   829: ldc2_w 272
    //   832: lcmp
    //   833: ifeq +63 -> 896
    //   836: lload 6
    //   838: aload_1
    //   839: getfield 245	android/os/Message:obj	Ljava/lang/Object;
    //   842: checkcast 222	java/lang/Long
    //   845: invokevirtual 276	java/lang/Long:longValue	()J
    //   848: lcmp
    //   849: ifle +47 -> 896
    //   852: iconst_0
    //   853: istore_3
    //   854: goto +3 -> 857
    //   857: iload_3
    //   858: ifeq +18 -> 876
    //   861: aload 9
    //   863: invokevirtual 109	java/io/File:delete	()Z
    //   866: pop
    //   867: goto +9 -> 876
    //   870: aload 9
    //   872: invokevirtual 109	java/io/File:delete	()Z
    //   875: pop
    //   876: iload_2
    //   877: iconst_1
    //   878: iadd
    //   879: istore_2
    //   880: goto -72 -> 808
    //   883: return
    //   884: astore_1
    //   885: return
    //   886: astore 10
    //   888: goto -18 -> 870
    //   891: astore 9
    //   893: goto -17 -> 876
    //   896: iconst_1
    //   897: istore_3
    //   898: goto -41 -> 857
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	901	0	this	LogHandler
    //   0	901	1	paramMessage	android.os.Message
    //   591	289	2	i	int
    //   657	241	3	j	int
    //   588	224	4	k	int
    //   654	8	5	m	int
    //   825	12	6	l	long
    //   201	178	8	localObject1	java.lang.Object
    //   407	1	8	localThrowable1	java.lang.Throwable
    //   412	23	8	localThrowable2	java.lang.Throwable
    //   555	260	8	localObject2	java.lang.Object
    //   213	658	9	localObject3	java.lang.Object
    //   891	1	9	localThrowable3	java.lang.Throwable
    //   399	268	10	localObject4	java.lang.Object
    //   886	1	10	localThrowable4	java.lang.Throwable
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
    //   697	712	713	java/lang/Throwable
    //   786	806	884	java/lang/Throwable
    //   820	827	886	java/lang/Throwable
    //   836	852	886	java/lang/Throwable
    //   861	867	886	java/lang/Throwable
    //   870	876	891	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.backgroundcpu.BatteryLog.LogHandler
 * JD-Core Version:    0.7.0.1
 */