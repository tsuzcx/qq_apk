package cooperation.qzone.sim;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class DeviceInfoUtil
{
  public static final int BUFFER_SIZE = 1024;
  public static final String TAG = "UniKingCardHelper/DeviceInfoUtil";
  private static final String TOP_COMMADN_CPU_PROCESS = "top -n 1 -m 10";
  private static final String TOP_COMMADN_CPU_THREAD = "top -n 1 -m 10 -t";
  private static String appVersionWithCode;
  private static String channelName;
  public static float density = 1.0F;
  public static int densityDpi = 0;
  private static String deviceId = "";
  private static String imsi = null;
  private static String localMacAddress;
  private static boolean mRegisterHandler = false;
  private static int orientation;
  private static long screenHeight;
  private static long screenWidth = 0L;
  
  static
  {
    screenHeight = 0L;
    orientation = 0;
  }
  
  public static String getAppMetaValue(Context paramContext, String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = paramContext.getPackageName();
      str = paramContext.getPackageManager().getApplicationInfo(str, 128).metaData.getString(paramString, "");
      return str;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext) {}
    return "getVersionException";
  }
  
  public static String getAppVersionWithCode(Context paramContext)
  {
    if (!TextUtils.isEmpty(appVersionWithCode)) {
      return appVersionWithCode;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      if (paramContext != null)
      {
        appVersionWithCode = paramContext.versionName + "." + paramContext.versionCode;
        paramContext = appVersionWithCode;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return appVersionWithCode;
  }
  
  /* Error */
  public static long getCpuFrequency()
  {
    // Byte code:
    //   0: new 136	java/io/FileReader
    //   3: dup
    //   4: ldc 138
    //   6: invokespecial 141	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore 6
    //   11: aload 6
    //   13: astore 4
    //   15: new 143	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 1024
    //   24: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 5
    //   29: aload 6
    //   31: astore 4
    //   33: aload 5
    //   35: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 7
    //   40: aload 7
    //   42: ifnull +135 -> 177
    //   45: aload 6
    //   47: astore 4
    //   49: aload 7
    //   51: invokestatic 155	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   54: ldc2_w 156
    //   57: ldiv
    //   58: lstore_0
    //   59: aload 6
    //   61: astore 4
    //   63: aload 5
    //   65: invokevirtual 160	java/io/BufferedReader:close	()V
    //   68: lload_0
    //   69: lstore_2
    //   70: aload 6
    //   72: ifnull +10 -> 82
    //   75: aload 6
    //   77: invokevirtual 161	java/io/FileReader:close	()V
    //   80: lload_0
    //   81: lstore_2
    //   82: lload_2
    //   83: lreturn
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   91: lload_0
    //   92: lreturn
    //   93: astore 5
    //   95: aconst_null
    //   96: astore 6
    //   98: lconst_0
    //   99: lstore_0
    //   100: aload 6
    //   102: astore 4
    //   104: aload 5
    //   106: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   109: lload_0
    //   110: lstore_2
    //   111: aload 6
    //   113: ifnull -31 -> 82
    //   116: aload 6
    //   118: invokevirtual 161	java/io/FileReader:close	()V
    //   121: lload_0
    //   122: lreturn
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   130: lload_0
    //   131: lreturn
    //   132: astore 5
    //   134: aconst_null
    //   135: astore 4
    //   137: aload 4
    //   139: ifnull +8 -> 147
    //   142: aload 4
    //   144: invokevirtual 161	java/io/FileReader:close	()V
    //   147: aload 5
    //   149: athrow
    //   150: astore 4
    //   152: aload 4
    //   154: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   157: goto -10 -> 147
    //   160: astore 5
    //   162: goto -25 -> 137
    //   165: astore 5
    //   167: lconst_0
    //   168: lstore_0
    //   169: goto -69 -> 100
    //   172: astore 5
    //   174: goto -74 -> 100
    //   177: lconst_0
    //   178: lstore_0
    //   179: goto -120 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   58	121	0	l1	long
    //   69	42	2	l2	long
    //   13	49	4	localFileReader1	java.io.FileReader
    //   84	3	4	localException1	Exception
    //   102	1	4	localFileReader2	java.io.FileReader
    //   123	3	4	localException2	Exception
    //   135	8	4	localObject1	Object
    //   150	3	4	localException3	Exception
    //   27	37	5	localBufferedReader	java.io.BufferedReader
    //   93	12	5	localException4	Exception
    //   132	16	5	localObject2	Object
    //   160	1	5	localObject3	Object
    //   165	1	5	localException5	Exception
    //   172	1	5	localException6	Exception
    //   9	108	6	localFileReader3	java.io.FileReader
    //   38	12	7	str	String
    // Exception table:
    //   from	to	target	type
    //   75	80	84	java/lang/Exception
    //   0	11	93	java/lang/Exception
    //   116	121	123	java/lang/Exception
    //   0	11	132	finally
    //   142	147	150	java/lang/Exception
    //   15	29	160	finally
    //   33	40	160	finally
    //   49	59	160	finally
    //   63	68	160	finally
    //   104	109	160	finally
    //   15	29	165	java/lang/Exception
    //   33	40	165	java/lang/Exception
    //   49	59	165	java/lang/Exception
    //   63	68	172	java/lang/Exception
  }
  
  public static int getCpuNumber()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new DeviceInfoUtil.1CpuFilter()).length;
      return i;
    }
    catch (Exception localException) {}
    return 1;
  }
  
  /* Error */
  public static String getCpuType()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 136	java/io/FileReader
    //   6: dup
    //   7: ldc 178
    //   9: invokespecial 141	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_0
    //   13: new 143	java/io/BufferedReader
    //   16: dup
    //   17: aload_0
    //   18: sipush 8192
    //   21: invokespecial 146	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   24: astore_2
    //   25: ldc 180
    //   27: astore 4
    //   29: ldc 180
    //   31: astore_1
    //   32: ldc 180
    //   34: astore_3
    //   35: ldc 180
    //   37: astore 6
    //   39: ldc 35
    //   41: astore 5
    //   43: aload 5
    //   45: ifnull +14 -> 59
    //   48: aload_2
    //   49: invokevirtual 149	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 10
    //   54: aload 10
    //   56: ifnonnull +83 -> 139
    //   59: new 116	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   66: aload 6
    //   68: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: ldc 182
    //   73: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload_3
    //   77: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 182
    //   82: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_1
    //   86: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 182
    //   91: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload 4
    //   96: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: astore_1
    //   103: aload_2
    //   104: invokevirtual 160	java/io/BufferedReader:close	()V
    //   107: aload_0
    //   108: invokevirtual 161	java/io/FileReader:close	()V
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 184	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: aload_1
    //   124: astore_0
    //   125: iconst_0
    //   126: ifeq +11 -> 137
    //   129: new 184	java/lang/NullPointerException
    //   132: dup
    //   133: invokespecial 185	java/lang/NullPointerException:<init>	()V
    //   136: athrow
    //   137: aload_0
    //   138: areturn
    //   139: aload 10
    //   141: ldc 187
    //   143: invokevirtual 193	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   146: astore 11
    //   148: aload 10
    //   150: astore 5
    //   152: aload 11
    //   154: ifnull -111 -> 43
    //   157: aload 10
    //   159: astore 5
    //   161: aload 11
    //   163: arraylength
    //   164: iconst_3
    //   165: if_icmplt -122 -> 43
    //   168: aload 11
    //   170: iconst_0
    //   171: aaload
    //   172: invokevirtual 196	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   175: astore 5
    //   177: aload 6
    //   179: astore 7
    //   181: aload 5
    //   183: ldc 198
    //   185: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +39 -> 227
    //   191: new 116	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   198: aload 6
    //   200: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 11
    //   205: iconst_2
    //   206: aload 11
    //   208: arraylength
    //   209: invokestatic 205	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   212: ldc 207
    //   214: ldc 209
    //   216: invokevirtual 212	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   219: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: astore 7
    //   227: aload_3
    //   228: astore 8
    //   230: aload 5
    //   232: ldc 214
    //   234: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   237: ifeq +21 -> 258
    //   240: aload 11
    //   242: iconst_2
    //   243: aload 11
    //   245: arraylength
    //   246: invokestatic 205	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   249: ldc 207
    //   251: ldc 209
    //   253: invokevirtual 212	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   256: astore 8
    //   258: aload_1
    //   259: astore 9
    //   261: aload 5
    //   263: ldc 216
    //   265: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   268: ifeq +21 -> 289
    //   271: aload 11
    //   273: iconst_2
    //   274: aload 11
    //   276: arraylength
    //   277: invokestatic 205	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   280: ldc 207
    //   282: ldc 209
    //   284: invokevirtual 212	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   287: astore 9
    //   289: aload 9
    //   291: astore_1
    //   292: aload 8
    //   294: astore_3
    //   295: aload 7
    //   297: astore 6
    //   299: aload 10
    //   301: astore 5
    //   303: aload 11
    //   305: iconst_1
    //   306: aaload
    //   307: invokevirtual 196	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   310: ldc 218
    //   312: invokevirtual 201	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   315: ifeq -272 -> 43
    //   318: aload 11
    //   320: aload 11
    //   322: arraylength
    //   323: iconst_1
    //   324: isub
    //   325: aaload
    //   326: astore 4
    //   328: aload 9
    //   330: astore_1
    //   331: aload 8
    //   333: astore_3
    //   334: aload 7
    //   336: astore 6
    //   338: aload 10
    //   340: astore 5
    //   342: goto -299 -> 43
    //   345: astore_3
    //   346: aconst_null
    //   347: astore_2
    //   348: ldc 35
    //   350: astore_1
    //   351: aload 4
    //   353: astore_0
    //   354: aload_3
    //   355: invokevirtual 98	java/lang/Exception:printStackTrace	()V
    //   358: aload_0
    //   359: ifnull +7 -> 366
    //   362: aload_0
    //   363: invokevirtual 161	java/io/FileReader:close	()V
    //   366: aload_1
    //   367: astore_0
    //   368: aload_2
    //   369: ifnull -232 -> 137
    //   372: aload_2
    //   373: invokevirtual 160	java/io/BufferedReader:close	()V
    //   376: aload_1
    //   377: areturn
    //   378: astore_0
    //   379: aload_1
    //   380: areturn
    //   381: astore_1
    //   382: aconst_null
    //   383: astore_2
    //   384: aconst_null
    //   385: astore_0
    //   386: aload_0
    //   387: ifnull +7 -> 394
    //   390: aload_0
    //   391: invokevirtual 161	java/io/FileReader:close	()V
    //   394: aload_2
    //   395: ifnull +7 -> 402
    //   398: aload_2
    //   399: invokevirtual 160	java/io/BufferedReader:close	()V
    //   402: aload_1
    //   403: athrow
    //   404: astore_0
    //   405: goto -282 -> 123
    //   408: astore_0
    //   409: aload_1
    //   410: areturn
    //   411: astore_0
    //   412: goto -46 -> 366
    //   415: astore_0
    //   416: goto -22 -> 394
    //   419: astore_0
    //   420: goto -18 -> 402
    //   423: astore_1
    //   424: aconst_null
    //   425: astore_2
    //   426: goto -40 -> 386
    //   429: astore_1
    //   430: goto -44 -> 386
    //   433: astore_1
    //   434: goto -48 -> 386
    //   437: astore_3
    //   438: aconst_null
    //   439: astore_2
    //   440: ldc 35
    //   442: astore_1
    //   443: goto -89 -> 354
    //   446: astore_3
    //   447: ldc 35
    //   449: astore_1
    //   450: goto -96 -> 354
    //   453: astore_3
    //   454: goto -100 -> 354
    //   457: astore_3
    //   458: aconst_null
    //   459: astore_2
    //   460: goto -106 -> 354
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	356	0	localObject1	Object
    //   378	1	0	localException1	Exception
    //   385	6	0	localObject2	Object
    //   404	1	0	localException2	Exception
    //   408	1	0	localException3	Exception
    //   411	1	0	localException4	Exception
    //   415	1	0	localException5	Exception
    //   419	1	0	localException6	Exception
    //   31	349	1	localObject3	Object
    //   381	29	1	str1	String
    //   423	1	1	localObject4	Object
    //   429	1	1	localObject5	Object
    //   433	1	1	localObject6	Object
    //   442	8	1	str2	String
    //   24	436	2	localBufferedReader	java.io.BufferedReader
    //   34	300	3	localObject7	Object
    //   345	10	3	localException7	Exception
    //   437	1	3	localException8	Exception
    //   446	1	3	localException9	Exception
    //   453	1	3	localException10	Exception
    //   457	1	3	localException11	Exception
    //   1	351	4	str3	String
    //   41	300	5	localObject8	Object
    //   37	300	6	localObject9	Object
    //   179	156	7	localObject10	Object
    //   228	104	8	localObject11	Object
    //   259	70	9	localObject12	Object
    //   52	287	10	str4	String
    //   146	175	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   3	13	345	java/lang/Exception
    //   372	376	378	java/lang/Exception
    //   3	13	381	finally
    //   115	123	404	java/lang/Exception
    //   129	137	408	java/lang/Exception
    //   362	366	411	java/lang/Exception
    //   390	394	415	java/lang/Exception
    //   398	402	419	java/lang/Exception
    //   13	25	423	finally
    //   107	111	423	finally
    //   48	54	429	finally
    //   59	103	429	finally
    //   103	107	429	finally
    //   139	148	429	finally
    //   161	177	429	finally
    //   181	227	429	finally
    //   230	258	429	finally
    //   261	289	429	finally
    //   303	328	429	finally
    //   354	358	433	finally
    //   13	25	437	java/lang/Exception
    //   48	54	446	java/lang/Exception
    //   59	103	446	java/lang/Exception
    //   139	148	446	java/lang/Exception
    //   161	177	446	java/lang/Exception
    //   181	227	446	java/lang/Exception
    //   230	258	446	java/lang/Exception
    //   261	289	446	java/lang/Exception
    //   303	328	446	java/lang/Exception
    //   103	107	453	java/lang/Exception
    //   107	111	457	java/lang/Exception
  }
  
  public static SimInfo getDataSimInfo(Context paramContext)
  {
    SimManager localSimManager = SimManager.getInstance(Build.MODEL, Build.VERSION.SDK_INT);
    localSimManager.initAllInfo(paramContext);
    return localSimManager.getDataSimInfo();
  }
  
  public static String getDeviceBrand()
  {
    String str2 = Build.BRAND;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getDeviceModel()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getDeviceOSVersion()
  {
    String str2 = Build.VERSION.RELEASE;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static String getIMEI(Context paramContext)
  {
    if ((deviceId != null) && (deviceId.length() > 0)) {
      return deviceId;
    }
    deviceId = PlatformInfor.g().getIMEI();
    if (deviceId == null) {
      deviceId = "";
    }
    return deviceId;
  }
  
  /* Error */
  public static String getIMSI(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 51	cooperation/qzone/sim/DeviceInfoUtil:mRegisterHandler	Z
    //   3: ifne +17 -> 20
    //   6: new 269	cooperation/qzone/sim/DeviceInfoUtil$1
    //   9: dup
    //   10: invokespecial 270	cooperation/qzone/sim/DeviceInfoUtil$1:<init>	()V
    //   13: invokestatic 276	cooperation/qzone/util/NetworkState:addListener	(Lcooperation/qzone/util/NetworkState$NetworkStateListener;)V
    //   16: iconst_1
    //   17: putstatic 51	cooperation/qzone/sim/DeviceInfoUtil:mRegisterHandler	Z
    //   20: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   23: ifnull +7 -> 30
    //   26: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   29: areturn
    //   30: aload_0
    //   31: ldc_w 278
    //   34: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 284	android/telephony/TelephonyManager
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 287	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   45: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   48: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   51: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +10 -> 64
    //   57: aload_2
    //   58: invokevirtual 290	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   61: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 292	java/lang/Class
    //   68: astore 4
    //   70: aload 4
    //   72: iconst_0
    //   73: getstatic 298	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   76: aastore
    //   77: new 294	java/lang/Integer
    //   80: dup
    //   81: iconst_1
    //   82: invokespecial 301	java/lang/Integer:<init>	(I)V
    //   85: astore_3
    //   86: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   89: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +43 -> 137
    //   97: aload_2
    //   98: invokevirtual 305	java/lang/Object:getClass	()Ljava/lang/Class;
    //   101: ldc_w 307
    //   104: aload 4
    //   106: invokevirtual 311	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   109: astore 5
    //   111: aload 5
    //   113: iconst_1
    //   114: invokevirtual 317	java/lang/reflect/Method:setAccessible	(Z)V
    //   117: aload 5
    //   119: aload_2
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_3
    //   127: aastore
    //   128: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 189	java/lang/String
    //   134: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   137: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   140: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: istore_1
    //   144: iload_1
    //   145: ifeq +72 -> 217
    //   148: ldc_w 323
    //   151: invokestatic 327	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 5
    //   156: aload_0
    //   157: aload 5
    //   159: ldc_w 329
    //   162: iconst_2
    //   163: anewarray 292	java/lang/Class
    //   166: dup
    //   167: iconst_0
    //   168: ldc 189
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: getstatic 298	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   176: aastore
    //   177: invokevirtual 332	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   180: aload 5
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: ldc_w 278
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: iconst_1
    //   195: invokestatic 336	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 189	java/lang/String
    //   205: invokevirtual 282	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   208: checkcast 284	android/telephony/TelephonyManager
    //   211: invokevirtual 287	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   214: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   217: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   220: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: istore_1
    //   224: iload_1
    //   225: ifeq +40 -> 265
    //   228: aload_2
    //   229: invokevirtual 305	java/lang/Object:getClass	()Ljava/lang/Class;
    //   232: ldc_w 338
    //   235: aload 4
    //   237: invokevirtual 311	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   240: astore_0
    //   241: aload_0
    //   242: iconst_1
    //   243: invokevirtual 317	java/lang/reflect/Method:setAccessible	(Z)V
    //   246: aload_0
    //   247: aload_2
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_3
    //   255: aastore
    //   256: invokevirtual 321	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 189	java/lang/String
    //   262: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   265: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   268: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifeq +8 -> 279
    //   274: ldc 35
    //   276: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   279: getstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   282: areturn
    //   283: astore 5
    //   285: aload 5
    //   287: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   290: ldc 11
    //   292: new 116	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 341
    //   302: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 5
    //   307: invokevirtual 344	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 350	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: ldc 35
    //   321: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   324: goto -187 -> 137
    //   327: astore_0
    //   328: ldc 35
    //   330: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   333: ldc 35
    //   335: areturn
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   341: ldc 11
    //   343: new 116	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 352
    //   353: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: invokevirtual 344	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 350	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: ldc 35
    //   371: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   374: goto -157 -> 217
    //   377: astore_0
    //   378: ldc 11
    //   380: new 116	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 117	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 354
    //   390: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: invokevirtual 344	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 350	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: invokevirtual 339	java/lang/Throwable:printStackTrace	()V
    //   410: ldc 35
    //   412: putstatic 39	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   415: goto -150 -> 265
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramContext	Context
    //   92	133	1	bool	boolean
    //   40	208	2	localTelephonyManager	android.telephony.TelephonyManager
    //   85	170	3	localInteger	java.lang.Integer
    //   68	168	4	arrayOfClass	java.lang.Class[]
    //   109	72	5	localObject	Object
    //   283	23	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   97	137	283	java/lang/Throwable
    //   30	64	327	java/lang/Throwable
    //   64	93	327	java/lang/Throwable
    //   137	144	327	java/lang/Throwable
    //   217	224	327	java/lang/Throwable
    //   265	279	327	java/lang/Throwable
    //   279	283	327	java/lang/Throwable
    //   285	324	327	java/lang/Throwable
    //   337	374	327	java/lang/Throwable
    //   378	415	327	java/lang/Throwable
    //   148	217	336	java/lang/Throwable
    //   228	265	377	java/lang/Throwable
  }
  
  public static int getOsVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String getPhoneNum(Context paramContext)
  {
    return "";
  }
  
  public static String getProcessName(Context paramContext)
  {
    int i = Process.myPid();
    if (paramContext != null) {
      try
      {
        paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (localRunningAppProcessInfo.pid == i)
            {
              paramContext = localRunningAppProcessInfo.processName;
              return paramContext;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        QZLog.e("UniKingCardHelper/DeviceInfoUtil", "exception happened!" + paramContext.getMessage());
        return "";
      }
    }
    return "";
  }
  
  public static int getVersionCode(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      QZLog.e("AppSetting", "getVersionCode error:" + paramContext.getMessage());
    }
    return 0;
  }
  
  public static int getVersionCode(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramString, 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      QZLog.e("AppSetting", "getVersionCode error:" + paramContext.getMessage());
    }
    return 0;
  }
  
  private static String subStrings2String(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramArrayOfString == null)
    {
      localObject = "";
      return localObject;
    }
    if ((paramInt1 < 0) || (paramArrayOfString.length < paramInt2)) {
      return "";
    }
    String str = "";
    paramInt1 = 2;
    for (;;)
    {
      localObject = str;
      if (paramInt1 >= paramArrayOfString.length) {
        break;
      }
      str = str + paramArrayOfString[paramInt1] + " ";
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.sim.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */