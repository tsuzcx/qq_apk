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
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.sdk.BuildConfig;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class c
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static int a(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (a(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
      {
        paramContext = localConnectivityManager.getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isConnectedOrConnecting())) {}
      }
      else
      {
        switch (paramContext.getType())
        {
        case 1: 
          f.b("Require \"ACCESS_NETWORK_STATE\" permission for reading apn type!", new Object[0]);
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
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: aconst_null
    //   5: astore 4
    //   7: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   10: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +9 -> 22
    //   16: getstatic 16	com/tencent/tbs/one/impl/common/statistic/c:b	Ljava/lang/String;
    //   19: astore_1
    //   20: aload_1
    //   21: areturn
    //   22: new 77	java/io/InputStreamReader
    //   25: dup
    //   26: invokestatic 83	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   29: ldc 85
    //   31: invokevirtual 89	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   34: invokevirtual 95	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   37: invokespecial 99	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   40: astore_0
    //   41: aload_1
    //   42: astore_2
    //   43: aload_0
    //   44: astore_1
    //   45: new 101	java/io/BufferedReader
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: ldc 109
    //   60: invokevirtual 114	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   63: ifeq +26 -> 89
    //   66: ldc 116
    //   68: invokestatic 119	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_3
    //   73: invokevirtual 122	java/io/BufferedReader:close	()V
    //   76: aload_0
    //   77: invokevirtual 123	java/io/InputStreamReader:close	()V
    //   80: aload_1
    //   81: areturn
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   87: aload_1
    //   88: areturn
    //   89: ldc 126
    //   91: invokestatic 131	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokestatic 119	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore_1
    //   98: goto -26 -> 72
    //   101: astore_2
    //   102: aload_2
    //   103: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   106: goto -30 -> 76
    //   109: astore_3
    //   110: aconst_null
    //   111: astore_0
    //   112: aload 4
    //   114: astore_2
    //   115: aload_0
    //   116: astore_1
    //   117: ldc 126
    //   119: invokestatic 131	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   122: invokestatic 119	com/tencent/tbs/one/impl/common/statistic/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   125: astore 5
    //   127: aload 4
    //   129: astore_2
    //   130: aload_0
    //   131: astore_1
    //   132: aload_3
    //   133: invokevirtual 132	java/lang/Throwable:printStackTrace	()V
    //   136: aload 4
    //   138: ifnull +8 -> 146
    //   141: aload 4
    //   143: invokevirtual 122	java/io/BufferedReader:close	()V
    //   146: aload 5
    //   148: astore_1
    //   149: aload_0
    //   150: ifnull -130 -> 20
    //   153: aload_0
    //   154: invokevirtual 123	java/io/InputStreamReader:close	()V
    //   157: aload 5
    //   159: areturn
    //   160: astore_0
    //   161: aload_0
    //   162: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   165: aload 5
    //   167: areturn
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   173: goto -27 -> 146
    //   176: astore_3
    //   177: aconst_null
    //   178: astore_0
    //   179: aload_2
    //   180: ifnull +7 -> 187
    //   183: aload_2
    //   184: invokevirtual 122	java/io/BufferedReader:close	()V
    //   187: aload_0
    //   188: ifnull +7 -> 195
    //   191: aload_0
    //   192: invokevirtual 123	java/io/InputStreamReader:close	()V
    //   195: aload_3
    //   196: athrow
    //   197: astore_1
    //   198: aload_1
    //   199: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   202: goto -15 -> 187
    //   205: astore_0
    //   206: aload_0
    //   207: invokevirtual 124	java/io/IOException:printStackTrace	()V
    //   210: goto -15 -> 195
    //   213: astore_3
    //   214: aload_1
    //   215: astore_0
    //   216: goto -37 -> 179
    //   219: astore_1
    //   220: aload_3
    //   221: astore_2
    //   222: aload_1
    //   223: astore_3
    //   224: goto -45 -> 179
    //   227: astore_3
    //   228: goto -116 -> 112
    //   231: astore_1
    //   232: aload_3
    //   233: astore 4
    //   235: aload_1
    //   236: astore_3
    //   237: goto -125 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	37	0	localInputStreamReader	java.io.InputStreamReader
    //   82	2	0	localIOException1	java.io.IOException
    //   111	43	0	localObject1	Object
    //   160	2	0	localIOException2	java.io.IOException
    //   178	14	0	localObject2	Object
    //   205	2	0	localIOException3	java.io.IOException
    //   215	1	0	localIOException4	java.io.IOException
    //   3	146	1	localObject3	Object
    //   168	2	1	localIOException5	java.io.IOException
    //   197	18	1	localIOException6	java.io.IOException
    //   219	4	1	localObject4	Object
    //   231	5	1	localThrowable1	Throwable
    //   1	42	2	localObject5	Object
    //   101	2	2	localIOException7	java.io.IOException
    //   114	108	2	localObject6	Object
    //   53	20	3	localBufferedReader	java.io.BufferedReader
    //   109	24	3	localThrowable2	Throwable
    //   176	20	3	localObject7	Object
    //   213	8	3	localObject8	Object
    //   223	1	3	localObject9	Object
    //   227	6	3	localThrowable3	Throwable
    //   236	1	3	localThrowable4	Throwable
    //   5	229	4	localObject10	Object
    //   125	41	5	str	String
    // Exception table:
    //   from	to	target	type
    //   76	80	82	java/io/IOException
    //   72	76	101	java/io/IOException
    //   22	41	109	java/lang/Throwable
    //   153	157	160	java/io/IOException
    //   141	146	168	java/io/IOException
    //   22	41	176	finally
    //   183	187	197	java/io/IOException
    //   191	195	205	java/io/IOException
    //   45	54	213	finally
    //   117	127	213	finally
    //   132	136	213	finally
    //   54	72	219	finally
    //   89	98	219	finally
    //   45	54	227	java/lang/Throwable
    //   54	72	231	java/lang/Throwable
    //   89	98	231	java/lang/Throwable
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().checkPermission(paramString, paramContext.getPackageName()) == 0;
  }
  
  public static String b()
  {
    try
    {
      String str = new String(Build.MODEL.getBytes("UTF-8"), "ISO8859-1");
      return str;
    }
    catch (Exception localException) {}
    return Build.MODEL;
  }
  
  public static String b(Context paramContext)
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
      f.c("Get app version name exception!", new Object[] { paramContext });
    }
    return null;
  }
  
  public static int c(Context paramContext)
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
  
  public static String c()
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
  
  public static String d(Context paramContext)
  {
    String str = e(paramContext);
    if (!TextUtils.isEmpty(str)) {
      paramContext = str;
    }
    do
    {
      return paramContext;
      str = f(paramContext);
      paramContext = str;
    } while (!TextUtils.isEmpty(str));
    return "unknown";
  }
  
  public static String e(Context paramContext)
  {
    if (!TextUtils.isEmpty(a)) {
      return a;
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (a(paramContext, "android.permission.READ_PHONE_STATE")) {
        return localTelephonyManager.getDeviceId();
      }
      f.b("Require \"READ_PHONE_STATE\" permission for reading imei!", new Object[0]);
      return "";
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String f(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    try
    {
      c = Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
      return c;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.c
 * JD-Core Version:    0.7.0.1
 */