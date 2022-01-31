package com.tencent.qphone.base.util;

import com.tencent.mobileqq.monitor.NetworkMonitorCallback;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketImplFactory;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.qfix.ApplicationDelegate;
import java.util.ArrayList;

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
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 145	com/tencent/mobileqq/qfix/ApplicationDelegate:onCreate	()V
    //   4: aload_0
    //   5: putstatic 128	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   8: new 147	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat
    //   11: dup
    //   12: invokespecial 148	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat:<init>	()V
    //   15: putstatic 150	com/tencent/qphone/base/util/BaseApplication:monitor	Lcom/tencent/mobileqq/msf/sdk/utils/MonitorSocketStat;
    //   18: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   21: lstore_1
    //   22: new 158	java/io/File
    //   25: dup
    //   26: new 160	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   33: getstatic 128	com/tencent/qphone/base/util/BaseApplication:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   36: invokevirtual 165	com/tencent/qphone/base/util/BaseApplication:getFilesDir	()Ljava/io/File;
    //   39: invokevirtual 168	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   42: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: ldc 174
    //   47: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokespecial 179	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +10 -> 68
    //   61: aload_3
    //   62: invokevirtual 182	java/io/File:exists	()Z
    //   65: ifne +121 -> 186
    //   68: ldc 184
    //   70: iconst_1
    //   71: ldc 186
    //   73: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aconst_null
    //   77: astore_3
    //   78: aconst_null
    //   79: astore 5
    //   81: aconst_null
    //   82: astore 7
    //   84: aload 7
    //   86: ifnonnull +309 -> 395
    //   89: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq +11 -> 103
    //   95: ldc 184
    //   97: iconst_2
    //   98: ldc 197
    //   100: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +48 -> 154
    //   109: ldc 184
    //   111: iconst_2
    //   112: new 160	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   119: ldc 199
    //   121: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: getstatic 201	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   127: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 203
    //   132: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokestatic 156	java/lang/System:currentTimeMillis	()J
    //   138: lload_1
    //   139: lsub
    //   140: invokevirtual 206	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   143: ldc 208
    //   145: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: return
    //   155: astore_3
    //   156: ldc 184
    //   158: iconst_1
    //   159: new 160	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   166: ldc 108
    //   168: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_3
    //   172: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: aconst_null
    //   182: astore_3
    //   183: goto -126 -> 57
    //   186: new 213	java/io/FileInputStream
    //   189: dup
    //   190: aload_3
    //   191: invokespecial 216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   194: astore 8
    //   196: new 218	java/util/Properties
    //   199: dup
    //   200: invokespecial 219	java/util/Properties:<init>	()V
    //   203: astore_3
    //   204: aload_3
    //   205: aload 8
    //   207: invokevirtual 223	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   210: aload_3
    //   211: ldc 225
    //   213: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 5
    //   218: aload_3
    //   219: ldc 231
    //   221: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   224: astore 7
    //   226: aload_3
    //   227: ldc 233
    //   229: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   232: astore 6
    //   234: aload_3
    //   235: ldc 235
    //   237: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   240: astore 4
    //   242: aload_3
    //   243: ldc 237
    //   245: invokevirtual 229	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   248: astore_3
    //   249: aload 8
    //   251: invokevirtual 240	java/io/FileInputStream:close	()V
    //   254: ldc 184
    //   256: iconst_1
    //   257: new 160	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   264: ldc 242
    //   266: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload 7
    //   271: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 244
    //   276: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: aload 5
    //   281: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 246
    //   286: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 6
    //   291: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 248
    //   296: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload 4
    //   301: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 250
    //   306: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokestatic 255	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:getAppVersion	()Ljava/lang/String;
    //   312: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 257
    //   318: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_3
    //   322: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc_w 259
    //   328: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: getstatic 201	com/tencent/qphone/base/util/BaseApplication:processName	Ljava/lang/String;
    //   334: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: goto -259 -> 84
    //   346: astore 5
    //   348: aconst_null
    //   349: astore 4
    //   351: aconst_null
    //   352: astore 6
    //   354: aconst_null
    //   355: astore 8
    //   357: aconst_null
    //   358: astore 7
    //   360: aconst_null
    //   361: astore_3
    //   362: ldc 184
    //   364: iconst_1
    //   365: new 160	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   372: ldc 108
    //   374: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 5
    //   379: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   388: aload 8
    //   390: astore 5
    //   392: goto -138 -> 254
    //   395: getstatic 264	android/os/Build$VERSION:SDK_INT	I
    //   398: bipush 19
    //   400: if_icmplt +45 -> 445
    //   403: getstatic 269	android/os/Build:DISPLAY	Ljava/lang/String;
    //   406: invokevirtual 274	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   409: ldc_w 276
    //   412: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   415: ifne +18 -> 433
    //   418: getstatic 269	android/os/Build:DISPLAY	Ljava/lang/String;
    //   421: invokevirtual 274	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   424: ldc_w 282
    //   427: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   430: ifeq +15 -> 445
    //   433: ldc 184
    //   435: iconst_1
    //   436: ldc_w 284
    //   439: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: goto -339 -> 103
    //   445: aload 7
    //   447: getstatic 269	android/os/Build:DISPLAY	Ljava/lang/String;
    //   450: invokevirtual 274	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   453: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   456: ifne +17 -> 473
    //   459: aload 5
    //   461: getstatic 287	android/os/Build:MODEL	Ljava/lang/String;
    //   464: invokevirtual 274	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   467: invokevirtual 280	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   470: ifeq +15 -> 485
    //   473: ldc 184
    //   475: iconst_1
    //   476: ldc_w 289
    //   479: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: goto -379 -> 103
    //   485: new 291	java/util/Random
    //   488: dup
    //   489: invokespecial 292	java/util/Random:<init>	()V
    //   492: bipush 100
    //   494: invokevirtual 296	java/util/Random:nextInt	(I)I
    //   497: iconst_2
    //   498: irem
    //   499: ifne +7 -> 506
    //   502: iconst_1
    //   503: putstatic 114	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   506: getstatic 114	com/tencent/qphone/base/util/BaseApplication:monitorBan	Z
    //   509: ifne -406 -> 103
    //   512: new 122	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory
    //   515: dup
    //   516: invokespecial 297	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:<init>	()V
    //   519: astore 4
    //   521: aload 4
    //   523: invokestatic 299	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   526: invokevirtual 303	com/tencent/mobileqq/msf/sdk/utils/MonitorSocketImplFactory:getMsfSocketImpl	(Landroid/content/Context;)Z
    //   529: iconst_1
    //   530: if_icmpne +50 -> 580
    //   533: aload 4
    //   535: invokestatic 309	java/net/Socket:setSocketImplFactory	(Ljava/net/SocketImplFactory;)V
    //   538: ldc 184
    //   540: iconst_1
    //   541: new 160	java/lang/StringBuilder
    //   544: dup
    //   545: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   548: aload_3
    //   549: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 311
    //   555: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: goto -461 -> 103
    //   567: astore_3
    //   568: ldc 184
    //   570: iconst_1
    //   571: ldc_w 313
    //   574: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: goto -474 -> 103
    //   580: ldc 184
    //   582: iconst_1
    //   583: ldc_w 315
    //   586: invokestatic 192	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   589: goto -486 -> 103
    //   592: astore 9
    //   594: aconst_null
    //   595: astore 4
    //   597: aconst_null
    //   598: astore 6
    //   600: aconst_null
    //   601: astore 7
    //   603: aconst_null
    //   604: astore_3
    //   605: aload 5
    //   607: astore 8
    //   609: aload 9
    //   611: astore 5
    //   613: goto -251 -> 362
    //   616: astore 9
    //   618: aconst_null
    //   619: astore 4
    //   621: aconst_null
    //   622: astore 6
    //   624: aconst_null
    //   625: astore_3
    //   626: aload 5
    //   628: astore 8
    //   630: aload 9
    //   632: astore 5
    //   634: goto -272 -> 362
    //   637: astore 9
    //   639: aconst_null
    //   640: astore 4
    //   642: aconst_null
    //   643: astore_3
    //   644: aload 5
    //   646: astore 8
    //   648: aload 9
    //   650: astore 5
    //   652: goto -290 -> 362
    //   655: astore 9
    //   657: aconst_null
    //   658: astore_3
    //   659: aload 5
    //   661: astore 8
    //   663: aload 9
    //   665: astore 5
    //   667: goto -305 -> 362
    //   670: astore 9
    //   672: aload 5
    //   674: astore 8
    //   676: aload 9
    //   678: astore 5
    //   680: goto -318 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	BaseApplication
    //   21	118	1	l	long
    //   56	22	3	localFile	java.io.File
    //   155	17	3	localException1	java.lang.Exception
    //   182	367	3	localObject1	Object
    //   567	1	3	localException2	java.lang.Exception
    //   604	55	3	localObject2	Object
    //   240	401	4	localObject3	Object
    //   79	201	5	str1	String
    //   346	32	5	localException3	java.lang.Exception
    //   390	289	5	localObject4	Object
    //   232	391	6	str2	String
    //   82	520	7	str3	String
    //   194	481	8	localObject5	Object
    //   592	18	9	localException4	java.lang.Exception
    //   616	15	9	localException5	java.lang.Exception
    //   637	12	9	localException6	java.lang.Exception
    //   655	9	9	localException7	java.lang.Exception
    //   670	7	9	localException8	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   22	57	155	java/lang/Exception
    //   186	218	346	java/lang/Exception
    //   533	564	567	java/lang/Exception
    //   218	226	592	java/lang/Exception
    //   226	234	616	java/lang/Exception
    //   234	242	637	java/lang/Exception
    //   242	249	655	java/lang/Exception
    //   249	254	670	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.BaseApplication
 * JD-Core Version:    0.7.0.1
 */