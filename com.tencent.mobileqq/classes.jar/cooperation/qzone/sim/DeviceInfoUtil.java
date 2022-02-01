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
  public static int densityDpi;
  private static String deviceId = "";
  private static String imsi;
  private static String localMacAddress;
  private static boolean mRegisterHandler;
  private static int orientation;
  private static long screenHeight;
  private static long screenWidth;
  
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
    //   0: new 126	java/io/FileReader
    //   3: dup
    //   4: ldc 128
    //   6: invokespecial 131	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore 6
    //   11: aload 6
    //   13: astore 4
    //   15: new 133	java/io/BufferedReader
    //   18: dup
    //   19: aload 6
    //   21: sipush 1024
    //   24: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   27: astore 5
    //   29: aload 6
    //   31: astore 4
    //   33: aload 5
    //   35: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   38: astore 7
    //   40: aload 7
    //   42: ifnull +135 -> 177
    //   45: aload 6
    //   47: astore 4
    //   49: aload 7
    //   51: invokestatic 145	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   54: ldc2_w 146
    //   57: ldiv
    //   58: lstore_0
    //   59: aload 6
    //   61: astore 4
    //   63: aload 5
    //   65: invokevirtual 150	java/io/BufferedReader:close	()V
    //   68: lload_0
    //   69: lstore_2
    //   70: aload 6
    //   72: ifnull +10 -> 82
    //   75: aload 6
    //   77: invokevirtual 151	java/io/FileReader:close	()V
    //   80: lload_0
    //   81: lstore_2
    //   82: lload_2
    //   83: lreturn
    //   84: astore 4
    //   86: aload 4
    //   88: invokevirtual 88	java/lang/Exception:printStackTrace	()V
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
    //   106: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   109: lload_0
    //   110: lstore_2
    //   111: aload 6
    //   113: ifnull -31 -> 82
    //   116: aload 6
    //   118: invokevirtual 151	java/io/FileReader:close	()V
    //   121: lload_0
    //   122: lreturn
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   130: lload_0
    //   131: lreturn
    //   132: astore 5
    //   134: aconst_null
    //   135: astore 4
    //   137: aload 4
    //   139: ifnull +8 -> 147
    //   142: aload 4
    //   144: invokevirtual 151	java/io/FileReader:close	()V
    //   147: aload 5
    //   149: athrow
    //   150: astore 4
    //   152: aload 4
    //   154: invokevirtual 88	java/lang/Exception:printStackTrace	()V
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
    //   1: astore_2
    //   2: new 126	java/io/FileReader
    //   5: dup
    //   6: ldc 168
    //   8: invokespecial 131	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   11: astore_0
    //   12: new 133	java/io/BufferedReader
    //   15: dup
    //   16: aload_0
    //   17: sipush 8192
    //   20: invokespecial 136	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   23: astore_2
    //   24: ldc 170
    //   26: astore_1
    //   27: ldc 170
    //   29: astore 7
    //   31: ldc 170
    //   33: astore 6
    //   35: ldc 170
    //   37: astore 4
    //   39: ldc 35
    //   41: astore_3
    //   42: aload_3
    //   43: ifnull +14 -> 57
    //   46: aload_2
    //   47: invokevirtual 139	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 10
    //   52: aload 10
    //   54: ifnonnull +84 -> 138
    //   57: new 106	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   64: aload 4
    //   66: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: ldc 172
    //   71: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 6
    //   76: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc 172
    //   81: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 7
    //   86: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: ldc 172
    //   91: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: astore_1
    //   102: aload_2
    //   103: invokevirtual 150	java/io/BufferedReader:close	()V
    //   106: aload_0
    //   107: invokevirtual 151	java/io/FileReader:close	()V
    //   110: iconst_0
    //   111: ifeq +11 -> 122
    //   114: new 174	java/lang/NullPointerException
    //   117: dup
    //   118: invokespecial 175	java/lang/NullPointerException:<init>	()V
    //   121: athrow
    //   122: aload_1
    //   123: astore_0
    //   124: iconst_0
    //   125: ifeq +11 -> 136
    //   128: new 174	java/lang/NullPointerException
    //   131: dup
    //   132: invokespecial 175	java/lang/NullPointerException:<init>	()V
    //   135: athrow
    //   136: aload_0
    //   137: areturn
    //   138: aload 10
    //   140: ldc 177
    //   142: invokevirtual 183	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   145: astore 11
    //   147: aload 10
    //   149: astore_3
    //   150: aload 11
    //   152: ifnull -110 -> 42
    //   155: aload 10
    //   157: astore_3
    //   158: aload 11
    //   160: arraylength
    //   161: iconst_3
    //   162: if_icmplt -120 -> 42
    //   165: aload 11
    //   167: iconst_0
    //   168: aaload
    //   169: invokevirtual 186	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   172: astore_3
    //   173: aload 4
    //   175: astore 5
    //   177: aload_3
    //   178: ldc 188
    //   180: invokevirtual 191	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   183: ifeq +39 -> 222
    //   186: new 106	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   193: aload 4
    //   195: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 11
    //   200: iconst_2
    //   201: aload 11
    //   203: arraylength
    //   204: invokestatic 195	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   207: ldc 197
    //   209: ldc 199
    //   211: invokevirtual 202	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore 5
    //   222: aload 6
    //   224: astore 8
    //   226: aload_3
    //   227: ldc 204
    //   229: invokevirtual 191	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   232: ifeq +21 -> 253
    //   235: aload 11
    //   237: iconst_2
    //   238: aload 11
    //   240: arraylength
    //   241: invokestatic 195	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   244: ldc 197
    //   246: ldc 199
    //   248: invokevirtual 202	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: astore 8
    //   253: aload 7
    //   255: astore 9
    //   257: aload_3
    //   258: ldc 206
    //   260: invokevirtual 191	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   263: ifeq +21 -> 284
    //   266: aload 11
    //   268: iconst_2
    //   269: aload 11
    //   271: arraylength
    //   272: invokestatic 195	cooperation/qzone/sim/DeviceInfoUtil:subStrings2String	([Ljava/lang/String;II)Ljava/lang/String;
    //   275: ldc 197
    //   277: ldc 199
    //   279: invokevirtual 202	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   282: astore 9
    //   284: aload 9
    //   286: astore 7
    //   288: aload 8
    //   290: astore 6
    //   292: aload 5
    //   294: astore 4
    //   296: aload 10
    //   298: astore_3
    //   299: aload 11
    //   301: iconst_1
    //   302: aaload
    //   303: invokevirtual 186	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   306: ldc 208
    //   308: invokevirtual 191	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   311: ifeq -269 -> 42
    //   314: aload 11
    //   316: aload 11
    //   318: arraylength
    //   319: iconst_1
    //   320: isub
    //   321: aaload
    //   322: astore_1
    //   323: aload 9
    //   325: astore 7
    //   327: aload 8
    //   329: astore 6
    //   331: aload 5
    //   333: astore 4
    //   335: aload 10
    //   337: astore_3
    //   338: goto -296 -> 42
    //   341: astore_3
    //   342: aconst_null
    //   343: astore 4
    //   345: ldc 35
    //   347: astore_1
    //   348: aload_2
    //   349: astore_0
    //   350: aload 4
    //   352: astore_2
    //   353: aload_3
    //   354: invokevirtual 88	java/lang/Exception:printStackTrace	()V
    //   357: aload_0
    //   358: ifnull +7 -> 365
    //   361: aload_0
    //   362: invokevirtual 151	java/io/FileReader:close	()V
    //   365: aload_1
    //   366: astore_0
    //   367: aload_2
    //   368: ifnull -232 -> 136
    //   371: aload_2
    //   372: invokevirtual 150	java/io/BufferedReader:close	()V
    //   375: aload_1
    //   376: areturn
    //   377: astore_0
    //   378: aload_1
    //   379: areturn
    //   380: astore_1
    //   381: aconst_null
    //   382: astore_2
    //   383: aconst_null
    //   384: astore_0
    //   385: aload_0
    //   386: ifnull +7 -> 393
    //   389: aload_0
    //   390: invokevirtual 151	java/io/FileReader:close	()V
    //   393: aload_2
    //   394: ifnull +7 -> 401
    //   397: aload_2
    //   398: invokevirtual 150	java/io/BufferedReader:close	()V
    //   401: aload_1
    //   402: athrow
    //   403: astore_0
    //   404: goto -282 -> 122
    //   407: astore_0
    //   408: aload_1
    //   409: areturn
    //   410: astore_0
    //   411: goto -46 -> 365
    //   414: astore_0
    //   415: goto -22 -> 393
    //   418: astore_0
    //   419: goto -18 -> 401
    //   422: astore_1
    //   423: aconst_null
    //   424: astore_2
    //   425: goto -40 -> 385
    //   428: astore_1
    //   429: goto -44 -> 385
    //   432: astore_1
    //   433: goto -48 -> 385
    //   436: astore_3
    //   437: aconst_null
    //   438: astore_2
    //   439: ldc 35
    //   441: astore_1
    //   442: goto -89 -> 353
    //   445: astore_3
    //   446: ldc 35
    //   448: astore_1
    //   449: goto -96 -> 353
    //   452: astore_3
    //   453: goto -100 -> 353
    //   456: astore_3
    //   457: aconst_null
    //   458: astore_2
    //   459: goto -106 -> 353
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	356	0	localObject1	Object
    //   377	1	0	localException1	Exception
    //   384	6	0	localObject2	Object
    //   403	1	0	localException2	Exception
    //   407	1	0	localException3	Exception
    //   410	1	0	localException4	Exception
    //   414	1	0	localException5	Exception
    //   418	1	0	localException6	Exception
    //   26	353	1	str1	String
    //   380	29	1	str2	String
    //   422	1	1	localObject3	Object
    //   428	1	1	localObject4	Object
    //   432	1	1	localObject5	Object
    //   441	8	1	str3	String
    //   1	458	2	localObject6	Object
    //   41	297	3	localObject7	Object
    //   341	13	3	localException7	Exception
    //   436	1	3	localException8	Exception
    //   445	1	3	localException9	Exception
    //   452	1	3	localException10	Exception
    //   456	1	3	localException11	Exception
    //   37	314	4	localObject8	Object
    //   175	157	5	localObject9	Object
    //   33	297	6	localObject10	Object
    //   29	297	7	localObject11	Object
    //   224	104	8	localObject12	Object
    //   255	69	9	localObject13	Object
    //   50	286	10	str4	String
    //   145	172	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   2	12	341	java/lang/Exception
    //   371	375	377	java/lang/Exception
    //   2	12	380	finally
    //   114	122	403	java/lang/Exception
    //   128	136	407	java/lang/Exception
    //   361	365	410	java/lang/Exception
    //   389	393	414	java/lang/Exception
    //   397	401	418	java/lang/Exception
    //   12	24	422	finally
    //   106	110	422	finally
    //   46	52	428	finally
    //   57	102	428	finally
    //   102	106	428	finally
    //   138	147	428	finally
    //   158	173	428	finally
    //   177	222	428	finally
    //   226	253	428	finally
    //   257	284	428	finally
    //   299	323	428	finally
    //   353	357	432	finally
    //   12	24	436	java/lang/Exception
    //   46	52	445	java/lang/Exception
    //   57	102	445	java/lang/Exception
    //   138	147	445	java/lang/Exception
    //   158	173	445	java/lang/Exception
    //   177	222	445	java/lang/Exception
    //   226	253	445	java/lang/Exception
    //   257	284	445	java/lang/Exception
    //   299	323	445	java/lang/Exception
    //   102	106	452	java/lang/Exception
    //   106	110	456	java/lang/Exception
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
    //   0: getstatic 259	cooperation/qzone/sim/DeviceInfoUtil:mRegisterHandler	Z
    //   3: ifne +17 -> 20
    //   6: new 261	cooperation/qzone/sim/DeviceInfoUtil$1
    //   9: dup
    //   10: invokespecial 262	cooperation/qzone/sim/DeviceInfoUtil$1:<init>	()V
    //   13: invokestatic 268	cooperation/qzone/util/NetworkState:addListener	(Lcooperation/qzone/util/NetworkState$NetworkStateListener;)V
    //   16: iconst_1
    //   17: putstatic 259	cooperation/qzone/sim/DeviceInfoUtil:mRegisterHandler	Z
    //   20: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   23: ifnull +7 -> 30
    //   26: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   29: areturn
    //   30: aload_0
    //   31: ldc_w 270
    //   34: invokevirtual 274	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   37: checkcast 276	android/telephony/TelephonyManager
    //   40: astore_2
    //   41: aload_2
    //   42: invokevirtual 279	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   45: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   48: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   51: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifeq +10 -> 64
    //   57: aload_2
    //   58: invokevirtual 282	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   61: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   64: iconst_1
    //   65: anewarray 284	java/lang/Class
    //   68: astore 4
    //   70: aload 4
    //   72: iconst_0
    //   73: getstatic 290	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   76: aastore
    //   77: new 286	java/lang/Integer
    //   80: dup
    //   81: iconst_1
    //   82: invokespecial 293	java/lang/Integer:<init>	(I)V
    //   85: astore_3
    //   86: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   89: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +43 -> 137
    //   97: aload_2
    //   98: invokevirtual 297	java/lang/Object:getClass	()Ljava/lang/Class;
    //   101: ldc_w 299
    //   104: aload 4
    //   106: invokevirtual 303	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   109: astore 5
    //   111: aload 5
    //   113: iconst_1
    //   114: invokevirtual 309	java/lang/reflect/Method:setAccessible	(Z)V
    //   117: aload 5
    //   119: aload_2
    //   120: iconst_1
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload_3
    //   127: aastore
    //   128: invokevirtual 313	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 179	java/lang/String
    //   134: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   137: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   140: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   143: istore_1
    //   144: iload_1
    //   145: ifeq +72 -> 217
    //   148: ldc_w 315
    //   151: invokestatic 319	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   154: astore 5
    //   156: aload_0
    //   157: aload 5
    //   159: ldc_w 321
    //   162: iconst_2
    //   163: anewarray 284	java/lang/Class
    //   166: dup
    //   167: iconst_0
    //   168: ldc 179
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: getstatic 290	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   176: aastore
    //   177: invokevirtual 324	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   180: aload 5
    //   182: iconst_2
    //   183: anewarray 4	java/lang/Object
    //   186: dup
    //   187: iconst_0
    //   188: ldc_w 270
    //   191: aastore
    //   192: dup
    //   193: iconst_1
    //   194: iconst_1
    //   195: invokestatic 328	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokevirtual 313	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   202: checkcast 179	java/lang/String
    //   205: invokevirtual 274	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   208: checkcast 276	android/telephony/TelephonyManager
    //   211: invokevirtual 279	android/telephony/TelephonyManager:getSubscriberId	()Ljava/lang/String;
    //   214: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   217: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   220: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: istore_1
    //   224: iload_1
    //   225: ifeq +40 -> 265
    //   228: aload_2
    //   229: invokevirtual 297	java/lang/Object:getClass	()Ljava/lang/Class;
    //   232: ldc_w 330
    //   235: aload 4
    //   237: invokevirtual 303	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   240: astore_0
    //   241: aload_0
    //   242: iconst_1
    //   243: invokevirtual 309	java/lang/reflect/Method:setAccessible	(Z)V
    //   246: aload_0
    //   247: aload_2
    //   248: iconst_1
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: aload_3
    //   255: aastore
    //   256: invokevirtual 313	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   259: checkcast 179	java/lang/String
    //   262: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   265: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   268: invokestatic 57	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifeq +8 -> 279
    //   274: ldc 35
    //   276: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   279: getstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   282: areturn
    //   283: astore 5
    //   285: aload 5
    //   287: invokevirtual 331	java/lang/Throwable:printStackTrace	()V
    //   290: ldc 11
    //   292: new 106	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 333
    //   302: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 5
    //   307: invokevirtual 336	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   310: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 342	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: ldc 35
    //   321: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   324: goto -187 -> 137
    //   327: astore_0
    //   328: ldc 35
    //   330: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   333: ldc 35
    //   335: areturn
    //   336: astore_0
    //   337: aload_0
    //   338: invokevirtual 331	java/lang/Throwable:printStackTrace	()V
    //   341: ldc 11
    //   343: new 106	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 344
    //   353: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: invokevirtual 336	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   360: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 342	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   369: ldc 35
    //   371: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
    //   374: goto -157 -> 217
    //   377: astore_0
    //   378: ldc 11
    //   380: new 106	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 346
    //   390: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: invokevirtual 336	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   397: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 342	cooperation/qzone/util/QZLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: invokevirtual 331	java/lang/Throwable:printStackTrace	()V
    //   410: ldc 35
    //   412: putstatic 47	cooperation/qzone/sim/DeviceInfoUtil:imsi	Ljava/lang/String;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.sim.DeviceInfoUtil
 * JD-Core Version:    0.7.0.1
 */