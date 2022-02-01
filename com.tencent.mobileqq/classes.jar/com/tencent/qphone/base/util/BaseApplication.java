package com.tencent.qphone.base.util;

import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseApplication
  extends ApplicationDelegate
{
  public static final String DATA_KEY_CHANNEL_ID = "channel_id";
  public static int appnewavmsgicon;
  public static int appnewmsgicon = 0;
  public static String buildNum;
  public static BaseApplication context;
  public static int defaultNotifSoundResourceId;
  public static int devlockQuickloginIcon;
  public static ArrayList exclusiveStreamList;
  public static int gMsfReceiverStarted;
  public static boolean httpMonitorBan = false;
  public static MonitorSocketStat monitor;
  public static boolean monitorBan;
  public static NetworkMonitorCallback networkMonitorCallback;
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
  public static String reportVersionName;
  private MSFInterfaceAdapter mMSFInterfaceAdapter = new MSFInterfaceAdapter();
  
  static
  {
    appnewavmsgicon = 0;
    qqlaunchicon = 0;
    qqWifiLayout = 0;
    qqWifiStateIconViewId = 0;
    qqWifiStateTextViewId = 0;
    qqWifiOperationTextViewId = 0;
    qqWifiTextDoubleLine = 0;
    qqWifiStateTextSingleLine = 0;
    qqWifiSettingViewId = 0;
    qqWifiRedTouchViewId = 0;
    qqWifiConnecticon3 = 0;
    qqWifiNoSignal = 0;
    qqWifiUserful = 0;
    qqWifiMissions = 0;
    qqWifiSettings = 0;
    qqWifiOperation = 0;
    qqwifinotifyusefulicon = 0;
    qqwifinotifynoneicon = 0;
    qqwifinotifyconnectedicon = 0;
    qqwifinotifydivide = 0;
    defaultNotifSoundResourceId = 0;
    devlockQuickloginIcon = 0;
    networkMonitorCallback = null;
    exclusiveStreamList = new ArrayList();
    gMsfReceiverStarted = 0;
    buildNum = "";
    reportVersionName = "";
    monitorBan = false;
  }
  
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
  
  public boolean doesHasPhonePermission()
  {
    return false;
  }
  
  public boolean doesHasSDCardPermission()
  {
    return false;
  }
  
  public abstract Object getAppData(String paramString);
  
  public abstract int getAppId();
  
  public abstract String getChannelId();
  
  public MSFInterfaceAdapter getMSFInterfaceAdapter()
  {
    return this.mMSFInterfaceAdapter;
  }
  
  public List getRegisterBeaconTunnel()
  {
    return new ArrayList();
  }
  
  public int getThirdPushType()
  {
    return 0;
  }
  
  public boolean isMultiChannelReportEnable()
  {
    return true;
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 158	com/tencent/mobileqq/qfix/ApplicationDelegate:onCreate	()V
    //   4: aload_0
    //   5: putstatic 135	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: new 160	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat
    //   11: dup
    //   12: invokespecial 161	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:<init>	()V
    //   15: putstatic 163	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   18: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: new 171	java/io/File
    //   25: dup
    //   26: new 173	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   33: getstatic 135	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: invokevirtual 178	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 181	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 187
    //   47: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 192	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +10 -> 68
    //   61: aload_3
    //   62: invokevirtual 195	java/io/File:exists	()Z
    //   65: ifne +121 -> 186
    //   68: ldc 197
    //   70: iconst_1
    //   71: ldc 199
    //   73: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_3
    //   78: aconst_null
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 7
    //   84: aload 7
    //   86: ifnonnull +313 -> 399
    //   89: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +11 -> 103
    //   95: ldc 197
    //   97: iconst_2
    //   98: ldc 210
    //   100: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +48 -> 154
    //   109: ldc 197
    //   111: iconst_2
    //   112: new 173	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   119: ldc 212
    //   121: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: getstatic 214	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   127: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 216
    //   132: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 169	java/lang/System:currentTimeMillis	()J
    //   138: lload_1
    //   139: lsub
    //   140: invokevirtual 219	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 221
    //   145: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: return
    //   155: astore_3
    //   156: ldc 197
    //   158: iconst_1
    //   159: new 173	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   166: ldc 110
    //   168: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_3
    //   172: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: goto -126 -> 57
    //   186: new 226	java/io/FileInputStream
    //   189: dup
    //   190: aload_3
    //   191: invokespecial 229	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   194: astore 8
    //   196: new 231	java/util/Properties
    //   199: dup
    //   200: invokespecial 232	java/util/Properties:<init>	()V
    //   203: astore_3
    //   204: aload_3
    //   205: aload 8
    //   207: invokevirtual 236	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   210: aload_3
    //   211: ldc 238
    //   213: invokevirtual 242	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 5
    //   218: aload_3
    //   219: ldc 244
    //   221: invokevirtual 242	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 7
    //   226: aload_3
    //   227: ldc 246
    //   229: invokevirtual 242	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 6
    //   234: aload_3
    //   235: ldc 248
    //   237: invokevirtual 242	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: aload_3
    //   243: ldc 250
    //   245: invokevirtual 242	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 8
    //   251: invokevirtual 253	java/io/FileInputStream:close	()V
    //   254: ldc 197
    //   256: iconst_1
    //   257: new 173	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   264: ldc 255
    //   266: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 7
    //   271: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc_w 257
    //   277: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 5
    //   282: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: ldc_w 259
    //   288: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: aload 6
    //   293: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: ldc_w 261
    //   299: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: aload 4
    //   304: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc_w 263
    //   310: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokestatic 268	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   316: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: ldc_w 270
    //   322: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: aload_3
    //   326: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 272
    //   332: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: getstatic 214	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   338: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: goto -263 -> 84
    //   350: astore 5
    //   352: aconst_null
    //   353: astore 4
    //   355: aconst_null
    //   356: astore 6
    //   358: aconst_null
    //   359: astore 8
    //   361: aconst_null
    //   362: astore 7
    //   364: aconst_null
    //   365: astore_3
    //   366: ldc 197
    //   368: iconst_1
    //   369: new 173	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   376: ldc 110
    //   378: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 5
    //   383: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: aload 8
    //   394: astore 5
    //   396: goto -142 -> 254
    //   399: getstatic 277	android/os/Build$VERSION:SDK_INT	I
    //   402: bipush 19
    //   404: if_icmplt +45 -> 449
    //   407: getstatic 282	android/os/Build:DISPLAY	Ljava/lang/String;
    //   410: invokevirtual 287	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   413: ldc_w 289
    //   416: invokevirtual 293	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   419: ifne +18 -> 437
    //   422: getstatic 282	android/os/Build:DISPLAY	Ljava/lang/String;
    //   425: invokevirtual 287	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   428: ldc_w 295
    //   431: invokevirtual 293	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   434: ifeq +15 -> 449
    //   437: ldc 197
    //   439: iconst_1
    //   440: ldc_w 297
    //   443: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: goto -343 -> 103
    //   449: aload 7
    //   451: getstatic 282	android/os/Build:DISPLAY	Ljava/lang/String;
    //   454: invokevirtual 287	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   457: invokevirtual 293	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   460: ifne +17 -> 477
    //   463: aload 5
    //   465: getstatic 300	android/os/Build:MODEL	Ljava/lang/String;
    //   468: invokevirtual 287	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   471: invokevirtual 293	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   474: ifeq +15 -> 489
    //   477: ldc 197
    //   479: iconst_1
    //   480: ldc_w 302
    //   483: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: goto -383 -> 103
    //   489: new 304	java/util/Random
    //   492: dup
    //   493: invokespecial 305	java/util/Random:<init>	()V
    //   496: bipush 100
    //   498: invokevirtual 309	java/util/Random:nextInt	(I)I
    //   501: iconst_2
    //   502: irem
    //   503: ifne +7 -> 510
    //   506: iconst_1
    //   507: putstatic 116	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   510: getstatic 116	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   513: ifne -410 -> 103
    //   516: new 129	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory
    //   519: dup
    //   520: invokespecial 310	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:<init>	()V
    //   523: astore 4
    //   525: aload 4
    //   527: invokestatic 312	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   530: invokevirtual 316	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:getMsfSocketImpl	(Landroid/content/Context;)Z
    //   533: iconst_1
    //   534: if_icmpne +50 -> 584
    //   537: aload 4
    //   539: invokestatic 322	java/net/Socket:setSocketImplFactory	(Ljava/net/SocketImplFactory;)V
    //   542: ldc 197
    //   544: iconst_1
    //   545: new 173	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   552: aload_3
    //   553: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: ldc_w 324
    //   559: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: goto -465 -> 103
    //   571: astore_3
    //   572: ldc 197
    //   574: iconst_1
    //   575: ldc_w 326
    //   578: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: goto -478 -> 103
    //   584: ldc 197
    //   586: iconst_1
    //   587: ldc_w 328
    //   590: invokestatic 205	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: goto -490 -> 103
    //   596: astore 9
    //   598: aconst_null
    //   599: astore 4
    //   601: aconst_null
    //   602: astore 6
    //   604: aconst_null
    //   605: astore 7
    //   607: aconst_null
    //   608: astore_3
    //   609: aload 5
    //   611: astore 8
    //   613: aload 9
    //   615: astore 5
    //   617: goto -251 -> 366
    //   620: astore 9
    //   622: aconst_null
    //   623: astore 4
    //   625: aconst_null
    //   626: astore 6
    //   628: aconst_null
    //   629: astore_3
    //   630: aload 5
    //   632: astore 8
    //   634: aload 9
    //   636: astore 5
    //   638: goto -272 -> 366
    //   641: astore 9
    //   643: aconst_null
    //   644: astore 4
    //   646: aconst_null
    //   647: astore_3
    //   648: aload 5
    //   650: astore 8
    //   652: aload 9
    //   654: astore 5
    //   656: goto -290 -> 366
    //   659: astore 9
    //   661: aconst_null
    //   662: astore_3
    //   663: aload 5
    //   665: astore 8
    //   667: aload 9
    //   669: astore 5
    //   671: goto -305 -> 366
    //   674: astore 9
    //   676: aload 5
    //   678: astore 8
    //   680: aload 9
    //   682: astore 5
    //   684: goto -318 -> 366
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	687	0	this	BaseApplication
    //   21	118	1	l	long
    //   56	22	3	localFile	java.io.File
    //   155	17	3	localException1	java.lang.Exception
    //   182	371	3	localObject1	Object
    //   571	1	3	localException2	java.lang.Exception
    //   608	55	3	localObject2	Object
    //   240	405	4	localObject3	Object
    //   79	202	5	str1	String
    //   350	32	5	localException3	java.lang.Exception
    //   394	289	5	localObject4	Object
    //   232	395	6	str2	String
    //   82	524	7	str3	String
    //   194	485	8	localObject5	Object
    //   596	18	9	localException4	java.lang.Exception
    //   620	15	9	localException5	java.lang.Exception
    //   641	12	9	localException6	java.lang.Exception
    //   659	9	9	localException7	java.lang.Exception
    //   674	7	9	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	57	155	java/lang/Exception
    //   186	218	350	java/lang/Exception
    //   537	568	571	java/lang/Exception
    //   218	226	596	java/lang/Exception
    //   226	234	620	java/lang/Exception
    //   234	242	641	java/lang/Exception
    //   242	249	659	java/lang/Exception
    //   249	254	674	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */