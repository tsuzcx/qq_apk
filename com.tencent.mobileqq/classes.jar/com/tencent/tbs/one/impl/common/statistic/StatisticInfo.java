package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.tbs.one.impl.base.Logging;
import com.tencent.tbs.sdk.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StatisticInfo
{
  private static final int APN_2G = 1;
  private static final int APN_3G = 2;
  private static final int APN_4G = 4;
  private static final int APN_UNKNOWN = 0;
  public static final int APN_WIFI = 3;
  private static String sAndroidID = "";
  private static String sCPU;
  private static String sIMEI = "";
  
  static
  {
    sCPU = "";
  }
  
  public static String getAndroidID(Context paramContext)
  {
    if (!TextUtils.isEmpty(sAndroidID)) {
      return sAndroidID;
    }
    try
    {
      sAndroidID = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return sAndroidID;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String getApnInfo(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (hasPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {}
      }
      else
      {
        switch (paramContext.getType())
        {
        case 1: 
          Logging.w("Require \"ACCESS_NETWORK_STATE\" permission for reading apn info!", new Object[0]);
          return "unknown";
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      break label94;
      return "wifi";
      return paramContext.getExtraInfo();
      label94:
      paramContext = "unknown";
    }
    return paramContext;
  }
  
  public static int getApnType(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (hasPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {}
      }
      else
      {
        switch (paramContext.getType())
        {
        case 1: 
          Logging.w("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
          return 0;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      int i = 0;
      return i;
      return 3;
      i = paramContext.getSubtype();
      switch (i)
      {
      default: 
        i = 0;
        break;
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
        i = 1;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
        i = 2;
        break;
      case 13: 
        i = 4;
        break;
        i = 0;
      }
      return i;
    }
  }
  
  public static int getAppVersionCode(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      int i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String getAppVersionName(Context paramContext)
  {
    try
    {
      String str = paramContext.getPackageName();
      paramContext = paramContext.getPackageManager().getPackageInfo(str, 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      Logging.e("Get app version name exception!", new Object[] { paramContext });
    }
    return null;
  }
  
  /* Error */
  public static String getDeviceCpuAbi()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: astore 4
    //   7: getstatic 27	com/tencent/tbs/one/impl/common/statistic/StatisticInfo:sCPU	Ljava/lang/String;
    //   10: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 27	com/tencent/tbs/one/impl/common/statistic/StatisticInfo:sCPU	Ljava/lang/String;
    //   19: astore_2
    //   20: aload_2
    //   21: areturn
    //   22: new 147	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 153	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc 155
    //   31: invokevirtual 159	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 165	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 168	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: new 170	java/io/BufferedReader
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 173	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 176	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: ldc 178
    //   60: invokevirtual 183	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +36 -> 99
    //   66: ldc 185
    //   68: invokestatic 189	com/tencent/tbs/one/impl/common/statistic/StatisticInfo:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_3
    //   73: ifnull +7 -> 80
    //   76: aload_3
    //   77: invokevirtual 192	java/io/BufferedReader:close	()V
    //   80: aload_1
    //   81: astore_2
    //   82: aload_0
    //   83: ifnull -63 -> 20
    //   86: aload_0
    //   87: invokevirtual 193	java/io/InputStreamReader:close	()V
    //   90: aload_1
    //   91: areturn
    //   92: astore_0
    //   93: aload_0
    //   94: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   97: aload_1
    //   98: areturn
    //   99: ldc 196
    //   101: invokestatic 201	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokestatic 189	com/tencent/tbs/one/impl/common/statistic/StatisticInfo:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_1
    //   108: goto -36 -> 72
    //   111: astore_2
    //   112: aload_2
    //   113: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   116: goto -36 -> 80
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_0
    //   122: aload 4
    //   124: astore_2
    //   125: aload_0
    //   126: astore_1
    //   127: ldc 196
    //   129: invokestatic 201	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   132: invokestatic 189	com/tencent/tbs/one/impl/common/statistic/StatisticInfo:notNullString	(Ljava/lang/String;)Ljava/lang/String;
    //   135: astore 5
    //   137: aload 4
    //   139: astore_2
    //   140: aload_0
    //   141: astore_1
    //   142: aload_3
    //   143: invokevirtual 202	java/lang/Throwable:printStackTrace	()V
    //   146: aload 4
    //   148: ifnull +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 192	java/io/BufferedReader:close	()V
    //   156: aload 5
    //   158: astore_2
    //   159: aload_0
    //   160: ifnull -140 -> 20
    //   163: aload_0
    //   164: invokevirtual 193	java/io/InputStreamReader:close	()V
    //   167: aload 5
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   175: aload 5
    //   177: areturn
    //   178: astore_1
    //   179: aload_1
    //   180: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   183: goto -27 -> 156
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_0
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 192	java/io/BufferedReader:close	()V
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 193	java/io/InputStreamReader:close	()V
    //   205: aload_3
    //   206: athrow
    //   207: astore_1
    //   208: aload_1
    //   209: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   212: goto -15 -> 197
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual 194	java/io/IOException:printStackTrace	()V
    //   220: goto -15 -> 205
    //   223: astore_3
    //   224: aload_1
    //   225: astore_0
    //   226: goto -37 -> 189
    //   229: astore_1
    //   230: aload_3
    //   231: astore_2
    //   232: aload_1
    //   233: astore_3
    //   234: goto -45 -> 189
    //   237: astore_3
    //   238: goto -116 -> 122
    //   241: astore_1
    //   242: aload_3
    //   243: astore 4
    //   245: aload_1
    //   246: astore_3
    //   247: goto -125 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	47	0	localInputStreamReader	java.io.InputStreamReader
    //   92	2	0	localIOException1	java.io.IOException
    //   121	43	0	localObject1	Object
    //   170	2	0	localIOException2	java.io.IOException
    //   188	14	0	localObject2	Object
    //   215	2	0	localIOException3	java.io.IOException
    //   225	1	0	localIOException4	java.io.IOException
    //   3	139	1	localObject3	Object
    //   178	2	1	localIOException5	java.io.IOException
    //   207	18	1	localIOException6	java.io.IOException
    //   229	4	1	localObject4	Object
    //   241	5	1	localThrowable1	Throwable
    //   1	81	2	localObject5	Object
    //   111	2	2	localIOException7	java.io.IOException
    //   124	108	2	localObject6	Object
    //   53	24	3	localBufferedReader	java.io.BufferedReader
    //   119	24	3	localThrowable2	Throwable
    //   186	20	3	localObject7	Object
    //   223	8	3	localObject8	Object
    //   233	1	3	localObject9	Object
    //   237	6	3	localThrowable3	Throwable
    //   246	1	3	localThrowable4	Throwable
    //   5	239	4	localObject10	Object
    //   135	41	5	str	String
    // Exception table:
    //   from	to	target	type
    //   86	90	92	java/io/IOException
    //   76	80	111	java/io/IOException
    //   22	41	119	java/lang/Throwable
    //   163	167	170	java/io/IOException
    //   151	156	178	java/io/IOException
    //   22	41	186	finally
    //   193	197	207	java/io/IOException
    //   201	205	215	java/io/IOException
    //   45	54	223	finally
    //   127	137	223	finally
    //   142	146	223	finally
    //   54	72	229	finally
    //   99	108	229	finally
    //   45	54	237	java/lang/Throwable
    //   54	72	241	java/lang/Throwable
    //   99	108	241	java/lang/Throwable
  }
  
  public static String getDeviceIdentifier(Context paramContext)
  {
    String str = getImei(paramContext);
    if (!TextUtils.isEmpty(str)) {
      paramContext = str;
    }
    do
    {
      return paramContext;
      str = getAndroidID(paramContext);
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static String getDeviceModel()
  {
    try
    {
      String str = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      return str;
    }
    catch (Exception localException) {}
    return Build.MODEL;
  }
  
  public static String getImei(Context paramContext)
  {
    if (!TextUtils.isEmpty(sIMEI)) {
      return sIMEI;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (hasPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
        return localTelephonyManager.getDeviceId();
      }
      Logging.w("Require \"READ_PHONE_STATE\" permission for reading imei!", new Object[0]);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
    return "";
  }
  
  public static String getSDKCodes()
  {
    try
    {
      Map localMap = BuildConfig.COMPONENT_SDK_VERSIONS;
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2).append(":").append(localMap.get(str2)).append(";");
      }
      str1 = localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      return "";
    }
    String str1;
    return str1;
  }
  
  private static boolean hasPermission(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  private static String notNullString(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticInfo
 * JD-Core Version:    0.7.0.1
 */