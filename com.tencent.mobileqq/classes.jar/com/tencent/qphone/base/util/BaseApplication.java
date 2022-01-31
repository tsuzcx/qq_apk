package com.tencent.qphone.base.util;

import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import java.util.ArrayList;

public abstract class BaseApplication
  extends ApplicationDelegate
{
  public static int APP_ID = 0;
  public static final String DATA_KEY_CHANNEL_ID = "channel_id";
  public static int appnewavmsgicon;
  public static int appnewmsgicon;
  public static String buildNum = "";
  public static String channelId = "";
  public static BaseApplication context;
  public static int defaultNotifSoundResourceId;
  public static int devlockQuickloginIcon;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static int gMsfReceiverStarted;
  public static MonitorSocketStat monitor;
  public static boolean monitorBan;
  public static String processName;
  public static int qqWifiConnecticon3;
  public static int qqWifiLayout;
  public static int qqWifiMissions;
  public static int qqWifiNoSignal;
  public static int qqWifiOperation;
  public static int qqWifiOperationTextViewId;
  public static int qqWifiRedTouchViewId;
  public static int qqWifiSettingViewId;
  public static int qqWifiSettings;
  public static int qqWifiStateIconViewId;
  public static int qqWifiStateTextSingleLine;
  public static int qqWifiStateTextViewId;
  public static int qqWifiTextDoubleLine;
  public static int qqWifiUserful;
  public static int qqlaunchicon;
  public static int qqwifinotifyconnectedicon;
  public static int qqwifinotifydivide;
  public static int qqwifinotifynoneicon;
  public static int qqwifinotifyusefulicon;
  public static String reportVersionName = "";
  
  public static final void addServerSocket(String paramString)
  {
    MonitorSocketImplFactory.addServerSocket(paramString);
  }
  
  public static BaseApplication getContext()
  {
    return context;
  }
  
  public static final void removeServerSocket(String paramString)
  {
    MonitorSocketImplFactory.removeServerSocket(paramString);
  }
  
  public abstract Object getAppData(String paramString);
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 86	com/tencent/mobileqq/qfix/ApplicationDelegate:onCreate	()V
    //   4: aload_0
    //   5: putstatic 76	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: new 88	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat
    //   11: dup
    //   12: invokespecial 89	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:<init>	()V
    //   15: putstatic 91	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   18: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: new 99	java/io/File
    //   25: dup
    //   26: new 101	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   33: getstatic 76	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: invokevirtual 106	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 110	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 116
    //   47: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +10 -> 68
    //   61: aload_3
    //   62: invokevirtual 125	java/io/File:exists	()Z
    //   65: ifne +121 -> 186
    //   68: ldc 127
    //   70: iconst_1
    //   71: ldc 129
    //   73: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_3
    //   78: aconst_null
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 7
    //   84: aload 7
    //   86: ifnonnull +318 -> 404
    //   89: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +11 -> 103
    //   95: ldc 127
    //   97: iconst_2
    //   98: ldc 140
    //   100: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +48 -> 154
    //   109: ldc 127
    //   111: iconst_2
    //   112: new 101	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   119: ldc 142
    //   121: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: getstatic 144	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   127: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 146
    //   132: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 97	java/lang/System:currentTimeMillis	()J
    //   138: lload_1
    //   139: lsub
    //   140: invokevirtual 149	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 151
    //   145: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: return
    //   155: astore_3
    //   156: ldc 127
    //   158: iconst_1
    //   159: new 101	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   166: ldc 58
    //   168: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_3
    //   172: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: goto -126 -> 57
    //   186: new 156	java/io/FileInputStream
    //   189: dup
    //   190: aload_3
    //   191: invokespecial 159	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   194: astore 8
    //   196: new 161	java/util/Properties
    //   199: dup
    //   200: invokespecial 162	java/util/Properties:<init>	()V
    //   203: astore_3
    //   204: aload_3
    //   205: aload 8
    //   207: invokevirtual 166	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   210: aload_3
    //   211: ldc 168
    //   213: invokevirtual 172	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 5
    //   218: aload_3
    //   219: ldc 174
    //   221: invokevirtual 172	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 7
    //   226: aload_3
    //   227: ldc 176
    //   229: invokevirtual 172	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 6
    //   234: aload_3
    //   235: ldc 178
    //   237: invokevirtual 172	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: aload_3
    //   243: ldc 180
    //   245: invokevirtual 172	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 8
    //   251: invokevirtual 183	java/io/FileInputStream:close	()V
    //   254: ldc 127
    //   256: iconst_1
    //   257: new 101	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   264: ldc 185
    //   266: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 7
    //   271: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 187
    //   276: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 189
    //   286: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 6
    //   291: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 191
    //   296: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokestatic 196	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppid	()Ljava/lang/String;
    //   302: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 198
    //   307: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 4
    //   312: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 200
    //   317: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokestatic 203	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   323: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: ldc 205
    //   328: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_3
    //   332: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc 207
    //   337: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: getstatic 144	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   343: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   352: goto -268 -> 84
    //   355: astore 5
    //   357: aconst_null
    //   358: astore 4
    //   360: aconst_null
    //   361: astore 6
    //   363: aconst_null
    //   364: astore 8
    //   366: aconst_null
    //   367: astore 7
    //   369: aconst_null
    //   370: astore_3
    //   371: ldc 127
    //   373: iconst_1
    //   374: new 101	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   381: ldc 58
    //   383: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload 5
    //   388: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload 8
    //   399: astore 5
    //   401: goto -147 -> 254
    //   404: getstatic 212	android/os/Build$VERSION:SDK_INT	I
    //   407: bipush 19
    //   409: if_icmplt +42 -> 451
    //   412: getstatic 217	android/os/Build:DISPLAY	Ljava/lang/String;
    //   415: invokevirtual 222	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   418: ldc 224
    //   420: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   423: ifne +17 -> 440
    //   426: getstatic 217	android/os/Build:DISPLAY	Ljava/lang/String;
    //   429: invokevirtual 222	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   432: ldc 230
    //   434: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   437: ifeq +14 -> 451
    //   440: ldc 127
    //   442: iconst_1
    //   443: ldc 232
    //   445: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: goto -345 -> 103
    //   451: aload 7
    //   453: getstatic 217	android/os/Build:DISPLAY	Ljava/lang/String;
    //   456: invokevirtual 222	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   459: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   462: ifne +17 -> 479
    //   465: aload 5
    //   467: getstatic 235	android/os/Build:MODEL	Ljava/lang/String;
    //   470: invokevirtual 222	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   473: invokevirtual 228	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   476: ifeq +14 -> 490
    //   479: ldc 127
    //   481: iconst_1
    //   482: ldc 237
    //   484: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: goto -384 -> 103
    //   490: new 239	java/util/Random
    //   493: dup
    //   494: invokespecial 240	java/util/Random:<init>	()V
    //   497: bipush 100
    //   499: invokevirtual 244	java/util/Random:nextInt	(I)I
    //   502: iconst_2
    //   503: irem
    //   504: ifne +7 -> 511
    //   507: iconst_1
    //   508: putstatic 246	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   511: getstatic 246	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   514: ifne -411 -> 103
    //   517: new 70	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory
    //   520: dup
    //   521: invokespecial 247	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:<init>	()V
    //   524: astore 4
    //   526: aload 4
    //   528: invokestatic 249	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   531: invokevirtual 253	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:getMsfSocketImpl	(Landroid/content/Context;)Z
    //   534: iconst_1
    //   535: if_icmpne +50 -> 585
    //   538: aload 4
    //   540: invokestatic 259	java/net/Socket:setSocketImplFactory	(Ljava/net/SocketImplFactory;)V
    //   543: ldc 127
    //   545: iconst_1
    //   546: new 101	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   553: aload_3
    //   554: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 261
    //   560: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: goto -466 -> 103
    //   572: astore_3
    //   573: ldc 127
    //   575: iconst_1
    //   576: ldc_w 263
    //   579: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: goto -479 -> 103
    //   585: ldc 127
    //   587: iconst_1
    //   588: ldc_w 265
    //   591: invokestatic 135	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: goto -491 -> 103
    //   597: astore 9
    //   599: aconst_null
    //   600: astore 4
    //   602: aconst_null
    //   603: astore 6
    //   605: aconst_null
    //   606: astore 7
    //   608: aconst_null
    //   609: astore_3
    //   610: aload 5
    //   612: astore 8
    //   614: aload 9
    //   616: astore 5
    //   618: goto -247 -> 371
    //   621: astore 9
    //   623: aconst_null
    //   624: astore 4
    //   626: aconst_null
    //   627: astore 6
    //   629: aconst_null
    //   630: astore_3
    //   631: aload 5
    //   633: astore 8
    //   635: aload 9
    //   637: astore 5
    //   639: goto -268 -> 371
    //   642: astore 9
    //   644: aconst_null
    //   645: astore 4
    //   647: aconst_null
    //   648: astore_3
    //   649: aload 5
    //   651: astore 8
    //   653: aload 9
    //   655: astore 5
    //   657: goto -286 -> 371
    //   660: astore 9
    //   662: aconst_null
    //   663: astore_3
    //   664: aload 5
    //   666: astore 8
    //   668: aload 9
    //   670: astore 5
    //   672: goto -301 -> 371
    //   675: astore 9
    //   677: aload 5
    //   679: astore 8
    //   681: aload 9
    //   683: astore 5
    //   685: goto -314 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	BaseApplication
    //   21	118	1	l	long
    //   56	22	3	localFile	java.io.File
    //   155	17	3	localException1	java.lang.Exception
    //   182	372	3	localObject1	Object
    //   572	1	3	localException2	java.lang.Exception
    //   609	55	3	localObject2	Object
    //   240	406	4	localObject3	Object
    //   79	201	5	str1	String
    //   355	32	5	localException3	java.lang.Exception
    //   399	285	5	localObject4	Object
    //   232	396	6	str2	String
    //   82	525	7	str3	String
    //   194	486	8	localObject5	Object
    //   597	18	9	localException4	java.lang.Exception
    //   621	15	9	localException5	java.lang.Exception
    //   642	12	9	localException6	java.lang.Exception
    //   660	9	9	localException7	java.lang.Exception
    //   675	7	9	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	57	155	java/lang/Exception
    //   186	218	355	java/lang/Exception
    //   538	569	572	java/lang/Exception
    //   218	226	597	java/lang/Exception
    //   226	234	621	java/lang/Exception
    //   234	242	642	java/lang/Exception
    //   242	249	660	java/lang/Exception
    //   249	254	675	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */