package com.tencent.qqperf.monitor.memory;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MemoryManager$AlertMemoryRunner
  implements Runnable
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  Class jdField_a_of_type_JavaLangClass;
  private int b;
  
  public MemoryManager$AlertMemoryRunner(Context paramContext, int paramInt1, Class paramClass, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = paramInt1;
    this.jdField_a_of_type_JavaLangClass = paramClass;
    this.jdField_a_of_type_Int = paramInt2;
    if (MemoryManager.a() == null)
    {
      MemoryManager.a(new ArrayList());
      MemoryManager.a().add("com.android.browser");
      MemoryManager.a().add("com.android.email");
      MemoryManager.a().add("com.sec.android.app.readershub");
    }
    if (MemoryManager.b() == null)
    {
      MemoryManager.b(new ArrayList());
      paramContext = Pattern.compile("^com.*.android.*");
      MemoryManager.b().add(paramContext);
    }
    if (MemoryManager.c() == null)
    {
      MemoryManager.c(new ArrayList());
      MemoryManager.c().add("system");
      MemoryManager.c().add("com.android.");
      MemoryManager.c().add("com.google.process.");
      MemoryManager.c().add("android.process.");
    }
  }
  
  private boolean a(String paramString)
  {
    if (paramString.startsWith("com.tencent.mobileqq")) {
      return true;
    }
    int i = 0;
    while (i < MemoryManager.a().size())
    {
      if (paramString.equals(MemoryManager.a().get(i))) {
        return false;
      }
      i += 1;
    }
    i = 0;
    while (i < MemoryManager.b().size())
    {
      if (((Pattern)MemoryManager.b().get(i)).matcher(paramString).find()) {
        return true;
      }
      i += 1;
    }
    i = 0;
    while (i < MemoryManager.c().size())
    {
      if (paramString.startsWith((String)MemoryManager.c().get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public void run()
  {
    // Byte code:
    //   0: ldc 110
    //   2: astore 12
    //   4: aload 12
    //   6: astore 13
    //   8: aload_0
    //   9: getfield 20	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:b	I
    //   12: istore_1
    //   13: iload_1
    //   14: iconst_1
    //   15: if_icmpeq +794 -> 809
    //   18: iload_1
    //   19: iconst_2
    //   20: if_icmpeq +6 -> 26
    //   23: goto +1003 -> 1026
    //   26: aload 12
    //   28: astore 13
    //   30: invokestatic 116	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()J
    //   33: lstore 4
    //   35: aload 12
    //   37: astore 13
    //   39: invokestatic 118	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   42: lstore 6
    //   44: aload 12
    //   46: astore 13
    //   48: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +99 -> 150
    //   54: aload 12
    //   56: astore 13
    //   58: new 125	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   65: astore 14
    //   67: aload 12
    //   69: astore 13
    //   71: aload 14
    //   73: ldc 128
    //   75: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 12
    //   81: astore 13
    //   83: aload 14
    //   85: lload 4
    //   87: ldc2_w 133
    //   90: ldiv
    //   91: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 12
    //   97: astore 13
    //   99: aload 14
    //   101: ldc 139
    //   103: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload 12
    //   109: astore 13
    //   111: aload 14
    //   113: lload 6
    //   115: ldc2_w 133
    //   118: ldiv
    //   119: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 12
    //   125: astore 13
    //   127: aload 14
    //   129: ldc 141
    //   131: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 12
    //   137: astore 13
    //   139: ldc 110
    //   141: iconst_2
    //   142: aload 14
    //   144: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: aload 12
    //   152: astore 13
    //   154: invokestatic 154	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   157: invokevirtual 157	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryConfigs;
    //   160: getfield 160	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   163: i2l
    //   164: lload 6
    //   166: lmul
    //   167: ldc2_w 161
    //   170: ldiv
    //   171: lstore 8
    //   173: lload 4
    //   175: lload 8
    //   177: lcmp
    //   178: iflt +9 -> 187
    //   181: aload_0
    //   182: aconst_null
    //   183: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   186: return
    //   187: aload 12
    //   189: astore 13
    //   191: invokestatic 168	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   194: ldc 170
    //   196: iconst_0
    //   197: invokevirtual 176	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   200: astore 15
    //   202: aload 12
    //   204: astore 13
    //   206: aload 15
    //   208: ldc 178
    //   210: lconst_0
    //   211: invokeinterface 184 4 0
    //   216: lstore_2
    //   217: aload 12
    //   219: astore 13
    //   221: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   224: lstore 10
    //   226: lload 10
    //   228: lload_2
    //   229: lcmp
    //   230: ifge +50 -> 280
    //   233: aload 12
    //   235: astore 13
    //   237: aload 15
    //   239: invokeinterface 193 1 0
    //   244: astore 14
    //   246: aload 12
    //   248: astore 13
    //   250: aload 14
    //   252: ldc 178
    //   254: lload 10
    //   256: invokeinterface 199 4 0
    //   261: pop
    //   262: aload 12
    //   264: astore 13
    //   266: aload 14
    //   268: invokeinterface 202 1 0
    //   273: pop
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   279: return
    //   280: aload 12
    //   282: astore 13
    //   284: invokestatic 205	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   287: lload 8
    //   289: lload 4
    //   291: invokevirtual 208	com/tencent/qqperf/monitor/memory/MemoryManager:a	(JJ)V
    //   294: lload 10
    //   296: lload_2
    //   297: lsub
    //   298: lstore_2
    //   299: aload 12
    //   301: astore 13
    //   303: invokestatic 154	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   306: invokevirtual 157	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryConfigs;
    //   309: getfield 211	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Long	J
    //   312: lstore 10
    //   314: lload_2
    //   315: lload 10
    //   317: lcmp
    //   318: ifge +9 -> 327
    //   321: aload_0
    //   322: aconst_null
    //   323: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   326: return
    //   327: aload 12
    //   329: astore 13
    //   331: invokestatic 205	com/tencent/qqperf/monitor/memory/MemoryManager:a	()Lcom/tencent/qqperf/monitor/memory/MemoryManager;
    //   334: lload 8
    //   336: lload 4
    //   338: invokevirtual 213	com/tencent/qqperf/monitor/memory/MemoryManager:b	(JJ)V
    //   341: aload 12
    //   343: astore 13
    //   345: new 31	java/util/ArrayList
    //   348: dup
    //   349: invokespecial 32	java/util/ArrayList:<init>	()V
    //   352: astore 16
    //   354: aload 12
    //   356: astore 13
    //   358: aload_0
    //   359: getfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   362: ldc 215
    //   364: invokevirtual 221	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   367: checkcast 223	android/app/ActivityManager
    //   370: invokevirtual 226	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   373: invokeinterface 230 1 0
    //   378: astore 14
    //   380: aload 12
    //   382: astore 13
    //   384: aload 14
    //   386: invokeinterface 235 1 0
    //   391: ifeq +132 -> 523
    //   394: aload 12
    //   396: astore 13
    //   398: aload 14
    //   400: invokeinterface 239 1 0
    //   405: checkcast 241	android/app/ActivityManager$RunningAppProcessInfo
    //   408: astore 17
    //   410: aload 12
    //   412: astore 13
    //   414: aload 17
    //   416: getfield 245	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   419: astore 18
    //   421: aload 12
    //   423: astore 13
    //   425: aload 13
    //   427: astore 12
    //   429: aload 17
    //   431: getfield 248	android/app/ActivityManager$RunningAppProcessInfo:importance	I
    //   434: bipush 100
    //   436: if_icmpeq +694 -> 1130
    //   439: aload 13
    //   441: astore 12
    //   443: aload 17
    //   445: getfield 248	android/app/ActivityManager$RunningAppProcessInfo:importance	I
    //   448: sipush 200
    //   451: if_icmpne +30 -> 481
    //   454: aload 13
    //   456: astore 12
    //   458: aload 17
    //   460: getfield 248	android/app/ActivityManager$RunningAppProcessInfo:importance	I
    //   463: sipush 200
    //   466: if_icmpne +664 -> 1130
    //   469: aload 13
    //   471: astore 12
    //   473: aload 17
    //   475: getfield 251	android/app/ActivityManager$RunningAppProcessInfo:importanceReasonCode	I
    //   478: ifeq +652 -> 1130
    //   481: aload 13
    //   483: astore 12
    //   485: aload_0
    //   486: aload 18
    //   488: invokespecial 253	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:a	(Ljava/lang/String;)Z
    //   491: ifne +639 -> 1130
    //   494: aload 13
    //   496: astore 12
    //   498: aload 16
    //   500: aload 18
    //   502: aload 17
    //   504: getfield 256	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   507: invokestatic 259	com/tencent/mobileqq/utils/DeviceInfoUtil:a	(I)J
    //   510: invokestatic 265	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   513: invokestatic 271	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   516: invokevirtual 272	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   519: pop
    //   520: goto +610 -> 1130
    //   523: aload 12
    //   525: astore 13
    //   527: aload 13
    //   529: astore 12
    //   531: aload 16
    //   533: invokestatic 277	com/tencent/mobileqq/util/SortUtils:a	(Ljava/util/ArrayList;)Ljava/util/ArrayList;
    //   536: pop
    //   537: aload 13
    //   539: astore 12
    //   541: aload_0
    //   542: getfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   545: ldc 215
    //   547: invokevirtual 221	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   550: checkcast 223	android/app/ActivityManager
    //   553: astore 14
    //   555: aload 13
    //   557: astore 12
    //   559: aload 15
    //   561: invokeinterface 193 1 0
    //   566: astore 14
    //   568: aload 13
    //   570: astore 12
    //   572: aload 14
    //   574: ldc 178
    //   576: invokestatic 189	java/lang/System:currentTimeMillis	()J
    //   579: invokeinterface 199 4 0
    //   584: pop
    //   585: aload 13
    //   587: astore 12
    //   589: aload 14
    //   591: invokeinterface 202 1 0
    //   596: pop
    //   597: aload 13
    //   599: astore 12
    //   601: invokestatic 278	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   604: invokestatic 284	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   607: astore 14
    //   609: aload 13
    //   611: astore 12
    //   613: new 286	java/util/HashMap
    //   616: dup
    //   617: invokespecial 287	java/util/HashMap:<init>	()V
    //   620: astore 15
    //   622: aload 13
    //   624: astore 12
    //   626: aload 15
    //   628: ldc_w 289
    //   631: getstatic 294	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   634: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   637: pop
    //   638: aload 13
    //   640: astore 12
    //   642: new 125	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   649: astore 16
    //   651: aload 13
    //   653: astore 12
    //   655: aload 16
    //   657: getstatic 303	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   660: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: pop
    //   664: aload 13
    //   666: astore 12
    //   668: aload 16
    //   670: ldc_w 305
    //   673: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 13
    //   679: astore 12
    //   681: aload 16
    //   683: getstatic 308	android/os/Build:MODEL	Ljava/lang/String;
    //   686: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: pop
    //   690: aload 13
    //   692: astore 12
    //   694: aload 15
    //   696: ldc_w 310
    //   699: aload 16
    //   701: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   707: pop
    //   708: aload 13
    //   710: astore 12
    //   712: aload 15
    //   714: ldc_w 312
    //   717: lload 4
    //   719: invokestatic 315	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   722: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   725: pop
    //   726: aload 13
    //   728: astore 12
    //   730: aload 15
    //   732: ldc_w 317
    //   735: lload 6
    //   737: invokestatic 315	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   740: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   743: pop
    //   744: aload 13
    //   746: astore 12
    //   748: aload 15
    //   750: ldc_w 319
    //   753: lload 8
    //   755: invokestatic 315	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   758: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   761: pop
    //   762: aload 13
    //   764: astore 12
    //   766: aload 15
    //   768: ldc_w 321
    //   771: lload_2
    //   772: ldc2_w 322
    //   775: ldiv
    //   776: invokestatic 315	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   779: invokevirtual 298	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   782: pop
    //   783: aload 13
    //   785: astore 12
    //   787: aload 14
    //   789: ldc_w 325
    //   792: ldc_w 327
    //   795: iconst_1
    //   796: lconst_0
    //   797: lconst_0
    //   798: aload 15
    //   800: ldc_w 325
    //   803: invokevirtual 331	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   806: goto -783 -> 23
    //   809: ldc 110
    //   811: astore 13
    //   813: aload 13
    //   815: astore 12
    //   817: invokestatic 116	com/tencent/mobileqq/utils/DeviceInfoUtil:e	()J
    //   820: lstore_2
    //   821: aload 13
    //   823: astore 12
    //   825: invokestatic 118	com/tencent/mobileqq/utils/DeviceInfoUtil:a	()J
    //   828: lstore 4
    //   830: aload 13
    //   832: astore 12
    //   834: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   837: ifeq +300 -> 1137
    //   840: aload 13
    //   842: astore 12
    //   844: new 125	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   851: astore 14
    //   853: aload 13
    //   855: astore 12
    //   857: aload 14
    //   859: ldc_w 333
    //   862: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   865: pop
    //   866: aload 13
    //   868: astore 12
    //   870: aload 14
    //   872: lload_2
    //   873: ldc2_w 133
    //   876: ldiv
    //   877: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload 13
    //   883: astore 12
    //   885: aload 14
    //   887: ldc 139
    //   889: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   892: pop
    //   893: aload 13
    //   895: astore 12
    //   897: aload 14
    //   899: lload 4
    //   901: ldc2_w 133
    //   904: ldiv
    //   905: invokevirtual 137	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   908: pop
    //   909: aload 13
    //   911: astore 12
    //   913: aload 14
    //   915: ldc 141
    //   917: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: aload 13
    //   923: astore 12
    //   925: aload 14
    //   927: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   930: astore 14
    //   932: aload 13
    //   934: iconst_2
    //   935: aload 14
    //   937: invokestatic 149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   940: goto +3 -> 943
    //   943: lload 4
    //   945: invokestatic 154	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/MagnifierSDK;
    //   948: invokevirtual 157	com/tencent/qqperf/MagnifierSDK:a	()Lcom/tencent/qqperf/opt/clearmemory/MemoryConfigs;
    //   951: getfield 160	com/tencent/qqperf/opt/clearmemory/MemoryConfigs:jdField_a_of_type_Int	I
    //   954: i2l
    //   955: lmul
    //   956: ldc2_w 161
    //   959: ldiv
    //   960: lstore 4
    //   962: lload_2
    //   963: lload 4
    //   965: lcmp
    //   966: iflt +9 -> 975
    //   969: aload_0
    //   970: aconst_null
    //   971: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   974: return
    //   975: new 335	android/content/Intent
    //   978: dup
    //   979: aload_0
    //   980: getfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   983: aload_0
    //   984: getfield 22	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_JavaLangClass	Ljava/lang/Class;
    //   987: invokespecial 338	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   990: astore 12
    //   992: aload 12
    //   994: ldc_w 340
    //   997: aload_0
    //   998: getfield 24	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_Int	I
    //   1001: invokevirtual 344	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1004: pop
    //   1005: aload 12
    //   1007: ldc_w 345
    //   1010: invokevirtual 349	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   1013: pop
    //   1014: aload_0
    //   1015: getfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1018: aload 12
    //   1020: invokevirtual 353	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   1023: goto -1000 -> 23
    //   1026: aload_0
    //   1027: aconst_null
    //   1028: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1031: return
    //   1032: ldc 110
    //   1034: astore 13
    //   1036: astore 12
    //   1038: goto +23 -> 1061
    //   1041: astore 14
    //   1043: aload 12
    //   1045: astore 13
    //   1047: aload 14
    //   1049: astore 12
    //   1051: goto +10 -> 1061
    //   1054: astore 12
    //   1056: goto +60 -> 1116
    //   1059: astore 12
    //   1061: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1064: ifeq -1041 -> 23
    //   1067: new 125	java/lang/StringBuilder
    //   1070: dup
    //   1071: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   1074: astore 14
    //   1076: aload 14
    //   1078: ldc_w 355
    //   1081: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: pop
    //   1085: aload 14
    //   1087: aload_0
    //   1088: getfield 20	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:b	I
    //   1091: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1094: pop
    //   1095: aload 13
    //   1097: iconst_2
    //   1098: aload 14
    //   1100: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1103: aload 12
    //   1105: invokestatic 361	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1108: aload 12
    //   1110: invokevirtual 364	java/lang/Throwable:printStackTrace	()V
    //   1113: goto -1090 -> 23
    //   1116: aload_0
    //   1117: aconst_null
    //   1118: putfield 18	com/tencent/qqperf/monitor/memory/MemoryManager$AlertMemoryRunner:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   1121: goto +6 -> 1127
    //   1124: aload 12
    //   1126: athrow
    //   1127: goto -3 -> 1124
    //   1130: aload 13
    //   1132: astore 12
    //   1134: goto -754 -> 380
    //   1137: goto -194 -> 943
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1140	0	this	AlertMemoryRunner
    //   12	9	1	i	int
    //   216	747	2	l1	long
    //   33	931	4	l2	long
    //   42	694	6	l3	long
    //   171	583	8	l4	long
    //   224	92	10	l5	long
    //   2	1017	12	localObject1	Object
    //   1036	8	12	localThrowable1	java.lang.Throwable
    //   1049	1	12	localObject2	Object
    //   1054	1	12	localObject3	Object
    //   1059	66	12	localThrowable2	java.lang.Throwable
    //   1132	1	12	localObject4	Object
    //   6	1125	13	localObject5	Object
    //   65	871	14	localObject6	Object
    //   1041	7	14	localThrowable3	java.lang.Throwable
    //   1074	25	14	localStringBuilder	java.lang.StringBuilder
    //   200	599	15	localObject7	Object
    //   352	348	16	localObject8	Object
    //   408	95	17	localRunningAppProcessInfo	android.app.ActivityManager.RunningAppProcessInfo
    //   419	82	18	str	String
    // Exception table:
    //   from	to	target	type
    //   932	940	1032	java/lang/Throwable
    //   943	962	1032	java/lang/Throwable
    //   975	1023	1032	java/lang/Throwable
    //   429	439	1041	java/lang/Throwable
    //   443	454	1041	java/lang/Throwable
    //   458	469	1041	java/lang/Throwable
    //   473	481	1041	java/lang/Throwable
    //   485	494	1041	java/lang/Throwable
    //   498	520	1041	java/lang/Throwable
    //   531	537	1041	java/lang/Throwable
    //   541	555	1041	java/lang/Throwable
    //   559	568	1041	java/lang/Throwable
    //   572	585	1041	java/lang/Throwable
    //   589	597	1041	java/lang/Throwable
    //   601	609	1041	java/lang/Throwable
    //   613	622	1041	java/lang/Throwable
    //   626	638	1041	java/lang/Throwable
    //   642	651	1041	java/lang/Throwable
    //   655	664	1041	java/lang/Throwable
    //   668	677	1041	java/lang/Throwable
    //   681	690	1041	java/lang/Throwable
    //   694	708	1041	java/lang/Throwable
    //   712	726	1041	java/lang/Throwable
    //   730	744	1041	java/lang/Throwable
    //   748	762	1041	java/lang/Throwable
    //   766	783	1041	java/lang/Throwable
    //   787	806	1041	java/lang/Throwable
    //   817	821	1041	java/lang/Throwable
    //   825	830	1041	java/lang/Throwable
    //   834	840	1041	java/lang/Throwable
    //   844	853	1041	java/lang/Throwable
    //   857	866	1041	java/lang/Throwable
    //   870	881	1041	java/lang/Throwable
    //   885	893	1041	java/lang/Throwable
    //   897	909	1041	java/lang/Throwable
    //   913	921	1041	java/lang/Throwable
    //   925	932	1041	java/lang/Throwable
    //   8	13	1054	finally
    //   30	35	1054	finally
    //   39	44	1054	finally
    //   48	54	1054	finally
    //   58	67	1054	finally
    //   71	79	1054	finally
    //   83	95	1054	finally
    //   99	107	1054	finally
    //   111	123	1054	finally
    //   127	135	1054	finally
    //   139	150	1054	finally
    //   154	173	1054	finally
    //   191	202	1054	finally
    //   206	217	1054	finally
    //   221	226	1054	finally
    //   237	246	1054	finally
    //   250	262	1054	finally
    //   266	274	1054	finally
    //   284	294	1054	finally
    //   303	314	1054	finally
    //   331	341	1054	finally
    //   345	354	1054	finally
    //   358	380	1054	finally
    //   384	394	1054	finally
    //   398	410	1054	finally
    //   414	421	1054	finally
    //   429	439	1054	finally
    //   443	454	1054	finally
    //   458	469	1054	finally
    //   473	481	1054	finally
    //   485	494	1054	finally
    //   498	520	1054	finally
    //   531	537	1054	finally
    //   541	555	1054	finally
    //   559	568	1054	finally
    //   572	585	1054	finally
    //   589	597	1054	finally
    //   601	609	1054	finally
    //   613	622	1054	finally
    //   626	638	1054	finally
    //   642	651	1054	finally
    //   655	664	1054	finally
    //   668	677	1054	finally
    //   681	690	1054	finally
    //   694	708	1054	finally
    //   712	726	1054	finally
    //   730	744	1054	finally
    //   748	762	1054	finally
    //   766	783	1054	finally
    //   787	806	1054	finally
    //   817	821	1054	finally
    //   825	830	1054	finally
    //   834	840	1054	finally
    //   844	853	1054	finally
    //   857	866	1054	finally
    //   870	881	1054	finally
    //   885	893	1054	finally
    //   897	909	1054	finally
    //   913	921	1054	finally
    //   925	932	1054	finally
    //   932	940	1054	finally
    //   943	962	1054	finally
    //   975	1023	1054	finally
    //   1061	1113	1054	finally
    //   8	13	1059	java/lang/Throwable
    //   30	35	1059	java/lang/Throwable
    //   39	44	1059	java/lang/Throwable
    //   48	54	1059	java/lang/Throwable
    //   58	67	1059	java/lang/Throwable
    //   71	79	1059	java/lang/Throwable
    //   83	95	1059	java/lang/Throwable
    //   99	107	1059	java/lang/Throwable
    //   111	123	1059	java/lang/Throwable
    //   127	135	1059	java/lang/Throwable
    //   139	150	1059	java/lang/Throwable
    //   154	173	1059	java/lang/Throwable
    //   191	202	1059	java/lang/Throwable
    //   206	217	1059	java/lang/Throwable
    //   221	226	1059	java/lang/Throwable
    //   237	246	1059	java/lang/Throwable
    //   250	262	1059	java/lang/Throwable
    //   266	274	1059	java/lang/Throwable
    //   284	294	1059	java/lang/Throwable
    //   303	314	1059	java/lang/Throwable
    //   331	341	1059	java/lang/Throwable
    //   345	354	1059	java/lang/Throwable
    //   358	380	1059	java/lang/Throwable
    //   384	394	1059	java/lang/Throwable
    //   398	410	1059	java/lang/Throwable
    //   414	421	1059	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.memory.MemoryManager.AlertMemoryRunner
 * JD-Core Version:    0.7.0.1
 */