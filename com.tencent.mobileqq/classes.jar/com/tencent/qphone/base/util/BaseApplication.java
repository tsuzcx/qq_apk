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
  public static int appnewmsgicon;
  public static String buildNum;
  public static BaseApplication context;
  public static int defaultNotifSoundResourceId;
  public static int devlockQuickloginIcon;
  public static ArrayList exclusiveStreamList = new ArrayList();
  public static int gMsfReceiverStarted = 0;
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
    //   1: invokespecial 110	com/tencent/mobileqq/qfix/ApplicationDelegate:onCreate	()V
    //   4: aload_0
    //   5: putstatic 87	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: new 112	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat
    //   11: dup
    //   12: invokespecial 113	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:<init>	()V
    //   15: putstatic 115	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   18: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: aconst_null
    //   23: astore 9
    //   25: aconst_null
    //   26: astore 7
    //   28: aconst_null
    //   29: astore 4
    //   31: new 123	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   38: astore_3
    //   39: aload_3
    //   40: getstatic 87	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   43: invokevirtual 128	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   46: invokevirtual 133	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   49: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_3
    //   54: ldc 139
    //   56: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: new 130	java/io/File
    //   63: dup
    //   64: aload_3
    //   65: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore_3
    //   72: goto +41 -> 113
    //   75: astore_3
    //   76: new 123	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   83: astore 5
    //   85: aload 5
    //   87: ldc 62
    //   89: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: aload_3
    //   96: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 149
    //   102: iconst_1
    //   103: aload 5
    //   105: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aconst_null
    //   112: astore_3
    //   113: aload_3
    //   114: ifnull +336 -> 450
    //   117: aload_3
    //   118: invokevirtual 158	java/io/File:exists	()Z
    //   121: ifne +6 -> 127
    //   124: goto +326 -> 450
    //   127: new 160	java/io/FileInputStream
    //   130: dup
    //   131: aload_3
    //   132: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore 5
    //   137: new 165	java/util/Properties
    //   140: dup
    //   141: invokespecial 166	java/util/Properties:<init>	()V
    //   144: astore 10
    //   146: aload 10
    //   148: aload 5
    //   150: invokevirtual 170	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   153: aload 10
    //   155: ldc 172
    //   157: invokevirtual 176	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   160: astore 6
    //   162: aload 10
    //   164: ldc 178
    //   166: invokevirtual 176	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   169: astore 7
    //   171: aload 10
    //   173: ldc 180
    //   175: invokevirtual 176	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   178: astore 8
    //   180: aload 10
    //   182: ldc 182
    //   184: invokevirtual 176	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   187: astore 9
    //   189: aload 4
    //   191: astore_3
    //   192: aload 10
    //   194: ldc 184
    //   196: invokevirtual 176	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   199: astore 4
    //   201: aload 4
    //   203: astore_3
    //   204: aload 5
    //   206: invokevirtual 187	java/io/FileInputStream:close	()V
    //   209: aload 4
    //   211: astore 5
    //   213: aload 9
    //   215: astore_3
    //   216: goto +98 -> 314
    //   219: astore 4
    //   221: aload_3
    //   222: astore 5
    //   224: aload 9
    //   226: astore_3
    //   227: goto +26 -> 253
    //   230: astore 4
    //   232: aconst_null
    //   233: astore 5
    //   235: aload 5
    //   237: astore_3
    //   238: goto +15 -> 253
    //   241: astore 4
    //   243: aconst_null
    //   244: astore 5
    //   246: aload 5
    //   248: astore 8
    //   250: aload 8
    //   252: astore_3
    //   253: goto +25 -> 278
    //   256: astore 4
    //   258: goto +8 -> 266
    //   261: astore 4
    //   263: aconst_null
    //   264: astore 6
    //   266: aconst_null
    //   267: astore 8
    //   269: aconst_null
    //   270: astore 5
    //   272: aconst_null
    //   273: astore_3
    //   274: aload 9
    //   276: astore 7
    //   278: new 123	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   285: astore 9
    //   287: aload 9
    //   289: ldc 62
    //   291: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload 9
    //   297: aload 4
    //   299: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: pop
    //   303: ldc 149
    //   305: iconst_1
    //   306: aload 9
    //   308: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: new 123	java/lang/StringBuilder
    //   317: dup
    //   318: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   321: astore 4
    //   323: aload 4
    //   325: ldc 189
    //   327: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 4
    //   333: aload 7
    //   335: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 4
    //   341: ldc 191
    //   343: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 4
    //   349: aload 6
    //   351: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: aload 4
    //   357: ldc 193
    //   359: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 4
    //   365: aload 8
    //   367: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: pop
    //   371: aload 4
    //   373: ldc 195
    //   375: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 4
    //   381: aload_3
    //   382: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 4
    //   388: ldc 197
    //   390: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 4
    //   396: invokestatic 202	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   399: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 4
    //   405: ldc 204
    //   407: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload 4
    //   413: aload 5
    //   415: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 4
    //   421: ldc 206
    //   423: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 4
    //   429: getstatic 208	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   432: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: ldc 149
    //   438: iconst_1
    //   439: aload 4
    //   441: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: goto +18 -> 465
    //   450: ldc 149
    //   452: iconst_1
    //   453: ldc 210
    //   455: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   458: aconst_null
    //   459: astore 5
    //   461: aload 5
    //   463: astore 6
    //   465: aload 7
    //   467: ifnonnull +20 -> 487
    //   470: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   473: ifeq +211 -> 684
    //   476: ldc 149
    //   478: iconst_2
    //   479: ldc 215
    //   481: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: goto +200 -> 684
    //   487: getstatic 220	android/os/Build$VERSION:SDK_INT	I
    //   490: bipush 19
    //   492: if_icmplt +42 -> 534
    //   495: getstatic 225	android/os/Build:DISPLAY	Ljava/lang/String;
    //   498: invokevirtual 230	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   501: ldc 232
    //   503: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   506: ifne +17 -> 523
    //   509: getstatic 225	android/os/Build:DISPLAY	Ljava/lang/String;
    //   512: invokevirtual 230	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   515: ldc 238
    //   517: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   520: ifeq +14 -> 534
    //   523: ldc 149
    //   525: iconst_1
    //   526: ldc 240
    //   528: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: goto +153 -> 684
    //   534: aload 7
    //   536: getstatic 225	android/os/Build:DISPLAY	Ljava/lang/String;
    //   539: invokevirtual 230	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   542: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   545: ifne +130 -> 675
    //   548: aload 6
    //   550: getstatic 243	android/os/Build:MODEL	Ljava/lang/String;
    //   553: invokevirtual 230	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   556: invokevirtual 236	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   559: ifeq +6 -> 565
    //   562: goto +113 -> 675
    //   565: new 245	java/util/Random
    //   568: dup
    //   569: invokespecial 246	java/util/Random:<init>	()V
    //   572: bipush 100
    //   574: invokevirtual 250	java/util/Random:nextInt	(I)I
    //   577: iconst_2
    //   578: irem
    //   579: ifne +7 -> 586
    //   582: iconst_1
    //   583: putstatic 68	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   586: getstatic 68	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   589: ifne +95 -> 684
    //   592: new 81	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory
    //   595: dup
    //   596: invokespecial 251	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:<init>	()V
    //   599: astore_3
    //   600: aload_3
    //   601: invokestatic 253	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   604: invokevirtual 257	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:getMsfSocketImpl	(Landroid/content/Context;)Z
    //   607: iconst_1
    //   608: if_icmpne +55 -> 663
    //   611: aload_3
    //   612: invokestatic 263	java/net/Socket:setSocketImplFactory	(Ljava/net/SocketImplFactory;)V
    //   615: new 123	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   622: astore_3
    //   623: aload_3
    //   624: aload 5
    //   626: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_3
    //   631: ldc_w 265
    //   634: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: pop
    //   638: ldc 149
    //   640: iconst_1
    //   641: aload_3
    //   642: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: goto +36 -> 684
    //   651: ldc 149
    //   653: iconst_1
    //   654: ldc_w 267
    //   657: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   660: goto +24 -> 684
    //   663: ldc 149
    //   665: iconst_1
    //   666: ldc_w 269
    //   669: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: goto +12 -> 684
    //   675: ldc 149
    //   677: iconst_1
    //   678: ldc_w 271
    //   681: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   684: invokestatic 213	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +63 -> 750
    //   690: new 123	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   697: astore_3
    //   698: aload_3
    //   699: ldc_w 273
    //   702: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_3
    //   707: getstatic 208	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   710: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_3
    //   715: ldc_w 275
    //   718: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: aload_3
    //   723: invokestatic 121	java/lang/System:currentTimeMillis	()J
    //   726: lload_1
    //   727: lsub
    //   728: invokevirtual 278	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload_3
    //   733: ldc_w 280
    //   736: invokevirtual 137	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: ldc 149
    //   742: iconst_2
    //   743: aload_3
    //   744: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   747: invokestatic 155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   750: return
    //   751: astore_3
    //   752: goto -101 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	755	0	this	BaseApplication
    //   21	706	1	l	long
    //   38	34	3	localObject1	Object
    //   75	21	3	localException1	java.lang.Exception
    //   112	632	3	localObject2	Object
    //   751	1	3	localException2	java.lang.Exception
    //   29	181	4	str	String
    //   219	1	4	localException3	java.lang.Exception
    //   230	1	4	localException4	java.lang.Exception
    //   241	1	4	localException5	java.lang.Exception
    //   256	1	4	localException6	java.lang.Exception
    //   261	37	4	localException7	java.lang.Exception
    //   321	119	4	localStringBuilder	java.lang.StringBuilder
    //   83	542	5	localObject3	Object
    //   160	389	6	localObject4	Object
    //   26	509	7	localObject5	Object
    //   178	188	8	localObject6	Object
    //   23	284	9	localObject7	Object
    //   144	49	10	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   31	72	75	java/lang/Exception
    //   192	201	219	java/lang/Exception
    //   204	209	219	java/lang/Exception
    //   180	189	230	java/lang/Exception
    //   171	180	241	java/lang/Exception
    //   162	171	256	java/lang/Exception
    //   127	162	261	java/lang/Exception
    //   611	648	751	java/lang/Exception
  }
  
  public void startBeacon() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */